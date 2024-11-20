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
import {BpjsPRBDetailModel} from '../bpjsPRBDetail/bpjs_prb_detail.model';
import {BpjsPcareRegistrationsModel} from '../bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import {BpjsSEPModel} from '../bpjsSEP/bpjs_sep.model';
import {BedFacilityModel} from '../bedFacility/bed_facility.model';
import {BedReserveModel} from '../bedReserve/bed_reserve.model';
import {DiagnosesAndProceduresModel} from '../diagnosesAndProcedures/diagnoses_and_procedures.model';
import {DiagnosticExaminationResultsModel} from '../diagnosticExaminationResults/diagnostic_examination_results.model';
import {DiagnosticStaffExaminationSummaryModel} from '../diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model';
import {ExaminationItemModel} from '../examinationItem/examination_item.model';
import {FluidBalanceDetailModel} from '../fluidBalanceDetail/fluid_balance_detail.model';
import {HealthFacilityModel} from '../healthFacility/health_facility.model';
import {InformedConsentModel} from '../informedConsent/informed_consent.model';
import {InvoiceItemModel} from '../invoiceItem/invoice_item.model';
import {MedicalCertificateDischargeResumeModel} from '../medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import {MedicalCertificateBirthModel} from '../medicalCertificateBirth/medical_certificate_birth.model';
import {MedicalCertificateHospitalizationModel} from '../medicalCertificateHospitalization/medical_certificate_hospitalization.model';
import {MedicalCertificateMedicalAttendanceModel} from '../medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model';
import {MedicalCertificateMentalHealthModel} from '../medicalCertificateMentalHealth/medical_certificate_mental_health.model';
import {MedicalCertificatePhysicalHealthModel} from '../medicalCertificatePhysicalHealth/medical_certificate_physical_health.model';
import {MedicalCertificateRestrictedWorkModel} from '../medicalCertificateRestrictedWork/medical_certificate_restricted_work.model';
import {MedicalCertificateSickLeaveModel} from '../medicalCertificateSickLeave/medical_certificate_sick_leave.model';
import {MedicalExaminationRecordModel} from '../medicalExaminationRecord/medical_examination_record.model';
import {MedicalFeeModel} from '../medicalFee/medical_fee.model';
import {MedicationHeaderModel} from '../medicationHeader/medication_header.model';
import {PcareExaminationModel} from '../pcareExamination/pcare_examination.model';
import {PatientVisitModel} from '../patientVisit/patient_visit.model';
import {PatientVitalInformationModel} from '../patientVitalInformation/patient_vital_information.model';
import {PrescriptionHeaderModel} from '../prescriptionHeader/prescription_header.model';
import {SepModel} from '../sep/sep.model';
import {SampleCollectionInformationModel} from '../sampleCollectionInformation/sample_collection_information.model';
import {ServiceModel} from '../service/service.model';
import {StaffModel} from '../staff/staff.model';
import {VaccinationOrderModel} from '../vaccinationOrder/vaccination_order.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import {FileModel} from '../../lib/models/file.model';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class RegistrationModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'registrationNumber',
		'scheduledDate',
		'queueNo',
		'registrationStatus',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'registrationNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'RegistrationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return RegistrationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Generated number by system. Auto-increment, with format [TBD by Consultant] (Max Length: 50)).
	 */
	registrationNumber: string;

	/**
	 * schedule to examine the patient.
	 */
	scheduledDate: Date;

	/**
	 * Actual Date when the examination record is created, by including time.
	 */
	actualInDate: Date;

	/**
	 * Dismissal Date or Actual Date Out (including time), when the patient is dismissed from doctor examination.
	 */
	dismissalDate: Date;

	/**
	 * Dismissal Type, get the Code from Reference Data where Type=DISMISS_OPD_STS. (Max Length: 20).
	 */
	dismissalType: string;

	/**
	 * Auto-increment (TBD by consultant) .
	 */
	queueNo: number;

	/**
	 * Duration in Minutes .
	 */
	duration: number;

	/**
	 * Treatment Class (TBD by consultant),  get the Code from Reference Data where Type=TREAT_CLASS.(Max Length: 20).
	 */
	treatmentClass: string;

	/**
	 * If the admission patient has no room/bed booking yet, the patient can select treatment class,  get the Code from Reference Data where Type=TREAT_CLASS.(Max Length: 20).
	 */
	bookedTreatmentClass: string;

	/**
	 * Shift, ,  get the Code from Reference Data where Type=SHIFT_REG.(Max Length: 20).
	 */
	shift: string;

	/**
	 * Urgent/Emergency flag.
	 */
	cito: boolean = false;

	/**
	 * An indicator whether the registration is as one day car.
	 */
	oneDayCare: boolean = false;

	/**
	 * Flag that the patient is referred form other facility.
	 */
	referral: boolean = false;

	/**
	 * Status of service activity , get the Code from Reference Data where Type=REG_STATUS. (Max Length: 20).
	 */
	registrationStatus: string;

	/**
	 * Referral Type, get the Code from Reference Data where Type=REFERRAL_TYPE. (Max Length: 20).
	 */
	referralType: string;

	/**
	 * Purpose of patient to register (Max Level: 500).
	 */
	purpose: string;

	/**
	 * Notes from Referral process, inputs from Doctor (Max Length: 500).
	 */
	referralNotes: string;

	/**
	 * Attached document during registration.
	 */
	supportingDocument: FileModel[];

	/**
	 * Diagnosis when patient is referred (Max Length: 5000).
	 */
	admissionDiagnosis: string;

	/**
	 * Print Wristband file.
	 */
	printWristband: FileModel[];

	/**
	 * Print label file.
	 */
	printLabel: FileModel[];

	/**
	 * .
	 */
	uploadedDateTime: Date;

	/**
	 * Visit Status, get the Code from Reference Data where Type=REFERRAL_TYPE. (Max Length: 20).
	 */
	visitStatus: string;

	/**
	 * Instruction specific for Inpatient service (Max Length: 5000).
	 */
	instruction: string;

	/**
	 * indicator whether the registration was created from appointment.
	 */
	isAnAppointment: boolean = false;

	/**
	 * FOR JKN.
	 */
	referralNumber: string;

	/**
	 * .
	 */
	notes: string;

	/**
	 * Only to store BPJS service mapping.
	 */
	kodepoli: string;

	/**
	 * It's madatory for Dismissal Type Death.
	 */
	deathCertificateNo: string;

	/**
	 * .
	 */
	timeOfDeath: Date;

	/**
	 * .
	 */
	dismissalReferral: boolean = false;

	/**
	 * .
	 */
	dismissalReferralDetail: string;

	/**
	 * .
	 */
	dismissalReferralType: string;

	/**
	 * .
	 */
	dismissalReferringNotes: string;

	/**
	 * .
	 */
	patientIsReferredBack: boolean = false;

	/**
	 * MCU Package.
	 */
	mcuPackage: string;

	/**
	 * Parent Registration Number.
	 */
	parentRegistrationNumber: string;

	/**
	 * .
	 */
	isUnknownPatient: boolean = false;

	/**
	 * .
	 */
	otherReferredFacility: string;

	/**
	 * .
	 */
	otherReferredStaff: string;

	/**
	 * Doctor Schedule Detail Id.
	 */
	doctorScheduleDetailId: string;

	bpjsPRBDetailId: string;

	bpjsPRBDetail: BpjsPRBDetailModel;

	bpjsPcareRegistrationsId: string;

	bpjsPcareRegistrations: BpjsPcareRegistrationsModel;

	bpjsSEPId: string;

	bpjsSEP: BpjsSEPModel;

	medicalCertificateDischargeResumeId: string;

	medicalCertificateDischargeResume: MedicalCertificateDischargeResumeModel;

	medicalCertificateBirthId: string;

	medicalCertificateBirth: MedicalCertificateBirthModel;

	medicalCertificateHospitalizationId: string;

	medicalCertificateHospitalization: MedicalCertificateHospitalizationModel;

	medicalCertificateMedicalAttendanceId: string;

	medicalCertificateMedicalAttendance: MedicalCertificateMedicalAttendanceModel;

	medicalCertificateMentalHealthId: string;

	medicalCertificateMentalHealth: MedicalCertificateMentalHealthModel;

	medicalCertificatePhysicalHealthId: string;

	medicalCertificatePhysicalHealth: MedicalCertificatePhysicalHealthModel;

	medicalCertificateRestrictedWorkId: string;

	medicalCertificateRestrictedWork: MedicalCertificateRestrictedWorkModel;

	medicalCertificateSickLeaveId: string;

	medicalCertificateSickLeave: MedicalCertificateSickLeaveModel;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	pcareExaminationId: string;

	pcareExamination: PcareExaminationModel;

	sepId: string;

	sep: SepModel;

	diagnosticStaffExaminationSummaryId: string;

	diagnosticStaffExaminationSummary: DiagnosticStaffExaminationSummaryModel;

	admissionICD10Id: string;

	admissionICD10: DiagnosesAndProceduresModel;

	admissionICD9CMId: string;

	admissionICD9CM: DiagnosesAndProceduresModel;

	dismissalReferringFacilityId: string;

	dismissalReferringFacility: HealthFacilityModel;

	dismissalReferringStaffId: string;

	dismissalReferringStaff: StaffModel;

	referringUnitId: string;

	referringUnit: ServiceModel;

	referringFacilityId: string;

	referringFacility: HealthFacilityModel;

	bedFacilityId: string;

	bedFacility: BedFacilityModel;

	patientVisitId: string;

	patientVisit: PatientVisitModel;

	serviceId: string;

	service: ServiceModel;

	staffId: string;

	staff: StaffModel;

	requestedById: string;

	requestedBy: StaffModel;

	bedReservesIds: string[] = [];

	bedReserves: BedReserveModel[];

	diagnosticExaminationResultsIds: string[] = [];

	diagnosticExaminationResults: DiagnosticExaminationResultsModel[];

	fluidBalanceDetailsIds: string[] = [];

	fluidBalanceDetails: FluidBalanceDetailModel[];

	informedConsentsIds: string[] = [];

	informedConsents: InformedConsentModel[];

	invoiceItemsIds: string[] = [];

	invoiceItems: InvoiceItemModel[];

	medicalFeesIds: string[] = [];

	medicalFees: MedicalFeeModel[];

	medicationHeadersIds: string[] = [];

	medicationHeaders: MedicationHeaderModel[];

	patientVitalInformationsIds: string[] = [];

	patientVitalInformations: PatientVitalInformationModel[];

	prescriptionHeadersIds: string[] = [];

	prescriptionHeaders: PrescriptionHeaderModel[];

	sampleCollectionInformationsIds: string[] = [];

	sampleCollectionInformations: SampleCollectionInformationModel[];

	vaccinationOrdersIds: string[] = [];

	vaccinationOrders: VaccinationOrderModel[];

	examinationItemsIds: string[] = [];

	examinationItems: ExaminationItemModel[];

	modelPropGroups: { [s: string]: Group } = RegistrationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'registrationNumber',
				// % protected region % [Set displayName for Registration Number here] off begin
				displayName: 'Registration Number',
				// % protected region % [Set displayName for Registration Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Registration Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Registration Number here] end
				// % protected region % [Set isSensitive for Registration Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Registration Number here] end
				// % protected region % [Set readonly for Registration Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Registration Number here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Registration Number here] off begin
					// % protected region % [Add other validators for Registration Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Registration Number here] off begin
				// % protected region % [Add any additional model attribute properties for Registration Number here] end
			},
			{
				name: 'scheduledDate',
				// % protected region % [Set displayName for Scheduled Date here] off begin
				displayName: 'Scheduled Date',
				// % protected region % [Set displayName for Scheduled Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Scheduled Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Scheduled Date here] end
				// % protected region % [Set isSensitive for Scheduled Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Scheduled Date here] end
				// % protected region % [Set readonly for Scheduled Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Scheduled Date here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Scheduled Date here] off begin
					// % protected region % [Add other validators for Scheduled Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Scheduled Date here] off begin
				// % protected region % [Add any additional model attribute properties for Scheduled Date here] end
			},
			{
				name: 'actualInDate',
				// % protected region % [Set displayName for Actual In Date here] off begin
				displayName: 'Actual In Date',
				// % protected region % [Set displayName for Actual In Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Actual In Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Actual In Date here] end
				// % protected region % [Set isSensitive for Actual In Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Actual In Date here] end
				// % protected region % [Set readonly for Actual In Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Actual In Date here] end
				validators: [
					// % protected region % [Add other validators for Actual In Date here] off begin
					// % protected region % [Add other validators for Actual In Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Actual In Date here] off begin
				// % protected region % [Add any additional model attribute properties for Actual In Date here] end
			},
			{
				name: 'dismissalDate',
				// % protected region % [Set displayName for Dismissal Date here] off begin
				displayName: 'Dismissal Date',
				// % protected region % [Set displayName for Dismissal Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Dismissal Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Dismissal Date here] end
				// % protected region % [Set isSensitive for Dismissal Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dismissal Date here] end
				// % protected region % [Set readonly for Dismissal Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dismissal Date here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Date here] off begin
					// % protected region % [Add other validators for Dismissal Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Dismissal Date here] off begin
				// % protected region % [Add any additional model attribute properties for Dismissal Date here] end
			},
			{
				name: 'dismissalType',
				// % protected region % [Set displayName for Dismissal Type here] off begin
				displayName: 'Dismissal Type',
				// % protected region % [Set displayName for Dismissal Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dismissal Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dismissal Type here] end
				// % protected region % [Set isSensitive for Dismissal Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dismissal Type here] end
				// % protected region % [Set readonly for Dismissal Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dismissal Type here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Type here] off begin
					// % protected region % [Add other validators for Dismissal Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Dismissal Type here] off begin
				// % protected region % [Add any additional model attribute properties for Dismissal Type here] end
			},
			{
				name: 'queueNo',
				// % protected region % [Set displayName for Queue No here] off begin
				displayName: 'Queue No',
				// % protected region % [Set displayName for Queue No here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Queue No here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Queue No here] end
				// % protected region % [Set isSensitive for Queue No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Queue No here] end
				// % protected region % [Set readonly for Queue No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Queue No here] end
				validators: [
					// % protected region % [Add other validators for Queue No here] off begin
					// % protected region % [Add other validators for Queue No here] end
				],
				// % protected region % [Add any additional model attribute properties for Queue No here] off begin
				// % protected region % [Add any additional model attribute properties for Queue No here] end
			},
			{
				name: 'duration',
				// % protected region % [Set displayName for Duration here] off begin
				displayName: 'Duration',
				// % protected region % [Set displayName for Duration here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Duration here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Duration here] end
				// % protected region % [Set isSensitive for Duration here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Duration here] end
				// % protected region % [Set readonly for Duration here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Duration here] end
				validators: [
					// % protected region % [Add other validators for Duration here] off begin
					// % protected region % [Add other validators for Duration here] end
				],
				// % protected region % [Add any additional model attribute properties for Duration here] off begin
				// % protected region % [Add any additional model attribute properties for Duration here] end
			},
			{
				name: 'treatmentClass',
				// % protected region % [Set displayName for Treatment Class here] off begin
				displayName: 'Treatment Class',
				// % protected region % [Set displayName for Treatment Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Treatment Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Treatment Class here] end
				// % protected region % [Set isSensitive for Treatment Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Treatment Class here] end
				// % protected region % [Set readonly for Treatment Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Treatment Class here] end
				validators: [
					// % protected region % [Add other validators for Treatment Class here] off begin
					// % protected region % [Add other validators for Treatment Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Treatment Class here] off begin
				// % protected region % [Add any additional model attribute properties for Treatment Class here] end
			},
			{
				name: 'bookedTreatmentClass',
				// % protected region % [Set displayName for Booked Treatment Class here] off begin
				displayName: 'Booked Treatment Class',
				// % protected region % [Set displayName for Booked Treatment Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Booked Treatment Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Booked Treatment Class here] end
				// % protected region % [Set isSensitive for Booked Treatment Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Booked Treatment Class here] end
				// % protected region % [Set readonly for Booked Treatment Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Booked Treatment Class here] end
				validators: [
					// % protected region % [Add other validators for Booked Treatment Class here] off begin
					// % protected region % [Add other validators for Booked Treatment Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Booked Treatment Class here] off begin
				// % protected region % [Add any additional model attribute properties for Booked Treatment Class here] end
			},
			{
				name: 'shift',
				// % protected region % [Set displayName for Shift here] off begin
				displayName: 'Shift',
				// % protected region % [Set displayName for Shift here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Shift here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Shift here] end
				// % protected region % [Set isSensitive for Shift here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Shift here] end
				// % protected region % [Set readonly for Shift here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Shift here] end
				validators: [
					// % protected region % [Add other validators for Shift here] off begin
					// % protected region % [Add other validators for Shift here] end
				],
				// % protected region % [Add any additional model attribute properties for Shift here] off begin
				// % protected region % [Add any additional model attribute properties for Shift here] end
			},
			{
				name: 'cito',
				// % protected region % [Set displayName for CITO here] off begin
				displayName: 'CITO',
				// % protected region % [Set displayName for CITO here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for CITO here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for CITO here] end
				// % protected region % [Set isSensitive for CITO here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for CITO here] end
				// % protected region % [Set readonly for CITO here] off begin
				readOnly: false,
				// % protected region % [Set readonly for CITO here] end
				validators: [
					// % protected region % [Add other validators for CITO here] off begin
					// % protected region % [Add other validators for CITO here] end
				],
				// % protected region % [Add any additional model attribute properties for CITO here] off begin
				// % protected region % [Add any additional model attribute properties for CITO here] end
			},
			{
				name: 'oneDayCare',
				// % protected region % [Set displayName for One Day Care here] off begin
				displayName: 'One Day Care',
				// % protected region % [Set displayName for One Day Care here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for One Day Care here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for One Day Care here] end
				// % protected region % [Set isSensitive for One Day Care here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for One Day Care here] end
				// % protected region % [Set readonly for One Day Care here] off begin
				readOnly: false,
				// % protected region % [Set readonly for One Day Care here] end
				validators: [
					// % protected region % [Add other validators for One Day Care here] off begin
					// % protected region % [Add other validators for One Day Care here] end
				],
				// % protected region % [Add any additional model attribute properties for One Day Care here] off begin
				// % protected region % [Add any additional model attribute properties for One Day Care here] end
			},
			{
				name: 'referral',
				// % protected region % [Set displayName for Referral here] off begin
				displayName: 'Referral',
				// % protected region % [Set displayName for Referral here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Referral here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Referral here] end
				// % protected region % [Set isSensitive for Referral here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral here] end
				// % protected region % [Set readonly for Referral here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral here] end
				validators: [
					// % protected region % [Add other validators for Referral here] off begin
					// % protected region % [Add other validators for Referral here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral here] off begin
				// % protected region % [Add any additional model attribute properties for Referral here] end
			},
			{
				name: 'registrationStatus',
				// % protected region % [Set displayName for Registration Status here] off begin
				displayName: 'Registration Status',
				// % protected region % [Set displayName for Registration Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Registration Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Registration Status here] end
				// % protected region % [Set isSensitive for Registration Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Registration Status here] end
				// % protected region % [Set readonly for Registration Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Registration Status here] end
				validators: [
					// % protected region % [Add other validators for Registration Status here] off begin
					// % protected region % [Add other validators for Registration Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Registration Status here] off begin
				// % protected region % [Add any additional model attribute properties for Registration Status here] end
			},
			{
				name: 'referralType',
				// % protected region % [Set displayName for Referral Type here] off begin
				displayName: 'Referral Type',
				// % protected region % [Set displayName for Referral Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral Type here] end
				// % protected region % [Set isSensitive for Referral Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral Type here] end
				// % protected region % [Set readonly for Referral Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral Type here] end
				validators: [
					// % protected region % [Add other validators for Referral Type here] off begin
					// % protected region % [Add other validators for Referral Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral Type here] off begin
				// % protected region % [Add any additional model attribute properties for Referral Type here] end
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
					// % protected region % [Add other validators for Purpose here] off begin
					// % protected region % [Add other validators for Purpose here] end
				],
				// % protected region % [Add any additional model attribute properties for Purpose here] off begin
				// % protected region % [Add any additional model attribute properties for Purpose here] end
			},
			{
				name: 'referralNotes',
				// % protected region % [Set displayName for Referral Notes here] off begin
				displayName: 'Referral Notes',
				// % protected region % [Set displayName for Referral Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral Notes here] end
				// % protected region % [Set isSensitive for Referral Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral Notes here] end
				// % protected region % [Set readonly for Referral Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral Notes here] end
				validators: [
					// % protected region % [Add other validators for Referral Notes here] off begin
					// % protected region % [Add other validators for Referral Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Referral Notes here] end
			},
			{
				name: 'supportingDocument',
				// % protected region % [Set displayName for Supporting Document here] off begin
				displayName: 'Supporting Document',
				// % protected region % [Set displayName for Supporting Document here] end
				type: ModelPropertyType.FILE,
				// % protected region % [Set display element type for Supporting Document here] off begin
				elementType: ElementType.FILE,
				// % protected region % [Set display element type for Supporting Document here] end
				// % protected region % [Set isSensitive for Supporting Document here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Supporting Document here] end
				// % protected region % [Set readonly for Supporting Document here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Supporting Document here] end
				validators: [
					// % protected region % [Add other validators for Supporting Document here] off begin
					// % protected region % [Add other validators for Supporting Document here] end
				],
				// % protected region % [Add any additional model attribute properties for Supporting Document here] off begin
				// % protected region % [Add any additional model attribute properties for Supporting Document here] end
			},
			{
				name: 'admissionDiagnosis',
				// % protected region % [Set displayName for Admission Diagnosis here] off begin
				displayName: 'Admission Diagnosis',
				// % protected region % [Set displayName for Admission Diagnosis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Admission Diagnosis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Admission Diagnosis here] end
				// % protected region % [Set isSensitive for Admission Diagnosis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Admission Diagnosis here] end
				// % protected region % [Set readonly for Admission Diagnosis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Admission Diagnosis here] end
				validators: [
					// % protected region % [Add other validators for Admission Diagnosis here] off begin
					// % protected region % [Add other validators for Admission Diagnosis here] end
				],
				// % protected region % [Add any additional model attribute properties for Admission Diagnosis here] off begin
				// % protected region % [Add any additional model attribute properties for Admission Diagnosis here] end
			},
			{
				name: 'printWristband',
				// % protected region % [Set displayName for Print Wristband here] off begin
				displayName: 'Print Wristband',
				// % protected region % [Set displayName for Print Wristband here] end
				type: ModelPropertyType.FILE,
				// % protected region % [Set display element type for Print Wristband here] off begin
				elementType: ElementType.FILE,
				// % protected region % [Set display element type for Print Wristband here] end
				// % protected region % [Set isSensitive for Print Wristband here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Print Wristband here] end
				// % protected region % [Set readonly for Print Wristband here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Print Wristband here] end
				validators: [
					// % protected region % [Add other validators for Print Wristband here] off begin
					// % protected region % [Add other validators for Print Wristband here] end
				],
				// % protected region % [Add any additional model attribute properties for Print Wristband here] off begin
				// % protected region % [Add any additional model attribute properties for Print Wristband here] end
			},
			{
				name: 'printLabel',
				// % protected region % [Set displayName for Print Label here] off begin
				displayName: 'Print Label',
				// % protected region % [Set displayName for Print Label here] end
				type: ModelPropertyType.FILE,
				// % protected region % [Set display element type for Print Label here] off begin
				elementType: ElementType.FILE,
				// % protected region % [Set display element type for Print Label here] end
				// % protected region % [Set isSensitive for Print Label here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Print Label here] end
				// % protected region % [Set readonly for Print Label here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Print Label here] end
				validators: [
					// % protected region % [Add other validators for Print Label here] off begin
					// % protected region % [Add other validators for Print Label here] end
				],
				// % protected region % [Add any additional model attribute properties for Print Label here] off begin
				// % protected region % [Add any additional model attribute properties for Print Label here] end
			},
			{
				name: 'uploadedDateTime',
				// % protected region % [Set displayName for Uploaded Date Time here] off begin
				displayName: 'Uploaded Date Time',
				// % protected region % [Set displayName for Uploaded Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Uploaded Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Uploaded Date Time here] end
				// % protected region % [Set isSensitive for Uploaded Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Uploaded Date Time here] end
				// % protected region % [Set readonly for Uploaded Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Uploaded Date Time here] end
				validators: [
					// % protected region % [Add other validators for Uploaded Date Time here] off begin
					// % protected region % [Add other validators for Uploaded Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Uploaded Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Uploaded Date Time here] end
			},
			{
				name: 'visitStatus',
				// % protected region % [Set displayName for Visit Status here] off begin
				displayName: 'Visit Status',
				// % protected region % [Set displayName for Visit Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Visit Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Visit Status here] end
				// % protected region % [Set isSensitive for Visit Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visit Status here] end
				// % protected region % [Set readonly for Visit Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visit Status here] end
				validators: [
					// % protected region % [Add other validators for Visit Status here] off begin
					// % protected region % [Add other validators for Visit Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Visit Status here] off begin
				// % protected region % [Add any additional model attribute properties for Visit Status here] end
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
					// % protected region % [Add other validators for Instruction here] off begin
					// % protected region % [Add other validators for Instruction here] end
				],
				// % protected region % [Add any additional model attribute properties for Instruction here] off begin
				// % protected region % [Add any additional model attribute properties for Instruction here] end
			},
			{
				name: 'isAnAppointment',
				// % protected region % [Set displayName for is An Appointment here] off begin
				displayName: 'is An Appointment',
				// % protected region % [Set displayName for is An Appointment here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for is An Appointment here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for is An Appointment here] end
				// % protected region % [Set isSensitive for is An Appointment here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for is An Appointment here] end
				// % protected region % [Set readonly for is An Appointment here] off begin
				readOnly: false,
				// % protected region % [Set readonly for is An Appointment here] end
				validators: [
					// % protected region % [Add other validators for is An Appointment here] off begin
					// % protected region % [Add other validators for is An Appointment here] end
				],
				// % protected region % [Add any additional model attribute properties for is An Appointment here] off begin
				// % protected region % [Add any additional model attribute properties for is An Appointment here] end
			},
			{
				name: 'referralNumber',
				// % protected region % [Set displayName for Referral Number here] off begin
				displayName: 'Referral Number',
				// % protected region % [Set displayName for Referral Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral Number here] end
				// % protected region % [Set isSensitive for Referral Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral Number here] end
				// % protected region % [Set readonly for Referral Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral Number here] end
				validators: [
					// % protected region % [Add other validators for Referral Number here] off begin
					// % protected region % [Add other validators for Referral Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral Number here] off begin
				// % protected region % [Add any additional model attribute properties for Referral Number here] end
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
			{
				name: 'kodepoli',
				// % protected region % [Set displayName for kodepoli here] off begin
				displayName: 'kodepoli',
				// % protected region % [Set displayName for kodepoli here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kodepoli here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kodepoli here] end
				// % protected region % [Set isSensitive for kodepoli here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kodepoli here] end
				// % protected region % [Set readonly for kodepoli here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kodepoli here] end
				validators: [
					// % protected region % [Add other validators for kodepoli here] off begin
					// % protected region % [Add other validators for kodepoli here] end
				],
				// % protected region % [Add any additional model attribute properties for kodepoli here] off begin
				// % protected region % [Add any additional model attribute properties for kodepoli here] end
			},
			{
				name: 'deathCertificateNo',
				// % protected region % [Set displayName for Death Certificate No here] off begin
				displayName: 'Death Certificate No',
				// % protected region % [Set displayName for Death Certificate No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Death Certificate No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Death Certificate No here] end
				// % protected region % [Set isSensitive for Death Certificate No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Death Certificate No here] end
				// % protected region % [Set readonly for Death Certificate No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Death Certificate No here] end
				validators: [
					// % protected region % [Add other validators for Death Certificate No here] off begin
					// % protected region % [Add other validators for Death Certificate No here] end
				],
				// % protected region % [Add any additional model attribute properties for Death Certificate No here] off begin
				// % protected region % [Add any additional model attribute properties for Death Certificate No here] end
			},
			{
				name: 'timeOfDeath',
				// % protected region % [Set displayName for Time Of Death here] off begin
				displayName: 'Time Of Death',
				// % protected region % [Set displayName for Time Of Death here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Time Of Death here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Time Of Death here] end
				// % protected region % [Set isSensitive for Time Of Death here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Time Of Death here] end
				// % protected region % [Set readonly for Time Of Death here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Time Of Death here] end
				validators: [
					// % protected region % [Add other validators for Time Of Death here] off begin
					// % protected region % [Add other validators for Time Of Death here] end
				],
				// % protected region % [Add any additional model attribute properties for Time Of Death here] off begin
				// % protected region % [Add any additional model attribute properties for Time Of Death here] end
			},
			{
				name: 'dismissalReferral',
				// % protected region % [Set displayName for Dismissal Referral here] off begin
				displayName: 'Dismissal Referral',
				// % protected region % [Set displayName for Dismissal Referral here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Dismissal Referral here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Dismissal Referral here] end
				// % protected region % [Set isSensitive for Dismissal Referral here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dismissal Referral here] end
				// % protected region % [Set readonly for Dismissal Referral here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dismissal Referral here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Referral here] off begin
					// % protected region % [Add other validators for Dismissal Referral here] end
				],
				// % protected region % [Add any additional model attribute properties for Dismissal Referral here] off begin
				// % protected region % [Add any additional model attribute properties for Dismissal Referral here] end
			},
			{
				name: 'dismissalReferralDetail',
				// % protected region % [Set displayName for Dismissal Referral Detail here] off begin
				displayName: 'Dismissal Referral Detail',
				// % protected region % [Set displayName for Dismissal Referral Detail here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dismissal Referral Detail here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dismissal Referral Detail here] end
				// % protected region % [Set isSensitive for Dismissal Referral Detail here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dismissal Referral Detail here] end
				// % protected region % [Set readonly for Dismissal Referral Detail here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dismissal Referral Detail here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Referral Detail here] off begin
					// % protected region % [Add other validators for Dismissal Referral Detail here] end
				],
				// % protected region % [Add any additional model attribute properties for Dismissal Referral Detail here] off begin
				// % protected region % [Add any additional model attribute properties for Dismissal Referral Detail here] end
			},
			{
				name: 'dismissalReferralType',
				// % protected region % [Set displayName for Dismissal Referral Type here] off begin
				displayName: 'Dismissal Referral Type',
				// % protected region % [Set displayName for Dismissal Referral Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dismissal Referral Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dismissal Referral Type here] end
				// % protected region % [Set isSensitive for Dismissal Referral Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dismissal Referral Type here] end
				// % protected region % [Set readonly for Dismissal Referral Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dismissal Referral Type here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Referral Type here] off begin
					// % protected region % [Add other validators for Dismissal Referral Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Dismissal Referral Type here] off begin
				// % protected region % [Add any additional model attribute properties for Dismissal Referral Type here] end
			},
			{
				name: 'dismissalReferringNotes',
				// % protected region % [Set displayName for Dismissal Referring Notes here] off begin
				displayName: 'Dismissal Referring Notes',
				// % protected region % [Set displayName for Dismissal Referring Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dismissal Referring Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dismissal Referring Notes here] end
				// % protected region % [Set isSensitive for Dismissal Referring Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dismissal Referring Notes here] end
				// % protected region % [Set readonly for Dismissal Referring Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dismissal Referring Notes here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Referring Notes here] off begin
					// % protected region % [Add other validators for Dismissal Referring Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Dismissal Referring Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Dismissal Referring Notes here] end
			},
			{
				name: 'patientIsReferredBack',
				// % protected region % [Set displayName for Patient Is Referred Back here] off begin
				displayName: 'Patient Is Referred Back',
				// % protected region % [Set displayName for Patient Is Referred Back here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Patient Is Referred Back here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Patient Is Referred Back here] end
				// % protected region % [Set isSensitive for Patient Is Referred Back here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Is Referred Back here] end
				// % protected region % [Set readonly for Patient Is Referred Back here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Is Referred Back here] end
				validators: [
					// % protected region % [Add other validators for Patient Is Referred Back here] off begin
					// % protected region % [Add other validators for Patient Is Referred Back here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Is Referred Back here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Is Referred Back here] end
			},
			{
				name: 'mcuPackage',
				// % protected region % [Set displayName for MCU Package here] off begin
				displayName: 'MCU Package',
				// % protected region % [Set displayName for MCU Package here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for MCU Package here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for MCU Package here] end
				// % protected region % [Set isSensitive for MCU Package here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for MCU Package here] end
				// % protected region % [Set readonly for MCU Package here] off begin
				readOnly: false,
				// % protected region % [Set readonly for MCU Package here] end
				validators: [
					// % protected region % [Add other validators for MCU Package here] off begin
					// % protected region % [Add other validators for MCU Package here] end
				],
				// % protected region % [Add any additional model attribute properties for MCU Package here] off begin
				// % protected region % [Add any additional model attribute properties for MCU Package here] end
			},
			{
				name: 'parentRegistrationNumber',
				// % protected region % [Set displayName for Parent Registration Number here] off begin
				displayName: 'Parent Registration Number',
				// % protected region % [Set displayName for Parent Registration Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Parent Registration Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Parent Registration Number here] end
				// % protected region % [Set isSensitive for Parent Registration Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Parent Registration Number here] end
				// % protected region % [Set readonly for Parent Registration Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Parent Registration Number here] end
				validators: [
					// % protected region % [Add other validators for Parent Registration Number here] off begin
					// % protected region % [Add other validators for Parent Registration Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Parent Registration Number here] off begin
				// % protected region % [Add any additional model attribute properties for Parent Registration Number here] end
			},
			{
				name: 'isUnknownPatient',
				// % protected region % [Set displayName for Is Unknown Patient here] off begin
				displayName: 'Is Unknown Patient',
				// % protected region % [Set displayName for Is Unknown Patient here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Unknown Patient here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Unknown Patient here] end
				// % protected region % [Set isSensitive for Is Unknown Patient here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Unknown Patient here] end
				// % protected region % [Set readonly for Is Unknown Patient here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Unknown Patient here] end
				validators: [
					// % protected region % [Add other validators for Is Unknown Patient here] off begin
					// % protected region % [Add other validators for Is Unknown Patient here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Unknown Patient here] off begin
				// % protected region % [Add any additional model attribute properties for Is Unknown Patient here] end
			},
			{
				name: 'otherReferredFacility',
				// % protected region % [Set displayName for Other Referred Facility here] off begin
				displayName: 'Other Referred Facility',
				// % protected region % [Set displayName for Other Referred Facility here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Other Referred Facility here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Other Referred Facility here] end
				// % protected region % [Set isSensitive for Other Referred Facility here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Referred Facility here] end
				// % protected region % [Set readonly for Other Referred Facility here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Referred Facility here] end
				validators: [
					// % protected region % [Add other validators for Other Referred Facility here] off begin
					// % protected region % [Add other validators for Other Referred Facility here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Referred Facility here] off begin
				// % protected region % [Add any additional model attribute properties for Other Referred Facility here] end
			},
			{
				name: 'otherReferredStaff',
				// % protected region % [Set displayName for Other Referred Staff here] off begin
				displayName: 'Other Referred Staff',
				// % protected region % [Set displayName for Other Referred Staff here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Other Referred Staff here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Other Referred Staff here] end
				// % protected region % [Set isSensitive for Other Referred Staff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Referred Staff here] end
				// % protected region % [Set readonly for Other Referred Staff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Referred Staff here] end
				validators: [
					// % protected region % [Add other validators for Other Referred Staff here] off begin
					// % protected region % [Add other validators for Other Referred Staff here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Referred Staff here] off begin
				// % protected region % [Add any additional model attribute properties for Other Referred Staff here] end
			},
			{
				name: 'doctorScheduleDetailId',
				// % protected region % [Set displayName for Doctor Schedule Detail Id here] off begin
				displayName: 'Doctor Schedule Detail Id',
				// % protected region % [Set displayName for Doctor Schedule Detail Id here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor Schedule Detail Id here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor Schedule Detail Id here] end
				// % protected region % [Set isSensitive for Doctor Schedule Detail Id here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor Schedule Detail Id here] end
				// % protected region % [Set readonly for Doctor Schedule Detail Id here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor Schedule Detail Id here] end
				validators: [
					// % protected region % [Add other validators for Doctor Schedule Detail Id here] off begin
					// % protected region % [Add other validators for Doctor Schedule Detail Id here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor Schedule Detail Id here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor Schedule Detail Id here] end
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
				id: 'bpjsPRBDetail',
				type: ModelRelationType.ONE,
				name: 'bpjsPRBDetailId',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS PRB Detail here] off begin
				label: 'BPJS PRB Detail',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS PRB Detail here] end
				entityName: 'BpjsPRBDetailModel',
				// % protected region % [Customise your display name for BPJS PRB Detail here] off begin
				displayName: 'srbNo',
				// % protected region % [Customise your display name for BPJS PRB Detail here] end
				validators: [
					// % protected region % [Add other validators for BPJS PRB Detail here] off begin
					// % protected region % [Add other validators for BPJS PRB Detail here] end
				],
				// % protected region % [Add any additional field for relation BPJS PRB Detail here] off begin
				// % protected region % [Add any additional field for relation BPJS PRB Detail here] end
			},
			{
				id: 'bpjsPcareRegistrations',
				type: ModelRelationType.ONE,
				name: 'bpjsPcareRegistrationsId',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Pcare Registrations here] off begin
				label: 'BPJS Pcare Registrations',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Pcare Registrations here] end
				entityName: 'BpjsPcareRegistrationsModel',
				// % protected region % [Customise your display name for BPJS Pcare Registrations here] off begin
				displayName: 'kdproviderpeserta',
				// % protected region % [Customise your display name for BPJS Pcare Registrations here] end
				validators: [
					// % protected region % [Add other validators for BPJS Pcare Registrations here] off begin
					// % protected region % [Add other validators for BPJS Pcare Registrations here] end
				],
				// % protected region % [Add any additional field for relation BPJS Pcare Registrations here] off begin
				// % protected region % [Add any additional field for relation BPJS Pcare Registrations here] end
			},
			{
				id: 'bpjsSEP',
				type: ModelRelationType.ONE,
				name: 'bpjsSEPId',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS SEP here] off begin
				label: 'BPJS SEP',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS SEP here] end
				entityName: 'BpjsSEPModel',
				// % protected region % [Customise your display name for BPJS SEP here] off begin
				displayName: 'noSEP',
				// % protected region % [Customise your display name for BPJS SEP here] end
				validators: [
					// % protected region % [Add other validators for BPJS SEP here] off begin
					// % protected region % [Add other validators for BPJS SEP here] end
				],
				// % protected region % [Add any additional field for relation BPJS SEP here] off begin
				// % protected region % [Add any additional field for relation BPJS SEP here] end
			},
			{
				id: 'bedReserves',
				type: ModelRelationType.MANY,
				name: 'bedReservesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Bed Reserves here] off begin
				label: 'Bed Reserves',
				// % protected region % [Customise your 1-1 or 1-M label for Bed Reserves here] end
				entityName: 'BedReserveModel',
				// % protected region % [Customise your display name for Bed Reserves here] off begin
				displayName: 'notes',
				// % protected region % [Customise your display name for Bed Reserves here] end
				validators: [
					// % protected region % [Add other validators for Bed Reserves here] off begin
					// % protected region % [Add other validators for Bed Reserves here] end
				],
				// % protected region % [Add any additional field for relation Bed Reserves here] off begin
				// % protected region % [Add any additional field for relation Bed Reserves here] end
			},
			{
				id: 'diagnosticExaminationResults',
				type: ModelRelationType.MANY,
				name: 'diagnosticExaminationResultsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnostic Examination Results here] off begin
				label: 'Diagnostic Examination Results',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnostic Examination Results here] end
				entityName: 'DiagnosticExaminationResultsModel',
				// % protected region % [Customise your display name for Diagnostic Examination Results here] off begin
				displayName: 'result',
				// % protected region % [Customise your display name for Diagnostic Examination Results here] end
				validators: [
					// % protected region % [Add other validators for Diagnostic Examination Results here] off begin
					// % protected region % [Add other validators for Diagnostic Examination Results here] end
				],
				// % protected region % [Add any additional field for relation Diagnostic Examination Results here] off begin
				// % protected region % [Add any additional field for relation Diagnostic Examination Results here] end
			},
			{
				id: 'fluidBalanceDetails',
				type: ModelRelationType.MANY,
				name: 'fluidBalanceDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Fluid Balance Details here] off begin
				label: 'Fluid Balance Details',
				// % protected region % [Customise your 1-1 or 1-M label for Fluid Balance Details here] end
				entityName: 'FluidBalanceDetailModel',
				// % protected region % [Customise your display name for Fluid Balance Details here] off begin
				displayName: 'recordDateTime',
				// % protected region % [Customise your display name for Fluid Balance Details here] end
				validators: [
					// % protected region % [Add other validators for Fluid Balance Details here] off begin
					// % protected region % [Add other validators for Fluid Balance Details here] end
				],
				// % protected region % [Add any additional field for relation Fluid Balance Details here] off begin
				// % protected region % [Add any additional field for relation Fluid Balance Details here] end
			},
			{
				id: 'informedConsents',
				type: ModelRelationType.MANY,
				name: 'informedConsentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Informed Consents here] off begin
				label: 'Informed Consents',
				// % protected region % [Customise your 1-1 or 1-M label for Informed Consents here] end
				entityName: 'InformedConsentModel',
				// % protected region % [Customise your display name for Informed Consents here] off begin
				displayName: 'patientFamilyGuardianName',
				// % protected region % [Customise your display name for Informed Consents here] end
				validators: [
					// % protected region % [Add other validators for Informed Consents here] off begin
					// % protected region % [Add other validators for Informed Consents here] end
				],
				// % protected region % [Add any additional field for relation Informed Consents here] off begin
				// % protected region % [Add any additional field for relation Informed Consents here] end
			},
			{
				id: 'invoiceItems',
				type: ModelRelationType.MANY,
				name: 'invoiceItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Items here] off begin
				label: 'Invoice Items',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Items here] end
				entityName: 'InvoiceItemModel',
				// % protected region % [Customise your display name for Invoice Items here] off begin
				displayName: 'transactionDate',
				// % protected region % [Customise your display name for Invoice Items here] end
				validators: [
					// % protected region % [Add other validators for Invoice Items here] off begin
					// % protected region % [Add other validators for Invoice Items here] end
				],
				// % protected region % [Add any additional field for relation Invoice Items here] off begin
				// % protected region % [Add any additional field for relation Invoice Items here] end
			},
			{
				id: 'medicalCertificateDischargeResume',
				type: ModelRelationType.ONE,
				name: 'medicalCertificateDischargeResumeId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate  Discharge Resume here] off begin
				label: 'Medical Certificate  Discharge Resume',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate  Discharge Resume here] end
				entityName: 'MedicalCertificateDischargeResumeModel',
				// % protected region % [Customise your display name for Medical Certificate  Discharge Resume here] off begin
				displayName: 'admissionDateTime',
				// % protected region % [Customise your display name for Medical Certificate  Discharge Resume here] end
				validators: [
					// % protected region % [Add other validators for Medical Certificate  Discharge Resume here] off begin
					// % protected region % [Add other validators for Medical Certificate  Discharge Resume here] end
				],
				// % protected region % [Add any additional field for relation Medical Certificate  Discharge Resume here] off begin
				// % protected region % [Add any additional field for relation Medical Certificate  Discharge Resume here] end
			},
			{
				id: 'medicalCertificateBirth',
				type: ModelRelationType.ONE,
				name: 'medicalCertificateBirthId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Birth here] off begin
				label: 'Medical Certificate Birth',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Birth here] end
				entityName: 'MedicalCertificateBirthModel',
				// % protected region % [Customise your display name for Medical Certificate Birth here] off begin
				displayName: 'patientName',
				// % protected region % [Customise your display name for Medical Certificate Birth here] end
				validators: [
					// % protected region % [Add other validators for Medical Certificate Birth here] off begin
					// % protected region % [Add other validators for Medical Certificate Birth here] end
				],
				// % protected region % [Add any additional field for relation Medical Certificate Birth here] off begin
				// % protected region % [Add any additional field for relation Medical Certificate Birth here] end
			},
			{
				id: 'medicalCertificateHospitalization',
				type: ModelRelationType.ONE,
				name: 'medicalCertificateHospitalizationId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Hospitalization here] off begin
				label: 'Medical Certificate Hospitalization',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Hospitalization here] end
				entityName: 'MedicalCertificateHospitalizationModel',
				// % protected region % [Customise your display name for Medical Certificate Hospitalization here] off begin
				displayName: 'admissionDateTime',
				// % protected region % [Customise your display name for Medical Certificate Hospitalization here] end
				validators: [
					// % protected region % [Add other validators for Medical Certificate Hospitalization here] off begin
					// % protected region % [Add other validators for Medical Certificate Hospitalization here] end
				],
				// % protected region % [Add any additional field for relation Medical Certificate Hospitalization here] off begin
				// % protected region % [Add any additional field for relation Medical Certificate Hospitalization here] end
			},
			{
				id: 'medicalCertificateMedicalAttendance',
				type: ModelRelationType.ONE,
				name: 'medicalCertificateMedicalAttendanceId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Medical Attendance here] off begin
				label: 'Medical Certificate Medical Attendance',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Medical Attendance here] end
				entityName: 'MedicalCertificateMedicalAttendanceModel',
				// % protected region % [Customise your display name for Medical Certificate Medical Attendance here] off begin
				displayName: 'date',
				// % protected region % [Customise your display name for Medical Certificate Medical Attendance here] end
				validators: [
					// % protected region % [Add other validators for Medical Certificate Medical Attendance here] off begin
					// % protected region % [Add other validators for Medical Certificate Medical Attendance here] end
				],
				// % protected region % [Add any additional field for relation Medical Certificate Medical Attendance here] off begin
				// % protected region % [Add any additional field for relation Medical Certificate Medical Attendance here] end
			},
			{
				id: 'medicalCertificateMentalHealth',
				type: ModelRelationType.ONE,
				name: 'medicalCertificateMentalHealthId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Mental Health here] off begin
				label: 'Medical Certificate Mental Health',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Mental Health here] end
				entityName: 'MedicalCertificateMentalHealthModel',
				// % protected region % [Customise your display name for Medical Certificate Mental Health here] off begin
				displayName: 'examinationDateTime',
				// % protected region % [Customise your display name for Medical Certificate Mental Health here] end
				validators: [
					// % protected region % [Add other validators for Medical Certificate Mental Health here] off begin
					// % protected region % [Add other validators for Medical Certificate Mental Health here] end
				],
				// % protected region % [Add any additional field for relation Medical Certificate Mental Health here] off begin
				// % protected region % [Add any additional field for relation Medical Certificate Mental Health here] end
			},
			{
				id: 'medicalCertificatePhysicalHealth',
				type: ModelRelationType.ONE,
				name: 'medicalCertificatePhysicalHealthId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Physical Health here] off begin
				label: 'Medical Certificate Physical Health',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Physical Health here] end
				entityName: 'MedicalCertificatePhysicalHealthModel',
				// % protected region % [Customise your display name for Medical Certificate Physical Health here] off begin
				displayName: 'examinationDateTime',
				// % protected region % [Customise your display name for Medical Certificate Physical Health here] end
				validators: [
					// % protected region % [Add other validators for Medical Certificate Physical Health here] off begin
					// % protected region % [Add other validators for Medical Certificate Physical Health here] end
				],
				// % protected region % [Add any additional field for relation Medical Certificate Physical Health here] off begin
				// % protected region % [Add any additional field for relation Medical Certificate Physical Health here] end
			},
			{
				id: 'medicalCertificateRestrictedWork',
				type: ModelRelationType.ONE,
				name: 'medicalCertificateRestrictedWorkId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Restricted Work here] off begin
				label: 'Medical Certificate Restricted Work',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Restricted Work here] end
				entityName: 'MedicalCertificateRestrictedWorkModel',
				// % protected region % [Customise your display name for Medical Certificate Restricted Work here] off begin
				displayName: 'period',
				// % protected region % [Customise your display name for Medical Certificate Restricted Work here] end
				validators: [
					// % protected region % [Add other validators for Medical Certificate Restricted Work here] off begin
					// % protected region % [Add other validators for Medical Certificate Restricted Work here] end
				],
				// % protected region % [Add any additional field for relation Medical Certificate Restricted Work here] off begin
				// % protected region % [Add any additional field for relation Medical Certificate Restricted Work here] end
			},
			{
				id: 'medicalCertificateSickLeave',
				type: ModelRelationType.ONE,
				name: 'medicalCertificateSickLeaveId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Sick Leave here] off begin
				label: 'Medical Certificate Sick Leave',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Sick Leave here] end
				entityName: 'MedicalCertificateSickLeaveModel',
				// % protected region % [Customise your display name for Medical Certificate Sick Leave here] off begin
				displayName: 'period',
				// % protected region % [Customise your display name for Medical Certificate Sick Leave here] end
				validators: [
					// % protected region % [Add other validators for Medical Certificate Sick Leave here] off begin
					// % protected region % [Add other validators for Medical Certificate Sick Leave here] end
				],
				// % protected region % [Add any additional field for relation Medical Certificate Sick Leave here] off begin
				// % protected region % [Add any additional field for relation Medical Certificate Sick Leave here] end
			},
			{
				id: 'medicalExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'medicalExaminationRecordId',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Examination Record here] off begin
				label: 'Medical Examination Record',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Examination Record here] end
				entityName: 'MedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Medical Examination Record here] off begin
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
				id: 'medicalFees',
				type: ModelRelationType.MANY,
				name: 'medicalFeesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Fees here] off begin
				label: 'Medical Fees',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Fees here] end
				entityName: 'MedicalFeeModel',
				// % protected region % [Customise your display name for Medical Fees here] off begin
				displayName: 'tariffType',
				// % protected region % [Customise your display name for Medical Fees here] end
				validators: [
					// % protected region % [Add other validators for Medical Fees here] off begin
					// % protected region % [Add other validators for Medical Fees here] end
				],
				// % protected region % [Add any additional field for relation Medical Fees here] off begin
				// % protected region % [Add any additional field for relation Medical Fees here] end
			},
			{
				id: 'medicationHeaders',
				type: ModelRelationType.MANY,
				name: 'medicationHeadersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Headers here] off begin
				label: 'Medication Headers',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Headers here] end
				entityName: 'MedicationHeaderModel',
				// % protected region % [Customise your display name for Medication Headers here] off begin
				displayName: 'medicationNumber',
				// % protected region % [Customise your display name for Medication Headers here] end
				validators: [
					// % protected region % [Add other validators for Medication Headers here] off begin
					// % protected region % [Add other validators for Medication Headers here] end
				],
				// % protected region % [Add any additional field for relation Medication Headers here] off begin
				// % protected region % [Add any additional field for relation Medication Headers here] end
			},
			{
				id: 'pcareExamination',
				type: ModelRelationType.ONE,
				name: 'pcareExaminationId',
				// % protected region % [Customise your 1-1 or 1-M label for PCare Examination here] off begin
				label: 'PCare Examination',
				// % protected region % [Customise your 1-1 or 1-M label for PCare Examination here] end
				entityName: 'PcareExaminationModel',
				// % protected region % [Customise your display name for PCare Examination here] off begin
				displayName: 'visitType',
				// % protected region % [Customise your display name for PCare Examination here] end
				validators: [
					// % protected region % [Add other validators for PCare Examination here] off begin
					// % protected region % [Add other validators for PCare Examination here] end
				],
				// % protected region % [Add any additional field for relation PCare Examination here] off begin
				// % protected region % [Add any additional field for relation PCare Examination here] end
			},
			{
				id: 'patientVitalInformations',
				type: ModelRelationType.MANY,
				name: 'patientVitalInformationsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Vital Informations here] off begin
				label: 'Patient Vital Informations',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Vital Informations here] end
				entityName: 'PatientVitalInformationModel',
				// % protected region % [Customise your display name for Patient Vital Informations here] off begin
				displayName: 'recordDateTime',
				// % protected region % [Customise your display name for Patient Vital Informations here] end
				validators: [
					// % protected region % [Add other validators for Patient Vital Informations here] off begin
					// % protected region % [Add other validators for Patient Vital Informations here] end
				],
				// % protected region % [Add any additional field for relation Patient Vital Informations here] off begin
				// % protected region % [Add any additional field for relation Patient Vital Informations here] end
			},
			{
				id: 'prescriptionHeaders',
				type: ModelRelationType.MANY,
				name: 'prescriptionHeadersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Prescription Headers here] off begin
				label: 'Prescription Headers',
				// % protected region % [Customise your 1-1 or 1-M label for Prescription Headers here] end
				entityName: 'PrescriptionHeaderModel',
				// % protected region % [Customise your display name for Prescription Headers here] off begin
				displayName: 'prescriptionNumber',
				// % protected region % [Customise your display name for Prescription Headers here] end
				validators: [
					// % protected region % [Add other validators for Prescription Headers here] off begin
					// % protected region % [Add other validators for Prescription Headers here] end
				],
				// % protected region % [Add any additional field for relation Prescription Headers here] off begin
				// % protected region % [Add any additional field for relation Prescription Headers here] end
			},
			{
				id: 'sep',
				type: ModelRelationType.ONE,
				name: 'sepId',
				// % protected region % [Customise your 1-1 or 1-M label for SEP here] off begin
				label: 'SEP',
				// % protected region % [Customise your 1-1 or 1-M label for SEP here] end
				entityName: 'SepModel',
				// % protected region % [Customise your display name for SEP here] off begin
				displayName: 'sepData',
				// % protected region % [Customise your display name for SEP here] end
				validators: [
					// % protected region % [Add other validators for SEP here] off begin
					// % protected region % [Add other validators for SEP here] end
				],
				// % protected region % [Add any additional field for relation SEP here] off begin
				// % protected region % [Add any additional field for relation SEP here] end
			},
			{
				id: 'sampleCollectionInformations',
				type: ModelRelationType.MANY,
				name: 'sampleCollectionInformationsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Sample Collection Informations here] off begin
				label: 'Sample Collection Informations',
				// % protected region % [Customise your 1-1 or 1-M label for Sample Collection Informations here] end
				entityName: 'SampleCollectionInformationModel',
				// % protected region % [Customise your display name for Sample Collection Informations here] off begin
				displayName: 'patientInformed',
				// % protected region % [Customise your display name for Sample Collection Informations here] end
				validators: [
					// % protected region % [Add other validators for Sample Collection Informations here] off begin
					// % protected region % [Add other validators for Sample Collection Informations here] end
				],
				// % protected region % [Add any additional field for relation Sample Collection Informations here] off begin
				// % protected region % [Add any additional field for relation Sample Collection Informations here] end
			},
			{
				id: 'vaccinationOrders',
				type: ModelRelationType.MANY,
				name: 'vaccinationOrdersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Vaccination Orders here] off begin
				label: 'Vaccination Orders',
				// % protected region % [Customise your 1-1 or 1-M label for Vaccination Orders here] end
				entityName: 'VaccinationOrderModel',
				// % protected region % [Customise your display name for Vaccination Orders here] off begin
				displayName: 'vaccinationLocation',
				// % protected region % [Customise your display name for Vaccination Orders here] end
				validators: [
					// % protected region % [Add other validators for Vaccination Orders here] off begin
					// % protected region % [Add other validators for Vaccination Orders here] end
				],
				// % protected region % [Add any additional field for relation Vaccination Orders here] off begin
				// % protected region % [Add any additional field for relation Vaccination Orders here] end
			},
			{
				id: 'admissionICD10',
				type: ModelRelationType.ONE,
				name: 'admissionICD10Id',
				// % protected region % [Customise your label for Admission ICD 10 here] off begin
				label: 'Admission ICD 10',
				// % protected region % [Customise your label for Admission ICD 10 here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for Admission ICD 10 here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemType',
				// % protected region % [Customise your display name for Admission ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for Admission ICD 10 here] off begin
					// % protected region % [Add other validators for Admission ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation Admission ICD 10 here] off begin
				// % protected region % [Add any additional field for relation Admission ICD 10 here] end
			},
			{
				id: 'admissionICD9CM',
				type: ModelRelationType.ONE,
				name: 'admissionICD9CMId',
				// % protected region % [Customise your label for Admission ICD 9 CM here] off begin
				label: 'Admission ICD 9 CM',
				// % protected region % [Customise your label for Admission ICD 9 CM here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for Admission ICD 9 CM here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemType',
				// % protected region % [Customise your display name for Admission ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for Admission ICD 9 CM here] off begin
					// % protected region % [Add other validators for Admission ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation Admission ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation Admission ICD 9 CM here] end
			},
			{
				id: 'dismissalReferringFacility',
				type: ModelRelationType.ONE,
				name: 'dismissalReferringFacilityId',
				// % protected region % [Customise your label for Dismissal Referring Facility here] off begin
				label: 'Dismissal Referring Facility',
				// % protected region % [Customise your label for Dismissal Referring Facility here] end
				entityName: 'HealthFacilityModel',
				// % protected region % [Customise your display name for Dismissal Referring Facility here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'healthFacilityID',
				// % protected region % [Customise your display name for Dismissal Referring Facility here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Referring Facility here] off begin
					// % protected region % [Add other validators for Dismissal Referring Facility here] end
				],
				// % protected region % [Add any additional field for relation Dismissal Referring Facility here] off begin
				// % protected region % [Add any additional field for relation Dismissal Referring Facility here] end
			},
			{
				id: 'dismissalReferringStaff',
				type: ModelRelationType.ONE,
				name: 'dismissalReferringStaffId',
				// % protected region % [Customise your label for Dismissal Referring Staff here] off begin
				label: 'Dismissal Referring Staff',
				// % protected region % [Customise your label for Dismissal Referring Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Dismissal Referring Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Dismissal Referring Staff here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Referring Staff here] off begin
					// % protected region % [Add other validators for Dismissal Referring Staff here] end
				],
				// % protected region % [Add any additional field for relation Dismissal Referring Staff here] off begin
				// % protected region % [Add any additional field for relation Dismissal Referring Staff here] end
			},
			{
				id: 'referringUnit',
				type: ModelRelationType.ONE,
				name: 'referringUnitId',
				// % protected region % [Customise your label for Referring Unit here] off begin
				label: 'Referring Unit',
				// % protected region % [Customise your label for Referring Unit here] end
				entityName: 'ServiceModel',
				// % protected region % [Customise your display name for Referring Unit here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'serviceNumber',
				// % protected region % [Customise your display name for Referring Unit here] end
				validators: [
					// % protected region % [Add other validators for Referring Unit here] off begin
					// % protected region % [Add other validators for Referring Unit here] end
				],
				// % protected region % [Add any additional field for relation Referring Unit here] off begin
				// % protected region % [Add any additional field for relation Referring Unit here] end
			},
			{
				id: 'referringFacility',
				type: ModelRelationType.ONE,
				name: 'referringFacilityId',
				// % protected region % [Customise your label for Referring facility here] off begin
				label: 'Referring facility',
				// % protected region % [Customise your label for Referring facility here] end
				entityName: 'HealthFacilityModel',
				// % protected region % [Customise your display name for Referring facility here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'healthFacilityID',
				// % protected region % [Customise your display name for Referring facility here] end
				validators: [
					// % protected region % [Add other validators for Referring facility here] off begin
					// % protected region % [Add other validators for Referring facility here] end
				],
				// % protected region % [Add any additional field for relation Referring facility here] off begin
				// % protected region % [Add any additional field for relation Referring facility here] end
			},
			{
				id: 'diagnosticStaffExaminationSummary',
				type: ModelRelationType.ONE,
				name: 'diagnosticStaffExaminationSummaryId',
				// % protected region % [Customise your label for Diagnostic Staff Examination Summary here] off begin
				label: 'Diagnostic Staff Examination Summary',
				// % protected region % [Customise your label for Diagnostic Staff Examination Summary here] end
				entityName: 'DiagnosticStaffExaminationSummaryModel',
				// % protected region % [Customise your display name for Diagnostic Staff Examination Summary here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'responsibleDoctor',
				// % protected region % [Customise your display name for Diagnostic Staff Examination Summary here] end
				validators: [
					// % protected region % [Add other validators for Diagnostic Staff Examination Summary here] off begin
					// % protected region % [Add other validators for Diagnostic Staff Examination Summary here] end
				],
				// % protected region % [Add any additional field for relation Diagnostic Staff Examination Summary here] off begin
				// % protected region % [Add any additional field for relation Diagnostic Staff Examination Summary here] end
			},
			{
				id: 'bedFacility',
				type: ModelRelationType.ONE,
				name: 'bedFacilityId',
				// % protected region % [Customise your label for Bed Facility here] off begin
				label: 'Bed Facility',
				// % protected region % [Customise your label for Bed Facility here] end
				entityName: 'BedFacilityModel',
				// % protected region % [Customise your display name for Bed Facility here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'bedNumber',
				// % protected region % [Customise your display name for Bed Facility here] end
				validators: [
					// % protected region % [Add other validators for Bed Facility here] off begin
					// % protected region % [Add other validators for Bed Facility here] end
				],
				// % protected region % [Add any additional field for relation Bed Facility here] off begin
				// % protected region % [Add any additional field for relation Bed Facility here] end
			},
			{
				id: 'examinationItems',
				type: ModelRelationType.MANY,
				name: 'examinationItemsIds',
				// % protected region % [Customise your label for Examination Items here] off begin
				label: 'Examination Items',
				// % protected region % [Customise your label for Examination Items here] end
				entityName: 'ExaminationItemModel',
				// % protected region % [Customise your display name for Examination Items here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemCode',
				// % protected region % [Customise your display name for Examination Items here] end
				validators: [
					// % protected region % [Add other validators for Examination Items here] off begin
					// % protected region % [Add other validators for Examination Items here] end
				],
				// % protected region % [Add any additional field for relation Examination Items here] off begin
				// % protected region % [Add any additional field for relation Examination Items here] end
			},
			{
				id: 'patientVisit',
				type: ModelRelationType.ONE,
				name: 'patientVisitId',
				// % protected region % [Customise your label for Patient Visit here] off begin
				label: 'Patient Visit',
				// % protected region % [Customise your label for Patient Visit here] end
				entityName: 'PatientVisitModel',
				// % protected region % [Customise your display name for Patient Visit here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'visitNumber',
				// % protected region % [Customise your display name for Patient Visit here] end
				validators: [
					// % protected region % [Add other validators for Patient Visit here] off begin
					// % protected region % [Add other validators for Patient Visit here] end
				],
				// % protected region % [Add any additional field for relation Patient Visit here] off begin
				// % protected region % [Add any additional field for relation Patient Visit here] end
			},
			{
				id: 'service',
				type: ModelRelationType.ONE,
				name: 'serviceId',
				// % protected region % [Customise your label for Service here] off begin
				label: 'Service',
				// % protected region % [Customise your label for Service here] end
				entityName: 'ServiceModel',
				// % protected region % [Customise your display name for Service here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'serviceNumber',
				// % protected region % [Customise your display name for Service here] end
				validators: [
					// % protected region % [Add other validators for Service here] off begin
					// % protected region % [Add other validators for Service here] end
				],
				// % protected region % [Add any additional field for relation Service here] off begin
				// % protected region % [Add any additional field for relation Service here] end
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
				id: 'requestedBy',
				type: ModelRelationType.ONE,
				name: 'requestedById',
				// % protected region % [Customise your label for Requested By here] off begin
				label: 'Requested By',
				// % protected region % [Customise your label for Requested By here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Requested By here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Requested By here] end
				validators: [
					// % protected region % [Add other validators for Requested By here] off begin
					// % protected region % [Add other validators for Requested By here] end
				],
				// % protected region % [Add any additional field for relation Requested By here] off begin
				// % protected region % [Add any additional field for relation Requested By here] end
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
				case 'registrationNumber':
					break;
				case 'scheduledDate':
					break;
				case 'queueNo':
					break;
				case 'registrationStatus':
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
	static deepParse(data: string | { [K in keyof RegistrationModel]?: RegistrationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new RegistrationModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.bpjsPRBDetail) {
			currentModel.bpjsPRBDetailId = json.bpjsPRBDetail.id;
			returned = _.union(returned, BpjsPRBDetailModel.deepParse(json.bpjsPRBDetail));
		}

		// Outgoing one to one
		if (json.bpjsPcareRegistrations) {
			currentModel.bpjsPcareRegistrationsId = json.bpjsPcareRegistrations.id;
			returned = _.union(returned, BpjsPcareRegistrationsModel.deepParse(json.bpjsPcareRegistrations));
		}

		// Outgoing one to one
		if (json.bpjsSEP) {
			currentModel.bpjsSEPId = json.bpjsSEP.id;
			returned = _.union(returned, BpjsSEPModel.deepParse(json.bpjsSEP));
		}

		// Outgoing one to one
		if (json.medicalCertificateDischargeResume) {
			currentModel.medicalCertificateDischargeResumeId = json.medicalCertificateDischargeResume.id;
			returned = _.union(returned, MedicalCertificateDischargeResumeModel.deepParse(json.medicalCertificateDischargeResume));
		}

		// Outgoing one to one
		if (json.medicalCertificateBirth) {
			currentModel.medicalCertificateBirthId = json.medicalCertificateBirth.id;
			returned = _.union(returned, MedicalCertificateBirthModel.deepParse(json.medicalCertificateBirth));
		}

		// Outgoing one to one
		if (json.medicalCertificateHospitalization) {
			currentModel.medicalCertificateHospitalizationId = json.medicalCertificateHospitalization.id;
			returned = _.union(returned, MedicalCertificateHospitalizationModel.deepParse(json.medicalCertificateHospitalization));
		}

		// Outgoing one to one
		if (json.medicalCertificateMedicalAttendance) {
			currentModel.medicalCertificateMedicalAttendanceId = json.medicalCertificateMedicalAttendance.id;
			returned = _.union(returned, MedicalCertificateMedicalAttendanceModel.deepParse(json.medicalCertificateMedicalAttendance));
		}

		// Outgoing one to one
		if (json.medicalCertificateMentalHealth) {
			currentModel.medicalCertificateMentalHealthId = json.medicalCertificateMentalHealth.id;
			returned = _.union(returned, MedicalCertificateMentalHealthModel.deepParse(json.medicalCertificateMentalHealth));
		}

		// Outgoing one to one
		if (json.medicalCertificatePhysicalHealth) {
			currentModel.medicalCertificatePhysicalHealthId = json.medicalCertificatePhysicalHealth.id;
			returned = _.union(returned, MedicalCertificatePhysicalHealthModel.deepParse(json.medicalCertificatePhysicalHealth));
		}

		// Outgoing one to one
		if (json.medicalCertificateRestrictedWork) {
			currentModel.medicalCertificateRestrictedWorkId = json.medicalCertificateRestrictedWork.id;
			returned = _.union(returned, MedicalCertificateRestrictedWorkModel.deepParse(json.medicalCertificateRestrictedWork));
		}

		// Outgoing one to one
		if (json.medicalCertificateSickLeave) {
			currentModel.medicalCertificateSickLeaveId = json.medicalCertificateSickLeave.id;
			returned = _.union(returned, MedicalCertificateSickLeaveModel.deepParse(json.medicalCertificateSickLeave));
		}

		// Outgoing one to one
		if (json.medicalExaminationRecord) {
			currentModel.medicalExaminationRecordId = json.medicalExaminationRecord.id;
			returned = _.union(returned, MedicalExaminationRecordModel.deepParse(json.medicalExaminationRecord));
		}

		// Outgoing one to one
		if (json.pcareExamination) {
			currentModel.pcareExaminationId = json.pcareExamination.id;
			returned = _.union(returned, PcareExaminationModel.deepParse(json.pcareExamination));
		}

		// Outgoing one to one
		if (json.sep) {
			currentModel.sepId = json.sep.id;
			returned = _.union(returned, SepModel.deepParse(json.sep));
		}

		// Incoming one to one
		if (json.diagnosticStaffExaminationSummary) {
			currentModel.diagnosticStaffExaminationSummaryId = json.diagnosticStaffExaminationSummary.id;
			returned = _.union(returned, DiagnosticStaffExaminationSummaryModel.deepParse(json.diagnosticStaffExaminationSummary));
		}

		// Incoming one to many
		if (json.admissionICD10) {
			currentModel.admissionICD10Id = json.admissionICD10.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.admissionICD10));
		}

		// Incoming one to many
		if (json.admissionICD9CM) {
			currentModel.admissionICD9CMId = json.admissionICD9CM.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.admissionICD9CM));
		}

		// Incoming one to many
		if (json.dismissalReferringFacility) {
			currentModel.dismissalReferringFacilityId = json.dismissalReferringFacility.id;
			returned = _.union(returned, HealthFacilityModel.deepParse(json.dismissalReferringFacility));
		}

		// Incoming one to many
		if (json.dismissalReferringStaff) {
			currentModel.dismissalReferringStaffId = json.dismissalReferringStaff.id;
			returned = _.union(returned, StaffModel.deepParse(json.dismissalReferringStaff));
		}

		// Incoming one to many
		if (json.referringUnit) {
			currentModel.referringUnitId = json.referringUnit.id;
			returned = _.union(returned, ServiceModel.deepParse(json.referringUnit));
		}

		// Incoming one to many
		if (json.referringFacility) {
			currentModel.referringFacilityId = json.referringFacility.id;
			returned = _.union(returned, HealthFacilityModel.deepParse(json.referringFacility));
		}

		// Incoming one to many
		if (json.bedFacility) {
			currentModel.bedFacilityId = json.bedFacility.id;
			returned = _.union(returned, BedFacilityModel.deepParse(json.bedFacility));
		}

		// Incoming one to many
		if (json.patientVisit) {
			currentModel.patientVisitId = json.patientVisit.id;
			returned = _.union(returned, PatientVisitModel.deepParse(json.patientVisit));
		}

		// Incoming one to many
		if (json.service) {
			currentModel.serviceId = json.service.id;
			returned = _.union(returned, ServiceModel.deepParse(json.service));
		}

		// Incoming one to many
		if (json.staff) {
			currentModel.staffId = json.staff.id;
			returned = _.union(returned, StaffModel.deepParse(json.staff));
		}

		// Incoming one to many
		if (json.requestedBy) {
			currentModel.requestedById = json.requestedBy.id;
			returned = _.union(returned, StaffModel.deepParse(json.requestedBy));
		}

		// Outgoing one to many
		if (json.bedReserves) {
			currentModel.bedReservesIds = json.bedReserves.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bedReserves.map(model => BedReserveModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.diagnosticExaminationResults) {
			currentModel.diagnosticExaminationResultsIds = json.diagnosticExaminationResults.map(model => model.id);
			returned = _.union(returned, _.flatten(json.diagnosticExaminationResults.map(model => DiagnosticExaminationResultsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.fluidBalanceDetails) {
			currentModel.fluidBalanceDetailsIds = json.fluidBalanceDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.fluidBalanceDetails.map(model => FluidBalanceDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.informedConsents) {
			currentModel.informedConsentsIds = json.informedConsents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.informedConsents.map(model => InformedConsentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.invoiceItems) {
			currentModel.invoiceItemsIds = json.invoiceItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoiceItems.map(model => InvoiceItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalFees) {
			currentModel.medicalFeesIds = json.medicalFees.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalFees.map(model => MedicalFeeModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicationHeaders) {
			currentModel.medicationHeadersIds = json.medicationHeaders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationHeaders.map(model => MedicationHeaderModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.patientVitalInformations) {
			currentModel.patientVitalInformationsIds = json.patientVitalInformations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.patientVitalInformations.map(model => PatientVitalInformationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.prescriptionHeaders) {
			currentModel.prescriptionHeadersIds = json.prescriptionHeaders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.prescriptionHeaders.map(model => PrescriptionHeaderModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.sampleCollectionInformations) {
			currentModel.sampleCollectionInformationsIds = json.sampleCollectionInformations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.sampleCollectionInformations.map(model => SampleCollectionInformationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.vaccinationOrders) {
			currentModel.vaccinationOrdersIds = json.vaccinationOrders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.vaccinationOrders.map(model => VaccinationOrderModel.deepParse(model))));
		}
		// Incoming many to many
		if (json.examinationItems) {
			currentModel.examinationItemsIds = json.examinationItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.examinationItems.map(model => ExaminationItemModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let registrationModel = new RegistrationModel(data);`
	 *
	 * @param data The input data to be initialised as the RegistrationModel,
	 *    it is expected as a JSON string or as a nullable RegistrationModel.
	 */
	constructor(data?: string | Partial<RegistrationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<RegistrationModel>
				: data;

			this.registrationNumber = json.registrationNumber;
			if (json.scheduledDate) {
				this.scheduledDate = new Date(json.scheduledDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.scheduledDate = json.scheduledDate;
			}
			if (json.actualInDate) {
				this.actualInDate = new Date(json.actualInDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.actualInDate = json.actualInDate;
			}
			if (json.dismissalDate) {
				this.dismissalDate = new Date(json.dismissalDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dismissalDate = json.dismissalDate;
			}
			this.dismissalType = json.dismissalType;
			this.queueNo = json.queueNo;
			this.duration = json.duration;
			this.treatmentClass = json.treatmentClass;
			this.bookedTreatmentClass = json.bookedTreatmentClass;
			this.shift = json.shift;
			this.cito = json.cito;
			this.oneDayCare = json.oneDayCare;
			this.referral = json.referral;
			this.registrationStatus = json.registrationStatus;
			this.referralType = json.referralType;
			this.purpose = json.purpose;
			this.referralNotes = json.referralNotes;
			this.supportingDocument = json.supportingDocument?.map(item => new FileModel(item));
			this.admissionDiagnosis = json.admissionDiagnosis;
			this.printWristband = json.printWristband?.map(item => new FileModel(item));
			this.printLabel = json.printLabel?.map(item => new FileModel(item));
			if (json.uploadedDateTime) {
				this.uploadedDateTime = new Date(json.uploadedDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.uploadedDateTime = json.uploadedDateTime;
			}
			this.visitStatus = json.visitStatus;
			this.instruction = json.instruction;
			this.isAnAppointment = json.isAnAppointment;
			this.referralNumber = json.referralNumber;
			this.notes = json.notes;
			this.kodepoli = json.kodepoli;
			this.deathCertificateNo = json.deathCertificateNo;
			if (json.timeOfDeath) {
				this.timeOfDeath = new Date(json.timeOfDeath);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.timeOfDeath = json.timeOfDeath;
			}
			this.dismissalReferral = json.dismissalReferral;
			this.dismissalReferralDetail = json.dismissalReferralDetail;
			this.dismissalReferralType = json.dismissalReferralType;
			this.dismissalReferringNotes = json.dismissalReferringNotes;
			this.patientIsReferredBack = json.patientIsReferredBack;
			this.mcuPackage = json.mcuPackage;
			this.parentRegistrationNumber = json.parentRegistrationNumber;
			this.isUnknownPatient = json.isUnknownPatient;
			this.otherReferredFacility = json.otherReferredFacility;
			this.otherReferredStaff = json.otherReferredStaff;
			this.doctorScheduleDetailId = json.doctorScheduleDetailId;
			this.bpjsPRBDetailId = json.bpjsPRBDetailId;
			this.bpjsPRBDetail = json.bpjsPRBDetail;
			this.bpjsPcareRegistrationsId = json.bpjsPcareRegistrationsId;
			this.bpjsPcareRegistrations = json.bpjsPcareRegistrations;
			this.bpjsSEPId = json.bpjsSEPId;
			this.bpjsSEP = json.bpjsSEP;
			this.medicalCertificateDischargeResumeId = json.medicalCertificateDischargeResumeId;
			this.medicalCertificateDischargeResume = json.medicalCertificateDischargeResume;
			this.medicalCertificateBirthId = json.medicalCertificateBirthId;
			this.medicalCertificateBirth = json.medicalCertificateBirth;
			this.medicalCertificateHospitalizationId = json.medicalCertificateHospitalizationId;
			this.medicalCertificateHospitalization = json.medicalCertificateHospitalization;
			this.medicalCertificateMedicalAttendanceId = json.medicalCertificateMedicalAttendanceId;
			this.medicalCertificateMedicalAttendance = json.medicalCertificateMedicalAttendance;
			this.medicalCertificateMentalHealthId = json.medicalCertificateMentalHealthId;
			this.medicalCertificateMentalHealth = json.medicalCertificateMentalHealth;
			this.medicalCertificatePhysicalHealthId = json.medicalCertificatePhysicalHealthId;
			this.medicalCertificatePhysicalHealth = json.medicalCertificatePhysicalHealth;
			this.medicalCertificateRestrictedWorkId = json.medicalCertificateRestrictedWorkId;
			this.medicalCertificateRestrictedWork = json.medicalCertificateRestrictedWork;
			this.medicalCertificateSickLeaveId = json.medicalCertificateSickLeaveId;
			this.medicalCertificateSickLeave = json.medicalCertificateSickLeave;
			this.medicalExaminationRecordId = json.medicalExaminationRecordId;
			this.medicalExaminationRecord = json.medicalExaminationRecord;
			this.pcareExaminationId = json.pcareExaminationId;
			this.pcareExamination = json.pcareExamination;
			this.sepId = json.sepId;
			this.sep = json.sep;
			this.diagnosticStaffExaminationSummaryId = json.diagnosticStaffExaminationSummaryId;
			this.diagnosticStaffExaminationSummary = json.diagnosticStaffExaminationSummary;
			this.admissionICD10Id = json.admissionICD10Id;
			this.admissionICD10 = json.admissionICD10;
			this.admissionICD9CMId = json.admissionICD9CMId;
			this.admissionICD9CM = json.admissionICD9CM;
			this.dismissalReferringFacilityId = json.dismissalReferringFacilityId;
			this.dismissalReferringFacility = json.dismissalReferringFacility;
			this.dismissalReferringStaffId = json.dismissalReferringStaffId;
			this.dismissalReferringStaff = json.dismissalReferringStaff;
			this.referringUnitId = json.referringUnitId;
			this.referringUnit = json.referringUnit;
			this.referringFacilityId = json.referringFacilityId;
			this.referringFacility = json.referringFacility;
			this.bedFacilityId = json.bedFacilityId;
			this.bedFacility = json.bedFacility;
			this.patientVisitId = json.patientVisitId;
			this.patientVisit = json.patientVisit;
			this.serviceId = json.serviceId;
			this.service = json.service;
			this.staffId = json.staffId;
			this.staff = json.staff;
			this.requestedById = json.requestedById;
			this.requestedBy = json.requestedBy;
			this.bedReservesIds = json.bedReservesIds;
			this.bedReserves = json.bedReserves;
			this.diagnosticExaminationResultsIds = json.diagnosticExaminationResultsIds;
			this.diagnosticExaminationResults = json.diagnosticExaminationResults;
			this.fluidBalanceDetailsIds = json.fluidBalanceDetailsIds;
			this.fluidBalanceDetails = json.fluidBalanceDetails;
			this.informedConsentsIds = json.informedConsentsIds;
			this.informedConsents = json.informedConsents;
			this.invoiceItemsIds = json.invoiceItemsIds;
			this.invoiceItems = json.invoiceItems;
			this.medicalFeesIds = json.medicalFeesIds;
			this.medicalFees = json.medicalFees;
			this.medicationHeadersIds = json.medicationHeadersIds;
			this.medicationHeaders = json.medicationHeaders;
			this.patientVitalInformationsIds = json.patientVitalInformationsIds;
			this.patientVitalInformations = json.patientVitalInformations;
			this.prescriptionHeadersIds = json.prescriptionHeadersIds;
			this.prescriptionHeaders = json.prescriptionHeaders;
			this.sampleCollectionInformationsIds = json.sampleCollectionInformationsIds;
			this.sampleCollectionInformations = json.sampleCollectionInformations;
			this.vaccinationOrdersIds = json.vaccinationOrdersIds;
			this.vaccinationOrders = json.vaccinationOrders;
			this.examinationItemsIds = json.examinationItemsIds;
			this.examinationItems = json.examinationItems;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			registrationNumber: this.registrationNumber,
			scheduledDate: this.scheduledDate,
			actualInDate: this.actualInDate,
			dismissalDate: this.dismissalDate,
			dismissalType: this.dismissalType,
			queueNo: this.queueNo,
			duration: this.duration,
			treatmentClass: this.treatmentClass,
			bookedTreatmentClass: this.bookedTreatmentClass,
			shift: this.shift,
			cito: this.cito,
			oneDayCare: this.oneDayCare,
			referral: this.referral,
			registrationStatus: this.registrationStatus,
			referralType: this.referralType,
			purpose: this.purpose,
			referralNotes: this.referralNotes,
			supportingDocument: this.supportingDocument,
			admissionDiagnosis: this.admissionDiagnosis,
			printWristband: this.printWristband,
			printLabel: this.printLabel,
			uploadedDateTime: this.uploadedDateTime,
			visitStatus: this.visitStatus,
			instruction: this.instruction,
			isAnAppointment: this.isAnAppointment,
			referralNumber: this.referralNumber,
			notes: this.notes,
			kodepoli: this.kodepoli,
			deathCertificateNo: this.deathCertificateNo,
			timeOfDeath: this.timeOfDeath,
			dismissalReferral: this.dismissalReferral,
			dismissalReferralDetail: this.dismissalReferralDetail,
			dismissalReferralType: this.dismissalReferralType,
			dismissalReferringNotes: this.dismissalReferringNotes,
			patientIsReferredBack: this.patientIsReferredBack,
			mcuPackage: this.mcuPackage,
			parentRegistrationNumber: this.parentRegistrationNumber,
			isUnknownPatient: this.isUnknownPatient,
			otherReferredFacility: this.otherReferredFacility,
			otherReferredStaff: this.otherReferredStaff,
			doctorScheduleDetailId: this.doctorScheduleDetailId,
			bpjsPRBDetailId: this.bpjsPRBDetailId,
			bpjsPcareRegistrationsId: this.bpjsPcareRegistrationsId,
			bpjsSEPId: this.bpjsSEPId,
			medicalCertificateDischargeResumeId: this.medicalCertificateDischargeResumeId,
			medicalCertificateBirthId: this.medicalCertificateBirthId,
			medicalCertificateHospitalizationId: this.medicalCertificateHospitalizationId,
			medicalCertificateMedicalAttendanceId: this.medicalCertificateMedicalAttendanceId,
			medicalCertificateMentalHealthId: this.medicalCertificateMentalHealthId,
			medicalCertificatePhysicalHealthId: this.medicalCertificatePhysicalHealthId,
			medicalCertificateRestrictedWorkId: this.medicalCertificateRestrictedWorkId,
			medicalCertificateSickLeaveId: this.medicalCertificateSickLeaveId,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			pcareExaminationId: this.pcareExaminationId,
			sepId: this.sepId,
			diagnosticStaffExaminationSummaryId: this.diagnosticStaffExaminationSummaryId,
			admissionICD10Id: this.admissionICD10Id,
			admissionICD9CMId: this.admissionICD9CMId,
			dismissalReferringFacilityId: this.dismissalReferringFacilityId,
			dismissalReferringStaffId: this.dismissalReferringStaffId,
			referringUnitId: this.referringUnitId,
			referringFacilityId: this.referringFacilityId,
			bedFacilityId: this.bedFacilityId,
			patientVisitId: this.patientVisitId,
			serviceId: this.serviceId,
			staffId: this.staffId,
			requestedById: this.requestedById,
			bedReservesIds: this.bedReservesIds,
			diagnosticExaminationResultsIds: this.diagnosticExaminationResultsIds,
			fluidBalanceDetailsIds: this.fluidBalanceDetailsIds,
			informedConsentsIds: this.informedConsentsIds,
			invoiceItemsIds: this.invoiceItemsIds,
			medicalFeesIds: this.medicalFeesIds,
			medicationHeadersIds: this.medicationHeadersIds,
			patientVitalInformationsIds: this.patientVitalInformationsIds,
			prescriptionHeadersIds: this.prescriptionHeadersIds,
			sampleCollectionInformationsIds: this.sampleCollectionInformationsIds,
			vaccinationOrdersIds: this.vaccinationOrdersIds,
			examinationItemsIds: this.examinationItemsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		RegistrationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): RegistrationModel {
		let newModelJson = this.toJSON();

		if (updates.registrationNumber) {
			newModelJson.registrationNumber = updates.registrationNumber;
		}

		if (updates.scheduledDate) {
			newModelJson.scheduledDate = updates.scheduledDate;
		}

		if (updates.actualInDate) {
			newModelJson.actualInDate = updates.actualInDate;
		}

		if (updates.dismissalDate) {
			newModelJson.dismissalDate = updates.dismissalDate;
		}

		if (updates.dismissalType) {
			newModelJson.dismissalType = updates.dismissalType;
		}

		if (updates.queueNo) {
			newModelJson.queueNo = updates.queueNo;
		}

		if (updates.duration) {
			newModelJson.duration = updates.duration;
		}

		if (updates.treatmentClass) {
			newModelJson.treatmentClass = updates.treatmentClass;
		}

		if (updates.bookedTreatmentClass) {
			newModelJson.bookedTreatmentClass = updates.bookedTreatmentClass;
		}

		if (updates.shift) {
			newModelJson.shift = updates.shift;
		}

		if (updates.cito) {
			newModelJson.cito = updates.cito;
		}

		if (updates.oneDayCare) {
			newModelJson.oneDayCare = updates.oneDayCare;
		}

		if (updates.referral) {
			newModelJson.referral = updates.referral;
		}

		if (updates.registrationStatus) {
			newModelJson.registrationStatus = updates.registrationStatus;
		}

		if (updates.referralType) {
			newModelJson.referralType = updates.referralType;
		}

		if (updates.purpose) {
			newModelJson.purpose = updates.purpose;
		}

		if (updates.referralNotes) {
			newModelJson.referralNotes = updates.referralNotes;
		}

		if (updates.supportingDocument) {
			newModelJson.supportingDocument = updates.supportingDocument;
		}

		if (updates.admissionDiagnosis) {
			newModelJson.admissionDiagnosis = updates.admissionDiagnosis;
		}

		if (updates.printWristband) {
			newModelJson.printWristband = updates.printWristband;
		}

		if (updates.printLabel) {
			newModelJson.printLabel = updates.printLabel;
		}

		if (updates.uploadedDateTime) {
			newModelJson.uploadedDateTime = updates.uploadedDateTime;
		}

		if (updates.visitStatus) {
			newModelJson.visitStatus = updates.visitStatus;
		}

		if (updates.instruction) {
			newModelJson.instruction = updates.instruction;
		}

		if (updates.isAnAppointment) {
			newModelJson.isAnAppointment = updates.isAnAppointment;
		}

		if (updates.referralNumber) {
			newModelJson.referralNumber = updates.referralNumber;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.kodepoli) {
			newModelJson.kodepoli = updates.kodepoli;
		}

		if (updates.deathCertificateNo) {
			newModelJson.deathCertificateNo = updates.deathCertificateNo;
		}

		if (updates.timeOfDeath) {
			newModelJson.timeOfDeath = updates.timeOfDeath;
		}

		if (updates.dismissalReferral) {
			newModelJson.dismissalReferral = updates.dismissalReferral;
		}

		if (updates.dismissalReferralDetail) {
			newModelJson.dismissalReferralDetail = updates.dismissalReferralDetail;
		}

		if (updates.dismissalReferralType) {
			newModelJson.dismissalReferralType = updates.dismissalReferralType;
		}

		if (updates.dismissalReferringNotes) {
			newModelJson.dismissalReferringNotes = updates.dismissalReferringNotes;
		}

		if (updates.patientIsReferredBack) {
			newModelJson.patientIsReferredBack = updates.patientIsReferredBack;
		}

		if (updates.mcuPackage) {
			newModelJson.mcuPackage = updates.mcuPackage;
		}

		if (updates.parentRegistrationNumber) {
			newModelJson.parentRegistrationNumber = updates.parentRegistrationNumber;
		}

		if (updates.isUnknownPatient) {
			newModelJson.isUnknownPatient = updates.isUnknownPatient;
		}

		if (updates.otherReferredFacility) {
			newModelJson.otherReferredFacility = updates.otherReferredFacility;
		}

		if (updates.otherReferredStaff) {
			newModelJson.otherReferredStaff = updates.otherReferredStaff;
		}

		if (updates.doctorScheduleDetailId) {
			newModelJson.doctorScheduleDetailId = updates.doctorScheduleDetailId;
		}

		if (updates.bpjsPRBDetailId) {
			newModelJson.bpjsPRBDetailId = updates.bpjsPRBDetailId;
		}

		if (updates.bpjsPcareRegistrationsId) {
			newModelJson.bpjsPcareRegistrationsId = updates.bpjsPcareRegistrationsId;
		}

		if (updates.bpjsSEPId) {
			newModelJson.bpjsSEPId = updates.bpjsSEPId;
		}

		if (updates.medicalCertificateDischargeResumeId) {
			newModelJson.medicalCertificateDischargeResumeId = updates.medicalCertificateDischargeResumeId;
		}

		if (updates.medicalCertificateBirthId) {
			newModelJson.medicalCertificateBirthId = updates.medicalCertificateBirthId;
		}

		if (updates.medicalCertificateHospitalizationId) {
			newModelJson.medicalCertificateHospitalizationId = updates.medicalCertificateHospitalizationId;
		}

		if (updates.medicalCertificateMedicalAttendanceId) {
			newModelJson.medicalCertificateMedicalAttendanceId = updates.medicalCertificateMedicalAttendanceId;
		}

		if (updates.medicalCertificateMentalHealthId) {
			newModelJson.medicalCertificateMentalHealthId = updates.medicalCertificateMentalHealthId;
		}

		if (updates.medicalCertificatePhysicalHealthId) {
			newModelJson.medicalCertificatePhysicalHealthId = updates.medicalCertificatePhysicalHealthId;
		}

		if (updates.medicalCertificateRestrictedWorkId) {
			newModelJson.medicalCertificateRestrictedWorkId = updates.medicalCertificateRestrictedWorkId;
		}

		if (updates.medicalCertificateSickLeaveId) {
			newModelJson.medicalCertificateSickLeaveId = updates.medicalCertificateSickLeaveId;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		if (updates.pcareExaminationId) {
			newModelJson.pcareExaminationId = updates.pcareExaminationId;
		}

		if (updates.sepId) {
			newModelJson.sepId = updates.sepId;
		}

		if (updates.diagnosticStaffExaminationSummaryId) {
			newModelJson.diagnosticStaffExaminationSummaryId = updates.diagnosticStaffExaminationSummaryId;
		}

		if (updates.admissionICD10Id) {
			newModelJson.admissionICD10Id = updates.admissionICD10Id;
		}

		if (updates.admissionICD9CMId) {
			newModelJson.admissionICD9CMId = updates.admissionICD9CMId;
		}

		if (updates.dismissalReferringFacilityId) {
			newModelJson.dismissalReferringFacilityId = updates.dismissalReferringFacilityId;
		}

		if (updates.dismissalReferringStaffId) {
			newModelJson.dismissalReferringStaffId = updates.dismissalReferringStaffId;
		}

		if (updates.referringUnitId) {
			newModelJson.referringUnitId = updates.referringUnitId;
		}

		if (updates.referringFacilityId) {
			newModelJson.referringFacilityId = updates.referringFacilityId;
		}

		if (updates.bedFacilityId) {
			newModelJson.bedFacilityId = updates.bedFacilityId;
		}

		if (updates.patientVisitId) {
			newModelJson.patientVisitId = updates.patientVisitId;
		}

		if (updates.serviceId) {
			newModelJson.serviceId = updates.serviceId;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		if (updates.requestedById) {
			newModelJson.requestedById = updates.requestedById;
		}

		if (updates.bedReservesIds) {
			newModelJson.bedReservesIds = updates.bedReservesIds;
		}

		if (updates.diagnosticExaminationResultsIds) {
			newModelJson.diagnosticExaminationResultsIds = updates.diagnosticExaminationResultsIds;
		}

		if (updates.fluidBalanceDetailsIds) {
			newModelJson.fluidBalanceDetailsIds = updates.fluidBalanceDetailsIds;
		}

		if (updates.informedConsentsIds) {
			newModelJson.informedConsentsIds = updates.informedConsentsIds;
		}

		if (updates.invoiceItemsIds) {
			newModelJson.invoiceItemsIds = updates.invoiceItemsIds;
		}

		if (updates.medicalFeesIds) {
			newModelJson.medicalFeesIds = updates.medicalFeesIds;
		}

		if (updates.medicationHeadersIds) {
			newModelJson.medicationHeadersIds = updates.medicationHeadersIds;
		}

		if (updates.patientVitalInformationsIds) {
			newModelJson.patientVitalInformationsIds = updates.patientVitalInformationsIds;
		}

		if (updates.prescriptionHeadersIds) {
			newModelJson.prescriptionHeadersIds = updates.prescriptionHeadersIds;
		}

		if (updates.sampleCollectionInformationsIds) {
			newModelJson.sampleCollectionInformationsIds = updates.sampleCollectionInformationsIds;
		}

		if (updates.vaccinationOrdersIds) {
			newModelJson.vaccinationOrdersIds = updates.vaccinationOrdersIds;
		}

		if (updates.examinationItemsIds) {
			newModelJson.examinationItemsIds = updates.examinationItemsIds;
		}

		return new RegistrationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof RegistrationModel)) {
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
			} else if (['supportingDocument', 'printWristband', 'printLabel'].includes(key)) {;
				const thisFiles = JSON.stringify(thisValue);
				const otherFiles = JSON.stringify(otherValue);

				if (thisFiles !== otherFiles) {
					diff[key] = thisValue;
				}
			} else if (thisValue !== otherValue) {
				diff[key] = thisValue;
			}
		}

		return _.omit(diff, [
			'created',
			'modified',
			'bpjsPRBDetailId',
			'bpjsPRBDetail',
			'bpjsPcareRegistrationsId',
			'bpjsPcareRegistrations',
			'bpjsSEPId',
			'bpjsSEP',
			'medicalCertificateDischargeResumeId',
			'medicalCertificateDischargeResume',
			'medicalCertificateBirthId',
			'medicalCertificateBirth',
			'medicalCertificateHospitalizationId',
			'medicalCertificateHospitalization',
			'medicalCertificateMedicalAttendanceId',
			'medicalCertificateMedicalAttendance',
			'medicalCertificateMentalHealthId',
			'medicalCertificateMentalHealth',
			'medicalCertificatePhysicalHealthId',
			'medicalCertificatePhysicalHealth',
			'medicalCertificateRestrictedWorkId',
			'medicalCertificateRestrictedWork',
			'medicalCertificateSickLeaveId',
			'medicalCertificateSickLeave',
			'medicalExaminationRecordId',
			'medicalExaminationRecord',
			'pcareExaminationId',
			'pcareExamination',
			'sepId',
			'sep',
			'diagnosticStaffExaminationSummaryId',
			'diagnosticStaffExaminationSummary',
			'admissionICD10Id',
			'admissionICD10',
			'admissionICD9CMId',
			'admissionICD9CM',
			'dismissalReferringFacilityId',
			'dismissalReferringFacility',
			'dismissalReferringStaffId',
			'dismissalReferringStaff',
			'referringUnitId',
			'referringUnit',
			'referringFacilityId',
			'referringFacility',
			'bedFacilityId',
			'bedFacility',
			'patientVisitId',
			'patientVisit',
			'serviceId',
			'service',
			'staffId',
			'staff',
			'requestedById',
			'requestedBy',
			'bedReservesIds',
			'bedReserves',
			'diagnosticExaminationResultsIds',
			'diagnosticExaminationResults',
			'fluidBalanceDetailsIds',
			'fluidBalanceDetails',
			'informedConsentsIds',
			'informedConsents',
			'invoiceItemsIds',
			'invoiceItems',
			'medicalFeesIds',
			'medicalFees',
			'medicationHeadersIds',
			'medicationHeaders',
			'patientVitalInformationsIds',
			'patientVitalInformations',
			'prescriptionHeadersIds',
			'prescriptionHeaders',
			'sampleCollectionInformationsIds',
			'sampleCollectionInformations',
			'vaccinationOrdersIds',
			'vaccinationOrders',
			'examinationItemsIds',
			'examinationItems',
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
		if (!this.bpjsPRBDetail) {
			this.bpjsPRBDetailId = null;
		} else {
			this.bpjsPRBDetailId = this.bpjsPRBDetail.id;
		}

		if (!this.bpjsPcareRegistrations) {
			this.bpjsPcareRegistrationsId = null;
		} else {
			this.bpjsPcareRegistrationsId = this.bpjsPcareRegistrations.id;
		}

		if (!this.bpjsSEP) {
			this.bpjsSEPId = null;
		} else {
			this.bpjsSEPId = this.bpjsSEP.id;
		}

		if (!this.medicalCertificateDischargeResume) {
			this.medicalCertificateDischargeResumeId = null;
		} else {
			this.medicalCertificateDischargeResumeId = this.medicalCertificateDischargeResume.id;
		}

		if (!this.medicalCertificateBirth) {
			this.medicalCertificateBirthId = null;
		} else {
			this.medicalCertificateBirthId = this.medicalCertificateBirth.id;
		}

		if (!this.medicalCertificateHospitalization) {
			this.medicalCertificateHospitalizationId = null;
		} else {
			this.medicalCertificateHospitalizationId = this.medicalCertificateHospitalization.id;
		}

		if (!this.medicalCertificateMedicalAttendance) {
			this.medicalCertificateMedicalAttendanceId = null;
		} else {
			this.medicalCertificateMedicalAttendanceId = this.medicalCertificateMedicalAttendance.id;
		}

		if (!this.medicalCertificateMentalHealth) {
			this.medicalCertificateMentalHealthId = null;
		} else {
			this.medicalCertificateMentalHealthId = this.medicalCertificateMentalHealth.id;
		}

		if (!this.medicalCertificatePhysicalHealth) {
			this.medicalCertificatePhysicalHealthId = null;
		} else {
			this.medicalCertificatePhysicalHealthId = this.medicalCertificatePhysicalHealth.id;
		}

		if (!this.medicalCertificateRestrictedWork) {
			this.medicalCertificateRestrictedWorkId = null;
		} else {
			this.medicalCertificateRestrictedWorkId = this.medicalCertificateRestrictedWork.id;
		}

		if (!this.medicalCertificateSickLeave) {
			this.medicalCertificateSickLeaveId = null;
		} else {
			this.medicalCertificateSickLeaveId = this.medicalCertificateSickLeave.id;
		}

		if (!this.medicalExaminationRecord) {
			this.medicalExaminationRecordId = null;
		} else {
			this.medicalExaminationRecordId = this.medicalExaminationRecord.id;
		}

		if (!this.pcareExamination) {
			this.pcareExaminationId = null;
		} else {
			this.pcareExaminationId = this.pcareExamination.id;
		}

		if (!this.sep) {
			this.sepId = null;
		} else {
			this.sepId = this.sep.id;
		}

		if (!this.diagnosticStaffExaminationSummary) {
			this.diagnosticStaffExaminationSummaryId = null;
		} else {
			this.diagnosticStaffExaminationSummaryId = this.diagnosticStaffExaminationSummary.id;
		}

		if (!this.admissionICD10) {
			this.admissionICD10Id = null;
		} else {
			this.admissionICD10Id = this.admissionICD10.id;
		}

		if (!this.admissionICD9CM) {
			this.admissionICD9CMId = null;
		} else {
			this.admissionICD9CMId = this.admissionICD9CM.id;
		}

		if (!this.dismissalReferringFacility) {
			this.dismissalReferringFacilityId = null;
		} else {
			this.dismissalReferringFacilityId = this.dismissalReferringFacility.id;
		}

		if (!this.dismissalReferringStaff) {
			this.dismissalReferringStaffId = null;
		} else {
			this.dismissalReferringStaffId = this.dismissalReferringStaff.id;
		}

		if (!this.referringUnit) {
			this.referringUnitId = null;
		} else {
			this.referringUnitId = this.referringUnit.id;
		}

		if (!this.referringFacility) {
			this.referringFacilityId = null;
		} else {
			this.referringFacilityId = this.referringFacility.id;
		}

		if (!this.bedFacility) {
			this.bedFacilityId = null;
		} else {
			this.bedFacilityId = this.bedFacility.id;
		}

		if (!this.patientVisit) {
			this.patientVisitId = null;
		} else {
			this.patientVisitId = this.patientVisit.id;
		}

		if (!this.service) {
			this.serviceId = null;
		} else {
			this.serviceId = this.service.id;
		}

		if (!this.staff) {
			this.staffId = null;
		} else {
			this.staffId = this.staff.id;
		}

		if (!this.requestedBy) {
			this.requestedById = null;
		} else {
			this.requestedById = this.requestedBy.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
