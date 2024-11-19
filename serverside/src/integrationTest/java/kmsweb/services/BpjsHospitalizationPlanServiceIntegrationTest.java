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
import kmsweb.entities.BpjsHospitalizationPlanEntity;
import kmsweb.repositories.BpjsHospitalizationPlanRepository;
import kmsweb.utils.BpjsHospitalizationPlanFactory;
import kmsweb.utils.DatabasePopulators.BpjsHospitalizationPlanDatabasePopulator;
import kmsweb.entities.BpjsDoctorMappingEntity;
import kmsweb.repositories.BpjsDoctorMappingRepository;
import kmsweb.utils.BpjsDoctorMappingFactory;
import kmsweb.utils.DatabasePopulators.BpjsDoctorMappingDatabasePopulator;
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
public class BpjsHospitalizationPlanServiceIntegrationTest {

	@Autowired
	private BpjsHospitalizationPlanRepository bpjsHospitalizationPlanRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsHospitalizationPlanService bpjsHospitalizationPlanService;

	private final BpjsHospitalizationPlanFactory bpjsHospitalizationPlanFactory = new BpjsHospitalizationPlanFactory();

	@Autowired
	private BpjsHospitalizationPlanDatabasePopulator bpjsHospitalizationPlanDatabasePopulator;

	@Autowired
	private BpjsDoctorMappingRepository bpjsDoctorMappingRepository;

	@Autowired
	private BpjsDoctorMappingDatabasePopulator bpjsDoctorMappingDatabasePopulator;

	private final BpjsDoctorMappingFactory bpjsDoctorMappingFactory = new BpjsDoctorMappingFactory();

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
		bpjsHospitalizationPlanService = new BpjsHospitalizationPlanService(
			bpjsDoctorMappingRepository,
			bpjsServiceMappingRepository,
			patientPaymentBPJSRepository,
			validator,
			auditRepository,
			bpjsHospitalizationPlanRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsHospitalizationPlanEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsHospitalizationPlanEntity bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanFactory.getObject(false, false);

		BpjsHospitalizationPlanEntity updatedEntity = bpjsHospitalizationPlanService.updateOldData(bpjsHospitalizationPlanEntity);
		Assertions.assertEquals(bpjsHospitalizationPlanEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsHospitalizationPlanEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHospitalizationPlanEntity bpjsHospitalizationPlanEntity;
			BpjsHospitalizationPlanEntity entityWithUpdatedValues;

			try {
				bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanFactory.getObject(false, false);
				bpjsHospitalizationPlanDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHospitalizationPlanEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsHospitalizationPlanFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanService.create(bpjsHospitalizationPlanEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsHospitalizationPlanEntity.getId());

			BpjsHospitalizationPlanEntity updatedEntity = bpjsHospitalizationPlanService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsHospitalizationPlanEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsHospitalizationPlanEntity bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanFactory.getObject(false, false);
		bpjsHospitalizationPlanEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsHospitalizationPlanService.updateOldData(bpjsHospitalizationPlanEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsHospitalizationPlanEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHospitalizationPlanEntity bpjsHospitalizationPlanEntity;
			BpjsHospitalizationPlanEntity updatedBpjsHospitalizationPlanEntity;

			PatientPaymentBPJSEntity patientPaymentBPJSEntity;

			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;

			BpjsServiceMappingEntity bpjsServiceMappingEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanFactory.getObject(true, false);
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
			patientPaymentBPJSEntity = bpjsHospitalizationPlanEntity.getPatientPaymentBPJS();
			try {
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(patientPaymentBPJSEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientPaymentBPJSEntity = patientPaymentBPJSRepository.save(patientPaymentBPJSEntity);
			bpjsHospitalizationPlanEntity.setPatientPaymentBPJSId(patientPaymentBPJSEntity.getId());

			bpjsDoctorMappingEntity = bpjsHospitalizationPlanEntity.getBpjsDoctorMapping();
			try {
				bpjsDoctorMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDoctorMappingEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsDoctorMappingEntity = bpjsDoctorMappingRepository.save(bpjsDoctorMappingEntity);
			bpjsHospitalizationPlanEntity.setBpjsDoctorMappingId(bpjsDoctorMappingEntity.getId());

			bpjsServiceMappingEntity = bpjsHospitalizationPlanEntity.getBpjsServiceMapping();
			try {
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsServiceMappingEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsServiceMappingEntity = bpjsServiceMappingRepository.save(bpjsServiceMappingEntity);
			bpjsHospitalizationPlanEntity.setBpjsServiceMappingId(bpjsServiceMappingEntity.getId());


			bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanService.create(bpjsHospitalizationPlanEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsHospitalizationPlanEntity.getPatientPaymentBPJS());
			bpjsHospitalizationPlanEntity.setPatientPaymentBPJSId(null);
			bpjsHospitalizationPlanEntity.unsetPatientPaymentBPJS();

			Assertions.assertNotNull(bpjsHospitalizationPlanEntity.getBpjsDoctorMapping());
			bpjsHospitalizationPlanEntity.setBpjsDoctorMappingId(null);
			bpjsHospitalizationPlanEntity.unsetBpjsDoctorMapping();

			Assertions.assertNotNull(bpjsHospitalizationPlanEntity.getBpjsServiceMapping());
			bpjsHospitalizationPlanEntity.setBpjsServiceMappingId(null);
			bpjsHospitalizationPlanEntity.unsetBpjsServiceMapping();


			updatedBpjsHospitalizationPlanEntity = bpjsHospitalizationPlanService.updateOldData(bpjsHospitalizationPlanEntity);

			Assertions.assertNull(updatedBpjsHospitalizationPlanEntity.getPatientPaymentBPJS());

			Assertions.assertNull(updatedBpjsHospitalizationPlanEntity.getBpjsDoctorMapping());

			Assertions.assertNull(updatedBpjsHospitalizationPlanEntity.getBpjsServiceMapping());

		});
	}

	@Test
	public void updateOldDataWithBpjsHospitalizationPlanEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHospitalizationPlanEntity bpjsHospitalizationPlanEntity;
			BpjsHospitalizationPlanEntity updatedBpjsHospitalizationPlanEntity;

			PatientPaymentBPJSEntity patientPaymentBPJSEntity;

			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;

			BpjsServiceMappingEntity bpjsServiceMappingEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanFactory.getObject(true, false);
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
				patientPaymentBPJSDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHospitalizationPlanEntity.getPatientPaymentBPJS(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Payment BPJS relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientPaymentBPJSEntity = patientPaymentBPJSRepository.findById(patientPaymentBPJSRepository.save(bpjsHospitalizationPlanEntity.getPatientPaymentBPJS()).getId()).get();
			bpjsHospitalizationPlanEntity.unsetPatientPaymentBPJS();
			bpjsHospitalizationPlanEntity.setPatientPaymentBPJSId(patientPaymentBPJSEntity.getId());

			try {
				bpjsDoctorMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHospitalizationPlanEntity.getBpjsDoctorMapping(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Doctor Mapping relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsDoctorMappingEntity = bpjsDoctorMappingRepository.findById(bpjsDoctorMappingRepository.save(bpjsHospitalizationPlanEntity.getBpjsDoctorMapping()).getId()).get();
			bpjsHospitalizationPlanEntity.unsetBpjsDoctorMapping();
			bpjsHospitalizationPlanEntity.setBpjsDoctorMappingId(bpjsDoctorMappingEntity.getId());

			try {
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHospitalizationPlanEntity.getBpjsServiceMapping(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Service Mapping relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsServiceMappingEntity = bpjsServiceMappingRepository.findById(bpjsServiceMappingRepository.save(bpjsHospitalizationPlanEntity.getBpjsServiceMapping()).getId()).get();
			bpjsHospitalizationPlanEntity.unsetBpjsServiceMapping();
			bpjsHospitalizationPlanEntity.setBpjsServiceMappingId(bpjsServiceMappingEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsHospitalizationPlanEntity = bpjsHospitalizationPlanService.updateOldData(bpjsHospitalizationPlanEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			patientPaymentBPJSEntity.unsetBpjsHospitalizationPlans(false);
			updatedBpjsHospitalizationPlanEntity.getPatientPaymentBPJS().unsetBpjsHospitalizationPlans(false);
			Assertions.assertEquals(patientPaymentBPJSEntity, updatedBpjsHospitalizationPlanEntity.getPatientPaymentBPJS());

			bpjsDoctorMappingEntity.unsetKodedokter(false);
			updatedBpjsHospitalizationPlanEntity.getBpjsDoctorMapping().unsetKodedokter(false);
			Assertions.assertEquals(bpjsDoctorMappingEntity, updatedBpjsHospitalizationPlanEntity.getBpjsDoctorMapping());

			bpjsServiceMappingEntity.unsetPolikontrol(false);
			updatedBpjsHospitalizationPlanEntity.getBpjsServiceMapping().unsetPolikontrol(false);
			Assertions.assertEquals(bpjsServiceMappingEntity, updatedBpjsHospitalizationPlanEntity.getBpjsServiceMapping());

		});
	}

	@Test
	public void whenCreateBpjsHospitalizationPlanEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHospitalizationPlanEntity bpjsHospitalizationPlanEntity;
			Optional<BpjsHospitalizationPlanEntity> fetchedBpjsHospitalizationPlanEntity;

			try {
				bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanFactory.getObject(false, false);
				bpjsHospitalizationPlanDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHospitalizationPlanEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanService.create(bpjsHospitalizationPlanEntity);

			fetchedBpjsHospitalizationPlanEntity = bpjsHospitalizationPlanService.findById(bpjsHospitalizationPlanEntity.getId());

			Assertions.assertTrue(fetchedBpjsHospitalizationPlanEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsHospitalizationPlanEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsHospitalizationPlanEntity, fetchedBpjsHospitalizationPlanEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsHospitalizationPlanEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHospitalizationPlanEntity bpjsHospitalizationPlanEntity;
			BpjsHospitalizationPlanEntity updatedBpjsHospitalizationPlanEntity;
			Optional<BpjsHospitalizationPlanEntity> fetchedBpjsHospitalizationPlanEntity;

			try {
				bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanFactory.getObject(false, false);
				bpjsHospitalizationPlanDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHospitalizationPlanEntity, true, true, false);
				updatedBpjsHospitalizationPlanEntity = bpjsHospitalizationPlanFactory.getObject(false, false);
				bpjsHospitalizationPlanDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsHospitalizationPlanEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanService.create(bpjsHospitalizationPlanEntity);

			updatedBpjsHospitalizationPlanEntity.setId(bpjsHospitalizationPlanEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsHospitalizationPlanEntity.setCreated(bpjsHospitalizationPlanEntity.getCreated());

			updatedBpjsHospitalizationPlanEntity = bpjsHospitalizationPlanService.update(updatedBpjsHospitalizationPlanEntity);

			fetchedBpjsHospitalizationPlanEntity = bpjsHospitalizationPlanService.findById(bpjsHospitalizationPlanEntity.getId());

			Assertions.assertTrue(fetchedBpjsHospitalizationPlanEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsHospitalizationPlanEntity_ThenEntityIsCreated
			fetchedBpjsHospitalizationPlanEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsHospitalizationPlanEntity, fetchedBpjsHospitalizationPlanEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsHospitalizationPlanEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHospitalizationPlanEntity bpjsHospitalizationPlanEntity;
			Optional<BpjsHospitalizationPlanEntity> fetchedBpjsHospitalizationPlanEntity;

			try {
				bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsHospitalizationPlanDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHospitalizationPlanEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsHospitalizationPlanEntity = bpjsHospitalizationPlanService.create(bpjsHospitalizationPlanEntity);

			bpjsHospitalizationPlanService.deleteById(bpjsHospitalizationPlanEntity.getId());
			fetchedBpjsHospitalizationPlanEntity = bpjsHospitalizationPlanService.findById(bpjsHospitalizationPlanEntity.getId());

			Assertions.assertTrue(fetchedBpjsHospitalizationPlanEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
