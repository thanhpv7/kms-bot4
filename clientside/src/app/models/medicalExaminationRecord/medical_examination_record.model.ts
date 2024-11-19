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
import {AmendmentDetailModel} from '../amendmentDetail/amendment_detail.model';
import {BirthHistoryModel} from '../birthHistory/birth_history.model';
import {BodyChartExaminationModel} from '../bodyChartExamination/body_chart_examination.model';
import {CoTreatingDoctorModel} from '../coTreatingDoctor/co_treating_doctor.model';
import {DailyCareCPPTModel} from '../dailyCareCPPT/daily_care_cppt.model';
import {DeliveryMedicalExaminationRecordModel} from '../deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import {DiagnosisExaminationRecordModel} from '../diagnosisExaminationRecord/diagnosis_examination_record.model';
import {DiagnosisNandaModel} from '../diagnosisNanda/diagnosis_nanda.model';
import {EntExaminationModel} from '../entExamination/ent_examination.model';
import {EmergencyMedicalExaminationRecordModel} from '../emergencyMedicalExaminationRecord/emergency_medical_examination_record.model';
import {FormulirKonselingTesHivModel} from '../formulirKonselingTesHiv/formulir_konseling_tes_hiv.model';
import {HemodialysisExaminationModel} from '../hemodialysisExamination/hemodialysis_examination.model';
import {InpatientMedicalExaminationRecordModel} from '../inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import {MedicalExaminationRecordDischargeSummaryModel} from '../medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model';
import {MedicalRecordInitialChecklistModel} from '../medicalRecordInitialChecklist/medical_record_initial_checklist.model';
import {MedicalRecordNextVerificationChecklistModel} from '../medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model';
import {NurseVitalSignMeasurementModel} from '../nurseVitalSignMeasurement/nurse_vital_sign_measurement.model';
import {ObstetricAndGynecologyHistoryModel} from '../obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model';
import {OdontogramExaminationModel} from '../odontogramExamination/odontogram_examination.model';
import {OperatingTheaterMedicalExaminationRecordModel} from '../operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import {OphthalmologyExaminationModel} from '../ophthalmologyExamination/ophthalmology_examination.model';
import {RegistrationModel} from '../registration/registration.model';
import {RoomTransferModel} from '../roomTransfer/room_transfer.model';
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
export class MedicalExaminationRecordModel extends AbstractModel {
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
		'diastole',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'MedicalExaminationRecordModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return MedicalExaminationRecordModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Diastole.
	 */
	diastole: number;

	/**
	 * Systole.
	 */
	systole: number;

	/**
	 * Pulse (X/min).
	 */
	pulse: number;

	/**
	 * BP Standing Systole.
	 */
	bpStandingSystole: number;

	/**
	 * BP Standing Diastole.
	 */
	bpStandingDiastole: number;

	/**
	 * Pulse Regularity , get the Code from Reference Data where Type=PULSE_REGULAR. (Max Length: 20).
	 */
	pulseRegularity: string;

	/**
	 * Pulse Strength, get the Code from Reference Data where Type=PULSE_STRENGTH. (Max Length: 20).
	 */
	pulseStrength: string;

	/**
	 * Temperature, with 1 decimal digit.
	 */
	temperature: number;

	/**
	 * Temperature scale, get the Unit Name from Unit Of Measurement entity where Unit Category is Temperature.
	 */
	temperatureScale: string;

	/**
	 * GCS Eyes, get the Code from Reference Data where Type=GCS_EYES. (Max Length: 20).
	 */
	gcsEyes: string;

	/**
	 * GCS Verbal, get the Code from Reference Data where Type=GCS_VERBAL (Max Length: 20).
	 */
	gcsVerbal: string;

	/**
	 * GCS Motor, get the Code from Reference Data where Type=GCS_MOTOR. (Max Length: 20).
	 */
	gcsMotor: string;

	/**
	 * Total GCS Score, with 2 decimal digits.
	 */
	totalGCSScore: number;

	/**
	 * Consciousness, get the Code from Reference Data where Type=CONSCIOUSNESS. (Max Length: 20).
	 */
	consciousness: string;

	/**
	 * Height, with 2 decimal digits.
	 */
	height: number;

	/**
	 * Height Scale, get the Unit Name from Unit Of Measurement entity where Unit Category is Height.
	 */
	heightScale: string;

	/**
	 * Weight, with 2 decimal digits.
	 */
	weight: number;

	/**
	 * Weight Scale, get the Unit Name from Unit Of Measurement entity where Unit Category is Weight.
	 */
	weightScale: string;

	/**
	 * Body Mass Index (BMI), with 2 decimal digits.
	 */
	bmi: number;

	/**
	 * Respiratory (X/min), with 2 decimal digits.
	 */
	respiratory: number;

	/**
	 * Oxygen Saturation (%), with 2 decimal digits.
	 */
	oxygenSaturation: number;

	/**
	 * Waist Circumfecimal digitsrence, with 2 de.
	 */
	waistCircumference: number;

	/**
	 * Waist Circumference Unit, get the Unit Name from Unit Of Measuement entity where Unit Category is Length.
	 */
	waistCircumferenceUnit: string;

	/**
	 * Nutrition Status, get the Code from Reference Data where Type=NUTRI_STATUS. (Max Length: 20).
	 */
	nutritionStatus: string;

	/**
	 * Pain Scale.
	 */
	painScale: number;

	/**
	 * Pain Scale Used, get the Code from Reference Data where Type=PAIN_SCALE_USE. (Max Length: 20).
	 */
	painScaleUsed: string;

	/**
	 * Risk Fall Scale.
	 */
	riskFallScale: number;

	/**
	 * The medical staff's examination result  (Max Length: 5000).
	 */
	objective: string;

	/**
	 * Risk Fall Scale Used, get the Code from Reference Data where Type=FALL_SCALE_USE. (Max Length: 20).
	 */
	riskFallScaleUsed: string;

	/**
	 * The patient's perspective/complaint of their condition (Max Length: 5000).
	 */
	subjective: string;

	/**
	 * The treatment or supporting examination plan for the patient  (Max Length: 5000).
	 */
	plan: string;

	/**
	 * Registration purpose  to service (Max Length: 5000).
	 */
	purpose: string;

	/**
	 * Examination Sub Case, only if the Examination Case is SURGICAL, get the Code from Reference Data where Type=EXAM_SUB_CASE. (Max Length: 20).
	 */
	examinationSubCase: string;

	/**
	 * Accidental Type, get the Code from Reference Data where Type=ACCIDENT_TYPE. (Max Length: 20).
	 */
	accidentalType: string;

	/**
	 * Service Case, get the Code from Reference Data where Type=SERVICE_CASE and the associate to Examination Case value (Max Length: 20).
	 */
	serviceCase: string;

	/**
	 * Accidental Sub Type, get the Code from Reference Data where Type=ACCIDENT_SUBTYPE. (Max Length: 20).
	 */
	accidentalSubType: string;

	/**
	 * .
	 */
	additionalNotes: string;

	/**
	 * Options for Dental Clinic Service.
	 */
	dentalProcedure: string;

	/**
	 * Options of Psychiatry service.
	 */
	psychiatryCase: string;

	/**
	 * Options of Psychiatry service.
	 */
	therapy: string;

	/**
	 * Family Planning Checkbox.
	 */
	familyPlanning: boolean = false;

	/**
	 * .
	 */
	condition: string;

	/**
	 * .
	 */
	familyPlanningCase: string;

	/**
	 * .
	 */
	previousContraceptiveMethod: string;

	/**
	 * .
	 */
	sideEffects: string;

	/**
	 * .
	 */
	complication: string;

	/**
	 * .
	 */
	contraseptiveMethod: string;

	/**
	 * Visit Type for Family Planning service.
	 */
	visitType: string;

	/**
	 * .
	 */
	hearingTestMethod: string;

	/**
	 * .
	 */
	hearingTestNotes: string;

	/**
	 * .
	 */
	hearingLossCategory: string;

	/**
	 * .
	 */
	hearingLossNotes: string;

	/**
	 * .
	 */
	eyePositionRightEye: string;

	/**
	 * .
	 */
	eyePositionLeftEye: string;

	/**
	 * .
	 */
	muscleBalanceRightEye: string;

	/**
	 * .
	 */
	muscleBalanceLeftEye: string;

	/**
	 * .
	 */
	visualFieldRightEye: string;

	/**
	 * .
	 */
	visualFieldLeftEye: string;

	/**
	 * .
	 */
	ocularFunduscopyRightEye: string;

	/**
	 * .
	 */
	ocularFunduscopyLeftEye: string;

	/**
	 * .
	 */
	intraocularPressureRightEye: string;

	/**
	 * .
	 */
	intraocularPressureLeftEye: string;

	/**
	 * .
	 */
	colorBlindness: string;

	/**
	 * .
	 */
	visualAcuityRightEye: string;

	/**
	 * .
	 */
	visualAcuityLeftEye: string;

	/**
	 * .
	 */
	correctionRightEye: string;

	/**
	 * .
	 */
	correctionLeftEye: string;

	/**
	 * .
	 */
	additionRightEye: string;

	/**
	 * .
	 */
	additionLeftEye: string;

	/**
	 * .
	 */
	occlusion: string;

	/**
	 * .
	 */
	torusPalatinus: string;

	/**
	 * .
	 */
	torusMandibularis: string;

	/**
	 * .
	 */
	palatum: string;

	/**
	 * .
	 */
	diastema: boolean = false;

	/**
	 * .
	 */
	diastemaNotes: string;

	/**
	 * .
	 */
	toothAnomaly: boolean = false;

	/**
	 * .
	 */
	toothAnomalyNotes: string;

	/**
	 * .
	 */
	otherDentalNotes: string;

	/**
	 * D.
	 */
	decayed: string;

	/**
	 * M.
	 */
	missing: string;

	/**
	 * F.
	 */
	filled: string;

	/**
	 * .
	 */
	totalPhotograph: string;

	/**
	 * .
	 */
	photographType: string;

	/**
	 * .
	 */
	totalRontgenPhotograph: string;

	/**
	 * .
	 */
	rontgenPhotographType: string;

	birthHistoryId: string;

	birthHistory: BirthHistoryModel;

	bodyChartExaminationId: string;

	bodyChartExamination: BodyChartExaminationModel;

	deliveryMedicalExaminationRecordId: string;

	deliveryMedicalExaminationRecord: DeliveryMedicalExaminationRecordModel;

	entExaminationId: string;

	entExamination: EntExaminationModel;

	emergencyMedicationExaminationRecordId: string;

	emergencyMedicationExaminationRecord: EmergencyMedicalExaminationRecordModel;

	formulirKonselingTesHivId: string;

	formulirKonselingTesHiv: FormulirKonselingTesHivModel;

	hemodialysisExaminationId: string;

	hemodialysisExamination: HemodialysisExaminationModel;

	medicalExaminationRecordDischargeSummaryId: string;

	medicalExaminationRecordDischargeSummary: MedicalExaminationRecordDischargeSummaryModel;

	medicalRecordInitialChecklistId: string;

	medicalRecordInitialChecklist: MedicalRecordInitialChecklistModel;

	medicalRecordNextVerificationChecklistId: string;

	medicalRecordNextVerificationChecklist: MedicalRecordNextVerificationChecklistModel;

	nurseVitalSignMeasurementId: string;

	nurseVitalSignMeasurement: NurseVitalSignMeasurementModel;

	obstetricAndGynecologyHistoryId: string;

	obstetricAndGynecologyHistory: ObstetricAndGynecologyHistoryModel;

	odontogramExaminationId: string;

	odontogramExamination: OdontogramExaminationModel;

	operatingTheaterMedicalExaminationRecordId: string;

	operatingTheaterMedicalExaminationRecord: OperatingTheaterMedicalExaminationRecordModel;

	ophthalmologyExaminationId: string;

	ophthalmologyExamination: OphthalmologyExaminationModel;

	inpatientMedicalExaminationRecordId: string;

	inpatientMedicalExaminationRecord: InpatientMedicalExaminationRecordModel;

	registrationId: string;

	registration: RegistrationModel;

	doctorId: string;

	doctor: StaffModel;

	medicalTranscriberId: string;

	medicalTranscriber: StaffModel;

	nurseId: string;

	nurse: StaffModel;

	amendmentDetailsIds: string[] = [];

	amendmentDetails: AmendmentDetailModel[];

	coTreatingDoctorsIds: string[] = [];

	coTreatingDoctors: CoTreatingDoctorModel[];

	dailyCareCPPTsIds: string[] = [];

	dailyCareCPPTs: DailyCareCPPTModel[];

	diagnosisExaminationRecordsIds: string[] = [];

	diagnosisExaminationRecords: DiagnosisExaminationRecordModel[];

	diagnosisNandasIds: string[] = [];

	diagnosisNandas: DiagnosisNandaModel[];

	roomTransfersIds: string[] = [];

	roomTransfers: RoomTransferModel[];

	modelPropGroups: { [s: string]: Group } = MedicalExaminationRecordModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
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
				name: 'bpStandingSystole',
				// % protected region % [Set displayName for BP Standing Systole here] off begin
				displayName: 'BP Standing Systole',
				// % protected region % [Set displayName for BP Standing Systole here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for BP Standing Systole here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for BP Standing Systole here] end
				// % protected region % [Set isSensitive for BP Standing Systole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BP Standing Systole here] end
				// % protected region % [Set readonly for BP Standing Systole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BP Standing Systole here] end
				validators: [
					// % protected region % [Add other validators for BP Standing Systole here] off begin
					// % protected region % [Add other validators for BP Standing Systole here] end
				],
				// % protected region % [Add any additional model attribute properties for BP Standing Systole here] off begin
				// % protected region % [Add any additional model attribute properties for BP Standing Systole here] end
			},
			{
				name: 'bpStandingDiastole',
				// % protected region % [Set displayName for BP Standing Diastole here] off begin
				displayName: 'BP Standing Diastole',
				// % protected region % [Set displayName for BP Standing Diastole here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for BP Standing Diastole here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for BP Standing Diastole here] end
				// % protected region % [Set isSensitive for BP Standing Diastole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BP Standing Diastole here] end
				// % protected region % [Set readonly for BP Standing Diastole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BP Standing Diastole here] end
				validators: [
					// % protected region % [Add other validators for BP Standing Diastole here] off begin
					// % protected region % [Add other validators for BP Standing Diastole here] end
				],
				// % protected region % [Add any additional model attribute properties for BP Standing Diastole here] off begin
				// % protected region % [Add any additional model attribute properties for BP Standing Diastole here] end
			},
			{
				name: 'pulseRegularity',
				// % protected region % [Set displayName for Pulse Regularity here] off begin
				displayName: 'Pulse Regularity',
				// % protected region % [Set displayName for Pulse Regularity here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pulse Regularity here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pulse Regularity here] end
				// % protected region % [Set isSensitive for Pulse Regularity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pulse Regularity here] end
				// % protected region % [Set readonly for Pulse Regularity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pulse Regularity here] end
				validators: [
					// % protected region % [Add other validators for Pulse Regularity here] off begin
					// % protected region % [Add other validators for Pulse Regularity here] end
				],
				// % protected region % [Add any additional model attribute properties for Pulse Regularity here] off begin
				// % protected region % [Add any additional model attribute properties for Pulse Regularity here] end
			},
			{
				name: 'pulseStrength',
				// % protected region % [Set displayName for Pulse Strength here] off begin
				displayName: 'Pulse Strength',
				// % protected region % [Set displayName for Pulse Strength here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pulse Strength here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pulse Strength here] end
				// % protected region % [Set isSensitive for Pulse Strength here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pulse Strength here] end
				// % protected region % [Set readonly for Pulse Strength here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pulse Strength here] end
				validators: [
					// % protected region % [Add other validators for Pulse Strength here] off begin
					// % protected region % [Add other validators for Pulse Strength here] end
				],
				// % protected region % [Add any additional model attribute properties for Pulse Strength here] off begin
				// % protected region % [Add any additional model attribute properties for Pulse Strength here] end
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
				name: 'temperatureScale',
				// % protected region % [Set displayName for Temperature scale here] off begin
				displayName: 'Temperature scale',
				// % protected region % [Set displayName for Temperature scale here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Temperature scale here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Temperature scale here] end
				// % protected region % [Set isSensitive for Temperature scale here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Temperature scale here] end
				// % protected region % [Set readonly for Temperature scale here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Temperature scale here] end
				validators: [
					// % protected region % [Add other validators for Temperature scale here] off begin
					// % protected region % [Add other validators for Temperature scale here] end
				],
				// % protected region % [Add any additional model attribute properties for Temperature scale here] off begin
				// % protected region % [Add any additional model attribute properties for Temperature scale here] end
			},
			{
				name: 'gcsEyes',
				// % protected region % [Set displayName for GCS Eyes here] off begin
				displayName: 'GCS Eyes',
				// % protected region % [Set displayName for GCS Eyes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for GCS Eyes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for GCS Eyes here] end
				// % protected region % [Set isSensitive for GCS Eyes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for GCS Eyes here] end
				// % protected region % [Set readonly for GCS Eyes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for GCS Eyes here] end
				validators: [
					// % protected region % [Add other validators for GCS Eyes here] off begin
					// % protected region % [Add other validators for GCS Eyes here] end
				],
				// % protected region % [Add any additional model attribute properties for GCS Eyes here] off begin
				// % protected region % [Add any additional model attribute properties for GCS Eyes here] end
			},
			{
				name: 'gcsVerbal',
				// % protected region % [Set displayName for GCS Verbal here] off begin
				displayName: 'GCS Verbal',
				// % protected region % [Set displayName for GCS Verbal here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for GCS Verbal here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for GCS Verbal here] end
				// % protected region % [Set isSensitive for GCS Verbal here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for GCS Verbal here] end
				// % protected region % [Set readonly for GCS Verbal here] off begin
				readOnly: false,
				// % protected region % [Set readonly for GCS Verbal here] end
				validators: [
					// % protected region % [Add other validators for GCS Verbal here] off begin
					// % protected region % [Add other validators for GCS Verbal here] end
				],
				// % protected region % [Add any additional model attribute properties for GCS Verbal here] off begin
				// % protected region % [Add any additional model attribute properties for GCS Verbal here] end
			},
			{
				name: 'gcsMotor',
				// % protected region % [Set displayName for GCS Motor here] off begin
				displayName: 'GCS Motor',
				// % protected region % [Set displayName for GCS Motor here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for GCS Motor here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for GCS Motor here] end
				// % protected region % [Set isSensitive for GCS Motor here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for GCS Motor here] end
				// % protected region % [Set readonly for GCS Motor here] off begin
				readOnly: false,
				// % protected region % [Set readonly for GCS Motor here] end
				validators: [
					// % protected region % [Add other validators for GCS Motor here] off begin
					// % protected region % [Add other validators for GCS Motor here] end
				],
				// % protected region % [Add any additional model attribute properties for GCS Motor here] off begin
				// % protected region % [Add any additional model attribute properties for GCS Motor here] end
			},
			{
				name: 'totalGCSScore',
				// % protected region % [Set displayName for Total GCS Score here] off begin
				displayName: 'Total GCS Score',
				// % protected region % [Set displayName for Total GCS Score here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total GCS Score here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total GCS Score here] end
				// % protected region % [Set isSensitive for Total GCS Score here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total GCS Score here] end
				// % protected region % [Set readonly for Total GCS Score here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total GCS Score here] end
				validators: [
					// % protected region % [Add other validators for Total GCS Score here] off begin
					// % protected region % [Add other validators for Total GCS Score here] end
				],
				// % protected region % [Add any additional model attribute properties for Total GCS Score here] off begin
				// % protected region % [Add any additional model attribute properties for Total GCS Score here] end
			},
			{
				name: 'consciousness',
				// % protected region % [Set displayName for Consciousness here] off begin
				displayName: 'Consciousness',
				// % protected region % [Set displayName for Consciousness here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consciousness here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Consciousness here] end
				// % protected region % [Set isSensitive for Consciousness here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consciousness here] end
				// % protected region % [Set readonly for Consciousness here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consciousness here] end
				validators: [
					// % protected region % [Add other validators for Consciousness here] off begin
					// % protected region % [Add other validators for Consciousness here] end
				],
				// % protected region % [Add any additional model attribute properties for Consciousness here] off begin
				// % protected region % [Add any additional model attribute properties for Consciousness here] end
			},
			{
				name: 'height',
				// % protected region % [Set displayName for Height here] off begin
				displayName: 'Height',
				// % protected region % [Set displayName for Height here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Height here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Height here] end
				// % protected region % [Set isSensitive for Height here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Height here] end
				// % protected region % [Set readonly for Height here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Height here] end
				validators: [
					// % protected region % [Add other validators for Height here] off begin
					// % protected region % [Add other validators for Height here] end
				],
				// % protected region % [Add any additional model attribute properties for Height here] off begin
				// % protected region % [Add any additional model attribute properties for Height here] end
			},
			{
				name: 'heightScale',
				// % protected region % [Set displayName for Height Scale here] off begin
				displayName: 'Height Scale',
				// % protected region % [Set displayName for Height Scale here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Height Scale here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Height Scale here] end
				// % protected region % [Set isSensitive for Height Scale here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Height Scale here] end
				// % protected region % [Set readonly for Height Scale here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Height Scale here] end
				validators: [
					// % protected region % [Add other validators for Height Scale here] off begin
					// % protected region % [Add other validators for Height Scale here] end
				],
				// % protected region % [Add any additional model attribute properties for Height Scale here] off begin
				// % protected region % [Add any additional model attribute properties for Height Scale here] end
			},
			{
				name: 'weight',
				// % protected region % [Set displayName for Weight here] off begin
				displayName: 'Weight',
				// % protected region % [Set displayName for Weight here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Weight here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Weight here] end
				// % protected region % [Set isSensitive for Weight here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight here] end
				// % protected region % [Set readonly for Weight here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight here] end
				validators: [
					// % protected region % [Add other validators for Weight here] off begin
					// % protected region % [Add other validators for Weight here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight here] off begin
				// % protected region % [Add any additional model attribute properties for Weight here] end
			},
			{
				name: 'weightScale',
				// % protected region % [Set displayName for Weight Scale here] off begin
				displayName: 'Weight Scale',
				// % protected region % [Set displayName for Weight Scale here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Weight Scale here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Weight Scale here] end
				// % protected region % [Set isSensitive for Weight Scale here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Weight Scale here] end
				// % protected region % [Set readonly for Weight Scale here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Weight Scale here] end
				validators: [
					// % protected region % [Add other validators for Weight Scale here] off begin
					// % protected region % [Add other validators for Weight Scale here] end
				],
				// % protected region % [Add any additional model attribute properties for Weight Scale here] off begin
				// % protected region % [Add any additional model attribute properties for Weight Scale here] end
			},
			{
				name: 'bmi',
				// % protected region % [Set displayName for BMI here] off begin
				displayName: 'BMI',
				// % protected region % [Set displayName for BMI here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for BMI here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for BMI here] end
				// % protected region % [Set isSensitive for BMI here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BMI here] end
				// % protected region % [Set readonly for BMI here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BMI here] end
				validators: [
					// % protected region % [Add other validators for BMI here] off begin
					// % protected region % [Add other validators for BMI here] end
				],
				// % protected region % [Add any additional model attribute properties for BMI here] off begin
				// % protected region % [Add any additional model attribute properties for BMI here] end
			},
			{
				name: 'respiratory',
				// % protected region % [Set displayName for Respiratory here] off begin
				displayName: 'Respiratory',
				// % protected region % [Set displayName for Respiratory here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Respiratory here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Respiratory here] end
				// % protected region % [Set isSensitive for Respiratory here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Respiratory here] end
				// % protected region % [Set readonly for Respiratory here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Respiratory here] end
				validators: [
					// % protected region % [Add other validators for Respiratory here] off begin
					// % protected region % [Add other validators for Respiratory here] end
				],
				// % protected region % [Add any additional model attribute properties for Respiratory here] off begin
				// % protected region % [Add any additional model attribute properties for Respiratory here] end
			},
			{
				name: 'oxygenSaturation',
				// % protected region % [Set displayName for Oxygen Saturation here] off begin
				displayName: 'Oxygen Saturation',
				// % protected region % [Set displayName for Oxygen Saturation here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Oxygen Saturation here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Oxygen Saturation here] end
				// % protected region % [Set isSensitive for Oxygen Saturation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Oxygen Saturation here] end
				// % protected region % [Set readonly for Oxygen Saturation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Oxygen Saturation here] end
				validators: [
					// % protected region % [Add other validators for Oxygen Saturation here] off begin
					// % protected region % [Add other validators for Oxygen Saturation here] end
				],
				// % protected region % [Add any additional model attribute properties for Oxygen Saturation here] off begin
				// % protected region % [Add any additional model attribute properties for Oxygen Saturation here] end
			},
			{
				name: 'waistCircumference',
				// % protected region % [Set displayName for Waist Circumference here] off begin
				displayName: 'Waist Circumference',
				// % protected region % [Set displayName for Waist Circumference here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Waist Circumference here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Waist Circumference here] end
				// % protected region % [Set isSensitive for Waist Circumference here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Waist Circumference here] end
				// % protected region % [Set readonly for Waist Circumference here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Waist Circumference here] end
				validators: [
					// % protected region % [Add other validators for Waist Circumference here] off begin
					// % protected region % [Add other validators for Waist Circumference here] end
				],
				// % protected region % [Add any additional model attribute properties for Waist Circumference here] off begin
				// % protected region % [Add any additional model attribute properties for Waist Circumference here] end
			},
			{
				name: 'waistCircumferenceUnit',
				// % protected region % [Set displayName for Waist Circumference Unit here] off begin
				displayName: 'Waist Circumference Unit',
				// % protected region % [Set displayName for Waist Circumference Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Waist Circumference Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Waist Circumference Unit here] end
				// % protected region % [Set isSensitive for Waist Circumference Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Waist Circumference Unit here] end
				// % protected region % [Set readonly for Waist Circumference Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Waist Circumference Unit here] end
				validators: [
					// % protected region % [Add other validators for Waist Circumference Unit here] off begin
					// % protected region % [Add other validators for Waist Circumference Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Waist Circumference Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Waist Circumference Unit here] end
			},
			{
				name: 'nutritionStatus',
				// % protected region % [Set displayName for Nutrition Status here] off begin
				displayName: 'Nutrition Status',
				// % protected region % [Set displayName for Nutrition Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nutrition Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nutrition Status here] end
				// % protected region % [Set isSensitive for Nutrition Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nutrition Status here] end
				// % protected region % [Set readonly for Nutrition Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nutrition Status here] end
				validators: [
					// % protected region % [Add other validators for Nutrition Status here] off begin
					// % protected region % [Add other validators for Nutrition Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Nutrition Status here] off begin
				// % protected region % [Add any additional model attribute properties for Nutrition Status here] end
			},
			{
				name: 'painScale',
				// % protected region % [Set displayName for Pain Scale here] off begin
				displayName: 'Pain Scale',
				// % protected region % [Set displayName for Pain Scale here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Pain Scale here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Pain Scale here] end
				// % protected region % [Set isSensitive for Pain Scale here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pain Scale here] end
				// % protected region % [Set readonly for Pain Scale here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pain Scale here] end
				validators: [
					// % protected region % [Add other validators for Pain Scale here] off begin
					// % protected region % [Add other validators for Pain Scale here] end
				],
				// % protected region % [Add any additional model attribute properties for Pain Scale here] off begin
				// % protected region % [Add any additional model attribute properties for Pain Scale here] end
			},
			{
				name: 'painScaleUsed',
				// % protected region % [Set displayName for Pain Scale Used here] off begin
				displayName: 'Pain Scale Used',
				// % protected region % [Set displayName for Pain Scale Used here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pain Scale Used here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pain Scale Used here] end
				// % protected region % [Set isSensitive for Pain Scale Used here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pain Scale Used here] end
				// % protected region % [Set readonly for Pain Scale Used here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pain Scale Used here] end
				validators: [
					// % protected region % [Add other validators for Pain Scale Used here] off begin
					// % protected region % [Add other validators for Pain Scale Used here] end
				],
				// % protected region % [Add any additional model attribute properties for Pain Scale Used here] off begin
				// % protected region % [Add any additional model attribute properties for Pain Scale Used here] end
			},
			{
				name: 'riskFallScale',
				// % protected region % [Set displayName for Risk Fall Scale here] off begin
				displayName: 'Risk Fall Scale',
				// % protected region % [Set displayName for Risk Fall Scale here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Risk Fall Scale here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Risk Fall Scale here] end
				// % protected region % [Set isSensitive for Risk Fall Scale here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Risk Fall Scale here] end
				// % protected region % [Set readonly for Risk Fall Scale here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Risk Fall Scale here] end
				validators: [
					// % protected region % [Add other validators for Risk Fall Scale here] off begin
					// % protected region % [Add other validators for Risk Fall Scale here] end
				],
				// % protected region % [Add any additional model attribute properties for Risk Fall Scale here] off begin
				// % protected region % [Add any additional model attribute properties for Risk Fall Scale here] end
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
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Objective here] off begin
					// % protected region % [Add other validators for Objective here] end
				],
				// % protected region % [Add any additional model attribute properties for Objective here] off begin
				// % protected region % [Add any additional model attribute properties for Objective here] end
			},
			{
				name: 'riskFallScaleUsed',
				// % protected region % [Set displayName for Risk Fall Scale Used here] off begin
				displayName: 'Risk Fall Scale Used',
				// % protected region % [Set displayName for Risk Fall Scale Used here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Risk Fall Scale Used here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Risk Fall Scale Used here] end
				// % protected region % [Set isSensitive for Risk Fall Scale Used here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Risk Fall Scale Used here] end
				// % protected region % [Set readonly for Risk Fall Scale Used here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Risk Fall Scale Used here] end
				validators: [
					// % protected region % [Add other validators for Risk Fall Scale Used here] off begin
					// % protected region % [Add other validators for Risk Fall Scale Used here] end
				],
				// % protected region % [Add any additional model attribute properties for Risk Fall Scale Used here] off begin
				// % protected region % [Add any additional model attribute properties for Risk Fall Scale Used here] end
			},
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
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Subjective here] off begin
					// % protected region % [Add other validators for Subjective here] end
				],
				// % protected region % [Add any additional model attribute properties for Subjective here] off begin
				// % protected region % [Add any additional model attribute properties for Subjective here] end
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
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Plan here] off begin
					// % protected region % [Add other validators for Plan here] end
				],
				// % protected region % [Add any additional model attribute properties for Plan here] off begin
				// % protected region % [Add any additional model attribute properties for Plan here] end
			},
			{
				name: 'purpose',
				// % protected region % [Set displayName for Purpose here] off begin
				displayName: 'Purpose',
				// % protected region % [Set displayName for Purpose here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Purpose here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Purpose here] end
				// % protected region % [Set isSensitive for Purpose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Purpose here] end
				// % protected region % [Set readonly for Purpose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Purpose here] end
				validators: [
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Purpose here] off begin
					// % protected region % [Add other validators for Purpose here] end
				],
				// % protected region % [Add any additional model attribute properties for Purpose here] off begin
				// % protected region % [Add any additional model attribute properties for Purpose here] end
			},
			{
				name: 'examinationSubCase',
				// % protected region % [Set displayName for Examination Sub Case here] off begin
				displayName: 'Examination Sub Case',
				// % protected region % [Set displayName for Examination Sub Case here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Examination Sub Case here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Examination Sub Case here] end
				// % protected region % [Set isSensitive for Examination Sub Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Examination Sub Case here] end
				// % protected region % [Set readonly for Examination Sub Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Examination Sub Case here] end
				validators: [
					// % protected region % [Add other validators for Examination Sub Case here] off begin
					// % protected region % [Add other validators for Examination Sub Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Examination Sub Case here] off begin
				// % protected region % [Add any additional model attribute properties for Examination Sub Case here] end
			},
			{
				name: 'accidentalType',
				// % protected region % [Set displayName for Accidental Type here] off begin
				displayName: 'Accidental Type',
				// % protected region % [Set displayName for Accidental Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Accidental Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Accidental Type here] end
				// % protected region % [Set isSensitive for Accidental Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Accidental Type here] end
				// % protected region % [Set readonly for Accidental Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Accidental Type here] end
				validators: [
					// % protected region % [Add other validators for Accidental Type here] off begin
					// % protected region % [Add other validators for Accidental Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Accidental Type here] off begin
				// % protected region % [Add any additional model attribute properties for Accidental Type here] end
			},
			{
				name: 'serviceCase',
				// % protected region % [Set displayName for Service Case here] off begin
				displayName: 'Service Case',
				// % protected region % [Set displayName for Service Case here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Service Case here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Service Case here] end
				// % protected region % [Set isSensitive for Service Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Service Case here] end
				// % protected region % [Set readonly for Service Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Service Case here] end
				validators: [
					// % protected region % [Add other validators for Service Case here] off begin
					// % protected region % [Add other validators for Service Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Service Case here] off begin
				// % protected region % [Add any additional model attribute properties for Service Case here] end
			},
			{
				name: 'accidentalSubType',
				// % protected region % [Set displayName for Accidental Sub Type here] off begin
				displayName: 'Accidental Sub Type',
				// % protected region % [Set displayName for Accidental Sub Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Accidental Sub Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Accidental Sub Type here] end
				// % protected region % [Set isSensitive for Accidental Sub Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Accidental Sub Type here] end
				// % protected region % [Set readonly for Accidental Sub Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Accidental Sub Type here] end
				validators: [
					// % protected region % [Add other validators for Accidental Sub Type here] off begin
					// % protected region % [Add other validators for Accidental Sub Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Accidental Sub Type here] off begin
				// % protected region % [Add any additional model attribute properties for Accidental Sub Type here] end
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
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Additional Notes here] off begin
					// % protected region % [Add other validators for Additional Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Additional Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Additional Notes here] end
			},
			{
				name: 'dentalProcedure',
				// % protected region % [Set displayName for Dental Procedure here] off begin
				displayName: 'Dental Procedure',
				// % protected region % [Set displayName for Dental Procedure here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dental Procedure here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dental Procedure here] end
				// % protected region % [Set isSensitive for Dental Procedure here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dental Procedure here] end
				// % protected region % [Set readonly for Dental Procedure here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dental Procedure here] end
				validators: [
					// % protected region % [Add other validators for Dental Procedure here] off begin
					// % protected region % [Add other validators for Dental Procedure here] end
				],
				// % protected region % [Add any additional model attribute properties for Dental Procedure here] off begin
				// % protected region % [Add any additional model attribute properties for Dental Procedure here] end
			},
			{
				name: 'psychiatryCase',
				// % protected region % [Set displayName for Psychiatry Case here] off begin
				displayName: 'Psychiatry Case',
				// % protected region % [Set displayName for Psychiatry Case here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Psychiatry Case here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Psychiatry Case here] end
				// % protected region % [Set isSensitive for Psychiatry Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Psychiatry Case here] end
				// % protected region % [Set readonly for Psychiatry Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Psychiatry Case here] end
				validators: [
					// % protected region % [Add other validators for Psychiatry Case here] off begin
					// % protected region % [Add other validators for Psychiatry Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Psychiatry Case here] off begin
				// % protected region % [Add any additional model attribute properties for Psychiatry Case here] end
			},
			{
				name: 'therapy',
				// % protected region % [Set displayName for Therapy here] off begin
				displayName: 'Therapy',
				// % protected region % [Set displayName for Therapy here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Therapy here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Therapy here] end
				// % protected region % [Set isSensitive for Therapy here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Therapy here] end
				// % protected region % [Set readonly for Therapy here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Therapy here] end
				validators: [
					// % protected region % [Add other validators for Therapy here] off begin
					// % protected region % [Add other validators for Therapy here] end
				],
				// % protected region % [Add any additional model attribute properties for Therapy here] off begin
				// % protected region % [Add any additional model attribute properties for Therapy here] end
			},
			{
				name: 'familyPlanning',
				// % protected region % [Set displayName for Family Planning here] off begin
				displayName: 'Family Planning',
				// % protected region % [Set displayName for Family Planning here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Family Planning here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Family Planning here] end
				// % protected region % [Set isSensitive for Family Planning here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Family Planning here] end
				// % protected region % [Set readonly for Family Planning here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Family Planning here] end
				validators: [
					// % protected region % [Add other validators for Family Planning here] off begin
					// % protected region % [Add other validators for Family Planning here] end
				],
				// % protected region % [Add any additional model attribute properties for Family Planning here] off begin
				// % protected region % [Add any additional model attribute properties for Family Planning here] end
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
				name: 'familyPlanningCase',
				// % protected region % [Set displayName for Family Planning Case here] off begin
				displayName: 'Family Planning Case',
				// % protected region % [Set displayName for Family Planning Case here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Family Planning Case here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Family Planning Case here] end
				// % protected region % [Set isSensitive for Family Planning Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Family Planning Case here] end
				// % protected region % [Set readonly for Family Planning Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Family Planning Case here] end
				validators: [
					// % protected region % [Add other validators for Family Planning Case here] off begin
					// % protected region % [Add other validators for Family Planning Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Family Planning Case here] off begin
				// % protected region % [Add any additional model attribute properties for Family Planning Case here] end
			},
			{
				name: 'previousContraceptiveMethod',
				// % protected region % [Set displayName for Previous Contraceptive Method here] off begin
				displayName: 'Previous Contraceptive Method',
				// % protected region % [Set displayName for Previous Contraceptive Method here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Previous Contraceptive Method here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Previous Contraceptive Method here] end
				// % protected region % [Set isSensitive for Previous Contraceptive Method here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Previous Contraceptive Method here] end
				// % protected region % [Set readonly for Previous Contraceptive Method here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Previous Contraceptive Method here] end
				validators: [
					// % protected region % [Add other validators for Previous Contraceptive Method here] off begin
					// % protected region % [Add other validators for Previous Contraceptive Method here] end
				],
				// % protected region % [Add any additional model attribute properties for Previous Contraceptive Method here] off begin
				// % protected region % [Add any additional model attribute properties for Previous Contraceptive Method here] end
			},
			{
				name: 'sideEffects',
				// % protected region % [Set displayName for Side Effects here] off begin
				displayName: 'Side Effects',
				// % protected region % [Set displayName for Side Effects here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Side Effects here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Side Effects here] end
				// % protected region % [Set isSensitive for Side Effects here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Side Effects here] end
				// % protected region % [Set readonly for Side Effects here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Side Effects here] end
				validators: [
					// % protected region % [Add other validators for Side Effects here] off begin
					// % protected region % [Add other validators for Side Effects here] end
				],
				// % protected region % [Add any additional model attribute properties for Side Effects here] off begin
				// % protected region % [Add any additional model attribute properties for Side Effects here] end
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
				name: 'contraseptiveMethod',
				// % protected region % [Set displayName for Contraseptive Method here] off begin
				displayName: 'Contraseptive Method',
				// % protected region % [Set displayName for Contraseptive Method here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Contraseptive Method here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Contraseptive Method here] end
				// % protected region % [Set isSensitive for Contraseptive Method here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Contraseptive Method here] end
				// % protected region % [Set readonly for Contraseptive Method here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Contraseptive Method here] end
				validators: [
					// % protected region % [Add other validators for Contraseptive Method here] off begin
					// % protected region % [Add other validators for Contraseptive Method here] end
				],
				// % protected region % [Add any additional model attribute properties for Contraseptive Method here] off begin
				// % protected region % [Add any additional model attribute properties for Contraseptive Method here] end
			},
			{
				name: 'visitType',
				// % protected region % [Set displayName for Visit Type here] off begin
				displayName: 'Visit Type',
				// % protected region % [Set displayName for Visit Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Visit Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Visit Type here] end
				// % protected region % [Set isSensitive for Visit Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visit Type here] end
				// % protected region % [Set readonly for Visit Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visit Type here] end
				validators: [
					// % protected region % [Add other validators for Visit Type here] off begin
					// % protected region % [Add other validators for Visit Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Visit Type here] off begin
				// % protected region % [Add any additional model attribute properties for Visit Type here] end
			},
			{
				name: 'hearingTestMethod',
				// % protected region % [Set displayName for Hearing Test Method here] off begin
				displayName: 'Hearing Test Method',
				// % protected region % [Set displayName for Hearing Test Method here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hearing Test Method here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hearing Test Method here] end
				// % protected region % [Set isSensitive for Hearing Test Method here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hearing Test Method here] end
				// % protected region % [Set readonly for Hearing Test Method here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hearing Test Method here] end
				validators: [
					// % protected region % [Add other validators for Hearing Test Method here] off begin
					// % protected region % [Add other validators for Hearing Test Method here] end
				],
				// % protected region % [Add any additional model attribute properties for Hearing Test Method here] off begin
				// % protected region % [Add any additional model attribute properties for Hearing Test Method here] end
			},
			{
				name: 'hearingTestNotes',
				// % protected region % [Set displayName for Hearing Test Notes here] off begin
				displayName: 'Hearing Test Notes',
				// % protected region % [Set displayName for Hearing Test Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hearing Test Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hearing Test Notes here] end
				// % protected region % [Set isSensitive for Hearing Test Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hearing Test Notes here] end
				// % protected region % [Set readonly for Hearing Test Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hearing Test Notes here] end
				validators: [
					// % protected region % [Add other validators for Hearing Test Notes here] off begin
					// % protected region % [Add other validators for Hearing Test Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Hearing Test Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Hearing Test Notes here] end
			},
			{
				name: 'hearingLossCategory',
				// % protected region % [Set displayName for Hearing Loss Category here] off begin
				displayName: 'Hearing Loss Category',
				// % protected region % [Set displayName for Hearing Loss Category here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hearing Loss Category here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hearing Loss Category here] end
				// % protected region % [Set isSensitive for Hearing Loss Category here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hearing Loss Category here] end
				// % protected region % [Set readonly for Hearing Loss Category here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hearing Loss Category here] end
				validators: [
					// % protected region % [Add other validators for Hearing Loss Category here] off begin
					// % protected region % [Add other validators for Hearing Loss Category here] end
				],
				// % protected region % [Add any additional model attribute properties for Hearing Loss Category here] off begin
				// % protected region % [Add any additional model attribute properties for Hearing Loss Category here] end
			},
			{
				name: 'hearingLossNotes',
				// % protected region % [Set displayName for Hearing Loss Notes here] off begin
				displayName: 'Hearing Loss Notes',
				// % protected region % [Set displayName for Hearing Loss Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hearing Loss Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hearing Loss Notes here] end
				// % protected region % [Set isSensitive for Hearing Loss Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hearing Loss Notes here] end
				// % protected region % [Set readonly for Hearing Loss Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hearing Loss Notes here] end
				validators: [
					// % protected region % [Add other validators for Hearing Loss Notes here] off begin
					// % protected region % [Add other validators for Hearing Loss Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Hearing Loss Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Hearing Loss Notes here] end
			},
			{
				name: 'eyePositionRightEye',
				// % protected region % [Set displayName for Eye Position Right Eye here] off begin
				displayName: 'Eye Position Right Eye',
				// % protected region % [Set displayName for Eye Position Right Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Eye Position Right Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Eye Position Right Eye here] end
				// % protected region % [Set isSensitive for Eye Position Right Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Eye Position Right Eye here] end
				// % protected region % [Set readonly for Eye Position Right Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Eye Position Right Eye here] end
				validators: [
					// % protected region % [Add other validators for Eye Position Right Eye here] off begin
					// % protected region % [Add other validators for Eye Position Right Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Eye Position Right Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Eye Position Right Eye here] end
			},
			{
				name: 'eyePositionLeftEye',
				// % protected region % [Set displayName for Eye Position Left Eye here] off begin
				displayName: 'Eye Position Left Eye',
				// % protected region % [Set displayName for Eye Position Left Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Eye Position Left Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Eye Position Left Eye here] end
				// % protected region % [Set isSensitive for Eye Position Left Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Eye Position Left Eye here] end
				// % protected region % [Set readonly for Eye Position Left Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Eye Position Left Eye here] end
				validators: [
					// % protected region % [Add other validators for Eye Position Left Eye here] off begin
					// % protected region % [Add other validators for Eye Position Left Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Eye Position Left Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Eye Position Left Eye here] end
			},
			{
				name: 'muscleBalanceRightEye',
				// % protected region % [Set displayName for Muscle Balance Right Eye here] off begin
				displayName: 'Muscle Balance Right Eye',
				// % protected region % [Set displayName for Muscle Balance Right Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Muscle Balance Right Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Muscle Balance Right Eye here] end
				// % protected region % [Set isSensitive for Muscle Balance Right Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Muscle Balance Right Eye here] end
				// % protected region % [Set readonly for Muscle Balance Right Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Muscle Balance Right Eye here] end
				validators: [
					// % protected region % [Add other validators for Muscle Balance Right Eye here] off begin
					// % protected region % [Add other validators for Muscle Balance Right Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Muscle Balance Right Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Muscle Balance Right Eye here] end
			},
			{
				name: 'muscleBalanceLeftEye',
				// % protected region % [Set displayName for Muscle Balance Left Eye here] off begin
				displayName: 'Muscle Balance Left Eye',
				// % protected region % [Set displayName for Muscle Balance Left Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Muscle Balance Left Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Muscle Balance Left Eye here] end
				// % protected region % [Set isSensitive for Muscle Balance Left Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Muscle Balance Left Eye here] end
				// % protected region % [Set readonly for Muscle Balance Left Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Muscle Balance Left Eye here] end
				validators: [
					// % protected region % [Add other validators for Muscle Balance Left Eye here] off begin
					// % protected region % [Add other validators for Muscle Balance Left Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Muscle Balance Left Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Muscle Balance Left Eye here] end
			},
			{
				name: 'visualFieldRightEye',
				// % protected region % [Set displayName for Visual Field Right Eye here] off begin
				displayName: 'Visual Field Right Eye',
				// % protected region % [Set displayName for Visual Field Right Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Visual Field Right Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Visual Field Right Eye here] end
				// % protected region % [Set isSensitive for Visual Field Right Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visual Field Right Eye here] end
				// % protected region % [Set readonly for Visual Field Right Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visual Field Right Eye here] end
				validators: [
					// % protected region % [Add other validators for Visual Field Right Eye here] off begin
					// % protected region % [Add other validators for Visual Field Right Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Visual Field Right Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Visual Field Right Eye here] end
			},
			{
				name: 'visualFieldLeftEye',
				// % protected region % [Set displayName for Visual Field Left Eye here] off begin
				displayName: 'Visual Field Left Eye',
				// % protected region % [Set displayName for Visual Field Left Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Visual Field Left Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Visual Field Left Eye here] end
				// % protected region % [Set isSensitive for Visual Field Left Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visual Field Left Eye here] end
				// % protected region % [Set readonly for Visual Field Left Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visual Field Left Eye here] end
				validators: [
					// % protected region % [Add other validators for Visual Field Left Eye here] off begin
					// % protected region % [Add other validators for Visual Field Left Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Visual Field Left Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Visual Field Left Eye here] end
			},
			{
				name: 'ocularFunduscopyRightEye',
				// % protected region % [Set displayName for Ocular Funduscopy Right Eye here] off begin
				displayName: 'Ocular Funduscopy Right Eye',
				// % protected region % [Set displayName for Ocular Funduscopy Right Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ocular Funduscopy Right Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ocular Funduscopy Right Eye here] end
				// % protected region % [Set isSensitive for Ocular Funduscopy Right Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ocular Funduscopy Right Eye here] end
				// % protected region % [Set readonly for Ocular Funduscopy Right Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ocular Funduscopy Right Eye here] end
				validators: [
					// % protected region % [Add other validators for Ocular Funduscopy Right Eye here] off begin
					// % protected region % [Add other validators for Ocular Funduscopy Right Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Ocular Funduscopy Right Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Ocular Funduscopy Right Eye here] end
			},
			{
				name: 'ocularFunduscopyLeftEye',
				// % protected region % [Set displayName for Ocular Funduscopy Left Eye here] off begin
				displayName: 'Ocular Funduscopy Left Eye',
				// % protected region % [Set displayName for Ocular Funduscopy Left Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ocular Funduscopy Left Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ocular Funduscopy Left Eye here] end
				// % protected region % [Set isSensitive for Ocular Funduscopy Left Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ocular Funduscopy Left Eye here] end
				// % protected region % [Set readonly for Ocular Funduscopy Left Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ocular Funduscopy Left Eye here] end
				validators: [
					// % protected region % [Add other validators for Ocular Funduscopy Left Eye here] off begin
					// % protected region % [Add other validators for Ocular Funduscopy Left Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Ocular Funduscopy Left Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Ocular Funduscopy Left Eye here] end
			},
			{
				name: 'intraocularPressureRightEye',
				// % protected region % [Set displayName for Intraocular Pressure Right Eye here] off begin
				displayName: 'Intraocular Pressure Right Eye',
				// % protected region % [Set displayName for Intraocular Pressure Right Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Intraocular Pressure Right Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Intraocular Pressure Right Eye here] end
				// % protected region % [Set isSensitive for Intraocular Pressure Right Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Intraocular Pressure Right Eye here] end
				// % protected region % [Set readonly for Intraocular Pressure Right Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Intraocular Pressure Right Eye here] end
				validators: [
					// % protected region % [Add other validators for Intraocular Pressure Right Eye here] off begin
					// % protected region % [Add other validators for Intraocular Pressure Right Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Intraocular Pressure Right Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Intraocular Pressure Right Eye here] end
			},
			{
				name: 'intraocularPressureLeftEye',
				// % protected region % [Set displayName for Intraocular Pressure Left Eye here] off begin
				displayName: 'Intraocular Pressure Left Eye',
				// % protected region % [Set displayName for Intraocular Pressure Left Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Intraocular Pressure Left Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Intraocular Pressure Left Eye here] end
				// % protected region % [Set isSensitive for Intraocular Pressure Left Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Intraocular Pressure Left Eye here] end
				// % protected region % [Set readonly for Intraocular Pressure Left Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Intraocular Pressure Left Eye here] end
				validators: [
					// % protected region % [Add other validators for Intraocular Pressure Left Eye here] off begin
					// % protected region % [Add other validators for Intraocular Pressure Left Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Intraocular Pressure Left Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Intraocular Pressure Left Eye here] end
			},
			{
				name: 'colorBlindness',
				// % protected region % [Set displayName for Color Blindness here] off begin
				displayName: 'Color Blindness',
				// % protected region % [Set displayName for Color Blindness here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Color Blindness here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Color Blindness here] end
				// % protected region % [Set isSensitive for Color Blindness here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Color Blindness here] end
				// % protected region % [Set readonly for Color Blindness here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Color Blindness here] end
				validators: [
					// % protected region % [Add other validators for Color Blindness here] off begin
					// % protected region % [Add other validators for Color Blindness here] end
				],
				// % protected region % [Add any additional model attribute properties for Color Blindness here] off begin
				// % protected region % [Add any additional model attribute properties for Color Blindness here] end
			},
			{
				name: 'visualAcuityRightEye',
				// % protected region % [Set displayName for Visual Acuity Right Eye here] off begin
				displayName: 'Visual Acuity Right Eye',
				// % protected region % [Set displayName for Visual Acuity Right Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Visual Acuity Right Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Visual Acuity Right Eye here] end
				// % protected region % [Set isSensitive for Visual Acuity Right Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visual Acuity Right Eye here] end
				// % protected region % [Set readonly for Visual Acuity Right Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visual Acuity Right Eye here] end
				validators: [
					// % protected region % [Add other validators for Visual Acuity Right Eye here] off begin
					// % protected region % [Add other validators for Visual Acuity Right Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Visual Acuity Right Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Visual Acuity Right Eye here] end
			},
			{
				name: 'visualAcuityLeftEye',
				// % protected region % [Set displayName for Visual Acuity Left Eye here] off begin
				displayName: 'Visual Acuity Left Eye',
				// % protected region % [Set displayName for Visual Acuity Left Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Visual Acuity Left Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Visual Acuity Left Eye here] end
				// % protected region % [Set isSensitive for Visual Acuity Left Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visual Acuity Left Eye here] end
				// % protected region % [Set readonly for Visual Acuity Left Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visual Acuity Left Eye here] end
				validators: [
					// % protected region % [Add other validators for Visual Acuity Left Eye here] off begin
					// % protected region % [Add other validators for Visual Acuity Left Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Visual Acuity Left Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Visual Acuity Left Eye here] end
			},
			{
				name: 'correctionRightEye',
				// % protected region % [Set displayName for Correction Right Eye here] off begin
				displayName: 'Correction Right Eye',
				// % protected region % [Set displayName for Correction Right Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Correction Right Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Correction Right Eye here] end
				// % protected region % [Set isSensitive for Correction Right Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Correction Right Eye here] end
				// % protected region % [Set readonly for Correction Right Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Correction Right Eye here] end
				validators: [
					// % protected region % [Add other validators for Correction Right Eye here] off begin
					// % protected region % [Add other validators for Correction Right Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Correction Right Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Correction Right Eye here] end
			},
			{
				name: 'correctionLeftEye',
				// % protected region % [Set displayName for Correction Left Eye here] off begin
				displayName: 'Correction Left Eye',
				// % protected region % [Set displayName for Correction Left Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Correction Left Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Correction Left Eye here] end
				// % protected region % [Set isSensitive for Correction Left Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Correction Left Eye here] end
				// % protected region % [Set readonly for Correction Left Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Correction Left Eye here] end
				validators: [
					// % protected region % [Add other validators for Correction Left Eye here] off begin
					// % protected region % [Add other validators for Correction Left Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Correction Left Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Correction Left Eye here] end
			},
			{
				name: 'additionRightEye',
				// % protected region % [Set displayName for Addition Right Eye here] off begin
				displayName: 'Addition Right Eye',
				// % protected region % [Set displayName for Addition Right Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Addition Right Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Addition Right Eye here] end
				// % protected region % [Set isSensitive for Addition Right Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Addition Right Eye here] end
				// % protected region % [Set readonly for Addition Right Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Addition Right Eye here] end
				validators: [
					// % protected region % [Add other validators for Addition Right Eye here] off begin
					// % protected region % [Add other validators for Addition Right Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Addition Right Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Addition Right Eye here] end
			},
			{
				name: 'additionLeftEye',
				// % protected region % [Set displayName for Addition Left Eye here] off begin
				displayName: 'Addition Left Eye',
				// % protected region % [Set displayName for Addition Left Eye here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Addition Left Eye here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Addition Left Eye here] end
				// % protected region % [Set isSensitive for Addition Left Eye here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Addition Left Eye here] end
				// % protected region % [Set readonly for Addition Left Eye here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Addition Left Eye here] end
				validators: [
					// % protected region % [Add other validators for Addition Left Eye here] off begin
					// % protected region % [Add other validators for Addition Left Eye here] end
				],
				// % protected region % [Add any additional model attribute properties for Addition Left Eye here] off begin
				// % protected region % [Add any additional model attribute properties for Addition Left Eye here] end
			},
			{
				name: 'occlusion',
				// % protected region % [Set displayName for Occlusion here] off begin
				displayName: 'Occlusion',
				// % protected region % [Set displayName for Occlusion here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Occlusion here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Occlusion here] end
				// % protected region % [Set isSensitive for Occlusion here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Occlusion here] end
				// % protected region % [Set readonly for Occlusion here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Occlusion here] end
				validators: [
					// % protected region % [Add other validators for Occlusion here] off begin
					// % protected region % [Add other validators for Occlusion here] end
				],
				// % protected region % [Add any additional model attribute properties for Occlusion here] off begin
				// % protected region % [Add any additional model attribute properties for Occlusion here] end
			},
			{
				name: 'torusPalatinus',
				// % protected region % [Set displayName for Torus Palatinus here] off begin
				displayName: 'Torus Palatinus',
				// % protected region % [Set displayName for Torus Palatinus here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Torus Palatinus here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Torus Palatinus here] end
				// % protected region % [Set isSensitive for Torus Palatinus here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Torus Palatinus here] end
				// % protected region % [Set readonly for Torus Palatinus here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Torus Palatinus here] end
				validators: [
					// % protected region % [Add other validators for Torus Palatinus here] off begin
					// % protected region % [Add other validators for Torus Palatinus here] end
				],
				// % protected region % [Add any additional model attribute properties for Torus Palatinus here] off begin
				// % protected region % [Add any additional model attribute properties for Torus Palatinus here] end
			},
			{
				name: 'torusMandibularis',
				// % protected region % [Set displayName for Torus Mandibularis here] off begin
				displayName: 'Torus Mandibularis',
				// % protected region % [Set displayName for Torus Mandibularis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Torus Mandibularis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Torus Mandibularis here] end
				// % protected region % [Set isSensitive for Torus Mandibularis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Torus Mandibularis here] end
				// % protected region % [Set readonly for Torus Mandibularis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Torus Mandibularis here] end
				validators: [
					// % protected region % [Add other validators for Torus Mandibularis here] off begin
					// % protected region % [Add other validators for Torus Mandibularis here] end
				],
				// % protected region % [Add any additional model attribute properties for Torus Mandibularis here] off begin
				// % protected region % [Add any additional model attribute properties for Torus Mandibularis here] end
			},
			{
				name: 'palatum',
				// % protected region % [Set displayName for Palatum here] off begin
				displayName: 'Palatum',
				// % protected region % [Set displayName for Palatum here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Palatum here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Palatum here] end
				// % protected region % [Set isSensitive for Palatum here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Palatum here] end
				// % protected region % [Set readonly for Palatum here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Palatum here] end
				validators: [
					// % protected region % [Add other validators for Palatum here] off begin
					// % protected region % [Add other validators for Palatum here] end
				],
				// % protected region % [Add any additional model attribute properties for Palatum here] off begin
				// % protected region % [Add any additional model attribute properties for Palatum here] end
			},
			{
				name: 'diastema',
				// % protected region % [Set displayName for Diastema here] off begin
				displayName: 'Diastema',
				// % protected region % [Set displayName for Diastema here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Diastema here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Diastema here] end
				// % protected region % [Set isSensitive for Diastema here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diastema here] end
				// % protected region % [Set readonly for Diastema here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diastema here] end
				validators: [
					// % protected region % [Add other validators for Diastema here] off begin
					// % protected region % [Add other validators for Diastema here] end
				],
				// % protected region % [Add any additional model attribute properties for Diastema here] off begin
				// % protected region % [Add any additional model attribute properties for Diastema here] end
			},
			{
				name: 'diastemaNotes',
				// % protected region % [Set displayName for Diastema Notes here] off begin
				displayName: 'Diastema Notes',
				// % protected region % [Set displayName for Diastema Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Diastema Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Diastema Notes here] end
				// % protected region % [Set isSensitive for Diastema Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diastema Notes here] end
				// % protected region % [Set readonly for Diastema Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diastema Notes here] end
				validators: [
					// % protected region % [Add other validators for Diastema Notes here] off begin
					// % protected region % [Add other validators for Diastema Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Diastema Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Diastema Notes here] end
			},
			{
				name: 'toothAnomaly',
				// % protected region % [Set displayName for Tooth Anomaly here] off begin
				displayName: 'Tooth Anomaly',
				// % protected region % [Set displayName for Tooth Anomaly here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Tooth Anomaly here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Tooth Anomaly here] end
				// % protected region % [Set isSensitive for Tooth Anomaly here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tooth Anomaly here] end
				// % protected region % [Set readonly for Tooth Anomaly here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tooth Anomaly here] end
				validators: [
					// % protected region % [Add other validators for Tooth Anomaly here] off begin
					// % protected region % [Add other validators for Tooth Anomaly here] end
				],
				// % protected region % [Add any additional model attribute properties for Tooth Anomaly here] off begin
				// % protected region % [Add any additional model attribute properties for Tooth Anomaly here] end
			},
			{
				name: 'toothAnomalyNotes',
				// % protected region % [Set displayName for Tooth Anomaly Notes here] off begin
				displayName: 'Tooth Anomaly Notes',
				// % protected region % [Set displayName for Tooth Anomaly Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tooth Anomaly Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tooth Anomaly Notes here] end
				// % protected region % [Set isSensitive for Tooth Anomaly Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tooth Anomaly Notes here] end
				// % protected region % [Set readonly for Tooth Anomaly Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tooth Anomaly Notes here] end
				validators: [
					// % protected region % [Add other validators for Tooth Anomaly Notes here] off begin
					// % protected region % [Add other validators for Tooth Anomaly Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Tooth Anomaly Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Tooth Anomaly Notes here] end
			},
			{
				name: 'otherDentalNotes',
				// % protected region % [Set displayName for Other Dental Notes here] off begin
				displayName: 'Other Dental Notes',
				// % protected region % [Set displayName for Other Dental Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Other Dental Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Other Dental Notes here] end
				// % protected region % [Set isSensitive for Other Dental Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Dental Notes here] end
				// % protected region % [Set readonly for Other Dental Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Dental Notes here] end
				validators: [
					// % protected region % [Add other validators for Other Dental Notes here] off begin
					// % protected region % [Add other validators for Other Dental Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Dental Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Other Dental Notes here] end
			},
			{
				name: 'decayed',
				// % protected region % [Set displayName for Decayed here] off begin
				displayName: 'Decayed',
				// % protected region % [Set displayName for Decayed here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Decayed here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Decayed here] end
				// % protected region % [Set isSensitive for Decayed here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Decayed here] end
				// % protected region % [Set readonly for Decayed here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Decayed here] end
				validators: [
					// % protected region % [Add other validators for Decayed here] off begin
					// % protected region % [Add other validators for Decayed here] end
				],
				// % protected region % [Add any additional model attribute properties for Decayed here] off begin
				// % protected region % [Add any additional model attribute properties for Decayed here] end
			},
			{
				name: 'missing',
				// % protected region % [Set displayName for Missing here] off begin
				displayName: 'Missing',
				// % protected region % [Set displayName for Missing here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Missing here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Missing here] end
				// % protected region % [Set isSensitive for Missing here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Missing here] end
				// % protected region % [Set readonly for Missing here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Missing here] end
				validators: [
					// % protected region % [Add other validators for Missing here] off begin
					// % protected region % [Add other validators for Missing here] end
				],
				// % protected region % [Add any additional model attribute properties for Missing here] off begin
				// % protected region % [Add any additional model attribute properties for Missing here] end
			},
			{
				name: 'filled',
				// % protected region % [Set displayName for Filled here] off begin
				displayName: 'Filled',
				// % protected region % [Set displayName for Filled here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Filled here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Filled here] end
				// % protected region % [Set isSensitive for Filled here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Filled here] end
				// % protected region % [Set readonly for Filled here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Filled here] end
				validators: [
					// % protected region % [Add other validators for Filled here] off begin
					// % protected region % [Add other validators for Filled here] end
				],
				// % protected region % [Add any additional model attribute properties for Filled here] off begin
				// % protected region % [Add any additional model attribute properties for Filled here] end
			},
			{
				name: 'totalPhotograph',
				// % protected region % [Set displayName for Total Photograph here] off begin
				displayName: 'Total Photograph',
				// % protected region % [Set displayName for Total Photograph here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Total Photograph here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Total Photograph here] end
				// % protected region % [Set isSensitive for Total Photograph here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Photograph here] end
				// % protected region % [Set readonly for Total Photograph here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Photograph here] end
				validators: [
					// % protected region % [Add other validators for Total Photograph here] off begin
					// % protected region % [Add other validators for Total Photograph here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Photograph here] off begin
				// % protected region % [Add any additional model attribute properties for Total Photograph here] end
			},
			{
				name: 'photographType',
				// % protected region % [Set displayName for Photograph Type here] off begin
				displayName: 'Photograph Type',
				// % protected region % [Set displayName for Photograph Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Photograph Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Photograph Type here] end
				// % protected region % [Set isSensitive for Photograph Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Photograph Type here] end
				// % protected region % [Set readonly for Photograph Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Photograph Type here] end
				validators: [
					// % protected region % [Add other validators for Photograph Type here] off begin
					// % protected region % [Add other validators for Photograph Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Photograph Type here] off begin
				// % protected region % [Add any additional model attribute properties for Photograph Type here] end
			},
			{
				name: 'totalRontgenPhotograph',
				// % protected region % [Set displayName for Total Rontgen Photograph here] off begin
				displayName: 'Total Rontgen Photograph',
				// % protected region % [Set displayName for Total Rontgen Photograph here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Total Rontgen Photograph here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Total Rontgen Photograph here] end
				// % protected region % [Set isSensitive for Total Rontgen Photograph here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Rontgen Photograph here] end
				// % protected region % [Set readonly for Total Rontgen Photograph here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Rontgen Photograph here] end
				validators: [
					// % protected region % [Add other validators for Total Rontgen Photograph here] off begin
					// % protected region % [Add other validators for Total Rontgen Photograph here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Rontgen Photograph here] off begin
				// % protected region % [Add any additional model attribute properties for Total Rontgen Photograph here] end
			},
			{
				name: 'rontgenPhotographType',
				// % protected region % [Set displayName for Rontgen Photograph Type here] off begin
				displayName: 'Rontgen Photograph Type',
				// % protected region % [Set displayName for Rontgen Photograph Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Rontgen Photograph Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Rontgen Photograph Type here] end
				// % protected region % [Set isSensitive for Rontgen Photograph Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Rontgen Photograph Type here] end
				// % protected region % [Set readonly for Rontgen Photograph Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Rontgen Photograph Type here] end
				validators: [
					// % protected region % [Add other validators for Rontgen Photograph Type here] off begin
					// % protected region % [Add other validators for Rontgen Photograph Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Rontgen Photograph Type here] off begin
				// % protected region % [Add any additional model attribute properties for Rontgen Photograph Type here] end
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
				id: 'amendmentDetails',
				type: ModelRelationType.MANY,
				name: 'amendmentDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Amendment Details here] off begin
				label: 'Amendment Details',
				// % protected region % [Customise your 1-1 or 1-M label for Amendment Details here] end
				entityName: 'AmendmentDetailModel',
				// % protected region % [Customise your display name for Amendment Details here] off begin
				displayName: 'date',
				// % protected region % [Customise your display name for Amendment Details here] end
				validators: [
					// % protected region % [Add other validators for Amendment Details here] off begin
					// % protected region % [Add other validators for Amendment Details here] end
				],
				// % protected region % [Add any additional field for relation Amendment Details here] off begin
				// % protected region % [Add any additional field for relation Amendment Details here] end
			},
			{
				id: 'birthHistory',
				type: ModelRelationType.ONE,
				name: 'birthHistoryId',
				// % protected region % [Customise your 1-1 or 1-M label for Birth History here] off begin
				label: 'Birth History',
				// % protected region % [Customise your 1-1 or 1-M label for Birth History here] end
				entityName: 'BirthHistoryModel',
				// % protected region % [Customise your display name for Birth History here] off begin
				displayName: 'gestationalAgeWeeks',
				// % protected region % [Customise your display name for Birth History here] end
				validators: [
					// % protected region % [Add other validators for Birth History here] off begin
					// % protected region % [Add other validators for Birth History here] end
				],
				// % protected region % [Add any additional field for relation Birth History here] off begin
				// % protected region % [Add any additional field for relation Birth History here] end
			},
			{
				id: 'bodyChartExamination',
				type: ModelRelationType.ONE,
				name: 'bodyChartExaminationId',
				// % protected region % [Customise your 1-1 or 1-M label for Body Chart Examination here] off begin
				label: 'Body Chart Examination',
				// % protected region % [Customise your 1-1 or 1-M label for Body Chart Examination here] end
				entityName: 'BodyChartExaminationModel',
				// % protected region % [Customise your display name for Body Chart Examination here] off begin
				displayName: 'bc01Subjective',
				// % protected region % [Customise your display name for Body Chart Examination here] end
				validators: [
					// % protected region % [Add other validators for Body Chart Examination here] off begin
					// % protected region % [Add other validators for Body Chart Examination here] end
				],
				// % protected region % [Add any additional field for relation Body Chart Examination here] off begin
				// % protected region % [Add any additional field for relation Body Chart Examination here] end
			},
			{
				id: 'coTreatingDoctors',
				type: ModelRelationType.MANY,
				name: 'coTreatingDoctorsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Co Treating Doctors here] off begin
				label: 'Co Treating Doctors',
				// % protected region % [Customise your 1-1 or 1-M label for Co Treating Doctors here] end
				entityName: 'CoTreatingDoctorModel',
				// % protected region % [Customise your display name for Co Treating Doctors here] off begin
				displayName: 'doctorNotes',
				// % protected region % [Customise your display name for Co Treating Doctors here] end
				validators: [
					// % protected region % [Add other validators for Co Treating Doctors here] off begin
					// % protected region % [Add other validators for Co Treating Doctors here] end
				],
				// % protected region % [Add any additional field for relation Co Treating Doctors here] off begin
				// % protected region % [Add any additional field for relation Co Treating Doctors here] end
			},
			{
				id: 'dailyCareCPPTs',
				type: ModelRelationType.MANY,
				name: 'dailyCareCPPTsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Daily Care CPPTs here] off begin
				label: 'Daily Care CPPTs',
				// % protected region % [Customise your 1-1 or 1-M label for Daily Care CPPTs here] end
				entityName: 'DailyCareCPPTModel',
				// % protected region % [Customise your display name for Daily Care CPPTs here] off begin
				displayName: 'subjective',
				// % protected region % [Customise your display name for Daily Care CPPTs here] end
				validators: [
					// % protected region % [Add other validators for Daily Care CPPTs here] off begin
					// % protected region % [Add other validators for Daily Care CPPTs here] end
				],
				// % protected region % [Add any additional field for relation Daily Care CPPTs here] off begin
				// % protected region % [Add any additional field for relation Daily Care CPPTs here] end
			},
			{
				id: 'deliveryMedicalExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'deliveryMedicalExaminationRecordId',
				// % protected region % [Customise your 1-1 or 1-M label for Delivery Medical Examination Record here] off begin
				label: 'Delivery Medical Examination Record',
				// % protected region % [Customise your 1-1 or 1-M label for Delivery Medical Examination Record here] end
				entityName: 'DeliveryMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Delivery Medical Examination Record here] off begin
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
				id: 'diagnosisExaminationRecords',
				type: ModelRelationType.MANY,
				name: 'diagnosisExaminationRecordsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnosis Examination Records here] off begin
				label: 'Diagnosis Examination Records',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnosis Examination Records here] end
				entityName: 'DiagnosisExaminationRecordModel',
				// % protected region % [Customise your display name for Diagnosis Examination Records here] off begin
				displayName: 'diagnosisSequence',
				// % protected region % [Customise your display name for Diagnosis Examination Records here] end
				validators: [
					// % protected region % [Add other validators for Diagnosis Examination Records here] off begin
					// % protected region % [Add other validators for Diagnosis Examination Records here] end
				],
				// % protected region % [Add any additional field for relation Diagnosis Examination Records here] off begin
				// % protected region % [Add any additional field for relation Diagnosis Examination Records here] end
			},
			{
				id: 'diagnosisNandas',
				type: ModelRelationType.MANY,
				name: 'diagnosisNandasIds',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnosis Nandas here] off begin
				label: 'Diagnosis Nandas',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnosis Nandas here] end
				entityName: 'DiagnosisNandaModel',
				// % protected region % [Customise your display name for Diagnosis Nandas here] off begin
				displayName: 'nursingNotes',
				// % protected region % [Customise your display name for Diagnosis Nandas here] end
				validators: [
					// % protected region % [Add other validators for Diagnosis Nandas here] off begin
					// % protected region % [Add other validators for Diagnosis Nandas here] end
				],
				// % protected region % [Add any additional field for relation Diagnosis Nandas here] off begin
				// % protected region % [Add any additional field for relation Diagnosis Nandas here] end
			},
			{
				id: 'entExamination',
				type: ModelRelationType.ONE,
				name: 'entExaminationId',
				// % protected region % [Customise your 1-1 or 1-M label for ENT Examination here] off begin
				label: 'ENT Examination',
				// % protected region % [Customise your 1-1 or 1-M label for ENT Examination here] end
				entityName: 'EntExaminationModel',
				// % protected region % [Customise your display name for ENT Examination here] off begin
				displayName: 'rightExternalEarSubjective',
				// % protected region % [Customise your display name for ENT Examination here] end
				validators: [
					// % protected region % [Add other validators for ENT Examination here] off begin
					// % protected region % [Add other validators for ENT Examination here] end
				],
				// % protected region % [Add any additional field for relation ENT Examination here] off begin
				// % protected region % [Add any additional field for relation ENT Examination here] end
			},
			{
				id: 'emergencyMedicationExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'emergencyMedicationExaminationRecordId',
				// % protected region % [Customise your 1-1 or 1-M label for Emergency Medication Examination Record here] off begin
				label: 'Emergency Medication Examination Record',
				// % protected region % [Customise your 1-1 or 1-M label for Emergency Medication Examination Record here] end
				entityName: 'EmergencyMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Emergency Medication Examination Record here] off begin
				displayName: 'surgicalOrNonSurgical',
				// % protected region % [Customise your display name for Emergency Medication Examination Record here] end
				validators: [
					// % protected region % [Add other validators for Emergency Medication Examination Record here] off begin
					// % protected region % [Add other validators for Emergency Medication Examination Record here] end
				],
				// % protected region % [Add any additional field for relation Emergency Medication Examination Record here] off begin
				// % protected region % [Add any additional field for relation Emergency Medication Examination Record here] end
			},
			{
				id: 'formulirKonselingTesHiv',
				type: ModelRelationType.ONE,
				name: 'formulirKonselingTesHivId',
				// % protected region % [Customise your 1-1 or 1-M label for Formulir Konseling Tes Hiv here] off begin
				label: 'Formulir Konseling Tes Hiv',
				// % protected region % [Customise your 1-1 or 1-M label for Formulir Konseling Tes Hiv here] end
				entityName: 'FormulirKonselingTesHivModel',
				// % protected region % [Customise your display name for Formulir Konseling Tes Hiv here] off begin
				displayName: 'formData',
				// % protected region % [Customise your display name for Formulir Konseling Tes Hiv here] end
				validators: [
					// % protected region % [Add other validators for Formulir Konseling Tes Hiv here] off begin
					// % protected region % [Add other validators for Formulir Konseling Tes Hiv here] end
				],
				// % protected region % [Add any additional field for relation Formulir Konseling Tes Hiv here] off begin
				// % protected region % [Add any additional field for relation Formulir Konseling Tes Hiv here] end
			},
			{
				id: 'hemodialysisExamination',
				type: ModelRelationType.ONE,
				name: 'hemodialysisExaminationId',
				// % protected region % [Customise your 1-1 or 1-M label for Hemodialysis Examination here] off begin
				label: 'Hemodialysis Examination',
				// % protected region % [Customise your 1-1 or 1-M label for Hemodialysis Examination here] end
				entityName: 'HemodialysisExaminationModel',
				// % protected region % [Customise your display name for Hemodialysis Examination here] off begin
				displayName: 'firstDialysis',
				// % protected region % [Customise your display name for Hemodialysis Examination here] end
				validators: [
					// % protected region % [Add other validators for Hemodialysis Examination here] off begin
					// % protected region % [Add other validators for Hemodialysis Examination here] end
				],
				// % protected region % [Add any additional field for relation Hemodialysis Examination here] off begin
				// % protected region % [Add any additional field for relation Hemodialysis Examination here] end
			},
			{
				id: 'medicalExaminationRecordDischargeSummary',
				type: ModelRelationType.ONE,
				name: 'medicalExaminationRecordDischargeSummaryId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Examination Record Discharge Summary here] off begin
				label: 'Medical Examination Record Discharge Summary',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Examination Record Discharge Summary here] end
				entityName: 'MedicalExaminationRecordDischargeSummaryModel',
				// % protected region % [Customise your display name for Medical Examination Record Discharge Summary here] off begin
				displayName: 'diastole',
				// % protected region % [Customise your display name for Medical Examination Record Discharge Summary here] end
				validators: [
					// % protected region % [Add other validators for Medical Examination Record Discharge Summary here] off begin
					// % protected region % [Add other validators for Medical Examination Record Discharge Summary here] end
				],
				// % protected region % [Add any additional field for relation Medical Examination Record Discharge Summary here] off begin
				// % protected region % [Add any additional field for relation Medical Examination Record Discharge Summary here] end
			},
			{
				id: 'medicalRecordInitialChecklist',
				type: ModelRelationType.ONE,
				name: 'medicalRecordInitialChecklistId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Record Initial Checklist here] off begin
				label: 'Medical Record Initial Checklist',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Record Initial Checklist here] end
				entityName: 'MedicalRecordInitialChecklistModel',
				// % protected region % [Customise your display name for Medical Record Initial Checklist here] off begin
				displayName: 'outVitalSign',
				// % protected region % [Customise your display name for Medical Record Initial Checklist here] end
				validators: [
					// % protected region % [Add other validators for Medical Record Initial Checklist here] off begin
					// % protected region % [Add other validators for Medical Record Initial Checklist here] end
				],
				// % protected region % [Add any additional field for relation Medical Record Initial Checklist here] off begin
				// % protected region % [Add any additional field for relation Medical Record Initial Checklist here] end
			},
			{
				id: 'medicalRecordNextVerificationChecklist',
				type: ModelRelationType.ONE,
				name: 'medicalRecordNextVerificationChecklistId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Record Next Verification Checklist here] off begin
				label: 'Medical Record Next Verification Checklist',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Record Next Verification Checklist here] end
				entityName: 'MedicalRecordNextVerificationChecklistModel',
				// % protected region % [Customise your display name for Medical Record Next Verification Checklist here] off begin
				displayName: 'outVitalSign',
				// % protected region % [Customise your display name for Medical Record Next Verification Checklist here] end
				validators: [
					// % protected region % [Add other validators for Medical Record Next Verification Checklist here] off begin
					// % protected region % [Add other validators for Medical Record Next Verification Checklist here] end
				],
				// % protected region % [Add any additional field for relation Medical Record Next Verification Checklist here] off begin
				// % protected region % [Add any additional field for relation Medical Record Next Verification Checklist here] end
			},
			{
				id: 'nurseVitalSignMeasurement',
				type: ModelRelationType.ONE,
				name: 'nurseVitalSignMeasurementId',
				// % protected region % [Customise your 1-1 or 1-M label for Nurse Vital Sign Measurement here] off begin
				label: 'Nurse Vital Sign Measurement',
				// % protected region % [Customise your 1-1 or 1-M label for Nurse Vital Sign Measurement here] end
				entityName: 'NurseVitalSignMeasurementModel',
				// % protected region % [Customise your display name for Nurse Vital Sign Measurement here] off begin
				displayName: 'diastole',
				// % protected region % [Customise your display name for Nurse Vital Sign Measurement here] end
				validators: [
					// % protected region % [Add other validators for Nurse Vital Sign Measurement here] off begin
					// % protected region % [Add other validators for Nurse Vital Sign Measurement here] end
				],
				// % protected region % [Add any additional field for relation Nurse Vital Sign Measurement here] off begin
				// % protected region % [Add any additional field for relation Nurse Vital Sign Measurement here] end
			},
			{
				id: 'obstetricAndGynecologyHistory',
				type: ModelRelationType.ONE,
				name: 'obstetricAndGynecologyHistoryId',
				// % protected region % [Customise your 1-1 or 1-M label for Obstetric And Gynecology History here] off begin
				label: 'Obstetric And Gynecology History',
				// % protected region % [Customise your 1-1 or 1-M label for Obstetric And Gynecology History here] end
				entityName: 'ObstetricAndGynecologyHistoryModel',
				// % protected region % [Customise your display name for Obstetric And Gynecology History here] off begin
				displayName: 'pregnancyHistoryGravida',
				// % protected region % [Customise your display name for Obstetric And Gynecology History here] end
				validators: [
					// % protected region % [Add other validators for Obstetric And Gynecology History here] off begin
					// % protected region % [Add other validators for Obstetric And Gynecology History here] end
				],
				// % protected region % [Add any additional field for relation Obstetric And Gynecology History here] off begin
				// % protected region % [Add any additional field for relation Obstetric And Gynecology History here] end
			},
			{
				id: 'odontogramExamination',
				type: ModelRelationType.ONE,
				name: 'odontogramExaminationId',
				// % protected region % [Customise your 1-1 or 1-M label for Odontogram Examination here] off begin
				label: 'Odontogram Examination',
				// % protected region % [Customise your 1-1 or 1-M label for Odontogram Examination here] end
				entityName: 'OdontogramExaminationModel',
				// % protected region % [Customise your display name for Odontogram Examination here] off begin
				displayName: 'odontogramData',
				// % protected region % [Customise your display name for Odontogram Examination here] end
				validators: [
					// % protected region % [Add other validators for Odontogram Examination here] off begin
					// % protected region % [Add other validators for Odontogram Examination here] end
				],
				// % protected region % [Add any additional field for relation Odontogram Examination here] off begin
				// % protected region % [Add any additional field for relation Odontogram Examination here] end
			},
			{
				id: 'operatingTheaterMedicalExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'operatingTheaterMedicalExaminationRecordId',
				// % protected region % [Customise your 1-1 or 1-M label for Operating Theater Medical Examination Record here] off begin
				label: 'Operating Theater Medical Examination Record',
				// % protected region % [Customise your 1-1 or 1-M label for Operating Theater Medical Examination Record here] end
				entityName: 'OperatingTheaterMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Operating Theater Medical Examination Record here] off begin
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
				id: 'ophthalmologyExamination',
				type: ModelRelationType.ONE,
				name: 'ophthalmologyExaminationId',
				// % protected region % [Customise your 1-1 or 1-M label for Ophthalmology Examination here] off begin
				label: 'Ophthalmology Examination',
				// % protected region % [Customise your 1-1 or 1-M label for Ophthalmology Examination here] end
				entityName: 'OphthalmologyExaminationModel',
				// % protected region % [Customise your display name for Ophthalmology Examination here] off begin
				displayName: 'rightEyelidSubjective',
				// % protected region % [Customise your display name for Ophthalmology Examination here] end
				validators: [
					// % protected region % [Add other validators for Ophthalmology Examination here] off begin
					// % protected region % [Add other validators for Ophthalmology Examination here] end
				],
				// % protected region % [Add any additional field for relation Ophthalmology Examination here] off begin
				// % protected region % [Add any additional field for relation Ophthalmology Examination here] end
			},
			{
				id: 'roomTransfers',
				type: ModelRelationType.MANY,
				name: 'roomTransfersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Room Transfers here] off begin
				label: 'Room Transfers',
				// % protected region % [Customise your 1-1 or 1-M label for Room Transfers here] end
				entityName: 'RoomTransferModel',
				// % protected region % [Customise your display name for Room Transfers here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Room Transfers here] end
				validators: [
					// % protected region % [Add other validators for Room Transfers here] off begin
					// % protected region % [Add other validators for Room Transfers here] end
				],
				// % protected region % [Add any additional field for relation Room Transfers here] off begin
				// % protected region % [Add any additional field for relation Room Transfers here] end
			},
			{
				id: 'doctor',
				type: ModelRelationType.ONE,
				name: 'doctorId',
				// % protected region % [Customise your label for Doctor here] off begin
				label: 'Doctor',
				// % protected region % [Customise your label for Doctor here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Doctor here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Doctor here] end
				validators: [
					// % protected region % [Add other validators for Doctor here] off begin
					// % protected region % [Add other validators for Doctor here] end
				],
				// % protected region % [Add any additional field for relation Doctor here] off begin
				// % protected region % [Add any additional field for relation Doctor here] end
			},
			{
				id: 'inpatientMedicalExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'inpatientMedicalExaminationRecordId',
				// % protected region % [Customise your label for Inpatient Medical Examination Record here] off begin
				label: 'Inpatient Medical Examination Record',
				// % protected region % [Customise your label for Inpatient Medical Examination Record here] end
				entityName: 'InpatientMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Inpatient Medical Examination Record here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Inpatient Medical Examination Record here] end
				validators: [
					// % protected region % [Add other validators for Inpatient Medical Examination Record here] off begin
					// % protected region % [Add other validators for Inpatient Medical Examination Record here] end
				],
				// % protected region % [Add any additional field for relation Inpatient Medical Examination Record here] off begin
				// % protected region % [Add any additional field for relation Inpatient Medical Examination Record here] end
			},
			{
				id: 'registration',
				type: ModelRelationType.ONE,
				name: 'registrationId',
				// % protected region % [Customise your label for Registration here] off begin
				label: 'Registration',
				// % protected region % [Customise your label for Registration here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Registration here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
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
				id: 'nurse',
				type: ModelRelationType.ONE,
				name: 'nurseId',
				// % protected region % [Customise your label for Nurse here] off begin
				label: 'Nurse',
				// % protected region % [Customise your label for Nurse here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Nurse here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Nurse here] end
				validators: [
					// % protected region % [Add other validators for Nurse here] off begin
					// % protected region % [Add other validators for Nurse here] end
				],
				// % protected region % [Add any additional field for relation Nurse here] off begin
				// % protected region % [Add any additional field for relation Nurse here] end
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
	static deepParse(data: string | { [K in keyof MedicalExaminationRecordModel]?: MedicalExaminationRecordModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new MedicalExaminationRecordModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.birthHistory) {
			currentModel.birthHistoryId = json.birthHistory.id;
			returned = _.union(returned, BirthHistoryModel.deepParse(json.birthHistory));
		}

		// Outgoing one to one
		if (json.bodyChartExamination) {
			currentModel.bodyChartExaminationId = json.bodyChartExamination.id;
			returned = _.union(returned, BodyChartExaminationModel.deepParse(json.bodyChartExamination));
		}

		// Outgoing one to one
		if (json.deliveryMedicalExaminationRecord) {
			currentModel.deliveryMedicalExaminationRecordId = json.deliveryMedicalExaminationRecord.id;
			returned = _.union(returned, DeliveryMedicalExaminationRecordModel.deepParse(json.deliveryMedicalExaminationRecord));
		}

		// Outgoing one to one
		if (json.entExamination) {
			currentModel.entExaminationId = json.entExamination.id;
			returned = _.union(returned, EntExaminationModel.deepParse(json.entExamination));
		}

		// Outgoing one to one
		if (json.emergencyMedicationExaminationRecord) {
			currentModel.emergencyMedicationExaminationRecordId = json.emergencyMedicationExaminationRecord.id;
			returned = _.union(returned, EmergencyMedicalExaminationRecordModel.deepParse(json.emergencyMedicationExaminationRecord));
		}

		// Outgoing one to one
		if (json.formulirKonselingTesHiv) {
			currentModel.formulirKonselingTesHivId = json.formulirKonselingTesHiv.id;
			returned = _.union(returned, FormulirKonselingTesHivModel.deepParse(json.formulirKonselingTesHiv));
		}

		// Outgoing one to one
		if (json.hemodialysisExamination) {
			currentModel.hemodialysisExaminationId = json.hemodialysisExamination.id;
			returned = _.union(returned, HemodialysisExaminationModel.deepParse(json.hemodialysisExamination));
		}

		// Outgoing one to one
		if (json.medicalExaminationRecordDischargeSummary) {
			currentModel.medicalExaminationRecordDischargeSummaryId = json.medicalExaminationRecordDischargeSummary.id;
			returned = _.union(returned, MedicalExaminationRecordDischargeSummaryModel.deepParse(json.medicalExaminationRecordDischargeSummary));
		}

		// Outgoing one to one
		if (json.medicalRecordInitialChecklist) {
			currentModel.medicalRecordInitialChecklistId = json.medicalRecordInitialChecklist.id;
			returned = _.union(returned, MedicalRecordInitialChecklistModel.deepParse(json.medicalRecordInitialChecklist));
		}

		// Outgoing one to one
		if (json.medicalRecordNextVerificationChecklist) {
			currentModel.medicalRecordNextVerificationChecklistId = json.medicalRecordNextVerificationChecklist.id;
			returned = _.union(returned, MedicalRecordNextVerificationChecklistModel.deepParse(json.medicalRecordNextVerificationChecklist));
		}

		// Outgoing one to one
		if (json.nurseVitalSignMeasurement) {
			currentModel.nurseVitalSignMeasurementId = json.nurseVitalSignMeasurement.id;
			returned = _.union(returned, NurseVitalSignMeasurementModel.deepParse(json.nurseVitalSignMeasurement));
		}

		// Outgoing one to one
		if (json.obstetricAndGynecologyHistory) {
			currentModel.obstetricAndGynecologyHistoryId = json.obstetricAndGynecologyHistory.id;
			returned = _.union(returned, ObstetricAndGynecologyHistoryModel.deepParse(json.obstetricAndGynecologyHistory));
		}

		// Outgoing one to one
		if (json.odontogramExamination) {
			currentModel.odontogramExaminationId = json.odontogramExamination.id;
			returned = _.union(returned, OdontogramExaminationModel.deepParse(json.odontogramExamination));
		}

		// Outgoing one to one
		if (json.operatingTheaterMedicalExaminationRecord) {
			currentModel.operatingTheaterMedicalExaminationRecordId = json.operatingTheaterMedicalExaminationRecord.id;
			returned = _.union(returned, OperatingTheaterMedicalExaminationRecordModel.deepParse(json.operatingTheaterMedicalExaminationRecord));
		}

		// Outgoing one to one
		if (json.ophthalmologyExamination) {
			currentModel.ophthalmologyExaminationId = json.ophthalmologyExamination.id;
			returned = _.union(returned, OphthalmologyExaminationModel.deepParse(json.ophthalmologyExamination));
		}

		// Incoming one to one
		if (json.inpatientMedicalExaminationRecord) {
			currentModel.inpatientMedicalExaminationRecordId = json.inpatientMedicalExaminationRecord.id;
			returned = _.union(returned, InpatientMedicalExaminationRecordModel.deepParse(json.inpatientMedicalExaminationRecord));
		}

		// Incoming one to one
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}

		// Incoming one to many
		if (json.doctor) {
			currentModel.doctorId = json.doctor.id;
			returned = _.union(returned, StaffModel.deepParse(json.doctor));
		}

		// Incoming one to many
		if (json.medicalTranscriber) {
			currentModel.medicalTranscriberId = json.medicalTranscriber.id;
			returned = _.union(returned, StaffModel.deepParse(json.medicalTranscriber));
		}

		// Incoming one to many
		if (json.nurse) {
			currentModel.nurseId = json.nurse.id;
			returned = _.union(returned, StaffModel.deepParse(json.nurse));
		}

		// Outgoing one to many
		if (json.amendmentDetails) {
			currentModel.amendmentDetailsIds = json.amendmentDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.amendmentDetails.map(model => AmendmentDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.coTreatingDoctors) {
			currentModel.coTreatingDoctorsIds = json.coTreatingDoctors.map(model => model.id);
			returned = _.union(returned, _.flatten(json.coTreatingDoctors.map(model => CoTreatingDoctorModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.dailyCareCPPTs) {
			currentModel.dailyCareCPPTsIds = json.dailyCareCPPTs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.dailyCareCPPTs.map(model => DailyCareCPPTModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.diagnosisExaminationRecords) {
			currentModel.diagnosisExaminationRecordsIds = json.diagnosisExaminationRecords.map(model => model.id);
			returned = _.union(returned, _.flatten(json.diagnosisExaminationRecords.map(model => DiagnosisExaminationRecordModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.diagnosisNandas) {
			currentModel.diagnosisNandasIds = json.diagnosisNandas.map(model => model.id);
			returned = _.union(returned, _.flatten(json.diagnosisNandas.map(model => DiagnosisNandaModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.roomTransfers) {
			currentModel.roomTransfersIds = json.roomTransfers.map(model => model.id);
			returned = _.union(returned, _.flatten(json.roomTransfers.map(model => RoomTransferModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let medicalExaminationRecordModel = new MedicalExaminationRecordModel(data);`
	 *
	 * @param data The input data to be initialised as the MedicalExaminationRecordModel,
	 *    it is expected as a JSON string or as a nullable MedicalExaminationRecordModel.
	 */
	constructor(data?: string | Partial<MedicalExaminationRecordModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<MedicalExaminationRecordModel>
				: data;

			this.diastole = json.diastole;
			this.systole = json.systole;
			this.pulse = json.pulse;
			this.bpStandingSystole = json.bpStandingSystole;
			this.bpStandingDiastole = json.bpStandingDiastole;
			this.pulseRegularity = json.pulseRegularity;
			this.pulseStrength = json.pulseStrength;
			this.temperature = json.temperature;
			this.temperatureScale = json.temperatureScale;
			this.gcsEyes = json.gcsEyes;
			this.gcsVerbal = json.gcsVerbal;
			this.gcsMotor = json.gcsMotor;
			this.totalGCSScore = json.totalGCSScore;
			this.consciousness = json.consciousness;
			this.height = json.height;
			this.heightScale = json.heightScale;
			this.weight = json.weight;
			this.weightScale = json.weightScale;
			this.bmi = json.bmi;
			this.respiratory = json.respiratory;
			this.oxygenSaturation = json.oxygenSaturation;
			this.waistCircumference = json.waistCircumference;
			this.waistCircumferenceUnit = json.waistCircumferenceUnit;
			this.nutritionStatus = json.nutritionStatus;
			this.painScale = json.painScale;
			this.painScaleUsed = json.painScaleUsed;
			this.riskFallScale = json.riskFallScale;
			this.objective = json.objective;
			this.riskFallScaleUsed = json.riskFallScaleUsed;
			this.subjective = json.subjective;
			this.plan = json.plan;
			this.purpose = json.purpose;
			this.examinationSubCase = json.examinationSubCase;
			this.accidentalType = json.accidentalType;
			this.serviceCase = json.serviceCase;
			this.accidentalSubType = json.accidentalSubType;
			this.additionalNotes = json.additionalNotes;
			this.dentalProcedure = json.dentalProcedure;
			this.psychiatryCase = json.psychiatryCase;
			this.therapy = json.therapy;
			this.familyPlanning = json.familyPlanning;
			this.condition = json.condition;
			this.familyPlanningCase = json.familyPlanningCase;
			this.previousContraceptiveMethod = json.previousContraceptiveMethod;
			this.sideEffects = json.sideEffects;
			this.complication = json.complication;
			this.contraseptiveMethod = json.contraseptiveMethod;
			this.visitType = json.visitType;
			this.hearingTestMethod = json.hearingTestMethod;
			this.hearingTestNotes = json.hearingTestNotes;
			this.hearingLossCategory = json.hearingLossCategory;
			this.hearingLossNotes = json.hearingLossNotes;
			this.eyePositionRightEye = json.eyePositionRightEye;
			this.eyePositionLeftEye = json.eyePositionLeftEye;
			this.muscleBalanceRightEye = json.muscleBalanceRightEye;
			this.muscleBalanceLeftEye = json.muscleBalanceLeftEye;
			this.visualFieldRightEye = json.visualFieldRightEye;
			this.visualFieldLeftEye = json.visualFieldLeftEye;
			this.ocularFunduscopyRightEye = json.ocularFunduscopyRightEye;
			this.ocularFunduscopyLeftEye = json.ocularFunduscopyLeftEye;
			this.intraocularPressureRightEye = json.intraocularPressureRightEye;
			this.intraocularPressureLeftEye = json.intraocularPressureLeftEye;
			this.colorBlindness = json.colorBlindness;
			this.visualAcuityRightEye = json.visualAcuityRightEye;
			this.visualAcuityLeftEye = json.visualAcuityLeftEye;
			this.correctionRightEye = json.correctionRightEye;
			this.correctionLeftEye = json.correctionLeftEye;
			this.additionRightEye = json.additionRightEye;
			this.additionLeftEye = json.additionLeftEye;
			this.occlusion = json.occlusion;
			this.torusPalatinus = json.torusPalatinus;
			this.torusMandibularis = json.torusMandibularis;
			this.palatum = json.palatum;
			this.diastema = json.diastema;
			this.diastemaNotes = json.diastemaNotes;
			this.toothAnomaly = json.toothAnomaly;
			this.toothAnomalyNotes = json.toothAnomalyNotes;
			this.otherDentalNotes = json.otherDentalNotes;
			this.decayed = json.decayed;
			this.missing = json.missing;
			this.filled = json.filled;
			this.totalPhotograph = json.totalPhotograph;
			this.photographType = json.photographType;
			this.totalRontgenPhotograph = json.totalRontgenPhotograph;
			this.rontgenPhotographType = json.rontgenPhotographType;
			this.birthHistoryId = json.birthHistoryId;
			this.birthHistory = json.birthHistory;
			this.bodyChartExaminationId = json.bodyChartExaminationId;
			this.bodyChartExamination = json.bodyChartExamination;
			this.deliveryMedicalExaminationRecordId = json.deliveryMedicalExaminationRecordId;
			this.deliveryMedicalExaminationRecord = json.deliveryMedicalExaminationRecord;
			this.entExaminationId = json.entExaminationId;
			this.entExamination = json.entExamination;
			this.emergencyMedicationExaminationRecordId = json.emergencyMedicationExaminationRecordId;
			this.emergencyMedicationExaminationRecord = json.emergencyMedicationExaminationRecord;
			this.formulirKonselingTesHivId = json.formulirKonselingTesHivId;
			this.formulirKonselingTesHiv = json.formulirKonselingTesHiv;
			this.hemodialysisExaminationId = json.hemodialysisExaminationId;
			this.hemodialysisExamination = json.hemodialysisExamination;
			this.medicalExaminationRecordDischargeSummaryId = json.medicalExaminationRecordDischargeSummaryId;
			this.medicalExaminationRecordDischargeSummary = json.medicalExaminationRecordDischargeSummary;
			this.medicalRecordInitialChecklistId = json.medicalRecordInitialChecklistId;
			this.medicalRecordInitialChecklist = json.medicalRecordInitialChecklist;
			this.medicalRecordNextVerificationChecklistId = json.medicalRecordNextVerificationChecklistId;
			this.medicalRecordNextVerificationChecklist = json.medicalRecordNextVerificationChecklist;
			this.nurseVitalSignMeasurementId = json.nurseVitalSignMeasurementId;
			this.nurseVitalSignMeasurement = json.nurseVitalSignMeasurement;
			this.obstetricAndGynecologyHistoryId = json.obstetricAndGynecologyHistoryId;
			this.obstetricAndGynecologyHistory = json.obstetricAndGynecologyHistory;
			this.odontogramExaminationId = json.odontogramExaminationId;
			this.odontogramExamination = json.odontogramExamination;
			this.operatingTheaterMedicalExaminationRecordId = json.operatingTheaterMedicalExaminationRecordId;
			this.operatingTheaterMedicalExaminationRecord = json.operatingTheaterMedicalExaminationRecord;
			this.ophthalmologyExaminationId = json.ophthalmologyExaminationId;
			this.ophthalmologyExamination = json.ophthalmologyExamination;
			this.inpatientMedicalExaminationRecordId = json.inpatientMedicalExaminationRecordId;
			this.inpatientMedicalExaminationRecord = json.inpatientMedicalExaminationRecord;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			this.doctorId = json.doctorId;
			this.doctor = json.doctor;
			this.medicalTranscriberId = json.medicalTranscriberId;
			this.medicalTranscriber = json.medicalTranscriber;
			this.nurseId = json.nurseId;
			this.nurse = json.nurse;
			this.amendmentDetailsIds = json.amendmentDetailsIds;
			this.amendmentDetails = json.amendmentDetails;
			this.coTreatingDoctorsIds = json.coTreatingDoctorsIds;
			this.coTreatingDoctors = json.coTreatingDoctors;
			this.dailyCareCPPTsIds = json.dailyCareCPPTsIds;
			this.dailyCareCPPTs = json.dailyCareCPPTs;
			this.diagnosisExaminationRecordsIds = json.diagnosisExaminationRecordsIds;
			this.diagnosisExaminationRecords = json.diagnosisExaminationRecords;
			this.diagnosisNandasIds = json.diagnosisNandasIds;
			this.diagnosisNandas = json.diagnosisNandas;
			this.roomTransfersIds = json.roomTransfersIds;
			this.roomTransfers = json.roomTransfers;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			diastole: this.diastole,
			systole: this.systole,
			pulse: this.pulse,
			bpStandingSystole: this.bpStandingSystole,
			bpStandingDiastole: this.bpStandingDiastole,
			pulseRegularity: this.pulseRegularity,
			pulseStrength: this.pulseStrength,
			temperature: this.temperature,
			temperatureScale: this.temperatureScale,
			gcsEyes: this.gcsEyes,
			gcsVerbal: this.gcsVerbal,
			gcsMotor: this.gcsMotor,
			totalGCSScore: this.totalGCSScore,
			consciousness: this.consciousness,
			height: this.height,
			heightScale: this.heightScale,
			weight: this.weight,
			weightScale: this.weightScale,
			bmi: this.bmi,
			respiratory: this.respiratory,
			oxygenSaturation: this.oxygenSaturation,
			waistCircumference: this.waistCircumference,
			waistCircumferenceUnit: this.waistCircumferenceUnit,
			nutritionStatus: this.nutritionStatus,
			painScale: this.painScale,
			painScaleUsed: this.painScaleUsed,
			riskFallScale: this.riskFallScale,
			objective: this.objective,
			riskFallScaleUsed: this.riskFallScaleUsed,
			subjective: this.subjective,
			plan: this.plan,
			purpose: this.purpose,
			examinationSubCase: this.examinationSubCase,
			accidentalType: this.accidentalType,
			serviceCase: this.serviceCase,
			accidentalSubType: this.accidentalSubType,
			additionalNotes: this.additionalNotes,
			dentalProcedure: this.dentalProcedure,
			psychiatryCase: this.psychiatryCase,
			therapy: this.therapy,
			familyPlanning: this.familyPlanning,
			condition: this.condition,
			familyPlanningCase: this.familyPlanningCase,
			previousContraceptiveMethod: this.previousContraceptiveMethod,
			sideEffects: this.sideEffects,
			complication: this.complication,
			contraseptiveMethod: this.contraseptiveMethod,
			visitType: this.visitType,
			hearingTestMethod: this.hearingTestMethod,
			hearingTestNotes: this.hearingTestNotes,
			hearingLossCategory: this.hearingLossCategory,
			hearingLossNotes: this.hearingLossNotes,
			eyePositionRightEye: this.eyePositionRightEye,
			eyePositionLeftEye: this.eyePositionLeftEye,
			muscleBalanceRightEye: this.muscleBalanceRightEye,
			muscleBalanceLeftEye: this.muscleBalanceLeftEye,
			visualFieldRightEye: this.visualFieldRightEye,
			visualFieldLeftEye: this.visualFieldLeftEye,
			ocularFunduscopyRightEye: this.ocularFunduscopyRightEye,
			ocularFunduscopyLeftEye: this.ocularFunduscopyLeftEye,
			intraocularPressureRightEye: this.intraocularPressureRightEye,
			intraocularPressureLeftEye: this.intraocularPressureLeftEye,
			colorBlindness: this.colorBlindness,
			visualAcuityRightEye: this.visualAcuityRightEye,
			visualAcuityLeftEye: this.visualAcuityLeftEye,
			correctionRightEye: this.correctionRightEye,
			correctionLeftEye: this.correctionLeftEye,
			additionRightEye: this.additionRightEye,
			additionLeftEye: this.additionLeftEye,
			occlusion: this.occlusion,
			torusPalatinus: this.torusPalatinus,
			torusMandibularis: this.torusMandibularis,
			palatum: this.palatum,
			diastema: this.diastema,
			diastemaNotes: this.diastemaNotes,
			toothAnomaly: this.toothAnomaly,
			toothAnomalyNotes: this.toothAnomalyNotes,
			otherDentalNotes: this.otherDentalNotes,
			decayed: this.decayed,
			missing: this.missing,
			filled: this.filled,
			totalPhotograph: this.totalPhotograph,
			photographType: this.photographType,
			totalRontgenPhotograph: this.totalRontgenPhotograph,
			rontgenPhotographType: this.rontgenPhotographType,
			birthHistoryId: this.birthHistoryId,
			bodyChartExaminationId: this.bodyChartExaminationId,
			deliveryMedicalExaminationRecordId: this.deliveryMedicalExaminationRecordId,
			entExaminationId: this.entExaminationId,
			emergencyMedicationExaminationRecordId: this.emergencyMedicationExaminationRecordId,
			formulirKonselingTesHivId: this.formulirKonselingTesHivId,
			hemodialysisExaminationId: this.hemodialysisExaminationId,
			medicalExaminationRecordDischargeSummaryId: this.medicalExaminationRecordDischargeSummaryId,
			medicalRecordInitialChecklistId: this.medicalRecordInitialChecklistId,
			medicalRecordNextVerificationChecklistId: this.medicalRecordNextVerificationChecklistId,
			nurseVitalSignMeasurementId: this.nurseVitalSignMeasurementId,
			obstetricAndGynecologyHistoryId: this.obstetricAndGynecologyHistoryId,
			odontogramExaminationId: this.odontogramExaminationId,
			operatingTheaterMedicalExaminationRecordId: this.operatingTheaterMedicalExaminationRecordId,
			ophthalmologyExaminationId: this.ophthalmologyExaminationId,
			inpatientMedicalExaminationRecordId: this.inpatientMedicalExaminationRecordId,
			registrationId: this.registrationId,
			doctorId: this.doctorId,
			medicalTranscriberId: this.medicalTranscriberId,
			nurseId: this.nurseId,
			amendmentDetailsIds: this.amendmentDetailsIds,
			coTreatingDoctorsIds: this.coTreatingDoctorsIds,
			dailyCareCPPTsIds: this.dailyCareCPPTsIds,
			diagnosisExaminationRecordsIds: this.diagnosisExaminationRecordsIds,
			diagnosisNandasIds: this.diagnosisNandasIds,
			roomTransfersIds: this.roomTransfersIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		MedicalExaminationRecordModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): MedicalExaminationRecordModel {
		let newModelJson = this.toJSON();

		if (updates.diastole) {
			newModelJson.diastole = updates.diastole;
		}

		if (updates.systole) {
			newModelJson.systole = updates.systole;
		}

		if (updates.pulse) {
			newModelJson.pulse = updates.pulse;
		}

		if (updates.bpStandingSystole) {
			newModelJson.bpStandingSystole = updates.bpStandingSystole;
		}

		if (updates.bpStandingDiastole) {
			newModelJson.bpStandingDiastole = updates.bpStandingDiastole;
		}

		if (updates.pulseRegularity) {
			newModelJson.pulseRegularity = updates.pulseRegularity;
		}

		if (updates.pulseStrength) {
			newModelJson.pulseStrength = updates.pulseStrength;
		}

		if (updates.temperature) {
			newModelJson.temperature = updates.temperature;
		}

		if (updates.temperatureScale) {
			newModelJson.temperatureScale = updates.temperatureScale;
		}

		if (updates.gcsEyes) {
			newModelJson.gcsEyes = updates.gcsEyes;
		}

		if (updates.gcsVerbal) {
			newModelJson.gcsVerbal = updates.gcsVerbal;
		}

		if (updates.gcsMotor) {
			newModelJson.gcsMotor = updates.gcsMotor;
		}

		if (updates.totalGCSScore) {
			newModelJson.totalGCSScore = updates.totalGCSScore;
		}

		if (updates.consciousness) {
			newModelJson.consciousness = updates.consciousness;
		}

		if (updates.height) {
			newModelJson.height = updates.height;
		}

		if (updates.heightScale) {
			newModelJson.heightScale = updates.heightScale;
		}

		if (updates.weight) {
			newModelJson.weight = updates.weight;
		}

		if (updates.weightScale) {
			newModelJson.weightScale = updates.weightScale;
		}

		if (updates.bmi) {
			newModelJson.bmi = updates.bmi;
		}

		if (updates.respiratory) {
			newModelJson.respiratory = updates.respiratory;
		}

		if (updates.oxygenSaturation) {
			newModelJson.oxygenSaturation = updates.oxygenSaturation;
		}

		if (updates.waistCircumference) {
			newModelJson.waistCircumference = updates.waistCircumference;
		}

		if (updates.waistCircumferenceUnit) {
			newModelJson.waistCircumferenceUnit = updates.waistCircumferenceUnit;
		}

		if (updates.nutritionStatus) {
			newModelJson.nutritionStatus = updates.nutritionStatus;
		}

		if (updates.painScale) {
			newModelJson.painScale = updates.painScale;
		}

		if (updates.painScaleUsed) {
			newModelJson.painScaleUsed = updates.painScaleUsed;
		}

		if (updates.riskFallScale) {
			newModelJson.riskFallScale = updates.riskFallScale;
		}

		if (updates.objective) {
			newModelJson.objective = updates.objective;
		}

		if (updates.riskFallScaleUsed) {
			newModelJson.riskFallScaleUsed = updates.riskFallScaleUsed;
		}

		if (updates.subjective) {
			newModelJson.subjective = updates.subjective;
		}

		if (updates.plan) {
			newModelJson.plan = updates.plan;
		}

		if (updates.purpose) {
			newModelJson.purpose = updates.purpose;
		}

		if (updates.examinationSubCase) {
			newModelJson.examinationSubCase = updates.examinationSubCase;
		}

		if (updates.accidentalType) {
			newModelJson.accidentalType = updates.accidentalType;
		}

		if (updates.serviceCase) {
			newModelJson.serviceCase = updates.serviceCase;
		}

		if (updates.accidentalSubType) {
			newModelJson.accidentalSubType = updates.accidentalSubType;
		}

		if (updates.additionalNotes) {
			newModelJson.additionalNotes = updates.additionalNotes;
		}

		if (updates.dentalProcedure) {
			newModelJson.dentalProcedure = updates.dentalProcedure;
		}

		if (updates.psychiatryCase) {
			newModelJson.psychiatryCase = updates.psychiatryCase;
		}

		if (updates.therapy) {
			newModelJson.therapy = updates.therapy;
		}

		if (updates.familyPlanning) {
			newModelJson.familyPlanning = updates.familyPlanning;
		}

		if (updates.condition) {
			newModelJson.condition = updates.condition;
		}

		if (updates.familyPlanningCase) {
			newModelJson.familyPlanningCase = updates.familyPlanningCase;
		}

		if (updates.previousContraceptiveMethod) {
			newModelJson.previousContraceptiveMethod = updates.previousContraceptiveMethod;
		}

		if (updates.sideEffects) {
			newModelJson.sideEffects = updates.sideEffects;
		}

		if (updates.complication) {
			newModelJson.complication = updates.complication;
		}

		if (updates.contraseptiveMethod) {
			newModelJson.contraseptiveMethod = updates.contraseptiveMethod;
		}

		if (updates.visitType) {
			newModelJson.visitType = updates.visitType;
		}

		if (updates.hearingTestMethod) {
			newModelJson.hearingTestMethod = updates.hearingTestMethod;
		}

		if (updates.hearingTestNotes) {
			newModelJson.hearingTestNotes = updates.hearingTestNotes;
		}

		if (updates.hearingLossCategory) {
			newModelJson.hearingLossCategory = updates.hearingLossCategory;
		}

		if (updates.hearingLossNotes) {
			newModelJson.hearingLossNotes = updates.hearingLossNotes;
		}

		if (updates.eyePositionRightEye) {
			newModelJson.eyePositionRightEye = updates.eyePositionRightEye;
		}

		if (updates.eyePositionLeftEye) {
			newModelJson.eyePositionLeftEye = updates.eyePositionLeftEye;
		}

		if (updates.muscleBalanceRightEye) {
			newModelJson.muscleBalanceRightEye = updates.muscleBalanceRightEye;
		}

		if (updates.muscleBalanceLeftEye) {
			newModelJson.muscleBalanceLeftEye = updates.muscleBalanceLeftEye;
		}

		if (updates.visualFieldRightEye) {
			newModelJson.visualFieldRightEye = updates.visualFieldRightEye;
		}

		if (updates.visualFieldLeftEye) {
			newModelJson.visualFieldLeftEye = updates.visualFieldLeftEye;
		}

		if (updates.ocularFunduscopyRightEye) {
			newModelJson.ocularFunduscopyRightEye = updates.ocularFunduscopyRightEye;
		}

		if (updates.ocularFunduscopyLeftEye) {
			newModelJson.ocularFunduscopyLeftEye = updates.ocularFunduscopyLeftEye;
		}

		if (updates.intraocularPressureRightEye) {
			newModelJson.intraocularPressureRightEye = updates.intraocularPressureRightEye;
		}

		if (updates.intraocularPressureLeftEye) {
			newModelJson.intraocularPressureLeftEye = updates.intraocularPressureLeftEye;
		}

		if (updates.colorBlindness) {
			newModelJson.colorBlindness = updates.colorBlindness;
		}

		if (updates.visualAcuityRightEye) {
			newModelJson.visualAcuityRightEye = updates.visualAcuityRightEye;
		}

		if (updates.visualAcuityLeftEye) {
			newModelJson.visualAcuityLeftEye = updates.visualAcuityLeftEye;
		}

		if (updates.correctionRightEye) {
			newModelJson.correctionRightEye = updates.correctionRightEye;
		}

		if (updates.correctionLeftEye) {
			newModelJson.correctionLeftEye = updates.correctionLeftEye;
		}

		if (updates.additionRightEye) {
			newModelJson.additionRightEye = updates.additionRightEye;
		}

		if (updates.additionLeftEye) {
			newModelJson.additionLeftEye = updates.additionLeftEye;
		}

		if (updates.occlusion) {
			newModelJson.occlusion = updates.occlusion;
		}

		if (updates.torusPalatinus) {
			newModelJson.torusPalatinus = updates.torusPalatinus;
		}

		if (updates.torusMandibularis) {
			newModelJson.torusMandibularis = updates.torusMandibularis;
		}

		if (updates.palatum) {
			newModelJson.palatum = updates.palatum;
		}

		if (updates.diastema) {
			newModelJson.diastema = updates.diastema;
		}

		if (updates.diastemaNotes) {
			newModelJson.diastemaNotes = updates.diastemaNotes;
		}

		if (updates.toothAnomaly) {
			newModelJson.toothAnomaly = updates.toothAnomaly;
		}

		if (updates.toothAnomalyNotes) {
			newModelJson.toothAnomalyNotes = updates.toothAnomalyNotes;
		}

		if (updates.otherDentalNotes) {
			newModelJson.otherDentalNotes = updates.otherDentalNotes;
		}

		if (updates.decayed) {
			newModelJson.decayed = updates.decayed;
		}

		if (updates.missing) {
			newModelJson.missing = updates.missing;
		}

		if (updates.filled) {
			newModelJson.filled = updates.filled;
		}

		if (updates.totalPhotograph) {
			newModelJson.totalPhotograph = updates.totalPhotograph;
		}

		if (updates.photographType) {
			newModelJson.photographType = updates.photographType;
		}

		if (updates.totalRontgenPhotograph) {
			newModelJson.totalRontgenPhotograph = updates.totalRontgenPhotograph;
		}

		if (updates.rontgenPhotographType) {
			newModelJson.rontgenPhotographType = updates.rontgenPhotographType;
		}

		if (updates.birthHistoryId) {
			newModelJson.birthHistoryId = updates.birthHistoryId;
		}

		if (updates.bodyChartExaminationId) {
			newModelJson.bodyChartExaminationId = updates.bodyChartExaminationId;
		}

		if (updates.deliveryMedicalExaminationRecordId) {
			newModelJson.deliveryMedicalExaminationRecordId = updates.deliveryMedicalExaminationRecordId;
		}

		if (updates.entExaminationId) {
			newModelJson.entExaminationId = updates.entExaminationId;
		}

		if (updates.emergencyMedicationExaminationRecordId) {
			newModelJson.emergencyMedicationExaminationRecordId = updates.emergencyMedicationExaminationRecordId;
		}

		if (updates.formulirKonselingTesHivId) {
			newModelJson.formulirKonselingTesHivId = updates.formulirKonselingTesHivId;
		}

		if (updates.hemodialysisExaminationId) {
			newModelJson.hemodialysisExaminationId = updates.hemodialysisExaminationId;
		}

		if (updates.medicalExaminationRecordDischargeSummaryId) {
			newModelJson.medicalExaminationRecordDischargeSummaryId = updates.medicalExaminationRecordDischargeSummaryId;
		}

		if (updates.medicalRecordInitialChecklistId) {
			newModelJson.medicalRecordInitialChecklistId = updates.medicalRecordInitialChecklistId;
		}

		if (updates.medicalRecordNextVerificationChecklistId) {
			newModelJson.medicalRecordNextVerificationChecklistId = updates.medicalRecordNextVerificationChecklistId;
		}

		if (updates.nurseVitalSignMeasurementId) {
			newModelJson.nurseVitalSignMeasurementId = updates.nurseVitalSignMeasurementId;
		}

		if (updates.obstetricAndGynecologyHistoryId) {
			newModelJson.obstetricAndGynecologyHistoryId = updates.obstetricAndGynecologyHistoryId;
		}

		if (updates.odontogramExaminationId) {
			newModelJson.odontogramExaminationId = updates.odontogramExaminationId;
		}

		if (updates.operatingTheaterMedicalExaminationRecordId) {
			newModelJson.operatingTheaterMedicalExaminationRecordId = updates.operatingTheaterMedicalExaminationRecordId;
		}

		if (updates.ophthalmologyExaminationId) {
			newModelJson.ophthalmologyExaminationId = updates.ophthalmologyExaminationId;
		}

		if (updates.inpatientMedicalExaminationRecordId) {
			newModelJson.inpatientMedicalExaminationRecordId = updates.inpatientMedicalExaminationRecordId;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.doctorId) {
			newModelJson.doctorId = updates.doctorId;
		}

		if (updates.medicalTranscriberId) {
			newModelJson.medicalTranscriberId = updates.medicalTranscriberId;
		}

		if (updates.nurseId) {
			newModelJson.nurseId = updates.nurseId;
		}

		if (updates.amendmentDetailsIds) {
			newModelJson.amendmentDetailsIds = updates.amendmentDetailsIds;
		}

		if (updates.coTreatingDoctorsIds) {
			newModelJson.coTreatingDoctorsIds = updates.coTreatingDoctorsIds;
		}

		if (updates.dailyCareCPPTsIds) {
			newModelJson.dailyCareCPPTsIds = updates.dailyCareCPPTsIds;
		}

		if (updates.diagnosisExaminationRecordsIds) {
			newModelJson.diagnosisExaminationRecordsIds = updates.diagnosisExaminationRecordsIds;
		}

		if (updates.diagnosisNandasIds) {
			newModelJson.diagnosisNandasIds = updates.diagnosisNandasIds;
		}

		if (updates.roomTransfersIds) {
			newModelJson.roomTransfersIds = updates.roomTransfersIds;
		}

		return new MedicalExaminationRecordModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof MedicalExaminationRecordModel)) {
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
			'birthHistoryId',
			'birthHistory',
			'bodyChartExaminationId',
			'bodyChartExamination',
			'deliveryMedicalExaminationRecordId',
			'deliveryMedicalExaminationRecord',
			'entExaminationId',
			'entExamination',
			'emergencyMedicationExaminationRecordId',
			'emergencyMedicationExaminationRecord',
			'formulirKonselingTesHivId',
			'formulirKonselingTesHiv',
			'hemodialysisExaminationId',
			'hemodialysisExamination',
			'medicalExaminationRecordDischargeSummaryId',
			'medicalExaminationRecordDischargeSummary',
			'medicalRecordInitialChecklistId',
			'medicalRecordInitialChecklist',
			'medicalRecordNextVerificationChecklistId',
			'medicalRecordNextVerificationChecklist',
			'nurseVitalSignMeasurementId',
			'nurseVitalSignMeasurement',
			'obstetricAndGynecologyHistoryId',
			'obstetricAndGynecologyHistory',
			'odontogramExaminationId',
			'odontogramExamination',
			'operatingTheaterMedicalExaminationRecordId',
			'operatingTheaterMedicalExaminationRecord',
			'ophthalmologyExaminationId',
			'ophthalmologyExamination',
			'inpatientMedicalExaminationRecordId',
			'inpatientMedicalExaminationRecord',
			'registrationId',
			'registration',
			'doctorId',
			'doctor',
			'medicalTranscriberId',
			'medicalTranscriber',
			'nurseId',
			'nurse',
			'amendmentDetailsIds',
			'amendmentDetails',
			'coTreatingDoctorsIds',
			'coTreatingDoctors',
			'dailyCareCPPTsIds',
			'dailyCareCPPTs',
			'diagnosisExaminationRecordsIds',
			'diagnosisExaminationRecords',
			'diagnosisNandasIds',
			'diagnosisNandas',
			'roomTransfersIds',
			'roomTransfers',
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
		if (!this.birthHistory) {
			this.birthHistoryId = null;
		} else {
			this.birthHistoryId = this.birthHistory.id;
		}

		if (!this.bodyChartExamination) {
			this.bodyChartExaminationId = null;
		} else {
			this.bodyChartExaminationId = this.bodyChartExamination.id;
		}

		if (!this.deliveryMedicalExaminationRecord) {
			this.deliveryMedicalExaminationRecordId = null;
		} else {
			this.deliveryMedicalExaminationRecordId = this.deliveryMedicalExaminationRecord.id;
		}

		if (!this.entExamination) {
			this.entExaminationId = null;
		} else {
			this.entExaminationId = this.entExamination.id;
		}

		if (!this.emergencyMedicationExaminationRecord) {
			this.emergencyMedicationExaminationRecordId = null;
		} else {
			this.emergencyMedicationExaminationRecordId = this.emergencyMedicationExaminationRecord.id;
		}

		if (!this.formulirKonselingTesHiv) {
			this.formulirKonselingTesHivId = null;
		} else {
			this.formulirKonselingTesHivId = this.formulirKonselingTesHiv.id;
		}

		if (!this.hemodialysisExamination) {
			this.hemodialysisExaminationId = null;
		} else {
			this.hemodialysisExaminationId = this.hemodialysisExamination.id;
		}

		if (!this.medicalExaminationRecordDischargeSummary) {
			this.medicalExaminationRecordDischargeSummaryId = null;
		} else {
			this.medicalExaminationRecordDischargeSummaryId = this.medicalExaminationRecordDischargeSummary.id;
		}

		if (!this.medicalRecordInitialChecklist) {
			this.medicalRecordInitialChecklistId = null;
		} else {
			this.medicalRecordInitialChecklistId = this.medicalRecordInitialChecklist.id;
		}

		if (!this.medicalRecordNextVerificationChecklist) {
			this.medicalRecordNextVerificationChecklistId = null;
		} else {
			this.medicalRecordNextVerificationChecklistId = this.medicalRecordNextVerificationChecklist.id;
		}

		if (!this.nurseVitalSignMeasurement) {
			this.nurseVitalSignMeasurementId = null;
		} else {
			this.nurseVitalSignMeasurementId = this.nurseVitalSignMeasurement.id;
		}

		if (!this.obstetricAndGynecologyHistory) {
			this.obstetricAndGynecologyHistoryId = null;
		} else {
			this.obstetricAndGynecologyHistoryId = this.obstetricAndGynecologyHistory.id;
		}

		if (!this.odontogramExamination) {
			this.odontogramExaminationId = null;
		} else {
			this.odontogramExaminationId = this.odontogramExamination.id;
		}

		if (!this.operatingTheaterMedicalExaminationRecord) {
			this.operatingTheaterMedicalExaminationRecordId = null;
		} else {
			this.operatingTheaterMedicalExaminationRecordId = this.operatingTheaterMedicalExaminationRecord.id;
		}

		if (!this.ophthalmologyExamination) {
			this.ophthalmologyExaminationId = null;
		} else {
			this.ophthalmologyExaminationId = this.ophthalmologyExamination.id;
		}

		if (!this.inpatientMedicalExaminationRecord) {
			this.inpatientMedicalExaminationRecordId = null;
		} else {
			this.inpatientMedicalExaminationRecordId = this.inpatientMedicalExaminationRecord.id;
		}

		if (!this.registration) {
			this.registrationId = null;
		} else {
			this.registrationId = this.registration.id;
		}

		if (!this.doctor) {
			this.doctorId = null;
		} else {
			this.doctorId = this.doctor.id;
		}

		if (!this.medicalTranscriber) {
			this.medicalTranscriberId = null;
		} else {
			this.medicalTranscriberId = this.medicalTranscriber.id;
		}

		if (!this.nurse) {
			this.nurseId = null;
		} else {
			this.nurseId = this.nurse.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
