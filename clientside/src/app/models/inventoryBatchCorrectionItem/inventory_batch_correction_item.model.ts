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
import {InventoryBatchCorrectionModel} from '../inventoryBatchCorrection/inventory_batch_correction.model';
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
export class InventoryBatchCorrectionItemModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'batchNumber',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'itemLineNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InventoryBatchCorrectionItemModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InventoryBatchCorrectionItemModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	itemLineNumber: number;

	/**
	 * .
	 */
	batchNumber: string;

	/**
	 * .
	 */
	expirationDate: Date;

	/**
	 * .
	 */
	uom: string;

	/**
	 * .
	 */
	availableQtyBatch: number;

	/**
	 * .
	 */
	actualQtyBatch: number;

	/**
	 * .
	 */
	qtyAdjusted: number;

	/**
	 * .
	 */
	itemNotes: string;

	/**
	 * .
	 */
	uoi: string;

	/**
	 * .
	 */
	qtyUOI: number;

	inventoryBatchCorrectionId: string;

	inventoryBatchCorrection: InventoryBatchCorrectionModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	modelPropGroups: { [s: string]: Group } = InventoryBatchCorrectionItemModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'itemLineNumber',
				// % protected region % [Set displayName for Item Line Number here] off begin
				displayName: 'Item Line Number',
				// % protected region % [Set displayName for Item Line Number here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Item Line Number here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Item Line Number here] end
				// % protected region % [Set isSensitive for Item Line Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Item Line Number here] end
				// % protected region % [Set readonly for Item Line Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Item Line Number here] end
				validators: [
					// % protected region % [Add other validators for Item Line Number here] off begin
					// % protected region % [Add other validators for Item Line Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Item Line Number here] off begin
				// % protected region % [Add any additional model attribute properties for Item Line Number here] end
			},
			{
				name: 'batchNumber',
				// % protected region % [Set displayName for Batch Number here] off begin
				displayName: 'Batch Number',
				// % protected region % [Set displayName for Batch Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Batch Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Batch Number here] end
				// % protected region % [Set isSensitive for Batch Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Batch Number here] end
				// % protected region % [Set readonly for Batch Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Batch Number here] end
				validators: [
					// % protected region % [Add other validators for Batch Number here] off begin
					// % protected region % [Add other validators for Batch Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Batch Number here] off begin
				// % protected region % [Add any additional model attribute properties for Batch Number here] end
			},
			{
				name: 'expirationDate',
				// % protected region % [Set displayName for Expiration Date here] off begin
				displayName: 'Expiration Date',
				// % protected region % [Set displayName for Expiration Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Expiration Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Expiration Date here] end
				// % protected region % [Set isSensitive for Expiration Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Expiration Date here] end
				// % protected region % [Set readonly for Expiration Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Expiration Date here] end
				validators: [
					// % protected region % [Add other validators for Expiration Date here] off begin
					// % protected region % [Add other validators for Expiration Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Expiration Date here] off begin
				// % protected region % [Add any additional model attribute properties for Expiration Date here] end
			},
			{
				name: 'uom',
				// % protected region % [Set displayName for UOM here] off begin
				displayName: 'UOM',
				// % protected region % [Set displayName for UOM here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for UOM here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for UOM here] end
				// % protected region % [Set isSensitive for UOM here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for UOM here] end
				// % protected region % [Set readonly for UOM here] off begin
				readOnly: false,
				// % protected region % [Set readonly for UOM here] end
				validators: [
					// % protected region % [Add other validators for UOM here] off begin
					// % protected region % [Add other validators for UOM here] end
				],
				// % protected region % [Add any additional model attribute properties for UOM here] off begin
				// % protected region % [Add any additional model attribute properties for UOM here] end
			},
			{
				name: 'availableQtyBatch',
				// % protected region % [Set displayName for Available Qty Batch here] off begin
				displayName: 'Available Qty Batch',
				// % protected region % [Set displayName for Available Qty Batch here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Available Qty Batch here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Available Qty Batch here] end
				// % protected region % [Set isSensitive for Available Qty Batch here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Available Qty Batch here] end
				// % protected region % [Set readonly for Available Qty Batch here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Available Qty Batch here] end
				validators: [
					// % protected region % [Add other validators for Available Qty Batch here] off begin
					// % protected region % [Add other validators for Available Qty Batch here] end
				],
				// % protected region % [Add any additional model attribute properties for Available Qty Batch here] off begin
				// % protected region % [Add any additional model attribute properties for Available Qty Batch here] end
			},
			{
				name: 'actualQtyBatch',
				// % protected region % [Set displayName for Actual Qty Batch here] off begin
				displayName: 'Actual Qty Batch',
				// % protected region % [Set displayName for Actual Qty Batch here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Actual Qty Batch here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Actual Qty Batch here] end
				// % protected region % [Set isSensitive for Actual Qty Batch here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Actual Qty Batch here] end
				// % protected region % [Set readonly for Actual Qty Batch here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Actual Qty Batch here] end
				validators: [
					// % protected region % [Add other validators for Actual Qty Batch here] off begin
					// % protected region % [Add other validators for Actual Qty Batch here] end
				],
				// % protected region % [Add any additional model attribute properties for Actual Qty Batch here] off begin
				// % protected region % [Add any additional model attribute properties for Actual Qty Batch here] end
			},
			{
				name: 'qtyAdjusted',
				// % protected region % [Set displayName for Qty Adjusted here] off begin
				displayName: 'Qty Adjusted',
				// % protected region % [Set displayName for Qty Adjusted here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Qty Adjusted here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Qty Adjusted here] end
				// % protected region % [Set isSensitive for Qty Adjusted here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Qty Adjusted here] end
				// % protected region % [Set readonly for Qty Adjusted here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Qty Adjusted here] end
				validators: [
					// % protected region % [Add other validators for Qty Adjusted here] off begin
					// % protected region % [Add other validators for Qty Adjusted here] end
				],
				// % protected region % [Add any additional model attribute properties for Qty Adjusted here] off begin
				// % protected region % [Add any additional model attribute properties for Qty Adjusted here] end
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
				name: 'qtyUOI',
				// % protected region % [Set displayName for Qty UOI here] off begin
				displayName: 'Qty UOI',
				// % protected region % [Set displayName for Qty UOI here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Qty UOI here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Qty UOI here] end
				// % protected region % [Set isSensitive for Qty UOI here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Qty UOI here] end
				// % protected region % [Set readonly for Qty UOI here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Qty UOI here] end
				validators: [
					// % protected region % [Add other validators for Qty UOI here] off begin
					// % protected region % [Add other validators for Qty UOI here] end
				],
				// % protected region % [Add any additional model attribute properties for Qty UOI here] off begin
				// % protected region % [Add any additional model attribute properties for Qty UOI here] end
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
				id: 'inventoryBatchCorrection',
				type: ModelRelationType.ONE,
				name: 'inventoryBatchCorrectionId',
				// % protected region % [Customise your label for Inventory Batch Correction here] off begin
				label: 'Inventory Batch Correction',
				// % protected region % [Customise your label for Inventory Batch Correction here] end
				entityName: 'InventoryBatchCorrectionModel',
				// % protected region % [Customise your display name for Inventory Batch Correction here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'batchCorrectionNumber',
				// % protected region % [Customise your display name for Inventory Batch Correction here] end
				validators: [
					// % protected region % [Add other validators for Inventory Batch Correction here] off begin
					// % protected region % [Add other validators for Inventory Batch Correction here] end
				],
				// % protected region % [Add any additional field for relation Inventory Batch Correction here] off begin
				// % protected region % [Add any additional field for relation Inventory Batch Correction here] end
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
				case 'batchNumber':
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
	static deepParse(data: string | { [K in keyof InventoryBatchCorrectionItemModel]?: InventoryBatchCorrectionItemModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InventoryBatchCorrectionItemModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.inventoryBatchCorrection) {
			currentModel.inventoryBatchCorrectionId = json.inventoryBatchCorrection.id;
			returned = _.union(returned, InventoryBatchCorrectionModel.deepParse(json.inventoryBatchCorrection));
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
	 * `let inventoryBatchCorrectionItemModel = new InventoryBatchCorrectionItemModel(data);`
	 *
	 * @param data The input data to be initialised as the InventoryBatchCorrectionItemModel,
	 *    it is expected as a JSON string or as a nullable InventoryBatchCorrectionItemModel.
	 */
	constructor(data?: string | Partial<InventoryBatchCorrectionItemModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InventoryBatchCorrectionItemModel>
				: data;

			this.itemLineNumber = json.itemLineNumber;
			this.batchNumber = json.batchNumber;
			if (json.expirationDate) {
				this.expirationDate = new Date(json.expirationDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.expirationDate = json.expirationDate;
			}
			this.uom = json.uom;
			this.availableQtyBatch = json.availableQtyBatch;
			this.actualQtyBatch = json.actualQtyBatch;
			this.qtyAdjusted = json.qtyAdjusted;
			this.itemNotes = json.itemNotes;
			this.uoi = json.uoi;
			this.qtyUOI = json.qtyUOI;
			this.inventoryBatchCorrectionId = json.inventoryBatchCorrectionId;
			this.inventoryBatchCorrection = json.inventoryBatchCorrection;
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
			itemLineNumber: this.itemLineNumber,
			batchNumber: this.batchNumber,
			expirationDate: this.expirationDate,
			uom: this.uom,
			availableQtyBatch: this.availableQtyBatch,
			actualQtyBatch: this.actualQtyBatch,
			qtyAdjusted: this.qtyAdjusted,
			itemNotes: this.itemNotes,
			uoi: this.uoi,
			qtyUOI: this.qtyUOI,
			inventoryBatchCorrectionId: this.inventoryBatchCorrectionId,
			stockCatalogueId: this.stockCatalogueId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InventoryBatchCorrectionItemModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InventoryBatchCorrectionItemModel {
		let newModelJson = this.toJSON();

		if (updates.itemLineNumber) {
			newModelJson.itemLineNumber = updates.itemLineNumber;
		}

		if (updates.batchNumber) {
			newModelJson.batchNumber = updates.batchNumber;
		}

		if (updates.expirationDate) {
			newModelJson.expirationDate = updates.expirationDate;
		}

		if (updates.uom) {
			newModelJson.uom = updates.uom;
		}

		if (updates.availableQtyBatch) {
			newModelJson.availableQtyBatch = updates.availableQtyBatch;
		}

		if (updates.actualQtyBatch) {
			newModelJson.actualQtyBatch = updates.actualQtyBatch;
		}

		if (updates.qtyAdjusted) {
			newModelJson.qtyAdjusted = updates.qtyAdjusted;
		}

		if (updates.itemNotes) {
			newModelJson.itemNotes = updates.itemNotes;
		}

		if (updates.uoi) {
			newModelJson.uoi = updates.uoi;
		}

		if (updates.qtyUOI) {
			newModelJson.qtyUOI = updates.qtyUOI;
		}

		if (updates.inventoryBatchCorrectionId) {
			newModelJson.inventoryBatchCorrectionId = updates.inventoryBatchCorrectionId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		return new InventoryBatchCorrectionItemModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InventoryBatchCorrectionItemModel)) {
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
			'inventoryBatchCorrectionId',
			'inventoryBatchCorrection',
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
		if (!this.inventoryBatchCorrection) {
			this.inventoryBatchCorrectionId = null;
		} else {
			this.inventoryBatchCorrectionId = this.inventoryBatchCorrection.id;
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
