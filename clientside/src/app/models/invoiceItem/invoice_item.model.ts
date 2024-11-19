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
import {TariffTypeEnum, tariffTypeEnumArray} from '../../enums/tariff-type.enum';
import {InvoiceModel} from '../invoice/invoice.model';
import {InvoiceItemComponentModel} from '../invoiceItemComponent/invoice_item_component.model';
import {MedicalFeeModel} from '../medicalFee/medical_fee.model';
import {MedicationHeaderModel} from '../medicationHeader/medication_header.model';
import {PrescriptionHeaderModel} from '../prescriptionHeader/prescription_header.model';
import {RegistrationModel} from '../registration/registration.model';
import {RetailPharmacyInvoiceModel} from '../retailPharmacyInvoice/retail_pharmacy_invoice.model';
import {TariffSchemaModel} from '../tariffSchema/tariff_schema.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class InvoiceItemModel extends AbstractModel {
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
		'transactionDate',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InvoiceItemModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InvoiceItemModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Transaction Date when the item/service was  given to patient.
	 */
	transactionDate: Date;

	/**
	 * (Max length: 50) If [Tariff Type]=SERVICE ITEM then copy [Service Item Code] on [Service Item] entity. If [Tariff Type]=STOCK then copy [Stock Code] on [Stock Catalogue] entity. If [Tariff Type]=ROOM then copys [Bed Number] on [Bed Facility] entity.
	 */
	tariffCode: string;

	/**
	 * Maintain the tariff Name (stock Name, Bed Name or Service Item Name).
	 */
	name: string;

	/**
	 * Medical Staff who did treatment to patient.
	 */
	medicalStaffCode: string;

	/**
	 * Unit Price of Item with 2 decimal digits.
	 */
	price: number;

	/**
	 * Price of Hospital component, with 2 decimal digits.
	 */
	hospitalPrice: number;

	/**
	 * Total Other Component Price on Invoice Item Component Entity, with 2 decimal digits.
	 */
	totalOtherComponentPrice: number;

	/**
	 * Charged Quantity with 2 decimal digits.
	 */
	quantity: number;

	/**
	 * It's used to maintain the unit from source data.
	 */
	unit: string;

	/**
	 * Discount in percentage with 2 decimal digits.
	 */
	discount: number;

	/**
	 * Tax indicator.
	 */
	tax: boolean = false;

	/**
	 * Item Total (Price x Qty - Discount), with 2 decimal digits.
	 */
	itemTotal: number;

	/**
	 * Treatment Class, get the Code from Reference Data where Type=TREA_CLS. (Max Length: 20).
	 */
	treatmentClass: string;

	/**
	 * Notes (max length: 500).
	 */
	notes: string;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=4, example=Sally}.
	 */
	tariffType: TariffTypeEnum;

	invoiceId: string;

	invoice: InvoiceModel;

	medicalFeeId: string;

	medicalFee: MedicalFeeModel;

	medicationHeaderId: string;

	medicationHeader: MedicationHeaderModel;

	prescriptionId: string;

	prescription: PrescriptionHeaderModel;

	retailPharmacyInvoiceId: string;

	retailPharmacyInvoice: RetailPharmacyInvoiceModel;

	serviceNumberId: string;

	serviceNumber: RegistrationModel;

	tariffSchemaId: string;

	tariffSchema: TariffSchemaModel;

	invoiceItemComponentsIds: string[] = [];

	invoiceItemComponents: InvoiceItemComponentModel[];

	modelPropGroups: { [s: string]: Group } = InvoiceItemModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
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
				name: 'totalOtherComponentPrice',
				// % protected region % [Set displayName for Total Other Component Price here] off begin
				displayName: 'Total Other Component Price',
				// % protected region % [Set displayName for Total Other Component Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Other Component Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Other Component Price here] end
				// % protected region % [Set isSensitive for Total Other Component Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Other Component Price here] end
				// % protected region % [Set readonly for Total Other Component Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Other Component Price here] end
				validators: [
					// % protected region % [Add other validators for Total Other Component Price here] off begin
					// % protected region % [Add other validators for Total Other Component Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Other Component Price here] off begin
				// % protected region % [Add any additional model attribute properties for Total Other Component Price here] end
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
				name: 'discount',
				// % protected region % [Set displayName for Discount here] off begin
				displayName: 'Discount',
				// % protected region % [Set displayName for Discount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Discount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Discount here] end
				// % protected region % [Set isSensitive for Discount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Discount here] end
				// % protected region % [Set readonly for Discount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Discount here] end
				validators: [
					// % protected region % [Add other validators for Discount here] off begin
					// % protected region % [Add other validators for Discount here] end
				],
				// % protected region % [Add any additional model attribute properties for Discount here] off begin
				// % protected region % [Add any additional model attribute properties for Discount here] end
			},
			{
				name: 'tax',
				// % protected region % [Set displayName for Tax here] off begin
				displayName: 'Tax',
				// % protected region % [Set displayName for Tax here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Tax here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Tax here] end
				// % protected region % [Set isSensitive for Tax here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax here] end
				// % protected region % [Set readonly for Tax here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax here] end
				validators: [
					// % protected region % [Add other validators for Tax here] off begin
					// % protected region % [Add other validators for Tax here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax here] off begin
				// % protected region % [Add any additional model attribute properties for Tax here] end
			},
			{
				name: 'itemTotal',
				// % protected region % [Set displayName for Item Total here] off begin
				displayName: 'Item Total',
				// % protected region % [Set displayName for Item Total here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Item Total here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Item Total here] end
				// % protected region % [Set isSensitive for Item Total here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Item Total here] end
				// % protected region % [Set readonly for Item Total here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Item Total here] end
				validators: [
					// % protected region % [Add other validators for Item Total here] off begin
					// % protected region % [Add other validators for Item Total here] end
				],
				// % protected region % [Add any additional model attribute properties for Item Total here] off begin
				// % protected region % [Add any additional model attribute properties for Item Total here] end
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
					Validators.maxLength(500),
					// % protected region % [Add other validators for Notes here] off begin
					// % protected region % [Add other validators for Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Notes here] end
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
				id: 'invoiceItemComponents',
				type: ModelRelationType.MANY,
				name: 'invoiceItemComponentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Item Components here] off begin
				label: 'Invoice Item Components',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Item Components here] end
				entityName: 'InvoiceItemComponentModel',
				// % protected region % [Customise your display name for Invoice Item Components here] off begin
				displayName: 'price',
				// % protected region % [Customise your display name for Invoice Item Components here] end
				validators: [
					// % protected region % [Add other validators for Invoice Item Components here] off begin
					// % protected region % [Add other validators for Invoice Item Components here] end
				],
				// % protected region % [Add any additional field for relation Invoice Item Components here] off begin
				// % protected region % [Add any additional field for relation Invoice Item Components here] end
			},
			{
				id: 'invoice',
				type: ModelRelationType.ONE,
				name: 'invoiceId',
				// % protected region % [Customise your label for Invoice here] off begin
				label: 'Invoice',
				// % protected region % [Customise your label for Invoice here] end
				entityName: 'InvoiceModel',
				// % protected region % [Customise your display name for Invoice here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
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
				id: 'medicalFee',
				type: ModelRelationType.ONE,
				name: 'medicalFeeId',
				// % protected region % [Customise your label for Medical Fee here] off begin
				label: 'Medical Fee',
				// % protected region % [Customise your label for Medical Fee here] end
				entityName: 'MedicalFeeModel',
				// % protected region % [Customise your display name for Medical Fee here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'tariffType',
				// % protected region % [Customise your display name for Medical Fee here] end
				validators: [
					// % protected region % [Add other validators for Medical Fee here] off begin
					// % protected region % [Add other validators for Medical Fee here] end
				],
				// % protected region % [Add any additional field for relation Medical Fee here] off begin
				// % protected region % [Add any additional field for relation Medical Fee here] end
			},
			{
				id: 'medicationHeader',
				type: ModelRelationType.ONE,
				name: 'medicationHeaderId',
				// % protected region % [Customise your label for Medication Header here] off begin
				label: 'Medication Header',
				// % protected region % [Customise your label for Medication Header here] end
				entityName: 'MedicationHeaderModel',
				// % protected region % [Customise your display name for Medication Header here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'medicationNumber',
				// % protected region % [Customise your display name for Medication Header here] end
				validators: [
					// % protected region % [Add other validators for Medication Header here] off begin
					// % protected region % [Add other validators for Medication Header here] end
				],
				// % protected region % [Add any additional field for relation Medication Header here] off begin
				// % protected region % [Add any additional field for relation Medication Header here] end
			},
			{
				id: 'prescription',
				type: ModelRelationType.ONE,
				name: 'prescriptionId',
				// % protected region % [Customise your label for Prescription here] off begin
				label: 'Prescription',
				// % protected region % [Customise your label for Prescription here] end
				entityName: 'PrescriptionHeaderModel',
				// % protected region % [Customise your display name for Prescription here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'prescriptionNumber',
				// % protected region % [Customise your display name for Prescription here] end
				validators: [
					// % protected region % [Add other validators for Prescription here] off begin
					// % protected region % [Add other validators for Prescription here] end
				],
				// % protected region % [Add any additional field for relation Prescription here] off begin
				// % protected region % [Add any additional field for relation Prescription here] end
			},
			{
				id: 'retailPharmacyInvoice',
				type: ModelRelationType.ONE,
				name: 'retailPharmacyInvoiceId',
				// % protected region % [Customise your label for Retail Pharmacy Invoice here] off begin
				label: 'Retail Pharmacy Invoice',
				// % protected region % [Customise your label for Retail Pharmacy Invoice here] end
				entityName: 'RetailPharmacyInvoiceModel',
				// % protected region % [Customise your display name for Retail Pharmacy Invoice here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'invoiceNumber',
				// % protected region % [Customise your display name for Retail Pharmacy Invoice here] end
				validators: [
					// % protected region % [Add other validators for Retail Pharmacy Invoice here] off begin
					// % protected region % [Add other validators for Retail Pharmacy Invoice here] end
				],
				// % protected region % [Add any additional field for relation Retail Pharmacy Invoice here] off begin
				// % protected region % [Add any additional field for relation Retail Pharmacy Invoice here] end
			},
			{
				id: 'serviceNumber',
				type: ModelRelationType.ONE,
				name: 'serviceNumberId',
				// % protected region % [Customise your label for Service Number here] off begin
				label: 'Service Number',
				// % protected region % [Customise your label for Service Number here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Service Number here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Service Number here] end
				validators: [
					// % protected region % [Add other validators for Service Number here] off begin
					// % protected region % [Add other validators for Service Number here] end
				],
				// % protected region % [Add any additional field for relation Service Number here] off begin
				// % protected region % [Add any additional field for relation Service Number here] end
			},
			{
				id: 'tariffSchema',
				type: ModelRelationType.ONE,
				name: 'tariffSchemaId',
				// % protected region % [Customise your label for Tariff Schema here] off begin
				label: 'Tariff Schema',
				// % protected region % [Customise your label for Tariff Schema here] end
				entityName: 'TariffSchemaModel',
				// % protected region % [Customise your display name for Tariff Schema here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'schemaCode',
				// % protected region % [Customise your display name for Tariff Schema here] end
				validators: [
					// % protected region % [Add other validators for Tariff Schema here] off begin
					// % protected region % [Add other validators for Tariff Schema here] end
				],
				// % protected region % [Add any additional field for relation Tariff Schema here] off begin
				// % protected region % [Add any additional field for relation Tariff Schema here] end
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
	static deepParse(data: string | { [K in keyof InvoiceItemModel]?: InvoiceItemModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InvoiceItemModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.invoice) {
			currentModel.invoiceId = json.invoice.id;
			returned = _.union(returned, InvoiceModel.deepParse(json.invoice));
		}

		// Incoming one to many
		if (json.medicalFee) {
			currentModel.medicalFeeId = json.medicalFee.id;
			returned = _.union(returned, MedicalFeeModel.deepParse(json.medicalFee));
		}

		// Incoming one to many
		if (json.medicationHeader) {
			currentModel.medicationHeaderId = json.medicationHeader.id;
			returned = _.union(returned, MedicationHeaderModel.deepParse(json.medicationHeader));
		}

		// Incoming one to many
		if (json.prescription) {
			currentModel.prescriptionId = json.prescription.id;
			returned = _.union(returned, PrescriptionHeaderModel.deepParse(json.prescription));
		}

		// Incoming one to many
		if (json.retailPharmacyInvoice) {
			currentModel.retailPharmacyInvoiceId = json.retailPharmacyInvoice.id;
			returned = _.union(returned, RetailPharmacyInvoiceModel.deepParse(json.retailPharmacyInvoice));
		}

		// Incoming one to many
		if (json.serviceNumber) {
			currentModel.serviceNumberId = json.serviceNumber.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.serviceNumber));
		}

		// Incoming one to many
		if (json.tariffSchema) {
			currentModel.tariffSchemaId = json.tariffSchema.id;
			returned = _.union(returned, TariffSchemaModel.deepParse(json.tariffSchema));
		}

		// Outgoing one to many
		if (json.invoiceItemComponents) {
			currentModel.invoiceItemComponentsIds = json.invoiceItemComponents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoiceItemComponents.map(model => InvoiceItemComponentModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let invoiceItemModel = new InvoiceItemModel(data);`
	 *
	 * @param data The input data to be initialised as the InvoiceItemModel,
	 *    it is expected as a JSON string or as a nullable InvoiceItemModel.
	 */
	constructor(data?: string | Partial<InvoiceItemModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InvoiceItemModel>
				: data;

			if (json.transactionDate) {
				this.transactionDate = new Date(json.transactionDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.transactionDate = json.transactionDate;
			}
			this.tariffCode = json.tariffCode;
			this.tariffType = json.tariffType;
			this.name = json.name;
			this.medicalStaffCode = json.medicalStaffCode;
			this.price = json.price;
			this.hospitalPrice = json.hospitalPrice;
			this.totalOtherComponentPrice = json.totalOtherComponentPrice;
			this.quantity = json.quantity;
			this.unit = json.unit;
			this.discount = json.discount;
			this.tax = json.tax;
			this.itemTotal = json.itemTotal;
			this.treatmentClass = json.treatmentClass;
			this.notes = json.notes;
			this.tariffType = json.tariffType;
			this.invoiceId = json.invoiceId;
			this.invoice = json.invoice;
			this.medicalFeeId = json.medicalFeeId;
			this.medicalFee = json.medicalFee;
			this.medicationHeaderId = json.medicationHeaderId;
			this.medicationHeader = json.medicationHeader;
			this.prescriptionId = json.prescriptionId;
			this.prescription = json.prescription;
			this.retailPharmacyInvoiceId = json.retailPharmacyInvoiceId;
			this.retailPharmacyInvoice = json.retailPharmacyInvoice;
			this.serviceNumberId = json.serviceNumberId;
			this.serviceNumber = json.serviceNumber;
			this.tariffSchemaId = json.tariffSchemaId;
			this.tariffSchema = json.tariffSchema;
			this.invoiceItemComponentsIds = json.invoiceItemComponentsIds;
			this.invoiceItemComponents = json.invoiceItemComponents;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			transactionDate: this.transactionDate,
			tariffCode: this.tariffCode,
			tariffType: this.tariffType,
			name: this.name,
			medicalStaffCode: this.medicalStaffCode,
			price: this.price,
			hospitalPrice: this.hospitalPrice,
			totalOtherComponentPrice: this.totalOtherComponentPrice,
			quantity: this.quantity,
			unit: this.unit,
			discount: this.discount,
			tax: this.tax,
			itemTotal: this.itemTotal,
			treatmentClass: this.treatmentClass,
			notes: this.notes,
			invoiceId: this.invoiceId,
			medicalFeeId: this.medicalFeeId,
			medicationHeaderId: this.medicationHeaderId,
			prescriptionId: this.prescriptionId,
			retailPharmacyInvoiceId: this.retailPharmacyInvoiceId,
			serviceNumberId: this.serviceNumberId,
			tariffSchemaId: this.tariffSchemaId,
			invoiceItemComponentsIds: this.invoiceItemComponentsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InvoiceItemModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InvoiceItemModel {
		let newModelJson = this.toJSON();

		if (updates.transactionDate) {
			newModelJson.transactionDate = updates.transactionDate;
		}

		if (updates.tariffCode) {
			newModelJson.tariffCode = updates.tariffCode;
		}

		if (updates.tariffType) {
			newModelJson.tariffType = updates.tariffType;
		}

		if (updates.name) {
			newModelJson.name = updates.name;
		}

		if (updates.medicalStaffCode) {
			newModelJson.medicalStaffCode = updates.medicalStaffCode;
		}

		if (updates.price) {
			newModelJson.price = updates.price;
		}

		if (updates.hospitalPrice) {
			newModelJson.hospitalPrice = updates.hospitalPrice;
		}

		if (updates.totalOtherComponentPrice) {
			newModelJson.totalOtherComponentPrice = updates.totalOtherComponentPrice;
		}

		if (updates.quantity) {
			newModelJson.quantity = updates.quantity;
		}

		if (updates.unit) {
			newModelJson.unit = updates.unit;
		}

		if (updates.discount) {
			newModelJson.discount = updates.discount;
		}

		if (updates.tax) {
			newModelJson.tax = updates.tax;
		}

		if (updates.itemTotal) {
			newModelJson.itemTotal = updates.itemTotal;
		}

		if (updates.treatmentClass) {
			newModelJson.treatmentClass = updates.treatmentClass;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.tariffType) {
			newModelJson.tariffType = updates.tariffType;
		}

		if (updates.invoiceId) {
			newModelJson.invoiceId = updates.invoiceId;
		}

		if (updates.medicalFeeId) {
			newModelJson.medicalFeeId = updates.medicalFeeId;
		}

		if (updates.medicationHeaderId) {
			newModelJson.medicationHeaderId = updates.medicationHeaderId;
		}

		if (updates.prescriptionId) {
			newModelJson.prescriptionId = updates.prescriptionId;
		}

		if (updates.retailPharmacyInvoiceId) {
			newModelJson.retailPharmacyInvoiceId = updates.retailPharmacyInvoiceId;
		}

		if (updates.serviceNumberId) {
			newModelJson.serviceNumberId = updates.serviceNumberId;
		}

		if (updates.tariffSchemaId) {
			newModelJson.tariffSchemaId = updates.tariffSchemaId;
		}

		if (updates.invoiceItemComponentsIds) {
			newModelJson.invoiceItemComponentsIds = updates.invoiceItemComponentsIds;
		}

		return new InvoiceItemModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InvoiceItemModel)) {
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
			'medicalFeeId',
			'medicalFee',
			'medicationHeaderId',
			'medicationHeader',
			'prescriptionId',
			'prescription',
			'retailPharmacyInvoiceId',
			'retailPharmacyInvoice',
			'serviceNumberId',
			'serviceNumber',
			'tariffSchemaId',
			'tariffSchema',
			'invoiceItemComponentsIds',
			'invoiceItemComponents',
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

		if (!this.medicalFee) {
			this.medicalFeeId = null;
		} else {
			this.medicalFeeId = this.medicalFee.id;
		}

		if (!this.medicationHeader) {
			this.medicationHeaderId = null;
		} else {
			this.medicationHeaderId = this.medicationHeader.id;
		}

		if (!this.prescription) {
			this.prescriptionId = null;
		} else {
			this.prescriptionId = this.prescription.id;
		}

		if (!this.retailPharmacyInvoice) {
			this.retailPharmacyInvoiceId = null;
		} else {
			this.retailPharmacyInvoiceId = this.retailPharmacyInvoice.id;
		}

		if (!this.serviceNumber) {
			this.serviceNumberId = null;
		} else {
			this.serviceNumberId = this.serviceNumber.id;
		}

		if (!this.tariffSchema) {
			this.tariffSchemaId = null;
		} else {
			this.tariffSchemaId = this.tariffSchema.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
