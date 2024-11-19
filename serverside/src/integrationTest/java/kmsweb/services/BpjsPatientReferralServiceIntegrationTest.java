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
import kmsweb.entities.BpjsPatientReferralEntity;
import kmsweb.repositories.BpjsPatientReferralRepository;
import kmsweb.utils.BpjsPatientReferralFactory;
import kmsweb.utils.DatabasePopulators.BpjsPatientReferralDatabasePopulator;
import kmsweb.entities.BpjsDiagnoseEntity;
import kmsweb.repositories.BpjsDiagnoseRepository;
import kmsweb.utils.BpjsDiagnoseFactory;
import kmsweb.utils.DatabasePopulators.BpjsDiagnoseDatabasePopulator;
import kmsweb.entities.BpjsHealthFacilityEntity;
import kmsweb.repositories.BpjsHealthFacilityRepository;
import kmsweb.utils.BpjsHealthFacilityFactory;
import kmsweb.utils.DatabasePopulators.BpjsHealthFacilityDatabasePopulator;
import kmsweb.entities.BpjsServiceMappingEntity;
import kmsweb.repositories.BpjsServiceMappingRepository;
import kmsweb.utils.BpjsServiceMappingFactory;
import kmsweb.utils.DatabasePopulators.BpjsServiceMappingDatabasePopulator;
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
public class BpjsPatientReferralServiceIntegrationTest {

	@Autowired
	private BpjsPatientReferralRepository bpjsPatientReferralRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsPatientReferralService bpjsPatientReferralService;

	private final BpjsPatientReferralFactory bpjsPatientReferralFactory = new BpjsPatientReferralFactory();

	@Autowired
	private BpjsPatientReferralDatabasePopulator bpjsPatientReferralDatabasePopulator;

	@Autowired
	private BpjsDiagnoseRepository bpjsDiagnoseRepository;

	@Autowired
	private BpjsDiagnoseDatabasePopulator bpjsDiagnoseDatabasePopulator;

	private final BpjsDiagnoseFactory bpjsDiagnoseFactory = new BpjsDiagnoseFactory();

	@Autowired
	private BpjsHealthFacilityRepository bpjsHealthFacilityRepository;

	@Autowired
	private BpjsHealthFacilityDatabasePopulator bpjsHealthFacilityDatabasePopulator;

	private final BpjsHealthFacilityFactory bpjsHealthFacilityFactory = new BpjsHealthFacilityFactory();

	@Autowired
	private BpjsServiceMappingRepository bpjsServiceMappingRepository;

	@Autowired
	private BpjsServiceMappingDatabasePopulator bpjsServiceMappingDatabasePopulator;

	private final BpjsServiceMappingFactory bpjsServiceMappingFactory = new BpjsServiceMappingFactory();

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
		bpjsPatientReferralService = new BpjsPatientReferralService(
			bpjsDiagnoseRepository,
			bpjsHealthFacilityRepository,
			bpjsServiceMappingRepository,
			patientPaymentBPJSRepository,
			validator,
			auditRepository,
			bpjsPatientReferralRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsPatientReferralEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsPatientReferralEntity bpjsPatientReferralEntity = bpjsPatientReferralFactory.getObject(false, false);

		BpjsPatientReferralEntity updatedEntity = bpjsPatientReferralService.updateOldData(bpjsPatientReferralEntity);
		Assertions.assertEquals(bpjsPatientReferralEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsPatientReferralEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPatientReferralEntity bpjsPatientReferralEntity;
			BpjsPatientReferralEntity entityWithUpdatedValues;

			try {
				bpjsPatientReferralEntity = bpjsPatientReferralFactory.getObject(false, false);
				bpjsPatientReferralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPatientReferralEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsPatientReferralFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPatientReferralEntity = bpjsPatientReferralService.create(bpjsPatientReferralEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsPatientReferralEntity.getId());

			BpjsPatientReferralEntity updatedEntity = bpjsPatientReferralService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsPatientReferralEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsPatientReferralEntity bpjsPatientReferralEntity = bpjsPatientReferralFactory.getObject(false, false);
		bpjsPatientReferralEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsPatientReferralService.updateOldData(bpjsPatientReferralEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsPatientReferralEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPatientReferralEntity bpjsPatientReferralEntity;
			BpjsPatientReferralEntity updatedBpjsPatientReferralEntity;

			BpjsDiagnoseEntity bpjsDiagnoseEntity;

			BpjsHealthFacilityEntity bpjsHealthFacilityEntity;

			BpjsServiceMappingEntity bpjsServiceMappingEntity;

			PatientPaymentBPJSEntity patientPaymentBPJSEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsPatientReferralEntity = bpjsPatientReferralFactory.getObject(true, false);
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
			bpjsDiagnoseEntity = bpjsPatientReferralEntity.getBpjsDiagnose();
			try {
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnoseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsDiagnoseEntity = bpjsDiagnoseRepository.save(bpjsDiagnoseEntity);
			bpjsPatientReferralEntity.setBpjsDiagnoseId(bpjsDiagnoseEntity.getId());

			bpjsHealthFacilityEntity = bpjsPatientReferralEntity.getBpjsHealthFacility();
			try {
				bpjsHealthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHealthFacilityEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsHealthFacilityEntity = bpjsHealthFacilityRepository.save(bpjsHealthFacilityEntity);
			bpjsPatientReferralEntity.setBpjsHealthFacilityId(bpjsHealthFacilityEntity.getId());

			bpjsServiceMappingEntity = bpjsPatientReferralEntity.getBpjsServiceMapping();
			try {
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsServiceMappingEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsServiceMappingEntity = bpjsServiceMappingRepository.save(bpjsServiceMappingEntity);
			bpjsPatientReferralEntity.setBpjsServiceMappingId(bpjsServiceMappingEntity.getId());

			patientPaymentBPJSEntity = bpjsPatientReferralEntity.getPatientPaymentBPJS();
			try {
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentBPJSEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientPaymentBPJSEntity = patientPaymentBPJSRepository.save(patientPaymentBPJSEntity);
			bpjsPatientReferralEntity.setPatientPaymentBPJSId(patientPaymentBPJSEntity.getId());


			bpjsPatientReferralEntity = bpjsPatientReferralService.create(bpjsPatientReferralEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsPatientReferralEntity.getBpjsDiagnose());
			bpjsPatientReferralEntity.setBpjsDiagnoseId(null);
			bpjsPatientReferralEntity.unsetBpjsDiagnose();

			Assertions.assertNotNull(bpjsPatientReferralEntity.getBpjsHealthFacility());
			bpjsPatientReferralEntity.setBpjsHealthFacilityId(null);
			bpjsPatientReferralEntity.unsetBpjsHealthFacility();

			Assertions.assertNotNull(bpjsPatientReferralEntity.getBpjsServiceMapping());
			bpjsPatientReferralEntity.setBpjsServiceMappingId(null);
			bpjsPatientReferralEntity.unsetBpjsServiceMapping();

			Assertions.assertNotNull(bpjsPatientReferralEntity.getPatientPaymentBPJS());
			bpjsPatientReferralEntity.setPatientPaymentBPJSId(null);
			bpjsPatientReferralEntity.unsetPatientPaymentBPJS();


			updatedBpjsPatientReferralEntity = bpjsPatientReferralService.updateOldData(bpjsPatientReferralEntity);

			Assertions.assertNull(updatedBpjsPatientReferralEntity.getBpjsDiagnose());

			Assertions.assertNull(updatedBpjsPatientReferralEntity.getBpjsHealthFacility());

			Assertions.assertNull(updatedBpjsPatientReferralEntity.getBpjsServiceMapping());

			Assertions.assertNull(updatedBpjsPatientReferralEntity.getPatientPaymentBPJS());

		});
	}

	@Test
	public void updateOldDataWithBpjsPatientReferralEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPatientReferralEntity bpjsPatientReferralEntity;
			BpjsPatientReferralEntity updatedBpjsPatientReferralEntity;

			BpjsDiagnoseEntity bpjsDiagnoseEntity;

			BpjsHealthFacilityEntity bpjsHealthFacilityEntity;

			BpjsServiceMappingEntity bpjsServiceMappingEntity;

			PatientPaymentBPJSEntity patientPaymentBPJSEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsPatientReferralEntity = bpjsPatientReferralFactory.getObject(true, false);
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
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPatientReferralEntity.getBpjsDiagnose(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Diagnose relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsDiagnoseEntity = bpjsDiagnoseRepository.findById(bpjsDiagnoseRepository.save(bpjsPatientReferralEntity.getBpjsDiagnose()).getId()).get();
			bpjsPatientReferralEntity.unsetBpjsDiagnose();
			bpjsPatientReferralEntity.setBpjsDiagnoseId(bpjsDiagnoseEntity.getId());

			try {
				bpjsHealthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPatientReferralEntity.getBpjsHealthFacility(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Health Facility relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsHealthFacilityEntity = bpjsHealthFacilityRepository.findById(bpjsHealthFacilityRepository.save(bpjsPatientReferralEntity.getBpjsHealthFacility()).getId()).get();
			bpjsPatientReferralEntity.unsetBpjsHealthFacility();
			bpjsPatientReferralEntity.setBpjsHealthFacilityId(bpjsHealthFacilityEntity.getId());

			try {
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPatientReferralEntity.getBpjsServiceMapping(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Service Mapping relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsServiceMappingEntity = bpjsServiceMappingRepository.findById(bpjsServiceMappingRepository.save(bpjsPatientReferralEntity.getBpjsServiceMapping()).getId()).get();
			bpjsPatientReferralEntity.unsetBpjsServiceMapping();
			bpjsPatientReferralEntity.setBpjsServiceMappingId(bpjsServiceMappingEntity.getId());

			try {
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPatientReferralEntity.getPatientPaymentBPJS(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Payment BPJS relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientPaymentBPJSEntity = patientPaymentBPJSRepository.findById(patientPaymentBPJSRepository.save(bpjsPatientReferralEntity.getPatientPaymentBPJS()).getId()).get();
			bpjsPatientReferralEntity.unsetPatientPaymentBPJS();
			bpjsPatientReferralEntity.setPatientPaymentBPJSId(patientPaymentBPJSEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsPatientReferralEntity = bpjsPatientReferralService.updateOldData(bpjsPatientReferralEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			bpjsDiagnoseEntity.unsetBpjsPatientReferrals(false);
			updatedBpjsPatientReferralEntity.getBpjsDiagnose().unsetBpjsPatientReferrals(false);
			Assertions.assertEquals(bpjsDiagnoseEntity, updatedBpjsPatientReferralEntity.getBpjsDiagnose());

			bpjsHealthFacilityEntity.unsetBpjsPatientReferrals(false);
			updatedBpjsPatientReferralEntity.getBpjsHealthFacility().unsetBpjsPatientReferrals(false);
			Assertions.assertEquals(bpjsHealthFacilityEntity, updatedBpjsPatientReferralEntity.getBpjsHealthFacility());

			bpjsServiceMappingEntity.unsetBpjsPatientReferrals(false);
			updatedBpjsPatientReferralEntity.getBpjsServiceMapping().unsetBpjsPatientReferrals(false);
			Assertions.assertEquals(bpjsServiceMappingEntity, updatedBpjsPatientReferralEntity.getBpjsServiceMapping());

			patientPaymentBPJSEntity.unsetBpjsPatientReferrals(false);
			updatedBpjsPatientReferralEntity.getPatientPaymentBPJS().unsetBpjsPatientReferrals(false);
			Assertions.assertEquals(patientPaymentBPJSEntity, updatedBpjsPatientReferralEntity.getPatientPaymentBPJS());

		});
	}

	@Test
	public void whenCreateBpjsPatientReferralEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPatientReferralEntity bpjsPatientReferralEntity;
			Optional<BpjsPatientReferralEntity> fetchedBpjsPatientReferralEntity;

			try {
				bpjsPatientReferralEntity = bpjsPatientReferralFactory.getObject(false, false);
				bpjsPatientReferralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPatientReferralEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPatientReferralEntity = bpjsPatientReferralService.create(bpjsPatientReferralEntity);

			fetchedBpjsPatientReferralEntity = bpjsPatientReferralService.findById(bpjsPatientReferralEntity.getId());

			Assertions.assertTrue(fetchedBpjsPatientReferralEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsPatientReferralEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsPatientReferralEntity, fetchedBpjsPatientReferralEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsPatientReferralEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPatientReferralEntity bpjsPatientReferralEntity;
			BpjsPatientReferralEntity updatedBpjsPatientReferralEntity;
			Optional<BpjsPatientReferralEntity> fetchedBpjsPatientReferralEntity;

			try {
				bpjsPatientReferralEntity = bpjsPatientReferralFactory.getObject(false, false);
				bpjsPatientReferralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPatientReferralEntity, true, true, false);
				updatedBpjsPatientReferralEntity = bpjsPatientReferralFactory.getObject(false, false);
				bpjsPatientReferralDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsPatientReferralEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPatientReferralEntity = bpjsPatientReferralService.create(bpjsPatientReferralEntity);

			updatedBpjsPatientReferralEntity.setId(bpjsPatientReferralEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsPatientReferralEntity.setCreated(bpjsPatientReferralEntity.getCreated());

			updatedBpjsPatientReferralEntity = bpjsPatientReferralService.update(updatedBpjsPatientReferralEntity);

			fetchedBpjsPatientReferralEntity = bpjsPatientReferralService.findById(bpjsPatientReferralEntity.getId());

			Assertions.assertTrue(fetchedBpjsPatientReferralEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsPatientReferralEntity_ThenEntityIsCreated
			fetchedBpjsPatientReferralEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsPatientReferralEntity, fetchedBpjsPatientReferralEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsPatientReferralEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPatientReferralEntity bpjsPatientReferralEntity;
			Optional<BpjsPatientReferralEntity> fetchedBpjsPatientReferralEntity;

			try {
				bpjsPatientReferralEntity = bpjsPatientReferralFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsPatientReferralDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPatientReferralEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPatientReferralEntity = bpjsPatientReferralService.create(bpjsPatientReferralEntity);

			bpjsPatientReferralService.deleteById(bpjsPatientReferralEntity.getId());
			fetchedBpjsPatientReferralEntity = bpjsPatientReferralService.findById(bpjsPatientReferralEntity.getId());

			Assertions.assertTrue(fetchedBpjsPatientReferralEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
