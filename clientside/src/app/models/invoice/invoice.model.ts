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
import {InvoiceTypeEnum, invoiceTypeEnumArray} from '../../enums/invoice-type.enum';
import {BedFacilityModel} from '../bedFacility/bed_facility.model';
import {DiagnosesAndProceduresModel} from '../diagnosesAndProcedures/diagnoses_and_procedures.model';
import {InvoiceItemModel} from '../invoiceItem/invoice_item.model';
import {InvoicePaymentInsuranceModel} from '../invoicePaymentInsurance/invoice_payment_insurance.model';
import {InvoicePaymentOtherModel} from '../invoicePaymentOther/invoice_payment_other.model';
import {InvoicePaymentSelfPayingModel} from '../invoicePaymentSelfPaying/invoice_payment_self_paying.model';
import {InvoiceSummaryModel} from '../invoiceSummary/invoice_summary.model';
import {MedicationHeaderModel} from '../medicationHeader/medication_header.model';
import {PatientVisitModel} from '../patientVisit/patient_visit.model';
import {PrescriptionHeaderModel} from '../prescriptionHeader/prescription_header.model';
import {StaffModel} from '../staff/staff.model';
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
export class InvoiceModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'invoiceNumber',
		'invoiceType',
		'invoiceDate',
		'billingLocation',
		'patientPaymentType',
		'verificationDate',
		'doctorCode',
		'treatmentClass',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'invoiceNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InvoiceModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InvoiceModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Invoice Number (Max Length: 50).
	 */
	invoiceNumber: string;

	/**
	 * Revision Number of Invoice.
	 */
	revisionNumber: number;

	/**
	 * Invoice Status, get the Code from Reference Data where Type=INVOICE_STATUS. (Max Length: 20).
	 */
	invoiceStatus: string;

	/**
	 * Format is Date without time, by default is set to TODAY.
	 */
	invoiceDate: Date;

	/**
	 * Date time when the invoice was canceled or voided.
	 */
	cancelDate: Date;

	/**
	 * Billing Location, get the Code from Reference Data where Type=BILL_LOC. (Max Length: 20 chars).
	 */
	billingLocation: string;

	/**
	 * Notes, max length: 500.
	 */
	notes: string;

	/**
	 * The default payment type of this patient, get the Code from Reference Data where Type=PAT_PAY_TYPE. (Max Length: 20).
	 */
	patientPaymentType: string;

	/**
	 * .
	 */
	verificationDate: Date;

	/**
	 * Indicator to display doctor name on invoice print.
	 */
	displayDoctorOnPrint: boolean = false;

	/**
	 * Indicator to display ICD 10 on invoice print.
	 */
	displayICD10OnPrint: boolean = false;

	/**
	 * Indicator to display ICD 9 CM on invoice print.
	 */
	displayICD9CMOnPrint: boolean = false;

	/**
	 * Responsible doctor assigned to patient examination.
	 */
	doctorCode: string;

	/**
	 * Treatment Class, get the Code from Reference Data where Type=TREA_CLS. (Max Length: 20).
	 */
	treatmentClass: string;

	/**
	 * Admission Date Time.
	 */
	admissionDate: Date;

	/**
	 * Discharged Date Time.
	 */
	dischargedDate: Date;

	/**
	 * .
	 */
	claimNo: string;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=5, example=Sally}.
	 */
	invoiceType: InvoiceTypeEnum;

	invoicePaymentOtherId: string;

	invoicePaymentOther: InvoicePaymentOtherModel;

	invoicePaymentSelfPayingId: string;

	invoicePaymentSelfPaying: InvoicePaymentSelfPayingModel;

	invoiceSummaryId: string;

	invoiceSummary: InvoiceSummaryModel;

	prescriptionHeaderId: string;

	prescriptionHeader: PrescriptionHeaderModel;

	medicationHeaderId: string;

	medicationHeader: MedicationHeaderModel;

	icd10Id: string;

	icd10: DiagnosesAndProceduresModel;

	icd9CMId: string;

	icd9CM: DiagnosesAndProceduresModel;

	bedFacilityId: string;

	bedFacility: BedFacilityModel;

	patientVisitId: string;

	patientVisit: PatientVisitModel;

	tariffSchemaId: string;

	tariffSchema: TariffSchemaModel;

	verifiedById: string;

	verifiedBy: StaffModel;

	invoiceItemsIds: string[] = [];

	invoiceItems: InvoiceItemModel[];

	invoicePaymentInsurancesIds: string[] = [];

	invoicePaymentInsurances: InvoicePaymentInsuranceModel[];

	modelPropGroups: { [s: string]: Group } = InvoiceModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'invoiceNumber',
				// % protected region % [Set displayName for Invoice Number here] off begin
				displayName: 'Invoice Number',
				// % protected region % [Set displayName for Invoice Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Invoice Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Invoice Number here] end
				// % protected region % [Set isSensitive for Invoice Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Invoice Number here] end
				// % protected region % [Set readonly for Invoice Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Invoice Number here] end
				validators: [
					// % protected region % [Add other validators for Invoice Number here] off begin
					// % protected region % [Add other validators for Invoice Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Invoice Number here] off begin
				// % protected region % [Add any additional model attribute properties for Invoice Number here] end
			},
			{
				name: 'revisionNumber',
				// % protected region % [Set displayName for Revision Number here] off begin
				displayName: 'Revision Number',
				// % protected region % [Set displayName for Revision Number here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Revision Number here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Revision Number here] end
				// % protected region % [Set isSensitive for Revision Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Revision Number here] end
				// % protected region % [Set readonly for Revision Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Revision Number here] end
				validators: [
					// % protected region % [Add other validators for Revision Number here] off begin
					// % protected region % [Add other validators for Revision Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Revision Number here] off begin
				// % protected region % [Add any additional model attribute properties for Revision Number here] end
			},
			{
				name: 'invoiceStatus',
				// % protected region % [Set displayName for Invoice Status here] off begin
				displayName: 'Invoice Status',
				// % protected region % [Set displayName for Invoice Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Invoice Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Invoice Status here] end
				// % protected region % [Set isSensitive for Invoice Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Invoice Status here] end
				// % protected region % [Set readonly for Invoice Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Invoice Status here] end
				validators: [
					// % protected region % [Add other validators for Invoice Status here] off begin
					// % protected region % [Add other validators for Invoice Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Invoice Status here] off begin
				// % protected region % [Add any additional model attribute properties for Invoice Status here] end
			},
			{
				name: 'invoiceType',
				// % protected region % [Set displayName for Invoice Type here] off begin
				displayName: 'Invoice Type',
				// % protected region % [Set displayName for Invoice Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: invoiceTypeEnumArray,
				// % protected region % [Set display element type for Invoice Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Invoice Type here] end
				// % protected region % [Set isSensitive for Invoice Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Invoice Type here] end
				// % protected region % [Set readonly for Invoice Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Invoice Type here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Invoice Type here] off begin
					// % protected region % [Add other validators for Invoice Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Invoice Type here] off begin
				// % protected region % [Add any additional model attribute properties for Invoice Type here] end
			},
			{
				name: 'invoiceDate',
				// % protected region % [Set displayName for Invoice Date here] off begin
				displayName: 'Invoice Date',
				// % protected region % [Set displayName for Invoice Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Invoice Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Invoice Date here] end
				// % protected region % [Set isSensitive for Invoice Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Invoice Date here] end
				// % protected region % [Set readonly for Invoice Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Invoice Date here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Invoice Date here] off begin
					// % protected region % [Add other validators for Invoice Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Invoice Date here] off begin
				// % protected region % [Add any additional model attribute properties for Invoice Date here] end
			},
			{
				name: 'cancelDate',
				// % protected region % [Set displayName for Cancel Date here] off begin
				displayName: 'Cancel Date',
				// % protected region % [Set displayName for Cancel Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Cancel Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Cancel Date here] end
				// % protected region % [Set isSensitive for Cancel Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Cancel Date here] end
				// % protected region % [Set readonly for Cancel Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Cancel Date here] end
				validators: [
					// % protected region % [Add other validators for Cancel Date here] off begin
					// % protected region % [Add other validators for Cancel Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Cancel Date here] off begin
				// % protected region % [Add any additional model attribute properties for Cancel Date here] end
			},
			{
				name: 'billingLocation',
				// % protected region % [Set displayName for Billing Location here] off begin
				displayName: 'Billing Location',
				// % protected region % [Set displayName for Billing Location here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Billing Location here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Billing Location here] end
				// % protected region % [Set isSensitive for Billing Location here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Billing Location here] end
				// % protected region % [Set readonly for Billing Location here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Billing Location here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(20),
					// % protected region % [Add other validators for Billing Location here] off begin
					// % protected region % [Add other validators for Billing Location here] end
				],
				// % protected region % [Add any additional model attribute properties for Billing Location here] off begin
				// % protected region % [Add any additional model attribute properties for Billing Location here] end
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
			{
				name: 'patientPaymentType',
				// % protected region % [Set displayName for Patient Payment Type here] off begin
				displayName: 'Patient Payment Type',
				// % protected region % [Set displayName for Patient Payment Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient Payment Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient Payment Type here] end
				// % protected region % [Set isSensitive for Patient Payment Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Payment Type here] end
				// % protected region % [Set readonly for Patient Payment Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Payment Type here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Patient Payment Type here] off begin
					// % protected region % [Add other validators for Patient Payment Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Payment Type here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Payment Type here] end
			},
			{
				name: 'verificationDate',
				// % protected region % [Set displayName for Verification Date here] off begin
				displayName: 'Verification Date',
				// % protected region % [Set displayName for Verification Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Verification Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Verification Date here] end
				// % protected region % [Set isSensitive for Verification Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Verification Date here] end
				// % protected region % [Set readonly for Verification Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Verification Date here] end
				validators: [
					// % protected region % [Add other validators for Verification Date here] off begin
					// % protected region % [Add other validators for Verification Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Verification Date here] off begin
				// % protected region % [Add any additional model attribute properties for Verification Date here] end
			},
			{
				name: 'displayDoctorOnPrint',
				// % protected region % [Set displayName for Display Doctor on Print here] off begin
				displayName: 'Display Doctor on Print',
				// % protected region % [Set displayName for Display Doctor on Print here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Display Doctor on Print here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Display Doctor on Print here] end
				// % protected region % [Set isSensitive for Display Doctor on Print here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Display Doctor on Print here] end
				// % protected region % [Set readonly for Display Doctor on Print here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Display Doctor on Print here] end
				validators: [
					// % protected region % [Add other validators for Display Doctor on Print here] off begin
					// % protected region % [Add other validators for Display Doctor on Print here] end
				],
				// % protected region % [Add any additional model attribute properties for Display Doctor on Print here] off begin
				// % protected region % [Add any additional model attribute properties for Display Doctor on Print here] end
			},
			{
				name: 'displayICD10OnPrint',
				// % protected region % [Set displayName for Display ICD 10 on Print here] off begin
				displayName: 'Display ICD 10 on Print',
				// % protected region % [Set displayName for Display ICD 10 on Print here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Display ICD 10 on Print here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Display ICD 10 on Print here] end
				// % protected region % [Set isSensitive for Display ICD 10 on Print here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Display ICD 10 on Print here] end
				// % protected region % [Set readonly for Display ICD 10 on Print here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Display ICD 10 on Print here] end
				validators: [
					// % protected region % [Add other validators for Display ICD 10 on Print here] off begin
					// % protected region % [Add other validators for Display ICD 10 on Print here] end
				],
				// % protected region % [Add any additional model attribute properties for Display ICD 10 on Print here] off begin
				// % protected region % [Add any additional model attribute properties for Display ICD 10 on Print here] end
			},
			{
				name: 'displayICD9CMOnPrint',
				// % protected region % [Set displayName for Display ICD 9 CM on Print here] off begin
				displayName: 'Display ICD 9 CM on Print',
				// % protected region % [Set displayName for Display ICD 9 CM on Print here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Display ICD 9 CM on Print here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Display ICD 9 CM on Print here] end
				// % protected region % [Set isSensitive for Display ICD 9 CM on Print here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Display ICD 9 CM on Print here] end
				// % protected region % [Set readonly for Display ICD 9 CM on Print here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Display ICD 9 CM on Print here] end
				validators: [
					// % protected region % [Add other validators for Display ICD 9 CM on Print here] off begin
					// % protected region % [Add other validators for Display ICD 9 CM on Print here] end
				],
				// % protected region % [Add any additional model attribute properties for Display ICD 9 CM on Print here] off begin
				// % protected region % [Add any additional model attribute properties for Display ICD 9 CM on Print here] end
			},
			{
				name: 'doctorCode',
				// % protected region % [Set displayName for Doctor Code here] off begin
				displayName: 'Doctor Code',
				// % protected region % [Set displayName for Doctor Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor Code here] end
				// % protected region % [Set isSensitive for Doctor Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor Code here] end
				// % protected region % [Set readonly for Doctor Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor Code here] end
				validators: [
					// % protected region % [Add other validators for Doctor Code here] off begin
					// % protected region % [Add other validators for Doctor Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor Code here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor Code here] end
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
				name: 'admissionDate',
				// % protected region % [Set displayName for Admission Date here] off begin
				displayName: 'Admission Date',
				// % protected region % [Set displayName for Admission Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Admission Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Admission Date here] end
				// % protected region % [Set isSensitive for Admission Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Admission Date here] end
				// % protected region % [Set readonly for Admission Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Admission Date here] end
				validators: [
					// % protected region % [Add other validators for Admission Date here] off begin
					// % protected region % [Add other validators for Admission Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Admission Date here] off begin
				// % protected region % [Add any additional model attribute properties for Admission Date here] end
			},
			{
				name: 'dischargedDate',
				// % protected region % [Set displayName for Discharged Date here] off begin
				displayName: 'Discharged Date',
				// % protected region % [Set displayName for Discharged Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Discharged Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Discharged Date here] end
				// % protected region % [Set isSensitive for Discharged Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Discharged Date here] end
				// % protected region % [Set readonly for Discharged Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Discharged Date here] end
				validators: [
					// % protected region % [Add other validators for Discharged Date here] off begin
					// % protected region % [Add other validators for Discharged Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Discharged Date here] off begin
				// % protected region % [Add any additional model attribute properties for Discharged Date here] end
			},
			{
				name: 'claimNo',
				// % protected region % [Set displayName for Claim No here] off begin
				displayName: 'Claim No',
				// % protected region % [Set displayName for Claim No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Claim No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Claim No here] end
				// % protected region % [Set isSensitive for Claim No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Claim No here] end
				// % protected region % [Set readonly for Claim No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Claim No here] end
				validators: [
					// % protected region % [Add other validators for Claim No here] off begin
					// % protected region % [Add other validators for Claim No here] end
				],
				// % protected region % [Add any additional model attribute properties for Claim No here] off begin
				// % protected region % [Add any additional model attribute properties for Claim No here] end
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
				id: 'invoicePaymentInsurances',
				type: ModelRelationType.MANY,
				name: 'invoicePaymentInsurancesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Payment Insurances here] off begin
				label: 'Invoice Payment Insurances',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Payment Insurances here] end
				entityName: 'InvoicePaymentInsuranceModel',
				// % protected region % [Customise your display name for Invoice Payment Insurances here] off begin
				displayName: 'memberNo',
				// % protected region % [Customise your display name for Invoice Payment Insurances here] end
				validators: [
					// % protected region % [Add other validators for Invoice Payment Insurances here] off begin
					// % protected region % [Add other validators for Invoice Payment Insurances here] end
				],
				// % protected region % [Add any additional field for relation Invoice Payment Insurances here] off begin
				// % protected region % [Add any additional field for relation Invoice Payment Insurances here] end
			},
			{
				id: 'invoicePaymentOther',
				type: ModelRelationType.ONE,
				name: 'invoicePaymentOtherId',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Payment Other here] off begin
				label: 'Invoice Payment Other',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Payment Other here] end
				entityName: 'InvoicePaymentOtherModel',
				// % protected region % [Customise your display name for Invoice Payment Other here] off begin
				displayName: 'notes',
				// % protected region % [Customise your display name for Invoice Payment Other here] end
				validators: [
					// % protected region % [Add other validators for Invoice Payment Other here] off begin
					// % protected region % [Add other validators for Invoice Payment Other here] end
				],
				// % protected region % [Add any additional field for relation Invoice Payment Other here] off begin
				// % protected region % [Add any additional field for relation Invoice Payment Other here] end
			},
			{
				id: 'invoicePaymentSelfPaying',
				type: ModelRelationType.ONE,
				name: 'invoicePaymentSelfPayingId',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Payment Self Paying here] off begin
				label: 'Invoice Payment Self Paying',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Payment Self Paying here] end
				entityName: 'InvoicePaymentSelfPayingModel',
				// % protected region % [Customise your display name for Invoice Payment Self Paying here] off begin
				displayName: 'sponsorName',
				// % protected region % [Customise your display name for Invoice Payment Self Paying here] end
				validators: [
					// % protected region % [Add other validators for Invoice Payment Self Paying here] off begin
					// % protected region % [Add other validators for Invoice Payment Self Paying here] end
				],
				// % protected region % [Add any additional field for relation Invoice Payment Self Paying here] off begin
				// % protected region % [Add any additional field for relation Invoice Payment Self Paying here] end
			},
			{
				id: 'invoiceSummary',
				type: ModelRelationType.ONE,
				name: 'invoiceSummaryId',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Summary here] off begin
				label: 'Invoice Summary',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Summary here] end
				entityName: 'InvoiceSummaryModel',
				// % protected region % [Customise your display name for Invoice Summary here] off begin
				displayName: 'subTotal',
				// % protected region % [Customise your display name for Invoice Summary here] end
				validators: [
					// % protected region % [Add other validators for Invoice Summary here] off begin
					// % protected region % [Add other validators for Invoice Summary here] end
				],
				// % protected region % [Add any additional field for relation Invoice Summary here] off begin
				// % protected region % [Add any additional field for relation Invoice Summary here] end
			},
			{
				id: 'prescriptionHeader',
				type: ModelRelationType.ONE,
				name: 'prescriptionHeaderId',
				// % protected region % [Customise your 1-1 or 1-M label for Prescription Header here] off begin
				label: 'Prescription Header',
				// % protected region % [Customise your 1-1 or 1-M label for Prescription Header here] end
				entityName: 'PrescriptionHeaderModel',
				// % protected region % [Customise your display name for Prescription Header here] off begin
				displayName: 'prescriptionNumber',
				// % protected region % [Customise your display name for Prescription Header here] end
				validators: [
					// % protected region % [Add other validators for Prescription Header here] off begin
					// % protected region % [Add other validators for Prescription Header here] end
				],
				// % protected region % [Add any additional field for relation Prescription Header here] off begin
				// % protected region % [Add any additional field for relation Prescription Header here] end
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
				id: 'icd10',
				type: ModelRelationType.ONE,
				name: 'icd10Id',
				// % protected region % [Customise your label for ICD 10 here] off begin
				label: 'ICD 10',
				// % protected region % [Customise your label for ICD 10 here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for ICD 10 here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemType',
				// % protected region % [Customise your display name for ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for ICD 10 here] off begin
					// % protected region % [Add other validators for ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation ICD 10 here] off begin
				// % protected region % [Add any additional field for relation ICD 10 here] end
			},
			{
				id: 'icd9CM',
				type: ModelRelationType.ONE,
				name: 'icd9CMId',
				// % protected region % [Customise your label for ICD 9 CM here] off begin
				label: 'ICD 9 CM',
				// % protected region % [Customise your label for ICD 9 CM here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for ICD 9 CM here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemType',
				// % protected region % [Customise your display name for ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for ICD 9 CM here] off begin
					// % protected region % [Add other validators for ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation ICD 9 CM here] end
			},
			{
				id: 'bedFacility',
				type: ModelRelationType.ONE,
				name: 'bedFacilityId',
				// % protected region % [Customise your label for Bed Facility here] off begin
				label: 'Bed Facility',
				// % protected region % [Customise your label for Bed Facility here] end
				entityName: 'BedFacilityModel',
				// % protected region % [Customise your display name for Bed Facility here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'bedNumber',
				// % protected region % [Customise your display name for Bed Facility here] end
				validators: [
					// % protected region % [Add other validators for Bed Facility here] off begin
					// % protected region % [Add other validators for Bed Facility here] end
				],
				// % protected region % [Add any additional field for relation Bed Facility here] off begin
				// % protected region % [Add any additional field for relation Bed Facility here] end
			},
			{
				id: 'patientVisit',
				type: ModelRelationType.ONE,
				name: 'patientVisitId',
				// % protected region % [Customise your label for Patient Visit here] off begin
				label: 'Patient Visit',
				// % protected region % [Customise your label for Patient Visit here] end
				entityName: 'PatientVisitModel',
				// % protected region % [Customise your display name for Patient Visit here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'visitNumber',
				// % protected region % [Customise your display name for Patient Visit here] end
				validators: [
					// % protected region % [Add other validators for Patient Visit here] off begin
					// % protected region % [Add other validators for Patient Visit here] end
				],
				// % protected region % [Add any additional field for relation Patient Visit here] off begin
				// % protected region % [Add any additional field for relation Patient Visit here] end
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
					Validators.required
					// % protected region % [Add other validators for Tariff Schema here] off begin
					// % protected region % [Add other validators for Tariff Schema here] end
				],
				// % protected region % [Add any additional field for relation Tariff Schema here] off begin
				// % protected region % [Add any additional field for relation Tariff Schema here] end
			},
			{
				id: 'verifiedBy',
				type: ModelRelationType.ONE,
				name: 'verifiedById',
				// % protected region % [Customise your label for Verified By here] off begin
				label: 'Verified By',
				// % protected region % [Customise your label for Verified By here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Verified By here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Verified By here] end
				validators: [
					// % protected region % [Add other validators for Verified By here] off begin
					// % protected region % [Add other validators for Verified By here] end
				],
				// % protected region % [Add any additional field for relation Verified By here] off begin
				// % protected region % [Add any additional field for relation Verified By here] end
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
				case 'invoiceNumber':
					break;
				case 'invoiceType':
					conditions.push([
						{
							path: key,
							operation: QueryOperation.EQUAL,
							value: formGroup.value[key],
						}
					]);
					break;
				case 'invoiceDate':
					break;
				case 'billingLocation':
					break;
				case 'patientPaymentType':
					break;
				case 'verificationDate':
					break;
				case 'doctorCode':
					break;
				case 'treatmentClass':
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
	static deepParse(data: string | { [K in keyof InvoiceModel]?: InvoiceModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InvoiceModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.invoicePaymentOther) {
			currentModel.invoicePaymentOtherId = json.invoicePaymentOther.id;
			returned = _.union(returned, InvoicePaymentOtherModel.deepParse(json.invoicePaymentOther));
		}

		// Outgoing one to one
		if (json.invoicePaymentSelfPaying) {
			currentModel.invoicePaymentSelfPayingId = json.invoicePaymentSelfPaying.id;
			returned = _.union(returned, InvoicePaymentSelfPayingModel.deepParse(json.invoicePaymentSelfPaying));
		}

		// Outgoing one to one
		if (json.invoiceSummary) {
			currentModel.invoiceSummaryId = json.invoiceSummary.id;
			returned = _.union(returned, InvoiceSummaryModel.deepParse(json.invoiceSummary));
		}

		// Outgoing one to one
		if (json.prescriptionHeader) {
			currentModel.prescriptionHeaderId = json.prescriptionHeader.id;
			returned = _.union(returned, PrescriptionHeaderModel.deepParse(json.prescriptionHeader));
		}

		// Incoming one to one
		if (json.medicationHeader) {
			currentModel.medicationHeaderId = json.medicationHeader.id;
			returned = _.union(returned, MedicationHeaderModel.deepParse(json.medicationHeader));
		}

		// Incoming one to many
		if (json.icd10) {
			currentModel.icd10Id = json.icd10.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.icd10));
		}

		// Incoming one to many
		if (json.icd9CM) {
			currentModel.icd9CMId = json.icd9CM.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.icd9CM));
		}

		// Incoming one to many
		if (json.bedFacility) {
			currentModel.bedFacilityId = json.bedFacility.id;
			returned = _.union(returned, BedFacilityModel.deepParse(json.bedFacility));
		}

		// Incoming one to many
		if (json.patientVisit) {
			currentModel.patientVisitId = json.patientVisit.id;
			returned = _.union(returned, PatientVisitModel.deepParse(json.patientVisit));
		}

		// Incoming one to many
		if (json.tariffSchema) {
			currentModel.tariffSchemaId = json.tariffSchema.id;
			returned = _.union(returned, TariffSchemaModel.deepParse(json.tariffSchema));
		}

		// Incoming one to many
		if (json.verifiedBy) {
			currentModel.verifiedById = json.verifiedBy.id;
			returned = _.union(returned, StaffModel.deepParse(json.verifiedBy));
		}

		// Outgoing one to many
		if (json.invoiceItems) {
			currentModel.invoiceItemsIds = json.invoiceItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoiceItems.map(model => InvoiceItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.invoicePaymentInsurances) {
			currentModel.invoicePaymentInsurancesIds = json.invoicePaymentInsurances.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoicePaymentInsurances.map(model => InvoicePaymentInsuranceModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let invoiceModel = new InvoiceModel(data);`
	 *
	 * @param data The input data to be initialised as the InvoiceModel,
	 *    it is expected as a JSON string or as a nullable InvoiceModel.
	 */
	constructor(data?: string | Partial<InvoiceModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InvoiceModel>
				: data;

			this.invoiceNumber = json.invoiceNumber;
			this.revisionNumber = json.revisionNumber;
			this.invoiceStatus = json.invoiceStatus;
			this.invoiceType = json.invoiceType;
			if (json.invoiceDate) {
				this.invoiceDate = new Date(json.invoiceDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.invoiceDate = json.invoiceDate;
			}
			if (json.cancelDate) {
				this.cancelDate = new Date(json.cancelDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.cancelDate = json.cancelDate;
			}
			this.billingLocation = json.billingLocation;
			this.notes = json.notes;
			this.patientPaymentType = json.patientPaymentType;
			if (json.verificationDate) {
				this.verificationDate = new Date(json.verificationDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.verificationDate = json.verificationDate;
			}
			this.displayDoctorOnPrint = json.displayDoctorOnPrint;
			this.displayICD10OnPrint = json.displayICD10OnPrint;
			this.displayICD9CMOnPrint = json.displayICD9CMOnPrint;
			this.doctorCode = json.doctorCode;
			this.treatmentClass = json.treatmentClass;
			if (json.admissionDate) {
				this.admissionDate = new Date(json.admissionDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.admissionDate = json.admissionDate;
			}
			if (json.dischargedDate) {
				this.dischargedDate = new Date(json.dischargedDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dischargedDate = json.dischargedDate;
			}
			this.claimNo = json.claimNo;
			this.invoiceType = json.invoiceType;
			this.invoicePaymentOtherId = json.invoicePaymentOtherId;
			this.invoicePaymentOther = json.invoicePaymentOther;
			this.invoicePaymentSelfPayingId = json.invoicePaymentSelfPayingId;
			this.invoicePaymentSelfPaying = json.invoicePaymentSelfPaying;
			this.invoiceSummaryId = json.invoiceSummaryId;
			this.invoiceSummary = json.invoiceSummary;
			this.prescriptionHeaderId = json.prescriptionHeaderId;
			this.prescriptionHeader = json.prescriptionHeader;
			this.medicationHeaderId = json.medicationHeaderId;
			this.medicationHeader = json.medicationHeader;
			this.icd10Id = json.icd10Id;
			this.icd10 = json.icd10;
			this.icd9CMId = json.icd9CMId;
			this.icd9CM = json.icd9CM;
			this.bedFacilityId = json.bedFacilityId;
			this.bedFacility = json.bedFacility;
			this.patientVisitId = json.patientVisitId;
			this.patientVisit = json.patientVisit;
			this.tariffSchemaId = json.tariffSchemaId;
			this.tariffSchema = json.tariffSchema;
			this.verifiedById = json.verifiedById;
			this.verifiedBy = json.verifiedBy;
			this.invoiceItemsIds = json.invoiceItemsIds;
			this.invoiceItems = json.invoiceItems;
			this.invoicePaymentInsurancesIds = json.invoicePaymentInsurancesIds;
			this.invoicePaymentInsurances = json.invoicePaymentInsurances;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			invoiceNumber: this.invoiceNumber,
			revisionNumber: this.revisionNumber,
			invoiceStatus: this.invoiceStatus,
			invoiceType: this.invoiceType,
			invoiceDate: this.invoiceDate,
			cancelDate: this.cancelDate,
			billingLocation: this.billingLocation,
			notes: this.notes,
			patientPaymentType: this.patientPaymentType,
			verificationDate: this.verificationDate,
			displayDoctorOnPrint: this.displayDoctorOnPrint,
			displayICD10OnPrint: this.displayICD10OnPrint,
			displayICD9CMOnPrint: this.displayICD9CMOnPrint,
			doctorCode: this.doctorCode,
			treatmentClass: this.treatmentClass,
			admissionDate: this.admissionDate,
			dischargedDate: this.dischargedDate,
			claimNo: this.claimNo,
			invoicePaymentOtherId: this.invoicePaymentOtherId,
			invoicePaymentSelfPayingId: this.invoicePaymentSelfPayingId,
			invoiceSummaryId: this.invoiceSummaryId,
			prescriptionHeaderId: this.prescriptionHeaderId,
			medicationHeaderId: this.medicationHeaderId,
			icd10Id: this.icd10Id,
			icd9CMId: this.icd9CMId,
			bedFacilityId: this.bedFacilityId,
			patientVisitId: this.patientVisitId,
			tariffSchemaId: this.tariffSchemaId,
			verifiedById: this.verifiedById,
			invoiceItemsIds: this.invoiceItemsIds,
			invoicePaymentInsurancesIds: this.invoicePaymentInsurancesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InvoiceModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InvoiceModel {
		let newModelJson = this.toJSON();

		if (updates.invoiceNumber) {
			newModelJson.invoiceNumber = updates.invoiceNumber;
		}

		if (updates.revisionNumber) {
			newModelJson.revisionNumber = updates.revisionNumber;
		}

		if (updates.invoiceStatus) {
			newModelJson.invoiceStatus = updates.invoiceStatus;
		}

		if (updates.invoiceType) {
			newModelJson.invoiceType = updates.invoiceType;
		}

		if (updates.invoiceDate) {
			newModelJson.invoiceDate = updates.invoiceDate;
		}

		if (updates.cancelDate) {
			newModelJson.cancelDate = updates.cancelDate;
		}

		if (updates.billingLocation) {
			newModelJson.billingLocation = updates.billingLocation;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.patientPaymentType) {
			newModelJson.patientPaymentType = updates.patientPaymentType;
		}

		if (updates.verificationDate) {
			newModelJson.verificationDate = updates.verificationDate;
		}

		if (updates.displayDoctorOnPrint) {
			newModelJson.displayDoctorOnPrint = updates.displayDoctorOnPrint;
		}

		if (updates.displayICD10OnPrint) {
			newModelJson.displayICD10OnPrint = updates.displayICD10OnPrint;
		}

		if (updates.displayICD9CMOnPrint) {
			newModelJson.displayICD9CMOnPrint = updates.displayICD9CMOnPrint;
		}

		if (updates.doctorCode) {
			newModelJson.doctorCode = updates.doctorCode;
		}

		if (updates.treatmentClass) {
			newModelJson.treatmentClass = updates.treatmentClass;
		}

		if (updates.admissionDate) {
			newModelJson.admissionDate = updates.admissionDate;
		}

		if (updates.dischargedDate) {
			newModelJson.dischargedDate = updates.dischargedDate;
		}

		if (updates.claimNo) {
			newModelJson.claimNo = updates.claimNo;
		}

		if (updates.invoiceType) {
			newModelJson.invoiceType = updates.invoiceType;
		}

		if (updates.invoicePaymentOtherId) {
			newModelJson.invoicePaymentOtherId = updates.invoicePaymentOtherId;
		}

		if (updates.invoicePaymentSelfPayingId) {
			newModelJson.invoicePaymentSelfPayingId = updates.invoicePaymentSelfPayingId;
		}

		if (updates.invoiceSummaryId) {
			newModelJson.invoiceSummaryId = updates.invoiceSummaryId;
		}

		if (updates.prescriptionHeaderId) {
			newModelJson.prescriptionHeaderId = updates.prescriptionHeaderId;
		}

		if (updates.medicationHeaderId) {
			newModelJson.medicationHeaderId = updates.medicationHeaderId;
		}

		if (updates.icd10Id) {
			newModelJson.icd10Id = updates.icd10Id;
		}

		if (updates.icd9CMId) {
			newModelJson.icd9CMId = updates.icd9CMId;
		}

		if (updates.bedFacilityId) {
			newModelJson.bedFacilityId = updates.bedFacilityId;
		}

		if (updates.patientVisitId) {
			newModelJson.patientVisitId = updates.patientVisitId;
		}

		if (updates.tariffSchemaId) {
			newModelJson.tariffSchemaId = updates.tariffSchemaId;
		}

		if (updates.verifiedById) {
			newModelJson.verifiedById = updates.verifiedById;
		}

		if (updates.invoiceItemsIds) {
			newModelJson.invoiceItemsIds = updates.invoiceItemsIds;
		}

		if (updates.invoicePaymentInsurancesIds) {
			newModelJson.invoicePaymentInsurancesIds = updates.invoicePaymentInsurancesIds;
		}

		return new InvoiceModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InvoiceModel)) {
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
			'invoicePaymentOtherId',
			'invoicePaymentOther',
			'invoicePaymentSelfPayingId',
			'invoicePaymentSelfPaying',
			'invoiceSummaryId',
			'invoiceSummary',
			'prescriptionHeaderId',
			'prescriptionHeader',
			'medicationHeaderId',
			'medicationHeader',
			'icd10Id',
			'icd10',
			'icd9CMId',
			'icd9CM',
			'bedFacilityId',
			'bedFacility',
			'patientVisitId',
			'patientVisit',
			'tariffSchemaId',
			'tariffSchema',
			'verifiedById',
			'verifiedBy',
			'invoiceItemsIds',
			'invoiceItems',
			'invoicePaymentInsurancesIds',
			'invoicePaymentInsurances',
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
		if (!this.invoicePaymentOther) {
			this.invoicePaymentOtherId = null;
		} else {
			this.invoicePaymentOtherId = this.invoicePaymentOther.id;
		}

		if (!this.invoicePaymentSelfPaying) {
			this.invoicePaymentSelfPayingId = null;
		} else {
			this.invoicePaymentSelfPayingId = this.invoicePaymentSelfPaying.id;
		}

		if (!this.invoiceSummary) {
			this.invoiceSummaryId = null;
		} else {
			this.invoiceSummaryId = this.invoiceSummary.id;
		}

		if (!this.prescriptionHeader) {
			this.prescriptionHeaderId = null;
		} else {
			this.prescriptionHeaderId = this.prescriptionHeader.id;
		}

		if (!this.medicationHeader) {
			this.medicationHeaderId = null;
		} else {
			this.medicationHeaderId = this.medicationHeader.id;
		}

		if (!this.icd10) {
			this.icd10Id = null;
		} else {
			this.icd10Id = this.icd10.id;
		}

		if (!this.icd9CM) {
			this.icd9CMId = null;
		} else {
			this.icd9CMId = this.icd9CM.id;
		}

		if (!this.bedFacility) {
			this.bedFacilityId = null;
		} else {
			this.bedFacilityId = this.bedFacility.id;
		}

		if (!this.patientVisit) {
			this.patientVisitId = null;
		} else {
			this.patientVisitId = this.patientVisit.id;
		}

		if (!this.tariffSchema) {
			this.tariffSchemaId = null;
		} else {
			this.tariffSchemaId = this.tariffSchema.id;
		}

		if (!this.verifiedBy) {
			this.verifiedById = null;
		} else {
			this.verifiedById = this.verifiedBy.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
