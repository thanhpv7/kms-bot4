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
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for StockCatalogueEntity")
@EqualsAndHashCode(callSuper = false)
public class StockCatalogueEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Boolean trackable;

	private String stockCode;

	private String stockName;

	private String description;

	private Double weight;

	private String weightUnit;

	private Double volume;

	private String volumeUnit;

	private String stockGroup;

	private String stockCategory;

	private String approvalStatus;

	private String approvedBy;

	private OffsetDateTime approvalDate;

	private String approvalNotes;

	private Integer quantityPerPack;

	private String uoi;

	private String lastBuyingPriceVATExcludeCurrency;

	private Double lastBuyingPriceVATExcludePrice;

	private String lastBuyingPriceVATIncludeCurrency;

	private Double lastBuyingPriceVATIncludePrice;

	private Boolean medicalType;

	private String stockCategoryVATExcluded;

	private String stockCategoryVATIncluded;

	private Double onHandQty;

	private Double averageCost;

	private Double totalCost;

	private String salesAccount;

	private String inventoryAccount;

	private String purchaseAccount;

	private String lupSupplierName;

	private Double lupUnitPrice;

	private Double lupDiscount;

	private Double lupItemPrice;

	private OffsetDateTime lupLastPurchaseDate;

	private String lppSupplierName;

	private Double lppUnitPrice;

	private Double lppDiscount;

	private Double lppItemPrice;

	private OffsetDateTime lppLastPurchaseDate;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<BatchStockBalanceEntity> batchStockBalancesCatalogue = new HashSet<>();

	private Set<BatchStockBalancePerDateEntity> batchStockBalances = new HashSet<>();

	private Set<BatchStockTransactionDetailEntity> batchStockTransactionDetails = new HashSet<>();

	private Set<CatalogueUOMEntity> catalogueUOMs = new HashSet<>();

	private Set<CompoundPrescriptionItemEntity> compoundPrescriptionItems = new HashSet<>();

	private Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs = new HashSet<>();

	private Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItems = new HashSet<>();

	private Set<InternalOrderStockDetailEntity> internalOrderStockDetails = new HashSet<>();

	private Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs = new HashSet<>();

	private Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItems = new HashSet<>();

	private Set<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItems = new HashSet<>();

	private Set<MedicationItemEntity> medicationItems = new HashSet<>();

	private Set<PrescriptionItemEntity> prescriptionItem = new HashSet<>();

	private Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails = new HashSet<>();

	private Set<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetails = new HashSet<>();

	private Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetails = new HashSet<>();

	private Set<ReturnSupplierStockDetailEntity> returnSupplierStockDetails = new HashSet<>();

	private CatalogueMedicalEntity stockCatalogueMedical;

	private CatalogueNonMedicalEntity stockCatalogueNonMedical;

	private Set<StockControlEntity> stockControls = new HashSet<>();

	private Set<StockTransactionDetailEntity> stockTransactionDetails = new HashSet<>();

	private Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes = new HashSet<>();

	private Set<StockTransactionPerDateEntity> stockTransactionPerDates = new HashSet<>();

	private Set<SupplierProductDetailEntity> supplierProductDetails = new HashSet<>();

	private Set<TransferOrderStockDetailEntity> transferOrderStockDetails = new HashSet<>();

	private Set<VaccinationOrderDetailEntity> vaccinationOrderDetails = new HashSet<>();

	private Set<WarehouseInitialStockEntity> warehouseInitialStockS = new HashSet<>();

	private Set<WarehouseInventoryEntity> warehouseInventories = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BpjsDrugGenericPRBEntity bpjsDrugGenericPRB;

	private BpjsPcareDPHOEntity bpjsPcareDPHO;

	private WarehouseEntity warehouse;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
