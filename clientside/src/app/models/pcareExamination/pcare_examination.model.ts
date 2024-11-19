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
import {PcareActionExaminationModel} from '../pcareActionExamination/pcare_action_examination.model';
import {PcareCompoundDrugModel} from '../pcareCompoundDrug/pcare_compound_drug.model';
import {PcareNonCompoundDrugModel} from '../pcareNonCompoundDrug/pcare_noncompound_drug.model';
import {RegistrationModel} from '../registration/registration.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class PcareExaminationModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'tglpulang',
		'nokunjungan',
		'jsoninsert',
		'jsonupdate',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'visitType',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PcareExaminationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PcareExaminationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Visit Type - Jenis Kunjungan.
	 */
	visitType: string;

	/**
	 * Treatment - Perawatan.
	 */
	treatment: string;

	/**
	 * Destination Polyclinic - Poli Tujuan.
	 */
	destinationPolyclinic: string;

	/**
	 * Disease - Keluhan.
	 */
	disease: string;

	/**
	 * Diagnosis - Diagnosa.
	 */
	diagnosis: string;

	/**
	 * .
	 */
	diagnosis2: string;

	/**
	 * .
	 */
	diagnosis3: string;

	/**
	 * Therapy - Terapi.
	 */
	therapy: string;

	/**
	 * Consciouness - Kesadaran.
	 */
	consciousness: string;

	/**
	 * Discharge Status - Status Pulang.
	 */
	dischargeStatus: string;

	/**
	 * Internal Referral Polyclinic - Poli Rujuk Internal.
	 */
	internalReferralPolyclinic: string;

	/**
	 * Referring Date - Tanggal Rujuk .
	 */
	referringDate: Date;

	/**
	 * PKK - PPK.
	 */
	pkk: string;

	/**
	 * Sub Specialist - Sub Spesialis.
	 */
	subSpecialist: string;

	/**
	 * Facility - Sarana.
	 */
	facility: string;

	/**
	 * .
	 */
	tacc: string;

	/**
	 * .
	 */
	taccReason: string;

	/**
	 * Special - Khusus.
	 */
	special: string;

	/**
	 * Height - Tinggii Badan.
	 */
	height: number;

	/**
	 * Weight - Berat Badan.
	 */
	weight: number;

	/**
	 * Waist Circumference - Lingkar Perut.
	 */
	waistCircumference: number;

	/**
	 * .
	 */
	bmi: number;

	/**
	 * .
	 */
	systole: number;

	/**
	 * .
	 */
	diastole: number;

	/**
	 * .
	 */
	respiratoryRate: number;

	/**
	 * .
	 */
	heartRate: number;

	/**
	 * Medical Staff - Staf Medis.
	 */
	medicalStaff: string;

	/**
	 * Tanggal Pulang.
	 */
	tglpulang: string;

	/**
	 * Kode Sub Spesialis 1.
	 */
	kdsubspesialis1: string;

	/**
	 * Rujuk Lanjut.
	 */
	rujuklanjut: string;

	/**
	 * Catatan.
	 */
	catatan: string;

	/**
	 * No Kunjungan.
	 */
	nokunjungan: string;

	/**
	 * Json Request Insert.
	 */
	jsoninsert: string;

	/**
	 * Json Request Update.
	 */
	jsonupdate: string;

	registrationId: string;

	registration: RegistrationModel;

	pcareActionExaminationsIds: string[] = [];

	pcareActionExaminations: PcareActionExaminationModel[];

	pcareCompoundDrugsIds: string[] = [];

	pcareCompoundDrugs: PcareCompoundDrugModel[];

	pcareNonCompoundDrugsIds: string[] = [];

	pcareNonCompoundDrugs: PcareNonCompoundDrugModel[];

	modelPropGroups: { [s: string]: Group } = PcareExaminationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'visitType',
				// % protected region % [Set displayName for Visit Type here] off begin
				displayName: 'Visit Type',
				// % protected region % [Set displayName for Visit Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Visit Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Visit Type here] end
				// % protected region % [Set isSensitive for Visit Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visit Type here] end
				// % protected region % [Set readonly for Visit Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visit Type here] end
				validators: [
					// % protected region % [Add other validators for Visit Type here] off begin
					// % protected region % [Add other validators for Visit Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Visit Type here] off begin
				// % protected region % [Add any additional model attribute properties for Visit Type here] end
			},
			{
				name: 'treatment',
				// % protected region % [Set displayName for Treatment here] off begin
				displayName: 'Treatment',
				// % protected region % [Set displayName for Treatment here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Treatment here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Treatment here] end
				// % protected region % [Set isSensitive for Treatment here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Treatment here] end
				// % protected region % [Set readonly for Treatment here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Treatment here] end
				validators: [
					// % protected region % [Add other validators for Treatment here] off begin
					// % protected region % [Add other validators for Treatment here] end
				],
				// % protected region % [Add any additional model attribute properties for Treatment here] off begin
				// % protected region % [Add any additional model attribute properties for Treatment here] end
			},
			{
				name: 'destinationPolyclinic',
				// % protected region % [Set displayName for Destination Polyclinic here] off begin
				displayName: 'Destination Polyclinic',
				// % protected region % [Set displayName for Destination Polyclinic here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Destination Polyclinic here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Destination Polyclinic here] end
				// % protected region % [Set isSensitive for Destination Polyclinic here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Destination Polyclinic here] end
				// % protected region % [Set readonly for Destination Polyclinic here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Destination Polyclinic here] end
				validators: [
					// % protected region % [Add other validators for Destination Polyclinic here] off begin
					// % protected region % [Add other validators for Destination Polyclinic here] end
				],
				// % protected region % [Add any additional model attribute properties for Destination Polyclinic here] off begin
				// % protected region % [Add any additional model attribute properties for Destination Polyclinic here] end
			},
			{
				name: 'disease',
				// % protected region % [Set displayName for Disease here] off begin
				displayName: 'Disease',
				// % protected region % [Set displayName for Disease here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Disease here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Disease here] end
				// % protected region % [Set isSensitive for Disease here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Disease here] end
				// % protected region % [Set readonly for Disease here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Disease here] end
				validators: [
					// % protected region % [Add other validators for Disease here] off begin
					// % protected region % [Add other validators for Disease here] end
				],
				// % protected region % [Add any additional model attribute properties for Disease here] off begin
				// % protected region % [Add any additional model attribute properties for Disease here] end
			},
			{
				name: 'diagnosis',
				// % protected region % [Set displayName for Diagnosis here] off begin
				displayName: 'Diagnosis',
				// % protected region % [Set displayName for Diagnosis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Diagnosis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Diagnosis here] end
				// % protected region % [Set isSensitive for Diagnosis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diagnosis here] end
				// % protected region % [Set readonly for Diagnosis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diagnosis here] end
				validators: [
					// % protected region % [Add other validators for Diagnosis here] off begin
					// % protected region % [Add other validators for Diagnosis here] end
				],
				// % protected region % [Add any additional model attribute properties for Diagnosis here] off begin
				// % protected region % [Add any additional model attribute properties for Diagnosis here] end
			},
			{
				name: 'diagnosis2',
				// % protected region % [Set displayName for Diagnosis 2 here] off begin
				displayName: 'Diagnosis 2',
				// % protected region % [Set displayName for Diagnosis 2 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Diagnosis 2 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Diagnosis 2 here] end
				// % protected region % [Set isSensitive for Diagnosis 2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diagnosis 2 here] end
				// % protected region % [Set readonly for Diagnosis 2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diagnosis 2 here] end
				validators: [
					// % protected region % [Add other validators for Diagnosis 2 here] off begin
					// % protected region % [Add other validators for Diagnosis 2 here] end
				],
				// % protected region % [Add any additional model attribute properties for Diagnosis 2 here] off begin
				// % protected region % [Add any additional model attribute properties for Diagnosis 2 here] end
			},
			{
				name: 'diagnosis3',
				// % protected region % [Set displayName for Diagnosis 3 here] off begin
				displayName: 'Diagnosis 3',
				// % protected region % [Set displayName for Diagnosis 3 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Diagnosis 3 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Diagnosis 3 here] end
				// % protected region % [Set isSensitive for Diagnosis 3 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diagnosis 3 here] end
				// % protected region % [Set readonly for Diagnosis 3 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diagnosis 3 here] end
				validators: [
					// % protected region % [Add other validators for Diagnosis 3 here] off begin
					// % protected region % [Add other validators for Diagnosis 3 here] end
				],
				// % protected region % [Add any additional model attribute properties for Diagnosis 3 here] off begin
				// % protected region % [Add any additional model attribute properties for Diagnosis 3 here] end
			},
			{
				name: 'therapy',
				// % protected region % [Set displayName for Therapy here] off begin
				displayName: 'Therapy',
				// % protected region % [Set displayName for Therapy here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Therapy here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Therapy here] end
				// % protected region % [Set isSensitive for Therapy here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Therapy here] end
				// % protected region % [Set readonly for Therapy here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Therapy here] end
				validators: [
					// % protected region % [Add other validators for Therapy here] off begin
					// % protected region % [Add other validators for Therapy here] end
				],
				// % protected region % [Add any additional model attribute properties for Therapy here] off begin
				// % protected region % [Add any additional model attribute properties for Therapy here] end
			},
			{
				name: 'consciousness',
				// % protected region % [Set displayName for Consciousness here] off begin
				displayName: 'Consciousness',
				// % protected region % [Set displayName for Consciousness here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consciousness here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Consciousness here] end
				// % protected region % [Set isSensitive for Consciousness here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consciousness here] end
				// % protected region % [Set readonly for Consciousness here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consciousness here] end
				validators: [
					// % protected region % [Add other validators for Consciousness here] off begin
					// % protected region % [Add other validators for Consciousness here] end
				],
				// % protected region % [Add any additional model attribute properties for Consciousness here] off begin
				// % protected region % [Add any additional model attribute properties for Consciousness here] end
			},
			{
				name: 'dischargeStatus',
				// % protected region % [Set displayName for Discharge Status here] off begin
				displayName: 'Discharge Status',
				// % protected region % [Set displayName for Discharge Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Discharge Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Discharge Status here] end
				// % protected region % [Set isSensitive for Discharge Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Discharge Status here] end
				// % protected region % [Set readonly for Discharge Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Discharge Status here] end
				validators: [
					// % protected region % [Add other validators for Discharge Status here] off begin
					// % protected region % [Add other validators for Discharge Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Discharge Status here] off begin
				// % protected region % [Add any additional model attribute properties for Discharge Status here] end
			},
			{
				name: 'internalReferralPolyclinic',
				// % protected region % [Set displayName for Internal Referral Polyclinic here] off begin
				displayName: 'Internal Referral Polyclinic',
				// % protected region % [Set displayName for Internal Referral Polyclinic here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Internal Referral Polyclinic here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Internal Referral Polyclinic here] end
				// % protected region % [Set isSensitive for Internal Referral Polyclinic here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Internal Referral Polyclinic here] end
				// % protected region % [Set readonly for Internal Referral Polyclinic here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Internal Referral Polyclinic here] end
				validators: [
					// % protected region % [Add other validators for Internal Referral Polyclinic here] off begin
					// % protected region % [Add other validators for Internal Referral Polyclinic here] end
				],
				// % protected region % [Add any additional model attribute properties for Internal Referral Polyclinic here] off begin
				// % protected region % [Add any additional model attribute properties for Internal Referral Polyclinic here] end
			},
			{
				name: 'referringDate',
				// % protected region % [Set displayName for Referring Date here] off begin
				displayName: 'Referring Date',
				// % protected region % [Set displayName for Referring Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Referring Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Referring Date here] end
				// % protected region % [Set isSensitive for Referring Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referring Date here] end
				// % protected region % [Set readonly for Referring Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referring Date here] end
				validators: [
					// % protected region % [Add other validators for Referring Date here] off begin
					// % protected region % [Add other validators for Referring Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Referring Date here] off begin
				// % protected region % [Add any additional model attribute properties for Referring Date here] end
			},
			{
				name: 'pkk',
				// % protected region % [Set displayName for PKK here] off begin
				displayName: 'PKK',
				// % protected region % [Set displayName for PKK here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for PKK here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for PKK here] end
				// % protected region % [Set isSensitive for PKK here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for PKK here] end
				// % protected region % [Set readonly for PKK here] off begin
				readOnly: false,
				// % protected region % [Set readonly for PKK here] end
				validators: [
					// % protected region % [Add other validators for PKK here] off begin
					// % protected region % [Add other validators for PKK here] end
				],
				// % protected region % [Add any additional model attribute properties for PKK here] off begin
				// % protected region % [Add any additional model attribute properties for PKK here] end
			},
			{
				name: 'subSpecialist',
				// % protected region % [Set displayName for Sub Specialist here] off begin
				displayName: 'Sub Specialist',
				// % protected region % [Set displayName for Sub Specialist here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sub Specialist here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sub Specialist here] end
				// % protected region % [Set isSensitive for Sub Specialist here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sub Specialist here] end
				// % protected region % [Set readonly for Sub Specialist here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sub Specialist here] end
				validators: [
					// % protected region % [Add other validators for Sub Specialist here] off begin
					// % protected region % [Add other validators for Sub Specialist here] end
				],
				// % protected region % [Add any additional model attribute properties for Sub Specialist here] off begin
				// % protected region % [Add any additional model attribute properties for Sub Specialist here] end
			},
			{
				name: 'facility',
				// % protected region % [Set displayName for Facility here] off begin
				displayName: 'Facility',
				// % protected region % [Set displayName for Facility here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Facility here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Facility here] end
				// % protected region % [Set isSensitive for Facility here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Facility here] end
				// % protected region % [Set readonly for Facility here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Facility here] end
				validators: [
					// % protected region % [Add other validators for Facility here] off begin
					// % protected region % [Add other validators for Facility here] end
				],
				// % protected region % [Add any additional model attribute properties for Facility here] off begin
				// % protected region % [Add any additional model attribute properties for Facility here] end
			},
			{
				name: 'tacc',
				// % protected region % [Set displayName for TACC here] off begin
				displayName: 'TACC',
				// % protected region % [Set displayName for TACC here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for TACC here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for TACC here] end
				// % protected region % [Set isSensitive for TACC here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for TACC here] end
				// % protected region % [Set readonly for TACC here] off begin
				readOnly: false,
				// % protected region % [Set readonly for TACC here] end
				validators: [
					// % protected region % [Add other validators for TACC here] off begin
					// % protected region % [Add other validators for TACC here] end
				],
				// % protected region % [Add any additional model attribute properties for TACC here] off begin
				// % protected region % [Add any additional model attribute properties for TACC here] end
			},
			{
				name: 'taccReason',
				// % protected region % [Set displayName for TACC Reason here] off begin
				displayName: 'TACC Reason',
				// % protected region % [Set displayName for TACC Reason here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for TACC Reason here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for TACC Reason here] end
				// % protected region % [Set isSensitive for TACC Reason here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for TACC Reason here] end
				// % protected region % [Set readonly for TACC Reason here] off begin
				readOnly: false,
				// % protected region % [Set readonly for TACC Reason here] end
				validators: [
					// % protected region % [Add other validators for TACC Reason here] off begin
					// % protected region % [Add other validators for TACC Reason here] end
				],
				// % protected region % [Add any additional model attribute properties for TACC Reason here] off begin
				// % protected region % [Add any additional model attribute properties for TACC Reason here] end
			},
			{
				name: 'special',
				// % protected region % [Set displayName for Special here] off begin
				displayName: 'Special',
				// % protected region % [Set displayName for Special here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Special here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Special here] end
				// % protected region % [Set isSensitive for Special here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Special here] end
				// % protected region % [Set readonly for Special here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Special here] end
				validators: [
					// % protected region % [Add other validators for Special here] off begin
					// % protected region % [Add other validators for Special here] end
				],
				// % protected region % [Add any additional model attribute properties for Special here] off begin
				// % protected region % [Add any additional model attribute properties for Special here] end
			},
			{
				name: 'height',
				// % protected region % [Set displayName for Height here] off begin
				displayName: 'Height',
				// % protected region % [Set displayName for Height here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Height here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Height here] end
				// % protected region % [Set isSensitive for Height here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Height here] end
				// % protected region % [Set readonly for Height here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Height here] end
				validators: [
					// % protected region % [Add other validators for Height here] off begin
					// % protected region % [Add other validators for Height here] end
				],
				// % protected region % [Add any additional model attribute properties for Height here] off begin
				// % protected region % [Add any additional model attribute properties for Height here] end
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
				name: 'waistCircumference',
				// % protected region % [Set displayName for Waist Circumference here] off begin
				displayName: 'Waist Circumference',
				// % protected region % [Set displayName for Waist Circumference here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Waist Circumference here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Waist Circumference here] end
				// % protected region % [Set isSensitive for Waist Circumference here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Waist Circumference here] end
				// % protected region % [Set readonly for Waist Circumference here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Waist Circumference here] end
				validators: [
					// % protected region % [Add other validators for Waist Circumference here] off begin
					// % protected region % [Add other validators for Waist Circumference here] end
				],
				// % protected region % [Add any additional model attribute properties for Waist Circumference here] off begin
				// % protected region % [Add any additional model attribute properties for Waist Circumference here] end
			},
			{
				name: 'bmi',
				// % protected region % [Set displayName for BMI here] off begin
				displayName: 'BMI',
				// % protected region % [Set displayName for BMI here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for BMI here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for BMI here] end
				// % protected region % [Set isSensitive for BMI here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BMI here] end
				// % protected region % [Set readonly for BMI here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BMI here] end
				validators: [
					// % protected region % [Add other validators for BMI here] off begin
					// % protected region % [Add other validators for BMI here] end
				],
				// % protected region % [Add any additional model attribute properties for BMI here] off begin
				// % protected region % [Add any additional model attribute properties for BMI here] end
			},
			{
				name: 'systole',
				// % protected region % [Set displayName for Systole here] off begin
				displayName: 'Systole',
				// % protected region % [Set displayName for Systole here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Systole here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Systole here] end
				// % protected region % [Set isSensitive for Systole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Systole here] end
				// % protected region % [Set readonly for Systole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Systole here] end
				validators: [
					// % protected region % [Add other validators for Systole here] off begin
					// % protected region % [Add other validators for Systole here] end
				],
				// % protected region % [Add any additional model attribute properties for Systole here] off begin
				// % protected region % [Add any additional model attribute properties for Systole here] end
			},
			{
				name: 'diastole',
				// % protected region % [Set displayName for Diastole here] off begin
				displayName: 'Diastole',
				// % protected region % [Set displayName for Diastole here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Diastole here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Diastole here] end
				// % protected region % [Set isSensitive for Diastole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diastole here] end
				// % protected region % [Set readonly for Diastole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diastole here] end
				validators: [
					// % protected region % [Add other validators for Diastole here] off begin
					// % protected region % [Add other validators for Diastole here] end
				],
				// % protected region % [Add any additional model attribute properties for Diastole here] off begin
				// % protected region % [Add any additional model attribute properties for Diastole here] end
			},
			{
				name: 'respiratoryRate',
				// % protected region % [Set displayName for Respiratory Rate here] off begin
				displayName: 'Respiratory Rate',
				// % protected region % [Set displayName for Respiratory Rate here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Respiratory Rate here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Respiratory Rate here] end
				// % protected region % [Set isSensitive for Respiratory Rate here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Respiratory Rate here] end
				// % protected region % [Set readonly for Respiratory Rate here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Respiratory Rate here] end
				validators: [
					// % protected region % [Add other validators for Respiratory Rate here] off begin
					// % protected region % [Add other validators for Respiratory Rate here] end
				],
				// % protected region % [Add any additional model attribute properties for Respiratory Rate here] off begin
				// % protected region % [Add any additional model attribute properties for Respiratory Rate here] end
			},
			{
				name: 'heartRate',
				// % protected region % [Set displayName for Heart Rate here] off begin
				displayName: 'Heart Rate',
				// % protected region % [Set displayName for Heart Rate here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Heart Rate here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Heart Rate here] end
				// % protected region % [Set isSensitive for Heart Rate here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Heart Rate here] end
				// % protected region % [Set readonly for Heart Rate here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Heart Rate here] end
				validators: [
					// % protected region % [Add other validators for Heart Rate here] off begin
					// % protected region % [Add other validators for Heart Rate here] end
				],
				// % protected region % [Add any additional model attribute properties for Heart Rate here] off begin
				// % protected region % [Add any additional model attribute properties for Heart Rate here] end
			},
			{
				name: 'medicalStaff',
				// % protected region % [Set displayName for Medical Staff here] off begin
				displayName: 'Medical Staff',
				// % protected region % [Set displayName for Medical Staff here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Medical Staff here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Medical Staff here] end
				// % protected region % [Set isSensitive for Medical Staff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medical Staff here] end
				// % protected region % [Set readonly for Medical Staff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medical Staff here] end
				validators: [
					// % protected region % [Add other validators for Medical Staff here] off begin
					// % protected region % [Add other validators for Medical Staff here] end
				],
				// % protected region % [Add any additional model attribute properties for Medical Staff here] off begin
				// % protected region % [Add any additional model attribute properties for Medical Staff here] end
			},
			{
				name: 'tglpulang',
				// % protected region % [Set displayName for tglPulang here] off begin
				displayName: 'tglPulang',
				// % protected region % [Set displayName for tglPulang here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglPulang here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglPulang here] end
				// % protected region % [Set isSensitive for tglPulang here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglPulang here] end
				// % protected region % [Set readonly for tglPulang here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglPulang here] end
				validators: [
					// % protected region % [Add other validators for tglPulang here] off begin
					// % protected region % [Add other validators for tglPulang here] end
				],
				// % protected region % [Add any additional model attribute properties for tglPulang here] off begin
				// % protected region % [Add any additional model attribute properties for tglPulang here] end
			},
			{
				name: 'kdsubspesialis1',
				// % protected region % [Set displayName for kdSubSpesialis1 here] off begin
				displayName: 'kdSubSpesialis1',
				// % protected region % [Set displayName for kdSubSpesialis1 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdSubSpesialis1 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdSubSpesialis1 here] end
				// % protected region % [Set isSensitive for kdSubSpesialis1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdSubSpesialis1 here] end
				// % protected region % [Set readonly for kdSubSpesialis1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdSubSpesialis1 here] end
				validators: [
					// % protected region % [Add other validators for kdSubSpesialis1 here] off begin
					// % protected region % [Add other validators for kdSubSpesialis1 here] end
				],
				// % protected region % [Add any additional model attribute properties for kdSubSpesialis1 here] off begin
				// % protected region % [Add any additional model attribute properties for kdSubSpesialis1 here] end
			},
			{
				name: 'rujuklanjut',
				// % protected region % [Set displayName for rujukLanjut here] off begin
				displayName: 'rujukLanjut',
				// % protected region % [Set displayName for rujukLanjut here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for rujukLanjut here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for rujukLanjut here] end
				// % protected region % [Set isSensitive for rujukLanjut here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for rujukLanjut here] end
				// % protected region % [Set readonly for rujukLanjut here] off begin
				readOnly: false,
				// % protected region % [Set readonly for rujukLanjut here] end
				validators: [
					// % protected region % [Add other validators for rujukLanjut here] off begin
					// % protected region % [Add other validators for rujukLanjut here] end
				],
				// % protected region % [Add any additional model attribute properties for rujukLanjut here] off begin
				// % protected region % [Add any additional model attribute properties for rujukLanjut here] end
			},
			{
				name: 'catatan',
				// % protected region % [Set displayName for catatan here] off begin
				displayName: 'catatan',
				// % protected region % [Set displayName for catatan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for catatan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for catatan here] end
				// % protected region % [Set isSensitive for catatan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for catatan here] end
				// % protected region % [Set readonly for catatan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for catatan here] end
				validators: [
					Validators.maxLength(1000),
					// % protected region % [Add other validators for catatan here] off begin
					// % protected region % [Add other validators for catatan here] end
				],
				// % protected region % [Add any additional model attribute properties for catatan here] off begin
				// % protected region % [Add any additional model attribute properties for catatan here] end
			},
			{
				name: 'nokunjungan',
				// % protected region % [Set displayName for noKunjungan here] off begin
				displayName: 'noKunjungan',
				// % protected region % [Set displayName for noKunjungan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noKunjungan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noKunjungan here] end
				// % protected region % [Set isSensitive for noKunjungan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noKunjungan here] end
				// % protected region % [Set readonly for noKunjungan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noKunjungan here] end
				validators: [
					// % protected region % [Add other validators for noKunjungan here] off begin
					// % protected region % [Add other validators for noKunjungan here] end
				],
				// % protected region % [Add any additional model attribute properties for noKunjungan here] off begin
				// % protected region % [Add any additional model attribute properties for noKunjungan here] end
			},
			{
				name: 'jsoninsert',
				// % protected region % [Set displayName for JsonInsert here] off begin
				displayName: 'JsonInsert',
				// % protected region % [Set displayName for JsonInsert here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for JsonInsert here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for JsonInsert here] end
				// % protected region % [Set isSensitive for JsonInsert here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for JsonInsert here] end
				// % protected region % [Set readonly for JsonInsert here] off begin
				readOnly: false,
				// % protected region % [Set readonly for JsonInsert here] end
				validators: [
					Validators.maxLength(5000),
					// % protected region % [Add other validators for JsonInsert here] off begin
					// % protected region % [Add other validators for JsonInsert here] end
				],
				// % protected region % [Add any additional model attribute properties for JsonInsert here] off begin
				// % protected region % [Add any additional model attribute properties for JsonInsert here] end
			},
			{
				name: 'jsonupdate',
				// % protected region % [Set displayName for JsonUpdate here] off begin
				displayName: 'JsonUpdate',
				// % protected region % [Set displayName for JsonUpdate here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for JsonUpdate here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for JsonUpdate here] end
				// % protected region % [Set isSensitive for JsonUpdate here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for JsonUpdate here] end
				// % protected region % [Set readonly for JsonUpdate here] off begin
				readOnly: false,
				// % protected region % [Set readonly for JsonUpdate here] end
				validators: [
					Validators.maxLength(5000),
					// % protected region % [Add other validators for JsonUpdate here] off begin
					// % protected region % [Add other validators for JsonUpdate here] end
				],
				// % protected region % [Add any additional model attribute properties for JsonUpdate here] off begin
				// % protected region % [Add any additional model attribute properties for JsonUpdate here] end
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
				id: 'pcareActionExaminations',
				type: ModelRelationType.MANY,
				name: 'pcareActionExaminationsIds',
				// % protected region % [Customise your 1-1 or 1-M label for PCare Action Examinations here] off begin
				label: 'PCare Action Examinations',
				// % protected region % [Customise your 1-1 or 1-M label for PCare Action Examinations here] end
				entityName: 'PcareActionExaminationModel',
				// % protected region % [Customise your display name for PCare Action Examinations here] off begin
				displayName: 'actionCode',
				// % protected region % [Customise your display name for PCare Action Examinations here] end
				validators: [
					// % protected region % [Add other validators for PCare Action Examinations here] off begin
					// % protected region % [Add other validators for PCare Action Examinations here] end
				],
				// % protected region % [Add any additional field for relation PCare Action Examinations here] off begin
				// % protected region % [Add any additional field for relation PCare Action Examinations here] end
			},
			{
				id: 'pcareCompoundDrugs',
				type: ModelRelationType.MANY,
				name: 'pcareCompoundDrugsIds',
				// % protected region % [Customise your 1-1 or 1-M label for PCare Compound Drugs here] off begin
				label: 'PCare Compound Drugs',
				// % protected region % [Customise your 1-1 or 1-M label for PCare Compound Drugs here] end
				entityName: 'PcareCompoundDrugModel',
				// % protected region % [Customise your display name for PCare Compound Drugs here] off begin
				displayName: 'compoundName',
				// % protected region % [Customise your display name for PCare Compound Drugs here] end
				validators: [
					// % protected region % [Add other validators for PCare Compound Drugs here] off begin
					// % protected region % [Add other validators for PCare Compound Drugs here] end
				],
				// % protected region % [Add any additional field for relation PCare Compound Drugs here] off begin
				// % protected region % [Add any additional field for relation PCare Compound Drugs here] end
			},
			{
				id: 'pcareNonCompoundDrugs',
				type: ModelRelationType.MANY,
				name: 'pcareNonCompoundDrugsIds',
				// % protected region % [Customise your 1-1 or 1-M label for PCare NonCompound Drugs here] off begin
				label: 'PCare NonCompound Drugs',
				// % protected region % [Customise your 1-1 or 1-M label for PCare NonCompound Drugs here] end
				entityName: 'PcareNonCompoundDrugModel',
				// % protected region % [Customise your display name for PCare NonCompound Drugs here] off begin
				displayName: 'drugCode',
				// % protected region % [Customise your display name for PCare NonCompound Drugs here] end
				validators: [
					// % protected region % [Add other validators for PCare NonCompound Drugs here] off begin
					// % protected region % [Add other validators for PCare NonCompound Drugs here] end
				],
				// % protected region % [Add any additional field for relation PCare NonCompound Drugs here] off begin
				// % protected region % [Add any additional field for relation PCare NonCompound Drugs here] end
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
				case 'tglpulang':
					break;
				case 'nokunjungan':
					break;
				case 'jsoninsert':
					break;
				case 'jsonupdate':
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
	static deepParse(data: string | { [K in keyof PcareExaminationModel]?: PcareExaminationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PcareExaminationModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}

		// Outgoing one to many
		if (json.pcareActionExaminations) {
			currentModel.pcareActionExaminationsIds = json.pcareActionExaminations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.pcareActionExaminations.map(model => PcareActionExaminationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.pcareCompoundDrugs) {
			currentModel.pcareCompoundDrugsIds = json.pcareCompoundDrugs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.pcareCompoundDrugs.map(model => PcareCompoundDrugModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.pcareNonCompoundDrugs) {
			currentModel.pcareNonCompoundDrugsIds = json.pcareNonCompoundDrugs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.pcareNonCompoundDrugs.map(model => PcareNonCompoundDrugModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let pcareExaminationModel = new PcareExaminationModel(data);`
	 *
	 * @param data The input data to be initialised as the PcareExaminationModel,
	 *    it is expected as a JSON string or as a nullable PcareExaminationModel.
	 */
	constructor(data?: string | Partial<PcareExaminationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PcareExaminationModel>
				: data;

			this.visitType = json.visitType;
			this.treatment = json.treatment;
			this.destinationPolyclinic = json.destinationPolyclinic;
			this.disease = json.disease;
			this.diagnosis = json.diagnosis;
			this.diagnosis2 = json.diagnosis2;
			this.diagnosis3 = json.diagnosis3;
			this.therapy = json.therapy;
			this.consciousness = json.consciousness;
			this.dischargeStatus = json.dischargeStatus;
			this.internalReferralPolyclinic = json.internalReferralPolyclinic;
			if (json.referringDate) {
				this.referringDate = new Date(json.referringDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.referringDate = json.referringDate;
			}
			this.pkk = json.pkk;
			this.subSpecialist = json.subSpecialist;
			this.facility = json.facility;
			this.tacc = json.tacc;
			this.taccReason = json.taccReason;
			this.special = json.special;
			this.height = json.height;
			this.weight = json.weight;
			this.waistCircumference = json.waistCircumference;
			this.bmi = json.bmi;
			this.systole = json.systole;
			this.diastole = json.diastole;
			this.respiratoryRate = json.respiratoryRate;
			this.heartRate = json.heartRate;
			this.medicalStaff = json.medicalStaff;
			this.tglpulang = json.tglpulang;
			this.kdsubspesialis1 = json.kdsubspesialis1;
			this.rujuklanjut = json.rujuklanjut;
			this.catatan = json.catatan;
			this.nokunjungan = json.nokunjungan;
			this.jsoninsert = json.jsoninsert;
			this.jsonupdate = json.jsonupdate;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			this.pcareActionExaminationsIds = json.pcareActionExaminationsIds;
			this.pcareActionExaminations = json.pcareActionExaminations;
			this.pcareCompoundDrugsIds = json.pcareCompoundDrugsIds;
			this.pcareCompoundDrugs = json.pcareCompoundDrugs;
			this.pcareNonCompoundDrugsIds = json.pcareNonCompoundDrugsIds;
			this.pcareNonCompoundDrugs = json.pcareNonCompoundDrugs;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			visitType: this.visitType,
			treatment: this.treatment,
			destinationPolyclinic: this.destinationPolyclinic,
			disease: this.disease,
			diagnosis: this.diagnosis,
			diagnosis2: this.diagnosis2,
			diagnosis3: this.diagnosis3,
			therapy: this.therapy,
			consciousness: this.consciousness,
			dischargeStatus: this.dischargeStatus,
			internalReferralPolyclinic: this.internalReferralPolyclinic,
			referringDate: this.referringDate,
			pkk: this.pkk,
			subSpecialist: this.subSpecialist,
			facility: this.facility,
			tacc: this.tacc,
			taccReason: this.taccReason,
			special: this.special,
			height: this.height,
			weight: this.weight,
			waistCircumference: this.waistCircumference,
			bmi: this.bmi,
			systole: this.systole,
			diastole: this.diastole,
			respiratoryRate: this.respiratoryRate,
			heartRate: this.heartRate,
			medicalStaff: this.medicalStaff,
			tglpulang: this.tglpulang,
			kdsubspesialis1: this.kdsubspesialis1,
			rujuklanjut: this.rujuklanjut,
			catatan: this.catatan,
			nokunjungan: this.nokunjungan,
			jsoninsert: this.jsoninsert,
			jsonupdate: this.jsonupdate,
			registrationId: this.registrationId,
			pcareActionExaminationsIds: this.pcareActionExaminationsIds,
			pcareCompoundDrugsIds: this.pcareCompoundDrugsIds,
			pcareNonCompoundDrugsIds: this.pcareNonCompoundDrugsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PcareExaminationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PcareExaminationModel {
		let newModelJson = this.toJSON();

		if (updates.visitType) {
			newModelJson.visitType = updates.visitType;
		}

		if (updates.treatment) {
			newModelJson.treatment = updates.treatment;
		}

		if (updates.destinationPolyclinic) {
			newModelJson.destinationPolyclinic = updates.destinationPolyclinic;
		}

		if (updates.disease) {
			newModelJson.disease = updates.disease;
		}

		if (updates.diagnosis) {
			newModelJson.diagnosis = updates.diagnosis;
		}

		if (updates.diagnosis2) {
			newModelJson.diagnosis2 = updates.diagnosis2;
		}

		if (updates.diagnosis3) {
			newModelJson.diagnosis3 = updates.diagnosis3;
		}

		if (updates.therapy) {
			newModelJson.therapy = updates.therapy;
		}

		if (updates.consciousness) {
			newModelJson.consciousness = updates.consciousness;
		}

		if (updates.dischargeStatus) {
			newModelJson.dischargeStatus = updates.dischargeStatus;
		}

		if (updates.internalReferralPolyclinic) {
			newModelJson.internalReferralPolyclinic = updates.internalReferralPolyclinic;
		}

		if (updates.referringDate) {
			newModelJson.referringDate = updates.referringDate;
		}

		if (updates.pkk) {
			newModelJson.pkk = updates.pkk;
		}

		if (updates.subSpecialist) {
			newModelJson.subSpecialist = updates.subSpecialist;
		}

		if (updates.facility) {
			newModelJson.facility = updates.facility;
		}

		if (updates.tacc) {
			newModelJson.tacc = updates.tacc;
		}

		if (updates.taccReason) {
			newModelJson.taccReason = updates.taccReason;
		}

		if (updates.special) {
			newModelJson.special = updates.special;
		}

		if (updates.height) {
			newModelJson.height = updates.height;
		}

		if (updates.weight) {
			newModelJson.weight = updates.weight;
		}

		if (updates.waistCircumference) {
			newModelJson.waistCircumference = updates.waistCircumference;
		}

		if (updates.bmi) {
			newModelJson.bmi = updates.bmi;
		}

		if (updates.systole) {
			newModelJson.systole = updates.systole;
		}

		if (updates.diastole) {
			newModelJson.diastole = updates.diastole;
		}

		if (updates.respiratoryRate) {
			newModelJson.respiratoryRate = updates.respiratoryRate;
		}

		if (updates.heartRate) {
			newModelJson.heartRate = updates.heartRate;
		}

		if (updates.medicalStaff) {
			newModelJson.medicalStaff = updates.medicalStaff;
		}

		if (updates.tglpulang) {
			newModelJson.tglpulang = updates.tglpulang;
		}

		if (updates.kdsubspesialis1) {
			newModelJson.kdsubspesialis1 = updates.kdsubspesialis1;
		}

		if (updates.rujuklanjut) {
			newModelJson.rujuklanjut = updates.rujuklanjut;
		}

		if (updates.catatan) {
			newModelJson.catatan = updates.catatan;
		}

		if (updates.nokunjungan) {
			newModelJson.nokunjungan = updates.nokunjungan;
		}

		if (updates.jsoninsert) {
			newModelJson.jsoninsert = updates.jsoninsert;
		}

		if (updates.jsonupdate) {
			newModelJson.jsonupdate = updates.jsonupdate;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.pcareActionExaminationsIds) {
			newModelJson.pcareActionExaminationsIds = updates.pcareActionExaminationsIds;
		}

		if (updates.pcareCompoundDrugsIds) {
			newModelJson.pcareCompoundDrugsIds = updates.pcareCompoundDrugsIds;
		}

		if (updates.pcareNonCompoundDrugsIds) {
			newModelJson.pcareNonCompoundDrugsIds = updates.pcareNonCompoundDrugsIds;
		}

		return new PcareExaminationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PcareExaminationModel)) {
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
			'pcareActionExaminationsIds',
			'pcareActionExaminations',
			'pcareCompoundDrugsIds',
			'pcareCompoundDrugs',
			'pcareNonCompoundDrugsIds',
			'pcareNonCompoundDrugs',
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

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
