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
import {BedFacilityModel} from '../bedFacility/bed_facility.model';
import {CoTreatingDoctorModel} from '../coTreatingDoctor/co_treating_doctor.model';
import {DiagnosesAndProceduresModel} from '../diagnosesAndProcedures/diagnoses_and_procedures.model';
import {OperatingTheaterMedicalExaminationRecordModel} from '../operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import {RoomFacilityModel} from '../roomFacility/room_facility.model';
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
export class PreoperativeRecordsModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'physicalStatusEvaluation',
		'surgeryRisk',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'startDateTime',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PreoperativeRecordsModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PreoperativeRecordsModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Start Date Time.
	 */
	startDateTime: Date;

	/**
	 * End Date Time.
	 */
	endDateTime: Date;

	/**
	 * Physical Status Evaluation.
	 */
	physicalStatusEvaluation: string;

	/**
	 * Surgery Risk.
	 */
	surgeryRisk: string;

	/**
	 * Psychological State.
	 */
	psychologicalState: string;

	/**
	 * Anesthesia Surgery Risk.
	 */
	anesthesiaSurgeryRisk: string;

	/**
	 * Preoperative Evaluation.
	 */
	preoperativeEvaluation: string;

	/**
	 * Anesthesia Notes.
	 */
	anesthesiaNotes: string;

	/**
	 * Surgical Specialty.
	 */
	surgicalSpecialty: string;

	/**
	 * .
	 */
	antibioticProphylaxisGiven: string;

	/**
	 * Surgery Type.
	 */
	surgeryType: string;

	/**
	 * Surgery Class.
	 */
	surgeryClass: string;

	/**
	 * Surgical Surgery Risk.
	 */
	surgicalSurgeryRisk: string;

	/**
	 * Physical Status Classification.
	 */
	physicalStatusClassification: string;

	/**
	 * Pre Surgery Diagnosis.
	 */
	preSurgeryDiagnosis: string;

	/**
	 * Preoperative Instructions.
	 */
	preoperativeInstructions: string;

	/**
	 * Preoperative Surgical Notes.
	 */
	preoperativeSurgicalNotes: string;

	operatingTheaterMedicalExaminationRecordId: string;

	operatingTheaterMedicalExaminationRecord: OperatingTheaterMedicalExaminationRecordModel;

	anesthesiaMedicalTranscriberId: string;

	anesthesiaMedicalTranscriber: StaffModel;

	anesthesiologistId: string;

	anesthesiologist: StaffModel;

	anesthesiologyNurseId: string;

	anesthesiologyNurse: StaffModel;

	preSurgeryICD10Id: string;

	preSurgeryICD10: DiagnosesAndProceduresModel;

	preSurgeryICD9CMId: string;

	preSurgeryICD9CM: DiagnosesAndProceduresModel;

	preoperativeRoomsId: string;

	preoperativeRooms: RoomFacilityModel;

	surgeonId: string;

	surgeon: StaffModel;

	surgicalMedicalTranscriberId: string;

	surgicalMedicalTranscriber: StaffModel;

	surgicalNurseId: string;

	surgicalNurse: StaffModel;

	additionalAnesthesiologistsIds: string[] = [];

	additionalAnesthesiologists: CoTreatingDoctorModel[];

	additionalSurgeryNursesIds: string[] = [];

	additionalSurgeryNurses: CoTreatingDoctorModel[];

	bedFacilitiesIds: string[] = [];

	bedFacilities: BedFacilityModel[];

	coTreatingAnesthesiologistsIds: string[] = [];

	coTreatingAnesthesiologists: CoTreatingDoctorModel[];

	coTreatingSurgeonsIds: string[] = [];

	coTreatingSurgeons: CoTreatingDoctorModel[];

	modelPropGroups: { [s: string]: Group } = PreoperativeRecordsModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'startDateTime',
				// % protected region % [Set displayName for Start Date Time here] off begin
				displayName: 'Start Date Time',
				// % protected region % [Set displayName for Start Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Start Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Start Date Time here] end
				// % protected region % [Set isSensitive for Start Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Start Date Time here] end
				// % protected region % [Set readonly for Start Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Start Date Time here] end
				validators: [
					// % protected region % [Add other validators for Start Date Time here] off begin
					// % protected region % [Add other validators for Start Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Start Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Start Date Time here] end
			},
			{
				name: 'endDateTime',
				// % protected region % [Set displayName for End Date Time here] off begin
				displayName: 'End Date Time',
				// % protected region % [Set displayName for End Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for End Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for End Date Time here] end
				// % protected region % [Set isSensitive for End Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for End Date Time here] end
				// % protected region % [Set readonly for End Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for End Date Time here] end
				validators: [
					// % protected region % [Add other validators for End Date Time here] off begin
					// % protected region % [Add other validators for End Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for End Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for End Date Time here] end
			},
			{
				name: 'physicalStatusEvaluation',
				// % protected region % [Set displayName for Physical Status Evaluation here] off begin
				displayName: 'Physical Status Evaluation',
				// % protected region % [Set displayName for Physical Status Evaluation here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Physical Status Evaluation here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Physical Status Evaluation here] end
				// % protected region % [Set isSensitive for Physical Status Evaluation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Physical Status Evaluation here] end
				// % protected region % [Set readonly for Physical Status Evaluation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Physical Status Evaluation here] end
				validators: [
					// % protected region % [Add other validators for Physical Status Evaluation here] off begin
					// % protected region % [Add other validators for Physical Status Evaluation here] end
				],
				// % protected region % [Add any additional model attribute properties for Physical Status Evaluation here] off begin
				// % protected region % [Add any additional model attribute properties for Physical Status Evaluation here] end
			},
			{
				name: 'surgeryRisk',
				// % protected region % [Set displayName for Surgery Risk here] off begin
				displayName: 'Surgery Risk',
				// % protected region % [Set displayName for Surgery Risk here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Surgery Risk here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Surgery Risk here] end
				// % protected region % [Set isSensitive for Surgery Risk here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surgery Risk here] end
				// % protected region % [Set readonly for Surgery Risk here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surgery Risk here] end
				validators: [
					// % protected region % [Add other validators for Surgery Risk here] off begin
					// % protected region % [Add other validators for Surgery Risk here] end
				],
				// % protected region % [Add any additional model attribute properties for Surgery Risk here] off begin
				// % protected region % [Add any additional model attribute properties for Surgery Risk here] end
			},
			{
				name: 'psychologicalState',
				// % protected region % [Set displayName for Psychological State here] off begin
				displayName: 'Psychological State',
				// % protected region % [Set displayName for Psychological State here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Psychological State here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Psychological State here] end
				// % protected region % [Set isSensitive for Psychological State here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Psychological State here] end
				// % protected region % [Set readonly for Psychological State here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Psychological State here] end
				validators: [
					// % protected region % [Add other validators for Psychological State here] off begin
					// % protected region % [Add other validators for Psychological State here] end
				],
				// % protected region % [Add any additional model attribute properties for Psychological State here] off begin
				// % protected region % [Add any additional model attribute properties for Psychological State here] end
			},
			{
				name: 'anesthesiaSurgeryRisk',
				// % protected region % [Set displayName for Anesthesia Surgery Risk here] off begin
				displayName: 'Anesthesia Surgery Risk',
				// % protected region % [Set displayName for Anesthesia Surgery Risk here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Anesthesia Surgery Risk here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Anesthesia Surgery Risk here] end
				// % protected region % [Set isSensitive for Anesthesia Surgery Risk here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia Surgery Risk here] end
				// % protected region % [Set readonly for Anesthesia Surgery Risk here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia Surgery Risk here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Surgery Risk here] off begin
					// % protected region % [Add other validators for Anesthesia Surgery Risk here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia Surgery Risk here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia Surgery Risk here] end
			},
			{
				name: 'preoperativeEvaluation',
				// % protected region % [Set displayName for Preoperative Evaluation here] off begin
				displayName: 'Preoperative Evaluation',
				// % protected region % [Set displayName for Preoperative Evaluation here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Preoperative Evaluation here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Preoperative Evaluation here] end
				// % protected region % [Set isSensitive for Preoperative Evaluation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Preoperative Evaluation here] end
				// % protected region % [Set readonly for Preoperative Evaluation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Preoperative Evaluation here] end
				validators: [
					// % protected region % [Add other validators for Preoperative Evaluation here] off begin
					// % protected region % [Add other validators for Preoperative Evaluation here] end
				],
				// % protected region % [Add any additional model attribute properties for Preoperative Evaluation here] off begin
				// % protected region % [Add any additional model attribute properties for Preoperative Evaluation here] end
			},
			{
				name: 'anesthesiaNotes',
				// % protected region % [Set displayName for Anesthesia Notes here] off begin
				displayName: 'Anesthesia Notes',
				// % protected region % [Set displayName for Anesthesia Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Anesthesia Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Anesthesia Notes here] end
				// % protected region % [Set isSensitive for Anesthesia Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia Notes here] end
				// % protected region % [Set readonly for Anesthesia Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia Notes here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Notes here] off begin
					// % protected region % [Add other validators for Anesthesia Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia Notes here] end
			},
			{
				name: 'surgicalSpecialty',
				// % protected region % [Set displayName for Surgical Specialty here] off begin
				displayName: 'Surgical Specialty',
				// % protected region % [Set displayName for Surgical Specialty here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Surgical Specialty here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Surgical Specialty here] end
				// % protected region % [Set isSensitive for Surgical Specialty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surgical Specialty here] end
				// % protected region % [Set readonly for Surgical Specialty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surgical Specialty here] end
				validators: [
					// % protected region % [Add other validators for Surgical Specialty here] off begin
					// % protected region % [Add other validators for Surgical Specialty here] end
				],
				// % protected region % [Add any additional model attribute properties for Surgical Specialty here] off begin
				// % protected region % [Add any additional model attribute properties for Surgical Specialty here] end
			},
			{
				name: 'antibioticProphylaxisGiven',
				// % protected region % [Set displayName for Antibiotic Prophylaxis Given here] off begin
				displayName: 'Antibiotic Prophylaxis Given',
				// % protected region % [Set displayName for Antibiotic Prophylaxis Given here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Antibiotic Prophylaxis Given here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Antibiotic Prophylaxis Given here] end
				// % protected region % [Set isSensitive for Antibiotic Prophylaxis Given here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Antibiotic Prophylaxis Given here] end
				// % protected region % [Set readonly for Antibiotic Prophylaxis Given here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Antibiotic Prophylaxis Given here] end
				validators: [
					// % protected region % [Add other validators for Antibiotic Prophylaxis Given here] off begin
					// % protected region % [Add other validators for Antibiotic Prophylaxis Given here] end
				],
				// % protected region % [Add any additional model attribute properties for Antibiotic Prophylaxis Given here] off begin
				// % protected region % [Add any additional model attribute properties for Antibiotic Prophylaxis Given here] end
			},
			{
				name: 'surgeryType',
				// % protected region % [Set displayName for Surgery Type here] off begin
				displayName: 'Surgery Type',
				// % protected region % [Set displayName for Surgery Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Surgery Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Surgery Type here] end
				// % protected region % [Set isSensitive for Surgery Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surgery Type here] end
				// % protected region % [Set readonly for Surgery Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surgery Type here] end
				validators: [
					// % protected region % [Add other validators for Surgery Type here] off begin
					// % protected region % [Add other validators for Surgery Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Surgery Type here] off begin
				// % protected region % [Add any additional model attribute properties for Surgery Type here] end
			},
			{
				name: 'surgeryClass',
				// % protected region % [Set displayName for Surgery Class here] off begin
				displayName: 'Surgery Class',
				// % protected region % [Set displayName for Surgery Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Surgery Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Surgery Class here] end
				// % protected region % [Set isSensitive for Surgery Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surgery Class here] end
				// % protected region % [Set readonly for Surgery Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surgery Class here] end
				validators: [
					// % protected region % [Add other validators for Surgery Class here] off begin
					// % protected region % [Add other validators for Surgery Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Surgery Class here] off begin
				// % protected region % [Add any additional model attribute properties for Surgery Class here] end
			},
			{
				name: 'surgicalSurgeryRisk',
				// % protected region % [Set displayName for Surgical Surgery Risk here] off begin
				displayName: 'Surgical Surgery Risk',
				// % protected region % [Set displayName for Surgical Surgery Risk here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Surgical Surgery Risk here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Surgical Surgery Risk here] end
				// % protected region % [Set isSensitive for Surgical Surgery Risk here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surgical Surgery Risk here] end
				// % protected region % [Set readonly for Surgical Surgery Risk here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surgical Surgery Risk here] end
				validators: [
					// % protected region % [Add other validators for Surgical Surgery Risk here] off begin
					// % protected region % [Add other validators for Surgical Surgery Risk here] end
				],
				// % protected region % [Add any additional model attribute properties for Surgical Surgery Risk here] off begin
				// % protected region % [Add any additional model attribute properties for Surgical Surgery Risk here] end
			},
			{
				name: 'physicalStatusClassification',
				// % protected region % [Set displayName for Physical Status Classification here] off begin
				displayName: 'Physical Status Classification',
				// % protected region % [Set displayName for Physical Status Classification here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Physical Status Classification here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Physical Status Classification here] end
				// % protected region % [Set isSensitive for Physical Status Classification here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Physical Status Classification here] end
				// % protected region % [Set readonly for Physical Status Classification here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Physical Status Classification here] end
				validators: [
					// % protected region % [Add other validators for Physical Status Classification here] off begin
					// % protected region % [Add other validators for Physical Status Classification here] end
				],
				// % protected region % [Add any additional model attribute properties for Physical Status Classification here] off begin
				// % protected region % [Add any additional model attribute properties for Physical Status Classification here] end
			},
			{
				name: 'preSurgeryDiagnosis',
				// % protected region % [Set displayName for Pre Surgery Diagnosis here] off begin
				displayName: 'Pre Surgery Diagnosis',
				// % protected region % [Set displayName for Pre Surgery Diagnosis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pre Surgery Diagnosis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pre Surgery Diagnosis here] end
				// % protected region % [Set isSensitive for Pre Surgery Diagnosis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pre Surgery Diagnosis here] end
				// % protected region % [Set readonly for Pre Surgery Diagnosis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pre Surgery Diagnosis here] end
				validators: [
					// % protected region % [Add other validators for Pre Surgery Diagnosis here] off begin
					// % protected region % [Add other validators for Pre Surgery Diagnosis here] end
				],
				// % protected region % [Add any additional model attribute properties for Pre Surgery Diagnosis here] off begin
				// % protected region % [Add any additional model attribute properties for Pre Surgery Diagnosis here] end
			},
			{
				name: 'preoperativeInstructions',
				// % protected region % [Set displayName for Preoperative Instructions here] off begin
				displayName: 'Preoperative Instructions',
				// % protected region % [Set displayName for Preoperative Instructions here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Preoperative Instructions here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Preoperative Instructions here] end
				// % protected region % [Set isSensitive for Preoperative Instructions here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Preoperative Instructions here] end
				// % protected region % [Set readonly for Preoperative Instructions here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Preoperative Instructions here] end
				validators: [
					// % protected region % [Add other validators for Preoperative Instructions here] off begin
					// % protected region % [Add other validators for Preoperative Instructions here] end
				],
				// % protected region % [Add any additional model attribute properties for Preoperative Instructions here] off begin
				// % protected region % [Add any additional model attribute properties for Preoperative Instructions here] end
			},
			{
				name: 'preoperativeSurgicalNotes',
				// % protected region % [Set displayName for Preoperative Surgical Notes here] off begin
				displayName: 'Preoperative Surgical Notes',
				// % protected region % [Set displayName for Preoperative Surgical Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Preoperative Surgical Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Preoperative Surgical Notes here] end
				// % protected region % [Set isSensitive for Preoperative Surgical Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Preoperative Surgical Notes here] end
				// % protected region % [Set readonly for Preoperative Surgical Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Preoperative Surgical Notes here] end
				validators: [
					// % protected region % [Add other validators for Preoperative Surgical Notes here] off begin
					// % protected region % [Add other validators for Preoperative Surgical Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Preoperative Surgical Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Preoperative Surgical Notes here] end
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
				id: 'additionalAnesthesiologists',
				type: ModelRelationType.MANY,
				name: 'additionalAnesthesiologistsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Additional Anesthesiologists here] off begin
				label: 'Additional Anesthesiologists',
				// % protected region % [Customise your 1-1 or 1-M label for Additional Anesthesiologists here] end
				entityName: 'CoTreatingDoctorModel',
				// % protected region % [Customise your display name for Additional Anesthesiologists here] off begin
				displayName: 'doctorNotes',
				// % protected region % [Customise your display name for Additional Anesthesiologists here] end
				validators: [
					// % protected region % [Add other validators for Additional Anesthesiologists here] off begin
					// % protected region % [Add other validators for Additional Anesthesiologists here] end
				],
				// % protected region % [Add any additional field for relation Additional Anesthesiologists here] off begin
				// % protected region % [Add any additional field for relation Additional Anesthesiologists here] end
			},
			{
				id: 'additionalSurgeryNurses',
				type: ModelRelationType.MANY,
				name: 'additionalSurgeryNursesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Additional Surgery Nurses here] off begin
				label: 'Additional Surgery Nurses',
				// % protected region % [Customise your 1-1 or 1-M label for Additional Surgery Nurses here] end
				entityName: 'CoTreatingDoctorModel',
				// % protected region % [Customise your display name for Additional Surgery Nurses here] off begin
				displayName: 'doctorNotes',
				// % protected region % [Customise your display name for Additional Surgery Nurses here] end
				validators: [
					// % protected region % [Add other validators for Additional Surgery Nurses here] off begin
					// % protected region % [Add other validators for Additional Surgery Nurses here] end
				],
				// % protected region % [Add any additional field for relation Additional Surgery Nurses here] off begin
				// % protected region % [Add any additional field for relation Additional Surgery Nurses here] end
			},
			{
				id: 'bedFacilities',
				type: ModelRelationType.MANY,
				name: 'bedFacilitiesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Bed Facilities here] off begin
				label: 'Bed Facilities',
				// % protected region % [Customise your 1-1 or 1-M label for Bed Facilities here] end
				entityName: 'BedFacilityModel',
				// % protected region % [Customise your display name for Bed Facilities here] off begin
				displayName: 'bedNumber',
				// % protected region % [Customise your display name for Bed Facilities here] end
				validators: [
					// % protected region % [Add other validators for Bed Facilities here] off begin
					// % protected region % [Add other validators for Bed Facilities here] end
				],
				// % protected region % [Add any additional field for relation Bed Facilities here] off begin
				// % protected region % [Add any additional field for relation Bed Facilities here] end
			},
			{
				id: 'coTreatingAnesthesiologists',
				type: ModelRelationType.MANY,
				name: 'coTreatingAnesthesiologistsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Co Treating Anesthesiologists here] off begin
				label: 'Co Treating Anesthesiologists',
				// % protected region % [Customise your 1-1 or 1-M label for Co Treating Anesthesiologists here] end
				entityName: 'CoTreatingDoctorModel',
				// % protected region % [Customise your display name for Co Treating Anesthesiologists here] off begin
				displayName: 'doctorNotes',
				// % protected region % [Customise your display name for Co Treating Anesthesiologists here] end
				validators: [
					// % protected region % [Add other validators for Co Treating Anesthesiologists here] off begin
					// % protected region % [Add other validators for Co Treating Anesthesiologists here] end
				],
				// % protected region % [Add any additional field for relation Co Treating Anesthesiologists here] off begin
				// % protected region % [Add any additional field for relation Co Treating Anesthesiologists here] end
			},
			{
				id: 'coTreatingSurgeons',
				type: ModelRelationType.MANY,
				name: 'coTreatingSurgeonsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Co Treating Surgeons here] off begin
				label: 'Co Treating Surgeons',
				// % protected region % [Customise your 1-1 or 1-M label for Co Treating Surgeons here] end
				entityName: 'CoTreatingDoctorModel',
				// % protected region % [Customise your display name for Co Treating Surgeons here] off begin
				displayName: 'doctorNotes',
				// % protected region % [Customise your display name for Co Treating Surgeons here] end
				validators: [
					// % protected region % [Add other validators for Co Treating Surgeons here] off begin
					// % protected region % [Add other validators for Co Treating Surgeons here] end
				],
				// % protected region % [Add any additional field for relation Co Treating Surgeons here] off begin
				// % protected region % [Add any additional field for relation Co Treating Surgeons here] end
			},
			{
				id: 'anesthesiaMedicalTranscriber',
				type: ModelRelationType.ONE,
				name: 'anesthesiaMedicalTranscriberId',
				// % protected region % [Customise your label for Anesthesia Medical Transcriber here] off begin
				label: 'Anesthesia Medical Transcriber',
				// % protected region % [Customise your label for Anesthesia Medical Transcriber here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Anesthesia Medical Transcriber here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Anesthesia Medical Transcriber here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Medical Transcriber here] off begin
					// % protected region % [Add other validators for Anesthesia Medical Transcriber here] end
				],
				// % protected region % [Add any additional field for relation Anesthesia Medical Transcriber here] off begin
				// % protected region % [Add any additional field for relation Anesthesia Medical Transcriber here] end
			},
			{
				id: 'anesthesiologist',
				type: ModelRelationType.ONE,
				name: 'anesthesiologistId',
				// % protected region % [Customise your label for Anesthesiologist here] off begin
				label: 'Anesthesiologist',
				// % protected region % [Customise your label for Anesthesiologist here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Anesthesiologist here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Anesthesiologist here] end
				validators: [
					// % protected region % [Add other validators for Anesthesiologist here] off begin
					// % protected region % [Add other validators for Anesthesiologist here] end
				],
				// % protected region % [Add any additional field for relation Anesthesiologist here] off begin
				// % protected region % [Add any additional field for relation Anesthesiologist here] end
			},
			{
				id: 'anesthesiologyNurse',
				type: ModelRelationType.ONE,
				name: 'anesthesiologyNurseId',
				// % protected region % [Customise your label for Anesthesiology Nurse here] off begin
				label: 'Anesthesiology Nurse',
				// % protected region % [Customise your label for Anesthesiology Nurse here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Anesthesiology Nurse here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Anesthesiology Nurse here] end
				validators: [
					// % protected region % [Add other validators for Anesthesiology Nurse here] off begin
					// % protected region % [Add other validators for Anesthesiology Nurse here] end
				],
				// % protected region % [Add any additional field for relation Anesthesiology Nurse here] off begin
				// % protected region % [Add any additional field for relation Anesthesiology Nurse here] end
			},
			{
				id: 'preSurgeryICD10',
				type: ModelRelationType.ONE,
				name: 'preSurgeryICD10Id',
				// % protected region % [Customise your label for Pre Surgery ICD 10 here] off begin
				label: 'Pre Surgery ICD 10',
				// % protected region % [Customise your label for Pre Surgery ICD 10 here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for Pre Surgery ICD 10 here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemType',
				// % protected region % [Customise your display name for Pre Surgery ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for Pre Surgery ICD 10 here] off begin
					// % protected region % [Add other validators for Pre Surgery ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation Pre Surgery ICD 10 here] off begin
				// % protected region % [Add any additional field for relation Pre Surgery ICD 10 here] end
			},
			{
				id: 'preSurgeryICD9CM',
				type: ModelRelationType.ONE,
				name: 'preSurgeryICD9CMId',
				// % protected region % [Customise your label for Pre Surgery ICD 9 CM here] off begin
				label: 'Pre Surgery ICD 9 CM',
				// % protected region % [Customise your label for Pre Surgery ICD 9 CM here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for Pre Surgery ICD 9 CM here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemType',
				// % protected region % [Customise your display name for Pre Surgery ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for Pre Surgery ICD 9 CM here] off begin
					// % protected region % [Add other validators for Pre Surgery ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation Pre Surgery ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation Pre Surgery ICD 9 CM here] end
			},
			{
				id: 'operatingTheaterMedicalExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'operatingTheaterMedicalExaminationRecordId',
				// % protected region % [Customise your label for Operating Theater Medical Examination Record here] off begin
				label: 'Operating Theater Medical Examination Record',
				// % protected region % [Customise your label for Operating Theater Medical Examination Record here] end
				entityName: 'OperatingTheaterMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Operating Theater Medical Examination Record here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'hasConfirmedIdentity',
				// % protected region % [Customise your display name for Operating Theater Medical Examination Record here] end
				validators: [
					// % protected region % [Add other validators for Operating Theater Medical Examination Record here] off begin
					// % protected region % [Add other validators for Operating Theater Medical Examination Record here] end
				],
				// % protected region % [Add any additional field for relation Operating Theater Medical Examination Record here] off begin
				// % protected region % [Add any additional field for relation Operating Theater Medical Examination Record here] end
			},
			{
				id: 'preoperativeRooms',
				type: ModelRelationType.ONE,
				name: 'preoperativeRoomsId',
				// % protected region % [Customise your label for Preoperative Rooms here] off begin
				label: 'Preoperative Rooms',
				// % protected region % [Customise your label for Preoperative Rooms here] end
				entityName: 'RoomFacilityModel',
				// % protected region % [Customise your display name for Preoperative Rooms here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'roomNumber',
				// % protected region % [Customise your display name for Preoperative Rooms here] end
				validators: [
					// % protected region % [Add other validators for Preoperative Rooms here] off begin
					// % protected region % [Add other validators for Preoperative Rooms here] end
				],
				// % protected region % [Add any additional field for relation Preoperative Rooms here] off begin
				// % protected region % [Add any additional field for relation Preoperative Rooms here] end
			},
			{
				id: 'surgeon',
				type: ModelRelationType.ONE,
				name: 'surgeonId',
				// % protected region % [Customise your label for Surgeon here] off begin
				label: 'Surgeon',
				// % protected region % [Customise your label for Surgeon here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Surgeon here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Surgeon here] end
				validators: [
					// % protected region % [Add other validators for Surgeon here] off begin
					// % protected region % [Add other validators for Surgeon here] end
				],
				// % protected region % [Add any additional field for relation Surgeon here] off begin
				// % protected region % [Add any additional field for relation Surgeon here] end
			},
			{
				id: 'surgicalMedicalTranscriber',
				type: ModelRelationType.ONE,
				name: 'surgicalMedicalTranscriberId',
				// % protected region % [Customise your label for Surgical Medical Transcriber here] off begin
				label: 'Surgical Medical Transcriber',
				// % protected region % [Customise your label for Surgical Medical Transcriber here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Surgical Medical Transcriber here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Surgical Medical Transcriber here] end
				validators: [
					// % protected region % [Add other validators for Surgical Medical Transcriber here] off begin
					// % protected region % [Add other validators for Surgical Medical Transcriber here] end
				],
				// % protected region % [Add any additional field for relation Surgical Medical Transcriber here] off begin
				// % protected region % [Add any additional field for relation Surgical Medical Transcriber here] end
			},
			{
				id: 'surgicalNurse',
				type: ModelRelationType.ONE,
				name: 'surgicalNurseId',
				// % protected region % [Customise your label for Surgical Nurse here] off begin
				label: 'Surgical Nurse',
				// % protected region % [Customise your label for Surgical Nurse here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Surgical Nurse here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Surgical Nurse here] end
				validators: [
					// % protected region % [Add other validators for Surgical Nurse here] off begin
					// % protected region % [Add other validators for Surgical Nurse here] end
				],
				// % protected region % [Add any additional field for relation Surgical Nurse here] off begin
				// % protected region % [Add any additional field for relation Surgical Nurse here] end
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
				case 'physicalStatusEvaluation':
					break;
				case 'surgeryRisk':
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
	static deepParse(data: string | { [K in keyof PreoperativeRecordsModel]?: PreoperativeRecordsModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PreoperativeRecordsModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.operatingTheaterMedicalExaminationRecord) {
			currentModel.operatingTheaterMedicalExaminationRecordId = json.operatingTheaterMedicalExaminationRecord.id;
			returned = _.union(returned, OperatingTheaterMedicalExaminationRecordModel.deepParse(json.operatingTheaterMedicalExaminationRecord));
		}

		// Incoming one to many
		if (json.anesthesiaMedicalTranscriber) {
			currentModel.anesthesiaMedicalTranscriberId = json.anesthesiaMedicalTranscriber.id;
			returned = _.union(returned, StaffModel.deepParse(json.anesthesiaMedicalTranscriber));
		}

		// Incoming one to many
		if (json.anesthesiologist) {
			currentModel.anesthesiologistId = json.anesthesiologist.id;
			returned = _.union(returned, StaffModel.deepParse(json.anesthesiologist));
		}

		// Incoming one to many
		if (json.anesthesiologyNurse) {
			currentModel.anesthesiologyNurseId = json.anesthesiologyNurse.id;
			returned = _.union(returned, StaffModel.deepParse(json.anesthesiologyNurse));
		}

		// Incoming one to many
		if (json.preSurgeryICD10) {
			currentModel.preSurgeryICD10Id = json.preSurgeryICD10.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.preSurgeryICD10));
		}

		// Incoming one to many
		if (json.preSurgeryICD9CM) {
			currentModel.preSurgeryICD9CMId = json.preSurgeryICD9CM.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.preSurgeryICD9CM));
		}

		// Incoming one to many
		if (json.preoperativeRooms) {
			currentModel.preoperativeRoomsId = json.preoperativeRooms.id;
			returned = _.union(returned, RoomFacilityModel.deepParse(json.preoperativeRooms));
		}

		// Incoming one to many
		if (json.surgeon) {
			currentModel.surgeonId = json.surgeon.id;
			returned = _.union(returned, StaffModel.deepParse(json.surgeon));
		}

		// Incoming one to many
		if (json.surgicalMedicalTranscriber) {
			currentModel.surgicalMedicalTranscriberId = json.surgicalMedicalTranscriber.id;
			returned = _.union(returned, StaffModel.deepParse(json.surgicalMedicalTranscriber));
		}

		// Incoming one to many
		if (json.surgicalNurse) {
			currentModel.surgicalNurseId = json.surgicalNurse.id;
			returned = _.union(returned, StaffModel.deepParse(json.surgicalNurse));
		}

		// Outgoing one to many
		if (json.additionalAnesthesiologists) {
			currentModel.additionalAnesthesiologistsIds = json.additionalAnesthesiologists.map(model => model.id);
			returned = _.union(returned, _.flatten(json.additionalAnesthesiologists.map(model => CoTreatingDoctorModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.additionalSurgeryNurses) {
			currentModel.additionalSurgeryNursesIds = json.additionalSurgeryNurses.map(model => model.id);
			returned = _.union(returned, _.flatten(json.additionalSurgeryNurses.map(model => CoTreatingDoctorModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bedFacilities) {
			currentModel.bedFacilitiesIds = json.bedFacilities.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bedFacilities.map(model => BedFacilityModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.coTreatingAnesthesiologists) {
			currentModel.coTreatingAnesthesiologistsIds = json.coTreatingAnesthesiologists.map(model => model.id);
			returned = _.union(returned, _.flatten(json.coTreatingAnesthesiologists.map(model => CoTreatingDoctorModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.coTreatingSurgeons) {
			currentModel.coTreatingSurgeonsIds = json.coTreatingSurgeons.map(model => model.id);
			returned = _.union(returned, _.flatten(json.coTreatingSurgeons.map(model => CoTreatingDoctorModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let preoperativeRecordsModel = new PreoperativeRecordsModel(data);`
	 *
	 * @param data The input data to be initialised as the PreoperativeRecordsModel,
	 *    it is expected as a JSON string or as a nullable PreoperativeRecordsModel.
	 */
	constructor(data?: string | Partial<PreoperativeRecordsModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PreoperativeRecordsModel>
				: data;

			if (json.startDateTime) {
				this.startDateTime = new Date(json.startDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.startDateTime = json.startDateTime;
			}
			if (json.endDateTime) {
				this.endDateTime = new Date(json.endDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.endDateTime = json.endDateTime;
			}
			this.physicalStatusEvaluation = json.physicalStatusEvaluation;
			this.surgeryRisk = json.surgeryRisk;
			this.psychologicalState = json.psychologicalState;
			this.anesthesiaSurgeryRisk = json.anesthesiaSurgeryRisk;
			this.preoperativeEvaluation = json.preoperativeEvaluation;
			this.anesthesiaNotes = json.anesthesiaNotes;
			this.surgicalSpecialty = json.surgicalSpecialty;
			this.antibioticProphylaxisGiven = json.antibioticProphylaxisGiven;
			this.surgeryType = json.surgeryType;
			this.surgeryClass = json.surgeryClass;
			this.surgicalSurgeryRisk = json.surgicalSurgeryRisk;
			this.physicalStatusClassification = json.physicalStatusClassification;
			this.preSurgeryDiagnosis = json.preSurgeryDiagnosis;
			this.preoperativeInstructions = json.preoperativeInstructions;
			this.preoperativeSurgicalNotes = json.preoperativeSurgicalNotes;
			this.operatingTheaterMedicalExaminationRecordId = json.operatingTheaterMedicalExaminationRecordId;
			this.operatingTheaterMedicalExaminationRecord = json.operatingTheaterMedicalExaminationRecord;
			this.anesthesiaMedicalTranscriberId = json.anesthesiaMedicalTranscriberId;
			this.anesthesiaMedicalTranscriber = json.anesthesiaMedicalTranscriber;
			this.anesthesiologistId = json.anesthesiologistId;
			this.anesthesiologist = json.anesthesiologist;
			this.anesthesiologyNurseId = json.anesthesiologyNurseId;
			this.anesthesiologyNurse = json.anesthesiologyNurse;
			this.preSurgeryICD10Id = json.preSurgeryICD10Id;
			this.preSurgeryICD10 = json.preSurgeryICD10;
			this.preSurgeryICD9CMId = json.preSurgeryICD9CMId;
			this.preSurgeryICD9CM = json.preSurgeryICD9CM;
			this.preoperativeRoomsId = json.preoperativeRoomsId;
			this.preoperativeRooms = json.preoperativeRooms;
			this.surgeonId = json.surgeonId;
			this.surgeon = json.surgeon;
			this.surgicalMedicalTranscriberId = json.surgicalMedicalTranscriberId;
			this.surgicalMedicalTranscriber = json.surgicalMedicalTranscriber;
			this.surgicalNurseId = json.surgicalNurseId;
			this.surgicalNurse = json.surgicalNurse;
			this.additionalAnesthesiologistsIds = json.additionalAnesthesiologistsIds;
			this.additionalAnesthesiologists = json.additionalAnesthesiologists;
			this.additionalSurgeryNursesIds = json.additionalSurgeryNursesIds;
			this.additionalSurgeryNurses = json.additionalSurgeryNurses;
			this.bedFacilitiesIds = json.bedFacilitiesIds;
			this.bedFacilities = json.bedFacilities;
			this.coTreatingAnesthesiologistsIds = json.coTreatingAnesthesiologistsIds;
			this.coTreatingAnesthesiologists = json.coTreatingAnesthesiologists;
			this.coTreatingSurgeonsIds = json.coTreatingSurgeonsIds;
			this.coTreatingSurgeons = json.coTreatingSurgeons;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			startDateTime: this.startDateTime,
			endDateTime: this.endDateTime,
			physicalStatusEvaluation: this.physicalStatusEvaluation,
			surgeryRisk: this.surgeryRisk,
			psychologicalState: this.psychologicalState,
			anesthesiaSurgeryRisk: this.anesthesiaSurgeryRisk,
			preoperativeEvaluation: this.preoperativeEvaluation,
			anesthesiaNotes: this.anesthesiaNotes,
			surgicalSpecialty: this.surgicalSpecialty,
			antibioticProphylaxisGiven: this.antibioticProphylaxisGiven,
			surgeryType: this.surgeryType,
			surgeryClass: this.surgeryClass,
			surgicalSurgeryRisk: this.surgicalSurgeryRisk,
			physicalStatusClassification: this.physicalStatusClassification,
			preSurgeryDiagnosis: this.preSurgeryDiagnosis,
			preoperativeInstructions: this.preoperativeInstructions,
			preoperativeSurgicalNotes: this.preoperativeSurgicalNotes,
			operatingTheaterMedicalExaminationRecordId: this.operatingTheaterMedicalExaminationRecordId,
			anesthesiaMedicalTranscriberId: this.anesthesiaMedicalTranscriberId,
			anesthesiologistId: this.anesthesiologistId,
			anesthesiologyNurseId: this.anesthesiologyNurseId,
			preSurgeryICD10Id: this.preSurgeryICD10Id,
			preSurgeryICD9CMId: this.preSurgeryICD9CMId,
			preoperativeRoomsId: this.preoperativeRoomsId,
			surgeonId: this.surgeonId,
			surgicalMedicalTranscriberId: this.surgicalMedicalTranscriberId,
			surgicalNurseId: this.surgicalNurseId,
			additionalAnesthesiologistsIds: this.additionalAnesthesiologistsIds,
			additionalSurgeryNursesIds: this.additionalSurgeryNursesIds,
			bedFacilitiesIds: this.bedFacilitiesIds,
			coTreatingAnesthesiologistsIds: this.coTreatingAnesthesiologistsIds,
			coTreatingSurgeonsIds: this.coTreatingSurgeonsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PreoperativeRecordsModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PreoperativeRecordsModel {
		let newModelJson = this.toJSON();

		if (updates.startDateTime) {
			newModelJson.startDateTime = updates.startDateTime;
		}

		if (updates.endDateTime) {
			newModelJson.endDateTime = updates.endDateTime;
		}

		if (updates.physicalStatusEvaluation) {
			newModelJson.physicalStatusEvaluation = updates.physicalStatusEvaluation;
		}

		if (updates.surgeryRisk) {
			newModelJson.surgeryRisk = updates.surgeryRisk;
		}

		if (updates.psychologicalState) {
			newModelJson.psychologicalState = updates.psychologicalState;
		}

		if (updates.anesthesiaSurgeryRisk) {
			newModelJson.anesthesiaSurgeryRisk = updates.anesthesiaSurgeryRisk;
		}

		if (updates.preoperativeEvaluation) {
			newModelJson.preoperativeEvaluation = updates.preoperativeEvaluation;
		}

		if (updates.anesthesiaNotes) {
			newModelJson.anesthesiaNotes = updates.anesthesiaNotes;
		}

		if (updates.surgicalSpecialty) {
			newModelJson.surgicalSpecialty = updates.surgicalSpecialty;
		}

		if (updates.antibioticProphylaxisGiven) {
			newModelJson.antibioticProphylaxisGiven = updates.antibioticProphylaxisGiven;
		}

		if (updates.surgeryType) {
			newModelJson.surgeryType = updates.surgeryType;
		}

		if (updates.surgeryClass) {
			newModelJson.surgeryClass = updates.surgeryClass;
		}

		if (updates.surgicalSurgeryRisk) {
			newModelJson.surgicalSurgeryRisk = updates.surgicalSurgeryRisk;
		}

		if (updates.physicalStatusClassification) {
			newModelJson.physicalStatusClassification = updates.physicalStatusClassification;
		}

		if (updates.preSurgeryDiagnosis) {
			newModelJson.preSurgeryDiagnosis = updates.preSurgeryDiagnosis;
		}

		if (updates.preoperativeInstructions) {
			newModelJson.preoperativeInstructions = updates.preoperativeInstructions;
		}

		if (updates.preoperativeSurgicalNotes) {
			newModelJson.preoperativeSurgicalNotes = updates.preoperativeSurgicalNotes;
		}

		if (updates.operatingTheaterMedicalExaminationRecordId) {
			newModelJson.operatingTheaterMedicalExaminationRecordId = updates.operatingTheaterMedicalExaminationRecordId;
		}

		if (updates.anesthesiaMedicalTranscriberId) {
			newModelJson.anesthesiaMedicalTranscriberId = updates.anesthesiaMedicalTranscriberId;
		}

		if (updates.anesthesiologistId) {
			newModelJson.anesthesiologistId = updates.anesthesiologistId;
		}

		if (updates.anesthesiologyNurseId) {
			newModelJson.anesthesiologyNurseId = updates.anesthesiologyNurseId;
		}

		if (updates.preSurgeryICD10Id) {
			newModelJson.preSurgeryICD10Id = updates.preSurgeryICD10Id;
		}

		if (updates.preSurgeryICD9CMId) {
			newModelJson.preSurgeryICD9CMId = updates.preSurgeryICD9CMId;
		}

		if (updates.preoperativeRoomsId) {
			newModelJson.preoperativeRoomsId = updates.preoperativeRoomsId;
		}

		if (updates.surgeonId) {
			newModelJson.surgeonId = updates.surgeonId;
		}

		if (updates.surgicalMedicalTranscriberId) {
			newModelJson.surgicalMedicalTranscriberId = updates.surgicalMedicalTranscriberId;
		}

		if (updates.surgicalNurseId) {
			newModelJson.surgicalNurseId = updates.surgicalNurseId;
		}

		if (updates.additionalAnesthesiologistsIds) {
			newModelJson.additionalAnesthesiologistsIds = updates.additionalAnesthesiologistsIds;
		}

		if (updates.additionalSurgeryNursesIds) {
			newModelJson.additionalSurgeryNursesIds = updates.additionalSurgeryNursesIds;
		}

		if (updates.bedFacilitiesIds) {
			newModelJson.bedFacilitiesIds = updates.bedFacilitiesIds;
		}

		if (updates.coTreatingAnesthesiologistsIds) {
			newModelJson.coTreatingAnesthesiologistsIds = updates.coTreatingAnesthesiologistsIds;
		}

		if (updates.coTreatingSurgeonsIds) {
			newModelJson.coTreatingSurgeonsIds = updates.coTreatingSurgeonsIds;
		}

		return new PreoperativeRecordsModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PreoperativeRecordsModel)) {
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
			'operatingTheaterMedicalExaminationRecordId',
			'operatingTheaterMedicalExaminationRecord',
			'anesthesiaMedicalTranscriberId',
			'anesthesiaMedicalTranscriber',
			'anesthesiologistId',
			'anesthesiologist',
			'anesthesiologyNurseId',
			'anesthesiologyNurse',
			'preSurgeryICD10Id',
			'preSurgeryICD10',
			'preSurgeryICD9CMId',
			'preSurgeryICD9CM',
			'preoperativeRoomsId',
			'preoperativeRooms',
			'surgeonId',
			'surgeon',
			'surgicalMedicalTranscriberId',
			'surgicalMedicalTranscriber',
			'surgicalNurseId',
			'surgicalNurse',
			'additionalAnesthesiologistsIds',
			'additionalAnesthesiologists',
			'additionalSurgeryNursesIds',
			'additionalSurgeryNurses',
			'bedFacilitiesIds',
			'bedFacilities',
			'coTreatingAnesthesiologistsIds',
			'coTreatingAnesthesiologists',
			'coTreatingSurgeonsIds',
			'coTreatingSurgeons',
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
		if (!this.operatingTheaterMedicalExaminationRecord) {
			this.operatingTheaterMedicalExaminationRecordId = null;
		} else {
			this.operatingTheaterMedicalExaminationRecordId = this.operatingTheaterMedicalExaminationRecord.id;
		}

		if (!this.anesthesiaMedicalTranscriber) {
			this.anesthesiaMedicalTranscriberId = null;
		} else {
			this.anesthesiaMedicalTranscriberId = this.anesthesiaMedicalTranscriber.id;
		}

		if (!this.anesthesiologist) {
			this.anesthesiologistId = null;
		} else {
			this.anesthesiologistId = this.anesthesiologist.id;
		}

		if (!this.anesthesiologyNurse) {
			this.anesthesiologyNurseId = null;
		} else {
			this.anesthesiologyNurseId = this.anesthesiologyNurse.id;
		}

		if (!this.preSurgeryICD10) {
			this.preSurgeryICD10Id = null;
		} else {
			this.preSurgeryICD10Id = this.preSurgeryICD10.id;
		}

		if (!this.preSurgeryICD9CM) {
			this.preSurgeryICD9CMId = null;
		} else {
			this.preSurgeryICD9CMId = this.preSurgeryICD9CM.id;
		}

		if (!this.preoperativeRooms) {
			this.preoperativeRoomsId = null;
		} else {
			this.preoperativeRoomsId = this.preoperativeRooms.id;
		}

		if (!this.surgeon) {
			this.surgeonId = null;
		} else {
			this.surgeonId = this.surgeon.id;
		}

		if (!this.surgicalMedicalTranscriber) {
			this.surgicalMedicalTranscriberId = null;
		} else {
			this.surgicalMedicalTranscriberId = this.surgicalMedicalTranscriber.id;
		}

		if (!this.surgicalNurse) {
			this.surgicalNurseId = null;
		} else {
			this.surgicalNurseId = this.surgicalNurse.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
