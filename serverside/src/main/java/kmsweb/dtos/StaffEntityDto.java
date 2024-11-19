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

package kmsweb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.entities.enums.*;
import kmsweb.entities.*;
import kmsweb.lib.file.models.FileEntity;
import lombok.*;
import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for StaffEntity")
@EqualsAndHashCode(callSuper = false)
public class StaffEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String staffNumber;

	private String firstName;

	private String lastName;

	private OffsetDateTime dateOfBirth;

	private String staffType;

	private String specialization;

	private String education;

	private String licenseNo;

	private String letterOfReg;

	private String gender;

	private String employeeID;

	private String title;

	private String defaultServiceNumber;

	private String placeOfBirth;

	private String religion;

	private BloodTypeEnum bloodType;

	private RhesusEnum rhesus;

	private String address;

	private String country;

	private String state;

	private String regency;

	private String district;

	private String homePhoneNo;

	private String village;

	private String postcode;

	private String officePhoneNumber;

	private String taxIdentificationNo;

	private String mobilePhoneNo;

	private String otherNotes;

	private String training;

	private String nationality;

	private String certification;

	private String extNo;

	private String maritalStatus;

	private String email;

	private Set<FileEntity> staffPicture = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<InformedConsentEntity> accompanyingConsents = new HashSet<>();

	private AdministratorEntity administrator;

	private Set<AmendmentDetailEntity> amendmentDetails = new HashSet<>();

	private Set<PreoperativeRecordsEntity> anesthesiaMedicalTranscriber = new HashSet<>();

	private Set<PreoperativeRecordsEntity> anesthesiologist = new HashSet<>();

	private Set<PreoperativeRecordsEntity> anesthesiologyNurse = new HashSet<>();

	private BpjsDoctorMappingEntity bpjsDoctorMapping;

	private Set<CashReceiptEntity> cashierStaff = new HashSet<>();

	private Set<CoTreatingDoctorEntity> coTreatingDoctors = new HashSet<>();

	private Set<DailyCareCPPTEntity> dailyCareCPPTsCreatedByStaff = new HashSet<>();

	private Set<DailyCareCPPTEntity> dailyCareCPPTsDoctorInCharge = new HashSet<>();

	private Set<DailyCareCPPTEntity> dailyCareCPPTsMedicalTranscriber = new HashSet<>();

	private Set<DeliveryProgressEntity> deliveryProgresses = new HashSet<>();

	private Set<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummaries = new HashSet<>();

	private Set<RegistrationEntity> dismissalReferringStaff = new HashSet<>();

	private Set<DoctorScheduleEntity> doctorSchedules = new HashSet<>();

	private Set<MedicalExaminationRecordEntity> doctorOnExamination = new HashSet<>();

	private Set<FluidBalanceDetailEntity> fluidBalanceDetails = new HashSet<>();

	private Set<HemodialysisMonitoringEntity> hemodialysisMonitorings = new HashSet<>();

	private Set<HospitalBranchInformationEntity> hospitalBranchInformations = new HashSet<>();

	private Set<InformedConsentEntity> informingConsents = new HashSet<>();

	private Set<InvoiceEntity> invoices = new HashSet<>();

	private Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();

	private Set<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumes = new HashSet<>();

	private Set<MedicalCertificateBirthEntity> medicalCertificateBirths = new HashSet<>();

	private Set<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizations = new HashSet<>();

	private Set<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummarys = new HashSet<>();

	private Set<MedicalExaminationRecordEntity> medicalRecordTranscriber = new HashSet<>();

	private Set<MedicalCertificateMedicalAttendanceEntity> medicalStaffOfMedicalAttendancesCertificate = new HashSet<>();

	private Set<MedicalCertificateMentalHealthEntity> medicalStaffOfMentalHealths = new HashSet<>();

	private Set<MedicalCertificatePhysicalHealthEntity> medicalStaffOfPhysicalHealths = new HashSet<>();

	private Set<MedicalCertificateRestrictedWorkEntity> medicalStaffOfRestrictedWorksCertificate = new HashSet<>();

	private Set<MedicalCertificateSickLeaveEntity> medicalStaffOfSickLeavesCertificate = new HashSet<>();

	private Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotries = new HashSet<>();

	private Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();

	private Set<DeliveryMedicalExaminationRecordEntity> midwives = new HashSet<>();

	private Set<MedicalExaminationRecordEntity> nurse = new HashSet<>();

	private Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailSurgicalNursing = new HashSet<>();

	private Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailsAnesthesiaNursing = new HashSet<>();

	private PcareDokterEntity pcareDokter;

	private Set<PatientConsentEntity> patientConsents = new HashSet<>();

	private Set<PatientVitalInformationEntity> patientVitalInformations = new HashSet<>();

	private Set<NewbornDetailEntity> pediatricianInCharge = new HashSet<>();

	private Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();

	private Set<ProcessWorkflowEntity> processWorkflowLogs = new HashSet<>();

	private Set<RegistrationEntity> registrations = new HashSet<>();

	private Set<RegistrationEntity> requestedBy = new HashSet<>();

	private Set<RoomTransferEntity> roomTransfers = new HashSet<>();

	private Set<SampleCollectionItemsEntity> sampleCollectionStaffs = new HashSet<>();

	private Set<SampleCollectionItemsEntity> sampleDeliveryStaffs = new HashSet<>();

	private Set<SampleCollectionItemsEntity> sampleProcessingStaffs = new HashSet<>();

	private ServiceEntity service;

	private Set<ServiceEntity> services = new HashSet<>();

	private Set<PreoperativeRecordsEntity> surgeon = new HashSet<>();

	private Set<PreoperativeRecordsEntity> surgicalMedicalTranscriber = new HashSet<>();

	private Set<PreoperativeRecordsEntity> surgicalNurse = new HashSet<>();

	private Set<TransferOrderStockDetailEntity> transferOrderStockDetails = new HashSet<>();

	private Set<VaccinationOrderEntity> vaccinationOrders = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private AdministrationUserEntity administrationUser;

	private CashierUserEntity cashierUser;

	private ClaimUserEntity claimUser;

	private DiagnosticSupportUserEntity diagnosticSupportUser;

	private DoctorUserEntity doctorUser;

	private FacilityUserEntity facilityUser;

	private ManagementUserEntity managementUser;

	private MedicalRecordUserEntity medicalRecordUser;

	private MedicalTranscriberUserEntity medicalTranscriberUser;

	private NurseUserEntity nurseUser;

	private PharmacyUserEntity pharmacyUser;

	private PurchasingUserEntity purchasingUser;

	private RegistrationUserEntity registrationUser;

	private SystemAdminUserEntity systemAdminUser;

	private WarehouseUserEntity warehouseUser;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
