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
import kmsweb.entities.BpjsAccidentMasterEntity;
import kmsweb.repositories.BpjsAccidentMasterRepository;
import kmsweb.utils.BpjsAccidentMasterFactory;
import kmsweb.utils.DatabasePopulators.BpjsAccidentMasterDatabasePopulator;
import kmsweb.entities.PatientPaymentBPJSEntity;
import kmsweb.repositories.PatientPaymentBPJSRepository;
import kmsweb.utils.PatientPaymentBPJSFactory;
import kmsweb.utils.DatabasePopulators.PatientPaymentBPJSDatabasePopulator;
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
public class BpjsAccidentMasterServiceIntegrationTest {

	@Autowired
	private BpjsAccidentMasterRepository bpjsAccidentMasterRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsAccidentMasterService bpjsAccidentMasterService;

	private final BpjsAccidentMasterFactory bpjsAccidentMasterFactory = new BpjsAccidentMasterFactory();

	@Autowired
	private BpjsAccidentMasterDatabasePopulator bpjsAccidentMasterDatabasePopulator;

	@Autowired
	private PatientPaymentBPJSRepository patientPaymentBPJSRepository;

	@Autowired
	private PatientPaymentBPJSDatabasePopulator patientPaymentBPJSDatabasePopulator;

	private final PatientPaymentBPJSFactory patientPaymentBPJSFactory = new PatientPaymentBPJSFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsAccidentMasterService = new BpjsAccidentMasterService(
			patientPaymentBPJSRepository,
			validator,
			auditRepository,
			bpjsAccidentMasterRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsAccidentMasterEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsAccidentMasterEntity bpjsAccidentMasterEntity = bpjsAccidentMasterFactory.getObject(false, false);

		BpjsAccidentMasterEntity updatedEntity = bpjsAccidentMasterService.updateOldData(bpjsAccidentMasterEntity);
		Assertions.assertEquals(bpjsAccidentMasterEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsAccidentMasterEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsAccidentMasterEntity bpjsAccidentMasterEntity;
			BpjsAccidentMasterEntity entityWithUpdatedValues;

			try {
				bpjsAccidentMasterEntity = bpjsAccidentMasterFactory.getObject(false, false);
				bpjsAccidentMasterDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsAccidentMasterEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsAccidentMasterFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsAccidentMasterEntity = bpjsAccidentMasterService.create(bpjsAccidentMasterEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsAccidentMasterEntity.getId());

			BpjsAccidentMasterEntity updatedEntity = bpjsAccidentMasterService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsAccidentMasterEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsAccidentMasterEntity bpjsAccidentMasterEntity = bpjsAccidentMasterFactory.getObject(false, false);
		bpjsAccidentMasterEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsAccidentMasterService.updateOldData(bpjsAccidentMasterEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsAccidentMasterEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsAccidentMasterEntity bpjsAccidentMasterEntity;
			BpjsAccidentMasterEntity updatedBpjsAccidentMasterEntity;

			PatientPaymentBPJSEntity patientPaymentBPJSEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsAccidentMasterEntity = bpjsAccidentMasterFactory.getObject(true, false);
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
			patientPaymentBPJSEntity = bpjsAccidentMasterEntity.getPatientPaymentBPJS();
			try {
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentBPJSEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientPaymentBPJSEntity = patientPaymentBPJSRepository.save(patientPaymentBPJSEntity);
			bpjsAccidentMasterEntity.setPatientPaymentBPJSId(patientPaymentBPJSEntity.getId());


			bpjsAccidentMasterEntity = bpjsAccidentMasterService.create(bpjsAccidentMasterEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsAccidentMasterEntity.getPatientPaymentBPJS());
			bpjsAccidentMasterEntity.setPatientPaymentBPJSId(null);
			bpjsAccidentMasterEntity.unsetPatientPaymentBPJS();


			updatedBpjsAccidentMasterEntity = bpjsAccidentMasterService.updateOldData(bpjsAccidentMasterEntity);

			Assertions.assertNull(updatedBpjsAccidentMasterEntity.getPatientPaymentBPJS());

		});
	}

	@Test
	public void updateOldDataWithBpjsAccidentMasterEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsAccidentMasterEntity bpjsAccidentMasterEntity;
			BpjsAccidentMasterEntity updatedBpjsAccidentMasterEntity;

			PatientPaymentBPJSEntity patientPaymentBPJSEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsAccidentMasterEntity = bpjsAccidentMasterFactory.getObject(true, false);
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
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsAccidentMasterEntity.getPatientPaymentBPJS(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Payment BPJS relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientPaymentBPJSEntity = patientPaymentBPJSRepository.findById(patientPaymentBPJSRepository.save(bpjsAccidentMasterEntity.getPatientPaymentBPJS()).getId()).get();
			bpjsAccidentMasterEntity.unsetPatientPaymentBPJS();
			bpjsAccidentMasterEntity.setPatientPaymentBPJSId(patientPaymentBPJSEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsAccidentMasterEntity = bpjsAccidentMasterService.updateOldData(bpjsAccidentMasterEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			patientPaymentBPJSEntity.unsetBpjsAccidentMasters(false);
			updatedBpjsAccidentMasterEntity.getPatientPaymentBPJS().unsetBpjsAccidentMasters(false);
			Assertions.assertEquals(patientPaymentBPJSEntity, updatedBpjsAccidentMasterEntity.getPatientPaymentBPJS());

		});
	}

	@Test
	public void whenCreateBpjsAccidentMasterEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsAccidentMasterEntity bpjsAccidentMasterEntity;
			Optional<BpjsAccidentMasterEntity> fetchedBpjsAccidentMasterEntity;

			try {
				bpjsAccidentMasterEntity = bpjsAccidentMasterFactory.getObject(false, false);
				bpjsAccidentMasterDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsAccidentMasterEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsAccidentMasterEntity = bpjsAccidentMasterService.create(bpjsAccidentMasterEntity);

			fetchedBpjsAccidentMasterEntity = bpjsAccidentMasterService.findById(bpjsAccidentMasterEntity.getId());

			Assertions.assertTrue(fetchedBpjsAccidentMasterEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsAccidentMasterEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsAccidentMasterEntity, fetchedBpjsAccidentMasterEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsAccidentMasterEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsAccidentMasterEntity bpjsAccidentMasterEntity;
			BpjsAccidentMasterEntity updatedBpjsAccidentMasterEntity;
			Optional<BpjsAccidentMasterEntity> fetchedBpjsAccidentMasterEntity;

			try {
				bpjsAccidentMasterEntity = bpjsAccidentMasterFactory.getObject(false, false);
				bpjsAccidentMasterDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsAccidentMasterEntity, true, true, false);
				updatedBpjsAccidentMasterEntity = bpjsAccidentMasterFactory.getObject(false, false);
				bpjsAccidentMasterDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsAccidentMasterEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsAccidentMasterEntity = bpjsAccidentMasterService.create(bpjsAccidentMasterEntity);

			updatedBpjsAccidentMasterEntity.setId(bpjsAccidentMasterEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsAccidentMasterEntity.setCreated(bpjsAccidentMasterEntity.getCreated());

			updatedBpjsAccidentMasterEntity = bpjsAccidentMasterService.update(updatedBpjsAccidentMasterEntity);

			fetchedBpjsAccidentMasterEntity = bpjsAccidentMasterService.findById(bpjsAccidentMasterEntity.getId());

			Assertions.assertTrue(fetchedBpjsAccidentMasterEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsAccidentMasterEntity_ThenEntityIsCreated
			fetchedBpjsAccidentMasterEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsAccidentMasterEntity, fetchedBpjsAccidentMasterEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsAccidentMasterEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsAccidentMasterEntity bpjsAccidentMasterEntity;
			Optional<BpjsAccidentMasterEntity> fetchedBpjsAccidentMasterEntity;

			try {
				bpjsAccidentMasterEntity = bpjsAccidentMasterFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsAccidentMasterDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsAccidentMasterEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsAccidentMasterEntity = bpjsAccidentMasterService.create(bpjsAccidentMasterEntity);

			bpjsAccidentMasterService.deleteById(bpjsAccidentMasterEntity.getId());
			fetchedBpjsAccidentMasterEntity = bpjsAccidentMasterService.findById(bpjsAccidentMasterEntity.getId());

			Assertions.assertTrue(fetchedBpjsAccidentMasterEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
