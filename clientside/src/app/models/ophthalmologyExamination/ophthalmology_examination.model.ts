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
export class OphthalmologyExaminationModel extends AbstractModel {
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
		'rightEyelidSubjective',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'OphthalmologyExaminationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return OphthalmologyExaminationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	rightEyelidSubjective: string;

	/**
	 * .
	 */
	rightEyelidObjective: string;

	/**
	 * .
	 */
	rightPupilSubjective: string;

	/**
	 * .
	 */
	rightPupilObjective: string;

	/**
	 * .
	 */
	rightScleraSubjective: string;

	/**
	 * .
	 */
	rightScleraObjective: string;

	/**
	 * .
	 */
	rightIrisSubjective: string;

	/**
	 * .
	 */
	rightIrisObjective: string;

	/**
	 * .
	 */
	leftEyelidSubjective: string;

	/**
	 * .
	 */
	leftEyelidObjective: string;

	/**
	 * .
	 */
	leftPupilSubjective: string;

	/**
	 * .
	 */
	leftPupilObjective: string;

	/**
	 * .
	 */
	leftScleraSubjective: string;

	/**
	 * .
	 */
	leftScleraObjective: string;

	/**
	 * .
	 */
	leftIrisSubjective: string;

	/**
	 * .
	 */
	leftIrisObjective: string;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	modelPropGroups: { [s: string]: Group } = OphthalmologyExaminationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'rightEyelidSubjective',
				// % protected region % [Set displayName for Right Eyelid Subjective here] off begin
				displayName: 'Right Eyelid Subjective',
				// % protected region % [Set displayName for Right Eyelid Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Eyelid Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Eyelid Subjective here] end
				// % protected region % [Set isSensitive for Right Eyelid Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Eyelid Subjective here] end
				// % protected region % [Set readonly for Right Eyelid Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Eyelid Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Eyelid Subjective here] off begin
					// % protected region % [Add other validators for Right Eyelid Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Eyelid Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Eyelid Subjective here] end
			},
			{
				name: 'rightEyelidObjective',
				// % protected region % [Set displayName for Right Eyelid Objective here] off begin
				displayName: 'Right Eyelid Objective',
				// % protected region % [Set displayName for Right Eyelid Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Eyelid Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Eyelid Objective here] end
				// % protected region % [Set isSensitive for Right Eyelid Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Eyelid Objective here] end
				// % protected region % [Set readonly for Right Eyelid Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Eyelid Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Eyelid Objective here] off begin
					// % protected region % [Add other validators for Right Eyelid Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Eyelid Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Eyelid Objective here] end
			},
			{
				name: 'rightPupilSubjective',
				// % protected region % [Set displayName for Right Pupil Subjective here] off begin
				displayName: 'Right Pupil Subjective',
				// % protected region % [Set displayName for Right Pupil Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Pupil Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Pupil Subjective here] end
				// % protected region % [Set isSensitive for Right Pupil Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Pupil Subjective here] end
				// % protected region % [Set readonly for Right Pupil Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Pupil Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Pupil Subjective here] off begin
					// % protected region % [Add other validators for Right Pupil Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Pupil Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Pupil Subjective here] end
			},
			{
				name: 'rightPupilObjective',
				// % protected region % [Set displayName for Right Pupil Objective here] off begin
				displayName: 'Right Pupil Objective',
				// % protected region % [Set displayName for Right Pupil Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Pupil Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Pupil Objective here] end
				// % protected region % [Set isSensitive for Right Pupil Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Pupil Objective here] end
				// % protected region % [Set readonly for Right Pupil Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Pupil Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Pupil Objective here] off begin
					// % protected region % [Add other validators for Right Pupil Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Pupil Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Pupil Objective here] end
			},
			{
				name: 'rightScleraSubjective',
				// % protected region % [Set displayName for Right Sclera Subjective here] off begin
				displayName: 'Right Sclera Subjective',
				// % protected region % [Set displayName for Right Sclera Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Sclera Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Sclera Subjective here] end
				// % protected region % [Set isSensitive for Right Sclera Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Sclera Subjective here] end
				// % protected region % [Set readonly for Right Sclera Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Sclera Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Sclera Subjective here] off begin
					// % protected region % [Add other validators for Right Sclera Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Sclera Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Sclera Subjective here] end
			},
			{
				name: 'rightScleraObjective',
				// % protected region % [Set displayName for Right Sclera Objective here] off begin
				displayName: 'Right Sclera Objective',
				// % protected region % [Set displayName for Right Sclera Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Sclera Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Sclera Objective here] end
				// % protected region % [Set isSensitive for Right Sclera Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Sclera Objective here] end
				// % protected region % [Set readonly for Right Sclera Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Sclera Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Sclera Objective here] off begin
					// % protected region % [Add other validators for Right Sclera Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Sclera Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Sclera Objective here] end
			},
			{
				name: 'rightIrisSubjective',
				// % protected region % [Set displayName for Right Iris Subjective here] off begin
				displayName: 'Right Iris Subjective',
				// % protected region % [Set displayName for Right Iris Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Iris Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Iris Subjective here] end
				// % protected region % [Set isSensitive for Right Iris Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Iris Subjective here] end
				// % protected region % [Set readonly for Right Iris Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Iris Subjective here] end
				validators: [
					// % protected region % [Add other validators for Right Iris Subjective here] off begin
					// % protected region % [Add other validators for Right Iris Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Iris Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Iris Subjective here] end
			},
			{
				name: 'rightIrisObjective',
				// % protected region % [Set displayName for Right Iris Objective here] off begin
				displayName: 'Right Iris Objective',
				// % protected region % [Set displayName for Right Iris Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Right Iris Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Right Iris Objective here] end
				// % protected region % [Set isSensitive for Right Iris Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Iris Objective here] end
				// % protected region % [Set readonly for Right Iris Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Iris Objective here] end
				validators: [
					// % protected region % [Add other validators for Right Iris Objective here] off begin
					// % protected region % [Add other validators for Right Iris Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Iris Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Right Iris Objective here] end
			},
			{
				name: 'leftEyelidSubjective',
				// % protected region % [Set displayName for Left Eyelid Subjective here] off begin
				displayName: 'Left Eyelid Subjective',
				// % protected region % [Set displayName for Left Eyelid Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Eyelid Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Eyelid Subjective here] end
				// % protected region % [Set isSensitive for Left Eyelid Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Eyelid Subjective here] end
				// % protected region % [Set readonly for Left Eyelid Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Eyelid Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Eyelid Subjective here] off begin
					// % protected region % [Add other validators for Left Eyelid Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Eyelid Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Eyelid Subjective here] end
			},
			{
				name: 'leftEyelidObjective',
				// % protected region % [Set displayName for Left Eyelid Objective here] off begin
				displayName: 'Left Eyelid Objective',
				// % protected region % [Set displayName for Left Eyelid Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Eyelid Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Eyelid Objective here] end
				// % protected region % [Set isSensitive for Left Eyelid Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Eyelid Objective here] end
				// % protected region % [Set readonly for Left Eyelid Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Eyelid Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Eyelid Objective here] off begin
					// % protected region % [Add other validators for Left Eyelid Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Eyelid Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Eyelid Objective here] end
			},
			{
				name: 'leftPupilSubjective',
				// % protected region % [Set displayName for Left Pupil Subjective here] off begin
				displayName: 'Left Pupil Subjective',
				// % protected region % [Set displayName for Left Pupil Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Pupil Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Pupil Subjective here] end
				// % protected region % [Set isSensitive for Left Pupil Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Pupil Subjective here] end
				// % protected region % [Set readonly for Left Pupil Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Pupil Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Pupil Subjective here] off begin
					// % protected region % [Add other validators for Left Pupil Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Pupil Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Pupil Subjective here] end
			},
			{
				name: 'leftPupilObjective',
				// % protected region % [Set displayName for Left Pupil Objective here] off begin
				displayName: 'Left Pupil Objective',
				// % protected region % [Set displayName for Left Pupil Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Pupil Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Pupil Objective here] end
				// % protected region % [Set isSensitive for Left Pupil Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Pupil Objective here] end
				// % protected region % [Set readonly for Left Pupil Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Pupil Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Pupil Objective here] off begin
					// % protected region % [Add other validators for Left Pupil Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Pupil Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Pupil Objective here] end
			},
			{
				name: 'leftScleraSubjective',
				// % protected region % [Set displayName for Left Sclera Subjective here] off begin
				displayName: 'Left Sclera Subjective',
				// % protected region % [Set displayName for Left Sclera Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Sclera Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Sclera Subjective here] end
				// % protected region % [Set isSensitive for Left Sclera Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Sclera Subjective here] end
				// % protected region % [Set readonly for Left Sclera Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Sclera Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Sclera Subjective here] off begin
					// % protected region % [Add other validators for Left Sclera Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Sclera Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Sclera Subjective here] end
			},
			{
				name: 'leftScleraObjective',
				// % protected region % [Set displayName for Left Sclera Objective here] off begin
				displayName: 'Left Sclera Objective',
				// % protected region % [Set displayName for Left Sclera Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Sclera Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Sclera Objective here] end
				// % protected region % [Set isSensitive for Left Sclera Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Sclera Objective here] end
				// % protected region % [Set readonly for Left Sclera Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Sclera Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Sclera Objective here] off begin
					// % protected region % [Add other validators for Left Sclera Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Sclera Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Sclera Objective here] end
			},
			{
				name: 'leftIrisSubjective',
				// % protected region % [Set displayName for Left Iris Subjective here] off begin
				displayName: 'Left Iris Subjective',
				// % protected region % [Set displayName for Left Iris Subjective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Iris Subjective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Iris Subjective here] end
				// % protected region % [Set isSensitive for Left Iris Subjective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Iris Subjective here] end
				// % protected region % [Set readonly for Left Iris Subjective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Iris Subjective here] end
				validators: [
					// % protected region % [Add other validators for Left Iris Subjective here] off begin
					// % protected region % [Add other validators for Left Iris Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Iris Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Iris Subjective here] end
			},
			{
				name: 'leftIrisObjective',
				// % protected region % [Set displayName for Left Iris Objective here] off begin
				displayName: 'Left Iris Objective',
				// % protected region % [Set displayName for Left Iris Objective here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Left Iris Objective here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Left Iris Objective here] end
				// % protected region % [Set isSensitive for Left Iris Objective here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Iris Objective here] end
				// % protected region % [Set readonly for Left Iris Objective here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Iris Objective here] end
				validators: [
					// % protected region % [Add other validators for Left Iris Objective here] off begin
					// % protected region % [Add other validators for Left Iris Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Iris Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Left Iris Objective here] end
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
	static deepParse(data: string | { [K in keyof OphthalmologyExaminationModel]?: OphthalmologyExaminationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new OphthalmologyExaminationModel(data);
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
	 * `let ophthalmologyExaminationModel = new OphthalmologyExaminationModel(data);`
	 *
	 * @param data The input data to be initialised as the OphthalmologyExaminationModel,
	 *    it is expected as a JSON string or as a nullable OphthalmologyExaminationModel.
	 */
	constructor(data?: string | Partial<OphthalmologyExaminationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<OphthalmologyExaminationModel>
				: data;

			this.rightEyelidSubjective = json.rightEyelidSubjective;
			this.rightEyelidObjective = json.rightEyelidObjective;
			this.rightPupilSubjective = json.rightPupilSubjective;
			this.rightPupilObjective = json.rightPupilObjective;
			this.rightScleraSubjective = json.rightScleraSubjective;
			this.rightScleraObjective = json.rightScleraObjective;
			this.rightIrisSubjective = json.rightIrisSubjective;
			this.rightIrisObjective = json.rightIrisObjective;
			this.leftEyelidSubjective = json.leftEyelidSubjective;
			this.leftEyelidObjective = json.leftEyelidObjective;
			this.leftPupilSubjective = json.leftPupilSubjective;
			this.leftPupilObjective = json.leftPupilObjective;
			this.leftScleraSubjective = json.leftScleraSubjective;
			this.leftScleraObjective = json.leftScleraObjective;
			this.leftIrisSubjective = json.leftIrisSubjective;
			this.leftIrisObjective = json.leftIrisObjective;
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
			rightEyelidSubjective: this.rightEyelidSubjective,
			rightEyelidObjective: this.rightEyelidObjective,
			rightPupilSubjective: this.rightPupilSubjective,
			rightPupilObjective: this.rightPupilObjective,
			rightScleraSubjective: this.rightScleraSubjective,
			rightScleraObjective: this.rightScleraObjective,
			rightIrisSubjective: this.rightIrisSubjective,
			rightIrisObjective: this.rightIrisObjective,
			leftEyelidSubjective: this.leftEyelidSubjective,
			leftEyelidObjective: this.leftEyelidObjective,
			leftPupilSubjective: this.leftPupilSubjective,
			leftPupilObjective: this.leftPupilObjective,
			leftScleraSubjective: this.leftScleraSubjective,
			leftScleraObjective: this.leftScleraObjective,
			leftIrisSubjective: this.leftIrisSubjective,
			leftIrisObjective: this.leftIrisObjective,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		OphthalmologyExaminationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): OphthalmologyExaminationModel {
		let newModelJson = this.toJSON();

		if (updates.rightEyelidSubjective) {
			newModelJson.rightEyelidSubjective = updates.rightEyelidSubjective;
		}

		if (updates.rightEyelidObjective) {
			newModelJson.rightEyelidObjective = updates.rightEyelidObjective;
		}

		if (updates.rightPupilSubjective) {
			newModelJson.rightPupilSubjective = updates.rightPupilSubjective;
		}

		if (updates.rightPupilObjective) {
			newModelJson.rightPupilObjective = updates.rightPupilObjective;
		}

		if (updates.rightScleraSubjective) {
			newModelJson.rightScleraSubjective = updates.rightScleraSubjective;
		}

		if (updates.rightScleraObjective) {
			newModelJson.rightScleraObjective = updates.rightScleraObjective;
		}

		if (updates.rightIrisSubjective) {
			newModelJson.rightIrisSubjective = updates.rightIrisSubjective;
		}

		if (updates.rightIrisObjective) {
			newModelJson.rightIrisObjective = updates.rightIrisObjective;
		}

		if (updates.leftEyelidSubjective) {
			newModelJson.leftEyelidSubjective = updates.leftEyelidSubjective;
		}

		if (updates.leftEyelidObjective) {
			newModelJson.leftEyelidObjective = updates.leftEyelidObjective;
		}

		if (updates.leftPupilSubjective) {
			newModelJson.leftPupilSubjective = updates.leftPupilSubjective;
		}

		if (updates.leftPupilObjective) {
			newModelJson.leftPupilObjective = updates.leftPupilObjective;
		}

		if (updates.leftScleraSubjective) {
			newModelJson.leftScleraSubjective = updates.leftScleraSubjective;
		}

		if (updates.leftScleraObjective) {
			newModelJson.leftScleraObjective = updates.leftScleraObjective;
		}

		if (updates.leftIrisSubjective) {
			newModelJson.leftIrisSubjective = updates.leftIrisSubjective;
		}

		if (updates.leftIrisObjective) {
			newModelJson.leftIrisObjective = updates.leftIrisObjective;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		return new OphthalmologyExaminationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof OphthalmologyExaminationModel)) {
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
