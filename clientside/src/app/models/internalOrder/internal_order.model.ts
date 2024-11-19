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
import {InternalOrderStockDetailModel} from '../internalOrderStockDetail/internal_order_stock_detail.model';
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
export class InternalOrderModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'internalOrderNumber',
		'transactionStatus',
		'approvalStatus',
		'orderDate',
		'expectedDate',
		'requestUnit',
		'requestPerson',
		'transactionDetailType',
		'referenceNumber',
		'notes',
		'voidDate',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'internalOrderNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InternalOrderModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InternalOrderModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Internal Order Number.
	 */
	internalOrderNumber: string;

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
	 * Request Unit.
	 */
	requestUnit: string;

	/**
	 * Request Person.
	 */
	requestPerson: string;

	/**
	 * Transaction Detail Type.
	 */
	transactionDetailType: string;

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
	 * Issued Date Time.
	 */
	issuedDateTime: Date;

	/**
	 * Received Date Time.
	 */
	receivedDateTime: Date;

	warehouseId: string;

	warehouse: WarehouseModel;

	internalOrderStockDetailsIds: string[] = [];

	internalOrderStockDetails: InternalOrderStockDetailModel[];

	modelPropGroups: { [s: string]: Group } = InternalOrderModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'internalOrderNumber',
				// % protected region % [Set displayName for Internal Order Number here] off begin
				displayName: 'Internal Order Number',
				// % protected region % [Set displayName for Internal Order Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Internal Order Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Internal Order Number here] end
				// % protected region % [Set isSensitive for Internal Order Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Internal Order Number here] end
				// % protected region % [Set readonly for Internal Order Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Internal Order Number here] end
				validators: [
					// % protected region % [Add other validators for Internal Order Number here] off begin
					// % protected region % [Add other validators for Internal Order Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Internal Order Number here] off begin
				// % protected region % [Add any additional model attribute properties for Internal Order Number here] end
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
				name: 'requestUnit',
				// % protected region % [Set displayName for Request Unit here] off begin
				displayName: 'Request Unit',
				// % protected region % [Set displayName for Request Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Request Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Request Unit here] end
				// % protected region % [Set isSensitive for Request Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Request Unit here] end
				// % protected region % [Set readonly for Request Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Request Unit here] end
				validators: [
					// % protected region % [Add other validators for Request Unit here] off begin
					// % protected region % [Add other validators for Request Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Request Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Request Unit here] end
			},
			{
				name: 'requestPerson',
				// % protected region % [Set displayName for Request Person here] off begin
				displayName: 'Request Person',
				// % protected region % [Set displayName for Request Person here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Request Person here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Request Person here] end
				// % protected region % [Set isSensitive for Request Person here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Request Person here] end
				// % protected region % [Set readonly for Request Person here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Request Person here] end
				validators: [
					// % protected region % [Add other validators for Request Person here] off begin
					// % protected region % [Add other validators for Request Person here] end
				],
				// % protected region % [Add any additional model attribute properties for Request Person here] off begin
				// % protected region % [Add any additional model attribute properties for Request Person here] end
			},
			{
				name: 'transactionDetailType',
				// % protected region % [Set displayName for Transaction Detail Type here] off begin
				displayName: 'Transaction Detail Type',
				// % protected region % [Set displayName for Transaction Detail Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transaction Detail Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transaction Detail Type here] end
				// % protected region % [Set isSensitive for Transaction Detail Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Detail Type here] end
				// % protected region % [Set readonly for Transaction Detail Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Detail Type here] end
				validators: [
					// % protected region % [Add other validators for Transaction Detail Type here] off begin
					// % protected region % [Add other validators for Transaction Detail Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Detail Type here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Detail Type here] end
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
				id: 'internalOrderStockDetails',
				type: ModelRelationType.MANY,
				name: 'internalOrderStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Internal Order Stock Details here] off begin
				label: 'Internal Order Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Internal Order Stock Details here] end
				entityName: 'InternalOrderStockDetailModel',
				// % protected region % [Customise your display name for Internal Order Stock Details here] off begin
				displayName: 'itemNumber',
				// % protected region % [Customise your display name for Internal Order Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Internal Order Stock Details here] off begin
					// % protected region % [Add other validators for Internal Order Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Internal Order Stock Details here] off begin
				// % protected region % [Add any additional field for relation Internal Order Stock Details here] end
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
				case 'internalOrderNumber':
					break;
				case 'transactionStatus':
					break;
				case 'approvalStatus':
					break;
				case 'orderDate':
					break;
				case 'expectedDate':
					break;
				case 'requestUnit':
					break;
				case 'requestPerson':
					break;
				case 'transactionDetailType':
					break;
				case 'referenceNumber':
					break;
				case 'notes':
					break;
				case 'voidDate':
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
	static deepParse(data: string | { [K in keyof InternalOrderModel]?: InternalOrderModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InternalOrderModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.warehouse) {
			currentModel.warehouseId = json.warehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.warehouse));
		}

		// Outgoing one to many
		if (json.internalOrderStockDetails) {
			currentModel.internalOrderStockDetailsIds = json.internalOrderStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.internalOrderStockDetails.map(model => InternalOrderStockDetailModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let internalOrderModel = new InternalOrderModel(data);`
	 *
	 * @param data The input data to be initialised as the InternalOrderModel,
	 *    it is expected as a JSON string or as a nullable InternalOrderModel.
	 */
	constructor(data?: string | Partial<InternalOrderModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InternalOrderModel>
				: data;

			this.internalOrderNumber = json.internalOrderNumber;
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
			this.requestUnit = json.requestUnit;
			this.requestPerson = json.requestPerson;
			this.transactionDetailType = json.transactionDetailType;
			this.referenceNumber = json.referenceNumber;
			this.notes = json.notes;
			if (json.voidDate) {
				this.voidDate = new Date(json.voidDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.voidDate = json.voidDate;
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
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			this.internalOrderStockDetailsIds = json.internalOrderStockDetailsIds;
			this.internalOrderStockDetails = json.internalOrderStockDetails;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			internalOrderNumber: this.internalOrderNumber,
			transactionStatus: this.transactionStatus,
			approvalStatus: this.approvalStatus,
			orderDate: this.orderDate,
			expectedDate: this.expectedDate,
			requestUnit: this.requestUnit,
			requestPerson: this.requestPerson,
			transactionDetailType: this.transactionDetailType,
			referenceNumber: this.referenceNumber,
			notes: this.notes,
			voidDate: this.voidDate,
			issuedDateTime: this.issuedDateTime,
			receivedDateTime: this.receivedDateTime,
			warehouseId: this.warehouseId,
			internalOrderStockDetailsIds: this.internalOrderStockDetailsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InternalOrderModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InternalOrderModel {
		let newModelJson = this.toJSON();

		if (updates.internalOrderNumber) {
			newModelJson.internalOrderNumber = updates.internalOrderNumber;
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

		if (updates.requestUnit) {
			newModelJson.requestUnit = updates.requestUnit;
		}

		if (updates.requestPerson) {
			newModelJson.requestPerson = updates.requestPerson;
		}

		if (updates.transactionDetailType) {
			newModelJson.transactionDetailType = updates.transactionDetailType;
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

		if (updates.issuedDateTime) {
			newModelJson.issuedDateTime = updates.issuedDateTime;
		}

		if (updates.receivedDateTime) {
			newModelJson.receivedDateTime = updates.receivedDateTime;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		if (updates.internalOrderStockDetailsIds) {
			newModelJson.internalOrderStockDetailsIds = updates.internalOrderStockDetailsIds;
		}

		return new InternalOrderModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InternalOrderModel)) {
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
			'internalOrderStockDetailsIds',
			'internalOrderStockDetails',
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
