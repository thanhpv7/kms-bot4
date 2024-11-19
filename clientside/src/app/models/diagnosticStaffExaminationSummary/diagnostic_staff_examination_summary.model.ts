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
import {RegistrationModel} from '../registration/registration.model';
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
export class DiagnosticStaffExaminationSummaryModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'responsibleDoctor',
		'medicalTranscriber',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'responsibleDoctor',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'DiagnosticStaffExaminationSummaryModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return DiagnosticStaffExaminationSummaryModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	responsibleDoctor: string;

	/**
	 * .
	 */
	medicalTranscriber: string;

	/**
	 * .
	 */
	referringRoom: string;

	/**
	 * .
	 */
	referingUnit: string;

	/**
	 * .
	 */
	examinationLocation: string;

	/**
	 * .
	 */
	additionalNotes: string;

	/**
	 * .
	 */
	conclusion: string;

	registrationId: string;

	registration: RegistrationModel;

	diagnosisExaminationRecordId: string;

	diagnosisExaminationRecord: DiagnosisExaminationRecordModel;

	staffId: string;

	staff: StaffModel;

	modelPropGroups: { [s: string]: Group } = DiagnosticStaffExaminationSummaryModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
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
				name: 'medicalTranscriber',
				// % protected region % [Set displayName for Medical Transcriber here] off begin
				displayName: 'Medical Transcriber',
				// % protected region % [Set displayName for Medical Transcriber here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Medical Transcriber here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Medical Transcriber here] end
				// % protected region % [Set isSensitive for Medical Transcriber here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medical Transcriber here] end
				// % protected region % [Set readonly for Medical Transcriber here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medical Transcriber here] end
				validators: [
					// % protected region % [Add other validators for Medical Transcriber here] off begin
					// % protected region % [Add other validators for Medical Transcriber here] end
				],
				// % protected region % [Add any additional model attribute properties for Medical Transcriber here] off begin
				// % protected region % [Add any additional model attribute properties for Medical Transcriber here] end
			},
			{
				name: 'referringRoom',
				// % protected region % [Set displayName for Referring Room here] off begin
				displayName: 'Referring Room',
				// % protected region % [Set displayName for Referring Room here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referring Room here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referring Room here] end
				// % protected region % [Set isSensitive for Referring Room here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referring Room here] end
				// % protected region % [Set readonly for Referring Room here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referring Room here] end
				validators: [
					// % protected region % [Add other validators for Referring Room here] off begin
					// % protected region % [Add other validators for Referring Room here] end
				],
				// % protected region % [Add any additional model attribute properties for Referring Room here] off begin
				// % protected region % [Add any additional model attribute properties for Referring Room here] end
			},
			{
				name: 'referingUnit',
				// % protected region % [Set displayName for Refering Unit here] off begin
				displayName: 'Refering Unit',
				// % protected region % [Set displayName for Refering Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Refering Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Refering Unit here] end
				// % protected region % [Set isSensitive for Refering Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Refering Unit here] end
				// % protected region % [Set readonly for Refering Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Refering Unit here] end
				validators: [
					// % protected region % [Add other validators for Refering Unit here] off begin
					// % protected region % [Add other validators for Refering Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Refering Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Refering Unit here] end
			},
			{
				name: 'examinationLocation',
				// % protected region % [Set displayName for Examination Location here] off begin
				displayName: 'Examination Location',
				// % protected region % [Set displayName for Examination Location here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Examination Location here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Examination Location here] end
				// % protected region % [Set isSensitive for Examination Location here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Examination Location here] end
				// % protected region % [Set readonly for Examination Location here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Examination Location here] end
				validators: [
					// % protected region % [Add other validators for Examination Location here] off begin
					// % protected region % [Add other validators for Examination Location here] end
				],
				// % protected region % [Add any additional model attribute properties for Examination Location here] off begin
				// % protected region % [Add any additional model attribute properties for Examination Location here] end
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
					// % protected region % [Add other validators for Additional Notes here] off begin
					// % protected region % [Add other validators for Additional Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Additional Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Additional Notes here] end
			},
			{
				name: 'conclusion',
				// % protected region % [Set displayName for Conclusion here] off begin
				displayName: 'Conclusion',
				// % protected region % [Set displayName for Conclusion here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Conclusion here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Conclusion here] end
				// % protected region % [Set isSensitive for Conclusion here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Conclusion here] end
				// % protected region % [Set readonly for Conclusion here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Conclusion here] end
				validators: [
					// % protected region % [Add other validators for Conclusion here] off begin
					// % protected region % [Add other validators for Conclusion here] end
				],
				// % protected region % [Add any additional model attribute properties for Conclusion here] off begin
				// % protected region % [Add any additional model attribute properties for Conclusion here] end
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
				id: 'registration',
				type: ModelRelationType.ONE,
				name: 'registrationId',
				// % protected region % [Customise your 1-1 or 1-M label for Registration here] off begin
				label: 'Registration',
				// % protected region % [Customise your 1-1 or 1-M label for Registration here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Registration here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Registration here] end
				validators: [
					// % protected region % [Add other validators for Registration here] off begin
					// % protected region % [Add other validators for Registration here] end
				],
				// % protected region % [Add any additional field for relation Registration here] off begin
				// % protected region % [Add any additional field for relation Registration here] end
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
			{
				id: 'diagnosisExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'diagnosisExaminationRecordId',
				// % protected region % [Customise your label for Diagnosis Examination Record here] off begin
				label: 'Diagnosis Examination Record',
				// % protected region % [Customise your label for Diagnosis Examination Record here] end
				entityName: 'DiagnosisExaminationRecordModel',
				// % protected region % [Customise your display name for Diagnosis Examination Record here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'diagnosisSequence',
				// % protected region % [Customise your display name for Diagnosis Examination Record here] end
				validators: [
					// % protected region % [Add other validators for Diagnosis Examination Record here] off begin
					// % protected region % [Add other validators for Diagnosis Examination Record here] end
				],
				// % protected region % [Add any additional field for relation Diagnosis Examination Record here] off begin
				// % protected region % [Add any additional field for relation Diagnosis Examination Record here] end
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
				case 'responsibleDoctor':
					break;
				case 'medicalTranscriber':
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
	static deepParse(data: string | { [K in keyof DiagnosticStaffExaminationSummaryModel]?: DiagnosticStaffExaminationSummaryModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new DiagnosticStaffExaminationSummaryModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}

		// Incoming one to one
		if (json.diagnosisExaminationRecord) {
			currentModel.diagnosisExaminationRecordId = json.diagnosisExaminationRecord.id;
			returned = _.union(returned, DiagnosisExaminationRecordModel.deepParse(json.diagnosisExaminationRecord));
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
	 * `let diagnosticStaffExaminationSummaryModel = new DiagnosticStaffExaminationSummaryModel(data);`
	 *
	 * @param data The input data to be initialised as the DiagnosticStaffExaminationSummaryModel,
	 *    it is expected as a JSON string or as a nullable DiagnosticStaffExaminationSummaryModel.
	 */
	constructor(data?: string | Partial<DiagnosticStaffExaminationSummaryModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<DiagnosticStaffExaminationSummaryModel>
				: data;

			this.responsibleDoctor = json.responsibleDoctor;
			this.medicalTranscriber = json.medicalTranscriber;
			this.referringRoom = json.referringRoom;
			this.referingUnit = json.referingUnit;
			this.examinationLocation = json.examinationLocation;
			this.additionalNotes = json.additionalNotes;
			this.conclusion = json.conclusion;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			this.diagnosisExaminationRecordId = json.diagnosisExaminationRecordId;
			this.diagnosisExaminationRecord = json.diagnosisExaminationRecord;
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
			responsibleDoctor: this.responsibleDoctor,
			medicalTranscriber: this.medicalTranscriber,
			referringRoom: this.referringRoom,
			referingUnit: this.referingUnit,
			examinationLocation: this.examinationLocation,
			additionalNotes: this.additionalNotes,
			conclusion: this.conclusion,
			registrationId: this.registrationId,
			diagnosisExaminationRecordId: this.diagnosisExaminationRecordId,
			staffId: this.staffId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		DiagnosticStaffExaminationSummaryModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): DiagnosticStaffExaminationSummaryModel {
		let newModelJson = this.toJSON();

		if (updates.responsibleDoctor) {
			newModelJson.responsibleDoctor = updates.responsibleDoctor;
		}

		if (updates.medicalTranscriber) {
			newModelJson.medicalTranscriber = updates.medicalTranscriber;
		}

		if (updates.referringRoom) {
			newModelJson.referringRoom = updates.referringRoom;
		}

		if (updates.referingUnit) {
			newModelJson.referingUnit = updates.referingUnit;
		}

		if (updates.examinationLocation) {
			newModelJson.examinationLocation = updates.examinationLocation;
		}

		if (updates.additionalNotes) {
			newModelJson.additionalNotes = updates.additionalNotes;
		}

		if (updates.conclusion) {
			newModelJson.conclusion = updates.conclusion;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.diagnosisExaminationRecordId) {
			newModelJson.diagnosisExaminationRecordId = updates.diagnosisExaminationRecordId;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		return new DiagnosticStaffExaminationSummaryModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof DiagnosticStaffExaminationSummaryModel)) {
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
			'diagnosisExaminationRecordId',
			'diagnosisExaminationRecord',
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
		if (!this.registration) {
			this.registrationId = null;
		} else {
			this.registrationId = this.registration.id;
		}

		if (!this.diagnosisExaminationRecord) {
			this.diagnosisExaminationRecordId = null;
		} else {
			this.diagnosisExaminationRecordId = this.diagnosisExaminationRecord.id;
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
