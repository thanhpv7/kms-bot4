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
import {DeliveryMedicalExaminationRecordModel} from '../deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import {StaffModel} from '../staff/staff.model';
import {VitalSignsModel} from '../vitalSigns/vital_signs.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class NewbornDetailModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'newbornFirstName',
		'newbornLastName',
		'dateTimeOfBirth',
		'gender',
		'deliveryType',
		'deliveryTypeIndication',
		'weight',
		'length',
		'weightOfGestationalAge',
		'headCircumference',
		'chestCircumference',
		'birthCondition',
		'neonatalCase',
		'congenitalCondition',
		'physicalExamination',
		'apgar1MinuteAppearance',
		'apgar5MinuteAppearance',
		'apgar10MinuteAppearance',
		'apgar1MinutePulse',
		'apgar5MinutePulse',
		'apgar10MinutePulse',
		'apgar1MinuteGrimace',
		'apgar5MinuteGrimace',
		'apgar10MinuteGrimace',
		'apgar1MinuteActivity',
		'apgar5MinuteActivity',
		'apgar10MinuteActivity',
		'apgar1MinuteRespiration',
		'apgar5MinuteRespiration',
		'apgar10MinuteRespiration',
		'apgar1MinuteScore',
		'apgar5MinuteScore',
		'apgar10MinuteScore',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'newbornFirstName',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'NewbornDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return NewbornDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Newborn First Name.
	 */
	newbornFirstName: string;

	/**
	 * Newborn Last Name.
	 */
	newbornLastName: string;

	/**
	 * .
	 */
	dateTimeOfBirth: Date;

	/**
	 * .
	 */
	gender: string;

	/**
	 * .
	 */
	deliveryType: string;

	/**
	 * .
	 */
	deliveryTypeIndication: string;

	/**
	 * .
	 */
	weight: number;

	/**
	 * .
	 */
	length: number;

	/**
	 * .
	 */
	weightOfGestationalAge: string;

	/**
	 * .
	 */
	headCircumference: number;

	/**
	 * .
	 */
	chestCircumference: number;

	/**
	 * .
	 */
	birthCondition: string;

	/**
	 * .
	 */
	neonatalCase: string;

	/**
	 * .
	 */
	congenitalCondition: string;

	/**
	 * .
	 */
	physicalExamination: string;

	/**
	 * .
	 */
	apgar1MinuteAppearance: string;

	/**
	 * .
	 */
	apgar5MinuteAppearance: string;

	/**
	 * .
	 */
	apgar10MinuteAppearance: string;

	/**
	 * .
	 */
	apgar1MinutePulse: string;

	/**
	 * .
	 */
	apgar5MinutePulse: string;

	/**
	 * .
	 */
	apgar10MinutePulse: string;

	/**
	 * .
	 */
	apgar1MinuteGrimace: string;

	/**
	 * .
	 */
	apgar5MinuteGrimace: string;

	/**
	 * .
	 */
	apgar10MinuteGrimace: string;

	/**
	 * .
	 */
	apgar1MinuteActivity: string;

	/**
	 * .
	 */
	apgar5MinuteActivity: string;

	/**
	 * .
	 */
	apgar10MinuteActivity: string;

	/**
	 * .
	 */
	apgar1MinuteRespiration: string;

	/**
	 * .
	 */
	apgar5MinuteRespiration: string;

	/**
	 * .
	 */
	apgar10MinuteRespiration: string;

	/**
	 * .
	 */
	apgar1MinuteScore: string;

	/**
	 * .
	 */
	apgar5MinuteScore: string;

	/**
	 * .
	 */
	apgar10MinuteScore: string;

	/**
	 * .
	 */
	pediatricNurse: string;

	/**
	 * Patient Id.
	 */
	patientId: string;

	/**
	 * Registration Id.
	 */
	registrationId: string;

	deliveryMedicalExaminationRecordId: string;

	deliveryMedicalExaminationRecord: DeliveryMedicalExaminationRecordModel;

	staffId: string;

	staff: StaffModel;

	vitalSignsIds: string[] = [];

	vitalSigns: VitalSignsModel[];

	modelPropGroups: { [s: string]: Group } = NewbornDetailModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'newbornFirstName',
				// % protected region % [Set displayName for Newborn First Name here] off begin
				displayName: 'Newborn First Name',
				// % protected region % [Set displayName for Newborn First Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Newborn First Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Newborn First Name here] end
				// % protected region % [Set isSensitive for Newborn First Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Newborn First Name here] end
				// % protected region % [Set readonly for Newborn First Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Newborn First Name here] end
				validators: [
					// % protected region % [Add other validators for Newborn First Name here] off begin
					// % protected region % [Add other validators for Newborn First Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Newborn First Name here] off begin
				// % protected region % [Add any additional model attribute properties for Newborn First Name here] end
			},
			{
				name: 'newbornLastName',
				// % protected region % [Set displayName for Newborn Last Name here] off begin
				displayName: 'Newborn Last Name',
				// % protected region % [Set displayName for Newborn Last Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Newborn Last Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Newborn Last Name here] end
				// % protected region % [Set isSensitive for Newborn Last Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Newborn Last Name here] end
				// % protected region % [Set readonly for Newborn Last Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Newborn Last Name here] end
				validators: [
					// % protected region % [Add other validators for Newborn Last Name here] off begin
					// % protected region % [Add other validators for Newborn Last Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Newborn Last Name here] off begin
				// % protected region % [Add any additional model attribute properties for Newborn Last Name here] end
			},
			{
				name: 'dateTimeOfBirth',
				// % protected region % [Set displayName for Date Time Of Birth here] off begin
				displayName: 'Date Time Of Birth',
				// % protected region % [Set displayName for Date Time Of Birth here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Date Time Of Birth here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Date Time Of Birth here] end
				// % protected region % [Set isSensitive for Date Time Of Birth here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date Time Of Birth here] end
				// % protected region % [Set readonly for Date Time Of Birth here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date Time Of Birth here] end
				validators: [
					// % protected region % [Add other validators for Date Time Of Birth here] off begin
					// % protected region % [Add other validators for Date Time Of Birth here] end
				],
				// % protected region % [Add any additional model attribute properties for Date Time Of Birth here] off begin
				// % protected region % [Add any additional model attribute properties for Date Time Of Birth here] end
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
				name: 'deliveryTypeIndication',
				// % protected region % [Set displayName for Delivery Type Indication here] off begin
				displayName: 'Delivery Type Indication',
				// % protected region % [Set displayName for Delivery Type Indication here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Delivery Type Indication here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Delivery Type Indication here] end
				// % protected region % [Set isSensitive for Delivery Type Indication here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Delivery Type Indication here] end
				// % protected region % [Set readonly for Delivery Type Indication here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Delivery Type Indication here] end
				validators: [
					// % protected region % [Add other validators for Delivery Type Indication here] off begin
					// % protected region % [Add other validators for Delivery Type Indication here] end
				],
				// % protected region % [Add any additional model attribute properties for Delivery Type Indication here] off begin
				// % protected region % [Add any additional model attribute properties for Delivery Type Indication here] end
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
				name: 'weightOfGestationalAge',
				// % protected region % [Set displayName for Weight Of Gestational Age here] off begin
				displayName: 'Weight Of Gestational Age',
				// % protected region % [Set displayName for Weight Of Gestational Age here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Weight Of Gestational Age here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Weight Of Gestational Age here] end
				// % protected region % [Set isSensitive for Weight Of Gestational Age here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight Of Gestational Age here] end
				// % protected region % [Set readonly for Weight Of Gestational Age here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight Of Gestational Age here] end
				validators: [
					// % protected region % [Add other validators for Weight Of Gestational Age here] off begin
					// % protected region % [Add other validators for Weight Of Gestational Age here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight Of Gestational Age here] off begin
				// % protected region % [Add any additional model attribute properties for Weight Of Gestational Age here] end
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
				name: 'congenitalCondition',
				// % protected region % [Set displayName for Congenital Condition here] off begin
				displayName: 'Congenital Condition',
				// % protected region % [Set displayName for Congenital Condition here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Congenital Condition here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Congenital Condition here] end
				// % protected region % [Set isSensitive for Congenital Condition here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Congenital Condition here] end
				// % protected region % [Set readonly for Congenital Condition here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Congenital Condition here] end
				validators: [
					// % protected region % [Add other validators for Congenital Condition here] off begin
					// % protected region % [Add other validators for Congenital Condition here] end
				],
				// % protected region % [Add any additional model attribute properties for Congenital Condition here] off begin
				// % protected region % [Add any additional model attribute properties for Congenital Condition here] end
			},
			{
				name: 'physicalExamination',
				// % protected region % [Set displayName for Physical Examination here] off begin
				displayName: 'Physical Examination',
				// % protected region % [Set displayName for Physical Examination here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Physical Examination here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Physical Examination here] end
				// % protected region % [Set isSensitive for Physical Examination here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Physical Examination here] end
				// % protected region % [Set readonly for Physical Examination here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Physical Examination here] end
				validators: [
					// % protected region % [Add other validators for Physical Examination here] off begin
					// % protected region % [Add other validators for Physical Examination here] end
				],
				// % protected region % [Add any additional model attribute properties for Physical Examination here] off begin
				// % protected region % [Add any additional model attribute properties for Physical Examination here] end
			},
			{
				name: 'apgar1MinuteAppearance',
				// % protected region % [Set displayName for APGAR 1 Minute Appearance here] off begin
				displayName: 'APGAR 1 Minute Appearance',
				// % protected region % [Set displayName for APGAR 1 Minute Appearance here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 1 Minute Appearance here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 1 Minute Appearance here] end
				// % protected region % [Set isSensitive for APGAR 1 Minute Appearance here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 1 Minute Appearance here] end
				// % protected region % [Set readonly for APGAR 1 Minute Appearance here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 1 Minute Appearance here] end
				validators: [
					// % protected region % [Add other validators for APGAR 1 Minute Appearance here] off begin
					// % protected region % [Add other validators for APGAR 1 Minute Appearance here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Appearance here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Appearance here] end
			},
			{
				name: 'apgar5MinuteAppearance',
				// % protected region % [Set displayName for APGAR 5 Minute Appearance here] off begin
				displayName: 'APGAR 5 Minute Appearance',
				// % protected region % [Set displayName for APGAR 5 Minute Appearance here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 5 Minute Appearance here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 5 Minute Appearance here] end
				// % protected region % [Set isSensitive for APGAR 5 Minute Appearance here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 5 Minute Appearance here] end
				// % protected region % [Set readonly for APGAR 5 Minute Appearance here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 5 Minute Appearance here] end
				validators: [
					// % protected region % [Add other validators for APGAR 5 Minute Appearance here] off begin
					// % protected region % [Add other validators for APGAR 5 Minute Appearance here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Appearance here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Appearance here] end
			},
			{
				name: 'apgar10MinuteAppearance',
				// % protected region % [Set displayName for APGAR 10 Minute Appearance here] off begin
				displayName: 'APGAR 10 Minute Appearance',
				// % protected region % [Set displayName for APGAR 10 Minute Appearance here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 10 Minute Appearance here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 10 Minute Appearance here] end
				// % protected region % [Set isSensitive for APGAR 10 Minute Appearance here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 10 Minute Appearance here] end
				// % protected region % [Set readonly for APGAR 10 Minute Appearance here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 10 Minute Appearance here] end
				validators: [
					// % protected region % [Add other validators for APGAR 10 Minute Appearance here] off begin
					// % protected region % [Add other validators for APGAR 10 Minute Appearance here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Appearance here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Appearance here] end
			},
			{
				name: 'apgar1MinutePulse',
				// % protected region % [Set displayName for APGAR 1 Minute Pulse here] off begin
				displayName: 'APGAR 1 Minute Pulse',
				// % protected region % [Set displayName for APGAR 1 Minute Pulse here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 1 Minute Pulse here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 1 Minute Pulse here] end
				// % protected region % [Set isSensitive for APGAR 1 Minute Pulse here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 1 Minute Pulse here] end
				// % protected region % [Set readonly for APGAR 1 Minute Pulse here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 1 Minute Pulse here] end
				validators: [
					// % protected region % [Add other validators for APGAR 1 Minute Pulse here] off begin
					// % protected region % [Add other validators for APGAR 1 Minute Pulse here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Pulse here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Pulse here] end
			},
			{
				name: 'apgar5MinutePulse',
				// % protected region % [Set displayName for APGAR 5 Minute Pulse here] off begin
				displayName: 'APGAR 5 Minute Pulse',
				// % protected region % [Set displayName for APGAR 5 Minute Pulse here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 5 Minute Pulse here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 5 Minute Pulse here] end
				// % protected region % [Set isSensitive for APGAR 5 Minute Pulse here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 5 Minute Pulse here] end
				// % protected region % [Set readonly for APGAR 5 Minute Pulse here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 5 Minute Pulse here] end
				validators: [
					// % protected region % [Add other validators for APGAR 5 Minute Pulse here] off begin
					// % protected region % [Add other validators for APGAR 5 Minute Pulse here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Pulse here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Pulse here] end
			},
			{
				name: 'apgar10MinutePulse',
				// % protected region % [Set displayName for APGAR 10 Minute Pulse here] off begin
				displayName: 'APGAR 10 Minute Pulse',
				// % protected region % [Set displayName for APGAR 10 Minute Pulse here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 10 Minute Pulse here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 10 Minute Pulse here] end
				// % protected region % [Set isSensitive for APGAR 10 Minute Pulse here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 10 Minute Pulse here] end
				// % protected region % [Set readonly for APGAR 10 Minute Pulse here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 10 Minute Pulse here] end
				validators: [
					// % protected region % [Add other validators for APGAR 10 Minute Pulse here] off begin
					// % protected region % [Add other validators for APGAR 10 Minute Pulse here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Pulse here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Pulse here] end
			},
			{
				name: 'apgar1MinuteGrimace',
				// % protected region % [Set displayName for APGAR 1 Minute Grimace here] off begin
				displayName: 'APGAR 1 Minute Grimace',
				// % protected region % [Set displayName for APGAR 1 Minute Grimace here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 1 Minute Grimace here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 1 Minute Grimace here] end
				// % protected region % [Set isSensitive for APGAR 1 Minute Grimace here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 1 Minute Grimace here] end
				// % protected region % [Set readonly for APGAR 1 Minute Grimace here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 1 Minute Grimace here] end
				validators: [
					// % protected region % [Add other validators for APGAR 1 Minute Grimace here] off begin
					// % protected region % [Add other validators for APGAR 1 Minute Grimace here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Grimace here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Grimace here] end
			},
			{
				name: 'apgar5MinuteGrimace',
				// % protected region % [Set displayName for APGAR 5 Minute Grimace here] off begin
				displayName: 'APGAR 5 Minute Grimace',
				// % protected region % [Set displayName for APGAR 5 Minute Grimace here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 5 Minute Grimace here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 5 Minute Grimace here] end
				// % protected region % [Set isSensitive for APGAR 5 Minute Grimace here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 5 Minute Grimace here] end
				// % protected region % [Set readonly for APGAR 5 Minute Grimace here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 5 Minute Grimace here] end
				validators: [
					// % protected region % [Add other validators for APGAR 5 Minute Grimace here] off begin
					// % protected region % [Add other validators for APGAR 5 Minute Grimace here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Grimace here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Grimace here] end
			},
			{
				name: 'apgar10MinuteGrimace',
				// % protected region % [Set displayName for APGAR 10 Minute Grimace here] off begin
				displayName: 'APGAR 10 Minute Grimace',
				// % protected region % [Set displayName for APGAR 10 Minute Grimace here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 10 Minute Grimace here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 10 Minute Grimace here] end
				// % protected region % [Set isSensitive for APGAR 10 Minute Grimace here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 10 Minute Grimace here] end
				// % protected region % [Set readonly for APGAR 10 Minute Grimace here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 10 Minute Grimace here] end
				validators: [
					// % protected region % [Add other validators for APGAR 10 Minute Grimace here] off begin
					// % protected region % [Add other validators for APGAR 10 Minute Grimace here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Grimace here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Grimace here] end
			},
			{
				name: 'apgar1MinuteActivity',
				// % protected region % [Set displayName for APGAR 1 Minute Activity here] off begin
				displayName: 'APGAR 1 Minute Activity',
				// % protected region % [Set displayName for APGAR 1 Minute Activity here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 1 Minute Activity here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 1 Minute Activity here] end
				// % protected region % [Set isSensitive for APGAR 1 Minute Activity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 1 Minute Activity here] end
				// % protected region % [Set readonly for APGAR 1 Minute Activity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 1 Minute Activity here] end
				validators: [
					// % protected region % [Add other validators for APGAR 1 Minute Activity here] off begin
					// % protected region % [Add other validators for APGAR 1 Minute Activity here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Activity here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Activity here] end
			},
			{
				name: 'apgar5MinuteActivity',
				// % protected region % [Set displayName for APGAR 5 Minute Activity here] off begin
				displayName: 'APGAR 5 Minute Activity',
				// % protected region % [Set displayName for APGAR 5 Minute Activity here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 5 Minute Activity here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 5 Minute Activity here] end
				// % protected region % [Set isSensitive for APGAR 5 Minute Activity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 5 Minute Activity here] end
				// % protected region % [Set readonly for APGAR 5 Minute Activity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 5 Minute Activity here] end
				validators: [
					// % protected region % [Add other validators for APGAR 5 Minute Activity here] off begin
					// % protected region % [Add other validators for APGAR 5 Minute Activity here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Activity here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Activity here] end
			},
			{
				name: 'apgar10MinuteActivity',
				// % protected region % [Set displayName for APGAR 10 Minute Activity here] off begin
				displayName: 'APGAR 10 Minute Activity',
				// % protected region % [Set displayName for APGAR 10 Minute Activity here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 10 Minute Activity here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 10 Minute Activity here] end
				// % protected region % [Set isSensitive for APGAR 10 Minute Activity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 10 Minute Activity here] end
				// % protected region % [Set readonly for APGAR 10 Minute Activity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 10 Minute Activity here] end
				validators: [
					// % protected region % [Add other validators for APGAR 10 Minute Activity here] off begin
					// % protected region % [Add other validators for APGAR 10 Minute Activity here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Activity here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Activity here] end
			},
			{
				name: 'apgar1MinuteRespiration',
				// % protected region % [Set displayName for APGAR 1 Minute Respiration here] off begin
				displayName: 'APGAR 1 Minute Respiration',
				// % protected region % [Set displayName for APGAR 1 Minute Respiration here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 1 Minute Respiration here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 1 Minute Respiration here] end
				// % protected region % [Set isSensitive for APGAR 1 Minute Respiration here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 1 Minute Respiration here] end
				// % protected region % [Set readonly for APGAR 1 Minute Respiration here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 1 Minute Respiration here] end
				validators: [
					// % protected region % [Add other validators for APGAR 1 Minute Respiration here] off begin
					// % protected region % [Add other validators for APGAR 1 Minute Respiration here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Respiration here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Respiration here] end
			},
			{
				name: 'apgar5MinuteRespiration',
				// % protected region % [Set displayName for APGAR 5 Minute Respiration here] off begin
				displayName: 'APGAR 5 Minute Respiration',
				// % protected region % [Set displayName for APGAR 5 Minute Respiration here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 5 Minute Respiration here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 5 Minute Respiration here] end
				// % protected region % [Set isSensitive for APGAR 5 Minute Respiration here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 5 Minute Respiration here] end
				// % protected region % [Set readonly for APGAR 5 Minute Respiration here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 5 Minute Respiration here] end
				validators: [
					// % protected region % [Add other validators for APGAR 5 Minute Respiration here] off begin
					// % protected region % [Add other validators for APGAR 5 Minute Respiration here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Respiration here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Respiration here] end
			},
			{
				name: 'apgar10MinuteRespiration',
				// % protected region % [Set displayName for APGAR 10 Minute Respiration here] off begin
				displayName: 'APGAR 10 Minute Respiration',
				// % protected region % [Set displayName for APGAR 10 Minute Respiration here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 10 Minute Respiration here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 10 Minute Respiration here] end
				// % protected region % [Set isSensitive for APGAR 10 Minute Respiration here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 10 Minute Respiration here] end
				// % protected region % [Set readonly for APGAR 10 Minute Respiration here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 10 Minute Respiration here] end
				validators: [
					// % protected region % [Add other validators for APGAR 10 Minute Respiration here] off begin
					// % protected region % [Add other validators for APGAR 10 Minute Respiration here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Respiration here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Respiration here] end
			},
			{
				name: 'apgar1MinuteScore',
				// % protected region % [Set displayName for APGAR 1 Minute Score here] off begin
				displayName: 'APGAR 1 Minute Score',
				// % protected region % [Set displayName for APGAR 1 Minute Score here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 1 Minute Score here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 1 Minute Score here] end
				// % protected region % [Set isSensitive for APGAR 1 Minute Score here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 1 Minute Score here] end
				// % protected region % [Set readonly for APGAR 1 Minute Score here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 1 Minute Score here] end
				validators: [
					// % protected region % [Add other validators for APGAR 1 Minute Score here] off begin
					// % protected region % [Add other validators for APGAR 1 Minute Score here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Score here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 1 Minute Score here] end
			},
			{
				name: 'apgar5MinuteScore',
				// % protected region % [Set displayName for APGAR 5 Minute Score here] off begin
				displayName: 'APGAR 5 Minute Score',
				// % protected region % [Set displayName for APGAR 5 Minute Score here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 5 Minute Score here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 5 Minute Score here] end
				// % protected region % [Set isSensitive for APGAR 5 Minute Score here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 5 Minute Score here] end
				// % protected region % [Set readonly for APGAR 5 Minute Score here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 5 Minute Score here] end
				validators: [
					// % protected region % [Add other validators for APGAR 5 Minute Score here] off begin
					// % protected region % [Add other validators for APGAR 5 Minute Score here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Score here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 5 Minute Score here] end
			},
			{
				name: 'apgar10MinuteScore',
				// % protected region % [Set displayName for APGAR 10 Minute Score here] off begin
				displayName: 'APGAR 10 Minute Score',
				// % protected region % [Set displayName for APGAR 10 Minute Score here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for APGAR 10 Minute Score here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for APGAR 10 Minute Score here] end
				// % protected region % [Set isSensitive for APGAR 10 Minute Score here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for APGAR 10 Minute Score here] end
				// % protected region % [Set readonly for APGAR 10 Minute Score here] off begin
				readOnly: false,
				// % protected region % [Set readonly for APGAR 10 Minute Score here] end
				validators: [
					// % protected region % [Add other validators for APGAR 10 Minute Score here] off begin
					// % protected region % [Add other validators for APGAR 10 Minute Score here] end
				],
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Score here] off begin
				// % protected region % [Add any additional model attribute properties for APGAR 10 Minute Score here] end
			},
			{
				name: 'pediatricNurse',
				// % protected region % [Set displayName for Pediatric Nurse here] off begin
				displayName: 'Pediatric Nurse',
				// % protected region % [Set displayName for Pediatric Nurse here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pediatric Nurse here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pediatric Nurse here] end
				// % protected region % [Set isSensitive for Pediatric Nurse here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pediatric Nurse here] end
				// % protected region % [Set readonly for Pediatric Nurse here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pediatric Nurse here] end
				validators: [
					// % protected region % [Add other validators for Pediatric Nurse here] off begin
					// % protected region % [Add other validators for Pediatric Nurse here] end
				],
				// % protected region % [Add any additional model attribute properties for Pediatric Nurse here] off begin
				// % protected region % [Add any additional model attribute properties for Pediatric Nurse here] end
			},
			{
				name: 'patientId',
				// % protected region % [Set displayName for Patient Id here] off begin
				displayName: 'Patient Id',
				// % protected region % [Set displayName for Patient Id here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient Id here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient Id here] end
				// % protected region % [Set isSensitive for Patient Id here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Id here] end
				// % protected region % [Set readonly for Patient Id here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Id here] end
				validators: [
					// % protected region % [Add other validators for Patient Id here] off begin
					// % protected region % [Add other validators for Patient Id here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Id here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Id here] end
			},
			{
				name: 'registrationId',
				// % protected region % [Set displayName for Registration Id here] off begin
				displayName: 'Registration Id',
				// % protected region % [Set displayName for Registration Id here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Registration Id here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Registration Id here] end
				// % protected region % [Set isSensitive for Registration Id here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Registration Id here] end
				// % protected region % [Set readonly for Registration Id here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Registration Id here] end
				validators: [
					// % protected region % [Add other validators for Registration Id here] off begin
					// % protected region % [Add other validators for Registration Id here] end
				],
				// % protected region % [Add any additional model attribute properties for Registration Id here] off begin
				// % protected region % [Add any additional model attribute properties for Registration Id here] end
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
				id: 'vitalSigns',
				type: ModelRelationType.MANY,
				name: 'vitalSignsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Vital Signs here] off begin
				label: 'Vital Signs',
				// % protected region % [Customise your 1-1 or 1-M label for Vital Signs here] end
				entityName: 'VitalSignsModel',
				// % protected region % [Customise your display name for Vital Signs here] off begin
				displayName: 'time',
				// % protected region % [Customise your display name for Vital Signs here] end
				validators: [
					// % protected region % [Add other validators for Vital Signs here] off begin
					// % protected region % [Add other validators for Vital Signs here] end
				],
				// % protected region % [Add any additional field for relation Vital Signs here] off begin
				// % protected region % [Add any additional field for relation Vital Signs here] end
			},
			{
				id: 'deliveryMedicalExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'deliveryMedicalExaminationRecordId',
				// % protected region % [Customise your label for Delivery Medical Examination Record here] off begin
				label: 'Delivery Medical Examination Record',
				// % protected region % [Customise your label for Delivery Medical Examination Record here] end
				entityName: 'DeliveryMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Delivery Medical Examination Record here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'pregnancyHistoryGravida',
				// % protected region % [Customise your display name for Delivery Medical Examination Record here] end
				validators: [
					// % protected region % [Add other validators for Delivery Medical Examination Record here] off begin
					// % protected region % [Add other validators for Delivery Medical Examination Record here] end
				],
				// % protected region % [Add any additional field for relation Delivery Medical Examination Record here] off begin
				// % protected region % [Add any additional field for relation Delivery Medical Examination Record here] end
			},
			{
				id: 'staff',
				type: ModelRelationType.ONE,
				name: 'staffId',
				// % protected region % [Customise your label for Staff here] off begin
				label: 'Staff',
				// % protected region % [Customise your label for Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Staff here] end
				validators: [
					// % protected region % [Add other validators for Staff here] off begin
					// % protected region % [Add other validators for Staff here] end
				],
				// % protected region % [Add any additional field for relation Staff here] off begin
				// % protected region % [Add any additional field for relation Staff here] end
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
				case 'newbornFirstName':
					break;
				case 'newbornLastName':
					break;
				case 'dateTimeOfBirth':
					break;
				case 'gender':
					break;
				case 'deliveryType':
					break;
				case 'deliveryTypeIndication':
					break;
				case 'weight':
					break;
				case 'length':
					break;
				case 'weightOfGestationalAge':
					break;
				case 'headCircumference':
					break;
				case 'chestCircumference':
					break;
				case 'birthCondition':
					break;
				case 'neonatalCase':
					break;
				case 'congenitalCondition':
					break;
				case 'physicalExamination':
					break;
				case 'apgar1MinuteAppearance':
					break;
				case 'apgar5MinuteAppearance':
					break;
				case 'apgar10MinuteAppearance':
					break;
				case 'apgar1MinutePulse':
					break;
				case 'apgar5MinutePulse':
					break;
				case 'apgar10MinutePulse':
					break;
				case 'apgar1MinuteGrimace':
					break;
				case 'apgar5MinuteGrimace':
					break;
				case 'apgar10MinuteGrimace':
					break;
				case 'apgar1MinuteActivity':
					break;
				case 'apgar5MinuteActivity':
					break;
				case 'apgar10MinuteActivity':
					break;
				case 'apgar1MinuteRespiration':
					break;
				case 'apgar5MinuteRespiration':
					break;
				case 'apgar10MinuteRespiration':
					break;
				case 'apgar1MinuteScore':
					break;
				case 'apgar5MinuteScore':
					break;
				case 'apgar10MinuteScore':
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
	static deepParse(data: string | { [K in keyof NewbornDetailModel]?: NewbornDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new NewbornDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.deliveryMedicalExaminationRecord) {
			currentModel.deliveryMedicalExaminationRecordId = json.deliveryMedicalExaminationRecord.id;
			returned = _.union(returned, DeliveryMedicalExaminationRecordModel.deepParse(json.deliveryMedicalExaminationRecord));
		}

		// Incoming one to many
		if (json.staff) {
			currentModel.staffId = json.staff.id;
			returned = _.union(returned, StaffModel.deepParse(json.staff));
		}

		// Outgoing one to many
		if (json.vitalSigns) {
			currentModel.vitalSignsIds = json.vitalSigns.map(model => model.id);
			returned = _.union(returned, _.flatten(json.vitalSigns.map(model => VitalSignsModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let newbornDetailModel = new NewbornDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the NewbornDetailModel,
	 *    it is expected as a JSON string or as a nullable NewbornDetailModel.
	 */
	constructor(data?: string | Partial<NewbornDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<NewbornDetailModel>
				: data;

			this.newbornFirstName = json.newbornFirstName;
			this.newbornLastName = json.newbornLastName;
			if (json.dateTimeOfBirth) {
				this.dateTimeOfBirth = new Date(json.dateTimeOfBirth);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dateTimeOfBirth = json.dateTimeOfBirth;
			}
			this.gender = json.gender;
			this.deliveryType = json.deliveryType;
			this.deliveryTypeIndication = json.deliveryTypeIndication;
			this.weight = json.weight;
			this.length = json.length;
			this.weightOfGestationalAge = json.weightOfGestationalAge;
			this.headCircumference = json.headCircumference;
			this.chestCircumference = json.chestCircumference;
			this.birthCondition = json.birthCondition;
			this.neonatalCase = json.neonatalCase;
			this.congenitalCondition = json.congenitalCondition;
			this.physicalExamination = json.physicalExamination;
			this.apgar1MinuteAppearance = json.apgar1MinuteAppearance;
			this.apgar5MinuteAppearance = json.apgar5MinuteAppearance;
			this.apgar10MinuteAppearance = json.apgar10MinuteAppearance;
			this.apgar1MinutePulse = json.apgar1MinutePulse;
			this.apgar5MinutePulse = json.apgar5MinutePulse;
			this.apgar10MinutePulse = json.apgar10MinutePulse;
			this.apgar1MinuteGrimace = json.apgar1MinuteGrimace;
			this.apgar5MinuteGrimace = json.apgar5MinuteGrimace;
			this.apgar10MinuteGrimace = json.apgar10MinuteGrimace;
			this.apgar1MinuteActivity = json.apgar1MinuteActivity;
			this.apgar5MinuteActivity = json.apgar5MinuteActivity;
			this.apgar10MinuteActivity = json.apgar10MinuteActivity;
			this.apgar1MinuteRespiration = json.apgar1MinuteRespiration;
			this.apgar5MinuteRespiration = json.apgar5MinuteRespiration;
			this.apgar10MinuteRespiration = json.apgar10MinuteRespiration;
			this.apgar1MinuteScore = json.apgar1MinuteScore;
			this.apgar5MinuteScore = json.apgar5MinuteScore;
			this.apgar10MinuteScore = json.apgar10MinuteScore;
			this.pediatricNurse = json.pediatricNurse;
			this.patientId = json.patientId;
			this.registrationId = json.registrationId;
			this.deliveryMedicalExaminationRecordId = json.deliveryMedicalExaminationRecordId;
			this.deliveryMedicalExaminationRecord = json.deliveryMedicalExaminationRecord;
			this.staffId = json.staffId;
			this.staff = json.staff;
			this.vitalSignsIds = json.vitalSignsIds;
			this.vitalSigns = json.vitalSigns;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			newbornFirstName: this.newbornFirstName,
			newbornLastName: this.newbornLastName,
			dateTimeOfBirth: this.dateTimeOfBirth,
			gender: this.gender,
			deliveryType: this.deliveryType,
			deliveryTypeIndication: this.deliveryTypeIndication,
			weight: this.weight,
			length: this.length,
			weightOfGestationalAge: this.weightOfGestationalAge,
			headCircumference: this.headCircumference,
			chestCircumference: this.chestCircumference,
			birthCondition: this.birthCondition,
			neonatalCase: this.neonatalCase,
			congenitalCondition: this.congenitalCondition,
			physicalExamination: this.physicalExamination,
			apgar1MinuteAppearance: this.apgar1MinuteAppearance,
			apgar5MinuteAppearance: this.apgar5MinuteAppearance,
			apgar10MinuteAppearance: this.apgar10MinuteAppearance,
			apgar1MinutePulse: this.apgar1MinutePulse,
			apgar5MinutePulse: this.apgar5MinutePulse,
			apgar10MinutePulse: this.apgar10MinutePulse,
			apgar1MinuteGrimace: this.apgar1MinuteGrimace,
			apgar5MinuteGrimace: this.apgar5MinuteGrimace,
			apgar10MinuteGrimace: this.apgar10MinuteGrimace,
			apgar1MinuteActivity: this.apgar1MinuteActivity,
			apgar5MinuteActivity: this.apgar5MinuteActivity,
			apgar10MinuteActivity: this.apgar10MinuteActivity,
			apgar1MinuteRespiration: this.apgar1MinuteRespiration,
			apgar5MinuteRespiration: this.apgar5MinuteRespiration,
			apgar10MinuteRespiration: this.apgar10MinuteRespiration,
			apgar1MinuteScore: this.apgar1MinuteScore,
			apgar5MinuteScore: this.apgar5MinuteScore,
			apgar10MinuteScore: this.apgar10MinuteScore,
			pediatricNurse: this.pediatricNurse,
			patientId: this.patientId,
			registrationId: this.registrationId,
			deliveryMedicalExaminationRecordId: this.deliveryMedicalExaminationRecordId,
			staffId: this.staffId,
			vitalSignsIds: this.vitalSignsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		NewbornDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): NewbornDetailModel {
		let newModelJson = this.toJSON();

		if (updates.newbornFirstName) {
			newModelJson.newbornFirstName = updates.newbornFirstName;
		}

		if (updates.newbornLastName) {
			newModelJson.newbornLastName = updates.newbornLastName;
		}

		if (updates.dateTimeOfBirth) {
			newModelJson.dateTimeOfBirth = updates.dateTimeOfBirth;
		}

		if (updates.gender) {
			newModelJson.gender = updates.gender;
		}

		if (updates.deliveryType) {
			newModelJson.deliveryType = updates.deliveryType;
		}

		if (updates.deliveryTypeIndication) {
			newModelJson.deliveryTypeIndication = updates.deliveryTypeIndication;
		}

		if (updates.weight) {
			newModelJson.weight = updates.weight;
		}

		if (updates.length) {
			newModelJson.length = updates.length;
		}

		if (updates.weightOfGestationalAge) {
			newModelJson.weightOfGestationalAge = updates.weightOfGestationalAge;
		}

		if (updates.headCircumference) {
			newModelJson.headCircumference = updates.headCircumference;
		}

		if (updates.chestCircumference) {
			newModelJson.chestCircumference = updates.chestCircumference;
		}

		if (updates.birthCondition) {
			newModelJson.birthCondition = updates.birthCondition;
		}

		if (updates.neonatalCase) {
			newModelJson.neonatalCase = updates.neonatalCase;
		}

		if (updates.congenitalCondition) {
			newModelJson.congenitalCondition = updates.congenitalCondition;
		}

		if (updates.physicalExamination) {
			newModelJson.physicalExamination = updates.physicalExamination;
		}

		if (updates.apgar1MinuteAppearance) {
			newModelJson.apgar1MinuteAppearance = updates.apgar1MinuteAppearance;
		}

		if (updates.apgar5MinuteAppearance) {
			newModelJson.apgar5MinuteAppearance = updates.apgar5MinuteAppearance;
		}

		if (updates.apgar10MinuteAppearance) {
			newModelJson.apgar10MinuteAppearance = updates.apgar10MinuteAppearance;
		}

		if (updates.apgar1MinutePulse) {
			newModelJson.apgar1MinutePulse = updates.apgar1MinutePulse;
		}

		if (updates.apgar5MinutePulse) {
			newModelJson.apgar5MinutePulse = updates.apgar5MinutePulse;
		}

		if (updates.apgar10MinutePulse) {
			newModelJson.apgar10MinutePulse = updates.apgar10MinutePulse;
		}

		if (updates.apgar1MinuteGrimace) {
			newModelJson.apgar1MinuteGrimace = updates.apgar1MinuteGrimace;
		}

		if (updates.apgar5MinuteGrimace) {
			newModelJson.apgar5MinuteGrimace = updates.apgar5MinuteGrimace;
		}

		if (updates.apgar10MinuteGrimace) {
			newModelJson.apgar10MinuteGrimace = updates.apgar10MinuteGrimace;
		}

		if (updates.apgar1MinuteActivity) {
			newModelJson.apgar1MinuteActivity = updates.apgar1MinuteActivity;
		}

		if (updates.apgar5MinuteActivity) {
			newModelJson.apgar5MinuteActivity = updates.apgar5MinuteActivity;
		}

		if (updates.apgar10MinuteActivity) {
			newModelJson.apgar10MinuteActivity = updates.apgar10MinuteActivity;
		}

		if (updates.apgar1MinuteRespiration) {
			newModelJson.apgar1MinuteRespiration = updates.apgar1MinuteRespiration;
		}

		if (updates.apgar5MinuteRespiration) {
			newModelJson.apgar5MinuteRespiration = updates.apgar5MinuteRespiration;
		}

		if (updates.apgar10MinuteRespiration) {
			newModelJson.apgar10MinuteRespiration = updates.apgar10MinuteRespiration;
		}

		if (updates.apgar1MinuteScore) {
			newModelJson.apgar1MinuteScore = updates.apgar1MinuteScore;
		}

		if (updates.apgar5MinuteScore) {
			newModelJson.apgar5MinuteScore = updates.apgar5MinuteScore;
		}

		if (updates.apgar10MinuteScore) {
			newModelJson.apgar10MinuteScore = updates.apgar10MinuteScore;
		}

		if (updates.pediatricNurse) {
			newModelJson.pediatricNurse = updates.pediatricNurse;
		}

		if (updates.patientId) {
			newModelJson.patientId = updates.patientId;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.deliveryMedicalExaminationRecordId) {
			newModelJson.deliveryMedicalExaminationRecordId = updates.deliveryMedicalExaminationRecordId;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		if (updates.vitalSignsIds) {
			newModelJson.vitalSignsIds = updates.vitalSignsIds;
		}

		return new NewbornDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof NewbornDetailModel)) {
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
			'deliveryMedicalExaminationRecordId',
			'deliveryMedicalExaminationRecord',
			'staffId',
			'staff',
			'vitalSignsIds',
			'vitalSigns',
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
		if (!this.deliveryMedicalExaminationRecord) {
			this.deliveryMedicalExaminationRecordId = null;
		} else {
			this.deliveryMedicalExaminationRecordId = this.deliveryMedicalExaminationRecord.id;
		}

		if (!this.staff) {
			this.staffId = null;
		} else {
			this.staffId = this.staff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
