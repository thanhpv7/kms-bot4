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
import {InventoryAdjusmentBatchModel} from '../inventoryAdjusmentBatch/inventory_adjusment_batch.model';
import {InventoryAdjustmentModel} from '../inventoryAdjustment/inventory_adjustment.model';
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
export class InventoryAdjustmentItemModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'originalInventoryValue',
		'qty',
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

	readonly className = 'InventoryAdjustmentItemModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InventoryAdjustmentItemModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	itemLineNumber: number;

	/**
	 * Stock On Hand.
	 */
	originalSOH: number;

	/**
	 * .
	 */
	originalInventoryValue: number;

	/**
	 * .
	 */
	qty: number;

	/**
	 * .
	 */
	uom: string;

	/**
	 * .
	 */
	price: number;

	/**
	 * .
	 */
	totalCost: number;

	/**
	 * .
	 */
	adjustedSoh: number;

	/**
	 * .
	 */
	adjustedInventoryValue: number;

	/**
	 * .
	 */
	minimalLevel: number;

	/**
	 * .
	 */
	maximalLevel: number;

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
	qtyUoi: number;

	/**
	 * .
	 */
	priceUoi: number;

	/**
	 * Inventory Rounding Value.
	 */
	inventoryRoundingValue: number;

	inventoryAdjustmentId: string;

	inventoryAdjustment: InventoryAdjustmentModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	inventoryAdjusmentBatchsIds: string[] = [];

	inventoryAdjusmentBatchs: InventoryAdjusmentBatchModel[];

	modelPropGroups: { [s: string]: Group } = InventoryAdjustmentItemModel.modelPropGroups;

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
				name: 'originalSOH',
				// % protected region % [Set displayName for Original SOH here] off begin
				displayName: 'Original SOH',
				// % protected region % [Set displayName for Original SOH here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Original SOH here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Original SOH here] end
				// % protected region % [Set isSensitive for Original SOH here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Original SOH here] end
				// % protected region % [Set readonly for Original SOH here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Original SOH here] end
				validators: [
					// % protected region % [Add other validators for Original SOH here] off begin
					// % protected region % [Add other validators for Original SOH here] end
				],
				// % protected region % [Add any additional model attribute properties for Original SOH here] off begin
				// % protected region % [Add any additional model attribute properties for Original SOH here] end
			},
			{
				name: 'originalInventoryValue',
				// % protected region % [Set displayName for Original Inventory Value here] off begin
				displayName: 'Original Inventory Value',
				// % protected region % [Set displayName for Original Inventory Value here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Original Inventory Value here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Original Inventory Value here] end
				// % protected region % [Set isSensitive for Original Inventory Value here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Original Inventory Value here] end
				// % protected region % [Set readonly for Original Inventory Value here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Original Inventory Value here] end
				validators: [
					// % protected region % [Add other validators for Original Inventory Value here] off begin
					// % protected region % [Add other validators for Original Inventory Value here] end
				],
				// % protected region % [Add any additional model attribute properties for Original Inventory Value here] off begin
				// % protected region % [Add any additional model attribute properties for Original Inventory Value here] end
			},
			{
				name: 'qty',
				// % protected region % [Set displayName for Qty here] off begin
				displayName: 'Qty',
				// % protected region % [Set displayName for Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Qty here] end
				// % protected region % [Set isSensitive for Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Qty here] end
				// % protected region % [Set readonly for Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Qty here] end
				validators: [
					// % protected region % [Add other validators for Qty here] off begin
					// % protected region % [Add other validators for Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Qty here] end
			},
			{
				name: 'uom',
				// % protected region % [Set displayName for Uom here] off begin
				displayName: 'Uom',
				// % protected region % [Set displayName for Uom here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Uom here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Uom here] end
				// % protected region % [Set isSensitive for Uom here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Uom here] end
				// % protected region % [Set readonly for Uom here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Uom here] end
				validators: [
					// % protected region % [Add other validators for Uom here] off begin
					// % protected region % [Add other validators for Uom here] end
				],
				// % protected region % [Add any additional model attribute properties for Uom here] off begin
				// % protected region % [Add any additional model attribute properties for Uom here] end
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
				name: 'totalCost',
				// % protected region % [Set displayName for Total Cost here] off begin
				displayName: 'Total Cost',
				// % protected region % [Set displayName for Total Cost here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Cost here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Cost here] end
				// % protected region % [Set isSensitive for Total Cost here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Cost here] end
				// % protected region % [Set readonly for Total Cost here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Cost here] end
				validators: [
					// % protected region % [Add other validators for Total Cost here] off begin
					// % protected region % [Add other validators for Total Cost here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Cost here] off begin
				// % protected region % [Add any additional model attribute properties for Total Cost here] end
			},
			{
				name: 'adjustedSoh',
				// % protected region % [Set displayName for Adjusted Soh here] off begin
				displayName: 'Adjusted Soh',
				// % protected region % [Set displayName for Adjusted Soh here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Adjusted Soh here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Adjusted Soh here] end
				// % protected region % [Set isSensitive for Adjusted Soh here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Adjusted Soh here] end
				// % protected region % [Set readonly for Adjusted Soh here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Adjusted Soh here] end
				validators: [
					// % protected region % [Add other validators for Adjusted Soh here] off begin
					// % protected region % [Add other validators for Adjusted Soh here] end
				],
				// % protected region % [Add any additional model attribute properties for Adjusted Soh here] off begin
				// % protected region % [Add any additional model attribute properties for Adjusted Soh here] end
			},
			{
				name: 'adjustedInventoryValue',
				// % protected region % [Set displayName for Adjusted Inventory Value here] off begin
				displayName: 'Adjusted Inventory Value',
				// % protected region % [Set displayName for Adjusted Inventory Value here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Adjusted Inventory Value here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Adjusted Inventory Value here] end
				// % protected region % [Set isSensitive for Adjusted Inventory Value here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Adjusted Inventory Value here] end
				// % protected region % [Set readonly for Adjusted Inventory Value here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Adjusted Inventory Value here] end
				validators: [
					// % protected region % [Add other validators for Adjusted Inventory Value here] off begin
					// % protected region % [Add other validators for Adjusted Inventory Value here] end
				],
				// % protected region % [Add any additional model attribute properties for Adjusted Inventory Value here] off begin
				// % protected region % [Add any additional model attribute properties for Adjusted Inventory Value here] end
			},
			{
				name: 'minimalLevel',
				// % protected region % [Set displayName for Minimal Level here] off begin
				displayName: 'Minimal Level',
				// % protected region % [Set displayName for Minimal Level here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Minimal Level here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Minimal Level here] end
				// % protected region % [Set isSensitive for Minimal Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Minimal Level here] end
				// % protected region % [Set readonly for Minimal Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Minimal Level here] end
				validators: [
					// % protected region % [Add other validators for Minimal Level here] off begin
					// % protected region % [Add other validators for Minimal Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Minimal Level here] off begin
				// % protected region % [Add any additional model attribute properties for Minimal Level here] end
			},
			{
				name: 'maximalLevel',
				// % protected region % [Set displayName for Maximal Level here] off begin
				displayName: 'Maximal Level',
				// % protected region % [Set displayName for Maximal Level here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Maximal Level here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Maximal Level here] end
				// % protected region % [Set isSensitive for Maximal Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Maximal Level here] end
				// % protected region % [Set readonly for Maximal Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Maximal Level here] end
				validators: [
					// % protected region % [Add other validators for Maximal Level here] off begin
					// % protected region % [Add other validators for Maximal Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Maximal Level here] off begin
				// % protected region % [Add any additional model attribute properties for Maximal Level here] end
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
				// % protected region % [Set displayName for Uoi here] off begin
				displayName: 'Uoi',
				// % protected region % [Set displayName for Uoi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Uoi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Uoi here] end
				// % protected region % [Set isSensitive for Uoi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Uoi here] end
				// % protected region % [Set readonly for Uoi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Uoi here] end
				validators: [
					// % protected region % [Add other validators for Uoi here] off begin
					// % protected region % [Add other validators for Uoi here] end
				],
				// % protected region % [Add any additional model attribute properties for Uoi here] off begin
				// % protected region % [Add any additional model attribute properties for Uoi here] end
			},
			{
				name: 'qtyUoi',
				// % protected region % [Set displayName for Qty Uoi here] off begin
				displayName: 'Qty Uoi',
				// % protected region % [Set displayName for Qty Uoi here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Qty Uoi here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Qty Uoi here] end
				// % protected region % [Set isSensitive for Qty Uoi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Qty Uoi here] end
				// % protected region % [Set readonly for Qty Uoi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Qty Uoi here] end
				validators: [
					// % protected region % [Add other validators for Qty Uoi here] off begin
					// % protected region % [Add other validators for Qty Uoi here] end
				],
				// % protected region % [Add any additional model attribute properties for Qty Uoi here] off begin
				// % protected region % [Add any additional model attribute properties for Qty Uoi here] end
			},
			{
				name: 'priceUoi',
				// % protected region % [Set displayName for Price Uoi here] off begin
				displayName: 'Price Uoi',
				// % protected region % [Set displayName for Price Uoi here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Price Uoi here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Price Uoi here] end
				// % protected region % [Set isSensitive for Price Uoi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Price Uoi here] end
				// % protected region % [Set readonly for Price Uoi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Price Uoi here] end
				validators: [
					// % protected region % [Add other validators for Price Uoi here] off begin
					// % protected region % [Add other validators for Price Uoi here] end
				],
				// % protected region % [Add any additional model attribute properties for Price Uoi here] off begin
				// % protected region % [Add any additional model attribute properties for Price Uoi here] end
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
				id: 'inventoryAdjusmentBatchs',
				type: ModelRelationType.MANY,
				name: 'inventoryAdjusmentBatchsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjusment Batchs here] off begin
				label: 'Inventory Adjusment Batchs',
				// % protected region % [Customise your 1-1 or 1-M label for Inventory Adjusment Batchs here] end
				entityName: 'InventoryAdjusmentBatchModel',
				// % protected region % [Customise your display name for Inventory Adjusment Batchs here] off begin
				displayName: 'itemLineNumber',
				// % protected region % [Customise your display name for Inventory Adjusment Batchs here] end
				validators: [
					// % protected region % [Add other validators for Inventory Adjusment Batchs here] off begin
					// % protected region % [Add other validators for Inventory Adjusment Batchs here] end
				],
				// % protected region % [Add any additional field for relation Inventory Adjusment Batchs here] off begin
				// % protected region % [Add any additional field for relation Inventory Adjusment Batchs here] end
			},
			{
				id: 'inventoryAdjustment',
				type: ModelRelationType.ONE,
				name: 'inventoryAdjustmentId',
				// % protected region % [Customise your label for Inventory Adjustment here] off begin
				label: 'Inventory Adjustment',
				// % protected region % [Customise your label for Inventory Adjustment here] end
				entityName: 'InventoryAdjustmentModel',
				// % protected region % [Customise your display name for Inventory Adjustment here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'adjustmentNumber',
				// % protected region % [Customise your display name for Inventory Adjustment here] end
				validators: [
					// % protected region % [Add other validators for Inventory Adjustment here] off begin
					// % protected region % [Add other validators for Inventory Adjustment here] end
				],
				// % protected region % [Add any additional field for relation Inventory Adjustment here] off begin
				// % protected region % [Add any additional field for relation Inventory Adjustment here] end
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
				case 'originalInventoryValue':
					break;
				case 'qty':
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
	static deepParse(data: string | { [K in keyof InventoryAdjustmentItemModel]?: InventoryAdjustmentItemModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InventoryAdjustmentItemModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.inventoryAdjustment) {
			currentModel.inventoryAdjustmentId = json.inventoryAdjustment.id;
			returned = _.union(returned, InventoryAdjustmentModel.deepParse(json.inventoryAdjustment));
		}

		// Incoming one to many
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}

		// Outgoing one to many
		if (json.inventoryAdjusmentBatchs) {
			currentModel.inventoryAdjusmentBatchsIds = json.inventoryAdjusmentBatchs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.inventoryAdjusmentBatchs.map(model => InventoryAdjusmentBatchModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let inventoryAdjustmentItemModel = new InventoryAdjustmentItemModel(data);`
	 *
	 * @param data The input data to be initialised as the InventoryAdjustmentItemModel,
	 *    it is expected as a JSON string or as a nullable InventoryAdjustmentItemModel.
	 */
	constructor(data?: string | Partial<InventoryAdjustmentItemModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InventoryAdjustmentItemModel>
				: data;

			this.itemLineNumber = json.itemLineNumber;
			this.originalSOH = json.originalSOH;
			this.originalInventoryValue = json.originalInventoryValue;
			this.qty = json.qty;
			this.uom = json.uom;
			this.price = json.price;
			this.totalCost = json.totalCost;
			this.adjustedSoh = json.adjustedSoh;
			this.adjustedInventoryValue = json.adjustedInventoryValue;
			this.minimalLevel = json.minimalLevel;
			this.maximalLevel = json.maximalLevel;
			this.itemNotes = json.itemNotes;
			this.uoi = json.uoi;
			this.qtyUoi = json.qtyUoi;
			this.priceUoi = json.priceUoi;
			this.inventoryRoundingValue = json.inventoryRoundingValue;
			this.inventoryAdjustmentId = json.inventoryAdjustmentId;
			this.inventoryAdjustment = json.inventoryAdjustment;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			this.inventoryAdjusmentBatchsIds = json.inventoryAdjusmentBatchsIds;
			this.inventoryAdjusmentBatchs = json.inventoryAdjusmentBatchs;
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
			originalSOH: this.originalSOH,
			originalInventoryValue: this.originalInventoryValue,
			qty: this.qty,
			uom: this.uom,
			price: this.price,
			totalCost: this.totalCost,
			adjustedSoh: this.adjustedSoh,
			adjustedInventoryValue: this.adjustedInventoryValue,
			minimalLevel: this.minimalLevel,
			maximalLevel: this.maximalLevel,
			itemNotes: this.itemNotes,
			uoi: this.uoi,
			qtyUoi: this.qtyUoi,
			priceUoi: this.priceUoi,
			inventoryRoundingValue: this.inventoryRoundingValue,
			inventoryAdjustmentId: this.inventoryAdjustmentId,
			stockCatalogueId: this.stockCatalogueId,
			inventoryAdjusmentBatchsIds: this.inventoryAdjusmentBatchsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InventoryAdjustmentItemModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InventoryAdjustmentItemModel {
		let newModelJson = this.toJSON();

		if (updates.itemLineNumber) {
			newModelJson.itemLineNumber = updates.itemLineNumber;
		}

		if (updates.originalSOH) {
			newModelJson.originalSOH = updates.originalSOH;
		}

		if (updates.originalInventoryValue) {
			newModelJson.originalInventoryValue = updates.originalInventoryValue;
		}

		if (updates.qty) {
			newModelJson.qty = updates.qty;
		}

		if (updates.uom) {
			newModelJson.uom = updates.uom;
		}

		if (updates.price) {
			newModelJson.price = updates.price;
		}

		if (updates.totalCost) {
			newModelJson.totalCost = updates.totalCost;
		}

		if (updates.adjustedSoh) {
			newModelJson.adjustedSoh = updates.adjustedSoh;
		}

		if (updates.adjustedInventoryValue) {
			newModelJson.adjustedInventoryValue = updates.adjustedInventoryValue;
		}

		if (updates.minimalLevel) {
			newModelJson.minimalLevel = updates.minimalLevel;
		}

		if (updates.maximalLevel) {
			newModelJson.maximalLevel = updates.maximalLevel;
		}

		if (updates.itemNotes) {
			newModelJson.itemNotes = updates.itemNotes;
		}

		if (updates.uoi) {
			newModelJson.uoi = updates.uoi;
		}

		if (updates.qtyUoi) {
			newModelJson.qtyUoi = updates.qtyUoi;
		}

		if (updates.priceUoi) {
			newModelJson.priceUoi = updates.priceUoi;
		}

		if (updates.inventoryRoundingValue) {
			newModelJson.inventoryRoundingValue = updates.inventoryRoundingValue;
		}

		if (updates.inventoryAdjustmentId) {
			newModelJson.inventoryAdjustmentId = updates.inventoryAdjustmentId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		if (updates.inventoryAdjusmentBatchsIds) {
			newModelJson.inventoryAdjusmentBatchsIds = updates.inventoryAdjusmentBatchsIds;
		}

		return new InventoryAdjustmentItemModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InventoryAdjustmentItemModel)) {
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
			'inventoryAdjustmentId',
			'inventoryAdjustment',
			'stockCatalogueId',
			'stockCatalogue',
			'inventoryAdjusmentBatchsIds',
			'inventoryAdjusmentBatchs',
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
		if (!this.inventoryAdjustment) {
			this.inventoryAdjustmentId = null;
		} else {
			this.inventoryAdjustmentId = this.inventoryAdjustment.id;
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
