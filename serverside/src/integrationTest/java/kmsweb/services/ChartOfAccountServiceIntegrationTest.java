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
import kmsweb.entities.ChartOfAccountEntity;
import kmsweb.repositories.ChartOfAccountRepository;
import kmsweb.utils.ChartOfAccountFactory;
import kmsweb.utils.DatabasePopulators.ChartOfAccountDatabasePopulator;
import kmsweb.entities.ChartOfAccountMappingEntity;
import kmsweb.repositories.ChartOfAccountMappingRepository;
import kmsweb.utils.ChartOfAccountMappingFactory;
import kmsweb.utils.DatabasePopulators.ChartOfAccountMappingDatabasePopulator;
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
public class ChartOfAccountServiceIntegrationTest {

	@Autowired
	private ChartOfAccountRepository chartOfAccountRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private ChartOfAccountService chartOfAccountService;

	private final ChartOfAccountFactory chartOfAccountFactory = new ChartOfAccountFactory();

	@Autowired
	private ChartOfAccountDatabasePopulator chartOfAccountDatabasePopulator;

	@Autowired
	private ChartOfAccountMappingRepository chartOfAccountMappingRepository;

	@Autowired
	private ChartOfAccountMappingDatabasePopulator chartOfAccountMappingDatabasePopulator;

	private final ChartOfAccountMappingFactory chartOfAccountMappingFactory = new ChartOfAccountMappingFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		chartOfAccountService = new ChartOfAccountService(
			chartOfAccountMappingRepository,
			validator,
			auditRepository,
			chartOfAccountRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewChartOfAccountEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		ChartOfAccountEntity chartOfAccountEntity = chartOfAccountFactory.getObject(false, false);

		ChartOfAccountEntity updatedEntity = chartOfAccountService.updateOldData(chartOfAccountEntity);
		Assertions.assertEquals(chartOfAccountEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewChartOfAccountEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		ChartOfAccountEntity chartOfAccountEntity = chartOfAccountFactory.getObject(false, false);

		chartOfAccountEntity.setDashboard(null);
		Assertions.assertNull(chartOfAccountEntity.getDashboard());

		chartOfAccountEntity.setExpenseClaim(null);
		Assertions.assertNull(chartOfAccountEntity.getExpenseClaim());

		chartOfAccountEntity.setEnablePayment(null);
		Assertions.assertNull(chartOfAccountEntity.getEnablePayment());


		ChartOfAccountEntity updatedEntity = chartOfAccountService.updateOldData(chartOfAccountEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getDashboard());
		Assertions.assertFalse(updatedEntity.getDashboard());

		Assertions.assertNotNull(updatedEntity.getExpenseClaim());
		Assertions.assertFalse(updatedEntity.getExpenseClaim());

		Assertions.assertNotNull(updatedEntity.getEnablePayment());
		Assertions.assertFalse(updatedEntity.getEnablePayment());

	}

	@Test
	public void updateOldDataWithExistingChartOfAccountEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			ChartOfAccountEntity chartOfAccountEntity;
			ChartOfAccountEntity entityWithUpdatedValues;

			try {
				chartOfAccountEntity = chartOfAccountFactory.getObject(false, false);
				chartOfAccountDatabasePopulator.populateRelatedEntitiesInDatabase(chartOfAccountEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = chartOfAccountFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			chartOfAccountEntity = chartOfAccountService.create(chartOfAccountEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(chartOfAccountEntity.getId());

			ChartOfAccountEntity updatedEntity = chartOfAccountService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithChartOfAccountEntityWithNonExistentId_ShouldThrowException() throws Exception {
		ChartOfAccountEntity chartOfAccountEntity = chartOfAccountFactory.getObject(false, false);
		chartOfAccountEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			chartOfAccountService.updateOldData(chartOfAccountEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingChartOfAccountEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ChartOfAccountEntity chartOfAccountEntity;
			ChartOfAccountEntity updatedChartOfAccountEntity;

			Set<ChartOfAccountMappingEntity> chartOfAccountMappingsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				chartOfAccountEntity = chartOfAccountFactory.getObject(true, false);
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
			chartOfAccountMappingsEntities = chartOfAccountEntity.getChartOfAccountMappings();
			Set<UUID> chartOfAccountMappingsEntityIds = new HashSet<>();
			for (ChartOfAccountMappingEntity entity : chartOfAccountMappingsEntities) {
				try {
					chartOfAccountMappingDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				chartOfAccountMappingsEntityIds.add(chartOfAccountMappingRepository.save(entity).getId());
			}
			chartOfAccountEntity.setChartOfAccountMappingsIds(chartOfAccountMappingsEntityIds);


			chartOfAccountEntity = chartOfAccountService.create(chartOfAccountEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(chartOfAccountEntity.getChartOfAccountMappings().size() > 0);
			chartOfAccountEntity.setChartOfAccountMappingsIds(new HashSet<UUID>());
			chartOfAccountEntity.unsetChartOfAccountMappings();


			updatedChartOfAccountEntity = chartOfAccountService.updateOldData(chartOfAccountEntity);

			Assertions.assertEquals(0, updatedChartOfAccountEntity.getChartOfAccountMappings().size());

		});
	}

	@Test
	public void updateOldDataWithChartOfAccountEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ChartOfAccountEntity chartOfAccountEntity;
			ChartOfAccountEntity updatedChartOfAccountEntity;

			Set<ChartOfAccountMappingEntity> chartOfAccountMappingsEntities;
			Set<UUID> chartOfAccountMappingsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				chartOfAccountEntity = chartOfAccountFactory.getObject(true, false);
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
			chartOfAccountMappingsEntities = new HashSet<>();
			chartOfAccountMappingsEntityIds = new HashSet<>();
			for (ChartOfAccountMappingEntity entity : chartOfAccountEntity.getChartOfAccountMappings()) {
				try {
					chartOfAccountMappingDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Chart of Account Mappings relation for this test: " + e.getCause());
					return;
				}
				UUID id = chartOfAccountMappingRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				chartOfAccountMappingsEntities.add(chartOfAccountMappingRepository.findById(id).get());
				chartOfAccountMappingsEntityIds.add(id);
			}
			chartOfAccountEntity.unsetChartOfAccountMappings();
			chartOfAccountEntity.setChartOfAccountMappingsIds(chartOfAccountMappingsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedChartOfAccountEntity = chartOfAccountService.updateOldData(chartOfAccountEntity);

			Assertions.assertEquals(chartOfAccountMappingsEntities.size(), updatedChartOfAccountEntity.getChartOfAccountMappings().size());

		});
	}

	@Test
	public void whenCreateChartOfAccountEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			ChartOfAccountEntity chartOfAccountEntity;
			Optional<ChartOfAccountEntity> fetchedChartOfAccountEntity;

			try {
				chartOfAccountEntity = chartOfAccountFactory.getObject(false, false);
				chartOfAccountDatabasePopulator.populateRelatedEntitiesInDatabase(chartOfAccountEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			chartOfAccountEntity = chartOfAccountService.create(chartOfAccountEntity);

			fetchedChartOfAccountEntity = chartOfAccountService.findById(chartOfAccountEntity.getId());

			Assertions.assertTrue(fetchedChartOfAccountEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedChartOfAccountEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(chartOfAccountEntity, fetchedChartOfAccountEntity.get());
		});
	}

	@Test
	public void whenUpdateChartOfAccountEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			ChartOfAccountEntity chartOfAccountEntity;
			ChartOfAccountEntity updatedChartOfAccountEntity;
			Optional<ChartOfAccountEntity> fetchedChartOfAccountEntity;

			try {
				chartOfAccountEntity = chartOfAccountFactory.getObject(false, false);
				chartOfAccountDatabasePopulator.populateRelatedEntitiesInDatabase(chartOfAccountEntity, true, true, false);
				updatedChartOfAccountEntity = chartOfAccountFactory.getObject(false, false);
				chartOfAccountDatabasePopulator.populateRelatedEntitiesInDatabase(updatedChartOfAccountEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			chartOfAccountEntity = chartOfAccountService.create(chartOfAccountEntity);

			updatedChartOfAccountEntity.setId(chartOfAccountEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedChartOfAccountEntity.setCreated(chartOfAccountEntity.getCreated());

			updatedChartOfAccountEntity = chartOfAccountService.update(updatedChartOfAccountEntity);

			fetchedChartOfAccountEntity = chartOfAccountService.findById(chartOfAccountEntity.getId());

			Assertions.assertTrue(fetchedChartOfAccountEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateChartOfAccountEntity_ThenEntityIsCreated
			fetchedChartOfAccountEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedChartOfAccountEntity, fetchedChartOfAccountEntity.get());
		});
	}

	@Test
	public void whenDeleteChartOfAccountEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			ChartOfAccountEntity chartOfAccountEntity;
			Optional<ChartOfAccountEntity> fetchedChartOfAccountEntity;

			try {
				chartOfAccountEntity = chartOfAccountFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				chartOfAccountDatabasePopulator.populateRelatedEntitiesInDatabase(chartOfAccountEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			chartOfAccountEntity = chartOfAccountService.create(chartOfAccountEntity);

			chartOfAccountService.deleteById(chartOfAccountEntity.getId());
			fetchedChartOfAccountEntity = chartOfAccountService.findById(chartOfAccountEntity.getId());

			Assertions.assertTrue(fetchedChartOfAccountEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
