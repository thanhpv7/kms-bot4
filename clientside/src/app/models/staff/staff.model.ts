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
import {BloodTypeEnum, bloodTypeEnumArray} from '../../enums/blood-type.enum';
import {RhesusEnum, rhesusEnumArray} from '../../enums/rhesus.enum';
import {AdministrationUserModel} from '../administrationUser/administration_user.model';
import {AdministratorModel} from '../administrator/administrator.model';
import {AmendmentDetailModel} from '../amendmentDetail/amendment_detail.model';
import {BpjsDoctorMappingModel} from '../bpjsDoctorMapping/bpjs_doctor_mapping.model';
import {CashReceiptModel} from '../cashReceipt/cash_receipt.model';
import {CashierUserModel} from '../cashierUser/cashier_user.model';
import {ClaimUserModel} from '../claimUser/claim_user.model';
import {CoTreatingDoctorModel} from '../coTreatingDoctor/co_treating_doctor.model';
import {DailyCareCPPTModel} from '../dailyCareCPPT/daily_care_cppt.model';
import {DeliveryMedicalExaminationRecordModel} from '../deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import {DeliveryProgressModel} from '../deliveryProgress/delivery_progress.model';
import {DiagnosticStaffExaminationSummaryModel} from '../diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model';
import {DiagnosticSupportUserModel} from '../diagnosticSupportUser/diagnostic_support_user.model';
import {DoctorScheduleModel} from '../doctorSchedule/doctor_schedule.model';
import {DoctorUserModel} from '../doctorUser/doctor_user.model';
import {FacilityUserModel} from '../facilityUser/facility_user.model';
import {FluidBalanceDetailModel} from '../fluidBalanceDetail/fluid_balance_detail.model';
import {HemodialysisMonitoringModel} from '../hemodialysisMonitoring/hemodialysis_monitoring.model';
import {HospitalBranchInformationModel} from '../hospitalBranchInformation/hospital_branch_information.model';
import {InformedConsentModel} from '../informedConsent/informed_consent.model';
import {InvoiceModel} from '../invoice/invoice.model';
import {McuPackageItemModel} from '../mcuPackageItem/mcu_package_item.model';
import {ManagementUserModel} from '../managementUser/management_user.model';
import {MedicalCertificateDischargeResumeModel} from '../medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import {MedicalCertificateBirthModel} from '../medicalCertificateBirth/medical_certificate_birth.model';
import {MedicalCertificateHospitalizationModel} from '../medicalCertificateHospitalization/medical_certificate_hospitalization.model';
import {MedicalCertificateMedicalAttendanceModel} from '../medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model';
import {MedicalCertificateMentalHealthModel} from '../medicalCertificateMentalHealth/medical_certificate_mental_health.model';
import {MedicalCertificatePhysicalHealthModel} from '../medicalCertificatePhysicalHealth/medical_certificate_physical_health.model';
import {MedicalCertificateRestrictedWorkModel} from '../medicalCertificateRestrictedWork/medical_certificate_restricted_work.model';
import {MedicalCertificateSickLeaveModel} from '../medicalCertificateSickLeave/medical_certificate_sick_leave.model';
import {MedicalExaminationRecordModel} from '../medicalExaminationRecord/medical_examination_record.model';
import {MedicalExaminationRecordDischargeSummaryModel} from '../medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model';
import {MedicalRecordUserModel} from '../medicalRecordUser/medical_record_user.model';
import {MedicalTranscriberUserModel} from '../medicalTranscriberUser/medical_transcriber_user.model';
import {MedicationAdministeredHistoryModel} from '../medicationAdministeredHistory/medication_administered_history.model';
import {MedicationHeaderModel} from '../medicationHeader/medication_header.model';
import {NewbornDetailModel} from '../newbornDetail/newborn_detail.model';
import {NurseUserModel} from '../nurseUser/nurse_user.model';
import {OperatingTheaterMedicalExaminationRecordModel} from '../operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import {PcareDokterModel} from '../pcareDokter/pcare_dokter.model';
import {PatientConsentModel} from '../patientConsent/patient_consent.model';
import {PatientVitalInformationModel} from '../patientVitalInformation/patient_vital_information.model';
import {PharmacyUserModel} from '../pharmacyUser/pharmacy_user.model';
import {PreoperativeRecordsModel} from '../preoperativeRecords/preoperative_records.model';
import {PrescriptionHeaderModel} from '../prescriptionHeader/prescription_header.model';
import {ProcessWorkflowModel} from '../processWorkflow/process_workflow.model';
import {PurchasingUserModel} from '../purchasingUser/purchasing_user.model';
import {RegistrationModel} from '../registration/registration.model';
import {RegistrationUserModel} from '../registrationUser/registration_user.model';
import {RoomTransferModel} from '../roomTransfer/room_transfer.model';
import {SampleCollectionItemsModel} from '../sampleCollectionItems/sample_collection_items.model';
import {ServiceModel} from '../service/service.model';
import {SystemAdminUserModel} from '../systemAdminUser/system_admin_user.model';
import {TransferOrderStockDetailModel} from '../transferOrderStockDetail/transfer_order_stock_detail.model';
import {VaccinationOrderModel} from '../vaccinationOrder/vaccination_order.model';
import {WarehouseUserModel} from '../warehouseUser/warehouse_user.model';
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
export class StaffModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'staffNumber',
		'firstName',
		'lastName',
		'staffType',
		'specialization',
		'education',
		'licenseNo',
		'letterOfReg',
		'gender',
		'employeeID',
		'defaultServiceNumber',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'staffNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'StaffModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return StaffModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Identifier for staff.
	 */
	staffNumber: string;

	/**
	 * The staff's first name..
	 */
	firstName: string;

	/**
	 * The staff's last name..
	 */
	lastName: string;

	/**
	 * Date of Birth of the staff..
	 */
	dateOfBirth: Date;

	/**
	 * The staff's type. Use Code from Reference Data where Type = STAFF_TYPE..
	 */
	staffType: string;

	/**
	 * The staff's specialization. Use Code of Reference Data where Type = STAFF_SPECIALIZATION..
	 */
	specialization: string;

	/**
	 * Staff Picture.
	 */
	staffPicture: FileModel[];

	/**
	 * Level of education of this staff. Use Code of Reference Data where Type = STAFF_EDUCATION..
	 */
	education: string;

	/**
	 * The staff's medical license number..
	 */
	licenseNo: string;

	/**
	 * Letter of Registration Number.
	 */
	letterOfReg: string;

	/**
	 * The staff's gender, get the Code from Reference Data where Type=GENDER. (Max Length: 20).
	 */
	gender: string;

	/**
	 * Employee ID (Max Length: 50).
	 */
	employeeID: string;

	/**
	 * Staff title, get the Code from Reference Data where Type=TITTLE. (Max Length: 20 chars).
	 */
	title: string;

	/**
	 * Default assigned Service to staff (Max Length: 50).
	 */
	defaultServiceNumber: string;

	/**
	 * The place where the patient was born. (Max Length: 250 chars).
	 */
	placeOfBirth: string;

	/**
	 * Religion, get the Code from Reference Data where Type=RELIGION. (Max Length: 20).
	 */
	religion: string;

	/**
	 * .
	 */
	address: string;

	/**
	 * Country, get the Code from Reference Data where Type=COUNTRY. (Max Length: 20 chars).
	 */
	country: string;

	/**
	 * State in a country, get the Code from Reference Data where Type=STATE. (Max Length: 20 chars).
	 */
	state: string;

	/**
	 * Regency in a country and under State, get the Code from Reference Data where Type=REGENCY. (Max Length: 20 chars).
	 */
	regency: string;

	/**
	 * District under Regency, get the Code from Reference Data where Type=DISTRICT. (Max Length: 20 chars).
	 */
	district: string;

	/**
	 * Home Phone No (Max Length: 50).
	 */
	homePhoneNo: string;

	/**
	 * Village information, get the Code from Reference Data where Type=VILLAGE. (Max Length: 20 chars).
	 */
	village: string;

	/**
	 * Post Code of patient address (Max Length: 20 chars).
	 */
	postcode: string;

	/**
	 * Office Phone No (Max Length: 50).
	 */
	officePhoneNumber: string;

	/**
	 * Personal Tax ID (Max Length: 50).
	 */
	taxIdentificationNo: string;

	/**
	 * Mobile Phone No (Max Length: 50).
	 */
	mobilePhoneNo: string;

	/**
	 * Other Notes (Max Length: 5000).
	 */
	otherNotes: string;

	/**
	 * Training/Course, get the Code from Reference Data where Type=STAFF_COURSE. (Max Length: 20).
	 */
	training: string;

	/**
	 * Data nationality, get the Code from Reference Data where Type=NATIONALITY. (Max Length: 20).
	 */
	nationality: string;

	/**
	 * Certification, get the Code from Reference Data where Type=STAFF_CERT. (Max Length: 20).
	 */
	certification: string;

	/**
	 * Extension No (Max Length: 50).
	 */
	extNo: string;

	/**
	 * Status of married of patient, get the Code from Reference Data where Type=MARITAL_STAT (Max Length: 20).
	 */
	maritalStatus: string;

	/**
	 * email (Max Length: 250).
	 */
	email: string;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=18, example=Sally}.
	 */
	bloodType: BloodTypeEnum;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=19, example=Sally}.
	 */
	rhesus: RhesusEnum;

	administratorId: string;

	administrator: AdministratorModel;

	bpjsDoctorMappingId: string;

	bpjsDoctorMapping: BpjsDoctorMappingModel;

	pcareDokterId: string;

	pcareDokter: PcareDokterModel;

	serviceId: string;

	service: ServiceModel;

	administrationUserId: string;

	administrationUser: AdministrationUserModel;

	cashierUserId: string;

	cashierUser: CashierUserModel;

	claimUserId: string;

	claimUser: ClaimUserModel;

	diagnosticSupportUserId: string;

	diagnosticSupportUser: DiagnosticSupportUserModel;

	doctorUserId: string;

	doctorUser: DoctorUserModel;

	facilityUserId: string;

	facilityUser: FacilityUserModel;

	managementUserId: string;

	managementUser: ManagementUserModel;

	medicalRecordUserId: string;

	medicalRecordUser: MedicalRecordUserModel;

	medicalTranscriberUserId: string;

	medicalTranscriberUser: MedicalTranscriberUserModel;

	nurseUserId: string;

	nurseUser: NurseUserModel;

	pharmacyUserId: string;

	pharmacyUser: PharmacyUserModel;

	purchasingUserId: string;

	purchasingUser: PurchasingUserModel;

	registrationUserId: string;

	registrationUser: RegistrationUserModel;

	systemAdminUserId: string;

	systemAdminUser: SystemAdminUserModel;

	warehouseUserId: string;

	warehouseUser: WarehouseUserModel;

	accompanyingConsentsIds: string[] = [];

	accompanyingConsents: InformedConsentModel[];

	amendmentDetailsIds: string[] = [];

	amendmentDetails: AmendmentDetailModel[];

	anesthesiaMedicalTranscriberIds: string[] = [];

	anesthesiaMedicalTranscriber: PreoperativeRecordsModel[];

	anesthesiologistIds: string[] = [];

	anesthesiologist: PreoperativeRecordsModel[];

	anesthesiologyNurseIds: string[] = [];

	anesthesiologyNurse: PreoperativeRecordsModel[];

	cashierStaffIds: string[] = [];

	cashierStaff: CashReceiptModel[];

	coTreatingDoctorsIds: string[] = [];

	coTreatingDoctors: CoTreatingDoctorModel[];

	dailyCareCPPTsCreatedByStaffIds: string[] = [];

	dailyCareCPPTsCreatedByStaff: DailyCareCPPTModel[];

	dailyCareCPPTsDoctorInChargeIds: string[] = [];

	dailyCareCPPTsDoctorInCharge: DailyCareCPPTModel[];

	dailyCareCPPTsMedicalTranscriberIds: string[] = [];

	dailyCareCPPTsMedicalTranscriber: DailyCareCPPTModel[];

	deliveryProgressesIds: string[] = [];

	deliveryProgresses: DeliveryProgressModel[];

	diagnosticStaffExaminationSummariesIds: string[] = [];

	diagnosticStaffExaminationSummaries: DiagnosticStaffExaminationSummaryModel[];

	dismissalReferringStaffIds: string[] = [];

	dismissalReferringStaff: RegistrationModel[];

	doctorSchedulesIds: string[] = [];

	doctorSchedules: DoctorScheduleModel[];

	doctorOnExaminationIds: string[] = [];

	doctorOnExamination: MedicalExaminationRecordModel[];

	fluidBalanceDetailsIds: string[] = [];

	fluidBalanceDetails: FluidBalanceDetailModel[];

	hemodialysisMonitoringsIds: string[] = [];

	hemodialysisMonitorings: HemodialysisMonitoringModel[];

	hospitalBranchInformationsIds: string[] = [];

	hospitalBranchInformations: HospitalBranchInformationModel[];

	informingConsentsIds: string[] = [];

	informingConsents: InformedConsentModel[];

	invoicesIds: string[] = [];

	invoices: InvoiceModel[];

	mcuPackageItemsIds: string[] = [];

	mcuPackageItems: McuPackageItemModel[];

	medicalCertificateDischargeResumesIds: string[] = [];

	medicalCertificateDischargeResumes: MedicalCertificateDischargeResumeModel[];

	medicalCertificateBirthsIds: string[] = [];

	medicalCertificateBirths: MedicalCertificateBirthModel[];

	medicalCertificateHospitalizationsIds: string[] = [];

	medicalCertificateHospitalizations: MedicalCertificateHospitalizationModel[];

	medicalExaminationRecordDischargeSummarysIds: string[] = [];

	medicalExaminationRecordDischargeSummarys: MedicalExaminationRecordDischargeSummaryModel[];

	medicalRecordTranscriberIds: string[] = [];

	medicalRecordTranscriber: MedicalExaminationRecordModel[];

	medicalStaffOfMedicalAttendancesCertificateIds: string[] = [];

	medicalStaffOfMedicalAttendancesCertificate: MedicalCertificateMedicalAttendanceModel[];

	medicalStaffOfMentalHealthsIds: string[] = [];

	medicalStaffOfMentalHealths: MedicalCertificateMentalHealthModel[];

	medicalStaffOfPhysicalHealthsIds: string[] = [];

	medicalStaffOfPhysicalHealths: MedicalCertificatePhysicalHealthModel[];

	medicalStaffOfRestrictedWorksCertificateIds: string[] = [];

	medicalStaffOfRestrictedWorksCertificate: MedicalCertificateRestrictedWorkModel[];

	medicalStaffOfSickLeavesCertificateIds: string[] = [];

	medicalStaffOfSickLeavesCertificate: MedicalCertificateSickLeaveModel[];

	medicationAdministeredHisotriesIds: string[] = [];

	medicationAdministeredHisotries: MedicationAdministeredHistoryModel[];

	medicationHeadersIds: string[] = [];

	medicationHeaders: MedicationHeaderModel[];

	midwivesIds: string[] = [];

	midwives: DeliveryMedicalExaminationRecordModel[];

	nurseIds: string[] = [];

	nurse: MedicalExaminationRecordModel[];

	nursingDetailSurgicalNursingIds: string[] = [];

	nursingDetailSurgicalNursing: OperatingTheaterMedicalExaminationRecordModel[];

	nursingDetailsAnesthesiaNursingIds: string[] = [];

	nursingDetailsAnesthesiaNursing: OperatingTheaterMedicalExaminationRecordModel[];

	patientConsentsIds: string[] = [];

	patientConsents: PatientConsentModel[];

	patientVitalInformationsIds: string[] = [];

	patientVitalInformations: PatientVitalInformationModel[];

	pediatricianInChargeIds: string[] = [];

	pediatricianInCharge: NewbornDetailModel[];

	prescriptionHeadersIds: string[] = [];

	prescriptionHeaders: PrescriptionHeaderModel[];

	processWorkflowLogsIds: string[] = [];

	processWorkflowLogs: ProcessWorkflowModel[];

	registrationsIds: string[] = [];

	registrations: RegistrationModel[];

	requestedByIds: string[] = [];

	requestedBy: RegistrationModel[];

	roomTransfersIds: string[] = [];

	roomTransfers: RoomTransferModel[];

	sampleCollectionStaffsIds: string[] = [];

	sampleCollectionStaffs: SampleCollectionItemsModel[];

	sampleDeliveryStaffsIds: string[] = [];

	sampleDeliveryStaffs: SampleCollectionItemsModel[];

	sampleProcessingStaffsIds: string[] = [];

	sampleProcessingStaffs: SampleCollectionItemsModel[];

	surgeonIds: string[] = [];

	surgeon: PreoperativeRecordsModel[];

	surgicalMedicalTranscriberIds: string[] = [];

	surgicalMedicalTranscriber: PreoperativeRecordsModel[];

	surgicalNurseIds: string[] = [];

	surgicalNurse: PreoperativeRecordsModel[];

	transferOrderStockDetailsIds: string[] = [];

	transferOrderStockDetails: TransferOrderStockDetailModel[];

	vaccinationOrdersIds: string[] = [];

	vaccinationOrders: VaccinationOrderModel[];

	servicesIds: string[] = [];

	services: ServiceModel[];

	modelPropGroups: { [s: string]: Group } = StaffModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'staffNumber',
				// % protected region % [Set displayName for Staff Number here] off begin
				displayName: 'Staff Number',
				// % protected region % [Set displayName for Staff Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Staff Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Staff Number here] end
				// % protected region % [Set isSensitive for Staff Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Staff Number here] end
				// % protected region % [Set readonly for Staff Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Staff Number here] end
				validators: [
					// % protected region % [Add other validators for Staff Number here] off begin
					// % protected region % [Add other validators for Staff Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Staff Number here] off begin
				// % protected region % [Add any additional model attribute properties for Staff Number here] end
			},
			{
				name: 'firstName',
				// % protected region % [Set displayName for First Name here] off begin
				displayName: 'First Name',
				// % protected region % [Set displayName for First Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for First Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for First Name here] end
				// % protected region % [Set isSensitive for First Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for First Name here] end
				// % protected region % [Set readonly for First Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for First Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for First Name here] off begin
					// % protected region % [Add other validators for First Name here] end
				],
				// % protected region % [Add any additional model attribute properties for First Name here] off begin
				// % protected region % [Add any additional model attribute properties for First Name here] end
			},
			{
				name: 'lastName',
				// % protected region % [Set displayName for Last Name here] off begin
				displayName: 'Last Name',
				// % protected region % [Set displayName for Last Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Last Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Last Name here] end
				// % protected region % [Set isSensitive for Last Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Last Name here] end
				// % protected region % [Set readonly for Last Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Last Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Last Name here] off begin
					// % protected region % [Add other validators for Last Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Name here] off begin
				// % protected region % [Add any additional model attribute properties for Last Name here] end
			},
			{
				name: 'dateOfBirth',
				// % protected region % [Set displayName for Date of Birth here] off begin
				displayName: 'Date of Birth',
				// % protected region % [Set displayName for Date of Birth here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Date of Birth here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Date of Birth here] end
				// % protected region % [Set isSensitive for Date of Birth here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date of Birth here] end
				// % protected region % [Set readonly for Date of Birth here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date of Birth here] end
				validators: [
					// % protected region % [Add other validators for Date of Birth here] off begin
					// % protected region % [Add other validators for Date of Birth here] end
				],
				// % protected region % [Add any additional model attribute properties for Date of Birth here] off begin
				// % protected region % [Add any additional model attribute properties for Date of Birth here] end
			},
			{
				name: 'staffType',
				// % protected region % [Set displayName for Staff Type here] off begin
				displayName: 'Staff Type',
				// % protected region % [Set displayName for Staff Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Staff Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Staff Type here] end
				// % protected region % [Set isSensitive for Staff Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Staff Type here] end
				// % protected region % [Set readonly for Staff Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Staff Type here] end
				validators: [
					// % protected region % [Add other validators for Staff Type here] off begin
					// % protected region % [Add other validators for Staff Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Staff Type here] off begin
				// % protected region % [Add any additional model attribute properties for Staff Type here] end
			},
			{
				name: 'specialization',
				// % protected region % [Set displayName for Specialization here] off begin
				displayName: 'Specialization',
				// % protected region % [Set displayName for Specialization here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Specialization here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Specialization here] end
				// % protected region % [Set isSensitive for Specialization here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Specialization here] end
				// % protected region % [Set readonly for Specialization here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Specialization here] end
				validators: [
					// % protected region % [Add other validators for Specialization here] off begin
					// % protected region % [Add other validators for Specialization here] end
				],
				// % protected region % [Add any additional model attribute properties for Specialization here] off begin
				// % protected region % [Add any additional model attribute properties for Specialization here] end
			},
			{
				name: 'staffPicture',
				// % protected region % [Set displayName for Staff Picture here] off begin
				displayName: 'Staff Picture',
				// % protected region % [Set displayName for Staff Picture here] end
				type: ModelPropertyType.FILE,
				// % protected region % [Set display element type for Staff Picture here] off begin
				elementType: ElementType.FILE,
				// % protected region % [Set display element type for Staff Picture here] end
				// % protected region % [Set isSensitive for Staff Picture here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Staff Picture here] end
				// % protected region % [Set readonly for Staff Picture here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Staff Picture here] end
				validators: [
					// % protected region % [Add other validators for Staff Picture here] off begin
					// % protected region % [Add other validators for Staff Picture here] end
				],
				// % protected region % [Add any additional model attribute properties for Staff Picture here] off begin
				// % protected region % [Add any additional model attribute properties for Staff Picture here] end
			},
			{
				name: 'education',
				// % protected region % [Set displayName for Education here] off begin
				displayName: 'Education',
				// % protected region % [Set displayName for Education here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Education here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Education here] end
				// % protected region % [Set isSensitive for Education here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Education here] end
				// % protected region % [Set readonly for Education here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Education here] end
				validators: [
					// % protected region % [Add other validators for Education here] off begin
					// % protected region % [Add other validators for Education here] end
				],
				// % protected region % [Add any additional model attribute properties for Education here] off begin
				// % protected region % [Add any additional model attribute properties for Education here] end
			},
			{
				name: 'licenseNo',
				// % protected region % [Set displayName for License No here] off begin
				displayName: 'License No',
				// % protected region % [Set displayName for License No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for License No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for License No here] end
				// % protected region % [Set isSensitive for License No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for License No here] end
				// % protected region % [Set readonly for License No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for License No here] end
				validators: [
					// % protected region % [Add other validators for License No here] off begin
					// % protected region % [Add other validators for License No here] end
				],
				// % protected region % [Add any additional model attribute properties for License No here] off begin
				// % protected region % [Add any additional model attribute properties for License No here] end
			},
			{
				name: 'letterOfReg',
				// % protected region % [Set displayName for Letter of Reg here] off begin
				displayName: 'Letter of Reg',
				// % protected region % [Set displayName for Letter of Reg here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Letter of Reg here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Letter of Reg here] end
				// % protected region % [Set isSensitive for Letter of Reg here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Letter of Reg here] end
				// % protected region % [Set readonly for Letter of Reg here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Letter of Reg here] end
				validators: [
					// % protected region % [Add other validators for Letter of Reg here] off begin
					// % protected region % [Add other validators for Letter of Reg here] end
				],
				// % protected region % [Add any additional model attribute properties for Letter of Reg here] off begin
				// % protected region % [Add any additional model attribute properties for Letter of Reg here] end
			},
			{
				name: 'gender',
				// % protected region % [Set displayName for Gender here] off begin
				displayName: 'Gender',
				// % protected region % [Set displayName for Gender here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gender here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gender here] end
				// % protected region % [Set isSensitive for Gender here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gender here] end
				// % protected region % [Set readonly for Gender here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gender here] end
				validators: [
					// % protected region % [Add other validators for Gender here] off begin
					// % protected region % [Add other validators for Gender here] end
				],
				// % protected region % [Add any additional model attribute properties for Gender here] off begin
				// % protected region % [Add any additional model attribute properties for Gender here] end
			},
			{
				name: 'employeeID',
				// % protected region % [Set displayName for Employee ID here] off begin
				displayName: 'Employee ID',
				// % protected region % [Set displayName for Employee ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Employee ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Employee ID here] end
				// % protected region % [Set isSensitive for Employee ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Employee ID here] end
				// % protected region % [Set readonly for Employee ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Employee ID here] end
				validators: [
					// % protected region % [Add other validators for Employee ID here] off begin
					// % protected region % [Add other validators for Employee ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Employee ID here] off begin
				// % protected region % [Add any additional model attribute properties for Employee ID here] end
			},
			{
				name: 'title',
				// % protected region % [Set displayName for Title here] off begin
				displayName: 'Title',
				// % protected region % [Set displayName for Title here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Title here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Title here] end
				// % protected region % [Set isSensitive for Title here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Title here] end
				// % protected region % [Set readonly for Title here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Title here] end
				validators: [
					// % protected region % [Add other validators for Title here] off begin
					// % protected region % [Add other validators for Title here] end
				],
				// % protected region % [Add any additional model attribute properties for Title here] off begin
				// % protected region % [Add any additional model attribute properties for Title here] end
			},
			{
				name: 'defaultServiceNumber',
				// % protected region % [Set displayName for Default Service Number here] off begin
				displayName: 'Default Service Number',
				// % protected region % [Set displayName for Default Service Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Default Service Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Default Service Number here] end
				// % protected region % [Set isSensitive for Default Service Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Default Service Number here] end
				// % protected region % [Set readonly for Default Service Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Default Service Number here] end
				validators: [
					// % protected region % [Add other validators for Default Service Number here] off begin
					// % protected region % [Add other validators for Default Service Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Default Service Number here] off begin
				// % protected region % [Add any additional model attribute properties for Default Service Number here] end
			},
			{
				name: 'placeOfBirth',
				// % protected region % [Set displayName for Place of birth here] off begin
				displayName: 'Place of birth',
				// % protected region % [Set displayName for Place of birth here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Place of birth here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Place of birth here] end
				// % protected region % [Set isSensitive for Place of birth here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Place of birth here] end
				// % protected region % [Set readonly for Place of birth here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Place of birth here] end
				validators: [
					// % protected region % [Add other validators for Place of birth here] off begin
					// % protected region % [Add other validators for Place of birth here] end
				],
				// % protected region % [Add any additional model attribute properties for Place of birth here] off begin
				// % protected region % [Add any additional model attribute properties for Place of birth here] end
			},
			{
				name: 'religion',
				// % protected region % [Set displayName for Religion here] off begin
				displayName: 'Religion',
				// % protected region % [Set displayName for Religion here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Religion here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Religion here] end
				// % protected region % [Set isSensitive for Religion here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Religion here] end
				// % protected region % [Set readonly for Religion here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Religion here] end
				validators: [
					// % protected region % [Add other validators for Religion here] off begin
					// % protected region % [Add other validators for Religion here] end
				],
				// % protected region % [Add any additional model attribute properties for Religion here] off begin
				// % protected region % [Add any additional model attribute properties for Religion here] end
			},
			{
				name: 'bloodType',
				// % protected region % [Set displayName for Blood Type here] off begin
				displayName: 'Blood Type',
				// % protected region % [Set displayName for Blood Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: bloodTypeEnumArray,
				// % protected region % [Set display element type for Blood Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Blood Type here] end
				// % protected region % [Set isSensitive for Blood Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Blood Type here] end
				// % protected region % [Set readonly for Blood Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Blood Type here] end
				validators: [
					// % protected region % [Add other validators for Blood Type here] off begin
					// % protected region % [Add other validators for Blood Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Blood Type here] off begin
				// % protected region % [Add any additional model attribute properties for Blood Type here] end
			},
			{
				name: 'rhesus',
				// % protected region % [Set displayName for Rhesus here] off begin
				displayName: 'Rhesus',
				// % protected region % [Set displayName for Rhesus here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: rhesusEnumArray,
				// % protected region % [Set display element type for Rhesus here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Rhesus here] end
				// % protected region % [Set isSensitive for Rhesus here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Rhesus here] end
				// % protected region % [Set readonly for Rhesus here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Rhesus here] end
				validators: [
					// % protected region % [Add other validators for Rhesus here] off begin
					// % protected region % [Add other validators for Rhesus here] end
				],
				// % protected region % [Add any additional model attribute properties for Rhesus here] off begin
				// % protected region % [Add any additional model attribute properties for Rhesus here] end
			},
			{
				name: 'address',
				// % protected region % [Set displayName for address here] off begin
				displayName: 'address',
				// % protected region % [Set displayName for address here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for address here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for address here] end
				// % protected region % [Set isSensitive for address here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for address here] end
				// % protected region % [Set readonly for address here] off begin
				readOnly: false,
				// % protected region % [Set readonly for address here] end
				validators: [
					// % protected region % [Add other validators for address here] off begin
					// % protected region % [Add other validators for address here] end
				],
				// % protected region % [Add any additional model attribute properties for address here] off begin
				// % protected region % [Add any additional model attribute properties for address here] end
			},
			{
				name: 'country',
				// % protected region % [Set displayName for Country here] off begin
				displayName: 'Country',
				// % protected region % [Set displayName for Country here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Country here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Country here] end
				// % protected region % [Set isSensitive for Country here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Country here] end
				// % protected region % [Set readonly for Country here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Country here] end
				validators: [
					// % protected region % [Add other validators for Country here] off begin
					// % protected region % [Add other validators for Country here] end
				],
				// % protected region % [Add any additional model attribute properties for Country here] off begin
				// % protected region % [Add any additional model attribute properties for Country here] end
			},
			{
				name: 'state',
				// % protected region % [Set displayName for State here] off begin
				displayName: 'State',
				// % protected region % [Set displayName for State here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for State here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for State here] end
				// % protected region % [Set isSensitive for State here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for State here] end
				// % protected region % [Set readonly for State here] off begin
				readOnly: false,
				// % protected region % [Set readonly for State here] end
				validators: [
					// % protected region % [Add other validators for State here] off begin
					// % protected region % [Add other validators for State here] end
				],
				// % protected region % [Add any additional model attribute properties for State here] off begin
				// % protected region % [Add any additional model attribute properties for State here] end
			},
			{
				name: 'regency',
				// % protected region % [Set displayName for Regency here] off begin
				displayName: 'Regency',
				// % protected region % [Set displayName for Regency here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Regency here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Regency here] end
				// % protected region % [Set isSensitive for Regency here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Regency here] end
				// % protected region % [Set readonly for Regency here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Regency here] end
				validators: [
					// % protected region % [Add other validators for Regency here] off begin
					// % protected region % [Add other validators for Regency here] end
				],
				// % protected region % [Add any additional model attribute properties for Regency here] off begin
				// % protected region % [Add any additional model attribute properties for Regency here] end
			},
			{
				name: 'district',
				// % protected region % [Set displayName for District here] off begin
				displayName: 'District',
				// % protected region % [Set displayName for District here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for District here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for District here] end
				// % protected region % [Set isSensitive for District here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for District here] end
				// % protected region % [Set readonly for District here] off begin
				readOnly: false,
				// % protected region % [Set readonly for District here] end
				validators: [
					// % protected region % [Add other validators for District here] off begin
					// % protected region % [Add other validators for District here] end
				],
				// % protected region % [Add any additional model attribute properties for District here] off begin
				// % protected region % [Add any additional model attribute properties for District here] end
			},
			{
				name: 'homePhoneNo',
				// % protected region % [Set displayName for Home phone no here] off begin
				displayName: 'Home phone no',
				// % protected region % [Set displayName for Home phone no here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Home phone no here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Home phone no here] end
				// % protected region % [Set isSensitive for Home phone no here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Home phone no here] end
				// % protected region % [Set readonly for Home phone no here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Home phone no here] end
				validators: [
					// % protected region % [Add other validators for Home phone no here] off begin
					// % protected region % [Add other validators for Home phone no here] end
				],
				// % protected region % [Add any additional model attribute properties for Home phone no here] off begin
				// % protected region % [Add any additional model attribute properties for Home phone no here] end
			},
			{
				name: 'village',
				// % protected region % [Set displayName for Village here] off begin
				displayName: 'Village',
				// % protected region % [Set displayName for Village here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Village here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Village here] end
				// % protected region % [Set isSensitive for Village here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Village here] end
				// % protected region % [Set readonly for Village here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Village here] end
				validators: [
					// % protected region % [Add other validators for Village here] off begin
					// % protected region % [Add other validators for Village here] end
				],
				// % protected region % [Add any additional model attribute properties for Village here] off begin
				// % protected region % [Add any additional model attribute properties for Village here] end
			},
			{
				name: 'postcode',
				// % protected region % [Set displayName for Postcode here] off begin
				displayName: 'Postcode',
				// % protected region % [Set displayName for Postcode here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Postcode here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Postcode here] end
				// % protected region % [Set isSensitive for Postcode here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Postcode here] end
				// % protected region % [Set readonly for Postcode here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Postcode here] end
				validators: [
					// % protected region % [Add other validators for Postcode here] off begin
					// % protected region % [Add other validators for Postcode here] end
				],
				// % protected region % [Add any additional model attribute properties for Postcode here] off begin
				// % protected region % [Add any additional model attribute properties for Postcode here] end
			},
			{
				name: 'officePhoneNumber',
				// % protected region % [Set displayName for Office Phone Number here] off begin
				displayName: 'Office Phone Number',
				// % protected region % [Set displayName for Office Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Office Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Office Phone Number here] end
				// % protected region % [Set isSensitive for Office Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Office Phone Number here] end
				// % protected region % [Set readonly for Office Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Office Phone Number here] end
				validators: [
					// % protected region % [Add other validators for Office Phone Number here] off begin
					// % protected region % [Add other validators for Office Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Office Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Office Phone Number here] end
			},
			{
				name: 'taxIdentificationNo',
				// % protected region % [Set displayName for Tax Identification No here] off begin
				displayName: 'Tax Identification No',
				// % protected region % [Set displayName for Tax Identification No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tax Identification No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tax Identification No here] end
				// % protected region % [Set isSensitive for Tax Identification No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax Identification No here] end
				// % protected region % [Set readonly for Tax Identification No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax Identification No here] end
				validators: [
					// % protected region % [Add other validators for Tax Identification No here] off begin
					// % protected region % [Add other validators for Tax Identification No here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax Identification No here] off begin
				// % protected region % [Add any additional model attribute properties for Tax Identification No here] end
			},
			{
				name: 'mobilePhoneNo',
				// % protected region % [Set displayName for Mobile Phone No here] off begin
				displayName: 'Mobile Phone No',
				// % protected region % [Set displayName for Mobile Phone No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Mobile Phone No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Mobile Phone No here] end
				// % protected region % [Set isSensitive for Mobile Phone No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Mobile Phone No here] end
				// % protected region % [Set readonly for Mobile Phone No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Mobile Phone No here] end
				validators: [
					// % protected region % [Add other validators for Mobile Phone No here] off begin
					// % protected region % [Add other validators for Mobile Phone No here] end
				],
				// % protected region % [Add any additional model attribute properties for Mobile Phone No here] off begin
				// % protected region % [Add any additional model attribute properties for Mobile Phone No here] end
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
				name: 'training',
				// % protected region % [Set displayName for Training here] off begin
				displayName: 'Training',
				// % protected region % [Set displayName for Training here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Training here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Training here] end
				// % protected region % [Set isSensitive for Training here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Training here] end
				// % protected region % [Set readonly for Training here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Training here] end
				validators: [
					// % protected region % [Add other validators for Training here] off begin
					// % protected region % [Add other validators for Training here] end
				],
				// % protected region % [Add any additional model attribute properties for Training here] off begin
				// % protected region % [Add any additional model attribute properties for Training here] end
			},
			{
				name: 'nationality',
				// % protected region % [Set displayName for Nationality here] off begin
				displayName: 'Nationality',
				// % protected region % [Set displayName for Nationality here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nationality here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nationality here] end
				// % protected region % [Set isSensitive for Nationality here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nationality here] end
				// % protected region % [Set readonly for Nationality here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nationality here] end
				validators: [
					// % protected region % [Add other validators for Nationality here] off begin
					// % protected region % [Add other validators for Nationality here] end
				],
				// % protected region % [Add any additional model attribute properties for Nationality here] off begin
				// % protected region % [Add any additional model attribute properties for Nationality here] end
			},
			{
				name: 'certification',
				// % protected region % [Set displayName for Certification here] off begin
				displayName: 'Certification',
				// % protected region % [Set displayName for Certification here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Certification here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Certification here] end
				// % protected region % [Set isSensitive for Certification here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Certification here] end
				// % protected region % [Set readonly for Certification here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Certification here] end
				validators: [
					// % protected region % [Add other validators for Certification here] off begin
					// % protected region % [Add other validators for Certification here] end
				],
				// % protected region % [Add any additional model attribute properties for Certification here] off begin
				// % protected region % [Add any additional model attribute properties for Certification here] end
			},
			{
				name: 'extNo',
				// % protected region % [Set displayName for Ext No here] off begin
				displayName: 'Ext No',
				// % protected region % [Set displayName for Ext No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ext No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ext No here] end
				// % protected region % [Set isSensitive for Ext No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ext No here] end
				// % protected region % [Set readonly for Ext No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ext No here] end
				validators: [
					// % protected region % [Add other validators for Ext No here] off begin
					// % protected region % [Add other validators for Ext No here] end
				],
				// % protected region % [Add any additional model attribute properties for Ext No here] off begin
				// % protected region % [Add any additional model attribute properties for Ext No here] end
			},
			{
				name: 'maritalStatus',
				// % protected region % [Set displayName for Marital Status here] off begin
				displayName: 'Marital Status',
				// % protected region % [Set displayName for Marital Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Marital Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Marital Status here] end
				// % protected region % [Set isSensitive for Marital Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Marital Status here] end
				// % protected region % [Set readonly for Marital Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Marital Status here] end
				validators: [
					// % protected region % [Add other validators for Marital Status here] off begin
					// % protected region % [Add other validators for Marital Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Marital Status here] off begin
				// % protected region % [Add any additional model attribute properties for Marital Status here] end
			},
			{
				name: 'email',
				// % protected region % [Set displayName for email here] off begin
				displayName: 'email',
				// % protected region % [Set displayName for email here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for email here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for email here] end
				// % protected region % [Set isSensitive for email here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for email here] end
				// % protected region % [Set readonly for email here] off begin
				readOnly: false,
				// % protected region % [Set readonly for email here] end
				validators: [
					// % protected region % [Add other validators for email here] off begin
					// % protected region % [Add other validators for email here] end
				],
				// % protected region % [Add any additional model attribute properties for email here] off begin
				// % protected region % [Add any additional model attribute properties for email here] end
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
				id: 'accompanyingConsents',
				type: ModelRelationType.MANY,
				name: 'accompanyingConsentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Accompanying Consents here] off begin
				label: 'Accompanying Consents',
				// % protected region % [Customise your 1-1 or 1-M label for Accompanying Consents here] end
				entityName: 'InformedConsentModel',
				// % protected region % [Customise your display name for Accompanying Consents here] off begin
				displayName: 'patientFamilyGuardianName',
				// % protected region % [Customise your display name for Accompanying Consents here] end
				validators: [
					// % protected region % [Add other validators for Accompanying Consents here] off begin
					// % protected region % [Add other validators for Accompanying Consents here] end
				],
				// % protected region % [Add any additional field for relation Accompanying Consents here] off begin
				// % protected region % [Add any additional field for relation Accompanying Consents here] end
			},
			{
				id: 'administrator',
				type: ModelRelationType.ONE,
				name: 'administratorId',
				// % protected region % [Customise your 1-1 or 1-M label for Administrator here] off begin
				label: 'Administrator',
				// % protected region % [Customise your 1-1 or 1-M label for Administrator here] end
				entityName: 'AdministratorModel',
				// % protected region % [Customise your display name for Administrator here] off begin
				displayName: 'name',
				// % protected region % [Customise your display name for Administrator here] end
				validators: [
					// % protected region % [Add other validators for Administrator here] off begin
					// % protected region % [Add other validators for Administrator here] end
				],
				// % protected region % [Add any additional field for relation Administrator here] off begin
				// % protected region % [Add any additional field for relation Administrator here] end
			},
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
				id: 'anesthesiaMedicalTranscriber',
				type: ModelRelationType.MANY,
				name: 'anesthesiaMedicalTranscriberIds',
				// % protected region % [Customise your 1-1 or 1-M label for Anesthesia Medical Transcriber here] off begin
				label: 'Anesthesia Medical Transcriber',
				// % protected region % [Customise your 1-1 or 1-M label for Anesthesia Medical Transcriber here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Anesthesia Medical Transcriber here] off begin
				displayName: 'startDateTime',
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
				type: ModelRelationType.MANY,
				name: 'anesthesiologistIds',
				// % protected region % [Customise your 1-1 or 1-M label for Anesthesiologist here] off begin
				label: 'Anesthesiologist',
				// % protected region % [Customise your 1-1 or 1-M label for Anesthesiologist here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Anesthesiologist here] off begin
				displayName: 'startDateTime',
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
				type: ModelRelationType.MANY,
				name: 'anesthesiologyNurseIds',
				// % protected region % [Customise your 1-1 or 1-M label for Anesthesiology Nurse here] off begin
				label: 'Anesthesiology Nurse',
				// % protected region % [Customise your 1-1 or 1-M label for Anesthesiology Nurse here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Anesthesiology Nurse here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Anesthesiology Nurse here] end
				validators: [
					// % protected region % [Add other validators for Anesthesiology Nurse here] off begin
					// % protected region % [Add other validators for Anesthesiology Nurse here] end
				],
				// % protected region % [Add any additional field for relation Anesthesiology Nurse here] off begin
				// % protected region % [Add any additional field for relation Anesthesiology Nurse here] end
			},
			{
				id: 'bpjsDoctorMapping',
				type: ModelRelationType.ONE,
				name: 'bpjsDoctorMappingId',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Doctor Mapping here] off begin
				label: 'BPJS Doctor Mapping',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Doctor Mapping here] end
				entityName: 'BpjsDoctorMappingModel',
				// % protected region % [Customise your display name for BPJS Doctor Mapping here] off begin
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Doctor Mapping here] end
				validators: [
					// % protected region % [Add other validators for BPJS Doctor Mapping here] off begin
					// % protected region % [Add other validators for BPJS Doctor Mapping here] end
				],
				// % protected region % [Add any additional field for relation BPJS Doctor Mapping here] off begin
				// % protected region % [Add any additional field for relation BPJS Doctor Mapping here] end
			},
			{
				id: 'cashierStaff',
				type: ModelRelationType.MANY,
				name: 'cashierStaffIds',
				// % protected region % [Customise your 1-1 or 1-M label for Cashier Staff here] off begin
				label: 'Cashier Staff',
				// % protected region % [Customise your 1-1 or 1-M label for Cashier Staff here] end
				entityName: 'CashReceiptModel',
				// % protected region % [Customise your display name for Cashier Staff here] off begin
				displayName: 'receiptType',
				// % protected region % [Customise your display name for Cashier Staff here] end
				validators: [
					// % protected region % [Add other validators for Cashier Staff here] off begin
					// % protected region % [Add other validators for Cashier Staff here] end
				],
				// % protected region % [Add any additional field for relation Cashier Staff here] off begin
				// % protected region % [Add any additional field for relation Cashier Staff here] end
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
				id: 'dailyCareCPPTsCreatedByStaff',
				type: ModelRelationType.MANY,
				name: 'dailyCareCPPTsCreatedByStaffIds',
				// % protected region % [Customise your 1-1 or 1-M label for Daily Care CPPTs Created By Staff here] off begin
				label: 'Daily Care CPPTs Created By Staff',
				// % protected region % [Customise your 1-1 or 1-M label for Daily Care CPPTs Created By Staff here] end
				entityName: 'DailyCareCPPTModel',
				// % protected region % [Customise your display name for Daily Care CPPTs Created By Staff here] off begin
				displayName: 'subjective',
				// % protected region % [Customise your display name for Daily Care CPPTs Created By Staff here] end
				validators: [
					// % protected region % [Add other validators for Daily Care CPPTs Created By Staff here] off begin
					// % protected region % [Add other validators for Daily Care CPPTs Created By Staff here] end
				],
				// % protected region % [Add any additional field for relation Daily Care CPPTs Created By Staff here] off begin
				// % protected region % [Add any additional field for relation Daily Care CPPTs Created By Staff here] end
			},
			{
				id: 'dailyCareCPPTsDoctorInCharge',
				type: ModelRelationType.MANY,
				name: 'dailyCareCPPTsDoctorInChargeIds',
				// % protected region % [Customise your 1-1 or 1-M label for Daily Care CPPTs Doctor in Charge here] off begin
				label: 'Daily Care CPPTs Doctor in Charge',
				// % protected region % [Customise your 1-1 or 1-M label for Daily Care CPPTs Doctor in Charge here] end
				entityName: 'DailyCareCPPTModel',
				// % protected region % [Customise your display name for Daily Care CPPTs Doctor in Charge here] off begin
				displayName: 'subjective',
				// % protected region % [Customise your display name for Daily Care CPPTs Doctor in Charge here] end
				validators: [
					// % protected region % [Add other validators for Daily Care CPPTs Doctor in Charge here] off begin
					// % protected region % [Add other validators for Daily Care CPPTs Doctor in Charge here] end
				],
				// % protected region % [Add any additional field for relation Daily Care CPPTs Doctor in Charge here] off begin
				// % protected region % [Add any additional field for relation Daily Care CPPTs Doctor in Charge here] end
			},
			{
				id: 'dailyCareCPPTsMedicalTranscriber',
				type: ModelRelationType.MANY,
				name: 'dailyCareCPPTsMedicalTranscriberIds',
				// % protected region % [Customise your 1-1 or 1-M label for Daily Care CPPTs Medical Transcriber here] off begin
				label: 'Daily Care CPPTs Medical Transcriber',
				// % protected region % [Customise your 1-1 or 1-M label for Daily Care CPPTs Medical Transcriber here] end
				entityName: 'DailyCareCPPTModel',
				// % protected region % [Customise your display name for Daily Care CPPTs Medical Transcriber here] off begin
				displayName: 'subjective',
				// % protected region % [Customise your display name for Daily Care CPPTs Medical Transcriber here] end
				validators: [
					// % protected region % [Add other validators for Daily Care CPPTs Medical Transcriber here] off begin
					// % protected region % [Add other validators for Daily Care CPPTs Medical Transcriber here] end
				],
				// % protected region % [Add any additional field for relation Daily Care CPPTs Medical Transcriber here] off begin
				// % protected region % [Add any additional field for relation Daily Care CPPTs Medical Transcriber here] end
			},
			{
				id: 'deliveryProgresses',
				type: ModelRelationType.MANY,
				name: 'deliveryProgressesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Delivery Progresses here] off begin
				label: 'Delivery Progresses',
				// % protected region % [Customise your 1-1 or 1-M label for Delivery Progresses here] end
				entityName: 'DeliveryProgressModel',
				// % protected region % [Customise your display name for Delivery Progresses here] off begin
				displayName: 'progressDateTime',
				// % protected region % [Customise your display name for Delivery Progresses here] end
				validators: [
					// % protected region % [Add other validators for Delivery Progresses here] off begin
					// % protected region % [Add other validators for Delivery Progresses here] end
				],
				// % protected region % [Add any additional field for relation Delivery Progresses here] off begin
				// % protected region % [Add any additional field for relation Delivery Progresses here] end
			},
			{
				id: 'diagnosticStaffExaminationSummaries',
				type: ModelRelationType.MANY,
				name: 'diagnosticStaffExaminationSummariesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnostic Staff Examination Summaries here] off begin
				label: 'Diagnostic Staff Examination Summaries',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnostic Staff Examination Summaries here] end
				entityName: 'DiagnosticStaffExaminationSummaryModel',
				// % protected region % [Customise your display name for Diagnostic Staff Examination Summaries here] off begin
				displayName: 'responsibleDoctor',
				// % protected region % [Customise your display name for Diagnostic Staff Examination Summaries here] end
				validators: [
					// % protected region % [Add other validators for Diagnostic Staff Examination Summaries here] off begin
					// % protected region % [Add other validators for Diagnostic Staff Examination Summaries here] end
				],
				// % protected region % [Add any additional field for relation Diagnostic Staff Examination Summaries here] off begin
				// % protected region % [Add any additional field for relation Diagnostic Staff Examination Summaries here] end
			},
			{
				id: 'dismissalReferringStaff',
				type: ModelRelationType.MANY,
				name: 'dismissalReferringStaffIds',
				// % protected region % [Customise your 1-1 or 1-M label for Dismissal Referring Staff here] off begin
				label: 'Dismissal Referring Staff',
				// % protected region % [Customise your 1-1 or 1-M label for Dismissal Referring Staff here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Dismissal Referring Staff here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Dismissal Referring Staff here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Referring Staff here] off begin
					// % protected region % [Add other validators for Dismissal Referring Staff here] end
				],
				// % protected region % [Add any additional field for relation Dismissal Referring Staff here] off begin
				// % protected region % [Add any additional field for relation Dismissal Referring Staff here] end
			},
			{
				id: 'doctorSchedules',
				type: ModelRelationType.MANY,
				name: 'doctorSchedulesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Doctor Schedules here] off begin
				label: 'Doctor Schedules',
				// % protected region % [Customise your 1-1 or 1-M label for Doctor Schedules here] end
				entityName: 'DoctorScheduleModel',
				// % protected region % [Customise your display name for Doctor Schedules here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Doctor Schedules here] end
				validators: [
					// % protected region % [Add other validators for Doctor Schedules here] off begin
					// % protected region % [Add other validators for Doctor Schedules here] end
				],
				// % protected region % [Add any additional field for relation Doctor Schedules here] off begin
				// % protected region % [Add any additional field for relation Doctor Schedules here] end
			},
			{
				id: 'doctorOnExamination',
				type: ModelRelationType.MANY,
				name: 'doctorOnExaminationIds',
				// % protected region % [Customise your 1-1 or 1-M label for Doctor on examination here] off begin
				label: 'Doctor on examination',
				// % protected region % [Customise your 1-1 or 1-M label for Doctor on examination here] end
				entityName: 'MedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Doctor on examination here] off begin
				displayName: 'diastole',
				// % protected region % [Customise your display name for Doctor on examination here] end
				validators: [
					// % protected region % [Add other validators for Doctor on examination here] off begin
					// % protected region % [Add other validators for Doctor on examination here] end
				],
				// % protected region % [Add any additional field for relation Doctor on examination here] off begin
				// % protected region % [Add any additional field for relation Doctor on examination here] end
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
				id: 'hemodialysisMonitorings',
				type: ModelRelationType.MANY,
				name: 'hemodialysisMonitoringsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Hemodialysis Monitorings here] off begin
				label: 'Hemodialysis Monitorings',
				// % protected region % [Customise your 1-1 or 1-M label for Hemodialysis Monitorings here] end
				entityName: 'HemodialysisMonitoringModel',
				// % protected region % [Customise your display name for Hemodialysis Monitorings here] off begin
				displayName: 'datetime',
				// % protected region % [Customise your display name for Hemodialysis Monitorings here] end
				validators: [
					// % protected region % [Add other validators for Hemodialysis Monitorings here] off begin
					// % protected region % [Add other validators for Hemodialysis Monitorings here] end
				],
				// % protected region % [Add any additional field for relation Hemodialysis Monitorings here] off begin
				// % protected region % [Add any additional field for relation Hemodialysis Monitorings here] end
			},
			{
				id: 'hospitalBranchInformations',
				type: ModelRelationType.MANY,
				name: 'hospitalBranchInformationsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Hospital Branch Informations here] off begin
				label: 'Hospital Branch Informations',
				// % protected region % [Customise your 1-1 or 1-M label for Hospital Branch Informations here] end
				entityName: 'HospitalBranchInformationModel',
				// % protected region % [Customise your display name for Hospital Branch Informations here] off begin
				displayName: 'hospitalCode',
				// % protected region % [Customise your display name for Hospital Branch Informations here] end
				validators: [
					// % protected region % [Add other validators for Hospital Branch Informations here] off begin
					// % protected region % [Add other validators for Hospital Branch Informations here] end
				],
				// % protected region % [Add any additional field for relation Hospital Branch Informations here] off begin
				// % protected region % [Add any additional field for relation Hospital Branch Informations here] end
			},
			{
				id: 'informingConsents',
				type: ModelRelationType.MANY,
				name: 'informingConsentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Informing Consents here] off begin
				label: 'Informing Consents',
				// % protected region % [Customise your 1-1 or 1-M label for Informing Consents here] end
				entityName: 'InformedConsentModel',
				// % protected region % [Customise your display name for Informing Consents here] off begin
				displayName: 'patientFamilyGuardianName',
				// % protected region % [Customise your display name for Informing Consents here] end
				validators: [
					// % protected region % [Add other validators for Informing Consents here] off begin
					// % protected region % [Add other validators for Informing Consents here] end
				],
				// % protected region % [Add any additional field for relation Informing Consents here] off begin
				// % protected region % [Add any additional field for relation Informing Consents here] end
			},
			{
				id: 'invoices',
				type: ModelRelationType.MANY,
				name: 'invoicesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices here] off begin
				label: 'Invoices',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices here] end
				entityName: 'InvoiceModel',
				// % protected region % [Customise your display name for Invoices here] off begin
				displayName: 'invoiceNumber',
				// % protected region % [Customise your display name for Invoices here] end
				validators: [
					// % protected region % [Add other validators for Invoices here] off begin
					// % protected region % [Add other validators for Invoices here] end
				],
				// % protected region % [Add any additional field for relation Invoices here] off begin
				// % protected region % [Add any additional field for relation Invoices here] end
			},
			{
				id: 'mcuPackageItems',
				type: ModelRelationType.MANY,
				name: 'mcuPackageItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for MCU Package Items here] off begin
				label: 'MCU Package Items',
				// % protected region % [Customise your 1-1 or 1-M label for MCU Package Items here] end
				entityName: 'McuPackageItemModel',
				// % protected region % [Customise your display name for MCU Package Items here] off begin
				displayName: 'itemCode',
				// % protected region % [Customise your display name for MCU Package Items here] end
				validators: [
					// % protected region % [Add other validators for MCU Package Items here] off begin
					// % protected region % [Add other validators for MCU Package Items here] end
				],
				// % protected region % [Add any additional field for relation MCU Package Items here] off begin
				// % protected region % [Add any additional field for relation MCU Package Items here] end
			},
			{
				id: 'medicalCertificateDischargeResumes',
				type: ModelRelationType.MANY,
				name: 'medicalCertificateDischargeResumesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate  Discharge Resumes here] off begin
				label: 'Medical Certificate  Discharge Resumes',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate  Discharge Resumes here] end
				entityName: 'MedicalCertificateDischargeResumeModel',
				// % protected region % [Customise your display name for Medical Certificate  Discharge Resumes here] off begin
				displayName: 'admissionDateTime',
				// % protected region % [Customise your display name for Medical Certificate  Discharge Resumes here] end
				validators: [
					// % protected region % [Add other validators for Medical Certificate  Discharge Resumes here] off begin
					// % protected region % [Add other validators for Medical Certificate  Discharge Resumes here] end
				],
				// % protected region % [Add any additional field for relation Medical Certificate  Discharge Resumes here] off begin
				// % protected region % [Add any additional field for relation Medical Certificate  Discharge Resumes here] end
			},
			{
				id: 'medicalCertificateBirths',
				type: ModelRelationType.MANY,
				name: 'medicalCertificateBirthsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Births here] off begin
				label: 'Medical Certificate Births',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Births here] end
				entityName: 'MedicalCertificateBirthModel',
				// % protected region % [Customise your display name for Medical Certificate Births here] off begin
				displayName: 'patientName',
				// % protected region % [Customise your display name for Medical Certificate Births here] end
				validators: [
					// % protected region % [Add other validators for Medical Certificate Births here] off begin
					// % protected region % [Add other validators for Medical Certificate Births here] end
				],
				// % protected region % [Add any additional field for relation Medical Certificate Births here] off begin
				// % protected region % [Add any additional field for relation Medical Certificate Births here] end
			},
			{
				id: 'medicalCertificateHospitalizations',
				type: ModelRelationType.MANY,
				name: 'medicalCertificateHospitalizationsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Hospitalizations here] off begin
				label: 'Medical Certificate Hospitalizations',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Certificate Hospitalizations here] end
				entityName: 'MedicalCertificateHospitalizationModel',
				// % protected region % [Customise your display name for Medical Certificate Hospitalizations here] off begin
				displayName: 'admissionDateTime',
				// % protected region % [Customise your display name for Medical Certificate Hospitalizations here] end
				validators: [
					// % protected region % [Add other validators for Medical Certificate Hospitalizations here] off begin
					// % protected region % [Add other validators for Medical Certificate Hospitalizations here] end
				],
				// % protected region % [Add any additional field for relation Medical Certificate Hospitalizations here] off begin
				// % protected region % [Add any additional field for relation Medical Certificate Hospitalizations here] end
			},
			{
				id: 'medicalExaminationRecordDischargeSummarys',
				type: ModelRelationType.MANY,
				name: 'medicalExaminationRecordDischargeSummarysIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Examination Record Discharge Summarys here] off begin
				label: 'Medical Examination Record Discharge Summarys',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Examination Record Discharge Summarys here] end
				entityName: 'MedicalExaminationRecordDischargeSummaryModel',
				// % protected region % [Customise your display name for Medical Examination Record Discharge Summarys here] off begin
				displayName: 'diastole',
				// % protected region % [Customise your display name for Medical Examination Record Discharge Summarys here] end
				validators: [
					// % protected region % [Add other validators for Medical Examination Record Discharge Summarys here] off begin
					// % protected region % [Add other validators for Medical Examination Record Discharge Summarys here] end
				],
				// % protected region % [Add any additional field for relation Medical Examination Record Discharge Summarys here] off begin
				// % protected region % [Add any additional field for relation Medical Examination Record Discharge Summarys here] end
			},
			{
				id: 'medicalRecordTranscriber',
				type: ModelRelationType.MANY,
				name: 'medicalRecordTranscriberIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Record Transcriber here] off begin
				label: 'Medical Record Transcriber',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Record Transcriber here] end
				entityName: 'MedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Medical Record Transcriber here] off begin
				displayName: 'diastole',
				// % protected region % [Customise your display name for Medical Record Transcriber here] end
				validators: [
					// % protected region % [Add other validators for Medical Record Transcriber here] off begin
					// % protected region % [Add other validators for Medical Record Transcriber here] end
				],
				// % protected region % [Add any additional field for relation Medical Record Transcriber here] off begin
				// % protected region % [Add any additional field for relation Medical Record Transcriber here] end
			},
			{
				id: 'medicalStaffOfMedicalAttendancesCertificate',
				type: ModelRelationType.MANY,
				name: 'medicalStaffOfMedicalAttendancesCertificateIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Staff of Medical Attendances certificate here] off begin
				label: 'Medical Staff of Medical Attendances certificate',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Staff of Medical Attendances certificate here] end
				entityName: 'MedicalCertificateMedicalAttendanceModel',
				// % protected region % [Customise your display name for Medical Staff of Medical Attendances certificate here] off begin
				displayName: 'date',
				// % protected region % [Customise your display name for Medical Staff of Medical Attendances certificate here] end
				validators: [
					// % protected region % [Add other validators for Medical Staff of Medical Attendances certificate here] off begin
					// % protected region % [Add other validators for Medical Staff of Medical Attendances certificate here] end
				],
				// % protected region % [Add any additional field for relation Medical Staff of Medical Attendances certificate here] off begin
				// % protected region % [Add any additional field for relation Medical Staff of Medical Attendances certificate here] end
			},
			{
				id: 'medicalStaffOfMentalHealths',
				type: ModelRelationType.MANY,
				name: 'medicalStaffOfMentalHealthsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Staff of Mental Healths here] off begin
				label: 'Medical Staff of Mental Healths',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Staff of Mental Healths here] end
				entityName: 'MedicalCertificateMentalHealthModel',
				// % protected region % [Customise your display name for Medical Staff of Mental Healths here] off begin
				displayName: 'examinationDateTime',
				// % protected region % [Customise your display name for Medical Staff of Mental Healths here] end
				validators: [
					// % protected region % [Add other validators for Medical Staff of Mental Healths here] off begin
					// % protected region % [Add other validators for Medical Staff of Mental Healths here] end
				],
				// % protected region % [Add any additional field for relation Medical Staff of Mental Healths here] off begin
				// % protected region % [Add any additional field for relation Medical Staff of Mental Healths here] end
			},
			{
				id: 'medicalStaffOfPhysicalHealths',
				type: ModelRelationType.MANY,
				name: 'medicalStaffOfPhysicalHealthsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Staff of Physical Healths here] off begin
				label: 'Medical Staff of Physical Healths',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Staff of Physical Healths here] end
				entityName: 'MedicalCertificatePhysicalHealthModel',
				// % protected region % [Customise your display name for Medical Staff of Physical Healths here] off begin
				displayName: 'examinationDateTime',
				// % protected region % [Customise your display name for Medical Staff of Physical Healths here] end
				validators: [
					// % protected region % [Add other validators for Medical Staff of Physical Healths here] off begin
					// % protected region % [Add other validators for Medical Staff of Physical Healths here] end
				],
				// % protected region % [Add any additional field for relation Medical Staff of Physical Healths here] off begin
				// % protected region % [Add any additional field for relation Medical Staff of Physical Healths here] end
			},
			{
				id: 'medicalStaffOfRestrictedWorksCertificate',
				type: ModelRelationType.MANY,
				name: 'medicalStaffOfRestrictedWorksCertificateIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Staff of Restricted Works certificate here] off begin
				label: 'Medical Staff of Restricted Works certificate',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Staff of Restricted Works certificate here] end
				entityName: 'MedicalCertificateRestrictedWorkModel',
				// % protected region % [Customise your display name for Medical Staff of Restricted Works certificate here] off begin
				displayName: 'period',
				// % protected region % [Customise your display name for Medical Staff of Restricted Works certificate here] end
				validators: [
					// % protected region % [Add other validators for Medical Staff of Restricted Works certificate here] off begin
					// % protected region % [Add other validators for Medical Staff of Restricted Works certificate here] end
				],
				// % protected region % [Add any additional field for relation Medical Staff of Restricted Works certificate here] off begin
				// % protected region % [Add any additional field for relation Medical Staff of Restricted Works certificate here] end
			},
			{
				id: 'medicalStaffOfSickLeavesCertificate',
				type: ModelRelationType.MANY,
				name: 'medicalStaffOfSickLeavesCertificateIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Staff of Sick Leaves certificate here] off begin
				label: 'Medical Staff of Sick Leaves certificate',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Staff of Sick Leaves certificate here] end
				entityName: 'MedicalCertificateSickLeaveModel',
				// % protected region % [Customise your display name for Medical Staff of Sick Leaves certificate here] off begin
				displayName: 'period',
				// % protected region % [Customise your display name for Medical Staff of Sick Leaves certificate here] end
				validators: [
					// % protected region % [Add other validators for Medical Staff of Sick Leaves certificate here] off begin
					// % protected region % [Add other validators for Medical Staff of Sick Leaves certificate here] end
				],
				// % protected region % [Add any additional field for relation Medical Staff of Sick Leaves certificate here] off begin
				// % protected region % [Add any additional field for relation Medical Staff of Sick Leaves certificate here] end
			},
			{
				id: 'medicationAdministeredHisotries',
				type: ModelRelationType.MANY,
				name: 'medicationAdministeredHisotriesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Administered Hisotries here] off begin
				label: 'Medication Administered Hisotries',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Administered Hisotries here] end
				entityName: 'MedicationAdministeredHistoryModel',
				// % protected region % [Customise your display name for Medication Administered Hisotries here] off begin
				displayName: 'datetime',
				// % protected region % [Customise your display name for Medication Administered Hisotries here] end
				validators: [
					// % protected region % [Add other validators for Medication Administered Hisotries here] off begin
					// % protected region % [Add other validators for Medication Administered Hisotries here] end
				],
				// % protected region % [Add any additional field for relation Medication Administered Hisotries here] off begin
				// % protected region % [Add any additional field for relation Medication Administered Hisotries here] end
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
				id: 'midwives',
				type: ModelRelationType.MANY,
				name: 'midwivesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Midwives here] off begin
				label: 'Midwives',
				// % protected region % [Customise your 1-1 or 1-M label for Midwives here] end
				entityName: 'DeliveryMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Midwives here] off begin
				displayName: 'pregnancyHistoryGravida',
				// % protected region % [Customise your display name for Midwives here] end
				validators: [
					// % protected region % [Add other validators for Midwives here] off begin
					// % protected region % [Add other validators for Midwives here] end
				],
				// % protected region % [Add any additional field for relation Midwives here] off begin
				// % protected region % [Add any additional field for relation Midwives here] end
			},
			{
				id: 'nurse',
				type: ModelRelationType.MANY,
				name: 'nurseIds',
				// % protected region % [Customise your 1-1 or 1-M label for Nurse here] off begin
				label: 'Nurse',
				// % protected region % [Customise your 1-1 or 1-M label for Nurse here] end
				entityName: 'MedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Nurse here] off begin
				displayName: 'diastole',
				// % protected region % [Customise your display name for Nurse here] end
				validators: [
					// % protected region % [Add other validators for Nurse here] off begin
					// % protected region % [Add other validators for Nurse here] end
				],
				// % protected region % [Add any additional field for relation Nurse here] off begin
				// % protected region % [Add any additional field for relation Nurse here] end
			},
			{
				id: 'nursingDetailSurgicalNursing',
				type: ModelRelationType.MANY,
				name: 'nursingDetailSurgicalNursingIds',
				// % protected region % [Customise your 1-1 or 1-M label for Nursing Detail Surgical Nursing here] off begin
				label: 'Nursing Detail Surgical Nursing',
				// % protected region % [Customise your 1-1 or 1-M label for Nursing Detail Surgical Nursing here] end
				entityName: 'OperatingTheaterMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Nursing Detail Surgical Nursing here] off begin
				displayName: 'hasConfirmedIdentity',
				// % protected region % [Customise your display name for Nursing Detail Surgical Nursing here] end
				validators: [
					// % protected region % [Add other validators for Nursing Detail Surgical Nursing here] off begin
					// % protected region % [Add other validators for Nursing Detail Surgical Nursing here] end
				],
				// % protected region % [Add any additional field for relation Nursing Detail Surgical Nursing here] off begin
				// % protected region % [Add any additional field for relation Nursing Detail Surgical Nursing here] end
			},
			{
				id: 'nursingDetailsAnesthesiaNursing',
				type: ModelRelationType.MANY,
				name: 'nursingDetailsAnesthesiaNursingIds',
				// % protected region % [Customise your 1-1 or 1-M label for Nursing Details Anesthesia Nursing here] off begin
				label: 'Nursing Details Anesthesia Nursing',
				// % protected region % [Customise your 1-1 or 1-M label for Nursing Details Anesthesia Nursing here] end
				entityName: 'OperatingTheaterMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Nursing Details Anesthesia Nursing here] off begin
				displayName: 'hasConfirmedIdentity',
				// % protected region % [Customise your display name for Nursing Details Anesthesia Nursing here] end
				validators: [
					// % protected region % [Add other validators for Nursing Details Anesthesia Nursing here] off begin
					// % protected region % [Add other validators for Nursing Details Anesthesia Nursing here] end
				],
				// % protected region % [Add any additional field for relation Nursing Details Anesthesia Nursing here] off begin
				// % protected region % [Add any additional field for relation Nursing Details Anesthesia Nursing here] end
			},
			{
				id: 'pcareDokter',
				type: ModelRelationType.ONE,
				name: 'pcareDokterId',
				// % protected region % [Customise your 1-1 or 1-M label for PCare Dokter here] off begin
				label: 'PCare Dokter',
				// % protected region % [Customise your 1-1 or 1-M label for PCare Dokter here] end
				entityName: 'PcareDokterModel',
				// % protected region % [Customise your display name for PCare Dokter here] off begin
				displayName: 'kodeDokter',
				// % protected region % [Customise your display name for PCare Dokter here] end
				validators: [
					// % protected region % [Add other validators for PCare Dokter here] off begin
					// % protected region % [Add other validators for PCare Dokter here] end
				],
				// % protected region % [Add any additional field for relation PCare Dokter here] off begin
				// % protected region % [Add any additional field for relation PCare Dokter here] end
			},
			{
				id: 'patientConsents',
				type: ModelRelationType.MANY,
				name: 'patientConsentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Consents here] off begin
				label: 'Patient Consents',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Consents here] end
				entityName: 'PatientConsentModel',
				// % protected region % [Customise your display name for Patient Consents here] off begin
				displayName: 'consentDateTime',
				// % protected region % [Customise your display name for Patient Consents here] end
				validators: [
					// % protected region % [Add other validators for Patient Consents here] off begin
					// % protected region % [Add other validators for Patient Consents here] end
				],
				// % protected region % [Add any additional field for relation Patient Consents here] off begin
				// % protected region % [Add any additional field for relation Patient Consents here] end
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
				id: 'pediatricianInCharge',
				type: ModelRelationType.MANY,
				name: 'pediatricianInChargeIds',
				// % protected region % [Customise your 1-1 or 1-M label for Pediatrician In Charge here] off begin
				label: 'Pediatrician In Charge',
				// % protected region % [Customise your 1-1 or 1-M label for Pediatrician In Charge here] end
				entityName: 'NewbornDetailModel',
				// % protected region % [Customise your display name for Pediatrician In Charge here] off begin
				displayName: 'newbornFirstName',
				// % protected region % [Customise your display name for Pediatrician In Charge here] end
				validators: [
					// % protected region % [Add other validators for Pediatrician In Charge here] off begin
					// % protected region % [Add other validators for Pediatrician In Charge here] end
				],
				// % protected region % [Add any additional field for relation Pediatrician In Charge here] off begin
				// % protected region % [Add any additional field for relation Pediatrician In Charge here] end
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
				id: 'processWorkflowLogs',
				type: ModelRelationType.MANY,
				name: 'processWorkflowLogsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Process Workflow Logs here] off begin
				label: 'Process Workflow Logs',
				// % protected region % [Customise your 1-1 or 1-M label for Process Workflow Logs here] end
				entityName: 'ProcessWorkflowModel',
				// % protected region % [Customise your display name for Process Workflow Logs here] off begin
				displayName: 'stepNumber',
				// % protected region % [Customise your display name for Process Workflow Logs here] end
				validators: [
					// % protected region % [Add other validators for Process Workflow Logs here] off begin
					// % protected region % [Add other validators for Process Workflow Logs here] end
				],
				// % protected region % [Add any additional field for relation Process Workflow Logs here] off begin
				// % protected region % [Add any additional field for relation Process Workflow Logs here] end
			},
			{
				id: 'registrations',
				type: ModelRelationType.MANY,
				name: 'registrationsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Registrations here] off begin
				label: 'Registrations',
				// % protected region % [Customise your 1-1 or 1-M label for Registrations here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Registrations here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Registrations here] end
				validators: [
					// % protected region % [Add other validators for Registrations here] off begin
					// % protected region % [Add other validators for Registrations here] end
				],
				// % protected region % [Add any additional field for relation Registrations here] off begin
				// % protected region % [Add any additional field for relation Registrations here] end
			},
			{
				id: 'requestedBy',
				type: ModelRelationType.MANY,
				name: 'requestedByIds',
				// % protected region % [Customise your 1-1 or 1-M label for Requested By here] off begin
				label: 'Requested By',
				// % protected region % [Customise your 1-1 or 1-M label for Requested By here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Requested By here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Requested By here] end
				validators: [
					// % protected region % [Add other validators for Requested By here] off begin
					// % protected region % [Add other validators for Requested By here] end
				],
				// % protected region % [Add any additional field for relation Requested By here] off begin
				// % protected region % [Add any additional field for relation Requested By here] end
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
				id: 'sampleCollectionStaffs',
				type: ModelRelationType.MANY,
				name: 'sampleCollectionStaffsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Sample Collection Staffs here] off begin
				label: 'Sample Collection Staffs',
				// % protected region % [Customise your 1-1 or 1-M label for Sample Collection Staffs here] end
				entityName: 'SampleCollectionItemsModel',
				// % protected region % [Customise your display name for Sample Collection Staffs here] off begin
				displayName: 'sampleType',
				// % protected region % [Customise your display name for Sample Collection Staffs here] end
				validators: [
					// % protected region % [Add other validators for Sample Collection Staffs here] off begin
					// % protected region % [Add other validators for Sample Collection Staffs here] end
				],
				// % protected region % [Add any additional field for relation Sample Collection Staffs here] off begin
				// % protected region % [Add any additional field for relation Sample Collection Staffs here] end
			},
			{
				id: 'sampleDeliveryStaffs',
				type: ModelRelationType.MANY,
				name: 'sampleDeliveryStaffsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Sample Delivery Staffs here] off begin
				label: 'Sample Delivery Staffs',
				// % protected region % [Customise your 1-1 or 1-M label for Sample Delivery Staffs here] end
				entityName: 'SampleCollectionItemsModel',
				// % protected region % [Customise your display name for Sample Delivery Staffs here] off begin
				displayName: 'sampleType',
				// % protected region % [Customise your display name for Sample Delivery Staffs here] end
				validators: [
					// % protected region % [Add other validators for Sample Delivery Staffs here] off begin
					// % protected region % [Add other validators for Sample Delivery Staffs here] end
				],
				// % protected region % [Add any additional field for relation Sample Delivery Staffs here] off begin
				// % protected region % [Add any additional field for relation Sample Delivery Staffs here] end
			},
			{
				id: 'sampleProcessingStaffs',
				type: ModelRelationType.MANY,
				name: 'sampleProcessingStaffsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Sample Processing Staffs here] off begin
				label: 'Sample Processing Staffs',
				// % protected region % [Customise your 1-1 or 1-M label for Sample Processing Staffs here] end
				entityName: 'SampleCollectionItemsModel',
				// % protected region % [Customise your display name for Sample Processing Staffs here] off begin
				displayName: 'sampleType',
				// % protected region % [Customise your display name for Sample Processing Staffs here] end
				validators: [
					// % protected region % [Add other validators for Sample Processing Staffs here] off begin
					// % protected region % [Add other validators for Sample Processing Staffs here] end
				],
				// % protected region % [Add any additional field for relation Sample Processing Staffs here] off begin
				// % protected region % [Add any additional field for relation Sample Processing Staffs here] end
			},
			{
				id: 'service',
				type: ModelRelationType.ONE,
				name: 'serviceId',
				// % protected region % [Customise your 1-1 or 1-M label for Service here] off begin
				label: 'Service',
				// % protected region % [Customise your 1-1 or 1-M label for Service here] end
				entityName: 'ServiceModel',
				// % protected region % [Customise your display name for Service here] off begin
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
				id: 'services',
				type: ModelRelationType.MANY,
				name: 'servicesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Services here] off begin
				label: 'Services',
				// % protected region % [Customise your 1-1 or 1-M label for Services here] end
				entityName: 'ServiceModel',
				// % protected region % [Customise your display name for Services here] off begin
				displayName: 'serviceNumber',
				// % protected region % [Customise your display name for Services here] end
				validators: [
					// % protected region % [Add other validators for Services here] off begin
					// % protected region % [Add other validators for Services here] end
				],
				// % protected region % [Add any additional field for relation Services here] off begin
				// % protected region % [Add any additional field for relation Services here] end
			},
			{
				id: 'surgeon',
				type: ModelRelationType.MANY,
				name: 'surgeonIds',
				// % protected region % [Customise your 1-1 or 1-M label for Surgeon here] off begin
				label: 'Surgeon',
				// % protected region % [Customise your 1-1 or 1-M label for Surgeon here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Surgeon here] off begin
				displayName: 'startDateTime',
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
				type: ModelRelationType.MANY,
				name: 'surgicalMedicalTranscriberIds',
				// % protected region % [Customise your 1-1 or 1-M label for Surgical Medical Transcriber here] off begin
				label: 'Surgical Medical Transcriber',
				// % protected region % [Customise your 1-1 or 1-M label for Surgical Medical Transcriber here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Surgical Medical Transcriber here] off begin
				displayName: 'startDateTime',
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
				type: ModelRelationType.MANY,
				name: 'surgicalNurseIds',
				// % protected region % [Customise your 1-1 or 1-M label for Surgical Nurse here] off begin
				label: 'Surgical Nurse',
				// % protected region % [Customise your 1-1 or 1-M label for Surgical Nurse here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Surgical Nurse here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Surgical Nurse here] end
				validators: [
					// % protected region % [Add other validators for Surgical Nurse here] off begin
					// % protected region % [Add other validators for Surgical Nurse here] end
				],
				// % protected region % [Add any additional field for relation Surgical Nurse here] off begin
				// % protected region % [Add any additional field for relation Surgical Nurse here] end
			},
			{
				id: 'transferOrderStockDetails',
				type: ModelRelationType.MANY,
				name: 'transferOrderStockDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Transfer Order Stock Details here] off begin
				label: 'Transfer Order Stock Details',
				// % protected region % [Customise your 1-1 or 1-M label for Transfer Order Stock Details here] end
				entityName: 'TransferOrderStockDetailModel',
				// % protected region % [Customise your display name for Transfer Order Stock Details here] off begin
				displayName: 'itemNumber',
				// % protected region % [Customise your display name for Transfer Order Stock Details here] end
				validators: [
					// % protected region % [Add other validators for Transfer Order Stock Details here] off begin
					// % protected region % [Add other validators for Transfer Order Stock Details here] end
				],
				// % protected region % [Add any additional field for relation Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional field for relation Transfer Order Stock Details here] end
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
				id: 'administrationUser',
				type: ModelRelationType.ONE,
				name: 'administrationUserId',
				// % protected region % [Customise your label for Administration User here] off begin
				label: 'Administration User',
				// % protected region % [Customise your label for Administration User here] end
				entityName: 'AdministrationUserModel',
				// % protected region % [Customise your display name for Administration User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Administration User here] end
				validators: [
					// % protected region % [Add other validators for Administration User here] off begin
					// % protected region % [Add other validators for Administration User here] end
				],
				// % protected region % [Add any additional field for relation Administration User here] off begin
				// % protected region % [Add any additional field for relation Administration User here] end
			},
			{
				id: 'cashierUser',
				type: ModelRelationType.ONE,
				name: 'cashierUserId',
				// % protected region % [Customise your label for Cashier User here] off begin
				label: 'Cashier User',
				// % protected region % [Customise your label for Cashier User here] end
				entityName: 'CashierUserModel',
				// % protected region % [Customise your display name for Cashier User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Cashier User here] end
				validators: [
					// % protected region % [Add other validators for Cashier User here] off begin
					// % protected region % [Add other validators for Cashier User here] end
				],
				// % protected region % [Add any additional field for relation Cashier User here] off begin
				// % protected region % [Add any additional field for relation Cashier User here] end
			},
			{
				id: 'claimUser',
				type: ModelRelationType.ONE,
				name: 'claimUserId',
				// % protected region % [Customise your label for Claim User here] off begin
				label: 'Claim User',
				// % protected region % [Customise your label for Claim User here] end
				entityName: 'ClaimUserModel',
				// % protected region % [Customise your display name for Claim User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Claim User here] end
				validators: [
					// % protected region % [Add other validators for Claim User here] off begin
					// % protected region % [Add other validators for Claim User here] end
				],
				// % protected region % [Add any additional field for relation Claim User here] off begin
				// % protected region % [Add any additional field for relation Claim User here] end
			},
			{
				id: 'diagnosticSupportUser',
				type: ModelRelationType.ONE,
				name: 'diagnosticSupportUserId',
				// % protected region % [Customise your label for Diagnostic Support User here] off begin
				label: 'Diagnostic Support User',
				// % protected region % [Customise your label for Diagnostic Support User here] end
				entityName: 'DiagnosticSupportUserModel',
				// % protected region % [Customise your display name for Diagnostic Support User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Diagnostic Support User here] end
				validators: [
					// % protected region % [Add other validators for Diagnostic Support User here] off begin
					// % protected region % [Add other validators for Diagnostic Support User here] end
				],
				// % protected region % [Add any additional field for relation Diagnostic Support User here] off begin
				// % protected region % [Add any additional field for relation Diagnostic Support User here] end
			},
			{
				id: 'doctorUser',
				type: ModelRelationType.ONE,
				name: 'doctorUserId',
				// % protected region % [Customise your label for Doctor User here] off begin
				label: 'Doctor User',
				// % protected region % [Customise your label for Doctor User here] end
				entityName: 'DoctorUserModel',
				// % protected region % [Customise your display name for Doctor User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Doctor User here] end
				validators: [
					// % protected region % [Add other validators for Doctor User here] off begin
					// % protected region % [Add other validators for Doctor User here] end
				],
				// % protected region % [Add any additional field for relation Doctor User here] off begin
				// % protected region % [Add any additional field for relation Doctor User here] end
			},
			{
				id: 'facilityUser',
				type: ModelRelationType.ONE,
				name: 'facilityUserId',
				// % protected region % [Customise your label for Facility User here] off begin
				label: 'Facility User',
				// % protected region % [Customise your label for Facility User here] end
				entityName: 'FacilityUserModel',
				// % protected region % [Customise your display name for Facility User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Facility User here] end
				validators: [
					// % protected region % [Add other validators for Facility User here] off begin
					// % protected region % [Add other validators for Facility User here] end
				],
				// % protected region % [Add any additional field for relation Facility User here] off begin
				// % protected region % [Add any additional field for relation Facility User here] end
			},
			{
				id: 'managementUser',
				type: ModelRelationType.ONE,
				name: 'managementUserId',
				// % protected region % [Customise your label for Management User here] off begin
				label: 'Management User',
				// % protected region % [Customise your label for Management User here] end
				entityName: 'ManagementUserModel',
				// % protected region % [Customise your display name for Management User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Management User here] end
				validators: [
					// % protected region % [Add other validators for Management User here] off begin
					// % protected region % [Add other validators for Management User here] end
				],
				// % protected region % [Add any additional field for relation Management User here] off begin
				// % protected region % [Add any additional field for relation Management User here] end
			},
			{
				id: 'medicalRecordUser',
				type: ModelRelationType.ONE,
				name: 'medicalRecordUserId',
				// % protected region % [Customise your label for Medical Record user here] off begin
				label: 'Medical Record user',
				// % protected region % [Customise your label for Medical Record user here] end
				entityName: 'MedicalRecordUserModel',
				// % protected region % [Customise your display name for Medical Record user here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Medical Record user here] end
				validators: [
					// % protected region % [Add other validators for Medical Record user here] off begin
					// % protected region % [Add other validators for Medical Record user here] end
				],
				// % protected region % [Add any additional field for relation Medical Record user here] off begin
				// % protected region % [Add any additional field for relation Medical Record user here] end
			},
			{
				id: 'medicalTranscriberUser',
				type: ModelRelationType.ONE,
				name: 'medicalTranscriberUserId',
				// % protected region % [Customise your label for Medical Transcriber User here] off begin
				label: 'Medical Transcriber User',
				// % protected region % [Customise your label for Medical Transcriber User here] end
				entityName: 'MedicalTranscriberUserModel',
				// % protected region % [Customise your display name for Medical Transcriber User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Medical Transcriber User here] end
				validators: [
					// % protected region % [Add other validators for Medical Transcriber User here] off begin
					// % protected region % [Add other validators for Medical Transcriber User here] end
				],
				// % protected region % [Add any additional field for relation Medical Transcriber User here] off begin
				// % protected region % [Add any additional field for relation Medical Transcriber User here] end
			},
			{
				id: 'nurseUser',
				type: ModelRelationType.ONE,
				name: 'nurseUserId',
				// % protected region % [Customise your label for Nurse User here] off begin
				label: 'Nurse User',
				// % protected region % [Customise your label for Nurse User here] end
				entityName: 'NurseUserModel',
				// % protected region % [Customise your display name for Nurse User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Nurse User here] end
				validators: [
					// % protected region % [Add other validators for Nurse User here] off begin
					// % protected region % [Add other validators for Nurse User here] end
				],
				// % protected region % [Add any additional field for relation Nurse User here] off begin
				// % protected region % [Add any additional field for relation Nurse User here] end
			},
			{
				id: 'pharmacyUser',
				type: ModelRelationType.ONE,
				name: 'pharmacyUserId',
				// % protected region % [Customise your label for Pharmacy User here] off begin
				label: 'Pharmacy User',
				// % protected region % [Customise your label for Pharmacy User here] end
				entityName: 'PharmacyUserModel',
				// % protected region % [Customise your display name for Pharmacy User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Pharmacy User here] end
				validators: [
					// % protected region % [Add other validators for Pharmacy User here] off begin
					// % protected region % [Add other validators for Pharmacy User here] end
				],
				// % protected region % [Add any additional field for relation Pharmacy User here] off begin
				// % protected region % [Add any additional field for relation Pharmacy User here] end
			},
			{
				id: 'purchasingUser',
				type: ModelRelationType.ONE,
				name: 'purchasingUserId',
				// % protected region % [Customise your label for Purchasing User here] off begin
				label: 'Purchasing User',
				// % protected region % [Customise your label for Purchasing User here] end
				entityName: 'PurchasingUserModel',
				// % protected region % [Customise your display name for Purchasing User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Purchasing User here] end
				validators: [
					// % protected region % [Add other validators for Purchasing User here] off begin
					// % protected region % [Add other validators for Purchasing User here] end
				],
				// % protected region % [Add any additional field for relation Purchasing User here] off begin
				// % protected region % [Add any additional field for relation Purchasing User here] end
			},
			{
				id: 'registrationUser',
				type: ModelRelationType.ONE,
				name: 'registrationUserId',
				// % protected region % [Customise your label for Registration User here] off begin
				label: 'Registration User',
				// % protected region % [Customise your label for Registration User here] end
				entityName: 'RegistrationUserModel',
				// % protected region % [Customise your display name for Registration User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Registration User here] end
				validators: [
					// % protected region % [Add other validators for Registration User here] off begin
					// % protected region % [Add other validators for Registration User here] end
				],
				// % protected region % [Add any additional field for relation Registration User here] off begin
				// % protected region % [Add any additional field for relation Registration User here] end
			},
			{
				id: 'systemAdminUser',
				type: ModelRelationType.ONE,
				name: 'systemAdminUserId',
				// % protected region % [Customise your label for System Admin User here] off begin
				label: 'System Admin User',
				// % protected region % [Customise your label for System Admin User here] end
				entityName: 'SystemAdminUserModel',
				// % protected region % [Customise your display name for System Admin User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for System Admin User here] end
				validators: [
					// % protected region % [Add other validators for System Admin User here] off begin
					// % protected region % [Add other validators for System Admin User here] end
				],
				// % protected region % [Add any additional field for relation System Admin User here] off begin
				// % protected region % [Add any additional field for relation System Admin User here] end
			},
			{
				id: 'warehouseUser',
				type: ModelRelationType.ONE,
				name: 'warehouseUserId',
				// % protected region % [Customise your label for Warehouse User here] off begin
				label: 'Warehouse User',
				// % protected region % [Customise your label for Warehouse User here] end
				entityName: 'WarehouseUserModel',
				// % protected region % [Customise your display name for Warehouse User here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'email',
				// % protected region % [Customise your display name for Warehouse User here] end
				validators: [
					// % protected region % [Add other validators for Warehouse User here] off begin
					// % protected region % [Add other validators for Warehouse User here] end
				],
				// % protected region % [Add any additional field for relation Warehouse User here] off begin
				// % protected region % [Add any additional field for relation Warehouse User here] end
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
				case 'staffNumber':
					break;
				case 'firstName':
					break;
				case 'lastName':
					break;
				case 'staffType':
					break;
				case 'specialization':
					break;
				case 'education':
					break;
				case 'licenseNo':
					break;
				case 'letterOfReg':
					break;
				case 'gender':
					break;
				case 'employeeID':
					break;
				case 'defaultServiceNumber':
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
	static deepParse(data: string | { [K in keyof StaffModel]?: StaffModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new StaffModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.administrator) {
			currentModel.administratorId = json.administrator.id;
			returned = _.union(returned, AdministratorModel.deepParse(json.administrator));
		}

		// Outgoing one to one
		if (json.bpjsDoctorMapping) {
			currentModel.bpjsDoctorMappingId = json.bpjsDoctorMapping.id;
			returned = _.union(returned, BpjsDoctorMappingModel.deepParse(json.bpjsDoctorMapping));
		}

		// Outgoing one to one
		if (json.pcareDokter) {
			currentModel.pcareDokterId = json.pcareDokter.id;
			returned = _.union(returned, PcareDokterModel.deepParse(json.pcareDokter));
		}

		// Outgoing one to one
		if (json.service) {
			currentModel.serviceId = json.service.id;
			returned = _.union(returned, ServiceModel.deepParse(json.service));
		}

		// Incoming one to one
		if (json.administrationUser) {
			currentModel.administrationUserId = json.administrationUser.id;
			returned = _.union(returned, AdministrationUserModel.deepParse(json.administrationUser));
		}

		// Incoming one to one
		if (json.cashierUser) {
			currentModel.cashierUserId = json.cashierUser.id;
			returned = _.union(returned, CashierUserModel.deepParse(json.cashierUser));
		}

		// Incoming one to one
		if (json.claimUser) {
			currentModel.claimUserId = json.claimUser.id;
			returned = _.union(returned, ClaimUserModel.deepParse(json.claimUser));
		}

		// Incoming one to one
		if (json.diagnosticSupportUser) {
			currentModel.diagnosticSupportUserId = json.diagnosticSupportUser.id;
			returned = _.union(returned, DiagnosticSupportUserModel.deepParse(json.diagnosticSupportUser));
		}

		// Incoming one to one
		if (json.doctorUser) {
			currentModel.doctorUserId = json.doctorUser.id;
			returned = _.union(returned, DoctorUserModel.deepParse(json.doctorUser));
		}

		// Incoming one to one
		if (json.facilityUser) {
			currentModel.facilityUserId = json.facilityUser.id;
			returned = _.union(returned, FacilityUserModel.deepParse(json.facilityUser));
		}

		// Incoming one to one
		if (json.managementUser) {
			currentModel.managementUserId = json.managementUser.id;
			returned = _.union(returned, ManagementUserModel.deepParse(json.managementUser));
		}

		// Incoming one to one
		if (json.medicalRecordUser) {
			currentModel.medicalRecordUserId = json.medicalRecordUser.id;
			returned = _.union(returned, MedicalRecordUserModel.deepParse(json.medicalRecordUser));
		}

		// Incoming one to one
		if (json.medicalTranscriberUser) {
			currentModel.medicalTranscriberUserId = json.medicalTranscriberUser.id;
			returned = _.union(returned, MedicalTranscriberUserModel.deepParse(json.medicalTranscriberUser));
		}

		// Incoming one to one
		if (json.nurseUser) {
			currentModel.nurseUserId = json.nurseUser.id;
			returned = _.union(returned, NurseUserModel.deepParse(json.nurseUser));
		}

		// Incoming one to one
		if (json.pharmacyUser) {
			currentModel.pharmacyUserId = json.pharmacyUser.id;
			returned = _.union(returned, PharmacyUserModel.deepParse(json.pharmacyUser));
		}

		// Incoming one to one
		if (json.purchasingUser) {
			currentModel.purchasingUserId = json.purchasingUser.id;
			returned = _.union(returned, PurchasingUserModel.deepParse(json.purchasingUser));
		}

		// Incoming one to one
		if (json.registrationUser) {
			currentModel.registrationUserId = json.registrationUser.id;
			returned = _.union(returned, RegistrationUserModel.deepParse(json.registrationUser));
		}

		// Incoming one to one
		if (json.systemAdminUser) {
			currentModel.systemAdminUserId = json.systemAdminUser.id;
			returned = _.union(returned, SystemAdminUserModel.deepParse(json.systemAdminUser));
		}

		// Incoming one to one
		if (json.warehouseUser) {
			currentModel.warehouseUserId = json.warehouseUser.id;
			returned = _.union(returned, WarehouseUserModel.deepParse(json.warehouseUser));
		}

		// Outgoing one to many
		if (json.accompanyingConsents) {
			currentModel.accompanyingConsentsIds = json.accompanyingConsents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.accompanyingConsents.map(model => InformedConsentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.amendmentDetails) {
			currentModel.amendmentDetailsIds = json.amendmentDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.amendmentDetails.map(model => AmendmentDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.anesthesiaMedicalTranscriber) {
			currentModel.anesthesiaMedicalTranscriberIds = json.anesthesiaMedicalTranscriber.map(model => model.id);
			returned = _.union(returned, _.flatten(json.anesthesiaMedicalTranscriber.map(model => PreoperativeRecordsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.anesthesiologist) {
			currentModel.anesthesiologistIds = json.anesthesiologist.map(model => model.id);
			returned = _.union(returned, _.flatten(json.anesthesiologist.map(model => PreoperativeRecordsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.anesthesiologyNurse) {
			currentModel.anesthesiologyNurseIds = json.anesthesiologyNurse.map(model => model.id);
			returned = _.union(returned, _.flatten(json.anesthesiologyNurse.map(model => PreoperativeRecordsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.cashierStaff) {
			currentModel.cashierStaffIds = json.cashierStaff.map(model => model.id);
			returned = _.union(returned, _.flatten(json.cashierStaff.map(model => CashReceiptModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.coTreatingDoctors) {
			currentModel.coTreatingDoctorsIds = json.coTreatingDoctors.map(model => model.id);
			returned = _.union(returned, _.flatten(json.coTreatingDoctors.map(model => CoTreatingDoctorModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.dailyCareCPPTsCreatedByStaff) {
			currentModel.dailyCareCPPTsCreatedByStaffIds = json.dailyCareCPPTsCreatedByStaff.map(model => model.id);
			returned = _.union(returned, _.flatten(json.dailyCareCPPTsCreatedByStaff.map(model => DailyCareCPPTModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.dailyCareCPPTsDoctorInCharge) {
			currentModel.dailyCareCPPTsDoctorInChargeIds = json.dailyCareCPPTsDoctorInCharge.map(model => model.id);
			returned = _.union(returned, _.flatten(json.dailyCareCPPTsDoctorInCharge.map(model => DailyCareCPPTModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.dailyCareCPPTsMedicalTranscriber) {
			currentModel.dailyCareCPPTsMedicalTranscriberIds = json.dailyCareCPPTsMedicalTranscriber.map(model => model.id);
			returned = _.union(returned, _.flatten(json.dailyCareCPPTsMedicalTranscriber.map(model => DailyCareCPPTModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.deliveryProgresses) {
			currentModel.deliveryProgressesIds = json.deliveryProgresses.map(model => model.id);
			returned = _.union(returned, _.flatten(json.deliveryProgresses.map(model => DeliveryProgressModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.diagnosticStaffExaminationSummaries) {
			currentModel.diagnosticStaffExaminationSummariesIds = json.diagnosticStaffExaminationSummaries.map(model => model.id);
			returned = _.union(returned, _.flatten(json.diagnosticStaffExaminationSummaries.map(model => DiagnosticStaffExaminationSummaryModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.dismissalReferringStaff) {
			currentModel.dismissalReferringStaffIds = json.dismissalReferringStaff.map(model => model.id);
			returned = _.union(returned, _.flatten(json.dismissalReferringStaff.map(model => RegistrationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.doctorSchedules) {
			currentModel.doctorSchedulesIds = json.doctorSchedules.map(model => model.id);
			returned = _.union(returned, _.flatten(json.doctorSchedules.map(model => DoctorScheduleModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.doctorOnExamination) {
			currentModel.doctorOnExaminationIds = json.doctorOnExamination.map(model => model.id);
			returned = _.union(returned, _.flatten(json.doctorOnExamination.map(model => MedicalExaminationRecordModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.fluidBalanceDetails) {
			currentModel.fluidBalanceDetailsIds = json.fluidBalanceDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.fluidBalanceDetails.map(model => FluidBalanceDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.hemodialysisMonitorings) {
			currentModel.hemodialysisMonitoringsIds = json.hemodialysisMonitorings.map(model => model.id);
			returned = _.union(returned, _.flatten(json.hemodialysisMonitorings.map(model => HemodialysisMonitoringModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.hospitalBranchInformations) {
			currentModel.hospitalBranchInformationsIds = json.hospitalBranchInformations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.hospitalBranchInformations.map(model => HospitalBranchInformationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.informingConsents) {
			currentModel.informingConsentsIds = json.informingConsents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.informingConsents.map(model => InformedConsentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.invoices) {
			currentModel.invoicesIds = json.invoices.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoices.map(model => InvoiceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.mcuPackageItems) {
			currentModel.mcuPackageItemsIds = json.mcuPackageItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.mcuPackageItems.map(model => McuPackageItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalCertificateDischargeResumes) {
			currentModel.medicalCertificateDischargeResumesIds = json.medicalCertificateDischargeResumes.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalCertificateDischargeResumes.map(model => MedicalCertificateDischargeResumeModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalCertificateBirths) {
			currentModel.medicalCertificateBirthsIds = json.medicalCertificateBirths.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalCertificateBirths.map(model => MedicalCertificateBirthModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalCertificateHospitalizations) {
			currentModel.medicalCertificateHospitalizationsIds = json.medicalCertificateHospitalizations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalCertificateHospitalizations.map(model => MedicalCertificateHospitalizationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalExaminationRecordDischargeSummarys) {
			currentModel.medicalExaminationRecordDischargeSummarysIds = json.medicalExaminationRecordDischargeSummarys.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalExaminationRecordDischargeSummarys.map(model => MedicalExaminationRecordDischargeSummaryModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalRecordTranscriber) {
			currentModel.medicalRecordTranscriberIds = json.medicalRecordTranscriber.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalRecordTranscriber.map(model => MedicalExaminationRecordModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalStaffOfMedicalAttendancesCertificate) {
			currentModel.medicalStaffOfMedicalAttendancesCertificateIds = json.medicalStaffOfMedicalAttendancesCertificate.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalStaffOfMedicalAttendancesCertificate.map(model => MedicalCertificateMedicalAttendanceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalStaffOfMentalHealths) {
			currentModel.medicalStaffOfMentalHealthsIds = json.medicalStaffOfMentalHealths.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalStaffOfMentalHealths.map(model => MedicalCertificateMentalHealthModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalStaffOfPhysicalHealths) {
			currentModel.medicalStaffOfPhysicalHealthsIds = json.medicalStaffOfPhysicalHealths.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalStaffOfPhysicalHealths.map(model => MedicalCertificatePhysicalHealthModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalStaffOfRestrictedWorksCertificate) {
			currentModel.medicalStaffOfRestrictedWorksCertificateIds = json.medicalStaffOfRestrictedWorksCertificate.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalStaffOfRestrictedWorksCertificate.map(model => MedicalCertificateRestrictedWorkModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicalStaffOfSickLeavesCertificate) {
			currentModel.medicalStaffOfSickLeavesCertificateIds = json.medicalStaffOfSickLeavesCertificate.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicalStaffOfSickLeavesCertificate.map(model => MedicalCertificateSickLeaveModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicationAdministeredHisotries) {
			currentModel.medicationAdministeredHisotriesIds = json.medicationAdministeredHisotries.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationAdministeredHisotries.map(model => MedicationAdministeredHistoryModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicationHeaders) {
			currentModel.medicationHeadersIds = json.medicationHeaders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationHeaders.map(model => MedicationHeaderModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.midwives) {
			currentModel.midwivesIds = json.midwives.map(model => model.id);
			returned = _.union(returned, _.flatten(json.midwives.map(model => DeliveryMedicalExaminationRecordModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.nurse) {
			currentModel.nurseIds = json.nurse.map(model => model.id);
			returned = _.union(returned, _.flatten(json.nurse.map(model => MedicalExaminationRecordModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.nursingDetailSurgicalNursing) {
			currentModel.nursingDetailSurgicalNursingIds = json.nursingDetailSurgicalNursing.map(model => model.id);
			returned = _.union(returned, _.flatten(json.nursingDetailSurgicalNursing.map(model => OperatingTheaterMedicalExaminationRecordModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.nursingDetailsAnesthesiaNursing) {
			currentModel.nursingDetailsAnesthesiaNursingIds = json.nursingDetailsAnesthesiaNursing.map(model => model.id);
			returned = _.union(returned, _.flatten(json.nursingDetailsAnesthesiaNursing.map(model => OperatingTheaterMedicalExaminationRecordModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.patientConsents) {
			currentModel.patientConsentsIds = json.patientConsents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.patientConsents.map(model => PatientConsentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.patientVitalInformations) {
			currentModel.patientVitalInformationsIds = json.patientVitalInformations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.patientVitalInformations.map(model => PatientVitalInformationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.pediatricianInCharge) {
			currentModel.pediatricianInChargeIds = json.pediatricianInCharge.map(model => model.id);
			returned = _.union(returned, _.flatten(json.pediatricianInCharge.map(model => NewbornDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.prescriptionHeaders) {
			currentModel.prescriptionHeadersIds = json.prescriptionHeaders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.prescriptionHeaders.map(model => PrescriptionHeaderModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.processWorkflowLogs) {
			currentModel.processWorkflowLogsIds = json.processWorkflowLogs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.processWorkflowLogs.map(model => ProcessWorkflowModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.registrations) {
			currentModel.registrationsIds = json.registrations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.registrations.map(model => RegistrationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.requestedBy) {
			currentModel.requestedByIds = json.requestedBy.map(model => model.id);
			returned = _.union(returned, _.flatten(json.requestedBy.map(model => RegistrationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.roomTransfers) {
			currentModel.roomTransfersIds = json.roomTransfers.map(model => model.id);
			returned = _.union(returned, _.flatten(json.roomTransfers.map(model => RoomTransferModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.sampleCollectionStaffs) {
			currentModel.sampleCollectionStaffsIds = json.sampleCollectionStaffs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.sampleCollectionStaffs.map(model => SampleCollectionItemsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.sampleDeliveryStaffs) {
			currentModel.sampleDeliveryStaffsIds = json.sampleDeliveryStaffs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.sampleDeliveryStaffs.map(model => SampleCollectionItemsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.sampleProcessingStaffs) {
			currentModel.sampleProcessingStaffsIds = json.sampleProcessingStaffs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.sampleProcessingStaffs.map(model => SampleCollectionItemsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.surgeon) {
			currentModel.surgeonIds = json.surgeon.map(model => model.id);
			returned = _.union(returned, _.flatten(json.surgeon.map(model => PreoperativeRecordsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.surgicalMedicalTranscriber) {
			currentModel.surgicalMedicalTranscriberIds = json.surgicalMedicalTranscriber.map(model => model.id);
			returned = _.union(returned, _.flatten(json.surgicalMedicalTranscriber.map(model => PreoperativeRecordsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.surgicalNurse) {
			currentModel.surgicalNurseIds = json.surgicalNurse.map(model => model.id);
			returned = _.union(returned, _.flatten(json.surgicalNurse.map(model => PreoperativeRecordsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.transferOrderStockDetails) {
			currentModel.transferOrderStockDetailsIds = json.transferOrderStockDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.transferOrderStockDetails.map(model => TransferOrderStockDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.vaccinationOrders) {
			currentModel.vaccinationOrdersIds = json.vaccinationOrders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.vaccinationOrders.map(model => VaccinationOrderModel.deepParse(model))));
		}
		// Outgoing many to many
		if (json.services) {
			currentModel.servicesIds = json.services.map(model => model.id);
			returned = _.union(returned, _.flatten(json.services.map(model => ServiceModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let staffModel = new StaffModel(data);`
	 *
	 * @param data The input data to be initialised as the StaffModel,
	 *    it is expected as a JSON string or as a nullable StaffModel.
	 */
	constructor(data?: string | Partial<StaffModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<StaffModel>
				: data;

			this.staffNumber = json.staffNumber;
			this.firstName = json.firstName;
			this.lastName = json.lastName;
			if (json.dateOfBirth) {
				this.dateOfBirth = new Date(json.dateOfBirth);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dateOfBirth = json.dateOfBirth;
			}
			this.staffType = json.staffType;
			this.specialization = json.specialization;
			this.staffPicture = json.staffPicture?.map(item => new FileModel(item));
			this.education = json.education;
			this.licenseNo = json.licenseNo;
			this.letterOfReg = json.letterOfReg;
			this.gender = json.gender;
			this.employeeID = json.employeeID;
			this.title = json.title;
			this.defaultServiceNumber = json.defaultServiceNumber;
			this.placeOfBirth = json.placeOfBirth;
			this.religion = json.religion;
			this.bloodType = json.bloodType;
			this.rhesus = json.rhesus;
			this.address = json.address;
			this.country = json.country;
			this.state = json.state;
			this.regency = json.regency;
			this.district = json.district;
			this.homePhoneNo = json.homePhoneNo;
			this.village = json.village;
			this.postcode = json.postcode;
			this.officePhoneNumber = json.officePhoneNumber;
			this.taxIdentificationNo = json.taxIdentificationNo;
			this.mobilePhoneNo = json.mobilePhoneNo;
			this.otherNotes = json.otherNotes;
			this.training = json.training;
			this.nationality = json.nationality;
			this.certification = json.certification;
			this.extNo = json.extNo;
			this.maritalStatus = json.maritalStatus;
			this.email = json.email;
			this.bloodType = json.bloodType;
			this.rhesus = json.rhesus;
			this.administratorId = json.administratorId;
			this.administrator = json.administrator;
			this.bpjsDoctorMappingId = json.bpjsDoctorMappingId;
			this.bpjsDoctorMapping = json.bpjsDoctorMapping;
			this.pcareDokterId = json.pcareDokterId;
			this.pcareDokter = json.pcareDokter;
			this.serviceId = json.serviceId;
			this.service = json.service;
			this.administrationUserId = json.administrationUserId;
			this.administrationUser = json.administrationUser;
			this.cashierUserId = json.cashierUserId;
			this.cashierUser = json.cashierUser;
			this.claimUserId = json.claimUserId;
			this.claimUser = json.claimUser;
			this.diagnosticSupportUserId = json.diagnosticSupportUserId;
			this.diagnosticSupportUser = json.diagnosticSupportUser;
			this.doctorUserId = json.doctorUserId;
			this.doctorUser = json.doctorUser;
			this.facilityUserId = json.facilityUserId;
			this.facilityUser = json.facilityUser;
			this.managementUserId = json.managementUserId;
			this.managementUser = json.managementUser;
			this.medicalRecordUserId = json.medicalRecordUserId;
			this.medicalRecordUser = json.medicalRecordUser;
			this.medicalTranscriberUserId = json.medicalTranscriberUserId;
			this.medicalTranscriberUser = json.medicalTranscriberUser;
			this.nurseUserId = json.nurseUserId;
			this.nurseUser = json.nurseUser;
			this.pharmacyUserId = json.pharmacyUserId;
			this.pharmacyUser = json.pharmacyUser;
			this.purchasingUserId = json.purchasingUserId;
			this.purchasingUser = json.purchasingUser;
			this.registrationUserId = json.registrationUserId;
			this.registrationUser = json.registrationUser;
			this.systemAdminUserId = json.systemAdminUserId;
			this.systemAdminUser = json.systemAdminUser;
			this.warehouseUserId = json.warehouseUserId;
			this.warehouseUser = json.warehouseUser;
			this.accompanyingConsentsIds = json.accompanyingConsentsIds;
			this.accompanyingConsents = json.accompanyingConsents;
			this.amendmentDetailsIds = json.amendmentDetailsIds;
			this.amendmentDetails = json.amendmentDetails;
			this.anesthesiaMedicalTranscriberIds = json.anesthesiaMedicalTranscriberIds;
			this.anesthesiaMedicalTranscriber = json.anesthesiaMedicalTranscriber;
			this.anesthesiologistIds = json.anesthesiologistIds;
			this.anesthesiologist = json.anesthesiologist;
			this.anesthesiologyNurseIds = json.anesthesiologyNurseIds;
			this.anesthesiologyNurse = json.anesthesiologyNurse;
			this.cashierStaffIds = json.cashierStaffIds;
			this.cashierStaff = json.cashierStaff;
			this.coTreatingDoctorsIds = json.coTreatingDoctorsIds;
			this.coTreatingDoctors = json.coTreatingDoctors;
			this.dailyCareCPPTsCreatedByStaffIds = json.dailyCareCPPTsCreatedByStaffIds;
			this.dailyCareCPPTsCreatedByStaff = json.dailyCareCPPTsCreatedByStaff;
			this.dailyCareCPPTsDoctorInChargeIds = json.dailyCareCPPTsDoctorInChargeIds;
			this.dailyCareCPPTsDoctorInCharge = json.dailyCareCPPTsDoctorInCharge;
			this.dailyCareCPPTsMedicalTranscriberIds = json.dailyCareCPPTsMedicalTranscriberIds;
			this.dailyCareCPPTsMedicalTranscriber = json.dailyCareCPPTsMedicalTranscriber;
			this.deliveryProgressesIds = json.deliveryProgressesIds;
			this.deliveryProgresses = json.deliveryProgresses;
			this.diagnosticStaffExaminationSummariesIds = json.diagnosticStaffExaminationSummariesIds;
			this.diagnosticStaffExaminationSummaries = json.diagnosticStaffExaminationSummaries;
			this.dismissalReferringStaffIds = json.dismissalReferringStaffIds;
			this.dismissalReferringStaff = json.dismissalReferringStaff;
			this.doctorSchedulesIds = json.doctorSchedulesIds;
			this.doctorSchedules = json.doctorSchedules;
			this.doctorOnExaminationIds = json.doctorOnExaminationIds;
			this.doctorOnExamination = json.doctorOnExamination;
			this.fluidBalanceDetailsIds = json.fluidBalanceDetailsIds;
			this.fluidBalanceDetails = json.fluidBalanceDetails;
			this.hemodialysisMonitoringsIds = json.hemodialysisMonitoringsIds;
			this.hemodialysisMonitorings = json.hemodialysisMonitorings;
			this.hospitalBranchInformationsIds = json.hospitalBranchInformationsIds;
			this.hospitalBranchInformations = json.hospitalBranchInformations;
			this.informingConsentsIds = json.informingConsentsIds;
			this.informingConsents = json.informingConsents;
			this.invoicesIds = json.invoicesIds;
			this.invoices = json.invoices;
			this.mcuPackageItemsIds = json.mcuPackageItemsIds;
			this.mcuPackageItems = json.mcuPackageItems;
			this.medicalCertificateDischargeResumesIds = json.medicalCertificateDischargeResumesIds;
			this.medicalCertificateDischargeResumes = json.medicalCertificateDischargeResumes;
			this.medicalCertificateBirthsIds = json.medicalCertificateBirthsIds;
			this.medicalCertificateBirths = json.medicalCertificateBirths;
			this.medicalCertificateHospitalizationsIds = json.medicalCertificateHospitalizationsIds;
			this.medicalCertificateHospitalizations = json.medicalCertificateHospitalizations;
			this.medicalExaminationRecordDischargeSummarysIds = json.medicalExaminationRecordDischargeSummarysIds;
			this.medicalExaminationRecordDischargeSummarys = json.medicalExaminationRecordDischargeSummarys;
			this.medicalRecordTranscriberIds = json.medicalRecordTranscriberIds;
			this.medicalRecordTranscriber = json.medicalRecordTranscriber;
			this.medicalStaffOfMedicalAttendancesCertificateIds = json.medicalStaffOfMedicalAttendancesCertificateIds;
			this.medicalStaffOfMedicalAttendancesCertificate = json.medicalStaffOfMedicalAttendancesCertificate;
			this.medicalStaffOfMentalHealthsIds = json.medicalStaffOfMentalHealthsIds;
			this.medicalStaffOfMentalHealths = json.medicalStaffOfMentalHealths;
			this.medicalStaffOfPhysicalHealthsIds = json.medicalStaffOfPhysicalHealthsIds;
			this.medicalStaffOfPhysicalHealths = json.medicalStaffOfPhysicalHealths;
			this.medicalStaffOfRestrictedWorksCertificateIds = json.medicalStaffOfRestrictedWorksCertificateIds;
			this.medicalStaffOfRestrictedWorksCertificate = json.medicalStaffOfRestrictedWorksCertificate;
			this.medicalStaffOfSickLeavesCertificateIds = json.medicalStaffOfSickLeavesCertificateIds;
			this.medicalStaffOfSickLeavesCertificate = json.medicalStaffOfSickLeavesCertificate;
			this.medicationAdministeredHisotriesIds = json.medicationAdministeredHisotriesIds;
			this.medicationAdministeredHisotries = json.medicationAdministeredHisotries;
			this.medicationHeadersIds = json.medicationHeadersIds;
			this.medicationHeaders = json.medicationHeaders;
			this.midwivesIds = json.midwivesIds;
			this.midwives = json.midwives;
			this.nurseIds = json.nurseIds;
			this.nurse = json.nurse;
			this.nursingDetailSurgicalNursingIds = json.nursingDetailSurgicalNursingIds;
			this.nursingDetailSurgicalNursing = json.nursingDetailSurgicalNursing;
			this.nursingDetailsAnesthesiaNursingIds = json.nursingDetailsAnesthesiaNursingIds;
			this.nursingDetailsAnesthesiaNursing = json.nursingDetailsAnesthesiaNursing;
			this.patientConsentsIds = json.patientConsentsIds;
			this.patientConsents = json.patientConsents;
			this.patientVitalInformationsIds = json.patientVitalInformationsIds;
			this.patientVitalInformations = json.patientVitalInformations;
			this.pediatricianInChargeIds = json.pediatricianInChargeIds;
			this.pediatricianInCharge = json.pediatricianInCharge;
			this.prescriptionHeadersIds = json.prescriptionHeadersIds;
			this.prescriptionHeaders = json.prescriptionHeaders;
			this.processWorkflowLogsIds = json.processWorkflowLogsIds;
			this.processWorkflowLogs = json.processWorkflowLogs;
			this.registrationsIds = json.registrationsIds;
			this.registrations = json.registrations;
			this.requestedByIds = json.requestedByIds;
			this.requestedBy = json.requestedBy;
			this.roomTransfersIds = json.roomTransfersIds;
			this.roomTransfers = json.roomTransfers;
			this.sampleCollectionStaffsIds = json.sampleCollectionStaffsIds;
			this.sampleCollectionStaffs = json.sampleCollectionStaffs;
			this.sampleDeliveryStaffsIds = json.sampleDeliveryStaffsIds;
			this.sampleDeliveryStaffs = json.sampleDeliveryStaffs;
			this.sampleProcessingStaffsIds = json.sampleProcessingStaffsIds;
			this.sampleProcessingStaffs = json.sampleProcessingStaffs;
			this.surgeonIds = json.surgeonIds;
			this.surgeon = json.surgeon;
			this.surgicalMedicalTranscriberIds = json.surgicalMedicalTranscriberIds;
			this.surgicalMedicalTranscriber = json.surgicalMedicalTranscriber;
			this.surgicalNurseIds = json.surgicalNurseIds;
			this.surgicalNurse = json.surgicalNurse;
			this.transferOrderStockDetailsIds = json.transferOrderStockDetailsIds;
			this.transferOrderStockDetails = json.transferOrderStockDetails;
			this.vaccinationOrdersIds = json.vaccinationOrdersIds;
			this.vaccinationOrders = json.vaccinationOrders;
			this.servicesIds = json.servicesIds;
			this.services = json.services;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			staffNumber: this.staffNumber,
			firstName: this.firstName,
			lastName: this.lastName,
			dateOfBirth: this.dateOfBirth,
			staffType: this.staffType,
			specialization: this.specialization,
			staffPicture: this.staffPicture,
			education: this.education,
			licenseNo: this.licenseNo,
			letterOfReg: this.letterOfReg,
			gender: this.gender,
			employeeID: this.employeeID,
			title: this.title,
			defaultServiceNumber: this.defaultServiceNumber,
			placeOfBirth: this.placeOfBirth,
			religion: this.religion,
			bloodType: this.bloodType,
			rhesus: this.rhesus,
			address: this.address,
			country: this.country,
			state: this.state,
			regency: this.regency,
			district: this.district,
			homePhoneNo: this.homePhoneNo,
			village: this.village,
			postcode: this.postcode,
			officePhoneNumber: this.officePhoneNumber,
			taxIdentificationNo: this.taxIdentificationNo,
			mobilePhoneNo: this.mobilePhoneNo,
			otherNotes: this.otherNotes,
			training: this.training,
			nationality: this.nationality,
			certification: this.certification,
			extNo: this.extNo,
			maritalStatus: this.maritalStatus,
			email: this.email,
			administratorId: this.administratorId,
			bpjsDoctorMappingId: this.bpjsDoctorMappingId,
			pcareDokterId: this.pcareDokterId,
			serviceId: this.serviceId,
			administrationUserId: this.administrationUserId,
			cashierUserId: this.cashierUserId,
			claimUserId: this.claimUserId,
			diagnosticSupportUserId: this.diagnosticSupportUserId,
			doctorUserId: this.doctorUserId,
			facilityUserId: this.facilityUserId,
			managementUserId: this.managementUserId,
			medicalRecordUserId: this.medicalRecordUserId,
			medicalTranscriberUserId: this.medicalTranscriberUserId,
			nurseUserId: this.nurseUserId,
			pharmacyUserId: this.pharmacyUserId,
			purchasingUserId: this.purchasingUserId,
			registrationUserId: this.registrationUserId,
			systemAdminUserId: this.systemAdminUserId,
			warehouseUserId: this.warehouseUserId,
			accompanyingConsentsIds: this.accompanyingConsentsIds,
			amendmentDetailsIds: this.amendmentDetailsIds,
			anesthesiaMedicalTranscriberIds: this.anesthesiaMedicalTranscriberIds,
			anesthesiologistIds: this.anesthesiologistIds,
			anesthesiologyNurseIds: this.anesthesiologyNurseIds,
			cashierStaffIds: this.cashierStaffIds,
			coTreatingDoctorsIds: this.coTreatingDoctorsIds,
			dailyCareCPPTsCreatedByStaffIds: this.dailyCareCPPTsCreatedByStaffIds,
			dailyCareCPPTsDoctorInChargeIds: this.dailyCareCPPTsDoctorInChargeIds,
			dailyCareCPPTsMedicalTranscriberIds: this.dailyCareCPPTsMedicalTranscriberIds,
			deliveryProgressesIds: this.deliveryProgressesIds,
			diagnosticStaffExaminationSummariesIds: this.diagnosticStaffExaminationSummariesIds,
			dismissalReferringStaffIds: this.dismissalReferringStaffIds,
			doctorSchedulesIds: this.doctorSchedulesIds,
			doctorOnExaminationIds: this.doctorOnExaminationIds,
			fluidBalanceDetailsIds: this.fluidBalanceDetailsIds,
			hemodialysisMonitoringsIds: this.hemodialysisMonitoringsIds,
			hospitalBranchInformationsIds: this.hospitalBranchInformationsIds,
			informingConsentsIds: this.informingConsentsIds,
			invoicesIds: this.invoicesIds,
			mcuPackageItemsIds: this.mcuPackageItemsIds,
			medicalCertificateDischargeResumesIds: this.medicalCertificateDischargeResumesIds,
			medicalCertificateBirthsIds: this.medicalCertificateBirthsIds,
			medicalCertificateHospitalizationsIds: this.medicalCertificateHospitalizationsIds,
			medicalExaminationRecordDischargeSummarysIds: this.medicalExaminationRecordDischargeSummarysIds,
			medicalRecordTranscriberIds: this.medicalRecordTranscriberIds,
			medicalStaffOfMedicalAttendancesCertificateIds: this.medicalStaffOfMedicalAttendancesCertificateIds,
			medicalStaffOfMentalHealthsIds: this.medicalStaffOfMentalHealthsIds,
			medicalStaffOfPhysicalHealthsIds: this.medicalStaffOfPhysicalHealthsIds,
			medicalStaffOfRestrictedWorksCertificateIds: this.medicalStaffOfRestrictedWorksCertificateIds,
			medicalStaffOfSickLeavesCertificateIds: this.medicalStaffOfSickLeavesCertificateIds,
			medicationAdministeredHisotriesIds: this.medicationAdministeredHisotriesIds,
			medicationHeadersIds: this.medicationHeadersIds,
			midwivesIds: this.midwivesIds,
			nurseIds: this.nurseIds,
			nursingDetailSurgicalNursingIds: this.nursingDetailSurgicalNursingIds,
			nursingDetailsAnesthesiaNursingIds: this.nursingDetailsAnesthesiaNursingIds,
			patientConsentsIds: this.patientConsentsIds,
			patientVitalInformationsIds: this.patientVitalInformationsIds,
			pediatricianInChargeIds: this.pediatricianInChargeIds,
			prescriptionHeadersIds: this.prescriptionHeadersIds,
			processWorkflowLogsIds: this.processWorkflowLogsIds,
			registrationsIds: this.registrationsIds,
			requestedByIds: this.requestedByIds,
			roomTransfersIds: this.roomTransfersIds,
			sampleCollectionStaffsIds: this.sampleCollectionStaffsIds,
			sampleDeliveryStaffsIds: this.sampleDeliveryStaffsIds,
			sampleProcessingStaffsIds: this.sampleProcessingStaffsIds,
			surgeonIds: this.surgeonIds,
			surgicalMedicalTranscriberIds: this.surgicalMedicalTranscriberIds,
			surgicalNurseIds: this.surgicalNurseIds,
			transferOrderStockDetailsIds: this.transferOrderStockDetailsIds,
			vaccinationOrdersIds: this.vaccinationOrdersIds,
			servicesIds: this.servicesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		StaffModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): StaffModel {
		let newModelJson = this.toJSON();

		if (updates.staffNumber) {
			newModelJson.staffNumber = updates.staffNumber;
		}

		if (updates.firstName) {
			newModelJson.firstName = updates.firstName;
		}

		if (updates.lastName) {
			newModelJson.lastName = updates.lastName;
		}

		if (updates.dateOfBirth) {
			newModelJson.dateOfBirth = updates.dateOfBirth;
		}

		if (updates.staffType) {
			newModelJson.staffType = updates.staffType;
		}

		if (updates.specialization) {
			newModelJson.specialization = updates.specialization;
		}

		if (updates.staffPicture) {
			newModelJson.staffPicture = updates.staffPicture;
		}

		if (updates.education) {
			newModelJson.education = updates.education;
		}

		if (updates.licenseNo) {
			newModelJson.licenseNo = updates.licenseNo;
		}

		if (updates.letterOfReg) {
			newModelJson.letterOfReg = updates.letterOfReg;
		}

		if (updates.gender) {
			newModelJson.gender = updates.gender;
		}

		if (updates.employeeID) {
			newModelJson.employeeID = updates.employeeID;
		}

		if (updates.title) {
			newModelJson.title = updates.title;
		}

		if (updates.defaultServiceNumber) {
			newModelJson.defaultServiceNumber = updates.defaultServiceNumber;
		}

		if (updates.placeOfBirth) {
			newModelJson.placeOfBirth = updates.placeOfBirth;
		}

		if (updates.religion) {
			newModelJson.religion = updates.religion;
		}

		if (updates.bloodType) {
			newModelJson.bloodType = updates.bloodType;
		}

		if (updates.rhesus) {
			newModelJson.rhesus = updates.rhesus;
		}

		if (updates.address) {
			newModelJson.address = updates.address;
		}

		if (updates.country) {
			newModelJson.country = updates.country;
		}

		if (updates.state) {
			newModelJson.state = updates.state;
		}

		if (updates.regency) {
			newModelJson.regency = updates.regency;
		}

		if (updates.district) {
			newModelJson.district = updates.district;
		}

		if (updates.homePhoneNo) {
			newModelJson.homePhoneNo = updates.homePhoneNo;
		}

		if (updates.village) {
			newModelJson.village = updates.village;
		}

		if (updates.postcode) {
			newModelJson.postcode = updates.postcode;
		}

		if (updates.officePhoneNumber) {
			newModelJson.officePhoneNumber = updates.officePhoneNumber;
		}

		if (updates.taxIdentificationNo) {
			newModelJson.taxIdentificationNo = updates.taxIdentificationNo;
		}

		if (updates.mobilePhoneNo) {
			newModelJson.mobilePhoneNo = updates.mobilePhoneNo;
		}

		if (updates.otherNotes) {
			newModelJson.otherNotes = updates.otherNotes;
		}

		if (updates.training) {
			newModelJson.training = updates.training;
		}

		if (updates.nationality) {
			newModelJson.nationality = updates.nationality;
		}

		if (updates.certification) {
			newModelJson.certification = updates.certification;
		}

		if (updates.extNo) {
			newModelJson.extNo = updates.extNo;
		}

		if (updates.maritalStatus) {
			newModelJson.maritalStatus = updates.maritalStatus;
		}

		if (updates.email) {
			newModelJson.email = updates.email;
		}

		if (updates.bloodType) {
			newModelJson.bloodType = updates.bloodType;
		}

		if (updates.rhesus) {
			newModelJson.rhesus = updates.rhesus;
		}

		if (updates.administratorId) {
			newModelJson.administratorId = updates.administratorId;
		}

		if (updates.bpjsDoctorMappingId) {
			newModelJson.bpjsDoctorMappingId = updates.bpjsDoctorMappingId;
		}

		if (updates.pcareDokterId) {
			newModelJson.pcareDokterId = updates.pcareDokterId;
		}

		if (updates.serviceId) {
			newModelJson.serviceId = updates.serviceId;
		}

		if (updates.administrationUserId) {
			newModelJson.administrationUserId = updates.administrationUserId;
		}

		if (updates.cashierUserId) {
			newModelJson.cashierUserId = updates.cashierUserId;
		}

		if (updates.claimUserId) {
			newModelJson.claimUserId = updates.claimUserId;
		}

		if (updates.diagnosticSupportUserId) {
			newModelJson.diagnosticSupportUserId = updates.diagnosticSupportUserId;
		}

		if (updates.doctorUserId) {
			newModelJson.doctorUserId = updates.doctorUserId;
		}

		if (updates.facilityUserId) {
			newModelJson.facilityUserId = updates.facilityUserId;
		}

		if (updates.managementUserId) {
			newModelJson.managementUserId = updates.managementUserId;
		}

		if (updates.medicalRecordUserId) {
			newModelJson.medicalRecordUserId = updates.medicalRecordUserId;
		}

		if (updates.medicalTranscriberUserId) {
			newModelJson.medicalTranscriberUserId = updates.medicalTranscriberUserId;
		}

		if (updates.nurseUserId) {
			newModelJson.nurseUserId = updates.nurseUserId;
		}

		if (updates.pharmacyUserId) {
			newModelJson.pharmacyUserId = updates.pharmacyUserId;
		}

		if (updates.purchasingUserId) {
			newModelJson.purchasingUserId = updates.purchasingUserId;
		}

		if (updates.registrationUserId) {
			newModelJson.registrationUserId = updates.registrationUserId;
		}

		if (updates.systemAdminUserId) {
			newModelJson.systemAdminUserId = updates.systemAdminUserId;
		}

		if (updates.warehouseUserId) {
			newModelJson.warehouseUserId = updates.warehouseUserId;
		}

		if (updates.accompanyingConsentsIds) {
			newModelJson.accompanyingConsentsIds = updates.accompanyingConsentsIds;
		}

		if (updates.amendmentDetailsIds) {
			newModelJson.amendmentDetailsIds = updates.amendmentDetailsIds;
		}

		if (updates.anesthesiaMedicalTranscriberIds) {
			newModelJson.anesthesiaMedicalTranscriberIds = updates.anesthesiaMedicalTranscriberIds;
		}

		if (updates.anesthesiologistIds) {
			newModelJson.anesthesiologistIds = updates.anesthesiologistIds;
		}

		if (updates.anesthesiologyNurseIds) {
			newModelJson.anesthesiologyNurseIds = updates.anesthesiologyNurseIds;
		}

		if (updates.cashierStaffIds) {
			newModelJson.cashierStaffIds = updates.cashierStaffIds;
		}

		if (updates.coTreatingDoctorsIds) {
			newModelJson.coTreatingDoctorsIds = updates.coTreatingDoctorsIds;
		}

		if (updates.dailyCareCPPTsCreatedByStaffIds) {
			newModelJson.dailyCareCPPTsCreatedByStaffIds = updates.dailyCareCPPTsCreatedByStaffIds;
		}

		if (updates.dailyCareCPPTsDoctorInChargeIds) {
			newModelJson.dailyCareCPPTsDoctorInChargeIds = updates.dailyCareCPPTsDoctorInChargeIds;
		}

		if (updates.dailyCareCPPTsMedicalTranscriberIds) {
			newModelJson.dailyCareCPPTsMedicalTranscriberIds = updates.dailyCareCPPTsMedicalTranscriberIds;
		}

		if (updates.deliveryProgressesIds) {
			newModelJson.deliveryProgressesIds = updates.deliveryProgressesIds;
		}

		if (updates.diagnosticStaffExaminationSummariesIds) {
			newModelJson.diagnosticStaffExaminationSummariesIds = updates.diagnosticStaffExaminationSummariesIds;
		}

		if (updates.dismissalReferringStaffIds) {
			newModelJson.dismissalReferringStaffIds = updates.dismissalReferringStaffIds;
		}

		if (updates.doctorSchedulesIds) {
			newModelJson.doctorSchedulesIds = updates.doctorSchedulesIds;
		}

		if (updates.doctorOnExaminationIds) {
			newModelJson.doctorOnExaminationIds = updates.doctorOnExaminationIds;
		}

		if (updates.fluidBalanceDetailsIds) {
			newModelJson.fluidBalanceDetailsIds = updates.fluidBalanceDetailsIds;
		}

		if (updates.hemodialysisMonitoringsIds) {
			newModelJson.hemodialysisMonitoringsIds = updates.hemodialysisMonitoringsIds;
		}

		if (updates.hospitalBranchInformationsIds) {
			newModelJson.hospitalBranchInformationsIds = updates.hospitalBranchInformationsIds;
		}

		if (updates.informingConsentsIds) {
			newModelJson.informingConsentsIds = updates.informingConsentsIds;
		}

		if (updates.invoicesIds) {
			newModelJson.invoicesIds = updates.invoicesIds;
		}

		if (updates.mcuPackageItemsIds) {
			newModelJson.mcuPackageItemsIds = updates.mcuPackageItemsIds;
		}

		if (updates.medicalCertificateDischargeResumesIds) {
			newModelJson.medicalCertificateDischargeResumesIds = updates.medicalCertificateDischargeResumesIds;
		}

		if (updates.medicalCertificateBirthsIds) {
			newModelJson.medicalCertificateBirthsIds = updates.medicalCertificateBirthsIds;
		}

		if (updates.medicalCertificateHospitalizationsIds) {
			newModelJson.medicalCertificateHospitalizationsIds = updates.medicalCertificateHospitalizationsIds;
		}

		if (updates.medicalExaminationRecordDischargeSummarysIds) {
			newModelJson.medicalExaminationRecordDischargeSummarysIds = updates.medicalExaminationRecordDischargeSummarysIds;
		}

		if (updates.medicalRecordTranscriberIds) {
			newModelJson.medicalRecordTranscriberIds = updates.medicalRecordTranscriberIds;
		}

		if (updates.medicalStaffOfMedicalAttendancesCertificateIds) {
			newModelJson.medicalStaffOfMedicalAttendancesCertificateIds = updates.medicalStaffOfMedicalAttendancesCertificateIds;
		}

		if (updates.medicalStaffOfMentalHealthsIds) {
			newModelJson.medicalStaffOfMentalHealthsIds = updates.medicalStaffOfMentalHealthsIds;
		}

		if (updates.medicalStaffOfPhysicalHealthsIds) {
			newModelJson.medicalStaffOfPhysicalHealthsIds = updates.medicalStaffOfPhysicalHealthsIds;
		}

		if (updates.medicalStaffOfRestrictedWorksCertificateIds) {
			newModelJson.medicalStaffOfRestrictedWorksCertificateIds = updates.medicalStaffOfRestrictedWorksCertificateIds;
		}

		if (updates.medicalStaffOfSickLeavesCertificateIds) {
			newModelJson.medicalStaffOfSickLeavesCertificateIds = updates.medicalStaffOfSickLeavesCertificateIds;
		}

		if (updates.medicationAdministeredHisotriesIds) {
			newModelJson.medicationAdministeredHisotriesIds = updates.medicationAdministeredHisotriesIds;
		}

		if (updates.medicationHeadersIds) {
			newModelJson.medicationHeadersIds = updates.medicationHeadersIds;
		}

		if (updates.midwivesIds) {
			newModelJson.midwivesIds = updates.midwivesIds;
		}

		if (updates.nurseIds) {
			newModelJson.nurseIds = updates.nurseIds;
		}

		if (updates.nursingDetailSurgicalNursingIds) {
			newModelJson.nursingDetailSurgicalNursingIds = updates.nursingDetailSurgicalNursingIds;
		}

		if (updates.nursingDetailsAnesthesiaNursingIds) {
			newModelJson.nursingDetailsAnesthesiaNursingIds = updates.nursingDetailsAnesthesiaNursingIds;
		}

		if (updates.patientConsentsIds) {
			newModelJson.patientConsentsIds = updates.patientConsentsIds;
		}

		if (updates.patientVitalInformationsIds) {
			newModelJson.patientVitalInformationsIds = updates.patientVitalInformationsIds;
		}

		if (updates.pediatricianInChargeIds) {
			newModelJson.pediatricianInChargeIds = updates.pediatricianInChargeIds;
		}

		if (updates.prescriptionHeadersIds) {
			newModelJson.prescriptionHeadersIds = updates.prescriptionHeadersIds;
		}

		if (updates.processWorkflowLogsIds) {
			newModelJson.processWorkflowLogsIds = updates.processWorkflowLogsIds;
		}

		if (updates.registrationsIds) {
			newModelJson.registrationsIds = updates.registrationsIds;
		}

		if (updates.requestedByIds) {
			newModelJson.requestedByIds = updates.requestedByIds;
		}

		if (updates.roomTransfersIds) {
			newModelJson.roomTransfersIds = updates.roomTransfersIds;
		}

		if (updates.sampleCollectionStaffsIds) {
			newModelJson.sampleCollectionStaffsIds = updates.sampleCollectionStaffsIds;
		}

		if (updates.sampleDeliveryStaffsIds) {
			newModelJson.sampleDeliveryStaffsIds = updates.sampleDeliveryStaffsIds;
		}

		if (updates.sampleProcessingStaffsIds) {
			newModelJson.sampleProcessingStaffsIds = updates.sampleProcessingStaffsIds;
		}

		if (updates.surgeonIds) {
			newModelJson.surgeonIds = updates.surgeonIds;
		}

		if (updates.surgicalMedicalTranscriberIds) {
			newModelJson.surgicalMedicalTranscriberIds = updates.surgicalMedicalTranscriberIds;
		}

		if (updates.surgicalNurseIds) {
			newModelJson.surgicalNurseIds = updates.surgicalNurseIds;
		}

		if (updates.transferOrderStockDetailsIds) {
			newModelJson.transferOrderStockDetailsIds = updates.transferOrderStockDetailsIds;
		}

		if (updates.vaccinationOrdersIds) {
			newModelJson.vaccinationOrdersIds = updates.vaccinationOrdersIds;
		}

		if (updates.servicesIds) {
			newModelJson.servicesIds = updates.servicesIds;
		}

		return new StaffModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof StaffModel)) {
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
			} else if (['staffPicture'].includes(key)) {;
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
			'administratorId',
			'administrator',
			'bpjsDoctorMappingId',
			'bpjsDoctorMapping',
			'pcareDokterId',
			'pcareDokter',
			'serviceId',
			'service',
			'administrationUserId',
			'administrationUser',
			'cashierUserId',
			'cashierUser',
			'claimUserId',
			'claimUser',
			'diagnosticSupportUserId',
			'diagnosticSupportUser',
			'doctorUserId',
			'doctorUser',
			'facilityUserId',
			'facilityUser',
			'managementUserId',
			'managementUser',
			'medicalRecordUserId',
			'medicalRecordUser',
			'medicalTranscriberUserId',
			'medicalTranscriberUser',
			'nurseUserId',
			'nurseUser',
			'pharmacyUserId',
			'pharmacyUser',
			'purchasingUserId',
			'purchasingUser',
			'registrationUserId',
			'registrationUser',
			'systemAdminUserId',
			'systemAdminUser',
			'warehouseUserId',
			'warehouseUser',
			'accompanyingConsentsIds',
			'accompanyingConsents',
			'amendmentDetailsIds',
			'amendmentDetails',
			'anesthesiaMedicalTranscriberIds',
			'anesthesiaMedicalTranscriber',
			'anesthesiologistIds',
			'anesthesiologist',
			'anesthesiologyNurseIds',
			'anesthesiologyNurse',
			'cashierStaffIds',
			'cashierStaff',
			'coTreatingDoctorsIds',
			'coTreatingDoctors',
			'dailyCareCPPTsCreatedByStaffIds',
			'dailyCareCPPTsCreatedByStaff',
			'dailyCareCPPTsDoctorInChargeIds',
			'dailyCareCPPTsDoctorInCharge',
			'dailyCareCPPTsMedicalTranscriberIds',
			'dailyCareCPPTsMedicalTranscriber',
			'deliveryProgressesIds',
			'deliveryProgresses',
			'diagnosticStaffExaminationSummariesIds',
			'diagnosticStaffExaminationSummaries',
			'dismissalReferringStaffIds',
			'dismissalReferringStaff',
			'doctorSchedulesIds',
			'doctorSchedules',
			'doctorOnExaminationIds',
			'doctorOnExamination',
			'fluidBalanceDetailsIds',
			'fluidBalanceDetails',
			'hemodialysisMonitoringsIds',
			'hemodialysisMonitorings',
			'hospitalBranchInformationsIds',
			'hospitalBranchInformations',
			'informingConsentsIds',
			'informingConsents',
			'invoicesIds',
			'invoices',
			'mcuPackageItemsIds',
			'mcuPackageItems',
			'medicalCertificateDischargeResumesIds',
			'medicalCertificateDischargeResumes',
			'medicalCertificateBirthsIds',
			'medicalCertificateBirths',
			'medicalCertificateHospitalizationsIds',
			'medicalCertificateHospitalizations',
			'medicalExaminationRecordDischargeSummarysIds',
			'medicalExaminationRecordDischargeSummarys',
			'medicalRecordTranscriberIds',
			'medicalRecordTranscriber',
			'medicalStaffOfMedicalAttendancesCertificateIds',
			'medicalStaffOfMedicalAttendancesCertificate',
			'medicalStaffOfMentalHealthsIds',
			'medicalStaffOfMentalHealths',
			'medicalStaffOfPhysicalHealthsIds',
			'medicalStaffOfPhysicalHealths',
			'medicalStaffOfRestrictedWorksCertificateIds',
			'medicalStaffOfRestrictedWorksCertificate',
			'medicalStaffOfSickLeavesCertificateIds',
			'medicalStaffOfSickLeavesCertificate',
			'medicationAdministeredHisotriesIds',
			'medicationAdministeredHisotries',
			'medicationHeadersIds',
			'medicationHeaders',
			'midwivesIds',
			'midwives',
			'nurseIds',
			'nurse',
			'nursingDetailSurgicalNursingIds',
			'nursingDetailSurgicalNursing',
			'nursingDetailsAnesthesiaNursingIds',
			'nursingDetailsAnesthesiaNursing',
			'patientConsentsIds',
			'patientConsents',
			'patientVitalInformationsIds',
			'patientVitalInformations',
			'pediatricianInChargeIds',
			'pediatricianInCharge',
			'prescriptionHeadersIds',
			'prescriptionHeaders',
			'processWorkflowLogsIds',
			'processWorkflowLogs',
			'registrationsIds',
			'registrations',
			'requestedByIds',
			'requestedBy',
			'roomTransfersIds',
			'roomTransfers',
			'sampleCollectionStaffsIds',
			'sampleCollectionStaffs',
			'sampleDeliveryStaffsIds',
			'sampleDeliveryStaffs',
			'sampleProcessingStaffsIds',
			'sampleProcessingStaffs',
			'surgeonIds',
			'surgeon',
			'surgicalMedicalTranscriberIds',
			'surgicalMedicalTranscriber',
			'surgicalNurseIds',
			'surgicalNurse',
			'transferOrderStockDetailsIds',
			'transferOrderStockDetails',
			'vaccinationOrdersIds',
			'vaccinationOrders',
			'servicesIds',
			'services',
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
		if (!this.administrator) {
			this.administratorId = null;
		} else {
			this.administratorId = this.administrator.id;
		}

		if (!this.bpjsDoctorMapping) {
			this.bpjsDoctorMappingId = null;
		} else {
			this.bpjsDoctorMappingId = this.bpjsDoctorMapping.id;
		}

		if (!this.pcareDokter) {
			this.pcareDokterId = null;
		} else {
			this.pcareDokterId = this.pcareDokter.id;
		}

		if (!this.service) {
			this.serviceId = null;
		} else {
			this.serviceId = this.service.id;
		}

		if (!this.administrationUser) {
			this.administrationUserId = null;
		} else {
			this.administrationUserId = this.administrationUser.id;
		}

		if (!this.cashierUser) {
			this.cashierUserId = null;
		} else {
			this.cashierUserId = this.cashierUser.id;
		}

		if (!this.claimUser) {
			this.claimUserId = null;
		} else {
			this.claimUserId = this.claimUser.id;
		}

		if (!this.diagnosticSupportUser) {
			this.diagnosticSupportUserId = null;
		} else {
			this.diagnosticSupportUserId = this.diagnosticSupportUser.id;
		}

		if (!this.doctorUser) {
			this.doctorUserId = null;
		} else {
			this.doctorUserId = this.doctorUser.id;
		}

		if (!this.facilityUser) {
			this.facilityUserId = null;
		} else {
			this.facilityUserId = this.facilityUser.id;
		}

		if (!this.managementUser) {
			this.managementUserId = null;
		} else {
			this.managementUserId = this.managementUser.id;
		}

		if (!this.medicalRecordUser) {
			this.medicalRecordUserId = null;
		} else {
			this.medicalRecordUserId = this.medicalRecordUser.id;
		}

		if (!this.medicalTranscriberUser) {
			this.medicalTranscriberUserId = null;
		} else {
			this.medicalTranscriberUserId = this.medicalTranscriberUser.id;
		}

		if (!this.nurseUser) {
			this.nurseUserId = null;
		} else {
			this.nurseUserId = this.nurseUser.id;
		}

		if (!this.pharmacyUser) {
			this.pharmacyUserId = null;
		} else {
			this.pharmacyUserId = this.pharmacyUser.id;
		}

		if (!this.purchasingUser) {
			this.purchasingUserId = null;
		} else {
			this.purchasingUserId = this.purchasingUser.id;
		}

		if (!this.registrationUser) {
			this.registrationUserId = null;
		} else {
			this.registrationUserId = this.registrationUser.id;
		}

		if (!this.systemAdminUser) {
			this.systemAdminUserId = null;
		} else {
			this.systemAdminUserId = this.systemAdminUser.id;
		}

		if (!this.warehouseUser) {
			this.warehouseUserId = null;
		} else {
			this.warehouseUserId = this.warehouseUser.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
