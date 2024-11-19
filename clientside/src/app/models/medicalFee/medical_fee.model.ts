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
import {PharmacyTypeEnum, pharmacyTypeEnumArray} from '../../enums/pharmacy-type.enum';
import {TariffTypeEnum, tariffTypeEnumArray} from '../../enums/tariff-type.enum';
import {MedicalFeeStatusEnum, medicalFeeStatusEnumArray} from '../../enums/medical-fee-status.enum';
import {InvoiceItemModel} from '../invoiceItem/invoice_item.model';
import {MedicalFeeItemComponentModel} from '../medicalFeeItemComponent/medical_fee_item_component.model';
import {RegistrationModel} from '../registration/registration.model';
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
export class MedicalFeeModel extends AbstractModel {
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
		'tariffType',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'MedicalFeeModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return MedicalFeeModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * (Max length: 50) If [Tariff Type]=SERVICE ITEM then copy [Service Item Code] on [Service Item] entity. If [Tariff Type]=STOCK then copy [Stock Code] on [Stock Catalogue] entity. If [Tariff Type]=ROOM then copys [Bed Number] on [Bed Facility] entity.
	 */
	tariffCode: string;

	/**
	 * Maintain the tariff Name (stock Name, Bed Name or Service Item Name).
	 */
	name: string;

	/**
	 * Prescription/Medication Number as source of Pharmacy transaction (Max Length: 50).
	 */
	pharmacyTransactionNumber: string;

	/**
	 * .
	 */
	medicationTransactionNumber: string;

	/**
	 * Date when the treatment was given to patient, by default the date refers to today date time during input data.
	 */
	transactionDate: Date;

	/**
	 * Number of amount  from treatment given (stock quantity, etc).
	 */
	quantity: number;

	/**
	 * It's used to maintain the unit from source data.
	 */
	unit: string;

	/**
	 * Price of unit from treatment/item given, it's total of Hospital Price and Other Component Price (2 digits decimal).
	 */
	unitPrice: number;

	/**
	 * Amount of hospital component price (2 digits decimal).
	 */
	hospitalPrice: number;

	/**
	 * Total of Price from related Medical Fee Item Component entity (2 digits decimal).
	 */
	otherComponentPrice: number;

	/**
	 * Medical Staff who did treatment to patient.
	 */
	medicalStaffCode: string;

	/**
	 * Treatment Class, get the Code from Reference Data where Type=TREA_CLS. (Max Length: 20).
	 */
	treatmentClass: string;

	/**
	 * Notes (max length: 500).
	 */
	notes: string;

	/**
	 * Inventory Rounding Value.
	 */
	inventoryRoundingValue: number;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=5, example=Sally}.
	 */
	pharmacyTransactionType: PharmacyTypeEnum;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=2, example=Sally}.
	 */
	tariffType: TariffTypeEnum;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=17, example=Sally}.
	 */
	medicalFeeStatus: MedicalFeeStatusEnum;

	registrationId: string;

	registration: RegistrationModel;

	warehouseId: string;

	warehouse: WarehouseModel;

	invoiceItemsIds: string[] = [];

	invoiceItems: InvoiceItemModel[];

	medicalFeeItemComponentsIds: string[] = [];

	medicalFeeItemComponents: MedicalFeeItemComponentModel[];

	modelPropGroups: { [s: string]: Group } = MedicalFeeModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'tariffType',
				// % protected region % [Set displayName for Tariff Type here] off begin
				displayName: 'Tariff Type',
				// % protected region % [Set displayName for Tariff Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: tariffTypeEnumArray,
				// % protected region % [Set display element type for Tariff Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Tariff Type here] end
				// % protected region % [Set isSensitive for Tariff Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff Type here] end
				// % protected region % [Set readonly for Tariff Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff Type here] end
				validators: [
					// % protected region % [Add other validators for Tariff Type here] off begin
					// % protected region % [Add other validators for Tariff Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff Type here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff Type here] end
			},
			{
				name: 'tariffCode',
				// % protected region % [Set displayName for Tariff Code here] off begin
				displayName: 'Tariff Code',
				// % protected region % [Set displayName for Tariff Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tariff Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tariff Code here] end
				// % protected region % [Set isSensitive for Tariff Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff Code here] end
				// % protected region % [Set readonly for Tariff Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff Code here] end
				validators: [
					// % protected region % [Add other validators for Tariff Code here] off begin
					// % protected region % [Add other validators for Tariff Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff Code here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff Code here] end
			},
			{
				name: 'name',
				// % protected region % [Set displayName for Name here] off begin
				displayName: 'Name',
				// % protected region % [Set displayName for Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Name here] end
				// % protected region % [Set isSensitive for Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Name here] end
				// % protected region % [Set readonly for Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Name here] end
				validators: [
					// % protected region % [Add other validators for Name here] off begin
					// % protected region % [Add other validators for Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Name here] off begin
				// % protected region % [Add any additional model attribute properties for Name here] end
			},
			{
				name: 'pharmacyTransactionType',
				// % protected region % [Set displayName for Pharmacy Transaction Type here] off begin
				displayName: 'Pharmacy Transaction Type',
				// % protected region % [Set displayName for Pharmacy Transaction Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: pharmacyTypeEnumArray,
				// % protected region % [Set display element type for Pharmacy Transaction Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Pharmacy Transaction Type here] end
				// % protected region % [Set isSensitive for Pharmacy Transaction Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pharmacy Transaction Type here] end
				// % protected region % [Set readonly for Pharmacy Transaction Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pharmacy Transaction Type here] end
				validators: [
					// % protected region % [Add other validators for Pharmacy Transaction Type here] off begin
					// % protected region % [Add other validators for Pharmacy Transaction Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Pharmacy Transaction Type here] off begin
				// % protected region % [Add any additional model attribute properties for Pharmacy Transaction Type here] end
			},
			{
				name: 'pharmacyTransactionNumber',
				// % protected region % [Set displayName for Pharmacy Transaction Number here] off begin
				displayName: 'Pharmacy Transaction Number',
				// % protected region % [Set displayName for Pharmacy Transaction Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pharmacy Transaction Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pharmacy Transaction Number here] end
				// % protected region % [Set isSensitive for Pharmacy Transaction Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pharmacy Transaction Number here] end
				// % protected region % [Set readonly for Pharmacy Transaction Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pharmacy Transaction Number here] end
				validators: [
					// % protected region % [Add other validators for Pharmacy Transaction Number here] off begin
					// % protected region % [Add other validators for Pharmacy Transaction Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Pharmacy Transaction Number here] off begin
				// % protected region % [Add any additional model attribute properties for Pharmacy Transaction Number here] end
			},
			{
				name: 'medicationTransactionNumber',
				// % protected region % [Set displayName for Medication Transaction Number here] off begin
				displayName: 'Medication Transaction Number',
				// % protected region % [Set displayName for Medication Transaction Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Medication Transaction Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Medication Transaction Number here] end
				// % protected region % [Set isSensitive for Medication Transaction Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medication Transaction Number here] end
				// % protected region % [Set readonly for Medication Transaction Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medication Transaction Number here] end
				validators: [
					// % protected region % [Add other validators for Medication Transaction Number here] off begin
					// % protected region % [Add other validators for Medication Transaction Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Medication Transaction Number here] off begin
				// % protected region % [Add any additional model attribute properties for Medication Transaction Number here] end
			},
			{
				name: 'transactionDate',
				// % protected region % [Set displayName for Transaction Date here] off begin
				displayName: 'Transaction Date',
				// % protected region % [Set displayName for Transaction Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Transaction Date here] off begin
				elementType: ElementType.DATETIME,
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
				name: 'quantity',
				// % protected region % [Set displayName for Quantity here] off begin
				displayName: 'Quantity',
				// % protected region % [Set displayName for Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Quantity here] end
				// % protected region % [Set isSensitive for Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Quantity here] end
				// % protected region % [Set readonly for Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Quantity here] end
				validators: [
					// % protected region % [Add other validators for Quantity here] off begin
					// % protected region % [Add other validators for Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Quantity here] end
			},
			{
				name: 'unit',
				// % protected region % [Set displayName for Unit here] off begin
				displayName: 'Unit',
				// % protected region % [Set displayName for Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Unit here] end
				// % protected region % [Set isSensitive for Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unit here] end
				// % protected region % [Set readonly for Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unit here] end
				validators: [
					// % protected region % [Add other validators for Unit here] off begin
					// % protected region % [Add other validators for Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Unit here] end
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
				name: 'hospitalPrice',
				// % protected region % [Set displayName for Hospital Price here] off begin
				displayName: 'Hospital Price',
				// % protected region % [Set displayName for Hospital Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Hospital Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Hospital Price here] end
				// % protected region % [Set isSensitive for Hospital Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Price here] end
				// % protected region % [Set readonly for Hospital Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Price here] end
				validators: [
					// % protected region % [Add other validators for Hospital Price here] off begin
					// % protected region % [Add other validators for Hospital Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Price here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Price here] end
			},
			{
				name: 'otherComponentPrice',
				// % protected region % [Set displayName for Other Component Price here] off begin
				displayName: 'Other Component Price',
				// % protected region % [Set displayName for Other Component Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Other Component Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Other Component Price here] end
				// % protected region % [Set isSensitive for Other Component Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Component Price here] end
				// % protected region % [Set readonly for Other Component Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Component Price here] end
				validators: [
					// % protected region % [Add other validators for Other Component Price here] off begin
					// % protected region % [Add other validators for Other Component Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Component Price here] off begin
				// % protected region % [Add any additional model attribute properties for Other Component Price here] end
			},
			{
				name: 'medicalStaffCode',
				// % protected region % [Set displayName for Medical Staff Code here] off begin
				displayName: 'Medical Staff Code',
				// % protected region % [Set displayName for Medical Staff Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Medical Staff Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Medical Staff Code here] end
				// % protected region % [Set isSensitive for Medical Staff Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medical Staff Code here] end
				// % protected region % [Set readonly for Medical Staff Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medical Staff Code here] end
				validators: [
					// % protected region % [Add other validators for Medical Staff Code here] off begin
					// % protected region % [Add other validators for Medical Staff Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Medical Staff Code here] off begin
				// % protected region % [Add any additional model attribute properties for Medical Staff Code here] end
			},
			{
				name: 'treatmentClass',
				// % protected region % [Set displayName for Treatment Class here] off begin
				displayName: 'Treatment Class',
				// % protected region % [Set displayName for Treatment Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Treatment Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Treatment Class here] end
				// % protected region % [Set isSensitive for Treatment Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Treatment Class here] end
				// % protected region % [Set readonly for Treatment Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Treatment Class here] end
				validators: [
					// % protected region % [Add other validators for Treatment Class here] off begin
					// % protected region % [Add other validators for Treatment Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Treatment Class here] off begin
				// % protected region % [Add any additional model attribute properties for Treatment Class here] end
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
				name: 'medicalFeeStatus',
				// % protected region % [Set displayName for medical fee status here] off begin
				displayName: 'medical fee status',
				// % protected region % [Set displayName for medical fee status here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: medicalFeeStatusEnumArray,
				// % protected region % [Set display element type for medical fee status here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for medical fee status here] end
				// % protected region % [Set isSensitive for medical fee status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for medical fee status here] end
				// % protected region % [Set readonly for medical fee status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for medical fee status here] end
				validators: [
					// % protected region % [Add other validators for medical fee status here] off begin
					// % protected region % [Add other validators for medical fee status here] end
				],
				// % protected region % [Add any additional model attribute properties for medical fee status here] off begin
				// % protected region % [Add any additional model attribute properties for medical fee status here] end
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
				id: 'medicalFeeItemComponents',
				type: ModelRelationType.MANY,
				name: 'medicalFeeItemComponentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Fee Item Components here] off begin
				label: 'Medical Fee Item Components',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Fee Item Components here] end
				entityName: 'MedicalFeeItemComponentModel',
				// % protected region % [Customise your display name for Medical Fee Item Components here] off begin
				displayName: 'price',
				// % protected region % [Customise your display name for Medical Fee Item Components here] end
				validators: [
					// % protected region % [Add other validators for Medical Fee Item Components here] off begin
					// % protected region % [Add other validators for Medical Fee Item Components here] end
				],
				// % protected region % [Add any additional field for relation Medical Fee Item Components here] off begin
				// % protected region % [Add any additional field for relation Medical Fee Item Components here] end
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
	static deepParse(data: string | { [K in keyof MedicalFeeModel]?: MedicalFeeModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new MedicalFeeModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
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
		if (json.medicalFeeItemComponents) {
			currentModel.medicalFeeItemComponentsIds = json.medicalFeeItemComponents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalFeeItemComponents.map(model => MedicalFeeItemComponentModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let medicalFeeModel = new MedicalFeeModel(data);`
	 *
	 * @param data The input data to be initialised as the MedicalFeeModel,
	 *    it is expected as a JSON string or as a nullable MedicalFeeModel.
	 */
	constructor(data?: string | Partial<MedicalFeeModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<MedicalFeeModel>
				: data;

			this.tariffType = json.tariffType;
			this.tariffCode = json.tariffCode;
			this.name = json.name;
			this.pharmacyTransactionType = json.pharmacyTransactionType;
			this.pharmacyTransactionNumber = json.pharmacyTransactionNumber;
			this.medicationTransactionNumber = json.medicationTransactionNumber;
			if (json.transactionDate) {
				this.transactionDate = new Date(json.transactionDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.transactionDate = json.transactionDate;
			}
			this.quantity = json.quantity;
			this.unit = json.unit;
			this.unitPrice = json.unitPrice;
			this.hospitalPrice = json.hospitalPrice;
			this.otherComponentPrice = json.otherComponentPrice;
			this.medicalStaffCode = json.medicalStaffCode;
			this.treatmentClass = json.treatmentClass;
			this.notes = json.notes;
			this.medicalFeeStatus = json.medicalFeeStatus;
			this.inventoryRoundingValue = json.inventoryRoundingValue;
			this.pharmacyTransactionType = json.pharmacyTransactionType;
			this.tariffType = json.tariffType;
			this.medicalFeeStatus = json.medicalFeeStatus;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			this.warehouseId = json.warehouseId;
			this.warehouse = json.warehouse;
			this.invoiceItemsIds = json.invoiceItemsIds;
			this.invoiceItems = json.invoiceItems;
			this.medicalFeeItemComponentsIds = json.medicalFeeItemComponentsIds;
			this.medicalFeeItemComponents = json.medicalFeeItemComponents;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			tariffType: this.tariffType,
			tariffCode: this.tariffCode,
			name: this.name,
			pharmacyTransactionType: this.pharmacyTransactionType,
			pharmacyTransactionNumber: this.pharmacyTransactionNumber,
			medicationTransactionNumber: this.medicationTransactionNumber,
			transactionDate: this.transactionDate,
			quantity: this.quantity,
			unit: this.unit,
			unitPrice: this.unitPrice,
			hospitalPrice: this.hospitalPrice,
			otherComponentPrice: this.otherComponentPrice,
			medicalStaffCode: this.medicalStaffCode,
			treatmentClass: this.treatmentClass,
			notes: this.notes,
			medicalFeeStatus: this.medicalFeeStatus,
			inventoryRoundingValue: this.inventoryRoundingValue,
			registrationId: this.registrationId,
			warehouseId: this.warehouseId,
			invoiceItemsIds: this.invoiceItemsIds,
			medicalFeeItemComponentsIds: this.medicalFeeItemComponentsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		MedicalFeeModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): MedicalFeeModel {
		let newModelJson = this.toJSON();

		if (updates.tariffType) {
			newModelJson.tariffType = updates.tariffType;
		}

		if (updates.tariffCode) {
			newModelJson.tariffCode = updates.tariffCode;
		}

		if (updates.name) {
			newModelJson.name = updates.name;
		}

		if (updates.pharmacyTransactionType) {
			newModelJson.pharmacyTransactionType = updates.pharmacyTransactionType;
		}

		if (updates.pharmacyTransactionNumber) {
			newModelJson.pharmacyTransactionNumber = updates.pharmacyTransactionNumber;
		}

		if (updates.medicationTransactionNumber) {
			newModelJson.medicationTransactionNumber = updates.medicationTransactionNumber;
		}

		if (updates.transactionDate) {
			newModelJson.transactionDate = updates.transactionDate;
		}

		if (updates.quantity) {
			newModelJson.quantity = updates.quantity;
		}

		if (updates.unit) {
			newModelJson.unit = updates.unit;
		}

		if (updates.unitPrice) {
			newModelJson.unitPrice = updates.unitPrice;
		}

		if (updates.hospitalPrice) {
			newModelJson.hospitalPrice = updates.hospitalPrice;
		}

		if (updates.otherComponentPrice) {
			newModelJson.otherComponentPrice = updates.otherComponentPrice;
		}

		if (updates.medicalStaffCode) {
			newModelJson.medicalStaffCode = updates.medicalStaffCode;
		}

		if (updates.treatmentClass) {
			newModelJson.treatmentClass = updates.treatmentClass;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.medicalFeeStatus) {
			newModelJson.medicalFeeStatus = updates.medicalFeeStatus;
		}

		if (updates.inventoryRoundingValue) {
			newModelJson.inventoryRoundingValue = updates.inventoryRoundingValue;
		}

		if (updates.pharmacyTransactionType) {
			newModelJson.pharmacyTransactionType = updates.pharmacyTransactionType;
		}

		if (updates.tariffType) {
			newModelJson.tariffType = updates.tariffType;
		}

		if (updates.medicalFeeStatus) {
			newModelJson.medicalFeeStatus = updates.medicalFeeStatus;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.warehouseId) {
			newModelJson.warehouseId = updates.warehouseId;
		}

		if (updates.invoiceItemsIds) {
			newModelJson.invoiceItemsIds = updates.invoiceItemsIds;
		}

		if (updates.medicalFeeItemComponentsIds) {
			newModelJson.medicalFeeItemComponentsIds = updates.medicalFeeItemComponentsIds;
		}

		return new MedicalFeeModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof MedicalFeeModel)) {
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
			'registrationId',
			'registration',
			'warehouseId',
			'warehouse',
			'invoiceItemsIds',
			'invoiceItems',
			'medicalFeeItemComponentsIds',
			'medicalFeeItemComponents',
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
		if (!this.registration) {
			this.registrationId = null;
		} else {
			this.registrationId = this.registration.id;
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
