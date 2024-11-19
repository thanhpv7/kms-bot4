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
import {GrnSourceTypeEnum, grnSourceTypeEnumArray} from '../../enums/grn-source-type.enum';
import {GoodsReceiveNoteItemModel} from '../goodsReceiveNoteItem/goods_receive_note_item.model';
import {PurchaseOrderModel} from '../purchaseOrder/purchase_order.model';
import {SupplierModel} from '../supplier/supplier.model';
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
export class GoodsReceiveNoteModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'receiveNumber',
		'sourceDocumentType',
		'sourceDocumentNumber',
		'receiveDate',
		'approvalStatus',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'receiveNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'GoodsReceiveNoteModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return GoodsReceiveNoteModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * String and number combination..
	 */
	receiveNumber: string;

	/**
	 * .
	 */
	sourceDocumentNumber: string;

	/**
	 * .
	 */
	receiveDate: Date;

	/**
	 * .
	 */
	voidDate: Date;

	/**
	 * .
	 */
	approvalStatus: string;

	/**
	 * .
	 */
	notes: string;

	/**
	 * .
	 */
	supplierInvoiceNumber: string;

	/**
	 * .
	 */
	shippingMethod: string;

	/**
	 * .
	 */
	shippingNumber: string;

	/**
	 * .
	 */
	shippingDate: Date;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=3, example=Sally}.
	 */
	sourceDocumentType: GrnSourceTypeEnum;

	supplierId: string;

	supplier: SupplierModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	goodsReceiveNoteItemsIds: string[] = [];

	goodsReceiveNoteItems: GoodsReceiveNoteItemModel[];

	purchaseOrdersIds: string[] = [];

	purchaseOrders: PurchaseOrderModel[];

	modelPropGroups: { [s: string]: Group } = GoodsReceiveNoteModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'receiveNumber',
				// % protected region % [Set displayName for Receive Number here] off begin
				displayName: 'Receive Number',
				// % protected region % [Set displayName for Receive Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Receive Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Receive Number here] end
				// % protected region % [Set isSensitive for Receive Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Receive Number here] end
				// % protected region % [Set readonly for Receive Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Receive Number here] end
				validators: [
					// % protected region % [Add other validators for Receive Number here] off begin
					// % protected region % [Add other validators for Receive Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Receive Number here] off begin
				// % protected region % [Add any additional model attribute properties for Receive Number here] end
			},
			{
				name: 'sourceDocumentType',
				// % protected region % [Set displayName for Source Document Type here] off begin
				displayName: 'Source Document Type',
				// % protected region % [Set displayName for Source Document Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: grnSourceTypeEnumArray,
				// % protected region % [Set display element type for Source Document Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Source Document Type here] end
				// % protected region % [Set isSensitive for Source Document Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Source Document Type here] end
				// % protected region % [Set readonly for Source Document Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Source Document Type here] end
				validators: [
					// % protected region % [Add other validators for Source Document Type here] off begin
					// % protected region % [Add other validators for Source Document Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Source Document Type here] off begin
				// % protected region % [Add any additional model attribute properties for Source Document Type here] end
			},
			{
				name: 'sourceDocumentNumber',
				// % protected region % [Set displayName for Source Document Number here] off begin
				displayName: 'Source Document Number',
				// % protected region % [Set displayName for Source Document Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Source Document Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Source Document Number here] end
				// % protected region % [Set isSensitive for Source Document Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Source Document Number here] end
				// % protected region % [Set readonly for Source Document Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Source Document Number here] end
				validators: [
					// % protected region % [Add other validators for Source Document Number here] off begin
					// % protected region % [Add other validators for Source Document Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Source Document Number here] off begin
				// % protected region % [Add any additional model attribute properties for Source Document Number here] end
			},
			{
				name: 'receiveDate',
				// % protected region % [Set displayName for Receive Date here] off begin
				displayName: 'Receive Date',
				// % protected region % [Set displayName for Receive Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Receive Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Receive Date here] end
				// % protected region % [Set isSensitive for Receive Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Receive Date here] end
				// % protected region % [Set readonly for Receive Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Receive Date here] end
				validators: [
					// % protected region % [Add other validators for Receive Date here] off begin
					// % protected region % [Add other validators for Receive Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Receive Date here] off begin
				// % protected region % [Add any additional model attribute properties for Receive Date here] end
			},
			{
				name: 'voidDate',
				// % protected region % [Set displayName for Void Date here] off begin
				displayName: 'Void Date',
				// % protected region % [Set displayName for Void Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Void Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Void Date here] end
				// % protected region % [Set isSensitive for Void Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Void Date here] end
				// % protected region % [Set readonly for Void Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Void Date here] end
				validators: [
					// % protected region % [Add other validators for Void Date here] off begin
					// % protected region % [Add other validators for Void Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Void Date here] off begin
				// % protected region % [Add any additional model attribute properties for Void Date here] end
			},
			{
				name: 'approvalStatus',
				// % protected region % [Set displayName for Approval Status here] off begin
				displayName: 'Approval Status',
				// % protected region % [Set displayName for Approval Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Approval Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Approval Status here] end
				// % protected region % [Set isSensitive for Approval Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approval Status here] end
				// % protected region % [Set readonly for Approval Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approval Status here] end
				validators: [
					// % protected region % [Add other validators for Approval Status here] off begin
					// % protected region % [Add other validators for Approval Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Approval Status here] off begin
				// % protected region % [Add any additional model attribute properties for Approval Status here] end
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
			{
				name: 'supplierInvoiceNumber',
				// % protected region % [Set displayName for Supplier Invoice Number here] off begin
				displayName: 'Supplier Invoice Number',
				// % protected region % [Set displayName for Supplier Invoice Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Supplier Invoice Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Supplier Invoice Number here] end
				// % protected region % [Set isSensitive for Supplier Invoice Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Supplier Invoice Number here] end
				// % protected region % [Set readonly for Supplier Invoice Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Supplier Invoice Number here] end
				validators: [
					// % protected region % [Add other validators for Supplier Invoice Number here] off begin
					// % protected region % [Add other validators for Supplier Invoice Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Supplier Invoice Number here] off begin
				// % protected region % [Add any additional model attribute properties for Supplier Invoice Number here] end
			},
			{
				name: 'shippingMethod',
				// % protected region % [Set displayName for Shipping Method here] off begin
				displayName: 'Shipping Method',
				// % protected region % [Set displayName for Shipping Method here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Shipping Method here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Shipping Method here] end
				// % protected region % [Set isSensitive for Shipping Method here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Shipping Method here] end
				// % protected region % [Set readonly for Shipping Method here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Shipping Method here] end
				validators: [
					// % protected region % [Add other validators for Shipping Method here] off begin
					// % protected region % [Add other validators for Shipping Method here] end
				],
				// % protected region % [Add any additional model attribute properties for Shipping Method here] off begin
				// % protected region % [Add any additional model attribute properties for Shipping Method here] end
			},
			{
				name: 'shippingNumber',
				// % protected region % [Set displayName for Shipping Number here] off begin
				displayName: 'Shipping Number',
				// % protected region % [Set displayName for Shipping Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Shipping Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Shipping Number here] end
				// % protected region % [Set isSensitive for Shipping Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Shipping Number here] end
				// % protected region % [Set readonly for Shipping Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Shipping Number here] end
				validators: [
					// % protected region % [Add other validators for Shipping Number here] off begin
					// % protected region % [Add other validators for Shipping Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Shipping Number here] off begin
				// % protected region % [Add any additional model attribute properties for Shipping Number here] end
			},
			{
				name: 'shippingDate',
				// % protected region % [Set displayName for Shipping Date here] off begin
				displayName: 'Shipping Date',
				// % protected region % [Set displayName for Shipping Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Shipping Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Shipping Date here] end
				// % protected region % [Set isSensitive for Shipping Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Shipping Date here] end
				// % protected region % [Set readonly for Shipping Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Shipping Date here] end
				validators: [
					// % protected region % [Add other validators for Shipping Date here] off begin
					// % protected region % [Add other validators for Shipping Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Shipping Date here] off begin
				// % protected region % [Add any additional model attribute properties for Shipping Date here] end
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
				id: 'goodsReceiveNoteItems',
				type: ModelRelationType.MANY,
				name: 'goodsReceiveNoteItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Note Items here] off begin
				label: 'Goods Receive Note Items',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Note Items here] end
				entityName: 'GoodsReceiveNoteItemModel',
				// % protected region % [Customise your display name for Goods Receive Note Items here] off begin
				displayName: 'itemLineNumber',
				// % protected region % [Customise your display name for Goods Receive Note Items here] end
				validators: [
					// % protected region % [Add other validators for Goods Receive Note Items here] off begin
					// % protected region % [Add other validators for Goods Receive Note Items here] end
				],
				// % protected region % [Add any additional field for relation Goods Receive Note Items here] off begin
				// % protected region % [Add any additional field for relation Goods Receive Note Items here] end
			},
			{
				id: 'purchaseOrders',
				type: ModelRelationType.MANY,
				name: 'purchaseOrdersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Orders here] off begin
				label: 'Purchase Orders',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Orders here] end
				entityName: 'PurchaseOrderModel',
				// % protected region % [Customise your display name for Purchase Orders here] off begin
				displayName: 'purchaseOrderType',
				// % protected region % [Customise your display name for Purchase Orders here] end
				validators: [
					// % protected region % [Add other validators for Purchase Orders here] off begin
					// % protected region % [Add other validators for Purchase Orders here] end
				],
				// % protected region % [Add any additional field for relation Purchase Orders here] off begin
				// % protected region % [Add any additional field for relation Purchase Orders here] end
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
				case 'receiveNumber':
					break;
				case 'sourceDocumentType':
					conditions.push([
						{
							path: key,
							operation: QueryOperation.EQUAL,
							value: formGroup.value[key],
						}
					]);
					break;
				case 'sourceDocumentNumber':
					break;
				case 'receiveDate':
					break;
				case 'approvalStatus':
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
	static deepParse(data: string | { [K in keyof GoodsReceiveNoteModel]?: GoodsReceiveNoteModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new GoodsReceiveNoteModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.supplier) {
			currentModel.supplierId = json.supplier.id;
			returned = _.union(returned, SupplierModel.deepParse(json.supplier));
		}

		// Incoming one to many
		if (json.warehouse) {
			currentModel.warehouseId = json.warehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.warehouse));
		}

		// Outgoing one to many
		if (json.goodsReceiveNoteItems) {
			currentModel.goodsReceiveNoteItemsIds = json.goodsReceiveNoteItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.goodsReceiveNoteItems.map(model => GoodsReceiveNoteItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.purchaseOrders) {
			currentModel.purchaseOrdersIds = json.purchaseOrders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.purchaseOrders.map(model => PurchaseOrderModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let goodsReceiveNoteModel = new GoodsReceiveNoteModel(data);`
	 *
	 * @param data The input data to be initialised as the GoodsReceiveNoteModel,
	 *    it is expected as a JSON string or as a nullable GoodsReceiveNoteModel.
	 */
	constructor(data?: string | Partial<GoodsReceiveNoteModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<GoodsReceiveNoteModel>
				: data;

			this.receiveNumber = json.receiveNumber;
			this.sourceDocumentType = json.sourceDocumentType;
			this.sourceDocumentNumber = json.sourceDocumentNumber;
			if (json.receiveDate) {
				this.receiveDate = new Date(json.receiveDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.receiveDate = json.receiveDate;
			}
			if (json.voidDate) {
				this.voidDate = new Date(json.voidDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.voidDate = json.voidDate;
			}
			this.approvalStatus = json.approvalStatus;
			this.notes = json.notes;
			this.supplierInvoiceNumber = json.supplierInvoiceNumber;
			this.shippingMethod = json.shippingMethod;
			this.shippingNumber = json.shippingNumber;
			if (json.shippingDate) {
				this.shippingDate = new Date(json.shippingDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.shippingDate = json.shippingDate;
			}
			this.sourceDocumentType = json.sourceDocumentType;
			this.supplierId = json.supplierId;
			this.supplier = json.supplier;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			this.goodsReceiveNoteItemsIds = json.goodsReceiveNoteItemsIds;
			this.goodsReceiveNoteItems = json.goodsReceiveNoteItems;
			this.purchaseOrdersIds = json.purchaseOrdersIds;
			this.purchaseOrders = json.purchaseOrders;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			receiveNumber: this.receiveNumber,
			sourceDocumentType: this.sourceDocumentType,
			sourceDocumentNumber: this.sourceDocumentNumber,
			receiveDate: this.receiveDate,
			voidDate: this.voidDate,
			approvalStatus: this.approvalStatus,
			notes: this.notes,
			supplierInvoiceNumber: this.supplierInvoiceNumber,
			shippingMethod: this.shippingMethod,
			shippingNumber: this.shippingNumber,
			shippingDate: this.shippingDate,
			supplierId: this.supplierId,
			warehouseId: this.warehouseId,
			goodsReceiveNoteItemsIds: this.goodsReceiveNoteItemsIds,
			purchaseOrdersIds: this.purchaseOrdersIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		GoodsReceiveNoteModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): GoodsReceiveNoteModel {
		let newModelJson = this.toJSON();

		if (updates.receiveNumber) {
			newModelJson.receiveNumber = updates.receiveNumber;
		}

		if (updates.sourceDocumentType) {
			newModelJson.sourceDocumentType = updates.sourceDocumentType;
		}

		if (updates.sourceDocumentNumber) {
			newModelJson.sourceDocumentNumber = updates.sourceDocumentNumber;
		}

		if (updates.receiveDate) {
			newModelJson.receiveDate = updates.receiveDate;
		}

		if (updates.voidDate) {
			newModelJson.voidDate = updates.voidDate;
		}

		if (updates.approvalStatus) {
			newModelJson.approvalStatus = updates.approvalStatus;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.supplierInvoiceNumber) {
			newModelJson.supplierInvoiceNumber = updates.supplierInvoiceNumber;
		}

		if (updates.shippingMethod) {
			newModelJson.shippingMethod = updates.shippingMethod;
		}

		if (updates.shippingNumber) {
			newModelJson.shippingNumber = updates.shippingNumber;
		}

		if (updates.shippingDate) {
			newModelJson.shippingDate = updates.shippingDate;
		}

		if (updates.sourceDocumentType) {
			newModelJson.sourceDocumentType = updates.sourceDocumentType;
		}

		if (updates.supplierId) {
			newModelJson.supplierId = updates.supplierId;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		if (updates.goodsReceiveNoteItemsIds) {
			newModelJson.goodsReceiveNoteItemsIds = updates.goodsReceiveNoteItemsIds;
		}

		if (updates.purchaseOrdersIds) {
			newModelJson.purchaseOrdersIds = updates.purchaseOrdersIds;
		}

		return new GoodsReceiveNoteModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof GoodsReceiveNoteModel)) {
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
			'supplierId',
			'supplier',
			'warehouseId',
			'warehouse',
			'goodsReceiveNoteItemsIds',
			'goodsReceiveNoteItems',
			'purchaseOrdersIds',
			'purchaseOrders',
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
		if (!this.supplier) {
			this.supplierId = null;
		} else {
			this.supplierId = this.supplier.id;
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
