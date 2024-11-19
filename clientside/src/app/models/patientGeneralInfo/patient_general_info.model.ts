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
import {BpjsClaimSubmissionModel} from '../bpjsClaimSubmission/bpjs_claim_submission.model';
import {CashReceiptModel} from '../cashReceipt/cash_receipt.model';
import {CashRefundModel} from '../cashRefund/cash_refund.model';
import {InformedConsentModel} from '../informedConsent/informed_consent.model';
import {PatientCaseHistoryModel} from '../patientCaseHistory/patient_case_history.model';
import {PatientConsentModel} from '../patientConsent/patient_consent.model';
import {PatientContactInfoModel} from '../patientContactInfo/patient_contact_info.model';
import {PatientDetailModel} from '../patientDetail/patient_detail.model';
import {PatientDetailAddressModel} from '../patientDetailAddress/patient_detail_address.model';
import {PatientEmergencyContactDetailModel} from '../patientEmergencyContactDetail/patient_emergency_contact_detail.model';
import {PatientEmploymentDetailModel} from '../patientEmploymentDetail/patient_employment_detail.model';
import {PatientPaymentSelfPayingModel} from '../patientPaymentSelfPaying/patient_payment_self_paying.model';
import {PatientPaymentBPJSModel} from '../patientPaymentBPJS/patient_payment_bpjs.model';
import {PatientPaymentInsuranceModel} from '../patientPaymentInsurance/patient_payment_insurance.model';
import {PatientPaymentOthersModel} from '../patientPaymentOthers/patient_payment_others.model';
import {PatientPersonalInfoModel} from '../patientPersonalInfo/patient_personal_info.model';
import {PatientSupportingDocumentModel} from '../patientSupportingDocument/patient_supporting_document.model';
import {PatientVisitModel} from '../patientVisit/patient_visit.model';
import {RetailPharmacyModel} from '../retailPharmacy/retail_pharmacy.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import {FileModel} from '../../lib/models/file.model';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class PatientGeneralInfoModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'patientID',
		'givenName',
		'lastName',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'patientID',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PatientGeneralInfoModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PatientGeneralInfoModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Patient identification number. It's 10 digits number where the format can be configured from branch configuration setting. (Max Length: 50 chars).
	 */
	patientID: string;

	/**
	 * Patient title, get the Code from Reference Data where Type=TITTLE. (Max Length: 20 chars).
	 */
	title: string;

	/**
	 * First patient name. (Max Length: 250 chars).
	 */
	givenName: string;

	/**
	 * Last name of the patient name. (Max Length: 250 chars).
	 */
	lastName: string;

	/**
	 * The place where the patient was born. (Max Length: 250 chars).
	 */
	placeOfBirth: string;

	/**
	 * The date when the patient was born.
	 */
	dateOfBirth: Date;

	/**
	 * The gender of the patient., get the Code from Reference Data where Type=GENDER. (Max Length: 20).
	 */
	gender: string;

	/**
	 * Address where patient lives. (Max Length: 250 chars).
	 */
	address: string;

	/**
	 * The default payment type of this patient, get the Code from Reference Data where Type=PAT_PAY_TYPE. (Max Length: 20).
	 */
	patientPaymentType: string;

	/**
	 * Any specific information about patient that will be displayed on registration or examination screen (Max Length: 5000).
	 */
	importantNotes: string;

	/**
	 * Patient Picture.
	 */
	patientPicture: FileModel[];

	/**
	 * Indicator if there is any invoice that has not been fully paid yet.
	 */
	hasOutstandingPayment: boolean = false;

	patientContactInformationId: string;

	patientContactInformation: PatientContactInfoModel;

	patientDetailAddressId: string;

	patientDetailAddress: PatientDetailAddressModel;

	patientDetailId: string;

	patientDetail: PatientDetailModel;

	patientEmergencyContactDetailId: string;

	patientEmergencyContactDetail: PatientEmergencyContactDetailModel;

	patientEmploymentDetailId: string;

	patientEmploymentDetail: PatientEmploymentDetailModel;

	patientPaymentBPJSId: string;

	patientPaymentBPJS: PatientPaymentBPJSModel;

	patientPaymentTypeInsuranceId: string;

	patientPaymentTypeInsurance: PatientPaymentInsuranceModel;

	patientPaymentTypeOthersId: string;

	patientPaymentTypeOthers: PatientPaymentOthersModel;

	patientPersonalInformationId: string;

	patientPersonalInformation: PatientPersonalInfoModel;

	patientSelfPayingId: string;

	patientSelfPaying: PatientPaymentSelfPayingModel;

	bpjsClaimSubmissionsIds: string[] = [];

	bpjsClaimSubmissions: BpjsClaimSubmissionModel[];

	cashRefundsIds: string[] = [];

	cashRefunds: CashRefundModel[];

	informedConsentsIds: string[] = [];

	informedConsents: InformedConsentModel[];

	invoiceReceiptsIds: string[] = [];

	invoiceReceipts: CashReceiptModel[];

	patientCaseHistoriesIds: string[] = [];

	patientCaseHistories: PatientCaseHistoryModel[];

	patientConsentsIds: string[] = [];

	patientConsents: PatientConsentModel[];

	patientFinalizeProfilesIds: string[] = [];

	patientFinalizeProfiles: PatientSupportingDocumentModel[];

	retailPharmaciesIds: string[] = [];

	retailPharmacies: RetailPharmacyModel[];

	visitsIds: string[] = [];

	visits: PatientVisitModel[];

	modelPropGroups: { [s: string]: Group } = PatientGeneralInfoModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'patientID',
				// % protected region % [Set displayName for Patient ID here] off begin
				displayName: 'Patient ID',
				// % protected region % [Set displayName for Patient ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient ID here] end
				// % protected region % [Set isSensitive for Patient ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient ID here] end
				// % protected region % [Set readonly for Patient ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient ID here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Patient ID here] off begin
					// % protected region % [Add other validators for Patient ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient ID here] off begin
				// % protected region % [Add any additional model attribute properties for Patient ID here] end
			},
			{
				name: 'title',
				// % protected region % [Set displayName for Title here] off begin
				displayName: 'Title',
				// % protected region % [Set displayName for Title here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Title here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Title here] end
				// % protected region % [Set isSensitive for Title here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Title here] end
				// % protected region % [Set readonly for Title here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Title here] end
				validators: [
					// % protected region % [Add other validators for Title here] off begin
					// % protected region % [Add other validators for Title here] end
				],
				// % protected region % [Add any additional model attribute properties for Title here] off begin
				// % protected region % [Add any additional model attribute properties for Title here] end
			},
			{
				name: 'givenName',
				// % protected region % [Set displayName for Given Name here] off begin
				displayName: 'Given Name',
				// % protected region % [Set displayName for Given Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Given Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Given Name here] end
				// % protected region % [Set isSensitive for Given Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Given Name here] end
				// % protected region % [Set readonly for Given Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Given Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Given Name here] off begin
					// % protected region % [Add other validators for Given Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Given Name here] off begin
				// % protected region % [Add any additional model attribute properties for Given Name here] end
			},
			{
				name: 'lastName',
				// % protected region % [Set displayName for Last Name here] off begin
				displayName: 'Last Name',
				// % protected region % [Set displayName for Last Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Last Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Last Name here] end
				// % protected region % [Set isSensitive for Last Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Last Name here] end
				// % protected region % [Set readonly for Last Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Last Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Last Name here] off begin
					// % protected region % [Add other validators for Last Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Name here] off begin
				// % protected region % [Add any additional model attribute properties for Last Name here] end
			},
			{
				name: 'placeOfBirth',
				// % protected region % [Set displayName for Place of Birth here] off begin
				displayName: 'Place of Birth',
				// % protected region % [Set displayName for Place of Birth here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Place of Birth here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Place of Birth here] end
				// % protected region % [Set isSensitive for Place of Birth here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Place of Birth here] end
				// % protected region % [Set readonly for Place of Birth here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Place of Birth here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Place of Birth here] off begin
					// % protected region % [Add other validators for Place of Birth here] end
				],
				// % protected region % [Add any additional model attribute properties for Place of Birth here] off begin
				// % protected region % [Add any additional model attribute properties for Place of Birth here] end
			},
			{
				name: 'dateOfBirth',
				// % protected region % [Set displayName for Date of Birth here] off begin
				displayName: 'Date of Birth',
				// % protected region % [Set displayName for Date of Birth here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Date of Birth here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Date of Birth here] end
				// % protected region % [Set isSensitive for Date of Birth here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date of Birth here] end
				// % protected region % [Set readonly for Date of Birth here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date of Birth here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Date of Birth here] off begin
					// % protected region % [Add other validators for Date of Birth here] end
				],
				// % protected region % [Add any additional model attribute properties for Date of Birth here] off begin
				// % protected region % [Add any additional model attribute properties for Date of Birth here] end
			},
			{
				name: 'gender',
				// % protected region % [Set displayName for Gender here] off begin
				displayName: 'Gender',
				// % protected region % [Set displayName for Gender here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gender here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gender here] end
				// % protected region % [Set isSensitive for Gender here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gender here] end
				// % protected region % [Set readonly for Gender here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gender here] end
				validators: [
					// % protected region % [Add other validators for Gender here] off begin
					// % protected region % [Add other validators for Gender here] end
				],
				// % protected region % [Add any additional model attribute properties for Gender here] off begin
				// % protected region % [Add any additional model attribute properties for Gender here] end
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
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Address here] off begin
					// % protected region % [Add other validators for Address here] end
				],
				// % protected region % [Add any additional model attribute properties for Address here] off begin
				// % protected region % [Add any additional model attribute properties for Address here] end
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
					// % protected region % [Add other validators for Patient Payment Type here] off begin
					// % protected region % [Add other validators for Patient Payment Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Payment Type here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Payment Type here] end
			},
			{
				name: 'importantNotes',
				// % protected region % [Set displayName for Important Notes here] off begin
				displayName: 'Important Notes',
				// % protected region % [Set displayName for Important Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Important Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Important Notes here] end
				// % protected region % [Set isSensitive for Important Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Important Notes here] end
				// % protected region % [Set readonly for Important Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Important Notes here] end
				validators: [
					// % protected region % [Add other validators for Important Notes here] off begin
					// % protected region % [Add other validators for Important Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Important Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Important Notes here] end
			},
			{
				name: 'patientPicture',
				// % protected region % [Set displayName for Patient Picture here] off begin
				displayName: 'Patient Picture',
				// % protected region % [Set displayName for Patient Picture here] end
				type: ModelPropertyType.FILE,
				// % protected region % [Set display element type for Patient Picture here] off begin
				elementType: ElementType.FILE,
				// % protected region % [Set display element type for Patient Picture here] end
				// % protected region % [Set isSensitive for Patient Picture here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Picture here] end
				// % protected region % [Set readonly for Patient Picture here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Picture here] end
				validators: [
					// % protected region % [Add other validators for Patient Picture here] off begin
					// % protected region % [Add other validators for Patient Picture here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Picture here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Picture here] end
			},
			{
				name: 'hasOutstandingPayment',
				// % protected region % [Set displayName for Has Outstanding Payment here] off begin
				displayName: 'Has Outstanding Payment',
				// % protected region % [Set displayName for Has Outstanding Payment here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Has Outstanding Payment here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Has Outstanding Payment here] end
				// % protected region % [Set isSensitive for Has Outstanding Payment here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Has Outstanding Payment here] end
				// % protected region % [Set readonly for Has Outstanding Payment here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Has Outstanding Payment here] end
				validators: [
					// % protected region % [Add other validators for Has Outstanding Payment here] off begin
					// % protected region % [Add other validators for Has Outstanding Payment here] end
				],
				// % protected region % [Add any additional model attribute properties for Has Outstanding Payment here] off begin
				// % protected region % [Add any additional model attribute properties for Has Outstanding Payment here] end
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
				id: 'bpjsClaimSubmissions',
				type: ModelRelationType.MANY,
				name: 'bpjsClaimSubmissionsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Claim Submissions here] off begin
				label: 'BPJS Claim Submissions',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Claim Submissions here] end
				entityName: 'BpjsClaimSubmissionModel',
				// % protected region % [Customise your display name for BPJS Claim Submissions here] off begin
				displayName: 'sepNo',
				// % protected region % [Customise your display name for BPJS Claim Submissions here] end
				validators: [
					// % protected region % [Add other validators for BPJS Claim Submissions here] off begin
					// % protected region % [Add other validators for BPJS Claim Submissions here] end
				],
				// % protected region % [Add any additional field for relation BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional field for relation BPJS Claim Submissions here] end
			},
			{
				id: 'cashRefunds',
				type: ModelRelationType.MANY,
				name: 'cashRefundsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Cash Refunds here] off begin
				label: 'Cash Refunds',
				// % protected region % [Customise your 1-1 or 1-M label for Cash Refunds here] end
				entityName: 'CashRefundModel',
				// % protected region % [Customise your display name for Cash Refunds here] off begin
				displayName: 'refundNumber',
				// % protected region % [Customise your display name for Cash Refunds here] end
				validators: [
					// % protected region % [Add other validators for Cash Refunds here] off begin
					// % protected region % [Add other validators for Cash Refunds here] end
				],
				// % protected region % [Add any additional field for relation Cash Refunds here] off begin
				// % protected region % [Add any additional field for relation Cash Refunds here] end
			},
			{
				id: 'informedConsents',
				type: ModelRelationType.MANY,
				name: 'informedConsentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Informed Consents here] off begin
				label: 'Informed Consents',
				// % protected region % [Customise your 1-1 or 1-M label for Informed Consents here] end
				entityName: 'InformedConsentModel',
				// % protected region % [Customise your display name for Informed Consents here] off begin
				displayName: 'patientFamilyGuardianName',
				// % protected region % [Customise your display name for Informed Consents here] end
				validators: [
					// % protected region % [Add other validators for Informed Consents here] off begin
					// % protected region % [Add other validators for Informed Consents here] end
				],
				// % protected region % [Add any additional field for relation Informed Consents here] off begin
				// % protected region % [Add any additional field for relation Informed Consents here] end
			},
			{
				id: 'invoiceReceipts',
				type: ModelRelationType.MANY,
				name: 'invoiceReceiptsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Receipts here] off begin
				label: 'Invoice Receipts',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Receipts here] end
				entityName: 'CashReceiptModel',
				// % protected region % [Customise your display name for Invoice Receipts here] off begin
				displayName: 'receiptType',
				// % protected region % [Customise your display name for Invoice Receipts here] end
				validators: [
					// % protected region % [Add other validators for Invoice Receipts here] off begin
					// % protected region % [Add other validators for Invoice Receipts here] end
				],
				// % protected region % [Add any additional field for relation Invoice Receipts here] off begin
				// % protected region % [Add any additional field for relation Invoice Receipts here] end
			},
			{
				id: 'patientCaseHistories',
				type: ModelRelationType.MANY,
				name: 'patientCaseHistoriesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Case Histories here] off begin
				label: 'Patient Case Histories',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Case Histories here] end
				entityName: 'PatientCaseHistoryModel',
				// % protected region % [Customise your display name for Patient Case Histories here] off begin
				displayName: 'allergy',
				// % protected region % [Customise your display name for Patient Case Histories here] end
				validators: [
					// % protected region % [Add other validators for Patient Case Histories here] off begin
					// % protected region % [Add other validators for Patient Case Histories here] end
				],
				// % protected region % [Add any additional field for relation Patient Case Histories here] off begin
				// % protected region % [Add any additional field for relation Patient Case Histories here] end
			},
			{
				id: 'patientConsents',
				type: ModelRelationType.MANY,
				name: 'patientConsentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Consents here] off begin
				label: 'Patient Consents',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Consents here] end
				entityName: 'PatientConsentModel',
				// % protected region % [Customise your display name for Patient Consents here] off begin
				displayName: 'consentDateTime',
				// % protected region % [Customise your display name for Patient Consents here] end
				validators: [
					// % protected region % [Add other validators for Patient Consents here] off begin
					// % protected region % [Add other validators for Patient Consents here] end
				],
				// % protected region % [Add any additional field for relation Patient Consents here] off begin
				// % protected region % [Add any additional field for relation Patient Consents here] end
			},
			{
				id: 'patientContactInformation',
				type: ModelRelationType.ONE,
				name: 'patientContactInformationId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Contact Information here] off begin
				label: 'Patient Contact Information',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Contact Information here] end
				entityName: 'PatientContactInfoModel',
				// % protected region % [Customise your display name for Patient Contact Information here] off begin
				displayName: 'mobilePhoneNo',
				// % protected region % [Customise your display name for Patient Contact Information here] end
				validators: [
					// % protected region % [Add other validators for Patient Contact Information here] off begin
					// % protected region % [Add other validators for Patient Contact Information here] end
				],
				// % protected region % [Add any additional field for relation Patient Contact Information here] off begin
				// % protected region % [Add any additional field for relation Patient Contact Information here] end
			},
			{
				id: 'patientDetailAddress',
				type: ModelRelationType.ONE,
				name: 'patientDetailAddressId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Detail Address here] off begin
				label: 'Patient Detail Address',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Detail Address here] end
				entityName: 'PatientDetailAddressModel',
				// % protected region % [Customise your display name for Patient Detail Address here] off begin
				displayName: 'country',
				// % protected region % [Customise your display name for Patient Detail Address here] end
				validators: [
					// % protected region % [Add other validators for Patient Detail Address here] off begin
					// % protected region % [Add other validators for Patient Detail Address here] end
				],
				// % protected region % [Add any additional field for relation Patient Detail Address here] off begin
				// % protected region % [Add any additional field for relation Patient Detail Address here] end
			},
			{
				id: 'patientDetail',
				type: ModelRelationType.ONE,
				name: 'patientDetailId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Detail here] off begin
				label: 'Patient Detail',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Detail here] end
				entityName: 'PatientDetailModel',
				// % protected region % [Customise your display name for Patient Detail here] off begin
				displayName: 'activePatientID',
				// % protected region % [Customise your display name for Patient Detail here] end
				validators: [
					// % protected region % [Add other validators for Patient Detail here] off begin
					// % protected region % [Add other validators for Patient Detail here] end
				],
				// % protected region % [Add any additional field for relation Patient Detail here] off begin
				// % protected region % [Add any additional field for relation Patient Detail here] end
			},
			{
				id: 'patientEmergencyContactDetail',
				type: ModelRelationType.ONE,
				name: 'patientEmergencyContactDetailId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Emergency Contact Detail here] off begin
				label: 'Patient Emergency Contact Detail',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Emergency Contact Detail here] end
				entityName: 'PatientEmergencyContactDetailModel',
				// % protected region % [Customise your display name for Patient Emergency Contact Detail here] off begin
				displayName: 'title',
				// % protected region % [Customise your display name for Patient Emergency Contact Detail here] end
				validators: [
					// % protected region % [Add other validators for Patient Emergency Contact Detail here] off begin
					// % protected region % [Add other validators for Patient Emergency Contact Detail here] end
				],
				// % protected region % [Add any additional field for relation Patient Emergency Contact Detail here] off begin
				// % protected region % [Add any additional field for relation Patient Emergency Contact Detail here] end
			},
			{
				id: 'patientEmploymentDetail',
				type: ModelRelationType.ONE,
				name: 'patientEmploymentDetailId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Employment Detail  here] off begin
				label: 'Patient Employment Detail ',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Employment Detail  here] end
				entityName: 'PatientEmploymentDetailModel',
				// % protected region % [Customise your display name for Patient Employment Detail  here] off begin
				displayName: 'employeeID',
				// % protected region % [Customise your display name for Patient Employment Detail  here] end
				validators: [
					// % protected region % [Add other validators for Patient Employment Detail  here] off begin
					// % protected region % [Add other validators for Patient Employment Detail  here] end
				],
				// % protected region % [Add any additional field for relation Patient Employment Detail  here] off begin
				// % protected region % [Add any additional field for relation Patient Employment Detail  here] end
			},
			{
				id: 'patientFinalizeProfiles',
				type: ModelRelationType.MANY,
				name: 'patientFinalizeProfilesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Finalize Profiles here] off begin
				label: 'Patient Finalize Profiles',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Finalize Profiles here] end
				entityName: 'PatientSupportingDocumentModel',
				// % protected region % [Customise your display name for Patient Finalize Profiles here] off begin
				displayName: 'supportingDocument',
				// % protected region % [Customise your display name for Patient Finalize Profiles here] end
				validators: [
					// % protected region % [Add other validators for Patient Finalize Profiles here] off begin
					// % protected region % [Add other validators for Patient Finalize Profiles here] end
				],
				// % protected region % [Add any additional field for relation Patient Finalize Profiles here] off begin
				// % protected region % [Add any additional field for relation Patient Finalize Profiles here] end
			},
			{
				id: 'patientPaymentBPJS',
				type: ModelRelationType.ONE,
				name: 'patientPaymentBPJSId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Payment BPJS here] off begin
				label: 'Patient Payment BPJS',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Payment BPJS here] end
				entityName: 'PatientPaymentBPJSModel',
				// % protected region % [Customise your display name for Patient Payment BPJS here] off begin
				displayName: 'bpjsCardNo',
				// % protected region % [Customise your display name for Patient Payment BPJS here] end
				validators: [
					// % protected region % [Add other validators for Patient Payment BPJS here] off begin
					// % protected region % [Add other validators for Patient Payment BPJS here] end
				],
				// % protected region % [Add any additional field for relation Patient Payment BPJS here] off begin
				// % protected region % [Add any additional field for relation Patient Payment BPJS here] end
			},
			{
				id: 'patientPaymentTypeInsurance',
				type: ModelRelationType.ONE,
				name: 'patientPaymentTypeInsuranceId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Payment Type Insurance here] off begin
				label: 'Patient Payment Type Insurance',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Payment Type Insurance here] end
				entityName: 'PatientPaymentInsuranceModel',
				// % protected region % [Customise your display name for Patient Payment Type Insurance here] off begin
				displayName: 'memberNo',
				// % protected region % [Customise your display name for Patient Payment Type Insurance here] end
				validators: [
					// % protected region % [Add other validators for Patient Payment Type Insurance here] off begin
					// % protected region % [Add other validators for Patient Payment Type Insurance here] end
				],
				// % protected region % [Add any additional field for relation Patient Payment Type Insurance here] off begin
				// % protected region % [Add any additional field for relation Patient Payment Type Insurance here] end
			},
			{
				id: 'patientPaymentTypeOthers',
				type: ModelRelationType.ONE,
				name: 'patientPaymentTypeOthersId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Payment Type Others here] off begin
				label: 'Patient Payment Type Others',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Payment Type Others here] end
				entityName: 'PatientPaymentOthersModel',
				// % protected region % [Customise your display name for Patient Payment Type Others here] off begin
				displayName: 'notes',
				// % protected region % [Customise your display name for Patient Payment Type Others here] end
				validators: [
					// % protected region % [Add other validators for Patient Payment Type Others here] off begin
					// % protected region % [Add other validators for Patient Payment Type Others here] end
				],
				// % protected region % [Add any additional field for relation Patient Payment Type Others here] off begin
				// % protected region % [Add any additional field for relation Patient Payment Type Others here] end
			},
			{
				id: 'patientPersonalInformation',
				type: ModelRelationType.ONE,
				name: 'patientPersonalInformationId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Personal Information here] off begin
				label: 'Patient Personal Information',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Personal Information here] end
				entityName: 'PatientPersonalInfoModel',
				// % protected region % [Customise your display name for Patient Personal Information here] off begin
				displayName: 'religion',
				// % protected region % [Customise your display name for Patient Personal Information here] end
				validators: [
					// % protected region % [Add other validators for Patient Personal Information here] off begin
					// % protected region % [Add other validators for Patient Personal Information here] end
				],
				// % protected region % [Add any additional field for relation Patient Personal Information here] off begin
				// % protected region % [Add any additional field for relation Patient Personal Information here] end
			},
			{
				id: 'patientSelfPaying',
				type: ModelRelationType.ONE,
				name: 'patientSelfPayingId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Self Paying here] off begin
				label: 'Patient Self Paying',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Self Paying here] end
				entityName: 'PatientPaymentSelfPayingModel',
				// % protected region % [Customise your display name for Patient Self Paying here] off begin
				displayName: 'sponsorName',
				// % protected region % [Customise your display name for Patient Self Paying here] end
				validators: [
					// % protected region % [Add other validators for Patient Self Paying here] off begin
					// % protected region % [Add other validators for Patient Self Paying here] end
				],
				// % protected region % [Add any additional field for relation Patient Self Paying here] off begin
				// % protected region % [Add any additional field for relation Patient Self Paying here] end
			},
			{
				id: 'retailPharmacies',
				type: ModelRelationType.MANY,
				name: 'retailPharmaciesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Retail Pharmacies here] off begin
				label: 'Retail Pharmacies',
				// % protected region % [Customise your 1-1 or 1-M label for Retail Pharmacies here] end
				entityName: 'RetailPharmacyModel',
				// % protected region % [Customise your display name for Retail Pharmacies here] off begin
				displayName: 'customerType',
				// % protected region % [Customise your display name for Retail Pharmacies here] end
				validators: [
					// % protected region % [Add other validators for Retail Pharmacies here] off begin
					// % protected region % [Add other validators for Retail Pharmacies here] end
				],
				// % protected region % [Add any additional field for relation Retail Pharmacies here] off begin
				// % protected region % [Add any additional field for relation Retail Pharmacies here] end
			},
			{
				id: 'visits',
				type: ModelRelationType.MANY,
				name: 'visitsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Visits here] off begin
				label: 'Visits',
				// % protected region % [Customise your 1-1 or 1-M label for Visits here] end
				entityName: 'PatientVisitModel',
				// % protected region % [Customise your display name for Visits here] off begin
				displayName: 'visitNumber',
				// % protected region % [Customise your display name for Visits here] end
				validators: [
					// % protected region % [Add other validators for Visits here] off begin
					// % protected region % [Add other validators for Visits here] end
				],
				// % protected region % [Add any additional field for relation Visits here] off begin
				// % protected region % [Add any additional field for relation Visits here] end
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
				case 'patientID':
					break;
				case 'givenName':
					break;
				case 'lastName':
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
	static deepParse(data: string | { [K in keyof PatientGeneralInfoModel]?: PatientGeneralInfoModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PatientGeneralInfoModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.patientContactInformation) {
			currentModel.patientContactInformationId = json.patientContactInformation.id;
			returned = _.union(returned, PatientContactInfoModel.deepParse(json.patientContactInformation));
		}

		// Outgoing one to one
		if (json.patientDetailAddress) {
			currentModel.patientDetailAddressId = json.patientDetailAddress.id;
			returned = _.union(returned, PatientDetailAddressModel.deepParse(json.patientDetailAddress));
		}

		// Outgoing one to one
		if (json.patientDetail) {
			currentModel.patientDetailId = json.patientDetail.id;
			returned = _.union(returned, PatientDetailModel.deepParse(json.patientDetail));
		}

		// Outgoing one to one
		if (json.patientEmergencyContactDetail) {
			currentModel.patientEmergencyContactDetailId = json.patientEmergencyContactDetail.id;
			returned = _.union(returned, PatientEmergencyContactDetailModel.deepParse(json.patientEmergencyContactDetail));
		}

		// Outgoing one to one
		if (json.patientEmploymentDetail) {
			currentModel.patientEmploymentDetailId = json.patientEmploymentDetail.id;
			returned = _.union(returned, PatientEmploymentDetailModel.deepParse(json.patientEmploymentDetail));
		}

		// Outgoing one to one
		if (json.patientPaymentBPJS) {
			currentModel.patientPaymentBPJSId = json.patientPaymentBPJS.id;
			returned = _.union(returned, PatientPaymentBPJSModel.deepParse(json.patientPaymentBPJS));
		}

		// Outgoing one to one
		if (json.patientPaymentTypeInsurance) {
			currentModel.patientPaymentTypeInsuranceId = json.patientPaymentTypeInsurance.id;
			returned = _.union(returned, PatientPaymentInsuranceModel.deepParse(json.patientPaymentTypeInsurance));
		}

		// Outgoing one to one
		if (json.patientPaymentTypeOthers) {
			currentModel.patientPaymentTypeOthersId = json.patientPaymentTypeOthers.id;
			returned = _.union(returned, PatientPaymentOthersModel.deepParse(json.patientPaymentTypeOthers));
		}

		// Outgoing one to one
		if (json.patientPersonalInformation) {
			currentModel.patientPersonalInformationId = json.patientPersonalInformation.id;
			returned = _.union(returned, PatientPersonalInfoModel.deepParse(json.patientPersonalInformation));
		}

		// Outgoing one to one
		if (json.patientSelfPaying) {
			currentModel.patientSelfPayingId = json.patientSelfPaying.id;
			returned = _.union(returned, PatientPaymentSelfPayingModel.deepParse(json.patientSelfPaying));
		}

		// Outgoing one to many
		if (json.bpjsClaimSubmissions) {
			currentModel.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsClaimSubmissions.map(model => BpjsClaimSubmissionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.cashRefunds) {
			currentModel.cashRefundsIds = json.cashRefunds.map(model => model.id);
			returned = _.union(returned, _.flatten(json.cashRefunds.map(model => CashRefundModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.informedConsents) {
			currentModel.informedConsentsIds = json.informedConsents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.informedConsents.map(model => InformedConsentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.invoiceReceipts) {
			currentModel.invoiceReceiptsIds = json.invoiceReceipts.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoiceReceipts.map(model => CashReceiptModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.patientCaseHistories) {
			currentModel.patientCaseHistoriesIds = json.patientCaseHistories.map(model => model.id);
			returned = _.union(returned, _.flatten(json.patientCaseHistories.map(model => PatientCaseHistoryModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.patientConsents) {
			currentModel.patientConsentsIds = json.patientConsents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.patientConsents.map(model => PatientConsentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.patientFinalizeProfiles) {
			currentModel.patientFinalizeProfilesIds = json.patientFinalizeProfiles.map(model => model.id);
			returned = _.union(returned, _.flatten(json.patientFinalizeProfiles.map(model => PatientSupportingDocumentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.retailPharmacies) {
			currentModel.retailPharmaciesIds = json.retailPharmacies.map(model => model.id);
			returned = _.union(returned, _.flatten(json.retailPharmacies.map(model => RetailPharmacyModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.visits) {
			currentModel.visitsIds = json.visits.map(model => model.id);
			returned = _.union(returned, _.flatten(json.visits.map(model => PatientVisitModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let patientGeneralInfoModel = new PatientGeneralInfoModel(data);`
	 *
	 * @param data The input data to be initialised as the PatientGeneralInfoModel,
	 *    it is expected as a JSON string or as a nullable PatientGeneralInfoModel.
	 */
	constructor(data?: string | Partial<PatientGeneralInfoModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PatientGeneralInfoModel>
				: data;

			this.patientID = json.patientID;
			this.title = json.title;
			this.givenName = json.givenName;
			this.lastName = json.lastName;
			this.placeOfBirth = json.placeOfBirth;
			if (json.dateOfBirth) {
				this.dateOfBirth = new Date(json.dateOfBirth);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dateOfBirth = json.dateOfBirth;
			}
			this.gender = json.gender;
			this.address = json.address;
			this.patientPaymentType = json.patientPaymentType;
			this.importantNotes = json.importantNotes;
			this.patientPicture = json.patientPicture?.map(item => new FileModel(item));
			this.hasOutstandingPayment = json.hasOutstandingPayment;
			this.patientContactInformationId = json.patientContactInformationId;
			this.patientContactInformation = json.patientContactInformation;
			this.patientDetailAddressId = json.patientDetailAddressId;
			this.patientDetailAddress = json.patientDetailAddress;
			this.patientDetailId = json.patientDetailId;
			this.patientDetail = json.patientDetail;
			this.patientEmergencyContactDetailId = json.patientEmergencyContactDetailId;
			this.patientEmergencyContactDetail = json.patientEmergencyContactDetail;
			this.patientEmploymentDetailId = json.patientEmploymentDetailId;
			this.patientEmploymentDetail = json.patientEmploymentDetail;
			this.patientPaymentBPJSId = json.patientPaymentBPJSId;
			this.patientPaymentBPJS = json.patientPaymentBPJS;
			this.patientPaymentTypeInsuranceId = json.patientPaymentTypeInsuranceId;
			this.patientPaymentTypeInsurance = json.patientPaymentTypeInsurance;
			this.patientPaymentTypeOthersId = json.patientPaymentTypeOthersId;
			this.patientPaymentTypeOthers = json.patientPaymentTypeOthers;
			this.patientPersonalInformationId = json.patientPersonalInformationId;
			this.patientPersonalInformation = json.patientPersonalInformation;
			this.patientSelfPayingId = json.patientSelfPayingId;
			this.patientSelfPaying = json.patientSelfPaying;
			this.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissionsIds;
			this.bpjsClaimSubmissions = json.bpjsClaimSubmissions;
			this.cashRefundsIds = json.cashRefundsIds;
			this.cashRefunds = json.cashRefunds;
			this.informedConsentsIds = json.informedConsentsIds;
			this.informedConsents = json.informedConsents;
			this.invoiceReceiptsIds = json.invoiceReceiptsIds;
			this.invoiceReceipts = json.invoiceReceipts;
			this.patientCaseHistoriesIds = json.patientCaseHistoriesIds;
			this.patientCaseHistories = json.patientCaseHistories;
			this.patientConsentsIds = json.patientConsentsIds;
			this.patientConsents = json.patientConsents;
			this.patientFinalizeProfilesIds = json.patientFinalizeProfilesIds;
			this.patientFinalizeProfiles = json.patientFinalizeProfiles;
			this.retailPharmaciesIds = json.retailPharmaciesIds;
			this.retailPharmacies = json.retailPharmacies;
			this.visitsIds = json.visitsIds;
			this.visits = json.visits;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			patientID: this.patientID,
			title: this.title,
			givenName: this.givenName,
			lastName: this.lastName,
			placeOfBirth: this.placeOfBirth,
			dateOfBirth: this.dateOfBirth,
			gender: this.gender,
			address: this.address,
			patientPaymentType: this.patientPaymentType,
			importantNotes: this.importantNotes,
			patientPicture: this.patientPicture,
			hasOutstandingPayment: this.hasOutstandingPayment,
			patientContactInformationId: this.patientContactInformationId,
			patientDetailAddressId: this.patientDetailAddressId,
			patientDetailId: this.patientDetailId,
			patientEmergencyContactDetailId: this.patientEmergencyContactDetailId,
			patientEmploymentDetailId: this.patientEmploymentDetailId,
			patientPaymentBPJSId: this.patientPaymentBPJSId,
			patientPaymentTypeInsuranceId: this.patientPaymentTypeInsuranceId,
			patientPaymentTypeOthersId: this.patientPaymentTypeOthersId,
			patientPersonalInformationId: this.patientPersonalInformationId,
			patientSelfPayingId: this.patientSelfPayingId,
			bpjsClaimSubmissionsIds: this.bpjsClaimSubmissionsIds,
			cashRefundsIds: this.cashRefundsIds,
			informedConsentsIds: this.informedConsentsIds,
			invoiceReceiptsIds: this.invoiceReceiptsIds,
			patientCaseHistoriesIds: this.patientCaseHistoriesIds,
			patientConsentsIds: this.patientConsentsIds,
			patientFinalizeProfilesIds: this.patientFinalizeProfilesIds,
			retailPharmaciesIds: this.retailPharmaciesIds,
			visitsIds: this.visitsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PatientGeneralInfoModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PatientGeneralInfoModel {
		let newModelJson = this.toJSON();

		if (updates.patientID) {
			newModelJson.patientID = updates.patientID;
		}

		if (updates.title) {
			newModelJson.title = updates.title;
		}

		if (updates.givenName) {
			newModelJson.givenName = updates.givenName;
		}

		if (updates.lastName) {
			newModelJson.lastName = updates.lastName;
		}

		if (updates.placeOfBirth) {
			newModelJson.placeOfBirth = updates.placeOfBirth;
		}

		if (updates.dateOfBirth) {
			newModelJson.dateOfBirth = updates.dateOfBirth;
		}

		if (updates.gender) {
			newModelJson.gender = updates.gender;
		}

		if (updates.address) {
			newModelJson.address = updates.address;
		}

		if (updates.patientPaymentType) {
			newModelJson.patientPaymentType = updates.patientPaymentType;
		}

		if (updates.importantNotes) {
			newModelJson.importantNotes = updates.importantNotes;
		}

		if (updates.patientPicture) {
			newModelJson.patientPicture = updates.patientPicture;
		}

		if (updates.hasOutstandingPayment) {
			newModelJson.hasOutstandingPayment = updates.hasOutstandingPayment;
		}

		if (updates.patientContactInformationId) {
			newModelJson.patientContactInformationId = updates.patientContactInformationId;
		}

		if (updates.patientDetailAddressId) {
			newModelJson.patientDetailAddressId = updates.patientDetailAddressId;
		}

		if (updates.patientDetailId) {
			newModelJson.patientDetailId = updates.patientDetailId;
		}

		if (updates.patientEmergencyContactDetailId) {
			newModelJson.patientEmergencyContactDetailId = updates.patientEmergencyContactDetailId;
		}

		if (updates.patientEmploymentDetailId) {
			newModelJson.patientEmploymentDetailId = updates.patientEmploymentDetailId;
		}

		if (updates.patientPaymentBPJSId) {
			newModelJson.patientPaymentBPJSId = updates.patientPaymentBPJSId;
		}

		if (updates.patientPaymentTypeInsuranceId) {
			newModelJson.patientPaymentTypeInsuranceId = updates.patientPaymentTypeInsuranceId;
		}

		if (updates.patientPaymentTypeOthersId) {
			newModelJson.patientPaymentTypeOthersId = updates.patientPaymentTypeOthersId;
		}

		if (updates.patientPersonalInformationId) {
			newModelJson.patientPersonalInformationId = updates.patientPersonalInformationId;
		}

		if (updates.patientSelfPayingId) {
			newModelJson.patientSelfPayingId = updates.patientSelfPayingId;
		}

		if (updates.bpjsClaimSubmissionsIds) {
			newModelJson.bpjsClaimSubmissionsIds = updates.bpjsClaimSubmissionsIds;
		}

		if (updates.cashRefundsIds) {
			newModelJson.cashRefundsIds = updates.cashRefundsIds;
		}

		if (updates.informedConsentsIds) {
			newModelJson.informedConsentsIds = updates.informedConsentsIds;
		}

		if (updates.invoiceReceiptsIds) {
			newModelJson.invoiceReceiptsIds = updates.invoiceReceiptsIds;
		}

		if (updates.patientCaseHistoriesIds) {
			newModelJson.patientCaseHistoriesIds = updates.patientCaseHistoriesIds;
		}

		if (updates.patientConsentsIds) {
			newModelJson.patientConsentsIds = updates.patientConsentsIds;
		}

		if (updates.patientFinalizeProfilesIds) {
			newModelJson.patientFinalizeProfilesIds = updates.patientFinalizeProfilesIds;
		}

		if (updates.retailPharmaciesIds) {
			newModelJson.retailPharmaciesIds = updates.retailPharmaciesIds;
		}

		if (updates.visitsIds) {
			newModelJson.visitsIds = updates.visitsIds;
		}

		return new PatientGeneralInfoModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PatientGeneralInfoModel)) {
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
			} else if (['patientPicture'].includes(key)) {;
				const thisFiles = JSON.stringify(thisValue);
				const otherFiles = JSON.stringify(otherValue);

				if (thisFiles !== otherFiles) {
					diff[key] = thisValue;
				}
			} else if (thisValue !== otherValue) {
				diff[key] = thisValue;
			}
		}

		return _.omit(diff, [
			'created',
			'modified',
			'patientContactInformationId',
			'patientContactInformation',
			'patientDetailAddressId',
			'patientDetailAddress',
			'patientDetailId',
			'patientDetail',
			'patientEmergencyContactDetailId',
			'patientEmergencyContactDetail',
			'patientEmploymentDetailId',
			'patientEmploymentDetail',
			'patientPaymentBPJSId',
			'patientPaymentBPJS',
			'patientPaymentTypeInsuranceId',
			'patientPaymentTypeInsurance',
			'patientPaymentTypeOthersId',
			'patientPaymentTypeOthers',
			'patientPersonalInformationId',
			'patientPersonalInformation',
			'patientSelfPayingId',
			'patientSelfPaying',
			'bpjsClaimSubmissionsIds',
			'bpjsClaimSubmissions',
			'cashRefundsIds',
			'cashRefunds',
			'informedConsentsIds',
			'informedConsents',
			'invoiceReceiptsIds',
			'invoiceReceipts',
			'patientCaseHistoriesIds',
			'patientCaseHistories',
			'patientConsentsIds',
			'patientConsents',
			'patientFinalizeProfilesIds',
			'patientFinalizeProfiles',
			'retailPharmaciesIds',
			'retailPharmacies',
			'visitsIds',
			'visits',
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
		if (!this.patientContactInformation) {
			this.patientContactInformationId = null;
		} else {
			this.patientContactInformationId = this.patientContactInformation.id;
		}

		if (!this.patientDetailAddress) {
			this.patientDetailAddressId = null;
		} else {
			this.patientDetailAddressId = this.patientDetailAddress.id;
		}

		if (!this.patientDetail) {
			this.patientDetailId = null;
		} else {
			this.patientDetailId = this.patientDetail.id;
		}

		if (!this.patientEmergencyContactDetail) {
			this.patientEmergencyContactDetailId = null;
		} else {
			this.patientEmergencyContactDetailId = this.patientEmergencyContactDetail.id;
		}

		if (!this.patientEmploymentDetail) {
			this.patientEmploymentDetailId = null;
		} else {
			this.patientEmploymentDetailId = this.patientEmploymentDetail.id;
		}

		if (!this.patientPaymentBPJS) {
			this.patientPaymentBPJSId = null;
		} else {
			this.patientPaymentBPJSId = this.patientPaymentBPJS.id;
		}

		if (!this.patientPaymentTypeInsurance) {
			this.patientPaymentTypeInsuranceId = null;
		} else {
			this.patientPaymentTypeInsuranceId = this.patientPaymentTypeInsurance.id;
		}

		if (!this.patientPaymentTypeOthers) {
			this.patientPaymentTypeOthersId = null;
		} else {
			this.patientPaymentTypeOthersId = this.patientPaymentTypeOthers.id;
		}

		if (!this.patientPersonalInformation) {
			this.patientPersonalInformationId = null;
		} else {
			this.patientPersonalInformationId = this.patientPersonalInformation.id;
		}

		if (!this.patientSelfPaying) {
			this.patientSelfPayingId = null;
		} else {
			this.patientSelfPayingId = this.patientSelfPaying.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
