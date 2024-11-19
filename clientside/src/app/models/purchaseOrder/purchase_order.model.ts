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
import {GoodsReceiveNoteModel} from '../goodsReceiveNote/goods_receive_note.model';
import {PurchaseOrderStockDetailModel} from '../purchaseOrderStockDetail/purchase_order_stock_detail.model';
import {PurchaseRequisitionModel} from '../purchaseRequisition/purchase_requisition.model';
import {ReturnSupplierModel} from '../returnSupplier/return_supplier.model';
import {SupplierModel} from '../supplier/supplier.model';
import {WarehouseModel} from '../warehouse/warehouse.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class PurchaseOrderModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'purchaseOrderType',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'purchaseOrderType',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PurchaseOrderModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PurchaseOrderModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Purchase Order Type.
	 */
	purchaseOrderType: string;

	/**
	 * Purchase Order Number.
	 */
	purchaseOrderNumber: string;

	/**
	 * status.
	 */
	status: string;

	/**
	 * Supply Stock Group.
	 */
	supplyStockGroup: string;

	/**
	 * Order Date.
	 */
	orderDate: Date;

	/**
	 * Expected Date.
	 */
	expectedDate: Date;

	/**
	 * Price VAT Included.
	 */
	priceVATIncluded: boolean = false;

	/**
	 * Inventory VAT Included.
	 */
	inventoryVATIncluded: boolean = false;

	/**
	 * Reference Document.
	 */
	referenceDocument: string;

	/**
	 * Supplier Reference Document.
	 */
	supplierReferenceDocument: string;

	/**
	 * Payment Terms.
	 */
	paymentTerms: string;

	/**
	 * Shipping Method.
	 */
	shippingMethod: string;

	/**
	 * Notes.
	 */
	notes: string;

	/**
	 * Sub Total.
	 */
	subTotal: number;

	/**
	 * Extra Discount In Percent.
	 */
	extraDiscountInPercent: boolean = false;

	/**
	 * Extra Discount Include Tax.
	 */
	extraDiscountIncludeTax: boolean = false;

	/**
	 * Extra Discount Value.
	 */
	extraDiscountValue: number;

	/**
	 * Freight Fee Include Tax.
	 */
	freightFeeIncludeTax: boolean = false;

	/**
	 * Freight Fee Value.
	 */
	freightFeeValue: number;

	/**
	 * Other Fee Include Tax.
	 */
	otherFeeIncludeTax: boolean = false;

	/**
	 * Other Fee Value.
	 */
	otherFeeValue: number;

	/**
	 * Tax Base.
	 */
	taxBase: number;

	/**
	 * Tax Amount.
	 */
	taxAmount: number;

	/**
	 * Total Amount.
	 */
	totalAmount: number;

	goodsReceiveNoteId: string;

	goodsReceiveNote: GoodsReceiveNoteModel;

	supplierId: string;

	supplier: SupplierModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	purchaseOrderStockDetailsIds: string[] = [];

	purchaseOrderStockDetails: PurchaseOrderStockDetailModel[];

	purchaseRequisitionsIds: string[] = [];

	purchaseRequisitions: PurchaseRequisitionModel[];

	returnSuppliersIds: string[] = [];

	returnSuppliers: ReturnSupplierModel[];

	modelPropGroups: { [s: string]: Group } = PurchaseOrderModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'purchaseOrderType',
				// % protected region % [Set displayName for Purchase Order Type here] off begin
				displayName: 'Purchase Order Type',
				// % protected region % [Set displayName for Purchase Order Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Purchase Order Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Purchase Order Type here] end
				// % protected region % [Set isSensitive for Purchase Order Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Purchase Order Type here] end
				// % protected region % [Set readonly for Purchase Order Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Purchase Order Type here] end
				validators: [
					// % protected region % [Add other validators for Purchase Order Type here] off begin
					// % protected region % [Add other validators for Purchase Order Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Purchase Order Type here] off begin
				// % protected region % [Add any additional model attribute properties for Purchase Order Type here] end
			},
			{
				name: 'purchaseOrderNumber',
				// % protected region % [Set displayName for Purchase Order Number here] off begin
				displayName: 'Purchase Order Number',
				// % protected region % [Set displayName for Purchase Order Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Purchase Order Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Purchase Order Number here] end
				// % protected region % [Set isSensitive for Purchase Order Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Purchase Order Number here] end
				// % protected region % [Set readonly for Purchase Order Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Purchase Order Number here] end
				validators: [
					// % protected region % [Add other validators for Purchase Order Number here] off begin
					// % protected region % [Add other validators for Purchase Order Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Purchase Order Number here] off begin
				// % protected region % [Add any additional model attribute properties for Purchase Order Number here] end
			},
			{
				name: 'status',
				// % protected region % [Set displayName for status here] off begin
				displayName: 'status',
				// % protected region % [Set displayName for status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for status here] end
				// % protected region % [Set isSensitive for status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for status here] end
				// % protected region % [Set readonly for status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for status here] end
				validators: [
					// % protected region % [Add other validators for status here] off begin
					// % protected region % [Add other validators for status here] end
				],
				// % protected region % [Add any additional model attribute properties for status here] off begin
				// % protected region % [Add any additional model attribute properties for status here] end
			},
			{
				name: 'supplyStockGroup',
				// % protected region % [Set displayName for Supply Stock Group here] off begin
				displayName: 'Supply Stock Group',
				// % protected region % [Set displayName for Supply Stock Group here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Supply Stock Group here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Supply Stock Group here] end
				// % protected region % [Set isSensitive for Supply Stock Group here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Supply Stock Group here] end
				// % protected region % [Set readonly for Supply Stock Group here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Supply Stock Group here] end
				validators: [
					// % protected region % [Add other validators for Supply Stock Group here] off begin
					// % protected region % [Add other validators for Supply Stock Group here] end
				],
				// % protected region % [Add any additional model attribute properties for Supply Stock Group here] off begin
				// % protected region % [Add any additional model attribute properties for Supply Stock Group here] end
			},
			{
				name: 'orderDate',
				// % protected region % [Set displayName for Order Date here] off begin
				displayName: 'Order Date',
				// % protected region % [Set displayName for Order Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Order Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Order Date here] end
				// % protected region % [Set isSensitive for Order Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Order Date here] end
				// % protected region % [Set readonly for Order Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Order Date here] end
				validators: [
					// % protected region % [Add other validators for Order Date here] off begin
					// % protected region % [Add other validators for Order Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Order Date here] off begin
				// % protected region % [Add any additional model attribute properties for Order Date here] end
			},
			{
				name: 'expectedDate',
				// % protected region % [Set displayName for Expected Date here] off begin
				displayName: 'Expected Date',
				// % protected region % [Set displayName for Expected Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Expected Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Expected Date here] end
				// % protected region % [Set isSensitive for Expected Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Expected Date here] end
				// % protected region % [Set readonly for Expected Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Expected Date here] end
				validators: [
					// % protected region % [Add other validators for Expected Date here] off begin
					// % protected region % [Add other validators for Expected Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Expected Date here] off begin
				// % protected region % [Add any additional model attribute properties for Expected Date here] end
			},
			{
				name: 'priceVATIncluded',
				// % protected region % [Set displayName for Price VAT Included here] off begin
				displayName: 'Price VAT Included',
				// % protected region % [Set displayName for Price VAT Included here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Price VAT Included here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Price VAT Included here] end
				// % protected region % [Set isSensitive for Price VAT Included here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Price VAT Included here] end
				// % protected region % [Set readonly for Price VAT Included here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Price VAT Included here] end
				validators: [
					// % protected region % [Add other validators for Price VAT Included here] off begin
					// % protected region % [Add other validators for Price VAT Included here] end
				],
				// % protected region % [Add any additional model attribute properties for Price VAT Included here] off begin
				// % protected region % [Add any additional model attribute properties for Price VAT Included here] end
			},
			{
				name: 'inventoryVATIncluded',
				// % protected region % [Set displayName for Inventory VAT Included here] off begin
				displayName: 'Inventory VAT Included',
				// % protected region % [Set displayName for Inventory VAT Included here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inventory VAT Included here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inventory VAT Included here] end
				// % protected region % [Set isSensitive for Inventory VAT Included here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inventory VAT Included here] end
				// % protected region % [Set readonly for Inventory VAT Included here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inventory VAT Included here] end
				validators: [
					// % protected region % [Add other validators for Inventory VAT Included here] off begin
					// % protected region % [Add other validators for Inventory VAT Included here] end
				],
				// % protected region % [Add any additional model attribute properties for Inventory VAT Included here] off begin
				// % protected region % [Add any additional model attribute properties for Inventory VAT Included here] end
			},
			{
				name: 'referenceDocument',
				// % protected region % [Set displayName for Reference Document here] off begin
				displayName: 'Reference Document',
				// % protected region % [Set displayName for Reference Document here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Reference Document here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Reference Document here] end
				// % protected region % [Set isSensitive for Reference Document here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Reference Document here] end
				// % protected region % [Set readonly for Reference Document here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Reference Document here] end
				validators: [
					// % protected region % [Add other validators for Reference Document here] off begin
					// % protected region % [Add other validators for Reference Document here] end
				],
				// % protected region % [Add any additional model attribute properties for Reference Document here] off begin
				// % protected region % [Add any additional model attribute properties for Reference Document here] end
			},
			{
				name: 'supplierReferenceDocument',
				// % protected region % [Set displayName for Supplier Reference Document here] off begin
				displayName: 'Supplier Reference Document',
				// % protected region % [Set displayName for Supplier Reference Document here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Supplier Reference Document here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Supplier Reference Document here] end
				// % protected region % [Set isSensitive for Supplier Reference Document here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Supplier Reference Document here] end
				// % protected region % [Set readonly for Supplier Reference Document here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Supplier Reference Document here] end
				validators: [
					// % protected region % [Add other validators for Supplier Reference Document here] off begin
					// % protected region % [Add other validators for Supplier Reference Document here] end
				],
				// % protected region % [Add any additional model attribute properties for Supplier Reference Document here] off begin
				// % protected region % [Add any additional model attribute properties for Supplier Reference Document here] end
			},
			{
				name: 'paymentTerms',
				// % protected region % [Set displayName for Payment Terms here] off begin
				displayName: 'Payment Terms',
				// % protected region % [Set displayName for Payment Terms here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Payment Terms here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Payment Terms here] end
				// % protected region % [Set isSensitive for Payment Terms here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Payment Terms here] end
				// % protected region % [Set readonly for Payment Terms here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Payment Terms here] end
				validators: [
					// % protected region % [Add other validators for Payment Terms here] off begin
					// % protected region % [Add other validators for Payment Terms here] end
				],
				// % protected region % [Add any additional model attribute properties for Payment Terms here] off begin
				// % protected region % [Add any additional model attribute properties for Payment Terms here] end
			},
			{
				name: 'shippingMethod',
				// % protected region % [Set displayName for Shipping Method here] off begin
				displayName: 'Shipping Method',
				// % protected region % [Set displayName for Shipping Method here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Shipping Method here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Shipping Method here] end
				// % protected region % [Set isSensitive for Shipping Method here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Shipping Method here] end
				// % protected region % [Set readonly for Shipping Method here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Shipping Method here] end
				validators: [
					// % protected region % [Add other validators for Shipping Method here] off begin
					// % protected region % [Add other validators for Shipping Method here] end
				],
				// % protected region % [Add any additional model attribute properties for Shipping Method here] off begin
				// % protected region % [Add any additional model attribute properties for Shipping Method here] end
			},
			{
				name: 'notes',
				// % protected region % [Set displayName for Notes here] off begin
				displayName: 'Notes',
				// % protected region % [Set displayName for Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Notes here] end
				// % protected region % [Set isSensitive for Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Notes here] end
				// % protected region % [Set readonly for Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Notes here] end
				validators: [
					// % protected region % [Add other validators for Notes here] off begin
					// % protected region % [Add other validators for Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Notes here] end
			},
			{
				name: 'subTotal',
				// % protected region % [Set displayName for Sub Total here] off begin
				displayName: 'Sub Total',
				// % protected region % [Set displayName for Sub Total here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Sub Total here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Sub Total here] end
				// % protected region % [Set isSensitive for Sub Total here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sub Total here] end
				// % protected region % [Set readonly for Sub Total here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sub Total here] end
				validators: [
					// % protected region % [Add other validators for Sub Total here] off begin
					// % protected region % [Add other validators for Sub Total here] end
				],
				// % protected region % [Add any additional model attribute properties for Sub Total here] off begin
				// % protected region % [Add any additional model attribute properties for Sub Total here] end
			},
			{
				name: 'extraDiscountInPercent',
				// % protected region % [Set displayName for Extra Discount In Percent here] off begin
				displayName: 'Extra Discount In Percent',
				// % protected region % [Set displayName for Extra Discount In Percent here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Extra Discount In Percent here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Extra Discount In Percent here] end
				// % protected region % [Set isSensitive for Extra Discount In Percent here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Extra Discount In Percent here] end
				// % protected region % [Set readonly for Extra Discount In Percent here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Extra Discount In Percent here] end
				validators: [
					// % protected region % [Add other validators for Extra Discount In Percent here] off begin
					// % protected region % [Add other validators for Extra Discount In Percent here] end
				],
				// % protected region % [Add any additional model attribute properties for Extra Discount In Percent here] off begin
				// % protected region % [Add any additional model attribute properties for Extra Discount In Percent here] end
			},
			{
				name: 'extraDiscountIncludeTax',
				// % protected region % [Set displayName for Extra Discount Include Tax here] off begin
				displayName: 'Extra Discount Include Tax',
				// % protected region % [Set displayName for Extra Discount Include Tax here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Extra Discount Include Tax here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Extra Discount Include Tax here] end
				// % protected region % [Set isSensitive for Extra Discount Include Tax here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Extra Discount Include Tax here] end
				// % protected region % [Set readonly for Extra Discount Include Tax here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Extra Discount Include Tax here] end
				validators: [
					// % protected region % [Add other validators for Extra Discount Include Tax here] off begin
					// % protected region % [Add other validators for Extra Discount Include Tax here] end
				],
				// % protected region % [Add any additional model attribute properties for Extra Discount Include Tax here] off begin
				// % protected region % [Add any additional model attribute properties for Extra Discount Include Tax here] end
			},
			{
				name: 'extraDiscountValue',
				// % protected region % [Set displayName for Extra Discount Value here] off begin
				displayName: 'Extra Discount Value',
				// % protected region % [Set displayName for Extra Discount Value here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Extra Discount Value here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Extra Discount Value here] end
				// % protected region % [Set isSensitive for Extra Discount Value here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Extra Discount Value here] end
				// % protected region % [Set readonly for Extra Discount Value here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Extra Discount Value here] end
				validators: [
					// % protected region % [Add other validators for Extra Discount Value here] off begin
					// % protected region % [Add other validators for Extra Discount Value here] end
				],
				// % protected region % [Add any additional model attribute properties for Extra Discount Value here] off begin
				// % protected region % [Add any additional model attribute properties for Extra Discount Value here] end
			},
			{
				name: 'freightFeeIncludeTax',
				// % protected region % [Set displayName for Freight Fee Include Tax here] off begin
				displayName: 'Freight Fee Include Tax',
				// % protected region % [Set displayName for Freight Fee Include Tax here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Freight Fee Include Tax here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Freight Fee Include Tax here] end
				// % protected region % [Set isSensitive for Freight Fee Include Tax here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Freight Fee Include Tax here] end
				// % protected region % [Set readonly for Freight Fee Include Tax here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Freight Fee Include Tax here] end
				validators: [
					// % protected region % [Add other validators for Freight Fee Include Tax here] off begin
					// % protected region % [Add other validators for Freight Fee Include Tax here] end
				],
				// % protected region % [Add any additional model attribute properties for Freight Fee Include Tax here] off begin
				// % protected region % [Add any additional model attribute properties for Freight Fee Include Tax here] end
			},
			{
				name: 'freightFeeValue',
				// % protected region % [Set displayName for Freight Fee Value here] off begin
				displayName: 'Freight Fee Value',
				// % protected region % [Set displayName for Freight Fee Value here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Freight Fee Value here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Freight Fee Value here] end
				// % protected region % [Set isSensitive for Freight Fee Value here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Freight Fee Value here] end
				// % protected region % [Set readonly for Freight Fee Value here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Freight Fee Value here] end
				validators: [
					// % protected region % [Add other validators for Freight Fee Value here] off begin
					// % protected region % [Add other validators for Freight Fee Value here] end
				],
				// % protected region % [Add any additional model attribute properties for Freight Fee Value here] off begin
				// % protected region % [Add any additional model attribute properties for Freight Fee Value here] end
			},
			{
				name: 'otherFeeIncludeTax',
				// % protected region % [Set displayName for Other Fee Include Tax here] off begin
				displayName: 'Other Fee Include Tax',
				// % protected region % [Set displayName for Other Fee Include Tax here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Other Fee Include Tax here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Other Fee Include Tax here] end
				// % protected region % [Set isSensitive for Other Fee Include Tax here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Fee Include Tax here] end
				// % protected region % [Set readonly for Other Fee Include Tax here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Fee Include Tax here] end
				validators: [
					// % protected region % [Add other validators for Other Fee Include Tax here] off begin
					// % protected region % [Add other validators for Other Fee Include Tax here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Fee Include Tax here] off begin
				// % protected region % [Add any additional model attribute properties for Other Fee Include Tax here] end
			},
			{
				name: 'otherFeeValue',
				// % protected region % [Set displayName for Other Fee Value here] off begin
				displayName: 'Other Fee Value',
				// % protected region % [Set displayName for Other Fee Value here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Other Fee Value here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Other Fee Value here] end
				// % protected region % [Set isSensitive for Other Fee Value here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Fee Value here] end
				// % protected region % [Set readonly for Other Fee Value here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Fee Value here] end
				validators: [
					// % protected region % [Add other validators for Other Fee Value here] off begin
					// % protected region % [Add other validators for Other Fee Value here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Fee Value here] off begin
				// % protected region % [Add any additional model attribute properties for Other Fee Value here] end
			},
			{
				name: 'taxBase',
				// % protected region % [Set displayName for Tax Base here] off begin
				displayName: 'Tax Base',
				// % protected region % [Set displayName for Tax Base here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Tax Base here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Tax Base here] end
				// % protected region % [Set isSensitive for Tax Base here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax Base here] end
				// % protected region % [Set readonly for Tax Base here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax Base here] end
				validators: [
					// % protected region % [Add other validators for Tax Base here] off begin
					// % protected region % [Add other validators for Tax Base here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax Base here] off begin
				// % protected region % [Add any additional model attribute properties for Tax Base here] end
			},
			{
				name: 'taxAmount',
				// % protected region % [Set displayName for Tax Amount here] off begin
				displayName: 'Tax Amount',
				// % protected region % [Set displayName for Tax Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Tax Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Tax Amount here] end
				// % protected region % [Set isSensitive for Tax Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax Amount here] end
				// % protected region % [Set readonly for Tax Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax Amount here] end
				validators: [
					// % protected region % [Add other validators for Tax Amount here] off begin
					// % protected region % [Add other validators for Tax Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Tax Amount here] end
			},
			{
				name: 'totalAmount',
				// % protected region % [Set displayName for Total Amount here] off begin
				displayName: 'Total Amount',
				// % protected region % [Set displayName for Total Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Amount here] end
				// % protected region % [Set isSensitive for Total Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Amount here] end
				// % protected region % [Set readonly for Total Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Amount here] end
				validators: [
					// % protected region % [Add other validators for Total Amount here] off begin
					// % protected region % [Add other validators for Total Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Total Amount here] end
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
				id: 'purchaseRequisitions',
				type: ModelRelationType.MANY,
				name: 'purchaseRequisitionsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Requisitions here] off begin
				label: 'Purchase Requisitions',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Requisitions here] end
				entityName: 'PurchaseRequisitionModel',
				// % protected region % [Customise your display name for Purchase Requisitions here] off begin
				displayName: 'purchaseRequisitionNumber',
				// % protected region % [Customise your display name for Purchase Requisitions here] end
				validators: [
					// % protected region % [Add other validators for Purchase Requisitions here] off begin
					// % protected region % [Add other validators for Purchase Requisitions here] end
				],
				// % protected region % [Add any additional field for relation Purchase Requisitions here] off begin
				// % protected region % [Add any additional field for relation Purchase Requisitions here] end
			},
			{
				id: 'returnSuppliers',
				type: ModelRelationType.MANY,
				name: 'returnSuppliersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Return Suppliers here] off begin
				label: 'Return Suppliers',
				// % protected region % [Customise your 1-1 or 1-M label for Return Suppliers here] end
				entityName: 'ReturnSupplierModel',
				// % protected region % [Customise your display name for Return Suppliers here] off begin
				displayName: 'returnNumber',
				// % protected region % [Customise your display name for Return Suppliers here] end
				validators: [
					// % protected region % [Add other validators for Return Suppliers here] off begin
					// % protected region % [Add other validators for Return Suppliers here] end
				],
				// % protected region % [Add any additional field for relation Return Suppliers here] off begin
				// % protected region % [Add any additional field for relation Return Suppliers here] end
			},
			{
				id: 'goodsReceiveNote',
				type: ModelRelationType.ONE,
				name: 'goodsReceiveNoteId',
				// % protected region % [Customise your label for Goods Receive Note here] off begin
				label: 'Goods Receive Note',
				// % protected region % [Customise your label for Goods Receive Note here] end
				entityName: 'GoodsReceiveNoteModel',
				// % protected region % [Customise your display name for Goods Receive Note here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'receiveNumber',
				// % protected region % [Customise your display name for Goods Receive Note here] end
				validators: [
					// % protected region % [Add other validators for Goods Receive Note here] off begin
					// % protected region % [Add other validators for Goods Receive Note here] end
				],
				// % protected region % [Add any additional field for relation Goods Receive Note here] off begin
				// % protected region % [Add any additional field for relation Goods Receive Note here] end
			},
			{
				id: 'supplier',
				type: ModelRelationType.ONE,
				name: 'supplierId',
				// % protected region % [Customise your label for Supplier here] off begin
				label: 'Supplier',
				// % protected region % [Customise your label for Supplier here] end
				entityName: 'SupplierModel',
				// % protected region % [Customise your display name for Supplier here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'supplierNumber',
				// % protected region % [Customise your display name for Supplier here] end
				validators: [
					// % protected region % [Add other validators for Supplier here] off begin
					// % protected region % [Add other validators for Supplier here] end
				],
				// % protected region % [Add any additional field for relation Supplier here] off begin
				// % protected region % [Add any additional field for relation Supplier here] end
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
				case 'purchaseOrderType':
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
	static deepParse(data: string | { [K in keyof PurchaseOrderModel]?: PurchaseOrderModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PurchaseOrderModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.goodsReceiveNote) {
			currentModel.goodsReceiveNoteId = json.goodsReceiveNote.id;
			returned = _.union(returned, GoodsReceiveNoteModel.deepParse(json.goodsReceiveNote));
		}

		// Incoming one to many
		if (json.supplier) {
			currentModel.supplierId = json.supplier.id;
			returned = _.union(returned, SupplierModel.deepParse(json.supplier));
		}

		// Incoming one to many
		if (json.warehouse) {
			currentModel.warehouseId = json.warehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.warehouse));
		}

		// Outgoing one to many
		if (json.purchaseOrderStockDetails) {
			currentModel.purchaseOrderStockDetailsIds = json.purchaseOrderStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.purchaseOrderStockDetails.map(model => PurchaseOrderStockDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.purchaseRequisitions) {
			currentModel.purchaseRequisitionsIds = json.purchaseRequisitions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.purchaseRequisitions.map(model => PurchaseRequisitionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.returnSuppliers) {
			currentModel.returnSuppliersIds = json.returnSuppliers.map(model => model.id);
			returned = _.union(returned, _.flatten(json.returnSuppliers.map(model => ReturnSupplierModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let purchaseOrderModel = new PurchaseOrderModel(data);`
	 *
	 * @param data The input data to be initialised as the PurchaseOrderModel,
	 *    it is expected as a JSON string or as a nullable PurchaseOrderModel.
	 */
	constructor(data?: string | Partial<PurchaseOrderModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PurchaseOrderModel>
				: data;

			this.purchaseOrderType = json.purchaseOrderType;
			this.purchaseOrderNumber = json.purchaseOrderNumber;
			this.status = json.status;
			this.supplyStockGroup = json.supplyStockGroup;
			if (json.orderDate) {
				this.orderDate = new Date(json.orderDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.orderDate = json.orderDate;
			}
			if (json.expectedDate) {
				this.expectedDate = new Date(json.expectedDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.expectedDate = json.expectedDate;
			}
			this.priceVATIncluded = json.priceVATIncluded;
			this.inventoryVATIncluded = json.inventoryVATIncluded;
			this.referenceDocument = json.referenceDocument;
			this.supplierReferenceDocument = json.supplierReferenceDocument;
			this.paymentTerms = json.paymentTerms;
			this.shippingMethod = json.shippingMethod;
			this.notes = json.notes;
			this.subTotal = json.subTotal;
			this.extraDiscountInPercent = json.extraDiscountInPercent;
			this.extraDiscountIncludeTax = json.extraDiscountIncludeTax;
			this.extraDiscountValue = json.extraDiscountValue;
			this.freightFeeIncludeTax = json.freightFeeIncludeTax;
			this.freightFeeValue = json.freightFeeValue;
			this.otherFeeIncludeTax = json.otherFeeIncludeTax;
			this.otherFeeValue = json.otherFeeValue;
			this.taxBase = json.taxBase;
			this.taxAmount = json.taxAmount;
			this.totalAmount = json.totalAmount;
			this.goodsReceiveNoteId = json.goodsReceiveNoteId;
			this.goodsReceiveNote = json.goodsReceiveNote;
			this.supplierId = json.supplierId;
			this.supplier = json.supplier;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			this.purchaseOrderStockDetailsIds = json.purchaseOrderStockDetailsIds;
			this.purchaseOrderStockDetails = json.purchaseOrderStockDetails;
			this.purchaseRequisitionsIds = json.purchaseRequisitionsIds;
			this.purchaseRequisitions = json.purchaseRequisitions;
			this.returnSuppliersIds = json.returnSuppliersIds;
			this.returnSuppliers = json.returnSuppliers;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			purchaseOrderType: this.purchaseOrderType,
			purchaseOrderNumber: this.purchaseOrderNumber,
			status: this.status,
			supplyStockGroup: this.supplyStockGroup,
			orderDate: this.orderDate,
			expectedDate: this.expectedDate,
			priceVATIncluded: this.priceVATIncluded,
			inventoryVATIncluded: this.inventoryVATIncluded,
			referenceDocument: this.referenceDocument,
			supplierReferenceDocument: this.supplierReferenceDocument,
			paymentTerms: this.paymentTerms,
			shippingMethod: this.shippingMethod,
			notes: this.notes,
			subTotal: this.subTotal,
			extraDiscountInPercent: this.extraDiscountInPercent,
			extraDiscountIncludeTax: this.extraDiscountIncludeTax,
			extraDiscountValue: this.extraDiscountValue,
			freightFeeIncludeTax: this.freightFeeIncludeTax,
			freightFeeValue: this.freightFeeValue,
			otherFeeIncludeTax: this.otherFeeIncludeTax,
			otherFeeValue: this.otherFeeValue,
			taxBase: this.taxBase,
			taxAmount: this.taxAmount,
			totalAmount: this.totalAmount,
			goodsReceiveNoteId: this.goodsReceiveNoteId,
			supplierId: this.supplierId,
			warehouseId: this.warehouseId,
			purchaseOrderStockDetailsIds: this.purchaseOrderStockDetailsIds,
			purchaseRequisitionsIds: this.purchaseRequisitionsIds,
			returnSuppliersIds: this.returnSuppliersIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PurchaseOrderModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PurchaseOrderModel {
		let newModelJson = this.toJSON();

		if (updates.purchaseOrderType) {
			newModelJson.purchaseOrderType = updates.purchaseOrderType;
		}

		if (updates.purchaseOrderNumber) {
			newModelJson.purchaseOrderNumber = updates.purchaseOrderNumber;
		}

		if (updates.status) {
			newModelJson.status = updates.status;
		}

		if (updates.supplyStockGroup) {
			newModelJson.supplyStockGroup = updates.supplyStockGroup;
		}

		if (updates.orderDate) {
			newModelJson.orderDate = updates.orderDate;
		}

		if (updates.expectedDate) {
			newModelJson.expectedDate = updates.expectedDate;
		}

		if (updates.priceVATIncluded) {
			newModelJson.priceVATIncluded = updates.priceVATIncluded;
		}

		if (updates.inventoryVATIncluded) {
			newModelJson.inventoryVATIncluded = updates.inventoryVATIncluded;
		}

		if (updates.referenceDocument) {
			newModelJson.referenceDocument = updates.referenceDocument;
		}

		if (updates.supplierReferenceDocument) {
			newModelJson.supplierReferenceDocument = updates.supplierReferenceDocument;
		}

		if (updates.paymentTerms) {
			newModelJson.paymentTerms = updates.paymentTerms;
		}

		if (updates.shippingMethod) {
			newModelJson.shippingMethod = updates.shippingMethod;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.subTotal) {
			newModelJson.subTotal = updates.subTotal;
		}

		if (updates.extraDiscountInPercent) {
			newModelJson.extraDiscountInPercent = updates.extraDiscountInPercent;
		}

		if (updates.extraDiscountIncludeTax) {
			newModelJson.extraDiscountIncludeTax = updates.extraDiscountIncludeTax;
		}

		if (updates.extraDiscountValue) {
			newModelJson.extraDiscountValue = updates.extraDiscountValue;
		}

		if (updates.freightFeeIncludeTax) {
			newModelJson.freightFeeIncludeTax = updates.freightFeeIncludeTax;
		}

		if (updates.freightFeeValue) {
			newModelJson.freightFeeValue = updates.freightFeeValue;
		}

		if (updates.otherFeeIncludeTax) {
			newModelJson.otherFeeIncludeTax = updates.otherFeeIncludeTax;
		}

		if (updates.otherFeeValue) {
			newModelJson.otherFeeValue = updates.otherFeeValue;
		}

		if (updates.taxBase) {
			newModelJson.taxBase = updates.taxBase;
		}

		if (updates.taxAmount) {
			newModelJson.taxAmount = updates.taxAmount;
		}

		if (updates.totalAmount) {
			newModelJson.totalAmount = updates.totalAmount;
		}

		if (updates.goodsReceiveNoteId) {
			newModelJson.goodsReceiveNoteId = updates.goodsReceiveNoteId;
		}

		if (updates.supplierId) {
			newModelJson.supplierId = updates.supplierId;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		if (updates.purchaseOrderStockDetailsIds) {
			newModelJson.purchaseOrderStockDetailsIds = updates.purchaseOrderStockDetailsIds;
		}

		if (updates.purchaseRequisitionsIds) {
			newModelJson.purchaseRequisitionsIds = updates.purchaseRequisitionsIds;
		}

		if (updates.returnSuppliersIds) {
			newModelJson.returnSuppliersIds = updates.returnSuppliersIds;
		}

		return new PurchaseOrderModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PurchaseOrderModel)) {
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
			'goodsReceiveNoteId',
			'goodsReceiveNote',
			'supplierId',
			'supplier',
			'warehouseId',
			'warehouse',
			'purchaseOrderStockDetailsIds',
			'purchaseOrderStockDetails',
			'purchaseRequisitionsIds',
			'purchaseRequisitions',
			'returnSuppliersIds',
			'returnSuppliers',
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
		if (!this.goodsReceiveNote) {
			this.goodsReceiveNoteId = null;
		} else {
			this.goodsReceiveNoteId = this.goodsReceiveNote.id;
		}

		if (!this.supplier) {
			this.supplierId = null;
		} else {
			this.supplierId = this.supplier.id;
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
