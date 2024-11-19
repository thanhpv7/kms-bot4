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
import {FormGroup, Validators} from '@angular/forms';
import {Group, AbstractModel, ModelProperty, ModelPropertyType, ModelRelation, ModelRelationType} from '../../lib/models/abstract.model';
import {BpjsDrugGenericPRBModel} from '../bpjsDrugGenericPRB/bpjs_drug_generic_prb.model';
import {BpjsPcareDPHOModel} from '../bpjsPcareDPHO/bpjs_pcare_dpho.model';
import {BatchStockBalanceModel} from '../batchStockBalance/batch_stock_balance.model';
import {BatchStockBalancePerDateModel} from '../batchStockBalancePerDate/batch_stock_balance_per_date.model';
import {BatchStockTransactionDetailModel} from '../batchStockTransactionDetail/batch_stock_transaction_detail.model';
import {CatalogueMedicalModel} from '../catalogueMedical/catalogue_medical.model';
import {CatalogueNonMedicalModel} from '../catalogueNonMedical/catalogue_non_medical.model';
import {CatalogueUOMModel} from '../catalogueUOM/catalogue_uom.model';
import {CompoundPrescriptionItemModel} from '../compoundPrescriptionItem/compound_prescription_item.model';
import {GoodsReceiveNoteBatchModel} from '../goodsReceiveNoteBatch/goods_receive_note_batch.model';
import {GoodsReceiveNoteItemModel} from '../goodsReceiveNoteItem/goods_receive_note_item.model';
import {InternalOrderStockDetailModel} from '../internalOrderStockDetail/internal_order_stock_detail.model';
import {InventoryAdjusmentBatchModel} from '../inventoryAdjusmentBatch/inventory_adjusment_batch.model';
import {InventoryAdjustmentItemModel} from '../inventoryAdjustmentItem/inventory_adjustment_item.model';
import {InventoryBatchCorrectionItemModel} from '../inventoryBatchCorrectionItem/inventory_batch_correction_item.model';
import {MedicationItemModel} from '../medicationItem/medication_item.model';
import {PrescriptionItemModel} from '../prescriptionItem/prescription_item.model';
import {PurchaseOrderStockDetailModel} from '../purchaseOrderStockDetail/purchase_order_stock_detail.model';
import {PurchaseRequisitionStockDetailModel} from '../purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model';
import {RetailPharmacyStockDetailModel} from '../retailPharmacyStockDetail/retail_pharmacy_stock_detail.model';
import {ReturnSupplierStockDetailModel} from '../returnSupplierStockDetail/return_supplier_stock_detail.model';
import {StockControlModel} from '../stockControl/stock_control.model';
import {StockTransactionDetailModel} from '../stockTransactionDetail/stock_transaction_detail.model';
import {StockTransactionPerDateModel} from '../stockTransactionPerDate/stock_transaction_per_date.model';
import {StockTransactionPerDateTypeModel} from '../stockTransactionPerDateType/stock_transaction_per_date_type.model';
import {SupplierProductDetailModel} from '../supplierProductDetail/supplier_product_detail.model';
import {TransferOrderStockDetailModel} from '../transferOrderStockDetail/transfer_order_stock_detail.model';
import {VaccinationOrderDetailModel} from '../vaccinationOrderDetail/vaccination_order_detail.model';
import {WarehouseModel} from '../warehouse/warehouse.model';
import {WarehouseInitialStockModel} from '../warehouseInitialStock/warehouse_initial_stock.model';
import {WarehouseInventoryModel} from '../warehouseInventory/warehouse_inventory.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class StockCatalogueModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'stockCode',
		'stockName',
		'stockGroup',
		'stockCategory',
		'approvalStatus',
		'medicalType',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'trackable',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'StockCatalogueModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return StockCatalogueModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Indicator whether the stock is trackable on warehouse or not, default is TRUE.
	 */
	trackable: boolean = false;

	/**
	 * Code for Stock identifier (Max Length: 50).
	 */
	stockCode: string;

	/**
	 * Name of stock (Max: 250).
	 */
	stockName: string;

	/**
	 * Detail information about stock (Max Length: 500).
	 */
	description: string;

	/**
	 * Weight with 2 decimal digits, default set to 0.
	 */
	weight: number;

	/**
	 * Weight Unit, get the Unit Name from Unit Of Measuement entity where Unit Category is Weight.
	 */
	weightUnit: string;

	/**
	 * Volume with 2 decimal digits, default set to 0.
	 */
	volume: number;

	/**
	 * Volume Unit, get the Unit Name from Unit Of Measuement entity where Unit Category is Volume.
	 */
	volumeUnit: string;

	/**
	 * Stock Group, get the Code from Reference Data where Type=STK_GRP. (Max Length: 20).
	 */
	stockGroup: string;

	/**
	 * Stock Category, get the Code from Reference Data where Type=STK_CTGRY. (Max Length: 20).
	 */
	stockCategory: string;

	/**
	 * Approval Status, get the Code from Reference Data where Type=APPROVAL_STATUS. (Max Length: 20).
	 */
	approvalStatus: string;

	/**
	 * Approved By, it's filled by user name login on Approved status. It refers to Staff entity.
	 */
	approvedBy: string;

	/**
	 * Date on approval status change.
	 */
	approvalDate: Date;

	/**
	 * Approval Notes (Max Length: 500).
	 */
	approvalNotes: string;

	/**
	 * Quantity Per Pack.
	 */
	quantityPerPack: number;

	/**
	 * Unit Of Issuance (UOI), get the Unit Name from Unit Of Measuement entity (display all active data).
	 */
	uoi: string;

	/**
	 * Last Buying Price VAT exclude currency, get the Currency Name from Currency entity. It's set default to default currency.
	 */
	lastBuyingPriceVATExcludeCurrency: string;

	/**
	 * Last Buying Price VAT exclude Price, with 2 decimal digits.
	 */
	lastBuyingPriceVATExcludePrice: number;

	/**
	 * Last Buying Price VAT include currency, get the Currency Name from Currency entity. It's set default to default Currency.
	 */
	lastBuyingPriceVATIncludeCurrency: string;

	/**
	 * Last Buying Price VAT include Price, with 2 decimal digits.
	 */
	lastBuyingPriceVATIncludePrice: number;

	/**
	 * If Medical Type is TRUE, then detail data is maintaine to Catalogue Medical. If FALSE, it's maintained to Catalogue Non Medical.
	 */
	medicalType: boolean = false;

	/**
	 * Stock Category VAT Excluded.
	 */
	stockCategoryVATExcluded: string;

	/**
	 * Stock Category VAT Included.
	 */
	stockCategoryVATIncluded: string;

	/**
	 * .
	 */
	onHandQty: number;

	/**
	 * .
	 */
	averageCost: number;

	/**
	 * .
	 */
	totalCost: number;

	/**
	 * .
	 */
	salesAccount: string;

	/**
	 * .
	 */
	inventoryAccount: string;

	/**
	 * .
	 */
	purchaseAccount: string;

	/**
	 * Lup Supplier Name.
	 */
	lupSupplierName: string;

	/**
	 * Lup Unit Price.
	 */
	lupUnitPrice: number;

	/**
	 * Lup Discount.
	 */
	lupDiscount: number;

	/**
	 * Lup Item Price.
	 */
	lupItemPrice: number;

	/**
	 * Lup Last Purchase Date.
	 */
	lupLastPurchaseDate: Date;

	/**
	 * Lpp Supplier Name.
	 */
	lppSupplierName: string;

	/**
	 * Lpp Unit Price.
	 */
	lppUnitPrice: number;

	/**
	 * Lpp Discount.
	 */
	lppDiscount: number;

	/**
	 * Lpp Item Price.
	 */
	lppItemPrice: number;

	/**
	 * Lpp Last Purchase Date.
	 */
	lppLastPurchaseDate: Date;

	stockCatalogueMedicalId: string;

	stockCatalogueMedical: CatalogueMedicalModel;

	stockCatalogueNonMedicalId: string;

	stockCatalogueNonMedical: CatalogueNonMedicalModel;

	bpjsDrugGenericPRBId: string;

	bpjsDrugGenericPRB: BpjsDrugGenericPRBModel;

	bpjsPcareDPHOId: string;

	bpjsPcareDPHO: BpjsPcareDPHOModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	batchStockBalancesCatalogueIds: string[] = [];

	batchStockBalancesCatalogue: BatchStockBalanceModel[];

	batchStockBalancesIds: string[] = [];

	batchStockBalances: BatchStockBalancePerDateModel[];

	batchStockTransactionDetailsIds: string[] = [];

	batchStockTransactionDetails: BatchStockTransactionDetailModel[];

	catalogueUOMsIds: string[] = [];

	catalogueUOMs: CatalogueUOMModel[];

	compoundPrescriptionItemsIds: string[] = [];

	compoundPrescriptionItems: CompoundPrescriptionItemModel[];

	goodsReceiveNoteBatchsIds: string[] = [];

	goodsReceiveNoteBatchs: GoodsReceiveNoteBatchModel[];

	goodsReceiveNoteItemsIds: string[] = [];

	goodsReceiveNoteItems: GoodsReceiveNoteItemModel[];

	internalOrderStockDetailsIds: string[] = [];

	internalOrderStockDetails: InternalOrderStockDetailModel[];

	inventoryAdjusmentBatchsIds: string[] = [];

	inventoryAdjusmentBatchs: InventoryAdjusmentBatchModel[];

	inventoryAdjustmentItemsIds: string[] = [];

	inventoryAdjustmentItems: InventoryAdjustmentItemModel[];

	inventoryBatchCorrectionItemsIds: string[] = [];

	inventoryBatchCorrectionItems: InventoryBatchCorrectionItemModel[];

	medicationItemsIds: string[] = [];

	medicationItems: MedicationItemModel[];

	prescriptionItemIds: string[] = [];

	prescriptionItem: PrescriptionItemModel[];

	purchaseOrderStockDetailsIds: string[] = [];

	purchaseOrderStockDetails: PurchaseOrderStockDetailModel[];

	purchaseRequisitionStockDetailsIds: string[] = [];

	purchaseRequisitionStockDetails: PurchaseRequisitionStockDetailModel[];

	retailPharmacyStockDetailsIds: string[] = [];

	retailPharmacyStockDetails: RetailPharmacyStockDetailModel[];

	returnSupplierStockDetailsIds: string[] = [];

	returnSupplierStockDetails: ReturnSupplierStockDetailModel[];

	stockControlsIds: string[] = [];

	stockControls: StockControlModel[];

	stockTransactionDetailsIds: string[] = [];

	stockTransactionDetails: StockTransactionDetailModel[];

	stockTransactionPerDateTypesIds: string[] = [];

	stockTransactionPerDateTypes: StockTransactionPerDateTypeModel[];

	stockTransactionPerDatesIds: string[] = [];

	stockTransactionPerDates: StockTransactionPerDateModel[];

	supplierProductDetailsIds: string[] = [];

	supplierProductDetails: SupplierProductDetailModel[];

	transferOrderStockDetailsIds: string[] = [];

	transferOrderStockDetails: TransferOrderStockDetailModel[];

	vaccinationOrderDetailsIds: string[] = [];

	vaccinationOrderDetails: VaccinationOrderDetailModel[];

	warehouseInitialStockSIds: string[] = [];

	warehouseInitialStockS: WarehouseInitialStockModel[];

	warehouseInventoriesIds: string[] = [];

	warehouseInventories: WarehouseInventoryModel[];

	modelPropGroups: { [s: string]: Group } = StockCatalogueModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'trackable',
				// % protected region % [Set displayName for Trackable here] off begin
				displayName: 'Trackable',
				// % protected region % [Set displayName for Trackable here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Trackable here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Trackable here] end
				// % protected region % [Set isSensitive for Trackable here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Trackable here] end
				// % protected region % [Set readonly for Trackable here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Trackable here] end
				validators: [
					// % protected region % [Add other validators for Trackable here] off begin
					// % protected region % [Add other validators for Trackable here] end
				],
				// % protected region % [Add any additional model attribute properties for Trackable here] off begin
				// % protected region % [Add any additional model attribute properties for Trackable here] end
			},
			{
				name: 'stockCode',
				// % protected region % [Set displayName for Stock Code here] off begin
				displayName: 'Stock Code',
				// % protected region % [Set displayName for Stock Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Stock Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Stock Code here] end
				// % protected region % [Set isSensitive for Stock Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stock Code here] end
				// % protected region % [Set readonly for Stock Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stock Code here] end
				validators: [
					// % protected region % [Add other validators for Stock Code here] off begin
					// % protected region % [Add other validators for Stock Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Stock Code here] off begin
				// % protected region % [Add any additional model attribute properties for Stock Code here] end
			},
			{
				name: 'stockName',
				// % protected region % [Set displayName for Stock Name here] off begin
				displayName: 'Stock Name',
				// % protected region % [Set displayName for Stock Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Stock Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Stock Name here] end
				// % protected region % [Set isSensitive for Stock Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stock Name here] end
				// % protected region % [Set readonly for Stock Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stock Name here] end
				validators: [
					// % protected region % [Add other validators for Stock Name here] off begin
					// % protected region % [Add other validators for Stock Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Stock Name here] off begin
				// % protected region % [Add any additional model attribute properties for Stock Name here] end
			},
			{
				name: 'description',
				// % protected region % [Set displayName for Description here] off begin
				displayName: 'Description',
				// % protected region % [Set displayName for Description here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Description here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Description here] end
				// % protected region % [Set isSensitive for Description here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Description here] end
				// % protected region % [Set readonly for Description here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Description here] end
				validators: [
					// % protected region % [Add other validators for Description here] off begin
					// % protected region % [Add other validators for Description here] end
				],
				// % protected region % [Add any additional model attribute properties for Description here] off begin
				// % protected region % [Add any additional model attribute properties for Description here] end
			},
			{
				name: 'weight',
				// % protected region % [Set displayName for Weight here] off begin
				displayName: 'Weight',
				// % protected region % [Set displayName for Weight here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Weight here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Weight here] end
				// % protected region % [Set isSensitive for Weight here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight here] end
				// % protected region % [Set readonly for Weight here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight here] end
				validators: [
					// % protected region % [Add other validators for Weight here] off begin
					// % protected region % [Add other validators for Weight here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight here] off begin
				// % protected region % [Add any additional model attribute properties for Weight here] end
			},
			{
				name: 'weightUnit',
				// % protected region % [Set displayName for Weight Unit here] off begin
				displayName: 'Weight Unit',
				// % protected region % [Set displayName for Weight Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Weight Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Weight Unit here] end
				// % protected region % [Set isSensitive for Weight Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight Unit here] end
				// % protected region % [Set readonly for Weight Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight Unit here] end
				validators: [
					// % protected region % [Add other validators for Weight Unit here] off begin
					// % protected region % [Add other validators for Weight Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Weight Unit here] end
			},
			{
				name: 'volume',
				// % protected region % [Set displayName for Volume here] off begin
				displayName: 'Volume',
				// % protected region % [Set displayName for Volume here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Volume here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Volume here] end
				// % protected region % [Set isSensitive for Volume here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Volume here] end
				// % protected region % [Set readonly for Volume here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Volume here] end
				validators: [
					// % protected region % [Add other validators for Volume here] off begin
					// % protected region % [Add other validators for Volume here] end
				],
				// % protected region % [Add any additional model attribute properties for Volume here] off begin
				// % protected region % [Add any additional model attribute properties for Volume here] end
			},
			{
				name: 'volumeUnit',
				// % protected region % [Set displayName for Volume Unit here] off begin
				displayName: 'Volume Unit',
				// % protected region % [Set displayName for Volume Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Volume Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Volume Unit here] end
				// % protected region % [Set isSensitive for Volume Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Volume Unit here] end
				// % protected region % [Set readonly for Volume Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Volume Unit here] end
				validators: [
					// % protected region % [Add other validators for Volume Unit here] off begin
					// % protected region % [Add other validators for Volume Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Volume Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Volume Unit here] end
			},
			{
				name: 'stockGroup',
				// % protected region % [Set displayName for Stock Group here] off begin
				displayName: 'Stock Group',
				// % protected region % [Set displayName for Stock Group here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Stock Group here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Stock Group here] end
				// % protected region % [Set isSensitive for Stock Group here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stock Group here] end
				// % protected region % [Set readonly for Stock Group here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stock Group here] end
				validators: [
					// % protected region % [Add other validators for Stock Group here] off begin
					// % protected region % [Add other validators for Stock Group here] end
				],
				// % protected region % [Add any additional model attribute properties for Stock Group here] off begin
				// % protected region % [Add any additional model attribute properties for Stock Group here] end
			},
			{
				name: 'stockCategory',
				// % protected region % [Set displayName for Stock Category here] off begin
				displayName: 'Stock Category',
				// % protected region % [Set displayName for Stock Category here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Stock Category here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Stock Category here] end
				// % protected region % [Set isSensitive for Stock Category here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stock Category here] end
				// % protected region % [Set readonly for Stock Category here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stock Category here] end
				validators: [
					// % protected region % [Add other validators for Stock Category here] off begin
					// % protected region % [Add other validators for Stock Category here] end
				],
				// % protected region % [Add any additional model attribute properties for Stock Category here] off begin
				// % protected region % [Add any additional model attribute properties for Stock Category here] end
			},
			{
				name: 'approvalStatus',
				// % protected region % [Set displayName for Approval Status here] off begin
				displayName: 'Approval Status',
				// % protected region % [Set displayName for Approval Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Approval Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Approval Status here] end
				// % protected region % [Set isSensitive for Approval Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approval Status here] end
				// % protected region % [Set readonly for Approval Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approval Status here] end
				validators: [
					// % protected region % [Add other validators for Approval Status here] off begin
					// % protected region % [Add other validators for Approval Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Approval Status here] off begin
				// % protected region % [Add any additional model attribute properties for Approval Status here] end
			},
			{
				name: 'approvedBy',
				// % protected region % [Set displayName for Approved By here] off begin
				displayName: 'Approved By',
				// % protected region % [Set displayName for Approved By here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Approved By here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Approved By here] end
				// % protected region % [Set isSensitive for Approved By here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approved By here] end
				// % protected region % [Set readonly for Approved By here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approved By here] end
				validators: [
					// % protected region % [Add other validators for Approved By here] off begin
					// % protected region % [Add other validators for Approved By here] end
				],
				// % protected region % [Add any additional model attribute properties for Approved By here] off begin
				// % protected region % [Add any additional model attribute properties for Approved By here] end
			},
			{
				name: 'approvalDate',
				// % protected region % [Set displayName for Approval Date here] off begin
				displayName: 'Approval Date',
				// % protected region % [Set displayName for Approval Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Approval Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Approval Date here] end
				// % protected region % [Set isSensitive for Approval Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approval Date here] end
				// % protected region % [Set readonly for Approval Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approval Date here] end
				validators: [
					// % protected region % [Add other validators for Approval Date here] off begin
					// % protected region % [Add other validators for Approval Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Approval Date here] off begin
				// % protected region % [Add any additional model attribute properties for Approval Date here] end
			},
			{
				name: 'approvalNotes',
				// % protected region % [Set displayName for Approval Notes here] off begin
				displayName: 'Approval Notes',
				// % protected region % [Set displayName for Approval Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Approval Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Approval Notes here] end
				// % protected region % [Set isSensitive for Approval Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approval Notes here] end
				// % protected region % [Set readonly for Approval Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approval Notes here] end
				validators: [
					// % protected region % [Add other validators for Approval Notes here] off begin
					// % protected region % [Add other validators for Approval Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Approval Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Approval Notes here] end
			},
			{
				name: 'quantityPerPack',
				// % protected region % [Set displayName for Quantity Per Pack here] off begin
				displayName: 'Quantity Per Pack',
				// % protected region % [Set displayName for Quantity Per Pack here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Quantity Per Pack here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Quantity Per Pack here] end
				// % protected region % [Set isSensitive for Quantity Per Pack here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Quantity Per Pack here] end
				// % protected region % [Set readonly for Quantity Per Pack here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Quantity Per Pack here] end
				validators: [
					// % protected region % [Add other validators for Quantity Per Pack here] off begin
					// % protected region % [Add other validators for Quantity Per Pack here] end
				],
				// % protected region % [Add any additional model attribute properties for Quantity Per Pack here] off begin
				// % protected region % [Add any additional model attribute properties for Quantity Per Pack here] end
			},
			{
				name: 'uoi',
				// % protected region % [Set displayName for UOI here] off begin
				displayName: 'UOI',
				// % protected region % [Set displayName for UOI here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for UOI here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for UOI here] end
				// % protected region % [Set isSensitive for UOI here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for UOI here] end
				// % protected region % [Set readonly for UOI here] off begin
				readOnly: false,
				// % protected region % [Set readonly for UOI here] end
				validators: [
					// % protected region % [Add other validators for UOI here] off begin
					// % protected region % [Add other validators for UOI here] end
				],
				// % protected region % [Add any additional model attribute properties for UOI here] off begin
				// % protected region % [Add any additional model attribute properties for UOI here] end
			},
			{
				name: 'lastBuyingPriceVATExcludeCurrency',
				// % protected region % [Set displayName for Last Buying Price VAT exclude Currency here] off begin
				displayName: 'Last Buying Price VAT exclude Currency',
				// % protected region % [Set displayName for Last Buying Price VAT exclude Currency here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Last Buying Price VAT exclude Currency here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Last Buying Price VAT exclude Currency here] end
				// % protected region % [Set isSensitive for Last Buying Price VAT exclude Currency here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Last Buying Price VAT exclude Currency here] end
				// % protected region % [Set readonly for Last Buying Price VAT exclude Currency here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Last Buying Price VAT exclude Currency here] end
				validators: [
					// % protected region % [Add other validators for Last Buying Price VAT exclude Currency here] off begin
					// % protected region % [Add other validators for Last Buying Price VAT exclude Currency here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Buying Price VAT exclude Currency here] off begin
				// % protected region % [Add any additional model attribute properties for Last Buying Price VAT exclude Currency here] end
			},
			{
				name: 'lastBuyingPriceVATExcludePrice',
				// % protected region % [Set displayName for Last Buying Price VAT exclude Price here] off begin
				displayName: 'Last Buying Price VAT exclude Price',
				// % protected region % [Set displayName for Last Buying Price VAT exclude Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Last Buying Price VAT exclude Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Last Buying Price VAT exclude Price here] end
				// % protected region % [Set isSensitive for Last Buying Price VAT exclude Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Last Buying Price VAT exclude Price here] end
				// % protected region % [Set readonly for Last Buying Price VAT exclude Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Last Buying Price VAT exclude Price here] end
				validators: [
					// % protected region % [Add other validators for Last Buying Price VAT exclude Price here] off begin
					// % protected region % [Add other validators for Last Buying Price VAT exclude Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Buying Price VAT exclude Price here] off begin
				// % protected region % [Add any additional model attribute properties for Last Buying Price VAT exclude Price here] end
			},
			{
				name: 'lastBuyingPriceVATIncludeCurrency',
				// % protected region % [Set displayName for Last Buying Price VAT include Currency here] off begin
				displayName: 'Last Buying Price VAT include Currency',
				// % protected region % [Set displayName for Last Buying Price VAT include Currency here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Last Buying Price VAT include Currency here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Last Buying Price VAT include Currency here] end
				// % protected region % [Set isSensitive for Last Buying Price VAT include Currency here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Last Buying Price VAT include Currency here] end
				// % protected region % [Set readonly for Last Buying Price VAT include Currency here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Last Buying Price VAT include Currency here] end
				validators: [
					// % protected region % [Add other validators for Last Buying Price VAT include Currency here] off begin
					// % protected region % [Add other validators for Last Buying Price VAT include Currency here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Buying Price VAT include Currency here] off begin
				// % protected region % [Add any additional model attribute properties for Last Buying Price VAT include Currency here] end
			},
			{
				name: 'lastBuyingPriceVATIncludePrice',
				// % protected region % [Set displayName for Last Buying Price VAT include Price here] off begin
				displayName: 'Last Buying Price VAT include Price',
				// % protected region % [Set displayName for Last Buying Price VAT include Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Last Buying Price VAT include Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Last Buying Price VAT include Price here] end
				// % protected region % [Set isSensitive for Last Buying Price VAT include Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Last Buying Price VAT include Price here] end
				// % protected region % [Set readonly for Last Buying Price VAT include Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Last Buying Price VAT include Price here] end
				validators: [
					// % protected region % [Add other validators for Last Buying Price VAT include Price here] off begin
					// % protected region % [Add other validators for Last Buying Price VAT include Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Buying Price VAT include Price here] off begin
				// % protected region % [Add any additional model attribute properties for Last Buying Price VAT include Price here] end
			},
			{
				name: 'medicalType',
				// % protected region % [Set displayName for Medical Type here] off begin
				displayName: 'Medical Type',
				// % protected region % [Set displayName for Medical Type here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Medical Type here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Medical Type here] end
				// % protected region % [Set isSensitive for Medical Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medical Type here] end
				// % protected region % [Set readonly for Medical Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medical Type here] end
				validators: [
					// % protected region % [Add other validators for Medical Type here] off begin
					// % protected region % [Add other validators for Medical Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Medical Type here] off begin
				// % protected region % [Add any additional model attribute properties for Medical Type here] end
			},
			{
				name: 'stockCategoryVATExcluded',
				// % protected region % [Set displayName for Stock Category VAT Excluded here] off begin
				displayName: 'Stock Category VAT Excluded',
				// % protected region % [Set displayName for Stock Category VAT Excluded here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Stock Category VAT Excluded here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Stock Category VAT Excluded here] end
				// % protected region % [Set isSensitive for Stock Category VAT Excluded here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stock Category VAT Excluded here] end
				// % protected region % [Set readonly for Stock Category VAT Excluded here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stock Category VAT Excluded here] end
				validators: [
					// % protected region % [Add other validators for Stock Category VAT Excluded here] off begin
					// % protected region % [Add other validators for Stock Category VAT Excluded here] end
				],
				// % protected region % [Add any additional model attribute properties for Stock Category VAT Excluded here] off begin
				// % protected region % [Add any additional model attribute properties for Stock Category VAT Excluded here] end
			},
			{
				name: 'stockCategoryVATIncluded',
				// % protected region % [Set displayName for Stock Category VAT Included here] off begin
				displayName: 'Stock Category VAT Included',
				// % protected region % [Set displayName for Stock Category VAT Included here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Stock Category VAT Included here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Stock Category VAT Included here] end
				// % protected region % [Set isSensitive for Stock Category VAT Included here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Stock Category VAT Included here] end
				// % protected region % [Set readonly for Stock Category VAT Included here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Stock Category VAT Included here] end
				validators: [
					// % protected region % [Add other validators for Stock Category VAT Included here] off begin
					// % protected region % [Add other validators for Stock Category VAT Included here] end
				],
				// % protected region % [Add any additional model attribute properties for Stock Category VAT Included here] off begin
				// % protected region % [Add any additional model attribute properties for Stock Category VAT Included here] end
			},
			{
				name: 'onHandQty',
				// % protected region % [Set displayName for On Hand Qty here] off begin
				displayName: 'On Hand Qty',
				// % protected region % [Set displayName for On Hand Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for On Hand Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for On Hand Qty here] end
				// % protected region % [Set isSensitive for On Hand Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for On Hand Qty here] end
				// % protected region % [Set readonly for On Hand Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for On Hand Qty here] end
				validators: [
					// % protected region % [Add other validators for On Hand Qty here] off begin
					// % protected region % [Add other validators for On Hand Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for On Hand Qty here] off begin
				// % protected region % [Add any additional model attribute properties for On Hand Qty here] end
			},
			{
				name: 'averageCost',
				// % protected region % [Set displayName for Average Cost here] off begin
				displayName: 'Average Cost',
				// % protected region % [Set displayName for Average Cost here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Average Cost here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Average Cost here] end
				// % protected region % [Set isSensitive for Average Cost here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Average Cost here] end
				// % protected region % [Set readonly for Average Cost here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Average Cost here] end
				validators: [
					// % protected region % [Add other validators for Average Cost here] off begin
					// % protected region % [Add other validators for Average Cost here] end
				],
				// % protected region % [Add any additional model attribute properties for Average Cost here] off begin
				// % protected region % [Add any additional model attribute properties for Average Cost here] end
			},
			{
				name: 'totalCost',
				// % protected region % [Set displayName for Total Cost here] off begin
				displayName: 'Total Cost',
				// % protected region % [Set displayName for Total Cost here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Cost here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Cost here] end
				// % protected region % [Set isSensitive for Total Cost here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Cost here] end
				// % protected region % [Set readonly for Total Cost here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Cost here] end
				validators: [
					// % protected region % [Add other validators for Total Cost here] off begin
					// % protected region % [Add other validators for Total Cost here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Cost here] off begin
				// % protected region % [Add any additional model attribute properties for Total Cost here] end
			},
			{
				name: 'salesAccount',
				// % protected region % [Set displayName for Sales Account here] off begin
				displayName: 'Sales Account',
				// % protected region % [Set displayName for Sales Account here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sales Account here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sales Account here] end
				// % protected region % [Set isSensitive for Sales Account here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sales Account here] end
				// % protected region % [Set readonly for Sales Account here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sales Account here] end
				validators: [
					// % protected region % [Add other validators for Sales Account here] off begin
					// % protected region % [Add other validators for Sales Account here] end
				],
				// % protected region % [Add any additional model attribute properties for Sales Account here] off begin
				// % protected region % [Add any additional model attribute properties for Sales Account here] end
			},
			{
				name: 'inventoryAccount',
				// % protected region % [Set displayName for Inventory Account here] off begin
				displayName: 'Inventory Account',
				// % protected region % [Set displayName for Inventory Account here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Inventory Account here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Inventory Account here] end
				// % protected region % [Set isSensitive for Inventory Account here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inventory Account here] end
				// % protected region % [Set readonly for Inventory Account here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inventory Account here] end
				validators: [
					// % protected region % [Add other validators for Inventory Account here] off begin
					// % protected region % [Add other validators for Inventory Account here] end
				],
				// % protected region % [Add any additional model attribute properties for Inventory Account here] off begin
				// % protected region % [Add any additional model attribute properties for Inventory Account here] end
			},
			{
				name: 'purchaseAccount',
				// % protected region % [Set displayName for Purchase Account here] off begin
				displayName: 'Purchase Account',
				// % protected region % [Set displayName for Purchase Account here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Purchase Account here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Purchase Account here] end
				// % protected region % [Set isSensitive for Purchase Account here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Purchase Account here] end
				// % protected region % [Set readonly for Purchase Account here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Purchase Account here] end
				validators: [
					// % protected region % [Add other validators for Purchase Account here] off begin
					// % protected region % [Add other validators for Purchase Account here] end
				],
				// % protected region % [Add any additional model attribute properties for Purchase Account here] off begin
				// % protected region % [Add any additional model attribute properties for Purchase Account here] end
			},
			{
				name: 'lupSupplierName',
				// % protected region % [Set displayName for Lup Supplier Name here] off begin
				displayName: 'Lup Supplier Name',
				// % protected region % [Set displayName for Lup Supplier Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Lup Supplier Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Lup Supplier Name here] end
				// % protected region % [Set isSensitive for Lup Supplier Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lup Supplier Name here] end
				// % protected region % [Set readonly for Lup Supplier Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lup Supplier Name here] end
				validators: [
					// % protected region % [Add other validators for Lup Supplier Name here] off begin
					// % protected region % [Add other validators for Lup Supplier Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Lup Supplier Name here] off begin
				// % protected region % [Add any additional model attribute properties for Lup Supplier Name here] end
			},
			{
				name: 'lupUnitPrice',
				// % protected region % [Set displayName for Lup Unit Price here] off begin
				displayName: 'Lup Unit Price',
				// % protected region % [Set displayName for Lup Unit Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Lup Unit Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Lup Unit Price here] end
				// % protected region % [Set isSensitive for Lup Unit Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lup Unit Price here] end
				// % protected region % [Set readonly for Lup Unit Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lup Unit Price here] end
				validators: [
					// % protected region % [Add other validators for Lup Unit Price here] off begin
					// % protected region % [Add other validators for Lup Unit Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Lup Unit Price here] off begin
				// % protected region % [Add any additional model attribute properties for Lup Unit Price here] end
			},
			{
				name: 'lupDiscount',
				// % protected region % [Set displayName for Lup Discount here] off begin
				displayName: 'Lup Discount',
				// % protected region % [Set displayName for Lup Discount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Lup Discount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Lup Discount here] end
				// % protected region % [Set isSensitive for Lup Discount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lup Discount here] end
				// % protected region % [Set readonly for Lup Discount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lup Discount here] end
				validators: [
					// % protected region % [Add other validators for Lup Discount here] off begin
					// % protected region % [Add other validators for Lup Discount here] end
				],
				// % protected region % [Add any additional model attribute properties for Lup Discount here] off begin
				// % protected region % [Add any additional model attribute properties for Lup Discount here] end
			},
			{
				name: 'lupItemPrice',
				// % protected region % [Set displayName for Lup Item Price here] off begin
				displayName: 'Lup Item Price',
				// % protected region % [Set displayName for Lup Item Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Lup Item Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Lup Item Price here] end
				// % protected region % [Set isSensitive for Lup Item Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lup Item Price here] end
				// % protected region % [Set readonly for Lup Item Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lup Item Price here] end
				validators: [
					// % protected region % [Add other validators for Lup Item Price here] off begin
					// % protected region % [Add other validators for Lup Item Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Lup Item Price here] off begin
				// % protected region % [Add any additional model attribute properties for Lup Item Price here] end
			},
			{
				name: 'lupLastPurchaseDate',
				// % protected region % [Set displayName for Lup Last Purchase Date here] off begin
				displayName: 'Lup Last Purchase Date',
				// % protected region % [Set displayName for Lup Last Purchase Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Lup Last Purchase Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Lup Last Purchase Date here] end
				// % protected region % [Set isSensitive for Lup Last Purchase Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lup Last Purchase Date here] end
				// % protected region % [Set readonly for Lup Last Purchase Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lup Last Purchase Date here] end
				validators: [
					// % protected region % [Add other validators for Lup Last Purchase Date here] off begin
					// % protected region % [Add other validators for Lup Last Purchase Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Lup Last Purchase Date here] off begin
				// % protected region % [Add any additional model attribute properties for Lup Last Purchase Date here] end
			},
			{
				name: 'lppSupplierName',
				// % protected region % [Set displayName for Lpp Supplier Name here] off begin
				displayName: 'Lpp Supplier Name',
				// % protected region % [Set displayName for Lpp Supplier Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Lpp Supplier Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Lpp Supplier Name here] end
				// % protected region % [Set isSensitive for Lpp Supplier Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lpp Supplier Name here] end
				// % protected region % [Set readonly for Lpp Supplier Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lpp Supplier Name here] end
				validators: [
					// % protected region % [Add other validators for Lpp Supplier Name here] off begin
					// % protected region % [Add other validators for Lpp Supplier Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Lpp Supplier Name here] off begin
				// % protected region % [Add any additional model attribute properties for Lpp Supplier Name here] end
			},
			{
				name: 'lppUnitPrice',
				// % protected region % [Set displayName for Lpp Unit Price here] off begin
				displayName: 'Lpp Unit Price',
				// % protected region % [Set displayName for Lpp Unit Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Lpp Unit Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Lpp Unit Price here] end
				// % protected region % [Set isSensitive for Lpp Unit Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lpp Unit Price here] end
				// % protected region % [Set readonly for Lpp Unit Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lpp Unit Price here] end
				validators: [
					// % protected region % [Add other validators for Lpp Unit Price here] off begin
					// % protected region % [Add other validators for Lpp Unit Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Lpp Unit Price here] off begin
				// % protected region % [Add any additional model attribute properties for Lpp Unit Price here] end
			},
			{
				name: 'lppDiscount',
				// % protected region % [Set displayName for Lpp Discount here] off begin
				displayName: 'Lpp Discount',
				// % protected region % [Set displayName for Lpp Discount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Lpp Discount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Lpp Discount here] end
				// % protected region % [Set isSensitive for Lpp Discount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lpp Discount here] end
				// % protected region % [Set readonly for Lpp Discount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lpp Discount here] end
				validators: [
					// % protected region % [Add other validators for Lpp Discount here] off begin
					// % protected region % [Add other validators for Lpp Discount here] end
				],
				// % protected region % [Add any additional model attribute properties for Lpp Discount here] off begin
				// % protected region % [Add any additional model attribute properties for Lpp Discount here] end
			},
			{
				name: 'lppItemPrice',
				// % protected region % [Set displayName for Lpp Item Price here] off begin
				displayName: 'Lpp Item Price',
				// % protected region % [Set displayName for Lpp Item Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Lpp Item Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Lpp Item Price here] end
				// % protected region % [Set isSensitive for Lpp Item Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lpp Item Price here] end
				// % protected region % [Set readonly for Lpp Item Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lpp Item Price here] end
				validators: [
					// % protected region % [Add other validators for Lpp Item Price here] off begin
					// % protected region % [Add other validators for Lpp Item Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Lpp Item Price here] off begin
				// % protected region % [Add any additional model attribute properties for Lpp Item Price here] end
			},
			{
				name: 'lppLastPurchaseDate',
				// % protected region % [Set displayName for Lpp Last Purchase Date here] off begin
				displayName: 'Lpp Last Purchase Date',
				// % protected region % [Set displayName for Lpp Last Purchase Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Lpp Last Purchase Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Lpp Last Purchase Date here] end
				// % protected region % [Set isSensitive for Lpp Last Purchase Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lpp Last Purchase Date here] end
				// % protected region % [Set readonly for Lpp Last Purchase Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lpp Last Purchase Date here] end
				validators: [
					// % protected region % [Add other validators for Lpp Last Purchase Date here] off begin
					// % protected region % [Add other validators for Lpp Last Purchase Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Lpp Last Purchase Date here] off begin
				// % protected region % [Add any additional model attribute properties for Lpp Last Purchase Date here] end
			},
			// % protected region % [Add any additional class field names here] off begin
			// % protected region % [Add any additional class field names here] end
		]);
	}

	/**
	 * The relations of the entity
	 */
	static getRelations(): ModelRelation[] {
		return super.getRelations().concat([
			{
				id: 'batchStockBalancesCatalogue',
				type: ModelRelationType.MANY,
				name: 'batchStockBalancesCatalogueIds',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Balances Catalogue here] off begin
				label: 'Batch Stock Balances Catalogue',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Balances Catalogue here] end
				entityName: 'BatchStockBalanceModel',
				// % protected region % [Customise your display name for Batch Stock Balances Catalogue here] off begin
				displayName: 'sourceNumber',
				// % protected region % [Customise your display name for Batch Stock Balances Catalogue here] end
				validators: [
					// % protected region % [Add other validators for Batch Stock Balances Catalogue here] off begin
					// % protected region % [Add other validators for Batch Stock Balances Catalogue here] end
				],
				// % protected region % [Add any additional field for relation Batch Stock Balances Catalogue here] off begin
				// % protected region % [Add any additional field for relation Batch Stock Balances Catalogue here] end
			},
			{
				id: 'batchStockBalances',
				type: ModelRelationType.MANY,
				name: 'batchStockBalancesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Balances here] off begin
				label: 'Batch Stock Balances',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Balances here] end
				entityName: 'BatchStockBalancePerDateModel',
				// % protected region % [Customise your display name for Batch Stock Balances here] off begin
				displayName: 'batchNo',
				// % protected region % [Customise your display name for Batch Stock Balances here] end
				validators: [
					// % protected region % [Add other validators for Batch Stock Balances here] off begin
					// % protected region % [Add other validators for Batch Stock Balances here] end
				],
				// % protected region % [Add any additional field for relation Batch Stock Balances here] off begin
				// % protected region % [Add any additional field for relation Batch Stock Balances here] end
			},
			{
				id: 'batchStockTransactionDetails',
				type: ModelRelationType.MANY,
				name: 'batchStockTransactionDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Transaction Details here] off begin
				label: 'Batch Stock Transaction Details',
				// % protected region % [Customise your 1-1 or 1-M label for Batch Stock Transaction Details here] end
				entityName: 'BatchStockTransactionDetailModel',
				// % protected region % [Customise your display name for Batch Stock Transaction Details here] off begin
				displayName: 'batchNo',
				// % protected region % [Customise your display name for Batch Stock Transaction Details here] end
				validators: [
					// % protected region % [Add other validators for Batch Stock Transaction Details here] off begin
					// % protected region % [Add other validators for Batch Stock Transaction Details here] end
				],
				// % protected region % [Add any additional field for relation Batch Stock Transaction Details here] off begin
				// % protected region % [Add any additional field for relation Batch Stock Transaction Details here] end
			},
			{
				id: 'catalogueUOMs',
				type: ModelRelationType.MANY,
				name: 'catalogueUOMsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Catalogue UOMs here] off begin
				label: 'Catalogue UOMs',
				// % protected region % [Customise your 1-1 or 1-M label for Catalogue UOMs here] end
				entityName: 'CatalogueUOMModel',
				// % protected region % [Customise your display name for Catalogue UOMs here] off begin
				displayName: 'unitName',
				// % protected region % [Customise your display name for Catalogue UOMs here] end
				validators: [
					// % protected region % [Add other validators for Catalogue UOMs here] off begin
					// % protected region % [Add other validators for Catalogue UOMs here] end
				],
				// % protected region % [Add any additional field for relation Catalogue UOMs here] off begin
				// % protected region % [Add any additional field for relation Catalogue UOMs here] end
			},
			{
				id: 'compoundPrescriptionItems',
				type: ModelRelationType.MANY,
				name: 'compoundPrescriptionItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Compound Prescription Items here] off begin
				label: 'Compound Prescription Items',
				// % protected region % [Customise your 1-1 or 1-M label for Compound Prescription Items here] end
				entityName: 'CompoundPrescriptionItemModel',
				// % protected region % [Customise your display name for Compound Prescription Items here] off begin
				displayName: 'dose',
				// % protected region % [Customise your display name for Compound Prescription Items here] end
				validators: [
					// % protected region % [Add other validators for Compound Prescription Items here] off begin
					// % protected region % [Add other validators for Compound Prescription Items here] end
				],
				// % protected region % [Add any additional field for relation Compound Prescription Items here] off begin
				// % protected region % [Add any additional field for relation Compound Prescription Items here] end
			},
			{
				id: 'goodsReceiveNoteBatchs',
				type: ModelRelationType.MANY,
				name: 'goodsReceiveNoteBatchsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Note Batchs here] off begin
				label: 'Goods Receive Note Batchs',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Note Batchs here] end
				entityName: 'GoodsReceiveNoteBatchModel',
				// % protected region % [Customise your display name for Goods Receive Note Batchs here] off begin
				displayName: 'itemLineNumber',
				// % protected region % [Customise your display name for Goods Receive Note Batchs here] end
				validators: [
					// % protected region % [Add other validators for Goods Receive Note Batchs here] off begin
					// % protected region % [Add other validators for Goods Receive Note Batchs here] end
				],
				// % protected region % [Add any additional field for relation Goods Receive Note Batchs here] off begin
				// % protected region % [Add any additional field for relation Goods Receive Note Batchs here] end
			},
			{
				id: 'goodsReceiveNoteItems',
				type: ModelRelationType.MANY,
				name: 'goodsReceiveNoteItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Note Items here] off begin
				label: 'Goods Receive Note Items',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Note Items here] end
				entityName: 'GoodsReceiveNoteItemModel',
				// % protected region % [Customise your display name for Goods Receive Note Items here] off begin
				displayName: 'itemLineNumber',
				// % protected region % [Customise your display name for Goods Receive Note Items here] end
				validators: [
					// % protected region % [Add other validators for Goods Receive Note Items here] off begin
					// % protected region % [Add other validators for Goods Receive Note Items here] end
				],
				// % protected region % [Add any additional field for relation Goods Receive Note Items here] off begin
				// % protected region % [Add any additional field for relation Goods Receive Note Items here] end
			},
			{
				id: 'internalOrderStockDetails',
				type: ModelRelationType.MANY,
				name: 'internalOrderStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Internal Order Stock Details here] off begin
				label: 'Internal Order Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Internal Order Stock Details here] end
				entityName: 'InternalOrderStockDetailModel',
				// % protected region % [Customise your display name for Internal Order Stock Details here] off begin
				displayName: 'itemNumber',
				// % protected region % [Customise your display name for Internal Order Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Internal Order Stock Details here] off begin
					// % protected region % [Add other validators for Internal Order Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Internal Order Stock Details here] off begin
				// % protected region % [Add any additional field for relation Internal Order Stock Details here] end
			},
			{
				id: 'inventoryAdjusmentBatchs',
				type: ModelRelationType.MANY,
				name: 'inventoryAdjusmentBatchsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjusment Batchs here] off begin
				label: 'Inventory Adjusment Batchs',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjusment Batchs here] end
				entityName: 'InventoryAdjusmentBatchModel',
				// % protected region % [Customise your display name for Inventory Adjusment Batchs here] off begin
				displayName: 'itemLineNumber',
				// % protected region % [Customise your display name for Inventory Adjusment Batchs here] end
				validators: [
					// % protected region % [Add other validators for Inventory Adjusment Batchs here] off begin
					// % protected region % [Add other validators for Inventory Adjusment Batchs here] end
				],
				// % protected region % [Add any additional field for relation Inventory Adjusment Batchs here] off begin
				// % protected region % [Add any additional field for relation Inventory Adjusment Batchs here] end
			},
			{
				id: 'inventoryAdjustmentItems',
				type: ModelRelationType.MANY,
				name: 'inventoryAdjustmentItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjustment Items here] off begin
				label: 'Inventory Adjustment Items',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjustment Items here] end
				entityName: 'InventoryAdjustmentItemModel',
				// % protected region % [Customise your display name for Inventory Adjustment Items here] off begin
				displayName: 'itemLineNumber',
				// % protected region % [Customise your display name for Inventory Adjustment Items here] end
				validators: [
					// % protected region % [Add other validators for Inventory Adjustment Items here] off begin
					// % protected region % [Add other validators for Inventory Adjustment Items here] end
				],
				// % protected region % [Add any additional field for relation Inventory Adjustment Items here] off begin
				// % protected region % [Add any additional field for relation Inventory Adjustment Items here] end
			},
			{
				id: 'inventoryBatchCorrectionItems',
				type: ModelRelationType.MANY,
				name: 'inventoryBatchCorrectionItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Batch Correction Items here] off begin
				label: 'Inventory Batch Correction Items',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Batch Correction Items here] end
				entityName: 'InventoryBatchCorrectionItemModel',
				// % protected region % [Customise your display name for Inventory Batch Correction Items here] off begin
				displayName: 'itemLineNumber',
				// % protected region % [Customise your display name for Inventory Batch Correction Items here] end
				validators: [
					// % protected region % [Add other validators for Inventory Batch Correction Items here] off begin
					// % protected region % [Add other validators for Inventory Batch Correction Items here] end
				],
				// % protected region % [Add any additional field for relation Inventory Batch Correction Items here] off begin
				// % protected region % [Add any additional field for relation Inventory Batch Correction Items here] end
			},
			{
				id: 'medicationItems',
				type: ModelRelationType.MANY,
				name: 'medicationItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Items here] off begin
				label: 'Medication Items',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Items here] end
				entityName: 'MedicationItemModel',
				// % protected region % [Customise your display name for Medication Items here] off begin
				displayName: 'requestedQty',
				// % protected region % [Customise your display name for Medication Items here] end
				validators: [
					// % protected region % [Add other validators for Medication Items here] off begin
					// % protected region % [Add other validators for Medication Items here] end
				],
				// % protected region % [Add any additional field for relation Medication Items here] off begin
				// % protected region % [Add any additional field for relation Medication Items here] end
			},
			{
				id: 'prescriptionItem',
				type: ModelRelationType.MANY,
				name: 'prescriptionItemIds',
				// % protected region % [Customise your 1-1 or 1-M label for Prescription Item here] off begin
				label: 'Prescription Item',
				// % protected region % [Customise your 1-1 or 1-M label for Prescription Item here] end
				entityName: 'PrescriptionItemModel',
				// % protected region % [Customise your display name for Prescription Item here] off begin
				displayName: 'iterationStart',
				// % protected region % [Customise your display name for Prescription Item here] end
				validators: [
					// % protected region % [Add other validators for Prescription Item here] off begin
					// % protected region % [Add other validators for Prescription Item here] end
				],
				// % protected region % [Add any additional field for relation Prescription Item here] off begin
				// % protected region % [Add any additional field for relation Prescription Item here] end
			},
			{
				id: 'purchaseOrderStockDetails',
				type: ModelRelationType.MANY,
				name: 'purchaseOrderStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Order Stock Details here] off begin
				label: 'Purchase Order Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Order Stock Details here] end
				entityName: 'PurchaseOrderStockDetailModel',
				// % protected region % [Customise your display name for Purchase Order Stock Details here] off begin
				displayName: 'unitPrice',
				// % protected region % [Customise your display name for Purchase Order Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Purchase Order Stock Details here] off begin
					// % protected region % [Add other validators for Purchase Order Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional field for relation Purchase Order Stock Details here] end
			},
			{
				id: 'purchaseRequisitionStockDetails',
				type: ModelRelationType.MANY,
				name: 'purchaseRequisitionStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Requisition Stock Details here] off begin
				label: 'Purchase Requisition Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Requisition Stock Details here] end
				entityName: 'PurchaseRequisitionStockDetailModel',
				// % protected region % [Customise your display name for Purchase Requisition Stock Details here] off begin
				displayName: 'soh',
				// % protected region % [Customise your display name for Purchase Requisition Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Purchase Requisition Stock Details here] off begin
					// % protected region % [Add other validators for Purchase Requisition Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Purchase Requisition Stock Details here] off begin
				// % protected region % [Add any additional field for relation Purchase Requisition Stock Details here] end
			},
			{
				id: 'retailPharmacyStockDetails',
				type: ModelRelationType.MANY,
				name: 'retailPharmacyStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Retail Pharmacy Stock Details here] off begin
				label: 'Retail Pharmacy Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Retail Pharmacy Stock Details here] end
				entityName: 'RetailPharmacyStockDetailModel',
				// % protected region % [Customise your display name for Retail Pharmacy Stock Details here] off begin
				displayName: 'supplyStockGroup',
				// % protected region % [Customise your display name for Retail Pharmacy Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Retail Pharmacy Stock Details here] off begin
					// % protected region % [Add other validators for Retail Pharmacy Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Retail Pharmacy Stock Details here] off begin
				// % protected region % [Add any additional field for relation Retail Pharmacy Stock Details here] end
			},
			{
				id: 'returnSupplierStockDetails',
				type: ModelRelationType.MANY,
				name: 'returnSupplierStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Return Supplier Stock Details here] off begin
				label: 'Return Supplier Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Return Supplier Stock Details here] end
				entityName: 'ReturnSupplierStockDetailModel',
				// % protected region % [Customise your display name for Return Supplier Stock Details here] off begin
				displayName: 'price',
				// % protected region % [Customise your display name for Return Supplier Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Return Supplier Stock Details here] off begin
					// % protected region % [Add other validators for Return Supplier Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Return Supplier Stock Details here] off begin
				// % protected region % [Add any additional field for relation Return Supplier Stock Details here] end
			},
			{
				id: 'stockCatalogueMedical',
				type: ModelRelationType.ONE,
				name: 'stockCatalogueMedicalId',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Catalogue Medical  here] off begin
				label: 'Stock Catalogue Medical ',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Catalogue Medical  here] end
				entityName: 'CatalogueMedicalModel',
				// % protected region % [Customise your display name for Stock Catalogue Medical  here] off begin
				displayName: 'composition',
				// % protected region % [Customise your display name for Stock Catalogue Medical  here] end
				validators: [
					// % protected region % [Add other validators for Stock Catalogue Medical  here] off begin
					// % protected region % [Add other validators for Stock Catalogue Medical  here] end
				],
				// % protected region % [Add any additional field for relation Stock Catalogue Medical  here] off begin
				// % protected region % [Add any additional field for relation Stock Catalogue Medical  here] end
			},
			{
				id: 'stockCatalogueNonMedical',
				type: ModelRelationType.ONE,
				name: 'stockCatalogueNonMedicalId',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Catalogue Non Medical here] off begin
				label: 'Stock Catalogue Non Medical',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Catalogue Non Medical here] end
				entityName: 'CatalogueNonMedicalModel',
				// % protected region % [Customise your display name for Stock Catalogue Non Medical here] off begin
				displayName: 'manufacturer',
				// % protected region % [Customise your display name for Stock Catalogue Non Medical here] end
				validators: [
					// % protected region % [Add other validators for Stock Catalogue Non Medical here] off begin
					// % protected region % [Add other validators for Stock Catalogue Non Medical here] end
				],
				// % protected region % [Add any additional field for relation Stock Catalogue Non Medical here] off begin
				// % protected region % [Add any additional field for relation Stock Catalogue Non Medical here] end
			},
			{
				id: 'stockControls',
				type: ModelRelationType.MANY,
				name: 'stockControlsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Controls here] off begin
				label: 'Stock Controls',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Controls here] end
				entityName: 'StockControlModel',
				// % protected region % [Customise your display name for Stock Controls here] off begin
				displayName: 'onHandQty',
				// % protected region % [Customise your display name for Stock Controls here] end
				validators: [
					// % protected region % [Add other validators for Stock Controls here] off begin
					// % protected region % [Add other validators for Stock Controls here] end
				],
				// % protected region % [Add any additional field for relation Stock Controls here] off begin
				// % protected region % [Add any additional field for relation Stock Controls here] end
			},
			{
				id: 'stockTransactionDetails',
				type: ModelRelationType.MANY,
				name: 'stockTransactionDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Details here] off begin
				label: 'Stock Transaction Details',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Details here] end
				entityName: 'StockTransactionDetailModel',
				// % protected region % [Customise your display name for Stock Transaction Details here] off begin
				displayName: 'transactionNumber',
				// % protected region % [Customise your display name for Stock Transaction Details here] end
				validators: [
					// % protected region % [Add other validators for Stock Transaction Details here] off begin
					// % protected region % [Add other validators for Stock Transaction Details here] end
				],
				// % protected region % [Add any additional field for relation Stock Transaction Details here] off begin
				// % protected region % [Add any additional field for relation Stock Transaction Details here] end
			},
			{
				id: 'stockTransactionPerDateTypes',
				type: ModelRelationType.MANY,
				name: 'stockTransactionPerDateTypesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Per Date Types here] off begin
				label: 'Stock Transaction Per Date Types',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Per Date Types here] end
				entityName: 'StockTransactionPerDateTypeModel',
				// % protected region % [Customise your display name for Stock Transaction Per Date Types here] off begin
				displayName: 'asOfDate',
				// % protected region % [Customise your display name for Stock Transaction Per Date Types here] end
				validators: [
					// % protected region % [Add other validators for Stock Transaction Per Date Types here] off begin
					// % protected region % [Add other validators for Stock Transaction Per Date Types here] end
				],
				// % protected region % [Add any additional field for relation Stock Transaction Per Date Types here] off begin
				// % protected region % [Add any additional field for relation Stock Transaction Per Date Types here] end
			},
			{
				id: 'stockTransactionPerDates',
				type: ModelRelationType.MANY,
				name: 'stockTransactionPerDatesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Per Dates here] off begin
				label: 'Stock Transaction Per Dates',
				// % protected region % [Customise your 1-1 or 1-M label for Stock Transaction Per Dates here] end
				entityName: 'StockTransactionPerDateModel',
				// % protected region % [Customise your display name for Stock Transaction Per Dates here] off begin
				displayName: 'asOfDate',
				// % protected region % [Customise your display name for Stock Transaction Per Dates here] end
				validators: [
					// % protected region % [Add other validators for Stock Transaction Per Dates here] off begin
					// % protected region % [Add other validators for Stock Transaction Per Dates here] end
				],
				// % protected region % [Add any additional field for relation Stock Transaction Per Dates here] off begin
				// % protected region % [Add any additional field for relation Stock Transaction Per Dates here] end
			},
			{
				id: 'supplierProductDetails',
				type: ModelRelationType.MANY,
				name: 'supplierProductDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Supplier Product Details here] off begin
				label: 'Supplier Product Details',
				// % protected region % [Customise your 1-1 or 1-M label for Supplier Product Details here] end
				entityName: 'SupplierProductDetailModel',
				// % protected region % [Customise your display name for Supplier Product Details here] off begin
				displayName: 'unitCode',
				// % protected region % [Customise your display name for Supplier Product Details here] end
				validators: [
					// % protected region % [Add other validators for Supplier Product Details here] off begin
					// % protected region % [Add other validators for Supplier Product Details here] end
				],
				// % protected region % [Add any additional field for relation Supplier Product Details here] off begin
				// % protected region % [Add any additional field for relation Supplier Product Details here] end
			},
			{
				id: 'transferOrderStockDetails',
				type: ModelRelationType.MANY,
				name: 'transferOrderStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Transfer Order Stock Details here] off begin
				label: 'Transfer Order Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Transfer Order Stock Details here] end
				entityName: 'TransferOrderStockDetailModel',
				// % protected region % [Customise your display name for Transfer Order Stock Details here] off begin
				displayName: 'itemNumber',
				// % protected region % [Customise your display name for Transfer Order Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Transfer Order Stock Details here] off begin
					// % protected region % [Add other validators for Transfer Order Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional field for relation Transfer Order Stock Details here] end
			},
			{
				id: 'vaccinationOrderDetails',
				type: ModelRelationType.MANY,
				name: 'vaccinationOrderDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Vaccination Order Details here] off begin
				label: 'Vaccination Order Details',
				// % protected region % [Customise your 1-1 or 1-M label for Vaccination Order Details here] end
				entityName: 'VaccinationOrderDetailModel',
				// % protected region % [Customise your display name for Vaccination Order Details here] off begin
				displayName: 'vaccinationDate',
				// % protected region % [Customise your display name for Vaccination Order Details here] end
				validators: [
					// % protected region % [Add other validators for Vaccination Order Details here] off begin
					// % protected region % [Add other validators for Vaccination Order Details here] end
				],
				// % protected region % [Add any additional field for relation Vaccination Order Details here] off begin
				// % protected region % [Add any additional field for relation Vaccination Order Details here] end
			},
			{
				id: 'warehouseInitialStockS',
				type: ModelRelationType.MANY,
				name: 'warehouseInitialStockSIds',
				// % protected region % [Customise your 1-1 or 1-M label for Warehouse Initial Stock s here] off begin
				label: 'Warehouse Initial Stock s',
				// % protected region % [Customise your 1-1 or 1-M label for Warehouse Initial Stock s here] end
				entityName: 'WarehouseInitialStockModel',
				// % protected region % [Customise your display name for Warehouse Initial Stock s here] off begin
				displayName: 'minimumLevel',
				// % protected region % [Customise your display name for Warehouse Initial Stock s here] end
				validators: [
					// % protected region % [Add other validators for Warehouse Initial Stock s here] off begin
					// % protected region % [Add other validators for Warehouse Initial Stock s here] end
				],
				// % protected region % [Add any additional field for relation Warehouse Initial Stock s here] off begin
				// % protected region % [Add any additional field for relation Warehouse Initial Stock s here] end
			},
			{
				id: 'warehouseInventories',
				type: ModelRelationType.MANY,
				name: 'warehouseInventoriesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Warehouse Inventories here] off begin
				label: 'Warehouse Inventories',
				// % protected region % [Customise your 1-1 or 1-M label for Warehouse Inventories here] end
				entityName: 'WarehouseInventoryModel',
				// % protected region % [Customise your display name for Warehouse Inventories here] off begin
				displayName: 'soh',
				// % protected region % [Customise your display name for Warehouse Inventories here] end
				validators: [
					// % protected region % [Add other validators for Warehouse Inventories here] off begin
					// % protected region % [Add other validators for Warehouse Inventories here] end
				],
				// % protected region % [Add any additional field for relation Warehouse Inventories here] off begin
				// % protected region % [Add any additional field for relation Warehouse Inventories here] end
			},
			{
				id: 'bpjsDrugGenericPRB',
				type: ModelRelationType.ONE,
				name: 'bpjsDrugGenericPRBId',
				// % protected region % [Customise your label for BPJS Drug Generic PRB here] off begin
				label: 'BPJS Drug Generic PRB',
				// % protected region % [Customise your label for BPJS Drug Generic PRB here] end
				entityName: 'BpjsDrugGenericPRBModel',
				// % protected region % [Customise your display name for BPJS Drug Generic PRB here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refDrugCode',
				// % protected region % [Customise your display name for BPJS Drug Generic PRB here] end
				validators: [
					// % protected region % [Add other validators for BPJS Drug Generic PRB here] off begin
					// % protected region % [Add other validators for BPJS Drug Generic PRB here] end
				],
				// % protected region % [Add any additional field for relation BPJS Drug Generic PRB here] off begin
				// % protected region % [Add any additional field for relation BPJS Drug Generic PRB here] end
			},
			{
				id: 'bpjsPcareDPHO',
				type: ModelRelationType.ONE,
				name: 'bpjsPcareDPHOId',
				// % protected region % [Customise your label for BPJS Pcare DPHO here] off begin
				label: 'BPJS Pcare DPHO',
				// % protected region % [Customise your label for BPJS Pcare DPHO here] end
				entityName: 'BpjsPcareDPHOModel',
				// % protected region % [Customise your display name for BPJS Pcare DPHO here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'kdobat',
				// % protected region % [Customise your display name for BPJS Pcare DPHO here] end
				validators: [
					// % protected region % [Add other validators for BPJS Pcare DPHO here] off begin
					// % protected region % [Add other validators for BPJS Pcare DPHO here] end
				],
				// % protected region % [Add any additional field for relation BPJS Pcare DPHO here] off begin
				// % protected region % [Add any additional field for relation BPJS Pcare DPHO here] end
			},
			{
				id: 'warehouse',
				type: ModelRelationType.ONE,
				name: 'warehouseId',
				// % protected region % [Customise your label for Warehouse here] off begin
				label: 'Warehouse',
				// % protected region % [Customise your label for Warehouse here] end
				entityName: 'WarehouseModel',
				// % protected region % [Customise your display name for Warehouse here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'warehouseNumber',
				// % protected region % [Customise your display name for Warehouse here] end
				validators: [
					// % protected region % [Add other validators for Warehouse here] off begin
					// % protected region % [Add other validators for Warehouse here] end
				],
				// % protected region % [Add any additional field for relation Warehouse here] off begin
				// % protected region % [Add any additional field for relation Warehouse here] end
			},
		]);
	}

	/**
	 * Convert the form group to the query conditions
	 */
	static convertFilterToCondition(formGroup: FormGroup): Where[][] {
		let conditions: Where[][] = [];

		// % protected region % [Overide the default convertFilterToCondition here] off begin
		Object.keys(formGroup.value).forEach((key) => {
			switch (key) {
				case 'stockCode':
					break;
				case 'stockName':
					break;
				case 'stockGroup':
					break;
				case 'stockCategory':
					break;
				case 'approvalStatus':
					break;
				case 'medicalType':
					break;
				case 'created':
					const created = formGroup.value[key];
					// is the range of date
					if (created instanceof Array) {
						conditions.push([
							{
								path: key,
								operation: QueryOperation.GREATER_THAN_OR_EQUAL,
								value: created[0]
							}
						]);
						conditions.push([
							{
								path: key,
								operation: QueryOperation.LESS_THAN_OR_EQUAL,
								value: created[1]
							}
						]);
					}
			}
		});
		// % protected region % [Overide the default convertFilterToCondition here] end


		return conditions;
	}

	/**
	 * Convert a nested JSON object into an array of flatten objects.
	 */
	static deepParse(data: string | { [K in keyof StockCatalogueModel]?: StockCatalogueModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new StockCatalogueModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.stockCatalogueMedical) {
			currentModel.stockCatalogueMedicalId = json.stockCatalogueMedical.id;
			returned = _.union(returned, CatalogueMedicalModel.deepParse(json.stockCatalogueMedical));
		}

		// Outgoing one to one
		if (json.stockCatalogueNonMedical) {
			currentModel.stockCatalogueNonMedicalId = json.stockCatalogueNonMedical.id;
			returned = _.union(returned, CatalogueNonMedicalModel.deepParse(json.stockCatalogueNonMedical));
		}

		// Incoming one to one
		if (json.bpjsDrugGenericPRB) {
			currentModel.bpjsDrugGenericPRBId = json.bpjsDrugGenericPRB.id;
			returned = _.union(returned, BpjsDrugGenericPRBModel.deepParse(json.bpjsDrugGenericPRB));
		}

		// Incoming one to one
		if (json.bpjsPcareDPHO) {
			currentModel.bpjsPcareDPHOId = json.bpjsPcareDPHO.id;
			returned = _.union(returned, BpjsPcareDPHOModel.deepParse(json.bpjsPcareDPHO));
		}

		// Incoming one to many
		if (json.warehouse) {
			currentModel.warehouseId = json.warehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.warehouse));
		}

		// Outgoing one to many
		if (json.batchStockBalancesCatalogue) {
			currentModel.batchStockBalancesCatalogueIds = json.batchStockBalancesCatalogue.map(model => model.id);
			returned = _.union(returned, _.flatten(json.batchStockBalancesCatalogue.map(model => BatchStockBalanceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.batchStockBalances) {
			currentModel.batchStockBalancesIds = json.batchStockBalances.map(model => model.id);
			returned = _.union(returned, _.flatten(json.batchStockBalances.map(model => BatchStockBalancePerDateModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.batchStockTransactionDetails) {
			currentModel.batchStockTransactionDetailsIds = json.batchStockTransactionDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.batchStockTransactionDetails.map(model => BatchStockTransactionDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.catalogueUOMs) {
			currentModel.catalogueUOMsIds = json.catalogueUOMs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.catalogueUOMs.map(model => CatalogueUOMModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.compoundPrescriptionItems) {
			currentModel.compoundPrescriptionItemsIds = json.compoundPrescriptionItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.compoundPrescriptionItems.map(model => CompoundPrescriptionItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.goodsReceiveNoteBatchs) {
			currentModel.goodsReceiveNoteBatchsIds = json.goodsReceiveNoteBatchs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.goodsReceiveNoteBatchs.map(model => GoodsReceiveNoteBatchModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.goodsReceiveNoteItems) {
			currentModel.goodsReceiveNoteItemsIds = json.goodsReceiveNoteItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.goodsReceiveNoteItems.map(model => GoodsReceiveNoteItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.internalOrderStockDetails) {
			currentModel.internalOrderStockDetailsIds = json.internalOrderStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.internalOrderStockDetails.map(model => InternalOrderStockDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.inventoryAdjusmentBatchs) {
			currentModel.inventoryAdjusmentBatchsIds = json.inventoryAdjusmentBatchs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.inventoryAdjusmentBatchs.map(model => InventoryAdjusmentBatchModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.inventoryAdjustmentItems) {
			currentModel.inventoryAdjustmentItemsIds = json.inventoryAdjustmentItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.inventoryAdjustmentItems.map(model => InventoryAdjustmentItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.inventoryBatchCorrectionItems) {
			currentModel.inventoryBatchCorrectionItemsIds = json.inventoryBatchCorrectionItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.inventoryBatchCorrectionItems.map(model => InventoryBatchCorrectionItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicationItems) {
			currentModel.medicationItemsIds = json.medicationItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationItems.map(model => MedicationItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.prescriptionItem) {
			currentModel.prescriptionItemIds = json.prescriptionItem.map(model => model.id);
			returned = _.union(returned, _.flatten(json.prescriptionItem.map(model => PrescriptionItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.purchaseOrderStockDetails) {
			currentModel.purchaseOrderStockDetailsIds = json.purchaseOrderStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.purchaseOrderStockDetails.map(model => PurchaseOrderStockDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.purchaseRequisitionStockDetails) {
			currentModel.purchaseRequisitionStockDetailsIds = json.purchaseRequisitionStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.purchaseRequisitionStockDetails.map(model => PurchaseRequisitionStockDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.retailPharmacyStockDetails) {
			currentModel.retailPharmacyStockDetailsIds = json.retailPharmacyStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.retailPharmacyStockDetails.map(model => RetailPharmacyStockDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.returnSupplierStockDetails) {
			currentModel.returnSupplierStockDetailsIds = json.returnSupplierStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.returnSupplierStockDetails.map(model => ReturnSupplierStockDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.stockControls) {
			currentModel.stockControlsIds = json.stockControls.map(model => model.id);
			returned = _.union(returned, _.flatten(json.stockControls.map(model => StockControlModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.stockTransactionDetails) {
			currentModel.stockTransactionDetailsIds = json.stockTransactionDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.stockTransactionDetails.map(model => StockTransactionDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.stockTransactionPerDateTypes) {
			currentModel.stockTransactionPerDateTypesIds = json.stockTransactionPerDateTypes.map(model => model.id);
			returned = _.union(returned, _.flatten(json.stockTransactionPerDateTypes.map(model => StockTransactionPerDateTypeModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.stockTransactionPerDates) {
			currentModel.stockTransactionPerDatesIds = json.stockTransactionPerDates.map(model => model.id);
			returned = _.union(returned, _.flatten(json.stockTransactionPerDates.map(model => StockTransactionPerDateModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.supplierProductDetails) {
			currentModel.supplierProductDetailsIds = json.supplierProductDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.supplierProductDetails.map(model => SupplierProductDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.transferOrderStockDetails) {
			currentModel.transferOrderStockDetailsIds = json.transferOrderStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.transferOrderStockDetails.map(model => TransferOrderStockDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.vaccinationOrderDetails) {
			currentModel.vaccinationOrderDetailsIds = json.vaccinationOrderDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.vaccinationOrderDetails.map(model => VaccinationOrderDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.warehouseInitialStockS) {
			currentModel.warehouseInitialStockSIds = json.warehouseInitialStockS.map(model => model.id);
			returned = _.union(returned, _.flatten(json.warehouseInitialStockS.map(model => WarehouseInitialStockModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.warehouseInventories) {
			currentModel.warehouseInventoriesIds = json.warehouseInventories.map(model => model.id);
			returned = _.union(returned, _.flatten(json.warehouseInventories.map(model => WarehouseInventoryModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let stockCatalogueModel = new StockCatalogueModel(data);`
	 *
	 * @param data The input data to be initialised as the StockCatalogueModel,
	 *    it is expected as a JSON string or as a nullable StockCatalogueModel.
	 */
	constructor(data?: string | Partial<StockCatalogueModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<StockCatalogueModel>
				: data;

			this.trackable = json.trackable;
			this.stockCode = json.stockCode;
			this.stockName = json.stockName;
			this.description = json.description;
			this.weight = json.weight;
			this.weightUnit = json.weightUnit;
			this.volume = json.volume;
			this.volumeUnit = json.volumeUnit;
			this.stockGroup = json.stockGroup;
			this.stockCategory = json.stockCategory;
			this.approvalStatus = json.approvalStatus;
			this.approvedBy = json.approvedBy;
			if (json.approvalDate) {
				this.approvalDate = new Date(json.approvalDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.approvalDate = json.approvalDate;
			}
			this.approvalNotes = json.approvalNotes;
			this.quantityPerPack = json.quantityPerPack;
			this.uoi = json.uoi;
			this.lastBuyingPriceVATExcludeCurrency = json.lastBuyingPriceVATExcludeCurrency;
			this.lastBuyingPriceVATExcludePrice = json.lastBuyingPriceVATExcludePrice;
			this.lastBuyingPriceVATIncludeCurrency = json.lastBuyingPriceVATIncludeCurrency;
			this.lastBuyingPriceVATIncludePrice = json.lastBuyingPriceVATIncludePrice;
			this.medicalType = json.medicalType;
			this.stockCategoryVATExcluded = json.stockCategoryVATExcluded;
			this.stockCategoryVATIncluded = json.stockCategoryVATIncluded;
			this.onHandQty = json.onHandQty;
			this.averageCost = json.averageCost;
			this.totalCost = json.totalCost;
			this.salesAccount = json.salesAccount;
			this.inventoryAccount = json.inventoryAccount;
			this.purchaseAccount = json.purchaseAccount;
			this.lupSupplierName = json.lupSupplierName;
			this.lupUnitPrice = json.lupUnitPrice;
			this.lupDiscount = json.lupDiscount;
			this.lupItemPrice = json.lupItemPrice;
			if (json.lupLastPurchaseDate) {
				this.lupLastPurchaseDate = new Date(json.lupLastPurchaseDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.lupLastPurchaseDate = json.lupLastPurchaseDate;
			}
			this.lppSupplierName = json.lppSupplierName;
			this.lppUnitPrice = json.lppUnitPrice;
			this.lppDiscount = json.lppDiscount;
			this.lppItemPrice = json.lppItemPrice;
			if (json.lppLastPurchaseDate) {
				this.lppLastPurchaseDate = new Date(json.lppLastPurchaseDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.lppLastPurchaseDate = json.lppLastPurchaseDate;
			}
			this.stockCatalogueMedicalId = json.stockCatalogueMedicalId;
			this.stockCatalogueMedical = json.stockCatalogueMedical;
			this.stockCatalogueNonMedicalId = json.stockCatalogueNonMedicalId;
			this.stockCatalogueNonMedical = json.stockCatalogueNonMedical;
			this.bpjsDrugGenericPRBId = json.bpjsDrugGenericPRBId;
			this.bpjsDrugGenericPRB = json.bpjsDrugGenericPRB;
			this.bpjsPcareDPHOId = json.bpjsPcareDPHOId;
			this.bpjsPcareDPHO = json.bpjsPcareDPHO;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			this.batchStockBalancesCatalogueIds = json.batchStockBalancesCatalogueIds;
			this.batchStockBalancesCatalogue = json.batchStockBalancesCatalogue;
			this.batchStockBalancesIds = json.batchStockBalancesIds;
			this.batchStockBalances = json.batchStockBalances;
			this.batchStockTransactionDetailsIds = json.batchStockTransactionDetailsIds;
			this.batchStockTransactionDetails = json.batchStockTransactionDetails;
			this.catalogueUOMsIds = json.catalogueUOMsIds;
			this.catalogueUOMs = json.catalogueUOMs;
			this.compoundPrescriptionItemsIds = json.compoundPrescriptionItemsIds;
			this.compoundPrescriptionItems = json.compoundPrescriptionItems;
			this.goodsReceiveNoteBatchsIds = json.goodsReceiveNoteBatchsIds;
			this.goodsReceiveNoteBatchs = json.goodsReceiveNoteBatchs;
			this.goodsReceiveNoteItemsIds = json.goodsReceiveNoteItemsIds;
			this.goodsReceiveNoteItems = json.goodsReceiveNoteItems;
			this.internalOrderStockDetailsIds = json.internalOrderStockDetailsIds;
			this.internalOrderStockDetails = json.internalOrderStockDetails;
			this.inventoryAdjusmentBatchsIds = json.inventoryAdjusmentBatchsIds;
			this.inventoryAdjusmentBatchs = json.inventoryAdjusmentBatchs;
			this.inventoryAdjustmentItemsIds = json.inventoryAdjustmentItemsIds;
			this.inventoryAdjustmentItems = json.inventoryAdjustmentItems;
			this.inventoryBatchCorrectionItemsIds = json.inventoryBatchCorrectionItemsIds;
			this.inventoryBatchCorrectionItems = json.inventoryBatchCorrectionItems;
			this.medicationItemsIds = json.medicationItemsIds;
			this.medicationItems = json.medicationItems;
			this.prescriptionItemIds = json.prescriptionItemIds;
			this.prescriptionItem = json.prescriptionItem;
			this.purchaseOrderStockDetailsIds = json.purchaseOrderStockDetailsIds;
			this.purchaseOrderStockDetails = json.purchaseOrderStockDetails;
			this.purchaseRequisitionStockDetailsIds = json.purchaseRequisitionStockDetailsIds;
			this.purchaseRequisitionStockDetails = json.purchaseRequisitionStockDetails;
			this.retailPharmacyStockDetailsIds = json.retailPharmacyStockDetailsIds;
			this.retailPharmacyStockDetails = json.retailPharmacyStockDetails;
			this.returnSupplierStockDetailsIds = json.returnSupplierStockDetailsIds;
			this.returnSupplierStockDetails = json.returnSupplierStockDetails;
			this.stockControlsIds = json.stockControlsIds;
			this.stockControls = json.stockControls;
			this.stockTransactionDetailsIds = json.stockTransactionDetailsIds;
			this.stockTransactionDetails = json.stockTransactionDetails;
			this.stockTransactionPerDateTypesIds = json.stockTransactionPerDateTypesIds;
			this.stockTransactionPerDateTypes = json.stockTransactionPerDateTypes;
			this.stockTransactionPerDatesIds = json.stockTransactionPerDatesIds;
			this.stockTransactionPerDates = json.stockTransactionPerDates;
			this.supplierProductDetailsIds = json.supplierProductDetailsIds;
			this.supplierProductDetails = json.supplierProductDetails;
			this.transferOrderStockDetailsIds = json.transferOrderStockDetailsIds;
			this.transferOrderStockDetails = json.transferOrderStockDetails;
			this.vaccinationOrderDetailsIds = json.vaccinationOrderDetailsIds;
			this.vaccinationOrderDetails = json.vaccinationOrderDetails;
			this.warehouseInitialStockSIds = json.warehouseInitialStockSIds;
			this.warehouseInitialStockS = json.warehouseInitialStockS;
			this.warehouseInventoriesIds = json.warehouseInventoriesIds;
			this.warehouseInventories = json.warehouseInventories;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			trackable: this.trackable,
			stockCode: this.stockCode,
			stockName: this.stockName,
			description: this.description,
			weight: this.weight,
			weightUnit: this.weightUnit,
			volume: this.volume,
			volumeUnit: this.volumeUnit,
			stockGroup: this.stockGroup,
			stockCategory: this.stockCategory,
			approvalStatus: this.approvalStatus,
			approvedBy: this.approvedBy,
			approvalDate: this.approvalDate,
			approvalNotes: this.approvalNotes,
			quantityPerPack: this.quantityPerPack,
			uoi: this.uoi,
			lastBuyingPriceVATExcludeCurrency: this.lastBuyingPriceVATExcludeCurrency,
			lastBuyingPriceVATExcludePrice: this.lastBuyingPriceVATExcludePrice,
			lastBuyingPriceVATIncludeCurrency: this.lastBuyingPriceVATIncludeCurrency,
			lastBuyingPriceVATIncludePrice: this.lastBuyingPriceVATIncludePrice,
			medicalType: this.medicalType,
			stockCategoryVATExcluded: this.stockCategoryVATExcluded,
			stockCategoryVATIncluded: this.stockCategoryVATIncluded,
			onHandQty: this.onHandQty,
			averageCost: this.averageCost,
			totalCost: this.totalCost,
			salesAccount: this.salesAccount,
			inventoryAccount: this.inventoryAccount,
			purchaseAccount: this.purchaseAccount,
			lupSupplierName: this.lupSupplierName,
			lupUnitPrice: this.lupUnitPrice,
			lupDiscount: this.lupDiscount,
			lupItemPrice: this.lupItemPrice,
			lupLastPurchaseDate: this.lupLastPurchaseDate,
			lppSupplierName: this.lppSupplierName,
			lppUnitPrice: this.lppUnitPrice,
			lppDiscount: this.lppDiscount,
			lppItemPrice: this.lppItemPrice,
			lppLastPurchaseDate: this.lppLastPurchaseDate,
			stockCatalogueMedicalId: this.stockCatalogueMedicalId,
			stockCatalogueNonMedicalId: this.stockCatalogueNonMedicalId,
			bpjsDrugGenericPRBId: this.bpjsDrugGenericPRBId,
			bpjsPcareDPHOId: this.bpjsPcareDPHOId,
			warehouseId: this.warehouseId,
			batchStockBalancesCatalogueIds: this.batchStockBalancesCatalogueIds,
			batchStockBalancesIds: this.batchStockBalancesIds,
			batchStockTransactionDetailsIds: this.batchStockTransactionDetailsIds,
			catalogueUOMsIds: this.catalogueUOMsIds,
			compoundPrescriptionItemsIds: this.compoundPrescriptionItemsIds,
			goodsReceiveNoteBatchsIds: this.goodsReceiveNoteBatchsIds,
			goodsReceiveNoteItemsIds: this.goodsReceiveNoteItemsIds,
			internalOrderStockDetailsIds: this.internalOrderStockDetailsIds,
			inventoryAdjusmentBatchsIds: this.inventoryAdjusmentBatchsIds,
			inventoryAdjustmentItemsIds: this.inventoryAdjustmentItemsIds,
			inventoryBatchCorrectionItemsIds: this.inventoryBatchCorrectionItemsIds,
			medicationItemsIds: this.medicationItemsIds,
			prescriptionItemIds: this.prescriptionItemIds,
			purchaseOrderStockDetailsIds: this.purchaseOrderStockDetailsIds,
			purchaseRequisitionStockDetailsIds: this.purchaseRequisitionStockDetailsIds,
			retailPharmacyStockDetailsIds: this.retailPharmacyStockDetailsIds,
			returnSupplierStockDetailsIds: this.returnSupplierStockDetailsIds,
			stockControlsIds: this.stockControlsIds,
			stockTransactionDetailsIds: this.stockTransactionDetailsIds,
			stockTransactionPerDateTypesIds: this.stockTransactionPerDateTypesIds,
			stockTransactionPerDatesIds: this.stockTransactionPerDatesIds,
			supplierProductDetailsIds: this.supplierProductDetailsIds,
			transferOrderStockDetailsIds: this.transferOrderStockDetailsIds,
			vaccinationOrderDetailsIds: this.vaccinationOrderDetailsIds,
			warehouseInitialStockSIds: this.warehouseInitialStockSIds,
			warehouseInventoriesIds: this.warehouseInventoriesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		StockCatalogueModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): StockCatalogueModel {
		let newModelJson = this.toJSON();

		if (updates.trackable) {
			newModelJson.trackable = updates.trackable;
		}

		if (updates.stockCode) {
			newModelJson.stockCode = updates.stockCode;
		}

		if (updates.stockName) {
			newModelJson.stockName = updates.stockName;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.weight) {
			newModelJson.weight = updates.weight;
		}

		if (updates.weightUnit) {
			newModelJson.weightUnit = updates.weightUnit;
		}

		if (updates.volume) {
			newModelJson.volume = updates.volume;
		}

		if (updates.volumeUnit) {
			newModelJson.volumeUnit = updates.volumeUnit;
		}

		if (updates.stockGroup) {
			newModelJson.stockGroup = updates.stockGroup;
		}

		if (updates.stockCategory) {
			newModelJson.stockCategory = updates.stockCategory;
		}

		if (updates.approvalStatus) {
			newModelJson.approvalStatus = updates.approvalStatus;
		}

		if (updates.approvedBy) {
			newModelJson.approvedBy = updates.approvedBy;
		}

		if (updates.approvalDate) {
			newModelJson.approvalDate = updates.approvalDate;
		}

		if (updates.approvalNotes) {
			newModelJson.approvalNotes = updates.approvalNotes;
		}

		if (updates.quantityPerPack) {
			newModelJson.quantityPerPack = updates.quantityPerPack;
		}

		if (updates.uoi) {
			newModelJson.uoi = updates.uoi;
		}

		if (updates.lastBuyingPriceVATExcludeCurrency) {
			newModelJson.lastBuyingPriceVATExcludeCurrency = updates.lastBuyingPriceVATExcludeCurrency;
		}

		if (updates.lastBuyingPriceVATExcludePrice) {
			newModelJson.lastBuyingPriceVATExcludePrice = updates.lastBuyingPriceVATExcludePrice;
		}

		if (updates.lastBuyingPriceVATIncludeCurrency) {
			newModelJson.lastBuyingPriceVATIncludeCurrency = updates.lastBuyingPriceVATIncludeCurrency;
		}

		if (updates.lastBuyingPriceVATIncludePrice) {
			newModelJson.lastBuyingPriceVATIncludePrice = updates.lastBuyingPriceVATIncludePrice;
		}

		if (updates.medicalType) {
			newModelJson.medicalType = updates.medicalType;
		}

		if (updates.stockCategoryVATExcluded) {
			newModelJson.stockCategoryVATExcluded = updates.stockCategoryVATExcluded;
		}

		if (updates.stockCategoryVATIncluded) {
			newModelJson.stockCategoryVATIncluded = updates.stockCategoryVATIncluded;
		}

		if (updates.onHandQty) {
			newModelJson.onHandQty = updates.onHandQty;
		}

		if (updates.averageCost) {
			newModelJson.averageCost = updates.averageCost;
		}

		if (updates.totalCost) {
			newModelJson.totalCost = updates.totalCost;
		}

		if (updates.salesAccount) {
			newModelJson.salesAccount = updates.salesAccount;
		}

		if (updates.inventoryAccount) {
			newModelJson.inventoryAccount = updates.inventoryAccount;
		}

		if (updates.purchaseAccount) {
			newModelJson.purchaseAccount = updates.purchaseAccount;
		}

		if (updates.lupSupplierName) {
			newModelJson.lupSupplierName = updates.lupSupplierName;
		}

		if (updates.lupUnitPrice) {
			newModelJson.lupUnitPrice = updates.lupUnitPrice;
		}

		if (updates.lupDiscount) {
			newModelJson.lupDiscount = updates.lupDiscount;
		}

		if (updates.lupItemPrice) {
			newModelJson.lupItemPrice = updates.lupItemPrice;
		}

		if (updates.lupLastPurchaseDate) {
			newModelJson.lupLastPurchaseDate = updates.lupLastPurchaseDate;
		}

		if (updates.lppSupplierName) {
			newModelJson.lppSupplierName = updates.lppSupplierName;
		}

		if (updates.lppUnitPrice) {
			newModelJson.lppUnitPrice = updates.lppUnitPrice;
		}

		if (updates.lppDiscount) {
			newModelJson.lppDiscount = updates.lppDiscount;
		}

		if (updates.lppItemPrice) {
			newModelJson.lppItemPrice = updates.lppItemPrice;
		}

		if (updates.lppLastPurchaseDate) {
			newModelJson.lppLastPurchaseDate = updates.lppLastPurchaseDate;
		}

		if (updates.stockCatalogueMedicalId) {
			newModelJson.stockCatalogueMedicalId = updates.stockCatalogueMedicalId;
		}

		if (updates.stockCatalogueNonMedicalId) {
			newModelJson.stockCatalogueNonMedicalId = updates.stockCatalogueNonMedicalId;
		}

		if (updates.bpjsDrugGenericPRBId) {
			newModelJson.bpjsDrugGenericPRBId = updates.bpjsDrugGenericPRBId;
		}

		if (updates.bpjsPcareDPHOId) {
			newModelJson.bpjsPcareDPHOId = updates.bpjsPcareDPHOId;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		if (updates.batchStockBalancesCatalogueIds) {
			newModelJson.batchStockBalancesCatalogueIds = updates.batchStockBalancesCatalogueIds;
		}

		if (updates.batchStockBalancesIds) {
			newModelJson.batchStockBalancesIds = updates.batchStockBalancesIds;
		}

		if (updates.batchStockTransactionDetailsIds) {
			newModelJson.batchStockTransactionDetailsIds = updates.batchStockTransactionDetailsIds;
		}

		if (updates.catalogueUOMsIds) {
			newModelJson.catalogueUOMsIds = updates.catalogueUOMsIds;
		}

		if (updates.compoundPrescriptionItemsIds) {
			newModelJson.compoundPrescriptionItemsIds = updates.compoundPrescriptionItemsIds;
		}

		if (updates.goodsReceiveNoteBatchsIds) {
			newModelJson.goodsReceiveNoteBatchsIds = updates.goodsReceiveNoteBatchsIds;
		}

		if (updates.goodsReceiveNoteItemsIds) {
			newModelJson.goodsReceiveNoteItemsIds = updates.goodsReceiveNoteItemsIds;
		}

		if (updates.internalOrderStockDetailsIds) {
			newModelJson.internalOrderStockDetailsIds = updates.internalOrderStockDetailsIds;
		}

		if (updates.inventoryAdjusmentBatchsIds) {
			newModelJson.inventoryAdjusmentBatchsIds = updates.inventoryAdjusmentBatchsIds;
		}

		if (updates.inventoryAdjustmentItemsIds) {
			newModelJson.inventoryAdjustmentItemsIds = updates.inventoryAdjustmentItemsIds;
		}

		if (updates.inventoryBatchCorrectionItemsIds) {
			newModelJson.inventoryBatchCorrectionItemsIds = updates.inventoryBatchCorrectionItemsIds;
		}

		if (updates.medicationItemsIds) {
			newModelJson.medicationItemsIds = updates.medicationItemsIds;
		}

		if (updates.prescriptionItemIds) {
			newModelJson.prescriptionItemIds = updates.prescriptionItemIds;
		}

		if (updates.purchaseOrderStockDetailsIds) {
			newModelJson.purchaseOrderStockDetailsIds = updates.purchaseOrderStockDetailsIds;
		}

		if (updates.purchaseRequisitionStockDetailsIds) {
			newModelJson.purchaseRequisitionStockDetailsIds = updates.purchaseRequisitionStockDetailsIds;
		}

		if (updates.retailPharmacyStockDetailsIds) {
			newModelJson.retailPharmacyStockDetailsIds = updates.retailPharmacyStockDetailsIds;
		}

		if (updates.returnSupplierStockDetailsIds) {
			newModelJson.returnSupplierStockDetailsIds = updates.returnSupplierStockDetailsIds;
		}

		if (updates.stockControlsIds) {
			newModelJson.stockControlsIds = updates.stockControlsIds;
		}

		if (updates.stockTransactionDetailsIds) {
			newModelJson.stockTransactionDetailsIds = updates.stockTransactionDetailsIds;
		}

		if (updates.stockTransactionPerDateTypesIds) {
			newModelJson.stockTransactionPerDateTypesIds = updates.stockTransactionPerDateTypesIds;
		}

		if (updates.stockTransactionPerDatesIds) {
			newModelJson.stockTransactionPerDatesIds = updates.stockTransactionPerDatesIds;
		}

		if (updates.supplierProductDetailsIds) {
			newModelJson.supplierProductDetailsIds = updates.supplierProductDetailsIds;
		}

		if (updates.transferOrderStockDetailsIds) {
			newModelJson.transferOrderStockDetailsIds = updates.transferOrderStockDetailsIds;
		}

		if (updates.vaccinationOrderDetailsIds) {
			newModelJson.vaccinationOrderDetailsIds = updates.vaccinationOrderDetailsIds;
		}

		if (updates.warehouseInitialStockSIds) {
			newModelJson.warehouseInitialStockSIds = updates.warehouseInitialStockSIds;
		}

		if (updates.warehouseInventoriesIds) {
			newModelJson.warehouseInventoriesIds = updates.warehouseInventoriesIds;
		}

		return new StockCatalogueModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof StockCatalogueModel)) {
			return {};
		}

		const diff = {};

		for (const key of _.keys(this)) {
			const thisValue = this[key];
			const otherValue = other[key];

			// Handle dates differently
			if (thisValue instanceof Date) {
				let thisDate = (thisValue) ? thisValue.getTime() : null;
				let otherDate = (otherValue) ? otherValue.getTime() : null;

				if (thisDate !== otherDate) {
					diff[key] = thisValue;
				}
			} else if (thisValue !== otherValue) {
				diff[key] = thisValue;
			}
		}

		return _.omit(diff, [
			'created',
			'modified',
			'stockCatalogueMedicalId',
			'stockCatalogueMedical',
			'stockCatalogueNonMedicalId',
			'stockCatalogueNonMedical',
			'bpjsDrugGenericPRBId',
			'bpjsDrugGenericPRB',
			'bpjsPcareDPHOId',
			'bpjsPcareDPHO',
			'warehouseId',
			'warehouse',
			'batchStockBalancesCatalogueIds',
			'batchStockBalancesCatalogue',
			'batchStockBalancesIds',
			'batchStockBalances',
			'batchStockTransactionDetailsIds',
			'batchStockTransactionDetails',
			'catalogueUOMsIds',
			'catalogueUOMs',
			'compoundPrescriptionItemsIds',
			'compoundPrescriptionItems',
			'goodsReceiveNoteBatchsIds',
			'goodsReceiveNoteBatchs',
			'goodsReceiveNoteItemsIds',
			'goodsReceiveNoteItems',
			'internalOrderStockDetailsIds',
			'internalOrderStockDetails',
			'inventoryAdjusmentBatchsIds',
			'inventoryAdjusmentBatchs',
			'inventoryAdjustmentItemsIds',
			'inventoryAdjustmentItems',
			'inventoryBatchCorrectionItemsIds',
			'inventoryBatchCorrectionItems',
			'medicationItemsIds',
			'medicationItems',
			'prescriptionItemIds',
			'prescriptionItem',
			'purchaseOrderStockDetailsIds',
			'purchaseOrderStockDetails',
			'purchaseRequisitionStockDetailsIds',
			'purchaseRequisitionStockDetails',
			'retailPharmacyStockDetailsIds',
			'retailPharmacyStockDetails',
			'returnSupplierStockDetailsIds',
			'returnSupplierStockDetails',
			'stockControlsIds',
			'stockControls',
			'stockTransactionDetailsIds',
			'stockTransactionDetails',
			'stockTransactionPerDateTypesIds',
			'stockTransactionPerDateTypes',
			'stockTransactionPerDatesIds',
			'stockTransactionPerDates',
			'supplierProductDetailsIds',
			'supplierProductDetails',
			'transferOrderStockDetailsIds',
			'transferOrderStockDetails',
			'vaccinationOrderDetailsIds',
			'vaccinationOrderDetails',
			'warehouseInitialStockSIds',
			'warehouseInitialStockS',
			'warehouseInventoriesIds',
			'warehouseInventories',
			// % protected region % [Add any other fields to omit here] off begin
			// % protected region % [Add any other fields to omit here] end
		]);
	}

	/**
	 * Sets the relation ID parameters to be based on the ID's of the associated entities.
	 * 
	 * Fetching entities is based on the object, but updating relations is based on the id, so we need to
	 * make sure that they match
	 */
	syncRelations() {
		if (!this.stockCatalogueMedical) {
			this.stockCatalogueMedicalId = null;
		} else {
			this.stockCatalogueMedicalId = this.stockCatalogueMedical.id;
		}

		if (!this.stockCatalogueNonMedical) {
			this.stockCatalogueNonMedicalId = null;
		} else {
			this.stockCatalogueNonMedicalId = this.stockCatalogueNonMedical.id;
		}

		if (!this.bpjsDrugGenericPRB) {
			this.bpjsDrugGenericPRBId = null;
		} else {
			this.bpjsDrugGenericPRBId = this.bpjsDrugGenericPRB.id;
		}

		if (!this.bpjsPcareDPHO) {
			this.bpjsPcareDPHOId = null;
		} else {
			this.bpjsPcareDPHOId = this.bpjsPcareDPHO.id;
		}

		if (!this.warehouse) {
			this.warehouseId = null;
		} else {
			this.warehouseId = this.warehouse.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
