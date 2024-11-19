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
import {TransactionDetailTypeModel} from '../transactionDetailType/transaction_detail_type.model';
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
export class StockTransactionDetailModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'transactionNumber',
		'transactionDate',
		'transactionType',
		'transactionNotes',
		'itemNotes',
		'qtyUoi',
		'qtyUomTransaction',
		'totalCost',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'transactionNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'StockTransactionDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return StockTransactionDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	transactionNumber: string;

	/**
	 * .
	 */
	transactionDate: Date;

	/**
	 * .
	 */
	transactionType: string;

	/**
	 * .
	 */
	transactionNotes: string;

	/**
	 * .
	 */
	itemLineNumber: number;

	/**
	 * .
	 */
	itemNotes: string;

	/**
	 * .
	 */
	qtyUoi: number;

	/**
	 * .
	 */
	qtyUomTransaction: number;

	/**
	 * .
	 */
	totalCost: number;

	/**
	 * .
	 */
	uoi: string;

	/**
	 * .
	 */
	uomTransaction: string;

	/**
	 * .
	 */
	sourceOrderNumber: string;

	/**
	 * .
	 */
	qtyTransitUoi: number;

	/**
	 * .
	 */
	qtyTransitUomTransaction: number;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	transactionDetailTypeId: string;

	transactionDetailType: TransactionDetailTypeModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	modelPropGroups: { [s: string]: Group } = StockTransactionDetailModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'transactionNumber',
				// % protected region % [Set displayName for Transaction Number here] off begin
				displayName: 'Transaction Number',
				// % protected region % [Set displayName for Transaction Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transaction Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transaction Number here] end
				// % protected region % [Set isSensitive for Transaction Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Number here] end
				// % protected region % [Set readonly for Transaction Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Number here] end
				validators: [
					// % protected region % [Add other validators for Transaction Number here] off begin
					// % protected region % [Add other validators for Transaction Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Number here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Number here] end
			},
			{
				name: 'transactionDate',
				// % protected region % [Set displayName for Transaction Date here] off begin
				displayName: 'Transaction Date',
				// % protected region % [Set displayName for Transaction Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Transaction Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Transaction Date here] end
				// % protected region % [Set isSensitive for Transaction Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Date here] end
				// % protected region % [Set readonly for Transaction Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Date here] end
				validators: [
					// % protected region % [Add other validators for Transaction Date here] off begin
					// % protected region % [Add other validators for Transaction Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Date here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Date here] end
			},
			{
				name: 'transactionType',
				// % protected region % [Set displayName for Transaction Type here] off begin
				displayName: 'Transaction Type',
				// % protected region % [Set displayName for Transaction Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transaction Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transaction Type here] end
				// % protected region % [Set isSensitive for Transaction Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Type here] end
				// % protected region % [Set readonly for Transaction Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Type here] end
				validators: [
					// % protected region % [Add other validators for Transaction Type here] off begin
					// % protected region % [Add other validators for Transaction Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Type here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Type here] end
			},
			{
				name: 'transactionNotes',
				// % protected region % [Set displayName for Transaction Notes here] off begin
				displayName: 'Transaction Notes',
				// % protected region % [Set displayName for Transaction Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transaction Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transaction Notes here] end
				// % protected region % [Set isSensitive for Transaction Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Notes here] end
				// % protected region % [Set readonly for Transaction Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Notes here] end
				validators: [
					// % protected region % [Add other validators for Transaction Notes here] off begin
					// % protected region % [Add other validators for Transaction Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Notes here] end
			},
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
				name: 'qtyUomTransaction',
				// % protected region % [Set displayName for Qty Uom Transaction here] off begin
				displayName: 'Qty Uom Transaction',
				// % protected region % [Set displayName for Qty Uom Transaction here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Qty Uom Transaction here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Qty Uom Transaction here] end
				// % protected region % [Set isSensitive for Qty Uom Transaction here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Qty Uom Transaction here] end
				// % protected region % [Set readonly for Qty Uom Transaction here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Qty Uom Transaction here] end
				validators: [
					// % protected region % [Add other validators for Qty Uom Transaction here] off begin
					// % protected region % [Add other validators for Qty Uom Transaction here] end
				],
				// % protected region % [Add any additional model attribute properties for Qty Uom Transaction here] off begin
				// % protected region % [Add any additional model attribute properties for Qty Uom Transaction here] end
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
				name: 'uomTransaction',
				// % protected region % [Set displayName for Uom Transaction here] off begin
				displayName: 'Uom Transaction',
				// % protected region % [Set displayName for Uom Transaction here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Uom Transaction here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Uom Transaction here] end
				// % protected region % [Set isSensitive for Uom Transaction here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Uom Transaction here] end
				// % protected region % [Set readonly for Uom Transaction here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Uom Transaction here] end
				validators: [
					// % protected region % [Add other validators for Uom Transaction here] off begin
					// % protected region % [Add other validators for Uom Transaction here] end
				],
				// % protected region % [Add any additional model attribute properties for Uom Transaction here] off begin
				// % protected region % [Add any additional model attribute properties for Uom Transaction here] end
			},
			{
				name: 'sourceOrderNumber',
				// % protected region % [Set displayName for Source Order Number here] off begin
				displayName: 'Source Order Number',
				// % protected region % [Set displayName for Source Order Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Source Order Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Source Order Number here] end
				// % protected region % [Set isSensitive for Source Order Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Source Order Number here] end
				// % protected region % [Set readonly for Source Order Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Source Order Number here] end
				validators: [
					// % protected region % [Add other validators for Source Order Number here] off begin
					// % protected region % [Add other validators for Source Order Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Source Order Number here] off begin
				// % protected region % [Add any additional model attribute properties for Source Order Number here] end
			},
			{
				name: 'qtyTransitUoi',
				// % protected region % [Set displayName for Qty Transit Uoi here] off begin
				displayName: 'Qty Transit Uoi',
				// % protected region % [Set displayName for Qty Transit Uoi here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Qty Transit Uoi here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Qty Transit Uoi here] end
				// % protected region % [Set isSensitive for Qty Transit Uoi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Qty Transit Uoi here] end
				// % protected region % [Set readonly for Qty Transit Uoi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Qty Transit Uoi here] end
				validators: [
					// % protected region % [Add other validators for Qty Transit Uoi here] off begin
					// % protected region % [Add other validators for Qty Transit Uoi here] end
				],
				// % protected region % [Add any additional model attribute properties for Qty Transit Uoi here] off begin
				// % protected region % [Add any additional model attribute properties for Qty Transit Uoi here] end
			},
			{
				name: 'qtyTransitUomTransaction',
				// % protected region % [Set displayName for Qty Transit Uom Transaction here] off begin
				displayName: 'Qty Transit Uom Transaction',
				// % protected region % [Set displayName for Qty Transit Uom Transaction here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Qty Transit Uom Transaction here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Qty Transit Uom Transaction here] end
				// % protected region % [Set isSensitive for Qty Transit Uom Transaction here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Qty Transit Uom Transaction here] end
				// % protected region % [Set readonly for Qty Transit Uom Transaction here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Qty Transit Uom Transaction here] end
				validators: [
					// % protected region % [Add other validators for Qty Transit Uom Transaction here] off begin
					// % protected region % [Add other validators for Qty Transit Uom Transaction here] end
				],
				// % protected region % [Add any additional model attribute properties for Qty Transit Uom Transaction here] off begin
				// % protected region % [Add any additional model attribute properties for Qty Transit Uom Transaction here] end
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
				id: 'transactionDetailType',
				type: ModelRelationType.ONE,
				name: 'transactionDetailTypeId',
				// % protected region % [Customise your label for Transaction Detail Type here] off begin
				label: 'Transaction Detail Type',
				// % protected region % [Customise your label for Transaction Detail Type here] end
				entityName: 'TransactionDetailTypeModel',
				// % protected region % [Customise your display name for Transaction Detail Type here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'transactionDetail',
				// % protected region % [Customise your display name for Transaction Detail Type here] end
				validators: [
					// % protected region % [Add other validators for Transaction Detail Type here] off begin
					// % protected region % [Add other validators for Transaction Detail Type here] end
				],
				// % protected region % [Add any additional field for relation Transaction Detail Type here] off begin
				// % protected region % [Add any additional field for relation Transaction Detail Type here] end
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
				case 'transactionNumber':
					break;
				case 'transactionDate':
					break;
				case 'transactionType':
					break;
				case 'transactionNotes':
					break;
				case 'itemNotes':
					break;
				case 'qtyUoi':
					break;
				case 'qtyUomTransaction':
					break;
				case 'totalCost':
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
	static deepParse(data: string | { [K in keyof StockTransactionDetailModel]?: StockTransactionDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new StockTransactionDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}

		// Incoming one to many
		if (json.transactionDetailType) {
			currentModel.transactionDetailTypeId = json.transactionDetailType.id;
			returned = _.union(returned, TransactionDetailTypeModel.deepParse(json.transactionDetailType));
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
	 * `let stockTransactionDetailModel = new StockTransactionDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the StockTransactionDetailModel,
	 *    it is expected as a JSON string or as a nullable StockTransactionDetailModel.
	 */
	constructor(data?: string | Partial<StockTransactionDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<StockTransactionDetailModel>
				: data;

			this.transactionNumber = json.transactionNumber;
			if (json.transactionDate) {
				this.transactionDate = new Date(json.transactionDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.transactionDate = json.transactionDate;
			}
			this.transactionType = json.transactionType;
			this.transactionNotes = json.transactionNotes;
			this.itemLineNumber = json.itemLineNumber;
			this.itemNotes = json.itemNotes;
			this.qtyUoi = json.qtyUoi;
			this.qtyUomTransaction = json.qtyUomTransaction;
			this.totalCost = json.totalCost;
			this.uoi = json.uoi;
			this.uomTransaction = json.uomTransaction;
			this.sourceOrderNumber = json.sourceOrderNumber;
			this.qtyTransitUoi = json.qtyTransitUoi;
			this.qtyTransitUomTransaction = json.qtyTransitUomTransaction;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			this.transactionDetailTypeId = json.transactionDetailTypeId;
			this.transactionDetailType = json.transactionDetailType;
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
			transactionNumber: this.transactionNumber,
			transactionDate: this.transactionDate,
			transactionType: this.transactionType,
			transactionNotes: this.transactionNotes,
			itemLineNumber: this.itemLineNumber,
			itemNotes: this.itemNotes,
			qtyUoi: this.qtyUoi,
			qtyUomTransaction: this.qtyUomTransaction,
			totalCost: this.totalCost,
			uoi: this.uoi,
			uomTransaction: this.uomTransaction,
			sourceOrderNumber: this.sourceOrderNumber,
			qtyTransitUoi: this.qtyTransitUoi,
			qtyTransitUomTransaction: this.qtyTransitUomTransaction,
			stockCatalogueId: this.stockCatalogueId,
			transactionDetailTypeId: this.transactionDetailTypeId,
			warehouseId: this.warehouseId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		StockTransactionDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): StockTransactionDetailModel {
		let newModelJson = this.toJSON();

		if (updates.transactionNumber) {
			newModelJson.transactionNumber = updates.transactionNumber;
		}

		if (updates.transactionDate) {
			newModelJson.transactionDate = updates.transactionDate;
		}

		if (updates.transactionType) {
			newModelJson.transactionType = updates.transactionType;
		}

		if (updates.transactionNotes) {
			newModelJson.transactionNotes = updates.transactionNotes;
		}

		if (updates.itemLineNumber) {
			newModelJson.itemLineNumber = updates.itemLineNumber;
		}

		if (updates.itemNotes) {
			newModelJson.itemNotes = updates.itemNotes;
		}

		if (updates.qtyUoi) {
			newModelJson.qtyUoi = updates.qtyUoi;
		}

		if (updates.qtyUomTransaction) {
			newModelJson.qtyUomTransaction = updates.qtyUomTransaction;
		}

		if (updates.totalCost) {
			newModelJson.totalCost = updates.totalCost;
		}

		if (updates.uoi) {
			newModelJson.uoi = updates.uoi;
		}

		if (updates.uomTransaction) {
			newModelJson.uomTransaction = updates.uomTransaction;
		}

		if (updates.sourceOrderNumber) {
			newModelJson.sourceOrderNumber = updates.sourceOrderNumber;
		}

		if (updates.qtyTransitUoi) {
			newModelJson.qtyTransitUoi = updates.qtyTransitUoi;
		}

		if (updates.qtyTransitUomTransaction) {
			newModelJson.qtyTransitUomTransaction = updates.qtyTransitUomTransaction;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		if (updates.transactionDetailTypeId) {
			newModelJson.transactionDetailTypeId = updates.transactionDetailTypeId;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		return new StockTransactionDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof StockTransactionDetailModel)) {
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
			'transactionDetailTypeId',
			'transactionDetailType',
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
		if (!this.stockCatalogue) {
			this.stockCatalogueId = null;
		} else {
			this.stockCatalogueId = this.stockCatalogue.id;
		}

		if (!this.transactionDetailType) {
			this.transactionDetailTypeId = null;
		} else {
			this.transactionDetailTypeId = this.transactionDetailType.id;
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
