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
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class DeliveryProgressModel extends AbstractModel {
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
		'progressDateTime',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'DeliveryProgressModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return DeliveryProgressModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	progressDateTime: Date;

	/**
	 * Fetal Heart Rate per minute.
	 */
	fhrPerMinute: number;

	/**
	 * .
	 */
	amnioticFluid: string;

	/**
	 * .
	 */
	moulding: string;

	/**
	 * .
	 */
	cervicalDilatation: number;

	/**
	 * .
	 */
	fetalHeadDescent: string;

	/**
	 * .
	 */
	contractionQty: number;

	/**
	 * .
	 */
	contractionMins: string;

	/**
	 * .
	 */
	dripStrength: number;

	/**
	 * .
	 */
	dripNumber: number;

	/**
	 * .
	 */
	drugIV: string;

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
	pulse: number;

	/**
	 * .
	 */
	temperature: number;

	/**
	 * .
	 */
	temperatureUnit: string;

	/**
	 * .
	 */
	urineProtein: string;

	/**
	 * .
	 */
	urineAcetone: string;

	/**
	 * .
	 */
	urineVolume: number;

	/**
	 * .
	 */
	progressNotes: string;

	deliveryMedicalExaminationRecordId: string;

	deliveryMedicalExaminationRecord: DeliveryMedicalExaminationRecordModel;

	staffId: string;

	staff: StaffModel;

	modelPropGroups: { [s: string]: Group } = DeliveryProgressModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'progressDateTime',
				// % protected region % [Set displayName for Progress Date Time here] off begin
				displayName: 'Progress Date Time',
				// % protected region % [Set displayName for Progress Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Progress Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Progress Date Time here] end
				// % protected region % [Set isSensitive for Progress Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Progress Date Time here] end
				// % protected region % [Set readonly for Progress Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Progress Date Time here] end
				validators: [
					// % protected region % [Add other validators for Progress Date Time here] off begin
					// % protected region % [Add other validators for Progress Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Progress Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Progress Date Time here] end
			},
			{
				name: 'fhrPerMinute',
				// % protected region % [Set displayName for FHR Per Minute here] off begin
				displayName: 'FHR Per Minute',
				// % protected region % [Set displayName for FHR Per Minute here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for FHR Per Minute here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for FHR Per Minute here] end
				// % protected region % [Set isSensitive for FHR Per Minute here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for FHR Per Minute here] end
				// % protected region % [Set readonly for FHR Per Minute here] off begin
				readOnly: false,
				// % protected region % [Set readonly for FHR Per Minute here] end
				validators: [
					// % protected region % [Add other validators for FHR Per Minute here] off begin
					// % protected region % [Add other validators for FHR Per Minute here] end
				],
				// % protected region % [Add any additional model attribute properties for FHR Per Minute here] off begin
				// % protected region % [Add any additional model attribute properties for FHR Per Minute here] end
			},
			{
				name: 'amnioticFluid',
				// % protected region % [Set displayName for Amniotic Fluid here] off begin
				displayName: 'Amniotic Fluid',
				// % protected region % [Set displayName for Amniotic Fluid here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Amniotic Fluid here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Amniotic Fluid here] end
				// % protected region % [Set isSensitive for Amniotic Fluid here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Amniotic Fluid here] end
				// % protected region % [Set readonly for Amniotic Fluid here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Amniotic Fluid here] end
				validators: [
					// % protected region % [Add other validators for Amniotic Fluid here] off begin
					// % protected region % [Add other validators for Amniotic Fluid here] end
				],
				// % protected region % [Add any additional model attribute properties for Amniotic Fluid here] off begin
				// % protected region % [Add any additional model attribute properties for Amniotic Fluid here] end
			},
			{
				name: 'moulding',
				// % protected region % [Set displayName for Moulding here] off begin
				displayName: 'Moulding',
				// % protected region % [Set displayName for Moulding here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Moulding here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Moulding here] end
				// % protected region % [Set isSensitive for Moulding here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Moulding here] end
				// % protected region % [Set readonly for Moulding here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Moulding here] end
				validators: [
					// % protected region % [Add other validators for Moulding here] off begin
					// % protected region % [Add other validators for Moulding here] end
				],
				// % protected region % [Add any additional model attribute properties for Moulding here] off begin
				// % protected region % [Add any additional model attribute properties for Moulding here] end
			},
			{
				name: 'cervicalDilatation',
				// % protected region % [Set displayName for Cervical Dilatation here] off begin
				displayName: 'Cervical Dilatation',
				// % protected region % [Set displayName for Cervical Dilatation here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Cervical Dilatation here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Cervical Dilatation here] end
				// % protected region % [Set isSensitive for Cervical Dilatation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Cervical Dilatation here] end
				// % protected region % [Set readonly for Cervical Dilatation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Cervical Dilatation here] end
				validators: [
					// % protected region % [Add other validators for Cervical Dilatation here] off begin
					// % protected region % [Add other validators for Cervical Dilatation here] end
				],
				// % protected region % [Add any additional model attribute properties for Cervical Dilatation here] off begin
				// % protected region % [Add any additional model attribute properties for Cervical Dilatation here] end
			},
			{
				name: 'fetalHeadDescent',
				// % protected region % [Set displayName for Fetal Head Descent here] off begin
				displayName: 'Fetal Head Descent',
				// % protected region % [Set displayName for Fetal Head Descent here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Fetal Head Descent here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Fetal Head Descent here] end
				// % protected region % [Set isSensitive for Fetal Head Descent here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Fetal Head Descent here] end
				// % protected region % [Set readonly for Fetal Head Descent here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Fetal Head Descent here] end
				validators: [
					// % protected region % [Add other validators for Fetal Head Descent here] off begin
					// % protected region % [Add other validators for Fetal Head Descent here] end
				],
				// % protected region % [Add any additional model attribute properties for Fetal Head Descent here] off begin
				// % protected region % [Add any additional model attribute properties for Fetal Head Descent here] end
			},
			{
				name: 'contractionQty',
				// % protected region % [Set displayName for Contraction Qty here] off begin
				displayName: 'Contraction Qty',
				// % protected region % [Set displayName for Contraction Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Contraction Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Contraction Qty here] end
				// % protected region % [Set isSensitive for Contraction Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Contraction Qty here] end
				// % protected region % [Set readonly for Contraction Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Contraction Qty here] end
				validators: [
					// % protected region % [Add other validators for Contraction Qty here] off begin
					// % protected region % [Add other validators for Contraction Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Contraction Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Contraction Qty here] end
			},
			{
				name: 'contractionMins',
				// % protected region % [Set displayName for Contraction Mins here] off begin
				displayName: 'Contraction Mins',
				// % protected region % [Set displayName for Contraction Mins here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Contraction Mins here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Contraction Mins here] end
				// % protected region % [Set isSensitive for Contraction Mins here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Contraction Mins here] end
				// % protected region % [Set readonly for Contraction Mins here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Contraction Mins here] end
				validators: [
					// % protected region % [Add other validators for Contraction Mins here] off begin
					// % protected region % [Add other validators for Contraction Mins here] end
				],
				// % protected region % [Add any additional model attribute properties for Contraction Mins here] off begin
				// % protected region % [Add any additional model attribute properties for Contraction Mins here] end
			},
			{
				name: 'dripStrength',
				// % protected region % [Set displayName for Drip Strength here] off begin
				displayName: 'Drip Strength',
				// % protected region % [Set displayName for Drip Strength here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Drip Strength here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Drip Strength here] end
				// % protected region % [Set isSensitive for Drip Strength here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Drip Strength here] end
				// % protected region % [Set readonly for Drip Strength here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Drip Strength here] end
				validators: [
					// % protected region % [Add other validators for Drip Strength here] off begin
					// % protected region % [Add other validators for Drip Strength here] end
				],
				// % protected region % [Add any additional model attribute properties for Drip Strength here] off begin
				// % protected region % [Add any additional model attribute properties for Drip Strength here] end
			},
			{
				name: 'dripNumber',
				// % protected region % [Set displayName for Drip Number here] off begin
				displayName: 'Drip Number',
				// % protected region % [Set displayName for Drip Number here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Drip Number here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Drip Number here] end
				// % protected region % [Set isSensitive for Drip Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Drip Number here] end
				// % protected region % [Set readonly for Drip Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Drip Number here] end
				validators: [
					// % protected region % [Add other validators for Drip Number here] off begin
					// % protected region % [Add other validators for Drip Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Drip Number here] off begin
				// % protected region % [Add any additional model attribute properties for Drip Number here] end
			},
			{
				name: 'drugIV',
				// % protected region % [Set displayName for Drug IV here] off begin
				displayName: 'Drug IV',
				// % protected region % [Set displayName for Drug IV here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Drug IV here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Drug IV here] end
				// % protected region % [Set isSensitive for Drug IV here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Drug IV here] end
				// % protected region % [Set readonly for Drug IV here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Drug IV here] end
				validators: [
					// % protected region % [Add other validators for Drug IV here] off begin
					// % protected region % [Add other validators for Drug IV here] end
				],
				// % protected region % [Add any additional model attribute properties for Drug IV here] off begin
				// % protected region % [Add any additional model attribute properties for Drug IV here] end
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
				name: 'temperatureUnit',
				// % protected region % [Set displayName for Temperature Unit here] off begin
				displayName: 'Temperature Unit',
				// % protected region % [Set displayName for Temperature Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Temperature Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Temperature Unit here] end
				// % protected region % [Set isSensitive for Temperature Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Temperature Unit here] end
				// % protected region % [Set readonly for Temperature Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Temperature Unit here] end
				validators: [
					// % protected region % [Add other validators for Temperature Unit here] off begin
					// % protected region % [Add other validators for Temperature Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Temperature Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Temperature Unit here] end
			},
			{
				name: 'urineProtein',
				// % protected region % [Set displayName for Urine Protein here] off begin
				displayName: 'Urine Protein',
				// % protected region % [Set displayName for Urine Protein here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Urine Protein here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Urine Protein here] end
				// % protected region % [Set isSensitive for Urine Protein here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Urine Protein here] end
				// % protected region % [Set readonly for Urine Protein here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Urine Protein here] end
				validators: [
					// % protected region % [Add other validators for Urine Protein here] off begin
					// % protected region % [Add other validators for Urine Protein here] end
				],
				// % protected region % [Add any additional model attribute properties for Urine Protein here] off begin
				// % protected region % [Add any additional model attribute properties for Urine Protein here] end
			},
			{
				name: 'urineAcetone',
				// % protected region % [Set displayName for Urine Acetone here] off begin
				displayName: 'Urine Acetone',
				// % protected region % [Set displayName for Urine Acetone here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Urine Acetone here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Urine Acetone here] end
				// % protected region % [Set isSensitive for Urine Acetone here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Urine Acetone here] end
				// % protected region % [Set readonly for Urine Acetone here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Urine Acetone here] end
				validators: [
					// % protected region % [Add other validators for Urine Acetone here] off begin
					// % protected region % [Add other validators for Urine Acetone here] end
				],
				// % protected region % [Add any additional model attribute properties for Urine Acetone here] off begin
				// % protected region % [Add any additional model attribute properties for Urine Acetone here] end
			},
			{
				name: 'urineVolume',
				// % protected region % [Set displayName for Urine Volume here] off begin
				displayName: 'Urine Volume',
				// % protected region % [Set displayName for Urine Volume here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Urine Volume here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Urine Volume here] end
				// % protected region % [Set isSensitive for Urine Volume here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Urine Volume here] end
				// % protected region % [Set readonly for Urine Volume here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Urine Volume here] end
				validators: [
					// % protected region % [Add other validators for Urine Volume here] off begin
					// % protected region % [Add other validators for Urine Volume here] end
				],
				// % protected region % [Add any additional model attribute properties for Urine Volume here] off begin
				// % protected region % [Add any additional model attribute properties for Urine Volume here] end
			},
			{
				name: 'progressNotes',
				// % protected region % [Set displayName for Progress Notes here] off begin
				displayName: 'Progress Notes',
				// % protected region % [Set displayName for Progress Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Progress Notes here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Progress Notes here] end
				// % protected region % [Set isSensitive for Progress Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Progress Notes here] end
				// % protected region % [Set readonly for Progress Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Progress Notes here] end
				validators: [
					// % protected region % [Add other validators for Progress Notes here] off begin
					// % protected region % [Add other validators for Progress Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Progress Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Progress Notes here] end
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
	static deepParse(data: string | { [K in keyof DeliveryProgressModel]?: DeliveryProgressModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new DeliveryProgressModel(data);
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


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let deliveryProgressModel = new DeliveryProgressModel(data);`
	 *
	 * @param data The input data to be initialised as the DeliveryProgressModel,
	 *    it is expected as a JSON string or as a nullable DeliveryProgressModel.
	 */
	constructor(data?: string | Partial<DeliveryProgressModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<DeliveryProgressModel>
				: data;

			if (json.progressDateTime) {
				this.progressDateTime = new Date(json.progressDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.progressDateTime = json.progressDateTime;
			}
			this.fhrPerMinute = json.fhrPerMinute;
			this.amnioticFluid = json.amnioticFluid;
			this.moulding = json.moulding;
			this.cervicalDilatation = json.cervicalDilatation;
			this.fetalHeadDescent = json.fetalHeadDescent;
			this.contractionQty = json.contractionQty;
			this.contractionMins = json.contractionMins;
			this.dripStrength = json.dripStrength;
			this.dripNumber = json.dripNumber;
			this.drugIV = json.drugIV;
			this.systole = json.systole;
			this.diastole = json.diastole;
			this.pulse = json.pulse;
			this.temperature = json.temperature;
			this.temperatureUnit = json.temperatureUnit;
			this.urineProtein = json.urineProtein;
			this.urineAcetone = json.urineAcetone;
			this.urineVolume = json.urineVolume;
			this.progressNotes = json.progressNotes;
			this.deliveryMedicalExaminationRecordId = json.deliveryMedicalExaminationRecordId;
			this.deliveryMedicalExaminationRecord = json.deliveryMedicalExaminationRecord;
			this.staffId = json.staffId;
			this.staff = json.staff;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			progressDateTime: this.progressDateTime,
			fhrPerMinute: this.fhrPerMinute,
			amnioticFluid: this.amnioticFluid,
			moulding: this.moulding,
			cervicalDilatation: this.cervicalDilatation,
			fetalHeadDescent: this.fetalHeadDescent,
			contractionQty: this.contractionQty,
			contractionMins: this.contractionMins,
			dripStrength: this.dripStrength,
			dripNumber: this.dripNumber,
			drugIV: this.drugIV,
			systole: this.systole,
			diastole: this.diastole,
			pulse: this.pulse,
			temperature: this.temperature,
			temperatureUnit: this.temperatureUnit,
			urineProtein: this.urineProtein,
			urineAcetone: this.urineAcetone,
			urineVolume: this.urineVolume,
			progressNotes: this.progressNotes,
			deliveryMedicalExaminationRecordId: this.deliveryMedicalExaminationRecordId,
			staffId: this.staffId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		DeliveryProgressModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): DeliveryProgressModel {
		let newModelJson = this.toJSON();

		if (updates.progressDateTime) {
			newModelJson.progressDateTime = updates.progressDateTime;
		}

		if (updates.fhrPerMinute) {
			newModelJson.fhrPerMinute = updates.fhrPerMinute;
		}

		if (updates.amnioticFluid) {
			newModelJson.amnioticFluid = updates.amnioticFluid;
		}

		if (updates.moulding) {
			newModelJson.moulding = updates.moulding;
		}

		if (updates.cervicalDilatation) {
			newModelJson.cervicalDilatation = updates.cervicalDilatation;
		}

		if (updates.fetalHeadDescent) {
			newModelJson.fetalHeadDescent = updates.fetalHeadDescent;
		}

		if (updates.contractionQty) {
			newModelJson.contractionQty = updates.contractionQty;
		}

		if (updates.contractionMins) {
			newModelJson.contractionMins = updates.contractionMins;
		}

		if (updates.dripStrength) {
			newModelJson.dripStrength = updates.dripStrength;
		}

		if (updates.dripNumber) {
			newModelJson.dripNumber = updates.dripNumber;
		}

		if (updates.drugIV) {
			newModelJson.drugIV = updates.drugIV;
		}

		if (updates.systole) {
			newModelJson.systole = updates.systole;
		}

		if (updates.diastole) {
			newModelJson.diastole = updates.diastole;
		}

		if (updates.pulse) {
			newModelJson.pulse = updates.pulse;
		}

		if (updates.temperature) {
			newModelJson.temperature = updates.temperature;
		}

		if (updates.temperatureUnit) {
			newModelJson.temperatureUnit = updates.temperatureUnit;
		}

		if (updates.urineProtein) {
			newModelJson.urineProtein = updates.urineProtein;
		}

		if (updates.urineAcetone) {
			newModelJson.urineAcetone = updates.urineAcetone;
		}

		if (updates.urineVolume) {
			newModelJson.urineVolume = updates.urineVolume;
		}

		if (updates.progressNotes) {
			newModelJson.progressNotes = updates.progressNotes;
		}

		if (updates.deliveryMedicalExaminationRecordId) {
			newModelJson.deliveryMedicalExaminationRecordId = updates.deliveryMedicalExaminationRecordId;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		return new DeliveryProgressModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof DeliveryProgressModel)) {
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
