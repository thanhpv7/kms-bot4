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
import {PurchaseOrderStockDetailModel} from '../purchaseOrderStockDetail/purchase_order_stock_detail.model';
import {PurchaseRequisitionModel} from '../purchaseRequisition/purchase_requisition.model';
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
export class PurchaseRequisitionStockDetailModel extends AbstractModel {
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

	readonly className = 'PurchaseRequisitionStockDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PurchaseRequisitionStockDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * SOH.
	 */
	soh: number;

	/**
	 * Max Level.
	 */
	maxLevel: number;

	/**
	 * Quantity Requested.
	 */
	quantityRequested: number;

	/**
	 * UOP.
	 */
	uop: string;

	/**
	 * Unit Price.
	 */
	unitPrice: number;

	/**
	 * Total Price.
	 */
	totalPrice: number;

	/**
	 * Item Status.
	 */
	itemStatus: string;

	/**
	 * Quantity Ordered.
	 */
	quantityOrdered: number;

	/**
	 * Quantity Received.
	 */
	quantityReceived: number;

	/**
	 * Quantity Returned.
	 */
	quantityReturned: number;

	/**
	 * Item Notes.
	 */
	itemNotes: string;

	/**
	 * Remaining Quantity.
	 */
	remainingQuantity: number;

	purchaseRequisitionId: string;

	purchaseRequisition: PurchaseRequisitionModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	purchaseOrderStockDetailsIds: string[] = [];

	purchaseOrderStockDetails: PurchaseOrderStockDetailModel[];

	modelPropGroups: { [s: string]: Group } = PurchaseRequisitionStockDetailModel.modelPropGroups;

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
				name: 'maxLevel',
				// % protected region % [Set displayName for Max Level here] off begin
				displayName: 'Max Level',
				// % protected region % [Set displayName for Max Level here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Max Level here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Max Level here] end
				// % protected region % [Set isSensitive for Max Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Max Level here] end
				// % protected region % [Set readonly for Max Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Max Level here] end
				validators: [
					// % protected region % [Add other validators for Max Level here] off begin
					// % protected region % [Add other validators for Max Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Max Level here] off begin
				// % protected region % [Add any additional model attribute properties for Max Level here] end
			},
			{
				name: 'quantityRequested',
				// % protected region % [Set displayName for Quantity Requested here] off begin
				displayName: 'Quantity Requested',
				// % protected region % [Set displayName for Quantity Requested here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Quantity Requested here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Quantity Requested here] end
				// % protected region % [Set isSensitive for Quantity Requested here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Quantity Requested here] end
				// % protected region % [Set readonly for Quantity Requested here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Quantity Requested here] end
				validators: [
					// % protected region % [Add other validators for Quantity Requested here] off begin
					// % protected region % [Add other validators for Quantity Requested here] end
				],
				// % protected region % [Add any additional model attribute properties for Quantity Requested here] off begin
				// % protected region % [Add any additional model attribute properties for Quantity Requested here] end
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
				name: 'totalPrice',
				// % protected region % [Set displayName for Total Price here] off begin
				displayName: 'Total Price',
				// % protected region % [Set displayName for Total Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Price here] end
				// % protected region % [Set isSensitive for Total Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Price here] end
				// % protected region % [Set readonly for Total Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Price here] end
				validators: [
					// % protected region % [Add other validators for Total Price here] off begin
					// % protected region % [Add other validators for Total Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Price here] off begin
				// % protected region % [Add any additional model attribute properties for Total Price here] end
			},
			{
				name: 'itemStatus',
				// % protected region % [Set displayName for Item Status here] off begin
				displayName: 'Item Status',
				// % protected region % [Set displayName for Item Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Item Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Item Status here] end
				// % protected region % [Set isSensitive for Item Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Item Status here] end
				// % protected region % [Set readonly for Item Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Item Status here] end
				validators: [
					// % protected region % [Add other validators for Item Status here] off begin
					// % protected region % [Add other validators for Item Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Item Status here] off begin
				// % protected region % [Add any additional model attribute properties for Item Status here] end
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
				name: 'quantityReturned',
				// % protected region % [Set displayName for Quantity Returned here] off begin
				displayName: 'Quantity Returned',
				// % protected region % [Set displayName for Quantity Returned here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Quantity Returned here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Quantity Returned here] end
				// % protected region % [Set isSensitive for Quantity Returned here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Quantity Returned here] end
				// % protected region % [Set readonly for Quantity Returned here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Quantity Returned here] end
				validators: [
					// % protected region % [Add other validators for Quantity Returned here] off begin
					// % protected region % [Add other validators for Quantity Returned here] end
				],
				// % protected region % [Add any additional model attribute properties for Quantity Returned here] off begin
				// % protected region % [Add any additional model attribute properties for Quantity Returned here] end
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
				name: 'remainingQuantity',
				// % protected region % [Set displayName for Remaining Quantity here] off begin
				displayName: 'Remaining Quantity',
				// % protected region % [Set displayName for Remaining Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Remaining Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Remaining Quantity here] end
				// % protected region % [Set isSensitive for Remaining Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Remaining Quantity here] end
				// % protected region % [Set readonly for Remaining Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Remaining Quantity here] end
				validators: [
					// % protected region % [Add other validators for Remaining Quantity here] off begin
					// % protected region % [Add other validators for Remaining Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Remaining Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Remaining Quantity here] end
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
				id: 'purchaseOrderStockDetails',
				type: ModelRelationType.MANY,
				name: 'purchaseOrderStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Order Stock Details here] off begin
				label: 'Purchase Order Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Order Stock Details here] end
				entityName: 'PurchaseOrderStockDetailModel',
				// % protected region % [Customise your display name for Purchase Order Stock Details here] off begin
				displayName: 'unitPrice',
				// % protected region % [Customise your display name for Purchase Order Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Purchase Order Stock Details here] off begin
					// % protected region % [Add other validators for Purchase Order Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional field for relation Purchase Order Stock Details here] end
			},
			{
				id: 'purchaseRequisition',
				type: ModelRelationType.ONE,
				name: 'purchaseRequisitionId',
				// % protected region % [Customise your label for Purchase Requisition here] off begin
				label: 'Purchase Requisition',
				// % protected region % [Customise your label for Purchase Requisition here] end
				entityName: 'PurchaseRequisitionModel',
				// % protected region % [Customise your display name for Purchase Requisition here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'purchaseRequisitionNumber',
				// % protected region % [Customise your display name for Purchase Requisition here] end
				validators: [
					// % protected region % [Add other validators for Purchase Requisition here] off begin
					// % protected region % [Add other validators for Purchase Requisition here] end
				],
				// % protected region % [Add any additional field for relation Purchase Requisition here] off begin
				// % protected region % [Add any additional field for relation Purchase Requisition here] end
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
	static deepParse(data: string | { [K in keyof PurchaseRequisitionStockDetailModel]?: PurchaseRequisitionStockDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PurchaseRequisitionStockDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.purchaseRequisition) {
			currentModel.purchaseRequisitionId = json.purchaseRequisition.id;
			returned = _.union(returned, PurchaseRequisitionModel.deepParse(json.purchaseRequisition));
		}

		// Incoming one to many
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}

		// Outgoing one to many
		if (json.purchaseOrderStockDetails) {
			currentModel.purchaseOrderStockDetailsIds = json.purchaseOrderStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.purchaseOrderStockDetails.map(model => PurchaseOrderStockDetailModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let purchaseRequisitionStockDetailModel = new PurchaseRequisitionStockDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the PurchaseRequisitionStockDetailModel,
	 *    it is expected as a JSON string or as a nullable PurchaseRequisitionStockDetailModel.
	 */
	constructor(data?: string | Partial<PurchaseRequisitionStockDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PurchaseRequisitionStockDetailModel>
				: data;

			this.soh = json.soh;
			this.maxLevel = json.maxLevel;
			this.quantityRequested = json.quantityRequested;
			this.uop = json.uop;
			this.unitPrice = json.unitPrice;
			this.totalPrice = json.totalPrice;
			this.itemStatus = json.itemStatus;
			this.quantityOrdered = json.quantityOrdered;
			this.quantityReceived = json.quantityReceived;
			this.quantityReturned = json.quantityReturned;
			this.itemNotes = json.itemNotes;
			this.remainingQuantity = json.remainingQuantity;
			this.purchaseRequisitionId = json.purchaseRequisitionId;
			this.purchaseRequisition = json.purchaseRequisition;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			this.purchaseOrderStockDetailsIds = json.purchaseOrderStockDetailsIds;
			this.purchaseOrderStockDetails = json.purchaseOrderStockDetails;
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
			maxLevel: this.maxLevel,
			quantityRequested: this.quantityRequested,
			uop: this.uop,
			unitPrice: this.unitPrice,
			totalPrice: this.totalPrice,
			itemStatus: this.itemStatus,
			quantityOrdered: this.quantityOrdered,
			quantityReceived: this.quantityReceived,
			quantityReturned: this.quantityReturned,
			itemNotes: this.itemNotes,
			remainingQuantity: this.remainingQuantity,
			purchaseRequisitionId: this.purchaseRequisitionId,
			stockCatalogueId: this.stockCatalogueId,
			purchaseOrderStockDetailsIds: this.purchaseOrderStockDetailsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PurchaseRequisitionStockDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PurchaseRequisitionStockDetailModel {
		let newModelJson = this.toJSON();

		if (updates.soh) {
			newModelJson.soh = updates.soh;
		}

		if (updates.maxLevel) {
			newModelJson.maxLevel = updates.maxLevel;
		}

		if (updates.quantityRequested) {
			newModelJson.quantityRequested = updates.quantityRequested;
		}

		if (updates.uop) {
			newModelJson.uop = updates.uop;
		}

		if (updates.unitPrice) {
			newModelJson.unitPrice = updates.unitPrice;
		}

		if (updates.totalPrice) {
			newModelJson.totalPrice = updates.totalPrice;
		}

		if (updates.itemStatus) {
			newModelJson.itemStatus = updates.itemStatus;
		}

		if (updates.quantityOrdered) {
			newModelJson.quantityOrdered = updates.quantityOrdered;
		}

		if (updates.quantityReceived) {
			newModelJson.quantityReceived = updates.quantityReceived;
		}

		if (updates.quantityReturned) {
			newModelJson.quantityReturned = updates.quantityReturned;
		}

		if (updates.itemNotes) {
			newModelJson.itemNotes = updates.itemNotes;
		}

		if (updates.remainingQuantity) {
			newModelJson.remainingQuantity = updates.remainingQuantity;
		}

		if (updates.purchaseRequisitionId) {
			newModelJson.purchaseRequisitionId = updates.purchaseRequisitionId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		if (updates.purchaseOrderStockDetailsIds) {
			newModelJson.purchaseOrderStockDetailsIds = updates.purchaseOrderStockDetailsIds;
		}

		return new PurchaseRequisitionStockDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PurchaseRequisitionStockDetailModel)) {
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
			'purchaseRequisitionId',
			'purchaseRequisition',
			'stockCatalogueId',
			'stockCatalogue',
			'purchaseOrderStockDetailsIds',
			'purchaseOrderStockDetails',
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
		if (!this.purchaseRequisition) {
			this.purchaseRequisitionId = null;
		} else {
			this.purchaseRequisitionId = this.purchaseRequisition.id;
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
