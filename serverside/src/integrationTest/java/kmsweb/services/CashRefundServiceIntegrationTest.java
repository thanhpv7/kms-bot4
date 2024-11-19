/*
 * @bot-written
 *
 * WARNING AND NOTICE
 * Any access, download, storage, and/or use of this source code is subject to the terms and conditions of the
 * Full Software Licence as accepted by you before being granted access to this source code and other materials,
 * the terms of which can be accessed on the Codebots website at https://codebots.com/full-software-licence. Any
 * commercial use in contravention of the terms of the Full Software Licence may be pursued by Codebots through
 * licence termination and further legal action, and be required to indemnify Codebots for any loss or damage,
 * including interest and costs. You are deemed to have accepted the terms of the Full Software Licence on any
 * access, download, storage, and/or use of this source code.
 *
 * BOT WARNING
 * This file is bot-written.
 * Any changes out side of "protected regions" will be lost next time the bot makes any changes.
 */

package kmsweb.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;
import kmsweb.SpringTestConfiguration;
import kmsweb.configs.security.helpers.AnonymousHelper;
import kmsweb.entities.CashRefundEntity;
import kmsweb.repositories.CashRefundRepository;
import kmsweb.utils.CashRefundFactory;
import kmsweb.utils.DatabasePopulators.CashRefundDatabasePopulator;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.utils.PatientGeneralInfoFactory;
import kmsweb.utils.DatabasePopulators.PatientGeneralInfoDatabasePopulator;
import kmsweb.repositories.auditing.AuditingRepository;

import javax.validation.Validator;

import java.util.*;
import java.util.stream.Collectors;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestConfiguration.class)
@ActiveProfiles("test")
// % protected region % [Add any additional class annotations here] off begin
// % protected region % [Add any additional class annotations here] end
public class CashRefundServiceIntegrationTest {

	@Autowired
	private CashRefundRepository cashRefundRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private CashRefundService cashRefundService;

	private final CashRefundFactory cashRefundFactory = new CashRefundFactory();

	@Autowired
	private CashRefundDatabasePopulator cashRefundDatabasePopulator;

	@Autowired
	private PatientGeneralInfoRepository patientGeneralInfoRepository;

	@Autowired
	private PatientGeneralInfoDatabasePopulator patientGeneralInfoDatabasePopulator;

	private final PatientGeneralInfoFactory patientGeneralInfoFactory = new PatientGeneralInfoFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		cashRefundService = new CashRefundService(
			patientGeneralInfoRepository,
			validator,
			auditRepository,
			cashRefundRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewCashRefundEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		CashRefundEntity cashRefundEntity = cashRefundFactory.getObject(false, false);

		CashRefundEntity updatedEntity = cashRefundService.updateOldData(cashRefundEntity);
		Assertions.assertEquals(cashRefundEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewCashRefundEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		CashRefundEntity cashRefundEntity = cashRefundFactory.getObject(false, false);

		cashRefundEntity.setIsvoid(null);
		Assertions.assertNull(cashRefundEntity.getIsvoid());


		CashRefundEntity updatedEntity = cashRefundService.updateOldData(cashRefundEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getIsvoid());
		Assertions.assertFalse(updatedEntity.getIsvoid());

	}

	@Test
	public void updateOldDataWithExistingCashRefundEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			CashRefundEntity cashRefundEntity;
			CashRefundEntity entityWithUpdatedValues;

			try {
				cashRefundEntity = cashRefundFactory.getObject(false, false);
				cashRefundDatabasePopulator.populateRelatedEntitiesInDatabase(cashRefundEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = cashRefundFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashRefundEntity = cashRefundService.create(cashRefundEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(cashRefundEntity.getId());

			CashRefundEntity updatedEntity = cashRefundService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithCashRefundEntityWithNonExistentId_ShouldThrowException() throws Exception {
		CashRefundEntity cashRefundEntity = cashRefundFactory.getObject(false, false);
		cashRefundEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			cashRefundService.updateOldData(cashRefundEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingCashRefundEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			CashRefundEntity cashRefundEntity;
			CashRefundEntity updatedCashRefundEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				cashRefundEntity = cashRefundFactory.getObject(true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			/*
				As this test is checking that removing a reference entity works, we need to add the
				reference entities to the database
			 */
			patientGeneralInfoEntity = cashRefundEntity.getPatientGeneralInfo();
			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientGeneralInfoEntity = patientGeneralInfoRepository.save(patientGeneralInfoEntity);
			cashRefundEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());


			cashRefundEntity = cashRefundService.create(cashRefundEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(cashRefundEntity.getPatientGeneralInfo());
			cashRefundEntity.setPatientGeneralInfoId(null);
			cashRefundEntity.unsetPatientGeneralInfo();


			updatedCashRefundEntity = cashRefundService.updateOldData(cashRefundEntity);

			Assertions.assertNull(updatedCashRefundEntity.getPatientGeneralInfo());

		});
	}

	@Test
	public void updateOldDataWithCashRefundEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			CashRefundEntity cashRefundEntity;
			CashRefundEntity updatedCashRefundEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				cashRefundEntity = cashRefundFactory.getObject(true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			/*
				Expected state of the entity prior to updateOldData when trying to add a reference
				is that the reference id is set, but the reference entity is not set.  Therefore,
				we need to remove the reference entity and set the reference id, as this will set up
				the state we expect to see for this test.

				We also need to populate the required relations for all related entities, as creating any entities
				with required references will cause an error (and a subsequent test failure) if we do not
			 */
			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(cashRefundEntity.getPatientGeneralInfo(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient General Info relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientGeneralInfoEntity = patientGeneralInfoRepository.findById(patientGeneralInfoRepository.save(cashRefundEntity.getPatientGeneralInfo()).getId()).get();
			cashRefundEntity.unsetPatientGeneralInfo();
			cashRefundEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedCashRefundEntity = cashRefundService.updateOldData(cashRefundEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			patientGeneralInfoEntity.unsetCashRefunds(false);
			updatedCashRefundEntity.getPatientGeneralInfo().unsetCashRefunds(false);
			Assertions.assertEquals(patientGeneralInfoEntity, updatedCashRefundEntity.getPatientGeneralInfo());

		});
	}

	@Test
	public void whenCreateCashRefundEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			CashRefundEntity cashRefundEntity;
			Optional<CashRefundEntity> fetchedCashRefundEntity;

			try {
				cashRefundEntity = cashRefundFactory.getObject(false, false);
				cashRefundDatabasePopulator.populateRelatedEntitiesInDatabase(cashRefundEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashRefundEntity = cashRefundService.create(cashRefundEntity);

			Optional<PatientGeneralInfoEntity> relatedPatientGeneralInfoOptional = patientGeneralInfoRepository.findById(cashRefundEntity.getPatientGeneralInfoId());
			assert relatedPatientGeneralInfoOptional.isPresent();
			PatientGeneralInfoEntity relatedPatientGeneralInfo = relatedPatientGeneralInfoOptional.get();
			// Required related entity has to be created without a reference to this parent entity as it doesn't exist yet.
			// Therefore we need to update the related entity to reference our parent entity for the later checks
			relatedPatientGeneralInfo.setCashRefunds(Collections.singletonList(cashRefundEntity));
			patientGeneralInfoRepository.save(relatedPatientGeneralInfo);

			fetchedCashRefundEntity = cashRefundService.findById(cashRefundEntity.getId());

			Assertions.assertTrue(fetchedCashRefundEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedCashRefundEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(cashRefundEntity, fetchedCashRefundEntity.get());
		});
	}

	@Test
	public void whenUpdateCashRefundEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			CashRefundEntity cashRefundEntity;
			CashRefundEntity updatedCashRefundEntity;
			Optional<CashRefundEntity> fetchedCashRefundEntity;

			try {
				cashRefundEntity = cashRefundFactory.getObject(false, false);
				cashRefundDatabasePopulator.populateRelatedEntitiesInDatabase(cashRefundEntity, true, true, false);
				updatedCashRefundEntity = cashRefundFactory.getObject(false, false);
				cashRefundDatabasePopulator.populateRelatedEntitiesInDatabase(updatedCashRefundEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashRefundEntity = cashRefundService.create(cashRefundEntity);

			updatedCashRefundEntity.setId(cashRefundEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedCashRefundEntity.setCreated(cashRefundEntity.getCreated());

			updatedCashRefundEntity = cashRefundService.update(updatedCashRefundEntity);

			fetchedCashRefundEntity = cashRefundService.findById(cashRefundEntity.getId());

			Assertions.assertTrue(fetchedCashRefundEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateCashRefundEntity_ThenEntityIsCreated
			fetchedCashRefundEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedCashRefundEntity, fetchedCashRefundEntity.get());
		});
	}

	@Test
	public void whenDeleteCashRefundEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			CashRefundEntity cashRefundEntity;
			Optional<CashRefundEntity> fetchedCashRefundEntity;

			try {
				cashRefundEntity = cashRefundFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				cashRefundDatabasePopulator.populateRelatedEntitiesInDatabase(cashRefundEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			cashRefundEntity = cashRefundService.create(cashRefundEntity);

			cashRefundService.deleteById(cashRefundEntity.getId());
			fetchedCashRefundEntity = cashRefundService.findById(cashRefundEntity.getId());

			Assertions.assertTrue(fetchedCashRefundEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
