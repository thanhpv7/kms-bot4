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

package kmsweb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.entities.*;
import lombok.*;
import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for WarehouseEntity")
@EqualsAndHashCode(callSuper = false)
public class WarehouseEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String warehouseNumber;

	private String warehouseName;

	private String description;

	private String address;

	private String contactPerson;

	private String phoneNumber;

	private String ext;

	private String mobilePhoneNumber;

	private String email;

	private String revenueCenter;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<BatchStockBalanceEntity> batchStockBalancesWarehouse = new HashSet<>();

	private Set<BatchStockBalancePerDateEntity> batchStockBalances = new HashSet<>();

	private Set<BatchStockTransactionDetailEntity> batchStockTransactionDetails = new HashSet<>();

	private Set<TransferOrderEntity> destinationWarehouses = new HashSet<>();

	private Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs = new HashSet<>();

	private Set<GoodsReceiveNoteEntity> goodsReceiveNotes = new HashSet<>();

	private Set<InternalOrderEntity> internalOrders = new HashSet<>();

	private Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs = new HashSet<>();

	private Set<InventoryAdjustmentEntity> inventoryAdjustments = new HashSet<>();

	private Set<InventoryBatchCorrectionEntity> inventoryBatchCorrections = new HashSet<>();

	private Set<LocationEntity> locations = new HashSet<>();

	private Set<MedicalFeeEntity> medicalFees = new HashSet<>();

	private Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();

	private Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();

	private Set<PurchaseOrderEntity> purchaseOrders = new HashSet<>();

	private Set<PurchaseRequisitionEntity> purchaseRequisitions = new HashSet<>();

	private Set<RetailPharmacyEntity> retailPharmacies = new HashSet<>();

	private Set<ReturnSupplierEntity> returnSuppliers = new HashSet<>();

	private Set<TransferOrderEntity> sourceWarehouses = new HashSet<>();

	private Set<StockCatalogueEntity> stockCatalogues = new HashSet<>();

	private Set<StockControlEntity> stockControls = new HashSet<>();

	private Set<StockTransactionDetailEntity> stockTransactionDetails = new HashSet<>();

	private Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes = new HashSet<>();

	private Set<StockTransactionPerDateEntity> stockTransactionPerDates = new HashSet<>();

	private Set<VaccinationOrderDetailEntity> vaccinationOrderDetails = new HashSet<>();

	private Set<WarehouseInitialStockEntity> warehouseInitialStockS = new HashSet<>();

	private Set<WarehouseInventoryEntity> warehouseInventories = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
