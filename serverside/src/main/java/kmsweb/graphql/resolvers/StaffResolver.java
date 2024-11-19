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

package kmsweb.graphql.resolvers;

import kmsweb.entities.*;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Component
public class StaffResolver implements GraphQLResolver<StaffEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('InformedConsentEntity', 'read')")
	public Set<InformedConsentEntity> accompanyingConsents(StaffEntity staff) {
		return staff.getAccompanyingConsents();
	}

	@PreAuthorize("hasPermission('AdministratorEntity', 'read')")
	public AdministratorEntity administrator(StaffEntity staff) {
		return staff.getAdministrator();
	}

	@PreAuthorize("hasPermission('AmendmentDetailEntity', 'read')")
	public Set<AmendmentDetailEntity> amendmentDetails(StaffEntity staff) {
		return staff.getAmendmentDetails();
	}

	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	public Set<PreoperativeRecordsEntity> anesthesiaMedicalTranscriber(StaffEntity staff) {
		return staff.getAnesthesiaMedicalTranscriber();
	}

	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	public Set<PreoperativeRecordsEntity> anesthesiologist(StaffEntity staff) {
		return staff.getAnesthesiologist();
	}

	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	public Set<PreoperativeRecordsEntity> anesthesiologyNurse(StaffEntity staff) {
		return staff.getAnesthesiologyNurse();
	}

	@PreAuthorize("hasPermission('BpjsDoctorMappingEntity', 'read')")
	public BpjsDoctorMappingEntity bpjsDoctorMapping(StaffEntity staff) {
		return staff.getBpjsDoctorMapping();
	}

	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	public Set<CashReceiptEntity> cashierStaff(StaffEntity staff) {
		return staff.getCashierStaff();
	}

	@PreAuthorize("hasPermission('CoTreatingDoctorEntity', 'read')")
	public Set<CoTreatingDoctorEntity> coTreatingDoctors(StaffEntity staff) {
		return staff.getCoTreatingDoctors();
	}

	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	public Set<DailyCareCPPTEntity> dailyCareCPPTsCreatedByStaff(StaffEntity staff) {
		return staff.getDailyCareCPPTsCreatedByStaff();
	}

	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	public Set<DailyCareCPPTEntity> dailyCareCPPTsDoctorInCharge(StaffEntity staff) {
		return staff.getDailyCareCPPTsDoctorInCharge();
	}

	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	public Set<DailyCareCPPTEntity> dailyCareCPPTsMedicalTranscriber(StaffEntity staff) {
		return staff.getDailyCareCPPTsMedicalTranscriber();
	}

	@PreAuthorize("hasPermission('DeliveryProgressEntity', 'read')")
	public Set<DeliveryProgressEntity> deliveryProgresses(StaffEntity staff) {
		return staff.getDeliveryProgresses();
	}

	@PreAuthorize("hasPermission('DiagnosticStaffExaminationSummaryEntity', 'read')")
	public Set<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummaries(StaffEntity staff) {
		return staff.getDiagnosticStaffExaminationSummaries();
	}

	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	public Set<RegistrationEntity> dismissalReferringStaff(StaffEntity staff) {
		return staff.getDismissalReferringStaff();
	}

	@PreAuthorize("hasPermission('DoctorScheduleEntity', 'read')")
	public Set<DoctorScheduleEntity> doctorSchedules(StaffEntity staff) {
		return staff.getDoctorSchedules();
	}

	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	public Set<MedicalExaminationRecordEntity> doctorOnExamination(StaffEntity staff) {
		return staff.getDoctorOnExamination();
	}

	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	public Set<FluidBalanceDetailEntity> fluidBalanceDetails(StaffEntity staff) {
		return staff.getFluidBalanceDetails();
	}

	@PreAuthorize("hasPermission('HemodialysisMonitoringEntity', 'read')")
	public Set<HemodialysisMonitoringEntity> hemodialysisMonitorings(StaffEntity staff) {
		return staff.getHemodialysisMonitorings();
	}

	@PreAuthorize("hasPermission('HospitalBranchInformationEntity', 'read')")
	public Set<HospitalBranchInformationEntity> hospitalBranchInformations(StaffEntity staff) {
		return staff.getHospitalBranchInformations();
	}

	@PreAuthorize("hasPermission('InformedConsentEntity', 'read')")
	public Set<InformedConsentEntity> informingConsents(StaffEntity staff) {
		return staff.getInformingConsents();
	}

	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	public Set<InvoiceEntity> invoices(StaffEntity staff) {
		return staff.getInvoices();
	}

	@PreAuthorize("hasPermission('McuPackageItemEntity', 'read')")
	public Set<McuPackageItemEntity> mcuPackageItems(StaffEntity staff) {
		return staff.getMcuPackageItems();
	}

	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	public Set<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumes(StaffEntity staff) {
		return staff.getMedicalCertificateDischargeResumes();
	}

	@PreAuthorize("hasPermission('MedicalCertificateBirthEntity', 'read')")
	public Set<MedicalCertificateBirthEntity> medicalCertificateBirths(StaffEntity staff) {
		return staff.getMedicalCertificateBirths();
	}

	@PreAuthorize("hasPermission('MedicalCertificateHospitalizationEntity', 'read')")
	public Set<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizations(StaffEntity staff) {
		return staff.getMedicalCertificateHospitalizations();
	}

	@PreAuthorize("hasPermission('MedicalExaminationRecordDischargeSummaryEntity', 'read')")
	public Set<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummarys(StaffEntity staff) {
		return staff.getMedicalExaminationRecordDischargeSummarys();
	}

	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	public Set<MedicalExaminationRecordEntity> medicalRecordTranscriber(StaffEntity staff) {
		return staff.getMedicalRecordTranscriber();
	}

	@PreAuthorize("hasPermission('MedicalCertificateMedicalAttendanceEntity', 'read')")
	public Set<MedicalCertificateMedicalAttendanceEntity> medicalStaffOfMedicalAttendancesCertificate(StaffEntity staff) {
		return staff.getMedicalStaffOfMedicalAttendancesCertificate();
	}

	@PreAuthorize("hasPermission('MedicalCertificateMentalHealthEntity', 'read')")
	public Set<MedicalCertificateMentalHealthEntity> medicalStaffOfMentalHealths(StaffEntity staff) {
		return staff.getMedicalStaffOfMentalHealths();
	}

	@PreAuthorize("hasPermission('MedicalCertificatePhysicalHealthEntity', 'read')")
	public Set<MedicalCertificatePhysicalHealthEntity> medicalStaffOfPhysicalHealths(StaffEntity staff) {
		return staff.getMedicalStaffOfPhysicalHealths();
	}

	@PreAuthorize("hasPermission('MedicalCertificateRestrictedWorkEntity', 'read')")
	public Set<MedicalCertificateRestrictedWorkEntity> medicalStaffOfRestrictedWorksCertificate(StaffEntity staff) {
		return staff.getMedicalStaffOfRestrictedWorksCertificate();
	}

	@PreAuthorize("hasPermission('MedicalCertificateSickLeaveEntity', 'read')")
	public Set<MedicalCertificateSickLeaveEntity> medicalStaffOfSickLeavesCertificate(StaffEntity staff) {
		return staff.getMedicalStaffOfSickLeavesCertificate();
	}

	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	public Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotries(StaffEntity staff) {
		return staff.getMedicationAdministeredHisotries();
	}

	@PreAuthorize("hasPermission('MedicationHeaderEntity', 'read')")
	public Set<MedicationHeaderEntity> medicationHeaders(StaffEntity staff) {
		return staff.getMedicationHeaders();
	}

	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	public Set<DeliveryMedicalExaminationRecordEntity> midwives(StaffEntity staff) {
		return staff.getMidwives();
	}

	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	public Set<MedicalExaminationRecordEntity> nurse(StaffEntity staff) {
		return staff.getNurse();
	}

	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	public Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailSurgicalNursing(StaffEntity staff) {
		return staff.getNursingDetailSurgicalNursing();
	}

	@PreAuthorize("hasPermission('OperatingTheaterMedicalExaminationRecordEntity', 'read')")
	public Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailsAnesthesiaNursing(StaffEntity staff) {
		return staff.getNursingDetailsAnesthesiaNursing();
	}

	@PreAuthorize("hasPermission('PcareDokterEntity', 'read')")
	public PcareDokterEntity pcareDokter(StaffEntity staff) {
		return staff.getPcareDokter();
	}

	@PreAuthorize("hasPermission('PatientConsentEntity', 'read')")
	public Set<PatientConsentEntity> patientConsents(StaffEntity staff) {
		return staff.getPatientConsents();
	}

	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	public Set<PatientVitalInformationEntity> patientVitalInformations(StaffEntity staff) {
		return staff.getPatientVitalInformations();
	}

	@PreAuthorize("hasPermission('NewbornDetailEntity', 'read')")
	public Set<NewbornDetailEntity> pediatricianInCharge(StaffEntity staff) {
		return staff.getPediatricianInCharge();
	}

	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	public Set<PrescriptionHeaderEntity> prescriptionHeaders(StaffEntity staff) {
		return staff.getPrescriptionHeaders();
	}

	@PreAuthorize("hasPermission('ProcessWorkflowEntity', 'read')")
	public Set<ProcessWorkflowEntity> processWorkflowLogs(StaffEntity staff) {
		return staff.getProcessWorkflowLogs();
	}

	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	public Set<RegistrationEntity> registrations(StaffEntity staff) {
		return staff.getRegistrations();
	}

	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	public Set<RegistrationEntity> requestedBy(StaffEntity staff) {
		return staff.getRequestedBy();
	}

	@PreAuthorize("hasPermission('RoomTransferEntity', 'read')")
	public Set<RoomTransferEntity> roomTransfers(StaffEntity staff) {
		return staff.getRoomTransfers();
	}

	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	public Set<SampleCollectionItemsEntity> sampleCollectionStaffs(StaffEntity staff) {
		return staff.getSampleCollectionStaffs();
	}

	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	public Set<SampleCollectionItemsEntity> sampleDeliveryStaffs(StaffEntity staff) {
		return staff.getSampleDeliveryStaffs();
	}

	@PreAuthorize("hasPermission('SampleCollectionItemsEntity', 'read')")
	public Set<SampleCollectionItemsEntity> sampleProcessingStaffs(StaffEntity staff) {
		return staff.getSampleProcessingStaffs();
	}

	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	public ServiceEntity service(StaffEntity staff) {
		return staff.getService();
	}

	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	public Set<ServiceEntity> services(StaffEntity staff) {
		return staff.getServices();
	}

	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	public Set<PreoperativeRecordsEntity> surgeon(StaffEntity staff) {
		return staff.getSurgeon();
	}

	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	public Set<PreoperativeRecordsEntity> surgicalMedicalTranscriber(StaffEntity staff) {
		return staff.getSurgicalMedicalTranscriber();
	}

	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	public Set<PreoperativeRecordsEntity> surgicalNurse(StaffEntity staff) {
		return staff.getSurgicalNurse();
	}

	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	public Set<TransferOrderStockDetailEntity> transferOrderStockDetails(StaffEntity staff) {
		return staff.getTransferOrderStockDetails();
	}

	@PreAuthorize("hasPermission('VaccinationOrderEntity', 'read')")
	public Set<VaccinationOrderEntity> vaccinationOrders(StaffEntity staff) {
		return staff.getVaccinationOrders();
	}

	@PreAuthorize("hasPermission('AdministrationUserEntity', 'read')")
	public AdministrationUserEntity administrationUser(StaffEntity staff) {
		return staff.getAdministrationUser();
	}

	@PreAuthorize("hasPermission('CashierUserEntity', 'read')")
	public CashierUserEntity cashierUser(StaffEntity staff) {
		return staff.getCashierUser();
	}

	@PreAuthorize("hasPermission('ClaimUserEntity', 'read')")
	public ClaimUserEntity claimUser(StaffEntity staff) {
		return staff.getClaimUser();
	}

	@PreAuthorize("hasPermission('DiagnosticSupportUserEntity', 'read')")
	public DiagnosticSupportUserEntity diagnosticSupportUser(StaffEntity staff) {
		return staff.getDiagnosticSupportUser();
	}

	@PreAuthorize("hasPermission('DoctorUserEntity', 'read')")
	public DoctorUserEntity doctorUser(StaffEntity staff) {
		return staff.getDoctorUser();
	}

	@PreAuthorize("hasPermission('FacilityUserEntity', 'read')")
	public FacilityUserEntity facilityUser(StaffEntity staff) {
		return staff.getFacilityUser();
	}

	@PreAuthorize("hasPermission('ManagementUserEntity', 'read')")
	public ManagementUserEntity managementUser(StaffEntity staff) {
		return staff.getManagementUser();
	}

	@PreAuthorize("hasPermission('MedicalRecordUserEntity', 'read')")
	public MedicalRecordUserEntity medicalRecordUser(StaffEntity staff) {
		return staff.getMedicalRecordUser();
	}

	@PreAuthorize("hasPermission('MedicalTranscriberUserEntity', 'read')")
	public MedicalTranscriberUserEntity medicalTranscriberUser(StaffEntity staff) {
		return staff.getMedicalTranscriberUser();
	}

	@PreAuthorize("hasPermission('NurseUserEntity', 'read')")
	public NurseUserEntity nurseUser(StaffEntity staff) {
		return staff.getNurseUser();
	}

	@PreAuthorize("hasPermission('PharmacyUserEntity', 'read')")
	public PharmacyUserEntity pharmacyUser(StaffEntity staff) {
		return staff.getPharmacyUser();
	}

	@PreAuthorize("hasPermission('PurchasingUserEntity', 'read')")
	public PurchasingUserEntity purchasingUser(StaffEntity staff) {
		return staff.getPurchasingUser();
	}

	@PreAuthorize("hasPermission('RegistrationUserEntity', 'read')")
	public RegistrationUserEntity registrationUser(StaffEntity staff) {
		return staff.getRegistrationUser();
	}

	@PreAuthorize("hasPermission('SystemAdminUserEntity', 'read')")
	public SystemAdminUserEntity systemAdminUser(StaffEntity staff) {
		return staff.getSystemAdminUser();
	}

	@PreAuthorize("hasPermission('WarehouseUserEntity', 'read')")
	public WarehouseUserEntity warehouseUser(StaffEntity staff) {
		return staff.getWarehouseUser();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
