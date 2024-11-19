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
import kmsweb.entities.WarehouseEntity;
import kmsweb.repositories.WarehouseRepository;
import kmsweb.utils.WarehouseFactory;
import kmsweb.utils.DatabasePopulators.WarehouseDatabasePopulator;
import kmsweb.entities.BatchStockBalanceEntity;
import kmsweb.repositories.BatchStockBalanceRepository;
import kmsweb.utils.BatchStockBalanceFactory;
import kmsweb.utils.DatabasePopulators.BatchStockBalanceDatabasePopulator;
import kmsweb.entities.BatchStockBalancePerDateEntity;
import kmsweb.repositories.BatchStockBalancePerDateRepository;
import kmsweb.utils.BatchStockBalancePerDateFactory;
import kmsweb.utils.DatabasePopulators.BatchStockBalancePerDateDatabasePopulator;
import kmsweb.entities.BatchStockTransactionDetailEntity;
import kmsweb.repositories.BatchStockTransactionDetailRepository;
import kmsweb.utils.BatchStockTransactionDetailFactory;
import kmsweb.utils.DatabasePopulators.BatchStockTransactionDetailDatabasePopulator;
import kmsweb.entities.GoodsReceiveNoteEntity;
import kmsweb.repositories.GoodsReceiveNoteRepository;
import kmsweb.utils.GoodsReceiveNoteFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteDatabasePopulator;
import kmsweb.entities.GoodsReceiveNoteBatchEntity;
import kmsweb.repositories.GoodsReceiveNoteBatchRepository;
import kmsweb.utils.GoodsReceiveNoteBatchFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteBatchDatabasePopulator;
import kmsweb.entities.InternalOrderEntity;
import kmsweb.repositories.InternalOrderRepository;
import kmsweb.utils.InternalOrderFactory;
import kmsweb.utils.DatabasePopulators.InternalOrderDatabasePopulator;
import kmsweb.entities.InventoryAdjusmentBatchEntity;
import kmsweb.repositories.InventoryAdjusmentBatchRepository;
import kmsweb.utils.InventoryAdjusmentBatchFactory;
import kmsweb.utils.DatabasePopulators.InventoryAdjusmentBatchDatabasePopulator;
import kmsweb.entities.InventoryAdjustmentEntity;
import kmsweb.repositories.InventoryAdjustmentRepository;
import kmsweb.utils.InventoryAdjustmentFactory;
import kmsweb.utils.DatabasePopulators.InventoryAdjustmentDatabasePopulator;
import kmsweb.entities.InventoryBatchCorrectionEntity;
import kmsweb.repositories.InventoryBatchCorrectionRepository;
import kmsweb.utils.InventoryBatchCorrectionFactory;
import kmsweb.utils.DatabasePopulators.InventoryBatchCorrectionDatabasePopulator;
import kmsweb.entities.LocationEntity;
import kmsweb.repositories.LocationRepository;
import kmsweb.utils.LocationFactory;
import kmsweb.utils.DatabasePopulators.LocationDatabasePopulator;
import kmsweb.entities.MedicalFeeEntity;
import kmsweb.repositories.MedicalFeeRepository;
import kmsweb.utils.MedicalFeeFactory;
import kmsweb.utils.DatabasePopulators.MedicalFeeDatabasePopulator;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.utils.MedicationHeaderFactory;
import kmsweb.utils.DatabasePopulators.MedicationHeaderDatabasePopulator;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.utils.PrescriptionHeaderFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionHeaderDatabasePopulator;
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.utils.PurchaseOrderFactory;
import kmsweb.utils.DatabasePopulators.PurchaseOrderDatabasePopulator;
import kmsweb.entities.PurchaseRequisitionEntity;
import kmsweb.repositories.PurchaseRequisitionRepository;
import kmsweb.utils.PurchaseRequisitionFactory;
import kmsweb.utils.DatabasePopulators.PurchaseRequisitionDatabasePopulator;
import kmsweb.entities.RetailPharmacyEntity;
import kmsweb.repositories.RetailPharmacyRepository;
import kmsweb.utils.RetailPharmacyFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyDatabasePopulator;
import kmsweb.entities.ReturnSupplierEntity;
import kmsweb.repositories.ReturnSupplierRepository;
import kmsweb.utils.ReturnSupplierFactory;
import kmsweb.utils.DatabasePopulators.ReturnSupplierDatabasePopulator;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.utils.StockCatalogueFactory;
import kmsweb.utils.DatabasePopulators.StockCatalogueDatabasePopulator;
import kmsweb.entities.StockControlEntity;
import kmsweb.repositories.StockControlRepository;
import kmsweb.utils.StockControlFactory;
import kmsweb.utils.DatabasePopulators.StockControlDatabasePopulator;
import kmsweb.entities.StockTransactionDetailEntity;
import kmsweb.repositories.StockTransactionDetailRepository;
import kmsweb.utils.StockTransactionDetailFactory;
import kmsweb.utils.DatabasePopulators.StockTransactionDetailDatabasePopulator;
import kmsweb.entities.StockTransactionPerDateEntity;
import kmsweb.repositories.StockTransactionPerDateRepository;
import kmsweb.utils.StockTransactionPerDateFactory;
import kmsweb.utils.DatabasePopulators.StockTransactionPerDateDatabasePopulator;
import kmsweb.entities.StockTransactionPerDateTypeEntity;
import kmsweb.repositories.StockTransactionPerDateTypeRepository;
import kmsweb.utils.StockTransactionPerDateTypeFactory;
import kmsweb.utils.DatabasePopulators.StockTransactionPerDateTypeDatabasePopulator;
import kmsweb.entities.TransferOrderEntity;
import kmsweb.repositories.TransferOrderRepository;
import kmsweb.utils.TransferOrderFactory;
import kmsweb.utils.DatabasePopulators.TransferOrderDatabasePopulator;
import kmsweb.entities.VaccinationOrderDetailEntity;
import kmsweb.repositories.VaccinationOrderDetailRepository;
import kmsweb.utils.VaccinationOrderDetailFactory;
import kmsweb.utils.DatabasePopulators.VaccinationOrderDetailDatabasePopulator;
import kmsweb.entities.WarehouseInitialStockEntity;
import kmsweb.repositories.WarehouseInitialStockRepository;
import kmsweb.utils.WarehouseInitialStockFactory;
import kmsweb.utils.DatabasePopulators.WarehouseInitialStockDatabasePopulator;
import kmsweb.entities.WarehouseInventoryEntity;
import kmsweb.repositories.WarehouseInventoryRepository;
import kmsweb.utils.WarehouseInventoryFactory;
import kmsweb.utils.DatabasePopulators.WarehouseInventoryDatabasePopulator;
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
public class WarehouseServiceIntegrationTest {

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private WarehouseService warehouseService;

	private final WarehouseFactory warehouseFactory = new WarehouseFactory();

	@Autowired
	private WarehouseDatabasePopulator warehouseDatabasePopulator;

	@Autowired
	private BatchStockBalanceRepository batchStockBalanceRepository;

	@Autowired
	private BatchStockBalanceDatabasePopulator batchStockBalanceDatabasePopulator;

	private final BatchStockBalanceFactory batchStockBalanceFactory = new BatchStockBalanceFactory();

	@Autowired
	private BatchStockBalancePerDateRepository batchStockBalancePerDateRepository;

	@Autowired
	private BatchStockBalancePerDateDatabasePopulator batchStockBalancePerDateDatabasePopulator;

	private final BatchStockBalancePerDateFactory batchStockBalancePerDateFactory = new BatchStockBalancePerDateFactory();

	@Autowired
	private BatchStockTransactionDetailRepository batchStockTransactionDetailRepository;

	@Autowired
	private BatchStockTransactionDetailDatabasePopulator batchStockTransactionDetailDatabasePopulator;

	private final BatchStockTransactionDetailFactory batchStockTransactionDetailFactory = new BatchStockTransactionDetailFactory();

	@Autowired
	private GoodsReceiveNoteRepository goodsReceiveNoteRepository;

	@Autowired
	private GoodsReceiveNoteDatabasePopulator goodsReceiveNoteDatabasePopulator;

	private final GoodsReceiveNoteFactory goodsReceiveNoteFactory = new GoodsReceiveNoteFactory();

	@Autowired
	private GoodsReceiveNoteBatchRepository goodsReceiveNoteBatchRepository;

	@Autowired
	private GoodsReceiveNoteBatchDatabasePopulator goodsReceiveNoteBatchDatabasePopulator;

	private final GoodsReceiveNoteBatchFactory goodsReceiveNoteBatchFactory = new GoodsReceiveNoteBatchFactory();

	@Autowired
	private InternalOrderRepository internalOrderRepository;

	@Autowired
	private InternalOrderDatabasePopulator internalOrderDatabasePopulator;

	private final InternalOrderFactory internalOrderFactory = new InternalOrderFactory();

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
	private InventoryBatchCorrectionRepository inventoryBatchCorrectionRepository;

	@Autowired
	private InventoryBatchCorrectionDatabasePopulator inventoryBatchCorrectionDatabasePopulator;

	private final InventoryBatchCorrectionFactory inventoryBatchCorrectionFactory = new InventoryBatchCorrectionFactory();

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private LocationDatabasePopulator locationDatabasePopulator;

	private final LocationFactory locationFactory = new LocationFactory();

	@Autowired
	private MedicalFeeRepository medicalFeeRepository;

	@Autowired
	private MedicalFeeDatabasePopulator medicalFeeDatabasePopulator;

	private final MedicalFeeFactory medicalFeeFactory = new MedicalFeeFactory();

	@Autowired
	private MedicationHeaderRepository medicationHeaderRepository;

	@Autowired
	private MedicationHeaderDatabasePopulator medicationHeaderDatabasePopulator;

	private final MedicationHeaderFactory medicationHeaderFactory = new MedicationHeaderFactory();

	@Autowired
	private PrescriptionHeaderRepository prescriptionHeaderRepository;

	@Autowired
	private PrescriptionHeaderDatabasePopulator prescriptionHeaderDatabasePopulator;

	private final PrescriptionHeaderFactory prescriptionHeaderFactory = new PrescriptionHeaderFactory();

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private PurchaseOrderDatabasePopulator purchaseOrderDatabasePopulator;

	private final PurchaseOrderFactory purchaseOrderFactory = new PurchaseOrderFactory();

	@Autowired
	private PurchaseRequisitionRepository purchaseRequisitionRepository;

	@Autowired
	private PurchaseRequisitionDatabasePopulator purchaseRequisitionDatabasePopulator;

	private final PurchaseRequisitionFactory purchaseRequisitionFactory = new PurchaseRequisitionFactory();

	@Autowired
	private RetailPharmacyRepository retailPharmacyRepository;

	@Autowired
	private RetailPharmacyDatabasePopulator retailPharmacyDatabasePopulator;

	private final RetailPharmacyFactory retailPharmacyFactory = new RetailPharmacyFactory();

	@Autowired
	private ReturnSupplierRepository returnSupplierRepository;

	@Autowired
	private ReturnSupplierDatabasePopulator returnSupplierDatabasePopulator;

	private final ReturnSupplierFactory returnSupplierFactory = new ReturnSupplierFactory();

	@Autowired
	private StockCatalogueRepository stockCatalogueRepository;

	@Autowired
	private StockCatalogueDatabasePopulator stockCatalogueDatabasePopulator;

	private final StockCatalogueFactory stockCatalogueFactory = new StockCatalogueFactory();

	@Autowired
	private StockControlRepository stockControlRepository;

	@Autowired
	private StockControlDatabasePopulator stockControlDatabasePopulator;

	private final StockControlFactory stockControlFactory = new StockControlFactory();

	@Autowired
	private StockTransactionDetailRepository stockTransactionDetailRepository;

	@Autowired
	private StockTransactionDetailDatabasePopulator stockTransactionDetailDatabasePopulator;

	private final StockTransactionDetailFactory stockTransactionDetailFactory = new StockTransactionDetailFactory();

	@Autowired
	private StockTransactionPerDateRepository stockTransactionPerDateRepository;

	@Autowired
	private StockTransactionPerDateDatabasePopulator stockTransactionPerDateDatabasePopulator;

	private final StockTransactionPerDateFactory stockTransactionPerDateFactory = new StockTransactionPerDateFactory();

	@Autowired
	private StockTransactionPerDateTypeRepository stockTransactionPerDateTypeRepository;

	@Autowired
	private StockTransactionPerDateTypeDatabasePopulator stockTransactionPerDateTypeDatabasePopulator;

	private final StockTransactionPerDateTypeFactory stockTransactionPerDateTypeFactory = new StockTransactionPerDateTypeFactory();

	@Autowired
	private TransferOrderRepository transferOrderRepository;

	@Autowired
	private TransferOrderDatabasePopulator transferOrderDatabasePopulator;

	private final TransferOrderFactory transferOrderFactory = new TransferOrderFactory();

	@Autowired
	private VaccinationOrderDetailRepository vaccinationOrderDetailRepository;

	@Autowired
	private VaccinationOrderDetailDatabasePopulator vaccinationOrderDetailDatabasePopulator;

	private final VaccinationOrderDetailFactory vaccinationOrderDetailFactory = new VaccinationOrderDetailFactory();

	@Autowired
	private WarehouseInitialStockRepository warehouseInitialStockRepository;

	@Autowired
	private WarehouseInitialStockDatabasePopulator warehouseInitialStockDatabasePopulator;

	private final WarehouseInitialStockFactory warehouseInitialStockFactory = new WarehouseInitialStockFactory();

	@Autowired
	private WarehouseInventoryRepository warehouseInventoryRepository;

	@Autowired
	private WarehouseInventoryDatabasePopulator warehouseInventoryDatabasePopulator;

	private final WarehouseInventoryFactory warehouseInventoryFactory = new WarehouseInventoryFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		warehouseService = new WarehouseService(
			batchStockBalanceRepository,
			batchStockBalancePerDateRepository,
			batchStockTransactionDetailRepository,
			goodsReceiveNoteRepository,
			goodsReceiveNoteBatchRepository,
			internalOrderRepository,
			inventoryAdjusmentBatchRepository,
			inventoryAdjustmentRepository,
			inventoryBatchCorrectionRepository,
			locationRepository,
			medicalFeeRepository,
			medicationHeaderRepository,
			prescriptionHeaderRepository,
			purchaseOrderRepository,
			purchaseRequisitionRepository,
			retailPharmacyRepository,
			returnSupplierRepository,
			stockCatalogueRepository,
			stockControlRepository,
			stockTransactionDetailRepository,
			stockTransactionPerDateRepository,
			stockTransactionPerDateTypeRepository,
			transferOrderRepository,
			vaccinationOrderDetailRepository,
			warehouseInitialStockRepository,
			warehouseInventoryRepository,
			validator,
			auditRepository,
			warehouseRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewWarehouseEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		WarehouseEntity warehouseEntity = warehouseFactory.getObject(false, false);

		WarehouseEntity updatedEntity = warehouseService.updateOldData(warehouseEntity);
		Assertions.assertEquals(warehouseEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingWarehouseEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			WarehouseEntity warehouseEntity;
			WarehouseEntity entityWithUpdatedValues;

			try {
				warehouseEntity = warehouseFactory.getObject(false, false);
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = warehouseFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			warehouseEntity = warehouseService.create(warehouseEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(warehouseEntity.getId());

			WarehouseEntity updatedEntity = warehouseService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithWarehouseEntityWithNonExistentId_ShouldThrowException() throws Exception {
		WarehouseEntity warehouseEntity = warehouseFactory.getObject(false, false);
		warehouseEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			warehouseService.updateOldData(warehouseEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingWarehouseEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			WarehouseEntity warehouseEntity;
			WarehouseEntity updatedWarehouseEntity;

			Set<BatchStockBalanceEntity> batchStockBalancesWarehouseEntities;

			Set<BatchStockBalancePerDateEntity> batchStockBalancesEntities;

			Set<BatchStockTransactionDetailEntity> batchStockTransactionDetailsEntities;

			Set<TransferOrderEntity> destinationWarehousesEntities;

			Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchsEntities;

			Set<GoodsReceiveNoteEntity> goodsReceiveNotesEntities;

			Set<InternalOrderEntity> internalOrdersEntities;

			Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchsEntities;

			Set<InventoryAdjustmentEntity> inventoryAdjustmentsEntities;

			Set<InventoryBatchCorrectionEntity> inventoryBatchCorrectionsEntities;

			Set<LocationEntity> locationsEntities;

			Set<MedicalFeeEntity> medicalFeesEntities;

			Set<MedicationHeaderEntity> medicationHeadersEntities;

			Set<PrescriptionHeaderEntity> prescriptionHeadersEntities;

			Set<PurchaseOrderEntity> purchaseOrdersEntities;

			Set<PurchaseRequisitionEntity> purchaseRequisitionsEntities;

			Set<RetailPharmacyEntity> retailPharmaciesEntities;

			Set<ReturnSupplierEntity> returnSuppliersEntities;

			Set<TransferOrderEntity> sourceWarehousesEntities;

			Set<StockCatalogueEntity> stockCataloguesEntities;

			Set<StockControlEntity> stockControlsEntities;

			Set<StockTransactionDetailEntity> stockTransactionDetailsEntities;

			Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypesEntities;

			Set<StockTransactionPerDateEntity> stockTransactionPerDatesEntities;

			Set<VaccinationOrderDetailEntity> vaccinationOrderDetailsEntities;

			Set<WarehouseInitialStockEntity> warehouseInitialStockSEntities;

			Set<WarehouseInventoryEntity> warehouseInventoriesEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				warehouseEntity = warehouseFactory.getObject(true, false);
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
			batchStockBalancesWarehouseEntities = warehouseEntity.getBatchStockBalancesWarehouse();
			Set<UUID> batchStockBalancesWarehouseEntityIds = new HashSet<>();
			for (BatchStockBalanceEntity entity : batchStockBalancesWarehouseEntities) {
				try {
					batchStockBalanceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				batchStockBalancesWarehouseEntityIds.add(batchStockBalanceRepository.save(entity).getId());
			}
			warehouseEntity.setBatchStockBalancesWarehouseIds(batchStockBalancesWarehouseEntityIds);

			batchStockBalancesEntities = warehouseEntity.getBatchStockBalances();
			Set<UUID> batchStockBalancesEntityIds = new HashSet<>();
			for (BatchStockBalancePerDateEntity entity : batchStockBalancesEntities) {
				try {
					batchStockBalancePerDateDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				batchStockBalancesEntityIds.add(batchStockBalancePerDateRepository.save(entity).getId());
			}
			warehouseEntity.setBatchStockBalancesIds(batchStockBalancesEntityIds);

			batchStockTransactionDetailsEntities = warehouseEntity.getBatchStockTransactionDetails();
			Set<UUID> batchStockTransactionDetailsEntityIds = new HashSet<>();
			for (BatchStockTransactionDetailEntity entity : batchStockTransactionDetailsEntities) {
				try {
					batchStockTransactionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				batchStockTransactionDetailsEntityIds.add(batchStockTransactionDetailRepository.save(entity).getId());
			}
			warehouseEntity.setBatchStockTransactionDetailsIds(batchStockTransactionDetailsEntityIds);

			destinationWarehousesEntities = warehouseEntity.getDestinationWarehouses();
			Set<UUID> destinationWarehousesEntityIds = new HashSet<>();
			for (TransferOrderEntity entity : destinationWarehousesEntities) {
				try {
					transferOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				destinationWarehousesEntityIds.add(transferOrderRepository.save(entity).getId());
			}
			warehouseEntity.setDestinationWarehousesIds(destinationWarehousesEntityIds);

			goodsReceiveNoteBatchsEntities = warehouseEntity.getGoodsReceiveNoteBatchs();
			Set<UUID> goodsReceiveNoteBatchsEntityIds = new HashSet<>();
			for (GoodsReceiveNoteBatchEntity entity : goodsReceiveNoteBatchsEntities) {
				try {
					goodsReceiveNoteBatchDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				goodsReceiveNoteBatchsEntityIds.add(goodsReceiveNoteBatchRepository.save(entity).getId());
			}
			warehouseEntity.setGoodsReceiveNoteBatchsIds(goodsReceiveNoteBatchsEntityIds);

			goodsReceiveNotesEntities = warehouseEntity.getGoodsReceiveNotes();
			Set<UUID> goodsReceiveNotesEntityIds = new HashSet<>();
			for (GoodsReceiveNoteEntity entity : goodsReceiveNotesEntities) {
				try {
					goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				goodsReceiveNotesEntityIds.add(goodsReceiveNoteRepository.save(entity).getId());
			}
			warehouseEntity.setGoodsReceiveNotesIds(goodsReceiveNotesEntityIds);

			internalOrdersEntities = warehouseEntity.getInternalOrders();
			Set<UUID> internalOrdersEntityIds = new HashSet<>();
			for (InternalOrderEntity entity : internalOrdersEntities) {
				try {
					internalOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				internalOrdersEntityIds.add(internalOrderRepository.save(entity).getId());
			}
			warehouseEntity.setInternalOrdersIds(internalOrdersEntityIds);

			inventoryAdjusmentBatchsEntities = warehouseEntity.getInventoryAdjusmentBatchs();
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
			warehouseEntity.setInventoryAdjusmentBatchsIds(inventoryAdjusmentBatchsEntityIds);

			inventoryAdjustmentsEntities = warehouseEntity.getInventoryAdjustments();
			Set<UUID> inventoryAdjustmentsEntityIds = new HashSet<>();
			for (InventoryAdjustmentEntity entity : inventoryAdjustmentsEntities) {
				try {
					inventoryAdjustmentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				inventoryAdjustmentsEntityIds.add(inventoryAdjustmentRepository.save(entity).getId());
			}
			warehouseEntity.setInventoryAdjustmentsIds(inventoryAdjustmentsEntityIds);

			inventoryBatchCorrectionsEntities = warehouseEntity.getInventoryBatchCorrections();
			Set<UUID> inventoryBatchCorrectionsEntityIds = new HashSet<>();
			for (InventoryBatchCorrectionEntity entity : inventoryBatchCorrectionsEntities) {
				try {
					inventoryBatchCorrectionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				inventoryBatchCorrectionsEntityIds.add(inventoryBatchCorrectionRepository.save(entity).getId());
			}
			warehouseEntity.setInventoryBatchCorrectionsIds(inventoryBatchCorrectionsEntityIds);

			locationsEntities = warehouseEntity.getLocations();
			Set<UUID> locationsEntityIds = new HashSet<>();
			for (LocationEntity entity : locationsEntities) {
				try {
					locationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				locationsEntityIds.add(locationRepository.save(entity).getId());
			}
			warehouseEntity.setLocationsIds(locationsEntityIds);

			medicalFeesEntities = warehouseEntity.getMedicalFees();
			Set<UUID> medicalFeesEntityIds = new HashSet<>();
			for (MedicalFeeEntity entity : medicalFeesEntities) {
				try {
					medicalFeeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalFeesEntityIds.add(medicalFeeRepository.save(entity).getId());
			}
			warehouseEntity.setMedicalFeesIds(medicalFeesEntityIds);

			medicationHeadersEntities = warehouseEntity.getMedicationHeaders();
			Set<UUID> medicationHeadersEntityIds = new HashSet<>();
			for (MedicationHeaderEntity entity : medicationHeadersEntities) {
				try {
					medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicationHeadersEntityIds.add(medicationHeaderRepository.save(entity).getId());
			}
			warehouseEntity.setMedicationHeadersIds(medicationHeadersEntityIds);

			prescriptionHeadersEntities = warehouseEntity.getPrescriptionHeaders();
			Set<UUID> prescriptionHeadersEntityIds = new HashSet<>();
			for (PrescriptionHeaderEntity entity : prescriptionHeadersEntities) {
				try {
					prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				prescriptionHeadersEntityIds.add(prescriptionHeaderRepository.save(entity).getId());
			}
			warehouseEntity.setPrescriptionHeadersIds(prescriptionHeadersEntityIds);

			purchaseOrdersEntities = warehouseEntity.getPurchaseOrders();
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
			warehouseEntity.setPurchaseOrdersIds(purchaseOrdersEntityIds);

			purchaseRequisitionsEntities = warehouseEntity.getPurchaseRequisitions();
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
			warehouseEntity.setPurchaseRequisitionsIds(purchaseRequisitionsEntityIds);

			retailPharmaciesEntities = warehouseEntity.getRetailPharmacies();
			Set<UUID> retailPharmaciesEntityIds = new HashSet<>();
			for (RetailPharmacyEntity entity : retailPharmaciesEntities) {
				try {
					retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				retailPharmaciesEntityIds.add(retailPharmacyRepository.save(entity).getId());
			}
			warehouseEntity.setRetailPharmaciesIds(retailPharmaciesEntityIds);

			returnSuppliersEntities = warehouseEntity.getReturnSuppliers();
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
			warehouseEntity.setReturnSuppliersIds(returnSuppliersEntityIds);

			sourceWarehousesEntities = warehouseEntity.getSourceWarehouses();
			Set<UUID> sourceWarehousesEntityIds = new HashSet<>();
			for (TransferOrderEntity entity : sourceWarehousesEntities) {
				try {
					transferOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				sourceWarehousesEntityIds.add(transferOrderRepository.save(entity).getId());
			}
			warehouseEntity.setSourceWarehousesIds(sourceWarehousesEntityIds);

			stockCataloguesEntities = warehouseEntity.getStockCatalogues();
			Set<UUID> stockCataloguesEntityIds = new HashSet<>();
			for (StockCatalogueEntity entity : stockCataloguesEntities) {
				try {
					stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				stockCataloguesEntityIds.add(stockCatalogueRepository.save(entity).getId());
			}
			warehouseEntity.setStockCataloguesIds(stockCataloguesEntityIds);

			stockControlsEntities = warehouseEntity.getStockControls();
			Set<UUID> stockControlsEntityIds = new HashSet<>();
			for (StockControlEntity entity : stockControlsEntities) {
				try {
					stockControlDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				stockControlsEntityIds.add(stockControlRepository.save(entity).getId());
			}
			warehouseEntity.setStockControlsIds(stockControlsEntityIds);

			stockTransactionDetailsEntities = warehouseEntity.getStockTransactionDetails();
			Set<UUID> stockTransactionDetailsEntityIds = new HashSet<>();
			for (StockTransactionDetailEntity entity : stockTransactionDetailsEntities) {
				try {
					stockTransactionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				stockTransactionDetailsEntityIds.add(stockTransactionDetailRepository.save(entity).getId());
			}
			warehouseEntity.setStockTransactionDetailsIds(stockTransactionDetailsEntityIds);

			stockTransactionPerDateTypesEntities = warehouseEntity.getStockTransactionPerDateTypes();
			Set<UUID> stockTransactionPerDateTypesEntityIds = new HashSet<>();
			for (StockTransactionPerDateTypeEntity entity : stockTransactionPerDateTypesEntities) {
				try {
					stockTransactionPerDateTypeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				stockTransactionPerDateTypesEntityIds.add(stockTransactionPerDateTypeRepository.save(entity).getId());
			}
			warehouseEntity.setStockTransactionPerDateTypesIds(stockTransactionPerDateTypesEntityIds);

			stockTransactionPerDatesEntities = warehouseEntity.getStockTransactionPerDates();
			Set<UUID> stockTransactionPerDatesEntityIds = new HashSet<>();
			for (StockTransactionPerDateEntity entity : stockTransactionPerDatesEntities) {
				try {
					stockTransactionPerDateDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				stockTransactionPerDatesEntityIds.add(stockTransactionPerDateRepository.save(entity).getId());
			}
			warehouseEntity.setStockTransactionPerDatesIds(stockTransactionPerDatesEntityIds);

			vaccinationOrderDetailsEntities = warehouseEntity.getVaccinationOrderDetails();
			Set<UUID> vaccinationOrderDetailsEntityIds = new HashSet<>();
			for (VaccinationOrderDetailEntity entity : vaccinationOrderDetailsEntities) {
				try {
					vaccinationOrderDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				vaccinationOrderDetailsEntityIds.add(vaccinationOrderDetailRepository.save(entity).getId());
			}
			warehouseEntity.setVaccinationOrderDetailsIds(vaccinationOrderDetailsEntityIds);

			warehouseInitialStockSEntities = warehouseEntity.getWarehouseInitialStockS();
			Set<UUID> warehouseInitialStockSEntityIds = new HashSet<>();
			for (WarehouseInitialStockEntity entity : warehouseInitialStockSEntities) {
				try {
					warehouseInitialStockDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				warehouseInitialStockSEntityIds.add(warehouseInitialStockRepository.save(entity).getId());
			}
			warehouseEntity.setWarehouseInitialStockSIds(warehouseInitialStockSEntityIds);

			warehouseInventoriesEntities = warehouseEntity.getWarehouseInventories();
			Set<UUID> warehouseInventoriesEntityIds = new HashSet<>();
			for (WarehouseInventoryEntity entity : warehouseInventoriesEntities) {
				try {
					warehouseInventoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				warehouseInventoriesEntityIds.add(warehouseInventoryRepository.save(entity).getId());
			}
			warehouseEntity.setWarehouseInventoriesIds(warehouseInventoriesEntityIds);


			warehouseEntity = warehouseService.create(warehouseEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(warehouseEntity.getBatchStockBalancesWarehouse().size() > 0);
			warehouseEntity.setBatchStockBalancesWarehouseIds(new HashSet<UUID>());
			warehouseEntity.unsetBatchStockBalancesWarehouse();

			Assertions.assertTrue(warehouseEntity.getBatchStockBalances().size() > 0);
			warehouseEntity.setBatchStockBalancesIds(new HashSet<UUID>());
			warehouseEntity.unsetBatchStockBalances();

			Assertions.assertTrue(warehouseEntity.getBatchStockTransactionDetails().size() > 0);
			warehouseEntity.setBatchStockTransactionDetailsIds(new HashSet<UUID>());
			warehouseEntity.unsetBatchStockTransactionDetails();

			Assertions.assertTrue(warehouseEntity.getDestinationWarehouses().size() > 0);
			warehouseEntity.setDestinationWarehousesIds(new HashSet<UUID>());
			warehouseEntity.unsetDestinationWarehouses();

			Assertions.assertTrue(warehouseEntity.getGoodsReceiveNoteBatchs().size() > 0);
			warehouseEntity.setGoodsReceiveNoteBatchsIds(new HashSet<UUID>());
			warehouseEntity.unsetGoodsReceiveNoteBatchs();

			Assertions.assertTrue(warehouseEntity.getGoodsReceiveNotes().size() > 0);
			warehouseEntity.setGoodsReceiveNotesIds(new HashSet<UUID>());
			warehouseEntity.unsetGoodsReceiveNotes();

			Assertions.assertTrue(warehouseEntity.getInternalOrders().size() > 0);
			warehouseEntity.setInternalOrdersIds(new HashSet<UUID>());
			warehouseEntity.unsetInternalOrders();

			Assertions.assertTrue(warehouseEntity.getInventoryAdjusmentBatchs().size() > 0);
			warehouseEntity.setInventoryAdjusmentBatchsIds(new HashSet<UUID>());
			warehouseEntity.unsetInventoryAdjusmentBatchs();

			Assertions.assertTrue(warehouseEntity.getInventoryAdjustments().size() > 0);
			warehouseEntity.setInventoryAdjustmentsIds(new HashSet<UUID>());
			warehouseEntity.unsetInventoryAdjustments();

			Assertions.assertTrue(warehouseEntity.getInventoryBatchCorrections().size() > 0);
			warehouseEntity.setInventoryBatchCorrectionsIds(new HashSet<UUID>());
			warehouseEntity.unsetInventoryBatchCorrections();

			Assertions.assertTrue(warehouseEntity.getLocations().size() > 0);
			warehouseEntity.setLocationsIds(new HashSet<UUID>());
			warehouseEntity.unsetLocations();

			Assertions.assertTrue(warehouseEntity.getMedicalFees().size() > 0);
			warehouseEntity.setMedicalFeesIds(new HashSet<UUID>());
			warehouseEntity.unsetMedicalFees();

			Assertions.assertTrue(warehouseEntity.getMedicationHeaders().size() > 0);
			warehouseEntity.setMedicationHeadersIds(new HashSet<UUID>());
			warehouseEntity.unsetMedicationHeaders();

			Assertions.assertTrue(warehouseEntity.getPrescriptionHeaders().size() > 0);
			warehouseEntity.setPrescriptionHeadersIds(new HashSet<UUID>());
			warehouseEntity.unsetPrescriptionHeaders();

			Assertions.assertTrue(warehouseEntity.getPurchaseOrders().size() > 0);
			warehouseEntity.setPurchaseOrdersIds(new HashSet<UUID>());
			warehouseEntity.unsetPurchaseOrders();

			Assertions.assertTrue(warehouseEntity.getPurchaseRequisitions().size() > 0);
			warehouseEntity.setPurchaseRequisitionsIds(new HashSet<UUID>());
			warehouseEntity.unsetPurchaseRequisitions();

			Assertions.assertTrue(warehouseEntity.getRetailPharmacies().size() > 0);
			warehouseEntity.setRetailPharmaciesIds(new HashSet<UUID>());
			warehouseEntity.unsetRetailPharmacies();

			Assertions.assertTrue(warehouseEntity.getReturnSuppliers().size() > 0);
			warehouseEntity.setReturnSuppliersIds(new HashSet<UUID>());
			warehouseEntity.unsetReturnSuppliers();

			Assertions.assertTrue(warehouseEntity.getSourceWarehouses().size() > 0);
			warehouseEntity.setSourceWarehousesIds(new HashSet<UUID>());
			warehouseEntity.unsetSourceWarehouses();

			Assertions.assertTrue(warehouseEntity.getStockCatalogues().size() > 0);
			warehouseEntity.setStockCataloguesIds(new HashSet<UUID>());
			warehouseEntity.unsetStockCatalogues();

			Assertions.assertTrue(warehouseEntity.getStockControls().size() > 0);
			warehouseEntity.setStockControlsIds(new HashSet<UUID>());
			warehouseEntity.unsetStockControls();

			Assertions.assertTrue(warehouseEntity.getStockTransactionDetails().size() > 0);
			warehouseEntity.setStockTransactionDetailsIds(new HashSet<UUID>());
			warehouseEntity.unsetStockTransactionDetails();

			Assertions.assertTrue(warehouseEntity.getStockTransactionPerDateTypes().size() > 0);
			warehouseEntity.setStockTransactionPerDateTypesIds(new HashSet<UUID>());
			warehouseEntity.unsetStockTransactionPerDateTypes();

			Assertions.assertTrue(warehouseEntity.getStockTransactionPerDates().size() > 0);
			warehouseEntity.setStockTransactionPerDatesIds(new HashSet<UUID>());
			warehouseEntity.unsetStockTransactionPerDates();

			Assertions.assertTrue(warehouseEntity.getVaccinationOrderDetails().size() > 0);
			warehouseEntity.setVaccinationOrderDetailsIds(new HashSet<UUID>());
			warehouseEntity.unsetVaccinationOrderDetails();

			Assertions.assertTrue(warehouseEntity.getWarehouseInitialStockS().size() > 0);
			warehouseEntity.setWarehouseInitialStockSIds(new HashSet<UUID>());
			warehouseEntity.unsetWarehouseInitialStockS();

			Assertions.assertTrue(warehouseEntity.getWarehouseInventories().size() > 0);
			warehouseEntity.setWarehouseInventoriesIds(new HashSet<UUID>());
			warehouseEntity.unsetWarehouseInventories();


			updatedWarehouseEntity = warehouseService.updateOldData(warehouseEntity);

			Assertions.assertEquals(0, updatedWarehouseEntity.getBatchStockBalancesWarehouse().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getBatchStockBalances().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getBatchStockTransactionDetails().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getDestinationWarehouses().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getGoodsReceiveNoteBatchs().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getGoodsReceiveNotes().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getInternalOrders().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getInventoryAdjusmentBatchs().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getInventoryAdjustments().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getInventoryBatchCorrections().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getLocations().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getMedicalFees().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getMedicationHeaders().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getPrescriptionHeaders().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getPurchaseOrders().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getPurchaseRequisitions().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getRetailPharmacies().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getReturnSuppliers().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getSourceWarehouses().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getStockCatalogues().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getStockControls().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getStockTransactionDetails().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getStockTransactionPerDateTypes().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getStockTransactionPerDates().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getVaccinationOrderDetails().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getWarehouseInitialStockS().size());

			Assertions.assertEquals(0, updatedWarehouseEntity.getWarehouseInventories().size());

		});
	}

	@Test
	public void updateOldDataWithWarehouseEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			WarehouseEntity warehouseEntity;
			WarehouseEntity updatedWarehouseEntity;

			Set<BatchStockBalanceEntity> batchStockBalancesWarehouseEntities;
			Set<UUID> batchStockBalancesWarehouseEntityIds;

			Set<BatchStockBalancePerDateEntity> batchStockBalancesEntities;
			Set<UUID> batchStockBalancesEntityIds;

			Set<BatchStockTransactionDetailEntity> batchStockTransactionDetailsEntities;
			Set<UUID> batchStockTransactionDetailsEntityIds;

			Set<TransferOrderEntity> destinationWarehousesEntities;
			Set<UUID> destinationWarehousesEntityIds;

			Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchsEntities;
			Set<UUID> goodsReceiveNoteBatchsEntityIds;

			Set<GoodsReceiveNoteEntity> goodsReceiveNotesEntities;
			Set<UUID> goodsReceiveNotesEntityIds;

			Set<InternalOrderEntity> internalOrdersEntities;
			Set<UUID> internalOrdersEntityIds;

			Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchsEntities;
			Set<UUID> inventoryAdjusmentBatchsEntityIds;

			Set<InventoryAdjustmentEntity> inventoryAdjustmentsEntities;
			Set<UUID> inventoryAdjustmentsEntityIds;

			Set<InventoryBatchCorrectionEntity> inventoryBatchCorrectionsEntities;
			Set<UUID> inventoryBatchCorrectionsEntityIds;

			Set<LocationEntity> locationsEntities;
			Set<UUID> locationsEntityIds;

			Set<MedicalFeeEntity> medicalFeesEntities;
			Set<UUID> medicalFeesEntityIds;

			Set<MedicationHeaderEntity> medicationHeadersEntities;
			Set<UUID> medicationHeadersEntityIds;

			Set<PrescriptionHeaderEntity> prescriptionHeadersEntities;
			Set<UUID> prescriptionHeadersEntityIds;

			Set<PurchaseOrderEntity> purchaseOrdersEntities;
			Set<UUID> purchaseOrdersEntityIds;

			Set<PurchaseRequisitionEntity> purchaseRequisitionsEntities;
			Set<UUID> purchaseRequisitionsEntityIds;

			Set<RetailPharmacyEntity> retailPharmaciesEntities;
			Set<UUID> retailPharmaciesEntityIds;

			Set<ReturnSupplierEntity> returnSuppliersEntities;
			Set<UUID> returnSuppliersEntityIds;

			Set<TransferOrderEntity> sourceWarehousesEntities;
			Set<UUID> sourceWarehousesEntityIds;

			Set<StockCatalogueEntity> stockCataloguesEntities;
			Set<UUID> stockCataloguesEntityIds;

			Set<StockControlEntity> stockControlsEntities;
			Set<UUID> stockControlsEntityIds;

			Set<StockTransactionDetailEntity> stockTransactionDetailsEntities;
			Set<UUID> stockTransactionDetailsEntityIds;

			Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypesEntities;
			Set<UUID> stockTransactionPerDateTypesEntityIds;

			Set<StockTransactionPerDateEntity> stockTransactionPerDatesEntities;
			Set<UUID> stockTransactionPerDatesEntityIds;

			Set<VaccinationOrderDetailEntity> vaccinationOrderDetailsEntities;
			Set<UUID> vaccinationOrderDetailsEntityIds;

			Set<WarehouseInitialStockEntity> warehouseInitialStockSEntities;
			Set<UUID> warehouseInitialStockSEntityIds;

			Set<WarehouseInventoryEntity> warehouseInventoriesEntities;
			Set<UUID> warehouseInventoriesEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				warehouseEntity = warehouseFactory.getObject(true, false);
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
			batchStockBalancesWarehouseEntities = new HashSet<>();
			batchStockBalancesWarehouseEntityIds = new HashSet<>();
			for (BatchStockBalanceEntity entity : warehouseEntity.getBatchStockBalancesWarehouse()) {
				try {
					batchStockBalanceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Batch Stock Balances Warehouse relation for this test: " + e.getCause());
					return;
				}
				UUID id = batchStockBalanceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				batchStockBalancesWarehouseEntities.add(batchStockBalanceRepository.findById(id).get());
				batchStockBalancesWarehouseEntityIds.add(id);
			}
			warehouseEntity.unsetBatchStockBalancesWarehouse();
			warehouseEntity.setBatchStockBalancesWarehouseIds(batchStockBalancesWarehouseEntityIds);

			batchStockBalancesEntities = new HashSet<>();
			batchStockBalancesEntityIds = new HashSet<>();
			for (BatchStockBalancePerDateEntity entity : warehouseEntity.getBatchStockBalances()) {
				try {
					batchStockBalancePerDateDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Batch Stock Balances relation for this test: " + e.getCause());
					return;
				}
				UUID id = batchStockBalancePerDateRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				batchStockBalancesEntities.add(batchStockBalancePerDateRepository.findById(id).get());
				batchStockBalancesEntityIds.add(id);
			}
			warehouseEntity.unsetBatchStockBalances();
			warehouseEntity.setBatchStockBalancesIds(batchStockBalancesEntityIds);

			batchStockTransactionDetailsEntities = new HashSet<>();
			batchStockTransactionDetailsEntityIds = new HashSet<>();
			for (BatchStockTransactionDetailEntity entity : warehouseEntity.getBatchStockTransactionDetails()) {
				try {
					batchStockTransactionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Batch Stock Transaction Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = batchStockTransactionDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				batchStockTransactionDetailsEntities.add(batchStockTransactionDetailRepository.findById(id).get());
				batchStockTransactionDetailsEntityIds.add(id);
			}
			warehouseEntity.unsetBatchStockTransactionDetails();
			warehouseEntity.setBatchStockTransactionDetailsIds(batchStockTransactionDetailsEntityIds);

			destinationWarehousesEntities = new HashSet<>();
			destinationWarehousesEntityIds = new HashSet<>();
			for (TransferOrderEntity entity : warehouseEntity.getDestinationWarehouses()) {
				try {
					transferOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Destination Warehouses relation for this test: " + e.getCause());
					return;
				}
				UUID id = transferOrderRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				destinationWarehousesEntities.add(transferOrderRepository.findById(id).get());
				destinationWarehousesEntityIds.add(id);
			}
			warehouseEntity.unsetDestinationWarehouses();
			warehouseEntity.setDestinationWarehousesIds(destinationWarehousesEntityIds);

			goodsReceiveNoteBatchsEntities = new HashSet<>();
			goodsReceiveNoteBatchsEntityIds = new HashSet<>();
			for (GoodsReceiveNoteBatchEntity entity : warehouseEntity.getGoodsReceiveNoteBatchs()) {
				try {
					goodsReceiveNoteBatchDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Goods Receive Note Batchs relation for this test: " + e.getCause());
					return;
				}
				UUID id = goodsReceiveNoteBatchRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				goodsReceiveNoteBatchsEntities.add(goodsReceiveNoteBatchRepository.findById(id).get());
				goodsReceiveNoteBatchsEntityIds.add(id);
			}
			warehouseEntity.unsetGoodsReceiveNoteBatchs();
			warehouseEntity.setGoodsReceiveNoteBatchsIds(goodsReceiveNoteBatchsEntityIds);

			goodsReceiveNotesEntities = new HashSet<>();
			goodsReceiveNotesEntityIds = new HashSet<>();
			for (GoodsReceiveNoteEntity entity : warehouseEntity.getGoodsReceiveNotes()) {
				try {
					goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Goods Receive Notes relation for this test: " + e.getCause());
					return;
				}
				UUID id = goodsReceiveNoteRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				goodsReceiveNotesEntities.add(goodsReceiveNoteRepository.findById(id).get());
				goodsReceiveNotesEntityIds.add(id);
			}
			warehouseEntity.unsetGoodsReceiveNotes();
			warehouseEntity.setGoodsReceiveNotesIds(goodsReceiveNotesEntityIds);

			internalOrdersEntities = new HashSet<>();
			internalOrdersEntityIds = new HashSet<>();
			for (InternalOrderEntity entity : warehouseEntity.getInternalOrders()) {
				try {
					internalOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Internal Orders relation for this test: " + e.getCause());
					return;
				}
				UUID id = internalOrderRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				internalOrdersEntities.add(internalOrderRepository.findById(id).get());
				internalOrdersEntityIds.add(id);
			}
			warehouseEntity.unsetInternalOrders();
			warehouseEntity.setInternalOrdersIds(internalOrdersEntityIds);

			inventoryAdjusmentBatchsEntities = new HashSet<>();
			inventoryAdjusmentBatchsEntityIds = new HashSet<>();
			for (InventoryAdjusmentBatchEntity entity : warehouseEntity.getInventoryAdjusmentBatchs()) {
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
			warehouseEntity.unsetInventoryAdjusmentBatchs();
			warehouseEntity.setInventoryAdjusmentBatchsIds(inventoryAdjusmentBatchsEntityIds);

			inventoryAdjustmentsEntities = new HashSet<>();
			inventoryAdjustmentsEntityIds = new HashSet<>();
			for (InventoryAdjustmentEntity entity : warehouseEntity.getInventoryAdjustments()) {
				try {
					inventoryAdjustmentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Inventory Adjustments relation for this test: " + e.getCause());
					return;
				}
				UUID id = inventoryAdjustmentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				inventoryAdjustmentsEntities.add(inventoryAdjustmentRepository.findById(id).get());
				inventoryAdjustmentsEntityIds.add(id);
			}
			warehouseEntity.unsetInventoryAdjustments();
			warehouseEntity.setInventoryAdjustmentsIds(inventoryAdjustmentsEntityIds);

			inventoryBatchCorrectionsEntities = new HashSet<>();
			inventoryBatchCorrectionsEntityIds = new HashSet<>();
			for (InventoryBatchCorrectionEntity entity : warehouseEntity.getInventoryBatchCorrections()) {
				try {
					inventoryBatchCorrectionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Inventory Batch Corrections relation for this test: " + e.getCause());
					return;
				}
				UUID id = inventoryBatchCorrectionRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				inventoryBatchCorrectionsEntities.add(inventoryBatchCorrectionRepository.findById(id).get());
				inventoryBatchCorrectionsEntityIds.add(id);
			}
			warehouseEntity.unsetInventoryBatchCorrections();
			warehouseEntity.setInventoryBatchCorrectionsIds(inventoryBatchCorrectionsEntityIds);

			locationsEntities = new HashSet<>();
			locationsEntityIds = new HashSet<>();
			for (LocationEntity entity : warehouseEntity.getLocations()) {
				try {
					locationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Locations relation for this test: " + e.getCause());
					return;
				}
				UUID id = locationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				locationsEntities.add(locationRepository.findById(id).get());
				locationsEntityIds.add(id);
			}
			warehouseEntity.unsetLocations();
			warehouseEntity.setLocationsIds(locationsEntityIds);

			medicalFeesEntities = new HashSet<>();
			medicalFeesEntityIds = new HashSet<>();
			for (MedicalFeeEntity entity : warehouseEntity.getMedicalFees()) {
				try {
					medicalFeeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Fees relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalFeeRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalFeesEntities.add(medicalFeeRepository.findById(id).get());
				medicalFeesEntityIds.add(id);
			}
			warehouseEntity.unsetMedicalFees();
			warehouseEntity.setMedicalFeesIds(medicalFeesEntityIds);

			medicationHeadersEntities = new HashSet<>();
			medicationHeadersEntityIds = new HashSet<>();
			for (MedicationHeaderEntity entity : warehouseEntity.getMedicationHeaders()) {
				try {
					medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medication Headers relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicationHeaderRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicationHeadersEntities.add(medicationHeaderRepository.findById(id).get());
				medicationHeadersEntityIds.add(id);
			}
			warehouseEntity.unsetMedicationHeaders();
			warehouseEntity.setMedicationHeadersIds(medicationHeadersEntityIds);

			prescriptionHeadersEntities = new HashSet<>();
			prescriptionHeadersEntityIds = new HashSet<>();
			for (PrescriptionHeaderEntity entity : warehouseEntity.getPrescriptionHeaders()) {
				try {
					prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Prescription Headers relation for this test: " + e.getCause());
					return;
				}
				UUID id = prescriptionHeaderRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				prescriptionHeadersEntities.add(prescriptionHeaderRepository.findById(id).get());
				prescriptionHeadersEntityIds.add(id);
			}
			warehouseEntity.unsetPrescriptionHeaders();
			warehouseEntity.setPrescriptionHeadersIds(prescriptionHeadersEntityIds);

			purchaseOrdersEntities = new HashSet<>();
			purchaseOrdersEntityIds = new HashSet<>();
			for (PurchaseOrderEntity entity : warehouseEntity.getPurchaseOrders()) {
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
			warehouseEntity.unsetPurchaseOrders();
			warehouseEntity.setPurchaseOrdersIds(purchaseOrdersEntityIds);

			purchaseRequisitionsEntities = new HashSet<>();
			purchaseRequisitionsEntityIds = new HashSet<>();
			for (PurchaseRequisitionEntity entity : warehouseEntity.getPurchaseRequisitions()) {
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
			warehouseEntity.unsetPurchaseRequisitions();
			warehouseEntity.setPurchaseRequisitionsIds(purchaseRequisitionsEntityIds);

			retailPharmaciesEntities = new HashSet<>();
			retailPharmaciesEntityIds = new HashSet<>();
			for (RetailPharmacyEntity entity : warehouseEntity.getRetailPharmacies()) {
				try {
					retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Retail Pharmacies relation for this test: " + e.getCause());
					return;
				}
				UUID id = retailPharmacyRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				retailPharmaciesEntities.add(retailPharmacyRepository.findById(id).get());
				retailPharmaciesEntityIds.add(id);
			}
			warehouseEntity.unsetRetailPharmacies();
			warehouseEntity.setRetailPharmaciesIds(retailPharmaciesEntityIds);

			returnSuppliersEntities = new HashSet<>();
			returnSuppliersEntityIds = new HashSet<>();
			for (ReturnSupplierEntity entity : warehouseEntity.getReturnSuppliers()) {
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
			warehouseEntity.unsetReturnSuppliers();
			warehouseEntity.setReturnSuppliersIds(returnSuppliersEntityIds);

			sourceWarehousesEntities = new HashSet<>();
			sourceWarehousesEntityIds = new HashSet<>();
			for (TransferOrderEntity entity : warehouseEntity.getSourceWarehouses()) {
				try {
					transferOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Source Warehouses relation for this test: " + e.getCause());
					return;
				}
				UUID id = transferOrderRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				sourceWarehousesEntities.add(transferOrderRepository.findById(id).get());
				sourceWarehousesEntityIds.add(id);
			}
			warehouseEntity.unsetSourceWarehouses();
			warehouseEntity.setSourceWarehousesIds(sourceWarehousesEntityIds);

			stockCataloguesEntities = new HashSet<>();
			stockCataloguesEntityIds = new HashSet<>();
			for (StockCatalogueEntity entity : warehouseEntity.getStockCatalogues()) {
				try {
					stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Stock Catalogues relation for this test: " + e.getCause());
					return;
				}
				UUID id = stockCatalogueRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				stockCataloguesEntities.add(stockCatalogueRepository.findById(id).get());
				stockCataloguesEntityIds.add(id);
			}
			warehouseEntity.unsetStockCatalogues();
			warehouseEntity.setStockCataloguesIds(stockCataloguesEntityIds);

			stockControlsEntities = new HashSet<>();
			stockControlsEntityIds = new HashSet<>();
			for (StockControlEntity entity : warehouseEntity.getStockControls()) {
				try {
					stockControlDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Stock Controls relation for this test: " + e.getCause());
					return;
				}
				UUID id = stockControlRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				stockControlsEntities.add(stockControlRepository.findById(id).get());
				stockControlsEntityIds.add(id);
			}
			warehouseEntity.unsetStockControls();
			warehouseEntity.setStockControlsIds(stockControlsEntityIds);

			stockTransactionDetailsEntities = new HashSet<>();
			stockTransactionDetailsEntityIds = new HashSet<>();
			for (StockTransactionDetailEntity entity : warehouseEntity.getStockTransactionDetails()) {
				try {
					stockTransactionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Stock Transaction Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = stockTransactionDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				stockTransactionDetailsEntities.add(stockTransactionDetailRepository.findById(id).get());
				stockTransactionDetailsEntityIds.add(id);
			}
			warehouseEntity.unsetStockTransactionDetails();
			warehouseEntity.setStockTransactionDetailsIds(stockTransactionDetailsEntityIds);

			stockTransactionPerDateTypesEntities = new HashSet<>();
			stockTransactionPerDateTypesEntityIds = new HashSet<>();
			for (StockTransactionPerDateTypeEntity entity : warehouseEntity.getStockTransactionPerDateTypes()) {
				try {
					stockTransactionPerDateTypeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Stock Transaction Per Date Types relation for this test: " + e.getCause());
					return;
				}
				UUID id = stockTransactionPerDateTypeRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				stockTransactionPerDateTypesEntities.add(stockTransactionPerDateTypeRepository.findById(id).get());
				stockTransactionPerDateTypesEntityIds.add(id);
			}
			warehouseEntity.unsetStockTransactionPerDateTypes();
			warehouseEntity.setStockTransactionPerDateTypesIds(stockTransactionPerDateTypesEntityIds);

			stockTransactionPerDatesEntities = new HashSet<>();
			stockTransactionPerDatesEntityIds = new HashSet<>();
			for (StockTransactionPerDateEntity entity : warehouseEntity.getStockTransactionPerDates()) {
				try {
					stockTransactionPerDateDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Stock Transaction Per Dates relation for this test: " + e.getCause());
					return;
				}
				UUID id = stockTransactionPerDateRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				stockTransactionPerDatesEntities.add(stockTransactionPerDateRepository.findById(id).get());
				stockTransactionPerDatesEntityIds.add(id);
			}
			warehouseEntity.unsetStockTransactionPerDates();
			warehouseEntity.setStockTransactionPerDatesIds(stockTransactionPerDatesEntityIds);

			vaccinationOrderDetailsEntities = new HashSet<>();
			vaccinationOrderDetailsEntityIds = new HashSet<>();
			for (VaccinationOrderDetailEntity entity : warehouseEntity.getVaccinationOrderDetails()) {
				try {
					vaccinationOrderDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Vaccination Order Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = vaccinationOrderDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				vaccinationOrderDetailsEntities.add(vaccinationOrderDetailRepository.findById(id).get());
				vaccinationOrderDetailsEntityIds.add(id);
			}
			warehouseEntity.unsetVaccinationOrderDetails();
			warehouseEntity.setVaccinationOrderDetailsIds(vaccinationOrderDetailsEntityIds);

			warehouseInitialStockSEntities = new HashSet<>();
			warehouseInitialStockSEntityIds = new HashSet<>();
			for (WarehouseInitialStockEntity entity : warehouseEntity.getWarehouseInitialStockS()) {
				try {
					warehouseInitialStockDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Warehouse Initial Stock s relation for this test: " + e.getCause());
					return;
				}
				UUID id = warehouseInitialStockRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				warehouseInitialStockSEntities.add(warehouseInitialStockRepository.findById(id).get());
				warehouseInitialStockSEntityIds.add(id);
			}
			warehouseEntity.unsetWarehouseInitialStockS();
			warehouseEntity.setWarehouseInitialStockSIds(warehouseInitialStockSEntityIds);

			warehouseInventoriesEntities = new HashSet<>();
			warehouseInventoriesEntityIds = new HashSet<>();
			for (WarehouseInventoryEntity entity : warehouseEntity.getWarehouseInventories()) {
				try {
					warehouseInventoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Warehouse Inventories relation for this test: " + e.getCause());
					return;
				}
				UUID id = warehouseInventoryRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				warehouseInventoriesEntities.add(warehouseInventoryRepository.findById(id).get());
				warehouseInventoriesEntityIds.add(id);
			}
			warehouseEntity.unsetWarehouseInventories();
			warehouseEntity.setWarehouseInventoriesIds(warehouseInventoriesEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedWarehouseEntity = warehouseService.updateOldData(warehouseEntity);

			Assertions.assertEquals(batchStockBalancesWarehouseEntities.size(), updatedWarehouseEntity.getBatchStockBalancesWarehouse().size());

			Assertions.assertEquals(batchStockBalancesEntities.size(), updatedWarehouseEntity.getBatchStockBalances().size());

			Assertions.assertEquals(batchStockTransactionDetailsEntities.size(), updatedWarehouseEntity.getBatchStockTransactionDetails().size());

			Assertions.assertEquals(destinationWarehousesEntities.size(), updatedWarehouseEntity.getDestinationWarehouses().size());

			Assertions.assertEquals(goodsReceiveNoteBatchsEntities.size(), updatedWarehouseEntity.getGoodsReceiveNoteBatchs().size());

			Assertions.assertEquals(goodsReceiveNotesEntities.size(), updatedWarehouseEntity.getGoodsReceiveNotes().size());

			Assertions.assertEquals(internalOrdersEntities.size(), updatedWarehouseEntity.getInternalOrders().size());

			Assertions.assertEquals(inventoryAdjusmentBatchsEntities.size(), updatedWarehouseEntity.getInventoryAdjusmentBatchs().size());

			Assertions.assertEquals(inventoryAdjustmentsEntities.size(), updatedWarehouseEntity.getInventoryAdjustments().size());

			Assertions.assertEquals(inventoryBatchCorrectionsEntities.size(), updatedWarehouseEntity.getInventoryBatchCorrections().size());

			Assertions.assertEquals(locationsEntities.size(), updatedWarehouseEntity.getLocations().size());

			Assertions.assertEquals(medicalFeesEntities.size(), updatedWarehouseEntity.getMedicalFees().size());

			Assertions.assertEquals(medicationHeadersEntities.size(), updatedWarehouseEntity.getMedicationHeaders().size());

			Assertions.assertEquals(prescriptionHeadersEntities.size(), updatedWarehouseEntity.getPrescriptionHeaders().size());

			Assertions.assertEquals(purchaseOrdersEntities.size(), updatedWarehouseEntity.getPurchaseOrders().size());

			Assertions.assertEquals(purchaseRequisitionsEntities.size(), updatedWarehouseEntity.getPurchaseRequisitions().size());

			Assertions.assertEquals(retailPharmaciesEntities.size(), updatedWarehouseEntity.getRetailPharmacies().size());

			Assertions.assertEquals(returnSuppliersEntities.size(), updatedWarehouseEntity.getReturnSuppliers().size());

			Assertions.assertEquals(sourceWarehousesEntities.size(), updatedWarehouseEntity.getSourceWarehouses().size());

			Assertions.assertEquals(stockCataloguesEntities.size(), updatedWarehouseEntity.getStockCatalogues().size());

			Assertions.assertEquals(stockControlsEntities.size(), updatedWarehouseEntity.getStockControls().size());

			Assertions.assertEquals(stockTransactionDetailsEntities.size(), updatedWarehouseEntity.getStockTransactionDetails().size());

			Assertions.assertEquals(stockTransactionPerDateTypesEntities.size(), updatedWarehouseEntity.getStockTransactionPerDateTypes().size());

			Assertions.assertEquals(stockTransactionPerDatesEntities.size(), updatedWarehouseEntity.getStockTransactionPerDates().size());

			Assertions.assertEquals(vaccinationOrderDetailsEntities.size(), updatedWarehouseEntity.getVaccinationOrderDetails().size());

			Assertions.assertEquals(warehouseInitialStockSEntities.size(), updatedWarehouseEntity.getWarehouseInitialStockS().size());

			Assertions.assertEquals(warehouseInventoriesEntities.size(), updatedWarehouseEntity.getWarehouseInventories().size());

		});
	}

	@Test
	public void whenCreateWarehouseEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			WarehouseEntity warehouseEntity;
			Optional<WarehouseEntity> fetchedWarehouseEntity;

			try {
				warehouseEntity = warehouseFactory.getObject(false, false);
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			warehouseEntity = warehouseService.create(warehouseEntity);

			fetchedWarehouseEntity = warehouseService.findById(warehouseEntity.getId());

			Assertions.assertTrue(fetchedWarehouseEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedWarehouseEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(warehouseEntity, fetchedWarehouseEntity.get());
		});
	}

	@Test
	public void whenUpdateWarehouseEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			WarehouseEntity warehouseEntity;
			WarehouseEntity updatedWarehouseEntity;
			Optional<WarehouseEntity> fetchedWarehouseEntity;

			try {
				warehouseEntity = warehouseFactory.getObject(false, false);
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, false);
				updatedWarehouseEntity = warehouseFactory.getObject(false, false);
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(updatedWarehouseEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			warehouseEntity = warehouseService.create(warehouseEntity);

			updatedWarehouseEntity.setId(warehouseEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedWarehouseEntity.setCreated(warehouseEntity.getCreated());

			updatedWarehouseEntity = warehouseService.update(updatedWarehouseEntity);

			fetchedWarehouseEntity = warehouseService.findById(warehouseEntity.getId());

			Assertions.assertTrue(fetchedWarehouseEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateWarehouseEntity_ThenEntityIsCreated
			fetchedWarehouseEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedWarehouseEntity, fetchedWarehouseEntity.get());
		});
	}

	@Test
	public void whenDeleteWarehouseEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			WarehouseEntity warehouseEntity;
			Optional<WarehouseEntity> fetchedWarehouseEntity;

			try {
				warehouseEntity = warehouseFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			warehouseEntity = warehouseService.create(warehouseEntity);

			warehouseService.deleteById(warehouseEntity.getId());
			fetchedWarehouseEntity = warehouseService.findById(warehouseEntity.getId());

			Assertions.assertTrue(fetchedWarehouseEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
