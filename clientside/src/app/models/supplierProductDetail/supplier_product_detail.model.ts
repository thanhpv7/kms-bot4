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
import {StockCatalogueModel} from '../stockCatalogue/stock_catalogue.model';
import {SupplierModel} from '../supplier/supplier.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class SupplierProductDetailModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'unitCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'SupplierProductDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return SupplierProductDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Unit Code.
	 */
	unitCode: string;

	/**
	 * Unit Name.
	 */
	unitName: string;

	/**
	 * Price.
	 */
	price: number;

	/**
	 * Discount.
	 */
	discount: number;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	supplierId: string;

	supplier: SupplierModel;

	modelPropGroups: { [s: string]: Group } = SupplierProductDetailModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'unitCode',
				// % protected region % [Set displayName for Unit Code here] off begin
				displayName: 'Unit Code',
				// % protected region % [Set displayName for Unit Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Unit Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Unit Code here] end
				// % protected region % [Set isSensitive for Unit Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unit Code here] end
				// % protected region % [Set readonly for Unit Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unit Code here] end
				validators: [
					// % protected region % [Add other validators for Unit Code here] off begin
					// % protected region % [Add other validators for Unit Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit Code here] off begin
				// % protected region % [Add any additional model attribute properties for Unit Code here] end
			},
			{
				name: 'unitName',
				// % protected region % [Set displayName for Unit Name here] off begin
				displayName: 'Unit Name',
				// % protected region % [Set displayName for Unit Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Unit Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Unit Name here] end
				// % protected region % [Set isSensitive for Unit Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unit Name here] end
				// % protected region % [Set readonly for Unit Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unit Name here] end
				validators: [
					// % protected region % [Add other validators for Unit Name here] off begin
					// % protected region % [Add other validators for Unit Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit Name here] off begin
				// % protected region % [Add any additional model attribute properties for Unit Name here] end
			},
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
	static deepParse(data: string | { [K in keyof SupplierProductDetailModel]?: SupplierProductDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new SupplierProductDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}

		// Incoming one to many
		if (json.supplier) {
			currentModel.supplierId = json.supplier.id;
			returned = _.union(returned, SupplierModel.deepParse(json.supplier));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let supplierProductDetailModel = new SupplierProductDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the SupplierProductDetailModel,
	 *    it is expected as a JSON string or as a nullable SupplierProductDetailModel.
	 */
	constructor(data?: string | Partial<SupplierProductDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<SupplierProductDetailModel>
				: data;

			this.unitCode = json.unitCode;
			this.unitName = json.unitName;
			this.price = json.price;
			this.discount = json.discount;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			this.supplierId = json.supplierId;
			this.supplier = json.supplier;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			unitCode: this.unitCode,
			unitName: this.unitName,
			price: this.price,
			discount: this.discount,
			stockCatalogueId: this.stockCatalogueId,
			supplierId: this.supplierId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		SupplierProductDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): SupplierProductDetailModel {
		let newModelJson = this.toJSON();

		if (updates.unitCode) {
			newModelJson.unitCode = updates.unitCode;
		}

		if (updates.unitName) {
			newModelJson.unitName = updates.unitName;
		}

		if (updates.price) {
			newModelJson.price = updates.price;
		}

		if (updates.discount) {
			newModelJson.discount = updates.discount;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		if (updates.supplierId) {
			newModelJson.supplierId = updates.supplierId;
		}

		return new SupplierProductDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof SupplierProductDetailModel)) {
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
			'stockCatalogueId',
			'stockCatalogue',
			'supplierId',
			'supplier',
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
		if (!this.stockCatalogue) {
			this.stockCatalogueId = null;
		} else {
			this.stockCatalogueId = this.stockCatalogue.id;
		}

		if (!this.supplier) {
			this.supplierId = null;
		} else {
			this.supplierId = this.supplier.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
