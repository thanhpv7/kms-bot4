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

import net.andreinc.mockneat.MockNeat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.services.StockCatalogueService;
import kmsweb.repositories.BpjsDrugGenericPRBRepository;
import kmsweb.repositories.BpjsPcareDPHORepository;
import kmsweb.repositories.BatchStockBalanceRepository;
import kmsweb.repositories.BatchStockBalancePerDateRepository;
import kmsweb.repositories.BatchStockTransactionDetailRepository;
import kmsweb.repositories.CatalogueMedicalRepository;
import kmsweb.repositories.CatalogueNonMedicalRepository;
import kmsweb.repositories.CatalogueUOMRepository;
import kmsweb.repositories.CompoundPrescriptionItemRepository;
import kmsweb.repositories.GoodsReceiveNoteBatchRepository;
import kmsweb.repositories.GoodsReceiveNoteItemRepository;
import kmsweb.repositories.InternalOrderStockDetailRepository;
import kmsweb.repositories.InventoryAdjusmentBatchRepository;
import kmsweb.repositories.InventoryAdjustmentItemRepository;
import kmsweb.repositories.InventoryBatchCorrectionItemRepository;
import kmsweb.repositories.MedicationItemRepository;
import kmsweb.repositories.PrescriptionItemRepository;
import kmsweb.repositories.PurchaseOrderStockDetailRepository;
import kmsweb.repositories.PurchaseRequisitionStockDetailRepository;
import kmsweb.repositories.RetailPharmacyStockDetailRepository;
import kmsweb.repositories.ReturnSupplierStockDetailRepository;
import kmsweb.repositories.StockControlRepository;
import kmsweb.repositories.StockTransactionDetailRepository;
import kmsweb.repositories.StockTransactionPerDateRepository;
import kmsweb.repositories.StockTransactionPerDateTypeRepository;
import kmsweb.repositories.SupplierProductDetailRepository;
import kmsweb.repositories.TransferOrderStockDetailRepository;
import kmsweb.repositories.VaccinationOrderDetailRepository;
import kmsweb.repositories.WarehouseRepository;
import kmsweb.repositories.WarehouseInitialStockRepository;
import kmsweb.repositories.WarehouseInventoryRepository;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Override the default annotations here] off begin
@Tag("validation")
// % protected region % [Override the default annotations here] end
public class StockCatalogueServiceTest {


	@Mock
	private BpjsDrugGenericPRBRepository bpjsDrugGenericPRBRepository;


	@Mock
	private BpjsPcareDPHORepository bpjsPcareDPHORepository;


	@Mock
	private BatchStockBalanceRepository batchStockBalanceRepository;


	@Mock
	private BatchStockBalancePerDateRepository batchStockBalancePerDateRepository;


	@Mock
	private BatchStockTransactionDetailRepository batchStockTransactionDetailRepository;


	@Mock
	private CatalogueMedicalRepository catalogueMedicalRepository;


	@Mock
	private CatalogueNonMedicalRepository catalogueNonMedicalRepository;


	@Mock
	private CatalogueUOMRepository catalogueUOMRepository;


	@Mock
	private CompoundPrescriptionItemRepository compoundPrescriptionItemRepository;


	@Mock
	private GoodsReceiveNoteBatchRepository goodsReceiveNoteBatchRepository;


	@Mock
	private GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository;


	@Mock
	private InternalOrderStockDetailRepository internalOrderStockDetailRepository;


	@Mock
	private InventoryAdjusmentBatchRepository inventoryAdjusmentBatchRepository;


	@Mock
	private InventoryAdjustmentItemRepository inventoryAdjustmentItemRepository;


	@Mock
	private InventoryBatchCorrectionItemRepository inventoryBatchCorrectionItemRepository;


	@Mock
	private MedicationItemRepository medicationItemRepository;


	@Mock
	private PrescriptionItemRepository prescriptionItemRepository;


	@Mock
	private PurchaseOrderStockDetailRepository purchaseOrderStockDetailRepository;


	@Mock
	private PurchaseRequisitionStockDetailRepository purchaseRequisitionStockDetailRepository;


	@Mock
	private RetailPharmacyStockDetailRepository retailPharmacyStockDetailRepository;


	@Mock
	private ReturnSupplierStockDetailRepository returnSupplierStockDetailRepository;


	@Mock
	private StockControlRepository stockControlRepository;


	@Mock
	private StockTransactionDetailRepository stockTransactionDetailRepository;


	@Mock
	private StockTransactionPerDateRepository stockTransactionPerDateRepository;


	@Mock
	private StockTransactionPerDateTypeRepository stockTransactionPerDateTypeRepository;


	@Mock
	private SupplierProductDetailRepository supplierProductDetailRepository;


	@Mock
	private TransferOrderStockDetailRepository transferOrderStockDetailRepository;


	@Mock
	private VaccinationOrderDetailRepository vaccinationOrderDetailRepository;


	@Mock
	private WarehouseRepository warehouseRepository;


	@Mock
	private WarehouseInitialStockRepository warehouseInitialStockRepository;


	@Mock
	private WarehouseInventoryRepository warehouseInventoryRepository;

	@Mock
	private BatchStockBalanceService batchStockBalanceService;

	@Mock
	private BatchStockBalancePerDateService batchStockBalancePerDateService;

	@Mock
	private BatchStockTransactionDetailService batchStockTransactionDetailService;

	@Mock
	private CatalogueUOMService catalogueUOMService;

	@Mock
	private CompoundPrescriptionItemService compoundPrescriptionItemService;

	@Mock
	private GoodsReceiveNoteBatchService goodsReceiveNoteBatchService;

	@Mock
	private GoodsReceiveNoteItemService goodsReceiveNoteItemService;

	@Mock
	private InternalOrderStockDetailService internalOrderStockDetailService;

	@Mock
	private InventoryAdjusmentBatchService inventoryAdjusmentBatchService;

	@Mock
	private InventoryAdjustmentItemService inventoryAdjustmentItemService;

	@Mock
	private InventoryBatchCorrectionItemService inventoryBatchCorrectionItemService;

	@Mock
	private MedicationItemService medicationItemService;

	@Mock
	private PrescriptionItemService prescriptionItemService;

	@Mock
	private PurchaseOrderStockDetailService purchaseOrderStockDetailService;

	@Mock
	private PurchaseRequisitionStockDetailService purchaseRequisitionStockDetailService;

	@Mock
	private RetailPharmacyStockDetailService retailPharmacyStockDetailService;

	@Mock
	private ReturnSupplierStockDetailService returnSupplierStockDetailService;

	@Mock
	private CatalogueMedicalService catalogueMedicalService;

	@Mock
	private CatalogueNonMedicalService catalogueNonMedicalService;

	@Mock
	private StockControlService stockControlService;

	@Mock
	private StockTransactionDetailService stockTransactionDetailService;

	@Mock
	private StockTransactionPerDateTypeService stockTransactionPerDateTypeService;

	@Mock
	private StockTransactionPerDateService stockTransactionPerDateService;

	@Mock
	private SupplierProductDetailService supplierProductDetailService;

	@Mock
	private TransferOrderStockDetailService transferOrderStockDetailService;

	@Mock
	private VaccinationOrderDetailService vaccinationOrderDetailService;

	@Mock
	private WarehouseInitialStockService warehouseInitialStockService;

	@Mock
	private WarehouseInventoryService warehouseInventoryService;

	@Mock
	private Validator validator;

	@Mock
	private AuditingRepository auditingRepository;

	@Mock
	private StockCatalogueRepository stockCatalogueRepository;

	private StockCatalogueService stockCatalogueService;

	private static MockNeat mockNeat;

	// % protected region % [Add additional method fields here] off begin
	// % protected region % [Add additional method fields here] end

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockNeat = MockNeat.threadLocal();

		stockCatalogueService = new StockCatalogueService(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
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
			auditingRepository,
			stockCatalogueRepository
		);

		// % protected region % [Add additional setup logic here] off begin
		// % protected region % [Add additional setup logic here] end
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private StockCatalogueEntity setupConstrainViolationMock() {
		// % protected region % [Customise entity mock setup here] off begin
		var entity = new StockCatalogueEntity();

		entity.setStockCode(mockNeat.strings().get());
		when(stockCatalogueRepository.findByStockCode(entity.getStockCode()))
			.thenReturn(Optional.of(entity));

		// % protected region % [Customise entity mock setup here] end

		return entity;
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private StockCatalogueEntity setupConstrainHonouredMock() {
		// % protected region % [Customise valid entity mock setup here] off begin
		var entity = new StockCatalogueEntity();

		entity.setStockCode(mockNeat.strings().get());
		when(stockCatalogueRepository.findByStockCode(entity.getStockCode()))
			.thenReturn(Optional.empty());

		// % protected region % [Customise valid entity mock setup here] end

		return entity;
	}


	// % protected region % [Override test method here testUniquenessConstraintViolatedOnStockCodeAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnStockCodeAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<StockCatalogueEntity>(
				"Stock Code",
				entity.getStockCode(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"StockCode"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			stockCatalogueService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnStockCodeAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnStockCodeAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnStockCodeAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<StockCatalogueEntity>(
				"Stock Code",
				entity.getStockCode(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"StockCode"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		stockCatalogueService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnStockCodeAttribute] end

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}