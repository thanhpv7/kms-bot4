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
import {GoodsReceiveNoteModel} from '../goodsReceiveNote/goods_receive_note.model';
import {GoodsReceiveNoteBatchModel} from '../goodsReceiveNoteBatch/goods_receive_note_batch.model';
import {PurchaseOrderStockDetailModel} from '../purchaseOrderStockDetail/purchase_order_stock_detail.model';
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
export class GoodsReceiveNoteItemModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'uop',
		'taxValue',
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

	readonly className = 'GoodsReceiveNoteItemModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return GoodsReceiveNoteItemModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	itemLineNumber: number;

	/**
	 * .
	 */
	uop: string;

	/**
	 * .
	 */
	qtyReceived: number;

	/**
	 * .
	 */
	qtyOrdered: number;

	/**
	 * .
	 */
	price: number;

	/**
	 * .
	 */
	totalItemPrice: number;

	/**
	 * .
	 */
	itemNotes: string;

	/**
	 * .
	 */
	prevQtyReceived: number;

	/**
	 * .
	 */
	uoi: string;

	/**
	 * .
	 */
	qtyReceivedUOI: number;

	/**
	 * .
	 */
	priceUOI: number;

	/**
	 * Stock on hand qty after UOP conversion.
	 */
	onHandQtyUOP: number;

	/**
	 * Max level value after  UOP conversion.
	 */
	maxLevelUOP: number;

	/**
	 * Discount Value.
	 */
	discountValue: number;

	/**
	 * Tax Value.
	 */
	taxValue: number;

	/**
	 * Inventory Rounding Value.
	 */
	inventoryRoundingValue: number;

	/**
	 * Discount In Percent.
	 */
	discountInPercent: boolean = false;

	/**
	 * Tax In Percent.
	 */
	taxInPercent: boolean = false;

	goodsReceiveNoteId: string;

	goodsReceiveNote: GoodsReceiveNoteModel;

	purchaseOrderStockDetailId: string;

	purchaseOrderStockDetail: PurchaseOrderStockDetailModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	goodsReceiveNoteBatchsIds: string[] = [];

	goodsReceiveNoteBatchs: GoodsReceiveNoteBatchModel[];

	modelPropGroups: { [s: string]: Group } = GoodsReceiveNoteItemModel.modelPropGroups;

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
				name: 'qtyReceived',
				// % protected region % [Set displayName for Qty Received here] off begin
				displayName: 'Qty Received',
				// % protected region % [Set displayName for Qty Received here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Qty Received here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Qty Received here] end
				// % protected region % [Set isSensitive for Qty Received here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Qty Received here] end
				// % protected region % [Set readonly for Qty Received here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Qty Received here] end
				validators: [
					// % protected region % [Add other validators for Qty Received here] off begin
					// % protected region % [Add other validators for Qty Received here] end
				],
				// % protected region % [Add any additional model attribute properties for Qty Received here] off begin
				// % protected region % [Add any additional model attribute properties for Qty Received here] end
			},
			{
				name: 'qtyOrdered',
				// % protected region % [Set displayName for Qty Ordered here] off begin
				displayName: 'Qty Ordered',
				// % protected region % [Set displayName for Qty Ordered here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Qty Ordered here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Qty Ordered here] end
				// % protected region % [Set isSensitive for Qty Ordered here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Qty Ordered here] end
				// % protected region % [Set readonly for Qty Ordered here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Qty Ordered here] end
				validators: [
					// % protected region % [Add other validators for Qty Ordered here] off begin
					// % protected region % [Add other validators for Qty Ordered here] end
				],
				// % protected region % [Add any additional model attribute properties for Qty Ordered here] off begin
				// % protected region % [Add any additional model attribute properties for Qty Ordered here] end
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
				name: 'prevQtyReceived',
				// % protected region % [Set displayName for Prev Qty Received here] off begin
				displayName: 'Prev Qty Received',
				// % protected region % [Set displayName for Prev Qty Received here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Prev Qty Received here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Prev Qty Received here] end
				// % protected region % [Set isSensitive for Prev Qty Received here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Prev Qty Received here] end
				// % protected region % [Set readonly for Prev Qty Received here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Prev Qty Received here] end
				validators: [
					// % protected region % [Add other validators for Prev Qty Received here] off begin
					// % protected region % [Add other validators for Prev Qty Received here] end
				],
				// % protected region % [Add any additional model attribute properties for Prev Qty Received here] off begin
				// % protected region % [Add any additional model attribute properties for Prev Qty Received here] end
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
				name: 'qtyReceivedUOI',
				// % protected region % [Set displayName for Qty Received UOI here] off begin
				displayName: 'Qty Received UOI',
				// % protected region % [Set displayName for Qty Received UOI here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Qty Received UOI here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Qty Received UOI here] end
				// % protected region % [Set isSensitive for Qty Received UOI here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Qty Received UOI here] end
				// % protected region % [Set readonly for Qty Received UOI here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Qty Received UOI here] end
				validators: [
					// % protected region % [Add other validators for Qty Received UOI here] off begin
					// % protected region % [Add other validators for Qty Received UOI here] end
				],
				// % protected region % [Add any additional model attribute properties for Qty Received UOI here] off begin
				// % protected region % [Add any additional model attribute properties for Qty Received UOI here] end
			},
			{
				name: 'priceUOI',
				// % protected region % [Set displayName for Price UOI here] off begin
				displayName: 'Price UOI',
				// % protected region % [Set displayName for Price UOI here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Price UOI here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Price UOI here] end
				// % protected region % [Set isSensitive for Price UOI here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Price UOI here] end
				// % protected region % [Set readonly for Price UOI here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Price UOI here] end
				validators: [
					// % protected region % [Add other validators for Price UOI here] off begin
					// % protected region % [Add other validators for Price UOI here] end
				],
				// % protected region % [Add any additional model attribute properties for Price UOI here] off begin
				// % protected region % [Add any additional model attribute properties for Price UOI here] end
			},
			{
				name: 'onHandQtyUOP',
				// % protected region % [Set displayName for On Hand Qty UOP here] off begin
				displayName: 'On Hand Qty UOP',
				// % protected region % [Set displayName for On Hand Qty UOP here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for On Hand Qty UOP here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for On Hand Qty UOP here] end
				// % protected region % [Set isSensitive for On Hand Qty UOP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for On Hand Qty UOP here] end
				// % protected region % [Set readonly for On Hand Qty UOP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for On Hand Qty UOP here] end
				validators: [
					// % protected region % [Add other validators for On Hand Qty UOP here] off begin
					// % protected region % [Add other validators for On Hand Qty UOP here] end
				],
				// % protected region % [Add any additional model attribute properties for On Hand Qty UOP here] off begin
				// % protected region % [Add any additional model attribute properties for On Hand Qty UOP here] end
			},
			{
				name: 'maxLevelUOP',
				// % protected region % [Set displayName for Max Level UOP here] off begin
				displayName: 'Max Level UOP',
				// % protected region % [Set displayName for Max Level UOP here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Max Level UOP here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Max Level UOP here] end
				// % protected region % [Set isSensitive for Max Level UOP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Max Level UOP here] end
				// % protected region % [Set readonly for Max Level UOP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Max Level UOP here] end
				validators: [
					// % protected region % [Add other validators for Max Level UOP here] off begin
					// % protected region % [Add other validators for Max Level UOP here] end
				],
				// % protected region % [Add any additional model attribute properties for Max Level UOP here] off begin
				// % protected region % [Add any additional model attribute properties for Max Level UOP here] end
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
				name: 'taxValue',
				// % protected region % [Set displayName for Tax Value here] off begin
				displayName: 'Tax Value',
				// % protected region % [Set displayName for Tax Value here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Tax Value here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Tax Value here] end
				// % protected region % [Set isSensitive for Tax Value here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax Value here] end
				// % protected region % [Set readonly for Tax Value here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax Value here] end
				validators: [
					// % protected region % [Add other validators for Tax Value here] off begin
					// % protected region % [Add other validators for Tax Value here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax Value here] off begin
				// % protected region % [Add any additional model attribute properties for Tax Value here] end
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
				name: 'taxInPercent',
				// % protected region % [Set displayName for Tax In Percent here] off begin
				displayName: 'Tax In Percent',
				// % protected region % [Set displayName for Tax In Percent here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Tax In Percent here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Tax In Percent here] end
				// % protected region % [Set isSensitive for Tax In Percent here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax In Percent here] end
				// % protected region % [Set readonly for Tax In Percent here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax In Percent here] end
				validators: [
					// % protected region % [Add other validators for Tax In Percent here] off begin
					// % protected region % [Add other validators for Tax In Percent here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax In Percent here] off begin
				// % protected region % [Add any additional model attribute properties for Tax In Percent here] end
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
				id: 'goodsReceiveNoteBatchs',
				type: ModelRelationType.MANY,
				name: 'goodsReceiveNoteBatchsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Note Batchs here] off begin
				label: 'Goods Receive Note Batchs',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Note Batchs here] end
				entityName: 'GoodsReceiveNoteBatchModel',
				// % protected region % [Customise your display name for Goods Receive Note Batchs here] off begin
				displayName: 'itemLineNumber',
				// % protected region % [Customise your display name for Goods Receive Note Batchs here] end
				validators: [
					// % protected region % [Add other validators for Goods Receive Note Batchs here] off begin
					// % protected region % [Add other validators for Goods Receive Note Batchs here] end
				],
				// % protected region % [Add any additional field for relation Goods Receive Note Batchs here] off begin
				// % protected region % [Add any additional field for relation Goods Receive Note Batchs here] end
			},
			{
				id: 'goodsReceiveNote',
				type: ModelRelationType.ONE,
				name: 'goodsReceiveNoteId',
				// % protected region % [Customise your label for Goods Receive Note here] off begin
				label: 'Goods Receive Note',
				// % protected region % [Customise your label for Goods Receive Note here] end
				entityName: 'GoodsReceiveNoteModel',
				// % protected region % [Customise your display name for Goods Receive Note here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'receiveNumber',
				// % protected region % [Customise your display name for Goods Receive Note here] end
				validators: [
					// % protected region % [Add other validators for Goods Receive Note here] off begin
					// % protected region % [Add other validators for Goods Receive Note here] end
				],
				// % protected region % [Add any additional field for relation Goods Receive Note here] off begin
				// % protected region % [Add any additional field for relation Goods Receive Note here] end
			},
			{
				id: 'purchaseOrderStockDetail',
				type: ModelRelationType.ONE,
				name: 'purchaseOrderStockDetailId',
				// % protected region % [Customise your label for Purchase Order Stock Detail here] off begin
				label: 'Purchase Order Stock Detail',
				// % protected region % [Customise your label for Purchase Order Stock Detail here] end
				entityName: 'PurchaseOrderStockDetailModel',
				// % protected region % [Customise your display name for Purchase Order Stock Detail here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'unitPrice',
				// % protected region % [Customise your display name for Purchase Order Stock Detail here] end
				validators: [
					// % protected region % [Add other validators for Purchase Order Stock Detail here] off begin
					// % protected region % [Add other validators for Purchase Order Stock Detail here] end
				],
				// % protected region % [Add any additional field for relation Purchase Order Stock Detail here] off begin
				// % protected region % [Add any additional field for relation Purchase Order Stock Detail here] end
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
				case 'uop':
					break;
				case 'taxValue':
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
	static deepParse(data: string | { [K in keyof GoodsReceiveNoteItemModel]?: GoodsReceiveNoteItemModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new GoodsReceiveNoteItemModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.goodsReceiveNote) {
			currentModel.goodsReceiveNoteId = json.goodsReceiveNote.id;
			returned = _.union(returned, GoodsReceiveNoteModel.deepParse(json.goodsReceiveNote));
		}

		// Incoming one to many
		if (json.purchaseOrderStockDetail) {
			currentModel.purchaseOrderStockDetailId = json.purchaseOrderStockDetail.id;
			returned = _.union(returned, PurchaseOrderStockDetailModel.deepParse(json.purchaseOrderStockDetail));
		}

		// Incoming one to many
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}

		// Outgoing one to many
		if (json.goodsReceiveNoteBatchs) {
			currentModel.goodsReceiveNoteBatchsIds = json.goodsReceiveNoteBatchs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.goodsReceiveNoteBatchs.map(model => GoodsReceiveNoteBatchModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let goodsReceiveNoteItemModel = new GoodsReceiveNoteItemModel(data);`
	 *
	 * @param data The input data to be initialised as the GoodsReceiveNoteItemModel,
	 *    it is expected as a JSON string or as a nullable GoodsReceiveNoteItemModel.
	 */
	constructor(data?: string | Partial<GoodsReceiveNoteItemModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<GoodsReceiveNoteItemModel>
				: data;

			this.itemLineNumber = json.itemLineNumber;
			this.uop = json.uop;
			this.qtyReceived = json.qtyReceived;
			this.qtyOrdered = json.qtyOrdered;
			this.price = json.price;
			this.totalItemPrice = json.totalItemPrice;
			this.itemNotes = json.itemNotes;
			this.prevQtyReceived = json.prevQtyReceived;
			this.uoi = json.uoi;
			this.qtyReceivedUOI = json.qtyReceivedUOI;
			this.priceUOI = json.priceUOI;
			this.onHandQtyUOP = json.onHandQtyUOP;
			this.maxLevelUOP = json.maxLevelUOP;
			this.discountValue = json.discountValue;
			this.taxValue = json.taxValue;
			this.inventoryRoundingValue = json.inventoryRoundingValue;
			this.discountInPercent = json.discountInPercent;
			this.taxInPercent = json.taxInPercent;
			this.goodsReceiveNoteId = json.goodsReceiveNoteId;
			this.goodsReceiveNote = json.goodsReceiveNote;
			this.purchaseOrderStockDetailId = json.purchaseOrderStockDetailId;
			this.purchaseOrderStockDetail = json.purchaseOrderStockDetail;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			this.goodsReceiveNoteBatchsIds = json.goodsReceiveNoteBatchsIds;
			this.goodsReceiveNoteBatchs = json.goodsReceiveNoteBatchs;
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
			uop: this.uop,
			qtyReceived: this.qtyReceived,
			qtyOrdered: this.qtyOrdered,
			price: this.price,
			totalItemPrice: this.totalItemPrice,
			itemNotes: this.itemNotes,
			prevQtyReceived: this.prevQtyReceived,
			uoi: this.uoi,
			qtyReceivedUOI: this.qtyReceivedUOI,
			priceUOI: this.priceUOI,
			onHandQtyUOP: this.onHandQtyUOP,
			maxLevelUOP: this.maxLevelUOP,
			discountValue: this.discountValue,
			taxValue: this.taxValue,
			inventoryRoundingValue: this.inventoryRoundingValue,
			discountInPercent: this.discountInPercent,
			taxInPercent: this.taxInPercent,
			goodsReceiveNoteId: this.goodsReceiveNoteId,
			purchaseOrderStockDetailId: this.purchaseOrderStockDetailId,
			stockCatalogueId: this.stockCatalogueId,
			goodsReceiveNoteBatchsIds: this.goodsReceiveNoteBatchsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		GoodsReceiveNoteItemModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): GoodsReceiveNoteItemModel {
		let newModelJson = this.toJSON();

		if (updates.itemLineNumber) {
			newModelJson.itemLineNumber = updates.itemLineNumber;
		}

		if (updates.uop) {
			newModelJson.uop = updates.uop;
		}

		if (updates.qtyReceived) {
			newModelJson.qtyReceived = updates.qtyReceived;
		}

		if (updates.qtyOrdered) {
			newModelJson.qtyOrdered = updates.qtyOrdered;
		}

		if (updates.price) {
			newModelJson.price = updates.price;
		}

		if (updates.totalItemPrice) {
			newModelJson.totalItemPrice = updates.totalItemPrice;
		}

		if (updates.itemNotes) {
			newModelJson.itemNotes = updates.itemNotes;
		}

		if (updates.prevQtyReceived) {
			newModelJson.prevQtyReceived = updates.prevQtyReceived;
		}

		if (updates.uoi) {
			newModelJson.uoi = updates.uoi;
		}

		if (updates.qtyReceivedUOI) {
			newModelJson.qtyReceivedUOI = updates.qtyReceivedUOI;
		}

		if (updates.priceUOI) {
			newModelJson.priceUOI = updates.priceUOI;
		}

		if (updates.onHandQtyUOP) {
			newModelJson.onHandQtyUOP = updates.onHandQtyUOP;
		}

		if (updates.maxLevelUOP) {
			newModelJson.maxLevelUOP = updates.maxLevelUOP;
		}

		if (updates.discountValue) {
			newModelJson.discountValue = updates.discountValue;
		}

		if (updates.taxValue) {
			newModelJson.taxValue = updates.taxValue;
		}

		if (updates.inventoryRoundingValue) {
			newModelJson.inventoryRoundingValue = updates.inventoryRoundingValue;
		}

		if (updates.discountInPercent) {
			newModelJson.discountInPercent = updates.discountInPercent;
		}

		if (updates.taxInPercent) {
			newModelJson.taxInPercent = updates.taxInPercent;
		}

		if (updates.goodsReceiveNoteId) {
			newModelJson.goodsReceiveNoteId = updates.goodsReceiveNoteId;
		}

		if (updates.purchaseOrderStockDetailId) {
			newModelJson.purchaseOrderStockDetailId = updates.purchaseOrderStockDetailId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		if (updates.goodsReceiveNoteBatchsIds) {
			newModelJson.goodsReceiveNoteBatchsIds = updates.goodsReceiveNoteBatchsIds;
		}

		return new GoodsReceiveNoteItemModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof GoodsReceiveNoteItemModel)) {
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
			'goodsReceiveNoteId',
			'goodsReceiveNote',
			'purchaseOrderStockDetailId',
			'purchaseOrderStockDetail',
			'stockCatalogueId',
			'stockCatalogue',
			'goodsReceiveNoteBatchsIds',
			'goodsReceiveNoteBatchs',
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
		if (!this.goodsReceiveNote) {
			this.goodsReceiveNoteId = null;
		} else {
			this.goodsReceiveNoteId = this.goodsReceiveNote.id;
		}

		if (!this.purchaseOrderStockDetail) {
			this.purchaseOrderStockDetailId = null;
		} else {
			this.purchaseOrderStockDetailId = this.purchaseOrderStockDetail.id;
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
