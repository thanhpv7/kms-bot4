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
import {MedicalExaminationRecordModel} from '../medicalExaminationRecord/medical_examination_record.model';
import {PreoperativeRecordsModel} from '../preoperativeRecords/preoperative_records.model';
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
export class CoTreatingDoctorModel extends AbstractModel {
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
		'doctorNotes',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'CoTreatingDoctorModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return CoTreatingDoctorModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	doctorNotes: string;

	additionalAnesthesiologistId: string;

	additionalAnesthesiologist: PreoperativeRecordsModel;

	additionalMidwifeId: string;

	additionalMidwife: DeliveryMedicalExaminationRecordModel;

	additionalSurgeryNurseId: string;

	additionalSurgeryNurse: PreoperativeRecordsModel;

	coTreatingAnesthesiologistId: string;

	coTreatingAnesthesiologist: PreoperativeRecordsModel;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	staffId: string;

	staff: StaffModel;

	coTreatingSurgeonId: string;

	coTreatingSurgeon: PreoperativeRecordsModel;

	modelPropGroups: { [s: string]: Group } = CoTreatingDoctorModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'doctorNotes',
				// % protected region % [Set displayName for Doctor Notes here] off begin
				displayName: 'Doctor Notes',
				// % protected region % [Set displayName for Doctor Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor Notes here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Doctor Notes here] end
				// % protected region % [Set isSensitive for Doctor Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor Notes here] end
				// % protected region % [Set readonly for Doctor Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor Notes here] end
				validators: [
					// % protected region % [Add other validators for Doctor Notes here] off begin
					// % protected region % [Add other validators for Doctor Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor Notes here] end
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
				id: 'additionalAnesthesiologist',
				type: ModelRelationType.ONE,
				name: 'additionalAnesthesiologistId',
				// % protected region % [Customise your label for Additional Anesthesiologist here] off begin
				label: 'Additional Anesthesiologist',
				// % protected region % [Customise your label for Additional Anesthesiologist here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Additional Anesthesiologist here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Additional Anesthesiologist here] end
				validators: [
					// % protected region % [Add other validators for Additional Anesthesiologist here] off begin
					// % protected region % [Add other validators for Additional Anesthesiologist here] end
				],
				// % protected region % [Add any additional field for relation Additional Anesthesiologist here] off begin
				// % protected region % [Add any additional field for relation Additional Anesthesiologist here] end
			},
			{
				id: 'additionalMidwife',
				type: ModelRelationType.ONE,
				name: 'additionalMidwifeId',
				// % protected region % [Customise your label for Additional Midwife here] off begin
				label: 'Additional Midwife',
				// % protected region % [Customise your label for Additional Midwife here] end
				entityName: 'DeliveryMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Additional Midwife here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'pregnancyHistoryGravida',
				// % protected region % [Customise your display name for Additional Midwife here] end
				validators: [
					// % protected region % [Add other validators for Additional Midwife here] off begin
					// % protected region % [Add other validators for Additional Midwife here] end
				],
				// % protected region % [Add any additional field for relation Additional Midwife here] off begin
				// % protected region % [Add any additional field for relation Additional Midwife here] end
			},
			{
				id: 'additionalSurgeryNurse',
				type: ModelRelationType.ONE,
				name: 'additionalSurgeryNurseId',
				// % protected region % [Customise your label for Additional Surgery Nurse here] off begin
				label: 'Additional Surgery Nurse',
				// % protected region % [Customise your label for Additional Surgery Nurse here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Additional Surgery Nurse here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Additional Surgery Nurse here] end
				validators: [
					// % protected region % [Add other validators for Additional Surgery Nurse here] off begin
					// % protected region % [Add other validators for Additional Surgery Nurse here] end
				],
				// % protected region % [Add any additional field for relation Additional Surgery Nurse here] off begin
				// % protected region % [Add any additional field for relation Additional Surgery Nurse here] end
			},
			{
				id: 'coTreatingAnesthesiologist',
				type: ModelRelationType.ONE,
				name: 'coTreatingAnesthesiologistId',
				// % protected region % [Customise your label for Co Treating Anesthesiologist here] off begin
				label: 'Co Treating Anesthesiologist',
				// % protected region % [Customise your label for Co Treating Anesthesiologist here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Co Treating Anesthesiologist here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Co Treating Anesthesiologist here] end
				validators: [
					// % protected region % [Add other validators for Co Treating Anesthesiologist here] off begin
					// % protected region % [Add other validators for Co Treating Anesthesiologist here] end
				],
				// % protected region % [Add any additional field for relation Co Treating Anesthesiologist here] off begin
				// % protected region % [Add any additional field for relation Co Treating Anesthesiologist here] end
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
				id: 'coTreatingSurgeon',
				type: ModelRelationType.ONE,
				name: 'coTreatingSurgeonId',
				// % protected region % [Customise your label for Co Treating Surgeon here] off begin
				label: 'Co Treating Surgeon',
				// % protected region % [Customise your label for Co Treating Surgeon here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Co Treating Surgeon here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Co Treating Surgeon here] end
				validators: [
					// % protected region % [Add other validators for Co Treating Surgeon here] off begin
					// % protected region % [Add other validators for Co Treating Surgeon here] end
				],
				// % protected region % [Add any additional field for relation Co Treating Surgeon here] off begin
				// % protected region % [Add any additional field for relation Co Treating Surgeon here] end
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
	static deepParse(data: string | { [K in keyof CoTreatingDoctorModel]?: CoTreatingDoctorModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new CoTreatingDoctorModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.additionalAnesthesiologist) {
			currentModel.additionalAnesthesiologistId = json.additionalAnesthesiologist.id;
			returned = _.union(returned, PreoperativeRecordsModel.deepParse(json.additionalAnesthesiologist));
		}

		// Incoming one to many
		if (json.additionalMidwife) {
			currentModel.additionalMidwifeId = json.additionalMidwife.id;
			returned = _.union(returned, DeliveryMedicalExaminationRecordModel.deepParse(json.additionalMidwife));
		}

		// Incoming one to many
		if (json.additionalSurgeryNurse) {
			currentModel.additionalSurgeryNurseId = json.additionalSurgeryNurse.id;
			returned = _.union(returned, PreoperativeRecordsModel.deepParse(json.additionalSurgeryNurse));
		}

		// Incoming one to many
		if (json.coTreatingAnesthesiologist) {
			currentModel.coTreatingAnesthesiologistId = json.coTreatingAnesthesiologist.id;
			returned = _.union(returned, PreoperativeRecordsModel.deepParse(json.coTreatingAnesthesiologist));
		}

		// Incoming one to many
		if (json.medicalExaminationRecord) {
			currentModel.medicalExaminationRecordId = json.medicalExaminationRecord.id;
			returned = _.union(returned, MedicalExaminationRecordModel.deepParse(json.medicalExaminationRecord));
		}

		// Incoming one to many
		if (json.staff) {
			currentModel.staffId = json.staff.id;
			returned = _.union(returned, StaffModel.deepParse(json.staff));
		}

		// Incoming one to many
		if (json.coTreatingSurgeon) {
			currentModel.coTreatingSurgeonId = json.coTreatingSurgeon.id;
			returned = _.union(returned, PreoperativeRecordsModel.deepParse(json.coTreatingSurgeon));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let coTreatingDoctorModel = new CoTreatingDoctorModel(data);`
	 *
	 * @param data The input data to be initialised as the CoTreatingDoctorModel,
	 *    it is expected as a JSON string or as a nullable CoTreatingDoctorModel.
	 */
	constructor(data?: string | Partial<CoTreatingDoctorModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<CoTreatingDoctorModel>
				: data;

			this.doctorNotes = json.doctorNotes;
			this.additionalAnesthesiologistId = json.additionalAnesthesiologistId;
			this.additionalAnesthesiologist = json.additionalAnesthesiologist;
			this.additionalMidwifeId = json.additionalMidwifeId;
			this.additionalMidwife = json.additionalMidwife;
			this.additionalSurgeryNurseId = json.additionalSurgeryNurseId;
			this.additionalSurgeryNurse = json.additionalSurgeryNurse;
			this.coTreatingAnesthesiologistId = json.coTreatingAnesthesiologistId;
			this.coTreatingAnesthesiologist = json.coTreatingAnesthesiologist;
			this.medicalExaminationRecordId = json.medicalExaminationRecordId;
			this.medicalExaminationRecord = json.medicalExaminationRecord;
			this.staffId = json.staffId;
			this.staff = json.staff;
			this.coTreatingSurgeonId = json.coTreatingSurgeonId;
			this.coTreatingSurgeon = json.coTreatingSurgeon;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			doctorNotes: this.doctorNotes,
			additionalAnesthesiologistId: this.additionalAnesthesiologistId,
			additionalMidwifeId: this.additionalMidwifeId,
			additionalSurgeryNurseId: this.additionalSurgeryNurseId,
			coTreatingAnesthesiologistId: this.coTreatingAnesthesiologistId,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			staffId: this.staffId,
			coTreatingSurgeonId: this.coTreatingSurgeonId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		CoTreatingDoctorModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): CoTreatingDoctorModel {
		let newModelJson = this.toJSON();

		if (updates.doctorNotes) {
			newModelJson.doctorNotes = updates.doctorNotes;
		}

		if (updates.additionalAnesthesiologistId) {
			newModelJson.additionalAnesthesiologistId = updates.additionalAnesthesiologistId;
		}

		if (updates.additionalMidwifeId) {
			newModelJson.additionalMidwifeId = updates.additionalMidwifeId;
		}

		if (updates.additionalSurgeryNurseId) {
			newModelJson.additionalSurgeryNurseId = updates.additionalSurgeryNurseId;
		}

		if (updates.coTreatingAnesthesiologistId) {
			newModelJson.coTreatingAnesthesiologistId = updates.coTreatingAnesthesiologistId;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		if (updates.coTreatingSurgeonId) {
			newModelJson.coTreatingSurgeonId = updates.coTreatingSurgeonId;
		}

		return new CoTreatingDoctorModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof CoTreatingDoctorModel)) {
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
			'additionalAnesthesiologistId',
			'additionalAnesthesiologist',
			'additionalMidwifeId',
			'additionalMidwife',
			'additionalSurgeryNurseId',
			'additionalSurgeryNurse',
			'coTreatingAnesthesiologistId',
			'coTreatingAnesthesiologist',
			'medicalExaminationRecordId',
			'medicalExaminationRecord',
			'staffId',
			'staff',
			'coTreatingSurgeonId',
			'coTreatingSurgeon',
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
		if (!this.additionalAnesthesiologist) {
			this.additionalAnesthesiologistId = null;
		} else {
			this.additionalAnesthesiologistId = this.additionalAnesthesiologist.id;
		}

		if (!this.additionalMidwife) {
			this.additionalMidwifeId = null;
		} else {
			this.additionalMidwifeId = this.additionalMidwife.id;
		}

		if (!this.additionalSurgeryNurse) {
			this.additionalSurgeryNurseId = null;
		} else {
			this.additionalSurgeryNurseId = this.additionalSurgeryNurse.id;
		}

		if (!this.coTreatingAnesthesiologist) {
			this.coTreatingAnesthesiologistId = null;
		} else {
			this.coTreatingAnesthesiologistId = this.coTreatingAnesthesiologist.id;
		}

		if (!this.medicalExaminationRecord) {
			this.medicalExaminationRecordId = null;
		} else {
			this.medicalExaminationRecordId = this.medicalExaminationRecord.id;
		}

		if (!this.staff) {
			this.staffId = null;
		} else {
			this.staffId = this.staff.id;
		}

		if (!this.coTreatingSurgeon) {
			this.coTreatingSurgeonId = null;
		} else {
			this.coTreatingSurgeonId = this.coTreatingSurgeon.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
