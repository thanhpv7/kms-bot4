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
public class WarehouseResolver implements GraphQLResolver<WarehouseEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('BatchStockBalanceEntity', 'read')")
	public Set<BatchStockBalanceEntity> batchStockBalancesWarehouse(WarehouseEntity warehouse) {
		return warehouse.getBatchStockBalancesWarehouse();
	}

	@PreAuthorize("hasPermission('BatchStockBalancePerDateEntity', 'read')")
	public Set<BatchStockBalancePerDateEntity> batchStockBalances(WarehouseEntity warehouse) {
		return warehouse.getBatchStockBalances();
	}

	@PreAuthorize("hasPermission('BatchStockTransactionDetailEntity', 'read')")
	public Set<BatchStockTransactionDetailEntity> batchStockTransactionDetails(WarehouseEntity warehouse) {
		return warehouse.getBatchStockTransactionDetails();
	}

	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	public Set<TransferOrderEntity> destinationWarehouses(WarehouseEntity warehouse) {
		return warehouse.getDestinationWarehouses();
	}

	@PreAuthorize("hasPermission('GoodsReceiveNoteBatchEntity', 'read')")
	public Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs(WarehouseEntity warehouse) {
		return warehouse.getGoodsReceiveNoteBatchs();
	}

	@PreAuthorize("hasPermission('GoodsReceiveNoteEntity', 'read')")
	public Set<GoodsReceiveNoteEntity> goodsReceiveNotes(WarehouseEntity warehouse) {
		return warehouse.getGoodsReceiveNotes();
	}

	@PreAuthorize("hasPermission('InternalOrderEntity', 'read')")
	public Set<InternalOrderEntity> internalOrders(WarehouseEntity warehouse) {
		return warehouse.getInternalOrders();
	}

	@PreAuthorize("hasPermission('InventoryAdjusmentBatchEntity', 'read')")
	public Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs(WarehouseEntity warehouse) {
		return warehouse.getInventoryAdjusmentBatchs();
	}

	@PreAuthorize("hasPermission('InventoryAdjustmentEntity', 'read')")
	public Set<InventoryAdjustmentEntity> inventoryAdjustments(WarehouseEntity warehouse) {
		return warehouse.getInventoryAdjustments();
	}

	@PreAuthorize("hasPermission('InventoryBatchCorrectionEntity', 'read')")
	public Set<InventoryBatchCorrectionEntity> inventoryBatchCorrections(WarehouseEntity warehouse) {
		return warehouse.getInventoryBatchCorrections();
	}

	@PreAuthorize("hasPermission('LocationEntity', 'read')")
	public Set<LocationEntity> locations(WarehouseEntity warehouse) {
		return warehouse.getLocations();
	}

	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	public Set<MedicalFeeEntity> medicalFees(WarehouseEntity warehouse) {
		return warehouse.getMedicalFees();
	}

	@PreAuthorize("hasPermission('MedicationHeaderEntity', 'read')")
	public Set<MedicationHeaderEntity> medicationHeaders(WarehouseEntity warehouse) {
		return warehouse.getMedicationHeaders();
	}

	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	public Set<PrescriptionHeaderEntity> prescriptionHeaders(WarehouseEntity warehouse) {
		return warehouse.getPrescriptionHeaders();
	}

	@PreAuthorize("hasPermission('PurchaseOrderEntity', 'read')")
	public Set<PurchaseOrderEntity> purchaseOrders(WarehouseEntity warehouse) {
		return warehouse.getPurchaseOrders();
	}

	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	public Set<PurchaseRequisitionEntity> purchaseRequisitions(WarehouseEntity warehouse) {
		return warehouse.getPurchaseRequisitions();
	}

	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	public Set<RetailPharmacyEntity> retailPharmacies(WarehouseEntity warehouse) {
		return warehouse.getRetailPharmacies();
	}

	@PreAuthorize("hasPermission('ReturnSupplierEntity', 'read')")
	public Set<ReturnSupplierEntity> returnSuppliers(WarehouseEntity warehouse) {
		return warehouse.getReturnSuppliers();
	}

	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	public Set<TransferOrderEntity> sourceWarehouses(WarehouseEntity warehouse) {
		return warehouse.getSourceWarehouses();
	}

	@PreAuthorize("hasPermission('StockCatalogueEntity', 'read')")
	public Set<StockCatalogueEntity> stockCatalogues(WarehouseEntity warehouse) {
		return warehouse.getStockCatalogues();
	}

	@PreAuthorize("hasPermission('StockControlEntity', 'read')")
	public Set<StockControlEntity> stockControls(WarehouseEntity warehouse) {
		return warehouse.getStockControls();
	}

	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	public Set<StockTransactionDetailEntity> stockTransactionDetails(WarehouseEntity warehouse) {
		return warehouse.getStockTransactionDetails();
	}

	@PreAuthorize("hasPermission('StockTransactionPerDateTypeEntity', 'read')")
	public Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes(WarehouseEntity warehouse) {
		return warehouse.getStockTransactionPerDateTypes();
	}

	@PreAuthorize("hasPermission('StockTransactionPerDateEntity', 'read')")
	public Set<StockTransactionPerDateEntity> stockTransactionPerDates(WarehouseEntity warehouse) {
		return warehouse.getStockTransactionPerDates();
	}

	@PreAuthorize("hasPermission('VaccinationOrderDetailEntity', 'read')")
	public Set<VaccinationOrderDetailEntity> vaccinationOrderDetails(WarehouseEntity warehouse) {
		return warehouse.getVaccinationOrderDetails();
	}

	@PreAuthorize("hasPermission('WarehouseInitialStockEntity', 'read')")
	public Set<WarehouseInitialStockEntity> warehouseInitialStockS(WarehouseEntity warehouse) {
		return warehouse.getWarehouseInitialStockS();
	}

	@PreAuthorize("hasPermission('WarehouseInventoryEntity', 'read')")
	public Set<WarehouseInventoryEntity> warehouseInventories(WarehouseEntity warehouse) {
		return warehouse.getWarehouseInventories();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
