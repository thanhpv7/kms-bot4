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
import kmsweb.entities.ReturnSupplierEntity;
import kmsweb.repositories.ReturnSupplierRepository;
import kmsweb.utils.ReturnSupplierFactory;
import kmsweb.utils.DatabasePopulators.ReturnSupplierDatabasePopulator;
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.utils.PurchaseOrderFactory;
import kmsweb.utils.DatabasePopulators.PurchaseOrderDatabasePopulator;
import kmsweb.entities.ReturnSupplierStockDetailEntity;
import kmsweb.repositories.ReturnSupplierStockDetailRepository;
import kmsweb.utils.ReturnSupplierStockDetailFactory;
import kmsweb.utils.DatabasePopulators.ReturnSupplierStockDetailDatabasePopulator;
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
public class ReturnSupplierServiceIntegrationTest {

	@Autowired
	private ReturnSupplierRepository returnSupplierRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private ReturnSupplierService returnSupplierService;

	private final ReturnSupplierFactory returnSupplierFactory = new ReturnSupplierFactory();

	@Autowired
	private ReturnSupplierDatabasePopulator returnSupplierDatabasePopulator;

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private PurchaseOrderDatabasePopulator purchaseOrderDatabasePopulator;

	private final PurchaseOrderFactory purchaseOrderFactory = new PurchaseOrderFactory();

	@Autowired
	private ReturnSupplierStockDetailRepository returnSupplierStockDetailRepository;

	@Autowired
	private ReturnSupplierStockDetailDatabasePopulator returnSupplierStockDetailDatabasePopulator;

	private final ReturnSupplierStockDetailFactory returnSupplierStockDetailFactory = new ReturnSupplierStockDetailFactory();

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
		returnSupplierService = new ReturnSupplierService(
			purchaseOrderRepository,
			returnSupplierStockDetailRepository,
			supplierRepository,
			warehouseRepository,
			validator,
			auditRepository,
			returnSupplierRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewReturnSupplierEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		ReturnSupplierEntity returnSupplierEntity = returnSupplierFactory.getObject(false, false);

		ReturnSupplierEntity updatedEntity = returnSupplierService.updateOldData(returnSupplierEntity);
		Assertions.assertEquals(returnSupplierEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewReturnSupplierEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		ReturnSupplierEntity returnSupplierEntity = returnSupplierFactory.getObject(false, false);

		returnSupplierEntity.setPriceVATIncluded(null);
		Assertions.assertNull(returnSupplierEntity.getPriceVATIncluded());

		returnSupplierEntity.setExtraDiscountInPercentage(null);
		Assertions.assertNull(returnSupplierEntity.getExtraDiscountInPercentage());

		returnSupplierEntity.setExtraDiscountIncludeTax(null);
		Assertions.assertNull(returnSupplierEntity.getExtraDiscountIncludeTax());

		returnSupplierEntity.setFreightFeeIncludeTax(null);
		Assertions.assertNull(returnSupplierEntity.getFreightFeeIncludeTax());

		returnSupplierEntity.setOtherFeeIncludeTax(null);
		Assertions.assertNull(returnSupplierEntity.getOtherFeeIncludeTax());


		ReturnSupplierEntity updatedEntity = returnSupplierService.updateOldData(returnSupplierEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getPriceVATIncluded());
		Assertions.assertFalse(updatedEntity.getPriceVATIncluded());

		Assertions.assertNotNull(updatedEntity.getExtraDiscountInPercentage());
		Assertions.assertFalse(updatedEntity.getExtraDiscountInPercentage());

		Assertions.assertNotNull(updatedEntity.getExtraDiscountIncludeTax());
		Assertions.assertFalse(updatedEntity.getExtraDiscountIncludeTax());

		Assertions.assertNotNull(updatedEntity.getFreightFeeIncludeTax());
		Assertions.assertFalse(updatedEntity.getFreightFeeIncludeTax());

		Assertions.assertNotNull(updatedEntity.getOtherFeeIncludeTax());
		Assertions.assertFalse(updatedEntity.getOtherFeeIncludeTax());

	}

	@Test
	public void updateOldDataWithExistingReturnSupplierEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			ReturnSupplierEntity returnSupplierEntity;
			ReturnSupplierEntity entityWithUpdatedValues;

			try {
				returnSupplierEntity = returnSupplierFactory.getObject(false, false);
				returnSupplierDatabasePopulator.populateRelatedEntitiesInDatabase(returnSupplierEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = returnSupplierFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			returnSupplierEntity = returnSupplierService.create(returnSupplierEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(returnSupplierEntity.getId());

			ReturnSupplierEntity updatedEntity = returnSupplierService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithReturnSupplierEntityWithNonExistentId_ShouldThrowException() throws Exception {
		ReturnSupplierEntity returnSupplierEntity = returnSupplierFactory.getObject(false, false);
		returnSupplierEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			returnSupplierService.updateOldData(returnSupplierEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingReturnSupplierEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ReturnSupplierEntity returnSupplierEntity;
			ReturnSupplierEntity updatedReturnSupplierEntity;

			PurchaseOrderEntity purchaseOrderEntity;

			SupplierEntity supplierEntity;

			WarehouseEntity warehouseEntity;

			Set<ReturnSupplierStockDetailEntity> returnSupplierStockDetailsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				returnSupplierEntity = returnSupplierFactory.getObject(true, false);
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
			purchaseOrderEntity = returnSupplierEntity.getPurchaseOrder();
			try {
				purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			purchaseOrderEntity = purchaseOrderRepository.save(purchaseOrderEntity);
			returnSupplierEntity.setPurchaseOrderId(purchaseOrderEntity.getId());

			supplierEntity = returnSupplierEntity.getSupplier();
			try {
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(supplierEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			supplierEntity = supplierRepository.save(supplierEntity);
			returnSupplierEntity.setSupplierId(supplierEntity.getId());

			warehouseEntity = returnSupplierEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			returnSupplierEntity.setWarehouseId(warehouseEntity.getId());

			returnSupplierStockDetailsEntities = returnSupplierEntity.getReturnSupplierStockDetails();
			Set<UUID> returnSupplierStockDetailsEntityIds = new HashSet<>();
			for (ReturnSupplierStockDetailEntity entity : returnSupplierStockDetailsEntities) {
				try {
					returnSupplierStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				returnSupplierStockDetailsEntityIds.add(returnSupplierStockDetailRepository.save(entity).getId());
			}
			returnSupplierEntity.setReturnSupplierStockDetailsIds(returnSupplierStockDetailsEntityIds);


			returnSupplierEntity = returnSupplierService.create(returnSupplierEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(returnSupplierEntity.getPurchaseOrder());
			returnSupplierEntity.setPurchaseOrderId(null);
			returnSupplierEntity.unsetPurchaseOrder();

			Assertions.assertNotNull(returnSupplierEntity.getSupplier());
			returnSupplierEntity.setSupplierId(null);
			returnSupplierEntity.unsetSupplier();

			Assertions.assertNotNull(returnSupplierEntity.getWarehouse());
			returnSupplierEntity.setWarehouseId(null);
			returnSupplierEntity.unsetWarehouse();

			Assertions.assertTrue(returnSupplierEntity.getReturnSupplierStockDetails().size() > 0);
			returnSupplierEntity.setReturnSupplierStockDetailsIds(new HashSet<UUID>());
			returnSupplierEntity.unsetReturnSupplierStockDetails();


			updatedReturnSupplierEntity = returnSupplierService.updateOldData(returnSupplierEntity);

			Assertions.assertNull(updatedReturnSupplierEntity.getPurchaseOrder());

			Assertions.assertNull(updatedReturnSupplierEntity.getSupplier());

			Assertions.assertNull(updatedReturnSupplierEntity.getWarehouse());

			Assertions.assertEquals(0, updatedReturnSupplierEntity.getReturnSupplierStockDetails().size());

		});
	}

	@Test
	public void updateOldDataWithReturnSupplierEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ReturnSupplierEntity returnSupplierEntity;
			ReturnSupplierEntity updatedReturnSupplierEntity;

			PurchaseOrderEntity purchaseOrderEntity;

			SupplierEntity supplierEntity;

			WarehouseEntity warehouseEntity;

			Set<ReturnSupplierStockDetailEntity> returnSupplierStockDetailsEntities;
			Set<UUID> returnSupplierStockDetailsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				returnSupplierEntity = returnSupplierFactory.getObject(true, false);
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
				purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(returnSupplierEntity.getPurchaseOrder(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Purchase Order relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			purchaseOrderEntity = purchaseOrderRepository.findById(purchaseOrderRepository.save(returnSupplierEntity.getPurchaseOrder()).getId()).get();
			returnSupplierEntity.unsetPurchaseOrder();
			returnSupplierEntity.setPurchaseOrderId(purchaseOrderEntity.getId());

			try {
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(returnSupplierEntity.getSupplier(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Supplier relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			supplierEntity = supplierRepository.findById(supplierRepository.save(returnSupplierEntity.getSupplier()).getId()).get();
			returnSupplierEntity.unsetSupplier();
			returnSupplierEntity.setSupplierId(supplierEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(returnSupplierEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(returnSupplierEntity.getWarehouse()).getId()).get();
			returnSupplierEntity.unsetWarehouse();
			returnSupplierEntity.setWarehouseId(warehouseEntity.getId());

			returnSupplierStockDetailsEntities = new HashSet<>();
			returnSupplierStockDetailsEntityIds = new HashSet<>();
			for (ReturnSupplierStockDetailEntity entity : returnSupplierEntity.getReturnSupplierStockDetails()) {
				try {
					returnSupplierStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Return Supplier Stock Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = returnSupplierStockDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				returnSupplierStockDetailsEntities.add(returnSupplierStockDetailRepository.findById(id).get());
				returnSupplierStockDetailsEntityIds.add(id);
			}
			returnSupplierEntity.unsetReturnSupplierStockDetails();
			returnSupplierEntity.setReturnSupplierStockDetailsIds(returnSupplierStockDetailsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedReturnSupplierEntity = returnSupplierService.updateOldData(returnSupplierEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			purchaseOrderEntity.unsetReturnSuppliers(false);
			updatedReturnSupplierEntity.getPurchaseOrder().unsetReturnSuppliers(false);
			Assertions.assertEquals(purchaseOrderEntity, updatedReturnSupplierEntity.getPurchaseOrder());

			supplierEntity.unsetReturnSuppliers(false);
			updatedReturnSupplierEntity.getSupplier().unsetReturnSuppliers(false);
			Assertions.assertEquals(supplierEntity, updatedReturnSupplierEntity.getSupplier());

			warehouseEntity.unsetReturnSuppliers(false);
			updatedReturnSupplierEntity.getWarehouse().unsetReturnSuppliers(false);
			Assertions.assertEquals(warehouseEntity, updatedReturnSupplierEntity.getWarehouse());

			Assertions.assertEquals(returnSupplierStockDetailsEntities.size(), updatedReturnSupplierEntity.getReturnSupplierStockDetails().size());

		});
	}

	@Test
	public void whenCreateReturnSupplierEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			ReturnSupplierEntity returnSupplierEntity;
			Optional<ReturnSupplierEntity> fetchedReturnSupplierEntity;

			try {
				returnSupplierEntity = returnSupplierFactory.getObject(false, false);
				returnSupplierDatabasePopulator.populateRelatedEntitiesInDatabase(returnSupplierEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			returnSupplierEntity = returnSupplierService.create(returnSupplierEntity);

			fetchedReturnSupplierEntity = returnSupplierService.findById(returnSupplierEntity.getId());

			Assertions.assertTrue(fetchedReturnSupplierEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedReturnSupplierEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(returnSupplierEntity, fetchedReturnSupplierEntity.get());
		});
	}

	@Test
	public void whenUpdateReturnSupplierEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			ReturnSupplierEntity returnSupplierEntity;
			ReturnSupplierEntity updatedReturnSupplierEntity;
			Optional<ReturnSupplierEntity> fetchedReturnSupplierEntity;

			try {
				returnSupplierEntity = returnSupplierFactory.getObject(false, false);
				returnSupplierDatabasePopulator.populateRelatedEntitiesInDatabase(returnSupplierEntity, true, true, false);
				updatedReturnSupplierEntity = returnSupplierFactory.getObject(false, false);
				returnSupplierDatabasePopulator.populateRelatedEntitiesInDatabase(updatedReturnSupplierEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			returnSupplierEntity = returnSupplierService.create(returnSupplierEntity);

			updatedReturnSupplierEntity.setId(returnSupplierEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedReturnSupplierEntity.setCreated(returnSupplierEntity.getCreated());

			updatedReturnSupplierEntity = returnSupplierService.update(updatedReturnSupplierEntity);

			fetchedReturnSupplierEntity = returnSupplierService.findById(returnSupplierEntity.getId());

			Assertions.assertTrue(fetchedReturnSupplierEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateReturnSupplierEntity_ThenEntityIsCreated
			fetchedReturnSupplierEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedReturnSupplierEntity, fetchedReturnSupplierEntity.get());
		});
	}

	@Test
	public void whenDeleteReturnSupplierEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			ReturnSupplierEntity returnSupplierEntity;
			Optional<ReturnSupplierEntity> fetchedReturnSupplierEntity;

			try {
				returnSupplierEntity = returnSupplierFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				returnSupplierDatabasePopulator.populateRelatedEntitiesInDatabase(returnSupplierEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			returnSupplierEntity = returnSupplierService.create(returnSupplierEntity);

			returnSupplierService.deleteById(returnSupplierEntity.getId());
			fetchedReturnSupplierEntity = returnSupplierService.findById(returnSupplierEntity.getId());

			Assertions.assertTrue(fetchedReturnSupplierEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
