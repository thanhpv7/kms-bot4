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
import {DiagnosisNandaModel} from '../diagnosisNanda/diagnosis_nanda.model';
import {IntraoperativeRecordsModel} from '../intraoperativeRecords/intraoperative_records.model';
import {MedicalExaminationRecordModel} from '../medicalExaminationRecord/medical_examination_record.model';
import {PostOperativeDetailsModel} from '../postOperativeDetails/post_operative_details.model';
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
export class OperatingTheaterMedicalExaminationRecordModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'pulseOxymeterFunctioning',
		'hasKnownAllergy',
		'howLongCaseTake',
		'nameOfProcedure',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'hasConfirmedIdentity',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'OperatingTheaterMedicalExaminationRecordModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return OperatingTheaterMedicalExaminationRecordModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Has Confirmed Identity.
	 */
	hasConfirmedIdentity: boolean = false;

	/**
	 * Anesthesia Safety Check Completed.
	 */
	anesthesiaSafetyCheckCompleted: boolean = false;

	/**
	 * Pulse Oxymeter Functioning.
	 */
	pulseOxymeterFunctioning: boolean = false;

	/**
	 * Site Marked.
	 */
	siteMarked: string;

	/**
	 * Has Known Allergy.
	 */
	hasKnownAllergy: string;

	/**
	 * Has Difficult Airway Risk.
	 */
	hasDifficultAirwayRisk: string;

	/**
	 * Has Risk Of Blood Loss.
	 */
	hasRiskOfBloodLoss: string;

	/**
	 * Team Member Introduced.
	 */
	teamMemberIntroduced: boolean = false;

	/**
	 * Professional Confirmed Patient.
	 */
	professionalConfirmedPatient: boolean = false;

	/**
	 * Antibiotic Prophylaxis Given.
	 */
	antibioticProphylaxisGiven: string;

	/**
	 * Essential Imaging Displayed.
	 */
	essentialImagingDisplayed: string;

	/**
	 * Whare Are Critical Steps.
	 */
	whareAreCriticalSteps: boolean = false;

	/**
	 * How Long Case Take.
	 */
	howLongCaseTake: boolean = false;

	/**
	 * What Is Anticipated Blood Loss.
	 */
	whatIsAnticipatedBloodLoss: boolean = false;

	/**
	 * Any Patient Specific Concerns.
	 */
	anyPatientSpecificConcerns: boolean = false;

	/**
	 * Sterlity Been Confirmed.
	 */
	sterlityBeenConfirmed: boolean = false;

	/**
	 * Equipment Issues Any Concern.
	 */
	equipmentIssuesAnyConcern: boolean = false;

	/**
	 * Name Of Procedure.
	 */
	nameOfProcedure: boolean = false;

	/**
	 * Instruments Need Count Correct.
	 */
	instrumentsNeedCountCorrect: boolean = false;

	/**
	 * Specimen Is Labeled.
	 */
	specimenIsLabeled: boolean = false;

	/**
	 * Equipment Problems Addressed.
	 */
	equipmentProblemsAddressed: boolean = false;

	/**
	 * Key Concerns For Recovery.
	 */
	keyConcernsForRecovery: boolean = false;

	intraoperativeRecordsId: string;

	intraoperativeRecords: IntraoperativeRecordsModel;

	postOperativeDetailsId: string;

	postOperativeDetails: PostOperativeDetailsModel;

	preoperativeRecordsId: string;

	preoperativeRecords: PreoperativeRecordsModel;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	nursingAnesthesiaDetailId: string;

	nursingAnesthesiaDetail: DiagnosisNandaModel;

	nursingDetailSurgicalNursingsId: string;

	nursingDetailSurgicalNursings: StaffModel;

	nursingDetailsAnesthesiaNursingsId: string;

	nursingDetailsAnesthesiaNursings: StaffModel;

	nursingSurgicalDetailId: string;

	nursingSurgicalDetail: DiagnosisNandaModel;

	modelPropGroups: { [s: string]: Group } = OperatingTheaterMedicalExaminationRecordModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'hasConfirmedIdentity',
				// % protected region % [Set displayName for Has Confirmed Identity here] off begin
				displayName: 'Has Confirmed Identity',
				// % protected region % [Set displayName for Has Confirmed Identity here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Has Confirmed Identity here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Has Confirmed Identity here] end
				// % protected region % [Set isSensitive for Has Confirmed Identity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Has Confirmed Identity here] end
				// % protected region % [Set readonly for Has Confirmed Identity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Has Confirmed Identity here] end
				validators: [
					// % protected region % [Add other validators for Has Confirmed Identity here] off begin
					// % protected region % [Add other validators for Has Confirmed Identity here] end
				],
				// % protected region % [Add any additional model attribute properties for Has Confirmed Identity here] off begin
				// % protected region % [Add any additional model attribute properties for Has Confirmed Identity here] end
			},
			{
				name: 'anesthesiaSafetyCheckCompleted',
				// % protected region % [Set displayName for Anesthesia Safety Check Completed here] off begin
				displayName: 'Anesthesia Safety Check Completed',
				// % protected region % [Set displayName for Anesthesia Safety Check Completed here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Anesthesia Safety Check Completed here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Anesthesia Safety Check Completed here] end
				// % protected region % [Set isSensitive for Anesthesia Safety Check Completed here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia Safety Check Completed here] end
				// % protected region % [Set readonly for Anesthesia Safety Check Completed here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia Safety Check Completed here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Safety Check Completed here] off begin
					// % protected region % [Add other validators for Anesthesia Safety Check Completed here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia Safety Check Completed here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia Safety Check Completed here] end
			},
			{
				name: 'pulseOxymeterFunctioning',
				// % protected region % [Set displayName for Pulse Oxymeter Functioning here] off begin
				displayName: 'Pulse Oxymeter Functioning',
				// % protected region % [Set displayName for Pulse Oxymeter Functioning here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Pulse Oxymeter Functioning here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Pulse Oxymeter Functioning here] end
				// % protected region % [Set isSensitive for Pulse Oxymeter Functioning here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pulse Oxymeter Functioning here] end
				// % protected region % [Set readonly for Pulse Oxymeter Functioning here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pulse Oxymeter Functioning here] end
				validators: [
					// % protected region % [Add other validators for Pulse Oxymeter Functioning here] off begin
					// % protected region % [Add other validators for Pulse Oxymeter Functioning here] end
				],
				// % protected region % [Add any additional model attribute properties for Pulse Oxymeter Functioning here] off begin
				// % protected region % [Add any additional model attribute properties for Pulse Oxymeter Functioning here] end
			},
			{
				name: 'siteMarked',
				// % protected region % [Set displayName for Site Marked here] off begin
				displayName: 'Site Marked',
				// % protected region % [Set displayName for Site Marked here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Site Marked here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Site Marked here] end
				// % protected region % [Set isSensitive for Site Marked here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Site Marked here] end
				// % protected region % [Set readonly for Site Marked here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Site Marked here] end
				validators: [
					// % protected region % [Add other validators for Site Marked here] off begin
					// % protected region % [Add other validators for Site Marked here] end
				],
				// % protected region % [Add any additional model attribute properties for Site Marked here] off begin
				// % protected region % [Add any additional model attribute properties for Site Marked here] end
			},
			{
				name: 'hasKnownAllergy',
				// % protected region % [Set displayName for Has Known Allergy here] off begin
				displayName: 'Has Known Allergy',
				// % protected region % [Set displayName for Has Known Allergy here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Has Known Allergy here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Has Known Allergy here] end
				// % protected region % [Set isSensitive for Has Known Allergy here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Has Known Allergy here] end
				// % protected region % [Set readonly for Has Known Allergy here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Has Known Allergy here] end
				validators: [
					// % protected region % [Add other validators for Has Known Allergy here] off begin
					// % protected region % [Add other validators for Has Known Allergy here] end
				],
				// % protected region % [Add any additional model attribute properties for Has Known Allergy here] off begin
				// % protected region % [Add any additional model attribute properties for Has Known Allergy here] end
			},
			{
				name: 'hasDifficultAirwayRisk',
				// % protected region % [Set displayName for Has Difficult Airway Risk here] off begin
				displayName: 'Has Difficult Airway Risk',
				// % protected region % [Set displayName for Has Difficult Airway Risk here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Has Difficult Airway Risk here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Has Difficult Airway Risk here] end
				// % protected region % [Set isSensitive for Has Difficult Airway Risk here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Has Difficult Airway Risk here] end
				// % protected region % [Set readonly for Has Difficult Airway Risk here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Has Difficult Airway Risk here] end
				validators: [
					// % protected region % [Add other validators for Has Difficult Airway Risk here] off begin
					// % protected region % [Add other validators for Has Difficult Airway Risk here] end
				],
				// % protected region % [Add any additional model attribute properties for Has Difficult Airway Risk here] off begin
				// % protected region % [Add any additional model attribute properties for Has Difficult Airway Risk here] end
			},
			{
				name: 'hasRiskOfBloodLoss',
				// % protected region % [Set displayName for Has Risk Of Blood Loss here] off begin
				displayName: 'Has Risk Of Blood Loss',
				// % protected region % [Set displayName for Has Risk Of Blood Loss here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Has Risk Of Blood Loss here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Has Risk Of Blood Loss here] end
				// % protected region % [Set isSensitive for Has Risk Of Blood Loss here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Has Risk Of Blood Loss here] end
				// % protected region % [Set readonly for Has Risk Of Blood Loss here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Has Risk Of Blood Loss here] end
				validators: [
					// % protected region % [Add other validators for Has Risk Of Blood Loss here] off begin
					// % protected region % [Add other validators for Has Risk Of Blood Loss here] end
				],
				// % protected region % [Add any additional model attribute properties for Has Risk Of Blood Loss here] off begin
				// % protected region % [Add any additional model attribute properties for Has Risk Of Blood Loss here] end
			},
			{
				name: 'teamMemberIntroduced',
				// % protected region % [Set displayName for Team Member Introduced here] off begin
				displayName: 'Team Member Introduced',
				// % protected region % [Set displayName for Team Member Introduced here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Team Member Introduced here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Team Member Introduced here] end
				// % protected region % [Set isSensitive for Team Member Introduced here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Team Member Introduced here] end
				// % protected region % [Set readonly for Team Member Introduced here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Team Member Introduced here] end
				validators: [
					// % protected region % [Add other validators for Team Member Introduced here] off begin
					// % protected region % [Add other validators for Team Member Introduced here] end
				],
				// % protected region % [Add any additional model attribute properties for Team Member Introduced here] off begin
				// % protected region % [Add any additional model attribute properties for Team Member Introduced here] end
			},
			{
				name: 'professionalConfirmedPatient',
				// % protected region % [Set displayName for Professional Confirmed Patient here] off begin
				displayName: 'Professional Confirmed Patient',
				// % protected region % [Set displayName for Professional Confirmed Patient here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Professional Confirmed Patient here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Professional Confirmed Patient here] end
				// % protected region % [Set isSensitive for Professional Confirmed Patient here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Professional Confirmed Patient here] end
				// % protected region % [Set readonly for Professional Confirmed Patient here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Professional Confirmed Patient here] end
				validators: [
					// % protected region % [Add other validators for Professional Confirmed Patient here] off begin
					// % protected region % [Add other validators for Professional Confirmed Patient here] end
				],
				// % protected region % [Add any additional model attribute properties for Professional Confirmed Patient here] off begin
				// % protected region % [Add any additional model attribute properties for Professional Confirmed Patient here] end
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
				name: 'essentialImagingDisplayed',
				// % protected region % [Set displayName for Essential Imaging Displayed here] off begin
				displayName: 'Essential Imaging Displayed',
				// % protected region % [Set displayName for Essential Imaging Displayed here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Essential Imaging Displayed here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Essential Imaging Displayed here] end
				// % protected region % [Set isSensitive for Essential Imaging Displayed here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Essential Imaging Displayed here] end
				// % protected region % [Set readonly for Essential Imaging Displayed here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Essential Imaging Displayed here] end
				validators: [
					// % protected region % [Add other validators for Essential Imaging Displayed here] off begin
					// % protected region % [Add other validators for Essential Imaging Displayed here] end
				],
				// % protected region % [Add any additional model attribute properties for Essential Imaging Displayed here] off begin
				// % protected region % [Add any additional model attribute properties for Essential Imaging Displayed here] end
			},
			{
				name: 'whareAreCriticalSteps',
				// % protected region % [Set displayName for Whare Are Critical Steps here] off begin
				displayName: 'Whare Are Critical Steps',
				// % protected region % [Set displayName for Whare Are Critical Steps here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Whare Are Critical Steps here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Whare Are Critical Steps here] end
				// % protected region % [Set isSensitive for Whare Are Critical Steps here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Whare Are Critical Steps here] end
				// % protected region % [Set readonly for Whare Are Critical Steps here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Whare Are Critical Steps here] end
				validators: [
					// % protected region % [Add other validators for Whare Are Critical Steps here] off begin
					// % protected region % [Add other validators for Whare Are Critical Steps here] end
				],
				// % protected region % [Add any additional model attribute properties for Whare Are Critical Steps here] off begin
				// % protected region % [Add any additional model attribute properties for Whare Are Critical Steps here] end
			},
			{
				name: 'howLongCaseTake',
				// % protected region % [Set displayName for How Long Case Take here] off begin
				displayName: 'How Long Case Take',
				// % protected region % [Set displayName for How Long Case Take here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for How Long Case Take here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for How Long Case Take here] end
				// % protected region % [Set isSensitive for How Long Case Take here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for How Long Case Take here] end
				// % protected region % [Set readonly for How Long Case Take here] off begin
				readOnly: false,
				// % protected region % [Set readonly for How Long Case Take here] end
				validators: [
					// % protected region % [Add other validators for How Long Case Take here] off begin
					// % protected region % [Add other validators for How Long Case Take here] end
				],
				// % protected region % [Add any additional model attribute properties for How Long Case Take here] off begin
				// % protected region % [Add any additional model attribute properties for How Long Case Take here] end
			},
			{
				name: 'whatIsAnticipatedBloodLoss',
				// % protected region % [Set displayName for What Is Anticipated Blood Loss here] off begin
				displayName: 'What Is Anticipated Blood Loss',
				// % protected region % [Set displayName for What Is Anticipated Blood Loss here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for What Is Anticipated Blood Loss here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for What Is Anticipated Blood Loss here] end
				// % protected region % [Set isSensitive for What Is Anticipated Blood Loss here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for What Is Anticipated Blood Loss here] end
				// % protected region % [Set readonly for What Is Anticipated Blood Loss here] off begin
				readOnly: false,
				// % protected region % [Set readonly for What Is Anticipated Blood Loss here] end
				validators: [
					// % protected region % [Add other validators for What Is Anticipated Blood Loss here] off begin
					// % protected region % [Add other validators for What Is Anticipated Blood Loss here] end
				],
				// % protected region % [Add any additional model attribute properties for What Is Anticipated Blood Loss here] off begin
				// % protected region % [Add any additional model attribute properties for What Is Anticipated Blood Loss here] end
			},
			{
				name: 'anyPatientSpecificConcerns',
				// % protected region % [Set displayName for Any Patient Specific Concerns here] off begin
				displayName: 'Any Patient Specific Concerns',
				// % protected region % [Set displayName for Any Patient Specific Concerns here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Any Patient Specific Concerns here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Any Patient Specific Concerns here] end
				// % protected region % [Set isSensitive for Any Patient Specific Concerns here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Any Patient Specific Concerns here] end
				// % protected region % [Set readonly for Any Patient Specific Concerns here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Any Patient Specific Concerns here] end
				validators: [
					// % protected region % [Add other validators for Any Patient Specific Concerns here] off begin
					// % protected region % [Add other validators for Any Patient Specific Concerns here] end
				],
				// % protected region % [Add any additional model attribute properties for Any Patient Specific Concerns here] off begin
				// % protected region % [Add any additional model attribute properties for Any Patient Specific Concerns here] end
			},
			{
				name: 'sterlityBeenConfirmed',
				// % protected region % [Set displayName for Sterlity Been Confirmed here] off begin
				displayName: 'Sterlity Been Confirmed',
				// % protected region % [Set displayName for Sterlity Been Confirmed here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Sterlity Been Confirmed here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Sterlity Been Confirmed here] end
				// % protected region % [Set isSensitive for Sterlity Been Confirmed here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sterlity Been Confirmed here] end
				// % protected region % [Set readonly for Sterlity Been Confirmed here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sterlity Been Confirmed here] end
				validators: [
					// % protected region % [Add other validators for Sterlity Been Confirmed here] off begin
					// % protected region % [Add other validators for Sterlity Been Confirmed here] end
				],
				// % protected region % [Add any additional model attribute properties for Sterlity Been Confirmed here] off begin
				// % protected region % [Add any additional model attribute properties for Sterlity Been Confirmed here] end
			},
			{
				name: 'equipmentIssuesAnyConcern',
				// % protected region % [Set displayName for Equipment Issues Any Concern here] off begin
				displayName: 'Equipment Issues Any Concern',
				// % protected region % [Set displayName for Equipment Issues Any Concern here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Equipment Issues Any Concern here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Equipment Issues Any Concern here] end
				// % protected region % [Set isSensitive for Equipment Issues Any Concern here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Equipment Issues Any Concern here] end
				// % protected region % [Set readonly for Equipment Issues Any Concern here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Equipment Issues Any Concern here] end
				validators: [
					// % protected region % [Add other validators for Equipment Issues Any Concern here] off begin
					// % protected region % [Add other validators for Equipment Issues Any Concern here] end
				],
				// % protected region % [Add any additional model attribute properties for Equipment Issues Any Concern here] off begin
				// % protected region % [Add any additional model attribute properties for Equipment Issues Any Concern here] end
			},
			{
				name: 'nameOfProcedure',
				// % protected region % [Set displayName for Name Of Procedure here] off begin
				displayName: 'Name Of Procedure',
				// % protected region % [Set displayName for Name Of Procedure here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Name Of Procedure here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Name Of Procedure here] end
				// % protected region % [Set isSensitive for Name Of Procedure here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Name Of Procedure here] end
				// % protected region % [Set readonly for Name Of Procedure here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Name Of Procedure here] end
				validators: [
					// % protected region % [Add other validators for Name Of Procedure here] off begin
					// % protected region % [Add other validators for Name Of Procedure here] end
				],
				// % protected region % [Add any additional model attribute properties for Name Of Procedure here] off begin
				// % protected region % [Add any additional model attribute properties for Name Of Procedure here] end
			},
			{
				name: 'instrumentsNeedCountCorrect',
				// % protected region % [Set displayName for Instruments Need Count Correct here] off begin
				displayName: 'Instruments Need Count Correct',
				// % protected region % [Set displayName for Instruments Need Count Correct here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Instruments Need Count Correct here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Instruments Need Count Correct here] end
				// % protected region % [Set isSensitive for Instruments Need Count Correct here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Instruments Need Count Correct here] end
				// % protected region % [Set readonly for Instruments Need Count Correct here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Instruments Need Count Correct here] end
				validators: [
					// % protected region % [Add other validators for Instruments Need Count Correct here] off begin
					// % protected region % [Add other validators for Instruments Need Count Correct here] end
				],
				// % protected region % [Add any additional model attribute properties for Instruments Need Count Correct here] off begin
				// % protected region % [Add any additional model attribute properties for Instruments Need Count Correct here] end
			},
			{
				name: 'specimenIsLabeled',
				// % protected region % [Set displayName for Specimen Is Labeled here] off begin
				displayName: 'Specimen Is Labeled',
				// % protected region % [Set displayName for Specimen Is Labeled here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Specimen Is Labeled here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Specimen Is Labeled here] end
				// % protected region % [Set isSensitive for Specimen Is Labeled here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Specimen Is Labeled here] end
				// % protected region % [Set readonly for Specimen Is Labeled here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Specimen Is Labeled here] end
				validators: [
					// % protected region % [Add other validators for Specimen Is Labeled here] off begin
					// % protected region % [Add other validators for Specimen Is Labeled here] end
				],
				// % protected region % [Add any additional model attribute properties for Specimen Is Labeled here] off begin
				// % protected region % [Add any additional model attribute properties for Specimen Is Labeled here] end
			},
			{
				name: 'equipmentProblemsAddressed',
				// % protected region % [Set displayName for Equipment Problems Addressed here] off begin
				displayName: 'Equipment Problems Addressed',
				// % protected region % [Set displayName for Equipment Problems Addressed here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Equipment Problems Addressed here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Equipment Problems Addressed here] end
				// % protected region % [Set isSensitive for Equipment Problems Addressed here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Equipment Problems Addressed here] end
				// % protected region % [Set readonly for Equipment Problems Addressed here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Equipment Problems Addressed here] end
				validators: [
					// % protected region % [Add other validators for Equipment Problems Addressed here] off begin
					// % protected region % [Add other validators for Equipment Problems Addressed here] end
				],
				// % protected region % [Add any additional model attribute properties for Equipment Problems Addressed here] off begin
				// % protected region % [Add any additional model attribute properties for Equipment Problems Addressed here] end
			},
			{
				name: 'keyConcernsForRecovery',
				// % protected region % [Set displayName for Key Concerns For Recovery here] off begin
				displayName: 'Key Concerns For Recovery',
				// % protected region % [Set displayName for Key Concerns For Recovery here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Key Concerns For Recovery here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Key Concerns For Recovery here] end
				// % protected region % [Set isSensitive for Key Concerns For Recovery here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Key Concerns For Recovery here] end
				// % protected region % [Set readonly for Key Concerns For Recovery here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Key Concerns For Recovery here] end
				validators: [
					// % protected region % [Add other validators for Key Concerns For Recovery here] off begin
					// % protected region % [Add other validators for Key Concerns For Recovery here] end
				],
				// % protected region % [Add any additional model attribute properties for Key Concerns For Recovery here] off begin
				// % protected region % [Add any additional model attribute properties for Key Concerns For Recovery here] end
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
				id: 'intraoperativeRecords',
				type: ModelRelationType.ONE,
				name: 'intraoperativeRecordsId',
				// % protected region % [Customise your 1-1 or 1-M label for Intraoperative Records here] off begin
				label: 'Intraoperative Records',
				// % protected region % [Customise your 1-1 or 1-M label for Intraoperative Records here] end
				entityName: 'IntraoperativeRecordsModel',
				// % protected region % [Customise your display name for Intraoperative Records here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Intraoperative Records here] end
				validators: [
					// % protected region % [Add other validators for Intraoperative Records here] off begin
					// % protected region % [Add other validators for Intraoperative Records here] end
				],
				// % protected region % [Add any additional field for relation Intraoperative Records here] off begin
				// % protected region % [Add any additional field for relation Intraoperative Records here] end
			},
			{
				id: 'postOperativeDetails',
				type: ModelRelationType.ONE,
				name: 'postOperativeDetailsId',
				// % protected region % [Customise your 1-1 or 1-M label for Post Operative Details here] off begin
				label: 'Post Operative Details',
				// % protected region % [Customise your 1-1 or 1-M label for Post Operative Details here] end
				entityName: 'PostOperativeDetailsModel',
				// % protected region % [Customise your display name for Post Operative Details here] off begin
				displayName: 'recoveryStartDateTime',
				// % protected region % [Customise your display name for Post Operative Details here] end
				validators: [
					// % protected region % [Add other validators for Post Operative Details here] off begin
					// % protected region % [Add other validators for Post Operative Details here] end
				],
				// % protected region % [Add any additional field for relation Post Operative Details here] off begin
				// % protected region % [Add any additional field for relation Post Operative Details here] end
			},
			{
				id: 'preoperativeRecords',
				type: ModelRelationType.ONE,
				name: 'preoperativeRecordsId',
				// % protected region % [Customise your 1-1 or 1-M label for Preoperative Records here] off begin
				label: 'Preoperative Records',
				// % protected region % [Customise your 1-1 or 1-M label for Preoperative Records here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Preoperative Records here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Preoperative Records here] end
				validators: [
					// % protected region % [Add other validators for Preoperative Records here] off begin
					// % protected region % [Add other validators for Preoperative Records here] end
				],
				// % protected region % [Add any additional field for relation Preoperative Records here] off begin
				// % protected region % [Add any additional field for relation Preoperative Records here] end
			},
			{
				id: 'nursingAnesthesiaDetail',
				type: ModelRelationType.ONE,
				name: 'nursingAnesthesiaDetailId',
				// % protected region % [Customise your label for Nursing Anesthesia Detail here] off begin
				label: 'Nursing Anesthesia Detail',
				// % protected region % [Customise your label for Nursing Anesthesia Detail here] end
				entityName: 'DiagnosisNandaModel',
				// % protected region % [Customise your display name for Nursing Anesthesia Detail here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'nursingNotes',
				// % protected region % [Customise your display name for Nursing Anesthesia Detail here] end
				validators: [
					// % protected region % [Add other validators for Nursing Anesthesia Detail here] off begin
					// % protected region % [Add other validators for Nursing Anesthesia Detail here] end
				],
				// % protected region % [Add any additional field for relation Nursing Anesthesia Detail here] off begin
				// % protected region % [Add any additional field for relation Nursing Anesthesia Detail here] end
			},
			{
				id: 'nursingDetailSurgicalNursings',
				type: ModelRelationType.ONE,
				name: 'nursingDetailSurgicalNursingsId',
				// % protected region % [Customise your label for Nursing Detail Surgical Nursings here] off begin
				label: 'Nursing Detail Surgical Nursings',
				// % protected region % [Customise your label for Nursing Detail Surgical Nursings here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Nursing Detail Surgical Nursings here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Nursing Detail Surgical Nursings here] end
				validators: [
					// % protected region % [Add other validators for Nursing Detail Surgical Nursings here] off begin
					// % protected region % [Add other validators for Nursing Detail Surgical Nursings here] end
				],
				// % protected region % [Add any additional field for relation Nursing Detail Surgical Nursings here] off begin
				// % protected region % [Add any additional field for relation Nursing Detail Surgical Nursings here] end
			},
			{
				id: 'nursingDetailsAnesthesiaNursings',
				type: ModelRelationType.ONE,
				name: 'nursingDetailsAnesthesiaNursingsId',
				// % protected region % [Customise your label for Nursing Details Anesthesia Nursings here] off begin
				label: 'Nursing Details Anesthesia Nursings',
				// % protected region % [Customise your label for Nursing Details Anesthesia Nursings here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Nursing Details Anesthesia Nursings here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Nursing Details Anesthesia Nursings here] end
				validators: [
					// % protected region % [Add other validators for Nursing Details Anesthesia Nursings here] off begin
					// % protected region % [Add other validators for Nursing Details Anesthesia Nursings here] end
				],
				// % protected region % [Add any additional field for relation Nursing Details Anesthesia Nursings here] off begin
				// % protected region % [Add any additional field for relation Nursing Details Anesthesia Nursings here] end
			},
			{
				id: 'nursingSurgicalDetail',
				type: ModelRelationType.ONE,
				name: 'nursingSurgicalDetailId',
				// % protected region % [Customise your label for Nursing Surgical Detail here] off begin
				label: 'Nursing Surgical Detail',
				// % protected region % [Customise your label for Nursing Surgical Detail here] end
				entityName: 'DiagnosisNandaModel',
				// % protected region % [Customise your display name for Nursing Surgical Detail here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'nursingNotes',
				// % protected region % [Customise your display name for Nursing Surgical Detail here] end
				validators: [
					// % protected region % [Add other validators for Nursing Surgical Detail here] off begin
					// % protected region % [Add other validators for Nursing Surgical Detail here] end
				],
				// % protected region % [Add any additional field for relation Nursing Surgical Detail here] off begin
				// % protected region % [Add any additional field for relation Nursing Surgical Detail here] end
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
				case 'pulseOxymeterFunctioning':
					break;
				case 'hasKnownAllergy':
					break;
				case 'howLongCaseTake':
					break;
				case 'nameOfProcedure':
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
	static deepParse(data: string | { [K in keyof OperatingTheaterMedicalExaminationRecordModel]?: OperatingTheaterMedicalExaminationRecordModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new OperatingTheaterMedicalExaminationRecordModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.intraoperativeRecords) {
			currentModel.intraoperativeRecordsId = json.intraoperativeRecords.id;
			returned = _.union(returned, IntraoperativeRecordsModel.deepParse(json.intraoperativeRecords));
		}

		// Outgoing one to one
		if (json.postOperativeDetails) {
			currentModel.postOperativeDetailsId = json.postOperativeDetails.id;
			returned = _.union(returned, PostOperativeDetailsModel.deepParse(json.postOperativeDetails));
		}

		// Outgoing one to one
		if (json.preoperativeRecords) {
			currentModel.preoperativeRecordsId = json.preoperativeRecords.id;
			returned = _.union(returned, PreoperativeRecordsModel.deepParse(json.preoperativeRecords));
		}

		// Incoming one to one
		if (json.medicalExaminationRecord) {
			currentModel.medicalExaminationRecordId = json.medicalExaminationRecord.id;
			returned = _.union(returned, MedicalExaminationRecordModel.deepParse(json.medicalExaminationRecord));
		}

		// Incoming one to many
		if (json.nursingAnesthesiaDetail) {
			currentModel.nursingAnesthesiaDetailId = json.nursingAnesthesiaDetail.id;
			returned = _.union(returned, DiagnosisNandaModel.deepParse(json.nursingAnesthesiaDetail));
		}

		// Incoming one to many
		if (json.nursingDetailSurgicalNursings) {
			currentModel.nursingDetailSurgicalNursingsId = json.nursingDetailSurgicalNursings.id;
			returned = _.union(returned, StaffModel.deepParse(json.nursingDetailSurgicalNursings));
		}

		// Incoming one to many
		if (json.nursingDetailsAnesthesiaNursings) {
			currentModel.nursingDetailsAnesthesiaNursingsId = json.nursingDetailsAnesthesiaNursings.id;
			returned = _.union(returned, StaffModel.deepParse(json.nursingDetailsAnesthesiaNursings));
		}

		// Incoming one to many
		if (json.nursingSurgicalDetail) {
			currentModel.nursingSurgicalDetailId = json.nursingSurgicalDetail.id;
			returned = _.union(returned, DiagnosisNandaModel.deepParse(json.nursingSurgicalDetail));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let operatingTheaterMedicalExaminationRecordModel = new OperatingTheaterMedicalExaminationRecordModel(data);`
	 *
	 * @param data The input data to be initialised as the OperatingTheaterMedicalExaminationRecordModel,
	 *    it is expected as a JSON string or as a nullable OperatingTheaterMedicalExaminationRecordModel.
	 */
	constructor(data?: string | Partial<OperatingTheaterMedicalExaminationRecordModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<OperatingTheaterMedicalExaminationRecordModel>
				: data;

			this.hasConfirmedIdentity = json.hasConfirmedIdentity;
			this.anesthesiaSafetyCheckCompleted = json.anesthesiaSafetyCheckCompleted;
			this.pulseOxymeterFunctioning = json.pulseOxymeterFunctioning;
			this.siteMarked = json.siteMarked;
			this.hasKnownAllergy = json.hasKnownAllergy;
			this.hasDifficultAirwayRisk = json.hasDifficultAirwayRisk;
			this.hasRiskOfBloodLoss = json.hasRiskOfBloodLoss;
			this.teamMemberIntroduced = json.teamMemberIntroduced;
			this.professionalConfirmedPatient = json.professionalConfirmedPatient;
			this.antibioticProphylaxisGiven = json.antibioticProphylaxisGiven;
			this.essentialImagingDisplayed = json.essentialImagingDisplayed;
			this.whareAreCriticalSteps = json.whareAreCriticalSteps;
			this.howLongCaseTake = json.howLongCaseTake;
			this.whatIsAnticipatedBloodLoss = json.whatIsAnticipatedBloodLoss;
			this.anyPatientSpecificConcerns = json.anyPatientSpecificConcerns;
			this.sterlityBeenConfirmed = json.sterlityBeenConfirmed;
			this.equipmentIssuesAnyConcern = json.equipmentIssuesAnyConcern;
			this.nameOfProcedure = json.nameOfProcedure;
			this.instrumentsNeedCountCorrect = json.instrumentsNeedCountCorrect;
			this.specimenIsLabeled = json.specimenIsLabeled;
			this.equipmentProblemsAddressed = json.equipmentProblemsAddressed;
			this.keyConcernsForRecovery = json.keyConcernsForRecovery;
			this.intraoperativeRecordsId = json.intraoperativeRecordsId;
			this.intraoperativeRecords = json.intraoperativeRecords;
			this.postOperativeDetailsId = json.postOperativeDetailsId;
			this.postOperativeDetails = json.postOperativeDetails;
			this.preoperativeRecordsId = json.preoperativeRecordsId;
			this.preoperativeRecords = json.preoperativeRecords;
			this.medicalExaminationRecordId = json.medicalExaminationRecordId;
			this.medicalExaminationRecord = json.medicalExaminationRecord;
			this.nursingAnesthesiaDetailId = json.nursingAnesthesiaDetailId;
			this.nursingAnesthesiaDetail = json.nursingAnesthesiaDetail;
			this.nursingDetailSurgicalNursingsId = json.nursingDetailSurgicalNursingsId;
			this.nursingDetailSurgicalNursings = json.nursingDetailSurgicalNursings;
			this.nursingDetailsAnesthesiaNursingsId = json.nursingDetailsAnesthesiaNursingsId;
			this.nursingDetailsAnesthesiaNursings = json.nursingDetailsAnesthesiaNursings;
			this.nursingSurgicalDetailId = json.nursingSurgicalDetailId;
			this.nursingSurgicalDetail = json.nursingSurgicalDetail;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			hasConfirmedIdentity: this.hasConfirmedIdentity,
			anesthesiaSafetyCheckCompleted: this.anesthesiaSafetyCheckCompleted,
			pulseOxymeterFunctioning: this.pulseOxymeterFunctioning,
			siteMarked: this.siteMarked,
			hasKnownAllergy: this.hasKnownAllergy,
			hasDifficultAirwayRisk: this.hasDifficultAirwayRisk,
			hasRiskOfBloodLoss: this.hasRiskOfBloodLoss,
			teamMemberIntroduced: this.teamMemberIntroduced,
			professionalConfirmedPatient: this.professionalConfirmedPatient,
			antibioticProphylaxisGiven: this.antibioticProphylaxisGiven,
			essentialImagingDisplayed: this.essentialImagingDisplayed,
			whareAreCriticalSteps: this.whareAreCriticalSteps,
			howLongCaseTake: this.howLongCaseTake,
			whatIsAnticipatedBloodLoss: this.whatIsAnticipatedBloodLoss,
			anyPatientSpecificConcerns: this.anyPatientSpecificConcerns,
			sterlityBeenConfirmed: this.sterlityBeenConfirmed,
			equipmentIssuesAnyConcern: this.equipmentIssuesAnyConcern,
			nameOfProcedure: this.nameOfProcedure,
			instrumentsNeedCountCorrect: this.instrumentsNeedCountCorrect,
			specimenIsLabeled: this.specimenIsLabeled,
			equipmentProblemsAddressed: this.equipmentProblemsAddressed,
			keyConcernsForRecovery: this.keyConcernsForRecovery,
			intraoperativeRecordsId: this.intraoperativeRecordsId,
			postOperativeDetailsId: this.postOperativeDetailsId,
			preoperativeRecordsId: this.preoperativeRecordsId,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			nursingAnesthesiaDetailId: this.nursingAnesthesiaDetailId,
			nursingDetailSurgicalNursingsId: this.nursingDetailSurgicalNursingsId,
			nursingDetailsAnesthesiaNursingsId: this.nursingDetailsAnesthesiaNursingsId,
			nursingSurgicalDetailId: this.nursingSurgicalDetailId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		OperatingTheaterMedicalExaminationRecordModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): OperatingTheaterMedicalExaminationRecordModel {
		let newModelJson = this.toJSON();

		if (updates.hasConfirmedIdentity) {
			newModelJson.hasConfirmedIdentity = updates.hasConfirmedIdentity;
		}

		if (updates.anesthesiaSafetyCheckCompleted) {
			newModelJson.anesthesiaSafetyCheckCompleted = updates.anesthesiaSafetyCheckCompleted;
		}

		if (updates.pulseOxymeterFunctioning) {
			newModelJson.pulseOxymeterFunctioning = updates.pulseOxymeterFunctioning;
		}

		if (updates.siteMarked) {
			newModelJson.siteMarked = updates.siteMarked;
		}

		if (updates.hasKnownAllergy) {
			newModelJson.hasKnownAllergy = updates.hasKnownAllergy;
		}

		if (updates.hasDifficultAirwayRisk) {
			newModelJson.hasDifficultAirwayRisk = updates.hasDifficultAirwayRisk;
		}

		if (updates.hasRiskOfBloodLoss) {
			newModelJson.hasRiskOfBloodLoss = updates.hasRiskOfBloodLoss;
		}

		if (updates.teamMemberIntroduced) {
			newModelJson.teamMemberIntroduced = updates.teamMemberIntroduced;
		}

		if (updates.professionalConfirmedPatient) {
			newModelJson.professionalConfirmedPatient = updates.professionalConfirmedPatient;
		}

		if (updates.antibioticProphylaxisGiven) {
			newModelJson.antibioticProphylaxisGiven = updates.antibioticProphylaxisGiven;
		}

		if (updates.essentialImagingDisplayed) {
			newModelJson.essentialImagingDisplayed = updates.essentialImagingDisplayed;
		}

		if (updates.whareAreCriticalSteps) {
			newModelJson.whareAreCriticalSteps = updates.whareAreCriticalSteps;
		}

		if (updates.howLongCaseTake) {
			newModelJson.howLongCaseTake = updates.howLongCaseTake;
		}

		if (updates.whatIsAnticipatedBloodLoss) {
			newModelJson.whatIsAnticipatedBloodLoss = updates.whatIsAnticipatedBloodLoss;
		}

		if (updates.anyPatientSpecificConcerns) {
			newModelJson.anyPatientSpecificConcerns = updates.anyPatientSpecificConcerns;
		}

		if (updates.sterlityBeenConfirmed) {
			newModelJson.sterlityBeenConfirmed = updates.sterlityBeenConfirmed;
		}

		if (updates.equipmentIssuesAnyConcern) {
			newModelJson.equipmentIssuesAnyConcern = updates.equipmentIssuesAnyConcern;
		}

		if (updates.nameOfProcedure) {
			newModelJson.nameOfProcedure = updates.nameOfProcedure;
		}

		if (updates.instrumentsNeedCountCorrect) {
			newModelJson.instrumentsNeedCountCorrect = updates.instrumentsNeedCountCorrect;
		}

		if (updates.specimenIsLabeled) {
			newModelJson.specimenIsLabeled = updates.specimenIsLabeled;
		}

		if (updates.equipmentProblemsAddressed) {
			newModelJson.equipmentProblemsAddressed = updates.equipmentProblemsAddressed;
		}

		if (updates.keyConcernsForRecovery) {
			newModelJson.keyConcernsForRecovery = updates.keyConcernsForRecovery;
		}

		if (updates.intraoperativeRecordsId) {
			newModelJson.intraoperativeRecordsId = updates.intraoperativeRecordsId;
		}

		if (updates.postOperativeDetailsId) {
			newModelJson.postOperativeDetailsId = updates.postOperativeDetailsId;
		}

		if (updates.preoperativeRecordsId) {
			newModelJson.preoperativeRecordsId = updates.preoperativeRecordsId;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		if (updates.nursingAnesthesiaDetailId) {
			newModelJson.nursingAnesthesiaDetailId = updates.nursingAnesthesiaDetailId;
		}

		if (updates.nursingDetailSurgicalNursingsId) {
			newModelJson.nursingDetailSurgicalNursingsId = updates.nursingDetailSurgicalNursingsId;
		}

		if (updates.nursingDetailsAnesthesiaNursingsId) {
			newModelJson.nursingDetailsAnesthesiaNursingsId = updates.nursingDetailsAnesthesiaNursingsId;
		}

		if (updates.nursingSurgicalDetailId) {
			newModelJson.nursingSurgicalDetailId = updates.nursingSurgicalDetailId;
		}

		return new OperatingTheaterMedicalExaminationRecordModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof OperatingTheaterMedicalExaminationRecordModel)) {
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
			'intraoperativeRecordsId',
			'intraoperativeRecords',
			'postOperativeDetailsId',
			'postOperativeDetails',
			'preoperativeRecordsId',
			'preoperativeRecords',
			'medicalExaminationRecordId',
			'medicalExaminationRecord',
			'nursingAnesthesiaDetailId',
			'nursingAnesthesiaDetail',
			'nursingDetailSurgicalNursingsId',
			'nursingDetailSurgicalNursings',
			'nursingDetailsAnesthesiaNursingsId',
			'nursingDetailsAnesthesiaNursings',
			'nursingSurgicalDetailId',
			'nursingSurgicalDetail',
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
		if (!this.intraoperativeRecords) {
			this.intraoperativeRecordsId = null;
		} else {
			this.intraoperativeRecordsId = this.intraoperativeRecords.id;
		}

		if (!this.postOperativeDetails) {
			this.postOperativeDetailsId = null;
		} else {
			this.postOperativeDetailsId = this.postOperativeDetails.id;
		}

		if (!this.preoperativeRecords) {
			this.preoperativeRecordsId = null;
		} else {
			this.preoperativeRecordsId = this.preoperativeRecords.id;
		}

		if (!this.medicalExaminationRecord) {
			this.medicalExaminationRecordId = null;
		} else {
			this.medicalExaminationRecordId = this.medicalExaminationRecord.id;
		}

		if (!this.nursingAnesthesiaDetail) {
			this.nursingAnesthesiaDetailId = null;
		} else {
			this.nursingAnesthesiaDetailId = this.nursingAnesthesiaDetail.id;
		}

		if (!this.nursingDetailSurgicalNursings) {
			this.nursingDetailSurgicalNursingsId = null;
		} else {
			this.nursingDetailSurgicalNursingsId = this.nursingDetailSurgicalNursings.id;
		}

		if (!this.nursingDetailsAnesthesiaNursings) {
			this.nursingDetailsAnesthesiaNursingsId = null;
		} else {
			this.nursingDetailsAnesthesiaNursingsId = this.nursingDetailsAnesthesiaNursings.id;
		}

		if (!this.nursingSurgicalDetail) {
			this.nursingSurgicalDetailId = null;
		} else {
			this.nursingSurgicalDetailId = this.nursingSurgicalDetail.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
