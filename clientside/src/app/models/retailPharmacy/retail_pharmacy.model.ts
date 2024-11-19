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
import {PatientGeneralInfoModel} from '../patientGeneralInfo/patient_general_info.model';
import {RetailPharmacyInvoiceModel} from '../retailPharmacyInvoice/retail_pharmacy_invoice.model';
import {RetailPharmacyStockDetailModel} from '../retailPharmacyStockDetail/retail_pharmacy_stock_detail.model';
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
export class RetailPharmacyModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'customerType',
		'status',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'customerType',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'RetailPharmacyModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return RetailPharmacyModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Customer Type.
	 */
	customerType: string;

	/**
	 * Retail Number.
	 */
	retailNumber: string;

	/**
	 * Status.
	 */
	status: string;

	/**
	 * Customer Name.
	 */
	customerName: string;

	/**
	 * Address.
	 */
	address: string;

	/**
	 * Phone Number.
	 */
	phoneNumber: string;

	/**
	 * Notes.
	 */
	notes: string;

	/**
	 * Payment Status.
	 */
	paymentStatus: string;

	/**
	 * Total Price.
	 */
	totalPrice: number;

	patientGeneralInfoId: string;

	patientGeneralInfo: PatientGeneralInfoModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	retailPharmacyInvoicesIds: string[] = [];

	retailPharmacyInvoices: RetailPharmacyInvoiceModel[];

	retailPharmacyStockDetailsIds: string[] = [];

	retailPharmacyStockDetails: RetailPharmacyStockDetailModel[];

	modelPropGroups: { [s: string]: Group } = RetailPharmacyModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'customerType',
				// % protected region % [Set displayName for Customer Type here] off begin
				displayName: 'Customer Type',
				// % protected region % [Set displayName for Customer Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Customer Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Customer Type here] end
				// % protected region % [Set isSensitive for Customer Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Customer Type here] end
				// % protected region % [Set readonly for Customer Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Customer Type here] end
				validators: [
					// % protected region % [Add other validators for Customer Type here] off begin
					// % protected region % [Add other validators for Customer Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Customer Type here] off begin
				// % protected region % [Add any additional model attribute properties for Customer Type here] end
			},
			{
				name: 'retailNumber',
				// % protected region % [Set displayName for Retail Number here] off begin
				displayName: 'Retail Number',
				// % protected region % [Set displayName for Retail Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Retail Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Retail Number here] end
				// % protected region % [Set isSensitive for Retail Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Retail Number here] end
				// % protected region % [Set readonly for Retail Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Retail Number here] end
				validators: [
					// % protected region % [Add other validators for Retail Number here] off begin
					// % protected region % [Add other validators for Retail Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Retail Number here] off begin
				// % protected region % [Add any additional model attribute properties for Retail Number here] end
			},
			{
				name: 'status',
				// % protected region % [Set displayName for Status here] off begin
				displayName: 'Status',
				// % protected region % [Set displayName for Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Status here] end
				// % protected region % [Set isSensitive for Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Status here] end
				// % protected region % [Set readonly for Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Status here] end
				validators: [
					// % protected region % [Add other validators for Status here] off begin
					// % protected region % [Add other validators for Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Status here] off begin
				// % protected region % [Add any additional model attribute properties for Status here] end
			},
			{
				name: 'customerName',
				// % protected region % [Set displayName for Customer Name here] off begin
				displayName: 'Customer Name',
				// % protected region % [Set displayName for Customer Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Customer Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Customer Name here] end
				// % protected region % [Set isSensitive for Customer Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Customer Name here] end
				// % protected region % [Set readonly for Customer Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Customer Name here] end
				validators: [
					// % protected region % [Add other validators for Customer Name here] off begin
					// % protected region % [Add other validators for Customer Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Customer Name here] off begin
				// % protected region % [Add any additional model attribute properties for Customer Name here] end
			},
			{
				name: 'address',
				// % protected region % [Set displayName for Address here] off begin
				displayName: 'Address',
				// % protected region % [Set displayName for Address here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Address here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Address here] end
				// % protected region % [Set isSensitive for Address here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Address here] end
				// % protected region % [Set readonly for Address here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Address here] end
				validators: [
					// % protected region % [Add other validators for Address here] off begin
					// % protected region % [Add other validators for Address here] end
				],
				// % protected region % [Add any additional model attribute properties for Address here] off begin
				// % protected region % [Add any additional model attribute properties for Address here] end
			},
			{
				name: 'phoneNumber',
				// % protected region % [Set displayName for Phone Number here] off begin
				displayName: 'Phone Number',
				// % protected region % [Set displayName for Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Phone Number here] end
				// % protected region % [Set isSensitive for Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Phone Number here] end
				// % protected region % [Set readonly for Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Phone Number here] end
				validators: [
					// % protected region % [Add other validators for Phone Number here] off begin
					// % protected region % [Add other validators for Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Phone Number here] end
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
				name: 'paymentStatus',
				// % protected region % [Set displayName for Payment Status here] off begin
				displayName: 'Payment Status',
				// % protected region % [Set displayName for Payment Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Payment Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Payment Status here] end
				// % protected region % [Set isSensitive for Payment Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Payment Status here] end
				// % protected region % [Set readonly for Payment Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Payment Status here] end
				validators: [
					// % protected region % [Add other validators for Payment Status here] off begin
					// % protected region % [Add other validators for Payment Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Payment Status here] off begin
				// % protected region % [Add any additional model attribute properties for Payment Status here] end
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
				id: 'retailPharmacyInvoices',
				type: ModelRelationType.MANY,
				name: 'retailPharmacyInvoicesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Retail Pharmacy Invoices here] off begin
				label: 'Retail Pharmacy Invoices',
				// % protected region % [Customise your 1-1 or 1-M label for Retail Pharmacy Invoices here] end
				entityName: 'RetailPharmacyInvoiceModel',
				// % protected region % [Customise your display name for Retail Pharmacy Invoices here] off begin
				displayName: 'invoiceNumber',
				// % protected region % [Customise your display name for Retail Pharmacy Invoices here] end
				validators: [
					// % protected region % [Add other validators for Retail Pharmacy Invoices here] off begin
					// % protected region % [Add other validators for Retail Pharmacy Invoices here] end
				],
				// % protected region % [Add any additional field for relation Retail Pharmacy Invoices here] off begin
				// % protected region % [Add any additional field for relation Retail Pharmacy Invoices here] end
			},
			{
				id: 'retailPharmacyStockDetails',
				type: ModelRelationType.MANY,
				name: 'retailPharmacyStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Retail Pharmacy Stock Details here] off begin
				label: 'Retail Pharmacy Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Retail Pharmacy Stock Details here] end
				entityName: 'RetailPharmacyStockDetailModel',
				// % protected region % [Customise your display name for Retail Pharmacy Stock Details here] off begin
				displayName: 'supplyStockGroup',
				// % protected region % [Customise your display name for Retail Pharmacy Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Retail Pharmacy Stock Details here] off begin
					// % protected region % [Add other validators for Retail Pharmacy Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Retail Pharmacy Stock Details here] off begin
				// % protected region % [Add any additional field for relation Retail Pharmacy Stock Details here] end
			},
			{
				id: 'patientGeneralInfo',
				type: ModelRelationType.ONE,
				name: 'patientGeneralInfoId',
				// % protected region % [Customise your label for Patient General Info here] off begin
				label: 'Patient General Info',
				// % protected region % [Customise your label for Patient General Info here] end
				entityName: 'PatientGeneralInfoModel',
				// % protected region % [Customise your display name for Patient General Info here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'patientID',
				// % protected region % [Customise your display name for Patient General Info here] end
				validators: [
					// % protected region % [Add other validators for Patient General Info here] off begin
					// % protected region % [Add other validators for Patient General Info here] end
				],
				// % protected region % [Add any additional field for relation Patient General Info here] off begin
				// % protected region % [Add any additional field for relation Patient General Info here] end
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
				case 'customerType':
					break;
				case 'status':
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
	static deepParse(data: string | { [K in keyof RetailPharmacyModel]?: RetailPharmacyModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new RetailPharmacyModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.patientGeneralInfo) {
			currentModel.patientGeneralInfoId = json.patientGeneralInfo.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patientGeneralInfo));
		}

		// Incoming one to many
		if (json.warehouse) {
			currentModel.warehouseId = json.warehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.warehouse));
		}

		// Outgoing one to many
		if (json.retailPharmacyInvoices) {
			currentModel.retailPharmacyInvoicesIds = json.retailPharmacyInvoices.map(model => model.id);
			returned = _.union(returned, _.flatten(json.retailPharmacyInvoices.map(model => RetailPharmacyInvoiceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.retailPharmacyStockDetails) {
			currentModel.retailPharmacyStockDetailsIds = json.retailPharmacyStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.retailPharmacyStockDetails.map(model => RetailPharmacyStockDetailModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let retailPharmacyModel = new RetailPharmacyModel(data);`
	 *
	 * @param data The input data to be initialised as the RetailPharmacyModel,
	 *    it is expected as a JSON string or as a nullable RetailPharmacyModel.
	 */
	constructor(data?: string | Partial<RetailPharmacyModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<RetailPharmacyModel>
				: data;

			this.customerType = json.customerType;
			this.retailNumber = json.retailNumber;
			this.status = json.status;
			this.customerName = json.customerName;
			this.address = json.address;
			this.phoneNumber = json.phoneNumber;
			this.notes = json.notes;
			this.paymentStatus = json.paymentStatus;
			this.totalPrice = json.totalPrice;
			this.patientGeneralInfoId = json.patientGeneralInfoId;
			this.patientGeneralInfo = json.patientGeneralInfo;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			this.retailPharmacyInvoicesIds = json.retailPharmacyInvoicesIds;
			this.retailPharmacyInvoices = json.retailPharmacyInvoices;
			this.retailPharmacyStockDetailsIds = json.retailPharmacyStockDetailsIds;
			this.retailPharmacyStockDetails = json.retailPharmacyStockDetails;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			customerType: this.customerType,
			retailNumber: this.retailNumber,
			status: this.status,
			customerName: this.customerName,
			address: this.address,
			phoneNumber: this.phoneNumber,
			notes: this.notes,
			paymentStatus: this.paymentStatus,
			totalPrice: this.totalPrice,
			patientGeneralInfoId: this.patientGeneralInfoId,
			warehouseId: this.warehouseId,
			retailPharmacyInvoicesIds: this.retailPharmacyInvoicesIds,
			retailPharmacyStockDetailsIds: this.retailPharmacyStockDetailsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		RetailPharmacyModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): RetailPharmacyModel {
		let newModelJson = this.toJSON();

		if (updates.customerType) {
			newModelJson.customerType = updates.customerType;
		}

		if (updates.retailNumber) {
			newModelJson.retailNumber = updates.retailNumber;
		}

		if (updates.status) {
			newModelJson.status = updates.status;
		}

		if (updates.customerName) {
			newModelJson.customerName = updates.customerName;
		}

		if (updates.address) {
			newModelJson.address = updates.address;
		}

		if (updates.phoneNumber) {
			newModelJson.phoneNumber = updates.phoneNumber;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.paymentStatus) {
			newModelJson.paymentStatus = updates.paymentStatus;
		}

		if (updates.totalPrice) {
			newModelJson.totalPrice = updates.totalPrice;
		}

		if (updates.patientGeneralInfoId) {
			newModelJson.patientGeneralInfoId = updates.patientGeneralInfoId;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		if (updates.retailPharmacyInvoicesIds) {
			newModelJson.retailPharmacyInvoicesIds = updates.retailPharmacyInvoicesIds;
		}

		if (updates.retailPharmacyStockDetailsIds) {
			newModelJson.retailPharmacyStockDetailsIds = updates.retailPharmacyStockDetailsIds;
		}

		return new RetailPharmacyModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof RetailPharmacyModel)) {
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
			'patientGeneralInfoId',
			'patientGeneralInfo',
			'warehouseId',
			'warehouse',
			'retailPharmacyInvoicesIds',
			'retailPharmacyInvoices',
			'retailPharmacyStockDetailsIds',
			'retailPharmacyStockDetails',
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
		if (!this.patientGeneralInfo) {
			this.patientGeneralInfoId = null;
		} else {
			this.patientGeneralInfoId = this.patientGeneralInfo.id;
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
