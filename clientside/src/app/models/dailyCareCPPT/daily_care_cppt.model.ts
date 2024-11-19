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
import {DiagnosesAndProceduresModel} from '../diagnosesAndProcedures/diagnoses_and_procedures.model';
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
export class DailyCareCPPTModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'subjective',
		'objective',
		'diagnose',
		'plan',
		'instruction',
		'verifiedBy',
		'canceledBy',
		'status',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'subjective',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'DailyCareCPPTModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return DailyCareCPPTModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	subjective: string;

	/**
	 * .
	 */
	objective: string;

	/**
	 * .
	 */
	diagnose: string;

	/**
	 * .
	 */
	plan: string;

	/**
	 * .
	 */
	instruction: string;

	/**
	 * .
	 */
	verifiedDate: Date;

	/**
	 * .
	 */
	verifiedBy: string;

	/**
	 * .
	 */
	canceledDate: Date;

	/**
	 * .
	 */
	canceledBy: string;

	/**
	 * .
	 */
	status: string;

	/**
	 * CPPT Date Time.
	 */
	cpptDateTime: Date;

	icd10Id: string;

	icd10: DiagnosesAndProceduresModel;

	icd9CMId: string;

	icd9CM: DiagnosesAndProceduresModel;

	createdByStaffId: string;

	createdByStaff: StaffModel;

	doctorInChargeId: string;

	doctorInCharge: StaffModel;

	medicalTranscriberId: string;

	medicalTranscriber: StaffModel;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	modelPropGroups: { [s: string]: Group } = DailyCareCPPTModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
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
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Subjective here] off begin
					// % protected region % [Add other validators for Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Subjective here] end
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
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Objective here] off begin
					// % protected region % [Add other validators for Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Objective here] end
			},
			{
				name: 'diagnose',
				// % protected region % [Set displayName for Diagnose here] off begin
				displayName: 'Diagnose',
				// % protected region % [Set displayName for Diagnose here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Diagnose here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Diagnose here] end
				// % protected region % [Set isSensitive for Diagnose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diagnose here] end
				// % protected region % [Set readonly for Diagnose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diagnose here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Diagnose here] off begin
					// % protected region % [Add other validators for Diagnose here] end
				],
				// % protected region % [Add any additional model attribute properties for Diagnose here] off begin
				// % protected region % [Add any additional model attribute properties for Diagnose here] end
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
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Plan here] off begin
					// % protected region % [Add other validators for Plan here] end
				],
				// % protected region % [Add any additional model attribute properties for Plan here] off begin
				// % protected region % [Add any additional model attribute properties for Plan here] end
			},
			{
				name: 'instruction',
				// % protected region % [Set displayName for Instruction here] off begin
				displayName: 'Instruction',
				// % protected region % [Set displayName for Instruction here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Instruction here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Instruction here] end
				// % protected region % [Set isSensitive for Instruction here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Instruction here] end
				// % protected region % [Set readonly for Instruction here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Instruction here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Instruction here] off begin
					// % protected region % [Add other validators for Instruction here] end
				],
				// % protected region % [Add any additional model attribute properties for Instruction here] off begin
				// % protected region % [Add any additional model attribute properties for Instruction here] end
			},
			{
				name: 'verifiedDate',
				// % protected region % [Set displayName for Verified Date here] off begin
				displayName: 'Verified Date',
				// % protected region % [Set displayName for Verified Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Verified Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Verified Date here] end
				// % protected region % [Set isSensitive for Verified Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Verified Date here] end
				// % protected region % [Set readonly for Verified Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Verified Date here] end
				validators: [
					// % protected region % [Add other validators for Verified Date here] off begin
					// % protected region % [Add other validators for Verified Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Verified Date here] off begin
				// % protected region % [Add any additional model attribute properties for Verified Date here] end
			},
			{
				name: 'verifiedBy',
				// % protected region % [Set displayName for Verified By here] off begin
				displayName: 'Verified By',
				// % protected region % [Set displayName for Verified By here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Verified By here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Verified By here] end
				// % protected region % [Set isSensitive for Verified By here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Verified By here] end
				// % protected region % [Set readonly for Verified By here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Verified By here] end
				validators: [
					// % protected region % [Add other validators for Verified By here] off begin
					// % protected region % [Add other validators for Verified By here] end
				],
				// % protected region % [Add any additional model attribute properties for Verified By here] off begin
				// % protected region % [Add any additional model attribute properties for Verified By here] end
			},
			{
				name: 'canceledDate',
				// % protected region % [Set displayName for Canceled Date here] off begin
				displayName: 'Canceled Date',
				// % protected region % [Set displayName for Canceled Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Canceled Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Canceled Date here] end
				// % protected region % [Set isSensitive for Canceled Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Canceled Date here] end
				// % protected region % [Set readonly for Canceled Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Canceled Date here] end
				validators: [
					// % protected region % [Add other validators for Canceled Date here] off begin
					// % protected region % [Add other validators for Canceled Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Canceled Date here] off begin
				// % protected region % [Add any additional model attribute properties for Canceled Date here] end
			},
			{
				name: 'canceledBy',
				// % protected region % [Set displayName for Canceled By here] off begin
				displayName: 'Canceled By',
				// % protected region % [Set displayName for Canceled By here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Canceled By here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Canceled By here] end
				// % protected region % [Set isSensitive for Canceled By here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Canceled By here] end
				// % protected region % [Set readonly for Canceled By here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Canceled By here] end
				validators: [
					// % protected region % [Add other validators for Canceled By here] off begin
					// % protected region % [Add other validators for Canceled By here] end
				],
				// % protected region % [Add any additional model attribute properties for Canceled By here] off begin
				// % protected region % [Add any additional model attribute properties for Canceled By here] end
			},
			{
				name: 'status',
				// % protected region % [Set displayName for Status here] off begin
				displayName: 'Status',
				// % protected region % [Set displayName for Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Status here] end
				// % protected region % [Set isSensitive for Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Status here] end
				// % protected region % [Set readonly for Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Status here] end
				validators: [
					// % protected region % [Add other validators for Status here] off begin
					// % protected region % [Add other validators for Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Status here] off begin
				// % protected region % [Add any additional model attribute properties for Status here] end
			},
			{
				name: 'cpptDateTime',
				// % protected region % [Set displayName for CPPT Date Time here] off begin
				displayName: 'CPPT Date Time',
				// % protected region % [Set displayName for CPPT Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for CPPT Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for CPPT Date Time here] end
				// % protected region % [Set isSensitive for CPPT Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for CPPT Date Time here] end
				// % protected region % [Set readonly for CPPT Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for CPPT Date Time here] end
				validators: [
					// % protected region % [Add other validators for CPPT Date Time here] off begin
					// % protected region % [Add other validators for CPPT Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for CPPT Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for CPPT Date Time here] end
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
				id: 'icd10',
				type: ModelRelationType.ONE,
				name: 'icd10Id',
				// % protected region % [Customise your label for ICD 10 here] off begin
				label: 'ICD 10',
				// % protected region % [Customise your label for ICD 10 here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for ICD 10 here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemType',
				// % protected region % [Customise your display name for ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for ICD 10 here] off begin
					// % protected region % [Add other validators for ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation ICD 10 here] off begin
				// % protected region % [Add any additional field for relation ICD 10 here] end
			},
			{
				id: 'icd9CM',
				type: ModelRelationType.ONE,
				name: 'icd9CMId',
				// % protected region % [Customise your label for ICD 9 CM here] off begin
				label: 'ICD 9 CM',
				// % protected region % [Customise your label for ICD 9 CM here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for ICD 9 CM here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemType',
				// % protected region % [Customise your display name for ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for ICD 9 CM here] off begin
					// % protected region % [Add other validators for ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation ICD 9 CM here] end
			},
			{
				id: 'createdByStaff',
				type: ModelRelationType.ONE,
				name: 'createdByStaffId',
				// % protected region % [Customise your label for Created By Staff here] off begin
				label: 'Created By Staff',
				// % protected region % [Customise your label for Created By Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Created By Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Created By Staff here] end
				validators: [
					// % protected region % [Add other validators for Created By Staff here] off begin
					// % protected region % [Add other validators for Created By Staff here] end
				],
				// % protected region % [Add any additional field for relation Created By Staff here] off begin
				// % protected region % [Add any additional field for relation Created By Staff here] end
			},
			{
				id: 'doctorInCharge',
				type: ModelRelationType.ONE,
				name: 'doctorInChargeId',
				// % protected region % [Customise your label for Doctor in Charge here] off begin
				label: 'Doctor in Charge',
				// % protected region % [Customise your label for Doctor in Charge here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Doctor in Charge here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Doctor in Charge here] end
				validators: [
					// % protected region % [Add other validators for Doctor in Charge here] off begin
					// % protected region % [Add other validators for Doctor in Charge here] end
				],
				// % protected region % [Add any additional field for relation Doctor in Charge here] off begin
				// % protected region % [Add any additional field for relation Doctor in Charge here] end
			},
			{
				id: 'medicalTranscriber',
				type: ModelRelationType.ONE,
				name: 'medicalTranscriberId',
				// % protected region % [Customise your label for Medical Transcriber here] off begin
				label: 'Medical Transcriber',
				// % protected region % [Customise your label for Medical Transcriber here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Medical Transcriber here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Medical Transcriber here] end
				validators: [
					// % protected region % [Add other validators for Medical Transcriber here] off begin
					// % protected region % [Add other validators for Medical Transcriber here] end
				],
				// % protected region % [Add any additional field for relation Medical Transcriber here] off begin
				// % protected region % [Add any additional field for relation Medical Transcriber here] end
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
				case 'subjective':
					break;
				case 'objective':
					break;
				case 'diagnose':
					break;
				case 'plan':
					break;
				case 'instruction':
					break;
				case 'verifiedBy':
					break;
				case 'canceledBy':
					break;
				case 'status':
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
	static deepParse(data: string | { [K in keyof DailyCareCPPTModel]?: DailyCareCPPTModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new DailyCareCPPTModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.icd10) {
			currentModel.icd10Id = json.icd10.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.icd10));
		}

		// Incoming one to many
		if (json.icd9CM) {
			currentModel.icd9CMId = json.icd9CM.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.icd9CM));
		}

		// Incoming one to many
		if (json.createdByStaff) {
			currentModel.createdByStaffId = json.createdByStaff.id;
			returned = _.union(returned, StaffModel.deepParse(json.createdByStaff));
		}

		// Incoming one to many
		if (json.doctorInCharge) {
			currentModel.doctorInChargeId = json.doctorInCharge.id;
			returned = _.union(returned, StaffModel.deepParse(json.doctorInCharge));
		}

		// Incoming one to many
		if (json.medicalTranscriber) {
			currentModel.medicalTranscriberId = json.medicalTranscriber.id;
			returned = _.union(returned, StaffModel.deepParse(json.medicalTranscriber));
		}

		// Incoming one to many
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
	 * `let dailyCareCPPTModel = new DailyCareCPPTModel(data);`
	 *
	 * @param data The input data to be initialised as the DailyCareCPPTModel,
	 *    it is expected as a JSON string or as a nullable DailyCareCPPTModel.
	 */
	constructor(data?: string | Partial<DailyCareCPPTModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<DailyCareCPPTModel>
				: data;

			this.subjective = json.subjective;
			this.objective = json.objective;
			this.diagnose = json.diagnose;
			this.plan = json.plan;
			this.instruction = json.instruction;
			if (json.verifiedDate) {
				this.verifiedDate = new Date(json.verifiedDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.verifiedDate = json.verifiedDate;
			}
			this.verifiedBy = json.verifiedBy;
			if (json.canceledDate) {
				this.canceledDate = new Date(json.canceledDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.canceledDate = json.canceledDate;
			}
			this.canceledBy = json.canceledBy;
			this.status = json.status;
			if (json.cpptDateTime) {
				this.cpptDateTime = new Date(json.cpptDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.cpptDateTime = json.cpptDateTime;
			}
			this.icd10Id = json.icd10Id;
			this.icd10 = json.icd10;
			this.icd9CMId = json.icd9CMId;
			this.icd9CM = json.icd9CM;
			this.createdByStaffId = json.createdByStaffId;
			this.createdByStaff = json.createdByStaff;
			this.doctorInChargeId = json.doctorInChargeId;
			this.doctorInCharge = json.doctorInCharge;
			this.medicalTranscriberId = json.medicalTranscriberId;
			this.medicalTranscriber = json.medicalTranscriber;
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
			subjective: this.subjective,
			objective: this.objective,
			diagnose: this.diagnose,
			plan: this.plan,
			instruction: this.instruction,
			verifiedDate: this.verifiedDate,
			verifiedBy: this.verifiedBy,
			canceledDate: this.canceledDate,
			canceledBy: this.canceledBy,
			status: this.status,
			cpptDateTime: this.cpptDateTime,
			icd10Id: this.icd10Id,
			icd9CMId: this.icd9CMId,
			createdByStaffId: this.createdByStaffId,
			doctorInChargeId: this.doctorInChargeId,
			medicalTranscriberId: this.medicalTranscriberId,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		DailyCareCPPTModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): DailyCareCPPTModel {
		let newModelJson = this.toJSON();

		if (updates.subjective) {
			newModelJson.subjective = updates.subjective;
		}

		if (updates.objective) {
			newModelJson.objective = updates.objective;
		}

		if (updates.diagnose) {
			newModelJson.diagnose = updates.diagnose;
		}

		if (updates.plan) {
			newModelJson.plan = updates.plan;
		}

		if (updates.instruction) {
			newModelJson.instruction = updates.instruction;
		}

		if (updates.verifiedDate) {
			newModelJson.verifiedDate = updates.verifiedDate;
		}

		if (updates.verifiedBy) {
			newModelJson.verifiedBy = updates.verifiedBy;
		}

		if (updates.canceledDate) {
			newModelJson.canceledDate = updates.canceledDate;
		}

		if (updates.canceledBy) {
			newModelJson.canceledBy = updates.canceledBy;
		}

		if (updates.status) {
			newModelJson.status = updates.status;
		}

		if (updates.cpptDateTime) {
			newModelJson.cpptDateTime = updates.cpptDateTime;
		}

		if (updates.icd10Id) {
			newModelJson.icd10Id = updates.icd10Id;
		}

		if (updates.icd9CMId) {
			newModelJson.icd9CMId = updates.icd9CMId;
		}

		if (updates.createdByStaffId) {
			newModelJson.createdByStaffId = updates.createdByStaffId;
		}

		if (updates.doctorInChargeId) {
			newModelJson.doctorInChargeId = updates.doctorInChargeId;
		}

		if (updates.medicalTranscriberId) {
			newModelJson.medicalTranscriberId = updates.medicalTranscriberId;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		return new DailyCareCPPTModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof DailyCareCPPTModel)) {
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
			'icd10Id',
			'icd10',
			'icd9CMId',
			'icd9CM',
			'createdByStaffId',
			'createdByStaff',
			'doctorInChargeId',
			'doctorInCharge',
			'medicalTranscriberId',
			'medicalTranscriber',
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
		if (!this.icd10) {
			this.icd10Id = null;
		} else {
			this.icd10Id = this.icd10.id;
		}

		if (!this.icd9CM) {
			this.icd9CMId = null;
		} else {
			this.icd9CMId = this.icd9CM.id;
		}

		if (!this.createdByStaff) {
			this.createdByStaffId = null;
		} else {
			this.createdByStaffId = this.createdByStaff.id;
		}

		if (!this.doctorInCharge) {
			this.doctorInChargeId = null;
		} else {
			this.doctorInChargeId = this.doctorInCharge.id;
		}

		if (!this.medicalTranscriber) {
			this.medicalTranscriberId = null;
		} else {
			this.medicalTranscriberId = this.medicalTranscriber.id;
		}

		if (!this.medicalExaminationRecord) {
			this.medicalExaminationRecordId = null;
		} else {
			this.medicalExaminationRecordId = this.medicalExaminationRecord.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
