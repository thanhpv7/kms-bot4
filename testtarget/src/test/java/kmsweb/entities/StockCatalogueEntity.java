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
package kmsweb.entities;

import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class StockCatalogueEntity extends AbstractEntity {

	public StockCatalogueEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BatchStockBalancesCatalogueOneMany = new EntityReference();
			BatchStockBalancesCatalogueOneMany.entityName = "BatchStockBalance";
			BatchStockBalancesCatalogueOneMany.oppositeName = "StockCatalogue";
			BatchStockBalancesCatalogueOneMany.name = "BatchStockBalancesCatalogue";
			BatchStockBalancesCatalogueOneMany.optional = true;
			BatchStockBalancesCatalogueOneMany.type = "One";
			BatchStockBalancesCatalogueOneMany.oppositeType = "Many";

		References.add(BatchStockBalancesCatalogueOneMany);

		var BatchStockBalancesOneMany = new EntityReference();
			BatchStockBalancesOneMany.entityName = "BatchStockBalancePerDate";
			BatchStockBalancesOneMany.oppositeName = "StockCatalogue";
			BatchStockBalancesOneMany.name = "BatchStockBalances";
			BatchStockBalancesOneMany.optional = true;
			BatchStockBalancesOneMany.type = "One";
			BatchStockBalancesOneMany.oppositeType = "Many";

		References.add(BatchStockBalancesOneMany);

		var BatchStockTransactionDetailsOneMany = new EntityReference();
			BatchStockTransactionDetailsOneMany.entityName = "BatchStockTransactionDetail";
			BatchStockTransactionDetailsOneMany.oppositeName = "StockCatalogue";
			BatchStockTransactionDetailsOneMany.name = "BatchStockTransactionDetails";
			BatchStockTransactionDetailsOneMany.optional = true;
			BatchStockTransactionDetailsOneMany.type = "One";
			BatchStockTransactionDetailsOneMany.oppositeType = "Many";

		References.add(BatchStockTransactionDetailsOneMany);

		var CatalogueUOMsOneMany = new EntityReference();
			CatalogueUOMsOneMany.entityName = "CatalogueUOM";
			CatalogueUOMsOneMany.oppositeName = "StockCatalogue";
			CatalogueUOMsOneMany.name = "CatalogueUOMs";
			CatalogueUOMsOneMany.optional = true;
			CatalogueUOMsOneMany.type = "One";
			CatalogueUOMsOneMany.oppositeType = "Many";

		References.add(CatalogueUOMsOneMany);

		var CompoundPrescriptionItemsOneMany = new EntityReference();
			CompoundPrescriptionItemsOneMany.entityName = "CompoundPrescriptionItem";
			CompoundPrescriptionItemsOneMany.oppositeName = "StockCatalogue";
			CompoundPrescriptionItemsOneMany.name = "CompoundPrescriptionItems";
			CompoundPrescriptionItemsOneMany.optional = true;
			CompoundPrescriptionItemsOneMany.type = "One";
			CompoundPrescriptionItemsOneMany.oppositeType = "Many";

		References.add(CompoundPrescriptionItemsOneMany);

		var GoodsReceiveNoteBatchsOneMany = new EntityReference();
			GoodsReceiveNoteBatchsOneMany.entityName = "GoodsReceiveNoteBatch";
			GoodsReceiveNoteBatchsOneMany.oppositeName = "StockCatalogue";
			GoodsReceiveNoteBatchsOneMany.name = "GoodsReceiveNoteBatchs";
			GoodsReceiveNoteBatchsOneMany.optional = true;
			GoodsReceiveNoteBatchsOneMany.type = "One";
			GoodsReceiveNoteBatchsOneMany.oppositeType = "Many";

		References.add(GoodsReceiveNoteBatchsOneMany);

		var GoodsReceiveNoteItemsOneMany = new EntityReference();
			GoodsReceiveNoteItemsOneMany.entityName = "GoodsReceiveNoteItem";
			GoodsReceiveNoteItemsOneMany.oppositeName = "StockCatalogue";
			GoodsReceiveNoteItemsOneMany.name = "GoodsReceiveNoteItems";
			GoodsReceiveNoteItemsOneMany.optional = true;
			GoodsReceiveNoteItemsOneMany.type = "One";
			GoodsReceiveNoteItemsOneMany.oppositeType = "Many";

		References.add(GoodsReceiveNoteItemsOneMany);

		var InternalOrderStockDetailsOneMany = new EntityReference();
			InternalOrderStockDetailsOneMany.entityName = "InternalOrderStockDetail";
			InternalOrderStockDetailsOneMany.oppositeName = "StockCatalogue";
			InternalOrderStockDetailsOneMany.name = "InternalOrderStockDetails";
			InternalOrderStockDetailsOneMany.optional = true;
			InternalOrderStockDetailsOneMany.type = "One";
			InternalOrderStockDetailsOneMany.oppositeType = "Many";

		References.add(InternalOrderStockDetailsOneMany);

		var InventoryAdjusmentBatchsOneMany = new EntityReference();
			InventoryAdjusmentBatchsOneMany.entityName = "InventoryAdjusmentBatch";
			InventoryAdjusmentBatchsOneMany.oppositeName = "StockCatalogue";
			InventoryAdjusmentBatchsOneMany.name = "InventoryAdjusmentBatchs";
			InventoryAdjusmentBatchsOneMany.optional = true;
			InventoryAdjusmentBatchsOneMany.type = "One";
			InventoryAdjusmentBatchsOneMany.oppositeType = "Many";

		References.add(InventoryAdjusmentBatchsOneMany);

		var InventoryAdjustmentItemsOneMany = new EntityReference();
			InventoryAdjustmentItemsOneMany.entityName = "InventoryAdjustmentItem";
			InventoryAdjustmentItemsOneMany.oppositeName = "StockCatalogue";
			InventoryAdjustmentItemsOneMany.name = "InventoryAdjustmentItems";
			InventoryAdjustmentItemsOneMany.optional = true;
			InventoryAdjustmentItemsOneMany.type = "One";
			InventoryAdjustmentItemsOneMany.oppositeType = "Many";

		References.add(InventoryAdjustmentItemsOneMany);

		var InventoryBatchCorrectionItemsOneMany = new EntityReference();
			InventoryBatchCorrectionItemsOneMany.entityName = "InventoryBatchCorrectionItem";
			InventoryBatchCorrectionItemsOneMany.oppositeName = "StockCatalogue";
			InventoryBatchCorrectionItemsOneMany.name = "InventoryBatchCorrectionItems";
			InventoryBatchCorrectionItemsOneMany.optional = true;
			InventoryBatchCorrectionItemsOneMany.type = "One";
			InventoryBatchCorrectionItemsOneMany.oppositeType = "Many";

		References.add(InventoryBatchCorrectionItemsOneMany);

		var MedicationItemsOneMany = new EntityReference();
			MedicationItemsOneMany.entityName = "MedicationItem";
			MedicationItemsOneMany.oppositeName = "StockCatalogue";
			MedicationItemsOneMany.name = "MedicationItems";
			MedicationItemsOneMany.optional = true;
			MedicationItemsOneMany.type = "One";
			MedicationItemsOneMany.oppositeType = "Many";

		References.add(MedicationItemsOneMany);

		var PrescriptionItemOneMany = new EntityReference();
			PrescriptionItemOneMany.entityName = "PrescriptionItem";
			PrescriptionItemOneMany.oppositeName = "StockCatalogueId";
			PrescriptionItemOneMany.name = "PrescriptionItem";
			PrescriptionItemOneMany.optional = true;
			PrescriptionItemOneMany.type = "One";
			PrescriptionItemOneMany.oppositeType = "Many";

		References.add(PrescriptionItemOneMany);

		var PurchaseOrderStockDetailsOneMany = new EntityReference();
			PurchaseOrderStockDetailsOneMany.entityName = "PurchaseOrderStockDetail";
			PurchaseOrderStockDetailsOneMany.oppositeName = "StockCatalogue";
			PurchaseOrderStockDetailsOneMany.name = "PurchaseOrderStockDetails";
			PurchaseOrderStockDetailsOneMany.optional = true;
			PurchaseOrderStockDetailsOneMany.type = "One";
			PurchaseOrderStockDetailsOneMany.oppositeType = "Many";

		References.add(PurchaseOrderStockDetailsOneMany);

		var PurchaseRequisitionStockDetailsOneMany = new EntityReference();
			PurchaseRequisitionStockDetailsOneMany.entityName = "PurchaseRequisitionStockDetail";
			PurchaseRequisitionStockDetailsOneMany.oppositeName = "StockCatalogue";
			PurchaseRequisitionStockDetailsOneMany.name = "PurchaseRequisitionStockDetails";
			PurchaseRequisitionStockDetailsOneMany.optional = true;
			PurchaseRequisitionStockDetailsOneMany.type = "One";
			PurchaseRequisitionStockDetailsOneMany.oppositeType = "Many";

		References.add(PurchaseRequisitionStockDetailsOneMany);

		var RetailPharmacyStockDetailsOneMany = new EntityReference();
			RetailPharmacyStockDetailsOneMany.entityName = "RetailPharmacyStockDetail";
			RetailPharmacyStockDetailsOneMany.oppositeName = "StockCatalogue";
			RetailPharmacyStockDetailsOneMany.name = "RetailPharmacyStockDetails";
			RetailPharmacyStockDetailsOneMany.optional = true;
			RetailPharmacyStockDetailsOneMany.type = "One";
			RetailPharmacyStockDetailsOneMany.oppositeType = "Many";

		References.add(RetailPharmacyStockDetailsOneMany);

		var ReturnSupplierStockDetailsOneMany = new EntityReference();
			ReturnSupplierStockDetailsOneMany.entityName = "ReturnSupplierStockDetail";
			ReturnSupplierStockDetailsOneMany.oppositeName = "StockCatalogue";
			ReturnSupplierStockDetailsOneMany.name = "ReturnSupplierStockDetails";
			ReturnSupplierStockDetailsOneMany.optional = true;
			ReturnSupplierStockDetailsOneMany.type = "One";
			ReturnSupplierStockDetailsOneMany.oppositeType = "Many";

		References.add(ReturnSupplierStockDetailsOneMany);

		var StockCatalogueMedicalOneOne = new EntityReference();
			StockCatalogueMedicalOneOne.entityName = "CatalogueMedical";
			StockCatalogueMedicalOneOne.oppositeName = "StockCatalogue";
			StockCatalogueMedicalOneOne.name = "StockCatalogueMedical";
			StockCatalogueMedicalOneOne.optional = true;
			StockCatalogueMedicalOneOne.type = "One";
			StockCatalogueMedicalOneOne.oppositeType = "One";

		References.add(StockCatalogueMedicalOneOne);

		var StockCatalogueNonMedicalOneOne = new EntityReference();
			StockCatalogueNonMedicalOneOne.entityName = "CatalogueNonMedical";
			StockCatalogueNonMedicalOneOne.oppositeName = "StockCatalogue";
			StockCatalogueNonMedicalOneOne.name = "StockCatalogueNonMedical";
			StockCatalogueNonMedicalOneOne.optional = true;
			StockCatalogueNonMedicalOneOne.type = "One";
			StockCatalogueNonMedicalOneOne.oppositeType = "One";

		References.add(StockCatalogueNonMedicalOneOne);

		var BpjsDrugGenericPRBOneOne = new EntityReference();
			BpjsDrugGenericPRBOneOne.entityName = "BpjsDrugGenericPRB";
			BpjsDrugGenericPRBOneOne.oppositeName = "BpjsDrugGenericPRB";
			BpjsDrugGenericPRBOneOne.name = "StockCatalogue";
			BpjsDrugGenericPRBOneOne.optional = true;
			BpjsDrugGenericPRBOneOne.type = "One";
			BpjsDrugGenericPRBOneOne.oppositeType = "One";

		References.add(BpjsDrugGenericPRBOneOne);

		var BpjsPcareDPHOOneOne = new EntityReference();
			BpjsPcareDPHOOneOne.entityName = "BpjsPcareDPHO";
			BpjsPcareDPHOOneOne.oppositeName = "BpjsPcareDPHO";
			BpjsPcareDPHOOneOne.name = "StockCatalogue";
			BpjsPcareDPHOOneOne.optional = true;
			BpjsPcareDPHOOneOne.type = "One";
			BpjsPcareDPHOOneOne.oppositeType = "One";

		References.add(BpjsPcareDPHOOneOne);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "StockCatalogues";
			WarehouseOneMany.optional = true;
			WarehouseOneMany.type = "One";
			WarehouseOneMany.oppositeType = "Many";

		References.add(WarehouseOneMany);

		var StockControlsOneMany = new EntityReference();
			StockControlsOneMany.entityName = "StockControl";
			StockControlsOneMany.oppositeName = "StockCatalogue";
			StockControlsOneMany.name = "StockControls";
			StockControlsOneMany.optional = true;
			StockControlsOneMany.type = "One";
			StockControlsOneMany.oppositeType = "Many";

		References.add(StockControlsOneMany);

		var StockTransactionDetailsOneMany = new EntityReference();
			StockTransactionDetailsOneMany.entityName = "StockTransactionDetail";
			StockTransactionDetailsOneMany.oppositeName = "StockCatalogue";
			StockTransactionDetailsOneMany.name = "StockTransactionDetails";
			StockTransactionDetailsOneMany.optional = true;
			StockTransactionDetailsOneMany.type = "One";
			StockTransactionDetailsOneMany.oppositeType = "Many";

		References.add(StockTransactionDetailsOneMany);

		var StockTransactionPerDateTypesOneMany = new EntityReference();
			StockTransactionPerDateTypesOneMany.entityName = "StockTransactionPerDateType";
			StockTransactionPerDateTypesOneMany.oppositeName = "StockCatalogue";
			StockTransactionPerDateTypesOneMany.name = "StockTransactionPerDateTypes";
			StockTransactionPerDateTypesOneMany.optional = true;
			StockTransactionPerDateTypesOneMany.type = "One";
			StockTransactionPerDateTypesOneMany.oppositeType = "Many";

		References.add(StockTransactionPerDateTypesOneMany);

		var StockTransactionPerDatesOneMany = new EntityReference();
			StockTransactionPerDatesOneMany.entityName = "StockTransactionPerDate";
			StockTransactionPerDatesOneMany.oppositeName = "StockCatalogue";
			StockTransactionPerDatesOneMany.name = "StockTransactionPerDates";
			StockTransactionPerDatesOneMany.optional = true;
			StockTransactionPerDatesOneMany.type = "One";
			StockTransactionPerDatesOneMany.oppositeType = "Many";

		References.add(StockTransactionPerDatesOneMany);

		var SupplierProductDetailsOneMany = new EntityReference();
			SupplierProductDetailsOneMany.entityName = "SupplierProductDetail";
			SupplierProductDetailsOneMany.oppositeName = "StockCatalogue";
			SupplierProductDetailsOneMany.name = "SupplierProductDetails";
			SupplierProductDetailsOneMany.optional = true;
			SupplierProductDetailsOneMany.type = "One";
			SupplierProductDetailsOneMany.oppositeType = "Many";

		References.add(SupplierProductDetailsOneMany);

		var TransferOrderStockDetailsOneMany = new EntityReference();
			TransferOrderStockDetailsOneMany.entityName = "TransferOrderStockDetail";
			TransferOrderStockDetailsOneMany.oppositeName = "StockCatalogue";
			TransferOrderStockDetailsOneMany.name = "TransferOrderStockDetails";
			TransferOrderStockDetailsOneMany.optional = true;
			TransferOrderStockDetailsOneMany.type = "One";
			TransferOrderStockDetailsOneMany.oppositeType = "Many";

		References.add(TransferOrderStockDetailsOneMany);

		var VaccinationOrderDetailsOneMany = new EntityReference();
			VaccinationOrderDetailsOneMany.entityName = "VaccinationOrderDetail";
			VaccinationOrderDetailsOneMany.oppositeName = "StockCatalogue";
			VaccinationOrderDetailsOneMany.name = "VaccinationOrderDetails";
			VaccinationOrderDetailsOneMany.optional = true;
			VaccinationOrderDetailsOneMany.type = "One";
			VaccinationOrderDetailsOneMany.oppositeType = "Many";

		References.add(VaccinationOrderDetailsOneMany);

		var WarehouseInitialStockSOneMany = new EntityReference();
			WarehouseInitialStockSOneMany.entityName = "WarehouseInitialStock";
			WarehouseInitialStockSOneMany.oppositeName = "StockCatalogue";
			WarehouseInitialStockSOneMany.name = "WarehouseInitialStockS";
			WarehouseInitialStockSOneMany.optional = true;
			WarehouseInitialStockSOneMany.type = "One";
			WarehouseInitialStockSOneMany.oppositeType = "Many";

		References.add(WarehouseInitialStockSOneMany);

		var WarehouseInventoriesOneMany = new EntityReference();
			WarehouseInventoriesOneMany.entityName = "WarehouseInventory";
			WarehouseInventoriesOneMany.oppositeName = "StockCatalogue";
			WarehouseInventoriesOneMany.name = "WarehouseInventories";
			WarehouseInventoriesOneMany.optional = true;
			WarehouseInventoriesOneMany.type = "One";
			WarehouseInventoriesOneMany.oppositeType = "Many";

		References.add(WarehouseInventoriesOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Trackable here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Trackable here] end
	private Boolean trackable;

	// % protected region % [Modify attribute annotation for Stock Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stock Code here] end
	private String stockCode;

	// % protected region % [Modify attribute annotation for Stock Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stock Name here] end
	private String stockName;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for Weight Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight Unit here] end
	private String weightUnit;

	// % protected region % [Modify attribute annotation for Volume here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Volume here] end
	private Double volume;

	// % protected region % [Modify attribute annotation for Volume Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Volume Unit here] end
	private String volumeUnit;

	// % protected region % [Modify attribute annotation for Stock Group here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stock Group here] end
	private String stockGroup;

	// % protected region % [Modify attribute annotation for Stock Category here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stock Category here] end
	private String stockCategory;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Approved By here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approved By here] end
	private String approvedBy;

	// % protected region % [Modify attribute annotation for Approval Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approval Date here] end
	private OffsetDateTime approvalDate;

	// % protected region % [Modify attribute annotation for Approval Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approval Notes here] end
	private String approvalNotes;

	// % protected region % [Modify attribute annotation for Quantity Per Pack here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Per Pack here] end
	private Integer quantityPerPack;

	// % protected region % [Modify attribute annotation for UOI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UOI here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Last Buying Price VAT exclude Currency here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Buying Price VAT exclude Currency here] end
	private String lastBuyingPriceVATExcludeCurrency;

	// % protected region % [Modify attribute annotation for Last Buying Price VAT exclude Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Buying Price VAT exclude Price here] end
	private Double lastBuyingPriceVATExcludePrice;

	// % protected region % [Modify attribute annotation for Last Buying Price VAT include Currency here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Buying Price VAT include Currency here] end
	private String lastBuyingPriceVATIncludeCurrency;

	// % protected region % [Modify attribute annotation for Last Buying Price VAT include Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Buying Price VAT include Price here] end
	private Double lastBuyingPriceVATIncludePrice;

	// % protected region % [Modify attribute annotation for Medical Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medical Type here] end
	private Boolean medicalType;

	// % protected region % [Modify attribute annotation for Stock Category VAT Excluded here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stock Category VAT Excluded here] end
	private String stockCategoryVATExcluded;

	// % protected region % [Modify attribute annotation for Stock Category VAT Included here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stock Category VAT Included here] end
	private String stockCategoryVATIncluded;

	// % protected region % [Modify attribute annotation for On Hand Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for On Hand Qty here] end
	private Double onHandQty;

	// % protected region % [Modify attribute annotation for Average Cost here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Average Cost here] end
	private Double averageCost;

	// % protected region % [Modify attribute annotation for Total Cost here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Cost here] end
	private Double totalCost;

	// % protected region % [Modify attribute annotation for Sales Account here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sales Account here] end
	private String salesAccount;

	// % protected region % [Modify attribute annotation for Inventory Account here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inventory Account here] end
	private String inventoryAccount;

	// % protected region % [Modify attribute annotation for Purchase Account here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Purchase Account here] end
	private String purchaseAccount;

	// % protected region % [Modify attribute annotation for Lup Supplier Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lup Supplier Name here] end
	private String lupSupplierName;

	// % protected region % [Modify attribute annotation for Lup Unit Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lup Unit Price here] end
	private Double lupUnitPrice;

	// % protected region % [Modify attribute annotation for Lup Discount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lup Discount here] end
	private Double lupDiscount;

	// % protected region % [Modify attribute annotation for Lup Item Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lup Item Price here] end
	private Double lupItemPrice;

	// % protected region % [Modify attribute annotation for Lup Last Purchase Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lup Last Purchase Date here] end
	private OffsetDateTime lupLastPurchaseDate;

	// % protected region % [Modify attribute annotation for Lpp Supplier Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lpp Supplier Name here] end
	private String lppSupplierName;

	// % protected region % [Modify attribute annotation for Lpp Unit Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lpp Unit Price here] end
	private Double lppUnitPrice;

	// % protected region % [Modify attribute annotation for Lpp Discount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lpp Discount here] end
	private Double lppDiscount;

	// % protected region % [Modify attribute annotation for Lpp Item Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lpp Item Price here] end
	private Double lppItemPrice;

	// % protected region % [Modify attribute annotation for Lpp Last Purchase Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lpp Last Purchase Date here] end
	private OffsetDateTime lppLastPurchaseDate;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private CatalogueMedicalEntity stockCatalogueMedical;

	private CatalogueNonMedicalEntity stockCatalogueNonMedical;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BpjsDrugGenericPRBEntity bpjsDrugGenericPRB;

	private BpjsPcareDPHOEntity bpjsPcareDPHO;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
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
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private WarehouseEntity warehouse;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addBatchStockBalancesCatalogue(BatchStockBalanceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalanceEntity to be added to this entity
	 */
	public void addBatchStockBalancesCatalogue(@NonNull BatchStockBalanceEntity entity) {
		addBatchStockBalancesCatalogue(entity, true);
	}

	/**
	 * Add a new BatchStockBalanceEntity to batchStockBalancesCatalogue in this entity.
	 *
	 * @param entity the given BatchStockBalanceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBatchStockBalancesCatalogue(@NonNull BatchStockBalanceEntity entity, boolean reverseAdd) {
		if (!this.batchStockBalancesCatalogue.contains(entity)) {
			batchStockBalancesCatalogue.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBatchStockBalancesCatalogue(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be added to this entity
	 */
	public void addBatchStockBalancesCatalogue(@NonNull Collection<BatchStockBalanceEntity> entities) {
		addBatchStockBalancesCatalogue(entities, true);
	}

	/**
	 * Add a new collection of BatchStockBalanceEntity to Batch Stock Balances Catalogue in this entity.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBatchStockBalancesCatalogue(@NonNull Collection<BatchStockBalanceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBatchStockBalancesCatalogue(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBatchStockBalancesCatalogue(BatchStockBalanceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalanceEntity to be set to this entity
	 */
	public void removeBatchStockBalancesCatalogue(@NonNull BatchStockBalanceEntity entity) {
		this.removeBatchStockBalancesCatalogue(entity, true);
	}

	/**
	 * Remove the given BatchStockBalanceEntity from this entity.
	 *
	 * @param entity the given BatchStockBalanceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBatchStockBalancesCatalogue(@NonNull BatchStockBalanceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.batchStockBalancesCatalogue.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBatchStockBalancesCatalogue(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be removed to this entity
	 */
	public void removeBatchStockBalancesCatalogue(@NonNull Collection<BatchStockBalanceEntity> entities) {
		this.removeBatchStockBalancesCatalogue(entities, true);
	}

	/**
	 * Remove the given collection of BatchStockBalanceEntity from  to this entity.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBatchStockBalancesCatalogue(@NonNull Collection<BatchStockBalanceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBatchStockBalancesCatalogue(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBatchStockBalancesCatalogue(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be set to this entity
	 */
	public void setBatchStockBalancesCatalogue(@NonNull Collection<BatchStockBalanceEntity> entities) {
		setBatchStockBalancesCatalogue(entities, true);
	}

	/**
	 * Replace the current entities in Batch Stock Balances Catalogue with the given ones.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBatchStockBalancesCatalogue(@NonNull Collection<BatchStockBalanceEntity> entities, boolean reverseAdd) {

		this.unsetBatchStockBalancesCatalogue();
		this.batchStockBalancesCatalogue = new HashSet<>(entities);
		if (reverseAdd) {
			this.batchStockBalancesCatalogue.forEach(batchStockBalancesCatalogueEntity -> batchStockBalancesCatalogueEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBatchStockBalancesCatalogue(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBatchStockBalancesCatalogue() {
		this.unsetBatchStockBalancesCatalogue(true);
	}

	/**
	 * Remove all the entities in Batch Stock Balances Catalogue from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBatchStockBalancesCatalogue(boolean doReverse) {
		if (doReverse) {
			this.batchStockBalancesCatalogue.forEach(batchStockBalancesCatalogueEntity -> batchStockBalancesCatalogueEntity.unsetStockCatalogue(false));
		}
		this.batchStockBalancesCatalogue.clear();
	}

/**
	 * Similar to {@link this#addBatchStockBalances(BatchStockBalancePerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity to be added to this entity
	 */
	public void addBatchStockBalances(@NonNull BatchStockBalancePerDateEntity entity) {
		addBatchStockBalances(entity, true);
	}

	/**
	 * Add a new BatchStockBalancePerDateEntity to batchStockBalances in this entity.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBatchStockBalances(@NonNull BatchStockBalancePerDateEntity entity, boolean reverseAdd) {
		if (!this.batchStockBalances.contains(entity)) {
			batchStockBalances.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBatchStockBalances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be added to this entity
	 */
	public void addBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities) {
		addBatchStockBalances(entities, true);
	}

	/**
	 * Add a new collection of BatchStockBalancePerDateEntity to Batch Stock Balances in this entity.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBatchStockBalances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBatchStockBalances(BatchStockBalancePerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity to be set to this entity
	 */
	public void removeBatchStockBalances(@NonNull BatchStockBalancePerDateEntity entity) {
		this.removeBatchStockBalances(entity, true);
	}

	/**
	 * Remove the given BatchStockBalancePerDateEntity from this entity.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBatchStockBalances(@NonNull BatchStockBalancePerDateEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.batchStockBalances.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBatchStockBalances(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be removed to this entity
	 */
	public void removeBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities) {
		this.removeBatchStockBalances(entities, true);
	}

	/**
	 * Remove the given collection of BatchStockBalancePerDateEntity from  to this entity.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBatchStockBalances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBatchStockBalances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be set to this entity
	 */
	public void setBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities) {
		setBatchStockBalances(entities, true);
	}

	/**
	 * Replace the current entities in Batch Stock Balances with the given ones.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities, boolean reverseAdd) {

		this.unsetBatchStockBalances();
		this.batchStockBalances = new HashSet<>(entities);
		if (reverseAdd) {
			this.batchStockBalances.forEach(batchStockBalancesEntity -> batchStockBalancesEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBatchStockBalances(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBatchStockBalances() {
		this.unsetBatchStockBalances(true);
	}

	/**
	 * Remove all the entities in Batch Stock Balances from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBatchStockBalances(boolean doReverse) {
		if (doReverse) {
			this.batchStockBalances.forEach(batchStockBalancesEntity -> batchStockBalancesEntity.unsetStockCatalogue(false));
		}
		this.batchStockBalances.clear();
	}

/**
	 * Similar to {@link this#addBatchStockTransactionDetails(BatchStockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity to be added to this entity
	 */
	public void addBatchStockTransactionDetails(@NonNull BatchStockTransactionDetailEntity entity) {
		addBatchStockTransactionDetails(entity, true);
	}

	/**
	 * Add a new BatchStockTransactionDetailEntity to batchStockTransactionDetails in this entity.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBatchStockTransactionDetails(@NonNull BatchStockTransactionDetailEntity entity, boolean reverseAdd) {
		if (!this.batchStockTransactionDetails.contains(entity)) {
			batchStockTransactionDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBatchStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be added to this entity
	 */
	public void addBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities) {
		addBatchStockTransactionDetails(entities, true);
	}

	/**
	 * Add a new collection of BatchStockTransactionDetailEntity to Batch Stock Transaction Details in this entity.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBatchStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBatchStockTransactionDetails(BatchStockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity to be set to this entity
	 */
	public void removeBatchStockTransactionDetails(@NonNull BatchStockTransactionDetailEntity entity) {
		this.removeBatchStockTransactionDetails(entity, true);
	}

	/**
	 * Remove the given BatchStockTransactionDetailEntity from this entity.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBatchStockTransactionDetails(@NonNull BatchStockTransactionDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.batchStockTransactionDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBatchStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be removed to this entity
	 */
	public void removeBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities) {
		this.removeBatchStockTransactionDetails(entities, true);
	}

	/**
	 * Remove the given collection of BatchStockTransactionDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBatchStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBatchStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be set to this entity
	 */
	public void setBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities) {
		setBatchStockTransactionDetails(entities, true);
	}

	/**
	 * Replace the current entities in Batch Stock Transaction Details with the given ones.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities, boolean reverseAdd) {

		this.unsetBatchStockTransactionDetails();
		this.batchStockTransactionDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.batchStockTransactionDetails.forEach(batchStockTransactionDetailsEntity -> batchStockTransactionDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBatchStockTransactionDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBatchStockTransactionDetails() {
		this.unsetBatchStockTransactionDetails(true);
	}

	/**
	 * Remove all the entities in Batch Stock Transaction Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBatchStockTransactionDetails(boolean doReverse) {
		if (doReverse) {
			this.batchStockTransactionDetails.forEach(batchStockTransactionDetailsEntity -> batchStockTransactionDetailsEntity.unsetStockCatalogue(false));
		}
		this.batchStockTransactionDetails.clear();
	}

/**
	 * Similar to {@link this#addCatalogueUOMs(CatalogueUOMEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CatalogueUOMEntity to be added to this entity
	 */
	public void addCatalogueUOMs(@NonNull CatalogueUOMEntity entity) {
		addCatalogueUOMs(entity, true);
	}

	/**
	 * Add a new CatalogueUOMEntity to catalogueUOMs in this entity.
	 *
	 * @param entity the given CatalogueUOMEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCatalogueUOMs(@NonNull CatalogueUOMEntity entity, boolean reverseAdd) {
		if (!this.catalogueUOMs.contains(entity)) {
			catalogueUOMs.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCatalogueUOMs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to be added to this entity
	 */
	public void addCatalogueUOMs(@NonNull Collection<CatalogueUOMEntity> entities) {
		addCatalogueUOMs(entities, true);
	}

	/**
	 * Add a new collection of CatalogueUOMEntity to Catalogue UOMs in this entity.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCatalogueUOMs(@NonNull Collection<CatalogueUOMEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCatalogueUOMs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCatalogueUOMs(CatalogueUOMEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CatalogueUOMEntity to be set to this entity
	 */
	public void removeCatalogueUOMs(@NonNull CatalogueUOMEntity entity) {
		this.removeCatalogueUOMs(entity, true);
	}

	/**
	 * Remove the given CatalogueUOMEntity from this entity.
	 *
	 * @param entity the given CatalogueUOMEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCatalogueUOMs(@NonNull CatalogueUOMEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.catalogueUOMs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCatalogueUOMs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to be removed to this entity
	 */
	public void removeCatalogueUOMs(@NonNull Collection<CatalogueUOMEntity> entities) {
		this.removeCatalogueUOMs(entities, true);
	}

	/**
	 * Remove the given collection of CatalogueUOMEntity from  to this entity.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCatalogueUOMs(@NonNull Collection<CatalogueUOMEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCatalogueUOMs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCatalogueUOMs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to be set to this entity
	 */
	public void setCatalogueUOMs(@NonNull Collection<CatalogueUOMEntity> entities) {
		setCatalogueUOMs(entities, true);
	}

	/**
	 * Replace the current entities in Catalogue UOMs with the given ones.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCatalogueUOMs(@NonNull Collection<CatalogueUOMEntity> entities, boolean reverseAdd) {

		this.unsetCatalogueUOMs();
		this.catalogueUOMs = new HashSet<>(entities);
		if (reverseAdd) {
			this.catalogueUOMs.forEach(catalogueUOMsEntity -> catalogueUOMsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCatalogueUOMs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCatalogueUOMs() {
		this.unsetCatalogueUOMs(true);
	}

	/**
	 * Remove all the entities in Catalogue UOMs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCatalogueUOMs(boolean doReverse) {
		if (doReverse) {
			this.catalogueUOMs.forEach(catalogueUOMsEntity -> catalogueUOMsEntity.unsetStockCatalogue(false));
		}
		this.catalogueUOMs.clear();
	}

/**
	 * Similar to {@link this#addCompoundPrescriptionItems(CompoundPrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity to be added to this entity
	 */
	public void addCompoundPrescriptionItems(@NonNull CompoundPrescriptionItemEntity entity) {
		addCompoundPrescriptionItems(entity, true);
	}

	/**
	 * Add a new CompoundPrescriptionItemEntity to compoundPrescriptionItems in this entity.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCompoundPrescriptionItems(@NonNull CompoundPrescriptionItemEntity entity, boolean reverseAdd) {
		if (!this.compoundPrescriptionItems.contains(entity)) {
			compoundPrescriptionItems.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCompoundPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be added to this entity
	 */
	public void addCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities) {
		addCompoundPrescriptionItems(entities, true);
	}

	/**
	 * Add a new collection of CompoundPrescriptionItemEntity to Compound Prescription Items in this entity.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCompoundPrescriptionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCompoundPrescriptionItems(CompoundPrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity to be set to this entity
	 */
	public void removeCompoundPrescriptionItems(@NonNull CompoundPrescriptionItemEntity entity) {
		this.removeCompoundPrescriptionItems(entity, true);
	}

	/**
	 * Remove the given CompoundPrescriptionItemEntity from this entity.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCompoundPrescriptionItems(@NonNull CompoundPrescriptionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.compoundPrescriptionItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCompoundPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be removed to this entity
	 */
	public void removeCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities) {
		this.removeCompoundPrescriptionItems(entities, true);
	}

	/**
	 * Remove the given collection of CompoundPrescriptionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCompoundPrescriptionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCompoundPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be set to this entity
	 */
	public void setCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities) {
		setCompoundPrescriptionItems(entities, true);
	}

	/**
	 * Replace the current entities in Compound Prescription Items with the given ones.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities, boolean reverseAdd) {

		this.unsetCompoundPrescriptionItems();
		this.compoundPrescriptionItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.compoundPrescriptionItems.forEach(compoundPrescriptionItemsEntity -> compoundPrescriptionItemsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCompoundPrescriptionItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCompoundPrescriptionItems() {
		this.unsetCompoundPrescriptionItems(true);
	}

	/**
	 * Remove all the entities in Compound Prescription Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCompoundPrescriptionItems(boolean doReverse) {
		if (doReverse) {
			this.compoundPrescriptionItems.forEach(compoundPrescriptionItemsEntity -> compoundPrescriptionItemsEntity.unsetStockCatalogue(false));
		}
		this.compoundPrescriptionItems.clear();
	}

/**
	 * Similar to {@link this#addGoodsReceiveNoteBatchs(GoodsReceiveNoteBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity) {
		addGoodsReceiveNoteBatchs(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteBatchEntity to goodsReceiveNoteBatchs in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNoteBatchs.contains(entity)) {
			goodsReceiveNoteBatchs.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		addGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteBatchEntity to Goods Receive Note Batchs in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNoteBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteBatchs(GoodsReceiveNoteBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be set to this entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity) {
		this.removeGoodsReceiveNoteBatchs(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteBatchEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.goodsReceiveNoteBatchs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		this.removeGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteBatchEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNoteBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		setGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Note Batchs with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNoteBatchs();
		this.goodsReceiveNoteBatchs = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNoteBatchs.forEach(goodsReceiveNoteBatchsEntity -> goodsReceiveNoteBatchsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteBatchs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNoteBatchs() {
		this.unsetGoodsReceiveNoteBatchs(true);
	}

	/**
	 * Remove all the entities in Goods Receive Note Batchs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNoteBatchs(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNoteBatchs.forEach(goodsReceiveNoteBatchsEntity -> goodsReceiveNoteBatchsEntity.unsetStockCatalogue(false));
		}
		this.goodsReceiveNoteBatchs.clear();
	}

/**
	 * Similar to {@link this#addGoodsReceiveNoteItems(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteItems(@NonNull GoodsReceiveNoteItemEntity entity) {
		addGoodsReceiveNoteItems(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteItemEntity to goodsReceiveNoteItems in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNoteItems(@NonNull GoodsReceiveNoteItemEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNoteItems.contains(entity)) {
			goodsReceiveNoteItems.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities) {
		addGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteItemEntity to Goods Receive Note Items in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNoteItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteItems(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void removeGoodsReceiveNoteItems(@NonNull GoodsReceiveNoteItemEntity entity) {
		this.removeGoodsReceiveNoteItems(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteItemEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNoteItems(@NonNull GoodsReceiveNoteItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.goodsReceiveNoteItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities) {
		this.removeGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteItemEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNoteItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities) {
		setGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Note Items with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNoteItems();
		this.goodsReceiveNoteItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNoteItems() {
		this.unsetGoodsReceiveNoteItems(true);
	}

	/**
	 * Remove all the entities in Goods Receive Note Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNoteItems(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.unsetStockCatalogue(false));
		}
		this.goodsReceiveNoteItems.clear();
	}

/**
	 * Similar to {@link this#addInternalOrderStockDetails(InternalOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be added to this entity
	 */
	public void addInternalOrderStockDetails(@NonNull InternalOrderStockDetailEntity entity) {
		addInternalOrderStockDetails(entity, true);
	}

	/**
	 * Add a new InternalOrderStockDetailEntity to internalOrderStockDetails in this entity.
	 *
	 * @param entity the given InternalOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInternalOrderStockDetails(@NonNull InternalOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.internalOrderStockDetails.contains(entity)) {
			internalOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be added to this entity
	 */
	public void addInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities) {
		addInternalOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of InternalOrderStockDetailEntity to Internal Order Stock Details in this entity.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInternalOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInternalOrderStockDetails(InternalOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be set to this entity
	 */
	public void removeInternalOrderStockDetails(@NonNull InternalOrderStockDetailEntity entity) {
		this.removeInternalOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given InternalOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInternalOrderStockDetails(@NonNull InternalOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.internalOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be removed to this entity
	 */
	public void removeInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities) {
		this.removeInternalOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of InternalOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInternalOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be set to this entity
	 */
	public void setInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities) {
		setInternalOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Internal Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetInternalOrderStockDetails();
		this.internalOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.internalOrderStockDetails.forEach(internalOrderStockDetailsEntity -> internalOrderStockDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInternalOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInternalOrderStockDetails() {
		this.unsetInternalOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Internal Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInternalOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.internalOrderStockDetails.forEach(internalOrderStockDetailsEntity -> internalOrderStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.internalOrderStockDetails.clear();
	}

/**
	 * Similar to {@link this#addInventoryAdjusmentBatchs(InventoryAdjusmentBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be added to this entity
	 */
	public void addInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity) {
		addInventoryAdjusmentBatchs(entity, true);
	}

	/**
	 * Add a new InventoryAdjusmentBatchEntity to inventoryAdjusmentBatchs in this entity.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity, boolean reverseAdd) {
		if (!this.inventoryAdjusmentBatchs.contains(entity)) {
			inventoryAdjusmentBatchs.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be added to this entity
	 */
	public void addInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities) {
		addInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Add a new collection of InventoryAdjusmentBatchEntity to Inventory Adjusment Batchs in this entity.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryAdjusmentBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryAdjusmentBatchs(InventoryAdjusmentBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be set to this entity
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity) {
		this.removeInventoryAdjusmentBatchs(entity, true);
	}

	/**
	 * Remove the given InventoryAdjusmentBatchEntity from this entity.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.inventoryAdjusmentBatchs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be removed to this entity
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities) {
		this.removeInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Remove the given collection of InventoryAdjusmentBatchEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryAdjusmentBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be set to this entity
	 */
	public void setInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities) {
		setInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Adjusment Batchs with the given ones.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {

		this.unsetInventoryAdjusmentBatchs();
		this.inventoryAdjusmentBatchs = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryAdjusmentBatchs.forEach(inventoryAdjusmentBatchsEntity -> inventoryAdjusmentBatchsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjusmentBatchs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryAdjusmentBatchs() {
		this.unsetInventoryAdjusmentBatchs(true);
	}

	/**
	 * Remove all the entities in Inventory Adjusment Batchs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryAdjusmentBatchs(boolean doReverse) {
		if (doReverse) {
			this.inventoryAdjusmentBatchs.forEach(inventoryAdjusmentBatchsEntity -> inventoryAdjusmentBatchsEntity.unsetStockCatalogue(false));
		}
		this.inventoryAdjusmentBatchs.clear();
	}

/**
	 * Similar to {@link this#addInventoryAdjustmentItems(InventoryAdjustmentItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be added to this entity
	 */
	public void addInventoryAdjustmentItems(@NonNull InventoryAdjustmentItemEntity entity) {
		addInventoryAdjustmentItems(entity, true);
	}

	/**
	 * Add a new InventoryAdjustmentItemEntity to inventoryAdjustmentItems in this entity.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryAdjustmentItems(@NonNull InventoryAdjustmentItemEntity entity, boolean reverseAdd) {
		if (!this.inventoryAdjustmentItems.contains(entity)) {
			inventoryAdjustmentItems.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be added to this entity
	 */
	public void addInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities) {
		addInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Add a new collection of InventoryAdjustmentItemEntity to Inventory Adjustment Items in this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryAdjustmentItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustmentItems(InventoryAdjustmentItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be set to this entity
	 */
	public void removeInventoryAdjustmentItems(@NonNull InventoryAdjustmentItemEntity entity) {
		this.removeInventoryAdjustmentItems(entity, true);
	}

	/**
	 * Remove the given InventoryAdjustmentItemEntity from this entity.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryAdjustmentItems(@NonNull InventoryAdjustmentItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.inventoryAdjustmentItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be removed to this entity
	 */
	public void removeInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities) {
		this.removeInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Remove the given collection of InventoryAdjustmentItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryAdjustmentItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be set to this entity
	 */
	public void setInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities) {
		setInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Adjustment Items with the given ones.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {

		this.unsetInventoryAdjustmentItems();
		this.inventoryAdjustmentItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryAdjustmentItems.forEach(inventoryAdjustmentItemsEntity -> inventoryAdjustmentItemsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjustmentItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryAdjustmentItems() {
		this.unsetInventoryAdjustmentItems(true);
	}

	/**
	 * Remove all the entities in Inventory Adjustment Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryAdjustmentItems(boolean doReverse) {
		if (doReverse) {
			this.inventoryAdjustmentItems.forEach(inventoryAdjustmentItemsEntity -> inventoryAdjustmentItemsEntity.unsetStockCatalogue(false));
		}
		this.inventoryAdjustmentItems.clear();
	}

/**
	 * Similar to {@link this#addInventoryBatchCorrectionItems(InventoryBatchCorrectionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be added to this entity
	 */
	public void addInventoryBatchCorrectionItems(@NonNull InventoryBatchCorrectionItemEntity entity) {
		addInventoryBatchCorrectionItems(entity, true);
	}

	/**
	 * Add a new InventoryBatchCorrectionItemEntity to inventoryBatchCorrectionItems in this entity.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryBatchCorrectionItems(@NonNull InventoryBatchCorrectionItemEntity entity, boolean reverseAdd) {
		if (!this.inventoryBatchCorrectionItems.contains(entity)) {
			inventoryBatchCorrectionItems.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be added to this entity
	 */
	public void addInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		addInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Add a new collection of InventoryBatchCorrectionItemEntity to Inventory Batch Correction Items in this entity.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryBatchCorrectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryBatchCorrectionItems(InventoryBatchCorrectionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be set to this entity
	 */
	public void removeInventoryBatchCorrectionItems(@NonNull InventoryBatchCorrectionItemEntity entity) {
		this.removeInventoryBatchCorrectionItems(entity, true);
	}

	/**
	 * Remove the given InventoryBatchCorrectionItemEntity from this entity.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryBatchCorrectionItems(@NonNull InventoryBatchCorrectionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.inventoryBatchCorrectionItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be removed to this entity
	 */
	public void removeInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		this.removeInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Remove the given collection of InventoryBatchCorrectionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryBatchCorrectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be set to this entity
	 */
	public void setInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		setInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Batch Correction Items with the given ones.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {

		this.unsetInventoryBatchCorrectionItems();
		this.inventoryBatchCorrectionItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryBatchCorrectionItems.forEach(inventoryBatchCorrectionItemsEntity -> inventoryBatchCorrectionItemsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryBatchCorrectionItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryBatchCorrectionItems() {
		this.unsetInventoryBatchCorrectionItems(true);
	}

	/**
	 * Remove all the entities in Inventory Batch Correction Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryBatchCorrectionItems(boolean doReverse) {
		if (doReverse) {
			this.inventoryBatchCorrectionItems.forEach(inventoryBatchCorrectionItemsEntity -> inventoryBatchCorrectionItemsEntity.unsetStockCatalogue(false));
		}
		this.inventoryBatchCorrectionItems.clear();
	}

/**
	 * Similar to {@link this#addMedicationItems(MedicationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationItemEntity to be added to this entity
	 */
	public void addMedicationItems(@NonNull MedicationItemEntity entity) {
		addMedicationItems(entity, true);
	}

	/**
	 * Add a new MedicationItemEntity to medicationItems in this entity.
	 *
	 * @param entity the given MedicationItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationItems(@NonNull MedicationItemEntity entity, boolean reverseAdd) {
		if (!this.medicationItems.contains(entity)) {
			medicationItems.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationItemEntity to be added to this entity
	 */
	public void addMedicationItems(@NonNull Collection<MedicationItemEntity> entities) {
		addMedicationItems(entities, true);
	}

	/**
	 * Add a new collection of MedicationItemEntity to Medication Items in this entity.
	 *
	 * @param entities the given collection of MedicationItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationItems(@NonNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationItems(MedicationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationItemEntity to be set to this entity
	 */
	public void removeMedicationItems(@NonNull MedicationItemEntity entity) {
		this.removeMedicationItems(entity, true);
	}

	/**
	 * Remove the given MedicationItemEntity from this entity.
	 *
	 * @param entity the given MedicationItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationItems(@NonNull MedicationItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.medicationItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationItemEntity to be removed to this entity
	 */
	public void removeMedicationItems(@NonNull Collection<MedicationItemEntity> entities) {
		this.removeMedicationItems(entities, true);
	}

	/**
	 * Remove the given collection of MedicationItemEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationItems(@NonNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationItemEntity to be set to this entity
	 */
	public void setMedicationItems(@NonNull Collection<MedicationItemEntity> entities) {
		setMedicationItems(entities, true);
	}

	/**
	 * Replace the current entities in Medication Items with the given ones.
	 *
	 * @param entities the given collection of MedicationItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationItems(@NonNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {

		this.unsetMedicationItems();
		this.medicationItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationItems.forEach(medicationItemsEntity -> medicationItemsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationItems() {
		this.unsetMedicationItems(true);
	}

	/**
	 * Remove all the entities in Medication Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationItems(boolean doReverse) {
		if (doReverse) {
			this.medicationItems.forEach(medicationItemsEntity -> medicationItemsEntity.unsetStockCatalogue(false));
		}
		this.medicationItems.clear();
	}

/**
	 * Similar to {@link this#addPrescriptionItem(PrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionItemEntity to be added to this entity
	 */
	public void addPrescriptionItem(@NonNull PrescriptionItemEntity entity) {
		addPrescriptionItem(entity, true);
	}

	/**
	 * Add a new PrescriptionItemEntity to prescriptionItem in this entity.
	 *
	 * @param entity the given PrescriptionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrescriptionItem(@NonNull PrescriptionItemEntity entity, boolean reverseAdd) {
		if (!this.prescriptionItem.contains(entity)) {
			prescriptionItem.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogueId(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrescriptionItem(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be added to this entity
	 */
	public void addPrescriptionItem(@NonNull Collection<PrescriptionItemEntity> entities) {
		addPrescriptionItem(entities, true);
	}

	/**
	 * Add a new collection of PrescriptionItemEntity to Prescription Item in this entity.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrescriptionItem(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrescriptionItem(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrescriptionItem(PrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionItemEntity to be set to this entity
	 */
	public void removePrescriptionItem(@NonNull PrescriptionItemEntity entity) {
		this.removePrescriptionItem(entity, true);
	}

	/**
	 * Remove the given PrescriptionItemEntity from this entity.
	 *
	 * @param entity the given PrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionItem(@NonNull PrescriptionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogueId(false);
		}
		this.prescriptionItem.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrescriptionItem(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be removed to this entity
	 */
	public void removePrescriptionItem(@NonNull Collection<PrescriptionItemEntity> entities) {
		this.removePrescriptionItem(entities, true);
	}

	/**
	 * Remove the given collection of PrescriptionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrescriptionItem(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrescriptionItem(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrescriptionItem(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be set to this entity
	 */
	public void setPrescriptionItem(@NonNull Collection<PrescriptionItemEntity> entities) {
		setPrescriptionItem(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Item with the given ones.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionItem(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {

		this.unsetPrescriptionItem();
		this.prescriptionItem = new HashSet<>(entities);
		if (reverseAdd) {
			this.prescriptionItem.forEach(prescriptionItemEntity -> prescriptionItemEntity.setStockCatalogueId(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrescriptionItem(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrescriptionItem() {
		this.unsetPrescriptionItem(true);
	}

	/**
	 * Remove all the entities in Prescription Item from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrescriptionItem(boolean doReverse) {
		if (doReverse) {
			this.prescriptionItem.forEach(prescriptionItemEntity -> prescriptionItemEntity.unsetStockCatalogueId(false));
		}
		this.prescriptionItem.clear();
	}

/**
	 * Similar to {@link this#addPurchaseOrderStockDetails(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be added to this entity
	 */
	public void addPurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity) {
		addPurchaseOrderStockDetails(entity, true);
	}

	/**
	 * Add a new PurchaseOrderStockDetailEntity to purchaseOrderStockDetails in this entity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.purchaseOrderStockDetails.contains(entity)) {
			purchaseOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be added to this entity
	 */
	public void addPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities) {
		addPurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of PurchaseOrderStockDetailEntity to Purchase Order Stock Details in this entity.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseOrderStockDetails(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void removePurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity) {
		this.removePurchaseOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given PurchaseOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.purchaseOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be removed to this entity
	 */
	public void removePurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities) {
		this.removePurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void setPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities) {
		setPurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseOrderStockDetails();
		this.purchaseOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseOrderStockDetails() {
		this.unsetPurchaseOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Purchase Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.purchaseOrderStockDetails.clear();
	}

/**
	 * Similar to {@link this#addPurchaseRequisitionStockDetails(PurchaseRequisitionStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be added to this entity
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull PurchaseRequisitionStockDetailEntity entity) {
		addPurchaseRequisitionStockDetails(entity, true);
	}

	/**
	 * Add a new PurchaseRequisitionStockDetailEntity to purchaseRequisitionStockDetails in this entity.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull PurchaseRequisitionStockDetailEntity entity, boolean reverseAdd) {
		if (!this.purchaseRequisitionStockDetails.contains(entity)) {
			purchaseRequisitionStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be added to this entity
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		addPurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Add a new collection of PurchaseRequisitionStockDetailEntity to Purchase Requisition Stock Details in this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseRequisitionStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitionStockDetails(PurchaseRequisitionStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be set to this entity
	 */
	public void removePurchaseRequisitionStockDetails(@NonNull PurchaseRequisitionStockDetailEntity entity) {
		this.removePurchaseRequisitionStockDetails(entity, true);
	}

	/**
	 * Remove the given PurchaseRequisitionStockDetailEntity from this entity.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseRequisitionStockDetails(@NonNull PurchaseRequisitionStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.purchaseRequisitionStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be removed to this entity
	 */
	public void removePurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		this.removePurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseRequisitionStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseRequisitionStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be set to this entity
	 */
	public void setPurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		setPurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Requisition Stock Details with the given ones.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseRequisitionStockDetails();
		this.purchaseRequisitionStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseRequisitionStockDetails.forEach(purchaseRequisitionStockDetailsEntity -> purchaseRequisitionStockDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisitionStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseRequisitionStockDetails() {
		this.unsetPurchaseRequisitionStockDetails(true);
	}

	/**
	 * Remove all the entities in Purchase Requisition Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseRequisitionStockDetails(boolean doReverse) {
		if (doReverse) {
			this.purchaseRequisitionStockDetails.forEach(purchaseRequisitionStockDetailsEntity -> purchaseRequisitionStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.purchaseRequisitionStockDetails.clear();
	}

/**
	 * Similar to {@link this#addRetailPharmacyStockDetails(RetailPharmacyStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity to be added to this entity
	 */
	public void addRetailPharmacyStockDetails(@NonNull RetailPharmacyStockDetailEntity entity) {
		addRetailPharmacyStockDetails(entity, true);
	}

	/**
	 * Add a new RetailPharmacyStockDetailEntity to retailPharmacyStockDetails in this entity.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRetailPharmacyStockDetails(@NonNull RetailPharmacyStockDetailEntity entity, boolean reverseAdd) {
		if (!this.retailPharmacyStockDetails.contains(entity)) {
			retailPharmacyStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRetailPharmacyStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be added to this entity
	 */
	public void addRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities) {
		addRetailPharmacyStockDetails(entities, true);
	}

	/**
	 * Add a new collection of RetailPharmacyStockDetailEntity to Retail Pharmacy Stock Details in this entity.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRetailPharmacyStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRetailPharmacyStockDetails(RetailPharmacyStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity to be set to this entity
	 */
	public void removeRetailPharmacyStockDetails(@NonNull RetailPharmacyStockDetailEntity entity) {
		this.removeRetailPharmacyStockDetails(entity, true);
	}

	/**
	 * Remove the given RetailPharmacyStockDetailEntity from this entity.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRetailPharmacyStockDetails(@NonNull RetailPharmacyStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.retailPharmacyStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRetailPharmacyStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be removed to this entity
	 */
	public void removeRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities) {
		this.removeRetailPharmacyStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of RetailPharmacyStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRetailPharmacyStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRetailPharmacyStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be set to this entity
	 */
	public void setRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities) {
		setRetailPharmacyStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Retail Pharmacy Stock Details with the given ones.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetRetailPharmacyStockDetails();
		this.retailPharmacyStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.retailPharmacyStockDetails.forEach(retailPharmacyStockDetailsEntity -> retailPharmacyStockDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacyStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRetailPharmacyStockDetails() {
		this.unsetRetailPharmacyStockDetails(true);
	}

	/**
	 * Remove all the entities in Retail Pharmacy Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRetailPharmacyStockDetails(boolean doReverse) {
		if (doReverse) {
			this.retailPharmacyStockDetails.forEach(retailPharmacyStockDetailsEntity -> retailPharmacyStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.retailPharmacyStockDetails.clear();
	}

/**
	 * Similar to {@link this#addReturnSupplierStockDetails(ReturnSupplierStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be added to this entity
	 */
	public void addReturnSupplierStockDetails(@NonNull ReturnSupplierStockDetailEntity entity) {
		addReturnSupplierStockDetails(entity, true);
	}

	/**
	 * Add a new ReturnSupplierStockDetailEntity to returnSupplierStockDetails in this entity.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addReturnSupplierStockDetails(@NonNull ReturnSupplierStockDetailEntity entity, boolean reverseAdd) {
		if (!this.returnSupplierStockDetails.contains(entity)) {
			returnSupplierStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be added to this entity
	 */
	public void addReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities) {
		addReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Add a new collection of ReturnSupplierStockDetailEntity to Return Supplier Stock Details in this entity.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addReturnSupplierStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeReturnSupplierStockDetails(ReturnSupplierStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be set to this entity
	 */
	public void removeReturnSupplierStockDetails(@NonNull ReturnSupplierStockDetailEntity entity) {
		this.removeReturnSupplierStockDetails(entity, true);
	}

	/**
	 * Remove the given ReturnSupplierStockDetailEntity from this entity.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReturnSupplierStockDetails(@NonNull ReturnSupplierStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.returnSupplierStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be removed to this entity
	 */
	public void removeReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities) {
		this.removeReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of ReturnSupplierStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeReturnSupplierStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be set to this entity
	 */
	public void setReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities) {
		setReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Return Supplier Stock Details with the given ones.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetReturnSupplierStockDetails();
		this.returnSupplierStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.returnSupplierStockDetails.forEach(returnSupplierStockDetailsEntity -> returnSupplierStockDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetReturnSupplierStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetReturnSupplierStockDetails() {
		this.unsetReturnSupplierStockDetails(true);
	}

	/**
	 * Remove all the entities in Return Supplier Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetReturnSupplierStockDetails(boolean doReverse) {
		if (doReverse) {
			this.returnSupplierStockDetails.forEach(returnSupplierStockDetailsEntity -> returnSupplierStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.returnSupplierStockDetails.clear();
	}

	/**
	 * Similar to {@link this#setStockCatalogueMedical(CatalogueMedicalEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogueMedical(@NonNull CatalogueMedicalEntity entity) {
		setStockCatalogueMedical(entity, true);
	}

	/**
	 * Set or update stockCatalogueMedical with the given CatalogueMedicalEntity.
	 *
	 * @param entity the StockCatalogueEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogueMedical(@NonNull CatalogueMedicalEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogueMedical here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogueMedical here] end

		if (sameAsFormer(this.stockCatalogueMedical, entity)) {
			return;
		}

		if (this.stockCatalogueMedical != null) {
			this.stockCatalogueMedical.unsetStockCatalogue();
		}

		this.stockCatalogueMedical = entity;

		if (reverseAdd) {
			this.stockCatalogueMedical.setStockCatalogue(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogueMedical outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogueMedical outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogueMedical(boolean)} but default to true.
	 */
	public void unsetStockCatalogueMedical() {
		this.unsetStockCatalogueMedical(true);
	}

	/**
	 * Remove the CatalogueMedicalEntity in Stock Catalogue Medical  from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogueMedical(boolean reverse) {
		if (reverse && this.stockCatalogueMedical != null) {
			this.stockCatalogueMedical.unsetStockCatalogue(false);
		}
		this.stockCatalogueMedical = null;
	}

	/**
	 * Similar to {@link this#setStockCatalogueNonMedical(CatalogueNonMedicalEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogueNonMedical(@NonNull CatalogueNonMedicalEntity entity) {
		setStockCatalogueNonMedical(entity, true);
	}

	/**
	 * Set or update stockCatalogueNonMedical with the given CatalogueNonMedicalEntity.
	 *
	 * @param entity the StockCatalogueEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogueNonMedical(@NonNull CatalogueNonMedicalEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogueNonMedical here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogueNonMedical here] end

		if (sameAsFormer(this.stockCatalogueNonMedical, entity)) {
			return;
		}

		if (this.stockCatalogueNonMedical != null) {
			this.stockCatalogueNonMedical.unsetStockCatalogue();
		}

		this.stockCatalogueNonMedical = entity;

		if (reverseAdd) {
			this.stockCatalogueNonMedical.setStockCatalogue(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogueNonMedical outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogueNonMedical outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogueNonMedical(boolean)} but default to true.
	 */
	public void unsetStockCatalogueNonMedical() {
		this.unsetStockCatalogueNonMedical(true);
	}

	/**
	 * Remove the CatalogueNonMedicalEntity in Stock Catalogue Non Medical from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogueNonMedical(boolean reverse) {
		if (reverse && this.stockCatalogueNonMedical != null) {
			this.stockCatalogueNonMedical.unsetStockCatalogue(false);
		}
		this.stockCatalogueNonMedical = null;
	}

/**
	 * Similar to {@link this#addStockControls(StockControlEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockControlEntity to be added to this entity
	 */
	public void addStockControls(@NonNull StockControlEntity entity) {
		addStockControls(entity, true);
	}

	/**
	 * Add a new StockControlEntity to stockControls in this entity.
	 *
	 * @param entity the given StockControlEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockControls(@NonNull StockControlEntity entity, boolean reverseAdd) {
		if (!this.stockControls.contains(entity)) {
			stockControls.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockControls(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockControlEntity to be added to this entity
	 */
	public void addStockControls(@NonNull Collection<StockControlEntity> entities) {
		addStockControls(entities, true);
	}

	/**
	 * Add a new collection of StockControlEntity to Stock Controls in this entity.
	 *
	 * @param entities the given collection of StockControlEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockControls(@NonNull Collection<StockControlEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockControls(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockControls(StockControlEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockControlEntity to be set to this entity
	 */
	public void removeStockControls(@NonNull StockControlEntity entity) {
		this.removeStockControls(entity, true);
	}

	/**
	 * Remove the given StockControlEntity from this entity.
	 *
	 * @param entity the given StockControlEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockControls(@NonNull StockControlEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.stockControls.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockControls(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockControlEntity to be removed to this entity
	 */
	public void removeStockControls(@NonNull Collection<StockControlEntity> entities) {
		this.removeStockControls(entities, true);
	}

	/**
	 * Remove the given collection of StockControlEntity from  to this entity.
	 *
	 * @param entities the given collection of StockControlEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockControls(@NonNull Collection<StockControlEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockControls(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockControls(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockControlEntity to be set to this entity
	 */
	public void setStockControls(@NonNull Collection<StockControlEntity> entities) {
		setStockControls(entities, true);
	}

	/**
	 * Replace the current entities in Stock Controls with the given ones.
	 *
	 * @param entities the given collection of StockControlEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockControls(@NonNull Collection<StockControlEntity> entities, boolean reverseAdd) {

		this.unsetStockControls();
		this.stockControls = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockControls.forEach(stockControlsEntity -> stockControlsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockControls(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockControls() {
		this.unsetStockControls(true);
	}

	/**
	 * Remove all the entities in Stock Controls from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockControls(boolean doReverse) {
		if (doReverse) {
			this.stockControls.forEach(stockControlsEntity -> stockControlsEntity.unsetStockCatalogue(false));
		}
		this.stockControls.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionDetails(StockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionDetailEntity to be added to this entity
	 */
	public void addStockTransactionDetails(@NonNull StockTransactionDetailEntity entity) {
		addStockTransactionDetails(entity, true);
	}

	/**
	 * Add a new StockTransactionDetailEntity to stockTransactionDetails in this entity.
	 *
	 * @param entity the given StockTransactionDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionDetails(@NonNull StockTransactionDetailEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionDetails.contains(entity)) {
			stockTransactionDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be added to this entity
	 */
	public void addStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities) {
		addStockTransactionDetails(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionDetailEntity to Stock Transaction Details in this entity.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionDetails(StockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionDetailEntity to be set to this entity
	 */
	public void removeStockTransactionDetails(@NonNull StockTransactionDetailEntity entity) {
		this.removeStockTransactionDetails(entity, true);
	}

	/**
	 * Remove the given StockTransactionDetailEntity from this entity.
	 *
	 * @param entity the given StockTransactionDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionDetails(@NonNull StockTransactionDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.stockTransactionDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be removed to this entity
	 */
	public void removeStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities) {
		this.removeStockTransactionDetails(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be set to this entity
	 */
	public void setStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities) {
		setStockTransactionDetails(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Details with the given ones.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionDetails();
		this.stockTransactionDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionDetails.forEach(stockTransactionDetailsEntity -> stockTransactionDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionDetails() {
		this.unsetStockTransactionDetails(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionDetails(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionDetails.forEach(stockTransactionDetailsEntity -> stockTransactionDetailsEntity.unsetStockCatalogue(false));
		}
		this.stockTransactionDetails.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionPerDateTypes(StockTransactionPerDateTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be added to this entity
	 */
	public void addStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity) {
		addStockTransactionPerDateTypes(entity, true);
	}

	/**
	 * Add a new StockTransactionPerDateTypeEntity to stockTransactionPerDateTypes in this entity.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionPerDateTypes.contains(entity)) {
			stockTransactionPerDateTypes.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be added to this entity
	 */
	public void addStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities) {
		addStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionPerDateTypeEntity to Stock Transaction Per Date Types in this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionPerDateTypes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDateTypes(StockTransactionPerDateTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be set to this entity
	 */
	public void removeStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity) {
		this.removeStockTransactionPerDateTypes(entity, true);
	}

	/**
	 * Remove the given StockTransactionPerDateTypeEntity from this entity.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.stockTransactionPerDateTypes.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be removed to this entity
	 */
	public void removeStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities) {
		this.removeStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionPerDateTypeEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionPerDateTypes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be set to this entity
	 */
	public void setStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities) {
		setStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Per Date Types with the given ones.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionPerDateTypes();
		this.stockTransactionPerDateTypes = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionPerDateTypes.forEach(stockTransactionPerDateTypesEntity -> stockTransactionPerDateTypesEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionPerDateTypes(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionPerDateTypes() {
		this.unsetStockTransactionPerDateTypes(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Per Date Types from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionPerDateTypes(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionPerDateTypes.forEach(stockTransactionPerDateTypesEntity -> stockTransactionPerDateTypesEntity.unsetStockCatalogue(false));
		}
		this.stockTransactionPerDateTypes.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionPerDates(StockTransactionPerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateEntity to be added to this entity
	 */
	public void addStockTransactionPerDates(@NonNull StockTransactionPerDateEntity entity) {
		addStockTransactionPerDates(entity, true);
	}

	/**
	 * Add a new StockTransactionPerDateEntity to stockTransactionPerDates in this entity.
	 *
	 * @param entity the given StockTransactionPerDateEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionPerDates(@NonNull StockTransactionPerDateEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionPerDates.contains(entity)) {
			stockTransactionPerDates.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionPerDates(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be added to this entity
	 */
	public void addStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities) {
		addStockTransactionPerDates(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionPerDateEntity to Stock Transaction Per Dates in this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionPerDates(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDates(StockTransactionPerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateEntity to be set to this entity
	 */
	public void removeStockTransactionPerDates(@NonNull StockTransactionPerDateEntity entity) {
		this.removeStockTransactionPerDates(entity, true);
	}

	/**
	 * Remove the given StockTransactionPerDateEntity from this entity.
	 *
	 * @param entity the given StockTransactionPerDateEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionPerDates(@NonNull StockTransactionPerDateEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.stockTransactionPerDates.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDates(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be removed to this entity
	 */
	public void removeStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities) {
		this.removeStockTransactionPerDates(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionPerDateEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionPerDates(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionPerDates(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be set to this entity
	 */
	public void setStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities) {
		setStockTransactionPerDates(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Per Dates with the given ones.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionPerDates();
		this.stockTransactionPerDates = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionPerDates.forEach(stockTransactionPerDatesEntity -> stockTransactionPerDatesEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionPerDates(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionPerDates() {
		this.unsetStockTransactionPerDates(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Per Dates from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionPerDates(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionPerDates.forEach(stockTransactionPerDatesEntity -> stockTransactionPerDatesEntity.unsetStockCatalogue(false));
		}
		this.stockTransactionPerDates.clear();
	}

/**
	 * Similar to {@link this#addSupplierProductDetails(SupplierProductDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierProductDetailEntity to be added to this entity
	 */
	public void addSupplierProductDetails(@NonNull SupplierProductDetailEntity entity) {
		addSupplierProductDetails(entity, true);
	}

	/**
	 * Add a new SupplierProductDetailEntity to supplierProductDetails in this entity.
	 *
	 * @param entity the given SupplierProductDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSupplierProductDetails(@NonNull SupplierProductDetailEntity entity, boolean reverseAdd) {
		if (!this.supplierProductDetails.contains(entity)) {
			supplierProductDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be added to this entity
	 */
	public void addSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities) {
		addSupplierProductDetails(entities, true);
	}

	/**
	 * Add a new collection of SupplierProductDetailEntity to Supplier Product Details in this entity.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSupplierProductDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSupplierProductDetails(SupplierProductDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierProductDetailEntity to be set to this entity
	 */
	public void removeSupplierProductDetails(@NonNull SupplierProductDetailEntity entity) {
		this.removeSupplierProductDetails(entity, true);
	}

	/**
	 * Remove the given SupplierProductDetailEntity from this entity.
	 *
	 * @param entity the given SupplierProductDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSupplierProductDetails(@NonNull SupplierProductDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.supplierProductDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be removed to this entity
	 */
	public void removeSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities) {
		this.removeSupplierProductDetails(entities, true);
	}

	/**
	 * Remove the given collection of SupplierProductDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSupplierProductDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be set to this entity
	 */
	public void setSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities) {
		setSupplierProductDetails(entities, true);
	}

	/**
	 * Replace the current entities in Supplier Product Details with the given ones.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {

		this.unsetSupplierProductDetails();
		this.supplierProductDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.supplierProductDetails.forEach(supplierProductDetailsEntity -> supplierProductDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSupplierProductDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSupplierProductDetails() {
		this.unsetSupplierProductDetails(true);
	}

	/**
	 * Remove all the entities in Supplier Product Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSupplierProductDetails(boolean doReverse) {
		if (doReverse) {
			this.supplierProductDetails.forEach(supplierProductDetailsEntity -> supplierProductDetailsEntity.unsetStockCatalogue(false));
		}
		this.supplierProductDetails.clear();
	}

/**
	 * Similar to {@link this#addTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity) {
		addTransferOrderStockDetails(entity, true);
	}

	/**
	 * Add a new TransferOrderStockDetailEntity to transferOrderStockDetails in this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.transferOrderStockDetails.contains(entity)) {
			transferOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities) {
		addTransferOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of TransferOrderStockDetailEntity to Transfer Order Stock Details in this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be set to this entity
	 */
	public void removeTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity) {
		this.removeTransferOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given TransferOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.transferOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 */
	public void removeTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities) {
		this.removeTransferOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of TransferOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be set to this entity
	 */
	public void setTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities) {
		setTransferOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Transfer Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetTransferOrderStockDetails();
		this.transferOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTransferOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTransferOrderStockDetails() {
		this.unsetTransferOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Transfer Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTransferOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.transferOrderStockDetails.clear();
	}

/**
	 * Similar to {@link this#addVaccinationOrderDetails(VaccinationOrderDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be added to this entity
	 */
	public void addVaccinationOrderDetails(@NonNull VaccinationOrderDetailEntity entity) {
		addVaccinationOrderDetails(entity, true);
	}

	/**
	 * Add a new VaccinationOrderDetailEntity to vaccinationOrderDetails in this entity.
	 *
	 * @param entity the given VaccinationOrderDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addVaccinationOrderDetails(@NonNull VaccinationOrderDetailEntity entity, boolean reverseAdd) {
		if (!this.vaccinationOrderDetails.contains(entity)) {
			vaccinationOrderDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be added to this entity
	 */
	public void addVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities) {
		addVaccinationOrderDetails(entities, true);
	}

	/**
	 * Add a new collection of VaccinationOrderDetailEntity to Vaccination Order Details in this entity.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addVaccinationOrderDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeVaccinationOrderDetails(VaccinationOrderDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be set to this entity
	 */
	public void removeVaccinationOrderDetails(@NonNull VaccinationOrderDetailEntity entity) {
		this.removeVaccinationOrderDetails(entity, true);
	}

	/**
	 * Remove the given VaccinationOrderDetailEntity from this entity.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeVaccinationOrderDetails(@NonNull VaccinationOrderDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.vaccinationOrderDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be removed to this entity
	 */
	public void removeVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities) {
		this.removeVaccinationOrderDetails(entities, true);
	}

	/**
	 * Remove the given collection of VaccinationOrderDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeVaccinationOrderDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be set to this entity
	 */
	public void setVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities) {
		setVaccinationOrderDetails(entities, true);
	}

	/**
	 * Replace the current entities in Vaccination Order Details with the given ones.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {

		this.unsetVaccinationOrderDetails();
		this.vaccinationOrderDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.vaccinationOrderDetails.forEach(vaccinationOrderDetailsEntity -> vaccinationOrderDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetVaccinationOrderDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetVaccinationOrderDetails() {
		this.unsetVaccinationOrderDetails(true);
	}

	/**
	 * Remove all the entities in Vaccination Order Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetVaccinationOrderDetails(boolean doReverse) {
		if (doReverse) {
			this.vaccinationOrderDetails.forEach(vaccinationOrderDetailsEntity -> vaccinationOrderDetailsEntity.unsetStockCatalogue(false));
		}
		this.vaccinationOrderDetails.clear();
	}

/**
	 * Similar to {@link this#addWarehouseInitialStockS(WarehouseInitialStockEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be added to this entity
	 */
	public void addWarehouseInitialStockS(@NonNull WarehouseInitialStockEntity entity) {
		addWarehouseInitialStockS(entity, true);
	}

	/**
	 * Add a new WarehouseInitialStockEntity to warehouseInitialStockS in this entity.
	 *
	 * @param entity the given WarehouseInitialStockEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addWarehouseInitialStockS(@NonNull WarehouseInitialStockEntity entity, boolean reverseAdd) {
		if (!this.warehouseInitialStockS.contains(entity)) {
			warehouseInitialStockS.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be added to this entity
	 */
	public void addWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities) {
		addWarehouseInitialStockS(entities, true);
	}

	/**
	 * Add a new collection of WarehouseInitialStockEntity to Warehouse Initial Stock s in this entity.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addWarehouseInitialStockS(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeWarehouseInitialStockS(WarehouseInitialStockEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be set to this entity
	 */
	public void removeWarehouseInitialStockS(@NonNull WarehouseInitialStockEntity entity) {
		this.removeWarehouseInitialStockS(entity, true);
	}

	/**
	 * Remove the given WarehouseInitialStockEntity from this entity.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeWarehouseInitialStockS(@NonNull WarehouseInitialStockEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.warehouseInitialStockS.remove(entity);
	}

	/**
	 * Similar to {@link this#removeWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be removed to this entity
	 */
	public void removeWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities) {
		this.removeWarehouseInitialStockS(entities, true);
	}

	/**
	 * Remove the given collection of WarehouseInitialStockEntity from  to this entity.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeWarehouseInitialStockS(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be set to this entity
	 */
	public void setWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities) {
		setWarehouseInitialStockS(entities, true);
	}

	/**
	 * Replace the current entities in Warehouse Initial Stock s with the given ones.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {

		this.unsetWarehouseInitialStockS();
		this.warehouseInitialStockS = new HashSet<>(entities);
		if (reverseAdd) {
			this.warehouseInitialStockS.forEach(warehouseInitialStockSEntity -> warehouseInitialStockSEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetWarehouseInitialStockS(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetWarehouseInitialStockS() {
		this.unsetWarehouseInitialStockS(true);
	}

	/**
	 * Remove all the entities in Warehouse Initial Stock s from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetWarehouseInitialStockS(boolean doReverse) {
		if (doReverse) {
			this.warehouseInitialStockS.forEach(warehouseInitialStockSEntity -> warehouseInitialStockSEntity.unsetStockCatalogue(false));
		}
		this.warehouseInitialStockS.clear();
	}

/**
	 * Similar to {@link this#addWarehouseInventories(WarehouseInventoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInventoryEntity to be added to this entity
	 */
	public void addWarehouseInventories(@NonNull WarehouseInventoryEntity entity) {
		addWarehouseInventories(entity, true);
	}

	/**
	 * Add a new WarehouseInventoryEntity to warehouseInventories in this entity.
	 *
	 * @param entity the given WarehouseInventoryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addWarehouseInventories(@NonNull WarehouseInventoryEntity entity, boolean reverseAdd) {
		if (!this.warehouseInventories.contains(entity)) {
			warehouseInventories.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be added to this entity
	 */
	public void addWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities) {
		addWarehouseInventories(entities, true);
	}

	/**
	 * Add a new collection of WarehouseInventoryEntity to Warehouse Inventories in this entity.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addWarehouseInventories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeWarehouseInventories(WarehouseInventoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInventoryEntity to be set to this entity
	 */
	public void removeWarehouseInventories(@NonNull WarehouseInventoryEntity entity) {
		this.removeWarehouseInventories(entity, true);
	}

	/**
	 * Remove the given WarehouseInventoryEntity from this entity.
	 *
	 * @param entity the given WarehouseInventoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeWarehouseInventories(@NonNull WarehouseInventoryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.warehouseInventories.remove(entity);
	}

	/**
	 * Similar to {@link this#removeWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be removed to this entity
	 */
	public void removeWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities) {
		this.removeWarehouseInventories(entities, true);
	}

	/**
	 * Remove the given collection of WarehouseInventoryEntity from  to this entity.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeWarehouseInventories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be set to this entity
	 */
	public void setWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities) {
		setWarehouseInventories(entities, true);
	}

	/**
	 * Replace the current entities in Warehouse Inventories with the given ones.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {

		this.unsetWarehouseInventories();
		this.warehouseInventories = new HashSet<>(entities);
		if (reverseAdd) {
			this.warehouseInventories.forEach(warehouseInventoriesEntity -> warehouseInventoriesEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetWarehouseInventories(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetWarehouseInventories() {
		this.unsetWarehouseInventories(true);
	}

	/**
	 * Remove all the entities in Warehouse Inventories from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetWarehouseInventories(boolean doReverse) {
		if (doReverse) {
			this.warehouseInventories.forEach(warehouseInventoriesEntity -> warehouseInventoriesEntity.unsetStockCatalogue(false));
		}
		this.warehouseInventories.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setBpjsDrugGenericPRB(BpjsDrugGenericPRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDrugGenericPRBEntity to be set to this entity
	 */
	public void setBpjsDrugGenericPRB(BpjsDrugGenericPRBEntity entity) {
		setBpjsDrugGenericPRB(entity, true);
	}

	/**
	 * Set or update the bpjsDrugGenericPRB in this entity with single BpjsDrugGenericPRBEntity.
	 *
	 * @param entity the given BpjsDrugGenericPRBEntity to be set or updated to bpjsDrugGenericPRB
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDrugGenericPRB(BpjsDrugGenericPRBEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDrugGenericPRB here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDrugGenericPRB here] end

		if (sameAsFormer(this.bpjsDrugGenericPRB, entity)) {
			return;
		}

		if (this.bpjsDrugGenericPRB != null) {
			this.bpjsDrugGenericPRB.unsetStockCatalogue(false);
		}

		this.bpjsDrugGenericPRB = entity;
		if (reverseAdd) {
			this.bpjsDrugGenericPRB.setStockCatalogue(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDrugGenericPRB incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDrugGenericPRB incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDrugGenericPRB(boolean)} but default to true.
	 */
	public void unsetBpjsDrugGenericPRB() {
		this.unsetBpjsDrugGenericPRB(true);
	}

	/**
	 * Remove the BpjsDrugGenericPRBEntity of bpjsDrugGenericPRB from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDrugGenericPRB(boolean reverse) {
		if (reverse && this.bpjsDrugGenericPRB != null) {
			this.bpjsDrugGenericPRB.unsetStockCatalogue();
		}
		this.bpjsDrugGenericPRB = null;
	}
	/**
	 * Similar to {@link this#setBpjsPcareDPHO(BpjsPcareDPHOEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPcareDPHOEntity to be set to this entity
	 */
	public void setBpjsPcareDPHO(BpjsPcareDPHOEntity entity) {
		setBpjsPcareDPHO(entity, true);
	}

	/**
	 * Set or update the bpjsPcareDPHO in this entity with single BpjsPcareDPHOEntity.
	 *
	 * @param entity the given BpjsPcareDPHOEntity to be set or updated to bpjsPcareDPHO
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsPcareDPHO(BpjsPcareDPHOEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcareDPHO here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcareDPHO here] end

		if (sameAsFormer(this.bpjsPcareDPHO, entity)) {
			return;
		}

		if (this.bpjsPcareDPHO != null) {
			this.bpjsPcareDPHO.unsetStockCatalogue(false);
		}

		this.bpjsPcareDPHO = entity;
		if (reverseAdd) {
			this.bpjsPcareDPHO.setStockCatalogue(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsPcareDPHO incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsPcareDPHO incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsPcareDPHO(boolean)} but default to true.
	 */
	public void unsetBpjsPcareDPHO() {
		this.unsetBpjsPcareDPHO(true);
	}

	/**
	 * Remove the BpjsPcareDPHOEntity of bpjsPcareDPHO from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsPcareDPHO(boolean reverse) {
		if (reverse && this.bpjsPcareDPHO != null) {
			this.bpjsPcareDPHO.unsetStockCatalogue();
		}
		this.bpjsPcareDPHO = null;
	}
	/**
	 * Similar to {@link this#setWarehouse(WarehouseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseEntity to be set to this entity
	 */
	public void setWarehouse(@NonNull WarehouseEntity entity) {
		setWarehouse(entity, true);
	}

	/**
	 * Set or update the warehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to warehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouse(@NonNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] end

		if (sameAsFormer(this.warehouse, entity)) {
			return;
		}

		if (this.warehouse != null) {
			this.warehouse.removeStockCatalogues(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addStockCatalogues(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetWarehouse(boolean)} but default to true.
	 */
	public void unsetWarehouse() {
		this.unsetWarehouse(true);
	}

	/**
	 * Remove Warehouse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetWarehouse(boolean reverse) {
		if (reverse && this.warehouse != null) {
			this.warehouse.removeStockCatalogues(this, false);
		}
		this.warehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
