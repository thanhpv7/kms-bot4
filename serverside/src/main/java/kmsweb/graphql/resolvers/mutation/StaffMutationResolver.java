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

package kmsweb.graphql.resolvers.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kmsweb.entities.StaffEntity;
import kmsweb.services.StaffService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.AdministrationUserService;
import kmsweb.entities.AdministrationUserEntity;
import kmsweb.services.AdministratorService;
import kmsweb.entities.AdministratorEntity;
import kmsweb.services.AmendmentDetailService;
import kmsweb.entities.AmendmentDetailEntity;
import kmsweb.services.BpjsDoctorMappingService;
import kmsweb.entities.BpjsDoctorMappingEntity;
import kmsweb.services.CashReceiptService;
import kmsweb.entities.CashReceiptEntity;
import kmsweb.services.CashierUserService;
import kmsweb.entities.CashierUserEntity;
import kmsweb.services.ClaimUserService;
import kmsweb.entities.ClaimUserEntity;
import kmsweb.services.CoTreatingDoctorService;
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.services.DailyCareCPPTService;
import kmsweb.entities.DailyCareCPPTEntity;
import kmsweb.services.DeliveryMedicalExaminationRecordService;
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.services.DeliveryProgressService;
import kmsweb.entities.DeliveryProgressEntity;
import kmsweb.services.DiagnosticStaffExaminationSummaryService;
import kmsweb.entities.DiagnosticStaffExaminationSummaryEntity;
import kmsweb.services.DiagnosticSupportUserService;
import kmsweb.entities.DiagnosticSupportUserEntity;
import kmsweb.services.DoctorScheduleService;
import kmsweb.entities.DoctorScheduleEntity;
import kmsweb.services.DoctorUserService;
import kmsweb.entities.DoctorUserEntity;
import kmsweb.services.FacilityUserService;
import kmsweb.entities.FacilityUserEntity;
import kmsweb.services.FluidBalanceDetailService;
import kmsweb.entities.FluidBalanceDetailEntity;
import kmsweb.services.HemodialysisMonitoringService;
import kmsweb.entities.HemodialysisMonitoringEntity;
import kmsweb.services.HospitalBranchInformationService;
import kmsweb.entities.HospitalBranchInformationEntity;
import kmsweb.services.InformedConsentService;
import kmsweb.entities.InformedConsentEntity;
import kmsweb.services.InvoiceService;
import kmsweb.entities.InvoiceEntity;
import kmsweb.services.McuPackageItemService;
import kmsweb.entities.McuPackageItemEntity;
import kmsweb.services.ManagementUserService;
import kmsweb.entities.ManagementUserEntity;
import kmsweb.services.MedicalCertificateDischargeResumeService;
import kmsweb.entities.MedicalCertificateDischargeResumeEntity;
import kmsweb.services.MedicalCertificateBirthService;
import kmsweb.entities.MedicalCertificateBirthEntity;
import kmsweb.services.MedicalCertificateHospitalizationService;
import kmsweb.entities.MedicalCertificateHospitalizationEntity;
import kmsweb.services.MedicalCertificateMedicalAttendanceService;
import kmsweb.entities.MedicalCertificateMedicalAttendanceEntity;
import kmsweb.services.MedicalCertificateMentalHealthService;
import kmsweb.entities.MedicalCertificateMentalHealthEntity;
import kmsweb.services.MedicalCertificatePhysicalHealthService;
import kmsweb.entities.MedicalCertificatePhysicalHealthEntity;
import kmsweb.services.MedicalCertificateRestrictedWorkService;
import kmsweb.entities.MedicalCertificateRestrictedWorkEntity;
import kmsweb.services.MedicalCertificateSickLeaveService;
import kmsweb.entities.MedicalCertificateSickLeaveEntity;
import kmsweb.services.MedicalExaminationRecordService;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.services.MedicalExaminationRecordDischargeSummaryService;
import kmsweb.entities.MedicalExaminationRecordDischargeSummaryEntity;
import kmsweb.services.MedicalRecordUserService;
import kmsweb.entities.MedicalRecordUserEntity;
import kmsweb.services.MedicalTranscriberUserService;
import kmsweb.entities.MedicalTranscriberUserEntity;
import kmsweb.services.MedicationAdministeredHistoryService;
import kmsweb.entities.MedicationAdministeredHistoryEntity;
import kmsweb.services.MedicationHeaderService;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.services.NewbornDetailService;
import kmsweb.entities.NewbornDetailEntity;
import kmsweb.services.NurseUserService;
import kmsweb.entities.NurseUserEntity;
import kmsweb.services.OperatingTheaterMedicalExaminationRecordService;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.services.PcareDokterService;
import kmsweb.entities.PcareDokterEntity;
import kmsweb.services.PatientConsentService;
import kmsweb.entities.PatientConsentEntity;
import kmsweb.services.PatientVitalInformationService;
import kmsweb.entities.PatientVitalInformationEntity;
import kmsweb.services.PharmacyUserService;
import kmsweb.entities.PharmacyUserEntity;
import kmsweb.services.PreoperativeRecordsService;
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.services.PrescriptionHeaderService;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.services.ProcessWorkflowService;
import kmsweb.entities.ProcessWorkflowEntity;
import kmsweb.services.PurchasingUserService;
import kmsweb.entities.PurchasingUserEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;
import kmsweb.services.RegistrationUserService;
import kmsweb.entities.RegistrationUserEntity;
import kmsweb.services.RoomTransferService;
import kmsweb.entities.RoomTransferEntity;
import kmsweb.services.SampleCollectionItemsService;
import kmsweb.entities.SampleCollectionItemsEntity;
import kmsweb.services.ServiceService;
import kmsweb.entities.ServiceEntity;
import kmsweb.services.SystemAdminUserService;
import kmsweb.entities.SystemAdminUserEntity;
import kmsweb.services.TransferOrderStockDetailService;
import kmsweb.entities.TransferOrderStockDetailEntity;
import kmsweb.services.VaccinationOrderService;
import kmsweb.entities.VaccinationOrderEntity;
import kmsweb.services.WarehouseUserService;
import kmsweb.entities.WarehouseUserEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class StaffMutationResolver implements GraphQLMutationResolver {

	private final StaffService staffService;

	private final AdministrationUserService administrationUserService;

	private final AdministratorService administratorService;

	private final AmendmentDetailService amendmentDetailService;

	private final BpjsDoctorMappingService bpjsDoctorMappingService;

	private final CashReceiptService cashReceiptService;

	private final CashierUserService cashierUserService;

	private final ClaimUserService claimUserService;

	private final CoTreatingDoctorService coTreatingDoctorService;

	private final DailyCareCPPTService dailyCareCPPTService;

	private final DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService;

	private final DeliveryProgressService deliveryProgressService;

	private final DiagnosticStaffExaminationSummaryService diagnosticStaffExaminationSummaryService;

	private final DiagnosticSupportUserService diagnosticSupportUserService;

	private final DoctorScheduleService doctorScheduleService;

	private final DoctorUserService doctorUserService;

	private final FacilityUserService facilityUserService;

	private final FluidBalanceDetailService fluidBalanceDetailService;

	private final HemodialysisMonitoringService hemodialysisMonitoringService;

	private final HospitalBranchInformationService hospitalBranchInformationService;

	private final InformedConsentService informedConsentService;

	private final InvoiceService invoiceService;

	private final McuPackageItemService mcuPackageItemService;

	private final ManagementUserService managementUserService;

	private final MedicalCertificateDischargeResumeService medicalCertificateDischargeResumeService;

	private final MedicalCertificateBirthService medicalCertificateBirthService;

	private final MedicalCertificateHospitalizationService medicalCertificateHospitalizationService;

	private final MedicalCertificateMedicalAttendanceService medicalCertificateMedicalAttendanceService;

	private final MedicalCertificateMentalHealthService medicalCertificateMentalHealthService;

	private final MedicalCertificatePhysicalHealthService medicalCertificatePhysicalHealthService;

	private final MedicalCertificateRestrictedWorkService medicalCertificateRestrictedWorkService;

	private final MedicalCertificateSickLeaveService medicalCertificateSickLeaveService;

	private final MedicalExaminationRecordService medicalExaminationRecordService;

	private final MedicalExaminationRecordDischargeSummaryService medicalExaminationRecordDischargeSummaryService;

	private final MedicalRecordUserService medicalRecordUserService;

	private final MedicalTranscriberUserService medicalTranscriberUserService;

	private final MedicationAdministeredHistoryService medicationAdministeredHistoryService;

	private final MedicationHeaderService medicationHeaderService;

	private final NewbornDetailService newbornDetailService;

	private final NurseUserService nurseUserService;

	private final OperatingTheaterMedicalExaminationRecordService operatingTheaterMedicalExaminationRecordService;

	private final PcareDokterService pcareDokterService;

	private final PatientConsentService patientConsentService;

	private final PatientVitalInformationService patientVitalInformationService;

	private final PharmacyUserService pharmacyUserService;

	private final PreoperativeRecordsService preoperativeRecordsService;

	private final PrescriptionHeaderService prescriptionHeaderService;

	private final ProcessWorkflowService processWorkflowService;

	private final PurchasingUserService purchasingUserService;

	private final RegistrationService registrationService;

	private final RegistrationUserService registrationUserService;

	private final RoomTransferService roomTransferService;

	private final SampleCollectionItemsService sampleCollectionItemsService;

	private final ServiceService serviceService;

	private final SystemAdminUserService systemAdminUserService;

	private final TransferOrderStockDetailService transferOrderStockDetailService;

	private final VaccinationOrderService vaccinationOrderService;

	private final WarehouseUserService warehouseUserService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public StaffMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			AdministrationUserService administrationUserService,
			AdministratorService administratorService,
			AmendmentDetailService amendmentDetailService,
			BpjsDoctorMappingService bpjsDoctorMappingService,
			CashReceiptService cashReceiptService,
			CashierUserService cashierUserService,
			ClaimUserService claimUserService,
			CoTreatingDoctorService coTreatingDoctorService,
			DailyCareCPPTService dailyCareCPPTService,
			DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService,
			DeliveryProgressService deliveryProgressService,
			DiagnosticStaffExaminationSummaryService diagnosticStaffExaminationSummaryService,
			DiagnosticSupportUserService diagnosticSupportUserService,
			DoctorScheduleService doctorScheduleService,
			DoctorUserService doctorUserService,
			FacilityUserService facilityUserService,
			FluidBalanceDetailService fluidBalanceDetailService,
			HemodialysisMonitoringService hemodialysisMonitoringService,
			HospitalBranchInformationService hospitalBranchInformationService,
			InformedConsentService informedConsentService,
			InvoiceService invoiceService,
			McuPackageItemService mcuPackageItemService,
			ManagementUserService managementUserService,
			MedicalCertificateDischargeResumeService medicalCertificateDischargeResumeService,
			MedicalCertificateBirthService medicalCertificateBirthService,
			MedicalCertificateHospitalizationService medicalCertificateHospitalizationService,
			MedicalCertificateMedicalAttendanceService medicalCertificateMedicalAttendanceService,
			MedicalCertificateMentalHealthService medicalCertificateMentalHealthService,
			MedicalCertificatePhysicalHealthService medicalCertificatePhysicalHealthService,
			MedicalCertificateRestrictedWorkService medicalCertificateRestrictedWorkService,
			MedicalCertificateSickLeaveService medicalCertificateSickLeaveService,
			MedicalExaminationRecordService medicalExaminationRecordService,
			MedicalExaminationRecordDischargeSummaryService medicalExaminationRecordDischargeSummaryService,
			MedicalRecordUserService medicalRecordUserService,
			MedicalTranscriberUserService medicalTranscriberUserService,
			MedicationAdministeredHistoryService medicationAdministeredHistoryService,
			MedicationHeaderService medicationHeaderService,
			NewbornDetailService newbornDetailService,
			NurseUserService nurseUserService,
			OperatingTheaterMedicalExaminationRecordService operatingTheaterMedicalExaminationRecordService,
			PcareDokterService pcareDokterService,
			PatientConsentService patientConsentService,
			PatientVitalInformationService patientVitalInformationService,
			PharmacyUserService pharmacyUserService,
			PreoperativeRecordsService preoperativeRecordsService,
			PrescriptionHeaderService prescriptionHeaderService,
			ProcessWorkflowService processWorkflowService,
			PurchasingUserService purchasingUserService,
			RegistrationService registrationService,
			RegistrationUserService registrationUserService,
			RoomTransferService roomTransferService,
			SampleCollectionItemsService sampleCollectionItemsService,
			ServiceService serviceService,
			SystemAdminUserService systemAdminUserService,
			TransferOrderStockDetailService transferOrderStockDetailService,
			VaccinationOrderService vaccinationOrderService,
			WarehouseUserService warehouseUserService,
			StaffService staffService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.staffService = staffService;

		this.administrationUserService = administrationUserService;

		this.administratorService = administratorService;

		this.amendmentDetailService = amendmentDetailService;

		this.bpjsDoctorMappingService = bpjsDoctorMappingService;

		this.cashReceiptService = cashReceiptService;

		this.cashierUserService = cashierUserService;

		this.claimUserService = claimUserService;

		this.coTreatingDoctorService = coTreatingDoctorService;

		this.dailyCareCPPTService = dailyCareCPPTService;

		this.deliveryMedicalExaminationRecordService = deliveryMedicalExaminationRecordService;

		this.deliveryProgressService = deliveryProgressService;

		this.diagnosticStaffExaminationSummaryService = diagnosticStaffExaminationSummaryService;

		this.diagnosticSupportUserService = diagnosticSupportUserService;

		this.doctorScheduleService = doctorScheduleService;

		this.doctorUserService = doctorUserService;

		this.facilityUserService = facilityUserService;

		this.fluidBalanceDetailService = fluidBalanceDetailService;

		this.hemodialysisMonitoringService = hemodialysisMonitoringService;

		this.hospitalBranchInformationService = hospitalBranchInformationService;

		this.informedConsentService = informedConsentService;

		this.invoiceService = invoiceService;

		this.mcuPackageItemService = mcuPackageItemService;

		this.managementUserService = managementUserService;

		this.medicalCertificateDischargeResumeService = medicalCertificateDischargeResumeService;

		this.medicalCertificateBirthService = medicalCertificateBirthService;

		this.medicalCertificateHospitalizationService = medicalCertificateHospitalizationService;

		this.medicalCertificateMedicalAttendanceService = medicalCertificateMedicalAttendanceService;

		this.medicalCertificateMentalHealthService = medicalCertificateMentalHealthService;

		this.medicalCertificatePhysicalHealthService = medicalCertificatePhysicalHealthService;

		this.medicalCertificateRestrictedWorkService = medicalCertificateRestrictedWorkService;

		this.medicalCertificateSickLeaveService = medicalCertificateSickLeaveService;

		this.medicalExaminationRecordService = medicalExaminationRecordService;

		this.medicalExaminationRecordDischargeSummaryService = medicalExaminationRecordDischargeSummaryService;

		this.medicalRecordUserService = medicalRecordUserService;

		this.medicalTranscriberUserService = medicalTranscriberUserService;

		this.medicationAdministeredHistoryService = medicationAdministeredHistoryService;

		this.medicationHeaderService = medicationHeaderService;

		this.newbornDetailService = newbornDetailService;

		this.nurseUserService = nurseUserService;

		this.operatingTheaterMedicalExaminationRecordService = operatingTheaterMedicalExaminationRecordService;

		this.pcareDokterService = pcareDokterService;

		this.patientConsentService = patientConsentService;

		this.patientVitalInformationService = patientVitalInformationService;

		this.pharmacyUserService = pharmacyUserService;

		this.preoperativeRecordsService = preoperativeRecordsService;

		this.prescriptionHeaderService = prescriptionHeaderService;

		this.processWorkflowService = processWorkflowService;

		this.purchasingUserService = purchasingUserService;

		this.registrationService = registrationService;

		this.registrationUserService = registrationUserService;

		this.roomTransferService = roomTransferService;

		this.sampleCollectionItemsService = sampleCollectionItemsService;

		this.serviceService = serviceService;

		this.systemAdminUserService = systemAdminUserService;

		this.transferOrderStockDetailService = transferOrderStockDetailService;

		this.vaccinationOrderService = vaccinationOrderService;

		this.warehouseUserService = warehouseUserService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'create')")
	public StaffEntity createStaff(@NonNull StaffEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getAdministrationUser() != null) {
			rawEntity.setAdministrationUser(administrationUserService.updateOldData(rawEntity.getAdministrationUser()));
		}

		if (rawEntity.getCashierUser() != null) {
			rawEntity.setCashierUser(cashierUserService.updateOldData(rawEntity.getCashierUser()));
		}

		if (rawEntity.getClaimUser() != null) {
			rawEntity.setClaimUser(claimUserService.updateOldData(rawEntity.getClaimUser()));
		}

		if (rawEntity.getDiagnosticSupportUser() != null) {
			rawEntity.setDiagnosticSupportUser(diagnosticSupportUserService.updateOldData(rawEntity.getDiagnosticSupportUser()));
		}

		if (rawEntity.getDoctorUser() != null) {
			rawEntity.setDoctorUser(doctorUserService.updateOldData(rawEntity.getDoctorUser()));
		}

		if (rawEntity.getFacilityUser() != null) {
			rawEntity.setFacilityUser(facilityUserService.updateOldData(rawEntity.getFacilityUser()));
		}

		if (rawEntity.getManagementUser() != null) {
			rawEntity.setManagementUser(managementUserService.updateOldData(rawEntity.getManagementUser()));
		}

		if (rawEntity.getMedicalRecordUser() != null) {
			rawEntity.setMedicalRecordUser(medicalRecordUserService.updateOldData(rawEntity.getMedicalRecordUser()));
		}

		if (rawEntity.getMedicalTranscriberUser() != null) {
			rawEntity.setMedicalTranscriberUser(medicalTranscriberUserService.updateOldData(rawEntity.getMedicalTranscriberUser()));
		}

		if (rawEntity.getNurseUser() != null) {
			rawEntity.setNurseUser(nurseUserService.updateOldData(rawEntity.getNurseUser()));
		}

		if (rawEntity.getPharmacyUser() != null) {
			rawEntity.setPharmacyUser(pharmacyUserService.updateOldData(rawEntity.getPharmacyUser()));
		}

		if (rawEntity.getPurchasingUser() != null) {
			rawEntity.setPurchasingUser(purchasingUserService.updateOldData(rawEntity.getPurchasingUser()));
		}

		if (rawEntity.getRegistrationUser() != null) {
			rawEntity.setRegistrationUser(registrationUserService.updateOldData(rawEntity.getRegistrationUser()));
		}

		if (rawEntity.getSystemAdminUser() != null) {
			rawEntity.setSystemAdminUser(systemAdminUserService.updateOldData(rawEntity.getSystemAdminUser()));
		}

		if (rawEntity.getWarehouseUser() != null) {
			rawEntity.setWarehouseUser(warehouseUserService.updateOldData(rawEntity.getWarehouseUser()));
		}

		if (rawEntity.getAdministrator() != null) {
			rawEntity.setAdministrator(administratorService.updateOldData(rawEntity.getAdministrator()));
		}

		if (rawEntity.getBpjsDoctorMapping() != null) {
			rawEntity.setBpjsDoctorMapping(bpjsDoctorMappingService.updateOldData(rawEntity.getBpjsDoctorMapping()));
		}

		if (rawEntity.getPcareDokter() != null) {
			rawEntity.setPcareDokter(pcareDokterService.updateOldData(rawEntity.getPcareDokter()));
		}

		if (rawEntity.getService() != null) {
			rawEntity.setService(serviceService.updateOldData(rawEntity.getService()));
		}

		Set<InformedConsentEntity> accompanyingConsents = new HashSet<>();
		rawEntity.getAccompanyingConsents().forEach(entity -> {
			accompanyingConsents.add(informedConsentService.updateOldData(entity));
		});
		rawEntity.setAccompanyingConsents(accompanyingConsents);

		Set<AmendmentDetailEntity> amendmentDetails = new HashSet<>();
		rawEntity.getAmendmentDetails().forEach(entity -> {
			amendmentDetails.add(amendmentDetailService.updateOldData(entity));
		});
		rawEntity.setAmendmentDetails(amendmentDetails);

		Set<PreoperativeRecordsEntity> anesthesiaMedicalTranscriber = new HashSet<>();
		rawEntity.getAnesthesiaMedicalTranscriber().forEach(entity -> {
			anesthesiaMedicalTranscriber.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setAnesthesiaMedicalTranscriber(anesthesiaMedicalTranscriber);

		Set<PreoperativeRecordsEntity> anesthesiologist = new HashSet<>();
		rawEntity.getAnesthesiologist().forEach(entity -> {
			anesthesiologist.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setAnesthesiologist(anesthesiologist);

		Set<PreoperativeRecordsEntity> anesthesiologyNurse = new HashSet<>();
		rawEntity.getAnesthesiologyNurse().forEach(entity -> {
			anesthesiologyNurse.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setAnesthesiologyNurse(anesthesiologyNurse);

		Set<CashReceiptEntity> cashierStaff = new HashSet<>();
		rawEntity.getCashierStaff().forEach(entity -> {
			cashierStaff.add(cashReceiptService.updateOldData(entity));
		});
		rawEntity.setCashierStaff(cashierStaff);

		Set<CoTreatingDoctorEntity> coTreatingDoctors = new HashSet<>();
		rawEntity.getCoTreatingDoctors().forEach(entity -> {
			coTreatingDoctors.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setCoTreatingDoctors(coTreatingDoctors);

		Set<DailyCareCPPTEntity> dailyCareCPPTsCreatedByStaff = new HashSet<>();
		rawEntity.getDailyCareCPPTsCreatedByStaff().forEach(entity -> {
			dailyCareCPPTsCreatedByStaff.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setDailyCareCPPTsCreatedByStaff(dailyCareCPPTsCreatedByStaff);

		Set<DailyCareCPPTEntity> dailyCareCPPTsDoctorInCharge = new HashSet<>();
		rawEntity.getDailyCareCPPTsDoctorInCharge().forEach(entity -> {
			dailyCareCPPTsDoctorInCharge.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setDailyCareCPPTsDoctorInCharge(dailyCareCPPTsDoctorInCharge);

		Set<DailyCareCPPTEntity> dailyCareCPPTsMedicalTranscriber = new HashSet<>();
		rawEntity.getDailyCareCPPTsMedicalTranscriber().forEach(entity -> {
			dailyCareCPPTsMedicalTranscriber.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setDailyCareCPPTsMedicalTranscriber(dailyCareCPPTsMedicalTranscriber);

		Set<DeliveryProgressEntity> deliveryProgresses = new HashSet<>();
		rawEntity.getDeliveryProgresses().forEach(entity -> {
			deliveryProgresses.add(deliveryProgressService.updateOldData(entity));
		});
		rawEntity.setDeliveryProgresses(deliveryProgresses);

		Set<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummaries = new HashSet<>();
		rawEntity.getDiagnosticStaffExaminationSummaries().forEach(entity -> {
			diagnosticStaffExaminationSummaries.add(diagnosticStaffExaminationSummaryService.updateOldData(entity));
		});
		rawEntity.setDiagnosticStaffExaminationSummaries(diagnosticStaffExaminationSummaries);

		Set<RegistrationEntity> dismissalReferringStaff = new HashSet<>();
		rawEntity.getDismissalReferringStaff().forEach(entity -> {
			dismissalReferringStaff.add(registrationService.updateOldData(entity));
		});
		rawEntity.setDismissalReferringStaff(dismissalReferringStaff);

		Set<DoctorScheduleEntity> doctorSchedules = new HashSet<>();
		rawEntity.getDoctorSchedules().forEach(entity -> {
			doctorSchedules.add(doctorScheduleService.updateOldData(entity));
		});
		rawEntity.setDoctorSchedules(doctorSchedules);

		Set<MedicalExaminationRecordEntity> doctorOnExamination = new HashSet<>();
		rawEntity.getDoctorOnExamination().forEach(entity -> {
			doctorOnExamination.add(medicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setDoctorOnExamination(doctorOnExamination);

		Set<FluidBalanceDetailEntity> fluidBalanceDetails = new HashSet<>();
		rawEntity.getFluidBalanceDetails().forEach(entity -> {
			fluidBalanceDetails.add(fluidBalanceDetailService.updateOldData(entity));
		});
		rawEntity.setFluidBalanceDetails(fluidBalanceDetails);

		Set<HemodialysisMonitoringEntity> hemodialysisMonitorings = new HashSet<>();
		rawEntity.getHemodialysisMonitorings().forEach(entity -> {
			hemodialysisMonitorings.add(hemodialysisMonitoringService.updateOldData(entity));
		});
		rawEntity.setHemodialysisMonitorings(hemodialysisMonitorings);

		Set<HospitalBranchInformationEntity> hospitalBranchInformations = new HashSet<>();
		rawEntity.getHospitalBranchInformations().forEach(entity -> {
			hospitalBranchInformations.add(hospitalBranchInformationService.updateOldData(entity));
		});
		rawEntity.setHospitalBranchInformations(hospitalBranchInformations);

		Set<InformedConsentEntity> informingConsents = new HashSet<>();
		rawEntity.getInformingConsents().forEach(entity -> {
			informingConsents.add(informedConsentService.updateOldData(entity));
		});
		rawEntity.setInformingConsents(informingConsents);

		Set<InvoiceEntity> invoices = new HashSet<>();
		rawEntity.getInvoices().forEach(entity -> {
			invoices.add(invoiceService.updateOldData(entity));
		});
		rawEntity.setInvoices(invoices);

		Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();
		rawEntity.getMcuPackageItems().forEach(entity -> {
			mcuPackageItems.add(mcuPackageItemService.updateOldData(entity));
		});
		rawEntity.setMcuPackageItems(mcuPackageItems);

		Set<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumes = new HashSet<>();
		rawEntity.getMedicalCertificateDischargeResumes().forEach(entity -> {
			medicalCertificateDischargeResumes.add(medicalCertificateDischargeResumeService.updateOldData(entity));
		});
		rawEntity.setMedicalCertificateDischargeResumes(medicalCertificateDischargeResumes);

		Set<MedicalCertificateBirthEntity> medicalCertificateBirths = new HashSet<>();
		rawEntity.getMedicalCertificateBirths().forEach(entity -> {
			medicalCertificateBirths.add(medicalCertificateBirthService.updateOldData(entity));
		});
		rawEntity.setMedicalCertificateBirths(medicalCertificateBirths);

		Set<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizations = new HashSet<>();
		rawEntity.getMedicalCertificateHospitalizations().forEach(entity -> {
			medicalCertificateHospitalizations.add(medicalCertificateHospitalizationService.updateOldData(entity));
		});
		rawEntity.setMedicalCertificateHospitalizations(medicalCertificateHospitalizations);

		Set<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummarys = new HashSet<>();
		rawEntity.getMedicalExaminationRecordDischargeSummarys().forEach(entity -> {
			medicalExaminationRecordDischargeSummarys.add(medicalExaminationRecordDischargeSummaryService.updateOldData(entity));
		});
		rawEntity.setMedicalExaminationRecordDischargeSummarys(medicalExaminationRecordDischargeSummarys);

		Set<MedicalExaminationRecordEntity> medicalRecordTranscriber = new HashSet<>();
		rawEntity.getMedicalRecordTranscriber().forEach(entity -> {
			medicalRecordTranscriber.add(medicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setMedicalRecordTranscriber(medicalRecordTranscriber);

		Set<MedicalCertificateMedicalAttendanceEntity> medicalStaffOfMedicalAttendancesCertificate = new HashSet<>();
		rawEntity.getMedicalStaffOfMedicalAttendancesCertificate().forEach(entity -> {
			medicalStaffOfMedicalAttendancesCertificate.add(medicalCertificateMedicalAttendanceService.updateOldData(entity));
		});
		rawEntity.setMedicalStaffOfMedicalAttendancesCertificate(medicalStaffOfMedicalAttendancesCertificate);

		Set<MedicalCertificateMentalHealthEntity> medicalStaffOfMentalHealths = new HashSet<>();
		rawEntity.getMedicalStaffOfMentalHealths().forEach(entity -> {
			medicalStaffOfMentalHealths.add(medicalCertificateMentalHealthService.updateOldData(entity));
		});
		rawEntity.setMedicalStaffOfMentalHealths(medicalStaffOfMentalHealths);

		Set<MedicalCertificatePhysicalHealthEntity> medicalStaffOfPhysicalHealths = new HashSet<>();
		rawEntity.getMedicalStaffOfPhysicalHealths().forEach(entity -> {
			medicalStaffOfPhysicalHealths.add(medicalCertificatePhysicalHealthService.updateOldData(entity));
		});
		rawEntity.setMedicalStaffOfPhysicalHealths(medicalStaffOfPhysicalHealths);

		Set<MedicalCertificateRestrictedWorkEntity> medicalStaffOfRestrictedWorksCertificate = new HashSet<>();
		rawEntity.getMedicalStaffOfRestrictedWorksCertificate().forEach(entity -> {
			medicalStaffOfRestrictedWorksCertificate.add(medicalCertificateRestrictedWorkService.updateOldData(entity));
		});
		rawEntity.setMedicalStaffOfRestrictedWorksCertificate(medicalStaffOfRestrictedWorksCertificate);

		Set<MedicalCertificateSickLeaveEntity> medicalStaffOfSickLeavesCertificate = new HashSet<>();
		rawEntity.getMedicalStaffOfSickLeavesCertificate().forEach(entity -> {
			medicalStaffOfSickLeavesCertificate.add(medicalCertificateSickLeaveService.updateOldData(entity));
		});
		rawEntity.setMedicalStaffOfSickLeavesCertificate(medicalStaffOfSickLeavesCertificate);

		Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotries = new HashSet<>();
		rawEntity.getMedicationAdministeredHisotries().forEach(entity -> {
			medicationAdministeredHisotries.add(medicationAdministeredHistoryService.updateOldData(entity));
		});
		rawEntity.setMedicationAdministeredHisotries(medicationAdministeredHisotries);

		Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();
		rawEntity.getMedicationHeaders().forEach(entity -> {
			medicationHeaders.add(medicationHeaderService.updateOldData(entity));
		});
		rawEntity.setMedicationHeaders(medicationHeaders);

		Set<DeliveryMedicalExaminationRecordEntity> midwives = new HashSet<>();
		rawEntity.getMidwives().forEach(entity -> {
			midwives.add(deliveryMedicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setMidwives(midwives);

		Set<MedicalExaminationRecordEntity> nurse = new HashSet<>();
		rawEntity.getNurse().forEach(entity -> {
			nurse.add(medicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setNurse(nurse);

		Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailSurgicalNursing = new HashSet<>();
		rawEntity.getNursingDetailSurgicalNursing().forEach(entity -> {
			nursingDetailSurgicalNursing.add(operatingTheaterMedicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setNursingDetailSurgicalNursing(nursingDetailSurgicalNursing);

		Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailsAnesthesiaNursing = new HashSet<>();
		rawEntity.getNursingDetailsAnesthesiaNursing().forEach(entity -> {
			nursingDetailsAnesthesiaNursing.add(operatingTheaterMedicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setNursingDetailsAnesthesiaNursing(nursingDetailsAnesthesiaNursing);

		Set<PatientConsentEntity> patientConsents = new HashSet<>();
		rawEntity.getPatientConsents().forEach(entity -> {
			patientConsents.add(patientConsentService.updateOldData(entity));
		});
		rawEntity.setPatientConsents(patientConsents);

		Set<PatientVitalInformationEntity> patientVitalInformations = new HashSet<>();
		rawEntity.getPatientVitalInformations().forEach(entity -> {
			patientVitalInformations.add(patientVitalInformationService.updateOldData(entity));
		});
		rawEntity.setPatientVitalInformations(patientVitalInformations);

		Set<NewbornDetailEntity> pediatricianInCharge = new HashSet<>();
		rawEntity.getPediatricianInCharge().forEach(entity -> {
			pediatricianInCharge.add(newbornDetailService.updateOldData(entity));
		});
		rawEntity.setPediatricianInCharge(pediatricianInCharge);

		Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();
		rawEntity.getPrescriptionHeaders().forEach(entity -> {
			prescriptionHeaders.add(prescriptionHeaderService.updateOldData(entity));
		});
		rawEntity.setPrescriptionHeaders(prescriptionHeaders);

		Set<ProcessWorkflowEntity> processWorkflowLogs = new HashSet<>();
		rawEntity.getProcessWorkflowLogs().forEach(entity -> {
			processWorkflowLogs.add(processWorkflowService.updateOldData(entity));
		});
		rawEntity.setProcessWorkflowLogs(processWorkflowLogs);

		Set<RegistrationEntity> registrations = new HashSet<>();
		rawEntity.getRegistrations().forEach(entity -> {
			registrations.add(registrationService.updateOldData(entity));
		});
		rawEntity.setRegistrations(registrations);

		Set<RegistrationEntity> requestedBy = new HashSet<>();
		rawEntity.getRequestedBy().forEach(entity -> {
			requestedBy.add(registrationService.updateOldData(entity));
		});
		rawEntity.setRequestedBy(requestedBy);

		Set<RoomTransferEntity> roomTransfers = new HashSet<>();
		rawEntity.getRoomTransfers().forEach(entity -> {
			roomTransfers.add(roomTransferService.updateOldData(entity));
		});
		rawEntity.setRoomTransfers(roomTransfers);

		Set<SampleCollectionItemsEntity> sampleCollectionStaffs = new HashSet<>();
		rawEntity.getSampleCollectionStaffs().forEach(entity -> {
			sampleCollectionStaffs.add(sampleCollectionItemsService.updateOldData(entity));
		});
		rawEntity.setSampleCollectionStaffs(sampleCollectionStaffs);

		Set<SampleCollectionItemsEntity> sampleDeliveryStaffs = new HashSet<>();
		rawEntity.getSampleDeliveryStaffs().forEach(entity -> {
			sampleDeliveryStaffs.add(sampleCollectionItemsService.updateOldData(entity));
		});
		rawEntity.setSampleDeliveryStaffs(sampleDeliveryStaffs);

		Set<SampleCollectionItemsEntity> sampleProcessingStaffs = new HashSet<>();
		rawEntity.getSampleProcessingStaffs().forEach(entity -> {
			sampleProcessingStaffs.add(sampleCollectionItemsService.updateOldData(entity));
		});
		rawEntity.setSampleProcessingStaffs(sampleProcessingStaffs);

		Set<PreoperativeRecordsEntity> surgeon = new HashSet<>();
		rawEntity.getSurgeon().forEach(entity -> {
			surgeon.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setSurgeon(surgeon);

		Set<PreoperativeRecordsEntity> surgicalMedicalTranscriber = new HashSet<>();
		rawEntity.getSurgicalMedicalTranscriber().forEach(entity -> {
			surgicalMedicalTranscriber.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setSurgicalMedicalTranscriber(surgicalMedicalTranscriber);

		Set<PreoperativeRecordsEntity> surgicalNurse = new HashSet<>();
		rawEntity.getSurgicalNurse().forEach(entity -> {
			surgicalNurse.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setSurgicalNurse(surgicalNurse);

		Set<TransferOrderStockDetailEntity> transferOrderStockDetails = new HashSet<>();
		rawEntity.getTransferOrderStockDetails().forEach(entity -> {
			transferOrderStockDetails.add(transferOrderStockDetailService.updateOldData(entity));
		});
		rawEntity.setTransferOrderStockDetails(transferOrderStockDetails);

		Set<VaccinationOrderEntity> vaccinationOrders = new HashSet<>();
		rawEntity.getVaccinationOrders().forEach(entity -> {
			vaccinationOrders.add(vaccinationOrderService.updateOldData(entity));
		});
		rawEntity.setVaccinationOrders(vaccinationOrders);

		Set<ServiceEntity> services = new HashSet<>();
		rawEntity.getServices().forEach(entity -> {
			services.add(serviceService.updateOldData(entity));
		});
		rawEntity.setServices(services);

		StaffEntity newEntity = staffService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link StaffMutationResolver#createStaff(StaffEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'create')")
	public List<StaffEntity> createAllStaff(@NonNull List<StaffEntity> rawEntities) {
		List<StaffEntity> newEntities = Lists.newArrayList(staffService.createAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the created entities here] off begin
		// % protected region % [Add any additional logic for update before returning the created entities here] end

		return newEntities;
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'update')")
	public StaffEntity updateStaff(@NonNull StaffEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getAdministrationUser() != null) {
			rawEntity.setAdministrationUser(administrationUserService.updateOldData(rawEntity.getAdministrationUser()));
		}

		if (rawEntity.getCashierUser() != null) {
			rawEntity.setCashierUser(cashierUserService.updateOldData(rawEntity.getCashierUser()));
		}

		if (rawEntity.getClaimUser() != null) {
			rawEntity.setClaimUser(claimUserService.updateOldData(rawEntity.getClaimUser()));
		}

		if (rawEntity.getDiagnosticSupportUser() != null) {
			rawEntity.setDiagnosticSupportUser(diagnosticSupportUserService.updateOldData(rawEntity.getDiagnosticSupportUser()));
		}

		if (rawEntity.getDoctorUser() != null) {
			rawEntity.setDoctorUser(doctorUserService.updateOldData(rawEntity.getDoctorUser()));
		}

		if (rawEntity.getFacilityUser() != null) {
			rawEntity.setFacilityUser(facilityUserService.updateOldData(rawEntity.getFacilityUser()));
		}

		if (rawEntity.getManagementUser() != null) {
			rawEntity.setManagementUser(managementUserService.updateOldData(rawEntity.getManagementUser()));
		}

		if (rawEntity.getMedicalRecordUser() != null) {
			rawEntity.setMedicalRecordUser(medicalRecordUserService.updateOldData(rawEntity.getMedicalRecordUser()));
		}

		if (rawEntity.getMedicalTranscriberUser() != null) {
			rawEntity.setMedicalTranscriberUser(medicalTranscriberUserService.updateOldData(rawEntity.getMedicalTranscriberUser()));
		}

		if (rawEntity.getNurseUser() != null) {
			rawEntity.setNurseUser(nurseUserService.updateOldData(rawEntity.getNurseUser()));
		}

		if (rawEntity.getPharmacyUser() != null) {
			rawEntity.setPharmacyUser(pharmacyUserService.updateOldData(rawEntity.getPharmacyUser()));
		}

		if (rawEntity.getPurchasingUser() != null) {
			rawEntity.setPurchasingUser(purchasingUserService.updateOldData(rawEntity.getPurchasingUser()));
		}

		if (rawEntity.getRegistrationUser() != null) {
			rawEntity.setRegistrationUser(registrationUserService.updateOldData(rawEntity.getRegistrationUser()));
		}

		if (rawEntity.getSystemAdminUser() != null) {
			rawEntity.setSystemAdminUser(systemAdminUserService.updateOldData(rawEntity.getSystemAdminUser()));
		}

		if (rawEntity.getWarehouseUser() != null) {
			rawEntity.setWarehouseUser(warehouseUserService.updateOldData(rawEntity.getWarehouseUser()));
		}

		if (rawEntity.getAdministrator() != null) {
			rawEntity.setAdministrator(administratorService.updateOldData(rawEntity.getAdministrator()));
		}

		if (rawEntity.getBpjsDoctorMapping() != null) {
			rawEntity.setBpjsDoctorMapping(bpjsDoctorMappingService.updateOldData(rawEntity.getBpjsDoctorMapping()));
		}

		if (rawEntity.getPcareDokter() != null) {
			rawEntity.setPcareDokter(pcareDokterService.updateOldData(rawEntity.getPcareDokter()));
		}

		if (rawEntity.getService() != null) {
			rawEntity.setService(serviceService.updateOldData(rawEntity.getService()));
		}

		Set<InformedConsentEntity> accompanyingConsents = new HashSet<>();
		rawEntity.getAccompanyingConsents().forEach(entity -> {
			accompanyingConsents.add(informedConsentService.updateOldData(entity));
		});
		rawEntity.setAccompanyingConsents(accompanyingConsents);

		Set<AmendmentDetailEntity> amendmentDetails = new HashSet<>();
		rawEntity.getAmendmentDetails().forEach(entity -> {
			amendmentDetails.add(amendmentDetailService.updateOldData(entity));
		});
		rawEntity.setAmendmentDetails(amendmentDetails);

		Set<PreoperativeRecordsEntity> anesthesiaMedicalTranscriber = new HashSet<>();
		rawEntity.getAnesthesiaMedicalTranscriber().forEach(entity -> {
			anesthesiaMedicalTranscriber.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setAnesthesiaMedicalTranscriber(anesthesiaMedicalTranscriber);

		Set<PreoperativeRecordsEntity> anesthesiologist = new HashSet<>();
		rawEntity.getAnesthesiologist().forEach(entity -> {
			anesthesiologist.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setAnesthesiologist(anesthesiologist);

		Set<PreoperativeRecordsEntity> anesthesiologyNurse = new HashSet<>();
		rawEntity.getAnesthesiologyNurse().forEach(entity -> {
			anesthesiologyNurse.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setAnesthesiologyNurse(anesthesiologyNurse);

		Set<CashReceiptEntity> cashierStaff = new HashSet<>();
		rawEntity.getCashierStaff().forEach(entity -> {
			cashierStaff.add(cashReceiptService.updateOldData(entity));
		});
		rawEntity.setCashierStaff(cashierStaff);

		Set<CoTreatingDoctorEntity> coTreatingDoctors = new HashSet<>();
		rawEntity.getCoTreatingDoctors().forEach(entity -> {
			coTreatingDoctors.add(coTreatingDoctorService.updateOldData(entity));
		});
		rawEntity.setCoTreatingDoctors(coTreatingDoctors);

		Set<DailyCareCPPTEntity> dailyCareCPPTsCreatedByStaff = new HashSet<>();
		rawEntity.getDailyCareCPPTsCreatedByStaff().forEach(entity -> {
			dailyCareCPPTsCreatedByStaff.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setDailyCareCPPTsCreatedByStaff(dailyCareCPPTsCreatedByStaff);

		Set<DailyCareCPPTEntity> dailyCareCPPTsDoctorInCharge = new HashSet<>();
		rawEntity.getDailyCareCPPTsDoctorInCharge().forEach(entity -> {
			dailyCareCPPTsDoctorInCharge.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setDailyCareCPPTsDoctorInCharge(dailyCareCPPTsDoctorInCharge);

		Set<DailyCareCPPTEntity> dailyCareCPPTsMedicalTranscriber = new HashSet<>();
		rawEntity.getDailyCareCPPTsMedicalTranscriber().forEach(entity -> {
			dailyCareCPPTsMedicalTranscriber.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setDailyCareCPPTsMedicalTranscriber(dailyCareCPPTsMedicalTranscriber);

		Set<DeliveryProgressEntity> deliveryProgresses = new HashSet<>();
		rawEntity.getDeliveryProgresses().forEach(entity -> {
			deliveryProgresses.add(deliveryProgressService.updateOldData(entity));
		});
		rawEntity.setDeliveryProgresses(deliveryProgresses);

		Set<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummaries = new HashSet<>();
		rawEntity.getDiagnosticStaffExaminationSummaries().forEach(entity -> {
			diagnosticStaffExaminationSummaries.add(diagnosticStaffExaminationSummaryService.updateOldData(entity));
		});
		rawEntity.setDiagnosticStaffExaminationSummaries(diagnosticStaffExaminationSummaries);

		Set<RegistrationEntity> dismissalReferringStaff = new HashSet<>();
		rawEntity.getDismissalReferringStaff().forEach(entity -> {
			dismissalReferringStaff.add(registrationService.updateOldData(entity));
		});
		rawEntity.setDismissalReferringStaff(dismissalReferringStaff);

		Set<DoctorScheduleEntity> doctorSchedules = new HashSet<>();
		rawEntity.getDoctorSchedules().forEach(entity -> {
			doctorSchedules.add(doctorScheduleService.updateOldData(entity));
		});
		rawEntity.setDoctorSchedules(doctorSchedules);

		Set<MedicalExaminationRecordEntity> doctorOnExamination = new HashSet<>();
		rawEntity.getDoctorOnExamination().forEach(entity -> {
			doctorOnExamination.add(medicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setDoctorOnExamination(doctorOnExamination);

		Set<FluidBalanceDetailEntity> fluidBalanceDetails = new HashSet<>();
		rawEntity.getFluidBalanceDetails().forEach(entity -> {
			fluidBalanceDetails.add(fluidBalanceDetailService.updateOldData(entity));
		});
		rawEntity.setFluidBalanceDetails(fluidBalanceDetails);

		Set<HemodialysisMonitoringEntity> hemodialysisMonitorings = new HashSet<>();
		rawEntity.getHemodialysisMonitorings().forEach(entity -> {
			hemodialysisMonitorings.add(hemodialysisMonitoringService.updateOldData(entity));
		});
		rawEntity.setHemodialysisMonitorings(hemodialysisMonitorings);

		Set<HospitalBranchInformationEntity> hospitalBranchInformations = new HashSet<>();
		rawEntity.getHospitalBranchInformations().forEach(entity -> {
			hospitalBranchInformations.add(hospitalBranchInformationService.updateOldData(entity));
		});
		rawEntity.setHospitalBranchInformations(hospitalBranchInformations);

		Set<InformedConsentEntity> informingConsents = new HashSet<>();
		rawEntity.getInformingConsents().forEach(entity -> {
			informingConsents.add(informedConsentService.updateOldData(entity));
		});
		rawEntity.setInformingConsents(informingConsents);

		Set<InvoiceEntity> invoices = new HashSet<>();
		rawEntity.getInvoices().forEach(entity -> {
			invoices.add(invoiceService.updateOldData(entity));
		});
		rawEntity.setInvoices(invoices);

		Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();
		rawEntity.getMcuPackageItems().forEach(entity -> {
			mcuPackageItems.add(mcuPackageItemService.updateOldData(entity));
		});
		rawEntity.setMcuPackageItems(mcuPackageItems);

		Set<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumes = new HashSet<>();
		rawEntity.getMedicalCertificateDischargeResumes().forEach(entity -> {
			medicalCertificateDischargeResumes.add(medicalCertificateDischargeResumeService.updateOldData(entity));
		});
		rawEntity.setMedicalCertificateDischargeResumes(medicalCertificateDischargeResumes);

		Set<MedicalCertificateBirthEntity> medicalCertificateBirths = new HashSet<>();
		rawEntity.getMedicalCertificateBirths().forEach(entity -> {
			medicalCertificateBirths.add(medicalCertificateBirthService.updateOldData(entity));
		});
		rawEntity.setMedicalCertificateBirths(medicalCertificateBirths);

		Set<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizations = new HashSet<>();
		rawEntity.getMedicalCertificateHospitalizations().forEach(entity -> {
			medicalCertificateHospitalizations.add(medicalCertificateHospitalizationService.updateOldData(entity));
		});
		rawEntity.setMedicalCertificateHospitalizations(medicalCertificateHospitalizations);

		Set<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummarys = new HashSet<>();
		rawEntity.getMedicalExaminationRecordDischargeSummarys().forEach(entity -> {
			medicalExaminationRecordDischargeSummarys.add(medicalExaminationRecordDischargeSummaryService.updateOldData(entity));
		});
		rawEntity.setMedicalExaminationRecordDischargeSummarys(medicalExaminationRecordDischargeSummarys);

		Set<MedicalExaminationRecordEntity> medicalRecordTranscriber = new HashSet<>();
		rawEntity.getMedicalRecordTranscriber().forEach(entity -> {
			medicalRecordTranscriber.add(medicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setMedicalRecordTranscriber(medicalRecordTranscriber);

		Set<MedicalCertificateMedicalAttendanceEntity> medicalStaffOfMedicalAttendancesCertificate = new HashSet<>();
		rawEntity.getMedicalStaffOfMedicalAttendancesCertificate().forEach(entity -> {
			medicalStaffOfMedicalAttendancesCertificate.add(medicalCertificateMedicalAttendanceService.updateOldData(entity));
		});
		rawEntity.setMedicalStaffOfMedicalAttendancesCertificate(medicalStaffOfMedicalAttendancesCertificate);

		Set<MedicalCertificateMentalHealthEntity> medicalStaffOfMentalHealths = new HashSet<>();
		rawEntity.getMedicalStaffOfMentalHealths().forEach(entity -> {
			medicalStaffOfMentalHealths.add(medicalCertificateMentalHealthService.updateOldData(entity));
		});
		rawEntity.setMedicalStaffOfMentalHealths(medicalStaffOfMentalHealths);

		Set<MedicalCertificatePhysicalHealthEntity> medicalStaffOfPhysicalHealths = new HashSet<>();
		rawEntity.getMedicalStaffOfPhysicalHealths().forEach(entity -> {
			medicalStaffOfPhysicalHealths.add(medicalCertificatePhysicalHealthService.updateOldData(entity));
		});
		rawEntity.setMedicalStaffOfPhysicalHealths(medicalStaffOfPhysicalHealths);

		Set<MedicalCertificateRestrictedWorkEntity> medicalStaffOfRestrictedWorksCertificate = new HashSet<>();
		rawEntity.getMedicalStaffOfRestrictedWorksCertificate().forEach(entity -> {
			medicalStaffOfRestrictedWorksCertificate.add(medicalCertificateRestrictedWorkService.updateOldData(entity));
		});
		rawEntity.setMedicalStaffOfRestrictedWorksCertificate(medicalStaffOfRestrictedWorksCertificate);

		Set<MedicalCertificateSickLeaveEntity> medicalStaffOfSickLeavesCertificate = new HashSet<>();
		rawEntity.getMedicalStaffOfSickLeavesCertificate().forEach(entity -> {
			medicalStaffOfSickLeavesCertificate.add(medicalCertificateSickLeaveService.updateOldData(entity));
		});
		rawEntity.setMedicalStaffOfSickLeavesCertificate(medicalStaffOfSickLeavesCertificate);

		Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotries = new HashSet<>();
		rawEntity.getMedicationAdministeredHisotries().forEach(entity -> {
			medicationAdministeredHisotries.add(medicationAdministeredHistoryService.updateOldData(entity));
		});
		rawEntity.setMedicationAdministeredHisotries(medicationAdministeredHisotries);

		Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();
		rawEntity.getMedicationHeaders().forEach(entity -> {
			medicationHeaders.add(medicationHeaderService.updateOldData(entity));
		});
		rawEntity.setMedicationHeaders(medicationHeaders);

		Set<DeliveryMedicalExaminationRecordEntity> midwives = new HashSet<>();
		rawEntity.getMidwives().forEach(entity -> {
			midwives.add(deliveryMedicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setMidwives(midwives);

		Set<MedicalExaminationRecordEntity> nurse = new HashSet<>();
		rawEntity.getNurse().forEach(entity -> {
			nurse.add(medicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setNurse(nurse);

		Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailSurgicalNursing = new HashSet<>();
		rawEntity.getNursingDetailSurgicalNursing().forEach(entity -> {
			nursingDetailSurgicalNursing.add(operatingTheaterMedicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setNursingDetailSurgicalNursing(nursingDetailSurgicalNursing);

		Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailsAnesthesiaNursing = new HashSet<>();
		rawEntity.getNursingDetailsAnesthesiaNursing().forEach(entity -> {
			nursingDetailsAnesthesiaNursing.add(operatingTheaterMedicalExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setNursingDetailsAnesthesiaNursing(nursingDetailsAnesthesiaNursing);

		Set<PatientConsentEntity> patientConsents = new HashSet<>();
		rawEntity.getPatientConsents().forEach(entity -> {
			patientConsents.add(patientConsentService.updateOldData(entity));
		});
		rawEntity.setPatientConsents(patientConsents);

		Set<PatientVitalInformationEntity> patientVitalInformations = new HashSet<>();
		rawEntity.getPatientVitalInformations().forEach(entity -> {
			patientVitalInformations.add(patientVitalInformationService.updateOldData(entity));
		});
		rawEntity.setPatientVitalInformations(patientVitalInformations);

		Set<NewbornDetailEntity> pediatricianInCharge = new HashSet<>();
		rawEntity.getPediatricianInCharge().forEach(entity -> {
			pediatricianInCharge.add(newbornDetailService.updateOldData(entity));
		});
		rawEntity.setPediatricianInCharge(pediatricianInCharge);

		Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();
		rawEntity.getPrescriptionHeaders().forEach(entity -> {
			prescriptionHeaders.add(prescriptionHeaderService.updateOldData(entity));
		});
		rawEntity.setPrescriptionHeaders(prescriptionHeaders);

		Set<ProcessWorkflowEntity> processWorkflowLogs = new HashSet<>();
		rawEntity.getProcessWorkflowLogs().forEach(entity -> {
			processWorkflowLogs.add(processWorkflowService.updateOldData(entity));
		});
		rawEntity.setProcessWorkflowLogs(processWorkflowLogs);

		Set<RegistrationEntity> registrations = new HashSet<>();
		rawEntity.getRegistrations().forEach(entity -> {
			registrations.add(registrationService.updateOldData(entity));
		});
		rawEntity.setRegistrations(registrations);

		Set<RegistrationEntity> requestedBy = new HashSet<>();
		rawEntity.getRequestedBy().forEach(entity -> {
			requestedBy.add(registrationService.updateOldData(entity));
		});
		rawEntity.setRequestedBy(requestedBy);

		Set<RoomTransferEntity> roomTransfers = new HashSet<>();
		rawEntity.getRoomTransfers().forEach(entity -> {
			roomTransfers.add(roomTransferService.updateOldData(entity));
		});
		rawEntity.setRoomTransfers(roomTransfers);

		Set<SampleCollectionItemsEntity> sampleCollectionStaffs = new HashSet<>();
		rawEntity.getSampleCollectionStaffs().forEach(entity -> {
			sampleCollectionStaffs.add(sampleCollectionItemsService.updateOldData(entity));
		});
		rawEntity.setSampleCollectionStaffs(sampleCollectionStaffs);

		Set<SampleCollectionItemsEntity> sampleDeliveryStaffs = new HashSet<>();
		rawEntity.getSampleDeliveryStaffs().forEach(entity -> {
			sampleDeliveryStaffs.add(sampleCollectionItemsService.updateOldData(entity));
		});
		rawEntity.setSampleDeliveryStaffs(sampleDeliveryStaffs);

		Set<SampleCollectionItemsEntity> sampleProcessingStaffs = new HashSet<>();
		rawEntity.getSampleProcessingStaffs().forEach(entity -> {
			sampleProcessingStaffs.add(sampleCollectionItemsService.updateOldData(entity));
		});
		rawEntity.setSampleProcessingStaffs(sampleProcessingStaffs);

		Set<PreoperativeRecordsEntity> surgeon = new HashSet<>();
		rawEntity.getSurgeon().forEach(entity -> {
			surgeon.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setSurgeon(surgeon);

		Set<PreoperativeRecordsEntity> surgicalMedicalTranscriber = new HashSet<>();
		rawEntity.getSurgicalMedicalTranscriber().forEach(entity -> {
			surgicalMedicalTranscriber.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setSurgicalMedicalTranscriber(surgicalMedicalTranscriber);

		Set<PreoperativeRecordsEntity> surgicalNurse = new HashSet<>();
		rawEntity.getSurgicalNurse().forEach(entity -> {
			surgicalNurse.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setSurgicalNurse(surgicalNurse);

		Set<TransferOrderStockDetailEntity> transferOrderStockDetails = new HashSet<>();
		rawEntity.getTransferOrderStockDetails().forEach(entity -> {
			transferOrderStockDetails.add(transferOrderStockDetailService.updateOldData(entity));
		});
		rawEntity.setTransferOrderStockDetails(transferOrderStockDetails);

		Set<VaccinationOrderEntity> vaccinationOrders = new HashSet<>();
		rawEntity.getVaccinationOrders().forEach(entity -> {
			vaccinationOrders.add(vaccinationOrderService.updateOldData(entity));
		});
		rawEntity.setVaccinationOrders(vaccinationOrders);

		Set<ServiceEntity> services = new HashSet<>();
		rawEntity.getServices().forEach(entity -> {
			services.add(serviceService.updateOldData(entity));
		});
		rawEntity.setServices(services);

		StaffEntity entityFromDb = staffService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		StaffEntity newEntity = staffService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link StaffMutationResolver#updateStaff(StaffEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'update')")
	public List<StaffEntity> updateAllStaff(@NonNull List<StaffEntity> rawEntities) {
		List<StaffEntity> newEntities = Lists.newArrayList(staffService.updateAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the updated entities here] off begin
		// % protected region % [Add any additional logic for update before returning the updated entities here] end

		return newEntities;
	}

	/**
	 * Delete the entity with the ID from the database.
	 *
	 * @param id the ID of the entity to be deleted
	 * @return the ID of the deleted entity
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'delete')")
	public String deleteStaffById(@NonNull String id) {
		staffService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link StaffMutationResolver#deleteStaffById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'delete')")
	public List<String> deleteAllStaffByIds(@NonNull List<String> ids) {
		staffService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('StaffEntity', 'delete')")
	public List<String> deleteStaffExcludingIds(@NonNull List<String> ids) {
		staffService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
