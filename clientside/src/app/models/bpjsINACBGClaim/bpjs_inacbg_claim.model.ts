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
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsINACBGClaimModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'claimNo',
		'patientID',
		'invoiceNumber',
		'bpjsCardNo',
		'sepNo',
		'treatmentType',
		'treatmentClass',
		'admissionDate',
		'dismissalDate',
		'los',
		'dismissal',
		'responsibleDoctor',
		'weight',
		'adl',
		'claimStatus',
		'sepStatus',
		'staffName',
		'dateGrouping',
		'inacbgTariff',
		'description',
		'cbgType',
		'tariff',
		'subAcute',
		'subAcuteCode',
		'chronic',
		'chronicCode',
		'tariffType',
		'visitDate',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'claimNo',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsINACBGClaimModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsINACBGClaimModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	claimNo: string;

	/**
	 * .
	 */
	patientID: string;

	/**
	 * .
	 */
	invoiceNumber: string;

	/**
	 * .
	 */
	bpjsCardNo: string;

	/**
	 * .
	 */
	sepNo: string;

	/**
	 * .
	 */
	treatmentType: string;

	/**
	 * .
	 */
	treatmentClass: string;

	/**
	 * .
	 */
	admissionDate: Date;

	/**
	 * .
	 */
	dismissalDate: Date;

	/**
	 * Length of Staf.
	 */
	los: string;

	/**
	 * .
	 */
	dismissal: string;

	/**
	 * .
	 */
	responsibleDoctor: string;

	/**
	 * Newborn in gram.
	 */
	weight: number;

	/**
	 * .
	 */
	adl: number;

	/**
	 * .
	 */
	claimStatus: string;

	/**
	 * .
	 */
	sepStatus: string;

	/**
	 * .
	 */
	hospitalTariff: number;

	/**
	 * .
	 */
	referralLetter: string;

	/**
	 * .
	 */
	thirdSelLevel: string;

	/**
	 * .
	 */
	staffName: string;

	/**
	 * .
	 */
	dateGrouping: Date;

	/**
	 * .
	 */
	inacbgTariff: string;

	/**
	 * .
	 */
	description: string;

	/**
	 * .
	 */
	cbgType: string;

	/**
	 * .
	 */
	tariff: number;

	/**
	 * .
	 */
	subAcute: string;

	/**
	 * .
	 */
	subAcuteCode: string;

	/**
	 * .
	 */
	subAcuteTariff: number;

	/**
	 * .
	 */
	chronic: string;

	/**
	 * .
	 */
	chronicCode: string;

	/**
	 * .
	 */
	chronicTariff: number;

	/**
	 * .
	 */
	resultSpecProcedure: string;

	/**
	 * .
	 */
	resultSpecDrug: string;

	/**
	 * .
	 */
	resultSpecInvestigation: string;

	/**
	 * .
	 */
	resultSpecProsthesis: string;

	/**
	 * .
	 */
	hospitalClass: string;

	/**
	 * .
	 */
	tariffType: string;

	/**
	 * .
	 */
	totalTariff: number;

	/**
	 * .
	 */
	visitDate: Date;

	/**
	 * .
	 */
	specProcedureTariff: number;

	/**
	 * .
	 */
	specDrugTariff: number;

	/**
	 * .
	 */
	specInvestigationTariff: number;

	/**
	 * .
	 */
	specProsthesisTariff: number;

	/**
	 * .
	 */
	upgradeFlag: boolean = false;

	/**
	 * .
	 */
	hcuFlag: boolean = false;

	/**
	 * .
	 */
	grouperFlag: boolean = false;

	/**
	 * .
	 */
	nonSurgeryProcedure: number;

	/**
	 * .
	 */
	surgeryProcedure: number;

	/**
	 * .
	 */
	consultation: number;

	/**
	 * .
	 */
	specialist: number;

	/**
	 * .
	 */
	nursing: number;

	/**
	 * .
	 */
	diagnostic: number;

	/**
	 * .
	 */
	radiology: number;

	/**
	 * .
	 */
	laboratory: number;

	/**
	 * .
	 */
	bloodService: number;

	/**
	 * .
	 */
	rehabilitation: number;

	/**
	 * .
	 */
	bedAccomodation: number;

	/**
	 * .
	 */
	intensiveCare: number;

	/**
	 * .
	 */
	drugs: number;

	/**
	 * .
	 */
	medicalEquipment: number;

	/**
	 * .
	 */
	dispensedDisposable: number;

	/**
	 * .
	 */
	equipmentRental: number;

	/**
	 * .
	 */
	icd10Code: string;

	/**
	 * .
	 */
	icd10Desc: string;

	/**
	 * .
	 */
	icd10Tariff: number;

	/**
	 * .
	 */
	icd9cmCode: string;

	/**
	 * .
	 */
	icd9cmDesc: string;

	/**
	 * .
	 */
	icd9cmTariff: number;

	/**
	 * .
	 */
	chronicDrugs: number;

	/**
	 * .
	 */
	chemotherapyDrugs: number;

	/**
	 * .
	 */
	classUpgrade: string;

	/**
	 * .
	 */
	highCareUnit: string;

	/**
	 * Claim data is sent to INACBG server.
	 */
	inacbgClaimCreated: boolean = false;

	/**
	 * .
	 */
	inacbgResponse: string;

	/**
	 * Total Invoice, take from Invoice Summary.
	 */
	totalInvoice: number;



	modelPropGroups: { [s: string]: Group } = BpjsINACBGClaimModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
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
					// % protected region % [Add other validators for Patient ID here] off begin
					// % protected region % [Add other validators for Patient ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient ID here] off begin
				// % protected region % [Add any additional model attribute properties for Patient ID here] end
			},
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
				name: 'bpjsCardNo',
				// % protected region % [Set displayName for BPJS Card No here] off begin
				displayName: 'BPJS Card No',
				// % protected region % [Set displayName for BPJS Card No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BPJS Card No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BPJS Card No here] end
				// % protected region % [Set isSensitive for BPJS Card No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BPJS Card No here] end
				// % protected region % [Set readonly for BPJS Card No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BPJS Card No here] end
				validators: [
					// % protected region % [Add other validators for BPJS Card No here] off begin
					// % protected region % [Add other validators for BPJS Card No here] end
				],
				// % protected region % [Add any additional model attribute properties for BPJS Card No here] off begin
				// % protected region % [Add any additional model attribute properties for BPJS Card No here] end
			},
			{
				name: 'sepNo',
				// % protected region % [Set displayName for SEP No here] off begin
				displayName: 'SEP No',
				// % protected region % [Set displayName for SEP No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SEP No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SEP No here] end
				// % protected region % [Set isSensitive for SEP No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SEP No here] end
				// % protected region % [Set readonly for SEP No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SEP No here] end
				validators: [
					// % protected region % [Add other validators for SEP No here] off begin
					// % protected region % [Add other validators for SEP No here] end
				],
				// % protected region % [Add any additional model attribute properties for SEP No here] off begin
				// % protected region % [Add any additional model attribute properties for SEP No here] end
			},
			{
				name: 'treatmentType',
				// % protected region % [Set displayName for Treatment Type here] off begin
				displayName: 'Treatment Type',
				// % protected region % [Set displayName for Treatment Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Treatment Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Treatment Type here] end
				// % protected region % [Set isSensitive for Treatment Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Treatment Type here] end
				// % protected region % [Set readonly for Treatment Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Treatment Type here] end
				validators: [
					// % protected region % [Add other validators for Treatment Type here] off begin
					// % protected region % [Add other validators for Treatment Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Treatment Type here] off begin
				// % protected region % [Add any additional model attribute properties for Treatment Type here] end
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
				name: 'dismissalDate',
				// % protected region % [Set displayName for Dismissal Date here] off begin
				displayName: 'Dismissal Date',
				// % protected region % [Set displayName for Dismissal Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Dismissal Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Dismissal Date here] end
				// % protected region % [Set isSensitive for Dismissal Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dismissal Date here] end
				// % protected region % [Set readonly for Dismissal Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dismissal Date here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Date here] off begin
					// % protected region % [Add other validators for Dismissal Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Dismissal Date here] off begin
				// % protected region % [Add any additional model attribute properties for Dismissal Date here] end
			},
			{
				name: 'los',
				// % protected region % [Set displayName for LOS here] off begin
				displayName: 'LOS',
				// % protected region % [Set displayName for LOS here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for LOS here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for LOS here] end
				// % protected region % [Set isSensitive for LOS here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for LOS here] end
				// % protected region % [Set readonly for LOS here] off begin
				readOnly: false,
				// % protected region % [Set readonly for LOS here] end
				validators: [
					// % protected region % [Add other validators for LOS here] off begin
					// % protected region % [Add other validators for LOS here] end
				],
				// % protected region % [Add any additional model attribute properties for LOS here] off begin
				// % protected region % [Add any additional model attribute properties for LOS here] end
			},
			{
				name: 'dismissal',
				// % protected region % [Set displayName for Dismissal here] off begin
				displayName: 'Dismissal',
				// % protected region % [Set displayName for Dismissal here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dismissal here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dismissal here] end
				// % protected region % [Set isSensitive for Dismissal here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dismissal here] end
				// % protected region % [Set readonly for Dismissal here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dismissal here] end
				validators: [
					// % protected region % [Add other validators for Dismissal here] off begin
					// % protected region % [Add other validators for Dismissal here] end
				],
				// % protected region % [Add any additional model attribute properties for Dismissal here] off begin
				// % protected region % [Add any additional model attribute properties for Dismissal here] end
			},
			{
				name: 'responsibleDoctor',
				// % protected region % [Set displayName for Responsible Doctor here] off begin
				displayName: 'Responsible Doctor',
				// % protected region % [Set displayName for Responsible Doctor here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Responsible Doctor here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Responsible Doctor here] end
				// % protected region % [Set isSensitive for Responsible Doctor here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Responsible Doctor here] end
				// % protected region % [Set readonly for Responsible Doctor here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Responsible Doctor here] end
				validators: [
					// % protected region % [Add other validators for Responsible Doctor here] off begin
					// % protected region % [Add other validators for Responsible Doctor here] end
				],
				// % protected region % [Add any additional model attribute properties for Responsible Doctor here] off begin
				// % protected region % [Add any additional model attribute properties for Responsible Doctor here] end
			},
			{
				name: 'weight',
				// % protected region % [Set displayName for Weight here] off begin
				displayName: 'Weight',
				// % protected region % [Set displayName for Weight here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Weight here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Weight here] end
				// % protected region % [Set isSensitive for Weight here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight here] end
				// % protected region % [Set readonly for Weight here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight here] end
				validators: [
					// % protected region % [Add other validators for Weight here] off begin
					// % protected region % [Add other validators for Weight here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight here] off begin
				// % protected region % [Add any additional model attribute properties for Weight here] end
			},
			{
				name: 'adl',
				// % protected region % [Set displayName for ADL here] off begin
				displayName: 'ADL',
				// % protected region % [Set displayName for ADL here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for ADL here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for ADL here] end
				// % protected region % [Set isSensitive for ADL here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ADL here] end
				// % protected region % [Set readonly for ADL here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ADL here] end
				validators: [
					// % protected region % [Add other validators for ADL here] off begin
					// % protected region % [Add other validators for ADL here] end
				],
				// % protected region % [Add any additional model attribute properties for ADL here] off begin
				// % protected region % [Add any additional model attribute properties for ADL here] end
			},
			{
				name: 'claimStatus',
				// % protected region % [Set displayName for Claim Status here] off begin
				displayName: 'Claim Status',
				// % protected region % [Set displayName for Claim Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Claim Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Claim Status here] end
				// % protected region % [Set isSensitive for Claim Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Claim Status here] end
				// % protected region % [Set readonly for Claim Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Claim Status here] end
				validators: [
					// % protected region % [Add other validators for Claim Status here] off begin
					// % protected region % [Add other validators for Claim Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Claim Status here] off begin
				// % protected region % [Add any additional model attribute properties for Claim Status here] end
			},
			{
				name: 'sepStatus',
				// % protected region % [Set displayName for SEP Status here] off begin
				displayName: 'SEP Status',
				// % protected region % [Set displayName for SEP Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SEP Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SEP Status here] end
				// % protected region % [Set isSensitive for SEP Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SEP Status here] end
				// % protected region % [Set readonly for SEP Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SEP Status here] end
				validators: [
					// % protected region % [Add other validators for SEP Status here] off begin
					// % protected region % [Add other validators for SEP Status here] end
				],
				// % protected region % [Add any additional model attribute properties for SEP Status here] off begin
				// % protected region % [Add any additional model attribute properties for SEP Status here] end
			},
			{
				name: 'hospitalTariff',
				// % protected region % [Set displayName for Hospital Tariff here] off begin
				displayName: 'Hospital Tariff',
				// % protected region % [Set displayName for Hospital Tariff here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Hospital Tariff here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Hospital Tariff here] end
				// % protected region % [Set isSensitive for Hospital Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Tariff here] end
				// % protected region % [Set readonly for Hospital Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Tariff here] end
				validators: [
					// % protected region % [Add other validators for Hospital Tariff here] off begin
					// % protected region % [Add other validators for Hospital Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Tariff here] end
			},
			{
				name: 'referralLetter',
				// % protected region % [Set displayName for Referral Letter here] off begin
				displayName: 'Referral Letter',
				// % protected region % [Set displayName for Referral Letter here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral Letter here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral Letter here] end
				// % protected region % [Set isSensitive for Referral Letter here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral Letter here] end
				// % protected region % [Set readonly for Referral Letter here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral Letter here] end
				validators: [
					// % protected region % [Add other validators for Referral Letter here] off begin
					// % protected region % [Add other validators for Referral Letter here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral Letter here] off begin
				// % protected region % [Add any additional model attribute properties for Referral Letter here] end
			},
			{
				name: 'thirdSelLevel',
				// % protected region % [Set displayName for Third Sel Level here] off begin
				displayName: 'Third Sel Level',
				// % protected region % [Set displayName for Third Sel Level here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Third Sel Level here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Third Sel Level here] end
				// % protected region % [Set isSensitive for Third Sel Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Third Sel Level here] end
				// % protected region % [Set readonly for Third Sel Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Third Sel Level here] end
				validators: [
					// % protected region % [Add other validators for Third Sel Level here] off begin
					// % protected region % [Add other validators for Third Sel Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Third Sel Level here] off begin
				// % protected region % [Add any additional model attribute properties for Third Sel Level here] end
			},
			{
				name: 'staffName',
				// % protected region % [Set displayName for Staff Name here] off begin
				displayName: 'Staff Name',
				// % protected region % [Set displayName for Staff Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Staff Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Staff Name here] end
				// % protected region % [Set isSensitive for Staff Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Staff Name here] end
				// % protected region % [Set readonly for Staff Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Staff Name here] end
				validators: [
					// % protected region % [Add other validators for Staff Name here] off begin
					// % protected region % [Add other validators for Staff Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Staff Name here] off begin
				// % protected region % [Add any additional model attribute properties for Staff Name here] end
			},
			{
				name: 'dateGrouping',
				// % protected region % [Set displayName for Date Grouping here] off begin
				displayName: 'Date Grouping',
				// % protected region % [Set displayName for Date Grouping here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Date Grouping here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Date Grouping here] end
				// % protected region % [Set isSensitive for Date Grouping here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date Grouping here] end
				// % protected region % [Set readonly for Date Grouping here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date Grouping here] end
				validators: [
					// % protected region % [Add other validators for Date Grouping here] off begin
					// % protected region % [Add other validators for Date Grouping here] end
				],
				// % protected region % [Add any additional model attribute properties for Date Grouping here] off begin
				// % protected region % [Add any additional model attribute properties for Date Grouping here] end
			},
			{
				name: 'inacbgTariff',
				// % protected region % [Set displayName for INACBG Tariff here] off begin
				displayName: 'INACBG Tariff',
				// % protected region % [Set displayName for INACBG Tariff here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for INACBG Tariff here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for INACBG Tariff here] end
				// % protected region % [Set isSensitive for INACBG Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for INACBG Tariff here] end
				// % protected region % [Set readonly for INACBG Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for INACBG Tariff here] end
				validators: [
					// % protected region % [Add other validators for INACBG Tariff here] off begin
					// % protected region % [Add other validators for INACBG Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for INACBG Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for INACBG Tariff here] end
			},
			{
				name: 'description',
				// % protected region % [Set displayName for Description here] off begin
				displayName: 'Description',
				// % protected region % [Set displayName for Description here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Description here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Description here] end
				// % protected region % [Set isSensitive for Description here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Description here] end
				// % protected region % [Set readonly for Description here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Description here] end
				validators: [
					// % protected region % [Add other validators for Description here] off begin
					// % protected region % [Add other validators for Description here] end
				],
				// % protected region % [Add any additional model attribute properties for Description here] off begin
				// % protected region % [Add any additional model attribute properties for Description here] end
			},
			{
				name: 'cbgType',
				// % protected region % [Set displayName for CBG Type here] off begin
				displayName: 'CBG Type',
				// % protected region % [Set displayName for CBG Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for CBG Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for CBG Type here] end
				// % protected region % [Set isSensitive for CBG Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for CBG Type here] end
				// % protected region % [Set readonly for CBG Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for CBG Type here] end
				validators: [
					// % protected region % [Add other validators for CBG Type here] off begin
					// % protected region % [Add other validators for CBG Type here] end
				],
				// % protected region % [Add any additional model attribute properties for CBG Type here] off begin
				// % protected region % [Add any additional model attribute properties for CBG Type here] end
			},
			{
				name: 'tariff',
				// % protected region % [Set displayName for Tariff here] off begin
				displayName: 'Tariff',
				// % protected region % [Set displayName for Tariff here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Tariff here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Tariff here] end
				// % protected region % [Set isSensitive for Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff here] end
				// % protected region % [Set readonly for Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff here] end
				validators: [
					// % protected region % [Add other validators for Tariff here] off begin
					// % protected region % [Add other validators for Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff here] end
			},
			{
				name: 'subAcute',
				// % protected region % [Set displayName for Sub Acute here] off begin
				displayName: 'Sub Acute',
				// % protected region % [Set displayName for Sub Acute here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sub Acute here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sub Acute here] end
				// % protected region % [Set isSensitive for Sub Acute here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sub Acute here] end
				// % protected region % [Set readonly for Sub Acute here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sub Acute here] end
				validators: [
					// % protected region % [Add other validators for Sub Acute here] off begin
					// % protected region % [Add other validators for Sub Acute here] end
				],
				// % protected region % [Add any additional model attribute properties for Sub Acute here] off begin
				// % protected region % [Add any additional model attribute properties for Sub Acute here] end
			},
			{
				name: 'subAcuteCode',
				// % protected region % [Set displayName for Sub Acute Code here] off begin
				displayName: 'Sub Acute Code',
				// % protected region % [Set displayName for Sub Acute Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sub Acute Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sub Acute Code here] end
				// % protected region % [Set isSensitive for Sub Acute Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sub Acute Code here] end
				// % protected region % [Set readonly for Sub Acute Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sub Acute Code here] end
				validators: [
					// % protected region % [Add other validators for Sub Acute Code here] off begin
					// % protected region % [Add other validators for Sub Acute Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Sub Acute Code here] off begin
				// % protected region % [Add any additional model attribute properties for Sub Acute Code here] end
			},
			{
				name: 'subAcuteTariff',
				// % protected region % [Set displayName for Sub Acute Tariff here] off begin
				displayName: 'Sub Acute Tariff',
				// % protected region % [Set displayName for Sub Acute Tariff here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Sub Acute Tariff here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Sub Acute Tariff here] end
				// % protected region % [Set isSensitive for Sub Acute Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sub Acute Tariff here] end
				// % protected region % [Set readonly for Sub Acute Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sub Acute Tariff here] end
				validators: [
					// % protected region % [Add other validators for Sub Acute Tariff here] off begin
					// % protected region % [Add other validators for Sub Acute Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Sub Acute Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Sub Acute Tariff here] end
			},
			{
				name: 'chronic',
				// % protected region % [Set displayName for Chronic here] off begin
				displayName: 'Chronic',
				// % protected region % [Set displayName for Chronic here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Chronic here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Chronic here] end
				// % protected region % [Set isSensitive for Chronic here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Chronic here] end
				// % protected region % [Set readonly for Chronic here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Chronic here] end
				validators: [
					// % protected region % [Add other validators for Chronic here] off begin
					// % protected region % [Add other validators for Chronic here] end
				],
				// % protected region % [Add any additional model attribute properties for Chronic here] off begin
				// % protected region % [Add any additional model attribute properties for Chronic here] end
			},
			{
				name: 'chronicCode',
				// % protected region % [Set displayName for Chronic Code here] off begin
				displayName: 'Chronic Code',
				// % protected region % [Set displayName for Chronic Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Chronic Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Chronic Code here] end
				// % protected region % [Set isSensitive for Chronic Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Chronic Code here] end
				// % protected region % [Set readonly for Chronic Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Chronic Code here] end
				validators: [
					// % protected region % [Add other validators for Chronic Code here] off begin
					// % protected region % [Add other validators for Chronic Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Chronic Code here] off begin
				// % protected region % [Add any additional model attribute properties for Chronic Code here] end
			},
			{
				name: 'chronicTariff',
				// % protected region % [Set displayName for Chronic Tariff here] off begin
				displayName: 'Chronic Tariff',
				// % protected region % [Set displayName for Chronic Tariff here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Chronic Tariff here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Chronic Tariff here] end
				// % protected region % [Set isSensitive for Chronic Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Chronic Tariff here] end
				// % protected region % [Set readonly for Chronic Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Chronic Tariff here] end
				validators: [
					// % protected region % [Add other validators for Chronic Tariff here] off begin
					// % protected region % [Add other validators for Chronic Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Chronic Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Chronic Tariff here] end
			},
			{
				name: 'resultSpecProcedure',
				// % protected region % [Set displayName for Result Spec Procedure here] off begin
				displayName: 'Result Spec Procedure',
				// % protected region % [Set displayName for Result Spec Procedure here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Result Spec Procedure here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Result Spec Procedure here] end
				// % protected region % [Set isSensitive for Result Spec Procedure here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Result Spec Procedure here] end
				// % protected region % [Set readonly for Result Spec Procedure here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Result Spec Procedure here] end
				validators: [
					// % protected region % [Add other validators for Result Spec Procedure here] off begin
					// % protected region % [Add other validators for Result Spec Procedure here] end
				],
				// % protected region % [Add any additional model attribute properties for Result Spec Procedure here] off begin
				// % protected region % [Add any additional model attribute properties for Result Spec Procedure here] end
			},
			{
				name: 'resultSpecDrug',
				// % protected region % [Set displayName for Result Spec Drug here] off begin
				displayName: 'Result Spec Drug',
				// % protected region % [Set displayName for Result Spec Drug here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Result Spec Drug here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Result Spec Drug here] end
				// % protected region % [Set isSensitive for Result Spec Drug here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Result Spec Drug here] end
				// % protected region % [Set readonly for Result Spec Drug here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Result Spec Drug here] end
				validators: [
					// % protected region % [Add other validators for Result Spec Drug here] off begin
					// % protected region % [Add other validators for Result Spec Drug here] end
				],
				// % protected region % [Add any additional model attribute properties for Result Spec Drug here] off begin
				// % protected region % [Add any additional model attribute properties for Result Spec Drug here] end
			},
			{
				name: 'resultSpecInvestigation',
				// % protected region % [Set displayName for Result Spec Investigation here] off begin
				displayName: 'Result Spec Investigation',
				// % protected region % [Set displayName for Result Spec Investigation here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Result Spec Investigation here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Result Spec Investigation here] end
				// % protected region % [Set isSensitive for Result Spec Investigation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Result Spec Investigation here] end
				// % protected region % [Set readonly for Result Spec Investigation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Result Spec Investigation here] end
				validators: [
					// % protected region % [Add other validators for Result Spec Investigation here] off begin
					// % protected region % [Add other validators for Result Spec Investigation here] end
				],
				// % protected region % [Add any additional model attribute properties for Result Spec Investigation here] off begin
				// % protected region % [Add any additional model attribute properties for Result Spec Investigation here] end
			},
			{
				name: 'resultSpecProsthesis',
				// % protected region % [Set displayName for Result Spec Prosthesis here] off begin
				displayName: 'Result Spec Prosthesis',
				// % protected region % [Set displayName for Result Spec Prosthesis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Result Spec Prosthesis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Result Spec Prosthesis here] end
				// % protected region % [Set isSensitive for Result Spec Prosthesis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Result Spec Prosthesis here] end
				// % protected region % [Set readonly for Result Spec Prosthesis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Result Spec Prosthesis here] end
				validators: [
					// % protected region % [Add other validators for Result Spec Prosthesis here] off begin
					// % protected region % [Add other validators for Result Spec Prosthesis here] end
				],
				// % protected region % [Add any additional model attribute properties for Result Spec Prosthesis here] off begin
				// % protected region % [Add any additional model attribute properties for Result Spec Prosthesis here] end
			},
			{
				name: 'hospitalClass',
				// % protected region % [Set displayName for Hospital Class here] off begin
				displayName: 'Hospital Class',
				// % protected region % [Set displayName for Hospital Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Class here] end
				// % protected region % [Set isSensitive for Hospital Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Class here] end
				// % protected region % [Set readonly for Hospital Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Class here] end
				validators: [
					// % protected region % [Add other validators for Hospital Class here] off begin
					// % protected region % [Add other validators for Hospital Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Class here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Class here] end
			},
			{
				name: 'tariffType',
				// % protected region % [Set displayName for Tariff Type here] off begin
				displayName: 'Tariff Type',
				// % protected region % [Set displayName for Tariff Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tariff Type here] off begin
				elementType: ElementType.INPUT,
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
				name: 'totalTariff',
				// % protected region % [Set displayName for Total Tariff here] off begin
				displayName: 'Total Tariff',
				// % protected region % [Set displayName for Total Tariff here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Tariff here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Tariff here] end
				// % protected region % [Set isSensitive for Total Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Tariff here] end
				// % protected region % [Set readonly for Total Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Tariff here] end
				validators: [
					// % protected region % [Add other validators for Total Tariff here] off begin
					// % protected region % [Add other validators for Total Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Total Tariff here] end
			},
			{
				name: 'visitDate',
				// % protected region % [Set displayName for Visit Date here] off begin
				displayName: 'Visit Date',
				// % protected region % [Set displayName for Visit Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Visit Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Visit Date here] end
				// % protected region % [Set isSensitive for Visit Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visit Date here] end
				// % protected region % [Set readonly for Visit Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visit Date here] end
				validators: [
					// % protected region % [Add other validators for Visit Date here] off begin
					// % protected region % [Add other validators for Visit Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Visit Date here] off begin
				// % protected region % [Add any additional model attribute properties for Visit Date here] end
			},
			{
				name: 'specProcedureTariff',
				// % protected region % [Set displayName for Spec Procedure Tariff here] off begin
				displayName: 'Spec Procedure Tariff',
				// % protected region % [Set displayName for Spec Procedure Tariff here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Spec Procedure Tariff here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Spec Procedure Tariff here] end
				// % protected region % [Set isSensitive for Spec Procedure Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Spec Procedure Tariff here] end
				// % protected region % [Set readonly for Spec Procedure Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Spec Procedure Tariff here] end
				validators: [
					// % protected region % [Add other validators for Spec Procedure Tariff here] off begin
					// % protected region % [Add other validators for Spec Procedure Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Spec Procedure Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Spec Procedure Tariff here] end
			},
			{
				name: 'specDrugTariff',
				// % protected region % [Set displayName for Spec Drug Tariff here] off begin
				displayName: 'Spec Drug Tariff',
				// % protected region % [Set displayName for Spec Drug Tariff here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Spec Drug Tariff here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Spec Drug Tariff here] end
				// % protected region % [Set isSensitive for Spec Drug Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Spec Drug Tariff here] end
				// % protected region % [Set readonly for Spec Drug Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Spec Drug Tariff here] end
				validators: [
					// % protected region % [Add other validators for Spec Drug Tariff here] off begin
					// % protected region % [Add other validators for Spec Drug Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Spec Drug Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Spec Drug Tariff here] end
			},
			{
				name: 'specInvestigationTariff',
				// % protected region % [Set displayName for Spec Investigation Tariff here] off begin
				displayName: 'Spec Investigation Tariff',
				// % protected region % [Set displayName for Spec Investigation Tariff here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Spec Investigation Tariff here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Spec Investigation Tariff here] end
				// % protected region % [Set isSensitive for Spec Investigation Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Spec Investigation Tariff here] end
				// % protected region % [Set readonly for Spec Investigation Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Spec Investigation Tariff here] end
				validators: [
					// % protected region % [Add other validators for Spec Investigation Tariff here] off begin
					// % protected region % [Add other validators for Spec Investigation Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Spec Investigation Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Spec Investigation Tariff here] end
			},
			{
				name: 'specProsthesisTariff',
				// % protected region % [Set displayName for Spec Prosthesis Tariff here] off begin
				displayName: 'Spec Prosthesis Tariff',
				// % protected region % [Set displayName for Spec Prosthesis Tariff here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Spec Prosthesis Tariff here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Spec Prosthesis Tariff here] end
				// % protected region % [Set isSensitive for Spec Prosthesis Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Spec Prosthesis Tariff here] end
				// % protected region % [Set readonly for Spec Prosthesis Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Spec Prosthesis Tariff here] end
				validators: [
					// % protected region % [Add other validators for Spec Prosthesis Tariff here] off begin
					// % protected region % [Add other validators for Spec Prosthesis Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for Spec Prosthesis Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for Spec Prosthesis Tariff here] end
			},
			{
				name: 'upgradeFlag',
				// % protected region % [Set displayName for Upgrade Flag here] off begin
				displayName: 'Upgrade Flag',
				// % protected region % [Set displayName for Upgrade Flag here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Upgrade Flag here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Upgrade Flag here] end
				// % protected region % [Set isSensitive for Upgrade Flag here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Upgrade Flag here] end
				// % protected region % [Set readonly for Upgrade Flag here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Upgrade Flag here] end
				validators: [
					// % protected region % [Add other validators for Upgrade Flag here] off begin
					// % protected region % [Add other validators for Upgrade Flag here] end
				],
				// % protected region % [Add any additional model attribute properties for Upgrade Flag here] off begin
				// % protected region % [Add any additional model attribute properties for Upgrade Flag here] end
			},
			{
				name: 'hcuFlag',
				// % protected region % [Set displayName for HCU Flag here] off begin
				displayName: 'HCU Flag',
				// % protected region % [Set displayName for HCU Flag here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for HCU Flag here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for HCU Flag here] end
				// % protected region % [Set isSensitive for HCU Flag here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for HCU Flag here] end
				// % protected region % [Set readonly for HCU Flag here] off begin
				readOnly: false,
				// % protected region % [Set readonly for HCU Flag here] end
				validators: [
					// % protected region % [Add other validators for HCU Flag here] off begin
					// % protected region % [Add other validators for HCU Flag here] end
				],
				// % protected region % [Add any additional model attribute properties for HCU Flag here] off begin
				// % protected region % [Add any additional model attribute properties for HCU Flag here] end
			},
			{
				name: 'grouperFlag',
				// % protected region % [Set displayName for Grouper Flag here] off begin
				displayName: 'Grouper Flag',
				// % protected region % [Set displayName for Grouper Flag here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Grouper Flag here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Grouper Flag here] end
				// % protected region % [Set isSensitive for Grouper Flag here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Grouper Flag here] end
				// % protected region % [Set readonly for Grouper Flag here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Grouper Flag here] end
				validators: [
					// % protected region % [Add other validators for Grouper Flag here] off begin
					// % protected region % [Add other validators for Grouper Flag here] end
				],
				// % protected region % [Add any additional model attribute properties for Grouper Flag here] off begin
				// % protected region % [Add any additional model attribute properties for Grouper Flag here] end
			},
			{
				name: 'nonSurgeryProcedure',
				// % protected region % [Set displayName for Non Surgery Procedure here] off begin
				displayName: 'Non Surgery Procedure',
				// % protected region % [Set displayName for Non Surgery Procedure here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Non Surgery Procedure here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Non Surgery Procedure here] end
				// % protected region % [Set isSensitive for Non Surgery Procedure here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Non Surgery Procedure here] end
				// % protected region % [Set readonly for Non Surgery Procedure here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Non Surgery Procedure here] end
				validators: [
					// % protected region % [Add other validators for Non Surgery Procedure here] off begin
					// % protected region % [Add other validators for Non Surgery Procedure here] end
				],
				// % protected region % [Add any additional model attribute properties for Non Surgery Procedure here] off begin
				// % protected region % [Add any additional model attribute properties for Non Surgery Procedure here] end
			},
			{
				name: 'surgeryProcedure',
				// % protected region % [Set displayName for Surgery Procedure here] off begin
				displayName: 'Surgery Procedure',
				// % protected region % [Set displayName for Surgery Procedure here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Surgery Procedure here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Surgery Procedure here] end
				// % protected region % [Set isSensitive for Surgery Procedure here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surgery Procedure here] end
				// % protected region % [Set readonly for Surgery Procedure here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surgery Procedure here] end
				validators: [
					// % protected region % [Add other validators for Surgery Procedure here] off begin
					// % protected region % [Add other validators for Surgery Procedure here] end
				],
				// % protected region % [Add any additional model attribute properties for Surgery Procedure here] off begin
				// % protected region % [Add any additional model attribute properties for Surgery Procedure here] end
			},
			{
				name: 'consultation',
				// % protected region % [Set displayName for Consultation here] off begin
				displayName: 'Consultation',
				// % protected region % [Set displayName for Consultation here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Consultation here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Consultation here] end
				// % protected region % [Set isSensitive for Consultation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consultation here] end
				// % protected region % [Set readonly for Consultation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consultation here] end
				validators: [
					// % protected region % [Add other validators for Consultation here] off begin
					// % protected region % [Add other validators for Consultation here] end
				],
				// % protected region % [Add any additional model attribute properties for Consultation here] off begin
				// % protected region % [Add any additional model attribute properties for Consultation here] end
			},
			{
				name: 'specialist',
				// % protected region % [Set displayName for Specialist here] off begin
				displayName: 'Specialist',
				// % protected region % [Set displayName for Specialist here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Specialist here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Specialist here] end
				// % protected region % [Set isSensitive for Specialist here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Specialist here] end
				// % protected region % [Set readonly for Specialist here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Specialist here] end
				validators: [
					// % protected region % [Add other validators for Specialist here] off begin
					// % protected region % [Add other validators for Specialist here] end
				],
				// % protected region % [Add any additional model attribute properties for Specialist here] off begin
				// % protected region % [Add any additional model attribute properties for Specialist here] end
			},
			{
				name: 'nursing',
				// % protected region % [Set displayName for Nursing here] off begin
				displayName: 'Nursing',
				// % protected region % [Set displayName for Nursing here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Nursing here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Nursing here] end
				// % protected region % [Set isSensitive for Nursing here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nursing here] end
				// % protected region % [Set readonly for Nursing here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nursing here] end
				validators: [
					// % protected region % [Add other validators for Nursing here] off begin
					// % protected region % [Add other validators for Nursing here] end
				],
				// % protected region % [Add any additional model attribute properties for Nursing here] off begin
				// % protected region % [Add any additional model attribute properties for Nursing here] end
			},
			{
				name: 'diagnostic',
				// % protected region % [Set displayName for Diagnostic here] off begin
				displayName: 'Diagnostic',
				// % protected region % [Set displayName for Diagnostic here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Diagnostic here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Diagnostic here] end
				// % protected region % [Set isSensitive for Diagnostic here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diagnostic here] end
				// % protected region % [Set readonly for Diagnostic here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diagnostic here] end
				validators: [
					// % protected region % [Add other validators for Diagnostic here] off begin
					// % protected region % [Add other validators for Diagnostic here] end
				],
				// % protected region % [Add any additional model attribute properties for Diagnostic here] off begin
				// % protected region % [Add any additional model attribute properties for Diagnostic here] end
			},
			{
				name: 'radiology',
				// % protected region % [Set displayName for Radiology here] off begin
				displayName: 'Radiology',
				// % protected region % [Set displayName for Radiology here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Radiology here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Radiology here] end
				// % protected region % [Set isSensitive for Radiology here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Radiology here] end
				// % protected region % [Set readonly for Radiology here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Radiology here] end
				validators: [
					// % protected region % [Add other validators for Radiology here] off begin
					// % protected region % [Add other validators for Radiology here] end
				],
				// % protected region % [Add any additional model attribute properties for Radiology here] off begin
				// % protected region % [Add any additional model attribute properties for Radiology here] end
			},
			{
				name: 'laboratory',
				// % protected region % [Set displayName for Laboratory here] off begin
				displayName: 'Laboratory',
				// % protected region % [Set displayName for Laboratory here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Laboratory here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Laboratory here] end
				// % protected region % [Set isSensitive for Laboratory here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Laboratory here] end
				// % protected region % [Set readonly for Laboratory here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Laboratory here] end
				validators: [
					// % protected region % [Add other validators for Laboratory here] off begin
					// % protected region % [Add other validators for Laboratory here] end
				],
				// % protected region % [Add any additional model attribute properties for Laboratory here] off begin
				// % protected region % [Add any additional model attribute properties for Laboratory here] end
			},
			{
				name: 'bloodService',
				// % protected region % [Set displayName for Blood Service here] off begin
				displayName: 'Blood Service',
				// % protected region % [Set displayName for Blood Service here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Blood Service here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Blood Service here] end
				// % protected region % [Set isSensitive for Blood Service here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Blood Service here] end
				// % protected region % [Set readonly for Blood Service here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Blood Service here] end
				validators: [
					// % protected region % [Add other validators for Blood Service here] off begin
					// % protected region % [Add other validators for Blood Service here] end
				],
				// % protected region % [Add any additional model attribute properties for Blood Service here] off begin
				// % protected region % [Add any additional model attribute properties for Blood Service here] end
			},
			{
				name: 'rehabilitation',
				// % protected region % [Set displayName for Rehabilitation here] off begin
				displayName: 'Rehabilitation',
				// % protected region % [Set displayName for Rehabilitation here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Rehabilitation here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Rehabilitation here] end
				// % protected region % [Set isSensitive for Rehabilitation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Rehabilitation here] end
				// % protected region % [Set readonly for Rehabilitation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Rehabilitation here] end
				validators: [
					// % protected region % [Add other validators for Rehabilitation here] off begin
					// % protected region % [Add other validators for Rehabilitation here] end
				],
				// % protected region % [Add any additional model attribute properties for Rehabilitation here] off begin
				// % protected region % [Add any additional model attribute properties for Rehabilitation here] end
			},
			{
				name: 'bedAccomodation',
				// % protected region % [Set displayName for Bed Accomodation here] off begin
				displayName: 'Bed Accomodation',
				// % protected region % [Set displayName for Bed Accomodation here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Bed Accomodation here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Bed Accomodation here] end
				// % protected region % [Set isSensitive for Bed Accomodation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bed Accomodation here] end
				// % protected region % [Set readonly for Bed Accomodation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bed Accomodation here] end
				validators: [
					// % protected region % [Add other validators for Bed Accomodation here] off begin
					// % protected region % [Add other validators for Bed Accomodation here] end
				],
				// % protected region % [Add any additional model attribute properties for Bed Accomodation here] off begin
				// % protected region % [Add any additional model attribute properties for Bed Accomodation here] end
			},
			{
				name: 'intensiveCare',
				// % protected region % [Set displayName for Intensive Care here] off begin
				displayName: 'Intensive Care',
				// % protected region % [Set displayName for Intensive Care here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Intensive Care here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Intensive Care here] end
				// % protected region % [Set isSensitive for Intensive Care here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Intensive Care here] end
				// % protected region % [Set readonly for Intensive Care here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Intensive Care here] end
				validators: [
					// % protected region % [Add other validators for Intensive Care here] off begin
					// % protected region % [Add other validators for Intensive Care here] end
				],
				// % protected region % [Add any additional model attribute properties for Intensive Care here] off begin
				// % protected region % [Add any additional model attribute properties for Intensive Care here] end
			},
			{
				name: 'drugs',
				// % protected region % [Set displayName for Drugs here] off begin
				displayName: 'Drugs',
				// % protected region % [Set displayName for Drugs here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Drugs here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Drugs here] end
				// % protected region % [Set isSensitive for Drugs here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Drugs here] end
				// % protected region % [Set readonly for Drugs here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Drugs here] end
				validators: [
					// % protected region % [Add other validators for Drugs here] off begin
					// % protected region % [Add other validators for Drugs here] end
				],
				// % protected region % [Add any additional model attribute properties for Drugs here] off begin
				// % protected region % [Add any additional model attribute properties for Drugs here] end
			},
			{
				name: 'medicalEquipment',
				// % protected region % [Set displayName for Medical Equipment here] off begin
				displayName: 'Medical Equipment',
				// % protected region % [Set displayName for Medical Equipment here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Medical Equipment here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Medical Equipment here] end
				// % protected region % [Set isSensitive for Medical Equipment here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medical Equipment here] end
				// % protected region % [Set readonly for Medical Equipment here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medical Equipment here] end
				validators: [
					// % protected region % [Add other validators for Medical Equipment here] off begin
					// % protected region % [Add other validators for Medical Equipment here] end
				],
				// % protected region % [Add any additional model attribute properties for Medical Equipment here] off begin
				// % protected region % [Add any additional model attribute properties for Medical Equipment here] end
			},
			{
				name: 'dispensedDisposable',
				// % protected region % [Set displayName for Dispensed Disposable here] off begin
				displayName: 'Dispensed Disposable',
				// % protected region % [Set displayName for Dispensed Disposable here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Dispensed Disposable here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Dispensed Disposable here] end
				// % protected region % [Set isSensitive for Dispensed Disposable here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dispensed Disposable here] end
				// % protected region % [Set readonly for Dispensed Disposable here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dispensed Disposable here] end
				validators: [
					// % protected region % [Add other validators for Dispensed Disposable here] off begin
					// % protected region % [Add other validators for Dispensed Disposable here] end
				],
				// % protected region % [Add any additional model attribute properties for Dispensed Disposable here] off begin
				// % protected region % [Add any additional model attribute properties for Dispensed Disposable here] end
			},
			{
				name: 'equipmentRental',
				// % protected region % [Set displayName for Equipment Rental here] off begin
				displayName: 'Equipment Rental',
				// % protected region % [Set displayName for Equipment Rental here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Equipment Rental here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Equipment Rental here] end
				// % protected region % [Set isSensitive for Equipment Rental here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Equipment Rental here] end
				// % protected region % [Set readonly for Equipment Rental here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Equipment Rental here] end
				validators: [
					// % protected region % [Add other validators for Equipment Rental here] off begin
					// % protected region % [Add other validators for Equipment Rental here] end
				],
				// % protected region % [Add any additional model attribute properties for Equipment Rental here] off begin
				// % protected region % [Add any additional model attribute properties for Equipment Rental here] end
			},
			{
				name: 'icd10Code',
				// % protected region % [Set displayName for ICD10 Code here] off begin
				displayName: 'ICD10 Code',
				// % protected region % [Set displayName for ICD10 Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ICD10 Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ICD10 Code here] end
				// % protected region % [Set isSensitive for ICD10 Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ICD10 Code here] end
				// % protected region % [Set readonly for ICD10 Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ICD10 Code here] end
				validators: [
					// % protected region % [Add other validators for ICD10 Code here] off begin
					// % protected region % [Add other validators for ICD10 Code here] end
				],
				// % protected region % [Add any additional model attribute properties for ICD10 Code here] off begin
				// % protected region % [Add any additional model attribute properties for ICD10 Code here] end
			},
			{
				name: 'icd10Desc',
				// % protected region % [Set displayName for ICD10 Desc here] off begin
				displayName: 'ICD10 Desc',
				// % protected region % [Set displayName for ICD10 Desc here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ICD10 Desc here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ICD10 Desc here] end
				// % protected region % [Set isSensitive for ICD10 Desc here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ICD10 Desc here] end
				// % protected region % [Set readonly for ICD10 Desc here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ICD10 Desc here] end
				validators: [
					// % protected region % [Add other validators for ICD10 Desc here] off begin
					// % protected region % [Add other validators for ICD10 Desc here] end
				],
				// % protected region % [Add any additional model attribute properties for ICD10 Desc here] off begin
				// % protected region % [Add any additional model attribute properties for ICD10 Desc here] end
			},
			{
				name: 'icd10Tariff',
				// % protected region % [Set displayName for ICD10 Tariff here] off begin
				displayName: 'ICD10 Tariff',
				// % protected region % [Set displayName for ICD10 Tariff here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for ICD10 Tariff here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for ICD10 Tariff here] end
				// % protected region % [Set isSensitive for ICD10 Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ICD10 Tariff here] end
				// % protected region % [Set readonly for ICD10 Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ICD10 Tariff here] end
				validators: [
					// % protected region % [Add other validators for ICD10 Tariff here] off begin
					// % protected region % [Add other validators for ICD10 Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for ICD10 Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for ICD10 Tariff here] end
			},
			{
				name: 'icd9cmCode',
				// % protected region % [Set displayName for ICD9CM Code here] off begin
				displayName: 'ICD9CM Code',
				// % protected region % [Set displayName for ICD9CM Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ICD9CM Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ICD9CM Code here] end
				// % protected region % [Set isSensitive for ICD9CM Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ICD9CM Code here] end
				// % protected region % [Set readonly for ICD9CM Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ICD9CM Code here] end
				validators: [
					// % protected region % [Add other validators for ICD9CM Code here] off begin
					// % protected region % [Add other validators for ICD9CM Code here] end
				],
				// % protected region % [Add any additional model attribute properties for ICD9CM Code here] off begin
				// % protected region % [Add any additional model attribute properties for ICD9CM Code here] end
			},
			{
				name: 'icd9cmDesc',
				// % protected region % [Set displayName for ICD9CM Desc here] off begin
				displayName: 'ICD9CM Desc',
				// % protected region % [Set displayName for ICD9CM Desc here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ICD9CM Desc here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ICD9CM Desc here] end
				// % protected region % [Set isSensitive for ICD9CM Desc here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ICD9CM Desc here] end
				// % protected region % [Set readonly for ICD9CM Desc here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ICD9CM Desc here] end
				validators: [
					// % protected region % [Add other validators for ICD9CM Desc here] off begin
					// % protected region % [Add other validators for ICD9CM Desc here] end
				],
				// % protected region % [Add any additional model attribute properties for ICD9CM Desc here] off begin
				// % protected region % [Add any additional model attribute properties for ICD9CM Desc here] end
			},
			{
				name: 'icd9cmTariff',
				// % protected region % [Set displayName for ICD9CM Tariff here] off begin
				displayName: 'ICD9CM Tariff',
				// % protected region % [Set displayName for ICD9CM Tariff here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for ICD9CM Tariff here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for ICD9CM Tariff here] end
				// % protected region % [Set isSensitive for ICD9CM Tariff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ICD9CM Tariff here] end
				// % protected region % [Set readonly for ICD9CM Tariff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ICD9CM Tariff here] end
				validators: [
					// % protected region % [Add other validators for ICD9CM Tariff here] off begin
					// % protected region % [Add other validators for ICD9CM Tariff here] end
				],
				// % protected region % [Add any additional model attribute properties for ICD9CM Tariff here] off begin
				// % protected region % [Add any additional model attribute properties for ICD9CM Tariff here] end
			},
			{
				name: 'chronicDrugs',
				// % protected region % [Set displayName for Chronic Drugs here] off begin
				displayName: 'Chronic Drugs',
				// % protected region % [Set displayName for Chronic Drugs here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Chronic Drugs here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Chronic Drugs here] end
				// % protected region % [Set isSensitive for Chronic Drugs here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Chronic Drugs here] end
				// % protected region % [Set readonly for Chronic Drugs here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Chronic Drugs here] end
				validators: [
					// % protected region % [Add other validators for Chronic Drugs here] off begin
					// % protected region % [Add other validators for Chronic Drugs here] end
				],
				// % protected region % [Add any additional model attribute properties for Chronic Drugs here] off begin
				// % protected region % [Add any additional model attribute properties for Chronic Drugs here] end
			},
			{
				name: 'chemotherapyDrugs',
				// % protected region % [Set displayName for Chemotherapy Drugs here] off begin
				displayName: 'Chemotherapy Drugs',
				// % protected region % [Set displayName for Chemotherapy Drugs here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Chemotherapy Drugs here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Chemotherapy Drugs here] end
				// % protected region % [Set isSensitive for Chemotherapy Drugs here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Chemotherapy Drugs here] end
				// % protected region % [Set readonly for Chemotherapy Drugs here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Chemotherapy Drugs here] end
				validators: [
					// % protected region % [Add other validators for Chemotherapy Drugs here] off begin
					// % protected region % [Add other validators for Chemotherapy Drugs here] end
				],
				// % protected region % [Add any additional model attribute properties for Chemotherapy Drugs here] off begin
				// % protected region % [Add any additional model attribute properties for Chemotherapy Drugs here] end
			},
			{
				name: 'classUpgrade',
				// % protected region % [Set displayName for Class Upgrade here] off begin
				displayName: 'Class Upgrade',
				// % protected region % [Set displayName for Class Upgrade here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Class Upgrade here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Class Upgrade here] end
				// % protected region % [Set isSensitive for Class Upgrade here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Class Upgrade here] end
				// % protected region % [Set readonly for Class Upgrade here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Class Upgrade here] end
				validators: [
					// % protected region % [Add other validators for Class Upgrade here] off begin
					// % protected region % [Add other validators for Class Upgrade here] end
				],
				// % protected region % [Add any additional model attribute properties for Class Upgrade here] off begin
				// % protected region % [Add any additional model attribute properties for Class Upgrade here] end
			},
			{
				name: 'highCareUnit',
				// % protected region % [Set displayName for High Care Unit here] off begin
				displayName: 'High Care Unit',
				// % protected region % [Set displayName for High Care Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for High Care Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for High Care Unit here] end
				// % protected region % [Set isSensitive for High Care Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for High Care Unit here] end
				// % protected region % [Set readonly for High Care Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for High Care Unit here] end
				validators: [
					// % protected region % [Add other validators for High Care Unit here] off begin
					// % protected region % [Add other validators for High Care Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for High Care Unit here] off begin
				// % protected region % [Add any additional model attribute properties for High Care Unit here] end
			},
			{
				name: 'inacbgClaimCreated',
				// % protected region % [Set displayName for Inacbg Claim Created here] off begin
				displayName: 'Inacbg Claim Created',
				// % protected region % [Set displayName for Inacbg Claim Created here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inacbg Claim Created here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inacbg Claim Created here] end
				// % protected region % [Set isSensitive for Inacbg Claim Created here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inacbg Claim Created here] end
				// % protected region % [Set readonly for Inacbg Claim Created here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inacbg Claim Created here] end
				validators: [
					// % protected region % [Add other validators for Inacbg Claim Created here] off begin
					// % protected region % [Add other validators for Inacbg Claim Created here] end
				],
				// % protected region % [Add any additional model attribute properties for Inacbg Claim Created here] off begin
				// % protected region % [Add any additional model attribute properties for Inacbg Claim Created here] end
			},
			{
				name: 'inacbgResponse',
				// % protected region % [Set displayName for Inacbg Response here] off begin
				displayName: 'Inacbg Response',
				// % protected region % [Set displayName for Inacbg Response here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Inacbg Response here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Inacbg Response here] end
				// % protected region % [Set isSensitive for Inacbg Response here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inacbg Response here] end
				// % protected region % [Set readonly for Inacbg Response here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inacbg Response here] end
				validators: [
					// % protected region % [Add other validators for Inacbg Response here] off begin
					// % protected region % [Add other validators for Inacbg Response here] end
				],
				// % protected region % [Add any additional model attribute properties for Inacbg Response here] off begin
				// % protected region % [Add any additional model attribute properties for Inacbg Response here] end
			},
			{
				name: 'totalInvoice',
				// % protected region % [Set displayName for Total Invoice here] off begin
				displayName: 'Total Invoice',
				// % protected region % [Set displayName for Total Invoice here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Invoice here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Invoice here] end
				// % protected region % [Set isSensitive for Total Invoice here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Invoice here] end
				// % protected region % [Set readonly for Total Invoice here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Invoice here] end
				validators: [
					// % protected region % [Add other validators for Total Invoice here] off begin
					// % protected region % [Add other validators for Total Invoice here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Invoice here] off begin
				// % protected region % [Add any additional model attribute properties for Total Invoice here] end
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
				case 'claimNo':
					break;
				case 'patientID':
					break;
				case 'invoiceNumber':
					break;
				case 'bpjsCardNo':
					break;
				case 'sepNo':
					break;
				case 'treatmentType':
					break;
				case 'treatmentClass':
					break;
				case 'admissionDate':
					break;
				case 'dismissalDate':
					break;
				case 'los':
					break;
				case 'dismissal':
					break;
				case 'responsibleDoctor':
					break;
				case 'weight':
					break;
				case 'adl':
					break;
				case 'claimStatus':
					break;
				case 'sepStatus':
					break;
				case 'staffName':
					break;
				case 'dateGrouping':
					break;
				case 'inacbgTariff':
					break;
				case 'description':
					break;
				case 'cbgType':
					break;
				case 'tariff':
					break;
				case 'subAcute':
					break;
				case 'subAcuteCode':
					break;
				case 'chronic':
					break;
				case 'chronicCode':
					break;
				case 'tariffType':
					break;
				case 'visitDate':
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
	static deepParse(data: string | { [K in keyof BpjsINACBGClaimModel]?: BpjsINACBGClaimModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsINACBGClaimModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsINACBGClaimModel = new BpjsINACBGClaimModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsINACBGClaimModel,
	 *    it is expected as a JSON string or as a nullable BpjsINACBGClaimModel.
	 */
	constructor(data?: string | Partial<BpjsINACBGClaimModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsINACBGClaimModel>
				: data;

			this.claimNo = json.claimNo;
			this.patientID = json.patientID;
			this.invoiceNumber = json.invoiceNumber;
			this.bpjsCardNo = json.bpjsCardNo;
			this.sepNo = json.sepNo;
			this.treatmentType = json.treatmentType;
			this.treatmentClass = json.treatmentClass;
			if (json.admissionDate) {
				this.admissionDate = new Date(json.admissionDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.admissionDate = json.admissionDate;
			}
			if (json.dismissalDate) {
				this.dismissalDate = new Date(json.dismissalDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dismissalDate = json.dismissalDate;
			}
			this.los = json.los;
			this.dismissal = json.dismissal;
			this.responsibleDoctor = json.responsibleDoctor;
			this.weight = json.weight;
			this.adl = json.adl;
			this.claimStatus = json.claimStatus;
			this.sepStatus = json.sepStatus;
			this.hospitalTariff = json.hospitalTariff;
			this.referralLetter = json.referralLetter;
			this.thirdSelLevel = json.thirdSelLevel;
			this.staffName = json.staffName;
			if (json.dateGrouping) {
				this.dateGrouping = new Date(json.dateGrouping);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dateGrouping = json.dateGrouping;
			}
			this.inacbgTariff = json.inacbgTariff;
			this.description = json.description;
			this.cbgType = json.cbgType;
			this.tariff = json.tariff;
			this.subAcute = json.subAcute;
			this.subAcuteCode = json.subAcuteCode;
			this.subAcuteTariff = json.subAcuteTariff;
			this.chronic = json.chronic;
			this.chronicCode = json.chronicCode;
			this.chronicTariff = json.chronicTariff;
			this.resultSpecProcedure = json.resultSpecProcedure;
			this.resultSpecDrug = json.resultSpecDrug;
			this.resultSpecInvestigation = json.resultSpecInvestigation;
			this.resultSpecProsthesis = json.resultSpecProsthesis;
			this.hospitalClass = json.hospitalClass;
			this.tariffType = json.tariffType;
			this.totalTariff = json.totalTariff;
			if (json.visitDate) {
				this.visitDate = new Date(json.visitDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.visitDate = json.visitDate;
			}
			this.specProcedureTariff = json.specProcedureTariff;
			this.specDrugTariff = json.specDrugTariff;
			this.specInvestigationTariff = json.specInvestigationTariff;
			this.specProsthesisTariff = json.specProsthesisTariff;
			this.upgradeFlag = json.upgradeFlag;
			this.hcuFlag = json.hcuFlag;
			this.grouperFlag = json.grouperFlag;
			this.nonSurgeryProcedure = json.nonSurgeryProcedure;
			this.surgeryProcedure = json.surgeryProcedure;
			this.consultation = json.consultation;
			this.specialist = json.specialist;
			this.nursing = json.nursing;
			this.diagnostic = json.diagnostic;
			this.radiology = json.radiology;
			this.laboratory = json.laboratory;
			this.bloodService = json.bloodService;
			this.rehabilitation = json.rehabilitation;
			this.bedAccomodation = json.bedAccomodation;
			this.intensiveCare = json.intensiveCare;
			this.drugs = json.drugs;
			this.medicalEquipment = json.medicalEquipment;
			this.dispensedDisposable = json.dispensedDisposable;
			this.equipmentRental = json.equipmentRental;
			this.icd10Code = json.icd10Code;
			this.icd10Desc = json.icd10Desc;
			this.icd10Tariff = json.icd10Tariff;
			this.icd9cmCode = json.icd9cmCode;
			this.icd9cmDesc = json.icd9cmDesc;
			this.icd9cmTariff = json.icd9cmTariff;
			this.chronicDrugs = json.chronicDrugs;
			this.chemotherapyDrugs = json.chemotherapyDrugs;
			this.classUpgrade = json.classUpgrade;
			this.highCareUnit = json.highCareUnit;
			this.inacbgClaimCreated = json.inacbgClaimCreated;
			this.inacbgResponse = json.inacbgResponse;
			this.totalInvoice = json.totalInvoice;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			claimNo: this.claimNo,
			patientID: this.patientID,
			invoiceNumber: this.invoiceNumber,
			bpjsCardNo: this.bpjsCardNo,
			sepNo: this.sepNo,
			treatmentType: this.treatmentType,
			treatmentClass: this.treatmentClass,
			admissionDate: this.admissionDate,
			dismissalDate: this.dismissalDate,
			los: this.los,
			dismissal: this.dismissal,
			responsibleDoctor: this.responsibleDoctor,
			weight: this.weight,
			adl: this.adl,
			claimStatus: this.claimStatus,
			sepStatus: this.sepStatus,
			hospitalTariff: this.hospitalTariff,
			referralLetter: this.referralLetter,
			thirdSelLevel: this.thirdSelLevel,
			staffName: this.staffName,
			dateGrouping: this.dateGrouping,
			inacbgTariff: this.inacbgTariff,
			description: this.description,
			cbgType: this.cbgType,
			tariff: this.tariff,
			subAcute: this.subAcute,
			subAcuteCode: this.subAcuteCode,
			subAcuteTariff: this.subAcuteTariff,
			chronic: this.chronic,
			chronicCode: this.chronicCode,
			chronicTariff: this.chronicTariff,
			resultSpecProcedure: this.resultSpecProcedure,
			resultSpecDrug: this.resultSpecDrug,
			resultSpecInvestigation: this.resultSpecInvestigation,
			resultSpecProsthesis: this.resultSpecProsthesis,
			hospitalClass: this.hospitalClass,
			tariffType: this.tariffType,
			totalTariff: this.totalTariff,
			visitDate: this.visitDate,
			specProcedureTariff: this.specProcedureTariff,
			specDrugTariff: this.specDrugTariff,
			specInvestigationTariff: this.specInvestigationTariff,
			specProsthesisTariff: this.specProsthesisTariff,
			upgradeFlag: this.upgradeFlag,
			hcuFlag: this.hcuFlag,
			grouperFlag: this.grouperFlag,
			nonSurgeryProcedure: this.nonSurgeryProcedure,
			surgeryProcedure: this.surgeryProcedure,
			consultation: this.consultation,
			specialist: this.specialist,
			nursing: this.nursing,
			diagnostic: this.diagnostic,
			radiology: this.radiology,
			laboratory: this.laboratory,
			bloodService: this.bloodService,
			rehabilitation: this.rehabilitation,
			bedAccomodation: this.bedAccomodation,
			intensiveCare: this.intensiveCare,
			drugs: this.drugs,
			medicalEquipment: this.medicalEquipment,
			dispensedDisposable: this.dispensedDisposable,
			equipmentRental: this.equipmentRental,
			icd10Code: this.icd10Code,
			icd10Desc: this.icd10Desc,
			icd10Tariff: this.icd10Tariff,
			icd9cmCode: this.icd9cmCode,
			icd9cmDesc: this.icd9cmDesc,
			icd9cmTariff: this.icd9cmTariff,
			chronicDrugs: this.chronicDrugs,
			chemotherapyDrugs: this.chemotherapyDrugs,
			classUpgrade: this.classUpgrade,
			highCareUnit: this.highCareUnit,
			inacbgClaimCreated: this.inacbgClaimCreated,
			inacbgResponse: this.inacbgResponse,
			totalInvoice: this.totalInvoice,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsINACBGClaimModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsINACBGClaimModel {
		let newModelJson = this.toJSON();

		if (updates.claimNo) {
			newModelJson.claimNo = updates.claimNo;
		}

		if (updates.patientID) {
			newModelJson.patientID = updates.patientID;
		}

		if (updates.invoiceNumber) {
			newModelJson.invoiceNumber = updates.invoiceNumber;
		}

		if (updates.bpjsCardNo) {
			newModelJson.bpjsCardNo = updates.bpjsCardNo;
		}

		if (updates.sepNo) {
			newModelJson.sepNo = updates.sepNo;
		}

		if (updates.treatmentType) {
			newModelJson.treatmentType = updates.treatmentType;
		}

		if (updates.treatmentClass) {
			newModelJson.treatmentClass = updates.treatmentClass;
		}

		if (updates.admissionDate) {
			newModelJson.admissionDate = updates.admissionDate;
		}

		if (updates.dismissalDate) {
			newModelJson.dismissalDate = updates.dismissalDate;
		}

		if (updates.los) {
			newModelJson.los = updates.los;
		}

		if (updates.dismissal) {
			newModelJson.dismissal = updates.dismissal;
		}

		if (updates.responsibleDoctor) {
			newModelJson.responsibleDoctor = updates.responsibleDoctor;
		}

		if (updates.weight) {
			newModelJson.weight = updates.weight;
		}

		if (updates.adl) {
			newModelJson.adl = updates.adl;
		}

		if (updates.claimStatus) {
			newModelJson.claimStatus = updates.claimStatus;
		}

		if (updates.sepStatus) {
			newModelJson.sepStatus = updates.sepStatus;
		}

		if (updates.hospitalTariff) {
			newModelJson.hospitalTariff = updates.hospitalTariff;
		}

		if (updates.referralLetter) {
			newModelJson.referralLetter = updates.referralLetter;
		}

		if (updates.thirdSelLevel) {
			newModelJson.thirdSelLevel = updates.thirdSelLevel;
		}

		if (updates.staffName) {
			newModelJson.staffName = updates.staffName;
		}

		if (updates.dateGrouping) {
			newModelJson.dateGrouping = updates.dateGrouping;
		}

		if (updates.inacbgTariff) {
			newModelJson.inacbgTariff = updates.inacbgTariff;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.cbgType) {
			newModelJson.cbgType = updates.cbgType;
		}

		if (updates.tariff) {
			newModelJson.tariff = updates.tariff;
		}

		if (updates.subAcute) {
			newModelJson.subAcute = updates.subAcute;
		}

		if (updates.subAcuteCode) {
			newModelJson.subAcuteCode = updates.subAcuteCode;
		}

		if (updates.subAcuteTariff) {
			newModelJson.subAcuteTariff = updates.subAcuteTariff;
		}

		if (updates.chronic) {
			newModelJson.chronic = updates.chronic;
		}

		if (updates.chronicCode) {
			newModelJson.chronicCode = updates.chronicCode;
		}

		if (updates.chronicTariff) {
			newModelJson.chronicTariff = updates.chronicTariff;
		}

		if (updates.resultSpecProcedure) {
			newModelJson.resultSpecProcedure = updates.resultSpecProcedure;
		}

		if (updates.resultSpecDrug) {
			newModelJson.resultSpecDrug = updates.resultSpecDrug;
		}

		if (updates.resultSpecInvestigation) {
			newModelJson.resultSpecInvestigation = updates.resultSpecInvestigation;
		}

		if (updates.resultSpecProsthesis) {
			newModelJson.resultSpecProsthesis = updates.resultSpecProsthesis;
		}

		if (updates.hospitalClass) {
			newModelJson.hospitalClass = updates.hospitalClass;
		}

		if (updates.tariffType) {
			newModelJson.tariffType = updates.tariffType;
		}

		if (updates.totalTariff) {
			newModelJson.totalTariff = updates.totalTariff;
		}

		if (updates.visitDate) {
			newModelJson.visitDate = updates.visitDate;
		}

		if (updates.specProcedureTariff) {
			newModelJson.specProcedureTariff = updates.specProcedureTariff;
		}

		if (updates.specDrugTariff) {
			newModelJson.specDrugTariff = updates.specDrugTariff;
		}

		if (updates.specInvestigationTariff) {
			newModelJson.specInvestigationTariff = updates.specInvestigationTariff;
		}

		if (updates.specProsthesisTariff) {
			newModelJson.specProsthesisTariff = updates.specProsthesisTariff;
		}

		if (updates.upgradeFlag) {
			newModelJson.upgradeFlag = updates.upgradeFlag;
		}

		if (updates.hcuFlag) {
			newModelJson.hcuFlag = updates.hcuFlag;
		}

		if (updates.grouperFlag) {
			newModelJson.grouperFlag = updates.grouperFlag;
		}

		if (updates.nonSurgeryProcedure) {
			newModelJson.nonSurgeryProcedure = updates.nonSurgeryProcedure;
		}

		if (updates.surgeryProcedure) {
			newModelJson.surgeryProcedure = updates.surgeryProcedure;
		}

		if (updates.consultation) {
			newModelJson.consultation = updates.consultation;
		}

		if (updates.specialist) {
			newModelJson.specialist = updates.specialist;
		}

		if (updates.nursing) {
			newModelJson.nursing = updates.nursing;
		}

		if (updates.diagnostic) {
			newModelJson.diagnostic = updates.diagnostic;
		}

		if (updates.radiology) {
			newModelJson.radiology = updates.radiology;
		}

		if (updates.laboratory) {
			newModelJson.laboratory = updates.laboratory;
		}

		if (updates.bloodService) {
			newModelJson.bloodService = updates.bloodService;
		}

		if (updates.rehabilitation) {
			newModelJson.rehabilitation = updates.rehabilitation;
		}

		if (updates.bedAccomodation) {
			newModelJson.bedAccomodation = updates.bedAccomodation;
		}

		if (updates.intensiveCare) {
			newModelJson.intensiveCare = updates.intensiveCare;
		}

		if (updates.drugs) {
			newModelJson.drugs = updates.drugs;
		}

		if (updates.medicalEquipment) {
			newModelJson.medicalEquipment = updates.medicalEquipment;
		}

		if (updates.dispensedDisposable) {
			newModelJson.dispensedDisposable = updates.dispensedDisposable;
		}

		if (updates.equipmentRental) {
			newModelJson.equipmentRental = updates.equipmentRental;
		}

		if (updates.icd10Code) {
			newModelJson.icd10Code = updates.icd10Code;
		}

		if (updates.icd10Desc) {
			newModelJson.icd10Desc = updates.icd10Desc;
		}

		if (updates.icd10Tariff) {
			newModelJson.icd10Tariff = updates.icd10Tariff;
		}

		if (updates.icd9cmCode) {
			newModelJson.icd9cmCode = updates.icd9cmCode;
		}

		if (updates.icd9cmDesc) {
			newModelJson.icd9cmDesc = updates.icd9cmDesc;
		}

		if (updates.icd9cmTariff) {
			newModelJson.icd9cmTariff = updates.icd9cmTariff;
		}

		if (updates.chronicDrugs) {
			newModelJson.chronicDrugs = updates.chronicDrugs;
		}

		if (updates.chemotherapyDrugs) {
			newModelJson.chemotherapyDrugs = updates.chemotherapyDrugs;
		}

		if (updates.classUpgrade) {
			newModelJson.classUpgrade = updates.classUpgrade;
		}

		if (updates.highCareUnit) {
			newModelJson.highCareUnit = updates.highCareUnit;
		}

		if (updates.inacbgClaimCreated) {
			newModelJson.inacbgClaimCreated = updates.inacbgClaimCreated;
		}

		if (updates.inacbgResponse) {
			newModelJson.inacbgResponse = updates.inacbgResponse;
		}

		if (updates.totalInvoice) {
			newModelJson.totalInvoice = updates.totalInvoice;
		}

		return new BpjsINACBGClaimModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsINACBGClaimModel)) {
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
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
