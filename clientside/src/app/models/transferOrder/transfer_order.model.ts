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
import {TransferOrderStockDetailModel} from '../transferOrderStockDetail/transfer_order_stock_detail.model';
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
export class TransferOrderModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'transferOrderNumber',
		'transactionStatus',
		'approvalStatus',
		'orderDate',
		'expectedDate',
		'referenceNumber',
		'notes',
		'voidDate',
		'referenceDocument',
		'requiredDate',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'transferOrderNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'TransferOrderModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return TransferOrderModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Transfer Order Number.
	 */
	transferOrderNumber: string;

	/**
	 * Transaction Status.
	 */
	transactionStatus: string;

	/**
	 * Approval Status.
	 */
	approvalStatus: string;

	/**
	 * Order Date.
	 */
	orderDate: Date;

	/**
	 * Expected Date.
	 */
	expectedDate: Date;

	/**
	 * Reference Number.
	 */
	referenceNumber: string;

	/**
	 * Notes.
	 */
	notes: string;

	/**
	 * Void Date.
	 */
	voidDate: Date;

	/**
	 * Reference Document.
	 */
	referenceDocument: string;

	/**
	 * Required Date.
	 */
	requiredDate: Date;

	/**
	 * Issued Date Time.
	 */
	issuedDateTime: Date;

	/**
	 * Received Date Time.
	 */
	receivedDateTime: Date;

	destinationWarehouseId: string;

	destinationWarehouse: WarehouseModel;

	sourceWarehouseId: string;

	sourceWarehouse: WarehouseModel;

	transferOrderStockDetailsIds: string[] = [];

	transferOrderStockDetails: TransferOrderStockDetailModel[];

	modelPropGroups: { [s: string]: Group } = TransferOrderModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'transferOrderNumber',
				// % protected region % [Set displayName for Transfer Order Number here] off begin
				displayName: 'Transfer Order Number',
				// % protected region % [Set displayName for Transfer Order Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transfer Order Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transfer Order Number here] end
				// % protected region % [Set isSensitive for Transfer Order Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transfer Order Number here] end
				// % protected region % [Set readonly for Transfer Order Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transfer Order Number here] end
				validators: [
					// % protected region % [Add other validators for Transfer Order Number here] off begin
					// % protected region % [Add other validators for Transfer Order Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Transfer Order Number here] off begin
				// % protected region % [Add any additional model attribute properties for Transfer Order Number here] end
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
				name: 'expectedDate',
				// % protected region % [Set displayName for Expected Date here] off begin
				displayName: 'Expected Date',
				// % protected region % [Set displayName for Expected Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Expected Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Expected Date here] end
				// % protected region % [Set isSensitive for Expected Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Expected Date here] end
				// % protected region % [Set readonly for Expected Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Expected Date here] end
				validators: [
					// % protected region % [Add other validators for Expected Date here] off begin
					// % protected region % [Add other validators for Expected Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Expected Date here] off begin
				// % protected region % [Add any additional model attribute properties for Expected Date here] end
			},
			{
				name: 'referenceNumber',
				// % protected region % [Set displayName for Reference Number here] off begin
				displayName: 'Reference Number',
				// % protected region % [Set displayName for Reference Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Reference Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Reference Number here] end
				// % protected region % [Set isSensitive for Reference Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Reference Number here] end
				// % protected region % [Set readonly for Reference Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Reference Number here] end
				validators: [
					// % protected region % [Add other validators for Reference Number here] off begin
					// % protected region % [Add other validators for Reference Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Reference Number here] off begin
				// % protected region % [Add any additional model attribute properties for Reference Number here] end
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
				name: 'issuedDateTime',
				// % protected region % [Set displayName for Issued Date Time here] off begin
				displayName: 'Issued Date Time',
				// % protected region % [Set displayName for Issued Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Issued Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Issued Date Time here] end
				// % protected region % [Set isSensitive for Issued Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Issued Date Time here] end
				// % protected region % [Set readonly for Issued Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Issued Date Time here] end
				validators: [
					// % protected region % [Add other validators for Issued Date Time here] off begin
					// % protected region % [Add other validators for Issued Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Issued Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Issued Date Time here] end
			},
			{
				name: 'receivedDateTime',
				// % protected region % [Set displayName for Received Date Time here] off begin
				displayName: 'Received Date Time',
				// % protected region % [Set displayName for Received Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Received Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Received Date Time here] end
				// % protected region % [Set isSensitive for Received Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Received Date Time here] end
				// % protected region % [Set readonly for Received Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Received Date Time here] end
				validators: [
					// % protected region % [Add other validators for Received Date Time here] off begin
					// % protected region % [Add other validators for Received Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Received Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Received Date Time here] end
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
				id: 'transferOrderStockDetails',
				type: ModelRelationType.MANY,
				name: 'transferOrderStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Transfer Order Stock Details here] off begin
				label: 'Transfer Order Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Transfer Order Stock Details here] end
				entityName: 'TransferOrderStockDetailModel',
				// % protected region % [Customise your display name for Transfer Order Stock Details here] off begin
				displayName: 'itemNumber',
				// % protected region % [Customise your display name for Transfer Order Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Transfer Order Stock Details here] off begin
					// % protected region % [Add other validators for Transfer Order Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional field for relation Transfer Order Stock Details here] end
			},
			{
				id: 'destinationWarehouse',
				type: ModelRelationType.ONE,
				name: 'destinationWarehouseId',
				// % protected region % [Customise your label for Destination Warehouse here] off begin
				label: 'Destination Warehouse',
				// % protected region % [Customise your label for Destination Warehouse here] end
				entityName: 'WarehouseModel',
				// % protected region % [Customise your display name for Destination Warehouse here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'warehouseNumber',
				// % protected region % [Customise your display name for Destination Warehouse here] end
				validators: [
					// % protected region % [Add other validators for Destination Warehouse here] off begin
					// % protected region % [Add other validators for Destination Warehouse here] end
				],
				// % protected region % [Add any additional field for relation Destination Warehouse here] off begin
				// % protected region % [Add any additional field for relation Destination Warehouse here] end
			},
			{
				id: 'sourceWarehouse',
				type: ModelRelationType.ONE,
				name: 'sourceWarehouseId',
				// % protected region % [Customise your label for Source Warehouse here] off begin
				label: 'Source Warehouse',
				// % protected region % [Customise your label for Source Warehouse here] end
				entityName: 'WarehouseModel',
				// % protected region % [Customise your display name for Source Warehouse here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'warehouseNumber',
				// % protected region % [Customise your display name for Source Warehouse here] end
				validators: [
					// % protected region % [Add other validators for Source Warehouse here] off begin
					// % protected region % [Add other validators for Source Warehouse here] end
				],
				// % protected region % [Add any additional field for relation Source Warehouse here] off begin
				// % protected region % [Add any additional field for relation Source Warehouse here] end
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
				case 'transferOrderNumber':
					break;
				case 'transactionStatus':
					break;
				case 'approvalStatus':
					break;
				case 'orderDate':
					break;
				case 'expectedDate':
					break;
				case 'referenceNumber':
					break;
				case 'notes':
					break;
				case 'voidDate':
					break;
				case 'referenceDocument':
					break;
				case 'requiredDate':
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
	static deepParse(data: string | { [K in keyof TransferOrderModel]?: TransferOrderModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new TransferOrderModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.destinationWarehouse) {
			currentModel.destinationWarehouseId = json.destinationWarehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.destinationWarehouse));
		}

		// Incoming one to many
		if (json.sourceWarehouse) {
			currentModel.sourceWarehouseId = json.sourceWarehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.sourceWarehouse));
		}

		// Outgoing one to many
		if (json.transferOrderStockDetails) {
			currentModel.transferOrderStockDetailsIds = json.transferOrderStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.transferOrderStockDetails.map(model => TransferOrderStockDetailModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let transferOrderModel = new TransferOrderModel(data);`
	 *
	 * @param data The input data to be initialised as the TransferOrderModel,
	 *    it is expected as a JSON string or as a nullable TransferOrderModel.
	 */
	constructor(data?: string | Partial<TransferOrderModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<TransferOrderModel>
				: data;

			this.transferOrderNumber = json.transferOrderNumber;
			this.transactionStatus = json.transactionStatus;
			this.approvalStatus = json.approvalStatus;
			if (json.orderDate) {
				this.orderDate = new Date(json.orderDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.orderDate = json.orderDate;
			}
			if (json.expectedDate) {
				this.expectedDate = new Date(json.expectedDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.expectedDate = json.expectedDate;
			}
			this.referenceNumber = json.referenceNumber;
			this.notes = json.notes;
			if (json.voidDate) {
				this.voidDate = new Date(json.voidDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.voidDate = json.voidDate;
			}
			this.referenceDocument = json.referenceDocument;
			if (json.requiredDate) {
				this.requiredDate = new Date(json.requiredDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.requiredDate = json.requiredDate;
			}
			if (json.issuedDateTime) {
				this.issuedDateTime = new Date(json.issuedDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.issuedDateTime = json.issuedDateTime;
			}
			if (json.receivedDateTime) {
				this.receivedDateTime = new Date(json.receivedDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.receivedDateTime = json.receivedDateTime;
			}
			this.destinationWarehouseId = json.destinationWarehouseId;
			this.destinationWarehouse = json.destinationWarehouse;
			this.sourceWarehouseId = json.sourceWarehouseId;
			this.sourceWarehouse = json.sourceWarehouse;
			this.transferOrderStockDetailsIds = json.transferOrderStockDetailsIds;
			this.transferOrderStockDetails = json.transferOrderStockDetails;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			transferOrderNumber: this.transferOrderNumber,
			transactionStatus: this.transactionStatus,
			approvalStatus: this.approvalStatus,
			orderDate: this.orderDate,
			expectedDate: this.expectedDate,
			referenceNumber: this.referenceNumber,
			notes: this.notes,
			voidDate: this.voidDate,
			referenceDocument: this.referenceDocument,
			requiredDate: this.requiredDate,
			issuedDateTime: this.issuedDateTime,
			receivedDateTime: this.receivedDateTime,
			destinationWarehouseId: this.destinationWarehouseId,
			sourceWarehouseId: this.sourceWarehouseId,
			transferOrderStockDetailsIds: this.transferOrderStockDetailsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		TransferOrderModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): TransferOrderModel {
		let newModelJson = this.toJSON();

		if (updates.transferOrderNumber) {
			newModelJson.transferOrderNumber = updates.transferOrderNumber;
		}

		if (updates.transactionStatus) {
			newModelJson.transactionStatus = updates.transactionStatus;
		}

		if (updates.approvalStatus) {
			newModelJson.approvalStatus = updates.approvalStatus;
		}

		if (updates.orderDate) {
			newModelJson.orderDate = updates.orderDate;
		}

		if (updates.expectedDate) {
			newModelJson.expectedDate = updates.expectedDate;
		}

		if (updates.referenceNumber) {
			newModelJson.referenceNumber = updates.referenceNumber;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.voidDate) {
			newModelJson.voidDate = updates.voidDate;
		}

		if (updates.referenceDocument) {
			newModelJson.referenceDocument = updates.referenceDocument;
		}

		if (updates.requiredDate) {
			newModelJson.requiredDate = updates.requiredDate;
		}

		if (updates.issuedDateTime) {
			newModelJson.issuedDateTime = updates.issuedDateTime;
		}

		if (updates.receivedDateTime) {
			newModelJson.receivedDateTime = updates.receivedDateTime;
		}

		if (updates.destinationWarehouseId) {
			newModelJson.destinationWarehouseId = updates.destinationWarehouseId;
		}

		if (updates.sourceWarehouseId) {
			newModelJson.sourceWarehouseId = updates.sourceWarehouseId;
		}

		if (updates.transferOrderStockDetailsIds) {
			newModelJson.transferOrderStockDetailsIds = updates.transferOrderStockDetailsIds;
		}

		return new TransferOrderModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof TransferOrderModel)) {
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
			'destinationWarehouseId',
			'destinationWarehouse',
			'sourceWarehouseId',
			'sourceWarehouse',
			'transferOrderStockDetailsIds',
			'transferOrderStockDetails',
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
		if (!this.destinationWarehouse) {
			this.destinationWarehouseId = null;
		} else {
			this.destinationWarehouseId = this.destinationWarehouse.id;
		}

		if (!this.sourceWarehouse) {
			this.sourceWarehouseId = null;
		} else {
			this.sourceWarehouseId = this.sourceWarehouse.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
