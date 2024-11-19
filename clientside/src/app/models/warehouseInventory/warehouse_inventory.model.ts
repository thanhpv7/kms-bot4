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
import {LocationModel} from '../location/location.model';
import {StockCatalogueModel} from '../stockCatalogue/stock_catalogue.model';
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
export class WarehouseInventoryModel extends AbstractModel {
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
		'soh',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'WarehouseInventoryModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return WarehouseInventoryModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Stock on Hand, with 2 decimal digits.
	 */
	soh: number;

	/**
	 * Reserved Quantity, with 2 decimal digits.
	 */
	reservedQuantity: number;

	/**
	 * Notes (Max Length: 500).
	 */
	notes: string;

	locationId: string;

	location: LocationModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	modelPropGroups: { [s: string]: Group } = WarehouseInventoryModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'soh',
				// % protected region % [Set displayName for SOH here] off begin
				displayName: 'SOH',
				// % protected region % [Set displayName for SOH here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for SOH here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for SOH here] end
				// % protected region % [Set isSensitive for SOH here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SOH here] end
				// % protected region % [Set readonly for SOH here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SOH here] end
				validators: [
					// % protected region % [Add other validators for SOH here] off begin
					// % protected region % [Add other validators for SOH here] end
				],
				// % protected region % [Add any additional model attribute properties for SOH here] off begin
				// % protected region % [Add any additional model attribute properties for SOH here] end
			},
			{
				name: 'reservedQuantity',
				// % protected region % [Set displayName for Reserved Quantity here] off begin
				displayName: 'Reserved Quantity',
				// % protected region % [Set displayName for Reserved Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Reserved Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Reserved Quantity here] end
				// % protected region % [Set isSensitive for Reserved Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Reserved Quantity here] end
				// % protected region % [Set readonly for Reserved Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Reserved Quantity here] end
				validators: [
					// % protected region % [Add other validators for Reserved Quantity here] off begin
					// % protected region % [Add other validators for Reserved Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Reserved Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Reserved Quantity here] end
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
				id: 'location',
				type: ModelRelationType.ONE,
				name: 'locationId',
				// % protected region % [Customise your label for Location here] off begin
				label: 'Location',
				// % protected region % [Customise your label for Location here] end
				entityName: 'LocationModel',
				// % protected region % [Customise your display name for Location here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'locationName',
				// % protected region % [Customise your display name for Location here] end
				validators: [
					// % protected region % [Add other validators for Location here] off begin
					// % protected region % [Add other validators for Location here] end
				],
				// % protected region % [Add any additional field for relation Location here] off begin
				// % protected region % [Add any additional field for relation Location here] end
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
	static deepParse(data: string | { [K in keyof WarehouseInventoryModel]?: WarehouseInventoryModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new WarehouseInventoryModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.location) {
			currentModel.locationId = json.location.id;
			returned = _.union(returned, LocationModel.deepParse(json.location));
		}

		// Incoming one to many
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}

		// Incoming one to many
		if (json.warehouse) {
			currentModel.warehouseId = json.warehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.warehouse));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let warehouseInventoryModel = new WarehouseInventoryModel(data);`
	 *
	 * @param data The input data to be initialised as the WarehouseInventoryModel,
	 *    it is expected as a JSON string or as a nullable WarehouseInventoryModel.
	 */
	constructor(data?: string | Partial<WarehouseInventoryModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<WarehouseInventoryModel>
				: data;

			this.soh = json.soh;
			this.reservedQuantity = json.reservedQuantity;
			this.notes = json.notes;
			this.locationId = json.locationId;
			this.location = json.location;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			soh: this.soh,
			reservedQuantity: this.reservedQuantity,
			notes: this.notes,
			locationId: this.locationId,
			stockCatalogueId: this.stockCatalogueId,
			warehouseId: this.warehouseId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		WarehouseInventoryModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): WarehouseInventoryModel {
		let newModelJson = this.toJSON();

		if (updates.soh) {
			newModelJson.soh = updates.soh;
		}

		if (updates.reservedQuantity) {
			newModelJson.reservedQuantity = updates.reservedQuantity;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.locationId) {
			newModelJson.locationId = updates.locationId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		return new WarehouseInventoryModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof WarehouseInventoryModel)) {
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
			'locationId',
			'location',
			'stockCatalogueId',
			'stockCatalogue',
			'warehouseId',
			'warehouse',
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
		if (!this.location) {
			this.locationId = null;
		} else {
			this.locationId = this.location.id;
		}

		if (!this.stockCatalogue) {
			this.stockCatalogueId = null;
		} else {
			this.stockCatalogueId = this.stockCatalogue.id;
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
