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
export class ObstetricAndGynecologyHistoryModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'educationLevelOfHusbandOrWife',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'pregnancyHistoryGravida',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ObstetricAndGynecologyHistoryModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ObstetricAndGynecologyHistoryModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Pregnancy History Gravida.
	 */
	pregnancyHistoryGravida: string;

	/**
	 * Patient History Para.
	 */
	patientHistoryPara: string;

	/**
	 * Patient History Abortus.
	 */
	patientHistoryAbortus: string;

	/**
	 * Pregnancy History Notes.
	 */
	pregnancyHistoryNotes: string;

	/**
	 * Age of Menarche.
	 */
	ageOfMenarche: string;

	/**
	 * Age of First Sexual Contact.
	 */
	ageOfFirstSexualContact: string;

	/**
	 * Start Date.
	 */
	startDate: Date;

	/**
	 * End Date.
	 */
	endDate: Date;

	/**
	 * Approximate Birth Date.
	 */
	approximateBirthDate: Date;

	/**
	 * Gestation Age Weeks.
	 */
	gestationAgeWeeks: string;

	/**
	 * Gestation Age Days.
	 */
	gestationAgeDays: string;

	/**
	 * Maternity History.
	 */
	maternityHistory: string;

	/**
	 * Gynecology History.
	 */
	gynecologyHistory: string;

	/**
	 * Family Plan History.
	 */
	familyPlanHistory: string;

	/**
	 * Other Notes.
	 */
	otherNotes: string;

	/**
	 * Education Level of Patient.
	 */
	educationLevelOfPatient: string;

	/**
	 * Name of Husband or Wife.
	 */
	nameOfHusbandOrWife: string;

	/**
	 * Education Level of Husband or Wife.
	 */
	educationLevelOfHusbandOrWife: string;

	/**
	 * Occupation of Husband or Wife.
	 */
	occupationOfHusbandOrWife: string;

	/**
	 * .
	 */
	ruptureOfMembrane: Date;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	modelPropGroups: { [s: string]: Group } = ObstetricAndGynecologyHistoryModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'pregnancyHistoryGravida',
				// % protected region % [Set displayName for Pregnancy History Gravida here] off begin
				displayName: 'Pregnancy History Gravida',
				// % protected region % [Set displayName for Pregnancy History Gravida here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pregnancy History Gravida here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pregnancy History Gravida here] end
				// % protected region % [Set isSensitive for Pregnancy History Gravida here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pregnancy History Gravida here] end
				// % protected region % [Set readonly for Pregnancy History Gravida here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pregnancy History Gravida here] end
				validators: [
					// % protected region % [Add other validators for Pregnancy History Gravida here] off begin
					// % protected region % [Add other validators for Pregnancy History Gravida here] end
				],
				// % protected region % [Add any additional model attribute properties for Pregnancy History Gravida here] off begin
				// % protected region % [Add any additional model attribute properties for Pregnancy History Gravida here] end
			},
			{
				name: 'patientHistoryPara',
				// % protected region % [Set displayName for Patient History Para here] off begin
				displayName: 'Patient History Para',
				// % protected region % [Set displayName for Patient History Para here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient History Para here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient History Para here] end
				// % protected region % [Set isSensitive for Patient History Para here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient History Para here] end
				// % protected region % [Set readonly for Patient History Para here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient History Para here] end
				validators: [
					// % protected region % [Add other validators for Patient History Para here] off begin
					// % protected region % [Add other validators for Patient History Para here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient History Para here] off begin
				// % protected region % [Add any additional model attribute properties for Patient History Para here] end
			},
			{
				name: 'patientHistoryAbortus',
				// % protected region % [Set displayName for Patient History Abortus here] off begin
				displayName: 'Patient History Abortus',
				// % protected region % [Set displayName for Patient History Abortus here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient History Abortus here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient History Abortus here] end
				// % protected region % [Set isSensitive for Patient History Abortus here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient History Abortus here] end
				// % protected region % [Set readonly for Patient History Abortus here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient History Abortus here] end
				validators: [
					// % protected region % [Add other validators for Patient History Abortus here] off begin
					// % protected region % [Add other validators for Patient History Abortus here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient History Abortus here] off begin
				// % protected region % [Add any additional model attribute properties for Patient History Abortus here] end
			},
			{
				name: 'pregnancyHistoryNotes',
				// % protected region % [Set displayName for Pregnancy History Notes here] off begin
				displayName: 'Pregnancy History Notes',
				// % protected region % [Set displayName for Pregnancy History Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pregnancy History Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pregnancy History Notes here] end
				// % protected region % [Set isSensitive for Pregnancy History Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pregnancy History Notes here] end
				// % protected region % [Set readonly for Pregnancy History Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pregnancy History Notes here] end
				validators: [
					// % protected region % [Add other validators for Pregnancy History Notes here] off begin
					// % protected region % [Add other validators for Pregnancy History Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Pregnancy History Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Pregnancy History Notes here] end
			},
			{
				name: 'ageOfMenarche',
				// % protected region % [Set displayName for Age of Menarche here] off begin
				displayName: 'Age of Menarche',
				// % protected region % [Set displayName for Age of Menarche here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Age of Menarche here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Age of Menarche here] end
				// % protected region % [Set isSensitive for Age of Menarche here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Age of Menarche here] end
				// % protected region % [Set readonly for Age of Menarche here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Age of Menarche here] end
				validators: [
					// % protected region % [Add other validators for Age of Menarche here] off begin
					// % protected region % [Add other validators for Age of Menarche here] end
				],
				// % protected region % [Add any additional model attribute properties for Age of Menarche here] off begin
				// % protected region % [Add any additional model attribute properties for Age of Menarche here] end
			},
			{
				name: 'ageOfFirstSexualContact',
				// % protected region % [Set displayName for Age of First Sexual Contact here] off begin
				displayName: 'Age of First Sexual Contact',
				// % protected region % [Set displayName for Age of First Sexual Contact here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Age of First Sexual Contact here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Age of First Sexual Contact here] end
				// % protected region % [Set isSensitive for Age of First Sexual Contact here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Age of First Sexual Contact here] end
				// % protected region % [Set readonly for Age of First Sexual Contact here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Age of First Sexual Contact here] end
				validators: [
					// % protected region % [Add other validators for Age of First Sexual Contact here] off begin
					// % protected region % [Add other validators for Age of First Sexual Contact here] end
				],
				// % protected region % [Add any additional model attribute properties for Age of First Sexual Contact here] off begin
				// % protected region % [Add any additional model attribute properties for Age of First Sexual Contact here] end
			},
			{
				name: 'startDate',
				// % protected region % [Set displayName for Start Date here] off begin
				displayName: 'Start Date',
				// % protected region % [Set displayName for Start Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Start Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Start Date here] end
				// % protected region % [Set isSensitive for Start Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Start Date here] end
				// % protected region % [Set readonly for Start Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Start Date here] end
				validators: [
					// % protected region % [Add other validators for Start Date here] off begin
					// % protected region % [Add other validators for Start Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Start Date here] off begin
				// % protected region % [Add any additional model attribute properties for Start Date here] end
			},
			{
				name: 'endDate',
				// % protected region % [Set displayName for End Date here] off begin
				displayName: 'End Date',
				// % protected region % [Set displayName for End Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for End Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for End Date here] end
				// % protected region % [Set isSensitive for End Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for End Date here] end
				// % protected region % [Set readonly for End Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for End Date here] end
				validators: [
					// % protected region % [Add other validators for End Date here] off begin
					// % protected region % [Add other validators for End Date here] end
				],
				// % protected region % [Add any additional model attribute properties for End Date here] off begin
				// % protected region % [Add any additional model attribute properties for End Date here] end
			},
			{
				name: 'approximateBirthDate',
				// % protected region % [Set displayName for Approximate Birth Date here] off begin
				displayName: 'Approximate Birth Date',
				// % protected region % [Set displayName for Approximate Birth Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Approximate Birth Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Approximate Birth Date here] end
				// % protected region % [Set isSensitive for Approximate Birth Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approximate Birth Date here] end
				// % protected region % [Set readonly for Approximate Birth Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approximate Birth Date here] end
				validators: [
					// % protected region % [Add other validators for Approximate Birth Date here] off begin
					// % protected region % [Add other validators for Approximate Birth Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Approximate Birth Date here] off begin
				// % protected region % [Add any additional model attribute properties for Approximate Birth Date here] end
			},
			{
				name: 'gestationAgeWeeks',
				// % protected region % [Set displayName for Gestation Age Weeks here] off begin
				displayName: 'Gestation Age Weeks',
				// % protected region % [Set displayName for Gestation Age Weeks here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gestation Age Weeks here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gestation Age Weeks here] end
				// % protected region % [Set isSensitive for Gestation Age Weeks here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gestation Age Weeks here] end
				// % protected region % [Set readonly for Gestation Age Weeks here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gestation Age Weeks here] end
				validators: [
					// % protected region % [Add other validators for Gestation Age Weeks here] off begin
					// % protected region % [Add other validators for Gestation Age Weeks here] end
				],
				// % protected region % [Add any additional model attribute properties for Gestation Age Weeks here] off begin
				// % protected region % [Add any additional model attribute properties for Gestation Age Weeks here] end
			},
			{
				name: 'gestationAgeDays',
				// % protected region % [Set displayName for Gestation Age Days here] off begin
				displayName: 'Gestation Age Days',
				// % protected region % [Set displayName for Gestation Age Days here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gestation Age Days here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gestation Age Days here] end
				// % protected region % [Set isSensitive for Gestation Age Days here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gestation Age Days here] end
				// % protected region % [Set readonly for Gestation Age Days here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gestation Age Days here] end
				validators: [
					// % protected region % [Add other validators for Gestation Age Days here] off begin
					// % protected region % [Add other validators for Gestation Age Days here] end
				],
				// % protected region % [Add any additional model attribute properties for Gestation Age Days here] off begin
				// % protected region % [Add any additional model attribute properties for Gestation Age Days here] end
			},
			{
				name: 'maternityHistory',
				// % protected region % [Set displayName for Maternity History here] off begin
				displayName: 'Maternity History',
				// % protected region % [Set displayName for Maternity History here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Maternity History here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Maternity History here] end
				// % protected region % [Set isSensitive for Maternity History here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Maternity History here] end
				// % protected region % [Set readonly for Maternity History here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Maternity History here] end
				validators: [
					// % protected region % [Add other validators for Maternity History here] off begin
					// % protected region % [Add other validators for Maternity History here] end
				],
				// % protected region % [Add any additional model attribute properties for Maternity History here] off begin
				// % protected region % [Add any additional model attribute properties for Maternity History here] end
			},
			{
				name: 'gynecologyHistory',
				// % protected region % [Set displayName for Gynecology History here] off begin
				displayName: 'Gynecology History',
				// % protected region % [Set displayName for Gynecology History here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gynecology History here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gynecology History here] end
				// % protected region % [Set isSensitive for Gynecology History here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gynecology History here] end
				// % protected region % [Set readonly for Gynecology History here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gynecology History here] end
				validators: [
					// % protected region % [Add other validators for Gynecology History here] off begin
					// % protected region % [Add other validators for Gynecology History here] end
				],
				// % protected region % [Add any additional model attribute properties for Gynecology History here] off begin
				// % protected region % [Add any additional model attribute properties for Gynecology History here] end
			},
			{
				name: 'familyPlanHistory',
				// % protected region % [Set displayName for Family Plan History here] off begin
				displayName: 'Family Plan History',
				// % protected region % [Set displayName for Family Plan History here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Family Plan History here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Family Plan History here] end
				// % protected region % [Set isSensitive for Family Plan History here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Family Plan History here] end
				// % protected region % [Set readonly for Family Plan History here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Family Plan History here] end
				validators: [
					// % protected region % [Add other validators for Family Plan History here] off begin
					// % protected region % [Add other validators for Family Plan History here] end
				],
				// % protected region % [Add any additional model attribute properties for Family Plan History here] off begin
				// % protected region % [Add any additional model attribute properties for Family Plan History here] end
			},
			{
				name: 'otherNotes',
				// % protected region % [Set displayName for Other Notes here] off begin
				displayName: 'Other Notes',
				// % protected region % [Set displayName for Other Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Other Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Other Notes here] end
				// % protected region % [Set isSensitive for Other Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Notes here] end
				// % protected region % [Set readonly for Other Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Notes here] end
				validators: [
					// % protected region % [Add other validators for Other Notes here] off begin
					// % protected region % [Add other validators for Other Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Other Notes here] end
			},
			{
				name: 'educationLevelOfPatient',
				// % protected region % [Set displayName for Education Level of Patient here] off begin
				displayName: 'Education Level of Patient',
				// % protected region % [Set displayName for Education Level of Patient here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Education Level of Patient here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Education Level of Patient here] end
				// % protected region % [Set isSensitive for Education Level of Patient here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Education Level of Patient here] end
				// % protected region % [Set readonly for Education Level of Patient here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Education Level of Patient here] end
				validators: [
					// % protected region % [Add other validators for Education Level of Patient here] off begin
					// % protected region % [Add other validators for Education Level of Patient here] end
				],
				// % protected region % [Add any additional model attribute properties for Education Level of Patient here] off begin
				// % protected region % [Add any additional model attribute properties for Education Level of Patient here] end
			},
			{
				name: 'nameOfHusbandOrWife',
				// % protected region % [Set displayName for Name of Husband or Wife here] off begin
				displayName: 'Name of Husband or Wife',
				// % protected region % [Set displayName for Name of Husband or Wife here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Name of Husband or Wife here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Name of Husband or Wife here] end
				// % protected region % [Set isSensitive for Name of Husband or Wife here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Name of Husband or Wife here] end
				// % protected region % [Set readonly for Name of Husband or Wife here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Name of Husband or Wife here] end
				validators: [
					// % protected region % [Add other validators for Name of Husband or Wife here] off begin
					// % protected region % [Add other validators for Name of Husband or Wife here] end
				],
				// % protected region % [Add any additional model attribute properties for Name of Husband or Wife here] off begin
				// % protected region % [Add any additional model attribute properties for Name of Husband or Wife here] end
			},
			{
				name: 'educationLevelOfHusbandOrWife',
				// % protected region % [Set displayName for Education Level of Husband or Wife here] off begin
				displayName: 'Education Level of Husband or Wife',
				// % protected region % [Set displayName for Education Level of Husband or Wife here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Education Level of Husband or Wife here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Education Level of Husband or Wife here] end
				// % protected region % [Set isSensitive for Education Level of Husband or Wife here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Education Level of Husband or Wife here] end
				// % protected region % [Set readonly for Education Level of Husband or Wife here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Education Level of Husband or Wife here] end
				validators: [
					// % protected region % [Add other validators for Education Level of Husband or Wife here] off begin
					// % protected region % [Add other validators for Education Level of Husband or Wife here] end
				],
				// % protected region % [Add any additional model attribute properties for Education Level of Husband or Wife here] off begin
				// % protected region % [Add any additional model attribute properties for Education Level of Husband or Wife here] end
			},
			{
				name: 'occupationOfHusbandOrWife',
				// % protected region % [Set displayName for Occupation of Husband or Wife here] off begin
				displayName: 'Occupation of Husband or Wife',
				// % protected region % [Set displayName for Occupation of Husband or Wife here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Occupation of Husband or Wife here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Occupation of Husband or Wife here] end
				// % protected region % [Set isSensitive for Occupation of Husband or Wife here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Occupation of Husband or Wife here] end
				// % protected region % [Set readonly for Occupation of Husband or Wife here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Occupation of Husband or Wife here] end
				validators: [
					// % protected region % [Add other validators for Occupation of Husband or Wife here] off begin
					// % protected region % [Add other validators for Occupation of Husband or Wife here] end
				],
				// % protected region % [Add any additional model attribute properties for Occupation of Husband or Wife here] off begin
				// % protected region % [Add any additional model attribute properties for Occupation of Husband or Wife here] end
			},
			{
				name: 'ruptureOfMembrane',
				// % protected region % [Set displayName for Rupture Of Membrane here] off begin
				displayName: 'Rupture Of Membrane',
				// % protected region % [Set displayName for Rupture Of Membrane here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Rupture Of Membrane here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Rupture Of Membrane here] end
				// % protected region % [Set isSensitive for Rupture Of Membrane here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Rupture Of Membrane here] end
				// % protected region % [Set readonly for Rupture Of Membrane here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Rupture Of Membrane here] end
				validators: [
					// % protected region % [Add other validators for Rupture Of Membrane here] off begin
					// % protected region % [Add other validators for Rupture Of Membrane here] end
				],
				// % protected region % [Add any additional model attribute properties for Rupture Of Membrane here] off begin
				// % protected region % [Add any additional model attribute properties for Rupture Of Membrane here] end
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
				case 'educationLevelOfHusbandOrWife':
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
	static deepParse(data: string | { [K in keyof ObstetricAndGynecologyHistoryModel]?: ObstetricAndGynecologyHistoryModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ObstetricAndGynecologyHistoryModel(data);
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
	 * `let obstetricAndGynecologyHistoryModel = new ObstetricAndGynecologyHistoryModel(data);`
	 *
	 * @param data The input data to be initialised as the ObstetricAndGynecologyHistoryModel,
	 *    it is expected as a JSON string or as a nullable ObstetricAndGynecologyHistoryModel.
	 */
	constructor(data?: string | Partial<ObstetricAndGynecologyHistoryModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ObstetricAndGynecologyHistoryModel>
				: data;

			this.pregnancyHistoryGravida = json.pregnancyHistoryGravida;
			this.patientHistoryPara = json.patientHistoryPara;
			this.patientHistoryAbortus = json.patientHistoryAbortus;
			this.pregnancyHistoryNotes = json.pregnancyHistoryNotes;
			this.ageOfMenarche = json.ageOfMenarche;
			this.ageOfFirstSexualContact = json.ageOfFirstSexualContact;
			if (json.startDate) {
				this.startDate = new Date(json.startDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.startDate = json.startDate;
			}
			if (json.endDate) {
				this.endDate = new Date(json.endDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.endDate = json.endDate;
			}
			if (json.approximateBirthDate) {
				this.approximateBirthDate = new Date(json.approximateBirthDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.approximateBirthDate = json.approximateBirthDate;
			}
			this.gestationAgeWeeks = json.gestationAgeWeeks;
			this.gestationAgeDays = json.gestationAgeDays;
			this.maternityHistory = json.maternityHistory;
			this.gynecologyHistory = json.gynecologyHistory;
			this.familyPlanHistory = json.familyPlanHistory;
			this.otherNotes = json.otherNotes;
			this.educationLevelOfPatient = json.educationLevelOfPatient;
			this.nameOfHusbandOrWife = json.nameOfHusbandOrWife;
			this.educationLevelOfHusbandOrWife = json.educationLevelOfHusbandOrWife;
			this.occupationOfHusbandOrWife = json.occupationOfHusbandOrWife;
			if (json.ruptureOfMembrane) {
				this.ruptureOfMembrane = new Date(json.ruptureOfMembrane);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.ruptureOfMembrane = json.ruptureOfMembrane;
			}
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
			pregnancyHistoryGravida: this.pregnancyHistoryGravida,
			patientHistoryPara: this.patientHistoryPara,
			patientHistoryAbortus: this.patientHistoryAbortus,
			pregnancyHistoryNotes: this.pregnancyHistoryNotes,
			ageOfMenarche: this.ageOfMenarche,
			ageOfFirstSexualContact: this.ageOfFirstSexualContact,
			startDate: this.startDate,
			endDate: this.endDate,
			approximateBirthDate: this.approximateBirthDate,
			gestationAgeWeeks: this.gestationAgeWeeks,
			gestationAgeDays: this.gestationAgeDays,
			maternityHistory: this.maternityHistory,
			gynecologyHistory: this.gynecologyHistory,
			familyPlanHistory: this.familyPlanHistory,
			otherNotes: this.otherNotes,
			educationLevelOfPatient: this.educationLevelOfPatient,
			nameOfHusbandOrWife: this.nameOfHusbandOrWife,
			educationLevelOfHusbandOrWife: this.educationLevelOfHusbandOrWife,
			occupationOfHusbandOrWife: this.occupationOfHusbandOrWife,
			ruptureOfMembrane: this.ruptureOfMembrane,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ObstetricAndGynecologyHistoryModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ObstetricAndGynecologyHistoryModel {
		let newModelJson = this.toJSON();

		if (updates.pregnancyHistoryGravida) {
			newModelJson.pregnancyHistoryGravida = updates.pregnancyHistoryGravida;
		}

		if (updates.patientHistoryPara) {
			newModelJson.patientHistoryPara = updates.patientHistoryPara;
		}

		if (updates.patientHistoryAbortus) {
			newModelJson.patientHistoryAbortus = updates.patientHistoryAbortus;
		}

		if (updates.pregnancyHistoryNotes) {
			newModelJson.pregnancyHistoryNotes = updates.pregnancyHistoryNotes;
		}

		if (updates.ageOfMenarche) {
			newModelJson.ageOfMenarche = updates.ageOfMenarche;
		}

		if (updates.ageOfFirstSexualContact) {
			newModelJson.ageOfFirstSexualContact = updates.ageOfFirstSexualContact;
		}

		if (updates.startDate) {
			newModelJson.startDate = updates.startDate;
		}

		if (updates.endDate) {
			newModelJson.endDate = updates.endDate;
		}

		if (updates.approximateBirthDate) {
			newModelJson.approximateBirthDate = updates.approximateBirthDate;
		}

		if (updates.gestationAgeWeeks) {
			newModelJson.gestationAgeWeeks = updates.gestationAgeWeeks;
		}

		if (updates.gestationAgeDays) {
			newModelJson.gestationAgeDays = updates.gestationAgeDays;
		}

		if (updates.maternityHistory) {
			newModelJson.maternityHistory = updates.maternityHistory;
		}

		if (updates.gynecologyHistory) {
			newModelJson.gynecologyHistory = updates.gynecologyHistory;
		}

		if (updates.familyPlanHistory) {
			newModelJson.familyPlanHistory = updates.familyPlanHistory;
		}

		if (updates.otherNotes) {
			newModelJson.otherNotes = updates.otherNotes;
		}

		if (updates.educationLevelOfPatient) {
			newModelJson.educationLevelOfPatient = updates.educationLevelOfPatient;
		}

		if (updates.nameOfHusbandOrWife) {
			newModelJson.nameOfHusbandOrWife = updates.nameOfHusbandOrWife;
		}

		if (updates.educationLevelOfHusbandOrWife) {
			newModelJson.educationLevelOfHusbandOrWife = updates.educationLevelOfHusbandOrWife;
		}

		if (updates.occupationOfHusbandOrWife) {
			newModelJson.occupationOfHusbandOrWife = updates.occupationOfHusbandOrWife;
		}

		if (updates.ruptureOfMembrane) {
			newModelJson.ruptureOfMembrane = updates.ruptureOfMembrane;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		return new ObstetricAndGynecologyHistoryModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ObstetricAndGynecologyHistoryModel)) {
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
