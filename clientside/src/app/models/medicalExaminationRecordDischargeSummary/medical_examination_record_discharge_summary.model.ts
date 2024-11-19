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
import {DiagnosisExaminationRecordModel} from '../diagnosisExaminationRecord/diagnosis_examination_record.model';
import {MedicalExaminationRecordModel} from '../medicalExaminationRecord/medical_examination_record.model';
import {StaffModel} from '../staff/staff.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class MedicalExaminationRecordDischargeSummaryModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'dischargeSummary',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'diastole',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'MedicalExaminationRecordDischargeSummaryModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return MedicalExaminationRecordDischargeSummaryModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Diastole.
	 */
	diastole: number;

	/**
	 * Systole.
	 */
	systole: number;

	/**
	 * Pulse (X/min).
	 */
	pulse: number;

	/**
	 * BP Standing Systole.
	 */
	bpStandingSystole: number;

	/**
	 * BP Standing Diastole.
	 */
	bpStandingDiastole: number;

	/**
	 * Pulse Regularity , get the Code from Reference Data where Type=PULSE_REGULAR. (Max Length: 20).
	 */
	pulseRegularity: string;

	/**
	 * Pulse Strength, get the Code from Reference Data where Type=PULSE_STRENGTH. (Max Length: 20).
	 */
	pulseStrength: string;

	/**
	 * Temperature, with 1 decimal digit.
	 */
	temperature: number;

	/**
	 * Temperature scale, get the Unit Name from Unit Of Measurement entity where Unit Category is Temperature.
	 */
	temperatureScale: string;

	/**
	 * GCS Eyes, get the Code from Reference Data where Type=GCS_EYES. (Max Length: 20).
	 */
	gcsEyes: string;

	/**
	 * GCS Verbal, get the Code from Reference Data where Type=GCS_VERBAL (Max Length: 20).
	 */
	gcsVerbal: string;

	/**
	 * GCS Motor, get the Code from Reference Data where Type=GCS_MOTOR. (Max Length: 20).
	 */
	gcsMotor: string;

	/**
	 * Total GCS Score, with 2 decimal digits.
	 */
	totalGCSScore: number;

	/**
	 * Consciousness, get the Code from Reference Data where Type=CONSCIOUSNESS. (Max Length: 20).
	 */
	consciousness: string;

	/**
	 * Height, with 2 decimal digits.
	 */
	height: number;

	/**
	 * Height Scale, get the Unit Name from Unit Of Measurement entity where Unit Category is Height.
	 */
	heightScale: string;

	/**
	 * Weight, with 2 decimal digits.
	 */
	weight: number;

	/**
	 * Weight Scale, get the Unit Name from Unit Of Measurement entity where Unit Category is Weight.
	 */
	weightScale: string;

	/**
	 * Body Mass Index (BMI), with 2 decimal digits.
	 */
	bmi: number;

	/**
	 * Respiratory (X/min), with 2 decimal digits.
	 */
	respiratory: number;

	/**
	 * Oxygen Saturation (%), with 2 decimal digits.
	 */
	oxygenSaturation: number;

	/**
	 * Waist Circumfecimal digitsrence, with 2 de.
	 */
	waistCircumference: number;

	/**
	 * Waist Circumference Unit, get the Unit Name from Unit Of Measuement entity where Unit Category is Length.
	 */
	waistCircumferenceUnit: string;

	/**
	 * Nutrition Status, get the Code from Reference Data where Type=NUTRI_STATUS. (Max Length: 20).
	 */
	nutritionStatus: string;

	/**
	 * Pain Scale.
	 */
	painScale: number;

	/**
	 * Pain Scale Used, get the Code from Reference Data where Type=PAIN_SCALE_USE. (Max Length: 20).
	 */
	painScaleUsed: string;

	/**
	 * Risk Fall Scale.
	 */
	riskFallScale: number;

	/**
	 * The medical staff's examination result  (Max Length: 5000).
	 */
	objective: string;

	/**
	 * Risk Fall Scale Used, get the Code from Reference Data where Type=FALL_SCALE_USE. (Max Length: 20).
	 */
	riskFallScaleUsed: string;

	/**
	 * The patient's perspective/complaint of their condition (Max Length: 5000).
	 */
	subjective: string;

	/**
	 * The treatment or supporting examination plan for the patient  (Max Length: 5000).
	 */
	plan: string;

	/**
	 * Registration purpose  to service (Max Length: 5000).
	 */
	purpose: string;

	/**
	 * Examination Sub Case, only if the Examination Case is SURGICAL, get the Code from Reference Data where Type=EXAM_SUB_CASE. (Max Length: 20).
	 */
	examinationSubCase: string;

	/**
	 * Accidental Type, get the Code from Reference Data where Type=ACCIDENT_TYPE. (Max Length: 20).
	 */
	accidentalType: string;

	/**
	 * Service Case, get the Code from Reference Data where Type=SERVICE_CASE and the associate to Examination Case value (Max Length: 20).
	 */
	serviceCase: string;

	/**
	 * Accidental Sub Type, get the Code from Reference Data where Type=ACCIDENT_SUBTYPE. (Max Length: 20).
	 */
	accidentalSubType: string;

	/**
	 * .
	 */
	additionalNotes: string;

	/**
	 * .
	 */
	dischargeSummary: string;

	/**
	 * .
	 */
	conditionUponDischarge: string;

	/**
	 * .
	 */
	escortedBy: string;

	/**
	 * .
	 */
	dischargeReason: string;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	dischargingDoctorId: string;

	dischargingDoctor: StaffModel;

	diagnosisExaminationRecordsIds: string[] = [];

	diagnosisExaminationRecords: DiagnosisExaminationRecordModel[];

	modelPropGroups: { [s: string]: Group } = MedicalExaminationRecordDischargeSummaryModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
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
				name: 'pulse',
				// % protected region % [Set displayName for Pulse here] off begin
				displayName: 'Pulse',
				// % protected region % [Set displayName for Pulse here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Pulse here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Pulse here] end
				// % protected region % [Set isSensitive for Pulse here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pulse here] end
				// % protected region % [Set readonly for Pulse here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pulse here] end
				validators: [
					// % protected region % [Add other validators for Pulse here] off begin
					// % protected region % [Add other validators for Pulse here] end
				],
				// % protected region % [Add any additional model attribute properties for Pulse here] off begin
				// % protected region % [Add any additional model attribute properties for Pulse here] end
			},
			{
				name: 'bpStandingSystole',
				// % protected region % [Set displayName for BP Standing Systole here] off begin
				displayName: 'BP Standing Systole',
				// % protected region % [Set displayName for BP Standing Systole here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for BP Standing Systole here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for BP Standing Systole here] end
				// % protected region % [Set isSensitive for BP Standing Systole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BP Standing Systole here] end
				// % protected region % [Set readonly for BP Standing Systole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BP Standing Systole here] end
				validators: [
					// % protected region % [Add other validators for BP Standing Systole here] off begin
					// % protected region % [Add other validators for BP Standing Systole here] end
				],
				// % protected region % [Add any additional model attribute properties for BP Standing Systole here] off begin
				// % protected region % [Add any additional model attribute properties for BP Standing Systole here] end
			},
			{
				name: 'bpStandingDiastole',
				// % protected region % [Set displayName for BP Standing Diastole here] off begin
				displayName: 'BP Standing Diastole',
				// % protected region % [Set displayName for BP Standing Diastole here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for BP Standing Diastole here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for BP Standing Diastole here] end
				// % protected region % [Set isSensitive for BP Standing Diastole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BP Standing Diastole here] end
				// % protected region % [Set readonly for BP Standing Diastole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BP Standing Diastole here] end
				validators: [
					// % protected region % [Add other validators for BP Standing Diastole here] off begin
					// % protected region % [Add other validators for BP Standing Diastole here] end
				],
				// % protected region % [Add any additional model attribute properties for BP Standing Diastole here] off begin
				// % protected region % [Add any additional model attribute properties for BP Standing Diastole here] end
			},
			{
				name: 'pulseRegularity',
				// % protected region % [Set displayName for Pulse Regularity here] off begin
				displayName: 'Pulse Regularity',
				// % protected region % [Set displayName for Pulse Regularity here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pulse Regularity here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pulse Regularity here] end
				// % protected region % [Set isSensitive for Pulse Regularity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pulse Regularity here] end
				// % protected region % [Set readonly for Pulse Regularity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pulse Regularity here] end
				validators: [
					// % protected region % [Add other validators for Pulse Regularity here] off begin
					// % protected region % [Add other validators for Pulse Regularity here] end
				],
				// % protected region % [Add any additional model attribute properties for Pulse Regularity here] off begin
				// % protected region % [Add any additional model attribute properties for Pulse Regularity here] end
			},
			{
				name: 'pulseStrength',
				// % protected region % [Set displayName for Pulse Strength here] off begin
				displayName: 'Pulse Strength',
				// % protected region % [Set displayName for Pulse Strength here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pulse Strength here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pulse Strength here] end
				// % protected region % [Set isSensitive for Pulse Strength here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pulse Strength here] end
				// % protected region % [Set readonly for Pulse Strength here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pulse Strength here] end
				validators: [
					// % protected region % [Add other validators for Pulse Strength here] off begin
					// % protected region % [Add other validators for Pulse Strength here] end
				],
				// % protected region % [Add any additional model attribute properties for Pulse Strength here] off begin
				// % protected region % [Add any additional model attribute properties for Pulse Strength here] end
			},
			{
				name: 'temperature',
				// % protected region % [Set displayName for Temperature here] off begin
				displayName: 'Temperature',
				// % protected region % [Set displayName for Temperature here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Temperature here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Temperature here] end
				// % protected region % [Set isSensitive for Temperature here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Temperature here] end
				// % protected region % [Set readonly for Temperature here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Temperature here] end
				validators: [
					// % protected region % [Add other validators for Temperature here] off begin
					// % protected region % [Add other validators for Temperature here] end
				],
				// % protected region % [Add any additional model attribute properties for Temperature here] off begin
				// % protected region % [Add any additional model attribute properties for Temperature here] end
			},
			{
				name: 'temperatureScale',
				// % protected region % [Set displayName for Temperature scale here] off begin
				displayName: 'Temperature scale',
				// % protected region % [Set displayName for Temperature scale here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Temperature scale here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Temperature scale here] end
				// % protected region % [Set isSensitive for Temperature scale here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Temperature scale here] end
				// % protected region % [Set readonly for Temperature scale here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Temperature scale here] end
				validators: [
					// % protected region % [Add other validators for Temperature scale here] off begin
					// % protected region % [Add other validators for Temperature scale here] end
				],
				// % protected region % [Add any additional model attribute properties for Temperature scale here] off begin
				// % protected region % [Add any additional model attribute properties for Temperature scale here] end
			},
			{
				name: 'gcsEyes',
				// % protected region % [Set displayName for GCS Eyes here] off begin
				displayName: 'GCS Eyes',
				// % protected region % [Set displayName for GCS Eyes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for GCS Eyes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for GCS Eyes here] end
				// % protected region % [Set isSensitive for GCS Eyes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for GCS Eyes here] end
				// % protected region % [Set readonly for GCS Eyes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for GCS Eyes here] end
				validators: [
					// % protected region % [Add other validators for GCS Eyes here] off begin
					// % protected region % [Add other validators for GCS Eyes here] end
				],
				// % protected region % [Add any additional model attribute properties for GCS Eyes here] off begin
				// % protected region % [Add any additional model attribute properties for GCS Eyes here] end
			},
			{
				name: 'gcsVerbal',
				// % protected region % [Set displayName for GCS Verbal here] off begin
				displayName: 'GCS Verbal',
				// % protected region % [Set displayName for GCS Verbal here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for GCS Verbal here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for GCS Verbal here] end
				// % protected region % [Set isSensitive for GCS Verbal here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for GCS Verbal here] end
				// % protected region % [Set readonly for GCS Verbal here] off begin
				readOnly: false,
				// % protected region % [Set readonly for GCS Verbal here] end
				validators: [
					// % protected region % [Add other validators for GCS Verbal here] off begin
					// % protected region % [Add other validators for GCS Verbal here] end
				],
				// % protected region % [Add any additional model attribute properties for GCS Verbal here] off begin
				// % protected region % [Add any additional model attribute properties for GCS Verbal here] end
			},
			{
				name: 'gcsMotor',
				// % protected region % [Set displayName for GCS Motor here] off begin
				displayName: 'GCS Motor',
				// % protected region % [Set displayName for GCS Motor here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for GCS Motor here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for GCS Motor here] end
				// % protected region % [Set isSensitive for GCS Motor here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for GCS Motor here] end
				// % protected region % [Set readonly for GCS Motor here] off begin
				readOnly: false,
				// % protected region % [Set readonly for GCS Motor here] end
				validators: [
					// % protected region % [Add other validators for GCS Motor here] off begin
					// % protected region % [Add other validators for GCS Motor here] end
				],
				// % protected region % [Add any additional model attribute properties for GCS Motor here] off begin
				// % protected region % [Add any additional model attribute properties for GCS Motor here] end
			},
			{
				name: 'totalGCSScore',
				// % protected region % [Set displayName for Total GCS Score here] off begin
				displayName: 'Total GCS Score',
				// % protected region % [Set displayName for Total GCS Score here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total GCS Score here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total GCS Score here] end
				// % protected region % [Set isSensitive for Total GCS Score here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total GCS Score here] end
				// % protected region % [Set readonly for Total GCS Score here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total GCS Score here] end
				validators: [
					// % protected region % [Add other validators for Total GCS Score here] off begin
					// % protected region % [Add other validators for Total GCS Score here] end
				],
				// % protected region % [Add any additional model attribute properties for Total GCS Score here] off begin
				// % protected region % [Add any additional model attribute properties for Total GCS Score here] end
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
				name: 'heightScale',
				// % protected region % [Set displayName for Height Scale here] off begin
				displayName: 'Height Scale',
				// % protected region % [Set displayName for Height Scale here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Height Scale here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Height Scale here] end
				// % protected region % [Set isSensitive for Height Scale here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Height Scale here] end
				// % protected region % [Set readonly for Height Scale here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Height Scale here] end
				validators: [
					// % protected region % [Add other validators for Height Scale here] off begin
					// % protected region % [Add other validators for Height Scale here] end
				],
				// % protected region % [Add any additional model attribute properties for Height Scale here] off begin
				// % protected region % [Add any additional model attribute properties for Height Scale here] end
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
				name: 'weightScale',
				// % protected region % [Set displayName for Weight Scale here] off begin
				displayName: 'Weight Scale',
				// % protected region % [Set displayName for Weight Scale here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Weight Scale here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Weight Scale here] end
				// % protected region % [Set isSensitive for Weight Scale here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight Scale here] end
				// % protected region % [Set readonly for Weight Scale here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight Scale here] end
				validators: [
					// % protected region % [Add other validators for Weight Scale here] off begin
					// % protected region % [Add other validators for Weight Scale here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight Scale here] off begin
				// % protected region % [Add any additional model attribute properties for Weight Scale here] end
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
				name: 'respiratory',
				// % protected region % [Set displayName for Respiratory here] off begin
				displayName: 'Respiratory',
				// % protected region % [Set displayName for Respiratory here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Respiratory here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Respiratory here] end
				// % protected region % [Set isSensitive for Respiratory here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Respiratory here] end
				// % protected region % [Set readonly for Respiratory here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Respiratory here] end
				validators: [
					// % protected region % [Add other validators for Respiratory here] off begin
					// % protected region % [Add other validators for Respiratory here] end
				],
				// % protected region % [Add any additional model attribute properties for Respiratory here] off begin
				// % protected region % [Add any additional model attribute properties for Respiratory here] end
			},
			{
				name: 'oxygenSaturation',
				// % protected region % [Set displayName for Oxygen Saturation here] off begin
				displayName: 'Oxygen Saturation',
				// % protected region % [Set displayName for Oxygen Saturation here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Oxygen Saturation here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Oxygen Saturation here] end
				// % protected region % [Set isSensitive for Oxygen Saturation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Oxygen Saturation here] end
				// % protected region % [Set readonly for Oxygen Saturation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Oxygen Saturation here] end
				validators: [
					// % protected region % [Add other validators for Oxygen Saturation here] off begin
					// % protected region % [Add other validators for Oxygen Saturation here] end
				],
				// % protected region % [Add any additional model attribute properties for Oxygen Saturation here] off begin
				// % protected region % [Add any additional model attribute properties for Oxygen Saturation here] end
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
				name: 'waistCircumferenceUnit',
				// % protected region % [Set displayName for Waist Circumference Unit here] off begin
				displayName: 'Waist Circumference Unit',
				// % protected region % [Set displayName for Waist Circumference Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Waist Circumference Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Waist Circumference Unit here] end
				// % protected region % [Set isSensitive for Waist Circumference Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Waist Circumference Unit here] end
				// % protected region % [Set readonly for Waist Circumference Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Waist Circumference Unit here] end
				validators: [
					// % protected region % [Add other validators for Waist Circumference Unit here] off begin
					// % protected region % [Add other validators for Waist Circumference Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Waist Circumference Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Waist Circumference Unit here] end
			},
			{
				name: 'nutritionStatus',
				// % protected region % [Set displayName for Nutrition Status here] off begin
				displayName: 'Nutrition Status',
				// % protected region % [Set displayName for Nutrition Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nutrition Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nutrition Status here] end
				// % protected region % [Set isSensitive for Nutrition Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nutrition Status here] end
				// % protected region % [Set readonly for Nutrition Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nutrition Status here] end
				validators: [
					// % protected region % [Add other validators for Nutrition Status here] off begin
					// % protected region % [Add other validators for Nutrition Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Nutrition Status here] off begin
				// % protected region % [Add any additional model attribute properties for Nutrition Status here] end
			},
			{
				name: 'painScale',
				// % protected region % [Set displayName for Pain Scale here] off begin
				displayName: 'Pain Scale',
				// % protected region % [Set displayName for Pain Scale here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Pain Scale here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Pain Scale here] end
				// % protected region % [Set isSensitive for Pain Scale here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pain Scale here] end
				// % protected region % [Set readonly for Pain Scale here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pain Scale here] end
				validators: [
					// % protected region % [Add other validators for Pain Scale here] off begin
					// % protected region % [Add other validators for Pain Scale here] end
				],
				// % protected region % [Add any additional model attribute properties for Pain Scale here] off begin
				// % protected region % [Add any additional model attribute properties for Pain Scale here] end
			},
			{
				name: 'painScaleUsed',
				// % protected region % [Set displayName for Pain Scale Used here] off begin
				displayName: 'Pain Scale Used',
				// % protected region % [Set displayName for Pain Scale Used here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pain Scale Used here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pain Scale Used here] end
				// % protected region % [Set isSensitive for Pain Scale Used here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pain Scale Used here] end
				// % protected region % [Set readonly for Pain Scale Used here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pain Scale Used here] end
				validators: [
					// % protected region % [Add other validators for Pain Scale Used here] off begin
					// % protected region % [Add other validators for Pain Scale Used here] end
				],
				// % protected region % [Add any additional model attribute properties for Pain Scale Used here] off begin
				// % protected region % [Add any additional model attribute properties for Pain Scale Used here] end
			},
			{
				name: 'riskFallScale',
				// % protected region % [Set displayName for Risk Fall Scale here] off begin
				displayName: 'Risk Fall Scale',
				// % protected region % [Set displayName for Risk Fall Scale here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Risk Fall Scale here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Risk Fall Scale here] end
				// % protected region % [Set isSensitive for Risk Fall Scale here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Risk Fall Scale here] end
				// % protected region % [Set readonly for Risk Fall Scale here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Risk Fall Scale here] end
				validators: [
					// % protected region % [Add other validators for Risk Fall Scale here] off begin
					// % protected region % [Add other validators for Risk Fall Scale here] end
				],
				// % protected region % [Add any additional model attribute properties for Risk Fall Scale here] off begin
				// % protected region % [Add any additional model attribute properties for Risk Fall Scale here] end
			},
			{
				name: 'objective',
				// % protected region % [Set displayName for Objective here] off begin
				displayName: 'Objective',
				// % protected region % [Set displayName for Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Objective here] end
				// % protected region % [Set isSensitive for Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Objective here] end
				// % protected region % [Set readonly for Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Objective here] end
				validators: [
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Objective here] off begin
					// % protected region % [Add other validators for Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Objective here] end
			},
			{
				name: 'riskFallScaleUsed',
				// % protected region % [Set displayName for Risk Fall Scale Used here] off begin
				displayName: 'Risk Fall Scale Used',
				// % protected region % [Set displayName for Risk Fall Scale Used here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Risk Fall Scale Used here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Risk Fall Scale Used here] end
				// % protected region % [Set isSensitive for Risk Fall Scale Used here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Risk Fall Scale Used here] end
				// % protected region % [Set readonly for Risk Fall Scale Used here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Risk Fall Scale Used here] end
				validators: [
					// % protected region % [Add other validators for Risk Fall Scale Used here] off begin
					// % protected region % [Add other validators for Risk Fall Scale Used here] end
				],
				// % protected region % [Add any additional model attribute properties for Risk Fall Scale Used here] off begin
				// % protected region % [Add any additional model attribute properties for Risk Fall Scale Used here] end
			},
			{
				name: 'subjective',
				// % protected region % [Set displayName for Subjective here] off begin
				displayName: 'Subjective',
				// % protected region % [Set displayName for Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Subjective here] end
				// % protected region % [Set isSensitive for Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Subjective here] end
				// % protected region % [Set readonly for Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Subjective here] end
				validators: [
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Subjective here] off begin
					// % protected region % [Add other validators for Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Subjective here] end
			},
			{
				name: 'plan',
				// % protected region % [Set displayName for Plan here] off begin
				displayName: 'Plan',
				// % protected region % [Set displayName for Plan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Plan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Plan here] end
				// % protected region % [Set isSensitive for Plan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Plan here] end
				// % protected region % [Set readonly for Plan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Plan here] end
				validators: [
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Plan here] off begin
					// % protected region % [Add other validators for Plan here] end
				],
				// % protected region % [Add any additional model attribute properties for Plan here] off begin
				// % protected region % [Add any additional model attribute properties for Plan here] end
			},
			{
				name: 'purpose',
				// % protected region % [Set displayName for Purpose here] off begin
				displayName: 'Purpose',
				// % protected region % [Set displayName for Purpose here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Purpose here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Purpose here] end
				// % protected region % [Set isSensitive for Purpose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Purpose here] end
				// % protected region % [Set readonly for Purpose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Purpose here] end
				validators: [
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Purpose here] off begin
					// % protected region % [Add other validators for Purpose here] end
				],
				// % protected region % [Add any additional model attribute properties for Purpose here] off begin
				// % protected region % [Add any additional model attribute properties for Purpose here] end
			},
			{
				name: 'examinationSubCase',
				// % protected region % [Set displayName for Examination Sub Case here] off begin
				displayName: 'Examination Sub Case',
				// % protected region % [Set displayName for Examination Sub Case here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Examination Sub Case here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Examination Sub Case here] end
				// % protected region % [Set isSensitive for Examination Sub Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Examination Sub Case here] end
				// % protected region % [Set readonly for Examination Sub Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Examination Sub Case here] end
				validators: [
					// % protected region % [Add other validators for Examination Sub Case here] off begin
					// % protected region % [Add other validators for Examination Sub Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Examination Sub Case here] off begin
				// % protected region % [Add any additional model attribute properties for Examination Sub Case here] end
			},
			{
				name: 'accidentalType',
				// % protected region % [Set displayName for Accidental Type here] off begin
				displayName: 'Accidental Type',
				// % protected region % [Set displayName for Accidental Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Accidental Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Accidental Type here] end
				// % protected region % [Set isSensitive for Accidental Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Accidental Type here] end
				// % protected region % [Set readonly for Accidental Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Accidental Type here] end
				validators: [
					// % protected region % [Add other validators for Accidental Type here] off begin
					// % protected region % [Add other validators for Accidental Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Accidental Type here] off begin
				// % protected region % [Add any additional model attribute properties for Accidental Type here] end
			},
			{
				name: 'serviceCase',
				// % protected region % [Set displayName for Service Case here] off begin
				displayName: 'Service Case',
				// % protected region % [Set displayName for Service Case here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Service Case here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Service Case here] end
				// % protected region % [Set isSensitive for Service Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Service Case here] end
				// % protected region % [Set readonly for Service Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Service Case here] end
				validators: [
					// % protected region % [Add other validators for Service Case here] off begin
					// % protected region % [Add other validators for Service Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Service Case here] off begin
				// % protected region % [Add any additional model attribute properties for Service Case here] end
			},
			{
				name: 'accidentalSubType',
				// % protected region % [Set displayName for Accidental Sub Type here] off begin
				displayName: 'Accidental Sub Type',
				// % protected region % [Set displayName for Accidental Sub Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Accidental Sub Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Accidental Sub Type here] end
				// % protected region % [Set isSensitive for Accidental Sub Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Accidental Sub Type here] end
				// % protected region % [Set readonly for Accidental Sub Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Accidental Sub Type here] end
				validators: [
					// % protected region % [Add other validators for Accidental Sub Type here] off begin
					// % protected region % [Add other validators for Accidental Sub Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Accidental Sub Type here] off begin
				// % protected region % [Add any additional model attribute properties for Accidental Sub Type here] end
			},
			{
				name: 'additionalNotes',
				// % protected region % [Set displayName for Additional Notes here] off begin
				displayName: 'Additional Notes',
				// % protected region % [Set displayName for Additional Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Additional Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Additional Notes here] end
				// % protected region % [Set isSensitive for Additional Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Additional Notes here] end
				// % protected region % [Set readonly for Additional Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Additional Notes here] end
				validators: [
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Additional Notes here] off begin
					// % protected region % [Add other validators for Additional Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Additional Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Additional Notes here] end
			},
			{
				name: 'dischargeSummary',
				// % protected region % [Set displayName for Discharge Summary here] off begin
				displayName: 'Discharge Summary',
				// % protected region % [Set displayName for Discharge Summary here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Discharge Summary here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Discharge Summary here] end
				// % protected region % [Set isSensitive for Discharge Summary here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Discharge Summary here] end
				// % protected region % [Set readonly for Discharge Summary here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Discharge Summary here] end
				validators: [
					// % protected region % [Add other validators for Discharge Summary here] off begin
					// % protected region % [Add other validators for Discharge Summary here] end
				],
				// % protected region % [Add any additional model attribute properties for Discharge Summary here] off begin
				// % protected region % [Add any additional model attribute properties for Discharge Summary here] end
			},
			{
				name: 'conditionUponDischarge',
				// % protected region % [Set displayName for Condition Upon Discharge here] off begin
				displayName: 'Condition Upon Discharge',
				// % protected region % [Set displayName for Condition Upon Discharge here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Condition Upon Discharge here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Condition Upon Discharge here] end
				// % protected region % [Set isSensitive for Condition Upon Discharge here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Condition Upon Discharge here] end
				// % protected region % [Set readonly for Condition Upon Discharge here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Condition Upon Discharge here] end
				validators: [
					// % protected region % [Add other validators for Condition Upon Discharge here] off begin
					// % protected region % [Add other validators for Condition Upon Discharge here] end
				],
				// % protected region % [Add any additional model attribute properties for Condition Upon Discharge here] off begin
				// % protected region % [Add any additional model attribute properties for Condition Upon Discharge here] end
			},
			{
				name: 'escortedBy',
				// % protected region % [Set displayName for Escorted By here] off begin
				displayName: 'Escorted By',
				// % protected region % [Set displayName for Escorted By here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Escorted By here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Escorted By here] end
				// % protected region % [Set isSensitive for Escorted By here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Escorted By here] end
				// % protected region % [Set readonly for Escorted By here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Escorted By here] end
				validators: [
					// % protected region % [Add other validators for Escorted By here] off begin
					// % protected region % [Add other validators for Escorted By here] end
				],
				// % protected region % [Add any additional model attribute properties for Escorted By here] off begin
				// % protected region % [Add any additional model attribute properties for Escorted By here] end
			},
			{
				name: 'dischargeReason',
				// % protected region % [Set displayName for Discharge Reason here] off begin
				displayName: 'Discharge Reason',
				// % protected region % [Set displayName for Discharge Reason here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Discharge Reason here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Discharge Reason here] end
				// % protected region % [Set isSensitive for Discharge Reason here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Discharge Reason here] end
				// % protected region % [Set readonly for Discharge Reason here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Discharge Reason here] end
				validators: [
					// % protected region % [Add other validators for Discharge Reason here] off begin
					// % protected region % [Add other validators for Discharge Reason here] end
				],
				// % protected region % [Add any additional model attribute properties for Discharge Reason here] off begin
				// % protected region % [Add any additional model attribute properties for Discharge Reason here] end
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
				id: 'diagnosisExaminationRecords',
				type: ModelRelationType.MANY,
				name: 'diagnosisExaminationRecordsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnosis Examination Records here] off begin
				label: 'Diagnosis Examination Records',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnosis Examination Records here] end
				entityName: 'DiagnosisExaminationRecordModel',
				// % protected region % [Customise your display name for Diagnosis Examination Records here] off begin
				displayName: 'diagnosisSequence',
				// % protected region % [Customise your display name for Diagnosis Examination Records here] end
				validators: [
					// % protected region % [Add other validators for Diagnosis Examination Records here] off begin
					// % protected region % [Add other validators for Diagnosis Examination Records here] end
				],
				// % protected region % [Add any additional field for relation Diagnosis Examination Records here] off begin
				// % protected region % [Add any additional field for relation Diagnosis Examination Records here] end
			},
			{
				id: 'medicalExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'medicalExaminationRecordId',
				// % protected region % [Customise your label for Medical Examination Record here] off begin
				label: 'Medical Examination Record',
				// % protected region % [Customise your label for Medical Examination Record here] end
				entityName: 'MedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Medical Examination Record here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'diastole',
				// % protected region % [Customise your display name for Medical Examination Record here] end
				validators: [
					// % protected region % [Add other validators for Medical Examination Record here] off begin
					// % protected region % [Add other validators for Medical Examination Record here] end
				],
				// % protected region % [Add any additional field for relation Medical Examination Record here] off begin
				// % protected region % [Add any additional field for relation Medical Examination Record here] end
			},
			{
				id: 'dischargingDoctor',
				type: ModelRelationType.ONE,
				name: 'dischargingDoctorId',
				// % protected region % [Customise your label for Discharging Doctor here] off begin
				label: 'Discharging Doctor',
				// % protected region % [Customise your label for Discharging Doctor here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Discharging Doctor here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Discharging Doctor here] end
				validators: [
					// % protected region % [Add other validators for Discharging Doctor here] off begin
					// % protected region % [Add other validators for Discharging Doctor here] end
				],
				// % protected region % [Add any additional field for relation Discharging Doctor here] off begin
				// % protected region % [Add any additional field for relation Discharging Doctor here] end
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
				case 'dischargeSummary':
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
	static deepParse(data: string | { [K in keyof MedicalExaminationRecordDischargeSummaryModel]?: MedicalExaminationRecordDischargeSummaryModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new MedicalExaminationRecordDischargeSummaryModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.medicalExaminationRecord) {
			currentModel.medicalExaminationRecordId = json.medicalExaminationRecord.id;
			returned = _.union(returned, MedicalExaminationRecordModel.deepParse(json.medicalExaminationRecord));
		}

		// Incoming one to many
		if (json.dischargingDoctor) {
			currentModel.dischargingDoctorId = json.dischargingDoctor.id;
			returned = _.union(returned, StaffModel.deepParse(json.dischargingDoctor));
		}

		// Outgoing one to many
		if (json.diagnosisExaminationRecords) {
			currentModel.diagnosisExaminationRecordsIds = json.diagnosisExaminationRecords.map(model => model.id);
			returned = _.union(returned, _.flatten(json.diagnosisExaminationRecords.map(model => DiagnosisExaminationRecordModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let medicalExaminationRecordDischargeSummaryModel = new MedicalExaminationRecordDischargeSummaryModel(data);`
	 *
	 * @param data The input data to be initialised as the MedicalExaminationRecordDischargeSummaryModel,
	 *    it is expected as a JSON string or as a nullable MedicalExaminationRecordDischargeSummaryModel.
	 */
	constructor(data?: string | Partial<MedicalExaminationRecordDischargeSummaryModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<MedicalExaminationRecordDischargeSummaryModel>
				: data;

			this.diastole = json.diastole;
			this.systole = json.systole;
			this.pulse = json.pulse;
			this.bpStandingSystole = json.bpStandingSystole;
			this.bpStandingDiastole = json.bpStandingDiastole;
			this.pulseRegularity = json.pulseRegularity;
			this.pulseStrength = json.pulseStrength;
			this.temperature = json.temperature;
			this.temperatureScale = json.temperatureScale;
			this.gcsEyes = json.gcsEyes;
			this.gcsVerbal = json.gcsVerbal;
			this.gcsMotor = json.gcsMotor;
			this.totalGCSScore = json.totalGCSScore;
			this.consciousness = json.consciousness;
			this.height = json.height;
			this.heightScale = json.heightScale;
			this.weight = json.weight;
			this.weightScale = json.weightScale;
			this.bmi = json.bmi;
			this.respiratory = json.respiratory;
			this.oxygenSaturation = json.oxygenSaturation;
			this.waistCircumference = json.waistCircumference;
			this.waistCircumferenceUnit = json.waistCircumferenceUnit;
			this.nutritionStatus = json.nutritionStatus;
			this.painScale = json.painScale;
			this.painScaleUsed = json.painScaleUsed;
			this.riskFallScale = json.riskFallScale;
			this.objective = json.objective;
			this.riskFallScaleUsed = json.riskFallScaleUsed;
			this.subjective = json.subjective;
			this.plan = json.plan;
			this.purpose = json.purpose;
			this.examinationSubCase = json.examinationSubCase;
			this.accidentalType = json.accidentalType;
			this.serviceCase = json.serviceCase;
			this.accidentalSubType = json.accidentalSubType;
			this.additionalNotes = json.additionalNotes;
			this.dischargeSummary = json.dischargeSummary;
			this.conditionUponDischarge = json.conditionUponDischarge;
			this.escortedBy = json.escortedBy;
			this.dischargeReason = json.dischargeReason;
			this.medicalExaminationRecordId = json.medicalExaminationRecordId;
			this.medicalExaminationRecord = json.medicalExaminationRecord;
			this.dischargingDoctorId = json.dischargingDoctorId;
			this.dischargingDoctor = json.dischargingDoctor;
			this.diagnosisExaminationRecordsIds = json.diagnosisExaminationRecordsIds;
			this.diagnosisExaminationRecords = json.diagnosisExaminationRecords;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			diastole: this.diastole,
			systole: this.systole,
			pulse: this.pulse,
			bpStandingSystole: this.bpStandingSystole,
			bpStandingDiastole: this.bpStandingDiastole,
			pulseRegularity: this.pulseRegularity,
			pulseStrength: this.pulseStrength,
			temperature: this.temperature,
			temperatureScale: this.temperatureScale,
			gcsEyes: this.gcsEyes,
			gcsVerbal: this.gcsVerbal,
			gcsMotor: this.gcsMotor,
			totalGCSScore: this.totalGCSScore,
			consciousness: this.consciousness,
			height: this.height,
			heightScale: this.heightScale,
			weight: this.weight,
			weightScale: this.weightScale,
			bmi: this.bmi,
			respiratory: this.respiratory,
			oxygenSaturation: this.oxygenSaturation,
			waistCircumference: this.waistCircumference,
			waistCircumferenceUnit: this.waistCircumferenceUnit,
			nutritionStatus: this.nutritionStatus,
			painScale: this.painScale,
			painScaleUsed: this.painScaleUsed,
			riskFallScale: this.riskFallScale,
			objective: this.objective,
			riskFallScaleUsed: this.riskFallScaleUsed,
			subjective: this.subjective,
			plan: this.plan,
			purpose: this.purpose,
			examinationSubCase: this.examinationSubCase,
			accidentalType: this.accidentalType,
			serviceCase: this.serviceCase,
			accidentalSubType: this.accidentalSubType,
			additionalNotes: this.additionalNotes,
			dischargeSummary: this.dischargeSummary,
			conditionUponDischarge: this.conditionUponDischarge,
			escortedBy: this.escortedBy,
			dischargeReason: this.dischargeReason,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			dischargingDoctorId: this.dischargingDoctorId,
			diagnosisExaminationRecordsIds: this.diagnosisExaminationRecordsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		MedicalExaminationRecordDischargeSummaryModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): MedicalExaminationRecordDischargeSummaryModel {
		let newModelJson = this.toJSON();

		if (updates.diastole) {
			newModelJson.diastole = updates.diastole;
		}

		if (updates.systole) {
			newModelJson.systole = updates.systole;
		}

		if (updates.pulse) {
			newModelJson.pulse = updates.pulse;
		}

		if (updates.bpStandingSystole) {
			newModelJson.bpStandingSystole = updates.bpStandingSystole;
		}

		if (updates.bpStandingDiastole) {
			newModelJson.bpStandingDiastole = updates.bpStandingDiastole;
		}

		if (updates.pulseRegularity) {
			newModelJson.pulseRegularity = updates.pulseRegularity;
		}

		if (updates.pulseStrength) {
			newModelJson.pulseStrength = updates.pulseStrength;
		}

		if (updates.temperature) {
			newModelJson.temperature = updates.temperature;
		}

		if (updates.temperatureScale) {
			newModelJson.temperatureScale = updates.temperatureScale;
		}

		if (updates.gcsEyes) {
			newModelJson.gcsEyes = updates.gcsEyes;
		}

		if (updates.gcsVerbal) {
			newModelJson.gcsVerbal = updates.gcsVerbal;
		}

		if (updates.gcsMotor) {
			newModelJson.gcsMotor = updates.gcsMotor;
		}

		if (updates.totalGCSScore) {
			newModelJson.totalGCSScore = updates.totalGCSScore;
		}

		if (updates.consciousness) {
			newModelJson.consciousness = updates.consciousness;
		}

		if (updates.height) {
			newModelJson.height = updates.height;
		}

		if (updates.heightScale) {
			newModelJson.heightScale = updates.heightScale;
		}

		if (updates.weight) {
			newModelJson.weight = updates.weight;
		}

		if (updates.weightScale) {
			newModelJson.weightScale = updates.weightScale;
		}

		if (updates.bmi) {
			newModelJson.bmi = updates.bmi;
		}

		if (updates.respiratory) {
			newModelJson.respiratory = updates.respiratory;
		}

		if (updates.oxygenSaturation) {
			newModelJson.oxygenSaturation = updates.oxygenSaturation;
		}

		if (updates.waistCircumference) {
			newModelJson.waistCircumference = updates.waistCircumference;
		}

		if (updates.waistCircumferenceUnit) {
			newModelJson.waistCircumferenceUnit = updates.waistCircumferenceUnit;
		}

		if (updates.nutritionStatus) {
			newModelJson.nutritionStatus = updates.nutritionStatus;
		}

		if (updates.painScale) {
			newModelJson.painScale = updates.painScale;
		}

		if (updates.painScaleUsed) {
			newModelJson.painScaleUsed = updates.painScaleUsed;
		}

		if (updates.riskFallScale) {
			newModelJson.riskFallScale = updates.riskFallScale;
		}

		if (updates.objective) {
			newModelJson.objective = updates.objective;
		}

		if (updates.riskFallScaleUsed) {
			newModelJson.riskFallScaleUsed = updates.riskFallScaleUsed;
		}

		if (updates.subjective) {
			newModelJson.subjective = updates.subjective;
		}

		if (updates.plan) {
			newModelJson.plan = updates.plan;
		}

		if (updates.purpose) {
			newModelJson.purpose = updates.purpose;
		}

		if (updates.examinationSubCase) {
			newModelJson.examinationSubCase = updates.examinationSubCase;
		}

		if (updates.accidentalType) {
			newModelJson.accidentalType = updates.accidentalType;
		}

		if (updates.serviceCase) {
			newModelJson.serviceCase = updates.serviceCase;
		}

		if (updates.accidentalSubType) {
			newModelJson.accidentalSubType = updates.accidentalSubType;
		}

		if (updates.additionalNotes) {
			newModelJson.additionalNotes = updates.additionalNotes;
		}

		if (updates.dischargeSummary) {
			newModelJson.dischargeSummary = updates.dischargeSummary;
		}

		if (updates.conditionUponDischarge) {
			newModelJson.conditionUponDischarge = updates.conditionUponDischarge;
		}

		if (updates.escortedBy) {
			newModelJson.escortedBy = updates.escortedBy;
		}

		if (updates.dischargeReason) {
			newModelJson.dischargeReason = updates.dischargeReason;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		if (updates.dischargingDoctorId) {
			newModelJson.dischargingDoctorId = updates.dischargingDoctorId;
		}

		if (updates.diagnosisExaminationRecordsIds) {
			newModelJson.diagnosisExaminationRecordsIds = updates.diagnosisExaminationRecordsIds;
		}

		return new MedicalExaminationRecordDischargeSummaryModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof MedicalExaminationRecordDischargeSummaryModel)) {
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
			'medicalExaminationRecordId',
			'medicalExaminationRecord',
			'dischargingDoctorId',
			'dischargingDoctor',
			'diagnosisExaminationRecordsIds',
			'diagnosisExaminationRecords',
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
		if (!this.medicalExaminationRecord) {
			this.medicalExaminationRecordId = null;
		} else {
			this.medicalExaminationRecordId = this.medicalExaminationRecord.id;
		}

		if (!this.dischargingDoctor) {
			this.dischargingDoctorId = null;
		} else {
			this.dischargingDoctorId = this.dischargingDoctor.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
