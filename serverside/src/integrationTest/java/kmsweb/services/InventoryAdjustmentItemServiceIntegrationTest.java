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
import kmsweb.entities.InventoryAdjustmentItemEntity;
import kmsweb.repositories.InventoryAdjustmentItemRepository;
import kmsweb.utils.InventoryAdjustmentItemFactory;
import kmsweb.utils.DatabasePopulators.InventoryAdjustmentItemDatabasePopulator;
import kmsweb.entities.InventoryAdjusmentBatchEntity;
import kmsweb.repositories.InventoryAdjusmentBatchRepository;
import kmsweb.utils.InventoryAdjusmentBatchFactory;
import kmsweb.utils.DatabasePopulators.InventoryAdjusmentBatchDatabasePopulator;
import kmsweb.entities.InventoryAdjustmentEntity;
import kmsweb.repositories.InventoryAdjustmentRepository;
import kmsweb.utils.InventoryAdjustmentFactory;
import kmsweb.utils.DatabasePopulators.InventoryAdjustmentDatabasePopulator;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.utils.StockCatalogueFactory;
import kmsweb.utils.DatabasePopulators.StockCatalogueDatabasePopulator;
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
public class InventoryAdjustmentItemServiceIntegrationTest {

	@Autowired
	private InventoryAdjustmentItemRepository inventoryAdjustmentItemRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InventoryAdjustmentItemService inventoryAdjustmentItemService;

	private final InventoryAdjustmentItemFactory inventoryAdjustmentItemFactory = new InventoryAdjustmentItemFactory();

	@Autowired
	private InventoryAdjustmentItemDatabasePopulator inventoryAdjustmentItemDatabasePopulator;

	@Autowired
	private InventoryAdjusmentBatchRepository inventoryAdjusmentBatchRepository;

	@Autowired
	private InventoryAdjusmentBatchDatabasePopulator inventoryAdjusmentBatchDatabasePopulator;

	private final InventoryAdjusmentBatchFactory inventoryAdjusmentBatchFactory = new InventoryAdjusmentBatchFactory();

	@Autowired
	private InventoryAdjustmentRepository inventoryAdjustmentRepository;

	@Autowired
	private InventoryAdjustmentDatabasePopulator inventoryAdjustmentDatabasePopulator;

	private final InventoryAdjustmentFactory inventoryAdjustmentFactory = new InventoryAdjustmentFactory();

	@Autowired
	private StockCatalogueRepository stockCatalogueRepository;

	@Autowired
	private StockCatalogueDatabasePopulator stockCatalogueDatabasePopulator;

	private final StockCatalogueFactory stockCatalogueFactory = new StockCatalogueFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		inventoryAdjustmentItemService = new InventoryAdjustmentItemService(
			inventoryAdjusmentBatchRepository,
			inventoryAdjustmentRepository,
			stockCatalogueRepository,
			validator,
			auditRepository,
			inventoryAdjustmentItemRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInventoryAdjustmentItemEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InventoryAdjustmentItemEntity inventoryAdjustmentItemEntity = inventoryAdjustmentItemFactory.getObject(false, false);

		InventoryAdjustmentItemEntity updatedEntity = inventoryAdjustmentItemService.updateOldData(inventoryAdjustmentItemEntity);
		Assertions.assertEquals(inventoryAdjustmentItemEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingInventoryAdjustmentItemEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentItemEntity inventoryAdjustmentItemEntity;
			InventoryAdjustmentItemEntity entityWithUpdatedValues;

			try {
				inventoryAdjustmentItemEntity = inventoryAdjustmentItemFactory.getObject(false, false);
				inventoryAdjustmentItemDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentItemEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = inventoryAdjustmentItemFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryAdjustmentItemEntity = inventoryAdjustmentItemService.create(inventoryAdjustmentItemEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(inventoryAdjustmentItemEntity.getId());

			InventoryAdjustmentItemEntity updatedEntity = inventoryAdjustmentItemService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInventoryAdjustmentItemEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InventoryAdjustmentItemEntity inventoryAdjustmentItemEntity = inventoryAdjustmentItemFactory.getObject(false, false);
		inventoryAdjustmentItemEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			inventoryAdjustmentItemService.updateOldData(inventoryAdjustmentItemEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInventoryAdjustmentItemEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentItemEntity inventoryAdjustmentItemEntity;
			InventoryAdjustmentItemEntity updatedInventoryAdjustmentItemEntity;

			InventoryAdjustmentEntity inventoryAdjustmentEntity;

			StockCatalogueEntity stockCatalogueEntity;

			Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				inventoryAdjustmentItemEntity = inventoryAdjustmentItemFactory.getObject(true, false);
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
			inventoryAdjustmentEntity = inventoryAdjustmentItemEntity.getInventoryAdjustment();
			try {
				inventoryAdjustmentDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			inventoryAdjustmentEntity = inventoryAdjustmentRepository.save(inventoryAdjustmentEntity);
			inventoryAdjustmentItemEntity.setInventoryAdjustmentId(inventoryAdjustmentEntity.getId());

			stockCatalogueEntity = inventoryAdjustmentItemEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			inventoryAdjustmentItemEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			inventoryAdjusmentBatchsEntities = inventoryAdjustmentItemEntity.getInventoryAdjusmentBatchs();
			Set<UUID> inventoryAdjusmentBatchsEntityIds = new HashSet<>();
			for (InventoryAdjusmentBatchEntity entity : inventoryAdjusmentBatchsEntities) {
				try {
					inventoryAdjusmentBatchDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				inventoryAdjusmentBatchsEntityIds.add(inventoryAdjusmentBatchRepository.save(entity).getId());
			}
			inventoryAdjustmentItemEntity.setInventoryAdjusmentBatchsIds(inventoryAdjusmentBatchsEntityIds);


			inventoryAdjustmentItemEntity = inventoryAdjustmentItemService.create(inventoryAdjustmentItemEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(inventoryAdjustmentItemEntity.getInventoryAdjustment());
			inventoryAdjustmentItemEntity.setInventoryAdjustmentId(null);
			inventoryAdjustmentItemEntity.unsetInventoryAdjustment();

			Assertions.assertNotNull(inventoryAdjustmentItemEntity.getStockCatalogue());
			inventoryAdjustmentItemEntity.setStockCatalogueId(null);
			inventoryAdjustmentItemEntity.unsetStockCatalogue();

			Assertions.assertTrue(inventoryAdjustmentItemEntity.getInventoryAdjusmentBatchs().size() > 0);
			inventoryAdjustmentItemEntity.setInventoryAdjusmentBatchsIds(new HashSet<UUID>());
			inventoryAdjustmentItemEntity.unsetInventoryAdjusmentBatchs();


			updatedInventoryAdjustmentItemEntity = inventoryAdjustmentItemService.updateOldData(inventoryAdjustmentItemEntity);

			Assertions.assertNull(updatedInventoryAdjustmentItemEntity.getInventoryAdjustment());

			Assertions.assertNull(updatedInventoryAdjustmentItemEntity.getStockCatalogue());

			Assertions.assertEquals(0, updatedInventoryAdjustmentItemEntity.getInventoryAdjusmentBatchs().size());

		});
	}

	@Test
	public void updateOldDataWithInventoryAdjustmentItemEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentItemEntity inventoryAdjustmentItemEntity;
			InventoryAdjustmentItemEntity updatedInventoryAdjustmentItemEntity;

			InventoryAdjustmentEntity inventoryAdjustmentEntity;

			StockCatalogueEntity stockCatalogueEntity;

			Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchsEntities;
			Set<UUID> inventoryAdjusmentBatchsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				inventoryAdjustmentItemEntity = inventoryAdjustmentItemFactory.getObject(true, false);
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
				inventoryAdjustmentDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentItemEntity.getInventoryAdjustment(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Inventory Adjustment relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			inventoryAdjustmentEntity = inventoryAdjustmentRepository.findById(inventoryAdjustmentRepository.save(inventoryAdjustmentItemEntity.getInventoryAdjustment()).getId()).get();
			inventoryAdjustmentItemEntity.unsetInventoryAdjustment();
			inventoryAdjustmentItemEntity.setInventoryAdjustmentId(inventoryAdjustmentEntity.getId());

			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentItemEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(inventoryAdjustmentItemEntity.getStockCatalogue()).getId()).get();
			inventoryAdjustmentItemEntity.unsetStockCatalogue();
			inventoryAdjustmentItemEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			inventoryAdjusmentBatchsEntities = new HashSet<>();
			inventoryAdjusmentBatchsEntityIds = new HashSet<>();
			for (InventoryAdjusmentBatchEntity entity : inventoryAdjustmentItemEntity.getInventoryAdjusmentBatchs()) {
				try {
					inventoryAdjusmentBatchDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Inventory Adjusment Batchs relation for this test: " + e.getCause());
					return;
				}
				UUID id = inventoryAdjusmentBatchRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				inventoryAdjusmentBatchsEntities.add(inventoryAdjusmentBatchRepository.findById(id).get());
				inventoryAdjusmentBatchsEntityIds.add(id);
			}
			inventoryAdjustmentItemEntity.unsetInventoryAdjusmentBatchs();
			inventoryAdjustmentItemEntity.setInventoryAdjusmentBatchsIds(inventoryAdjusmentBatchsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInventoryAdjustmentItemEntity = inventoryAdjustmentItemService.updateOldData(inventoryAdjustmentItemEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			inventoryAdjustmentEntity.unsetInventoryAdjustmentItems(false);
			updatedInventoryAdjustmentItemEntity.getInventoryAdjustment().unsetInventoryAdjustmentItems(false);
			Assertions.assertEquals(inventoryAdjustmentEntity, updatedInventoryAdjustmentItemEntity.getInventoryAdjustment());

			stockCatalogueEntity.unsetInventoryAdjustmentItems(false);
			updatedInventoryAdjustmentItemEntity.getStockCatalogue().unsetInventoryAdjustmentItems(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedInventoryAdjustmentItemEntity.getStockCatalogue());

			Assertions.assertEquals(inventoryAdjusmentBatchsEntities.size(), updatedInventoryAdjustmentItemEntity.getInventoryAdjusmentBatchs().size());

		});
	}

	@Test
	public void whenCreateInventoryAdjustmentItemEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentItemEntity inventoryAdjustmentItemEntity;
			Optional<InventoryAdjustmentItemEntity> fetchedInventoryAdjustmentItemEntity;

			try {
				inventoryAdjustmentItemEntity = inventoryAdjustmentItemFactory.getObject(false, false);
				inventoryAdjustmentItemDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryAdjustmentItemEntity = inventoryAdjustmentItemService.create(inventoryAdjustmentItemEntity);

			fetchedInventoryAdjustmentItemEntity = inventoryAdjustmentItemService.findById(inventoryAdjustmentItemEntity.getId());

			Assertions.assertTrue(fetchedInventoryAdjustmentItemEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInventoryAdjustmentItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(inventoryAdjustmentItemEntity, fetchedInventoryAdjustmentItemEntity.get());
		});
	}

	@Test
	public void whenUpdateInventoryAdjustmentItemEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentItemEntity inventoryAdjustmentItemEntity;
			InventoryAdjustmentItemEntity updatedInventoryAdjustmentItemEntity;
			Optional<InventoryAdjustmentItemEntity> fetchedInventoryAdjustmentItemEntity;

			try {
				inventoryAdjustmentItemEntity = inventoryAdjustmentItemFactory.getObject(false, false);
				inventoryAdjustmentItemDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentItemEntity, true, true, false);
				updatedInventoryAdjustmentItemEntity = inventoryAdjustmentItemFactory.getObject(false, false);
				inventoryAdjustmentItemDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInventoryAdjustmentItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryAdjustmentItemEntity = inventoryAdjustmentItemService.create(inventoryAdjustmentItemEntity);

			updatedInventoryAdjustmentItemEntity.setId(inventoryAdjustmentItemEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInventoryAdjustmentItemEntity.setCreated(inventoryAdjustmentItemEntity.getCreated());

			updatedInventoryAdjustmentItemEntity = inventoryAdjustmentItemService.update(updatedInventoryAdjustmentItemEntity);

			fetchedInventoryAdjustmentItemEntity = inventoryAdjustmentItemService.findById(inventoryAdjustmentItemEntity.getId());

			Assertions.assertTrue(fetchedInventoryAdjustmentItemEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInventoryAdjustmentItemEntity_ThenEntityIsCreated
			fetchedInventoryAdjustmentItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInventoryAdjustmentItemEntity, fetchedInventoryAdjustmentItemEntity.get());
		});
	}

	@Test
	public void whenDeleteInventoryAdjustmentItemEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentItemEntity inventoryAdjustmentItemEntity;
			Optional<InventoryAdjustmentItemEntity> fetchedInventoryAdjustmentItemEntity;

			try {
				inventoryAdjustmentItemEntity = inventoryAdjustmentItemFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				inventoryAdjustmentItemDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryAdjustmentItemEntity = inventoryAdjustmentItemService.create(inventoryAdjustmentItemEntity);

			inventoryAdjustmentItemService.deleteById(inventoryAdjustmentItemEntity.getId());
			fetchedInventoryAdjustmentItemEntity = inventoryAdjustmentItemService.findById(inventoryAdjustmentItemEntity.getId());

			Assertions.assertTrue(fetchedInventoryAdjustmentItemEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
