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
import kmsweb.entities.PatientVisitPatientPaymentInsuranceEntity;
import kmsweb.repositories.PatientVisitPatientPaymentInsuranceRepository;
import kmsweb.utils.PatientVisitPatientPaymentInsuranceFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitPatientPaymentInsuranceDatabasePopulator;
import kmsweb.entities.InsuranceBenefitPlanEntity;
import kmsweb.repositories.InsuranceBenefitPlanRepository;
import kmsweb.utils.InsuranceBenefitPlanFactory;
import kmsweb.utils.DatabasePopulators.InsuranceBenefitPlanDatabasePopulator;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;
import kmsweb.utils.PatientVisitFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitDatabasePopulator;
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
public class PatientVisitPatientPaymentInsuranceServiceIntegrationTest {

	@Autowired
	private PatientVisitPatientPaymentInsuranceRepository patientVisitPatientPaymentInsuranceRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PatientVisitPatientPaymentInsuranceService patientVisitPatientPaymentInsuranceService;

	private final PatientVisitPatientPaymentInsuranceFactory patientVisitPatientPaymentInsuranceFactory = new PatientVisitPatientPaymentInsuranceFactory();

	@Autowired
	private PatientVisitPatientPaymentInsuranceDatabasePopulator patientVisitPatientPaymentInsuranceDatabasePopulator;

	@Autowired
	private InsuranceBenefitPlanRepository insuranceBenefitPlanRepository;

	@Autowired
	private InsuranceBenefitPlanDatabasePopulator insuranceBenefitPlanDatabasePopulator;

	private final InsuranceBenefitPlanFactory insuranceBenefitPlanFactory = new InsuranceBenefitPlanFactory();

	@Autowired
	private PatientVisitRepository patientVisitRepository;

	@Autowired
	private PatientVisitDatabasePopulator patientVisitDatabasePopulator;

	private final PatientVisitFactory patientVisitFactory = new PatientVisitFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		patientVisitPatientPaymentInsuranceService = new PatientVisitPatientPaymentInsuranceService(
			insuranceBenefitPlanRepository,
			patientVisitRepository,
			validator,
			auditRepository,
			patientVisitPatientPaymentInsuranceRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPatientVisitPatientPaymentInsuranceEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceFactory.getObject(false, false);

		PatientVisitPatientPaymentInsuranceEntity updatedEntity = patientVisitPatientPaymentInsuranceService.updateOldData(patientVisitPatientPaymentInsuranceEntity);
		Assertions.assertEquals(patientVisitPatientPaymentInsuranceEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingPatientVisitPatientPaymentInsuranceEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntity;
			PatientVisitPatientPaymentInsuranceEntity entityWithUpdatedValues;

			try {
				patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceFactory.getObject(false, false);
				patientVisitPatientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentInsuranceEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = patientVisitPatientPaymentInsuranceFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceService.create(patientVisitPatientPaymentInsuranceEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(patientVisitPatientPaymentInsuranceEntity.getId());

			PatientVisitPatientPaymentInsuranceEntity updatedEntity = patientVisitPatientPaymentInsuranceService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPatientVisitPatientPaymentInsuranceEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceFactory.getObject(false, false);
		patientVisitPatientPaymentInsuranceEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			patientVisitPatientPaymentInsuranceService.updateOldData(patientVisitPatientPaymentInsuranceEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPatientVisitPatientPaymentInsuranceEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntity;
			PatientVisitPatientPaymentInsuranceEntity updatedPatientVisitPatientPaymentInsuranceEntity;

			PatientVisitEntity patientVisitEntity;

			InsuranceBenefitPlanEntity insuranceBenefitPlanEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceFactory.getObject(true, false);
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
			patientVisitEntity = patientVisitPatientPaymentInsuranceEntity.getPatientVisit();
			try {
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientVisitEntity = patientVisitRepository.save(patientVisitEntity);
			patientVisitPatientPaymentInsuranceEntity.setPatientVisitId(patientVisitEntity.getId());

			insuranceBenefitPlanEntity = patientVisitPatientPaymentInsuranceEntity.getInsuranceBenefitPlan();
			try {
				insuranceBenefitPlanDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceBenefitPlanEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			insuranceBenefitPlanEntity = insuranceBenefitPlanRepository.save(insuranceBenefitPlanEntity);
			patientVisitPatientPaymentInsuranceEntity.setInsuranceBenefitPlanId(insuranceBenefitPlanEntity.getId());


			patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceService.create(patientVisitPatientPaymentInsuranceEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(patientVisitPatientPaymentInsuranceEntity.getPatientVisit());
			patientVisitPatientPaymentInsuranceEntity.setPatientVisitId(null);
			patientVisitPatientPaymentInsuranceEntity.unsetPatientVisit();

			Assertions.assertNotNull(patientVisitPatientPaymentInsuranceEntity.getInsuranceBenefitPlan());
			patientVisitPatientPaymentInsuranceEntity.setInsuranceBenefitPlanId(null);
			patientVisitPatientPaymentInsuranceEntity.unsetInsuranceBenefitPlan();


			updatedPatientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceService.updateOldData(patientVisitPatientPaymentInsuranceEntity);

			Assertions.assertNull(updatedPatientVisitPatientPaymentInsuranceEntity.getPatientVisit());

			Assertions.assertNull(updatedPatientVisitPatientPaymentInsuranceEntity.getInsuranceBenefitPlan());

		});
	}

	@Test
	public void updateOldDataWithPatientVisitPatientPaymentInsuranceEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntity;
			PatientVisitPatientPaymentInsuranceEntity updatedPatientVisitPatientPaymentInsuranceEntity;

			PatientVisitEntity patientVisitEntity;

			InsuranceBenefitPlanEntity insuranceBenefitPlanEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceFactory.getObject(true, false);
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
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentInsuranceEntity.getPatientVisit(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Visit relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientVisitEntity = patientVisitRepository.findById(patientVisitRepository.save(patientVisitPatientPaymentInsuranceEntity.getPatientVisit()).getId()).get();
			patientVisitPatientPaymentInsuranceEntity.unsetPatientVisit();
			patientVisitPatientPaymentInsuranceEntity.setPatientVisitId(patientVisitEntity.getId());

			try {
				insuranceBenefitPlanDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentInsuranceEntity.getInsuranceBenefitPlan(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Insurance Benefit Plan relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			insuranceBenefitPlanEntity = insuranceBenefitPlanRepository.findById(insuranceBenefitPlanRepository.save(patientVisitPatientPaymentInsuranceEntity.getInsuranceBenefitPlan()).getId()).get();
			patientVisitPatientPaymentInsuranceEntity.unsetInsuranceBenefitPlan();
			patientVisitPatientPaymentInsuranceEntity.setInsuranceBenefitPlanId(insuranceBenefitPlanEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPatientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceService.updateOldData(patientVisitPatientPaymentInsuranceEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			patientVisitEntity.unsetPatientVisitPatientPaymentInsurance(false);
			updatedPatientVisitPatientPaymentInsuranceEntity.getPatientVisit().unsetPatientVisitPatientPaymentInsurance(false);
			Assertions.assertEquals(patientVisitEntity, updatedPatientVisitPatientPaymentInsuranceEntity.getPatientVisit());

			insuranceBenefitPlanEntity.unsetPatientVisitPatientPaymentInsurances(false);
			updatedPatientVisitPatientPaymentInsuranceEntity.getInsuranceBenefitPlan().unsetPatientVisitPatientPaymentInsurances(false);
			Assertions.assertEquals(insuranceBenefitPlanEntity, updatedPatientVisitPatientPaymentInsuranceEntity.getInsuranceBenefitPlan());

		});
	}

	@Test
	public void whenCreatePatientVisitPatientPaymentInsuranceEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntity;
			Optional<PatientVisitPatientPaymentInsuranceEntity> fetchedPatientVisitPatientPaymentInsuranceEntity;

			try {
				patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceFactory.getObject(false, false);
				patientVisitPatientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentInsuranceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceService.create(patientVisitPatientPaymentInsuranceEntity);

			fetchedPatientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceService.findById(patientVisitPatientPaymentInsuranceEntity.getId());

			Assertions.assertTrue(fetchedPatientVisitPatientPaymentInsuranceEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPatientVisitPatientPaymentInsuranceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(patientVisitPatientPaymentInsuranceEntity, fetchedPatientVisitPatientPaymentInsuranceEntity.get());
		});
	}

	@Test
	public void whenUpdatePatientVisitPatientPaymentInsuranceEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntity;
			PatientVisitPatientPaymentInsuranceEntity updatedPatientVisitPatientPaymentInsuranceEntity;
			Optional<PatientVisitPatientPaymentInsuranceEntity> fetchedPatientVisitPatientPaymentInsuranceEntity;

			try {
				patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceFactory.getObject(false, false);
				patientVisitPatientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentInsuranceEntity, true, true, false);
				updatedPatientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceFactory.getObject(false, false);
				patientVisitPatientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPatientVisitPatientPaymentInsuranceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceService.create(patientVisitPatientPaymentInsuranceEntity);

			updatedPatientVisitPatientPaymentInsuranceEntity.setId(patientVisitPatientPaymentInsuranceEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPatientVisitPatientPaymentInsuranceEntity.setCreated(patientVisitPatientPaymentInsuranceEntity.getCreated());

			updatedPatientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceService.update(updatedPatientVisitPatientPaymentInsuranceEntity);

			fetchedPatientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceService.findById(patientVisitPatientPaymentInsuranceEntity.getId());

			Assertions.assertTrue(fetchedPatientVisitPatientPaymentInsuranceEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePatientVisitPatientPaymentInsuranceEntity_ThenEntityIsCreated
			fetchedPatientVisitPatientPaymentInsuranceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPatientVisitPatientPaymentInsuranceEntity, fetchedPatientVisitPatientPaymentInsuranceEntity.get());
		});
	}

	@Test
	public void whenDeletePatientVisitPatientPaymentInsuranceEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsuranceEntity;
			Optional<PatientVisitPatientPaymentInsuranceEntity> fetchedPatientVisitPatientPaymentInsuranceEntity;

			try {
				patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				patientVisitPatientPaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentInsuranceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceService.create(patientVisitPatientPaymentInsuranceEntity);

			patientVisitPatientPaymentInsuranceService.deleteById(patientVisitPatientPaymentInsuranceEntity.getId());
			fetchedPatientVisitPatientPaymentInsuranceEntity = patientVisitPatientPaymentInsuranceService.findById(patientVisitPatientPaymentInsuranceEntity.getId());

			Assertions.assertTrue(fetchedPatientVisitPatientPaymentInsuranceEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
