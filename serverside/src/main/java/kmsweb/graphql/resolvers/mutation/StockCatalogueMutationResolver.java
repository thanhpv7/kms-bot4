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
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.services.StockCatalogueService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsDrugGenericPRBService;
import kmsweb.entities.BpjsDrugGenericPRBEntity;
import kmsweb.services.BpjsPcareDPHOService;
import kmsweb.entities.BpjsPcareDPHOEntity;
import kmsweb.services.BatchStockBalanceService;
import kmsweb.entities.BatchStockBalanceEntity;
import kmsweb.services.BatchStockBalancePerDateService;
import kmsweb.entities.BatchStockBalancePerDateEntity;
import kmsweb.services.BatchStockTransactionDetailService;
import kmsweb.entities.BatchStockTransactionDetailEntity;
import kmsweb.services.CatalogueMedicalService;
import kmsweb.entities.CatalogueMedicalEntity;
import kmsweb.services.CatalogueNonMedicalService;
import kmsweb.entities.CatalogueNonMedicalEntity;
import kmsweb.services.CatalogueUOMService;
import kmsweb.entities.CatalogueUOMEntity;
import kmsweb.services.CompoundPrescriptionItemService;
import kmsweb.entities.CompoundPrescriptionItemEntity;
import kmsweb.services.GoodsReceiveNoteBatchService;
import kmsweb.entities.GoodsReceiveNoteBatchEntity;
import kmsweb.services.GoodsReceiveNoteItemService;
import kmsweb.entities.GoodsReceiveNoteItemEntity;
import kmsweb.services.InternalOrderStockDetailService;
import kmsweb.entities.InternalOrderStockDetailEntity;
import kmsweb.services.InventoryAdjusmentBatchService;
import kmsweb.entities.InventoryAdjusmentBatchEntity;
import kmsweb.services.InventoryAdjustmentItemService;
import kmsweb.entities.InventoryAdjustmentItemEntity;
import kmsweb.services.InventoryBatchCorrectionItemService;
import kmsweb.entities.InventoryBatchCorrectionItemEntity;
import kmsweb.services.MedicationItemService;
import kmsweb.entities.MedicationItemEntity;
import kmsweb.services.PrescriptionItemService;
import kmsweb.entities.PrescriptionItemEntity;
import kmsweb.services.PurchaseOrderStockDetailService;
import kmsweb.entities.PurchaseOrderStockDetailEntity;
import kmsweb.services.PurchaseRequisitionStockDetailService;
import kmsweb.entities.PurchaseRequisitionStockDetailEntity;
import kmsweb.services.RetailPharmacyStockDetailService;
import kmsweb.entities.RetailPharmacyStockDetailEntity;
import kmsweb.services.ReturnSupplierStockDetailService;
import kmsweb.entities.ReturnSupplierStockDetailEntity;
import kmsweb.services.StockControlService;
import kmsweb.entities.StockControlEntity;
import kmsweb.services.StockTransactionDetailService;
import kmsweb.entities.StockTransactionDetailEntity;
import kmsweb.services.StockTransactionPerDateService;
import kmsweb.entities.StockTransactionPerDateEntity;
import kmsweb.services.StockTransactionPerDateTypeService;
import kmsweb.entities.StockTransactionPerDateTypeEntity;
import kmsweb.services.SupplierProductDetailService;
import kmsweb.entities.SupplierProductDetailEntity;
import kmsweb.services.TransferOrderStockDetailService;
import kmsweb.entities.TransferOrderStockDetailEntity;
import kmsweb.services.VaccinationOrderDetailService;
import kmsweb.entities.VaccinationOrderDetailEntity;
import kmsweb.services.WarehouseService;
import kmsweb.entities.WarehouseEntity;
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
public class StockCatalogueMutationResolver implements GraphQLMutationResolver {

	private final StockCatalogueService stockCatalogueService;

	private final BpjsDrugGenericPRBService bpjsDrugGenericPRBService;

	private final BpjsPcareDPHOService bpjsPcareDPHOService;

	private final BatchStockBalanceService batchStockBalanceService;

	private final BatchStockBalancePerDateService batchStockBalancePerDateService;

	private final BatchStockTransactionDetailService batchStockTransactionDetailService;

	private final CatalogueMedicalService catalogueMedicalService;

	private final CatalogueNonMedicalService catalogueNonMedicalService;

	private final CatalogueUOMService catalogueUOMService;

	private final CompoundPrescriptionItemService compoundPrescriptionItemService;

	private final GoodsReceiveNoteBatchService goodsReceiveNoteBatchService;

	private final GoodsReceiveNoteItemService goodsReceiveNoteItemService;

	private final InternalOrderStockDetailService internalOrderStockDetailService;

	private final InventoryAdjusmentBatchService inventoryAdjusmentBatchService;

	private final InventoryAdjustmentItemService inventoryAdjustmentItemService;

	private final InventoryBatchCorrectionItemService inventoryBatchCorrectionItemService;

	private final MedicationItemService medicationItemService;

	private final PrescriptionItemService prescriptionItemService;

	private final PurchaseOrderStockDetailService purchaseOrderStockDetailService;

	private final PurchaseRequisitionStockDetailService purchaseRequisitionStockDetailService;

	private final RetailPharmacyStockDetailService retailPharmacyStockDetailService;

	private final ReturnSupplierStockDetailService returnSupplierStockDetailService;

	private final StockControlService stockControlService;

	private final StockTransactionDetailService stockTransactionDetailService;

	private final StockTransactionPerDateService stockTransactionPerDateService;

	private final StockTransactionPerDateTypeService stockTransactionPerDateTypeService;

	private final SupplierProductDetailService supplierProductDetailService;

	private final TransferOrderStockDetailService transferOrderStockDetailService;

	private final VaccinationOrderDetailService vaccinationOrderDetailService;

	private final WarehouseService warehouseService;

	private final WarehouseInitialStockService warehouseInitialStockService;

	private final WarehouseInventoryService warehouseInventoryService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public StockCatalogueMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsDrugGenericPRBService bpjsDrugGenericPRBService,
			BpjsPcareDPHOService bpjsPcareDPHOService,
			BatchStockBalanceService batchStockBalanceService,
			BatchStockBalancePerDateService batchStockBalancePerDateService,
			BatchStockTransactionDetailService batchStockTransactionDetailService,
			CatalogueMedicalService catalogueMedicalService,
			CatalogueNonMedicalService catalogueNonMedicalService,
			CatalogueUOMService catalogueUOMService,
			CompoundPrescriptionItemService compoundPrescriptionItemService,
			GoodsReceiveNoteBatchService goodsReceiveNoteBatchService,
			GoodsReceiveNoteItemService goodsReceiveNoteItemService,
			InternalOrderStockDetailService internalOrderStockDetailService,
			InventoryAdjusmentBatchService inventoryAdjusmentBatchService,
			InventoryAdjustmentItemService inventoryAdjustmentItemService,
			InventoryBatchCorrectionItemService inventoryBatchCorrectionItemService,
			MedicationItemService medicationItemService,
			PrescriptionItemService prescriptionItemService,
			PurchaseOrderStockDetailService purchaseOrderStockDetailService,
			PurchaseRequisitionStockDetailService purchaseRequisitionStockDetailService,
			RetailPharmacyStockDetailService retailPharmacyStockDetailService,
			ReturnSupplierStockDetailService returnSupplierStockDetailService,
			StockControlService stockControlService,
			StockTransactionDetailService stockTransactionDetailService,
			StockTransactionPerDateService stockTransactionPerDateService,
			StockTransactionPerDateTypeService stockTransactionPerDateTypeService,
			SupplierProductDetailService supplierProductDetailService,
			TransferOrderStockDetailService transferOrderStockDetailService,
			VaccinationOrderDetailService vaccinationOrderDetailService,
			WarehouseService warehouseService,
			WarehouseInitialStockService warehouseInitialStockService,
			WarehouseInventoryService warehouseInventoryService,
			StockCatalogueService stockCatalogueService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.stockCatalogueService = stockCatalogueService;

		this.bpjsDrugGenericPRBService = bpjsDrugGenericPRBService;

		this.bpjsPcareDPHOService = bpjsPcareDPHOService;

		this.batchStockBalanceService = batchStockBalanceService;

		this.batchStockBalancePerDateService = batchStockBalancePerDateService;

		this.batchStockTransactionDetailService = batchStockTransactionDetailService;

		this.catalogueMedicalService = catalogueMedicalService;

		this.catalogueNonMedicalService = catalogueNonMedicalService;

		this.catalogueUOMService = catalogueUOMService;

		this.compoundPrescriptionItemService = compoundPrescriptionItemService;

		this.goodsReceiveNoteBatchService = goodsReceiveNoteBatchService;

		this.goodsReceiveNoteItemService = goodsReceiveNoteItemService;

		this.internalOrderStockDetailService = internalOrderStockDetailService;

		this.inventoryAdjusmentBatchService = inventoryAdjusmentBatchService;

		this.inventoryAdjustmentItemService = inventoryAdjustmentItemService;

		this.inventoryBatchCorrectionItemService = inventoryBatchCorrectionItemService;

		this.medicationItemService = medicationItemService;

		this.prescriptionItemService = prescriptionItemService;

		this.purchaseOrderStockDetailService = purchaseOrderStockDetailService;

		this.purchaseRequisitionStockDetailService = purchaseRequisitionStockDetailService;

		this.retailPharmacyStockDetailService = retailPharmacyStockDetailService;

		this.returnSupplierStockDetailService = returnSupplierStockDetailService;

		this.stockControlService = stockControlService;

		this.stockTransactionDetailService = stockTransactionDetailService;

		this.stockTransactionPerDateService = stockTransactionPerDateService;

		this.stockTransactionPerDateTypeService = stockTransactionPerDateTypeService;

		this.supplierProductDetailService = supplierProductDetailService;

		this.transferOrderStockDetailService = transferOrderStockDetailService;

		this.vaccinationOrderDetailService = vaccinationOrderDetailService;

		this.warehouseService = warehouseService;

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
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'create')")
	public StockCatalogueEntity createStockCatalogue(@NonNull StockCatalogueEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getBpjsDrugGenericPRB() != null) {
			rawEntity.setBpjsDrugGenericPRB(bpjsDrugGenericPRBService.updateOldData(rawEntity.getBpjsDrugGenericPRB()));
		}

		if (rawEntity.getBpjsPcareDPHO() != null) {
			rawEntity.setBpjsPcareDPHO(bpjsPcareDPHOService.updateOldData(rawEntity.getBpjsPcareDPHO()));
		}

		if (rawEntity.getStockCatalogueMedical() != null) {
			rawEntity.setStockCatalogueMedical(catalogueMedicalService.updateOldData(rawEntity.getStockCatalogueMedical()));
		}

		if (rawEntity.getStockCatalogueNonMedical() != null) {
			rawEntity.setStockCatalogueNonMedical(catalogueNonMedicalService.updateOldData(rawEntity.getStockCatalogueNonMedical()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		Set<BatchStockBalanceEntity> batchStockBalancesCatalogue = new HashSet<>();
		rawEntity.getBatchStockBalancesCatalogue().forEach(entity -> {
			batchStockBalancesCatalogue.add(batchStockBalanceService.updateOldData(entity));
		});
		rawEntity.setBatchStockBalancesCatalogue(batchStockBalancesCatalogue);

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

		Set<CatalogueUOMEntity> catalogueUOMs = new HashSet<>();
		rawEntity.getCatalogueUOMs().forEach(entity -> {
			catalogueUOMs.add(catalogueUOMService.updateOldData(entity));
		});
		rawEntity.setCatalogueUOMs(catalogueUOMs);

		Set<CompoundPrescriptionItemEntity> compoundPrescriptionItems = new HashSet<>();
		rawEntity.getCompoundPrescriptionItems().forEach(entity -> {
			compoundPrescriptionItems.add(compoundPrescriptionItemService.updateOldData(entity));
		});
		rawEntity.setCompoundPrescriptionItems(compoundPrescriptionItems);

		Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs = new HashSet<>();
		rawEntity.getGoodsReceiveNoteBatchs().forEach(entity -> {
			goodsReceiveNoteBatchs.add(goodsReceiveNoteBatchService.updateOldData(entity));
		});
		rawEntity.setGoodsReceiveNoteBatchs(goodsReceiveNoteBatchs);

		Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItems = new HashSet<>();
		rawEntity.getGoodsReceiveNoteItems().forEach(entity -> {
			goodsReceiveNoteItems.add(goodsReceiveNoteItemService.updateOldData(entity));
		});
		rawEntity.setGoodsReceiveNoteItems(goodsReceiveNoteItems);

		Set<InternalOrderStockDetailEntity> internalOrderStockDetails = new HashSet<>();
		rawEntity.getInternalOrderStockDetails().forEach(entity -> {
			internalOrderStockDetails.add(internalOrderStockDetailService.updateOldData(entity));
		});
		rawEntity.setInternalOrderStockDetails(internalOrderStockDetails);

		Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs = new HashSet<>();
		rawEntity.getInventoryAdjusmentBatchs().forEach(entity -> {
			inventoryAdjusmentBatchs.add(inventoryAdjusmentBatchService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjusmentBatchs(inventoryAdjusmentBatchs);

		Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItems = new HashSet<>();
		rawEntity.getInventoryAdjustmentItems().forEach(entity -> {
			inventoryAdjustmentItems.add(inventoryAdjustmentItemService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjustmentItems(inventoryAdjustmentItems);

		Set<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItems = new HashSet<>();
		rawEntity.getInventoryBatchCorrectionItems().forEach(entity -> {
			inventoryBatchCorrectionItems.add(inventoryBatchCorrectionItemService.updateOldData(entity));
		});
		rawEntity.setInventoryBatchCorrectionItems(inventoryBatchCorrectionItems);

		Set<MedicationItemEntity> medicationItems = new HashSet<>();
		rawEntity.getMedicationItems().forEach(entity -> {
			medicationItems.add(medicationItemService.updateOldData(entity));
		});
		rawEntity.setMedicationItems(medicationItems);

		Set<PrescriptionItemEntity> prescriptionItem = new HashSet<>();
		rawEntity.getPrescriptionItem().forEach(entity -> {
			prescriptionItem.add(prescriptionItemService.updateOldData(entity));
		});
		rawEntity.setPrescriptionItem(prescriptionItem);

		Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails = new HashSet<>();
		rawEntity.getPurchaseOrderStockDetails().forEach(entity -> {
			purchaseOrderStockDetails.add(purchaseOrderStockDetailService.updateOldData(entity));
		});
		rawEntity.setPurchaseOrderStockDetails(purchaseOrderStockDetails);

		Set<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetails = new HashSet<>();
		rawEntity.getPurchaseRequisitionStockDetails().forEach(entity -> {
			purchaseRequisitionStockDetails.add(purchaseRequisitionStockDetailService.updateOldData(entity));
		});
		rawEntity.setPurchaseRequisitionStockDetails(purchaseRequisitionStockDetails);

		Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetails = new HashSet<>();
		rawEntity.getRetailPharmacyStockDetails().forEach(entity -> {
			retailPharmacyStockDetails.add(retailPharmacyStockDetailService.updateOldData(entity));
		});
		rawEntity.setRetailPharmacyStockDetails(retailPharmacyStockDetails);

		Set<ReturnSupplierStockDetailEntity> returnSupplierStockDetails = new HashSet<>();
		rawEntity.getReturnSupplierStockDetails().forEach(entity -> {
			returnSupplierStockDetails.add(returnSupplierStockDetailService.updateOldData(entity));
		});
		rawEntity.setReturnSupplierStockDetails(returnSupplierStockDetails);

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

		Set<SupplierProductDetailEntity> supplierProductDetails = new HashSet<>();
		rawEntity.getSupplierProductDetails().forEach(entity -> {
			supplierProductDetails.add(supplierProductDetailService.updateOldData(entity));
		});
		rawEntity.setSupplierProductDetails(supplierProductDetails);

		Set<TransferOrderStockDetailEntity> transferOrderStockDetails = new HashSet<>();
		rawEntity.getTransferOrderStockDetails().forEach(entity -> {
			transferOrderStockDetails.add(transferOrderStockDetailService.updateOldData(entity));
		});
		rawEntity.setTransferOrderStockDetails(transferOrderStockDetails);

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

		StockCatalogueEntity newEntity = stockCatalogueService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link StockCatalogueMutationResolver#createStockCatalogue(StockCatalogueEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'create')")
	public List<StockCatalogueEntity> createAllStockCatalogue(@NonNull List<StockCatalogueEntity> rawEntities) {
		List<StockCatalogueEntity> newEntities = Lists.newArrayList(stockCatalogueService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'update')")
	public StockCatalogueEntity updateStockCatalogue(@NonNull StockCatalogueEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getBpjsDrugGenericPRB() != null) {
			rawEntity.setBpjsDrugGenericPRB(bpjsDrugGenericPRBService.updateOldData(rawEntity.getBpjsDrugGenericPRB()));
		}

		if (rawEntity.getBpjsPcareDPHO() != null) {
			rawEntity.setBpjsPcareDPHO(bpjsPcareDPHOService.updateOldData(rawEntity.getBpjsPcareDPHO()));
		}

		if (rawEntity.getStockCatalogueMedical() != null) {
			rawEntity.setStockCatalogueMedical(catalogueMedicalService.updateOldData(rawEntity.getStockCatalogueMedical()));
		}

		if (rawEntity.getStockCatalogueNonMedical() != null) {
			rawEntity.setStockCatalogueNonMedical(catalogueNonMedicalService.updateOldData(rawEntity.getStockCatalogueNonMedical()));
		}

		if (rawEntity.getWarehouse() != null) {
			rawEntity.setWarehouse(warehouseService.updateOldData(rawEntity.getWarehouse()));
		}

		Set<BatchStockBalanceEntity> batchStockBalancesCatalogue = new HashSet<>();
		rawEntity.getBatchStockBalancesCatalogue().forEach(entity -> {
			batchStockBalancesCatalogue.add(batchStockBalanceService.updateOldData(entity));
		});
		rawEntity.setBatchStockBalancesCatalogue(batchStockBalancesCatalogue);

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

		Set<CatalogueUOMEntity> catalogueUOMs = new HashSet<>();
		rawEntity.getCatalogueUOMs().forEach(entity -> {
			catalogueUOMs.add(catalogueUOMService.updateOldData(entity));
		});
		rawEntity.setCatalogueUOMs(catalogueUOMs);

		Set<CompoundPrescriptionItemEntity> compoundPrescriptionItems = new HashSet<>();
		rawEntity.getCompoundPrescriptionItems().forEach(entity -> {
			compoundPrescriptionItems.add(compoundPrescriptionItemService.updateOldData(entity));
		});
		rawEntity.setCompoundPrescriptionItems(compoundPrescriptionItems);

		Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs = new HashSet<>();
		rawEntity.getGoodsReceiveNoteBatchs().forEach(entity -> {
			goodsReceiveNoteBatchs.add(goodsReceiveNoteBatchService.updateOldData(entity));
		});
		rawEntity.setGoodsReceiveNoteBatchs(goodsReceiveNoteBatchs);

		Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItems = new HashSet<>();
		rawEntity.getGoodsReceiveNoteItems().forEach(entity -> {
			goodsReceiveNoteItems.add(goodsReceiveNoteItemService.updateOldData(entity));
		});
		rawEntity.setGoodsReceiveNoteItems(goodsReceiveNoteItems);

		Set<InternalOrderStockDetailEntity> internalOrderStockDetails = new HashSet<>();
		rawEntity.getInternalOrderStockDetails().forEach(entity -> {
			internalOrderStockDetails.add(internalOrderStockDetailService.updateOldData(entity));
		});
		rawEntity.setInternalOrderStockDetails(internalOrderStockDetails);

		Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs = new HashSet<>();
		rawEntity.getInventoryAdjusmentBatchs().forEach(entity -> {
			inventoryAdjusmentBatchs.add(inventoryAdjusmentBatchService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjusmentBatchs(inventoryAdjusmentBatchs);

		Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItems = new HashSet<>();
		rawEntity.getInventoryAdjustmentItems().forEach(entity -> {
			inventoryAdjustmentItems.add(inventoryAdjustmentItemService.updateOldData(entity));
		});
		rawEntity.setInventoryAdjustmentItems(inventoryAdjustmentItems);

		Set<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItems = new HashSet<>();
		rawEntity.getInventoryBatchCorrectionItems().forEach(entity -> {
			inventoryBatchCorrectionItems.add(inventoryBatchCorrectionItemService.updateOldData(entity));
		});
		rawEntity.setInventoryBatchCorrectionItems(inventoryBatchCorrectionItems);

		Set<MedicationItemEntity> medicationItems = new HashSet<>();
		rawEntity.getMedicationItems().forEach(entity -> {
			medicationItems.add(medicationItemService.updateOldData(entity));
		});
		rawEntity.setMedicationItems(medicationItems);

		Set<PrescriptionItemEntity> prescriptionItem = new HashSet<>();
		rawEntity.getPrescriptionItem().forEach(entity -> {
			prescriptionItem.add(prescriptionItemService.updateOldData(entity));
		});
		rawEntity.setPrescriptionItem(prescriptionItem);

		Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails = new HashSet<>();
		rawEntity.getPurchaseOrderStockDetails().forEach(entity -> {
			purchaseOrderStockDetails.add(purchaseOrderStockDetailService.updateOldData(entity));
		});
		rawEntity.setPurchaseOrderStockDetails(purchaseOrderStockDetails);

		Set<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetails = new HashSet<>();
		rawEntity.getPurchaseRequisitionStockDetails().forEach(entity -> {
			purchaseRequisitionStockDetails.add(purchaseRequisitionStockDetailService.updateOldData(entity));
		});
		rawEntity.setPurchaseRequisitionStockDetails(purchaseRequisitionStockDetails);

		Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetails = new HashSet<>();
		rawEntity.getRetailPharmacyStockDetails().forEach(entity -> {
			retailPharmacyStockDetails.add(retailPharmacyStockDetailService.updateOldData(entity));
		});
		rawEntity.setRetailPharmacyStockDetails(retailPharmacyStockDetails);

		Set<ReturnSupplierStockDetailEntity> returnSupplierStockDetails = new HashSet<>();
		rawEntity.getReturnSupplierStockDetails().forEach(entity -> {
			returnSupplierStockDetails.add(returnSupplierStockDetailService.updateOldData(entity));
		});
		rawEntity.setReturnSupplierStockDetails(returnSupplierStockDetails);

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

		Set<SupplierProductDetailEntity> supplierProductDetails = new HashSet<>();
		rawEntity.getSupplierProductDetails().forEach(entity -> {
			supplierProductDetails.add(supplierProductDetailService.updateOldData(entity));
		});
		rawEntity.setSupplierProductDetails(supplierProductDetails);

		Set<TransferOrderStockDetailEntity> transferOrderStockDetails = new HashSet<>();
		rawEntity.getTransferOrderStockDetails().forEach(entity -> {
			transferOrderStockDetails.add(transferOrderStockDetailService.updateOldData(entity));
		});
		rawEntity.setTransferOrderStockDetails(transferOrderStockDetails);

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

		StockCatalogueEntity entityFromDb = stockCatalogueService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		StockCatalogueEntity newEntity = stockCatalogueService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link StockCatalogueMutationResolver#updateStockCatalogue(StockCatalogueEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'update')")
	public List<StockCatalogueEntity> updateAllStockCatalogue(@NonNull List<StockCatalogueEntity> rawEntities) {
		List<StockCatalogueEntity> newEntities = Lists.newArrayList(stockCatalogueService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'delete')")
	public String deleteStockCatalogueById(@NonNull String id) {
		stockCatalogueService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link StockCatalogueMutationResolver#deleteStockCatalogueById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('StockCatalogueEntity', 'delete')")
	public List<String> deleteAllStockCatalogueByIds(@NonNull List<String> ids) {
		stockCatalogueService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('StockCatalogueEntity', 'delete')")
	public List<String> deleteStockCatalogueExcludingIds(@NonNull List<String> ids) {
		stockCatalogueService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
