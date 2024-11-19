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
import kmsweb.entities.WarehouseEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.WarehouseRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.repositories.WarehouseRepository;
import kmsweb.services.WarehouseService;
import kmsweb.repositories.BatchStockBalanceRepository;
import kmsweb.repositories.BatchStockBalancePerDateRepository;
import kmsweb.repositories.BatchStockTransactionDetailRepository;
import kmsweb.repositories.GoodsReceiveNoteRepository;
import kmsweb.repositories.GoodsReceiveNoteBatchRepository;
import kmsweb.repositories.InternalOrderRepository;
import kmsweb.repositories.InventoryAdjusmentBatchRepository;
import kmsweb.repositories.InventoryAdjustmentRepository;
import kmsweb.repositories.InventoryBatchCorrectionRepository;
import kmsweb.repositories.LocationRepository;
import kmsweb.repositories.MedicalFeeRepository;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.repositories.PurchaseRequisitionRepository;
import kmsweb.repositories.RetailPharmacyRepository;
import kmsweb.repositories.ReturnSupplierRepository;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.repositories.StockControlRepository;
import kmsweb.repositories.StockTransactionDetailRepository;
import kmsweb.repositories.StockTransactionPerDateRepository;
import kmsweb.repositories.StockTransactionPerDateTypeRepository;
import kmsweb.repositories.TransferOrderRepository;
import kmsweb.repositories.VaccinationOrderDetailRepository;
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
public class WarehouseServiceTest {


	@Mock
	private BatchStockBalanceRepository batchStockBalanceRepository;


	@Mock
	private BatchStockBalancePerDateRepository batchStockBalancePerDateRepository;


	@Mock
	private BatchStockTransactionDetailRepository batchStockTransactionDetailRepository;


	@Mock
	private GoodsReceiveNoteRepository goodsReceiveNoteRepository;


	@Mock
	private GoodsReceiveNoteBatchRepository goodsReceiveNoteBatchRepository;


	@Mock
	private InternalOrderRepository internalOrderRepository;


	@Mock
	private InventoryAdjusmentBatchRepository inventoryAdjusmentBatchRepository;


	@Mock
	private InventoryAdjustmentRepository inventoryAdjustmentRepository;


	@Mock
	private InventoryBatchCorrectionRepository inventoryBatchCorrectionRepository;


	@Mock
	private LocationRepository locationRepository;


	@Mock
	private MedicalFeeRepository medicalFeeRepository;


	@Mock
	private MedicationHeaderRepository medicationHeaderRepository;


	@Mock
	private PrescriptionHeaderRepository prescriptionHeaderRepository;


	@Mock
	private PurchaseOrderRepository purchaseOrderRepository;


	@Mock
	private PurchaseRequisitionRepository purchaseRequisitionRepository;


	@Mock
	private RetailPharmacyRepository retailPharmacyRepository;


	@Mock
	private ReturnSupplierRepository returnSupplierRepository;


	@Mock
	private StockCatalogueRepository stockCatalogueRepository;


	@Mock
	private StockControlRepository stockControlRepository;


	@Mock
	private StockTransactionDetailRepository stockTransactionDetailRepository;


	@Mock
	private StockTransactionPerDateRepository stockTransactionPerDateRepository;


	@Mock
	private StockTransactionPerDateTypeRepository stockTransactionPerDateTypeRepository;


	@Mock
	private TransferOrderRepository transferOrderRepository;


	@Mock
	private VaccinationOrderDetailRepository vaccinationOrderDetailRepository;


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
	private TransferOrderService transferOrderService;

	@Mock
	private GoodsReceiveNoteBatchService goodsReceiveNoteBatchService;

	@Mock
	private GoodsReceiveNoteService goodsReceiveNoteService;

	@Mock
	private InternalOrderService internalOrderService;

	@Mock
	private InventoryAdjusmentBatchService inventoryAdjusmentBatchService;

	@Mock
	private InventoryAdjustmentService inventoryAdjustmentService;

	@Mock
	private InventoryBatchCorrectionService inventoryBatchCorrectionService;

	@Mock
	private LocationService locationService;

	@Mock
	private MedicalFeeService medicalFeeService;

	@Mock
	private MedicationHeaderService medicationHeaderService;

	@Mock
	private PrescriptionHeaderService prescriptionHeaderService;

	@Mock
	private PurchaseOrderService purchaseOrderService;

	@Mock
	private PurchaseRequisitionService purchaseRequisitionService;

	@Mock
	private RetailPharmacyService retailPharmacyService;

	@Mock
	private ReturnSupplierService returnSupplierService;

	@Mock
	private TransferOrderService transferOrderService;

	@Mock
	private StockCatalogueService stockCatalogueService;

	@Mock
	private StockControlService stockControlService;

	@Mock
	private StockTransactionDetailService stockTransactionDetailService;

	@Mock
	private StockTransactionPerDateTypeService stockTransactionPerDateTypeService;

	@Mock
	private StockTransactionPerDateService stockTransactionPerDateService;

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
	private WarehouseRepository warehouseRepository;

	private WarehouseService warehouseService;

	private static MockNeat mockNeat;

	// % protected region % [Add additional method fields here] off begin
	// % protected region % [Add additional method fields here] end

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockNeat = MockNeat.threadLocal();

		warehouseService = new WarehouseService(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
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
			auditingRepository,
			warehouseRepository
		);

		// % protected region % [Add additional setup logic here] off begin
		// % protected region % [Add additional setup logic here] end
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private WarehouseEntity setupConstrainViolationMock() {
		// % protected region % [Customise entity mock setup here] off begin
		var entity = new WarehouseEntity();

		entity.setWarehouseNumber(mockNeat.strings().get());
		when(warehouseRepository.findByWarehouseNumber(entity.getWarehouseNumber()))
			.thenReturn(Optional.of(entity));

		// % protected region % [Customise entity mock setup here] end

		return entity;
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private WarehouseEntity setupConstrainHonouredMock() {
		// % protected region % [Customise valid entity mock setup here] off begin
		var entity = new WarehouseEntity();

		entity.setWarehouseNumber(mockNeat.strings().get());
		when(warehouseRepository.findByWarehouseNumber(entity.getWarehouseNumber()))
			.thenReturn(Optional.empty());

		// % protected region % [Customise valid entity mock setup here] end

		return entity;
	}


	// % protected region % [Override test method here testUniquenessConstraintViolatedOnWarehouseNumberAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnWarehouseNumberAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<WarehouseEntity>(
				"Warehouse Number",
				entity.getWarehouseNumber(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"WarehouseNumber"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			warehouseService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnWarehouseNumberAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnWarehouseNumberAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnWarehouseNumberAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<WarehouseEntity>(
				"Warehouse Number",
				entity.getWarehouseNumber(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"WarehouseNumber"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		warehouseService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnWarehouseNumberAttribute] end

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}