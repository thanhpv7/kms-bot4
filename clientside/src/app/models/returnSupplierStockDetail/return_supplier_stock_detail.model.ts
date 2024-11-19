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
import {ReturnSupplierModel} from '../returnSupplier/return_supplier.model';
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
export class ReturnSupplierStockDetailModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'discountInPercent',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'price',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ReturnSupplierStockDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ReturnSupplierStockDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Price.
	 */
	price: number;

	/**
	 * Available Quantity Returned.
	 */
	availableQuantityReturned: number;

	/**
	 * UOP.
	 */
	uop: string;

	/**
	 * Discount In Percent.
	 */
	discountInPercent: boolean = false;

	/**
	 * Discount Value.
	 */
	discountValue: number;

	/**
	 * Taxable.
	 */
	taxable: boolean = false;

	/**
	 * Item Price.
	 */
	itemPrice: number;

	/**
	 * Available Quantity.
	 */
	availableQuantity: number;

	/**
	 * Quantity Ordered.
	 */
	quantityOrdered: number;

	/**
	 * Quantity Received.
	 */
	quantityReceived: number;

	/**
	 * Previous Quantity Returned.
	 */
	previousQuantityReturned: number;

	/**
	 * Item Notes.
	 */
	itemNotes: string;

	returnSupplierId: string;

	returnSupplier: ReturnSupplierModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	modelPropGroups: { [s: string]: Group } = ReturnSupplierStockDetailModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'price',
				// % protected region % [Set displayName for Price here] off begin
				displayName: 'Price',
				// % protected region % [Set displayName for Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Price here] end
				// % protected region % [Set isSensitive for Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Price here] end
				// % protected region % [Set readonly for Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Price here] end
				validators: [
					// % protected region % [Add other validators for Price here] off begin
					// % protected region % [Add other validators for Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Price here] off begin
				// % protected region % [Add any additional model attribute properties for Price here] end
			},
			{
				name: 'availableQuantityReturned',
				// % protected region % [Set displayName for Available Quantity Returned here] off begin
				displayName: 'Available Quantity Returned',
				// % protected region % [Set displayName for Available Quantity Returned here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Available Quantity Returned here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Available Quantity Returned here] end
				// % protected region % [Set isSensitive for Available Quantity Returned here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Available Quantity Returned here] end
				// % protected region % [Set readonly for Available Quantity Returned here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Available Quantity Returned here] end
				validators: [
					// % protected region % [Add other validators for Available Quantity Returned here] off begin
					// % protected region % [Add other validators for Available Quantity Returned here] end
				],
				// % protected region % [Add any additional model attribute properties for Available Quantity Returned here] off begin
				// % protected region % [Add any additional model attribute properties for Available Quantity Returned here] end
			},
			{
				name: 'uop',
				// % protected region % [Set displayName for UOP here] off begin
				displayName: 'UOP',
				// % protected region % [Set displayName for UOP here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for UOP here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for UOP here] end
				// % protected region % [Set isSensitive for UOP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for UOP here] end
				// % protected region % [Set readonly for UOP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for UOP here] end
				validators: [
					// % protected region % [Add other validators for UOP here] off begin
					// % protected region % [Add other validators for UOP here] end
				],
				// % protected region % [Add any additional model attribute properties for UOP here] off begin
				// % protected region % [Add any additional model attribute properties for UOP here] end
			},
			{
				name: 'discountInPercent',
				// % protected region % [Set displayName for Discount In Percent here] off begin
				displayName: 'Discount In Percent',
				// % protected region % [Set displayName for Discount In Percent here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Discount In Percent here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Discount In Percent here] end
				// % protected region % [Set isSensitive for Discount In Percent here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Discount In Percent here] end
				// % protected region % [Set readonly for Discount In Percent here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Discount In Percent here] end
				validators: [
					// % protected region % [Add other validators for Discount In Percent here] off begin
					// % protected region % [Add other validators for Discount In Percent here] end
				],
				// % protected region % [Add any additional model attribute properties for Discount In Percent here] off begin
				// % protected region % [Add any additional model attribute properties for Discount In Percent here] end
			},
			{
				name: 'discountValue',
				// % protected region % [Set displayName for Discount Value here] off begin
				displayName: 'Discount Value',
				// % protected region % [Set displayName for Discount Value here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Discount Value here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Discount Value here] end
				// % protected region % [Set isSensitive for Discount Value here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Discount Value here] end
				// % protected region % [Set readonly for Discount Value here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Discount Value here] end
				validators: [
					// % protected region % [Add other validators for Discount Value here] off begin
					// % protected region % [Add other validators for Discount Value here] end
				],
				// % protected region % [Add any additional model attribute properties for Discount Value here] off begin
				// % protected region % [Add any additional model attribute properties for Discount Value here] end
			},
			{
				name: 'taxable',
				// % protected region % [Set displayName for Taxable here] off begin
				displayName: 'Taxable',
				// % protected region % [Set displayName for Taxable here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Taxable here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Taxable here] end
				// % protected region % [Set isSensitive for Taxable here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Taxable here] end
				// % protected region % [Set readonly for Taxable here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Taxable here] end
				validators: [
					// % protected region % [Add other validators for Taxable here] off begin
					// % protected region % [Add other validators for Taxable here] end
				],
				// % protected region % [Add any additional model attribute properties for Taxable here] off begin
				// % protected region % [Add any additional model attribute properties for Taxable here] end
			},
			{
				name: 'itemPrice',
				// % protected region % [Set displayName for Item Price here] off begin
				displayName: 'Item Price',
				// % protected region % [Set displayName for Item Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Item Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Item Price here] end
				// % protected region % [Set isSensitive for Item Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Item Price here] end
				// % protected region % [Set readonly for Item Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Item Price here] end
				validators: [
					// % protected region % [Add other validators for Item Price here] off begin
					// % protected region % [Add other validators for Item Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Item Price here] off begin
				// % protected region % [Add any additional model attribute properties for Item Price here] end
			},
			{
				name: 'availableQuantity',
				// % protected region % [Set displayName for Available Quantity here] off begin
				displayName: 'Available Quantity',
				// % protected region % [Set displayName for Available Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Available Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Available Quantity here] end
				// % protected region % [Set isSensitive for Available Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Available Quantity here] end
				// % protected region % [Set readonly for Available Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Available Quantity here] end
				validators: [
					// % protected region % [Add other validators for Available Quantity here] off begin
					// % protected region % [Add other validators for Available Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Available Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Available Quantity here] end
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
				name: 'previousQuantityReturned',
				// % protected region % [Set displayName for Previous Quantity Returned here] off begin
				displayName: 'Previous Quantity Returned',
				// % protected region % [Set displayName for Previous Quantity Returned here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Previous Quantity Returned here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Previous Quantity Returned here] end
				// % protected region % [Set isSensitive for Previous Quantity Returned here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Previous Quantity Returned here] end
				// % protected region % [Set readonly for Previous Quantity Returned here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Previous Quantity Returned here] end
				validators: [
					// % protected region % [Add other validators for Previous Quantity Returned here] off begin
					// % protected region % [Add other validators for Previous Quantity Returned here] end
				],
				// % protected region % [Add any additional model attribute properties for Previous Quantity Returned here] off begin
				// % protected region % [Add any additional model attribute properties for Previous Quantity Returned here] end
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
				id: 'returnSupplier',
				type: ModelRelationType.ONE,
				name: 'returnSupplierId',
				// % protected region % [Customise your label for Return Supplier here] off begin
				label: 'Return Supplier',
				// % protected region % [Customise your label for Return Supplier here] end
				entityName: 'ReturnSupplierModel',
				// % protected region % [Customise your display name for Return Supplier here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'returnNumber',
				// % protected region % [Customise your display name for Return Supplier here] end
				validators: [
					// % protected region % [Add other validators for Return Supplier here] off begin
					// % protected region % [Add other validators for Return Supplier here] end
				],
				// % protected region % [Add any additional field for relation Return Supplier here] off begin
				// % protected region % [Add any additional field for relation Return Supplier here] end
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
				case 'discountInPercent':
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
	static deepParse(data: string | { [K in keyof ReturnSupplierStockDetailModel]?: ReturnSupplierStockDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ReturnSupplierStockDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.returnSupplier) {
			currentModel.returnSupplierId = json.returnSupplier.id;
			returned = _.union(returned, ReturnSupplierModel.deepParse(json.returnSupplier));
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
	 * `let returnSupplierStockDetailModel = new ReturnSupplierStockDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the ReturnSupplierStockDetailModel,
	 *    it is expected as a JSON string or as a nullable ReturnSupplierStockDetailModel.
	 */
	constructor(data?: string | Partial<ReturnSupplierStockDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ReturnSupplierStockDetailModel>
				: data;

			this.price = json.price;
			this.availableQuantityReturned = json.availableQuantityReturned;
			this.uop = json.uop;
			this.discountInPercent = json.discountInPercent;
			this.discountValue = json.discountValue;
			this.taxable = json.taxable;
			this.itemPrice = json.itemPrice;
			this.availableQuantity = json.availableQuantity;
			this.quantityOrdered = json.quantityOrdered;
			this.quantityReceived = json.quantityReceived;
			this.previousQuantityReturned = json.previousQuantityReturned;
			this.itemNotes = json.itemNotes;
			this.returnSupplierId = json.returnSupplierId;
			this.returnSupplier = json.returnSupplier;
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
			price: this.price,
			availableQuantityReturned: this.availableQuantityReturned,
			uop: this.uop,
			discountInPercent: this.discountInPercent,
			discountValue: this.discountValue,
			taxable: this.taxable,
			itemPrice: this.itemPrice,
			availableQuantity: this.availableQuantity,
			quantityOrdered: this.quantityOrdered,
			quantityReceived: this.quantityReceived,
			previousQuantityReturned: this.previousQuantityReturned,
			itemNotes: this.itemNotes,
			returnSupplierId: this.returnSupplierId,
			stockCatalogueId: this.stockCatalogueId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ReturnSupplierStockDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ReturnSupplierStockDetailModel {
		let newModelJson = this.toJSON();

		if (updates.price) {
			newModelJson.price = updates.price;
		}

		if (updates.availableQuantityReturned) {
			newModelJson.availableQuantityReturned = updates.availableQuantityReturned;
		}

		if (updates.uop) {
			newModelJson.uop = updates.uop;
		}

		if (updates.discountInPercent) {
			newModelJson.discountInPercent = updates.discountInPercent;
		}

		if (updates.discountValue) {
			newModelJson.discountValue = updates.discountValue;
		}

		if (updates.taxable) {
			newModelJson.taxable = updates.taxable;
		}

		if (updates.itemPrice) {
			newModelJson.itemPrice = updates.itemPrice;
		}

		if (updates.availableQuantity) {
			newModelJson.availableQuantity = updates.availableQuantity;
		}

		if (updates.quantityOrdered) {
			newModelJson.quantityOrdered = updates.quantityOrdered;
		}

		if (updates.quantityReceived) {
			newModelJson.quantityReceived = updates.quantityReceived;
		}

		if (updates.previousQuantityReturned) {
			newModelJson.previousQuantityReturned = updates.previousQuantityReturned;
		}

		if (updates.itemNotes) {
			newModelJson.itemNotes = updates.itemNotes;
		}

		if (updates.returnSupplierId) {
			newModelJson.returnSupplierId = updates.returnSupplierId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		return new ReturnSupplierStockDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ReturnSupplierStockDetailModel)) {
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
			'returnSupplierId',
			'returnSupplier',
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
		if (!this.returnSupplier) {
			this.returnSupplierId = null;
		} else {
			this.returnSupplierId = this.returnSupplier.id;
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
