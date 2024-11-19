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
import {InvoiceModel} from '../invoice/invoice.model';
import {InvoiceItemModel} from '../invoiceItem/invoice_item.model';
import {MedicationCompoundModel} from '../medicationCompound/medication_compound.model';
import {MedicationItemModel} from '../medicationItem/medication_item.model';
import {RegistrationModel} from '../registration/registration.model';
import {StaffModel} from '../staff/staff.model';
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
export class MedicationHeaderModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'medicationNumber',
		'dispensingType',
		'originalMedicationNumber',
		'orderDate',
		'status',
		'notes',
		'isUrgent',
		'isCompound',
		'restricted',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'medicationNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'MedicationHeaderModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return MedicationHeaderModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	medicationNumber: string;

	/**
	 * UDD/ODD.
	 */
	dispensingType: string;

	/**
	 * .
	 */
	originalMedicationNumber: string;

	/**
	 * .
	 */
	orderDate: Date;

	/**
	 * .
	 */
	status: string;

	/**
	 * .
	 */
	notes: string;

	/**
	 * .
	 */
	isUrgent: boolean = false;

	/**
	 * .
	 */
	isCompound: boolean = false;

	/**
	 * .
	 */
	revisionNo: number;

	/**
	 * .
	 */
	isInvoiced: boolean = false;

	/**
	 * External Warehouse.
	 */
	externalWarehouse: boolean = false;

	/**
	 * Restricted indicator if any catalogue medical on Medication Item has "Is Restricted" flag with YES, then this attribute will be set to TRUE.
	 */
	restricted: boolean = false;

	invoiceId: string;

	invoice: InvoiceModel;

	registrationId: string;

	registration: RegistrationModel;

	requestedById: string;

	requestedBy: StaffModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	invoiceItemsIds: string[] = [];

	invoiceItems: InvoiceItemModel[];

	medicationCompoundsIds: string[] = [];

	medicationCompounds: MedicationCompoundModel[];

	medicationItemsIds: string[] = [];

	medicationItems: MedicationItemModel[];

	modelPropGroups: { [s: string]: Group } = MedicationHeaderModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'medicationNumber',
				// % protected region % [Set displayName for Medication Number here] off begin
				displayName: 'Medication Number',
				// % protected region % [Set displayName for Medication Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Medication Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Medication Number here] end
				// % protected region % [Set isSensitive for Medication Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medication Number here] end
				// % protected region % [Set readonly for Medication Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medication Number here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Medication Number here] off begin
					// % protected region % [Add other validators for Medication Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Medication Number here] off begin
				// % protected region % [Add any additional model attribute properties for Medication Number here] end
			},
			{
				name: 'dispensingType',
				// % protected region % [Set displayName for Dispensing Type here] off begin
				displayName: 'Dispensing Type',
				// % protected region % [Set displayName for Dispensing Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dispensing Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dispensing Type here] end
				// % protected region % [Set isSensitive for Dispensing Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dispensing Type here] end
				// % protected region % [Set readonly for Dispensing Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dispensing Type here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Dispensing Type here] off begin
					// % protected region % [Add other validators for Dispensing Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Dispensing Type here] off begin
				// % protected region % [Add any additional model attribute properties for Dispensing Type here] end
			},
			{
				name: 'originalMedicationNumber',
				// % protected region % [Set displayName for Original Medication Number here] off begin
				displayName: 'Original Medication Number',
				// % protected region % [Set displayName for Original Medication Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Original Medication Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Original Medication Number here] end
				// % protected region % [Set isSensitive for Original Medication Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Original Medication Number here] end
				// % protected region % [Set readonly for Original Medication Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Original Medication Number here] end
				validators: [
					// % protected region % [Add other validators for Original Medication Number here] off begin
					// % protected region % [Add other validators for Original Medication Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Original Medication Number here] off begin
				// % protected region % [Add any additional model attribute properties for Original Medication Number here] end
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
				name: 'isUrgent',
				// % protected region % [Set displayName for Is Urgent here] off begin
				displayName: 'Is Urgent',
				// % protected region % [Set displayName for Is Urgent here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Urgent here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Urgent here] end
				// % protected region % [Set isSensitive for Is Urgent here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Urgent here] end
				// % protected region % [Set readonly for Is Urgent here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Urgent here] end
				validators: [
					// % protected region % [Add other validators for Is Urgent here] off begin
					// % protected region % [Add other validators for Is Urgent here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Urgent here] off begin
				// % protected region % [Add any additional model attribute properties for Is Urgent here] end
			},
			{
				name: 'isCompound',
				// % protected region % [Set displayName for Is Compound here] off begin
				displayName: 'Is Compound',
				// % protected region % [Set displayName for Is Compound here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Compound here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Compound here] end
				// % protected region % [Set isSensitive for Is Compound here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Compound here] end
				// % protected region % [Set readonly for Is Compound here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Compound here] end
				validators: [
					// % protected region % [Add other validators for Is Compound here] off begin
					// % protected region % [Add other validators for Is Compound here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Compound here] off begin
				// % protected region % [Add any additional model attribute properties for Is Compound here] end
			},
			{
				name: 'revisionNo',
				// % protected region % [Set displayName for Revision No here] off begin
				displayName: 'Revision No',
				// % protected region % [Set displayName for Revision No here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Revision No here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Revision No here] end
				// % protected region % [Set isSensitive for Revision No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Revision No here] end
				// % protected region % [Set readonly for Revision No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Revision No here] end
				validators: [
					// % protected region % [Add other validators for Revision No here] off begin
					// % protected region % [Add other validators for Revision No here] end
				],
				// % protected region % [Add any additional model attribute properties for Revision No here] off begin
				// % protected region % [Add any additional model attribute properties for Revision No here] end
			},
			{
				name: 'isInvoiced',
				// % protected region % [Set displayName for Is Invoiced here] off begin
				displayName: 'Is Invoiced',
				// % protected region % [Set displayName for Is Invoiced here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Invoiced here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Invoiced here] end
				// % protected region % [Set isSensitive for Is Invoiced here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Invoiced here] end
				// % protected region % [Set readonly for Is Invoiced here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Invoiced here] end
				validators: [
					// % protected region % [Add other validators for Is Invoiced here] off begin
					// % protected region % [Add other validators for Is Invoiced here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Invoiced here] off begin
				// % protected region % [Add any additional model attribute properties for Is Invoiced here] end
			},
			{
				name: 'externalWarehouse',
				// % protected region % [Set displayName for External Warehouse here] off begin
				displayName: 'External Warehouse',
				// % protected region % [Set displayName for External Warehouse here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for External Warehouse here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for External Warehouse here] end
				// % protected region % [Set isSensitive for External Warehouse here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for External Warehouse here] end
				// % protected region % [Set readonly for External Warehouse here] off begin
				readOnly: false,
				// % protected region % [Set readonly for External Warehouse here] end
				validators: [
					// % protected region % [Add other validators for External Warehouse here] off begin
					// % protected region % [Add other validators for External Warehouse here] end
				],
				// % protected region % [Add any additional model attribute properties for External Warehouse here] off begin
				// % protected region % [Add any additional model attribute properties for External Warehouse here] end
			},
			{
				name: 'restricted',
				// % protected region % [Set displayName for Restricted here] off begin
				displayName: 'Restricted',
				// % protected region % [Set displayName for Restricted here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Restricted here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Restricted here] end
				// % protected region % [Set isSensitive for Restricted here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Restricted here] end
				// % protected region % [Set readonly for Restricted here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Restricted here] end
				validators: [
					// % protected region % [Add other validators for Restricted here] off begin
					// % protected region % [Add other validators for Restricted here] end
				],
				// % protected region % [Add any additional model attribute properties for Restricted here] off begin
				// % protected region % [Add any additional model attribute properties for Restricted here] end
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
				id: 'invoiceItems',
				type: ModelRelationType.MANY,
				name: 'invoiceItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Items here] off begin
				label: 'Invoice Items',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Items here] end
				entityName: 'InvoiceItemModel',
				// % protected region % [Customise your display name for Invoice Items here] off begin
				displayName: 'transactionDate',
				// % protected region % [Customise your display name for Invoice Items here] end
				validators: [
					// % protected region % [Add other validators for Invoice Items here] off begin
					// % protected region % [Add other validators for Invoice Items here] end
				],
				// % protected region % [Add any additional field for relation Invoice Items here] off begin
				// % protected region % [Add any additional field for relation Invoice Items here] end
			},
			{
				id: 'invoice',
				type: ModelRelationType.ONE,
				name: 'invoiceId',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice here] off begin
				label: 'Invoice',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice here] end
				entityName: 'InvoiceModel',
				// % protected region % [Customise your display name for Invoice here] off begin
				displayName: 'invoiceNumber',
				// % protected region % [Customise your display name for Invoice here] end
				validators: [
					// % protected region % [Add other validators for Invoice here] off begin
					// % protected region % [Add other validators for Invoice here] end
				],
				// % protected region % [Add any additional field for relation Invoice here] off begin
				// % protected region % [Add any additional field for relation Invoice here] end
			},
			{
				id: 'medicationCompounds',
				type: ModelRelationType.MANY,
				name: 'medicationCompoundsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Compounds here] off begin
				label: 'Medication Compounds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Compounds here] end
				entityName: 'MedicationCompoundModel',
				// % protected region % [Customise your display name for Medication Compounds here] off begin
				displayName: 'compoundCode',
				// % protected region % [Customise your display name for Medication Compounds here] end
				validators: [
					// % protected region % [Add other validators for Medication Compounds here] off begin
					// % protected region % [Add other validators for Medication Compounds here] end
				],
				// % protected region % [Add any additional field for relation Medication Compounds here] off begin
				// % protected region % [Add any additional field for relation Medication Compounds here] end
			},
			{
				id: 'medicationItems',
				type: ModelRelationType.MANY,
				name: 'medicationItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Items here] off begin
				label: 'Medication Items',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Items here] end
				entityName: 'MedicationItemModel',
				// % protected region % [Customise your display name for Medication Items here] off begin
				displayName: 'requestedQty',
				// % protected region % [Customise your display name for Medication Items here] end
				validators: [
					// % protected region % [Add other validators for Medication Items here] off begin
					// % protected region % [Add other validators for Medication Items here] end
				],
				// % protected region % [Add any additional field for relation Medication Items here] off begin
				// % protected region % [Add any additional field for relation Medication Items here] end
			},
			{
				id: 'registration',
				type: ModelRelationType.ONE,
				name: 'registrationId',
				// % protected region % [Customise your label for Registration here] off begin
				label: 'Registration',
				// % protected region % [Customise your label for Registration here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Registration here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Registration here] end
				validators: [
					// % protected region % [Add other validators for Registration here] off begin
					// % protected region % [Add other validators for Registration here] end
				],
				// % protected region % [Add any additional field for relation Registration here] off begin
				// % protected region % [Add any additional field for relation Registration here] end
			},
			{
				id: 'requestedBy',
				type: ModelRelationType.ONE,
				name: 'requestedById',
				// % protected region % [Customise your label for Requested By here] off begin
				label: 'Requested By',
				// % protected region % [Customise your label for Requested By here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Requested By here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Requested By here] end
				validators: [
					// % protected region % [Add other validators for Requested By here] off begin
					// % protected region % [Add other validators for Requested By here] end
				],
				// % protected region % [Add any additional field for relation Requested By here] off begin
				// % protected region % [Add any additional field for relation Requested By here] end
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
				case 'medicationNumber':
					break;
				case 'dispensingType':
					break;
				case 'originalMedicationNumber':
					break;
				case 'orderDate':
					break;
				case 'status':
					break;
				case 'notes':
					break;
				case 'isUrgent':
					break;
				case 'isCompound':
					break;
				case 'restricted':
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
	static deepParse(data: string | { [K in keyof MedicationHeaderModel]?: MedicationHeaderModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new MedicationHeaderModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.invoice) {
			currentModel.invoiceId = json.invoice.id;
			returned = _.union(returned, InvoiceModel.deepParse(json.invoice));
		}

		// Incoming one to many
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}

		// Incoming one to many
		if (json.requestedBy) {
			currentModel.requestedById = json.requestedBy.id;
			returned = _.union(returned, StaffModel.deepParse(json.requestedBy));
		}

		// Incoming one to many
		if (json.warehouse) {
			currentModel.warehouseId = json.warehouse.id;
			returned = _.union(returned, WarehouseModel.deepParse(json.warehouse));
		}

		// Outgoing one to many
		if (json.invoiceItems) {
			currentModel.invoiceItemsIds = json.invoiceItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoiceItems.map(model => InvoiceItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicationCompounds) {
			currentModel.medicationCompoundsIds = json.medicationCompounds.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationCompounds.map(model => MedicationCompoundModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicationItems) {
			currentModel.medicationItemsIds = json.medicationItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationItems.map(model => MedicationItemModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let medicationHeaderModel = new MedicationHeaderModel(data);`
	 *
	 * @param data The input data to be initialised as the MedicationHeaderModel,
	 *    it is expected as a JSON string or as a nullable MedicationHeaderModel.
	 */
	constructor(data?: string | Partial<MedicationHeaderModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<MedicationHeaderModel>
				: data;

			this.medicationNumber = json.medicationNumber;
			this.dispensingType = json.dispensingType;
			this.originalMedicationNumber = json.originalMedicationNumber;
			if (json.orderDate) {
				this.orderDate = new Date(json.orderDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.orderDate = json.orderDate;
			}
			this.status = json.status;
			this.notes = json.notes;
			this.isUrgent = json.isUrgent;
			this.isCompound = json.isCompound;
			this.revisionNo = json.revisionNo;
			this.isInvoiced = json.isInvoiced;
			this.externalWarehouse = json.externalWarehouse;
			this.restricted = json.restricted;
			this.invoiceId = json.invoiceId;
			this.invoice = json.invoice;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			this.requestedById = json.requestedById;
			this.requestedBy = json.requestedBy;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			this.invoiceItemsIds = json.invoiceItemsIds;
			this.invoiceItems = json.invoiceItems;
			this.medicationCompoundsIds = json.medicationCompoundsIds;
			this.medicationCompounds = json.medicationCompounds;
			this.medicationItemsIds = json.medicationItemsIds;
			this.medicationItems = json.medicationItems;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			medicationNumber: this.medicationNumber,
			dispensingType: this.dispensingType,
			originalMedicationNumber: this.originalMedicationNumber,
			orderDate: this.orderDate,
			status: this.status,
			notes: this.notes,
			isUrgent: this.isUrgent,
			isCompound: this.isCompound,
			revisionNo: this.revisionNo,
			isInvoiced: this.isInvoiced,
			externalWarehouse: this.externalWarehouse,
			restricted: this.restricted,
			invoiceId: this.invoiceId,
			registrationId: this.registrationId,
			requestedById: this.requestedById,
			warehouseId: this.warehouseId,
			invoiceItemsIds: this.invoiceItemsIds,
			medicationCompoundsIds: this.medicationCompoundsIds,
			medicationItemsIds: this.medicationItemsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		MedicationHeaderModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): MedicationHeaderModel {
		let newModelJson = this.toJSON();

		if (updates.medicationNumber) {
			newModelJson.medicationNumber = updates.medicationNumber;
		}

		if (updates.dispensingType) {
			newModelJson.dispensingType = updates.dispensingType;
		}

		if (updates.originalMedicationNumber) {
			newModelJson.originalMedicationNumber = updates.originalMedicationNumber;
		}

		if (updates.orderDate) {
			newModelJson.orderDate = updates.orderDate;
		}

		if (updates.status) {
			newModelJson.status = updates.status;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.isUrgent) {
			newModelJson.isUrgent = updates.isUrgent;
		}

		if (updates.isCompound) {
			newModelJson.isCompound = updates.isCompound;
		}

		if (updates.revisionNo) {
			newModelJson.revisionNo = updates.revisionNo;
		}

		if (updates.isInvoiced) {
			newModelJson.isInvoiced = updates.isInvoiced;
		}

		if (updates.externalWarehouse) {
			newModelJson.externalWarehouse = updates.externalWarehouse;
		}

		if (updates.restricted) {
			newModelJson.restricted = updates.restricted;
		}

		if (updates.invoiceId) {
			newModelJson.invoiceId = updates.invoiceId;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.requestedById) {
			newModelJson.requestedById = updates.requestedById;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		if (updates.invoiceItemsIds) {
			newModelJson.invoiceItemsIds = updates.invoiceItemsIds;
		}

		if (updates.medicationCompoundsIds) {
			newModelJson.medicationCompoundsIds = updates.medicationCompoundsIds;
		}

		if (updates.medicationItemsIds) {
			newModelJson.medicationItemsIds = updates.medicationItemsIds;
		}

		return new MedicationHeaderModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof MedicationHeaderModel)) {
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
			'invoiceId',
			'invoice',
			'registrationId',
			'registration',
			'requestedById',
			'requestedBy',
			'warehouseId',
			'warehouse',
			'invoiceItemsIds',
			'invoiceItems',
			'medicationCompoundsIds',
			'medicationCompounds',
			'medicationItemsIds',
			'medicationItems',
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
		if (!this.invoice) {
			this.invoiceId = null;
		} else {
			this.invoiceId = this.invoice.id;
		}

		if (!this.registration) {
			this.registrationId = null;
		} else {
			this.registrationId = this.registration.id;
		}

		if (!this.requestedBy) {
			this.requestedById = null;
		} else {
			this.requestedById = this.requestedBy.id;
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
