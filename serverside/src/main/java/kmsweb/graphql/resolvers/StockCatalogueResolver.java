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

package kmsweb.graphql.resolvers;

import kmsweb.entities.*;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Component
public class StockCatalogueResolver implements GraphQLResolver<StockCatalogueEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('BatchStockBalanceEntity', 'read')")
	public Set<BatchStockBalanceEntity> batchStockBalancesCatalogue(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getBatchStockBalancesCatalogue();
	}

	@PreAuthorize("hasPermission('BatchStockBalancePerDateEntity', 'read')")
	public Set<BatchStockBalancePerDateEntity> batchStockBalances(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getBatchStockBalances();
	}

	@PreAuthorize("hasPermission('BatchStockTransactionDetailEntity', 'read')")
	public Set<BatchStockTransactionDetailEntity> batchStockTransactionDetails(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getBatchStockTransactionDetails();
	}

	@PreAuthorize("hasPermission('CatalogueUOMEntity', 'read')")
	public Set<CatalogueUOMEntity> catalogueUOMs(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getCatalogueUOMs();
	}

	@PreAuthorize("hasPermission('CompoundPrescriptionItemEntity', 'read')")
	public Set<CompoundPrescriptionItemEntity> compoundPrescriptionItems(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getCompoundPrescriptionItems();
	}

	@PreAuthorize("hasPermission('GoodsReceiveNoteBatchEntity', 'read')")
	public Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getGoodsReceiveNoteBatchs();
	}

	@PreAuthorize("hasPermission('GoodsReceiveNoteItemEntity', 'read')")
	public Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItems(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getGoodsReceiveNoteItems();
	}

	@PreAuthorize("hasPermission('InternalOrderStockDetailEntity', 'read')")
	public Set<InternalOrderStockDetailEntity> internalOrderStockDetails(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getInternalOrderStockDetails();
	}

	@PreAuthorize("hasPermission('InventoryAdjusmentBatchEntity', 'read')")
	public Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getInventoryAdjusmentBatchs();
	}

	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	public Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItems(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getInventoryAdjustmentItems();
	}

	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	public Set<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItems(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getInventoryBatchCorrectionItems();
	}

	@PreAuthorize("hasPermission('MedicationItemEntity', 'read')")
	public Set<MedicationItemEntity> medicationItems(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getMedicationItems();
	}

	@PreAuthorize("hasPermission('PrescriptionItemEntity', 'read')")
	public Set<PrescriptionItemEntity> prescriptionItem(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getPrescriptionItem();
	}

	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	public Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getPurchaseOrderStockDetails();
	}

	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	public Set<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetails(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getPurchaseRequisitionStockDetails();
	}

	@PreAuthorize("hasPermission('RetailPharmacyStockDetailEntity', 'read')")
	public Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetails(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getRetailPharmacyStockDetails();
	}

	@PreAuthorize("hasPermission('ReturnSupplierStockDetailEntity', 'read')")
	public Set<ReturnSupplierStockDetailEntity> returnSupplierStockDetails(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getReturnSupplierStockDetails();
	}

	@PreAuthorize("hasPermission('CatalogueMedicalEntity', 'read')")
	public CatalogueMedicalEntity stockCatalogueMedical(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getStockCatalogueMedical();
	}

	@PreAuthorize("hasPermission('CatalogueNonMedicalEntity', 'read')")
	public CatalogueNonMedicalEntity stockCatalogueNonMedical(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getStockCatalogueNonMedical();
	}

	@PreAuthorize("hasPermission('StockControlEntity', 'read')")
	public Set<StockControlEntity> stockControls(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getStockControls();
	}

	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	public Set<StockTransactionDetailEntity> stockTransactionDetails(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getStockTransactionDetails();
	}

	@PreAuthorize("hasPermission('StockTransactionPerDateTypeEntity', 'read')")
	public Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getStockTransactionPerDateTypes();
	}

	@PreAuthorize("hasPermission('StockTransactionPerDateEntity', 'read')")
	public Set<StockTransactionPerDateEntity> stockTransactionPerDates(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getStockTransactionPerDates();
	}

	@PreAuthorize("hasPermission('SupplierProductDetailEntity', 'read')")
	public Set<SupplierProductDetailEntity> supplierProductDetails(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getSupplierProductDetails();
	}

	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	public Set<TransferOrderStockDetailEntity> transferOrderStockDetails(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getTransferOrderStockDetails();
	}

	@PreAuthorize("hasPermission('VaccinationOrderDetailEntity', 'read')")
	public Set<VaccinationOrderDetailEntity> vaccinationOrderDetails(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getVaccinationOrderDetails();
	}

	@PreAuthorize("hasPermission('WarehouseInitialStockEntity', 'read')")
	public Set<WarehouseInitialStockEntity> warehouseInitialStockS(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getWarehouseInitialStockS();
	}

	@PreAuthorize("hasPermission('WarehouseInventoryEntity', 'read')")
	public Set<WarehouseInventoryEntity> warehouseInventories(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getWarehouseInventories();
	}

	@PreAuthorize("hasPermission('BpjsDrugGenericPRBEntity', 'read')")
	public BpjsDrugGenericPRBEntity bpjsDrugGenericPRB(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getBpjsDrugGenericPRB();
	}

	@PreAuthorize("hasPermission('BpjsPcareDPHOEntity', 'read')")
	public BpjsPcareDPHOEntity bpjsPcareDPHO(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getBpjsPcareDPHO();
	}

	@PreAuthorize("hasPermission('WarehouseEntity', 'read')")
	public WarehouseEntity warehouse(StockCatalogueEntity stockCatalogue) {
		return stockCatalogue.getWarehouse();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
