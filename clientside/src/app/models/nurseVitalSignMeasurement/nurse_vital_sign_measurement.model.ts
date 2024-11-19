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
import {MedicalExaminationRecordModel} from '../medicalExaminationRecord/medical_examination_record.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class NurseVitalSignMeasurementModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'diastole',
		'systole',
		'pulseRegularity',
		'waistCircumference',
		'waistCircumferenceUnit',
		'painScale',
		'painScaleUsed',
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

	readonly className = 'NurseVitalSignMeasurementModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return NurseVitalSignMeasurementModel.displayAttributes.map((attr) => this[attr]).join(' ');
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
	 * Temperature.
	 */
	temperature: number;

	/**
	 * Temperature Scale.
	 */
	temperatureScale: string;

	/**
	 * Consciousness.
	 */
	consciousness: string;

	/**
	 * Pulse.
	 */
	pulse: number;

	/**
	 * Pulse Regularity.
	 */
	pulseRegularity: string;

	/**
	 * Pulse Strength.
	 */
	pulseStrength: string;

	/**
	 * Gcs Eyes.
	 */
	gcsEyes: string;

	/**
	 * Gcs Verbal.
	 */
	gcsVerbal: string;

	/**
	 * Gcs Motor.
	 */
	gcsMotor: string;

	/**
	 * Total GCS Score.
	 */
	totalGCSScore: number;

	/**
	 * Height.
	 */
	height: number;

	/**
	 * Height Scale.
	 */
	heightScale: string;

	/**
	 * Weight.
	 */
	weight: number;

	/**
	 * Weight Scale.
	 */
	weightScale: string;

	/**
	 * Bmi.
	 */
	bmi: number;

	/**
	 * Respiratory.
	 */
	respiratory: number;

	/**
	 * Oxygen Saturation.
	 */
	oxygenSaturation: number;

	/**
	 * Nutrition Status.
	 */
	nutritionStatus: string;

	/**
	 * Waist Circumference.
	 */
	waistCircumference: number;

	/**
	 * Waist Circumference Unit.
	 */
	waistCircumferenceUnit: string;

	/**
	 * Pain Scale.
	 */
	painScale: number;

	/**
	 * Pain Scale Used.
	 */
	painScaleUsed: string;

	/**
	 * Risk Fall Scale.
	 */
	riskFallScale: number;

	/**
	 * Risk Fall Scale Used.
	 */
	riskFallScaleUsed: string;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	modelPropGroups: { [s: string]: Group } = NurseVitalSignMeasurementModel.modelPropGroups;

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
				// % protected region % [Set displayName for Temperature Scale here] off begin
				displayName: 'Temperature Scale',
				// % protected region % [Set displayName for Temperature Scale here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Temperature Scale here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Temperature Scale here] end
				// % protected region % [Set isSensitive for Temperature Scale here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Temperature Scale here] end
				// % protected region % [Set readonly for Temperature Scale here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Temperature Scale here] end
				validators: [
					// % protected region % [Add other validators for Temperature Scale here] off begin
					// % protected region % [Add other validators for Temperature Scale here] end
				],
				// % protected region % [Add any additional model attribute properties for Temperature Scale here] off begin
				// % protected region % [Add any additional model attribute properties for Temperature Scale here] end
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
				name: 'gcsEyes',
				// % protected region % [Set displayName for Gcs Eyes here] off begin
				displayName: 'Gcs Eyes',
				// % protected region % [Set displayName for Gcs Eyes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gcs Eyes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gcs Eyes here] end
				// % protected region % [Set isSensitive for Gcs Eyes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gcs Eyes here] end
				// % protected region % [Set readonly for Gcs Eyes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gcs Eyes here] end
				validators: [
					// % protected region % [Add other validators for Gcs Eyes here] off begin
					// % protected region % [Add other validators for Gcs Eyes here] end
				],
				// % protected region % [Add any additional model attribute properties for Gcs Eyes here] off begin
				// % protected region % [Add any additional model attribute properties for Gcs Eyes here] end
			},
			{
				name: 'gcsVerbal',
				// % protected region % [Set displayName for Gcs Verbal here] off begin
				displayName: 'Gcs Verbal',
				// % protected region % [Set displayName for Gcs Verbal here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gcs Verbal here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gcs Verbal here] end
				// % protected region % [Set isSensitive for Gcs Verbal here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gcs Verbal here] end
				// % protected region % [Set readonly for Gcs Verbal here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gcs Verbal here] end
				validators: [
					// % protected region % [Add other validators for Gcs Verbal here] off begin
					// % protected region % [Add other validators for Gcs Verbal here] end
				],
				// % protected region % [Add any additional model attribute properties for Gcs Verbal here] off begin
				// % protected region % [Add any additional model attribute properties for Gcs Verbal here] end
			},
			{
				name: 'gcsMotor',
				// % protected region % [Set displayName for Gcs Motor here] off begin
				displayName: 'Gcs Motor',
				// % protected region % [Set displayName for Gcs Motor here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gcs Motor here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gcs Motor here] end
				// % protected region % [Set isSensitive for Gcs Motor here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gcs Motor here] end
				// % protected region % [Set readonly for Gcs Motor here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gcs Motor here] end
				validators: [
					// % protected region % [Add other validators for Gcs Motor here] off begin
					// % protected region % [Add other validators for Gcs Motor here] end
				],
				// % protected region % [Add any additional model attribute properties for Gcs Motor here] off begin
				// % protected region % [Add any additional model attribute properties for Gcs Motor here] end
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
				// % protected region % [Set displayName for Bmi here] off begin
				displayName: 'Bmi',
				// % protected region % [Set displayName for Bmi here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Bmi here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Bmi here] end
				// % protected region % [Set isSensitive for Bmi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bmi here] end
				// % protected region % [Set readonly for Bmi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bmi here] end
				validators: [
					// % protected region % [Add other validators for Bmi here] off begin
					// % protected region % [Add other validators for Bmi here] end
				],
				// % protected region % [Add any additional model attribute properties for Bmi here] off begin
				// % protected region % [Add any additional model attribute properties for Bmi here] end
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
				case 'diastole':
					break;
				case 'systole':
					break;
				case 'pulseRegularity':
					break;
				case 'waistCircumference':
					break;
				case 'waistCircumferenceUnit':
					break;
				case 'painScale':
					break;
				case 'painScaleUsed':
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
	static deepParse(data: string | { [K in keyof NurseVitalSignMeasurementModel]?: NurseVitalSignMeasurementModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new NurseVitalSignMeasurementModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.medicalExaminationRecord) {
			currentModel.medicalExaminationRecordId = json.medicalExaminationRecord.id;
			returned = _.union(returned, MedicalExaminationRecordModel.deepParse(json.medicalExaminationRecord));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let nurseVitalSignMeasurementModel = new NurseVitalSignMeasurementModel(data);`
	 *
	 * @param data The input data to be initialised as the NurseVitalSignMeasurementModel,
	 *    it is expected as a JSON string or as a nullable NurseVitalSignMeasurementModel.
	 */
	constructor(data?: string | Partial<NurseVitalSignMeasurementModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<NurseVitalSignMeasurementModel>
				: data;

			this.diastole = json.diastole;
			this.systole = json.systole;
			this.temperature = json.temperature;
			this.temperatureScale = json.temperatureScale;
			this.consciousness = json.consciousness;
			this.pulse = json.pulse;
			this.pulseRegularity = json.pulseRegularity;
			this.pulseStrength = json.pulseStrength;
			this.gcsEyes = json.gcsEyes;
			this.gcsVerbal = json.gcsVerbal;
			this.gcsMotor = json.gcsMotor;
			this.totalGCSScore = json.totalGCSScore;
			this.height = json.height;
			this.heightScale = json.heightScale;
			this.weight = json.weight;
			this.weightScale = json.weightScale;
			this.bmi = json.bmi;
			this.respiratory = json.respiratory;
			this.oxygenSaturation = json.oxygenSaturation;
			this.nutritionStatus = json.nutritionStatus;
			this.waistCircumference = json.waistCircumference;
			this.waistCircumferenceUnit = json.waistCircumferenceUnit;
			this.painScale = json.painScale;
			this.painScaleUsed = json.painScaleUsed;
			this.riskFallScale = json.riskFallScale;
			this.riskFallScaleUsed = json.riskFallScaleUsed;
			this.medicalExaminationRecordId = json.medicalExaminationRecordId;
			this.medicalExaminationRecord = json.medicalExaminationRecord;
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
			temperature: this.temperature,
			temperatureScale: this.temperatureScale,
			consciousness: this.consciousness,
			pulse: this.pulse,
			pulseRegularity: this.pulseRegularity,
			pulseStrength: this.pulseStrength,
			gcsEyes: this.gcsEyes,
			gcsVerbal: this.gcsVerbal,
			gcsMotor: this.gcsMotor,
			totalGCSScore: this.totalGCSScore,
			height: this.height,
			heightScale: this.heightScale,
			weight: this.weight,
			weightScale: this.weightScale,
			bmi: this.bmi,
			respiratory: this.respiratory,
			oxygenSaturation: this.oxygenSaturation,
			nutritionStatus: this.nutritionStatus,
			waistCircumference: this.waistCircumference,
			waistCircumferenceUnit: this.waistCircumferenceUnit,
			painScale: this.painScale,
			painScaleUsed: this.painScaleUsed,
			riskFallScale: this.riskFallScale,
			riskFallScaleUsed: this.riskFallScaleUsed,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		NurseVitalSignMeasurementModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): NurseVitalSignMeasurementModel {
		let newModelJson = this.toJSON();

		if (updates.diastole) {
			newModelJson.diastole = updates.diastole;
		}

		if (updates.systole) {
			newModelJson.systole = updates.systole;
		}

		if (updates.temperature) {
			newModelJson.temperature = updates.temperature;
		}

		if (updates.temperatureScale) {
			newModelJson.temperatureScale = updates.temperatureScale;
		}

		if (updates.consciousness) {
			newModelJson.consciousness = updates.consciousness;
		}

		if (updates.pulse) {
			newModelJson.pulse = updates.pulse;
		}

		if (updates.pulseRegularity) {
			newModelJson.pulseRegularity = updates.pulseRegularity;
		}

		if (updates.pulseStrength) {
			newModelJson.pulseStrength = updates.pulseStrength;
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

		if (updates.nutritionStatus) {
			newModelJson.nutritionStatus = updates.nutritionStatus;
		}

		if (updates.waistCircumference) {
			newModelJson.waistCircumference = updates.waistCircumference;
		}

		if (updates.waistCircumferenceUnit) {
			newModelJson.waistCircumferenceUnit = updates.waistCircumferenceUnit;
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

		if (updates.riskFallScaleUsed) {
			newModelJson.riskFallScaleUsed = updates.riskFallScaleUsed;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		return new NurseVitalSignMeasurementModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof NurseVitalSignMeasurementModel)) {
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

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
