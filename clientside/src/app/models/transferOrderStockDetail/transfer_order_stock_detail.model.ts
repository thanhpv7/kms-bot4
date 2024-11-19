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
import {StaffModel} from '../staff/staff.model';
import {StockCatalogueModel} from '../stockCatalogue/stock_catalogue.model';
import {TransferOrderModel} from '../transferOrder/transfer_order.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class TransferOrderStockDetailModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'itemNumber',
		'sourceAvailableQuantity',
		'destinationSOH',
		'quantityOrdered',
		'uom',
		'transactionStatus',
		'quantityIssued',
		'quantityReceived',
		'sourceMinLevel',
		'destinationMaxLevel',
		'quantityTransferred',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'itemNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'TransferOrderStockDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return TransferOrderStockDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Item Number.
	 */
	itemNumber: number;

	/**
	 * Source Available Quantity.
	 */
	sourceAvailableQuantity: number;

	/**
	 * Destination SOH.
	 */
	destinationSOH: number;

	/**
	 * Quantity Ordered.
	 */
	quantityOrdered: number;

	/**
	 * uom.
	 */
	uom: string;

	/**
	 * Transaction Status.
	 */
	transactionStatus: string;

	/**
	 * Quantity Issued.
	 */
	quantityIssued: number;

	/**
	 * Quantity Received.
	 */
	quantityReceived: number;

	/**
	 * Source Min Level.
	 */
	sourceMinLevel: number;

	/**
	 * Destination Max Level.
	 */
	destinationMaxLevel: number;

	/**
	 * Quantity Transferred.
	 */
	quantityTransferred: number;

	/**
	 * Quantity Fulfilled.
	 */
	quantityFulfilled: number;

	/**
	 * Order Date Time.
	 */
	orderDateTime: Date;

	/**
	 * Item Notes.
	 */
	itemNotes: string;

	/**
	 * Inventory Rounding Value.
	 */
	inventoryRoundingValue: number;

	staffId: string;

	staff: StaffModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	transferOrderId: string;

	transferOrder: TransferOrderModel;

	modelPropGroups: { [s: string]: Group } = TransferOrderStockDetailModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'itemNumber',
				// % protected region % [Set displayName for Item Number here] off begin
				displayName: 'Item Number',
				// % protected region % [Set displayName for Item Number here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Item Number here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Item Number here] end
				// % protected region % [Set isSensitive for Item Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Item Number here] end
				// % protected region % [Set readonly for Item Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Item Number here] end
				validators: [
					// % protected region % [Add other validators for Item Number here] off begin
					// % protected region % [Add other validators for Item Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Item Number here] off begin
				// % protected region % [Add any additional model attribute properties for Item Number here] end
			},
			{
				name: 'sourceAvailableQuantity',
				// % protected region % [Set displayName for Source Available Quantity here] off begin
				displayName: 'Source Available Quantity',
				// % protected region % [Set displayName for Source Available Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Source Available Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Source Available Quantity here] end
				// % protected region % [Set isSensitive for Source Available Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Source Available Quantity here] end
				// % protected region % [Set readonly for Source Available Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Source Available Quantity here] end
				validators: [
					// % protected region % [Add other validators for Source Available Quantity here] off begin
					// % protected region % [Add other validators for Source Available Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Source Available Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Source Available Quantity here] end
			},
			{
				name: 'destinationSOH',
				// % protected region % [Set displayName for Destination SOH here] off begin
				displayName: 'Destination SOH',
				// % protected region % [Set displayName for Destination SOH here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Destination SOH here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Destination SOH here] end
				// % protected region % [Set isSensitive for Destination SOH here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Destination SOH here] end
				// % protected region % [Set readonly for Destination SOH here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Destination SOH here] end
				validators: [
					// % protected region % [Add other validators for Destination SOH here] off begin
					// % protected region % [Add other validators for Destination SOH here] end
				],
				// % protected region % [Add any additional model attribute properties for Destination SOH here] off begin
				// % protected region % [Add any additional model attribute properties for Destination SOH here] end
			},
			{
				name: 'quantityOrdered',
				// % protected region % [Set displayName for Quantity Ordered here] off begin
				displayName: 'Quantity Ordered',
				// % protected region % [Set displayName for Quantity Ordered here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Quantity Ordered here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Quantity Ordered here] end
				// % protected region % [Set isSensitive for Quantity Ordered here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Quantity Ordered here] end
				// % protected region % [Set readonly for Quantity Ordered here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Quantity Ordered here] end
				validators: [
					// % protected region % [Add other validators for Quantity Ordered here] off begin
					// % protected region % [Add other validators for Quantity Ordered here] end
				],
				// % protected region % [Add any additional model attribute properties for Quantity Ordered here] off begin
				// % protected region % [Add any additional model attribute properties for Quantity Ordered here] end
			},
			{
				name: 'uom',
				// % protected region % [Set displayName for uom here] off begin
				displayName: 'uom',
				// % protected region % [Set displayName for uom here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for uom here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for uom here] end
				// % protected region % [Set isSensitive for uom here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for uom here] end
				// % protected region % [Set readonly for uom here] off begin
				readOnly: false,
				// % protected region % [Set readonly for uom here] end
				validators: [
					// % protected region % [Add other validators for uom here] off begin
					// % protected region % [Add other validators for uom here] end
				],
				// % protected region % [Add any additional model attribute properties for uom here] off begin
				// % protected region % [Add any additional model attribute properties for uom here] end
			},
			{
				name: 'transactionStatus',
				// % protected region % [Set displayName for Transaction Status here] off begin
				displayName: 'Transaction Status',
				// % protected region % [Set displayName for Transaction Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transaction Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transaction Status here] end
				// % protected region % [Set isSensitive for Transaction Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Status here] end
				// % protected region % [Set readonly for Transaction Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Status here] end
				validators: [
					// % protected region % [Add other validators for Transaction Status here] off begin
					// % protected region % [Add other validators for Transaction Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Status here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Status here] end
			},
			{
				name: 'quantityIssued',
				// % protected region % [Set displayName for Quantity Issued here] off begin
				displayName: 'Quantity Issued',
				// % protected region % [Set displayName for Quantity Issued here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Quantity Issued here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Quantity Issued here] end
				// % protected region % [Set isSensitive for Quantity Issued here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Quantity Issued here] end
				// % protected region % [Set readonly for Quantity Issued here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Quantity Issued here] end
				validators: [
					// % protected region % [Add other validators for Quantity Issued here] off begin
					// % protected region % [Add other validators for Quantity Issued here] end
				],
				// % protected region % [Add any additional model attribute properties for Quantity Issued here] off begin
				// % protected region % [Add any additional model attribute properties for Quantity Issued here] end
			},
			{
				name: 'quantityReceived',
				// % protected region % [Set displayName for Quantity Received here] off begin
				displayName: 'Quantity Received',
				// % protected region % [Set displayName for Quantity Received here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Quantity Received here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Quantity Received here] end
				// % protected region % [Set isSensitive for Quantity Received here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Quantity Received here] end
				// % protected region % [Set readonly for Quantity Received here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Quantity Received here] end
				validators: [
					// % protected region % [Add other validators for Quantity Received here] off begin
					// % protected region % [Add other validators for Quantity Received here] end
				],
				// % protected region % [Add any additional model attribute properties for Quantity Received here] off begin
				// % protected region % [Add any additional model attribute properties for Quantity Received here] end
			},
			{
				name: 'sourceMinLevel',
				// % protected region % [Set displayName for Source Min Level here] off begin
				displayName: 'Source Min Level',
				// % protected region % [Set displayName for Source Min Level here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Source Min Level here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Source Min Level here] end
				// % protected region % [Set isSensitive for Source Min Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Source Min Level here] end
				// % protected region % [Set readonly for Source Min Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Source Min Level here] end
				validators: [
					// % protected region % [Add other validators for Source Min Level here] off begin
					// % protected region % [Add other validators for Source Min Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Source Min Level here] off begin
				// % protected region % [Add any additional model attribute properties for Source Min Level here] end
			},
			{
				name: 'destinationMaxLevel',
				// % protected region % [Set displayName for Destination Max Level here] off begin
				displayName: 'Destination Max Level',
				// % protected region % [Set displayName for Destination Max Level here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Destination Max Level here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Destination Max Level here] end
				// % protected region % [Set isSensitive for Destination Max Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Destination Max Level here] end
				// % protected region % [Set readonly for Destination Max Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Destination Max Level here] end
				validators: [
					// % protected region % [Add other validators for Destination Max Level here] off begin
					// % protected region % [Add other validators for Destination Max Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Destination Max Level here] off begin
				// % protected region % [Add any additional model attribute properties for Destination Max Level here] end
			},
			{
				name: 'quantityTransferred',
				// % protected region % [Set displayName for Quantity Transferred here] off begin
				displayName: 'Quantity Transferred',
				// % protected region % [Set displayName for Quantity Transferred here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Quantity Transferred here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Quantity Transferred here] end
				// % protected region % [Set isSensitive for Quantity Transferred here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Quantity Transferred here] end
				// % protected region % [Set readonly for Quantity Transferred here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Quantity Transferred here] end
				validators: [
					// % protected region % [Add other validators for Quantity Transferred here] off begin
					// % protected region % [Add other validators for Quantity Transferred here] end
				],
				// % protected region % [Add any additional model attribute properties for Quantity Transferred here] off begin
				// % protected region % [Add any additional model attribute properties for Quantity Transferred here] end
			},
			{
				name: 'quantityFulfilled',
				// % protected region % [Set displayName for Quantity Fulfilled here] off begin
				displayName: 'Quantity Fulfilled',
				// % protected region % [Set displayName for Quantity Fulfilled here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Quantity Fulfilled here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Quantity Fulfilled here] end
				// % protected region % [Set isSensitive for Quantity Fulfilled here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Quantity Fulfilled here] end
				// % protected region % [Set readonly for Quantity Fulfilled here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Quantity Fulfilled here] end
				validators: [
					// % protected region % [Add other validators for Quantity Fulfilled here] off begin
					// % protected region % [Add other validators for Quantity Fulfilled here] end
				],
				// % protected region % [Add any additional model attribute properties for Quantity Fulfilled here] off begin
				// % protected region % [Add any additional model attribute properties for Quantity Fulfilled here] end
			},
			{
				name: 'orderDateTime',
				// % protected region % [Set displayName for Order Date Time here] off begin
				displayName: 'Order Date Time',
				// % protected region % [Set displayName for Order Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Order Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Order Date Time here] end
				// % protected region % [Set isSensitive for Order Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Order Date Time here] end
				// % protected region % [Set readonly for Order Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Order Date Time here] end
				validators: [
					// % protected region % [Add other validators for Order Date Time here] off begin
					// % protected region % [Add other validators for Order Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Order Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Order Date Time here] end
			},
			{
				name: 'itemNotes',
				// % protected region % [Set displayName for Item Notes here] off begin
				displayName: 'Item Notes',
				// % protected region % [Set displayName for Item Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Item Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Item Notes here] end
				// % protected region % [Set isSensitive for Item Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Item Notes here] end
				// % protected region % [Set readonly for Item Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Item Notes here] end
				validators: [
					// % protected region % [Add other validators for Item Notes here] off begin
					// % protected region % [Add other validators for Item Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Item Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Item Notes here] end
			},
			{
				name: 'inventoryRoundingValue',
				// % protected region % [Set displayName for Inventory Rounding Value here] off begin
				displayName: 'Inventory Rounding Value',
				// % protected region % [Set displayName for Inventory Rounding Value here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Inventory Rounding Value here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Inventory Rounding Value here] end
				// % protected region % [Set isSensitive for Inventory Rounding Value here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inventory Rounding Value here] end
				// % protected region % [Set readonly for Inventory Rounding Value here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inventory Rounding Value here] end
				validators: [
					// % protected region % [Add other validators for Inventory Rounding Value here] off begin
					// % protected region % [Add other validators for Inventory Rounding Value here] end
				],
				// % protected region % [Add any additional model attribute properties for Inventory Rounding Value here] off begin
				// % protected region % [Add any additional model attribute properties for Inventory Rounding Value here] end
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
				id: 'staff',
				type: ModelRelationType.ONE,
				name: 'staffId',
				// % protected region % [Customise your label for Staff here] off begin
				label: 'Staff',
				// % protected region % [Customise your label for Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Staff here] end
				validators: [
					// % protected region % [Add other validators for Staff here] off begin
					// % protected region % [Add other validators for Staff here] end
				],
				// % protected region % [Add any additional field for relation Staff here] off begin
				// % protected region % [Add any additional field for relation Staff here] end
			},
			{
				id: 'stockCatalogue',
				type: ModelRelationType.ONE,
				name: 'stockCatalogueId',
				// % protected region % [Customise your label for Stock Catalogue here] off begin
				label: 'Stock Catalogue',
				// % protected region % [Customise your label for Stock Catalogue here] end
				entityName: 'StockCatalogueModel',
				// % protected region % [Customise your display name for Stock Catalogue here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'trackable',
				// % protected region % [Customise your display name for Stock Catalogue here] end
				validators: [
					// % protected region % [Add other validators for Stock Catalogue here] off begin
					// % protected region % [Add other validators for Stock Catalogue here] end
				],
				// % protected region % [Add any additional field for relation Stock Catalogue here] off begin
				// % protected region % [Add any additional field for relation Stock Catalogue here] end
			},
			{
				id: 'transferOrder',
				type: ModelRelationType.ONE,
				name: 'transferOrderId',
				// % protected region % [Customise your label for Transfer Order here] off begin
				label: 'Transfer Order',
				// % protected region % [Customise your label for Transfer Order here] end
				entityName: 'TransferOrderModel',
				// % protected region % [Customise your display name for Transfer Order here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'transferOrderNumber',
				// % protected region % [Customise your display name for Transfer Order here] end
				validators: [
					// % protected region % [Add other validators for Transfer Order here] off begin
					// % protected region % [Add other validators for Transfer Order here] end
				],
				// % protected region % [Add any additional field for relation Transfer Order here] off begin
				// % protected region % [Add any additional field for relation Transfer Order here] end
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
				case 'itemNumber':
					break;
				case 'sourceAvailableQuantity':
					break;
				case 'destinationSOH':
					break;
				case 'quantityOrdered':
					break;
				case 'uom':
					break;
				case 'transactionStatus':
					break;
				case 'quantityIssued':
					break;
				case 'quantityReceived':
					break;
				case 'sourceMinLevel':
					break;
				case 'destinationMaxLevel':
					break;
				case 'quantityTransferred':
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
	static deepParse(data: string | { [K in keyof TransferOrderStockDetailModel]?: TransferOrderStockDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new TransferOrderStockDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.staff) {
			currentModel.staffId = json.staff.id;
			returned = _.union(returned, StaffModel.deepParse(json.staff));
		}

		// Incoming one to many
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}

		// Incoming one to many
		if (json.transferOrder) {
			currentModel.transferOrderId = json.transferOrder.id;
			returned = _.union(returned, TransferOrderModel.deepParse(json.transferOrder));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let transferOrderStockDetailModel = new TransferOrderStockDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the TransferOrderStockDetailModel,
	 *    it is expected as a JSON string or as a nullable TransferOrderStockDetailModel.
	 */
	constructor(data?: string | Partial<TransferOrderStockDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<TransferOrderStockDetailModel>
				: data;

			this.itemNumber = json.itemNumber;
			this.sourceAvailableQuantity = json.sourceAvailableQuantity;
			this.destinationSOH = json.destinationSOH;
			this.quantityOrdered = json.quantityOrdered;
			this.uom = json.uom;
			this.transactionStatus = json.transactionStatus;
			this.quantityIssued = json.quantityIssued;
			this.quantityReceived = json.quantityReceived;
			this.sourceMinLevel = json.sourceMinLevel;
			this.destinationMaxLevel = json.destinationMaxLevel;
			this.quantityTransferred = json.quantityTransferred;
			this.quantityFulfilled = json.quantityFulfilled;
			if (json.orderDateTime) {
				this.orderDateTime = new Date(json.orderDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.orderDateTime = json.orderDateTime;
			}
			this.itemNotes = json.itemNotes;
			this.inventoryRoundingValue = json.inventoryRoundingValue;
			this.staffId = json.staffId;
			this.staff = json.staff;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			this.transferOrderId = json.transferOrderId;
			this.transferOrder = json.transferOrder;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			itemNumber: this.itemNumber,
			sourceAvailableQuantity: this.sourceAvailableQuantity,
			destinationSOH: this.destinationSOH,
			quantityOrdered: this.quantityOrdered,
			uom: this.uom,
			transactionStatus: this.transactionStatus,
			quantityIssued: this.quantityIssued,
			quantityReceived: this.quantityReceived,
			sourceMinLevel: this.sourceMinLevel,
			destinationMaxLevel: this.destinationMaxLevel,
			quantityTransferred: this.quantityTransferred,
			quantityFulfilled: this.quantityFulfilled,
			orderDateTime: this.orderDateTime,
			itemNotes: this.itemNotes,
			inventoryRoundingValue: this.inventoryRoundingValue,
			staffId: this.staffId,
			stockCatalogueId: this.stockCatalogueId,
			transferOrderId: this.transferOrderId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		TransferOrderStockDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): TransferOrderStockDetailModel {
		let newModelJson = this.toJSON();

		if (updates.itemNumber) {
			newModelJson.itemNumber = updates.itemNumber;
		}

		if (updates.sourceAvailableQuantity) {
			newModelJson.sourceAvailableQuantity = updates.sourceAvailableQuantity;
		}

		if (updates.destinationSOH) {
			newModelJson.destinationSOH = updates.destinationSOH;
		}

		if (updates.quantityOrdered) {
			newModelJson.quantityOrdered = updates.quantityOrdered;
		}

		if (updates.uom) {
			newModelJson.uom = updates.uom;
		}

		if (updates.transactionStatus) {
			newModelJson.transactionStatus = updates.transactionStatus;
		}

		if (updates.quantityIssued) {
			newModelJson.quantityIssued = updates.quantityIssued;
		}

		if (updates.quantityReceived) {
			newModelJson.quantityReceived = updates.quantityReceived;
		}

		if (updates.sourceMinLevel) {
			newModelJson.sourceMinLevel = updates.sourceMinLevel;
		}

		if (updates.destinationMaxLevel) {
			newModelJson.destinationMaxLevel = updates.destinationMaxLevel;
		}

		if (updates.quantityTransferred) {
			newModelJson.quantityTransferred = updates.quantityTransferred;
		}

		if (updates.quantityFulfilled) {
			newModelJson.quantityFulfilled = updates.quantityFulfilled;
		}

		if (updates.orderDateTime) {
			newModelJson.orderDateTime = updates.orderDateTime;
		}

		if (updates.itemNotes) {
			newModelJson.itemNotes = updates.itemNotes;
		}

		if (updates.inventoryRoundingValue) {
			newModelJson.inventoryRoundingValue = updates.inventoryRoundingValue;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		if (updates.transferOrderId) {
			newModelJson.transferOrderId = updates.transferOrderId;
		}

		return new TransferOrderStockDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof TransferOrderStockDetailModel)) {
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
			'staffId',
			'staff',
			'stockCatalogueId',
			'stockCatalogue',
			'transferOrderId',
			'transferOrder',
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
		if (!this.staff) {
			this.staffId = null;
		} else {
			this.staffId = this.staff.id;
		}

		if (!this.stockCatalogue) {
			this.stockCatalogueId = null;
		} else {
			this.stockCatalogueId = this.stockCatalogue.id;
		}

		if (!this.transferOrder) {
			this.transferOrderId = null;
		} else {
			this.transferOrderId = this.transferOrder.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
