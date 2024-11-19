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
import {InternalOrderModel} from '../internalOrder/internal_order.model';
import {StockCatalogueModel} from '../stockCatalogue/stock_catalogue.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class InternalOrderStockDetailModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'itemNumber',
		'sourceAvailableQuantity',
		'uom',
		'transactionStatus',
		'quantityIssued',
		'quantityReceived',
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

	readonly className = 'InternalOrderStockDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InternalOrderStockDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
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
	 * Quantity Fulfilled.
	 */
	quantityFulfilled: number;

	/**
	 * Item Notes.
	 */
	itemNotes: string;

	/**
	 * Inventory Rounding Value.
	 */
	inventoryRoundingValue: number;

	internalOrderId: string;

	internalOrder: InternalOrderModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	modelPropGroups: { [s: string]: Group } = InternalOrderStockDetailModel.modelPropGroups;

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
				id: 'internalOrder',
				type: ModelRelationType.ONE,
				name: 'internalOrderId',
				// % protected region % [Customise your label for Internal Order here] off begin
				label: 'Internal Order',
				// % protected region % [Customise your label for Internal Order here] end
				entityName: 'InternalOrderModel',
				// % protected region % [Customise your display name for Internal Order here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'internalOrderNumber',
				// % protected region % [Customise your display name for Internal Order here] end
				validators: [
					// % protected region % [Add other validators for Internal Order here] off begin
					// % protected region % [Add other validators for Internal Order here] end
				],
				// % protected region % [Add any additional field for relation Internal Order here] off begin
				// % protected region % [Add any additional field for relation Internal Order here] end
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
				case 'uom':
					break;
				case 'transactionStatus':
					break;
				case 'quantityIssued':
					break;
				case 'quantityReceived':
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
	static deepParse(data: string | { [K in keyof InternalOrderStockDetailModel]?: InternalOrderStockDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InternalOrderStockDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.internalOrder) {
			currentModel.internalOrderId = json.internalOrder.id;
			returned = _.union(returned, InternalOrderModel.deepParse(json.internalOrder));
		}

		// Incoming one to many
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let internalOrderStockDetailModel = new InternalOrderStockDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the InternalOrderStockDetailModel,
	 *    it is expected as a JSON string or as a nullable InternalOrderStockDetailModel.
	 */
	constructor(data?: string | Partial<InternalOrderStockDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InternalOrderStockDetailModel>
				: data;

			this.itemNumber = json.itemNumber;
			this.sourceAvailableQuantity = json.sourceAvailableQuantity;
			this.quantityOrdered = json.quantityOrdered;
			this.uom = json.uom;
			this.transactionStatus = json.transactionStatus;
			this.quantityIssued = json.quantityIssued;
			this.quantityReceived = json.quantityReceived;
			this.sourceMinLevel = json.sourceMinLevel;
			this.quantityFulfilled = json.quantityFulfilled;
			this.itemNotes = json.itemNotes;
			this.inventoryRoundingValue = json.inventoryRoundingValue;
			this.internalOrderId = json.internalOrderId;
			this.internalOrder = json.internalOrder;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
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
			quantityOrdered: this.quantityOrdered,
			uom: this.uom,
			transactionStatus: this.transactionStatus,
			quantityIssued: this.quantityIssued,
			quantityReceived: this.quantityReceived,
			sourceMinLevel: this.sourceMinLevel,
			quantityFulfilled: this.quantityFulfilled,
			itemNotes: this.itemNotes,
			inventoryRoundingValue: this.inventoryRoundingValue,
			internalOrderId: this.internalOrderId,
			stockCatalogueId: this.stockCatalogueId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InternalOrderStockDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InternalOrderStockDetailModel {
		let newModelJson = this.toJSON();

		if (updates.itemNumber) {
			newModelJson.itemNumber = updates.itemNumber;
		}

		if (updates.sourceAvailableQuantity) {
			newModelJson.sourceAvailableQuantity = updates.sourceAvailableQuantity;
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

		if (updates.quantityFulfilled) {
			newModelJson.quantityFulfilled = updates.quantityFulfilled;
		}

		if (updates.itemNotes) {
			newModelJson.itemNotes = updates.itemNotes;
		}

		if (updates.inventoryRoundingValue) {
			newModelJson.inventoryRoundingValue = updates.inventoryRoundingValue;
		}

		if (updates.internalOrderId) {
			newModelJson.internalOrderId = updates.internalOrderId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		return new InternalOrderStockDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InternalOrderStockDetailModel)) {
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
			'internalOrderId',
			'internalOrder',
			'stockCatalogueId',
			'stockCatalogue',
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
		if (!this.internalOrder) {
			this.internalOrderId = null;
		} else {
			this.internalOrderId = this.internalOrder.id;
		}

		if (!this.stockCatalogue) {
			this.stockCatalogueId = null;
		} else {
			this.stockCatalogueId = this.stockCatalogue.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
