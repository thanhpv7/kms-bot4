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
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.utils.PurchaseOrderFactory;
import kmsweb.utils.DatabasePopulators.PurchaseOrderDatabasePopulator;
import kmsweb.entities.GoodsReceiveNoteEntity;
import kmsweb.repositories.GoodsReceiveNoteRepository;
import kmsweb.utils.GoodsReceiveNoteFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteDatabasePopulator;
import kmsweb.entities.PurchaseOrderStockDetailEntity;
import kmsweb.repositories.PurchaseOrderStockDetailRepository;
import kmsweb.utils.PurchaseOrderStockDetailFactory;
import kmsweb.utils.DatabasePopulators.PurchaseOrderStockDetailDatabasePopulator;
import kmsweb.entities.PurchaseRequisitionEntity;
import kmsweb.repositories.PurchaseRequisitionRepository;
import kmsweb.utils.PurchaseRequisitionFactory;
import kmsweb.utils.DatabasePopulators.PurchaseRequisitionDatabasePopulator;
import kmsweb.entities.ReturnSupplierEntity;
import kmsweb.repositories.ReturnSupplierRepository;
import kmsweb.utils.ReturnSupplierFactory;
import kmsweb.utils.DatabasePopulators.ReturnSupplierDatabasePopulator;
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
public class PurchaseOrderServiceIntegrationTest {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PurchaseOrderService purchaseOrderService;

	private final PurchaseOrderFactory purchaseOrderFactory = new PurchaseOrderFactory();

	@Autowired
	private PurchaseOrderDatabasePopulator purchaseOrderDatabasePopulator;

	@Autowired
	private GoodsReceiveNoteRepository goodsReceiveNoteRepository;

	@Autowired
	private GoodsReceiveNoteDatabasePopulator goodsReceiveNoteDatabasePopulator;

	private final GoodsReceiveNoteFactory goodsReceiveNoteFactory = new GoodsReceiveNoteFactory();

	@Autowired
	private PurchaseOrderStockDetailRepository purchaseOrderStockDetailRepository;

	@Autowired
	private PurchaseOrderStockDetailDatabasePopulator purchaseOrderStockDetailDatabasePopulator;

	private final PurchaseOrderStockDetailFactory purchaseOrderStockDetailFactory = new PurchaseOrderStockDetailFactory();

	@Autowired
	private PurchaseRequisitionRepository purchaseRequisitionRepository;

	@Autowired
	private PurchaseRequisitionDatabasePopulator purchaseRequisitionDatabasePopulator;

	private final PurchaseRequisitionFactory purchaseRequisitionFactory = new PurchaseRequisitionFactory();

	@Autowired
	private ReturnSupplierRepository returnSupplierRepository;

	@Autowired
	private ReturnSupplierDatabasePopulator returnSupplierDatabasePopulator;

	private final ReturnSupplierFactory returnSupplierFactory = new ReturnSupplierFactory();

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
		purchaseOrderService = new PurchaseOrderService(
			goodsReceiveNoteRepository,
			purchaseOrderStockDetailRepository,
			purchaseRequisitionRepository,
			returnSupplierRepository,
			supplierRepository,
			warehouseRepository,
			validator,
			auditRepository,
			purchaseOrderRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPurchaseOrderEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PurchaseOrderEntity purchaseOrderEntity = purchaseOrderFactory.getObject(false, false);

		PurchaseOrderEntity updatedEntity = purchaseOrderService.updateOldData(purchaseOrderEntity);
		Assertions.assertEquals(purchaseOrderEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewPurchaseOrderEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		PurchaseOrderEntity purchaseOrderEntity = purchaseOrderFactory.getObject(false, false);

		purchaseOrderEntity.setPriceVATIncluded(null);
		Assertions.assertNull(purchaseOrderEntity.getPriceVATIncluded());

		purchaseOrderEntity.setInventoryVATIncluded(null);
		Assertions.assertNull(purchaseOrderEntity.getInventoryVATIncluded());

		purchaseOrderEntity.setExtraDiscountInPercent(null);
		Assertions.assertNull(purchaseOrderEntity.getExtraDiscountInPercent());

		purchaseOrderEntity.setExtraDiscountIncludeTax(null);
		Assertions.assertNull(purchaseOrderEntity.getExtraDiscountIncludeTax());

		purchaseOrderEntity.setFreightFeeIncludeTax(null);
		Assertions.assertNull(purchaseOrderEntity.getFreightFeeIncludeTax());

		purchaseOrderEntity.setOtherFeeIncludeTax(null);
		Assertions.assertNull(purchaseOrderEntity.getOtherFeeIncludeTax());


		PurchaseOrderEntity updatedEntity = purchaseOrderService.updateOldData(purchaseOrderEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getPriceVATIncluded());
		Assertions.assertFalse(updatedEntity.getPriceVATIncluded());

		Assertions.assertNotNull(updatedEntity.getInventoryVATIncluded());
		Assertions.assertFalse(updatedEntity.getInventoryVATIncluded());

		Assertions.assertNotNull(updatedEntity.getExtraDiscountInPercent());
		Assertions.assertFalse(updatedEntity.getExtraDiscountInPercent());

		Assertions.assertNotNull(updatedEntity.getExtraDiscountIncludeTax());
		Assertions.assertFalse(updatedEntity.getExtraDiscountIncludeTax());

		Assertions.assertNotNull(updatedEntity.getFreightFeeIncludeTax());
		Assertions.assertFalse(updatedEntity.getFreightFeeIncludeTax());

		Assertions.assertNotNull(updatedEntity.getOtherFeeIncludeTax());
		Assertions.assertFalse(updatedEntity.getOtherFeeIncludeTax());

	}

	@Test
	public void updateOldDataWithExistingPurchaseOrderEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderEntity purchaseOrderEntity;
			PurchaseOrderEntity entityWithUpdatedValues;

			try {
				purchaseOrderEntity = purchaseOrderFactory.getObject(false, false);
				purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = purchaseOrderFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseOrderEntity = purchaseOrderService.create(purchaseOrderEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(purchaseOrderEntity.getId());

			PurchaseOrderEntity updatedEntity = purchaseOrderService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPurchaseOrderEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PurchaseOrderEntity purchaseOrderEntity = purchaseOrderFactory.getObject(false, false);
		purchaseOrderEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			purchaseOrderService.updateOldData(purchaseOrderEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPurchaseOrderEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderEntity purchaseOrderEntity;
			PurchaseOrderEntity updatedPurchaseOrderEntity;

			GoodsReceiveNoteEntity goodsReceiveNoteEntity;

			SupplierEntity supplierEntity;

			WarehouseEntity warehouseEntity;

			Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetailsEntities;

			Set<PurchaseRequisitionEntity> purchaseRequisitionsEntities;

			Set<ReturnSupplierEntity> returnSuppliersEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				purchaseOrderEntity = purchaseOrderFactory.getObject(true, false);
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
			goodsReceiveNoteEntity = purchaseOrderEntity.getGoodsReceiveNote();
			try {
				goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			goodsReceiveNoteEntity = goodsReceiveNoteRepository.save(goodsReceiveNoteEntity);
			purchaseOrderEntity.setGoodsReceiveNoteId(goodsReceiveNoteEntity.getId());

			supplierEntity = purchaseOrderEntity.getSupplier();
			try {
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(supplierEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			supplierEntity = supplierRepository.save(supplierEntity);
			purchaseOrderEntity.setSupplierId(supplierEntity.getId());

			warehouseEntity = purchaseOrderEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			purchaseOrderEntity.setWarehouseId(warehouseEntity.getId());

			purchaseOrderStockDetailsEntities = purchaseOrderEntity.getPurchaseOrderStockDetails();
			Set<UUID> purchaseOrderStockDetailsEntityIds = new HashSet<>();
			for (PurchaseOrderStockDetailEntity entity : purchaseOrderStockDetailsEntities) {
				try {
					purchaseOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				purchaseOrderStockDetailsEntityIds.add(purchaseOrderStockDetailRepository.save(entity).getId());
			}
			purchaseOrderEntity.setPurchaseOrderStockDetailsIds(purchaseOrderStockDetailsEntityIds);

			purchaseRequisitionsEntities = purchaseOrderEntity.getPurchaseRequisitions();
			Set<UUID> purchaseRequisitionsEntityIds = new HashSet<>();
			for (PurchaseRequisitionEntity entity : purchaseRequisitionsEntities) {
				try {
					purchaseRequisitionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				purchaseRequisitionsEntityIds.add(purchaseRequisitionRepository.save(entity).getId());
			}
			purchaseOrderEntity.setPurchaseRequisitionsIds(purchaseRequisitionsEntityIds);

			returnSuppliersEntities = purchaseOrderEntity.getReturnSuppliers();
			Set<UUID> returnSuppliersEntityIds = new HashSet<>();
			for (ReturnSupplierEntity entity : returnSuppliersEntities) {
				try {
					returnSupplierDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				returnSuppliersEntityIds.add(returnSupplierRepository.save(entity).getId());
			}
			purchaseOrderEntity.setReturnSuppliersIds(returnSuppliersEntityIds);


			purchaseOrderEntity = purchaseOrderService.create(purchaseOrderEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(purchaseOrderEntity.getGoodsReceiveNote());
			purchaseOrderEntity.setGoodsReceiveNoteId(null);
			purchaseOrderEntity.unsetGoodsReceiveNote();

			Assertions.assertNotNull(purchaseOrderEntity.getSupplier());
			purchaseOrderEntity.setSupplierId(null);
			purchaseOrderEntity.unsetSupplier();

			Assertions.assertNotNull(purchaseOrderEntity.getWarehouse());
			purchaseOrderEntity.setWarehouseId(null);
			purchaseOrderEntity.unsetWarehouse();

			Assertions.assertTrue(purchaseOrderEntity.getPurchaseOrderStockDetails().size() > 0);
			purchaseOrderEntity.setPurchaseOrderStockDetailsIds(new HashSet<UUID>());
			purchaseOrderEntity.unsetPurchaseOrderStockDetails();

			Assertions.assertTrue(purchaseOrderEntity.getPurchaseRequisitions().size() > 0);
			purchaseOrderEntity.setPurchaseRequisitionsIds(new HashSet<UUID>());
			purchaseOrderEntity.unsetPurchaseRequisitions();

			Assertions.assertTrue(purchaseOrderEntity.getReturnSuppliers().size() > 0);
			purchaseOrderEntity.setReturnSuppliersIds(new HashSet<UUID>());
			purchaseOrderEntity.unsetReturnSuppliers();


			updatedPurchaseOrderEntity = purchaseOrderService.updateOldData(purchaseOrderEntity);

			Assertions.assertNull(updatedPurchaseOrderEntity.getGoodsReceiveNote());

			Assertions.assertNull(updatedPurchaseOrderEntity.getSupplier());

			Assertions.assertNull(updatedPurchaseOrderEntity.getWarehouse());

			Assertions.assertEquals(0, updatedPurchaseOrderEntity.getPurchaseOrderStockDetails().size());

			Assertions.assertEquals(0, updatedPurchaseOrderEntity.getPurchaseRequisitions().size());

			Assertions.assertEquals(0, updatedPurchaseOrderEntity.getReturnSuppliers().size());

		});
	}

	@Test
	public void updateOldDataWithPurchaseOrderEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderEntity purchaseOrderEntity;
			PurchaseOrderEntity updatedPurchaseOrderEntity;

			GoodsReceiveNoteEntity goodsReceiveNoteEntity;

			SupplierEntity supplierEntity;

			WarehouseEntity warehouseEntity;

			Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetailsEntities;
			Set<UUID> purchaseOrderStockDetailsEntityIds;

			Set<PurchaseRequisitionEntity> purchaseRequisitionsEntities;
			Set<UUID> purchaseRequisitionsEntityIds;

			Set<ReturnSupplierEntity> returnSuppliersEntities;
			Set<UUID> returnSuppliersEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				purchaseOrderEntity = purchaseOrderFactory.getObject(true, false);
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
				goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderEntity.getGoodsReceiveNote(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Goods Receive Note relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			goodsReceiveNoteEntity = goodsReceiveNoteRepository.findById(goodsReceiveNoteRepository.save(purchaseOrderEntity.getGoodsReceiveNote()).getId()).get();
			purchaseOrderEntity.unsetGoodsReceiveNote();
			purchaseOrderEntity.setGoodsReceiveNoteId(goodsReceiveNoteEntity.getId());

			try {
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderEntity.getSupplier(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Supplier relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			supplierEntity = supplierRepository.findById(supplierRepository.save(purchaseOrderEntity.getSupplier()).getId()).get();
			purchaseOrderEntity.unsetSupplier();
			purchaseOrderEntity.setSupplierId(supplierEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(purchaseOrderEntity.getWarehouse()).getId()).get();
			purchaseOrderEntity.unsetWarehouse();
			purchaseOrderEntity.setWarehouseId(warehouseEntity.getId());

			purchaseOrderStockDetailsEntities = new HashSet<>();
			purchaseOrderStockDetailsEntityIds = new HashSet<>();
			for (PurchaseOrderStockDetailEntity entity : purchaseOrderEntity.getPurchaseOrderStockDetails()) {
				try {
					purchaseOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Purchase Order Stock Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = purchaseOrderStockDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				purchaseOrderStockDetailsEntities.add(purchaseOrderStockDetailRepository.findById(id).get());
				purchaseOrderStockDetailsEntityIds.add(id);
			}
			purchaseOrderEntity.unsetPurchaseOrderStockDetails();
			purchaseOrderEntity.setPurchaseOrderStockDetailsIds(purchaseOrderStockDetailsEntityIds);

			purchaseRequisitionsEntities = new HashSet<>();
			purchaseRequisitionsEntityIds = new HashSet<>();
			for (PurchaseRequisitionEntity entity : purchaseOrderEntity.getPurchaseRequisitions()) {
				try {
					purchaseRequisitionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Purchase Requisitions relation for this test: " + e.getCause());
					return;
				}
				UUID id = purchaseRequisitionRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				purchaseRequisitionsEntities.add(purchaseRequisitionRepository.findById(id).get());
				purchaseRequisitionsEntityIds.add(id);
			}
			purchaseOrderEntity.unsetPurchaseRequisitions();
			purchaseOrderEntity.setPurchaseRequisitionsIds(purchaseRequisitionsEntityIds);

			returnSuppliersEntities = new HashSet<>();
			returnSuppliersEntityIds = new HashSet<>();
			for (ReturnSupplierEntity entity : purchaseOrderEntity.getReturnSuppliers()) {
				try {
					returnSupplierDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Return Suppliers relation for this test: " + e.getCause());
					return;
				}
				UUID id = returnSupplierRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				returnSuppliersEntities.add(returnSupplierRepository.findById(id).get());
				returnSuppliersEntityIds.add(id);
			}
			purchaseOrderEntity.unsetReturnSuppliers();
			purchaseOrderEntity.setReturnSuppliersIds(returnSuppliersEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPurchaseOrderEntity = purchaseOrderService.updateOldData(purchaseOrderEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			goodsReceiveNoteEntity.unsetPurchaseOrders(false);
			updatedPurchaseOrderEntity.getGoodsReceiveNote().unsetPurchaseOrders(false);
			Assertions.assertEquals(goodsReceiveNoteEntity, updatedPurchaseOrderEntity.getGoodsReceiveNote());

			supplierEntity.unsetPurchaseOrders(false);
			updatedPurchaseOrderEntity.getSupplier().unsetPurchaseOrders(false);
			Assertions.assertEquals(supplierEntity, updatedPurchaseOrderEntity.getSupplier());

			warehouseEntity.unsetPurchaseOrders(false);
			updatedPurchaseOrderEntity.getWarehouse().unsetPurchaseOrders(false);
			Assertions.assertEquals(warehouseEntity, updatedPurchaseOrderEntity.getWarehouse());

			Assertions.assertEquals(purchaseOrderStockDetailsEntities.size(), updatedPurchaseOrderEntity.getPurchaseOrderStockDetails().size());

			Assertions.assertEquals(purchaseRequisitionsEntities.size(), updatedPurchaseOrderEntity.getPurchaseRequisitions().size());

			Assertions.assertEquals(returnSuppliersEntities.size(), updatedPurchaseOrderEntity.getReturnSuppliers().size());

		});
	}

	@Test
	public void whenCreatePurchaseOrderEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderEntity purchaseOrderEntity;
			Optional<PurchaseOrderEntity> fetchedPurchaseOrderEntity;

			try {
				purchaseOrderEntity = purchaseOrderFactory.getObject(false, false);
				purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseOrderEntity = purchaseOrderService.create(purchaseOrderEntity);

			fetchedPurchaseOrderEntity = purchaseOrderService.findById(purchaseOrderEntity.getId());

			Assertions.assertTrue(fetchedPurchaseOrderEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPurchaseOrderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(purchaseOrderEntity, fetchedPurchaseOrderEntity.get());
		});
	}

	@Test
	public void whenUpdatePurchaseOrderEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderEntity purchaseOrderEntity;
			PurchaseOrderEntity updatedPurchaseOrderEntity;
			Optional<PurchaseOrderEntity> fetchedPurchaseOrderEntity;

			try {
				purchaseOrderEntity = purchaseOrderFactory.getObject(false, false);
				purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderEntity, true, true, false);
				updatedPurchaseOrderEntity = purchaseOrderFactory.getObject(false, false);
				purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPurchaseOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseOrderEntity = purchaseOrderService.create(purchaseOrderEntity);

			updatedPurchaseOrderEntity.setId(purchaseOrderEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPurchaseOrderEntity.setCreated(purchaseOrderEntity.getCreated());

			updatedPurchaseOrderEntity = purchaseOrderService.update(updatedPurchaseOrderEntity);

			fetchedPurchaseOrderEntity = purchaseOrderService.findById(purchaseOrderEntity.getId());

			Assertions.assertTrue(fetchedPurchaseOrderEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePurchaseOrderEntity_ThenEntityIsCreated
			fetchedPurchaseOrderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPurchaseOrderEntity, fetchedPurchaseOrderEntity.get());
		});
	}

	@Test
	public void whenDeletePurchaseOrderEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderEntity purchaseOrderEntity;
			Optional<PurchaseOrderEntity> fetchedPurchaseOrderEntity;

			try {
				purchaseOrderEntity = purchaseOrderFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseOrderEntity = purchaseOrderService.create(purchaseOrderEntity);

			purchaseOrderService.deleteById(purchaseOrderEntity.getId());
			fetchedPurchaseOrderEntity = purchaseOrderService.findById(purchaseOrderEntity.getId());

			Assertions.assertTrue(fetchedPurchaseOrderEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
