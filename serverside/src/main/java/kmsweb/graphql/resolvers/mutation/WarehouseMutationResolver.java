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

package kmsweb.graphql.resolvers.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kmsweb.entities.WarehouseEntity;
import kmsweb.services.WarehouseService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BatchStockBalanceService;
import kmsweb.entities.BatchStockBalanceEntity;
import kmsweb.services.BatchStockBalancePerDateService;
import kmsweb.entities.BatchStockBalancePerDateEntity;
import kmsweb.services.BatchStockTransactionDetailService;
import kmsweb.entities.BatchStockTransactionDetailEntity;
import kmsweb.services.GoodsReceiveNoteService;
import kmsweb.entities.GoodsReceiveNoteEntity;
import kmsweb.services.GoodsReceiveNoteBatchService;
import kmsweb.entities.GoodsReceiveNoteBatchEntity;
import kmsweb.services.InternalOrderService;
import kmsweb.entities.InternalOrderEntity;
import kmsweb.services.InventoryAdjusmentBatchService;
import kmsweb.entities.InventoryAdjusmentBatchEntity;
import kmsweb.services.InventoryAdjustmentService;
import kmsweb.entities.InventoryAdjustmentEntity;
import kmsweb.services.InventoryBatchCorrectionService;
import kmsweb.entities.InventoryBatchCorrectionEntity;
import kmsweb.services.LocationService;
import kmsweb.entities.LocationEntity;
import kmsweb.services.MedicalFeeService;
import kmsweb.entities.MedicalFeeEntity;
import kmsweb.services.MedicationHeaderService;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.services.PrescriptionHeaderService;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.services.PurchaseOrderService;
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.services.PurchaseRequisitionService;
import kmsweb.entities.PurchaseRequisitionEntity;
import kmsweb.services.RetailPharmacyService;
import kmsweb.entities.RetailPharmacyEntity;
import kmsweb.services.ReturnSupplierService;
import kmsweb.entities.ReturnSupplierEntity;
import kmsweb.services.StockCatalogueService;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.services.StockControlService;
import kmsweb.entities.StockControlEntity;
import kmsweb.services.StockTransactionDetailService;
import kmsweb.entities.StockTransactionDetailEntity;
import kmsweb.services.StockTransactionPerDateService;
import kmsweb.entities.StockTransactionPerDateEntity;
import kmsweb.services.StockTransactionPerDateTypeService;
import kmsweb.entities.StockTransactionPerDateTypeEntity;
import kmsweb.services.TransferOrderService;
import kmsweb.entities.TransferOrderEntity;
import kmsweb.services.VaccinationOrderDetailService;
import kmsweb.entities.VaccinationOrderDetailEntity;
import kmsweb.services.WarehouseInitialStockService;
import kmsweb.entities.WarehouseInitialStockEntity;
import kmsweb.services.WarehouseInventoryService;
import kmsweb.entities.WarehouseInventoryEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class WarehouseMutationResolver implements GraphQLMutationResolver {

	private final WarehouseService warehouseService;

	private final BatchStockBalanceService batchStockBalanceService;

	private final BatchStockBalancePerDateService batchStockBalancePerDateService;

	private final BatchStockTransactionDetailService batchStockTransactionDetailService;

	private final GoodsReceiveNoteService goodsReceiveNoteService;

	private final GoodsReceiveNoteBatchService goodsReceiveNoteBatchService;

	private final InternalOrderService internalOrderService;

	private final InventoryAdjusmentBatchService inventoryAdjusmentBatchService;

	private final InventoryAdjustmentService inventoryAdjustmentService;

	private final InventoryBatchCorrectionService inventoryBatchCorrectionService;

	private final LocationService locationService;

	private final MedicalFeeService medicalFeeService;

	private final MedicationHeaderService medicationHeaderService;

	private final PrescriptionHeaderService prescriptionHeaderService;

	private final PurchaseOrderService purchaseOrderService;

	private final PurchaseRequisitionService purchaseRequisitionService;

	private final RetailPharmacyService retailPharmacyService;

	private final ReturnSupplierService returnSupplierService;

	private final StockCatalogueService stockCatalogueService;

	private final StockControlService stockControlService;

	private final StockTransactionDetailService stockTransactionDetailService;

	private final StockTransactionPerDateService stockTransactionPerDateService;

	private final StockTransactionPerDateTypeService stockTransactionPerDateTypeService;

	private final TransferOrderService transferOrderService;

	private final VaccinationOrderDetailService vaccinationOrderDetailService;

	private final WarehouseInitialStockService warehouseInitialStockService;

	private final WarehouseInventoryService warehouseInventoryService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public WarehouseMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BatchStockBalanceService batchStockBalanceService,
			BatchStockBalancePerDateService batchStockBalancePerDateService,
			BatchStockTransactionDetailService batchStockTransactionDetailService,
			GoodsReceiveNoteService goodsReceiveNoteService,
			GoodsReceiveNoteBatchService goodsReceiveNoteBatchService,
			InternalOrderService internalOrderService,
			InventoryAdjusmentBatchService inventoryAdjusmentBatchService,
			InventoryAdjustmentService inventoryAdjustmentService,
			InventoryBatchCorrectionService inventoryBatchCorrectionService,
			LocationService locationService,
			MedicalFeeService medicalFeeService,
			MedicationHeaderService medicationHeaderService,
			PrescriptionHeaderService prescriptionHeaderService,
			PurchaseOrderService purchaseOrderService,
			PurchaseRequisitionService purchaseRequisitionService,
			RetailPharmacyService retailPharmacyService,
			ReturnSupplierService returnSupplierService,
			StockCatalogueService stockCatalogueService,
			StockControlService stockControlService,
			StockTransactionDetailService stockTransactionDetailService,
			StockTransactionPerDateService stockTransactionPerDateService,
			StockTransactionPerDateTypeService stockTransactionPerDateTypeService,
			TransferOrderService transferOrderService,
			VaccinationOrderDetailService vaccinationOrderDetailService,
			WarehouseInitialStockService warehouseInitialStockService,
			WarehouseInventoryService warehouseInventoryService,
			WarehouseService warehouseService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.warehouseService = warehouseService;

		this.batchStockBalanceService = batchStockBalanceService;

		this.batchStockBalancePerDateService = batchStockBalancePerDateService;

		this.batchStockTransactionDetailService = batchStockTransactionDetailService;

		this.goodsReceiveNoteService = goodsReceiveNoteService;

		this.goodsReceiveNoteBatchService = goodsReceiveNoteBatchService;

		this.internalOrderService = internalOrderService;

		this.inventoryAdjusmentBatchService = inventoryAdjusmentBatchService;

		this.inventoryAdjustmentService = inventoryAdjustmentService;

		this.inventoryBatchCorrectionService = inventoryBatchCorrectionService;

		this.locationService = locationService;

		this.medicalFeeService = medicalFeeService;

		this.medicationHeaderService = medicationHeaderService;

		this.prescriptionHeaderService = prescriptionHeaderService;

		this.purchaseOrderService = purchaseOrderService;

		this.purchaseRequisitionService = purchaseRequisitionService;

		this.retailPharmacyService = retailPharmacyService;

		this.returnSupplierService = returnSupplierService;

		this.stockCatalogueService = stockCatalogueService;

		this.stockControlService = stockControlService;

		this.stockTransactionDetailService = stockTransactionDetailService;

		this.stockTransactionPerDateService = stockTransactionPerDateService;

		this.stockTransactionPerDateTypeService = stockTransactionPerDateTypeService;

		this.transferOrderService = transferOrderService;

		this.vaccinationOrderDetailService = vaccinationOrderDetailService;

		this.warehouseInitialStockService = warehouseInitialStockService;

		this.warehouseInventoryService = warehouseInventoryService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'create')")
	public WarehouseEntity createWarehouse(@NonNull WarehouseEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<BatchStockBalanceEntity> batchStockBalancesWarehouse = new HashSet<>();
		rawEntity.getBatchStockBalancesWarehouse().forEach(entity -> {
			batchStockBalancesWarehouse.add(batchStockBalanceService.updateOldData(entity));
		});
		rawEntity.setBatchStockBalancesWarehouse(batchStockBalancesWarehouse);

		Set<BatchStockBalancePerDateEntity> batchStockBalances = new HashSet<>();
		rawEntity.getBatchStockBalances().forEach(entity -> {
			batchStockBalances.add(batchStockBalancePerDateService.updateOldData(entity));
		});
		rawEntity.setBatchStockBalances(batchStockBalances);

		Set<BatchStockTransactionDetailEntity> batchStockTransactionDetails = new HashSet<>();
		rawEntity.getBatchStockTransactionDetails().forEach(entity -> {
			batchStockTransactionDetails.add(batchStockTransactionDetailService.updateOldData(entity));
		});
		rawEntity.setBatchStockTransactionDetails(batchStockTransactionDetails);

		Set<TransferOrderEntity> destinationWarehouses = new HashSet<>();
		rawEntity.getDestinationWarehouses().forEach(entity -> {
			destinationWarehouses.add(transferOrderService.updateOldData(entity));
		});
		rawEntity.setDestinationWarehouses(destinationWarehouses);

		Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs = new HashSet<>();
		rawEntity.getGoodsReceiveNoteBatchs().forEach(entity -> {
			goodsReceiveNoteBatchs.add(goodsReceiveNoteBatchService.updateOldData(entity));
		});
		rawEntity.setGoodsReceiveNoteBatchs(goodsReceiveNoteBatchs);

		Set<GoodsReceiveNoteEntity> goodsReceiveNotes = new HashSet<>();
		rawEntity.getGoodsReceiveNotes().forEach(entity -> {
			goodsReceiveNotes.add(goodsReceiveNoteService.updateOldData(entity));
		});
		rawEntity.setGoodsReceiveNotes(goodsReceiveNotes);

		Set<InternalOrderEntity> internalOrders = new HashSet<>();
		rawEntity.getInternalOrders().forEach(entity -> {
			internalOrders.add(internalOrderService.updateOldData(entity));
		});
		rawEntity.setInternalOrders(internalOrders);

		Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs = new HashSet<>();
		rawEntity.getInventoryAdjusmentBatchs().forEach(entity -> {
			inventoryAdjusmentBatchs.add(inventoryAdjusmentBatchService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjusmentBatchs(inventoryAdjusmentBatchs);

		Set<InventoryAdjustmentEntity> inventoryAdjustments = new HashSet<>();
		rawEntity.getInventoryAdjustments().forEach(entity -> {
			inventoryAdjustments.add(inventoryAdjustmentService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjustments(inventoryAdjustments);

		Set<InventoryBatchCorrectionEntity> inventoryBatchCorrections = new HashSet<>();
		rawEntity.getInventoryBatchCorrections().forEach(entity -> {
			inventoryBatchCorrections.add(inventoryBatchCorrectionService.updateOldData(entity));
		});
		rawEntity.setInventoryBatchCorrections(inventoryBatchCorrections);

		Set<LocationEntity> locations = new HashSet<>();
		rawEntity.getLocations().forEach(entity -> {
			locations.add(locationService.updateOldData(entity));
		});
		rawEntity.setLocations(locations);

		Set<MedicalFeeEntity> medicalFees = new HashSet<>();
		rawEntity.getMedicalFees().forEach(entity -> {
			medicalFees.add(medicalFeeService.updateOldData(entity));
		});
		rawEntity.setMedicalFees(medicalFees);

		Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();
		rawEntity.getMedicationHeaders().forEach(entity -> {
			medicationHeaders.add(medicationHeaderService.updateOldData(entity));
		});
		rawEntity.setMedicationHeaders(medicationHeaders);

		Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();
		rawEntity.getPrescriptionHeaders().forEach(entity -> {
			prescriptionHeaders.add(prescriptionHeaderService.updateOldData(entity));
		});
		rawEntity.setPrescriptionHeaders(prescriptionHeaders);

		Set<PurchaseOrderEntity> purchaseOrders = new HashSet<>();
		rawEntity.getPurchaseOrders().forEach(entity -> {
			purchaseOrders.add(purchaseOrderService.updateOldData(entity));
		});
		rawEntity.setPurchaseOrders(purchaseOrders);

		Set<PurchaseRequisitionEntity> purchaseRequisitions = new HashSet<>();
		rawEntity.getPurchaseRequisitions().forEach(entity -> {
			purchaseRequisitions.add(purchaseRequisitionService.updateOldData(entity));
		});
		rawEntity.setPurchaseRequisitions(purchaseRequisitions);

		Set<RetailPharmacyEntity> retailPharmacies = new HashSet<>();
		rawEntity.getRetailPharmacies().forEach(entity -> {
			retailPharmacies.add(retailPharmacyService.updateOldData(entity));
		});
		rawEntity.setRetailPharmacies(retailPharmacies);

		Set<ReturnSupplierEntity> returnSuppliers = new HashSet<>();
		rawEntity.getReturnSuppliers().forEach(entity -> {
			returnSuppliers.add(returnSupplierService.updateOldData(entity));
		});
		rawEntity.setReturnSuppliers(returnSuppliers);

		Set<TransferOrderEntity> sourceWarehouses = new HashSet<>();
		rawEntity.getSourceWarehouses().forEach(entity -> {
			sourceWarehouses.add(transferOrderService.updateOldData(entity));
		});
		rawEntity.setSourceWarehouses(sourceWarehouses);

		Set<StockCatalogueEntity> stockCatalogues = new HashSet<>();
		rawEntity.getStockCatalogues().forEach(entity -> {
			stockCatalogues.add(stockCatalogueService.updateOldData(entity));
		});
		rawEntity.setStockCatalogues(stockCatalogues);

		Set<StockControlEntity> stockControls = new HashSet<>();
		rawEntity.getStockControls().forEach(entity -> {
			stockControls.add(stockControlService.updateOldData(entity));
		});
		rawEntity.setStockControls(stockControls);

		Set<StockTransactionDetailEntity> stockTransactionDetails = new HashSet<>();
		rawEntity.getStockTransactionDetails().forEach(entity -> {
			stockTransactionDetails.add(stockTransactionDetailService.updateOldData(entity));
		});
		rawEntity.setStockTransactionDetails(stockTransactionDetails);

		Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes = new HashSet<>();
		rawEntity.getStockTransactionPerDateTypes().forEach(entity -> {
			stockTransactionPerDateTypes.add(stockTransactionPerDateTypeService.updateOldData(entity));
		});
		rawEntity.setStockTransactionPerDateTypes(stockTransactionPerDateTypes);

		Set<StockTransactionPerDateEntity> stockTransactionPerDates = new HashSet<>();
		rawEntity.getStockTransactionPerDates().forEach(entity -> {
			stockTransactionPerDates.add(stockTransactionPerDateService.updateOldData(entity));
		});
		rawEntity.setStockTransactionPerDates(stockTransactionPerDates);

		Set<VaccinationOrderDetailEntity> vaccinationOrderDetails = new HashSet<>();
		rawEntity.getVaccinationOrderDetails().forEach(entity -> {
			vaccinationOrderDetails.add(vaccinationOrderDetailService.updateOldData(entity));
		});
		rawEntity.setVaccinationOrderDetails(vaccinationOrderDetails);

		Set<WarehouseInitialStockEntity> warehouseInitialStockS = new HashSet<>();
		rawEntity.getWarehouseInitialStockS().forEach(entity -> {
			warehouseInitialStockS.add(warehouseInitialStockService.updateOldData(entity));
		});
		rawEntity.setWarehouseInitialStockS(warehouseInitialStockS);

		Set<WarehouseInventoryEntity> warehouseInventories = new HashSet<>();
		rawEntity.getWarehouseInventories().forEach(entity -> {
			warehouseInventories.add(warehouseInventoryService.updateOldData(entity));
		});
		rawEntity.setWarehouseInventories(warehouseInventories);

		WarehouseEntity newEntity = warehouseService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link WarehouseMutationResolver#createWarehouse(WarehouseEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'create')")
	public List<WarehouseEntity> createAllWarehouse(@NonNull List<WarehouseEntity> rawEntities) {
		List<WarehouseEntity> newEntities = Lists.newArrayList(warehouseService.createAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the created entities here] off begin
		// % protected region % [Add any additional logic for update before returning the created entities here] end

		return newEntities;
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'update')")
	public WarehouseEntity updateWarehouse(@NonNull WarehouseEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		Set<BatchStockBalanceEntity> batchStockBalancesWarehouse = new HashSet<>();
		rawEntity.getBatchStockBalancesWarehouse().forEach(entity -> {
			batchStockBalancesWarehouse.add(batchStockBalanceService.updateOldData(entity));
		});
		rawEntity.setBatchStockBalancesWarehouse(batchStockBalancesWarehouse);

		Set<BatchStockBalancePerDateEntity> batchStockBalances = new HashSet<>();
		rawEntity.getBatchStockBalances().forEach(entity -> {
			batchStockBalances.add(batchStockBalancePerDateService.updateOldData(entity));
		});
		rawEntity.setBatchStockBalances(batchStockBalances);

		Set<BatchStockTransactionDetailEntity> batchStockTransactionDetails = new HashSet<>();
		rawEntity.getBatchStockTransactionDetails().forEach(entity -> {
			batchStockTransactionDetails.add(batchStockTransactionDetailService.updateOldData(entity));
		});
		rawEntity.setBatchStockTransactionDetails(batchStockTransactionDetails);

		Set<TransferOrderEntity> destinationWarehouses = new HashSet<>();
		rawEntity.getDestinationWarehouses().forEach(entity -> {
			destinationWarehouses.add(transferOrderService.updateOldData(entity));
		});
		rawEntity.setDestinationWarehouses(destinationWarehouses);

		Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs = new HashSet<>();
		rawEntity.getGoodsReceiveNoteBatchs().forEach(entity -> {
			goodsReceiveNoteBatchs.add(goodsReceiveNoteBatchService.updateOldData(entity));
		});
		rawEntity.setGoodsReceiveNoteBatchs(goodsReceiveNoteBatchs);

		Set<GoodsReceiveNoteEntity> goodsReceiveNotes = new HashSet<>();
		rawEntity.getGoodsReceiveNotes().forEach(entity -> {
			goodsReceiveNotes.add(goodsReceiveNoteService.updateOldData(entity));
		});
		rawEntity.setGoodsReceiveNotes(goodsReceiveNotes);

		Set<InternalOrderEntity> internalOrders = new HashSet<>();
		rawEntity.getInternalOrders().forEach(entity -> {
			internalOrders.add(internalOrderService.updateOldData(entity));
		});
		rawEntity.setInternalOrders(internalOrders);

		Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs = new HashSet<>();
		rawEntity.getInventoryAdjusmentBatchs().forEach(entity -> {
			inventoryAdjusmentBatchs.add(inventoryAdjusmentBatchService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjusmentBatchs(inventoryAdjusmentBatchs);

		Set<InventoryAdjustmentEntity> inventoryAdjustments = new HashSet<>();
		rawEntity.getInventoryAdjustments().forEach(entity -> {
			inventoryAdjustments.add(inventoryAdjustmentService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjustments(inventoryAdjustments);

		Set<InventoryBatchCorrectionEntity> inventoryBatchCorrections = new HashSet<>();
		rawEntity.getInventoryBatchCorrections().forEach(entity -> {
			inventoryBatchCorrections.add(inventoryBatchCorrectionService.updateOldData(entity));
		});
		rawEntity.setInventoryBatchCorrections(inventoryBatchCorrections);

		Set<LocationEntity> locations = new HashSet<>();
		rawEntity.getLocations().forEach(entity -> {
			locations.add(locationService.updateOldData(entity));
		});
		rawEntity.setLocations(locations);

		Set<MedicalFeeEntity> medicalFees = new HashSet<>();
		rawEntity.getMedicalFees().forEach(entity -> {
			medicalFees.add(medicalFeeService.updateOldData(entity));
		});
		rawEntity.setMedicalFees(medicalFees);

		Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();
		rawEntity.getMedicationHeaders().forEach(entity -> {
			medicationHeaders.add(medicationHeaderService.updateOldData(entity));
		});
		rawEntity.setMedicationHeaders(medicationHeaders);

		Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();
		rawEntity.getPrescriptionHeaders().forEach(entity -> {
			prescriptionHeaders.add(prescriptionHeaderService.updateOldData(entity));
		});
		rawEntity.setPrescriptionHeaders(prescriptionHeaders);

		Set<PurchaseOrderEntity> purchaseOrders = new HashSet<>();
		rawEntity.getPurchaseOrders().forEach(entity -> {
			purchaseOrders.add(purchaseOrderService.updateOldData(entity));
		});
		rawEntity.setPurchaseOrders(purchaseOrders);

		Set<PurchaseRequisitionEntity> purchaseRequisitions = new HashSet<>();
		rawEntity.getPurchaseRequisitions().forEach(entity -> {
			purchaseRequisitions.add(purchaseRequisitionService.updateOldData(entity));
		});
		rawEntity.setPurchaseRequisitions(purchaseRequisitions);

		Set<RetailPharmacyEntity> retailPharmacies = new HashSet<>();
		rawEntity.getRetailPharmacies().forEach(entity -> {
			retailPharmacies.add(retailPharmacyService.updateOldData(entity));
		});
		rawEntity.setRetailPharmacies(retailPharmacies);

		Set<ReturnSupplierEntity> returnSuppliers = new HashSet<>();
		rawEntity.getReturnSuppliers().forEach(entity -> {
			returnSuppliers.add(returnSupplierService.updateOldData(entity));
		});
		rawEntity.setReturnSuppliers(returnSuppliers);

		Set<TransferOrderEntity> sourceWarehouses = new HashSet<>();
		rawEntity.getSourceWarehouses().forEach(entity -> {
			sourceWarehouses.add(transferOrderService.updateOldData(entity));
		});
		rawEntity.setSourceWarehouses(sourceWarehouses);

		Set<StockCatalogueEntity> stockCatalogues = new HashSet<>();
		rawEntity.getStockCatalogues().forEach(entity -> {
			stockCatalogues.add(stockCatalogueService.updateOldData(entity));
		});
		rawEntity.setStockCatalogues(stockCatalogues);

		Set<StockControlEntity> stockControls = new HashSet<>();
		rawEntity.getStockControls().forEach(entity -> {
			stockControls.add(stockControlService.updateOldData(entity));
		});
		rawEntity.setStockControls(stockControls);

		Set<StockTransactionDetailEntity> stockTransactionDetails = new HashSet<>();
		rawEntity.getStockTransactionDetails().forEach(entity -> {
			stockTransactionDetails.add(stockTransactionDetailService.updateOldData(entity));
		});
		rawEntity.setStockTransactionDetails(stockTransactionDetails);

		Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes = new HashSet<>();
		rawEntity.getStockTransactionPerDateTypes().forEach(entity -> {
			stockTransactionPerDateTypes.add(stockTransactionPerDateTypeService.updateOldData(entity));
		});
		rawEntity.setStockTransactionPerDateTypes(stockTransactionPerDateTypes);

		Set<StockTransactionPerDateEntity> stockTransactionPerDates = new HashSet<>();
		rawEntity.getStockTransactionPerDates().forEach(entity -> {
			stockTransactionPerDates.add(stockTransactionPerDateService.updateOldData(entity));
		});
		rawEntity.setStockTransactionPerDates(stockTransactionPerDates);

		Set<VaccinationOrderDetailEntity> vaccinationOrderDetails = new HashSet<>();
		rawEntity.getVaccinationOrderDetails().forEach(entity -> {
			vaccinationOrderDetails.add(vaccinationOrderDetailService.updateOldData(entity));
		});
		rawEntity.setVaccinationOrderDetails(vaccinationOrderDetails);

		Set<WarehouseInitialStockEntity> warehouseInitialStockS = new HashSet<>();
		rawEntity.getWarehouseInitialStockS().forEach(entity -> {
			warehouseInitialStockS.add(warehouseInitialStockService.updateOldData(entity));
		});
		rawEntity.setWarehouseInitialStockS(warehouseInitialStockS);

		Set<WarehouseInventoryEntity> warehouseInventories = new HashSet<>();
		rawEntity.getWarehouseInventories().forEach(entity -> {
			warehouseInventories.add(warehouseInventoryService.updateOldData(entity));
		});
		rawEntity.setWarehouseInventories(warehouseInventories);

		WarehouseEntity entityFromDb = warehouseService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		WarehouseEntity newEntity = warehouseService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link WarehouseMutationResolver#updateWarehouse(WarehouseEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'update')")
	public List<WarehouseEntity> updateAllWarehouse(@NonNull List<WarehouseEntity> rawEntities) {
		List<WarehouseEntity> newEntities = Lists.newArrayList(warehouseService.updateAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the updated entities here] off begin
		// % protected region % [Add any additional logic for update before returning the updated entities here] end

		return newEntities;
	}

	/**
	 * Delete the entity with the ID from the database.
	 *
	 * @param id the ID of the entity to be deleted
	 * @return the ID of the deleted entity
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'delete')")
	public String deleteWarehouseById(@NonNull String id) {
		warehouseService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link WarehouseMutationResolver#deleteWarehouseById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('WarehouseEntity', 'delete')")
	public List<String> deleteAllWarehouseByIds(@NonNull List<String> ids) {
		warehouseService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('WarehouseEntity', 'delete')")
	public List<String> deleteWarehouseExcludingIds(@NonNull List<String> ids) {
		warehouseService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
