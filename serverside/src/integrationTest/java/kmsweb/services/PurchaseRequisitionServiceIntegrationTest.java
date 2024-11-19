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
import kmsweb.entities.PurchaseRequisitionEntity;
import kmsweb.repositories.PurchaseRequisitionRepository;
import kmsweb.utils.PurchaseRequisitionFactory;
import kmsweb.utils.DatabasePopulators.PurchaseRequisitionDatabasePopulator;
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.utils.PurchaseOrderFactory;
import kmsweb.utils.DatabasePopulators.PurchaseOrderDatabasePopulator;
import kmsweb.entities.PurchaseRequisitionStockDetailEntity;
import kmsweb.repositories.PurchaseRequisitionStockDetailRepository;
import kmsweb.utils.PurchaseRequisitionStockDetailFactory;
import kmsweb.utils.DatabasePopulators.PurchaseRequisitionStockDetailDatabasePopulator;
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
public class PurchaseRequisitionServiceIntegrationTest {

	@Autowired
	private PurchaseRequisitionRepository purchaseRequisitionRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PurchaseRequisitionService purchaseRequisitionService;

	private final PurchaseRequisitionFactory purchaseRequisitionFactory = new PurchaseRequisitionFactory();

	@Autowired
	private PurchaseRequisitionDatabasePopulator purchaseRequisitionDatabasePopulator;

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private PurchaseOrderDatabasePopulator purchaseOrderDatabasePopulator;

	private final PurchaseOrderFactory purchaseOrderFactory = new PurchaseOrderFactory();

	@Autowired
	private PurchaseRequisitionStockDetailRepository purchaseRequisitionStockDetailRepository;

	@Autowired
	private PurchaseRequisitionStockDetailDatabasePopulator purchaseRequisitionStockDetailDatabasePopulator;

	private final PurchaseRequisitionStockDetailFactory purchaseRequisitionStockDetailFactory = new PurchaseRequisitionStockDetailFactory();

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
		purchaseRequisitionService = new PurchaseRequisitionService(
			purchaseOrderRepository,
			purchaseRequisitionStockDetailRepository,
			supplierRepository,
			warehouseRepository,
			validator,
			auditRepository,
			purchaseRequisitionRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPurchaseRequisitionEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PurchaseRequisitionEntity purchaseRequisitionEntity = purchaseRequisitionFactory.getObject(false, false);

		PurchaseRequisitionEntity updatedEntity = purchaseRequisitionService.updateOldData(purchaseRequisitionEntity);
		Assertions.assertEquals(purchaseRequisitionEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingPurchaseRequisitionEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseRequisitionEntity purchaseRequisitionEntity;
			PurchaseRequisitionEntity entityWithUpdatedValues;

			try {
				purchaseRequisitionEntity = purchaseRequisitionFactory.getObject(false, false);
				purchaseRequisitionDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseRequisitionEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = purchaseRequisitionFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseRequisitionEntity = purchaseRequisitionService.create(purchaseRequisitionEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(purchaseRequisitionEntity.getId());

			PurchaseRequisitionEntity updatedEntity = purchaseRequisitionService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPurchaseRequisitionEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PurchaseRequisitionEntity purchaseRequisitionEntity = purchaseRequisitionFactory.getObject(false, false);
		purchaseRequisitionEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			purchaseRequisitionService.updateOldData(purchaseRequisitionEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPurchaseRequisitionEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseRequisitionEntity purchaseRequisitionEntity;
			PurchaseRequisitionEntity updatedPurchaseRequisitionEntity;

			PurchaseOrderEntity purchaseOrderEntity;

			SupplierEntity supplierEntity;

			WarehouseEntity warehouseEntity;

			Set<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetailsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				purchaseRequisitionEntity = purchaseRequisitionFactory.getObject(true, false);
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
			purchaseOrderEntity = purchaseRequisitionEntity.getPurchaseOrder();
			try {
				purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			purchaseOrderEntity = purchaseOrderRepository.save(purchaseOrderEntity);
			purchaseRequisitionEntity.setPurchaseOrderId(purchaseOrderEntity.getId());

			supplierEntity = purchaseRequisitionEntity.getSupplier();
			try {
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(supplierEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			supplierEntity = supplierRepository.save(supplierEntity);
			purchaseRequisitionEntity.setSupplierId(supplierEntity.getId());

			warehouseEntity = purchaseRequisitionEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			purchaseRequisitionEntity.setWarehouseId(warehouseEntity.getId());

			purchaseRequisitionStockDetailsEntities = purchaseRequisitionEntity.getPurchaseRequisitionStockDetails();
			Set<UUID> purchaseRequisitionStockDetailsEntityIds = new HashSet<>();
			for (PurchaseRequisitionStockDetailEntity entity : purchaseRequisitionStockDetailsEntities) {
				try {
					purchaseRequisitionStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				purchaseRequisitionStockDetailsEntityIds.add(purchaseRequisitionStockDetailRepository.save(entity).getId());
			}
			purchaseRequisitionEntity.setPurchaseRequisitionStockDetailsIds(purchaseRequisitionStockDetailsEntityIds);


			purchaseRequisitionEntity = purchaseRequisitionService.create(purchaseRequisitionEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(purchaseRequisitionEntity.getPurchaseOrder());
			purchaseRequisitionEntity.setPurchaseOrderId(null);
			purchaseRequisitionEntity.unsetPurchaseOrder();

			Assertions.assertNotNull(purchaseRequisitionEntity.getSupplier());
			purchaseRequisitionEntity.setSupplierId(null);
			purchaseRequisitionEntity.unsetSupplier();

			Assertions.assertNotNull(purchaseRequisitionEntity.getWarehouse());
			purchaseRequisitionEntity.setWarehouseId(null);
			purchaseRequisitionEntity.unsetWarehouse();

			Assertions.assertTrue(purchaseRequisitionEntity.getPurchaseRequisitionStockDetails().size() > 0);
			purchaseRequisitionEntity.setPurchaseRequisitionStockDetailsIds(new HashSet<UUID>());
			purchaseRequisitionEntity.unsetPurchaseRequisitionStockDetails();


			updatedPurchaseRequisitionEntity = purchaseRequisitionService.updateOldData(purchaseRequisitionEntity);

			Assertions.assertNull(updatedPurchaseRequisitionEntity.getPurchaseOrder());

			Assertions.assertNull(updatedPurchaseRequisitionEntity.getSupplier());

			Assertions.assertNull(updatedPurchaseRequisitionEntity.getWarehouse());

			Assertions.assertEquals(0, updatedPurchaseRequisitionEntity.getPurchaseRequisitionStockDetails().size());

		});
	}

	@Test
	public void updateOldDataWithPurchaseRequisitionEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseRequisitionEntity purchaseRequisitionEntity;
			PurchaseRequisitionEntity updatedPurchaseRequisitionEntity;

			PurchaseOrderEntity purchaseOrderEntity;

			SupplierEntity supplierEntity;

			WarehouseEntity warehouseEntity;

			Set<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetailsEntities;
			Set<UUID> purchaseRequisitionStockDetailsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				purchaseRequisitionEntity = purchaseRequisitionFactory.getObject(true, false);
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
				purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseRequisitionEntity.getPurchaseOrder(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Purchase Order relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			purchaseOrderEntity = purchaseOrderRepository.findById(purchaseOrderRepository.save(purchaseRequisitionEntity.getPurchaseOrder()).getId()).get();
			purchaseRequisitionEntity.unsetPurchaseOrder();
			purchaseRequisitionEntity.setPurchaseOrderId(purchaseOrderEntity.getId());

			try {
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseRequisitionEntity.getSupplier(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Supplier relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			supplierEntity = supplierRepository.findById(supplierRepository.save(purchaseRequisitionEntity.getSupplier()).getId()).get();
			purchaseRequisitionEntity.unsetSupplier();
			purchaseRequisitionEntity.setSupplierId(supplierEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseRequisitionEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(purchaseRequisitionEntity.getWarehouse()).getId()).get();
			purchaseRequisitionEntity.unsetWarehouse();
			purchaseRequisitionEntity.setWarehouseId(warehouseEntity.getId());

			purchaseRequisitionStockDetailsEntities = new HashSet<>();
			purchaseRequisitionStockDetailsEntityIds = new HashSet<>();
			for (PurchaseRequisitionStockDetailEntity entity : purchaseRequisitionEntity.getPurchaseRequisitionStockDetails()) {
				try {
					purchaseRequisitionStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Purchase Requisition Stock Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = purchaseRequisitionStockDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				purchaseRequisitionStockDetailsEntities.add(purchaseRequisitionStockDetailRepository.findById(id).get());
				purchaseRequisitionStockDetailsEntityIds.add(id);
			}
			purchaseRequisitionEntity.unsetPurchaseRequisitionStockDetails();
			purchaseRequisitionEntity.setPurchaseRequisitionStockDetailsIds(purchaseRequisitionStockDetailsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPurchaseRequisitionEntity = purchaseRequisitionService.updateOldData(purchaseRequisitionEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			purchaseOrderEntity.unsetPurchaseRequisitions(false);
			updatedPurchaseRequisitionEntity.getPurchaseOrder().unsetPurchaseRequisitions(false);
			Assertions.assertEquals(purchaseOrderEntity, updatedPurchaseRequisitionEntity.getPurchaseOrder());

			supplierEntity.unsetPurchaseRequisitions(false);
			updatedPurchaseRequisitionEntity.getSupplier().unsetPurchaseRequisitions(false);
			Assertions.assertEquals(supplierEntity, updatedPurchaseRequisitionEntity.getSupplier());

			warehouseEntity.unsetPurchaseRequisitions(false);
			updatedPurchaseRequisitionEntity.getWarehouse().unsetPurchaseRequisitions(false);
			Assertions.assertEquals(warehouseEntity, updatedPurchaseRequisitionEntity.getWarehouse());

			Assertions.assertEquals(purchaseRequisitionStockDetailsEntities.size(), updatedPurchaseRequisitionEntity.getPurchaseRequisitionStockDetails().size());

		});
	}

	@Test
	public void whenCreatePurchaseRequisitionEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseRequisitionEntity purchaseRequisitionEntity;
			Optional<PurchaseRequisitionEntity> fetchedPurchaseRequisitionEntity;

			try {
				purchaseRequisitionEntity = purchaseRequisitionFactory.getObject(false, false);
				purchaseRequisitionDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseRequisitionEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseRequisitionEntity = purchaseRequisitionService.create(purchaseRequisitionEntity);

			fetchedPurchaseRequisitionEntity = purchaseRequisitionService.findById(purchaseRequisitionEntity.getId());

			Assertions.assertTrue(fetchedPurchaseRequisitionEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPurchaseRequisitionEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(purchaseRequisitionEntity, fetchedPurchaseRequisitionEntity.get());
		});
	}

	@Test
	public void whenUpdatePurchaseRequisitionEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseRequisitionEntity purchaseRequisitionEntity;
			PurchaseRequisitionEntity updatedPurchaseRequisitionEntity;
			Optional<PurchaseRequisitionEntity> fetchedPurchaseRequisitionEntity;

			try {
				purchaseRequisitionEntity = purchaseRequisitionFactory.getObject(false, false);
				purchaseRequisitionDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseRequisitionEntity, true, true, false);
				updatedPurchaseRequisitionEntity = purchaseRequisitionFactory.getObject(false, false);
				purchaseRequisitionDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPurchaseRequisitionEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseRequisitionEntity = purchaseRequisitionService.create(purchaseRequisitionEntity);

			updatedPurchaseRequisitionEntity.setId(purchaseRequisitionEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPurchaseRequisitionEntity.setCreated(purchaseRequisitionEntity.getCreated());

			updatedPurchaseRequisitionEntity = purchaseRequisitionService.update(updatedPurchaseRequisitionEntity);

			fetchedPurchaseRequisitionEntity = purchaseRequisitionService.findById(purchaseRequisitionEntity.getId());

			Assertions.assertTrue(fetchedPurchaseRequisitionEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePurchaseRequisitionEntity_ThenEntityIsCreated
			fetchedPurchaseRequisitionEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPurchaseRequisitionEntity, fetchedPurchaseRequisitionEntity.get());
		});
	}

	@Test
	public void whenDeletePurchaseRequisitionEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseRequisitionEntity purchaseRequisitionEntity;
			Optional<PurchaseRequisitionEntity> fetchedPurchaseRequisitionEntity;

			try {
				purchaseRequisitionEntity = purchaseRequisitionFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				purchaseRequisitionDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseRequisitionEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseRequisitionEntity = purchaseRequisitionService.create(purchaseRequisitionEntity);

			purchaseRequisitionService.deleteById(purchaseRequisitionEntity.getId());
			fetchedPurchaseRequisitionEntity = purchaseRequisitionService.findById(purchaseRequisitionEntity.getId());

			Assertions.assertTrue(fetchedPurchaseRequisitionEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
