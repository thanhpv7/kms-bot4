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
import {PurchaseOrderModel} from '../purchaseOrder/purchase_order.model';
import {ReturnSupplierStockDetailModel} from '../returnSupplierStockDetail/return_supplier_stock_detail.model';
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
export class ReturnSupplierModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'invoiceReturnNumber',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'returnNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ReturnSupplierModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ReturnSupplierModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Return Number.
	 */
	returnNumber: string;

	/**
	 * Approval Status.
	 */
	approvalStatus: string;

	/**
	 * Return Date.
	 */
	returnDate: Date;

	/**
	 * Order Date.
	 */
	orderDate: Date;

	/**
	 * Notes.
	 */
	notes: string;

	/**
	 * Invoice Return Number.
	 */
	invoiceReturnNumber: string;

	/**
	 * Tax Invoice Number.
	 */
	taxInvoiceNumber: string;

	/**
	 * Price VAT Included.
	 */
	priceVATIncluded: boolean = false;

	/**
	 * Void Date.
	 */
	voidDate: Date;

	/**
	 * Void Reason.
	 */
	voidReason: string;

	/**
	 * Sub Total.
	 */
	subTotal: number;

	/**
	 * Extra Discount In Percentage.
	 */
	extraDiscountInPercentage: boolean = false;

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

	purchaseOrderId: string;

	purchaseOrder: PurchaseOrderModel;

	supplierId: string;

	supplier: SupplierModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	returnSupplierStockDetailsIds: string[] = [];

	returnSupplierStockDetails: ReturnSupplierStockDetailModel[];

	modelPropGroups: { [s: string]: Group } = ReturnSupplierModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'returnNumber',
				// % protected region % [Set displayName for Return Number here] off begin
				displayName: 'Return Number',
				// % protected region % [Set displayName for Return Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Return Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Return Number here] end
				// % protected region % [Set isSensitive for Return Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Return Number here] end
				// % protected region % [Set readonly for Return Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Return Number here] end
				validators: [
					// % protected region % [Add other validators for Return Number here] off begin
					// % protected region % [Add other validators for Return Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Return Number here] off begin
				// % protected region % [Add any additional model attribute properties for Return Number here] end
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
				name: 'returnDate',
				// % protected region % [Set displayName for Return Date here] off begin
				displayName: 'Return Date',
				// % protected region % [Set displayName for Return Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Return Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Return Date here] end
				// % protected region % [Set isSensitive for Return Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Return Date here] end
				// % protected region % [Set readonly for Return Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Return Date here] end
				validators: [
					// % protected region % [Add other validators for Return Date here] off begin
					// % protected region % [Add other validators for Return Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Return Date here] off begin
				// % protected region % [Add any additional model attribute properties for Return Date here] end
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
				name: 'invoiceReturnNumber',
				// % protected region % [Set displayName for Invoice Return Number here] off begin
				displayName: 'Invoice Return Number',
				// % protected region % [Set displayName for Invoice Return Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Invoice Return Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Invoice Return Number here] end
				// % protected region % [Set isSensitive for Invoice Return Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Invoice Return Number here] end
				// % protected region % [Set readonly for Invoice Return Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Invoice Return Number here] end
				validators: [
					// % protected region % [Add other validators for Invoice Return Number here] off begin
					// % protected region % [Add other validators for Invoice Return Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Invoice Return Number here] off begin
				// % protected region % [Add any additional model attribute properties for Invoice Return Number here] end
			},
			{
				name: 'taxInvoiceNumber',
				// % protected region % [Set displayName for Tax Invoice Number here] off begin
				displayName: 'Tax Invoice Number',
				// % protected region % [Set displayName for Tax Invoice Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tax Invoice Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tax Invoice Number here] end
				// % protected region % [Set isSensitive for Tax Invoice Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax Invoice Number here] end
				// % protected region % [Set readonly for Tax Invoice Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax Invoice Number here] end
				validators: [
					// % protected region % [Add other validators for Tax Invoice Number here] off begin
					// % protected region % [Add other validators for Tax Invoice Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax Invoice Number here] off begin
				// % protected region % [Add any additional model attribute properties for Tax Invoice Number here] end
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
				name: 'voidDate',
				// % protected region % [Set displayName for Void Date here] off begin
				displayName: 'Void Date',
				// % protected region % [Set displayName for Void Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Void Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Void Date here] end
				// % protected region % [Set isSensitive for Void Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Void Date here] end
				// % protected region % [Set readonly for Void Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Void Date here] end
				validators: [
					// % protected region % [Add other validators for Void Date here] off begin
					// % protected region % [Add other validators for Void Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Void Date here] off begin
				// % protected region % [Add any additional model attribute properties for Void Date here] end
			},
			{
				name: 'voidReason',
				// % protected region % [Set displayName for Void Reason here] off begin
				displayName: 'Void Reason',
				// % protected region % [Set displayName for Void Reason here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Void Reason here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Void Reason here] end
				// % protected region % [Set isSensitive for Void Reason here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Void Reason here] end
				// % protected region % [Set readonly for Void Reason here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Void Reason here] end
				validators: [
					// % protected region % [Add other validators for Void Reason here] off begin
					// % protected region % [Add other validators for Void Reason here] end
				],
				// % protected region % [Add any additional model attribute properties for Void Reason here] off begin
				// % protected region % [Add any additional model attribute properties for Void Reason here] end
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
				name: 'extraDiscountInPercentage',
				// % protected region % [Set displayName for Extra Discount In Percentage here] off begin
				displayName: 'Extra Discount In Percentage',
				// % protected region % [Set displayName for Extra Discount In Percentage here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Extra Discount In Percentage here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Extra Discount In Percentage here] end
				// % protected region % [Set isSensitive for Extra Discount In Percentage here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Extra Discount In Percentage here] end
				// % protected region % [Set readonly for Extra Discount In Percentage here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Extra Discount In Percentage here] end
				validators: [
					// % protected region % [Add other validators for Extra Discount In Percentage here] off begin
					// % protected region % [Add other validators for Extra Discount In Percentage here] end
				],
				// % protected region % [Add any additional model attribute properties for Extra Discount In Percentage here] off begin
				// % protected region % [Add any additional model attribute properties for Extra Discount In Percentage here] end
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
				id: 'purchaseOrder',
				type: ModelRelationType.ONE,
				name: 'purchaseOrderId',
				// % protected region % [Customise your label for Purchase Order here] off begin
				label: 'Purchase Order',
				// % protected region % [Customise your label for Purchase Order here] end
				entityName: 'PurchaseOrderModel',
				// % protected region % [Customise your display name for Purchase Order here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'purchaseOrderType',
				// % protected region % [Customise your display name for Purchase Order here] end
				validators: [
					// % protected region % [Add other validators for Purchase Order here] off begin
					// % protected region % [Add other validators for Purchase Order here] end
				],
				// % protected region % [Add any additional field for relation Purchase Order here] off begin
				// % protected region % [Add any additional field for relation Purchase Order here] end
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
				case 'invoiceReturnNumber':
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
	static deepParse(data: string | { [K in keyof ReturnSupplierModel]?: ReturnSupplierModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ReturnSupplierModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.purchaseOrder) {
			currentModel.purchaseOrderId = json.purchaseOrder.id;
			returned = _.union(returned, PurchaseOrderModel.deepParse(json.purchaseOrder));
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
		if (json.returnSupplierStockDetails) {
			currentModel.returnSupplierStockDetailsIds = json.returnSupplierStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.returnSupplierStockDetails.map(model => ReturnSupplierStockDetailModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let returnSupplierModel = new ReturnSupplierModel(data);`
	 *
	 * @param data The input data to be initialised as the ReturnSupplierModel,
	 *    it is expected as a JSON string or as a nullable ReturnSupplierModel.
	 */
	constructor(data?: string | Partial<ReturnSupplierModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ReturnSupplierModel>
				: data;

			this.returnNumber = json.returnNumber;
			this.approvalStatus = json.approvalStatus;
			if (json.returnDate) {
				this.returnDate = new Date(json.returnDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.returnDate = json.returnDate;
			}
			if (json.orderDate) {
				this.orderDate = new Date(json.orderDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.orderDate = json.orderDate;
			}
			this.notes = json.notes;
			this.invoiceReturnNumber = json.invoiceReturnNumber;
			this.taxInvoiceNumber = json.taxInvoiceNumber;
			this.priceVATIncluded = json.priceVATIncluded;
			if (json.voidDate) {
				this.voidDate = new Date(json.voidDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.voidDate = json.voidDate;
			}
			this.voidReason = json.voidReason;
			this.subTotal = json.subTotal;
			this.extraDiscountInPercentage = json.extraDiscountInPercentage;
			this.extraDiscountIncludeTax = json.extraDiscountIncludeTax;
			this.extraDiscountValue = json.extraDiscountValue;
			this.freightFeeIncludeTax = json.freightFeeIncludeTax;
			this.freightFeeValue = json.freightFeeValue;
			this.otherFeeIncludeTax = json.otherFeeIncludeTax;
			this.otherFeeValue = json.otherFeeValue;
			this.taxBase = json.taxBase;
			this.taxAmount = json.taxAmount;
			this.totalAmount = json.totalAmount;
			this.purchaseOrderId = json.purchaseOrderId;
			this.purchaseOrder = json.purchaseOrder;
			this.supplierId = json.supplierId;
			this.supplier = json.supplier;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			this.returnSupplierStockDetailsIds = json.returnSupplierStockDetailsIds;
			this.returnSupplierStockDetails = json.returnSupplierStockDetails;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			returnNumber: this.returnNumber,
			approvalStatus: this.approvalStatus,
			returnDate: this.returnDate,
			orderDate: this.orderDate,
			notes: this.notes,
			invoiceReturnNumber: this.invoiceReturnNumber,
			taxInvoiceNumber: this.taxInvoiceNumber,
			priceVATIncluded: this.priceVATIncluded,
			voidDate: this.voidDate,
			voidReason: this.voidReason,
			subTotal: this.subTotal,
			extraDiscountInPercentage: this.extraDiscountInPercentage,
			extraDiscountIncludeTax: this.extraDiscountIncludeTax,
			extraDiscountValue: this.extraDiscountValue,
			freightFeeIncludeTax: this.freightFeeIncludeTax,
			freightFeeValue: this.freightFeeValue,
			otherFeeIncludeTax: this.otherFeeIncludeTax,
			otherFeeValue: this.otherFeeValue,
			taxBase: this.taxBase,
			taxAmount: this.taxAmount,
			totalAmount: this.totalAmount,
			purchaseOrderId: this.purchaseOrderId,
			supplierId: this.supplierId,
			warehouseId: this.warehouseId,
			returnSupplierStockDetailsIds: this.returnSupplierStockDetailsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ReturnSupplierModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ReturnSupplierModel {
		let newModelJson = this.toJSON();

		if (updates.returnNumber) {
			newModelJson.returnNumber = updates.returnNumber;
		}

		if (updates.approvalStatus) {
			newModelJson.approvalStatus = updates.approvalStatus;
		}

		if (updates.returnDate) {
			newModelJson.returnDate = updates.returnDate;
		}

		if (updates.orderDate) {
			newModelJson.orderDate = updates.orderDate;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.invoiceReturnNumber) {
			newModelJson.invoiceReturnNumber = updates.invoiceReturnNumber;
		}

		if (updates.taxInvoiceNumber) {
			newModelJson.taxInvoiceNumber = updates.taxInvoiceNumber;
		}

		if (updates.priceVATIncluded) {
			newModelJson.priceVATIncluded = updates.priceVATIncluded;
		}

		if (updates.voidDate) {
			newModelJson.voidDate = updates.voidDate;
		}

		if (updates.voidReason) {
			newModelJson.voidReason = updates.voidReason;
		}

		if (updates.subTotal) {
			newModelJson.subTotal = updates.subTotal;
		}

		if (updates.extraDiscountInPercentage) {
			newModelJson.extraDiscountInPercentage = updates.extraDiscountInPercentage;
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

		if (updates.purchaseOrderId) {
			newModelJson.purchaseOrderId = updates.purchaseOrderId;
		}

		if (updates.supplierId) {
			newModelJson.supplierId = updates.supplierId;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		if (updates.returnSupplierStockDetailsIds) {
			newModelJson.returnSupplierStockDetailsIds = updates.returnSupplierStockDetailsIds;
		}

		return new ReturnSupplierModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ReturnSupplierModel)) {
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
			'purchaseOrderId',
			'purchaseOrder',
			'supplierId',
			'supplier',
			'warehouseId',
			'warehouse',
			'returnSupplierStockDetailsIds',
			'returnSupplierStockDetails',
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
		if (!this.purchaseOrder) {
			this.purchaseOrderId = null;
		} else {
			this.purchaseOrderId = this.purchaseOrder.id;
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
