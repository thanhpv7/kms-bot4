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
import kmsweb.entities.InventoryAdjustmentEntity;
import kmsweb.repositories.InventoryAdjustmentRepository;
import kmsweb.utils.InventoryAdjustmentFactory;
import kmsweb.utils.DatabasePopulators.InventoryAdjustmentDatabasePopulator;
import kmsweb.entities.InventoryAdjustmentItemEntity;
import kmsweb.repositories.InventoryAdjustmentItemRepository;
import kmsweb.utils.InventoryAdjustmentItemFactory;
import kmsweb.utils.DatabasePopulators.InventoryAdjustmentItemDatabasePopulator;
import kmsweb.entities.TransactionDetailTypeEntity;
import kmsweb.repositories.TransactionDetailTypeRepository;
import kmsweb.utils.TransactionDetailTypeFactory;
import kmsweb.utils.DatabasePopulators.TransactionDetailTypeDatabasePopulator;
import kmsweb.entities.WarehouseEntity;
import kmsweb.repositories.WarehouseRepository;
import kmsweb.utils.WarehouseFactory;
import kmsweb.utils.DatabasePopulators.WarehouseDatabasePopulator;
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
public class InventoryAdjustmentServiceIntegrationTest {

	@Autowired
	private InventoryAdjustmentRepository inventoryAdjustmentRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InventoryAdjustmentService inventoryAdjustmentService;

	private final InventoryAdjustmentFactory inventoryAdjustmentFactory = new InventoryAdjustmentFactory();

	@Autowired
	private InventoryAdjustmentDatabasePopulator inventoryAdjustmentDatabasePopulator;

	@Autowired
	private InventoryAdjustmentItemRepository inventoryAdjustmentItemRepository;

	@Autowired
	private InventoryAdjustmentItemDatabasePopulator inventoryAdjustmentItemDatabasePopulator;

	private final InventoryAdjustmentItemFactory inventoryAdjustmentItemFactory = new InventoryAdjustmentItemFactory();

	@Autowired
	private TransactionDetailTypeRepository transactionDetailTypeRepository;

	@Autowired
	private TransactionDetailTypeDatabasePopulator transactionDetailTypeDatabasePopulator;

	private final TransactionDetailTypeFactory transactionDetailTypeFactory = new TransactionDetailTypeFactory();

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private WarehouseDatabasePopulator warehouseDatabasePopulator;

	private final WarehouseFactory warehouseFactory = new WarehouseFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		inventoryAdjustmentService = new InventoryAdjustmentService(
			inventoryAdjustmentItemRepository,
			transactionDetailTypeRepository,
			warehouseRepository,
			validator,
			auditRepository,
			inventoryAdjustmentRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInventoryAdjustmentEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InventoryAdjustmentEntity inventoryAdjustmentEntity = inventoryAdjustmentFactory.getObject(false, false);

		InventoryAdjustmentEntity updatedEntity = inventoryAdjustmentService.updateOldData(inventoryAdjustmentEntity);
		Assertions.assertEquals(inventoryAdjustmentEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingInventoryAdjustmentEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentEntity inventoryAdjustmentEntity;
			InventoryAdjustmentEntity entityWithUpdatedValues;

			try {
				inventoryAdjustmentEntity = inventoryAdjustmentFactory.getObject(false, false);
				inventoryAdjustmentDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = inventoryAdjustmentFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryAdjustmentEntity = inventoryAdjustmentService.create(inventoryAdjustmentEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(inventoryAdjustmentEntity.getId());

			InventoryAdjustmentEntity updatedEntity = inventoryAdjustmentService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInventoryAdjustmentEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InventoryAdjustmentEntity inventoryAdjustmentEntity = inventoryAdjustmentFactory.getObject(false, false);
		inventoryAdjustmentEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			inventoryAdjustmentService.updateOldData(inventoryAdjustmentEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInventoryAdjustmentEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentEntity inventoryAdjustmentEntity;
			InventoryAdjustmentEntity updatedInventoryAdjustmentEntity;

			TransactionDetailTypeEntity transactionDetailTypeEntity;

			WarehouseEntity warehouseEntity;

			Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				inventoryAdjustmentEntity = inventoryAdjustmentFactory.getObject(true, false);
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
			transactionDetailTypeEntity = inventoryAdjustmentEntity.getTransactionDetailType();
			try {
				transactionDetailTypeDatabasePopulator.populateRelatedEntitiesInDatabase(transactionDetailTypeEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			transactionDetailTypeEntity = transactionDetailTypeRepository.save(transactionDetailTypeEntity);
			inventoryAdjustmentEntity.setTransactionDetailTypeId(transactionDetailTypeEntity.getId());

			warehouseEntity = inventoryAdjustmentEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			inventoryAdjustmentEntity.setWarehouseId(warehouseEntity.getId());

			inventoryAdjustmentItemsEntities = inventoryAdjustmentEntity.getInventoryAdjustmentItems();
			Set<UUID> inventoryAdjustmentItemsEntityIds = new HashSet<>();
			for (InventoryAdjustmentItemEntity entity : inventoryAdjustmentItemsEntities) {
				try {
					inventoryAdjustmentItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				inventoryAdjustmentItemsEntityIds.add(inventoryAdjustmentItemRepository.save(entity).getId());
			}
			inventoryAdjustmentEntity.setInventoryAdjustmentItemsIds(inventoryAdjustmentItemsEntityIds);


			inventoryAdjustmentEntity = inventoryAdjustmentService.create(inventoryAdjustmentEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(inventoryAdjustmentEntity.getTransactionDetailType());
			inventoryAdjustmentEntity.setTransactionDetailTypeId(null);
			inventoryAdjustmentEntity.unsetTransactionDetailType();

			Assertions.assertNotNull(inventoryAdjustmentEntity.getWarehouse());
			inventoryAdjustmentEntity.setWarehouseId(null);
			inventoryAdjustmentEntity.unsetWarehouse();

			Assertions.assertTrue(inventoryAdjustmentEntity.getInventoryAdjustmentItems().size() > 0);
			inventoryAdjustmentEntity.setInventoryAdjustmentItemsIds(new HashSet<UUID>());
			inventoryAdjustmentEntity.unsetInventoryAdjustmentItems();


			updatedInventoryAdjustmentEntity = inventoryAdjustmentService.updateOldData(inventoryAdjustmentEntity);

			Assertions.assertNull(updatedInventoryAdjustmentEntity.getTransactionDetailType());

			Assertions.assertNull(updatedInventoryAdjustmentEntity.getWarehouse());

			Assertions.assertEquals(0, updatedInventoryAdjustmentEntity.getInventoryAdjustmentItems().size());

		});
	}

	@Test
	public void updateOldDataWithInventoryAdjustmentEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentEntity inventoryAdjustmentEntity;
			InventoryAdjustmentEntity updatedInventoryAdjustmentEntity;

			TransactionDetailTypeEntity transactionDetailTypeEntity;

			WarehouseEntity warehouseEntity;

			Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItemsEntities;
			Set<UUID> inventoryAdjustmentItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				inventoryAdjustmentEntity = inventoryAdjustmentFactory.getObject(true, false);
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
				transactionDetailTypeDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentEntity.getTransactionDetailType(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Transaction Detail Type relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			transactionDetailTypeEntity = transactionDetailTypeRepository.findById(transactionDetailTypeRepository.save(inventoryAdjustmentEntity.getTransactionDetailType()).getId()).get();
			inventoryAdjustmentEntity.unsetTransactionDetailType();
			inventoryAdjustmentEntity.setTransactionDetailTypeId(transactionDetailTypeEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(inventoryAdjustmentEntity.getWarehouse()).getId()).get();
			inventoryAdjustmentEntity.unsetWarehouse();
			inventoryAdjustmentEntity.setWarehouseId(warehouseEntity.getId());

			inventoryAdjustmentItemsEntities = new HashSet<>();
			inventoryAdjustmentItemsEntityIds = new HashSet<>();
			for (InventoryAdjustmentItemEntity entity : inventoryAdjustmentEntity.getInventoryAdjustmentItems()) {
				try {
					inventoryAdjustmentItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Inventory Adjustment Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = inventoryAdjustmentItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				inventoryAdjustmentItemsEntities.add(inventoryAdjustmentItemRepository.findById(id).get());
				inventoryAdjustmentItemsEntityIds.add(id);
			}
			inventoryAdjustmentEntity.unsetInventoryAdjustmentItems();
			inventoryAdjustmentEntity.setInventoryAdjustmentItemsIds(inventoryAdjustmentItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInventoryAdjustmentEntity = inventoryAdjustmentService.updateOldData(inventoryAdjustmentEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			transactionDetailTypeEntity.unsetInventoryAdjustments(false);
			updatedInventoryAdjustmentEntity.getTransactionDetailType().unsetInventoryAdjustments(false);
			Assertions.assertEquals(transactionDetailTypeEntity, updatedInventoryAdjustmentEntity.getTransactionDetailType());

			warehouseEntity.unsetInventoryAdjustments(false);
			updatedInventoryAdjustmentEntity.getWarehouse().unsetInventoryAdjustments(false);
			Assertions.assertEquals(warehouseEntity, updatedInventoryAdjustmentEntity.getWarehouse());

			Assertions.assertEquals(inventoryAdjustmentItemsEntities.size(), updatedInventoryAdjustmentEntity.getInventoryAdjustmentItems().size());

		});
	}

	@Test
	public void whenCreateInventoryAdjustmentEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentEntity inventoryAdjustmentEntity;
			Optional<InventoryAdjustmentEntity> fetchedInventoryAdjustmentEntity;

			try {
				inventoryAdjustmentEntity = inventoryAdjustmentFactory.getObject(false, false);
				inventoryAdjustmentDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryAdjustmentEntity = inventoryAdjustmentService.create(inventoryAdjustmentEntity);

			fetchedInventoryAdjustmentEntity = inventoryAdjustmentService.findById(inventoryAdjustmentEntity.getId());

			Assertions.assertTrue(fetchedInventoryAdjustmentEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInventoryAdjustmentEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(inventoryAdjustmentEntity, fetchedInventoryAdjustmentEntity.get());
		});
	}

	@Test
	public void whenUpdateInventoryAdjustmentEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentEntity inventoryAdjustmentEntity;
			InventoryAdjustmentEntity updatedInventoryAdjustmentEntity;
			Optional<InventoryAdjustmentEntity> fetchedInventoryAdjustmentEntity;

			try {
				inventoryAdjustmentEntity = inventoryAdjustmentFactory.getObject(false, false);
				inventoryAdjustmentDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentEntity, true, true, false);
				updatedInventoryAdjustmentEntity = inventoryAdjustmentFactory.getObject(false, false);
				inventoryAdjustmentDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInventoryAdjustmentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryAdjustmentEntity = inventoryAdjustmentService.create(inventoryAdjustmentEntity);

			updatedInventoryAdjustmentEntity.setId(inventoryAdjustmentEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInventoryAdjustmentEntity.setCreated(inventoryAdjustmentEntity.getCreated());

			updatedInventoryAdjustmentEntity = inventoryAdjustmentService.update(updatedInventoryAdjustmentEntity);

			fetchedInventoryAdjustmentEntity = inventoryAdjustmentService.findById(inventoryAdjustmentEntity.getId());

			Assertions.assertTrue(fetchedInventoryAdjustmentEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInventoryAdjustmentEntity_ThenEntityIsCreated
			fetchedInventoryAdjustmentEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInventoryAdjustmentEntity, fetchedInventoryAdjustmentEntity.get());
		});
	}

	@Test
	public void whenDeleteInventoryAdjustmentEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryAdjustmentEntity inventoryAdjustmentEntity;
			Optional<InventoryAdjustmentEntity> fetchedInventoryAdjustmentEntity;

			try {
				inventoryAdjustmentEntity = inventoryAdjustmentFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				inventoryAdjustmentDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryAdjustmentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryAdjustmentEntity = inventoryAdjustmentService.create(inventoryAdjustmentEntity);

			inventoryAdjustmentService.deleteById(inventoryAdjustmentEntity.getId());
			fetchedInventoryAdjustmentEntity = inventoryAdjustmentService.findById(inventoryAdjustmentEntity.getId());

			Assertions.assertTrue(fetchedInventoryAdjustmentEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
