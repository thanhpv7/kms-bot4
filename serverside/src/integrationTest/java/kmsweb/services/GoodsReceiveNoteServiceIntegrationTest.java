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
import kmsweb.entities.GoodsReceiveNoteEntity;
import kmsweb.repositories.GoodsReceiveNoteRepository;
import kmsweb.utils.GoodsReceiveNoteFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteDatabasePopulator;
import kmsweb.entities.GoodsReceiveNoteItemEntity;
import kmsweb.repositories.GoodsReceiveNoteItemRepository;
import kmsweb.utils.GoodsReceiveNoteItemFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteItemDatabasePopulator;
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.utils.PurchaseOrderFactory;
import kmsweb.utils.DatabasePopulators.PurchaseOrderDatabasePopulator;
import kmsweb.entities.SupplierEntity;
import kmsweb.repositories.SupplierRepository;
import kmsweb.utils.SupplierFactory;
import kmsweb.utils.DatabasePopulators.SupplierDatabasePopulator;
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
public class GoodsReceiveNoteServiceIntegrationTest {

	@Autowired
	private GoodsReceiveNoteRepository goodsReceiveNoteRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private GoodsReceiveNoteService goodsReceiveNoteService;

	private final GoodsReceiveNoteFactory goodsReceiveNoteFactory = new GoodsReceiveNoteFactory();

	@Autowired
	private GoodsReceiveNoteDatabasePopulator goodsReceiveNoteDatabasePopulator;

	@Autowired
	private GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository;

	@Autowired
	private GoodsReceiveNoteItemDatabasePopulator goodsReceiveNoteItemDatabasePopulator;

	private final GoodsReceiveNoteItemFactory goodsReceiveNoteItemFactory = new GoodsReceiveNoteItemFactory();

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private PurchaseOrderDatabasePopulator purchaseOrderDatabasePopulator;

	private final PurchaseOrderFactory purchaseOrderFactory = new PurchaseOrderFactory();

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private SupplierDatabasePopulator supplierDatabasePopulator;

	private final SupplierFactory supplierFactory = new SupplierFactory();

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
		goodsReceiveNoteService = new GoodsReceiveNoteService(
			goodsReceiveNoteItemRepository,
			purchaseOrderRepository,
			supplierRepository,
			warehouseRepository,
			validator,
			auditRepository,
			goodsReceiveNoteRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewGoodsReceiveNoteEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		GoodsReceiveNoteEntity goodsReceiveNoteEntity = goodsReceiveNoteFactory.getObject(false, false);

		GoodsReceiveNoteEntity updatedEntity = goodsReceiveNoteService.updateOldData(goodsReceiveNoteEntity);
		Assertions.assertEquals(goodsReceiveNoteEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingGoodsReceiveNoteEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteEntity goodsReceiveNoteEntity;
			GoodsReceiveNoteEntity entityWithUpdatedValues;

			try {
				goodsReceiveNoteEntity = goodsReceiveNoteFactory.getObject(false, false);
				goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = goodsReceiveNoteFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteEntity = goodsReceiveNoteService.create(goodsReceiveNoteEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(goodsReceiveNoteEntity.getId());

			GoodsReceiveNoteEntity updatedEntity = goodsReceiveNoteService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithGoodsReceiveNoteEntityWithNonExistentId_ShouldThrowException() throws Exception {
		GoodsReceiveNoteEntity goodsReceiveNoteEntity = goodsReceiveNoteFactory.getObject(false, false);
		goodsReceiveNoteEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			goodsReceiveNoteService.updateOldData(goodsReceiveNoteEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingGoodsReceiveNoteEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteEntity goodsReceiveNoteEntity;
			GoodsReceiveNoteEntity updatedGoodsReceiveNoteEntity;

			SupplierEntity supplierEntity;

			WarehouseEntity warehouseEntity;

			Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemsEntities;

			Set<PurchaseOrderEntity> purchaseOrdersEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				goodsReceiveNoteEntity = goodsReceiveNoteFactory.getObject(true, false);
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
			supplierEntity = goodsReceiveNoteEntity.getSupplier();
			try {
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(supplierEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			supplierEntity = supplierRepository.save(supplierEntity);
			goodsReceiveNoteEntity.setSupplierId(supplierEntity.getId());

			warehouseEntity = goodsReceiveNoteEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			goodsReceiveNoteEntity.setWarehouseId(warehouseEntity.getId());

			goodsReceiveNoteItemsEntities = goodsReceiveNoteEntity.getGoodsReceiveNoteItems();
			Set<UUID> goodsReceiveNoteItemsEntityIds = new HashSet<>();
			for (GoodsReceiveNoteItemEntity entity : goodsReceiveNoteItemsEntities) {
				try {
					goodsReceiveNoteItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				goodsReceiveNoteItemsEntityIds.add(goodsReceiveNoteItemRepository.save(entity).getId());
			}
			goodsReceiveNoteEntity.setGoodsReceiveNoteItemsIds(goodsReceiveNoteItemsEntityIds);

			purchaseOrdersEntities = goodsReceiveNoteEntity.getPurchaseOrders();
			Set<UUID> purchaseOrdersEntityIds = new HashSet<>();
			for (PurchaseOrderEntity entity : purchaseOrdersEntities) {
				try {
					purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				purchaseOrdersEntityIds.add(purchaseOrderRepository.save(entity).getId());
			}
			goodsReceiveNoteEntity.setPurchaseOrdersIds(purchaseOrdersEntityIds);


			goodsReceiveNoteEntity = goodsReceiveNoteService.create(goodsReceiveNoteEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(goodsReceiveNoteEntity.getSupplier());
			goodsReceiveNoteEntity.setSupplierId(null);
			goodsReceiveNoteEntity.unsetSupplier();

			Assertions.assertNotNull(goodsReceiveNoteEntity.getWarehouse());
			goodsReceiveNoteEntity.setWarehouseId(null);
			goodsReceiveNoteEntity.unsetWarehouse();

			Assertions.assertTrue(goodsReceiveNoteEntity.getGoodsReceiveNoteItems().size() > 0);
			goodsReceiveNoteEntity.setGoodsReceiveNoteItemsIds(new HashSet<UUID>());
			goodsReceiveNoteEntity.unsetGoodsReceiveNoteItems();

			Assertions.assertTrue(goodsReceiveNoteEntity.getPurchaseOrders().size() > 0);
			goodsReceiveNoteEntity.setPurchaseOrdersIds(new HashSet<UUID>());
			goodsReceiveNoteEntity.unsetPurchaseOrders();


			updatedGoodsReceiveNoteEntity = goodsReceiveNoteService.updateOldData(goodsReceiveNoteEntity);

			Assertions.assertNull(updatedGoodsReceiveNoteEntity.getSupplier());

			Assertions.assertNull(updatedGoodsReceiveNoteEntity.getWarehouse());

			Assertions.assertEquals(0, updatedGoodsReceiveNoteEntity.getGoodsReceiveNoteItems().size());

			Assertions.assertEquals(0, updatedGoodsReceiveNoteEntity.getPurchaseOrders().size());

		});
	}

	@Test
	public void updateOldDataWithGoodsReceiveNoteEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteEntity goodsReceiveNoteEntity;
			GoodsReceiveNoteEntity updatedGoodsReceiveNoteEntity;

			SupplierEntity supplierEntity;

			WarehouseEntity warehouseEntity;

			Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemsEntities;
			Set<UUID> goodsReceiveNoteItemsEntityIds;

			Set<PurchaseOrderEntity> purchaseOrdersEntities;
			Set<UUID> purchaseOrdersEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				goodsReceiveNoteEntity = goodsReceiveNoteFactory.getObject(true, false);
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
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteEntity.getSupplier(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Supplier relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			supplierEntity = supplierRepository.findById(supplierRepository.save(goodsReceiveNoteEntity.getSupplier()).getId()).get();
			goodsReceiveNoteEntity.unsetSupplier();
			goodsReceiveNoteEntity.setSupplierId(supplierEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(goodsReceiveNoteEntity.getWarehouse()).getId()).get();
			goodsReceiveNoteEntity.unsetWarehouse();
			goodsReceiveNoteEntity.setWarehouseId(warehouseEntity.getId());

			goodsReceiveNoteItemsEntities = new HashSet<>();
			goodsReceiveNoteItemsEntityIds = new HashSet<>();
			for (GoodsReceiveNoteItemEntity entity : goodsReceiveNoteEntity.getGoodsReceiveNoteItems()) {
				try {
					goodsReceiveNoteItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Goods Receive Note Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = goodsReceiveNoteItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				goodsReceiveNoteItemsEntities.add(goodsReceiveNoteItemRepository.findById(id).get());
				goodsReceiveNoteItemsEntityIds.add(id);
			}
			goodsReceiveNoteEntity.unsetGoodsReceiveNoteItems();
			goodsReceiveNoteEntity.setGoodsReceiveNoteItemsIds(goodsReceiveNoteItemsEntityIds);

			purchaseOrdersEntities = new HashSet<>();
			purchaseOrdersEntityIds = new HashSet<>();
			for (PurchaseOrderEntity entity : goodsReceiveNoteEntity.getPurchaseOrders()) {
				try {
					purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Purchase Orders relation for this test: " + e.getCause());
					return;
				}
				UUID id = purchaseOrderRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				purchaseOrdersEntities.add(purchaseOrderRepository.findById(id).get());
				purchaseOrdersEntityIds.add(id);
			}
			goodsReceiveNoteEntity.unsetPurchaseOrders();
			goodsReceiveNoteEntity.setPurchaseOrdersIds(purchaseOrdersEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedGoodsReceiveNoteEntity = goodsReceiveNoteService.updateOldData(goodsReceiveNoteEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			supplierEntity.unsetGoodsReceiveNotes(false);
			updatedGoodsReceiveNoteEntity.getSupplier().unsetGoodsReceiveNotes(false);
			Assertions.assertEquals(supplierEntity, updatedGoodsReceiveNoteEntity.getSupplier());

			warehouseEntity.unsetGoodsReceiveNotes(false);
			updatedGoodsReceiveNoteEntity.getWarehouse().unsetGoodsReceiveNotes(false);
			Assertions.assertEquals(warehouseEntity, updatedGoodsReceiveNoteEntity.getWarehouse());

			Assertions.assertEquals(goodsReceiveNoteItemsEntities.size(), updatedGoodsReceiveNoteEntity.getGoodsReceiveNoteItems().size());

			Assertions.assertEquals(purchaseOrdersEntities.size(), updatedGoodsReceiveNoteEntity.getPurchaseOrders().size());

		});
	}

	@Test
	public void whenCreateGoodsReceiveNoteEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteEntity goodsReceiveNoteEntity;
			Optional<GoodsReceiveNoteEntity> fetchedGoodsReceiveNoteEntity;

			try {
				goodsReceiveNoteEntity = goodsReceiveNoteFactory.getObject(false, false);
				goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteEntity = goodsReceiveNoteService.create(goodsReceiveNoteEntity);

			fetchedGoodsReceiveNoteEntity = goodsReceiveNoteService.findById(goodsReceiveNoteEntity.getId());

			Assertions.assertTrue(fetchedGoodsReceiveNoteEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedGoodsReceiveNoteEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(goodsReceiveNoteEntity, fetchedGoodsReceiveNoteEntity.get());
		});
	}

	@Test
	public void whenUpdateGoodsReceiveNoteEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteEntity goodsReceiveNoteEntity;
			GoodsReceiveNoteEntity updatedGoodsReceiveNoteEntity;
			Optional<GoodsReceiveNoteEntity> fetchedGoodsReceiveNoteEntity;

			try {
				goodsReceiveNoteEntity = goodsReceiveNoteFactory.getObject(false, false);
				goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteEntity, true, true, false);
				updatedGoodsReceiveNoteEntity = goodsReceiveNoteFactory.getObject(false, false);
				goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(updatedGoodsReceiveNoteEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteEntity = goodsReceiveNoteService.create(goodsReceiveNoteEntity);

			updatedGoodsReceiveNoteEntity.setId(goodsReceiveNoteEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedGoodsReceiveNoteEntity.setCreated(goodsReceiveNoteEntity.getCreated());

			updatedGoodsReceiveNoteEntity = goodsReceiveNoteService.update(updatedGoodsReceiveNoteEntity);

			fetchedGoodsReceiveNoteEntity = goodsReceiveNoteService.findById(goodsReceiveNoteEntity.getId());

			Assertions.assertTrue(fetchedGoodsReceiveNoteEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateGoodsReceiveNoteEntity_ThenEntityIsCreated
			fetchedGoodsReceiveNoteEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedGoodsReceiveNoteEntity, fetchedGoodsReceiveNoteEntity.get());
		});
	}

	@Test
	public void whenDeleteGoodsReceiveNoteEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteEntity goodsReceiveNoteEntity;
			Optional<GoodsReceiveNoteEntity> fetchedGoodsReceiveNoteEntity;

			try {
				goodsReceiveNoteEntity = goodsReceiveNoteFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteEntity = goodsReceiveNoteService.create(goodsReceiveNoteEntity);

			goodsReceiveNoteService.deleteById(goodsReceiveNoteEntity.getId());
			fetchedGoodsReceiveNoteEntity = goodsReceiveNoteService.findById(goodsReceiveNoteEntity.getId());

			Assertions.assertTrue(fetchedGoodsReceiveNoteEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
