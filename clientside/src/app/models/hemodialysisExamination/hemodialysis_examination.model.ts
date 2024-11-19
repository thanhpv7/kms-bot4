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
import {HemodialysisMonitoringModel} from '../hemodialysisMonitoring/hemodialysis_monitoring.model';
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
export class HemodialysisExaminationModel extends AbstractModel {
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
		'firstDialysis',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'HemodialysisExaminationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return HemodialysisExaminationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	firstDialysis: Date;

	/**
	 * .
	 */
	dialysisFrequency: string;

	/**
	 * .
	 */
	dialysisNo: string;

	/**
	 * A drop-down based on the reference HEMODIALYSIS_TYPE.
	 */
	hemodialysisType: string;

	/**
	 * A drop-down based on the reference HEMODIALYSIS_CONDITION.
	 */
	condition: string;

	/**
	 * A drop-down based on the reference VASC_ACCESS.
	 */
	vascularAccess: string;

	/**
	 * A drop-down based on the reference HEPARINIZATION.
	 */
	heparinization: string;

	/**
	 * .
	 */
	heparinizationInitialDose: string;

	/**
	 * .
	 */
	heparinizationFollowUpDose: string;

	/**
	 * .
	 */
	dialyzer: string;

	/**
	 * .
	 */
	dialyzerType: string;

	/**
	 * A drop-down based on the reference DIALYSATE.
	 */
	dialysisFluid: string;

	/**
	 * .
	 */
	dryWeight: number;

	/**
	 * .
	 */
	dryWeightUnit: string;

	/**
	 * .
	 */
	weightUponArrival: number;

	/**
	 * .
	 */
	weightUponArrivalUnit: string;

	/**
	 * .
	 */
	weightDuringPreviousHemodialysis: number;

	/**
	 * .
	 */
	weightDuringPreviousHemodialysisUnit: string;

	/**
	 * .
	 */
	antiHIV: boolean = false;

	/**
	 * .
	 */
	hbsag: boolean = false;

	/**
	 * .
	 */
	antiHCV: boolean = false;

	/**
	 * .
	 */
	hemodialysisStartTime: Date;

	/**
	 * .
	 */
	hemodialysisEndTime: Date;

	/**
	 * .
	 */
	target: string;

	/**
	 * .
	 */
	primingVolume: string;

	/**
	 * .
	 */
	remainingPriming: string;

	/**
	 * A drop-down based on the reference HEMODIALYSIS_COMPLICATION.
	 */
	complication: string;

	/**
	 * .
	 */
	hemodialysisDetails: string;

	/**
	 * .
	 */
	weightUponDismissal: number;

	/**
	 * .
	 */
	weightUponDismissalUnit: string;

	/**
	 * .
	 */
	priming: number;

	/**
	 * .
	 */
	blood: number;

	/**
	 * .
	 */
	ivLine: number;

	/**
	 * .
	 */
	oral: number;

	/**
	 * .
	 */
	washOut: number;

	/**
	 * .
	 */
	totalFluidIntake: number;

	/**
	 * .
	 */
	urine: number;

	/**
	 * .
	 */
	others: number;

	/**
	 * .
	 */
	totalFluidOutput: number;

	/**
	 * .
	 */
	fluidBalance: number;

	/**
	 * .
	 */
	postHemodialysisEvaluation: string;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	hemodialysisMonitoringsIds: string[] = [];

	hemodialysisMonitorings: HemodialysisMonitoringModel[];

	modelPropGroups: { [s: string]: Group } = HemodialysisExaminationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'firstDialysis',
				// % protected region % [Set displayName for First Dialysis here] off begin
				displayName: 'First Dialysis',
				// % protected region % [Set displayName for First Dialysis here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for First Dialysis here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for First Dialysis here] end
				// % protected region % [Set isSensitive for First Dialysis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for First Dialysis here] end
				// % protected region % [Set readonly for First Dialysis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for First Dialysis here] end
				validators: [
					// % protected region % [Add other validators for First Dialysis here] off begin
					// % protected region % [Add other validators for First Dialysis here] end
				],
				// % protected region % [Add any additional model attribute properties for First Dialysis here] off begin
				// % protected region % [Add any additional model attribute properties for First Dialysis here] end
			},
			{
				name: 'dialysisFrequency',
				// % protected region % [Set displayName for Dialysis Frequency here] off begin
				displayName: 'Dialysis Frequency',
				// % protected region % [Set displayName for Dialysis Frequency here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dialysis Frequency here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dialysis Frequency here] end
				// % protected region % [Set isSensitive for Dialysis Frequency here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dialysis Frequency here] end
				// % protected region % [Set readonly for Dialysis Frequency here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dialysis Frequency here] end
				validators: [
					// % protected region % [Add other validators for Dialysis Frequency here] off begin
					// % protected region % [Add other validators for Dialysis Frequency here] end
				],
				// % protected region % [Add any additional model attribute properties for Dialysis Frequency here] off begin
				// % protected region % [Add any additional model attribute properties for Dialysis Frequency here] end
			},
			{
				name: 'dialysisNo',
				// % protected region % [Set displayName for Dialysis No here] off begin
				displayName: 'Dialysis No',
				// % protected region % [Set displayName for Dialysis No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dialysis No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dialysis No here] end
				// % protected region % [Set isSensitive for Dialysis No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dialysis No here] end
				// % protected region % [Set readonly for Dialysis No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dialysis No here] end
				validators: [
					// % protected region % [Add other validators for Dialysis No here] off begin
					// % protected region % [Add other validators for Dialysis No here] end
				],
				// % protected region % [Add any additional model attribute properties for Dialysis No here] off begin
				// % protected region % [Add any additional model attribute properties for Dialysis No here] end
			},
			{
				name: 'hemodialysisType',
				// % protected region % [Set displayName for Hemodialysis Type here] off begin
				displayName: 'Hemodialysis Type',
				// % protected region % [Set displayName for Hemodialysis Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hemodialysis Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hemodialysis Type here] end
				// % protected region % [Set isSensitive for Hemodialysis Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hemodialysis Type here] end
				// % protected region % [Set readonly for Hemodialysis Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hemodialysis Type here] end
				validators: [
					// % protected region % [Add other validators for Hemodialysis Type here] off begin
					// % protected region % [Add other validators for Hemodialysis Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Hemodialysis Type here] off begin
				// % protected region % [Add any additional model attribute properties for Hemodialysis Type here] end
			},
			{
				name: 'condition',
				// % protected region % [Set displayName for Condition here] off begin
				displayName: 'Condition',
				// % protected region % [Set displayName for Condition here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Condition here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Condition here] end
				// % protected region % [Set isSensitive for Condition here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Condition here] end
				// % protected region % [Set readonly for Condition here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Condition here] end
				validators: [
					// % protected region % [Add other validators for Condition here] off begin
					// % protected region % [Add other validators for Condition here] end
				],
				// % protected region % [Add any additional model attribute properties for Condition here] off begin
				// % protected region % [Add any additional model attribute properties for Condition here] end
			},
			{
				name: 'vascularAccess',
				// % protected region % [Set displayName for Vascular Access here] off begin
				displayName: 'Vascular Access',
				// % protected region % [Set displayName for Vascular Access here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Vascular Access here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Vascular Access here] end
				// % protected region % [Set isSensitive for Vascular Access here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Vascular Access here] end
				// % protected region % [Set readonly for Vascular Access here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Vascular Access here] end
				validators: [
					// % protected region % [Add other validators for Vascular Access here] off begin
					// % protected region % [Add other validators for Vascular Access here] end
				],
				// % protected region % [Add any additional model attribute properties for Vascular Access here] off begin
				// % protected region % [Add any additional model attribute properties for Vascular Access here] end
			},
			{
				name: 'heparinization',
				// % protected region % [Set displayName for Heparinization here] off begin
				displayName: 'Heparinization',
				// % protected region % [Set displayName for Heparinization here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Heparinization here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Heparinization here] end
				// % protected region % [Set isSensitive for Heparinization here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Heparinization here] end
				// % protected region % [Set readonly for Heparinization here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Heparinization here] end
				validators: [
					// % protected region % [Add other validators for Heparinization here] off begin
					// % protected region % [Add other validators for Heparinization here] end
				],
				// % protected region % [Add any additional model attribute properties for Heparinization here] off begin
				// % protected region % [Add any additional model attribute properties for Heparinization here] end
			},
			{
				name: 'heparinizationInitialDose',
				// % protected region % [Set displayName for Heparinization Initial Dose here] off begin
				displayName: 'Heparinization Initial Dose',
				// % protected region % [Set displayName for Heparinization Initial Dose here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Heparinization Initial Dose here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Heparinization Initial Dose here] end
				// % protected region % [Set isSensitive for Heparinization Initial Dose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Heparinization Initial Dose here] end
				// % protected region % [Set readonly for Heparinization Initial Dose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Heparinization Initial Dose here] end
				validators: [
					// % protected region % [Add other validators for Heparinization Initial Dose here] off begin
					// % protected region % [Add other validators for Heparinization Initial Dose here] end
				],
				// % protected region % [Add any additional model attribute properties for Heparinization Initial Dose here] off begin
				// % protected region % [Add any additional model attribute properties for Heparinization Initial Dose here] end
			},
			{
				name: 'heparinizationFollowUpDose',
				// % protected region % [Set displayName for Heparinization Follow Up Dose here] off begin
				displayName: 'Heparinization Follow Up Dose',
				// % protected region % [Set displayName for Heparinization Follow Up Dose here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Heparinization Follow Up Dose here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Heparinization Follow Up Dose here] end
				// % protected region % [Set isSensitive for Heparinization Follow Up Dose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Heparinization Follow Up Dose here] end
				// % protected region % [Set readonly for Heparinization Follow Up Dose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Heparinization Follow Up Dose here] end
				validators: [
					// % protected region % [Add other validators for Heparinization Follow Up Dose here] off begin
					// % protected region % [Add other validators for Heparinization Follow Up Dose here] end
				],
				// % protected region % [Add any additional model attribute properties for Heparinization Follow Up Dose here] off begin
				// % protected region % [Add any additional model attribute properties for Heparinization Follow Up Dose here] end
			},
			{
				name: 'dialyzer',
				// % protected region % [Set displayName for Dialyzer here] off begin
				displayName: 'Dialyzer',
				// % protected region % [Set displayName for Dialyzer here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dialyzer here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dialyzer here] end
				// % protected region % [Set isSensitive for Dialyzer here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dialyzer here] end
				// % protected region % [Set readonly for Dialyzer here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dialyzer here] end
				validators: [
					// % protected region % [Add other validators for Dialyzer here] off begin
					// % protected region % [Add other validators for Dialyzer here] end
				],
				// % protected region % [Add any additional model attribute properties for Dialyzer here] off begin
				// % protected region % [Add any additional model attribute properties for Dialyzer here] end
			},
			{
				name: 'dialyzerType',
				// % protected region % [Set displayName for Dialyzer Type here] off begin
				displayName: 'Dialyzer Type',
				// % protected region % [Set displayName for Dialyzer Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dialyzer Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dialyzer Type here] end
				// % protected region % [Set isSensitive for Dialyzer Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dialyzer Type here] end
				// % protected region % [Set readonly for Dialyzer Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dialyzer Type here] end
				validators: [
					// % protected region % [Add other validators for Dialyzer Type here] off begin
					// % protected region % [Add other validators for Dialyzer Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Dialyzer Type here] off begin
				// % protected region % [Add any additional model attribute properties for Dialyzer Type here] end
			},
			{
				name: 'dialysisFluid',
				// % protected region % [Set displayName for Dialysis Fluid here] off begin
				displayName: 'Dialysis Fluid',
				// % protected region % [Set displayName for Dialysis Fluid here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dialysis Fluid here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dialysis Fluid here] end
				// % protected region % [Set isSensitive for Dialysis Fluid here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dialysis Fluid here] end
				// % protected region % [Set readonly for Dialysis Fluid here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dialysis Fluid here] end
				validators: [
					// % protected region % [Add other validators for Dialysis Fluid here] off begin
					// % protected region % [Add other validators for Dialysis Fluid here] end
				],
				// % protected region % [Add any additional model attribute properties for Dialysis Fluid here] off begin
				// % protected region % [Add any additional model attribute properties for Dialysis Fluid here] end
			},
			{
				name: 'dryWeight',
				// % protected region % [Set displayName for Dry Weight here] off begin
				displayName: 'Dry Weight',
				// % protected region % [Set displayName for Dry Weight here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Dry Weight here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Dry Weight here] end
				// % protected region % [Set isSensitive for Dry Weight here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dry Weight here] end
				// % protected region % [Set readonly for Dry Weight here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dry Weight here] end
				validators: [
					// % protected region % [Add other validators for Dry Weight here] off begin
					// % protected region % [Add other validators for Dry Weight here] end
				],
				// % protected region % [Add any additional model attribute properties for Dry Weight here] off begin
				// % protected region % [Add any additional model attribute properties for Dry Weight here] end
			},
			{
				name: 'dryWeightUnit',
				// % protected region % [Set displayName for Dry Weight Unit here] off begin
				displayName: 'Dry Weight Unit',
				// % protected region % [Set displayName for Dry Weight Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dry Weight Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dry Weight Unit here] end
				// % protected region % [Set isSensitive for Dry Weight Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dry Weight Unit here] end
				// % protected region % [Set readonly for Dry Weight Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dry Weight Unit here] end
				validators: [
					// % protected region % [Add other validators for Dry Weight Unit here] off begin
					// % protected region % [Add other validators for Dry Weight Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Dry Weight Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Dry Weight Unit here] end
			},
			{
				name: 'weightUponArrival',
				// % protected region % [Set displayName for Weight Upon Arrival here] off begin
				displayName: 'Weight Upon Arrival',
				// % protected region % [Set displayName for Weight Upon Arrival here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Weight Upon Arrival here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Weight Upon Arrival here] end
				// % protected region % [Set isSensitive for Weight Upon Arrival here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight Upon Arrival here] end
				// % protected region % [Set readonly for Weight Upon Arrival here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight Upon Arrival here] end
				validators: [
					// % protected region % [Add other validators for Weight Upon Arrival here] off begin
					// % protected region % [Add other validators for Weight Upon Arrival here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight Upon Arrival here] off begin
				// % protected region % [Add any additional model attribute properties for Weight Upon Arrival here] end
			},
			{
				name: 'weightUponArrivalUnit',
				// % protected region % [Set displayName for Weight Upon Arrival Unit here] off begin
				displayName: 'Weight Upon Arrival Unit',
				// % protected region % [Set displayName for Weight Upon Arrival Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Weight Upon Arrival Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Weight Upon Arrival Unit here] end
				// % protected region % [Set isSensitive for Weight Upon Arrival Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight Upon Arrival Unit here] end
				// % protected region % [Set readonly for Weight Upon Arrival Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight Upon Arrival Unit here] end
				validators: [
					// % protected region % [Add other validators for Weight Upon Arrival Unit here] off begin
					// % protected region % [Add other validators for Weight Upon Arrival Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight Upon Arrival Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Weight Upon Arrival Unit here] end
			},
			{
				name: 'weightDuringPreviousHemodialysis',
				// % protected region % [Set displayName for Weight During Previous Hemodialysis here] off begin
				displayName: 'Weight During Previous Hemodialysis',
				// % protected region % [Set displayName for Weight During Previous Hemodialysis here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Weight During Previous Hemodialysis here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Weight During Previous Hemodialysis here] end
				// % protected region % [Set isSensitive for Weight During Previous Hemodialysis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight During Previous Hemodialysis here] end
				// % protected region % [Set readonly for Weight During Previous Hemodialysis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight During Previous Hemodialysis here] end
				validators: [
					// % protected region % [Add other validators for Weight During Previous Hemodialysis here] off begin
					// % protected region % [Add other validators for Weight During Previous Hemodialysis here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight During Previous Hemodialysis here] off begin
				// % protected region % [Add any additional model attribute properties for Weight During Previous Hemodialysis here] end
			},
			{
				name: 'weightDuringPreviousHemodialysisUnit',
				// % protected region % [Set displayName for Weight During Previous Hemodialysis Unit here] off begin
				displayName: 'Weight During Previous Hemodialysis Unit',
				// % protected region % [Set displayName for Weight During Previous Hemodialysis Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Weight During Previous Hemodialysis Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Weight During Previous Hemodialysis Unit here] end
				// % protected region % [Set isSensitive for Weight During Previous Hemodialysis Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight During Previous Hemodialysis Unit here] end
				// % protected region % [Set readonly for Weight During Previous Hemodialysis Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight During Previous Hemodialysis Unit here] end
				validators: [
					// % protected region % [Add other validators for Weight During Previous Hemodialysis Unit here] off begin
					// % protected region % [Add other validators for Weight During Previous Hemodialysis Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight During Previous Hemodialysis Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Weight During Previous Hemodialysis Unit here] end
			},
			{
				name: 'antiHIV',
				// % protected region % [Set displayName for Anti HIV here] off begin
				displayName: 'Anti HIV',
				// % protected region % [Set displayName for Anti HIV here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Anti HIV here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Anti HIV here] end
				// % protected region % [Set isSensitive for Anti HIV here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anti HIV here] end
				// % protected region % [Set readonly for Anti HIV here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anti HIV here] end
				validators: [
					// % protected region % [Add other validators for Anti HIV here] off begin
					// % protected region % [Add other validators for Anti HIV here] end
				],
				// % protected region % [Add any additional model attribute properties for Anti HIV here] off begin
				// % protected region % [Add any additional model attribute properties for Anti HIV here] end
			},
			{
				name: 'hbsag',
				// % protected region % [Set displayName for HbsAg here] off begin
				displayName: 'HbsAg',
				// % protected region % [Set displayName for HbsAg here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for HbsAg here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for HbsAg here] end
				// % protected region % [Set isSensitive for HbsAg here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for HbsAg here] end
				// % protected region % [Set readonly for HbsAg here] off begin
				readOnly: false,
				// % protected region % [Set readonly for HbsAg here] end
				validators: [
					// % protected region % [Add other validators for HbsAg here] off begin
					// % protected region % [Add other validators for HbsAg here] end
				],
				// % protected region % [Add any additional model attribute properties for HbsAg here] off begin
				// % protected region % [Add any additional model attribute properties for HbsAg here] end
			},
			{
				name: 'antiHCV',
				// % protected region % [Set displayName for Anti HCV here] off begin
				displayName: 'Anti HCV',
				// % protected region % [Set displayName for Anti HCV here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Anti HCV here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Anti HCV here] end
				// % protected region % [Set isSensitive for Anti HCV here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anti HCV here] end
				// % protected region % [Set readonly for Anti HCV here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anti HCV here] end
				validators: [
					// % protected region % [Add other validators for Anti HCV here] off begin
					// % protected region % [Add other validators for Anti HCV here] end
				],
				// % protected region % [Add any additional model attribute properties for Anti HCV here] off begin
				// % protected region % [Add any additional model attribute properties for Anti HCV here] end
			},
			{
				name: 'hemodialysisStartTime',
				// % protected region % [Set displayName for Hemodialysis Start Time here] off begin
				displayName: 'Hemodialysis Start Time',
				// % protected region % [Set displayName for Hemodialysis Start Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Hemodialysis Start Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Hemodialysis Start Time here] end
				// % protected region % [Set isSensitive for Hemodialysis Start Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hemodialysis Start Time here] end
				// % protected region % [Set readonly for Hemodialysis Start Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hemodialysis Start Time here] end
				validators: [
					// % protected region % [Add other validators for Hemodialysis Start Time here] off begin
					// % protected region % [Add other validators for Hemodialysis Start Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Hemodialysis Start Time here] off begin
				// % protected region % [Add any additional model attribute properties for Hemodialysis Start Time here] end
			},
			{
				name: 'hemodialysisEndTime',
				// % protected region % [Set displayName for Hemodialysis End Time here] off begin
				displayName: 'Hemodialysis End Time',
				// % protected region % [Set displayName for Hemodialysis End Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Hemodialysis End Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Hemodialysis End Time here] end
				// % protected region % [Set isSensitive for Hemodialysis End Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hemodialysis End Time here] end
				// % protected region % [Set readonly for Hemodialysis End Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hemodialysis End Time here] end
				validators: [
					// % protected region % [Add other validators for Hemodialysis End Time here] off begin
					// % protected region % [Add other validators for Hemodialysis End Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Hemodialysis End Time here] off begin
				// % protected region % [Add any additional model attribute properties for Hemodialysis End Time here] end
			},
			{
				name: 'target',
				// % protected region % [Set displayName for Target here] off begin
				displayName: 'Target',
				// % protected region % [Set displayName for Target here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Target here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Target here] end
				// % protected region % [Set isSensitive for Target here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Target here] end
				// % protected region % [Set readonly for Target here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Target here] end
				validators: [
					// % protected region % [Add other validators for Target here] off begin
					// % protected region % [Add other validators for Target here] end
				],
				// % protected region % [Add any additional model attribute properties for Target here] off begin
				// % protected region % [Add any additional model attribute properties for Target here] end
			},
			{
				name: 'primingVolume',
				// % protected region % [Set displayName for Priming Volume here] off begin
				displayName: 'Priming Volume',
				// % protected region % [Set displayName for Priming Volume here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Priming Volume here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Priming Volume here] end
				// % protected region % [Set isSensitive for Priming Volume here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Priming Volume here] end
				// % protected region % [Set readonly for Priming Volume here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Priming Volume here] end
				validators: [
					// % protected region % [Add other validators for Priming Volume here] off begin
					// % protected region % [Add other validators for Priming Volume here] end
				],
				// % protected region % [Add any additional model attribute properties for Priming Volume here] off begin
				// % protected region % [Add any additional model attribute properties for Priming Volume here] end
			},
			{
				name: 'remainingPriming',
				// % protected region % [Set displayName for Remaining Priming here] off begin
				displayName: 'Remaining Priming',
				// % protected region % [Set displayName for Remaining Priming here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Remaining Priming here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Remaining Priming here] end
				// % protected region % [Set isSensitive for Remaining Priming here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Remaining Priming here] end
				// % protected region % [Set readonly for Remaining Priming here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Remaining Priming here] end
				validators: [
					// % protected region % [Add other validators for Remaining Priming here] off begin
					// % protected region % [Add other validators for Remaining Priming here] end
				],
				// % protected region % [Add any additional model attribute properties for Remaining Priming here] off begin
				// % protected region % [Add any additional model attribute properties for Remaining Priming here] end
			},
			{
				name: 'complication',
				// % protected region % [Set displayName for Complication here] off begin
				displayName: 'Complication',
				// % protected region % [Set displayName for Complication here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Complication here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Complication here] end
				// % protected region % [Set isSensitive for Complication here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Complication here] end
				// % protected region % [Set readonly for Complication here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Complication here] end
				validators: [
					// % protected region % [Add other validators for Complication here] off begin
					// % protected region % [Add other validators for Complication here] end
				],
				// % protected region % [Add any additional model attribute properties for Complication here] off begin
				// % protected region % [Add any additional model attribute properties for Complication here] end
			},
			{
				name: 'hemodialysisDetails',
				// % protected region % [Set displayName for Hemodialysis Details here] off begin
				displayName: 'Hemodialysis Details',
				// % protected region % [Set displayName for Hemodialysis Details here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hemodialysis Details here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hemodialysis Details here] end
				// % protected region % [Set isSensitive for Hemodialysis Details here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hemodialysis Details here] end
				// % protected region % [Set readonly for Hemodialysis Details here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hemodialysis Details here] end
				validators: [
					// % protected region % [Add other validators for Hemodialysis Details here] off begin
					// % protected region % [Add other validators for Hemodialysis Details here] end
				],
				// % protected region % [Add any additional model attribute properties for Hemodialysis Details here] off begin
				// % protected region % [Add any additional model attribute properties for Hemodialysis Details here] end
			},
			{
				name: 'weightUponDismissal',
				// % protected region % [Set displayName for Weight Upon Dismissal here] off begin
				displayName: 'Weight Upon Dismissal',
				// % protected region % [Set displayName for Weight Upon Dismissal here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Weight Upon Dismissal here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Weight Upon Dismissal here] end
				// % protected region % [Set isSensitive for Weight Upon Dismissal here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight Upon Dismissal here] end
				// % protected region % [Set readonly for Weight Upon Dismissal here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight Upon Dismissal here] end
				validators: [
					// % protected region % [Add other validators for Weight Upon Dismissal here] off begin
					// % protected region % [Add other validators for Weight Upon Dismissal here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight Upon Dismissal here] off begin
				// % protected region % [Add any additional model attribute properties for Weight Upon Dismissal here] end
			},
			{
				name: 'weightUponDismissalUnit',
				// % protected region % [Set displayName for Weight Upon Dismissal Unit here] off begin
				displayName: 'Weight Upon Dismissal Unit',
				// % protected region % [Set displayName for Weight Upon Dismissal Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Weight Upon Dismissal Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Weight Upon Dismissal Unit here] end
				// % protected region % [Set isSensitive for Weight Upon Dismissal Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight Upon Dismissal Unit here] end
				// % protected region % [Set readonly for Weight Upon Dismissal Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight Upon Dismissal Unit here] end
				validators: [
					// % protected region % [Add other validators for Weight Upon Dismissal Unit here] off begin
					// % protected region % [Add other validators for Weight Upon Dismissal Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight Upon Dismissal Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Weight Upon Dismissal Unit here] end
			},
			{
				name: 'priming',
				// % protected region % [Set displayName for Priming here] off begin
				displayName: 'Priming',
				// % protected region % [Set displayName for Priming here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Priming here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Priming here] end
				// % protected region % [Set isSensitive for Priming here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Priming here] end
				// % protected region % [Set readonly for Priming here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Priming here] end
				validators: [
					// % protected region % [Add other validators for Priming here] off begin
					// % protected region % [Add other validators for Priming here] end
				],
				// % protected region % [Add any additional model attribute properties for Priming here] off begin
				// % protected region % [Add any additional model attribute properties for Priming here] end
			},
			{
				name: 'blood',
				// % protected region % [Set displayName for Blood here] off begin
				displayName: 'Blood',
				// % protected region % [Set displayName for Blood here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Blood here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Blood here] end
				// % protected region % [Set isSensitive for Blood here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Blood here] end
				// % protected region % [Set readonly for Blood here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Blood here] end
				validators: [
					// % protected region % [Add other validators for Blood here] off begin
					// % protected region % [Add other validators for Blood here] end
				],
				// % protected region % [Add any additional model attribute properties for Blood here] off begin
				// % protected region % [Add any additional model attribute properties for Blood here] end
			},
			{
				name: 'ivLine',
				// % protected region % [Set displayName for IV Line here] off begin
				displayName: 'IV Line',
				// % protected region % [Set displayName for IV Line here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for IV Line here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for IV Line here] end
				// % protected region % [Set isSensitive for IV Line here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for IV Line here] end
				// % protected region % [Set readonly for IV Line here] off begin
				readOnly: false,
				// % protected region % [Set readonly for IV Line here] end
				validators: [
					// % protected region % [Add other validators for IV Line here] off begin
					// % protected region % [Add other validators for IV Line here] end
				],
				// % protected region % [Add any additional model attribute properties for IV Line here] off begin
				// % protected region % [Add any additional model attribute properties for IV Line here] end
			},
			{
				name: 'oral',
				// % protected region % [Set displayName for Oral here] off begin
				displayName: 'Oral',
				// % protected region % [Set displayName for Oral here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Oral here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Oral here] end
				// % protected region % [Set isSensitive for Oral here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Oral here] end
				// % protected region % [Set readonly for Oral here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Oral here] end
				validators: [
					// % protected region % [Add other validators for Oral here] off begin
					// % protected region % [Add other validators for Oral here] end
				],
				// % protected region % [Add any additional model attribute properties for Oral here] off begin
				// % protected region % [Add any additional model attribute properties for Oral here] end
			},
			{
				name: 'washOut',
				// % protected region % [Set displayName for Wash Out here] off begin
				displayName: 'Wash Out',
				// % protected region % [Set displayName for Wash Out here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Wash Out here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Wash Out here] end
				// % protected region % [Set isSensitive for Wash Out here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Wash Out here] end
				// % protected region % [Set readonly for Wash Out here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Wash Out here] end
				validators: [
					// % protected region % [Add other validators for Wash Out here] off begin
					// % protected region % [Add other validators for Wash Out here] end
				],
				// % protected region % [Add any additional model attribute properties for Wash Out here] off begin
				// % protected region % [Add any additional model attribute properties for Wash Out here] end
			},
			{
				name: 'totalFluidIntake',
				// % protected region % [Set displayName for Total Fluid Intake here] off begin
				displayName: 'Total Fluid Intake',
				// % protected region % [Set displayName for Total Fluid Intake here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Fluid Intake here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Fluid Intake here] end
				// % protected region % [Set isSensitive for Total Fluid Intake here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Fluid Intake here] end
				// % protected region % [Set readonly for Total Fluid Intake here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Fluid Intake here] end
				validators: [
					// % protected region % [Add other validators for Total Fluid Intake here] off begin
					// % protected region % [Add other validators for Total Fluid Intake here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Fluid Intake here] off begin
				// % protected region % [Add any additional model attribute properties for Total Fluid Intake here] end
			},
			{
				name: 'urine',
				// % protected region % [Set displayName for Urine here] off begin
				displayName: 'Urine',
				// % protected region % [Set displayName for Urine here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Urine here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Urine here] end
				// % protected region % [Set isSensitive for Urine here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Urine here] end
				// % protected region % [Set readonly for Urine here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Urine here] end
				validators: [
					// % protected region % [Add other validators for Urine here] off begin
					// % protected region % [Add other validators for Urine here] end
				],
				// % protected region % [Add any additional model attribute properties for Urine here] off begin
				// % protected region % [Add any additional model attribute properties for Urine here] end
			},
			{
				name: 'others',
				// % protected region % [Set displayName for Others here] off begin
				displayName: 'Others',
				// % protected region % [Set displayName for Others here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Others here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Others here] end
				// % protected region % [Set isSensitive for Others here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Others here] end
				// % protected region % [Set readonly for Others here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Others here] end
				validators: [
					// % protected region % [Add other validators for Others here] off begin
					// % protected region % [Add other validators for Others here] end
				],
				// % protected region % [Add any additional model attribute properties for Others here] off begin
				// % protected region % [Add any additional model attribute properties for Others here] end
			},
			{
				name: 'totalFluidOutput',
				// % protected region % [Set displayName for Total Fluid Output here] off begin
				displayName: 'Total Fluid Output',
				// % protected region % [Set displayName for Total Fluid Output here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Fluid Output here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Fluid Output here] end
				// % protected region % [Set isSensitive for Total Fluid Output here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Fluid Output here] end
				// % protected region % [Set readonly for Total Fluid Output here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Fluid Output here] end
				validators: [
					// % protected region % [Add other validators for Total Fluid Output here] off begin
					// % protected region % [Add other validators for Total Fluid Output here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Fluid Output here] off begin
				// % protected region % [Add any additional model attribute properties for Total Fluid Output here] end
			},
			{
				name: 'fluidBalance',
				// % protected region % [Set displayName for Fluid Balance here] off begin
				displayName: 'Fluid Balance',
				// % protected region % [Set displayName for Fluid Balance here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Fluid Balance here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Fluid Balance here] end
				// % protected region % [Set isSensitive for Fluid Balance here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Fluid Balance here] end
				// % protected region % [Set readonly for Fluid Balance here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Fluid Balance here] end
				validators: [
					// % protected region % [Add other validators for Fluid Balance here] off begin
					// % protected region % [Add other validators for Fluid Balance here] end
				],
				// % protected region % [Add any additional model attribute properties for Fluid Balance here] off begin
				// % protected region % [Add any additional model attribute properties for Fluid Balance here] end
			},
			{
				name: 'postHemodialysisEvaluation',
				// % protected region % [Set displayName for Post Hemodialysis Evaluation here] off begin
				displayName: 'Post Hemodialysis Evaluation',
				// % protected region % [Set displayName for Post Hemodialysis Evaluation here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Post Hemodialysis Evaluation here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Post Hemodialysis Evaluation here] end
				// % protected region % [Set isSensitive for Post Hemodialysis Evaluation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Post Hemodialysis Evaluation here] end
				// % protected region % [Set readonly for Post Hemodialysis Evaluation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Post Hemodialysis Evaluation here] end
				validators: [
					Validators.maxLength(500),
					// % protected region % [Add other validators for Post Hemodialysis Evaluation here] off begin
					// % protected region % [Add other validators for Post Hemodialysis Evaluation here] end
				],
				// % protected region % [Add any additional model attribute properties for Post Hemodialysis Evaluation here] off begin
				// % protected region % [Add any additional model attribute properties for Post Hemodialysis Evaluation here] end
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
				id: 'hemodialysisMonitorings',
				type: ModelRelationType.MANY,
				name: 'hemodialysisMonitoringsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Hemodialysis Monitorings here] off begin
				label: 'Hemodialysis Monitorings',
				// % protected region % [Customise your 1-1 or 1-M label for Hemodialysis Monitorings here] end
				entityName: 'HemodialysisMonitoringModel',
				// % protected region % [Customise your display name for Hemodialysis Monitorings here] off begin
				displayName: 'datetime',
				// % protected region % [Customise your display name for Hemodialysis Monitorings here] end
				validators: [
					// % protected region % [Add other validators for Hemodialysis Monitorings here] off begin
					// % protected region % [Add other validators for Hemodialysis Monitorings here] end
				],
				// % protected region % [Add any additional field for relation Hemodialysis Monitorings here] off begin
				// % protected region % [Add any additional field for relation Hemodialysis Monitorings here] end
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
	static deepParse(data: string | { [K in keyof HemodialysisExaminationModel]?: HemodialysisExaminationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new HemodialysisExaminationModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.medicalExaminationRecord) {
			currentModel.medicalExaminationRecordId = json.medicalExaminationRecord.id;
			returned = _.union(returned, MedicalExaminationRecordModel.deepParse(json.medicalExaminationRecord));
		}

		// Outgoing one to many
		if (json.hemodialysisMonitorings) {
			currentModel.hemodialysisMonitoringsIds = json.hemodialysisMonitorings.map(model => model.id);
			returned = _.union(returned, _.flatten(json.hemodialysisMonitorings.map(model => HemodialysisMonitoringModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let hemodialysisExaminationModel = new HemodialysisExaminationModel(data);`
	 *
	 * @param data The input data to be initialised as the HemodialysisExaminationModel,
	 *    it is expected as a JSON string or as a nullable HemodialysisExaminationModel.
	 */
	constructor(data?: string | Partial<HemodialysisExaminationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<HemodialysisExaminationModel>
				: data;

			if (json.firstDialysis) {
				this.firstDialysis = new Date(json.firstDialysis);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.firstDialysis = json.firstDialysis;
			}
			this.dialysisFrequency = json.dialysisFrequency;
			this.dialysisNo = json.dialysisNo;
			this.hemodialysisType = json.hemodialysisType;
			this.condition = json.condition;
			this.vascularAccess = json.vascularAccess;
			this.heparinization = json.heparinization;
			this.heparinizationInitialDose = json.heparinizationInitialDose;
			this.heparinizationFollowUpDose = json.heparinizationFollowUpDose;
			this.dialyzer = json.dialyzer;
			this.dialyzerType = json.dialyzerType;
			this.dialysisFluid = json.dialysisFluid;
			this.dryWeight = json.dryWeight;
			this.dryWeightUnit = json.dryWeightUnit;
			this.weightUponArrival = json.weightUponArrival;
			this.weightUponArrivalUnit = json.weightUponArrivalUnit;
			this.weightDuringPreviousHemodialysis = json.weightDuringPreviousHemodialysis;
			this.weightDuringPreviousHemodialysisUnit = json.weightDuringPreviousHemodialysisUnit;
			this.antiHIV = json.antiHIV;
			this.hbsag = json.hbsag;
			this.antiHCV = json.antiHCV;
			if (json.hemodialysisStartTime) {
				this.hemodialysisStartTime = new Date(json.hemodialysisStartTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.hemodialysisStartTime = json.hemodialysisStartTime;
			}
			if (json.hemodialysisEndTime) {
				this.hemodialysisEndTime = new Date(json.hemodialysisEndTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.hemodialysisEndTime = json.hemodialysisEndTime;
			}
			this.target = json.target;
			this.primingVolume = json.primingVolume;
			this.remainingPriming = json.remainingPriming;
			this.complication = json.complication;
			this.hemodialysisDetails = json.hemodialysisDetails;
			this.weightUponDismissal = json.weightUponDismissal;
			this.weightUponDismissalUnit = json.weightUponDismissalUnit;
			this.priming = json.priming;
			this.blood = json.blood;
			this.ivLine = json.ivLine;
			this.oral = json.oral;
			this.washOut = json.washOut;
			this.totalFluidIntake = json.totalFluidIntake;
			this.urine = json.urine;
			this.others = json.others;
			this.totalFluidOutput = json.totalFluidOutput;
			this.fluidBalance = json.fluidBalance;
			this.postHemodialysisEvaluation = json.postHemodialysisEvaluation;
			this.medicalExaminationRecordId = json.medicalExaminationRecordId;
			this.medicalExaminationRecord = json.medicalExaminationRecord;
			this.hemodialysisMonitoringsIds = json.hemodialysisMonitoringsIds;
			this.hemodialysisMonitorings = json.hemodialysisMonitorings;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			firstDialysis: this.firstDialysis,
			dialysisFrequency: this.dialysisFrequency,
			dialysisNo: this.dialysisNo,
			hemodialysisType: this.hemodialysisType,
			condition: this.condition,
			vascularAccess: this.vascularAccess,
			heparinization: this.heparinization,
			heparinizationInitialDose: this.heparinizationInitialDose,
			heparinizationFollowUpDose: this.heparinizationFollowUpDose,
			dialyzer: this.dialyzer,
			dialyzerType: this.dialyzerType,
			dialysisFluid: this.dialysisFluid,
			dryWeight: this.dryWeight,
			dryWeightUnit: this.dryWeightUnit,
			weightUponArrival: this.weightUponArrival,
			weightUponArrivalUnit: this.weightUponArrivalUnit,
			weightDuringPreviousHemodialysis: this.weightDuringPreviousHemodialysis,
			weightDuringPreviousHemodialysisUnit: this.weightDuringPreviousHemodialysisUnit,
			antiHIV: this.antiHIV,
			hbsag: this.hbsag,
			antiHCV: this.antiHCV,
			hemodialysisStartTime: this.hemodialysisStartTime,
			hemodialysisEndTime: this.hemodialysisEndTime,
			target: this.target,
			primingVolume: this.primingVolume,
			remainingPriming: this.remainingPriming,
			complication: this.complication,
			hemodialysisDetails: this.hemodialysisDetails,
			weightUponDismissal: this.weightUponDismissal,
			weightUponDismissalUnit: this.weightUponDismissalUnit,
			priming: this.priming,
			blood: this.blood,
			ivLine: this.ivLine,
			oral: this.oral,
			washOut: this.washOut,
			totalFluidIntake: this.totalFluidIntake,
			urine: this.urine,
			others: this.others,
			totalFluidOutput: this.totalFluidOutput,
			fluidBalance: this.fluidBalance,
			postHemodialysisEvaluation: this.postHemodialysisEvaluation,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			hemodialysisMonitoringsIds: this.hemodialysisMonitoringsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		HemodialysisExaminationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): HemodialysisExaminationModel {
		let newModelJson = this.toJSON();

		if (updates.firstDialysis) {
			newModelJson.firstDialysis = updates.firstDialysis;
		}

		if (updates.dialysisFrequency) {
			newModelJson.dialysisFrequency = updates.dialysisFrequency;
		}

		if (updates.dialysisNo) {
			newModelJson.dialysisNo = updates.dialysisNo;
		}

		if (updates.hemodialysisType) {
			newModelJson.hemodialysisType = updates.hemodialysisType;
		}

		if (updates.condition) {
			newModelJson.condition = updates.condition;
		}

		if (updates.vascularAccess) {
			newModelJson.vascularAccess = updates.vascularAccess;
		}

		if (updates.heparinization) {
			newModelJson.heparinization = updates.heparinization;
		}

		if (updates.heparinizationInitialDose) {
			newModelJson.heparinizationInitialDose = updates.heparinizationInitialDose;
		}

		if (updates.heparinizationFollowUpDose) {
			newModelJson.heparinizationFollowUpDose = updates.heparinizationFollowUpDose;
		}

		if (updates.dialyzer) {
			newModelJson.dialyzer = updates.dialyzer;
		}

		if (updates.dialyzerType) {
			newModelJson.dialyzerType = updates.dialyzerType;
		}

		if (updates.dialysisFluid) {
			newModelJson.dialysisFluid = updates.dialysisFluid;
		}

		if (updates.dryWeight) {
			newModelJson.dryWeight = updates.dryWeight;
		}

		if (updates.dryWeightUnit) {
			newModelJson.dryWeightUnit = updates.dryWeightUnit;
		}

		if (updates.weightUponArrival) {
			newModelJson.weightUponArrival = updates.weightUponArrival;
		}

		if (updates.weightUponArrivalUnit) {
			newModelJson.weightUponArrivalUnit = updates.weightUponArrivalUnit;
		}

		if (updates.weightDuringPreviousHemodialysis) {
			newModelJson.weightDuringPreviousHemodialysis = updates.weightDuringPreviousHemodialysis;
		}

		if (updates.weightDuringPreviousHemodialysisUnit) {
			newModelJson.weightDuringPreviousHemodialysisUnit = updates.weightDuringPreviousHemodialysisUnit;
		}

		if (updates.antiHIV) {
			newModelJson.antiHIV = updates.antiHIV;
		}

		if (updates.hbsag) {
			newModelJson.hbsag = updates.hbsag;
		}

		if (updates.antiHCV) {
			newModelJson.antiHCV = updates.antiHCV;
		}

		if (updates.hemodialysisStartTime) {
			newModelJson.hemodialysisStartTime = updates.hemodialysisStartTime;
		}

		if (updates.hemodialysisEndTime) {
			newModelJson.hemodialysisEndTime = updates.hemodialysisEndTime;
		}

		if (updates.target) {
			newModelJson.target = updates.target;
		}

		if (updates.primingVolume) {
			newModelJson.primingVolume = updates.primingVolume;
		}

		if (updates.remainingPriming) {
			newModelJson.remainingPriming = updates.remainingPriming;
		}

		if (updates.complication) {
			newModelJson.complication = updates.complication;
		}

		if (updates.hemodialysisDetails) {
			newModelJson.hemodialysisDetails = updates.hemodialysisDetails;
		}

		if (updates.weightUponDismissal) {
			newModelJson.weightUponDismissal = updates.weightUponDismissal;
		}

		if (updates.weightUponDismissalUnit) {
			newModelJson.weightUponDismissalUnit = updates.weightUponDismissalUnit;
		}

		if (updates.priming) {
			newModelJson.priming = updates.priming;
		}

		if (updates.blood) {
			newModelJson.blood = updates.blood;
		}

		if (updates.ivLine) {
			newModelJson.ivLine = updates.ivLine;
		}

		if (updates.oral) {
			newModelJson.oral = updates.oral;
		}

		if (updates.washOut) {
			newModelJson.washOut = updates.washOut;
		}

		if (updates.totalFluidIntake) {
			newModelJson.totalFluidIntake = updates.totalFluidIntake;
		}

		if (updates.urine) {
			newModelJson.urine = updates.urine;
		}

		if (updates.others) {
			newModelJson.others = updates.others;
		}

		if (updates.totalFluidOutput) {
			newModelJson.totalFluidOutput = updates.totalFluidOutput;
		}

		if (updates.fluidBalance) {
			newModelJson.fluidBalance = updates.fluidBalance;
		}

		if (updates.postHemodialysisEvaluation) {
			newModelJson.postHemodialysisEvaluation = updates.postHemodialysisEvaluation;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		if (updates.hemodialysisMonitoringsIds) {
			newModelJson.hemodialysisMonitoringsIds = updates.hemodialysisMonitoringsIds;
		}

		return new HemodialysisExaminationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof HemodialysisExaminationModel)) {
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
			'hemodialysisMonitoringsIds',
			'hemodialysisMonitorings',
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
