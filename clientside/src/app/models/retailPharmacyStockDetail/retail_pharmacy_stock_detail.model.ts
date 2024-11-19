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
import {RetailPharmacyModel} from '../retailPharmacy/retail_pharmacy.model';
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
export class RetailPharmacyStockDetailModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'taxAmount',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'supplyStockGroup',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'RetailPharmacyStockDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return RetailPharmacyStockDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Supply Stock Group.
	 */
	supplyStockGroup: string;

	/**
	 * UOI.
	 */
	uoi: string;

	/**
	 * Available Quantity.
	 */
	availableQuantity: number;

	/**
	 * Quantity.
	 */
	quantity: number;

	/**
	 * Unit Price.
	 */
	unitPrice: number;

	/**
	 * Discount.
	 */
	discount: number;

	/**
	 * Tax Included.
	 */
	taxIncluded: boolean = false;

	/**
	 * Tax Amount.
	 */
	taxAmount: number;

	/**
	 * Total Item Price.
	 */
	totalItemPrice: number;

	retailPharmacyId: string;

	retailPharmacy: RetailPharmacyModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	modelPropGroups: { [s: string]: Group } = RetailPharmacyStockDetailModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
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
				name: 'quantity',
				// % protected region % [Set displayName for Quantity here] off begin
				displayName: 'Quantity',
				// % protected region % [Set displayName for Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Quantity here] end
				// % protected region % [Set isSensitive for Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Quantity here] end
				// % protected region % [Set readonly for Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Quantity here] end
				validators: [
					// % protected region % [Add other validators for Quantity here] off begin
					// % protected region % [Add other validators for Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Quantity here] end
			},
			{
				name: 'unitPrice',
				// % protected region % [Set displayName for Unit Price here] off begin
				displayName: 'Unit Price',
				// % protected region % [Set displayName for Unit Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Unit Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Unit Price here] end
				// % protected region % [Set isSensitive for Unit Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unit Price here] end
				// % protected region % [Set readonly for Unit Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unit Price here] end
				validators: [
					// % protected region % [Add other validators for Unit Price here] off begin
					// % protected region % [Add other validators for Unit Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit Price here] off begin
				// % protected region % [Add any additional model attribute properties for Unit Price here] end
			},
			{
				name: 'discount',
				// % protected region % [Set displayName for Discount here] off begin
				displayName: 'Discount',
				// % protected region % [Set displayName for Discount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Discount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Discount here] end
				// % protected region % [Set isSensitive for Discount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Discount here] end
				// % protected region % [Set readonly for Discount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Discount here] end
				validators: [
					// % protected region % [Add other validators for Discount here] off begin
					// % protected region % [Add other validators for Discount here] end
				],
				// % protected region % [Add any additional model attribute properties for Discount here] off begin
				// % protected region % [Add any additional model attribute properties for Discount here] end
			},
			{
				name: 'taxIncluded',
				// % protected region % [Set displayName for Tax Included here] off begin
				displayName: 'Tax Included',
				// % protected region % [Set displayName for Tax Included here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Tax Included here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Tax Included here] end
				// % protected region % [Set isSensitive for Tax Included here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax Included here] end
				// % protected region % [Set readonly for Tax Included here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax Included here] end
				validators: [
					// % protected region % [Add other validators for Tax Included here] off begin
					// % protected region % [Add other validators for Tax Included here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax Included here] off begin
				// % protected region % [Add any additional model attribute properties for Tax Included here] end
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
				name: 'totalItemPrice',
				// % protected region % [Set displayName for Total Item Price here] off begin
				displayName: 'Total Item Price',
				// % protected region % [Set displayName for Total Item Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Item Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Item Price here] end
				// % protected region % [Set isSensitive for Total Item Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Item Price here] end
				// % protected region % [Set readonly for Total Item Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Item Price here] end
				validators: [
					// % protected region % [Add other validators for Total Item Price here] off begin
					// % protected region % [Add other validators for Total Item Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Item Price here] off begin
				// % protected region % [Add any additional model attribute properties for Total Item Price here] end
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
				id: 'retailPharmacy',
				type: ModelRelationType.ONE,
				name: 'retailPharmacyId',
				// % protected region % [Customise your label for Retail Pharmacy here] off begin
				label: 'Retail Pharmacy',
				// % protected region % [Customise your label for Retail Pharmacy here] end
				entityName: 'RetailPharmacyModel',
				// % protected region % [Customise your display name for Retail Pharmacy here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'customerType',
				// % protected region % [Customise your display name for Retail Pharmacy here] end
				validators: [
					// % protected region % [Add other validators for Retail Pharmacy here] off begin
					// % protected region % [Add other validators for Retail Pharmacy here] end
				],
				// % protected region % [Add any additional field for relation Retail Pharmacy here] off begin
				// % protected region % [Add any additional field for relation Retail Pharmacy here] end
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
				case 'taxAmount':
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
	static deepParse(data: string | { [K in keyof RetailPharmacyStockDetailModel]?: RetailPharmacyStockDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new RetailPharmacyStockDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.retailPharmacy) {
			currentModel.retailPharmacyId = json.retailPharmacy.id;
			returned = _.union(returned, RetailPharmacyModel.deepParse(json.retailPharmacy));
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
	 * `let retailPharmacyStockDetailModel = new RetailPharmacyStockDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the RetailPharmacyStockDetailModel,
	 *    it is expected as a JSON string or as a nullable RetailPharmacyStockDetailModel.
	 */
	constructor(data?: string | Partial<RetailPharmacyStockDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<RetailPharmacyStockDetailModel>
				: data;

			this.supplyStockGroup = json.supplyStockGroup;
			this.uoi = json.uoi;
			this.availableQuantity = json.availableQuantity;
			this.quantity = json.quantity;
			this.unitPrice = json.unitPrice;
			this.discount = json.discount;
			this.taxIncluded = json.taxIncluded;
			this.taxAmount = json.taxAmount;
			this.totalItemPrice = json.totalItemPrice;
			this.retailPharmacyId = json.retailPharmacyId;
			this.retailPharmacy = json.retailPharmacy;
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
			supplyStockGroup: this.supplyStockGroup,
			uoi: this.uoi,
			availableQuantity: this.availableQuantity,
			quantity: this.quantity,
			unitPrice: this.unitPrice,
			discount: this.discount,
			taxIncluded: this.taxIncluded,
			taxAmount: this.taxAmount,
			totalItemPrice: this.totalItemPrice,
			retailPharmacyId: this.retailPharmacyId,
			stockCatalogueId: this.stockCatalogueId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		RetailPharmacyStockDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): RetailPharmacyStockDetailModel {
		let newModelJson = this.toJSON();

		if (updates.supplyStockGroup) {
			newModelJson.supplyStockGroup = updates.supplyStockGroup;
		}

		if (updates.uoi) {
			newModelJson.uoi = updates.uoi;
		}

		if (updates.availableQuantity) {
			newModelJson.availableQuantity = updates.availableQuantity;
		}

		if (updates.quantity) {
			newModelJson.quantity = updates.quantity;
		}

		if (updates.unitPrice) {
			newModelJson.unitPrice = updates.unitPrice;
		}

		if (updates.discount) {
			newModelJson.discount = updates.discount;
		}

		if (updates.taxIncluded) {
			newModelJson.taxIncluded = updates.taxIncluded;
		}

		if (updates.taxAmount) {
			newModelJson.taxAmount = updates.taxAmount;
		}

		if (updates.totalItemPrice) {
			newModelJson.totalItemPrice = updates.totalItemPrice;
		}

		if (updates.retailPharmacyId) {
			newModelJson.retailPharmacyId = updates.retailPharmacyId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		return new RetailPharmacyStockDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof RetailPharmacyStockDetailModel)) {
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
			'retailPharmacyId',
			'retailPharmacy',
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
		if (!this.retailPharmacy) {
			this.retailPharmacyId = null;
		} else {
			this.retailPharmacyId = this.retailPharmacy.id;
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
