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
export class BirthHistoryModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'deliveryType',
		'headCircumferenceBirth',
		'headCircumferenceBirthUnit',
		'neonatalCase',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'gestationalAgeWeeks',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BirthHistoryModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BirthHistoryModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Gestational Age Weeks.
	 */
	gestationalAgeWeeks: number;

	/**
	 * Gestational Age Days.
	 */
	gestationalAgeDays: number;

	/**
	 * Delivery Type.
	 */
	deliveryType: string;

	/**
	 * Length.
	 */
	length: number;

	/**
	 * Length Unit.
	 */
	lengthUnit: string;

	/**
	 * Weight.
	 */
	weight: number;

	/**
	 * Weight Unit.
	 */
	weightUnit: string;

	/**
	 * Head Circumference Birth.
	 */
	headCircumferenceBirth: number;

	/**
	 * Head Circumference Birth Unit.
	 */
	headCircumferenceBirthUnit: string;

	/**
	 * Chest Circumference.
	 */
	chestCircumference: number;

	/**
	 * Chest Circumference Unit.
	 */
	chestCircumferenceUnit: string;

	/**
	 * Birth Condition.
	 */
	birthCondition: string;

	/**
	 * Neonatal Case.
	 */
	neonatalCase: string;

	/**
	 * Pediatric Case.
	 */
	pediatricCase: string;

	/**
	 * Food Type.
	 */
	foodType: string;

	/**
	 * Head Circumference.
	 */
	headCircumference: number;

	/**
	 * Head Circumference Unit.
	 */
	headCircumferenceUnit: string;

	/**
	 * Upper Arm Circumference.
	 */
	upperArmCircumference: number;

	/**
	 * Upper Arm Circumference Unit.
	 */
	upperArmCircumferenceUnit: string;

	/**
	 * Action Taken.
	 */
	actionTaken: string;

	/**
	 * Weight Gestational Age.
	 */
	weightGestationalAge: string;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	modelPropGroups: { [s: string]: Group } = BirthHistoryModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'gestationalAgeWeeks',
				// % protected region % [Set displayName for Gestational Age Weeks here] off begin
				displayName: 'Gestational Age Weeks',
				// % protected region % [Set displayName for Gestational Age Weeks here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Gestational Age Weeks here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Gestational Age Weeks here] end
				// % protected region % [Set isSensitive for Gestational Age Weeks here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gestational Age Weeks here] end
				// % protected region % [Set readonly for Gestational Age Weeks here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gestational Age Weeks here] end
				validators: [
					// % protected region % [Add other validators for Gestational Age Weeks here] off begin
					// % protected region % [Add other validators for Gestational Age Weeks here] end
				],
				// % protected region % [Add any additional model attribute properties for Gestational Age Weeks here] off begin
				// % protected region % [Add any additional model attribute properties for Gestational Age Weeks here] end
			},
			{
				name: 'gestationalAgeDays',
				// % protected region % [Set displayName for Gestational Age Days here] off begin
				displayName: 'Gestational Age Days',
				// % protected region % [Set displayName for Gestational Age Days here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Gestational Age Days here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Gestational Age Days here] end
				// % protected region % [Set isSensitive for Gestational Age Days here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gestational Age Days here] end
				// % protected region % [Set readonly for Gestational Age Days here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gestational Age Days here] end
				validators: [
					// % protected region % [Add other validators for Gestational Age Days here] off begin
					// % protected region % [Add other validators for Gestational Age Days here] end
				],
				// % protected region % [Add any additional model attribute properties for Gestational Age Days here] off begin
				// % protected region % [Add any additional model attribute properties for Gestational Age Days here] end
			},
			{
				name: 'deliveryType',
				// % protected region % [Set displayName for Delivery Type here] off begin
				displayName: 'Delivery Type',
				// % protected region % [Set displayName for Delivery Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Delivery Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Delivery Type here] end
				// % protected region % [Set isSensitive for Delivery Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Delivery Type here] end
				// % protected region % [Set readonly for Delivery Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Delivery Type here] end
				validators: [
					// % protected region % [Add other validators for Delivery Type here] off begin
					// % protected region % [Add other validators for Delivery Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Delivery Type here] off begin
				// % protected region % [Add any additional model attribute properties for Delivery Type here] end
			},
			{
				name: 'length',
				// % protected region % [Set displayName for Length here] off begin
				displayName: 'Length',
				// % protected region % [Set displayName for Length here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Length here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Length here] end
				// % protected region % [Set isSensitive for Length here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Length here] end
				// % protected region % [Set readonly for Length here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Length here] end
				validators: [
					// % protected region % [Add other validators for Length here] off begin
					// % protected region % [Add other validators for Length here] end
				],
				// % protected region % [Add any additional model attribute properties for Length here] off begin
				// % protected region % [Add any additional model attribute properties for Length here] end
			},
			{
				name: 'lengthUnit',
				// % protected region % [Set displayName for Length Unit here] off begin
				displayName: 'Length Unit',
				// % protected region % [Set displayName for Length Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Length Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Length Unit here] end
				// % protected region % [Set isSensitive for Length Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Length Unit here] end
				// % protected region % [Set readonly for Length Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Length Unit here] end
				validators: [
					// % protected region % [Add other validators for Length Unit here] off begin
					// % protected region % [Add other validators for Length Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Length Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Length Unit here] end
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
				name: 'weightUnit',
				// % protected region % [Set displayName for Weight Unit here] off begin
				displayName: 'Weight Unit',
				// % protected region % [Set displayName for Weight Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Weight Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Weight Unit here] end
				// % protected region % [Set isSensitive for Weight Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight Unit here] end
				// % protected region % [Set readonly for Weight Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight Unit here] end
				validators: [
					// % protected region % [Add other validators for Weight Unit here] off begin
					// % protected region % [Add other validators for Weight Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Weight Unit here] end
			},
			{
				name: 'headCircumferenceBirth',
				// % protected region % [Set displayName for Head Circumference Birth here] off begin
				displayName: 'Head Circumference Birth',
				// % protected region % [Set displayName for Head Circumference Birth here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Head Circumference Birth here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Head Circumference Birth here] end
				// % protected region % [Set isSensitive for Head Circumference Birth here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Head Circumference Birth here] end
				// % protected region % [Set readonly for Head Circumference Birth here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Head Circumference Birth here] end
				validators: [
					// % protected region % [Add other validators for Head Circumference Birth here] off begin
					// % protected region % [Add other validators for Head Circumference Birth here] end
				],
				// % protected region % [Add any additional model attribute properties for Head Circumference Birth here] off begin
				// % protected region % [Add any additional model attribute properties for Head Circumference Birth here] end
			},
			{
				name: 'headCircumferenceBirthUnit',
				// % protected region % [Set displayName for Head Circumference Birth Unit here] off begin
				displayName: 'Head Circumference Birth Unit',
				// % protected region % [Set displayName for Head Circumference Birth Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Head Circumference Birth Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Head Circumference Birth Unit here] end
				// % protected region % [Set isSensitive for Head Circumference Birth Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Head Circumference Birth Unit here] end
				// % protected region % [Set readonly for Head Circumference Birth Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Head Circumference Birth Unit here] end
				validators: [
					// % protected region % [Add other validators for Head Circumference Birth Unit here] off begin
					// % protected region % [Add other validators for Head Circumference Birth Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Head Circumference Birth Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Head Circumference Birth Unit here] end
			},
			{
				name: 'chestCircumference',
				// % protected region % [Set displayName for Chest Circumference here] off begin
				displayName: 'Chest Circumference',
				// % protected region % [Set displayName for Chest Circumference here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Chest Circumference here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Chest Circumference here] end
				// % protected region % [Set isSensitive for Chest Circumference here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Chest Circumference here] end
				// % protected region % [Set readonly for Chest Circumference here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Chest Circumference here] end
				validators: [
					// % protected region % [Add other validators for Chest Circumference here] off begin
					// % protected region % [Add other validators for Chest Circumference here] end
				],
				// % protected region % [Add any additional model attribute properties for Chest Circumference here] off begin
				// % protected region % [Add any additional model attribute properties for Chest Circumference here] end
			},
			{
				name: 'chestCircumferenceUnit',
				// % protected region % [Set displayName for Chest Circumference Unit here] off begin
				displayName: 'Chest Circumference Unit',
				// % protected region % [Set displayName for Chest Circumference Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Chest Circumference Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Chest Circumference Unit here] end
				// % protected region % [Set isSensitive for Chest Circumference Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Chest Circumference Unit here] end
				// % protected region % [Set readonly for Chest Circumference Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Chest Circumference Unit here] end
				validators: [
					// % protected region % [Add other validators for Chest Circumference Unit here] off begin
					// % protected region % [Add other validators for Chest Circumference Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Chest Circumference Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Chest Circumference Unit here] end
			},
			{
				name: 'birthCondition',
				// % protected region % [Set displayName for Birth Condition here] off begin
				displayName: 'Birth Condition',
				// % protected region % [Set displayName for Birth Condition here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Birth Condition here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Birth Condition here] end
				// % protected region % [Set isSensitive for Birth Condition here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Birth Condition here] end
				// % protected region % [Set readonly for Birth Condition here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Birth Condition here] end
				validators: [
					// % protected region % [Add other validators for Birth Condition here] off begin
					// % protected region % [Add other validators for Birth Condition here] end
				],
				// % protected region % [Add any additional model attribute properties for Birth Condition here] off begin
				// % protected region % [Add any additional model attribute properties for Birth Condition here] end
			},
			{
				name: 'neonatalCase',
				// % protected region % [Set displayName for Neonatal Case here] off begin
				displayName: 'Neonatal Case',
				// % protected region % [Set displayName for Neonatal Case here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Neonatal Case here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Neonatal Case here] end
				// % protected region % [Set isSensitive for Neonatal Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Neonatal Case here] end
				// % protected region % [Set readonly for Neonatal Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Neonatal Case here] end
				validators: [
					// % protected region % [Add other validators for Neonatal Case here] off begin
					// % protected region % [Add other validators for Neonatal Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Neonatal Case here] off begin
				// % protected region % [Add any additional model attribute properties for Neonatal Case here] end
			},
			{
				name: 'pediatricCase',
				// % protected region % [Set displayName for Pediatric Case here] off begin
				displayName: 'Pediatric Case',
				// % protected region % [Set displayName for Pediatric Case here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pediatric Case here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pediatric Case here] end
				// % protected region % [Set isSensitive for Pediatric Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pediatric Case here] end
				// % protected region % [Set readonly for Pediatric Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pediatric Case here] end
				validators: [
					// % protected region % [Add other validators for Pediatric Case here] off begin
					// % protected region % [Add other validators for Pediatric Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Pediatric Case here] off begin
				// % protected region % [Add any additional model attribute properties for Pediatric Case here] end
			},
			{
				name: 'foodType',
				// % protected region % [Set displayName for Food Type here] off begin
				displayName: 'Food Type',
				// % protected region % [Set displayName for Food Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Food Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Food Type here] end
				// % protected region % [Set isSensitive for Food Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Food Type here] end
				// % protected region % [Set readonly for Food Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Food Type here] end
				validators: [
					// % protected region % [Add other validators for Food Type here] off begin
					// % protected region % [Add other validators for Food Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Food Type here] off begin
				// % protected region % [Add any additional model attribute properties for Food Type here] end
			},
			{
				name: 'headCircumference',
				// % protected region % [Set displayName for Head Circumference here] off begin
				displayName: 'Head Circumference',
				// % protected region % [Set displayName for Head Circumference here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Head Circumference here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Head Circumference here] end
				// % protected region % [Set isSensitive for Head Circumference here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Head Circumference here] end
				// % protected region % [Set readonly for Head Circumference here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Head Circumference here] end
				validators: [
					// % protected region % [Add other validators for Head Circumference here] off begin
					// % protected region % [Add other validators for Head Circumference here] end
				],
				// % protected region % [Add any additional model attribute properties for Head Circumference here] off begin
				// % protected region % [Add any additional model attribute properties for Head Circumference here] end
			},
			{
				name: 'headCircumferenceUnit',
				// % protected region % [Set displayName for Head Circumference Unit here] off begin
				displayName: 'Head Circumference Unit',
				// % protected region % [Set displayName for Head Circumference Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Head Circumference Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Head Circumference Unit here] end
				// % protected region % [Set isSensitive for Head Circumference Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Head Circumference Unit here] end
				// % protected region % [Set readonly for Head Circumference Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Head Circumference Unit here] end
				validators: [
					// % protected region % [Add other validators for Head Circumference Unit here] off begin
					// % protected region % [Add other validators for Head Circumference Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Head Circumference Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Head Circumference Unit here] end
			},
			{
				name: 'upperArmCircumference',
				// % protected region % [Set displayName for Upper Arm Circumference here] off begin
				displayName: 'Upper Arm Circumference',
				// % protected region % [Set displayName for Upper Arm Circumference here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Upper Arm Circumference here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Upper Arm Circumference here] end
				// % protected region % [Set isSensitive for Upper Arm Circumference here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Upper Arm Circumference here] end
				// % protected region % [Set readonly for Upper Arm Circumference here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Upper Arm Circumference here] end
				validators: [
					// % protected region % [Add other validators for Upper Arm Circumference here] off begin
					// % protected region % [Add other validators for Upper Arm Circumference here] end
				],
				// % protected region % [Add any additional model attribute properties for Upper Arm Circumference here] off begin
				// % protected region % [Add any additional model attribute properties for Upper Arm Circumference here] end
			},
			{
				name: 'upperArmCircumferenceUnit',
				// % protected region % [Set displayName for Upper Arm Circumference Unit here] off begin
				displayName: 'Upper Arm Circumference Unit',
				// % protected region % [Set displayName for Upper Arm Circumference Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Upper Arm Circumference Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Upper Arm Circumference Unit here] end
				// % protected region % [Set isSensitive for Upper Arm Circumference Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Upper Arm Circumference Unit here] end
				// % protected region % [Set readonly for Upper Arm Circumference Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Upper Arm Circumference Unit here] end
				validators: [
					// % protected region % [Add other validators for Upper Arm Circumference Unit here] off begin
					// % protected region % [Add other validators for Upper Arm Circumference Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Upper Arm Circumference Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Upper Arm Circumference Unit here] end
			},
			{
				name: 'actionTaken',
				// % protected region % [Set displayName for Action Taken here] off begin
				displayName: 'Action Taken',
				// % protected region % [Set displayName for Action Taken here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Action Taken here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Action Taken here] end
				// % protected region % [Set isSensitive for Action Taken here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Action Taken here] end
				// % protected region % [Set readonly for Action Taken here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Action Taken here] end
				validators: [
					// % protected region % [Add other validators for Action Taken here] off begin
					// % protected region % [Add other validators for Action Taken here] end
				],
				// % protected region % [Add any additional model attribute properties for Action Taken here] off begin
				// % protected region % [Add any additional model attribute properties for Action Taken here] end
			},
			{
				name: 'weightGestationalAge',
				// % protected region % [Set displayName for Weight Gestational Age here] off begin
				displayName: 'Weight Gestational Age',
				// % protected region % [Set displayName for Weight Gestational Age here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Weight Gestational Age here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Weight Gestational Age here] end
				// % protected region % [Set isSensitive for Weight Gestational Age here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight Gestational Age here] end
				// % protected region % [Set readonly for Weight Gestational Age here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight Gestational Age here] end
				validators: [
					// % protected region % [Add other validators for Weight Gestational Age here] off begin
					// % protected region % [Add other validators for Weight Gestational Age here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight Gestational Age here] off begin
				// % protected region % [Add any additional model attribute properties for Weight Gestational Age here] end
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
				case 'deliveryType':
					break;
				case 'headCircumferenceBirth':
					break;
				case 'headCircumferenceBirthUnit':
					break;
				case 'neonatalCase':
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
	static deepParse(data: string | { [K in keyof BirthHistoryModel]?: BirthHistoryModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BirthHistoryModel(data);
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
	 * `let birthHistoryModel = new BirthHistoryModel(data);`
	 *
	 * @param data The input data to be initialised as the BirthHistoryModel,
	 *    it is expected as a JSON string or as a nullable BirthHistoryModel.
	 */
	constructor(data?: string | Partial<BirthHistoryModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BirthHistoryModel>
				: data;

			this.gestationalAgeWeeks = json.gestationalAgeWeeks;
			this.gestationalAgeDays = json.gestationalAgeDays;
			this.deliveryType = json.deliveryType;
			this.length = json.length;
			this.lengthUnit = json.lengthUnit;
			this.weight = json.weight;
			this.weightUnit = json.weightUnit;
			this.headCircumferenceBirth = json.headCircumferenceBirth;
			this.headCircumferenceBirthUnit = json.headCircumferenceBirthUnit;
			this.chestCircumference = json.chestCircumference;
			this.chestCircumferenceUnit = json.chestCircumferenceUnit;
			this.birthCondition = json.birthCondition;
			this.neonatalCase = json.neonatalCase;
			this.pediatricCase = json.pediatricCase;
			this.foodType = json.foodType;
			this.headCircumference = json.headCircumference;
			this.headCircumferenceUnit = json.headCircumferenceUnit;
			this.upperArmCircumference = json.upperArmCircumference;
			this.upperArmCircumferenceUnit = json.upperArmCircumferenceUnit;
			this.actionTaken = json.actionTaken;
			this.weightGestationalAge = json.weightGestationalAge;
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
			gestationalAgeWeeks: this.gestationalAgeWeeks,
			gestationalAgeDays: this.gestationalAgeDays,
			deliveryType: this.deliveryType,
			length: this.length,
			lengthUnit: this.lengthUnit,
			weight: this.weight,
			weightUnit: this.weightUnit,
			headCircumferenceBirth: this.headCircumferenceBirth,
			headCircumferenceBirthUnit: this.headCircumferenceBirthUnit,
			chestCircumference: this.chestCircumference,
			chestCircumferenceUnit: this.chestCircumferenceUnit,
			birthCondition: this.birthCondition,
			neonatalCase: this.neonatalCase,
			pediatricCase: this.pediatricCase,
			foodType: this.foodType,
			headCircumference: this.headCircumference,
			headCircumferenceUnit: this.headCircumferenceUnit,
			upperArmCircumference: this.upperArmCircumference,
			upperArmCircumferenceUnit: this.upperArmCircumferenceUnit,
			actionTaken: this.actionTaken,
			weightGestationalAge: this.weightGestationalAge,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BirthHistoryModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BirthHistoryModel {
		let newModelJson = this.toJSON();

		if (updates.gestationalAgeWeeks) {
			newModelJson.gestationalAgeWeeks = updates.gestationalAgeWeeks;
		}

		if (updates.gestationalAgeDays) {
			newModelJson.gestationalAgeDays = updates.gestationalAgeDays;
		}

		if (updates.deliveryType) {
			newModelJson.deliveryType = updates.deliveryType;
		}

		if (updates.length) {
			newModelJson.length = updates.length;
		}

		if (updates.lengthUnit) {
			newModelJson.lengthUnit = updates.lengthUnit;
		}

		if (updates.weight) {
			newModelJson.weight = updates.weight;
		}

		if (updates.weightUnit) {
			newModelJson.weightUnit = updates.weightUnit;
		}

		if (updates.headCircumferenceBirth) {
			newModelJson.headCircumferenceBirth = updates.headCircumferenceBirth;
		}

		if (updates.headCircumferenceBirthUnit) {
			newModelJson.headCircumferenceBirthUnit = updates.headCircumferenceBirthUnit;
		}

		if (updates.chestCircumference) {
			newModelJson.chestCircumference = updates.chestCircumference;
		}

		if (updates.chestCircumferenceUnit) {
			newModelJson.chestCircumferenceUnit = updates.chestCircumferenceUnit;
		}

		if (updates.birthCondition) {
			newModelJson.birthCondition = updates.birthCondition;
		}

		if (updates.neonatalCase) {
			newModelJson.neonatalCase = updates.neonatalCase;
		}

		if (updates.pediatricCase) {
			newModelJson.pediatricCase = updates.pediatricCase;
		}

		if (updates.foodType) {
			newModelJson.foodType = updates.foodType;
		}

		if (updates.headCircumference) {
			newModelJson.headCircumference = updates.headCircumference;
		}

		if (updates.headCircumferenceUnit) {
			newModelJson.headCircumferenceUnit = updates.headCircumferenceUnit;
		}

		if (updates.upperArmCircumference) {
			newModelJson.upperArmCircumference = updates.upperArmCircumference;
		}

		if (updates.upperArmCircumferenceUnit) {
			newModelJson.upperArmCircumferenceUnit = updates.upperArmCircumferenceUnit;
		}

		if (updates.actionTaken) {
			newModelJson.actionTaken = updates.actionTaken;
		}

		if (updates.weightGestationalAge) {
			newModelJson.weightGestationalAge = updates.weightGestationalAge;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		return new BirthHistoryModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BirthHistoryModel)) {
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
