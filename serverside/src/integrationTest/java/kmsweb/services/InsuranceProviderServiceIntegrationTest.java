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
import kmsweb.entities.InsuranceProviderEntity;
import kmsweb.repositories.InsuranceProviderRepository;
import kmsweb.utils.InsuranceProviderFactory;
import kmsweb.utils.DatabasePopulators.InsuranceProviderDatabasePopulator;
import kmsweb.entities.InsuranceBenefitPlanEntity;
import kmsweb.repositories.InsuranceBenefitPlanRepository;
import kmsweb.utils.InsuranceBenefitPlanFactory;
import kmsweb.utils.DatabasePopulators.InsuranceBenefitPlanDatabasePopulator;
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
public class InsuranceProviderServiceIntegrationTest {

	@Autowired
	private InsuranceProviderRepository insuranceProviderRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InsuranceProviderService insuranceProviderService;

	private final InsuranceProviderFactory insuranceProviderFactory = new InsuranceProviderFactory();

	@Autowired
	private InsuranceProviderDatabasePopulator insuranceProviderDatabasePopulator;

	@Autowired
	private InsuranceBenefitPlanRepository insuranceBenefitPlanRepository;

	@Autowired
	private InsuranceBenefitPlanDatabasePopulator insuranceBenefitPlanDatabasePopulator;

	private final InsuranceBenefitPlanFactory insuranceBenefitPlanFactory = new InsuranceBenefitPlanFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		insuranceProviderService = new InsuranceProviderService(
			insuranceBenefitPlanRepository,
			validator,
			auditRepository,
			insuranceProviderRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInsuranceProviderEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InsuranceProviderEntity insuranceProviderEntity = insuranceProviderFactory.getObject(false, false);

		InsuranceProviderEntity updatedEntity = insuranceProviderService.updateOldData(insuranceProviderEntity);
		Assertions.assertEquals(insuranceProviderEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingInsuranceProviderEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceProviderEntity insuranceProviderEntity;
			InsuranceProviderEntity entityWithUpdatedValues;

			try {
				insuranceProviderEntity = insuranceProviderFactory.getObject(false, false);
				insuranceProviderDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceProviderEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = insuranceProviderFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			insuranceProviderEntity = insuranceProviderService.create(insuranceProviderEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(insuranceProviderEntity.getId());

			InsuranceProviderEntity updatedEntity = insuranceProviderService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInsuranceProviderEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InsuranceProviderEntity insuranceProviderEntity = insuranceProviderFactory.getObject(false, false);
		insuranceProviderEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			insuranceProviderService.updateOldData(insuranceProviderEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInsuranceProviderEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceProviderEntity insuranceProviderEntity;
			InsuranceProviderEntity updatedInsuranceProviderEntity;

			Set<InsuranceBenefitPlanEntity> insuranceBenefitPlansEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				insuranceProviderEntity = insuranceProviderFactory.getObject(true, false);
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
			insuranceBenefitPlansEntities = insuranceProviderEntity.getInsuranceBenefitPlans();
			Set<UUID> insuranceBenefitPlansEntityIds = new HashSet<>();
			for (InsuranceBenefitPlanEntity entity : insuranceBenefitPlansEntities) {
				try {
					insuranceBenefitPlanDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				insuranceBenefitPlansEntityIds.add(insuranceBenefitPlanRepository.save(entity).getId());
			}
			insuranceProviderEntity.setInsuranceBenefitPlansIds(insuranceBenefitPlansEntityIds);


			insuranceProviderEntity = insuranceProviderService.create(insuranceProviderEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(insuranceProviderEntity.getInsuranceBenefitPlans().size() > 0);
			insuranceProviderEntity.setInsuranceBenefitPlansIds(new HashSet<UUID>());
			insuranceProviderEntity.unsetInsuranceBenefitPlans();


			updatedInsuranceProviderEntity = insuranceProviderService.updateOldData(insuranceProviderEntity);

			Assertions.assertEquals(0, updatedInsuranceProviderEntity.getInsuranceBenefitPlans().size());

		});
	}

	@Test
	public void updateOldDataWithInsuranceProviderEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceProviderEntity insuranceProviderEntity;
			InsuranceProviderEntity updatedInsuranceProviderEntity;

			Set<InsuranceBenefitPlanEntity> insuranceBenefitPlansEntities;
			Set<UUID> insuranceBenefitPlansEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				insuranceProviderEntity = insuranceProviderFactory.getObject(true, false);
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
			insuranceBenefitPlansEntities = new HashSet<>();
			insuranceBenefitPlansEntityIds = new HashSet<>();
			for (InsuranceBenefitPlanEntity entity : insuranceProviderEntity.getInsuranceBenefitPlans()) {
				try {
					insuranceBenefitPlanDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Insurance Benefit Plans relation for this test: " + e.getCause());
					return;
				}
				UUID id = insuranceBenefitPlanRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				insuranceBenefitPlansEntities.add(insuranceBenefitPlanRepository.findById(id).get());
				insuranceBenefitPlansEntityIds.add(id);
			}
			insuranceProviderEntity.unsetInsuranceBenefitPlans();
			insuranceProviderEntity.setInsuranceBenefitPlansIds(insuranceBenefitPlansEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInsuranceProviderEntity = insuranceProviderService.updateOldData(insuranceProviderEntity);

			Assertions.assertEquals(insuranceBenefitPlansEntities.size(), updatedInsuranceProviderEntity.getInsuranceBenefitPlans().size());

		});
	}

	@Test
	public void whenCreateInsuranceProviderEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceProviderEntity insuranceProviderEntity;
			Optional<InsuranceProviderEntity> fetchedInsuranceProviderEntity;

			try {
				insuranceProviderEntity = insuranceProviderFactory.getObject(false, false);
				insuranceProviderDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceProviderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			insuranceProviderEntity = insuranceProviderService.create(insuranceProviderEntity);

			fetchedInsuranceProviderEntity = insuranceProviderService.findById(insuranceProviderEntity.getId());

			Assertions.assertTrue(fetchedInsuranceProviderEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInsuranceProviderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(insuranceProviderEntity, fetchedInsuranceProviderEntity.get());
		});
	}

	@Test
	public void whenUpdateInsuranceProviderEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceProviderEntity insuranceProviderEntity;
			InsuranceProviderEntity updatedInsuranceProviderEntity;
			Optional<InsuranceProviderEntity> fetchedInsuranceProviderEntity;

			try {
				insuranceProviderEntity = insuranceProviderFactory.getObject(false, false);
				insuranceProviderDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceProviderEntity, true, true, false);
				updatedInsuranceProviderEntity = insuranceProviderFactory.getObject(false, false);
				insuranceProviderDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInsuranceProviderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			insuranceProviderEntity = insuranceProviderService.create(insuranceProviderEntity);

			updatedInsuranceProviderEntity.setId(insuranceProviderEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInsuranceProviderEntity.setCreated(insuranceProviderEntity.getCreated());

			updatedInsuranceProviderEntity = insuranceProviderService.update(updatedInsuranceProviderEntity);

			fetchedInsuranceProviderEntity = insuranceProviderService.findById(insuranceProviderEntity.getId());

			Assertions.assertTrue(fetchedInsuranceProviderEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInsuranceProviderEntity_ThenEntityIsCreated
			fetchedInsuranceProviderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInsuranceProviderEntity, fetchedInsuranceProviderEntity.get());
		});
	}

	@Test
	public void whenDeleteInsuranceProviderEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InsuranceProviderEntity insuranceProviderEntity;
			Optional<InsuranceProviderEntity> fetchedInsuranceProviderEntity;

			try {
				insuranceProviderEntity = insuranceProviderFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				insuranceProviderDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceProviderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			insuranceProviderEntity = insuranceProviderService.create(insuranceProviderEntity);

			insuranceProviderService.deleteById(insuranceProviderEntity.getId());
			fetchedInsuranceProviderEntity = insuranceProviderService.findById(insuranceProviderEntity.getId());

			Assertions.assertTrue(fetchedInsuranceProviderEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
