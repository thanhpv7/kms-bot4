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
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.utils.StockCatalogueFactory;
import kmsweb.utils.DatabasePopulators.StockCatalogueDatabasePopulator;
import kmsweb.entities.BpjsDrugGenericPRBEntity;
import kmsweb.repositories.BpjsDrugGenericPRBRepository;
import kmsweb.utils.BpjsDrugGenericPRBFactory;
import kmsweb.utils.DatabasePopulators.BpjsDrugGenericPRBDatabasePopulator;
import kmsweb.entities.BpjsPcareDPHOEntity;
import kmsweb.repositories.BpjsPcareDPHORepository;
import kmsweb.utils.BpjsPcareDPHOFactory;
import kmsweb.utils.DatabasePopulators.BpjsPcareDPHODatabasePopulator;
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
import kmsweb.entities.CatalogueMedicalEntity;
import kmsweb.repositories.CatalogueMedicalRepository;
import kmsweb.utils.CatalogueMedicalFactory;
import kmsweb.utils.DatabasePopulators.CatalogueMedicalDatabasePopulator;
import kmsweb.entities.CatalogueNonMedicalEntity;
import kmsweb.repositories.CatalogueNonMedicalRepository;
import kmsweb.utils.CatalogueNonMedicalFactory;
import kmsweb.utils.DatabasePopulators.CatalogueNonMedicalDatabasePopulator;
import kmsweb.entities.CatalogueUOMEntity;
import kmsweb.repositories.CatalogueUOMRepository;
import kmsweb.utils.CatalogueUOMFactory;
import kmsweb.utils.DatabasePopulators.CatalogueUOMDatabasePopulator;
import kmsweb.entities.CompoundPrescriptionItemEntity;
import kmsweb.repositories.CompoundPrescriptionItemRepository;
import kmsweb.utils.CompoundPrescriptionItemFactory;
import kmsweb.utils.DatabasePopulators.CompoundPrescriptionItemDatabasePopulator;
import kmsweb.entities.GoodsReceiveNoteBatchEntity;
import kmsweb.repositories.GoodsReceiveNoteBatchRepository;
import kmsweb.utils.GoodsReceiveNoteBatchFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteBatchDatabasePopulator;
import kmsweb.entities.GoodsReceiveNoteItemEntity;
import kmsweb.repositories.GoodsReceiveNoteItemRepository;
import kmsweb.utils.GoodsReceiveNoteItemFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteItemDatabasePopulator;
import kmsweb.entities.InternalOrderStockDetailEntity;
import kmsweb.repositories.InternalOrderStockDetailRepository;
import kmsweb.utils.InternalOrderStockDetailFactory;
import kmsweb.utils.DatabasePopulators.InternalOrderStockDetailDatabasePopulator;
import kmsweb.entities.InventoryAdjusmentBatchEntity;
import kmsweb.repositories.InventoryAdjusmentBatchRepository;
import kmsweb.utils.InventoryAdjusmentBatchFactory;
import kmsweb.utils.DatabasePopulators.InventoryAdjusmentBatchDatabasePopulator;
import kmsweb.entities.InventoryAdjustmentItemEntity;
import kmsweb.repositories.InventoryAdjustmentItemRepository;
import kmsweb.utils.InventoryAdjustmentItemFactory;
import kmsweb.utils.DatabasePopulators.InventoryAdjustmentItemDatabasePopulator;
import kmsweb.entities.InventoryBatchCorrectionItemEntity;
import kmsweb.repositories.InventoryBatchCorrectionItemRepository;
import kmsweb.utils.InventoryBatchCorrectionItemFactory;
import kmsweb.utils.DatabasePopulators.InventoryBatchCorrectionItemDatabasePopulator;
import kmsweb.entities.MedicationItemEntity;
import kmsweb.repositories.MedicationItemRepository;
import kmsweb.utils.MedicationItemFactory;
import kmsweb.utils.DatabasePopulators.MedicationItemDatabasePopulator;
import kmsweb.entities.PrescriptionItemEntity;
import kmsweb.repositories.PrescriptionItemRepository;
import kmsweb.utils.PrescriptionItemFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionItemDatabasePopulator;
import kmsweb.entities.PurchaseOrderStockDetailEntity;
import kmsweb.repositories.PurchaseOrderStockDetailRepository;
import kmsweb.utils.PurchaseOrderStockDetailFactory;
import kmsweb.utils.DatabasePopulators.PurchaseOrderStockDetailDatabasePopulator;
import kmsweb.entities.PurchaseRequisitionStockDetailEntity;
import kmsweb.repositories.PurchaseRequisitionStockDetailRepository;
import kmsweb.utils.PurchaseRequisitionStockDetailFactory;
import kmsweb.utils.DatabasePopulators.PurchaseRequisitionStockDetailDatabasePopulator;
import kmsweb.entities.RetailPharmacyStockDetailEntity;
import kmsweb.repositories.RetailPharmacyStockDetailRepository;
import kmsweb.utils.RetailPharmacyStockDetailFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyStockDetailDatabasePopulator;
import kmsweb.entities.ReturnSupplierStockDetailEntity;
import kmsweb.repositories.ReturnSupplierStockDetailRepository;
import kmsweb.utils.ReturnSupplierStockDetailFactory;
import kmsweb.utils.DatabasePopulators.ReturnSupplierStockDetailDatabasePopulator;
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
import kmsweb.entities.SupplierProductDetailEntity;
import kmsweb.repositories.SupplierProductDetailRepository;
import kmsweb.utils.SupplierProductDetailFactory;
import kmsweb.utils.DatabasePopulators.SupplierProductDetailDatabasePopulator;
import kmsweb.entities.TransferOrderStockDetailEntity;
import kmsweb.repositories.TransferOrderStockDetailRepository;
import kmsweb.utils.TransferOrderStockDetailFactory;
import kmsweb.utils.DatabasePopulators.TransferOrderStockDetailDatabasePopulator;
import kmsweb.entities.VaccinationOrderDetailEntity;
import kmsweb.repositories.VaccinationOrderDetailRepository;
import kmsweb.utils.VaccinationOrderDetailFactory;
import kmsweb.utils.DatabasePopulators.VaccinationOrderDetailDatabasePopulator;
import kmsweb.entities.WarehouseEntity;
import kmsweb.repositories.WarehouseRepository;
import kmsweb.utils.WarehouseFactory;
import kmsweb.utils.DatabasePopulators.WarehouseDatabasePopulator;
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
public class StockCatalogueServiceIntegrationTest {

	@Autowired
	private StockCatalogueRepository stockCatalogueRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private StockCatalogueService stockCatalogueService;

	private final StockCatalogueFactory stockCatalogueFactory = new StockCatalogueFactory();

	@Autowired
	private StockCatalogueDatabasePopulator stockCatalogueDatabasePopulator;

	@Autowired
	private BpjsDrugGenericPRBRepository bpjsDrugGenericPRBRepository;

	@Autowired
	private BpjsDrugGenericPRBDatabasePopulator bpjsDrugGenericPRBDatabasePopulator;

	private final BpjsDrugGenericPRBFactory bpjsDrugGenericPRBFactory = new BpjsDrugGenericPRBFactory();

	@Autowired
	private BpjsPcareDPHORepository bpjsPcareDPHORepository;

	@Autowired
	private BpjsPcareDPHODatabasePopulator bpjsPcareDPHODatabasePopulator;

	private final BpjsPcareDPHOFactory bpjsPcareDPHOFactory = new BpjsPcareDPHOFactory();

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
	private CatalogueMedicalRepository catalogueMedicalRepository;

	@Autowired
	private CatalogueMedicalDatabasePopulator catalogueMedicalDatabasePopulator;

	private final CatalogueMedicalFactory catalogueMedicalFactory = new CatalogueMedicalFactory();

	@Autowired
	private CatalogueNonMedicalRepository catalogueNonMedicalRepository;

	@Autowired
	private CatalogueNonMedicalDatabasePopulator catalogueNonMedicalDatabasePopulator;

	private final CatalogueNonMedicalFactory catalogueNonMedicalFactory = new CatalogueNonMedicalFactory();

	@Autowired
	private CatalogueUOMRepository catalogueUOMRepository;

	@Autowired
	private CatalogueUOMDatabasePopulator catalogueUOMDatabasePopulator;

	private final CatalogueUOMFactory catalogueUOMFactory = new CatalogueUOMFactory();

	@Autowired
	private CompoundPrescriptionItemRepository compoundPrescriptionItemRepository;

	@Autowired
	private CompoundPrescriptionItemDatabasePopulator compoundPrescriptionItemDatabasePopulator;

	private final CompoundPrescriptionItemFactory compoundPrescriptionItemFactory = new CompoundPrescriptionItemFactory();

	@Autowired
	private GoodsReceiveNoteBatchRepository goodsReceiveNoteBatchRepository;

	@Autowired
	private GoodsReceiveNoteBatchDatabasePopulator goodsReceiveNoteBatchDatabasePopulator;

	private final GoodsReceiveNoteBatchFactory goodsReceiveNoteBatchFactory = new GoodsReceiveNoteBatchFactory();

	@Autowired
	private GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository;

	@Autowired
	private GoodsReceiveNoteItemDatabasePopulator goodsReceiveNoteItemDatabasePopulator;

	private final GoodsReceiveNoteItemFactory goodsReceiveNoteItemFactory = new GoodsReceiveNoteItemFactory();

	@Autowired
	private InternalOrderStockDetailRepository internalOrderStockDetailRepository;

	@Autowired
	private InternalOrderStockDetailDatabasePopulator internalOrderStockDetailDatabasePopulator;

	private final InternalOrderStockDetailFactory internalOrderStockDetailFactory = new InternalOrderStockDetailFactory();

	@Autowired
	private InventoryAdjusmentBatchRepository inventoryAdjusmentBatchRepository;

	@Autowired
	private InventoryAdjusmentBatchDatabasePopulator inventoryAdjusmentBatchDatabasePopulator;

	private final InventoryAdjusmentBatchFactory inventoryAdjusmentBatchFactory = new InventoryAdjusmentBatchFactory();

	@Autowired
	private InventoryAdjustmentItemRepository inventoryAdjustmentItemRepository;

	@Autowired
	private InventoryAdjustmentItemDatabasePopulator inventoryAdjustmentItemDatabasePopulator;

	private final InventoryAdjustmentItemFactory inventoryAdjustmentItemFactory = new InventoryAdjustmentItemFactory();

	@Autowired
	private InventoryBatchCorrectionItemRepository inventoryBatchCorrectionItemRepository;

	@Autowired
	private InventoryBatchCorrectionItemDatabasePopulator inventoryBatchCorrectionItemDatabasePopulator;

	private final InventoryBatchCorrectionItemFactory inventoryBatchCorrectionItemFactory = new InventoryBatchCorrectionItemFactory();

	@Autowired
	private MedicationItemRepository medicationItemRepository;

	@Autowired
	private MedicationItemDatabasePopulator medicationItemDatabasePopulator;

	private final MedicationItemFactory medicationItemFactory = new MedicationItemFactory();

	@Autowired
	private PrescriptionItemRepository prescriptionItemRepository;

	@Autowired
	private PrescriptionItemDatabasePopulator prescriptionItemDatabasePopulator;

	private final PrescriptionItemFactory prescriptionItemFactory = new PrescriptionItemFactory();

	@Autowired
	private PurchaseOrderStockDetailRepository purchaseOrderStockDetailRepository;

	@Autowired
	private PurchaseOrderStockDetailDatabasePopulator purchaseOrderStockDetailDatabasePopulator;

	private final PurchaseOrderStockDetailFactory purchaseOrderStockDetailFactory = new PurchaseOrderStockDetailFactory();

	@Autowired
	private PurchaseRequisitionStockDetailRepository purchaseRequisitionStockDetailRepository;

	@Autowired
	private PurchaseRequisitionStockDetailDatabasePopulator purchaseRequisitionStockDetailDatabasePopulator;

	private final PurchaseRequisitionStockDetailFactory purchaseRequisitionStockDetailFactory = new PurchaseRequisitionStockDetailFactory();

	@Autowired
	private RetailPharmacyStockDetailRepository retailPharmacyStockDetailRepository;

	@Autowired
	private RetailPharmacyStockDetailDatabasePopulator retailPharmacyStockDetailDatabasePopulator;

	private final RetailPharmacyStockDetailFactory retailPharmacyStockDetailFactory = new RetailPharmacyStockDetailFactory();

	@Autowired
	private ReturnSupplierStockDetailRepository returnSupplierStockDetailRepository;

	@Autowired
	private ReturnSupplierStockDetailDatabasePopulator returnSupplierStockDetailDatabasePopulator;

	private final ReturnSupplierStockDetailFactory returnSupplierStockDetailFactory = new ReturnSupplierStockDetailFactory();

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
	private SupplierProductDetailRepository supplierProductDetailRepository;

	@Autowired
	private SupplierProductDetailDatabasePopulator supplierProductDetailDatabasePopulator;

	private final SupplierProductDetailFactory supplierProductDetailFactory = new SupplierProductDetailFactory();

	@Autowired
	private TransferOrderStockDetailRepository transferOrderStockDetailRepository;

	@Autowired
	private TransferOrderStockDetailDatabasePopulator transferOrderStockDetailDatabasePopulator;

	private final TransferOrderStockDetailFactory transferOrderStockDetailFactory = new TransferOrderStockDetailFactory();

	@Autowired
	private VaccinationOrderDetailRepository vaccinationOrderDetailRepository;

	@Autowired
	private VaccinationOrderDetailDatabasePopulator vaccinationOrderDetailDatabasePopulator;

	private final VaccinationOrderDetailFactory vaccinationOrderDetailFactory = new VaccinationOrderDetailFactory();

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private WarehouseDatabasePopulator warehouseDatabasePopulator;

	private final WarehouseFactory warehouseFactory = new WarehouseFactory();

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
		stockCatalogueService = new StockCatalogueService(
			bpjsDrugGenericPRBRepository,
			bpjsPcareDPHORepository,
			batchStockBalanceRepository,
			batchStockBalancePerDateRepository,
			batchStockTransactionDetailRepository,
			catalogueMedicalRepository,
			catalogueNonMedicalRepository,
			catalogueUOMRepository,
			compoundPrescriptionItemRepository,
			goodsReceiveNoteBatchRepository,
			goodsReceiveNoteItemRepository,
			internalOrderStockDetailRepository,
			inventoryAdjusmentBatchRepository,
			inventoryAdjustmentItemRepository,
			inventoryBatchCorrectionItemRepository,
			medicationItemRepository,
			prescriptionItemRepository,
			purchaseOrderStockDetailRepository,
			purchaseRequisitionStockDetailRepository,
			retailPharmacyStockDetailRepository,
			returnSupplierStockDetailRepository,
			stockControlRepository,
			stockTransactionDetailRepository,
			stockTransactionPerDateRepository,
			stockTransactionPerDateTypeRepository,
			supplierProductDetailRepository,
			transferOrderStockDetailRepository,
			vaccinationOrderDetailRepository,
			warehouseRepository,
			warehouseInitialStockRepository,
			warehouseInventoryRepository,
			validator,
			auditRepository,
			stockCatalogueRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewStockCatalogueEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		StockCatalogueEntity stockCatalogueEntity = stockCatalogueFactory.getObject(false, false);

		StockCatalogueEntity updatedEntity = stockCatalogueService.updateOldData(stockCatalogueEntity);
		Assertions.assertEquals(stockCatalogueEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewStockCatalogueEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		StockCatalogueEntity stockCatalogueEntity = stockCatalogueFactory.getObject(false, false);

		stockCatalogueEntity.setTrackable(null);
		Assertions.assertNull(stockCatalogueEntity.getTrackable());

		stockCatalogueEntity.setMedicalType(null);
		Assertions.assertNull(stockCatalogueEntity.getMedicalType());


		StockCatalogueEntity updatedEntity = stockCatalogueService.updateOldData(stockCatalogueEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getTrackable());
		Assertions.assertFalse(updatedEntity.getTrackable());

		Assertions.assertNotNull(updatedEntity.getMedicalType());
		Assertions.assertFalse(updatedEntity.getMedicalType());

	}

	@Test
	public void updateOldDataWithExistingStockCatalogueEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			StockCatalogueEntity stockCatalogueEntity;
			StockCatalogueEntity entityWithUpdatedValues;

			try {
				stockCatalogueEntity = stockCatalogueFactory.getObject(false, false);
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = stockCatalogueFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockCatalogueEntity = stockCatalogueService.create(stockCatalogueEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(stockCatalogueEntity.getId());

			StockCatalogueEntity updatedEntity = stockCatalogueService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithStockCatalogueEntityWithNonExistentId_ShouldThrowException() throws Exception {
		StockCatalogueEntity stockCatalogueEntity = stockCatalogueFactory.getObject(false, false);
		stockCatalogueEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			stockCatalogueService.updateOldData(stockCatalogueEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingStockCatalogueEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			StockCatalogueEntity stockCatalogueEntity;
			StockCatalogueEntity updatedStockCatalogueEntity;

			BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntity;

			BpjsPcareDPHOEntity bpjsPcareDPHOEntity;

			CatalogueMedicalEntity stockCatalogueMedicalEntity;

			CatalogueNonMedicalEntity stockCatalogueNonMedicalEntity;

			WarehouseEntity warehouseEntity;

			Set<BatchStockBalanceEntity> batchStockBalancesCatalogueEntities;

			Set<BatchStockBalancePerDateEntity> batchStockBalancesEntities;

			Set<BatchStockTransactionDetailEntity> batchStockTransactionDetailsEntities;

			Set<CatalogueUOMEntity> catalogueUOMsEntities;

			Set<CompoundPrescriptionItemEntity> compoundPrescriptionItemsEntities;

			Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchsEntities;

			Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemsEntities;

			Set<InternalOrderStockDetailEntity> internalOrderStockDetailsEntities;

			Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchsEntities;

			Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItemsEntities;

			Set<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItemsEntities;

			Set<MedicationItemEntity> medicationItemsEntities;

			Set<PrescriptionItemEntity> prescriptionItemEntities;

			Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetailsEntities;

			Set<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetailsEntities;

			Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetailsEntities;

			Set<ReturnSupplierStockDetailEntity> returnSupplierStockDetailsEntities;

			Set<StockControlEntity> stockControlsEntities;

			Set<StockTransactionDetailEntity> stockTransactionDetailsEntities;

			Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypesEntities;

			Set<StockTransactionPerDateEntity> stockTransactionPerDatesEntities;

			Set<SupplierProductDetailEntity> supplierProductDetailsEntities;

			Set<TransferOrderStockDetailEntity> transferOrderStockDetailsEntities;

			Set<VaccinationOrderDetailEntity> vaccinationOrderDetailsEntities;

			Set<WarehouseInitialStockEntity> warehouseInitialStockSEntities;

			Set<WarehouseInventoryEntity> warehouseInventoriesEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				stockCatalogueEntity = stockCatalogueFactory.getObject(true, false);
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
			bpjsDrugGenericPRBEntity = stockCatalogueEntity.getBpjsDrugGenericPRB();
			try {
				bpjsDrugGenericPRBDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDrugGenericPRBEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBRepository.save(bpjsDrugGenericPRBEntity);
			stockCatalogueEntity.setBpjsDrugGenericPRBId(bpjsDrugGenericPRBEntity.getId());

			bpjsPcareDPHOEntity = stockCatalogueEntity.getBpjsPcareDPHO();
			try {
				bpjsPcareDPHODatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareDPHOEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsPcareDPHOEntity = bpjsPcareDPHORepository.save(bpjsPcareDPHOEntity);
			stockCatalogueEntity.setBpjsPcareDPHOId(bpjsPcareDPHOEntity.getId());

			stockCatalogueMedicalEntity = stockCatalogueEntity.getStockCatalogueMedical();
			try {
				catalogueMedicalDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueMedicalEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueMedicalEntity = catalogueMedicalRepository.save(stockCatalogueMedicalEntity);
			stockCatalogueEntity.setStockCatalogueMedicalId(stockCatalogueMedicalEntity.getId());

			stockCatalogueNonMedicalEntity = stockCatalogueEntity.getStockCatalogueNonMedical();
			try {
				catalogueNonMedicalDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueNonMedicalEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueNonMedicalEntity = catalogueNonMedicalRepository.save(stockCatalogueNonMedicalEntity);
			stockCatalogueEntity.setStockCatalogueNonMedicalId(stockCatalogueNonMedicalEntity.getId());

			warehouseEntity = stockCatalogueEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			stockCatalogueEntity.setWarehouseId(warehouseEntity.getId());

			batchStockBalancesCatalogueEntities = stockCatalogueEntity.getBatchStockBalancesCatalogue();
			Set<UUID> batchStockBalancesCatalogueEntityIds = new HashSet<>();
			for (BatchStockBalanceEntity entity : batchStockBalancesCatalogueEntities) {
				try {
					batchStockBalanceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				batchStockBalancesCatalogueEntityIds.add(batchStockBalanceRepository.save(entity).getId());
			}
			stockCatalogueEntity.setBatchStockBalancesCatalogueIds(batchStockBalancesCatalogueEntityIds);

			batchStockBalancesEntities = stockCatalogueEntity.getBatchStockBalances();
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
			stockCatalogueEntity.setBatchStockBalancesIds(batchStockBalancesEntityIds);

			batchStockTransactionDetailsEntities = stockCatalogueEntity.getBatchStockTransactionDetails();
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
			stockCatalogueEntity.setBatchStockTransactionDetailsIds(batchStockTransactionDetailsEntityIds);

			catalogueUOMsEntities = stockCatalogueEntity.getCatalogueUOMs();
			Set<UUID> catalogueUOMsEntityIds = new HashSet<>();
			for (CatalogueUOMEntity entity : catalogueUOMsEntities) {
				try {
					catalogueUOMDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				catalogueUOMsEntityIds.add(catalogueUOMRepository.save(entity).getId());
			}
			stockCatalogueEntity.setCatalogueUOMsIds(catalogueUOMsEntityIds);

			compoundPrescriptionItemsEntities = stockCatalogueEntity.getCompoundPrescriptionItems();
			Set<UUID> compoundPrescriptionItemsEntityIds = new HashSet<>();
			for (CompoundPrescriptionItemEntity entity : compoundPrescriptionItemsEntities) {
				try {
					compoundPrescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				compoundPrescriptionItemsEntityIds.add(compoundPrescriptionItemRepository.save(entity).getId());
			}
			stockCatalogueEntity.setCompoundPrescriptionItemsIds(compoundPrescriptionItemsEntityIds);

			goodsReceiveNoteBatchsEntities = stockCatalogueEntity.getGoodsReceiveNoteBatchs();
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
			stockCatalogueEntity.setGoodsReceiveNoteBatchsIds(goodsReceiveNoteBatchsEntityIds);

			goodsReceiveNoteItemsEntities = stockCatalogueEntity.getGoodsReceiveNoteItems();
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
			stockCatalogueEntity.setGoodsReceiveNoteItemsIds(goodsReceiveNoteItemsEntityIds);

			internalOrderStockDetailsEntities = stockCatalogueEntity.getInternalOrderStockDetails();
			Set<UUID> internalOrderStockDetailsEntityIds = new HashSet<>();
			for (InternalOrderStockDetailEntity entity : internalOrderStockDetailsEntities) {
				try {
					internalOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				internalOrderStockDetailsEntityIds.add(internalOrderStockDetailRepository.save(entity).getId());
			}
			stockCatalogueEntity.setInternalOrderStockDetailsIds(internalOrderStockDetailsEntityIds);

			inventoryAdjusmentBatchsEntities = stockCatalogueEntity.getInventoryAdjusmentBatchs();
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
			stockCatalogueEntity.setInventoryAdjusmentBatchsIds(inventoryAdjusmentBatchsEntityIds);

			inventoryAdjustmentItemsEntities = stockCatalogueEntity.getInventoryAdjustmentItems();
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
			stockCatalogueEntity.setInventoryAdjustmentItemsIds(inventoryAdjustmentItemsEntityIds);

			inventoryBatchCorrectionItemsEntities = stockCatalogueEntity.getInventoryBatchCorrectionItems();
			Set<UUID> inventoryBatchCorrectionItemsEntityIds = new HashSet<>();
			for (InventoryBatchCorrectionItemEntity entity : inventoryBatchCorrectionItemsEntities) {
				try {
					inventoryBatchCorrectionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				inventoryBatchCorrectionItemsEntityIds.add(inventoryBatchCorrectionItemRepository.save(entity).getId());
			}
			stockCatalogueEntity.setInventoryBatchCorrectionItemsIds(inventoryBatchCorrectionItemsEntityIds);

			medicationItemsEntities = stockCatalogueEntity.getMedicationItems();
			Set<UUID> medicationItemsEntityIds = new HashSet<>();
			for (MedicationItemEntity entity : medicationItemsEntities) {
				try {
					medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicationItemsEntityIds.add(medicationItemRepository.save(entity).getId());
			}
			stockCatalogueEntity.setMedicationItemsIds(medicationItemsEntityIds);

			prescriptionItemEntities = stockCatalogueEntity.getPrescriptionItem();
			Set<UUID> prescriptionItemEntityIds = new HashSet<>();
			for (PrescriptionItemEntity entity : prescriptionItemEntities) {
				try {
					prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				prescriptionItemEntityIds.add(prescriptionItemRepository.save(entity).getId());
			}
			stockCatalogueEntity.setPrescriptionItemIds(prescriptionItemEntityIds);

			purchaseOrderStockDetailsEntities = stockCatalogueEntity.getPurchaseOrderStockDetails();
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
			stockCatalogueEntity.setPurchaseOrderStockDetailsIds(purchaseOrderStockDetailsEntityIds);

			purchaseRequisitionStockDetailsEntities = stockCatalogueEntity.getPurchaseRequisitionStockDetails();
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
			stockCatalogueEntity.setPurchaseRequisitionStockDetailsIds(purchaseRequisitionStockDetailsEntityIds);

			retailPharmacyStockDetailsEntities = stockCatalogueEntity.getRetailPharmacyStockDetails();
			Set<UUID> retailPharmacyStockDetailsEntityIds = new HashSet<>();
			for (RetailPharmacyStockDetailEntity entity : retailPharmacyStockDetailsEntities) {
				try {
					retailPharmacyStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				retailPharmacyStockDetailsEntityIds.add(retailPharmacyStockDetailRepository.save(entity).getId());
			}
			stockCatalogueEntity.setRetailPharmacyStockDetailsIds(retailPharmacyStockDetailsEntityIds);

			returnSupplierStockDetailsEntities = stockCatalogueEntity.getReturnSupplierStockDetails();
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
			stockCatalogueEntity.setReturnSupplierStockDetailsIds(returnSupplierStockDetailsEntityIds);

			stockControlsEntities = stockCatalogueEntity.getStockControls();
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
			stockCatalogueEntity.setStockControlsIds(stockControlsEntityIds);

			stockTransactionDetailsEntities = stockCatalogueEntity.getStockTransactionDetails();
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
			stockCatalogueEntity.setStockTransactionDetailsIds(stockTransactionDetailsEntityIds);

			stockTransactionPerDateTypesEntities = stockCatalogueEntity.getStockTransactionPerDateTypes();
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
			stockCatalogueEntity.setStockTransactionPerDateTypesIds(stockTransactionPerDateTypesEntityIds);

			stockTransactionPerDatesEntities = stockCatalogueEntity.getStockTransactionPerDates();
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
			stockCatalogueEntity.setStockTransactionPerDatesIds(stockTransactionPerDatesEntityIds);

			supplierProductDetailsEntities = stockCatalogueEntity.getSupplierProductDetails();
			Set<UUID> supplierProductDetailsEntityIds = new HashSet<>();
			for (SupplierProductDetailEntity entity : supplierProductDetailsEntities) {
				try {
					supplierProductDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				supplierProductDetailsEntityIds.add(supplierProductDetailRepository.save(entity).getId());
			}
			stockCatalogueEntity.setSupplierProductDetailsIds(supplierProductDetailsEntityIds);

			transferOrderStockDetailsEntities = stockCatalogueEntity.getTransferOrderStockDetails();
			Set<UUID> transferOrderStockDetailsEntityIds = new HashSet<>();
			for (TransferOrderStockDetailEntity entity : transferOrderStockDetailsEntities) {
				try {
					transferOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				transferOrderStockDetailsEntityIds.add(transferOrderStockDetailRepository.save(entity).getId());
			}
			stockCatalogueEntity.setTransferOrderStockDetailsIds(transferOrderStockDetailsEntityIds);

			vaccinationOrderDetailsEntities = stockCatalogueEntity.getVaccinationOrderDetails();
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
			stockCatalogueEntity.setVaccinationOrderDetailsIds(vaccinationOrderDetailsEntityIds);

			warehouseInitialStockSEntities = stockCatalogueEntity.getWarehouseInitialStockS();
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
			stockCatalogueEntity.setWarehouseInitialStockSIds(warehouseInitialStockSEntityIds);

			warehouseInventoriesEntities = stockCatalogueEntity.getWarehouseInventories();
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
			stockCatalogueEntity.setWarehouseInventoriesIds(warehouseInventoriesEntityIds);


			stockCatalogueEntity = stockCatalogueService.create(stockCatalogueEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(stockCatalogueEntity.getBpjsDrugGenericPRB());
			stockCatalogueEntity.setBpjsDrugGenericPRBId(null);
			stockCatalogueEntity.unsetBpjsDrugGenericPRB();

			Assertions.assertNotNull(stockCatalogueEntity.getBpjsPcareDPHO());
			stockCatalogueEntity.setBpjsPcareDPHOId(null);
			stockCatalogueEntity.unsetBpjsPcareDPHO();

			Assertions.assertNotNull(stockCatalogueEntity.getStockCatalogueMedical());
			stockCatalogueEntity.setStockCatalogueMedicalId(null);
			stockCatalogueEntity.unsetStockCatalogueMedical();

			Assertions.assertNotNull(stockCatalogueEntity.getStockCatalogueNonMedical());
			stockCatalogueEntity.setStockCatalogueNonMedicalId(null);
			stockCatalogueEntity.unsetStockCatalogueNonMedical();

			Assertions.assertNotNull(stockCatalogueEntity.getWarehouse());
			stockCatalogueEntity.setWarehouseId(null);
			stockCatalogueEntity.unsetWarehouse();

			Assertions.assertTrue(stockCatalogueEntity.getBatchStockBalancesCatalogue().size() > 0);
			stockCatalogueEntity.setBatchStockBalancesCatalogueIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetBatchStockBalancesCatalogue();

			Assertions.assertTrue(stockCatalogueEntity.getBatchStockBalances().size() > 0);
			stockCatalogueEntity.setBatchStockBalancesIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetBatchStockBalances();

			Assertions.assertTrue(stockCatalogueEntity.getBatchStockTransactionDetails().size() > 0);
			stockCatalogueEntity.setBatchStockTransactionDetailsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetBatchStockTransactionDetails();

			Assertions.assertTrue(stockCatalogueEntity.getCatalogueUOMs().size() > 0);
			stockCatalogueEntity.setCatalogueUOMsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetCatalogueUOMs();

			Assertions.assertTrue(stockCatalogueEntity.getCompoundPrescriptionItems().size() > 0);
			stockCatalogueEntity.setCompoundPrescriptionItemsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetCompoundPrescriptionItems();

			Assertions.assertTrue(stockCatalogueEntity.getGoodsReceiveNoteBatchs().size() > 0);
			stockCatalogueEntity.setGoodsReceiveNoteBatchsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetGoodsReceiveNoteBatchs();

			Assertions.assertTrue(stockCatalogueEntity.getGoodsReceiveNoteItems().size() > 0);
			stockCatalogueEntity.setGoodsReceiveNoteItemsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetGoodsReceiveNoteItems();

			Assertions.assertTrue(stockCatalogueEntity.getInternalOrderStockDetails().size() > 0);
			stockCatalogueEntity.setInternalOrderStockDetailsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetInternalOrderStockDetails();

			Assertions.assertTrue(stockCatalogueEntity.getInventoryAdjusmentBatchs().size() > 0);
			stockCatalogueEntity.setInventoryAdjusmentBatchsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetInventoryAdjusmentBatchs();

			Assertions.assertTrue(stockCatalogueEntity.getInventoryAdjustmentItems().size() > 0);
			stockCatalogueEntity.setInventoryAdjustmentItemsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetInventoryAdjustmentItems();

			Assertions.assertTrue(stockCatalogueEntity.getInventoryBatchCorrectionItems().size() > 0);
			stockCatalogueEntity.setInventoryBatchCorrectionItemsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetInventoryBatchCorrectionItems();

			Assertions.assertTrue(stockCatalogueEntity.getMedicationItems().size() > 0);
			stockCatalogueEntity.setMedicationItemsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetMedicationItems();

			Assertions.assertTrue(stockCatalogueEntity.getPrescriptionItem().size() > 0);
			stockCatalogueEntity.setPrescriptionItemIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetPrescriptionItem();

			Assertions.assertTrue(stockCatalogueEntity.getPurchaseOrderStockDetails().size() > 0);
			stockCatalogueEntity.setPurchaseOrderStockDetailsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetPurchaseOrderStockDetails();

			Assertions.assertTrue(stockCatalogueEntity.getPurchaseRequisitionStockDetails().size() > 0);
			stockCatalogueEntity.setPurchaseRequisitionStockDetailsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetPurchaseRequisitionStockDetails();

			Assertions.assertTrue(stockCatalogueEntity.getRetailPharmacyStockDetails().size() > 0);
			stockCatalogueEntity.setRetailPharmacyStockDetailsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetRetailPharmacyStockDetails();

			Assertions.assertTrue(stockCatalogueEntity.getReturnSupplierStockDetails().size() > 0);
			stockCatalogueEntity.setReturnSupplierStockDetailsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetReturnSupplierStockDetails();

			Assertions.assertTrue(stockCatalogueEntity.getStockControls().size() > 0);
			stockCatalogueEntity.setStockControlsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetStockControls();

			Assertions.assertTrue(stockCatalogueEntity.getStockTransactionDetails().size() > 0);
			stockCatalogueEntity.setStockTransactionDetailsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetStockTransactionDetails();

			Assertions.assertTrue(stockCatalogueEntity.getStockTransactionPerDateTypes().size() > 0);
			stockCatalogueEntity.setStockTransactionPerDateTypesIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetStockTransactionPerDateTypes();

			Assertions.assertTrue(stockCatalogueEntity.getStockTransactionPerDates().size() > 0);
			stockCatalogueEntity.setStockTransactionPerDatesIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetStockTransactionPerDates();

			Assertions.assertTrue(stockCatalogueEntity.getSupplierProductDetails().size() > 0);
			stockCatalogueEntity.setSupplierProductDetailsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetSupplierProductDetails();

			Assertions.assertTrue(stockCatalogueEntity.getTransferOrderStockDetails().size() > 0);
			stockCatalogueEntity.setTransferOrderStockDetailsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetTransferOrderStockDetails();

			Assertions.assertTrue(stockCatalogueEntity.getVaccinationOrderDetails().size() > 0);
			stockCatalogueEntity.setVaccinationOrderDetailsIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetVaccinationOrderDetails();

			Assertions.assertTrue(stockCatalogueEntity.getWarehouseInitialStockS().size() > 0);
			stockCatalogueEntity.setWarehouseInitialStockSIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetWarehouseInitialStockS();

			Assertions.assertTrue(stockCatalogueEntity.getWarehouseInventories().size() > 0);
			stockCatalogueEntity.setWarehouseInventoriesIds(new HashSet<UUID>());
			stockCatalogueEntity.unsetWarehouseInventories();


			updatedStockCatalogueEntity = stockCatalogueService.updateOldData(stockCatalogueEntity);

			Assertions.assertNull(updatedStockCatalogueEntity.getBpjsDrugGenericPRB());

			Assertions.assertNull(updatedStockCatalogueEntity.getBpjsPcareDPHO());

			Assertions.assertNull(updatedStockCatalogueEntity.getStockCatalogueMedical());

			Assertions.assertNull(updatedStockCatalogueEntity.getStockCatalogueNonMedical());

			Assertions.assertNull(updatedStockCatalogueEntity.getWarehouse());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getBatchStockBalancesCatalogue().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getBatchStockBalances().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getBatchStockTransactionDetails().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getCatalogueUOMs().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getCompoundPrescriptionItems().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getGoodsReceiveNoteBatchs().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getGoodsReceiveNoteItems().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getInternalOrderStockDetails().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getInventoryAdjusmentBatchs().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getInventoryAdjustmentItems().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getInventoryBatchCorrectionItems().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getMedicationItems().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getPrescriptionItem().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getPurchaseOrderStockDetails().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getPurchaseRequisitionStockDetails().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getRetailPharmacyStockDetails().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getReturnSupplierStockDetails().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getStockControls().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getStockTransactionDetails().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getStockTransactionPerDateTypes().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getStockTransactionPerDates().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getSupplierProductDetails().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getTransferOrderStockDetails().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getVaccinationOrderDetails().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getWarehouseInitialStockS().size());

			Assertions.assertEquals(0, updatedStockCatalogueEntity.getWarehouseInventories().size());

		});
	}

	@Test
	public void updateOldDataWithStockCatalogueEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			StockCatalogueEntity stockCatalogueEntity;
			StockCatalogueEntity updatedStockCatalogueEntity;

			BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntity;

			BpjsPcareDPHOEntity bpjsPcareDPHOEntity;

			CatalogueMedicalEntity stockCatalogueMedicalEntity;

			CatalogueNonMedicalEntity stockCatalogueNonMedicalEntity;

			WarehouseEntity warehouseEntity;

			Set<BatchStockBalanceEntity> batchStockBalancesCatalogueEntities;
			Set<UUID> batchStockBalancesCatalogueEntityIds;

			Set<BatchStockBalancePerDateEntity> batchStockBalancesEntities;
			Set<UUID> batchStockBalancesEntityIds;

			Set<BatchStockTransactionDetailEntity> batchStockTransactionDetailsEntities;
			Set<UUID> batchStockTransactionDetailsEntityIds;

			Set<CatalogueUOMEntity> catalogueUOMsEntities;
			Set<UUID> catalogueUOMsEntityIds;

			Set<CompoundPrescriptionItemEntity> compoundPrescriptionItemsEntities;
			Set<UUID> compoundPrescriptionItemsEntityIds;

			Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchsEntities;
			Set<UUID> goodsReceiveNoteBatchsEntityIds;

			Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemsEntities;
			Set<UUID> goodsReceiveNoteItemsEntityIds;

			Set<InternalOrderStockDetailEntity> internalOrderStockDetailsEntities;
			Set<UUID> internalOrderStockDetailsEntityIds;

			Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchsEntities;
			Set<UUID> inventoryAdjusmentBatchsEntityIds;

			Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItemsEntities;
			Set<UUID> inventoryAdjustmentItemsEntityIds;

			Set<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItemsEntities;
			Set<UUID> inventoryBatchCorrectionItemsEntityIds;

			Set<MedicationItemEntity> medicationItemsEntities;
			Set<UUID> medicationItemsEntityIds;

			Set<PrescriptionItemEntity> prescriptionItemEntities;
			Set<UUID> prescriptionItemEntityIds;

			Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetailsEntities;
			Set<UUID> purchaseOrderStockDetailsEntityIds;

			Set<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetailsEntities;
			Set<UUID> purchaseRequisitionStockDetailsEntityIds;

			Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetailsEntities;
			Set<UUID> retailPharmacyStockDetailsEntityIds;

			Set<ReturnSupplierStockDetailEntity> returnSupplierStockDetailsEntities;
			Set<UUID> returnSupplierStockDetailsEntityIds;

			Set<StockControlEntity> stockControlsEntities;
			Set<UUID> stockControlsEntityIds;

			Set<StockTransactionDetailEntity> stockTransactionDetailsEntities;
			Set<UUID> stockTransactionDetailsEntityIds;

			Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypesEntities;
			Set<UUID> stockTransactionPerDateTypesEntityIds;

			Set<StockTransactionPerDateEntity> stockTransactionPerDatesEntities;
			Set<UUID> stockTransactionPerDatesEntityIds;

			Set<SupplierProductDetailEntity> supplierProductDetailsEntities;
			Set<UUID> supplierProductDetailsEntityIds;

			Set<TransferOrderStockDetailEntity> transferOrderStockDetailsEntities;
			Set<UUID> transferOrderStockDetailsEntityIds;

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
				stockCatalogueEntity = stockCatalogueFactory.getObject(true, false);
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
				bpjsDrugGenericPRBDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity.getBpjsDrugGenericPRB(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Drug Generic PRB relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBRepository.findById(bpjsDrugGenericPRBRepository.save(stockCatalogueEntity.getBpjsDrugGenericPRB()).getId()).get();
			stockCatalogueEntity.unsetBpjsDrugGenericPRB();
			stockCatalogueEntity.setBpjsDrugGenericPRBId(bpjsDrugGenericPRBEntity.getId());

			try {
				bpjsPcareDPHODatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity.getBpjsPcareDPHO(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Pcare DPHO relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsPcareDPHOEntity = bpjsPcareDPHORepository.findById(bpjsPcareDPHORepository.save(stockCatalogueEntity.getBpjsPcareDPHO()).getId()).get();
			stockCatalogueEntity.unsetBpjsPcareDPHO();
			stockCatalogueEntity.setBpjsPcareDPHOId(bpjsPcareDPHOEntity.getId());

			try {
				catalogueMedicalDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity.getStockCatalogueMedical(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue Medical  relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueMedicalEntity = catalogueMedicalRepository.findById(catalogueMedicalRepository.save(stockCatalogueEntity.getStockCatalogueMedical()).getId()).get();
			stockCatalogueEntity.unsetStockCatalogueMedical();
			stockCatalogueEntity.setStockCatalogueMedicalId(stockCatalogueMedicalEntity.getId());

			try {
				catalogueNonMedicalDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity.getStockCatalogueNonMedical(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue Non Medical relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueNonMedicalEntity = catalogueNonMedicalRepository.findById(catalogueNonMedicalRepository.save(stockCatalogueEntity.getStockCatalogueNonMedical()).getId()).get();
			stockCatalogueEntity.unsetStockCatalogueNonMedical();
			stockCatalogueEntity.setStockCatalogueNonMedicalId(stockCatalogueNonMedicalEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(stockCatalogueEntity.getWarehouse()).getId()).get();
			stockCatalogueEntity.unsetWarehouse();
			stockCatalogueEntity.setWarehouseId(warehouseEntity.getId());

			batchStockBalancesCatalogueEntities = new HashSet<>();
			batchStockBalancesCatalogueEntityIds = new HashSet<>();
			for (BatchStockBalanceEntity entity : stockCatalogueEntity.getBatchStockBalancesCatalogue()) {
				try {
					batchStockBalanceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Batch Stock Balances Catalogue relation for this test: " + e.getCause());
					return;
				}
				UUID id = batchStockBalanceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				batchStockBalancesCatalogueEntities.add(batchStockBalanceRepository.findById(id).get());
				batchStockBalancesCatalogueEntityIds.add(id);
			}
			stockCatalogueEntity.unsetBatchStockBalancesCatalogue();
			stockCatalogueEntity.setBatchStockBalancesCatalogueIds(batchStockBalancesCatalogueEntityIds);

			batchStockBalancesEntities = new HashSet<>();
			batchStockBalancesEntityIds = new HashSet<>();
			for (BatchStockBalancePerDateEntity entity : stockCatalogueEntity.getBatchStockBalances()) {
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
			stockCatalogueEntity.unsetBatchStockBalances();
			stockCatalogueEntity.setBatchStockBalancesIds(batchStockBalancesEntityIds);

			batchStockTransactionDetailsEntities = new HashSet<>();
			batchStockTransactionDetailsEntityIds = new HashSet<>();
			for (BatchStockTransactionDetailEntity entity : stockCatalogueEntity.getBatchStockTransactionDetails()) {
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
			stockCatalogueEntity.unsetBatchStockTransactionDetails();
			stockCatalogueEntity.setBatchStockTransactionDetailsIds(batchStockTransactionDetailsEntityIds);

			catalogueUOMsEntities = new HashSet<>();
			catalogueUOMsEntityIds = new HashSet<>();
			for (CatalogueUOMEntity entity : stockCatalogueEntity.getCatalogueUOMs()) {
				try {
					catalogueUOMDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Catalogue UOMs relation for this test: " + e.getCause());
					return;
				}
				UUID id = catalogueUOMRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				catalogueUOMsEntities.add(catalogueUOMRepository.findById(id).get());
				catalogueUOMsEntityIds.add(id);
			}
			stockCatalogueEntity.unsetCatalogueUOMs();
			stockCatalogueEntity.setCatalogueUOMsIds(catalogueUOMsEntityIds);

			compoundPrescriptionItemsEntities = new HashSet<>();
			compoundPrescriptionItemsEntityIds = new HashSet<>();
			for (CompoundPrescriptionItemEntity entity : stockCatalogueEntity.getCompoundPrescriptionItems()) {
				try {
					compoundPrescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Compound Prescription Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = compoundPrescriptionItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				compoundPrescriptionItemsEntities.add(compoundPrescriptionItemRepository.findById(id).get());
				compoundPrescriptionItemsEntityIds.add(id);
			}
			stockCatalogueEntity.unsetCompoundPrescriptionItems();
			stockCatalogueEntity.setCompoundPrescriptionItemsIds(compoundPrescriptionItemsEntityIds);

			goodsReceiveNoteBatchsEntities = new HashSet<>();
			goodsReceiveNoteBatchsEntityIds = new HashSet<>();
			for (GoodsReceiveNoteBatchEntity entity : stockCatalogueEntity.getGoodsReceiveNoteBatchs()) {
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
			stockCatalogueEntity.unsetGoodsReceiveNoteBatchs();
			stockCatalogueEntity.setGoodsReceiveNoteBatchsIds(goodsReceiveNoteBatchsEntityIds);

			goodsReceiveNoteItemsEntities = new HashSet<>();
			goodsReceiveNoteItemsEntityIds = new HashSet<>();
			for (GoodsReceiveNoteItemEntity entity : stockCatalogueEntity.getGoodsReceiveNoteItems()) {
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
			stockCatalogueEntity.unsetGoodsReceiveNoteItems();
			stockCatalogueEntity.setGoodsReceiveNoteItemsIds(goodsReceiveNoteItemsEntityIds);

			internalOrderStockDetailsEntities = new HashSet<>();
			internalOrderStockDetailsEntityIds = new HashSet<>();
			for (InternalOrderStockDetailEntity entity : stockCatalogueEntity.getInternalOrderStockDetails()) {
				try {
					internalOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Internal Order Stock Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = internalOrderStockDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				internalOrderStockDetailsEntities.add(internalOrderStockDetailRepository.findById(id).get());
				internalOrderStockDetailsEntityIds.add(id);
			}
			stockCatalogueEntity.unsetInternalOrderStockDetails();
			stockCatalogueEntity.setInternalOrderStockDetailsIds(internalOrderStockDetailsEntityIds);

			inventoryAdjusmentBatchsEntities = new HashSet<>();
			inventoryAdjusmentBatchsEntityIds = new HashSet<>();
			for (InventoryAdjusmentBatchEntity entity : stockCatalogueEntity.getInventoryAdjusmentBatchs()) {
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
			stockCatalogueEntity.unsetInventoryAdjusmentBatchs();
			stockCatalogueEntity.setInventoryAdjusmentBatchsIds(inventoryAdjusmentBatchsEntityIds);

			inventoryAdjustmentItemsEntities = new HashSet<>();
			inventoryAdjustmentItemsEntityIds = new HashSet<>();
			for (InventoryAdjustmentItemEntity entity : stockCatalogueEntity.getInventoryAdjustmentItems()) {
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
			stockCatalogueEntity.unsetInventoryAdjustmentItems();
			stockCatalogueEntity.setInventoryAdjustmentItemsIds(inventoryAdjustmentItemsEntityIds);

			inventoryBatchCorrectionItemsEntities = new HashSet<>();
			inventoryBatchCorrectionItemsEntityIds = new HashSet<>();
			for (InventoryBatchCorrectionItemEntity entity : stockCatalogueEntity.getInventoryBatchCorrectionItems()) {
				try {
					inventoryBatchCorrectionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Inventory Batch Correction Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = inventoryBatchCorrectionItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				inventoryBatchCorrectionItemsEntities.add(inventoryBatchCorrectionItemRepository.findById(id).get());
				inventoryBatchCorrectionItemsEntityIds.add(id);
			}
			stockCatalogueEntity.unsetInventoryBatchCorrectionItems();
			stockCatalogueEntity.setInventoryBatchCorrectionItemsIds(inventoryBatchCorrectionItemsEntityIds);

			medicationItemsEntities = new HashSet<>();
			medicationItemsEntityIds = new HashSet<>();
			for (MedicationItemEntity entity : stockCatalogueEntity.getMedicationItems()) {
				try {
					medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medication Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicationItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicationItemsEntities.add(medicationItemRepository.findById(id).get());
				medicationItemsEntityIds.add(id);
			}
			stockCatalogueEntity.unsetMedicationItems();
			stockCatalogueEntity.setMedicationItemsIds(medicationItemsEntityIds);

			prescriptionItemEntities = new HashSet<>();
			prescriptionItemEntityIds = new HashSet<>();
			for (PrescriptionItemEntity entity : stockCatalogueEntity.getPrescriptionItem()) {
				try {
					prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Prescription Item relation for this test: " + e.getCause());
					return;
				}
				UUID id = prescriptionItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				prescriptionItemEntities.add(prescriptionItemRepository.findById(id).get());
				prescriptionItemEntityIds.add(id);
			}
			stockCatalogueEntity.unsetPrescriptionItem();
			stockCatalogueEntity.setPrescriptionItemIds(prescriptionItemEntityIds);

			purchaseOrderStockDetailsEntities = new HashSet<>();
			purchaseOrderStockDetailsEntityIds = new HashSet<>();
			for (PurchaseOrderStockDetailEntity entity : stockCatalogueEntity.getPurchaseOrderStockDetails()) {
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
			stockCatalogueEntity.unsetPurchaseOrderStockDetails();
			stockCatalogueEntity.setPurchaseOrderStockDetailsIds(purchaseOrderStockDetailsEntityIds);

			purchaseRequisitionStockDetailsEntities = new HashSet<>();
			purchaseRequisitionStockDetailsEntityIds = new HashSet<>();
			for (PurchaseRequisitionStockDetailEntity entity : stockCatalogueEntity.getPurchaseRequisitionStockDetails()) {
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
			stockCatalogueEntity.unsetPurchaseRequisitionStockDetails();
			stockCatalogueEntity.setPurchaseRequisitionStockDetailsIds(purchaseRequisitionStockDetailsEntityIds);

			retailPharmacyStockDetailsEntities = new HashSet<>();
			retailPharmacyStockDetailsEntityIds = new HashSet<>();
			for (RetailPharmacyStockDetailEntity entity : stockCatalogueEntity.getRetailPharmacyStockDetails()) {
				try {
					retailPharmacyStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Retail Pharmacy Stock Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = retailPharmacyStockDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				retailPharmacyStockDetailsEntities.add(retailPharmacyStockDetailRepository.findById(id).get());
				retailPharmacyStockDetailsEntityIds.add(id);
			}
			stockCatalogueEntity.unsetRetailPharmacyStockDetails();
			stockCatalogueEntity.setRetailPharmacyStockDetailsIds(retailPharmacyStockDetailsEntityIds);

			returnSupplierStockDetailsEntities = new HashSet<>();
			returnSupplierStockDetailsEntityIds = new HashSet<>();
			for (ReturnSupplierStockDetailEntity entity : stockCatalogueEntity.getReturnSupplierStockDetails()) {
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
			stockCatalogueEntity.unsetReturnSupplierStockDetails();
			stockCatalogueEntity.setReturnSupplierStockDetailsIds(returnSupplierStockDetailsEntityIds);

			stockControlsEntities = new HashSet<>();
			stockControlsEntityIds = new HashSet<>();
			for (StockControlEntity entity : stockCatalogueEntity.getStockControls()) {
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
			stockCatalogueEntity.unsetStockControls();
			stockCatalogueEntity.setStockControlsIds(stockControlsEntityIds);

			stockTransactionDetailsEntities = new HashSet<>();
			stockTransactionDetailsEntityIds = new HashSet<>();
			for (StockTransactionDetailEntity entity : stockCatalogueEntity.getStockTransactionDetails()) {
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
			stockCatalogueEntity.unsetStockTransactionDetails();
			stockCatalogueEntity.setStockTransactionDetailsIds(stockTransactionDetailsEntityIds);

			stockTransactionPerDateTypesEntities = new HashSet<>();
			stockTransactionPerDateTypesEntityIds = new HashSet<>();
			for (StockTransactionPerDateTypeEntity entity : stockCatalogueEntity.getStockTransactionPerDateTypes()) {
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
			stockCatalogueEntity.unsetStockTransactionPerDateTypes();
			stockCatalogueEntity.setStockTransactionPerDateTypesIds(stockTransactionPerDateTypesEntityIds);

			stockTransactionPerDatesEntities = new HashSet<>();
			stockTransactionPerDatesEntityIds = new HashSet<>();
			for (StockTransactionPerDateEntity entity : stockCatalogueEntity.getStockTransactionPerDates()) {
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
			stockCatalogueEntity.unsetStockTransactionPerDates();
			stockCatalogueEntity.setStockTransactionPerDatesIds(stockTransactionPerDatesEntityIds);

			supplierProductDetailsEntities = new HashSet<>();
			supplierProductDetailsEntityIds = new HashSet<>();
			for (SupplierProductDetailEntity entity : stockCatalogueEntity.getSupplierProductDetails()) {
				try {
					supplierProductDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Supplier Product Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = supplierProductDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				supplierProductDetailsEntities.add(supplierProductDetailRepository.findById(id).get());
				supplierProductDetailsEntityIds.add(id);
			}
			stockCatalogueEntity.unsetSupplierProductDetails();
			stockCatalogueEntity.setSupplierProductDetailsIds(supplierProductDetailsEntityIds);

			transferOrderStockDetailsEntities = new HashSet<>();
			transferOrderStockDetailsEntityIds = new HashSet<>();
			for (TransferOrderStockDetailEntity entity : stockCatalogueEntity.getTransferOrderStockDetails()) {
				try {
					transferOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Transfer Order Stock Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = transferOrderStockDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				transferOrderStockDetailsEntities.add(transferOrderStockDetailRepository.findById(id).get());
				transferOrderStockDetailsEntityIds.add(id);
			}
			stockCatalogueEntity.unsetTransferOrderStockDetails();
			stockCatalogueEntity.setTransferOrderStockDetailsIds(transferOrderStockDetailsEntityIds);

			vaccinationOrderDetailsEntities = new HashSet<>();
			vaccinationOrderDetailsEntityIds = new HashSet<>();
			for (VaccinationOrderDetailEntity entity : stockCatalogueEntity.getVaccinationOrderDetails()) {
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
			stockCatalogueEntity.unsetVaccinationOrderDetails();
			stockCatalogueEntity.setVaccinationOrderDetailsIds(vaccinationOrderDetailsEntityIds);

			warehouseInitialStockSEntities = new HashSet<>();
			warehouseInitialStockSEntityIds = new HashSet<>();
			for (WarehouseInitialStockEntity entity : stockCatalogueEntity.getWarehouseInitialStockS()) {
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
			stockCatalogueEntity.unsetWarehouseInitialStockS();
			stockCatalogueEntity.setWarehouseInitialStockSIds(warehouseInitialStockSEntityIds);

			warehouseInventoriesEntities = new HashSet<>();
			warehouseInventoriesEntityIds = new HashSet<>();
			for (WarehouseInventoryEntity entity : stockCatalogueEntity.getWarehouseInventories()) {
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
			stockCatalogueEntity.unsetWarehouseInventories();
			stockCatalogueEntity.setWarehouseInventoriesIds(warehouseInventoriesEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedStockCatalogueEntity = stockCatalogueService.updateOldData(stockCatalogueEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			bpjsDrugGenericPRBEntity.unsetStockCatalogue(false);
			updatedStockCatalogueEntity.getBpjsDrugGenericPRB().unsetStockCatalogue(false);
			Assertions.assertEquals(bpjsDrugGenericPRBEntity, updatedStockCatalogueEntity.getBpjsDrugGenericPRB());

			bpjsPcareDPHOEntity.unsetStockCatalogue(false);
			updatedStockCatalogueEntity.getBpjsPcareDPHO().unsetStockCatalogue(false);
			Assertions.assertEquals(bpjsPcareDPHOEntity, updatedStockCatalogueEntity.getBpjsPcareDPHO());

			stockCatalogueMedicalEntity.unsetStockCatalogue(false);
			updatedStockCatalogueEntity.getStockCatalogueMedical().unsetStockCatalogue(false);
			Assertions.assertEquals(stockCatalogueMedicalEntity, updatedStockCatalogueEntity.getStockCatalogueMedical());

			stockCatalogueNonMedicalEntity.unsetStockCatalogue(false);
			updatedStockCatalogueEntity.getStockCatalogueNonMedical().unsetStockCatalogue(false);
			Assertions.assertEquals(stockCatalogueNonMedicalEntity, updatedStockCatalogueEntity.getStockCatalogueNonMedical());

			warehouseEntity.unsetStockCatalogues(false);
			updatedStockCatalogueEntity.getWarehouse().unsetStockCatalogues(false);
			Assertions.assertEquals(warehouseEntity, updatedStockCatalogueEntity.getWarehouse());

			Assertions.assertEquals(batchStockBalancesCatalogueEntities.size(), updatedStockCatalogueEntity.getBatchStockBalancesCatalogue().size());

			Assertions.assertEquals(batchStockBalancesEntities.size(), updatedStockCatalogueEntity.getBatchStockBalances().size());

			Assertions.assertEquals(batchStockTransactionDetailsEntities.size(), updatedStockCatalogueEntity.getBatchStockTransactionDetails().size());

			Assertions.assertEquals(catalogueUOMsEntities.size(), updatedStockCatalogueEntity.getCatalogueUOMs().size());

			Assertions.assertEquals(compoundPrescriptionItemsEntities.size(), updatedStockCatalogueEntity.getCompoundPrescriptionItems().size());

			Assertions.assertEquals(goodsReceiveNoteBatchsEntities.size(), updatedStockCatalogueEntity.getGoodsReceiveNoteBatchs().size());

			Assertions.assertEquals(goodsReceiveNoteItemsEntities.size(), updatedStockCatalogueEntity.getGoodsReceiveNoteItems().size());

			Assertions.assertEquals(internalOrderStockDetailsEntities.size(), updatedStockCatalogueEntity.getInternalOrderStockDetails().size());

			Assertions.assertEquals(inventoryAdjusmentBatchsEntities.size(), updatedStockCatalogueEntity.getInventoryAdjusmentBatchs().size());

			Assertions.assertEquals(inventoryAdjustmentItemsEntities.size(), updatedStockCatalogueEntity.getInventoryAdjustmentItems().size());

			Assertions.assertEquals(inventoryBatchCorrectionItemsEntities.size(), updatedStockCatalogueEntity.getInventoryBatchCorrectionItems().size());

			Assertions.assertEquals(medicationItemsEntities.size(), updatedStockCatalogueEntity.getMedicationItems().size());

			Assertions.assertEquals(prescriptionItemEntities.size(), updatedStockCatalogueEntity.getPrescriptionItem().size());

			Assertions.assertEquals(purchaseOrderStockDetailsEntities.size(), updatedStockCatalogueEntity.getPurchaseOrderStockDetails().size());

			Assertions.assertEquals(purchaseRequisitionStockDetailsEntities.size(), updatedStockCatalogueEntity.getPurchaseRequisitionStockDetails().size());

			Assertions.assertEquals(retailPharmacyStockDetailsEntities.size(), updatedStockCatalogueEntity.getRetailPharmacyStockDetails().size());

			Assertions.assertEquals(returnSupplierStockDetailsEntities.size(), updatedStockCatalogueEntity.getReturnSupplierStockDetails().size());

			Assertions.assertEquals(stockControlsEntities.size(), updatedStockCatalogueEntity.getStockControls().size());

			Assertions.assertEquals(stockTransactionDetailsEntities.size(), updatedStockCatalogueEntity.getStockTransactionDetails().size());

			Assertions.assertEquals(stockTransactionPerDateTypesEntities.size(), updatedStockCatalogueEntity.getStockTransactionPerDateTypes().size());

			Assertions.assertEquals(stockTransactionPerDatesEntities.size(), updatedStockCatalogueEntity.getStockTransactionPerDates().size());

			Assertions.assertEquals(supplierProductDetailsEntities.size(), updatedStockCatalogueEntity.getSupplierProductDetails().size());

			Assertions.assertEquals(transferOrderStockDetailsEntities.size(), updatedStockCatalogueEntity.getTransferOrderStockDetails().size());

			Assertions.assertEquals(vaccinationOrderDetailsEntities.size(), updatedStockCatalogueEntity.getVaccinationOrderDetails().size());

			Assertions.assertEquals(warehouseInitialStockSEntities.size(), updatedStockCatalogueEntity.getWarehouseInitialStockS().size());

			Assertions.assertEquals(warehouseInventoriesEntities.size(), updatedStockCatalogueEntity.getWarehouseInventories().size());

		});
	}

	@Test
	public void whenCreateStockCatalogueEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			StockCatalogueEntity stockCatalogueEntity;
			Optional<StockCatalogueEntity> fetchedStockCatalogueEntity;

			try {
				stockCatalogueEntity = stockCatalogueFactory.getObject(false, false);
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockCatalogueEntity = stockCatalogueService.create(stockCatalogueEntity);

			fetchedStockCatalogueEntity = stockCatalogueService.findById(stockCatalogueEntity.getId());

			Assertions.assertTrue(fetchedStockCatalogueEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedStockCatalogueEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(stockCatalogueEntity, fetchedStockCatalogueEntity.get());
		});
	}

	@Test
	public void whenUpdateStockCatalogueEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			StockCatalogueEntity stockCatalogueEntity;
			StockCatalogueEntity updatedStockCatalogueEntity;
			Optional<StockCatalogueEntity> fetchedStockCatalogueEntity;

			try {
				stockCatalogueEntity = stockCatalogueFactory.getObject(false, false);
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, false);
				updatedStockCatalogueEntity = stockCatalogueFactory.getObject(false, false);
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(updatedStockCatalogueEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockCatalogueEntity = stockCatalogueService.create(stockCatalogueEntity);

			updatedStockCatalogueEntity.setId(stockCatalogueEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedStockCatalogueEntity.setCreated(stockCatalogueEntity.getCreated());

			updatedStockCatalogueEntity = stockCatalogueService.update(updatedStockCatalogueEntity);

			fetchedStockCatalogueEntity = stockCatalogueService.findById(stockCatalogueEntity.getId());

			Assertions.assertTrue(fetchedStockCatalogueEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateStockCatalogueEntity_ThenEntityIsCreated
			fetchedStockCatalogueEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedStockCatalogueEntity, fetchedStockCatalogueEntity.get());
		});
	}

	@Test
	public void whenDeleteStockCatalogueEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			StockCatalogueEntity stockCatalogueEntity;
			Optional<StockCatalogueEntity> fetchedStockCatalogueEntity;

			try {
				stockCatalogueEntity = stockCatalogueFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockCatalogueEntity = stockCatalogueService.create(stockCatalogueEntity);

			stockCatalogueService.deleteById(stockCatalogueEntity.getId());
			fetchedStockCatalogueEntity = stockCatalogueService.findById(stockCatalogueEntity.getId());

			Assertions.assertTrue(fetchedStockCatalogueEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
