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
export class MedicalRecordInitialChecklistModel extends AbstractModel {
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
		'outVitalSign',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'MedicalRecordInitialChecklistModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return MedicalRecordInitialChecklistModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	outVitalSign: boolean = false;

	/**
	 * .
	 */
	outAnamnesis: boolean = false;

	/**
	 * .
	 */
	outPhysicalExamination: boolean = false;

	/**
	 * .
	 */
	outDiagnosis: boolean = false;

	/**
	 * .
	 */
	outDismissalType: boolean = false;

	/**
	 * .
	 */
	outDismissalDateAndTime: boolean = false;

	/**
	 * .
	 */
	inpVitalSign: boolean = false;

	/**
	 * .
	 */
	inpDailyCareDoctorNotes: boolean = false;

	/**
	 * .
	 */
	inpDailyCareDoctorNotesNA: boolean = false;

	/**
	 * .
	 */
	inpDailyCareNursingNotes: boolean = false;

	/**
	 * .
	 */
	inpDailyCareNursingNotesNA: boolean = false;

	/**
	 * .
	 */
	inpDailyCareProgressNotes: boolean = false;

	/**
	 * .
	 */
	inpDailyCareProgressNotesNA: boolean = false;

	/**
	 * .
	 */
	inpDismissalDiagnosis: boolean = false;

	/**
	 * .
	 */
	inpDismissalType: boolean = false;

	/**
	 * .
	 */
	inpDismissalDateAndTime: boolean = false;

	/**
	 * .
	 */
	inpDismissalCondition: boolean = false;

	/**
	 * .
	 */
	drAdmissionDiagnosis: boolean = false;

	/**
	 * .
	 */
	drObservationDoctorNotes: boolean = false;

	/**
	 * .
	 */
	drObservationDoctorNotesNA: boolean = false;

	/**
	 * .
	 */
	drObservationNursingNotes: boolean = false;

	/**
	 * .
	 */
	drObservationNursingNotesNA: boolean = false;

	/**
	 * .
	 */
	drObservationProgressNotes: boolean = false;

	/**
	 * .
	 */
	drObservationProgressNotesNA: boolean = false;

	/**
	 * .
	 */
	drDismissalDiagnosis: boolean = false;

	/**
	 * .
	 */
	drDismissalType: boolean = false;

	/**
	 * .
	 */
	drDismissalDateAndTime: boolean = false;

	/**
	 * .
	 */
	otPreOperativeDiagnosis: boolean = false;

	/**
	 * .
	 */
	otPreOperativeNotesSurgery: boolean = false;

	/**
	 * .
	 */
	otPreOperativeNotesAnaesthesiology: boolean = false;

	/**
	 * .
	 */
	otIntraOperativeNotesSurgery: boolean = false;

	/**
	 * .
	 */
	otIntraOperativeNotesAnaesthesiology: boolean = false;

	/**
	 * .
	 */
	otPostOperativeNotesSurgery: boolean = false;

	/**
	 * .
	 */
	otPostOperativeNotesAnaesthesiology: boolean = false;

	/**
	 * .
	 */
	otPostOperativeDiagnosis: boolean = false;

	/**
	 * .
	 */
	otDismissalType: boolean = false;

	/**
	 * .
	 */
	otDismissalDateAndTime: boolean = false;

	/**
	 * .
	 */
	dsResponsibleStaff: boolean = false;

	/**
	 * .
	 */
	dsInterpretation: boolean = false;

	/**
	 * Notes (Max Length: 5000).
	 */
	notes: string;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	modelPropGroups: { [s: string]: Group } = MedicalRecordInitialChecklistModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'outVitalSign',
				// % protected region % [Set displayName for Out Vital Sign here] off begin
				displayName: 'Out Vital Sign',
				// % protected region % [Set displayName for Out Vital Sign here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Out Vital Sign here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Out Vital Sign here] end
				// % protected region % [Set isSensitive for Out Vital Sign here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Out Vital Sign here] end
				// % protected region % [Set readonly for Out Vital Sign here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Out Vital Sign here] end
				validators: [
					// % protected region % [Add other validators for Out Vital Sign here] off begin
					// % protected region % [Add other validators for Out Vital Sign here] end
				],
				// % protected region % [Add any additional model attribute properties for Out Vital Sign here] off begin
				// % protected region % [Add any additional model attribute properties for Out Vital Sign here] end
			},
			{
				name: 'outAnamnesis',
				// % protected region % [Set displayName for Out Anamnesis here] off begin
				displayName: 'Out Anamnesis',
				// % protected region % [Set displayName for Out Anamnesis here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Out Anamnesis here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Out Anamnesis here] end
				// % protected region % [Set isSensitive for Out Anamnesis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Out Anamnesis here] end
				// % protected region % [Set readonly for Out Anamnesis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Out Anamnesis here] end
				validators: [
					// % protected region % [Add other validators for Out Anamnesis here] off begin
					// % protected region % [Add other validators for Out Anamnesis here] end
				],
				// % protected region % [Add any additional model attribute properties for Out Anamnesis here] off begin
				// % protected region % [Add any additional model attribute properties for Out Anamnesis here] end
			},
			{
				name: 'outPhysicalExamination',
				// % protected region % [Set displayName for Out Physical Examination here] off begin
				displayName: 'Out Physical Examination',
				// % protected region % [Set displayName for Out Physical Examination here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Out Physical Examination here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Out Physical Examination here] end
				// % protected region % [Set isSensitive for Out Physical Examination here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Out Physical Examination here] end
				// % protected region % [Set readonly for Out Physical Examination here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Out Physical Examination here] end
				validators: [
					// % protected region % [Add other validators for Out Physical Examination here] off begin
					// % protected region % [Add other validators for Out Physical Examination here] end
				],
				// % protected region % [Add any additional model attribute properties for Out Physical Examination here] off begin
				// % protected region % [Add any additional model attribute properties for Out Physical Examination here] end
			},
			{
				name: 'outDiagnosis',
				// % protected region % [Set displayName for Out Diagnosis here] off begin
				displayName: 'Out Diagnosis',
				// % protected region % [Set displayName for Out Diagnosis here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Out Diagnosis here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Out Diagnosis here] end
				// % protected region % [Set isSensitive for Out Diagnosis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Out Diagnosis here] end
				// % protected region % [Set readonly for Out Diagnosis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Out Diagnosis here] end
				validators: [
					// % protected region % [Add other validators for Out Diagnosis here] off begin
					// % protected region % [Add other validators for Out Diagnosis here] end
				],
				// % protected region % [Add any additional model attribute properties for Out Diagnosis here] off begin
				// % protected region % [Add any additional model attribute properties for Out Diagnosis here] end
			},
			{
				name: 'outDismissalType',
				// % protected region % [Set displayName for Out Dismissal Type here] off begin
				displayName: 'Out Dismissal Type',
				// % protected region % [Set displayName for Out Dismissal Type here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Out Dismissal Type here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Out Dismissal Type here] end
				// % protected region % [Set isSensitive for Out Dismissal Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Out Dismissal Type here] end
				// % protected region % [Set readonly for Out Dismissal Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Out Dismissal Type here] end
				validators: [
					// % protected region % [Add other validators for Out Dismissal Type here] off begin
					// % protected region % [Add other validators for Out Dismissal Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Out Dismissal Type here] off begin
				// % protected region % [Add any additional model attribute properties for Out Dismissal Type here] end
			},
			{
				name: 'outDismissalDateAndTime',
				// % protected region % [Set displayName for Out Dismissal Date and Time here] off begin
				displayName: 'Out Dismissal Date and Time',
				// % protected region % [Set displayName for Out Dismissal Date and Time here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Out Dismissal Date and Time here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Out Dismissal Date and Time here] end
				// % protected region % [Set isSensitive for Out Dismissal Date and Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Out Dismissal Date and Time here] end
				// % protected region % [Set readonly for Out Dismissal Date and Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Out Dismissal Date and Time here] end
				validators: [
					// % protected region % [Add other validators for Out Dismissal Date and Time here] off begin
					// % protected region % [Add other validators for Out Dismissal Date and Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Out Dismissal Date and Time here] off begin
				// % protected region % [Add any additional model attribute properties for Out Dismissal Date and Time here] end
			},
			{
				name: 'inpVitalSign',
				// % protected region % [Set displayName for Inp Vital Sign here] off begin
				displayName: 'Inp Vital Sign',
				// % protected region % [Set displayName for Inp Vital Sign here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inp Vital Sign here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inp Vital Sign here] end
				// % protected region % [Set isSensitive for Inp Vital Sign here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inp Vital Sign here] end
				// % protected region % [Set readonly for Inp Vital Sign here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inp Vital Sign here] end
				validators: [
					// % protected region % [Add other validators for Inp Vital Sign here] off begin
					// % protected region % [Add other validators for Inp Vital Sign here] end
				],
				// % protected region % [Add any additional model attribute properties for Inp Vital Sign here] off begin
				// % protected region % [Add any additional model attribute properties for Inp Vital Sign here] end
			},
			{
				name: 'inpDailyCareDoctorNotes',
				// % protected region % [Set displayName for Inp Daily Care Doctor Notes here] off begin
				displayName: 'Inp Daily Care Doctor Notes',
				// % protected region % [Set displayName for Inp Daily Care Doctor Notes here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inp Daily Care Doctor Notes here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inp Daily Care Doctor Notes here] end
				// % protected region % [Set isSensitive for Inp Daily Care Doctor Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inp Daily Care Doctor Notes here] end
				// % protected region % [Set readonly for Inp Daily Care Doctor Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inp Daily Care Doctor Notes here] end
				validators: [
					// % protected region % [Add other validators for Inp Daily Care Doctor Notes here] off begin
					// % protected region % [Add other validators for Inp Daily Care Doctor Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Doctor Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Doctor Notes here] end
			},
			{
				name: 'inpDailyCareDoctorNotesNA',
				// % protected region % [Set displayName for Inp Daily Care Doctor Notes NA here] off begin
				displayName: 'Inp Daily Care Doctor Notes NA',
				// % protected region % [Set displayName for Inp Daily Care Doctor Notes NA here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inp Daily Care Doctor Notes NA here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inp Daily Care Doctor Notes NA here] end
				// % protected region % [Set isSensitive for Inp Daily Care Doctor Notes NA here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inp Daily Care Doctor Notes NA here] end
				// % protected region % [Set readonly for Inp Daily Care Doctor Notes NA here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inp Daily Care Doctor Notes NA here] end
				validators: [
					// % protected region % [Add other validators for Inp Daily Care Doctor Notes NA here] off begin
					// % protected region % [Add other validators for Inp Daily Care Doctor Notes NA here] end
				],
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Doctor Notes NA here] off begin
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Doctor Notes NA here] end
			},
			{
				name: 'inpDailyCareNursingNotes',
				// % protected region % [Set displayName for Inp Daily Care Nursing Notes here] off begin
				displayName: 'Inp Daily Care Nursing Notes',
				// % protected region % [Set displayName for Inp Daily Care Nursing Notes here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inp Daily Care Nursing Notes here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inp Daily Care Nursing Notes here] end
				// % protected region % [Set isSensitive for Inp Daily Care Nursing Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inp Daily Care Nursing Notes here] end
				// % protected region % [Set readonly for Inp Daily Care Nursing Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inp Daily Care Nursing Notes here] end
				validators: [
					// % protected region % [Add other validators for Inp Daily Care Nursing Notes here] off begin
					// % protected region % [Add other validators for Inp Daily Care Nursing Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Nursing Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Nursing Notes here] end
			},
			{
				name: 'inpDailyCareNursingNotesNA',
				// % protected region % [Set displayName for Inp Daily Care Nursing Notes NA here] off begin
				displayName: 'Inp Daily Care Nursing Notes NA',
				// % protected region % [Set displayName for Inp Daily Care Nursing Notes NA here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inp Daily Care Nursing Notes NA here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inp Daily Care Nursing Notes NA here] end
				// % protected region % [Set isSensitive for Inp Daily Care Nursing Notes NA here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inp Daily Care Nursing Notes NA here] end
				// % protected region % [Set readonly for Inp Daily Care Nursing Notes NA here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inp Daily Care Nursing Notes NA here] end
				validators: [
					// % protected region % [Add other validators for Inp Daily Care Nursing Notes NA here] off begin
					// % protected region % [Add other validators for Inp Daily Care Nursing Notes NA here] end
				],
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Nursing Notes NA here] off begin
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Nursing Notes NA here] end
			},
			{
				name: 'inpDailyCareProgressNotes',
				// % protected region % [Set displayName for Inp Daily Care Progress Notes here] off begin
				displayName: 'Inp Daily Care Progress Notes',
				// % protected region % [Set displayName for Inp Daily Care Progress Notes here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inp Daily Care Progress Notes here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inp Daily Care Progress Notes here] end
				// % protected region % [Set isSensitive for Inp Daily Care Progress Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inp Daily Care Progress Notes here] end
				// % protected region % [Set readonly for Inp Daily Care Progress Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inp Daily Care Progress Notes here] end
				validators: [
					// % protected region % [Add other validators for Inp Daily Care Progress Notes here] off begin
					// % protected region % [Add other validators for Inp Daily Care Progress Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Progress Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Progress Notes here] end
			},
			{
				name: 'inpDailyCareProgressNotesNA',
				// % protected region % [Set displayName for Inp Daily Care Progress Notes NA here] off begin
				displayName: 'Inp Daily Care Progress Notes NA',
				// % protected region % [Set displayName for Inp Daily Care Progress Notes NA here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inp Daily Care Progress Notes NA here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inp Daily Care Progress Notes NA here] end
				// % protected region % [Set isSensitive for Inp Daily Care Progress Notes NA here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inp Daily Care Progress Notes NA here] end
				// % protected region % [Set readonly for Inp Daily Care Progress Notes NA here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inp Daily Care Progress Notes NA here] end
				validators: [
					// % protected region % [Add other validators for Inp Daily Care Progress Notes NA here] off begin
					// % protected region % [Add other validators for Inp Daily Care Progress Notes NA here] end
				],
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Progress Notes NA here] off begin
				// % protected region % [Add any additional model attribute properties for Inp Daily Care Progress Notes NA here] end
			},
			{
				name: 'inpDismissalDiagnosis',
				// % protected region % [Set displayName for Inp Dismissal Diagnosis here] off begin
				displayName: 'Inp Dismissal Diagnosis',
				// % protected region % [Set displayName for Inp Dismissal Diagnosis here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inp Dismissal Diagnosis here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inp Dismissal Diagnosis here] end
				// % protected region % [Set isSensitive for Inp Dismissal Diagnosis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inp Dismissal Diagnosis here] end
				// % protected region % [Set readonly for Inp Dismissal Diagnosis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inp Dismissal Diagnosis here] end
				validators: [
					// % protected region % [Add other validators for Inp Dismissal Diagnosis here] off begin
					// % protected region % [Add other validators for Inp Dismissal Diagnosis here] end
				],
				// % protected region % [Add any additional model attribute properties for Inp Dismissal Diagnosis here] off begin
				// % protected region % [Add any additional model attribute properties for Inp Dismissal Diagnosis here] end
			},
			{
				name: 'inpDismissalType',
				// % protected region % [Set displayName for Inp Dismissal Type here] off begin
				displayName: 'Inp Dismissal Type',
				// % protected region % [Set displayName for Inp Dismissal Type here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inp Dismissal Type here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inp Dismissal Type here] end
				// % protected region % [Set isSensitive for Inp Dismissal Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inp Dismissal Type here] end
				// % protected region % [Set readonly for Inp Dismissal Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inp Dismissal Type here] end
				validators: [
					// % protected region % [Add other validators for Inp Dismissal Type here] off begin
					// % protected region % [Add other validators for Inp Dismissal Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Inp Dismissal Type here] off begin
				// % protected region % [Add any additional model attribute properties for Inp Dismissal Type here] end
			},
			{
				name: 'inpDismissalDateAndTime',
				// % protected region % [Set displayName for Inp Dismissal Date and Time here] off begin
				displayName: 'Inp Dismissal Date and Time',
				// % protected region % [Set displayName for Inp Dismissal Date and Time here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inp Dismissal Date and Time here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inp Dismissal Date and Time here] end
				// % protected region % [Set isSensitive for Inp Dismissal Date and Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inp Dismissal Date and Time here] end
				// % protected region % [Set readonly for Inp Dismissal Date and Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inp Dismissal Date and Time here] end
				validators: [
					// % protected region % [Add other validators for Inp Dismissal Date and Time here] off begin
					// % protected region % [Add other validators for Inp Dismissal Date and Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Inp Dismissal Date and Time here] off begin
				// % protected region % [Add any additional model attribute properties for Inp Dismissal Date and Time here] end
			},
			{
				name: 'inpDismissalCondition',
				// % protected region % [Set displayName for Inp Dismissal Condition here] off begin
				displayName: 'Inp Dismissal Condition',
				// % protected region % [Set displayName for Inp Dismissal Condition here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inp Dismissal Condition here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inp Dismissal Condition here] end
				// % protected region % [Set isSensitive for Inp Dismissal Condition here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inp Dismissal Condition here] end
				// % protected region % [Set readonly for Inp Dismissal Condition here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inp Dismissal Condition here] end
				validators: [
					// % protected region % [Add other validators for Inp Dismissal Condition here] off begin
					// % protected region % [Add other validators for Inp Dismissal Condition here] end
				],
				// % protected region % [Add any additional model attribute properties for Inp Dismissal Condition here] off begin
				// % protected region % [Add any additional model attribute properties for Inp Dismissal Condition here] end
			},
			{
				name: 'drAdmissionDiagnosis',
				// % protected region % [Set displayName for DR Admission Diagnosis here] off begin
				displayName: 'DR Admission Diagnosis',
				// % protected region % [Set displayName for DR Admission Diagnosis here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DR Admission Diagnosis here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DR Admission Diagnosis here] end
				// % protected region % [Set isSensitive for DR Admission Diagnosis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DR Admission Diagnosis here] end
				// % protected region % [Set readonly for DR Admission Diagnosis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DR Admission Diagnosis here] end
				validators: [
					// % protected region % [Add other validators for DR Admission Diagnosis here] off begin
					// % protected region % [Add other validators for DR Admission Diagnosis here] end
				],
				// % protected region % [Add any additional model attribute properties for DR Admission Diagnosis here] off begin
				// % protected region % [Add any additional model attribute properties for DR Admission Diagnosis here] end
			},
			{
				name: 'drObservationDoctorNotes',
				// % protected region % [Set displayName for DR Observation Doctor Notes here] off begin
				displayName: 'DR Observation Doctor Notes',
				// % protected region % [Set displayName for DR Observation Doctor Notes here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DR Observation Doctor Notes here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DR Observation Doctor Notes here] end
				// % protected region % [Set isSensitive for DR Observation Doctor Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DR Observation Doctor Notes here] end
				// % protected region % [Set readonly for DR Observation Doctor Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DR Observation Doctor Notes here] end
				validators: [
					// % protected region % [Add other validators for DR Observation Doctor Notes here] off begin
					// % protected region % [Add other validators for DR Observation Doctor Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for DR Observation Doctor Notes here] off begin
				// % protected region % [Add any additional model attribute properties for DR Observation Doctor Notes here] end
			},
			{
				name: 'drObservationDoctorNotesNA',
				// % protected region % [Set displayName for DR Observation Doctor Notes NA here] off begin
				displayName: 'DR Observation Doctor Notes NA',
				// % protected region % [Set displayName for DR Observation Doctor Notes NA here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DR Observation Doctor Notes NA here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DR Observation Doctor Notes NA here] end
				// % protected region % [Set isSensitive for DR Observation Doctor Notes NA here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DR Observation Doctor Notes NA here] end
				// % protected region % [Set readonly for DR Observation Doctor Notes NA here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DR Observation Doctor Notes NA here] end
				validators: [
					// % protected region % [Add other validators for DR Observation Doctor Notes NA here] off begin
					// % protected region % [Add other validators for DR Observation Doctor Notes NA here] end
				],
				// % protected region % [Add any additional model attribute properties for DR Observation Doctor Notes NA here] off begin
				// % protected region % [Add any additional model attribute properties for DR Observation Doctor Notes NA here] end
			},
			{
				name: 'drObservationNursingNotes',
				// % protected region % [Set displayName for DR Observation Nursing Notes here] off begin
				displayName: 'DR Observation Nursing Notes',
				// % protected region % [Set displayName for DR Observation Nursing Notes here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DR Observation Nursing Notes here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DR Observation Nursing Notes here] end
				// % protected region % [Set isSensitive for DR Observation Nursing Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DR Observation Nursing Notes here] end
				// % protected region % [Set readonly for DR Observation Nursing Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DR Observation Nursing Notes here] end
				validators: [
					// % protected region % [Add other validators for DR Observation Nursing Notes here] off begin
					// % protected region % [Add other validators for DR Observation Nursing Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for DR Observation Nursing Notes here] off begin
				// % protected region % [Add any additional model attribute properties for DR Observation Nursing Notes here] end
			},
			{
				name: 'drObservationNursingNotesNA',
				// % protected region % [Set displayName for DR Observation Nursing Notes NA here] off begin
				displayName: 'DR Observation Nursing Notes NA',
				// % protected region % [Set displayName for DR Observation Nursing Notes NA here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DR Observation Nursing Notes NA here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DR Observation Nursing Notes NA here] end
				// % protected region % [Set isSensitive for DR Observation Nursing Notes NA here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DR Observation Nursing Notes NA here] end
				// % protected region % [Set readonly for DR Observation Nursing Notes NA here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DR Observation Nursing Notes NA here] end
				validators: [
					// % protected region % [Add other validators for DR Observation Nursing Notes NA here] off begin
					// % protected region % [Add other validators for DR Observation Nursing Notes NA here] end
				],
				// % protected region % [Add any additional model attribute properties for DR Observation Nursing Notes NA here] off begin
				// % protected region % [Add any additional model attribute properties for DR Observation Nursing Notes NA here] end
			},
			{
				name: 'drObservationProgressNotes',
				// % protected region % [Set displayName for DR Observation Progress Notes here] off begin
				displayName: 'DR Observation Progress Notes',
				// % protected region % [Set displayName for DR Observation Progress Notes here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DR Observation Progress Notes here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DR Observation Progress Notes here] end
				// % protected region % [Set isSensitive for DR Observation Progress Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DR Observation Progress Notes here] end
				// % protected region % [Set readonly for DR Observation Progress Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DR Observation Progress Notes here] end
				validators: [
					// % protected region % [Add other validators for DR Observation Progress Notes here] off begin
					// % protected region % [Add other validators for DR Observation Progress Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for DR Observation Progress Notes here] off begin
				// % protected region % [Add any additional model attribute properties for DR Observation Progress Notes here] end
			},
			{
				name: 'drObservationProgressNotesNA',
				// % protected region % [Set displayName for DR Observation Progress Notes NA here] off begin
				displayName: 'DR Observation Progress Notes NA',
				// % protected region % [Set displayName for DR Observation Progress Notes NA here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DR Observation Progress Notes NA here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DR Observation Progress Notes NA here] end
				// % protected region % [Set isSensitive for DR Observation Progress Notes NA here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DR Observation Progress Notes NA here] end
				// % protected region % [Set readonly for DR Observation Progress Notes NA here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DR Observation Progress Notes NA here] end
				validators: [
					// % protected region % [Add other validators for DR Observation Progress Notes NA here] off begin
					// % protected region % [Add other validators for DR Observation Progress Notes NA here] end
				],
				// % protected region % [Add any additional model attribute properties for DR Observation Progress Notes NA here] off begin
				// % protected region % [Add any additional model attribute properties for DR Observation Progress Notes NA here] end
			},
			{
				name: 'drDismissalDiagnosis',
				// % protected region % [Set displayName for DR Dismissal Diagnosis here] off begin
				displayName: 'DR Dismissal Diagnosis',
				// % protected region % [Set displayName for DR Dismissal Diagnosis here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DR Dismissal Diagnosis here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DR Dismissal Diagnosis here] end
				// % protected region % [Set isSensitive for DR Dismissal Diagnosis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DR Dismissal Diagnosis here] end
				// % protected region % [Set readonly for DR Dismissal Diagnosis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DR Dismissal Diagnosis here] end
				validators: [
					// % protected region % [Add other validators for DR Dismissal Diagnosis here] off begin
					// % protected region % [Add other validators for DR Dismissal Diagnosis here] end
				],
				// % protected region % [Add any additional model attribute properties for DR Dismissal Diagnosis here] off begin
				// % protected region % [Add any additional model attribute properties for DR Dismissal Diagnosis here] end
			},
			{
				name: 'drDismissalType',
				// % protected region % [Set displayName for DR Dismissal Type here] off begin
				displayName: 'DR Dismissal Type',
				// % protected region % [Set displayName for DR Dismissal Type here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DR Dismissal Type here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DR Dismissal Type here] end
				// % protected region % [Set isSensitive for DR Dismissal Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DR Dismissal Type here] end
				// % protected region % [Set readonly for DR Dismissal Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DR Dismissal Type here] end
				validators: [
					// % protected region % [Add other validators for DR Dismissal Type here] off begin
					// % protected region % [Add other validators for DR Dismissal Type here] end
				],
				// % protected region % [Add any additional model attribute properties for DR Dismissal Type here] off begin
				// % protected region % [Add any additional model attribute properties for DR Dismissal Type here] end
			},
			{
				name: 'drDismissalDateAndTime',
				// % protected region % [Set displayName for DR Dismissal Date and Time here] off begin
				displayName: 'DR Dismissal Date and Time',
				// % protected region % [Set displayName for DR Dismissal Date and Time here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DR Dismissal Date and Time here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DR Dismissal Date and Time here] end
				// % protected region % [Set isSensitive for DR Dismissal Date and Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DR Dismissal Date and Time here] end
				// % protected region % [Set readonly for DR Dismissal Date and Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DR Dismissal Date and Time here] end
				validators: [
					// % protected region % [Add other validators for DR Dismissal Date and Time here] off begin
					// % protected region % [Add other validators for DR Dismissal Date and Time here] end
				],
				// % protected region % [Add any additional model attribute properties for DR Dismissal Date and Time here] off begin
				// % protected region % [Add any additional model attribute properties for DR Dismissal Date and Time here] end
			},
			{
				name: 'otPreOperativeDiagnosis',
				// % protected region % [Set displayName for OT Pre Operative Diagnosis here] off begin
				displayName: 'OT Pre Operative Diagnosis',
				// % protected region % [Set displayName for OT Pre Operative Diagnosis here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for OT Pre Operative Diagnosis here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for OT Pre Operative Diagnosis here] end
				// % protected region % [Set isSensitive for OT Pre Operative Diagnosis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for OT Pre Operative Diagnosis here] end
				// % protected region % [Set readonly for OT Pre Operative Diagnosis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for OT Pre Operative Diagnosis here] end
				validators: [
					// % protected region % [Add other validators for OT Pre Operative Diagnosis here] off begin
					// % protected region % [Add other validators for OT Pre Operative Diagnosis here] end
				],
				// % protected region % [Add any additional model attribute properties for OT Pre Operative Diagnosis here] off begin
				// % protected region % [Add any additional model attribute properties for OT Pre Operative Diagnosis here] end
			},
			{
				name: 'otPreOperativeNotesSurgery',
				// % protected region % [Set displayName for OT Pre Operative Notes Surgery here] off begin
				displayName: 'OT Pre Operative Notes Surgery',
				// % protected region % [Set displayName for OT Pre Operative Notes Surgery here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for OT Pre Operative Notes Surgery here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for OT Pre Operative Notes Surgery here] end
				// % protected region % [Set isSensitive for OT Pre Operative Notes Surgery here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for OT Pre Operative Notes Surgery here] end
				// % protected region % [Set readonly for OT Pre Operative Notes Surgery here] off begin
				readOnly: false,
				// % protected region % [Set readonly for OT Pre Operative Notes Surgery here] end
				validators: [
					// % protected region % [Add other validators for OT Pre Operative Notes Surgery here] off begin
					// % protected region % [Add other validators for OT Pre Operative Notes Surgery here] end
				],
				// % protected region % [Add any additional model attribute properties for OT Pre Operative Notes Surgery here] off begin
				// % protected region % [Add any additional model attribute properties for OT Pre Operative Notes Surgery here] end
			},
			{
				name: 'otPreOperativeNotesAnaesthesiology',
				// % protected region % [Set displayName for OT Pre Operative Notes Anaesthesiology here] off begin
				displayName: 'OT Pre Operative Notes Anaesthesiology',
				// % protected region % [Set displayName for OT Pre Operative Notes Anaesthesiology here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for OT Pre Operative Notes Anaesthesiology here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for OT Pre Operative Notes Anaesthesiology here] end
				// % protected region % [Set isSensitive for OT Pre Operative Notes Anaesthesiology here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for OT Pre Operative Notes Anaesthesiology here] end
				// % protected region % [Set readonly for OT Pre Operative Notes Anaesthesiology here] off begin
				readOnly: false,
				// % protected region % [Set readonly for OT Pre Operative Notes Anaesthesiology here] end
				validators: [
					// % protected region % [Add other validators for OT Pre Operative Notes Anaesthesiology here] off begin
					// % protected region % [Add other validators for OT Pre Operative Notes Anaesthesiology here] end
				],
				// % protected region % [Add any additional model attribute properties for OT Pre Operative Notes Anaesthesiology here] off begin
				// % protected region % [Add any additional model attribute properties for OT Pre Operative Notes Anaesthesiology here] end
			},
			{
				name: 'otIntraOperativeNotesSurgery',
				// % protected region % [Set displayName for OT Intra Operative Notes Surgery here] off begin
				displayName: 'OT Intra Operative Notes Surgery',
				// % protected region % [Set displayName for OT Intra Operative Notes Surgery here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for OT Intra Operative Notes Surgery here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for OT Intra Operative Notes Surgery here] end
				// % protected region % [Set isSensitive for OT Intra Operative Notes Surgery here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for OT Intra Operative Notes Surgery here] end
				// % protected region % [Set readonly for OT Intra Operative Notes Surgery here] off begin
				readOnly: false,
				// % protected region % [Set readonly for OT Intra Operative Notes Surgery here] end
				validators: [
					// % protected region % [Add other validators for OT Intra Operative Notes Surgery here] off begin
					// % protected region % [Add other validators for OT Intra Operative Notes Surgery here] end
				],
				// % protected region % [Add any additional model attribute properties for OT Intra Operative Notes Surgery here] off begin
				// % protected region % [Add any additional model attribute properties for OT Intra Operative Notes Surgery here] end
			},
			{
				name: 'otIntraOperativeNotesAnaesthesiology',
				// % protected region % [Set displayName for OT Intra Operative Notes Anaesthesiology here] off begin
				displayName: 'OT Intra Operative Notes Anaesthesiology',
				// % protected region % [Set displayName for OT Intra Operative Notes Anaesthesiology here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for OT Intra Operative Notes Anaesthesiology here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for OT Intra Operative Notes Anaesthesiology here] end
				// % protected region % [Set isSensitive for OT Intra Operative Notes Anaesthesiology here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for OT Intra Operative Notes Anaesthesiology here] end
				// % protected region % [Set readonly for OT Intra Operative Notes Anaesthesiology here] off begin
				readOnly: false,
				// % protected region % [Set readonly for OT Intra Operative Notes Anaesthesiology here] end
				validators: [
					// % protected region % [Add other validators for OT Intra Operative Notes Anaesthesiology here] off begin
					// % protected region % [Add other validators for OT Intra Operative Notes Anaesthesiology here] end
				],
				// % protected region % [Add any additional model attribute properties for OT Intra Operative Notes Anaesthesiology here] off begin
				// % protected region % [Add any additional model attribute properties for OT Intra Operative Notes Anaesthesiology here] end
			},
			{
				name: 'otPostOperativeNotesSurgery',
				// % protected region % [Set displayName for OT Post Operative Notes Surgery here] off begin
				displayName: 'OT Post Operative Notes Surgery',
				// % protected region % [Set displayName for OT Post Operative Notes Surgery here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for OT Post Operative Notes Surgery here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for OT Post Operative Notes Surgery here] end
				// % protected region % [Set isSensitive for OT Post Operative Notes Surgery here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for OT Post Operative Notes Surgery here] end
				// % protected region % [Set readonly for OT Post Operative Notes Surgery here] off begin
				readOnly: false,
				// % protected region % [Set readonly for OT Post Operative Notes Surgery here] end
				validators: [
					// % protected region % [Add other validators for OT Post Operative Notes Surgery here] off begin
					// % protected region % [Add other validators for OT Post Operative Notes Surgery here] end
				],
				// % protected region % [Add any additional model attribute properties for OT Post Operative Notes Surgery here] off begin
				// % protected region % [Add any additional model attribute properties for OT Post Operative Notes Surgery here] end
			},
			{
				name: 'otPostOperativeNotesAnaesthesiology',
				// % protected region % [Set displayName for OT Post Operative Notes Anaesthesiology here] off begin
				displayName: 'OT Post Operative Notes Anaesthesiology',
				// % protected region % [Set displayName for OT Post Operative Notes Anaesthesiology here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for OT Post Operative Notes Anaesthesiology here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for OT Post Operative Notes Anaesthesiology here] end
				// % protected region % [Set isSensitive for OT Post Operative Notes Anaesthesiology here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for OT Post Operative Notes Anaesthesiology here] end
				// % protected region % [Set readonly for OT Post Operative Notes Anaesthesiology here] off begin
				readOnly: false,
				// % protected region % [Set readonly for OT Post Operative Notes Anaesthesiology here] end
				validators: [
					// % protected region % [Add other validators for OT Post Operative Notes Anaesthesiology here] off begin
					// % protected region % [Add other validators for OT Post Operative Notes Anaesthesiology here] end
				],
				// % protected region % [Add any additional model attribute properties for OT Post Operative Notes Anaesthesiology here] off begin
				// % protected region % [Add any additional model attribute properties for OT Post Operative Notes Anaesthesiology here] end
			},
			{
				name: 'otPostOperativeDiagnosis',
				// % protected region % [Set displayName for OT Post Operative Diagnosis here] off begin
				displayName: 'OT Post Operative Diagnosis',
				// % protected region % [Set displayName for OT Post Operative Diagnosis here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for OT Post Operative Diagnosis here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for OT Post Operative Diagnosis here] end
				// % protected region % [Set isSensitive for OT Post Operative Diagnosis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for OT Post Operative Diagnosis here] end
				// % protected region % [Set readonly for OT Post Operative Diagnosis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for OT Post Operative Diagnosis here] end
				validators: [
					// % protected region % [Add other validators for OT Post Operative Diagnosis here] off begin
					// % protected region % [Add other validators for OT Post Operative Diagnosis here] end
				],
				// % protected region % [Add any additional model attribute properties for OT Post Operative Diagnosis here] off begin
				// % protected region % [Add any additional model attribute properties for OT Post Operative Diagnosis here] end
			},
			{
				name: 'otDismissalType',
				// % protected region % [Set displayName for OT Dismissal Type here] off begin
				displayName: 'OT Dismissal Type',
				// % protected region % [Set displayName for OT Dismissal Type here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for OT Dismissal Type here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for OT Dismissal Type here] end
				// % protected region % [Set isSensitive for OT Dismissal Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for OT Dismissal Type here] end
				// % protected region % [Set readonly for OT Dismissal Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for OT Dismissal Type here] end
				validators: [
					// % protected region % [Add other validators for OT Dismissal Type here] off begin
					// % protected region % [Add other validators for OT Dismissal Type here] end
				],
				// % protected region % [Add any additional model attribute properties for OT Dismissal Type here] off begin
				// % protected region % [Add any additional model attribute properties for OT Dismissal Type here] end
			},
			{
				name: 'otDismissalDateAndTime',
				// % protected region % [Set displayName for OT Dismissal Date and Time here] off begin
				displayName: 'OT Dismissal Date and Time',
				// % protected region % [Set displayName for OT Dismissal Date and Time here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for OT Dismissal Date and Time here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for OT Dismissal Date and Time here] end
				// % protected region % [Set isSensitive for OT Dismissal Date and Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for OT Dismissal Date and Time here] end
				// % protected region % [Set readonly for OT Dismissal Date and Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for OT Dismissal Date and Time here] end
				validators: [
					// % protected region % [Add other validators for OT Dismissal Date and Time here] off begin
					// % protected region % [Add other validators for OT Dismissal Date and Time here] end
				],
				// % protected region % [Add any additional model attribute properties for OT Dismissal Date and Time here] off begin
				// % protected region % [Add any additional model attribute properties for OT Dismissal Date and Time here] end
			},
			{
				name: 'dsResponsibleStaff',
				// % protected region % [Set displayName for DS Responsible Staff here] off begin
				displayName: 'DS Responsible Staff',
				// % protected region % [Set displayName for DS Responsible Staff here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DS Responsible Staff here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DS Responsible Staff here] end
				// % protected region % [Set isSensitive for DS Responsible Staff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DS Responsible Staff here] end
				// % protected region % [Set readonly for DS Responsible Staff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DS Responsible Staff here] end
				validators: [
					// % protected region % [Add other validators for DS Responsible Staff here] off begin
					// % protected region % [Add other validators for DS Responsible Staff here] end
				],
				// % protected region % [Add any additional model attribute properties for DS Responsible Staff here] off begin
				// % protected region % [Add any additional model attribute properties for DS Responsible Staff here] end
			},
			{
				name: 'dsInterpretation',
				// % protected region % [Set displayName for DS Interpretation here] off begin
				displayName: 'DS Interpretation',
				// % protected region % [Set displayName for DS Interpretation here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for DS Interpretation here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for DS Interpretation here] end
				// % protected region % [Set isSensitive for DS Interpretation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DS Interpretation here] end
				// % protected region % [Set readonly for DS Interpretation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DS Interpretation here] end
				validators: [
					// % protected region % [Add other validators for DS Interpretation here] off begin
					// % protected region % [Add other validators for DS Interpretation here] end
				],
				// % protected region % [Add any additional model attribute properties for DS Interpretation here] off begin
				// % protected region % [Add any additional model attribute properties for DS Interpretation here] end
			},
			{
				name: 'notes',
				// % protected region % [Set displayName for Notes here] off begin
				displayName: 'Notes',
				// % protected region % [Set displayName for Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Notes here] end
				// % protected region % [Set isSensitive for Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Notes here] end
				// % protected region % [Set readonly for Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Notes here] end
				validators: [
					// % protected region % [Add other validators for Notes here] off begin
					// % protected region % [Add other validators for Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Notes here] end
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
	static deepParse(data: string | { [K in keyof MedicalRecordInitialChecklistModel]?: MedicalRecordInitialChecklistModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new MedicalRecordInitialChecklistModel(data);
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
	 * `let medicalRecordInitialChecklistModel = new MedicalRecordInitialChecklistModel(data);`
	 *
	 * @param data The input data to be initialised as the MedicalRecordInitialChecklistModel,
	 *    it is expected as a JSON string or as a nullable MedicalRecordInitialChecklistModel.
	 */
	constructor(data?: string | Partial<MedicalRecordInitialChecklistModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<MedicalRecordInitialChecklistModel>
				: data;

			this.outVitalSign = json.outVitalSign;
			this.outAnamnesis = json.outAnamnesis;
			this.outPhysicalExamination = json.outPhysicalExamination;
			this.outDiagnosis = json.outDiagnosis;
			this.outDismissalType = json.outDismissalType;
			this.outDismissalDateAndTime = json.outDismissalDateAndTime;
			this.inpVitalSign = json.inpVitalSign;
			this.inpDailyCareDoctorNotes = json.inpDailyCareDoctorNotes;
			this.inpDailyCareDoctorNotesNA = json.inpDailyCareDoctorNotesNA;
			this.inpDailyCareNursingNotes = json.inpDailyCareNursingNotes;
			this.inpDailyCareNursingNotesNA = json.inpDailyCareNursingNotesNA;
			this.inpDailyCareProgressNotes = json.inpDailyCareProgressNotes;
			this.inpDailyCareProgressNotesNA = json.inpDailyCareProgressNotesNA;
			this.inpDismissalDiagnosis = json.inpDismissalDiagnosis;
			this.inpDismissalType = json.inpDismissalType;
			this.inpDismissalDateAndTime = json.inpDismissalDateAndTime;
			this.inpDismissalCondition = json.inpDismissalCondition;
			this.drAdmissionDiagnosis = json.drAdmissionDiagnosis;
			this.drObservationDoctorNotes = json.drObservationDoctorNotes;
			this.drObservationDoctorNotesNA = json.drObservationDoctorNotesNA;
			this.drObservationNursingNotes = json.drObservationNursingNotes;
			this.drObservationNursingNotesNA = json.drObservationNursingNotesNA;
			this.drObservationProgressNotes = json.drObservationProgressNotes;
			this.drObservationProgressNotesNA = json.drObservationProgressNotesNA;
			this.drDismissalDiagnosis = json.drDismissalDiagnosis;
			this.drDismissalType = json.drDismissalType;
			this.drDismissalDateAndTime = json.drDismissalDateAndTime;
			this.otPreOperativeDiagnosis = json.otPreOperativeDiagnosis;
			this.otPreOperativeNotesSurgery = json.otPreOperativeNotesSurgery;
			this.otPreOperativeNotesAnaesthesiology = json.otPreOperativeNotesAnaesthesiology;
			this.otIntraOperativeNotesSurgery = json.otIntraOperativeNotesSurgery;
			this.otIntraOperativeNotesAnaesthesiology = json.otIntraOperativeNotesAnaesthesiology;
			this.otPostOperativeNotesSurgery = json.otPostOperativeNotesSurgery;
			this.otPostOperativeNotesAnaesthesiology = json.otPostOperativeNotesAnaesthesiology;
			this.otPostOperativeDiagnosis = json.otPostOperativeDiagnosis;
			this.otDismissalType = json.otDismissalType;
			this.otDismissalDateAndTime = json.otDismissalDateAndTime;
			this.dsResponsibleStaff = json.dsResponsibleStaff;
			this.dsInterpretation = json.dsInterpretation;
			this.notes = json.notes;
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
			outVitalSign: this.outVitalSign,
			outAnamnesis: this.outAnamnesis,
			outPhysicalExamination: this.outPhysicalExamination,
			outDiagnosis: this.outDiagnosis,
			outDismissalType: this.outDismissalType,
			outDismissalDateAndTime: this.outDismissalDateAndTime,
			inpVitalSign: this.inpVitalSign,
			inpDailyCareDoctorNotes: this.inpDailyCareDoctorNotes,
			inpDailyCareDoctorNotesNA: this.inpDailyCareDoctorNotesNA,
			inpDailyCareNursingNotes: this.inpDailyCareNursingNotes,
			inpDailyCareNursingNotesNA: this.inpDailyCareNursingNotesNA,
			inpDailyCareProgressNotes: this.inpDailyCareProgressNotes,
			inpDailyCareProgressNotesNA: this.inpDailyCareProgressNotesNA,
			inpDismissalDiagnosis: this.inpDismissalDiagnosis,
			inpDismissalType: this.inpDismissalType,
			inpDismissalDateAndTime: this.inpDismissalDateAndTime,
			inpDismissalCondition: this.inpDismissalCondition,
			drAdmissionDiagnosis: this.drAdmissionDiagnosis,
			drObservationDoctorNotes: this.drObservationDoctorNotes,
			drObservationDoctorNotesNA: this.drObservationDoctorNotesNA,
			drObservationNursingNotes: this.drObservationNursingNotes,
			drObservationNursingNotesNA: this.drObservationNursingNotesNA,
			drObservationProgressNotes: this.drObservationProgressNotes,
			drObservationProgressNotesNA: this.drObservationProgressNotesNA,
			drDismissalDiagnosis: this.drDismissalDiagnosis,
			drDismissalType: this.drDismissalType,
			drDismissalDateAndTime: this.drDismissalDateAndTime,
			otPreOperativeDiagnosis: this.otPreOperativeDiagnosis,
			otPreOperativeNotesSurgery: this.otPreOperativeNotesSurgery,
			otPreOperativeNotesAnaesthesiology: this.otPreOperativeNotesAnaesthesiology,
			otIntraOperativeNotesSurgery: this.otIntraOperativeNotesSurgery,
			otIntraOperativeNotesAnaesthesiology: this.otIntraOperativeNotesAnaesthesiology,
			otPostOperativeNotesSurgery: this.otPostOperativeNotesSurgery,
			otPostOperativeNotesAnaesthesiology: this.otPostOperativeNotesAnaesthesiology,
			otPostOperativeDiagnosis: this.otPostOperativeDiagnosis,
			otDismissalType: this.otDismissalType,
			otDismissalDateAndTime: this.otDismissalDateAndTime,
			dsResponsibleStaff: this.dsResponsibleStaff,
			dsInterpretation: this.dsInterpretation,
			notes: this.notes,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		MedicalRecordInitialChecklistModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): MedicalRecordInitialChecklistModel {
		let newModelJson = this.toJSON();

		if (updates.outVitalSign) {
			newModelJson.outVitalSign = updates.outVitalSign;
		}

		if (updates.outAnamnesis) {
			newModelJson.outAnamnesis = updates.outAnamnesis;
		}

		if (updates.outPhysicalExamination) {
			newModelJson.outPhysicalExamination = updates.outPhysicalExamination;
		}

		if (updates.outDiagnosis) {
			newModelJson.outDiagnosis = updates.outDiagnosis;
		}

		if (updates.outDismissalType) {
			newModelJson.outDismissalType = updates.outDismissalType;
		}

		if (updates.outDismissalDateAndTime) {
			newModelJson.outDismissalDateAndTime = updates.outDismissalDateAndTime;
		}

		if (updates.inpVitalSign) {
			newModelJson.inpVitalSign = updates.inpVitalSign;
		}

		if (updates.inpDailyCareDoctorNotes) {
			newModelJson.inpDailyCareDoctorNotes = updates.inpDailyCareDoctorNotes;
		}

		if (updates.inpDailyCareDoctorNotesNA) {
			newModelJson.inpDailyCareDoctorNotesNA = updates.inpDailyCareDoctorNotesNA;
		}

		if (updates.inpDailyCareNursingNotes) {
			newModelJson.inpDailyCareNursingNotes = updates.inpDailyCareNursingNotes;
		}

		if (updates.inpDailyCareNursingNotesNA) {
			newModelJson.inpDailyCareNursingNotesNA = updates.inpDailyCareNursingNotesNA;
		}

		if (updates.inpDailyCareProgressNotes) {
			newModelJson.inpDailyCareProgressNotes = updates.inpDailyCareProgressNotes;
		}

		if (updates.inpDailyCareProgressNotesNA) {
			newModelJson.inpDailyCareProgressNotesNA = updates.inpDailyCareProgressNotesNA;
		}

		if (updates.inpDismissalDiagnosis) {
			newModelJson.inpDismissalDiagnosis = updates.inpDismissalDiagnosis;
		}

		if (updates.inpDismissalType) {
			newModelJson.inpDismissalType = updates.inpDismissalType;
		}

		if (updates.inpDismissalDateAndTime) {
			newModelJson.inpDismissalDateAndTime = updates.inpDismissalDateAndTime;
		}

		if (updates.inpDismissalCondition) {
			newModelJson.inpDismissalCondition = updates.inpDismissalCondition;
		}

		if (updates.drAdmissionDiagnosis) {
			newModelJson.drAdmissionDiagnosis = updates.drAdmissionDiagnosis;
		}

		if (updates.drObservationDoctorNotes) {
			newModelJson.drObservationDoctorNotes = updates.drObservationDoctorNotes;
		}

		if (updates.drObservationDoctorNotesNA) {
			newModelJson.drObservationDoctorNotesNA = updates.drObservationDoctorNotesNA;
		}

		if (updates.drObservationNursingNotes) {
			newModelJson.drObservationNursingNotes = updates.drObservationNursingNotes;
		}

		if (updates.drObservationNursingNotesNA) {
			newModelJson.drObservationNursingNotesNA = updates.drObservationNursingNotesNA;
		}

		if (updates.drObservationProgressNotes) {
			newModelJson.drObservationProgressNotes = updates.drObservationProgressNotes;
		}

		if (updates.drObservationProgressNotesNA) {
			newModelJson.drObservationProgressNotesNA = updates.drObservationProgressNotesNA;
		}

		if (updates.drDismissalDiagnosis) {
			newModelJson.drDismissalDiagnosis = updates.drDismissalDiagnosis;
		}

		if (updates.drDismissalType) {
			newModelJson.drDismissalType = updates.drDismissalType;
		}

		if (updates.drDismissalDateAndTime) {
			newModelJson.drDismissalDateAndTime = updates.drDismissalDateAndTime;
		}

		if (updates.otPreOperativeDiagnosis) {
			newModelJson.otPreOperativeDiagnosis = updates.otPreOperativeDiagnosis;
		}

		if (updates.otPreOperativeNotesSurgery) {
			newModelJson.otPreOperativeNotesSurgery = updates.otPreOperativeNotesSurgery;
		}

		if (updates.otPreOperativeNotesAnaesthesiology) {
			newModelJson.otPreOperativeNotesAnaesthesiology = updates.otPreOperativeNotesAnaesthesiology;
		}

		if (updates.otIntraOperativeNotesSurgery) {
			newModelJson.otIntraOperativeNotesSurgery = updates.otIntraOperativeNotesSurgery;
		}

		if (updates.otIntraOperativeNotesAnaesthesiology) {
			newModelJson.otIntraOperativeNotesAnaesthesiology = updates.otIntraOperativeNotesAnaesthesiology;
		}

		if (updates.otPostOperativeNotesSurgery) {
			newModelJson.otPostOperativeNotesSurgery = updates.otPostOperativeNotesSurgery;
		}

		if (updates.otPostOperativeNotesAnaesthesiology) {
			newModelJson.otPostOperativeNotesAnaesthesiology = updates.otPostOperativeNotesAnaesthesiology;
		}

		if (updates.otPostOperativeDiagnosis) {
			newModelJson.otPostOperativeDiagnosis = updates.otPostOperativeDiagnosis;
		}

		if (updates.otDismissalType) {
			newModelJson.otDismissalType = updates.otDismissalType;
		}

		if (updates.otDismissalDateAndTime) {
			newModelJson.otDismissalDateAndTime = updates.otDismissalDateAndTime;
		}

		if (updates.dsResponsibleStaff) {
			newModelJson.dsResponsibleStaff = updates.dsResponsibleStaff;
		}

		if (updates.dsInterpretation) {
			newModelJson.dsInterpretation = updates.dsInterpretation;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		return new MedicalRecordInitialChecklistModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof MedicalRecordInitialChecklistModel)) {
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
