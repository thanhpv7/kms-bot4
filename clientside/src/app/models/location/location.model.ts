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
import {StockControlModel} from '../stockControl/stock_control.model';
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
export class LocationModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'locationName',
		'aisle',
		'shelf',
		'bin',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'locationName',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'LocationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return LocationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Location Name (Max Length: 250).
	 */
	locationName: string;

	/**
	 * .
	 */
	aisle: string;

	/**
	 * .
	 */
	shelf: string;

	/**
	 * .
	 */
	bin: string;

	warehouseId: string;

	warehouse: WarehouseModel;

	stockControlsIds: string[] = [];

	stockControls: StockControlModel[];

	warehouseInitialStockSIds: string[] = [];

	warehouseInitialStockS: WarehouseInitialStockModel[];

	warehouseInventoriesIds: string[] = [];

	warehouseInventories: WarehouseInventoryModel[];

	modelPropGroups: { [s: string]: Group } = LocationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'locationName',
				// % protected region % [Set displayName for Location Name here] off begin
				displayName: 'Location Name',
				// % protected region % [Set displayName for Location Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Location Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Location Name here] end
				// % protected region % [Set isSensitive for Location Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Location Name here] end
				// % protected region % [Set readonly for Location Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Location Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Location Name here] off begin
					// % protected region % [Add other validators for Location Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Location Name here] off begin
				// % protected region % [Add any additional model attribute properties for Location Name here] end
			},
			{
				name: 'aisle',
				// % protected region % [Set displayName for Aisle here] off begin
				displayName: 'Aisle',
				// % protected region % [Set displayName for Aisle here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Aisle here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Aisle here] end
				// % protected region % [Set isSensitive for Aisle here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Aisle here] end
				// % protected region % [Set readonly for Aisle here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Aisle here] end
				validators: [
					// % protected region % [Add other validators for Aisle here] off begin
					// % protected region % [Add other validators for Aisle here] end
				],
				// % protected region % [Add any additional model attribute properties for Aisle here] off begin
				// % protected region % [Add any additional model attribute properties for Aisle here] end
			},
			{
				name: 'shelf',
				// % protected region % [Set displayName for Shelf here] off begin
				displayName: 'Shelf',
				// % protected region % [Set displayName for Shelf here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Shelf here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Shelf here] end
				// % protected region % [Set isSensitive for Shelf here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Shelf here] end
				// % protected region % [Set readonly for Shelf here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Shelf here] end
				validators: [
					// % protected region % [Add other validators for Shelf here] off begin
					// % protected region % [Add other validators for Shelf here] end
				],
				// % protected region % [Add any additional model attribute properties for Shelf here] off begin
				// % protected region % [Add any additional model attribute properties for Shelf here] end
			},
			{
				name: 'bin',
				// % protected region % [Set displayName for Bin here] off begin
				displayName: 'Bin',
				// % protected region % [Set displayName for Bin here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Bin here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Bin here] end
				// % protected region % [Set isSensitive for Bin here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bin here] end
				// % protected region % [Set readonly for Bin here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bin here] end
				validators: [
					// % protected region % [Add other validators for Bin here] off begin
					// % protected region % [Add other validators for Bin here] end
				],
				// % protected region % [Add any additional model attribute properties for Bin here] off begin
				// % protected region % [Add any additional model attribute properties for Bin here] end
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
				case 'locationName':
					break;
				case 'aisle':
					break;
				case 'shelf':
					break;
				case 'bin':
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
	static deepParse(data: string | { [K in keyof LocationModel]?: LocationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new LocationModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.warehouse) {
			currentModel.warehouseId = json.warehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.warehouse));
		}

		// Outgoing one to many
		if (json.stockControls) {
			currentModel.stockControlsIds = json.stockControls.map(model => model.id);
			returned = _.union(returned, _.flatten(json.stockControls.map(model => StockControlModel.deepParse(model))));
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
	 * `let locationModel = new LocationModel(data);`
	 *
	 * @param data The input data to be initialised as the LocationModel,
	 *    it is expected as a JSON string or as a nullable LocationModel.
	 */
	constructor(data?: string | Partial<LocationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<LocationModel>
				: data;

			this.locationName = json.locationName;
			this.aisle = json.aisle;
			this.shelf = json.shelf;
			this.bin = json.bin;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			this.stockControlsIds = json.stockControlsIds;
			this.stockControls = json.stockControls;
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
			locationName: this.locationName,
			aisle: this.aisle,
			shelf: this.shelf,
			bin: this.bin,
			warehouseId: this.warehouseId,
			stockControlsIds: this.stockControlsIds,
			warehouseInitialStockSIds: this.warehouseInitialStockSIds,
			warehouseInventoriesIds: this.warehouseInventoriesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		LocationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): LocationModel {
		let newModelJson = this.toJSON();

		if (updates.locationName) {
			newModelJson.locationName = updates.locationName;
		}

		if (updates.aisle) {
			newModelJson.aisle = updates.aisle;
		}

		if (updates.shelf) {
			newModelJson.shelf = updates.shelf;
		}

		if (updates.bin) {
			newModelJson.bin = updates.bin;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		if (updates.stockControlsIds) {
			newModelJson.stockControlsIds = updates.stockControlsIds;
		}

		if (updates.warehouseInitialStockSIds) {
			newModelJson.warehouseInitialStockSIds = updates.warehouseInitialStockSIds;
		}

		if (updates.warehouseInventoriesIds) {
			newModelJson.warehouseInventoriesIds = updates.warehouseInventoriesIds;
		}

		return new LocationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof LocationModel)) {
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
			'warehouseId',
			'warehouse',
			'stockControlsIds',
			'stockControls',
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
		if (!this.warehouse) {
			this.warehouseId = null;
		} else {
			this.warehouseId = this.warehouse.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
