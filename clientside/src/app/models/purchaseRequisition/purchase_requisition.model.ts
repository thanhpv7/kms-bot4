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
import {PurchaseOrderModel} from '../purchaseOrder/purchase_order.model';
import {PurchaseRequisitionStockDetailModel} from '../purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model';
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
export class PurchaseRequisitionModel extends AbstractModel {
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
		'purchaseRequisitionNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PurchaseRequisitionModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PurchaseRequisitionModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Purchase Requisition Number.
	 */
	purchaseRequisitionNumber: string;

	/**
	 * Transaction Status.
	 */
	transactionStatus: string;

	/**
	 * Reference Document.
	 */
	referenceDocument: string;

	/**
	 * Notes.
	 */
	notes: string;

	/**
	 * Order Date.
	 */
	orderDate: Date;

	/**
	 * Required Date.
	 */
	requiredDate: Date;

	/**
	 * Total Estimation Order.
	 */
	totalEstimationOrder: number;

	/**
	 * Redrafting Date Time.
	 */
	redraftingDateTime: Date;

	/**
	 * Submission Date Time.
	 */
	submissionDateTime: Date;

	/**
	 * Approval Date Time.
	 */
	approvalDateTime: Date;

	/**
	 * Rejection Date Time.
	 */
	rejectionDateTime: Date;

	/**
	 * Voiding Date Time.
	 */
	voidingDateTime: Date;

	purchaseOrderId: string;

	purchaseOrder: PurchaseOrderModel;

	supplierId: string;

	supplier: SupplierModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	purchaseRequisitionStockDetailsIds: string[] = [];

	purchaseRequisitionStockDetails: PurchaseRequisitionStockDetailModel[];

	modelPropGroups: { [s: string]: Group } = PurchaseRequisitionModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'purchaseRequisitionNumber',
				// % protected region % [Set displayName for Purchase Requisition Number here] off begin
				displayName: 'Purchase Requisition Number',
				// % protected region % [Set displayName for Purchase Requisition Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Purchase Requisition Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Purchase Requisition Number here] end
				// % protected region % [Set isSensitive for Purchase Requisition Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Purchase Requisition Number here] end
				// % protected region % [Set readonly for Purchase Requisition Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Purchase Requisition Number here] end
				validators: [
					// % protected region % [Add other validators for Purchase Requisition Number here] off begin
					// % protected region % [Add other validators for Purchase Requisition Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Purchase Requisition Number here] off begin
				// % protected region % [Add any additional model attribute properties for Purchase Requisition Number here] end
			},
			{
				name: 'transactionStatus',
				// % protected region % [Set displayName for Transaction Status here] off begin
				displayName: 'Transaction Status',
				// % protected region % [Set displayName for Transaction Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transaction Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transaction Status here] end
				// % protected region % [Set isSensitive for Transaction Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Status here] end
				// % protected region % [Set readonly for Transaction Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Status here] end
				validators: [
					// % protected region % [Add other validators for Transaction Status here] off begin
					// % protected region % [Add other validators for Transaction Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Status here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Status here] end
			},
			{
				name: 'referenceDocument',
				// % protected region % [Set displayName for Reference Document here] off begin
				displayName: 'Reference Document',
				// % protected region % [Set displayName for Reference Document here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Reference Document here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Reference Document here] end
				// % protected region % [Set isSensitive for Reference Document here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Reference Document here] end
				// % protected region % [Set readonly for Reference Document here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Reference Document here] end
				validators: [
					// % protected region % [Add other validators for Reference Document here] off begin
					// % protected region % [Add other validators for Reference Document here] end
				],
				// % protected region % [Add any additional model attribute properties for Reference Document here] off begin
				// % protected region % [Add any additional model attribute properties for Reference Document here] end
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
				name: 'orderDate',
				// % protected region % [Set displayName for Order Date here] off begin
				displayName: 'Order Date',
				// % protected region % [Set displayName for Order Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Order Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Order Date here] end
				// % protected region % [Set isSensitive for Order Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Order Date here] end
				// % protected region % [Set readonly for Order Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Order Date here] end
				validators: [
					// % protected region % [Add other validators for Order Date here] off begin
					// % protected region % [Add other validators for Order Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Order Date here] off begin
				// % protected region % [Add any additional model attribute properties for Order Date here] end
			},
			{
				name: 'requiredDate',
				// % protected region % [Set displayName for Required Date here] off begin
				displayName: 'Required Date',
				// % protected region % [Set displayName for Required Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Required Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Required Date here] end
				// % protected region % [Set isSensitive for Required Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Required Date here] end
				// % protected region % [Set readonly for Required Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Required Date here] end
				validators: [
					// % protected region % [Add other validators for Required Date here] off begin
					// % protected region % [Add other validators for Required Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Required Date here] off begin
				// % protected region % [Add any additional model attribute properties for Required Date here] end
			},
			{
				name: 'totalEstimationOrder',
				// % protected region % [Set displayName for Total Estimation Order here] off begin
				displayName: 'Total Estimation Order',
				// % protected region % [Set displayName for Total Estimation Order here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Estimation Order here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Estimation Order here] end
				// % protected region % [Set isSensitive for Total Estimation Order here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Estimation Order here] end
				// % protected region % [Set readonly for Total Estimation Order here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Estimation Order here] end
				validators: [
					// % protected region % [Add other validators for Total Estimation Order here] off begin
					// % protected region % [Add other validators for Total Estimation Order here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Estimation Order here] off begin
				// % protected region % [Add any additional model attribute properties for Total Estimation Order here] end
			},
			{
				name: 'redraftingDateTime',
				// % protected region % [Set displayName for Redrafting Date Time here] off begin
				displayName: 'Redrafting Date Time',
				// % protected region % [Set displayName for Redrafting Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Redrafting Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Redrafting Date Time here] end
				// % protected region % [Set isSensitive for Redrafting Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Redrafting Date Time here] end
				// % protected region % [Set readonly for Redrafting Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Redrafting Date Time here] end
				validators: [
					// % protected region % [Add other validators for Redrafting Date Time here] off begin
					// % protected region % [Add other validators for Redrafting Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Redrafting Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Redrafting Date Time here] end
			},
			{
				name: 'submissionDateTime',
				// % protected region % [Set displayName for Submission Date Time here] off begin
				displayName: 'Submission Date Time',
				// % protected region % [Set displayName for Submission Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Submission Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Submission Date Time here] end
				// % protected region % [Set isSensitive for Submission Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Submission Date Time here] end
				// % protected region % [Set readonly for Submission Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Submission Date Time here] end
				validators: [
					// % protected region % [Add other validators for Submission Date Time here] off begin
					// % protected region % [Add other validators for Submission Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Submission Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Submission Date Time here] end
			},
			{
				name: 'approvalDateTime',
				// % protected region % [Set displayName for Approval Date Time here] off begin
				displayName: 'Approval Date Time',
				// % protected region % [Set displayName for Approval Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Approval Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Approval Date Time here] end
				// % protected region % [Set isSensitive for Approval Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approval Date Time here] end
				// % protected region % [Set readonly for Approval Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approval Date Time here] end
				validators: [
					// % protected region % [Add other validators for Approval Date Time here] off begin
					// % protected region % [Add other validators for Approval Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Approval Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Approval Date Time here] end
			},
			{
				name: 'rejectionDateTime',
				// % protected region % [Set displayName for Rejection Date Time here] off begin
				displayName: 'Rejection Date Time',
				// % protected region % [Set displayName for Rejection Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Rejection Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Rejection Date Time here] end
				// % protected region % [Set isSensitive for Rejection Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Rejection Date Time here] end
				// % protected region % [Set readonly for Rejection Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Rejection Date Time here] end
				validators: [
					// % protected region % [Add other validators for Rejection Date Time here] off begin
					// % protected region % [Add other validators for Rejection Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Rejection Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Rejection Date Time here] end
			},
			{
				name: 'voidingDateTime',
				// % protected region % [Set displayName for Voiding Date Time here] off begin
				displayName: 'Voiding Date Time',
				// % protected region % [Set displayName for Voiding Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Voiding Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Voiding Date Time here] end
				// % protected region % [Set isSensitive for Voiding Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Voiding Date Time here] end
				// % protected region % [Set readonly for Voiding Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Voiding Date Time here] end
				validators: [
					// % protected region % [Add other validators for Voiding Date Time here] off begin
					// % protected region % [Add other validators for Voiding Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Voiding Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Voiding Date Time here] end
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
				id: 'purchaseRequisitionStockDetails',
				type: ModelRelationType.MANY,
				name: 'purchaseRequisitionStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Requisition Stock Details here] off begin
				label: 'Purchase Requisition Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Requisition Stock Details here] end
				entityName: 'PurchaseRequisitionStockDetailModel',
				// % protected region % [Customise your display name for Purchase Requisition Stock Details here] off begin
				displayName: 'soh',
				// % protected region % [Customise your display name for Purchase Requisition Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Purchase Requisition Stock Details here] off begin
					// % protected region % [Add other validators for Purchase Requisition Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Purchase Requisition Stock Details here] off begin
				// % protected region % [Add any additional field for relation Purchase Requisition Stock Details here] end
			},
			{
				id: 'purchaseOrder',
				type: ModelRelationType.ONE,
				name: 'purchaseOrderId',
				// % protected region % [Customise your label for Purchase Order here] off begin
				label: 'Purchase Order',
				// % protected region % [Customise your label for Purchase Order here] end
				entityName: 'PurchaseOrderModel',
				// % protected region % [Customise your display name for Purchase Order here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'purchaseOrderType',
				// % protected region % [Customise your display name for Purchase Order here] end
				validators: [
					// % protected region % [Add other validators for Purchase Order here] off begin
					// % protected region % [Add other validators for Purchase Order here] end
				],
				// % protected region % [Add any additional field for relation Purchase Order here] off begin
				// % protected region % [Add any additional field for relation Purchase Order here] end
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
	static deepParse(data: string | { [K in keyof PurchaseRequisitionModel]?: PurchaseRequisitionModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PurchaseRequisitionModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.purchaseOrder) {
			currentModel.purchaseOrderId = json.purchaseOrder.id;
			returned = _.union(returned, PurchaseOrderModel.deepParse(json.purchaseOrder));
		}

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
		if (json.purchaseRequisitionStockDetails) {
			currentModel.purchaseRequisitionStockDetailsIds = json.purchaseRequisitionStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.purchaseRequisitionStockDetails.map(model => PurchaseRequisitionStockDetailModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let purchaseRequisitionModel = new PurchaseRequisitionModel(data);`
	 *
	 * @param data The input data to be initialised as the PurchaseRequisitionModel,
	 *    it is expected as a JSON string or as a nullable PurchaseRequisitionModel.
	 */
	constructor(data?: string | Partial<PurchaseRequisitionModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PurchaseRequisitionModel>
				: data;

			this.purchaseRequisitionNumber = json.purchaseRequisitionNumber;
			this.transactionStatus = json.transactionStatus;
			this.referenceDocument = json.referenceDocument;
			this.notes = json.notes;
			if (json.orderDate) {
				this.orderDate = new Date(json.orderDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.orderDate = json.orderDate;
			}
			if (json.requiredDate) {
				this.requiredDate = new Date(json.requiredDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.requiredDate = json.requiredDate;
			}
			this.totalEstimationOrder = json.totalEstimationOrder;
			if (json.redraftingDateTime) {
				this.redraftingDateTime = new Date(json.redraftingDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.redraftingDateTime = json.redraftingDateTime;
			}
			if (json.submissionDateTime) {
				this.submissionDateTime = new Date(json.submissionDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.submissionDateTime = json.submissionDateTime;
			}
			if (json.approvalDateTime) {
				this.approvalDateTime = new Date(json.approvalDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.approvalDateTime = json.approvalDateTime;
			}
			if (json.rejectionDateTime) {
				this.rejectionDateTime = new Date(json.rejectionDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.rejectionDateTime = json.rejectionDateTime;
			}
			if (json.voidingDateTime) {
				this.voidingDateTime = new Date(json.voidingDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.voidingDateTime = json.voidingDateTime;
			}
			this.purchaseOrderId = json.purchaseOrderId;
			this.purchaseOrder = json.purchaseOrder;
			this.supplierId = json.supplierId;
			this.supplier = json.supplier;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			this.purchaseRequisitionStockDetailsIds = json.purchaseRequisitionStockDetailsIds;
			this.purchaseRequisitionStockDetails = json.purchaseRequisitionStockDetails;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			purchaseRequisitionNumber: this.purchaseRequisitionNumber,
			transactionStatus: this.transactionStatus,
			referenceDocument: this.referenceDocument,
			notes: this.notes,
			orderDate: this.orderDate,
			requiredDate: this.requiredDate,
			totalEstimationOrder: this.totalEstimationOrder,
			redraftingDateTime: this.redraftingDateTime,
			submissionDateTime: this.submissionDateTime,
			approvalDateTime: this.approvalDateTime,
			rejectionDateTime: this.rejectionDateTime,
			voidingDateTime: this.voidingDateTime,
			purchaseOrderId: this.purchaseOrderId,
			supplierId: this.supplierId,
			warehouseId: this.warehouseId,
			purchaseRequisitionStockDetailsIds: this.purchaseRequisitionStockDetailsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PurchaseRequisitionModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PurchaseRequisitionModel {
		let newModelJson = this.toJSON();

		if (updates.purchaseRequisitionNumber) {
			newModelJson.purchaseRequisitionNumber = updates.purchaseRequisitionNumber;
		}

		if (updates.transactionStatus) {
			newModelJson.transactionStatus = updates.transactionStatus;
		}

		if (updates.referenceDocument) {
			newModelJson.referenceDocument = updates.referenceDocument;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.orderDate) {
			newModelJson.orderDate = updates.orderDate;
		}

		if (updates.requiredDate) {
			newModelJson.requiredDate = updates.requiredDate;
		}

		if (updates.totalEstimationOrder) {
			newModelJson.totalEstimationOrder = updates.totalEstimationOrder;
		}

		if (updates.redraftingDateTime) {
			newModelJson.redraftingDateTime = updates.redraftingDateTime;
		}

		if (updates.submissionDateTime) {
			newModelJson.submissionDateTime = updates.submissionDateTime;
		}

		if (updates.approvalDateTime) {
			newModelJson.approvalDateTime = updates.approvalDateTime;
		}

		if (updates.rejectionDateTime) {
			newModelJson.rejectionDateTime = updates.rejectionDateTime;
		}

		if (updates.voidingDateTime) {
			newModelJson.voidingDateTime = updates.voidingDateTime;
		}

		if (updates.purchaseOrderId) {
			newModelJson.purchaseOrderId = updates.purchaseOrderId;
		}

		if (updates.supplierId) {
			newModelJson.supplierId = updates.supplierId;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		if (updates.purchaseRequisitionStockDetailsIds) {
			newModelJson.purchaseRequisitionStockDetailsIds = updates.purchaseRequisitionStockDetailsIds;
		}

		return new PurchaseRequisitionModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PurchaseRequisitionModel)) {
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
			'purchaseOrderId',
			'purchaseOrder',
			'supplierId',
			'supplier',
			'warehouseId',
			'warehouse',
			'purchaseRequisitionStockDetailsIds',
			'purchaseRequisitionStockDetails',
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
		if (!this.purchaseOrder) {
			this.purchaseOrderId = null;
		} else {
			this.purchaseOrderId = this.purchaseOrder.id;
		}

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
