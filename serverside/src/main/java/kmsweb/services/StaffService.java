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
package kmsweb.services;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.querydsl.QSort;
import kmsweb.entities.*;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.StaffRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.graphql.utils.Where;
import kmsweb.graphql.utils.AuditQueryType;
import kmsweb.services.utils.QuerydslUtils;
import kmsweb.configs.security.auditing.CustomRevisionEntity;
import com.google.common.collect.Lists;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import com.google.common.collect.Sets;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import kmsweb.entities.enums.*;
import java.time.*;
import kmsweb.entities.AdministrationUserEntity;
import kmsweb.repositories.AdministrationUserRepository;
import kmsweb.entities.AdministratorEntity;
import kmsweb.repositories.AdministratorRepository;
import kmsweb.entities.AmendmentDetailEntity;
import kmsweb.repositories.AmendmentDetailRepository;
import kmsweb.entities.BpjsDoctorMappingEntity;
import kmsweb.repositories.BpjsDoctorMappingRepository;
import kmsweb.entities.CashReceiptEntity;
import kmsweb.repositories.CashReceiptRepository;
import kmsweb.entities.CashierUserEntity;
import kmsweb.repositories.CashierUserRepository;
import kmsweb.entities.ClaimUserEntity;
import kmsweb.repositories.ClaimUserRepository;
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.repositories.CoTreatingDoctorRepository;
import kmsweb.entities.DailyCareCPPTEntity;
import kmsweb.repositories.DailyCareCPPTRepository;
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.repositories.DeliveryMedicalExaminationRecordRepository;
import kmsweb.entities.DeliveryProgressEntity;
import kmsweb.repositories.DeliveryProgressRepository;
import kmsweb.entities.DiagnosticStaffExaminationSummaryEntity;
import kmsweb.repositories.DiagnosticStaffExaminationSummaryRepository;
import kmsweb.entities.DiagnosticSupportUserEntity;
import kmsweb.repositories.DiagnosticSupportUserRepository;
import kmsweb.entities.DoctorScheduleEntity;
import kmsweb.repositories.DoctorScheduleRepository;
import kmsweb.entities.DoctorUserEntity;
import kmsweb.repositories.DoctorUserRepository;
import kmsweb.entities.FacilityUserEntity;
import kmsweb.repositories.FacilityUserRepository;
import kmsweb.entities.FluidBalanceDetailEntity;
import kmsweb.repositories.FluidBalanceDetailRepository;
import kmsweb.entities.HemodialysisMonitoringEntity;
import kmsweb.repositories.HemodialysisMonitoringRepository;
import kmsweb.entities.HospitalBranchInformationEntity;
import kmsweb.repositories.HospitalBranchInformationRepository;
import kmsweb.entities.InformedConsentEntity;
import kmsweb.repositories.InformedConsentRepository;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.entities.McuPackageItemEntity;
import kmsweb.repositories.McuPackageItemRepository;
import kmsweb.entities.ManagementUserEntity;
import kmsweb.repositories.ManagementUserRepository;
import kmsweb.entities.MedicalCertificateDischargeResumeEntity;
import kmsweb.repositories.MedicalCertificateDischargeResumeRepository;
import kmsweb.entities.MedicalCertificateBirthEntity;
import kmsweb.repositories.MedicalCertificateBirthRepository;
import kmsweb.entities.MedicalCertificateHospitalizationEntity;
import kmsweb.repositories.MedicalCertificateHospitalizationRepository;
import kmsweb.entities.MedicalCertificateMedicalAttendanceEntity;
import kmsweb.repositories.MedicalCertificateMedicalAttendanceRepository;
import kmsweb.entities.MedicalCertificateMentalHealthEntity;
import kmsweb.repositories.MedicalCertificateMentalHealthRepository;
import kmsweb.entities.MedicalCertificatePhysicalHealthEntity;
import kmsweb.repositories.MedicalCertificatePhysicalHealthRepository;
import kmsweb.entities.MedicalCertificateRestrictedWorkEntity;
import kmsweb.repositories.MedicalCertificateRestrictedWorkRepository;
import kmsweb.entities.MedicalCertificateSickLeaveEntity;
import kmsweb.repositories.MedicalCertificateSickLeaveRepository;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.entities.MedicalExaminationRecordDischargeSummaryEntity;
import kmsweb.repositories.MedicalExaminationRecordDischargeSummaryRepository;
import kmsweb.entities.MedicalRecordUserEntity;
import kmsweb.repositories.MedicalRecordUserRepository;
import kmsweb.entities.MedicalTranscriberUserEntity;
import kmsweb.repositories.MedicalTranscriberUserRepository;
import kmsweb.entities.MedicationAdministeredHistoryEntity;
import kmsweb.repositories.MedicationAdministeredHistoryRepository;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.entities.NewbornDetailEntity;
import kmsweb.repositories.NewbornDetailRepository;
import kmsweb.entities.NurseUserEntity;
import kmsweb.repositories.NurseUserRepository;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.entities.PcareDokterEntity;
import kmsweb.repositories.PcareDokterRepository;
import kmsweb.entities.PatientConsentEntity;
import kmsweb.repositories.PatientConsentRepository;
import kmsweb.entities.PatientVitalInformationEntity;
import kmsweb.repositories.PatientVitalInformationRepository;
import kmsweb.entities.PharmacyUserEntity;
import kmsweb.repositories.PharmacyUserRepository;
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.repositories.PreoperativeRecordsRepository;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.entities.ProcessWorkflowEntity;
import kmsweb.repositories.ProcessWorkflowRepository;
import kmsweb.entities.PurchasingUserEntity;
import kmsweb.repositories.PurchasingUserRepository;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.entities.RegistrationUserEntity;
import kmsweb.repositories.RegistrationUserRepository;
import kmsweb.entities.RoomTransferEntity;
import kmsweb.repositories.RoomTransferRepository;
import kmsweb.entities.SampleCollectionItemsEntity;
import kmsweb.repositories.SampleCollectionItemsRepository;
import kmsweb.entities.ServiceEntity;
import kmsweb.repositories.ServiceRepository;
import kmsweb.entities.SystemAdminUserEntity;
import kmsweb.repositories.SystemAdminUserRepository;
import kmsweb.entities.TransferOrderStockDetailEntity;
import kmsweb.repositories.TransferOrderStockDetailRepository;
import kmsweb.entities.VaccinationOrderEntity;
import kmsweb.repositories.VaccinationOrderRepository;
import kmsweb.entities.WarehouseUserEntity;
import kmsweb.repositories.WarehouseUserRepository;
import kmsweb.lib.file.models.FileEntity;
import kmsweb.lib.file.services.AbstractFileService;
// % protected region % [Override your file service import here] off begin
import kmsweb.lib.file.services.S3FileService;
// % protected region % [Override your file service import here] end

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class StaffService extends AbstractService<StaffEntity, StaffRepository, StaffEntityAudit> {

	private final String[] referenceNamesInStaffEntity = {
		"accompanyingConsents",
		"administrator",
		"amendmentDetails",
		"anesthesiaMedicalTranscriber",
		"anesthesiologist",
		"anesthesiologyNurse",
		"bpjsDoctorMapping",
		"cashierStaff",
		"coTreatingDoctors",
		"dailyCareCPPTsCreatedByStaff",
		"dailyCareCPPTsDoctorInCharge",
		"dailyCareCPPTsMedicalTranscriber",
		"deliveryProgresses",
		"diagnosticStaffExaminationSummaries",
		"dismissalReferringStaff",
		"doctorSchedules",
		"doctorOnExamination",
		"fluidBalanceDetails",
		"hemodialysisMonitorings",
		"hospitalBranchInformations",
		"informingConsents",
		"invoices",
		"mcuPackageItems",
		"medicalCertificateDischargeResumes",
		"medicalCertificateBirths",
		"medicalCertificateHospitalizations",
		"medicalExaminationRecordDischargeSummarys",
		"medicalRecordTranscriber",
		"medicalStaffOfMedicalAttendancesCertificate",
		"medicalStaffOfMentalHealths",
		"medicalStaffOfPhysicalHealths",
		"medicalStaffOfRestrictedWorksCertificate",
		"medicalStaffOfSickLeavesCertificate",
		"medicationAdministeredHisotries",
		"medicationHeaders",
		"midwives",
		"nurse",
		"nursingDetailSurgicalNursing",
		"nursingDetailsAnesthesiaNursing",
		"pcareDokter",
		"patientConsents",
		"patientVitalInformations",
		"pediatricianInCharge",
		"prescriptionHeaders",
		"processWorkflowLogs",
		"registrations",
		"requestedBy",
		"roomTransfers",
		"sampleCollectionStaffs",
		"sampleDeliveryStaffs",
		"sampleProcessingStaffs",
		"service",
		"services",
		"surgeon",
		"surgicalMedicalTranscriber",
		"surgicalNurse",
		"transferOrderStockDetails",
		"vaccinationOrders",
		"administrationUser",
		"cashierUser",
		"claimUser",
		"diagnosticSupportUser",
		"doctorUser",
		"facilityUser",
		"managementUser",
		"medicalRecordUser",
		"medicalTranscriberUser",
		"nurseUser",
		"pharmacyUser",
		"purchasingUser",
		"registrationUser",
		"systemAdminUser",
		"warehouseUser",
	};

	private AbstractFileService<FileEntity> fileService;

	private final AdministrationUserRepository administrationUserRepository;

	private final AdministratorRepository administratorRepository;

	private final AmendmentDetailRepository amendmentDetailRepository;

	private final BpjsDoctorMappingRepository bpjsDoctorMappingRepository;

	private final CashReceiptRepository cashReceiptRepository;

	private final CashierUserRepository cashierUserRepository;

	private final ClaimUserRepository claimUserRepository;

	private final CoTreatingDoctorRepository coTreatingDoctorRepository;

	private final DailyCareCPPTRepository dailyCareCPPTRepository;

	private final DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository;

	private final DeliveryProgressRepository deliveryProgressRepository;

	private final DiagnosticStaffExaminationSummaryRepository diagnosticStaffExaminationSummaryRepository;

	private final DiagnosticSupportUserRepository diagnosticSupportUserRepository;

	private final DoctorScheduleRepository doctorScheduleRepository;

	private final DoctorUserRepository doctorUserRepository;

	private final FacilityUserRepository facilityUserRepository;

	private final FluidBalanceDetailRepository fluidBalanceDetailRepository;

	private final HemodialysisMonitoringRepository hemodialysisMonitoringRepository;

	private final HospitalBranchInformationRepository hospitalBranchInformationRepository;

	private final InformedConsentRepository informedConsentRepository;

	private final InvoiceRepository invoiceRepository;

	private final McuPackageItemRepository mcuPackageItemRepository;

	private final ManagementUserRepository managementUserRepository;

	private final MedicalCertificateDischargeResumeRepository medicalCertificateDischargeResumeRepository;

	private final MedicalCertificateBirthRepository medicalCertificateBirthRepository;

	private final MedicalCertificateHospitalizationRepository medicalCertificateHospitalizationRepository;

	private final MedicalCertificateMedicalAttendanceRepository medicalCertificateMedicalAttendanceRepository;

	private final MedicalCertificateMentalHealthRepository medicalCertificateMentalHealthRepository;

	private final MedicalCertificatePhysicalHealthRepository medicalCertificatePhysicalHealthRepository;

	private final MedicalCertificateRestrictedWorkRepository medicalCertificateRestrictedWorkRepository;

	private final MedicalCertificateSickLeaveRepository medicalCertificateSickLeaveRepository;

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private final MedicalExaminationRecordDischargeSummaryRepository medicalExaminationRecordDischargeSummaryRepository;

	private final MedicalRecordUserRepository medicalRecordUserRepository;

	private final MedicalTranscriberUserRepository medicalTranscriberUserRepository;

	private final MedicationAdministeredHistoryRepository medicationAdministeredHistoryRepository;

	private final MedicationHeaderRepository medicationHeaderRepository;

	private final NewbornDetailRepository newbornDetailRepository;

	private final NurseUserRepository nurseUserRepository;

	private final OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;

	private final PcareDokterRepository pcareDokterRepository;

	private final PatientConsentRepository patientConsentRepository;

	private final PatientVitalInformationRepository patientVitalInformationRepository;

	private final PharmacyUserRepository pharmacyUserRepository;

	private final PreoperativeRecordsRepository preoperativeRecordsRepository;

	private final PrescriptionHeaderRepository prescriptionHeaderRepository;

	private final ProcessWorkflowRepository processWorkflowRepository;

	private final PurchasingUserRepository purchasingUserRepository;

	private final RegistrationRepository registrationRepository;

	private final RegistrationUserRepository registrationUserRepository;

	private final RoomTransferRepository roomTransferRepository;

	private final SampleCollectionItemsRepository sampleCollectionItemsRepository;

	private final ServiceRepository serviceRepository;

	private final SystemAdminUserRepository systemAdminUserRepository;

	private final TransferOrderStockDetailRepository transferOrderStockDetailRepository;

	private final VaccinationOrderRepository vaccinationOrderRepository;

	private final WarehouseUserRepository warehouseUserRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public StaffService(
		// % protected region % [Add any additional constructor parameters here] off begin
		S3FileService s3FileService,
		// % protected region % [Add any additional constructor parameters here] end
		AdministrationUserRepository administrationUserRepository,
		AdministratorRepository administratorRepository,
		AmendmentDetailRepository amendmentDetailRepository,
		BpjsDoctorMappingRepository bpjsDoctorMappingRepository,
		CashReceiptRepository cashReceiptRepository,
		CashierUserRepository cashierUserRepository,
		ClaimUserRepository claimUserRepository,
		CoTreatingDoctorRepository coTreatingDoctorRepository,
		DailyCareCPPTRepository dailyCareCPPTRepository,
		DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository,
		DeliveryProgressRepository deliveryProgressRepository,
		DiagnosticStaffExaminationSummaryRepository diagnosticStaffExaminationSummaryRepository,
		DiagnosticSupportUserRepository diagnosticSupportUserRepository,
		DoctorScheduleRepository doctorScheduleRepository,
		DoctorUserRepository doctorUserRepository,
		FacilityUserRepository facilityUserRepository,
		FluidBalanceDetailRepository fluidBalanceDetailRepository,
		HemodialysisMonitoringRepository hemodialysisMonitoringRepository,
		HospitalBranchInformationRepository hospitalBranchInformationRepository,
		InformedConsentRepository informedConsentRepository,
		InvoiceRepository invoiceRepository,
		McuPackageItemRepository mcuPackageItemRepository,
		ManagementUserRepository managementUserRepository,
		MedicalCertificateDischargeResumeRepository medicalCertificateDischargeResumeRepository,
		MedicalCertificateBirthRepository medicalCertificateBirthRepository,
		MedicalCertificateHospitalizationRepository medicalCertificateHospitalizationRepository,
		MedicalCertificateMedicalAttendanceRepository medicalCertificateMedicalAttendanceRepository,
		MedicalCertificateMentalHealthRepository medicalCertificateMentalHealthRepository,
		MedicalCertificatePhysicalHealthRepository medicalCertificatePhysicalHealthRepository,
		MedicalCertificateRestrictedWorkRepository medicalCertificateRestrictedWorkRepository,
		MedicalCertificateSickLeaveRepository medicalCertificateSickLeaveRepository,
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		MedicalExaminationRecordDischargeSummaryRepository medicalExaminationRecordDischargeSummaryRepository,
		MedicalRecordUserRepository medicalRecordUserRepository,
		MedicalTranscriberUserRepository medicalTranscriberUserRepository,
		MedicationAdministeredHistoryRepository medicationAdministeredHistoryRepository,
		MedicationHeaderRepository medicationHeaderRepository,
		NewbornDetailRepository newbornDetailRepository,
		NurseUserRepository nurseUserRepository,
		OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository,
		PcareDokterRepository pcareDokterRepository,
		PatientConsentRepository patientConsentRepository,
		PatientVitalInformationRepository patientVitalInformationRepository,
		PharmacyUserRepository pharmacyUserRepository,
		PreoperativeRecordsRepository preoperativeRecordsRepository,
		PrescriptionHeaderRepository prescriptionHeaderRepository,
		ProcessWorkflowRepository processWorkflowRepository,
		PurchasingUserRepository purchasingUserRepository,
		RegistrationRepository registrationRepository,
		RegistrationUserRepository registrationUserRepository,
		RoomTransferRepository roomTransferRepository,
		SampleCollectionItemsRepository sampleCollectionItemsRepository,
		ServiceRepository serviceRepository,
		SystemAdminUserRepository systemAdminUserRepository,
		TransferOrderStockDetailRepository transferOrderStockDetailRepository,
		VaccinationOrderRepository vaccinationOrderRepository,
		WarehouseUserRepository warehouseUserRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		StaffRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.administrationUserRepository = administrationUserRepository;

		this.administratorRepository = administratorRepository;

		this.amendmentDetailRepository = amendmentDetailRepository;

		this.bpjsDoctorMappingRepository = bpjsDoctorMappingRepository;

		this.cashReceiptRepository = cashReceiptRepository;

		this.cashierUserRepository = cashierUserRepository;

		this.claimUserRepository = claimUserRepository;

		this.coTreatingDoctorRepository = coTreatingDoctorRepository;

		this.dailyCareCPPTRepository = dailyCareCPPTRepository;

		this.deliveryMedicalExaminationRecordRepository = deliveryMedicalExaminationRecordRepository;

		this.deliveryProgressRepository = deliveryProgressRepository;

		this.diagnosticStaffExaminationSummaryRepository = diagnosticStaffExaminationSummaryRepository;

		this.diagnosticSupportUserRepository = diagnosticSupportUserRepository;

		this.doctorScheduleRepository = doctorScheduleRepository;

		this.doctorUserRepository = doctorUserRepository;

		this.facilityUserRepository = facilityUserRepository;

		this.fluidBalanceDetailRepository = fluidBalanceDetailRepository;

		this.hemodialysisMonitoringRepository = hemodialysisMonitoringRepository;

		this.hospitalBranchInformationRepository = hospitalBranchInformationRepository;

		this.informedConsentRepository = informedConsentRepository;

		this.invoiceRepository = invoiceRepository;

		this.mcuPackageItemRepository = mcuPackageItemRepository;

		this.managementUserRepository = managementUserRepository;

		this.medicalCertificateDischargeResumeRepository = medicalCertificateDischargeResumeRepository;

		this.medicalCertificateBirthRepository = medicalCertificateBirthRepository;

		this.medicalCertificateHospitalizationRepository = medicalCertificateHospitalizationRepository;

		this.medicalCertificateMedicalAttendanceRepository = medicalCertificateMedicalAttendanceRepository;

		this.medicalCertificateMentalHealthRepository = medicalCertificateMentalHealthRepository;

		this.medicalCertificatePhysicalHealthRepository = medicalCertificatePhysicalHealthRepository;

		this.medicalCertificateRestrictedWorkRepository = medicalCertificateRestrictedWorkRepository;

		this.medicalCertificateSickLeaveRepository = medicalCertificateSickLeaveRepository;

		this.medicalExaminationRecordRepository = medicalExaminationRecordRepository;

		this.medicalExaminationRecordDischargeSummaryRepository = medicalExaminationRecordDischargeSummaryRepository;

		this.medicalRecordUserRepository = medicalRecordUserRepository;

		this.medicalTranscriberUserRepository = medicalTranscriberUserRepository;

		this.medicationAdministeredHistoryRepository = medicationAdministeredHistoryRepository;

		this.medicationHeaderRepository = medicationHeaderRepository;

		this.newbornDetailRepository = newbornDetailRepository;

		this.nurseUserRepository = nurseUserRepository;

		this.operatingTheaterMedicalExaminationRecordRepository = operatingTheaterMedicalExaminationRecordRepository;

		this.pcareDokterRepository = pcareDokterRepository;

		this.patientConsentRepository = patientConsentRepository;

		this.patientVitalInformationRepository = patientVitalInformationRepository;

		this.pharmacyUserRepository = pharmacyUserRepository;

		this.preoperativeRecordsRepository = preoperativeRecordsRepository;

		this.prescriptionHeaderRepository = prescriptionHeaderRepository;

		this.processWorkflowRepository = processWorkflowRepository;

		this.purchasingUserRepository = purchasingUserRepository;

		this.registrationRepository = registrationRepository;

		this.registrationUserRepository = registrationUserRepository;

		this.roomTransferRepository = roomTransferRepository;

		this.sampleCollectionItemsRepository = sampleCollectionItemsRepository;

		this.serviceRepository = serviceRepository;

		this.systemAdminUserRepository = systemAdminUserRepository;

		this.transferOrderStockDetailRepository = transferOrderStockDetailRepository;

		this.vaccinationOrderRepository = vaccinationOrderRepository;

		this.warehouseUserRepository = warehouseUserRepository;

		this.validator = validator;

		this.auditingRepository = auditingRepository;

		// % protected region % [Add any additional constructor logic here] off begin
		this.fileService = s3FileService;
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Return the number of records available in the database.
	 *
	 * @return the number of records available in the database.
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public long count()
	// % protected region % [Add any throwables, implementations, or extensions for count here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for count here] end
	{
		// % protected region % [Add any additional logic for count before the main body here] off begin
		// % protected region % [Add any additional logic for count before the main body here] end

		long count = repository.count();

		// % protected region % [Add any additional logic for count before returning the count here] off begin
		// % protected region % [Add any additional logic for count before returning the count here] end

		return count;
	}

	/**
	 * Return the number of records available in the database with filters
	 *
	 * @return the number of records available in the database.
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public long count(List<List<Where>> conditions)
	// % protected region % [Add any throwables, implementations, or extensions for count with filters here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for count with filters here] end
	{
		// % protected region % [Add any additional logic for count with query before the main body here] off begin
		// % protected region % [Add any additional logic for count with query before the main body here] end

		long count = (CollectionUtils.isEmpty(conditions) || CollectionUtils.isEmpty(conditions.get(0)))
				? repository.count() : repository.count(this.getQueryConditions(conditions));

		// % protected region % [Add any additional logic for count with query before returning the count here] off begin
		// % protected region % [Add any additional logic for count with query before returning the count here] end

		return count;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Staff Number.
	 *
	 * @param staffNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Staff Number
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<StaffEntity> findByStaffNumber(String staffNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByStaffNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStaffNumber here] end
	{
		// % protected region % [Add any additional logic for findByStaffNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByStaffNumber before the main body here] end

		Optional<StaffEntity> entity = repository.findByStaffNumber(staffNumber);

		// % protected region % [Add any additional logic for findByStaffNumber before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByStaffNumber before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute First Name.
	 *
	 * @param firstName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute First Name
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByFirstName(String firstName)
	// % protected region % [Add any throwables, implementations, or extensions for findByFirstName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFirstName here] end
	{
		// % protected region % [Add any additional logic for findByFirstName before the main body here] off begin
		// % protected region % [Add any additional logic for findByFirstName before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByFirstName(firstName));

		// % protected region % [Add any additional logic for findByFirstName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFirstName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Last Name.
	 *
	 * @param lastName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Name
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByLastName(String lastName)
	// % protected region % [Add any throwables, implementations, or extensions for findByLastName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLastName here] end
	{
		// % protected region % [Add any additional logic for findByLastName before the main body here] off begin
		// % protected region % [Add any additional logic for findByLastName before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByLastName(lastName));

		// % protected region % [Add any additional logic for findByLastName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLastName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Date of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date of Birth
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByDateOfBirth(OffsetDateTime dateOfBirth)
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfBirth here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfBirth here] end
	{
		// % protected region % [Add any additional logic for findByDateOfBirth before the main body here] off begin
		// % protected region % [Add any additional logic for findByDateOfBirth before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByDateOfBirth(dateOfBirth));

		// % protected region % [Add any additional logic for findByDateOfBirth before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDateOfBirth before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Staff Type.
	 *
	 * @param staffType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Staff Type
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByStaffType(String staffType)
	// % protected region % [Add any throwables, implementations, or extensions for findByStaffType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStaffType here] end
	{
		// % protected region % [Add any additional logic for findByStaffType before the main body here] off begin
		// % protected region % [Add any additional logic for findByStaffType before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByStaffType(staffType));

		// % protected region % [Add any additional logic for findByStaffType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStaffType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Specialization.
	 *
	 * @param specialization the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Specialization
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findBySpecialization(String specialization)
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecialization here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySpecialization here] end
	{
		// % protected region % [Add any additional logic for findBySpecialization before the main body here] off begin
		// % protected region % [Add any additional logic for findBySpecialization before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findBySpecialization(specialization));

		// % protected region % [Add any additional logic for findBySpecialization before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySpecialization before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Education.
	 *
	 * @param education the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Education
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByEducation(String education)
	// % protected region % [Add any throwables, implementations, or extensions for findByEducation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEducation here] end
	{
		// % protected region % [Add any additional logic for findByEducation before the main body here] off begin
		// % protected region % [Add any additional logic for findByEducation before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByEducation(education));

		// % protected region % [Add any additional logic for findByEducation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEducation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute License No.
	 *
	 * @param licenseNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute License No
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByLicenseNo(String licenseNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByLicenseNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLicenseNo here] end
	{
		// % protected region % [Add any additional logic for findByLicenseNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByLicenseNo before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByLicenseNo(licenseNo));

		// % protected region % [Add any additional logic for findByLicenseNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLicenseNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Letter of Reg.
	 *
	 * @param letterOfReg the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Letter of Reg
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByLetterOfReg(String letterOfReg)
	// % protected region % [Add any throwables, implementations, or extensions for findByLetterOfReg here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLetterOfReg here] end
	{
		// % protected region % [Add any additional logic for findByLetterOfReg before the main body here] off begin
		// % protected region % [Add any additional logic for findByLetterOfReg before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByLetterOfReg(letterOfReg));

		// % protected region % [Add any additional logic for findByLetterOfReg before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLetterOfReg before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByGender(String gender)
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] end
	{
		// % protected region % [Add any additional logic for findByGender before the main body here] off begin
		// % protected region % [Add any additional logic for findByGender before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByGender(gender));

		// % protected region % [Add any additional logic for findByGender before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGender before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Employee ID.
	 *
	 * @param employeeID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Employee ID
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByEmployeeID(String employeeID)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmployeeID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmployeeID here] end
	{
		// % protected region % [Add any additional logic for findByEmployeeID before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmployeeID before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByEmployeeID(employeeID));

		// % protected region % [Add any additional logic for findByEmployeeID before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmployeeID before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Title.
	 *
	 * @param title the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Title
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByTitle(String title)
	// % protected region % [Add any throwables, implementations, or extensions for findByTitle here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTitle here] end
	{
		// % protected region % [Add any additional logic for findByTitle before the main body here] off begin
		// % protected region % [Add any additional logic for findByTitle before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByTitle(title));

		// % protected region % [Add any additional logic for findByTitle before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTitle before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Default Service Number.
	 *
	 * @param defaultServiceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Default Service Number
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByDefaultServiceNumber(String defaultServiceNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByDefaultServiceNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDefaultServiceNumber here] end
	{
		// % protected region % [Add any additional logic for findByDefaultServiceNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByDefaultServiceNumber before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByDefaultServiceNumber(defaultServiceNumber));

		// % protected region % [Add any additional logic for findByDefaultServiceNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDefaultServiceNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Place of birth.
	 *
	 * @param placeOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Place of birth
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByPlaceOfBirth(String placeOfBirth)
	// % protected region % [Add any throwables, implementations, or extensions for findByPlaceOfBirth here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPlaceOfBirth here] end
	{
		// % protected region % [Add any additional logic for findByPlaceOfBirth before the main body here] off begin
		// % protected region % [Add any additional logic for findByPlaceOfBirth before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByPlaceOfBirth(placeOfBirth));

		// % protected region % [Add any additional logic for findByPlaceOfBirth before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPlaceOfBirth before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Religion.
	 *
	 * @param religion the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Religion
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByReligion(String religion)
	// % protected region % [Add any throwables, implementations, or extensions for findByReligion here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReligion here] end
	{
		// % protected region % [Add any additional logic for findByReligion before the main body here] off begin
		// % protected region % [Add any additional logic for findByReligion before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByReligion(religion));

		// % protected region % [Add any additional logic for findByReligion before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReligion before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Blood Type.
	 *
	 * @param bloodType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Blood Type
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByBloodType(BloodTypeEnum bloodType)
	// % protected region % [Add any throwables, implementations, or extensions for findByBloodType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBloodType here] end
	{
		// % protected region % [Add any additional logic for findByBloodType before the main body here] off begin
		// % protected region % [Add any additional logic for findByBloodType before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByBloodType(bloodType));

		// % protected region % [Add any additional logic for findByBloodType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBloodType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Rhesus.
	 *
	 * @param rhesus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rhesus
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByRhesus(RhesusEnum rhesus)
	// % protected region % [Add any throwables, implementations, or extensions for findByRhesus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRhesus here] end
	{
		// % protected region % [Add any additional logic for findByRhesus before the main body here] off begin
		// % protected region % [Add any additional logic for findByRhesus before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByRhesus(rhesus));

		// % protected region % [Add any additional logic for findByRhesus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRhesus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute address
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByAddress(String address)
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] end
	{
		// % protected region % [Add any additional logic for findByAddress before the main body here] off begin
		// % protected region % [Add any additional logic for findByAddress before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByAddress(address));

		// % protected region % [Add any additional logic for findByAddress before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAddress before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Country.
	 *
	 * @param country the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Country
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByCountry(String country)
	// % protected region % [Add any throwables, implementations, or extensions for findByCountry here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCountry here] end
	{
		// % protected region % [Add any additional logic for findByCountry before the main body here] off begin
		// % protected region % [Add any additional logic for findByCountry before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByCountry(country));

		// % protected region % [Add any additional logic for findByCountry before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCountry before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute State.
	 *
	 * @param state the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute State
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByState(String state)
	// % protected region % [Add any throwables, implementations, or extensions for findByState here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByState here] end
	{
		// % protected region % [Add any additional logic for findByState before the main body here] off begin
		// % protected region % [Add any additional logic for findByState before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByState(state));

		// % protected region % [Add any additional logic for findByState before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByState before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Regency.
	 *
	 * @param regency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Regency
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByRegency(String regency)
	// % protected region % [Add any throwables, implementations, or extensions for findByRegency here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRegency here] end
	{
		// % protected region % [Add any additional logic for findByRegency before the main body here] off begin
		// % protected region % [Add any additional logic for findByRegency before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByRegency(regency));

		// % protected region % [Add any additional logic for findByRegency before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRegency before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute District.
	 *
	 * @param district the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute District
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByDistrict(String district)
	// % protected region % [Add any throwables, implementations, or extensions for findByDistrict here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDistrict here] end
	{
		// % protected region % [Add any additional logic for findByDistrict before the main body here] off begin
		// % protected region % [Add any additional logic for findByDistrict before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByDistrict(district));

		// % protected region % [Add any additional logic for findByDistrict before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDistrict before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Home phone no.
	 *
	 * @param homePhoneNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Home phone no
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByHomePhoneNo(String homePhoneNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByHomePhoneNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHomePhoneNo here] end
	{
		// % protected region % [Add any additional logic for findByHomePhoneNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByHomePhoneNo before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByHomePhoneNo(homePhoneNo));

		// % protected region % [Add any additional logic for findByHomePhoneNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHomePhoneNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Village.
	 *
	 * @param village the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Village
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByVillage(String village)
	// % protected region % [Add any throwables, implementations, or extensions for findByVillage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVillage here] end
	{
		// % protected region % [Add any additional logic for findByVillage before the main body here] off begin
		// % protected region % [Add any additional logic for findByVillage before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByVillage(village));

		// % protected region % [Add any additional logic for findByVillage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVillage before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Postcode.
	 *
	 * @param postcode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postcode
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByPostcode(String postcode)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostcode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostcode here] end
	{
		// % protected region % [Add any additional logic for findByPostcode before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostcode before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByPostcode(postcode));

		// % protected region % [Add any additional logic for findByPostcode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostcode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Office Phone Number.
	 *
	 * @param officePhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Office Phone Number
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByOfficePhoneNumber(String officePhoneNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByOfficePhoneNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOfficePhoneNumber here] end
	{
		// % protected region % [Add any additional logic for findByOfficePhoneNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByOfficePhoneNumber before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByOfficePhoneNumber(officePhoneNumber));

		// % protected region % [Add any additional logic for findByOfficePhoneNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOfficePhoneNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tax Identification No.
	 *
	 * @param taxIdentificationNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Identification No
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByTaxIdentificationNo(String taxIdentificationNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxIdentificationNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxIdentificationNo here] end
	{
		// % protected region % [Add any additional logic for findByTaxIdentificationNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaxIdentificationNo before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByTaxIdentificationNo(taxIdentificationNo));

		// % protected region % [Add any additional logic for findByTaxIdentificationNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTaxIdentificationNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Mobile Phone No.
	 *
	 * @param mobilePhoneNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Mobile Phone No
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByMobilePhoneNo(String mobilePhoneNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByMobilePhoneNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMobilePhoneNo here] end
	{
		// % protected region % [Add any additional logic for findByMobilePhoneNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByMobilePhoneNo before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByMobilePhoneNo(mobilePhoneNo));

		// % protected region % [Add any additional logic for findByMobilePhoneNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMobilePhoneNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Notes.
	 *
	 * @param otherNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Notes
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByOtherNotes(String otherNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherNotes here] end
	{
		// % protected region % [Add any additional logic for findByOtherNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherNotes before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByOtherNotes(otherNotes));

		// % protected region % [Add any additional logic for findByOtherNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Training.
	 *
	 * @param training the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Training
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByTraining(String training)
	// % protected region % [Add any throwables, implementations, or extensions for findByTraining here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTraining here] end
	{
		// % protected region % [Add any additional logic for findByTraining before the main body here] off begin
		// % protected region % [Add any additional logic for findByTraining before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByTraining(training));

		// % protected region % [Add any additional logic for findByTraining before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTraining before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Nationality.
	 *
	 * @param nationality the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nationality
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByNationality(String nationality)
	// % protected region % [Add any throwables, implementations, or extensions for findByNationality here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNationality here] end
	{
		// % protected region % [Add any additional logic for findByNationality before the main body here] off begin
		// % protected region % [Add any additional logic for findByNationality before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByNationality(nationality));

		// % protected region % [Add any additional logic for findByNationality before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNationality before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Certification.
	 *
	 * @param certification the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Certification
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByCertification(String certification)
	// % protected region % [Add any throwables, implementations, or extensions for findByCertification here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCertification here] end
	{
		// % protected region % [Add any additional logic for findByCertification before the main body here] off begin
		// % protected region % [Add any additional logic for findByCertification before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByCertification(certification));

		// % protected region % [Add any additional logic for findByCertification before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCertification before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Ext No.
	 *
	 * @param extNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Ext No
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByExtNo(String extNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByExtNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExtNo here] end
	{
		// % protected region % [Add any additional logic for findByExtNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByExtNo before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByExtNo(extNo));

		// % protected region % [Add any additional logic for findByExtNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExtNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Marital Status.
	 *
	 * @param maritalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Marital Status
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByMaritalStatus(String maritalStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByMaritalStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMaritalStatus here] end
	{
		// % protected region % [Add any additional logic for findByMaritalStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByMaritalStatus before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByMaritalStatus(maritalStatus));

		// % protected region % [Add any additional logic for findByMaritalStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMaritalStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute email
	 */
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findByEmail(String email)
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEmail here] end
	{
		// % protected region % [Add any additional logic for findByEmail before the main body here] off begin
		// % protected region % [Add any additional logic for findByEmail before the main body here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findByEmail(email));

		// % protected region % [Add any additional logic for findByEmail before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEmail before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<StaffEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<StaffEntity> entity = repository.findById(id);

		entity.ifPresent(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<StaffEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StaffEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<StaffEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('StaffEntity', 'create')")
	public StaffEntity create(StaffEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		StaffEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('StaffEntity', 'create')")
	public StaffEntity create(StaffEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		StaffEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		StaffEntity newEntity;

		try {
			newEntity = this.save(entityToCreate);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		// % protected region % [Add any additional logic for create before returning the entity here] off begin
		// % protected region % [Add any additional logic for create before returning the entity here] end

		return newEntity;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('StaffEntity', 'create')")
	public List<StaffEntity> createAll(Iterable<StaffEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<StaffEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<StaffEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('StaffEntity', 'update')")
	public StaffEntity update(StaffEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		StaffEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('StaffEntity', 'update')")
	public StaffEntity update(StaffEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		StaffEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		StaffEntity newEntity;

		try {
			newEntity = this.save(entityToUpdate);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		// % protected region % [Add any additional logic for update before returning the entity here] off begin
		// % protected region % [Add any additional logic for update before returning the entity here] end

		return newEntity;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('StaffEntity', 'update')")
	public List<StaffEntity> updateAll(Iterable<StaffEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<StaffEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<StaffEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'create') or hasPermission('StaffEntity', 'update')")
	public StaffEntity save(StaffEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for save here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for save here] end
	{
		// % protected region % [Add any additional logic for save before the main logic here] off begin
		// % protected region % [Add any additional logic for save before the main logic here] end

		try {
			validateEntity(entity);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		// % protected region % [Add any additional logic for save before saving the entity here] off begin
		// % protected region % [Add any additional logic for save before saving the entity here] end

		StaffEntity newEntity = repository.save(entity);

		generateSignedFileUrls(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'create') or hasPermission('StaffEntity', 'update')")
	public List<StaffEntity> saveAll(Iterable<StaffEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<StaffEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'delete')")
	public void deleteAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllByIds here] end
	{
		// % protected region % [Add any additional logic for deleteAll before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteAll before the main logic here] end

		repository.deleteAllByIdIn(ids);
	}

	/**
	 * Delete all entities that do not have an id in the list of ids provided, if no ids provided, delete all.
	 *
	 * @param ids the IDs of the entities to exclude from deletion
	 */
	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'delete')")
	public void deleteAllExcludingIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllExcludingIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteAllExcludingIds here] end
	{
		// % protected region % [Add any additional logic for deleteAllExcludingIds before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteAllExcludingIds before the main logic here] end

		if (!ids.iterator().hasNext()) {
			repository.deleteAll();
		} else {
			repository.deleteAllByIdNotIn(ids);
		}
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public List<StaffEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public List<StaffEntity> findAllExcludingIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllExcludingIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllExcludingIds here] end
	{
		if (!ids.iterator().hasNext()) {
			return Lists.newArrayList(repository.findAll());
		} else {
			return Lists.newArrayList(repository.findAllByIdNotIn(ids));
		}
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<StaffEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(StaffEntity.class);

		// % protected region % [Add any additional processing before converting to a list of StaffEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of StaffEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<StaffEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of StaffEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of StaffEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(StaffEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of StaffEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of StaffEntityAudits
	 */
	private List<StaffEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<StaffEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param staff staff to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private StaffEntity updateAuditData(StaffEntity staff)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{

		staff.setStaffPicture(new HashSet<>(staff.getStaffPicture()));

		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return staff;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private StaffEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		StaffEntity entityAtRevision = updateAuditData((StaffEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new StaffEntityAudit(
				entityAtRevision,
				revision.getModifiedAt(),
				auditType,

				// We don't care about what the UUID is if it is the system.
				(isSystem) ? UUID.randomUUID() : revision.getAuthor().getId(),

				// % protected region % [Customise our revision author name here] off begin
				(isSystem) ? "System" : revision.getAuthor().getName(),
				""
				// % protected region % [Customise our revision author name here] end
		);
	}

	/**
	 * Generate signed URL for all files so that the user can download them.
	 */
	private void generateSignedFileUrls(StaffEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for generateSignedFileUrls here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for generateSignedFileUrls here] end
	{
		Set<FileEntity> staffPicture = entity.getStaffPicture();

		for (FileEntity individualStaffPicture : staffPicture) {
			String url = fileService.generateUrl(individualStaffPicture.getId());
			individualStaffPicture.setUrl(url);
		}
	}

	/**
	 * Create the predicate for the querydsl based on one condition
	 *
	 * @param condition Single condition used in the query
	 * @return querydsl predicate
	 */
	protected Predicate processCondition(Where condition)
	// % protected region % [Add any throwables, implementations, or extensions for processCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for processCondition here] end
	{
		// % protected region % [Add any additional logic for processCondition before the main logic here] off begin
		// % protected region % [Add any additional logic for processCondition before the main logic here] end

		Predicate predicate = null;

		QStaffEntity entity = QStaffEntity.staffEntity;

		switch (condition.getPath()) {
			case "created":
				// % protected region % [Add any additional logic before the query parameters of created here] off begin
				// % protected region % [Add any additional logic before the query parameters of created here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.created, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of created here] off begin
				// % protected region % [Add any additional logic after the query parameters of created here] end

				break;
			case "createdBy":
				// % protected region % [Add any additional logic before the query parameters of createdBy here] off begin
				// % protected region % [Add any additional logic before the query parameters of createdBy here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.createdBy, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of createdBy here] off begin
				// % protected region % [Add any additional logic after the query parameters of createdBy here] end

				break;
			case "modified":
				// % protected region % [Add any additional logic before the query parameters of modified here] off begin
				// % protected region % [Add any additional logic before the query parameters of modified here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.modified, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of modified here] off begin
				// % protected region % [Add any additional logic after the query parameters of modified here] end

				break;
			case "modifiedBy":
				// % protected region % [Add any additional logic before the query parameters of modifiedBy here] off begin
				// % protected region % [Add any additional logic before the query parameters of modifiedBy here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.modifiedBy, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of modifiedBy here] off begin
				// % protected region % [Add any additional logic after the query parameters of modifiedBy here] end

				break;
			case "administratorId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Administrator here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Administrator here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.administrator.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Administrator here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Administrator here] end

				break;
			case "bpjsDoctorMappingId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to BPJS Doctor Mapping here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to BPJS Doctor Mapping here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsDoctorMapping.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to BPJS Doctor Mapping here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to BPJS Doctor Mapping here] end

				break;
			case "pcareDokterId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to PCare Dokter here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to PCare Dokter here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pcareDokter.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to PCare Dokter here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to PCare Dokter here] end

				break;
			case "serviceId":
				// % protected region % [Add any additional logic before the query parameters of relation from Default Medical Staff to Service here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Default Medical Staff to Service here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.service.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Default Medical Staff to Service here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Default Medical Staff to Service here] end

				break;
			case "administrationUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Administration User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Administration User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.administrationUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Administration User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Administration User to Staff here] end

				break;
			case "cashierUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Cashier User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Cashier User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.cashierUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Cashier User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Cashier User to Staff here] end

				break;
			case "claimUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Claim User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Claim User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.claimUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Claim User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Claim User to Staff here] end

				break;
			case "diagnosticSupportUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Diagnostic Support User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Diagnostic Support User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnosticSupportUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Diagnostic Support User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Diagnostic Support User to Staff here] end

				break;
			case "doctorUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Doctor User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Doctor User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.doctorUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Doctor User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Doctor User to Staff here] end

				break;
			case "facilityUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Facility User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Facility User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.facilityUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Facility User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Facility User to Staff here] end

				break;
			case "managementUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Management User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Management User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.managementUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Management User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Management User to Staff here] end

				break;
			case "medicalRecordUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Record user to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Record user to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalRecordUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Record user to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Record user to Staff here] end

				break;
			case "medicalTranscriberUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Transcriber User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Transcriber User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalTranscriberUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Transcriber User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Transcriber User to Staff here] end

				break;
			case "nurseUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Nurse User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Nurse User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nurseUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Nurse User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Nurse User to Staff here] end

				break;
			case "pharmacyUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Pharmacy User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Pharmacy User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pharmacyUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Pharmacy User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Pharmacy User to Staff here] end

				break;
			case "purchasingUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Purchasing User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchasing User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchasingUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchasing User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchasing User to Staff here] end

				break;
			case "registrationUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registrationUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration User to Staff here] end

				break;
			case "systemAdminUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from System Admin User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from System Admin User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.systemAdminUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from System Admin User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from System Admin User to Staff here] end

				break;
			case "warehouseUserId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse User to Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse User to Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouseUser.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse User to Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse User to Staff here] end

				break;
			case "accompanyingConsentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Accompanying Staff to Accompanying Consents here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Accompanying Staff to Accompanying Consents here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.accompanyingConsents.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Accompanying Staff to Accompanying Consents here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Accompanying Staff to Accompanying Consents here] end

				break;
			case "amendmentDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Amendment Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Amendment Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.amendmentDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Amendment Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Amendment Details here] end

				break;
			case "anesthesiaMedicalTranscriberId":
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesia Medical Transcriber to Anesthesia Medical Transcriber here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesia Medical Transcriber to Anesthesia Medical Transcriber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.anesthesiaMedicalTranscriber.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesia Medical Transcriber to Anesthesia Medical Transcriber here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesia Medical Transcriber to Anesthesia Medical Transcriber here] end

				break;
			case "anesthesiologistId":
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesiologist to Anesthesiologist here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesiologist to Anesthesiologist here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.anesthesiologist.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesiologist to Anesthesiologist here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesiologist to Anesthesiologist here] end

				break;
			case "anesthesiologyNurseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesiology Nurse to Anesthesiology Nurse here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Anesthesiology Nurse to Anesthesiology Nurse here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.anesthesiologyNurse.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesiology Nurse to Anesthesiology Nurse here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Anesthesiology Nurse to Anesthesiology Nurse here] end

				break;
			case "cashierStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Cashier Staff to Cashier Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Cashier Staff to Cashier Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.cashierStaff.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Cashier Staff to Cashier Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Cashier Staff to Cashier Staff here] end

				break;
			case "coTreatingDoctorsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Co Treating Doctors here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Co Treating Doctors here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.coTreatingDoctors.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Co Treating Doctors here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Co Treating Doctors here] end

				break;
			case "dailyCareCPPTsCreatedByStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Created By Staff to Daily Care CPPTs Created By Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Created By Staff to Daily Care CPPTs Created By Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dailyCareCPPTsCreatedByStaff.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Created By Staff to Daily Care CPPTs Created By Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Created By Staff to Daily Care CPPTs Created By Staff here] end

				break;
			case "dailyCareCPPTsDoctorInChargeId":
				// % protected region % [Add any additional logic before the query parameters of relation from Doctor in Charge to Daily Care CPPTs Doctor in Charge here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Doctor in Charge to Daily Care CPPTs Doctor in Charge here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dailyCareCPPTsDoctorInCharge.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Doctor in Charge to Daily Care CPPTs Doctor in Charge here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Doctor in Charge to Daily Care CPPTs Doctor in Charge here] end

				break;
			case "dailyCareCPPTsMedicalTranscriberId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Transcriber to Daily Care CPPTs Medical Transcriber here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Transcriber to Daily Care CPPTs Medical Transcriber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dailyCareCPPTsMedicalTranscriber.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Transcriber to Daily Care CPPTs Medical Transcriber here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Transcriber to Daily Care CPPTs Medical Transcriber here] end

				break;
			case "deliveryProgressesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Delivery Progresses here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Delivery Progresses here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.deliveryProgresses.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Delivery Progresses here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Delivery Progresses here] end

				break;
			case "diagnosticStaffExaminationSummariesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Diagnostic Staff Examination Summaries here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Diagnostic Staff Examination Summaries here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnosticStaffExaminationSummaries.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Diagnostic Staff Examination Summaries here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Diagnostic Staff Examination Summaries here] end

				break;
			case "dismissalReferringStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Dismissal Referring Staff to Dismissal Referring Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Dismissal Referring Staff to Dismissal Referring Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dismissalReferringStaff.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Dismissal Referring Staff to Dismissal Referring Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Dismissal Referring Staff to Dismissal Referring Staff here] end

				break;
			case "doctorSchedulesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Doctor Schedules here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Doctor Schedules here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.doctorSchedules.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Doctor Schedules here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Doctor Schedules here] end

				break;
			case "doctorOnExaminationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Doctor to Doctor on examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Doctor to Doctor on examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.doctorOnExamination.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Doctor to Doctor on examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Doctor to Doctor on examination here] end

				break;
			case "fluidBalanceDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Fluid Balance Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Fluid Balance Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.fluidBalanceDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Fluid Balance Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Fluid Balance Details here] end

				break;
			case "hemodialysisMonitoringsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Hemodialysis Monitorings here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Hemodialysis Monitorings here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hemodialysisMonitorings.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Hemodialysis Monitorings here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Hemodialysis Monitorings here] end

				break;
			case "hospitalBranchInformationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Hospital Branch Informations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Hospital Branch Informations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hospitalBranchInformations.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Hospital Branch Informations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Hospital Branch Informations here] end

				break;
			case "informingConsentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Informing Staff to Informing Consents here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Informing Staff to Informing Consents here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.informingConsents.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Informing Staff to Informing Consents here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Informing Staff to Informing Consents here] end

				break;
			case "invoicesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Verified By to Invoices here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Verified By to Invoices here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoices.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Verified By to Invoices here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Verified By to Invoices here] end

				break;
			case "mcuPackageItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to MCU Package Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to MCU Package Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.mcuPackageItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to MCU Package Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to MCU Package Items here] end

				break;
			case "medicalCertificateDischargeResumesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Certificate  Discharge Resumes here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Certificate  Discharge Resumes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalCertificateDischargeResumes.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Certificate  Discharge Resumes here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Certificate  Discharge Resumes here] end

				break;
			case "medicalCertificateBirthsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Certificate Births here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Certificate Births here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalCertificateBirths.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Certificate Births here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Certificate Births here] end

				break;
			case "medicalCertificateHospitalizationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Certificate Hospitalizations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Certificate Hospitalizations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalCertificateHospitalizations.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Certificate Hospitalizations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Certificate Hospitalizations here] end

				break;
			case "medicalExaminationRecordDischargeSummarysId":
				// % protected region % [Add any additional logic before the query parameters of relation from Discharging Doctor to Medical Examination Record Discharge Summarys here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Discharging Doctor to Medical Examination Record Discharge Summarys here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecordDischargeSummarys.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Discharging Doctor to Medical Examination Record Discharge Summarys here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Discharging Doctor to Medical Examination Record Discharge Summarys here] end

				break;
			case "medicalRecordTranscriberId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Transcriber to Medical Record Transcriber here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Transcriber to Medical Record Transcriber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalRecordTranscriber.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Transcriber to Medical Record Transcriber here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Transcriber to Medical Record Transcriber here] end

				break;
			case "medicalStaffOfMedicalAttendancesCertificateId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Staff of Medical Attendances certificate here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Staff of Medical Attendances certificate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalStaffOfMedicalAttendancesCertificate.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Staff of Medical Attendances certificate here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Staff of Medical Attendances certificate here] end

				break;
			case "medicalStaffOfMentalHealthsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Staff of Mental Healths here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Staff of Mental Healths here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalStaffOfMentalHealths.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Staff of Mental Healths here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Staff of Mental Healths here] end

				break;
			case "medicalStaffOfPhysicalHealthsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Staff of Physical Healths here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Staff of Physical Healths here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalStaffOfPhysicalHealths.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Staff of Physical Healths here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Staff of Physical Healths here] end

				break;
			case "medicalStaffOfRestrictedWorksCertificateId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Staff of Restricted Works certificate here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Staff of Restricted Works certificate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalStaffOfRestrictedWorksCertificate.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Staff of Restricted Works certificate here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Staff of Restricted Works certificate here] end

				break;
			case "medicalStaffOfSickLeavesCertificateId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Staff of Sick Leaves certificate here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Staff of Sick Leaves certificate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalStaffOfSickLeavesCertificate.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Staff of Sick Leaves certificate here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Staff of Sick Leaves certificate here] end

				break;
			case "medicationAdministeredHisotriesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Medication Administered Hisotries here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Medication Administered Hisotries here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationAdministeredHisotries.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Medication Administered Hisotries here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Medication Administered Hisotries here] end

				break;
			case "medicationHeadersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Requested By to Medication Headers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Requested By to Medication Headers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationHeaders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Requested By to Medication Headers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Requested By to Medication Headers here] end

				break;
			case "midwivesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Midwife to Midwives here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Midwife to Midwives here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.midwives.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Midwife to Midwives here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Midwife to Midwives here] end

				break;
			case "nurseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Nurse to Nurse here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Nurse to Nurse here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nurse.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Nurse to Nurse here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Nurse to Nurse here] end

				break;
			case "nursingDetailSurgicalNursingId":
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Detail Surgical Nursings to Nursing Detail Surgical Nursing here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Detail Surgical Nursings to Nursing Detail Surgical Nursing here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nursingDetailSurgicalNursing.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Detail Surgical Nursings to Nursing Detail Surgical Nursing here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Detail Surgical Nursings to Nursing Detail Surgical Nursing here] end

				break;
			case "nursingDetailsAnesthesiaNursingId":
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Details Anesthesia Nursings to Nursing Details Anesthesia Nursing here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Nursing Details Anesthesia Nursings to Nursing Details Anesthesia Nursing here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.nursingDetailsAnesthesiaNursing.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Details Anesthesia Nursings to Nursing Details Anesthesia Nursing here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Nursing Details Anesthesia Nursings to Nursing Details Anesthesia Nursing here] end

				break;
			case "patientConsentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Patient Consents here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Patient Consents here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientConsents.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Patient Consents here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Patient Consents here] end

				break;
			case "patientVitalInformationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Patient Vital Informations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Patient Vital Informations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientVitalInformations.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Patient Vital Informations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Patient Vital Informations here] end

				break;
			case "pediatricianInChargeId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Pediatrician In Charge here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Pediatrician In Charge here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pediatricianInCharge.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Pediatrician In Charge here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Pediatrician In Charge here] end

				break;
			case "prescriptionHeadersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Requested By to Prescription Headers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Requested By to Prescription Headers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescriptionHeaders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Requested By to Prescription Headers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Requested By to Prescription Headers here] end

				break;
			case "processWorkflowLogsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Process Workflow Logs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Process Workflow Logs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.processWorkflowLogs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Process Workflow Logs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Process Workflow Logs here] end

				break;
			case "registrationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Registrations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Registrations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registrations.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Registrations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Registrations here] end

				break;
			case "requestedById":
				// % protected region % [Add any additional logic before the query parameters of relation from Requested By to Requested By here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Requested By to Requested By here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.requestedBy.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Requested By to Requested By here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Requested By to Requested By here] end

				break;
			case "roomTransfersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Transferring Staff to Room Transfers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Transferring Staff to Room Transfers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.roomTransfers.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Transferring Staff to Room Transfers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Transferring Staff to Room Transfers here] end

				break;
			case "sampleCollectionStaffsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Collection Staff to Sample Collection Staffs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Collection Staff to Sample Collection Staffs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sampleCollectionStaffs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Sample Collection Staff to Sample Collection Staffs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Sample Collection Staff to Sample Collection Staffs here] end

				break;
			case "sampleDeliveryStaffsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Delivery Staff to Sample Delivery Staffs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Delivery Staff to Sample Delivery Staffs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sampleDeliveryStaffs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Sample Delivery Staff to Sample Delivery Staffs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Sample Delivery Staff to Sample Delivery Staffs here] end

				break;
			case "sampleProcessingStaffsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Processing Staff to Sample Processing Staffs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Sample Processing Staff to Sample Processing Staffs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sampleProcessingStaffs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Sample Processing Staff to Sample Processing Staffs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Sample Processing Staff to Sample Processing Staffs here] end

				break;
			case "surgeonId":
				// % protected region % [Add any additional logic before the query parameters of relation from Surgeon to Surgeon here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Surgeon to Surgeon here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.surgeon.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Surgeon to Surgeon here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Surgeon to Surgeon here] end

				break;
			case "surgicalMedicalTranscriberId":
				// % protected region % [Add any additional logic before the query parameters of relation from Surgical Medical Transcriber to Surgical Medical Transcriber here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Surgical Medical Transcriber to Surgical Medical Transcriber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.surgicalMedicalTranscriber.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Surgical Medical Transcriber to Surgical Medical Transcriber here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Surgical Medical Transcriber to Surgical Medical Transcriber here] end

				break;
			case "surgicalNurseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Surgical Nurse to Surgical Nurse here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Surgical Nurse to Surgical Nurse here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.surgicalNurse.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Surgical Nurse to Surgical Nurse here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Surgical Nurse to Surgical Nurse here] end

				break;
			case "transferOrderStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Transfer Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transferOrderStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Transfer Order Stock Details here] end

				break;
			case "vaccinationOrdersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Vaccination Orders here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Vaccination Orders here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.vaccinationOrders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Vaccination Orders here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Vaccination Orders here] end

				break;
			case "servicesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Assigned Medical Staff to Services here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Assigned Medical Staff to Services here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.services.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Assigned Medical Staff to Services here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Assigned Medical Staff to Services here] end

				break;
			case "staffNumber":
				// % protected region % [Add any additional logic before the query parameters of staffNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of staffNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staffNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of staffNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of staffNumber here] end

				break;
			case "firstName":
				// % protected region % [Add any additional logic before the query parameters of firstName here] off begin
				// % protected region % [Add any additional logic before the query parameters of firstName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.firstName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of firstName here] off begin
				// % protected region % [Add any additional logic after the query parameters of firstName here] end

				break;
			case "lastName":
				// % protected region % [Add any additional logic before the query parameters of lastName here] off begin
				// % protected region % [Add any additional logic before the query parameters of lastName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.lastName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of lastName here] off begin
				// % protected region % [Add any additional logic after the query parameters of lastName here] end

				break;
			case "staffType":
				// % protected region % [Add any additional logic before the query parameters of staffType here] off begin
				// % protected region % [Add any additional logic before the query parameters of staffType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staffType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of staffType here] off begin
				// % protected region % [Add any additional logic after the query parameters of staffType here] end

				break;
			case "specialization":
				// % protected region % [Add any additional logic before the query parameters of specialization here] off begin
				// % protected region % [Add any additional logic before the query parameters of specialization here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.specialization, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of specialization here] off begin
				// % protected region % [Add any additional logic after the query parameters of specialization here] end

				break;
			case "education":
				// % protected region % [Add any additional logic before the query parameters of education here] off begin
				// % protected region % [Add any additional logic before the query parameters of education here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.education, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of education here] off begin
				// % protected region % [Add any additional logic after the query parameters of education here] end

				break;
			case "licenseNo":
				// % protected region % [Add any additional logic before the query parameters of licenseNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of licenseNo here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.licenseNo, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of licenseNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of licenseNo here] end

				break;
			case "letterOfReg":
				// % protected region % [Add any additional logic before the query parameters of letterOfReg here] off begin
				// % protected region % [Add any additional logic before the query parameters of letterOfReg here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.letterOfReg, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of letterOfReg here] off begin
				// % protected region % [Add any additional logic after the query parameters of letterOfReg here] end

				break;
			case "gender":
				// % protected region % [Add any additional logic before the query parameters of gender here] off begin
				// % protected region % [Add any additional logic before the query parameters of gender here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.gender, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of gender here] off begin
				// % protected region % [Add any additional logic after the query parameters of gender here] end

				break;
			case "employeeID":
				// % protected region % [Add any additional logic before the query parameters of employeeID here] off begin
				// % protected region % [Add any additional logic before the query parameters of employeeID here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.employeeID, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of employeeID here] off begin
				// % protected region % [Add any additional logic after the query parameters of employeeID here] end

				break;
			case "defaultServiceNumber":
				// % protected region % [Add any additional logic before the query parameters of defaultServiceNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of defaultServiceNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.defaultServiceNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of defaultServiceNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of defaultServiceNumber here] end

				break;
			// % protected region % [Add any additional cases for the custom query parameters here] off begin
			// % protected region % [Add any additional cases for the custom query parameters here] end
		}

		// % protected region % [Add any additional logic for processCondition after the main logic here] off begin
		// % protected region % [Add any additional logic for processCondition after the main logic here] end

		return predicate;
	}

	/**
	 * Create the predicate for the querydsl based on one single List of Where
	 * The List are connect with 'and' statement
	 *
	 * @param conditions Single list of where statement. The conditions are connected with "or"
	 * @return querydsl predicate
	 */
	protected Predicate processConditionList(List<Where> conditions)
	// % protected region % [Add any throwables, implementations, or extensions for processConditionList here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for processConditionList here] end
	{
		List<Predicate> predicates = conditions.stream()
				.map(this::processCondition)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

		return ExpressionUtils.anyOf(predicates);
	}

	/**
	 * Transfer a list of conditions to one querydsl predicate
	 *
	 * @param conditions A list of conditions
	 * @return a single query dsl predicate
	 */
	@Override
	protected Predicate getQueryConditions(List<List<Where>> conditions)
	// % protected region % [Add any throwables, implementations, or extensions for getQueryConditions here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getQueryConditions here] end
	{
		// % protected region % [Add any additional logic for getQueryConditions before the main logic here] off begin
		// % protected region % [Add any additional logic for getQueryConditions before the main logic here] end

		List<Predicate> predicates = conditions.stream()
				.map(this::processConditionList)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic for getQueryConditions after the main logic here] off begin
		// % protected region % [Add any additional logic for getQueryConditions after the main logic here] end
		return ExpressionUtils.allOf(predicates);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StaffEntity updateOldData(StaffEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public StaffEntity updateOldData(StaffEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		StaffEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInStaffEntity);


			// % protected region % [Add any additional logic for update before uploading files here] off begin
			// % protected region % [Add any additional logic for update before uploading files here] end

			Set<FileEntity> staffPictureFiles = entity.getStaffPicture();

			// Delete any file that requires deletion.
			Set<FileEntity> staffPicturefilesToDelete = staffPictureFiles.stream()
					.filter(fileToDelete -> fileToDelete.getId() != null && fileToDelete.getDoDelete()) // Only delete valid existing files
					.filter(entityToUpdate::containsStaffPicture) // Make sure that the files exist in the old entity before deleting them
					.collect(Collectors.toSet());

			staffPicturefilesToDelete.stream()
					.peek(entity::removeStaffPicture) // Remove the deleted files from the entity itself.
					.map(FileEntity::getId)
					.forEach(fileService::delete);

			// Upload and merge the rest of the files together with the current files
			Set<FileEntity> staffPictureFilesToUpload = staffPictureFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null) // Only upload those files that we have not uploaded yet
					.collect(Collectors.toSet());

			fileService.uploadMultiple(staffPictureFilesToUpload).forEach(entity::addStaffPicture);
		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			Set<FileEntity> staffPictureFiles = entityToUpdate.getStaffPicture();
			// Merge the rest of the files together
			Set<FileEntity> staffPictureFilesToUpload = staffPictureFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null)
					.collect(Collectors.toSet());

			entityToUpdate.clearAllStaffPicture();
			fileService.uploadMultiple(staffPictureFilesToUpload).forEach(entity::addStaffPicture);

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to One reference
		if (entity.getAdministrationUser() == null && entity.getAdministrationUserId() == null) {
			entityToUpdate.unsetAdministrationUser();
		} else if (entity.getAdministrationUserId() != null && entity.getAdministrationUser() == null) {
			Optional<AdministrationUserEntity> administrationUserEntity = this.administrationUserRepository.findById(entity.getAdministrationUserId());
			entityToUpdate.setAdministrationUser(administrationUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getAdministrationUser() != null) {
			entityToUpdate.setAdministrationUser(entity.getAdministrationUser(), false);
			if (entityToUpdate.getAdministrationUserId() != null) {
				this.administrationUserRepository.save(entityToUpdate.getAdministrationUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAdministrationUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getCashierUser() == null && entity.getCashierUserId() == null) {
			entityToUpdate.unsetCashierUser();
		} else if (entity.getCashierUserId() != null && entity.getCashierUser() == null) {
			Optional<CashierUserEntity> cashierUserEntity = this.cashierUserRepository.findById(entity.getCashierUserId());
			entityToUpdate.setCashierUser(cashierUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getCashierUser() != null) {
			entityToUpdate.setCashierUser(entity.getCashierUser(), false);
			if (entityToUpdate.getCashierUserId() != null) {
				this.cashierUserRepository.save(entityToUpdate.getCashierUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getCashierUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getClaimUser() == null && entity.getClaimUserId() == null) {
			entityToUpdate.unsetClaimUser();
		} else if (entity.getClaimUserId() != null && entity.getClaimUser() == null) {
			Optional<ClaimUserEntity> claimUserEntity = this.claimUserRepository.findById(entity.getClaimUserId());
			entityToUpdate.setClaimUser(claimUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getClaimUser() != null) {
			entityToUpdate.setClaimUser(entity.getClaimUser(), false);
			if (entityToUpdate.getClaimUserId() != null) {
				this.claimUserRepository.save(entityToUpdate.getClaimUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getClaimUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getDiagnosticSupportUser() == null && entity.getDiagnosticSupportUserId() == null) {
			entityToUpdate.unsetDiagnosticSupportUser();
		} else if (entity.getDiagnosticSupportUserId() != null && entity.getDiagnosticSupportUser() == null) {
			Optional<DiagnosticSupportUserEntity> diagnosticSupportUserEntity = this.diagnosticSupportUserRepository.findById(entity.getDiagnosticSupportUserId());
			entityToUpdate.setDiagnosticSupportUser(diagnosticSupportUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getDiagnosticSupportUser() != null) {
			entityToUpdate.setDiagnosticSupportUser(entity.getDiagnosticSupportUser(), false);
			if (entityToUpdate.getDiagnosticSupportUserId() != null) {
				this.diagnosticSupportUserRepository.save(entityToUpdate.getDiagnosticSupportUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDiagnosticSupportUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getDoctorUser() == null && entity.getDoctorUserId() == null) {
			entityToUpdate.unsetDoctorUser();
		} else if (entity.getDoctorUserId() != null && entity.getDoctorUser() == null) {
			Optional<DoctorUserEntity> doctorUserEntity = this.doctorUserRepository.findById(entity.getDoctorUserId());
			entityToUpdate.setDoctorUser(doctorUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getDoctorUser() != null) {
			entityToUpdate.setDoctorUser(entity.getDoctorUser(), false);
			if (entityToUpdate.getDoctorUserId() != null) {
				this.doctorUserRepository.save(entityToUpdate.getDoctorUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDoctorUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getFacilityUser() == null && entity.getFacilityUserId() == null) {
			entityToUpdate.unsetFacilityUser();
		} else if (entity.getFacilityUserId() != null && entity.getFacilityUser() == null) {
			Optional<FacilityUserEntity> facilityUserEntity = this.facilityUserRepository.findById(entity.getFacilityUserId());
			entityToUpdate.setFacilityUser(facilityUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getFacilityUser() != null) {
			entityToUpdate.setFacilityUser(entity.getFacilityUser(), false);
			if (entityToUpdate.getFacilityUserId() != null) {
				this.facilityUserRepository.save(entityToUpdate.getFacilityUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getFacilityUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getManagementUser() == null && entity.getManagementUserId() == null) {
			entityToUpdate.unsetManagementUser();
		} else if (entity.getManagementUserId() != null && entity.getManagementUser() == null) {
			Optional<ManagementUserEntity> managementUserEntity = this.managementUserRepository.findById(entity.getManagementUserId());
			entityToUpdate.setManagementUser(managementUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getManagementUser() != null) {
			entityToUpdate.setManagementUser(entity.getManagementUser(), false);
			if (entityToUpdate.getManagementUserId() != null) {
				this.managementUserRepository.save(entityToUpdate.getManagementUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getManagementUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getMedicalRecordUser() == null && entity.getMedicalRecordUserId() == null) {
			entityToUpdate.unsetMedicalRecordUser();
		} else if (entity.getMedicalRecordUserId() != null && entity.getMedicalRecordUser() == null) {
			Optional<MedicalRecordUserEntity> medicalRecordUserEntity = this.medicalRecordUserRepository.findById(entity.getMedicalRecordUserId());
			entityToUpdate.setMedicalRecordUser(medicalRecordUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalRecordUser() != null) {
			entityToUpdate.setMedicalRecordUser(entity.getMedicalRecordUser(), false);
			if (entityToUpdate.getMedicalRecordUserId() != null) {
				this.medicalRecordUserRepository.save(entityToUpdate.getMedicalRecordUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalRecordUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getMedicalTranscriberUser() == null && entity.getMedicalTranscriberUserId() == null) {
			entityToUpdate.unsetMedicalTranscriberUser();
		} else if (entity.getMedicalTranscriberUserId() != null && entity.getMedicalTranscriberUser() == null) {
			Optional<MedicalTranscriberUserEntity> medicalTranscriberUserEntity = this.medicalTranscriberUserRepository.findById(entity.getMedicalTranscriberUserId());
			entityToUpdate.setMedicalTranscriberUser(medicalTranscriberUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalTranscriberUser() != null) {
			entityToUpdate.setMedicalTranscriberUser(entity.getMedicalTranscriberUser(), false);
			if (entityToUpdate.getMedicalTranscriberUserId() != null) {
				this.medicalTranscriberUserRepository.save(entityToUpdate.getMedicalTranscriberUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalTranscriberUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getNurseUser() == null && entity.getNurseUserId() == null) {
			entityToUpdate.unsetNurseUser();
		} else if (entity.getNurseUserId() != null && entity.getNurseUser() == null) {
			Optional<NurseUserEntity> nurseUserEntity = this.nurseUserRepository.findById(entity.getNurseUserId());
			entityToUpdate.setNurseUser(nurseUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getNurseUser() != null) {
			entityToUpdate.setNurseUser(entity.getNurseUser(), false);
			if (entityToUpdate.getNurseUserId() != null) {
				this.nurseUserRepository.save(entityToUpdate.getNurseUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getNurseUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getPharmacyUser() == null && entity.getPharmacyUserId() == null) {
			entityToUpdate.unsetPharmacyUser();
		} else if (entity.getPharmacyUserId() != null && entity.getPharmacyUser() == null) {
			Optional<PharmacyUserEntity> pharmacyUserEntity = this.pharmacyUserRepository.findById(entity.getPharmacyUserId());
			entityToUpdate.setPharmacyUser(pharmacyUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getPharmacyUser() != null) {
			entityToUpdate.setPharmacyUser(entity.getPharmacyUser(), false);
			if (entityToUpdate.getPharmacyUserId() != null) {
				this.pharmacyUserRepository.save(entityToUpdate.getPharmacyUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPharmacyUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getPurchasingUser() == null && entity.getPurchasingUserId() == null) {
			entityToUpdate.unsetPurchasingUser();
		} else if (entity.getPurchasingUserId() != null && entity.getPurchasingUser() == null) {
			Optional<PurchasingUserEntity> purchasingUserEntity = this.purchasingUserRepository.findById(entity.getPurchasingUserId());
			entityToUpdate.setPurchasingUser(purchasingUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getPurchasingUser() != null) {
			entityToUpdate.setPurchasingUser(entity.getPurchasingUser(), false);
			if (entityToUpdate.getPurchasingUserId() != null) {
				this.purchasingUserRepository.save(entityToUpdate.getPurchasingUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPurchasingUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getRegistrationUser() == null && entity.getRegistrationUserId() == null) {
			entityToUpdate.unsetRegistrationUser();
		} else if (entity.getRegistrationUserId() != null && entity.getRegistrationUser() == null) {
			Optional<RegistrationUserEntity> registrationUserEntity = this.registrationUserRepository.findById(entity.getRegistrationUserId());
			entityToUpdate.setRegistrationUser(registrationUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getRegistrationUser() != null) {
			entityToUpdate.setRegistrationUser(entity.getRegistrationUser(), false);
			if (entityToUpdate.getRegistrationUserId() != null) {
				this.registrationUserRepository.save(entityToUpdate.getRegistrationUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getRegistrationUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getSystemAdminUser() == null && entity.getSystemAdminUserId() == null) {
			entityToUpdate.unsetSystemAdminUser();
		} else if (entity.getSystemAdminUserId() != null && entity.getSystemAdminUser() == null) {
			Optional<SystemAdminUserEntity> systemAdminUserEntity = this.systemAdminUserRepository.findById(entity.getSystemAdminUserId());
			entityToUpdate.setSystemAdminUser(systemAdminUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getSystemAdminUser() != null) {
			entityToUpdate.setSystemAdminUser(entity.getSystemAdminUser(), false);
			if (entityToUpdate.getSystemAdminUserId() != null) {
				this.systemAdminUserRepository.save(entityToUpdate.getSystemAdminUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSystemAdminUser().unsetStaff();
			}
		}

		// Incoming One to One reference
		if (entity.getWarehouseUser() == null && entity.getWarehouseUserId() == null) {
			entityToUpdate.unsetWarehouseUser();
		} else if (entity.getWarehouseUserId() != null && entity.getWarehouseUser() == null) {
			Optional<WarehouseUserEntity> warehouseUserEntity = this.warehouseUserRepository.findById(entity.getWarehouseUserId());
			entityToUpdate.setWarehouseUser(warehouseUserEntity.orElseThrow());
		}
		if (persistRelations && entity.getWarehouseUser() != null) {
			entityToUpdate.setWarehouseUser(entity.getWarehouseUser(), false);
			if (entityToUpdate.getWarehouseUserId() != null) {
				this.warehouseUserRepository.save(entityToUpdate.getWarehouseUser());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getWarehouseUser().unsetStaff();
			}
		}

		// Outgoing one to one reference
		if (entity.getAdministrator() == null && entity.getAdministratorId() == null) {
			entityToUpdate.unsetAdministrator();
		} else if (entity.getAdministratorId() != null && entity.getAdministrator() == null) {
			Optional<AdministratorEntity> administratorEntity = this.administratorRepository.findById(entity.getAdministratorId());
			entityToUpdate.setAdministrator(administratorEntity.orElseThrow());
		}
		if (persistRelations && entity.getAdministrator() != null) {
			entityToUpdate.setAdministrator(entity.getAdministrator(), false);
			if (entityToUpdate.getAdministratorId() != null) {
				this.administratorRepository.save(entityToUpdate.getAdministrator());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAdministrator().unsetStaff();
			}
		}

		// Outgoing one to one reference
		if (entity.getBpjsDoctorMapping() == null && entity.getBpjsDoctorMappingId() == null) {
			entityToUpdate.unsetBpjsDoctorMapping();
		} else if (entity.getBpjsDoctorMappingId() != null && entity.getBpjsDoctorMapping() == null) {
			Optional<BpjsDoctorMappingEntity> bpjsDoctorMappingEntity = this.bpjsDoctorMappingRepository.findById(entity.getBpjsDoctorMappingId());
			entityToUpdate.setBpjsDoctorMapping(bpjsDoctorMappingEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsDoctorMapping() != null) {
			entityToUpdate.setBpjsDoctorMapping(entity.getBpjsDoctorMapping(), false);
			if (entityToUpdate.getBpjsDoctorMappingId() != null) {
				this.bpjsDoctorMappingRepository.save(entityToUpdate.getBpjsDoctorMapping());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsDoctorMapping().unsetStaff();
			}
		}

		// Outgoing one to one reference
		if (entity.getPcareDokter() == null && entity.getPcareDokterId() == null) {
			entityToUpdate.unsetPcareDokter();
		} else if (entity.getPcareDokterId() != null && entity.getPcareDokter() == null) {
			Optional<PcareDokterEntity> pcareDokterEntity = this.pcareDokterRepository.findById(entity.getPcareDokterId());
			entityToUpdate.setPcareDokter(pcareDokterEntity.orElseThrow());
		}
		if (persistRelations && entity.getPcareDokter() != null) {
			entityToUpdate.setPcareDokter(entity.getPcareDokter(), false);
			if (entityToUpdate.getPcareDokterId() != null) {
				this.pcareDokterRepository.save(entityToUpdate.getPcareDokter());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPcareDokter().unsetStaff();
			}
		}

		// Outgoing one to one reference
		if (entity.getService() == null && entity.getServiceId() == null) {
			entityToUpdate.unsetService();
		} else if (entity.getServiceId() != null && entity.getService() == null) {
			Optional<ServiceEntity> serviceEntity = this.serviceRepository.findById(entity.getServiceId());
			entityToUpdate.setService(serviceEntity.orElseThrow());
		}
		if (persistRelations && entity.getService() != null) {
			entityToUpdate.setService(entity.getService(), false);
			if (entityToUpdate.getServiceId() != null) {
				this.serviceRepository.save(entityToUpdate.getService());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getService().unsetDefaultMedicalStaff();
			}
		}

		// Outgoing one to many reference
		if (entity.getAccompanyingConsentsIds().isEmpty() && entity.getAccompanyingConsents().isEmpty()) {
			entityToUpdate.setAccompanyingConsents(new HashSet<>());
		} else if (!entity.getAccompanyingConsentsIds().isEmpty() && entity.getAccompanyingConsents().isEmpty()) {
			Iterable<InformedConsentEntity> accompanyingConsentsEntities =
					this.informedConsentRepository.findAllById(entity.getAccompanyingConsentsIds());
			entityToUpdate.setAccompanyingConsents(Sets.newHashSet(accompanyingConsentsEntities));
		}
		if (persistRelations && !entity.getAccompanyingConsents().isEmpty()) {
			Set<InformedConsentEntity> updatedEntities = new HashSet<>();
			entity.getAccompanyingConsents().forEach(model -> {
				if (model.getId() != null) {
					model = this.informedConsentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setAccompanyingConsents(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getAmendmentDetailsIds().isEmpty() && entity.getAmendmentDetails().isEmpty()) {
			entityToUpdate.setAmendmentDetails(new HashSet<>());
		} else if (!entity.getAmendmentDetailsIds().isEmpty() && entity.getAmendmentDetails().isEmpty()) {
			Iterable<AmendmentDetailEntity> amendmentDetailsEntities =
					this.amendmentDetailRepository.findAllById(entity.getAmendmentDetailsIds());
			entityToUpdate.setAmendmentDetails(Sets.newHashSet(amendmentDetailsEntities));
		}
		if (persistRelations && !entity.getAmendmentDetails().isEmpty()) {
			Set<AmendmentDetailEntity> updatedEntities = new HashSet<>();
			entity.getAmendmentDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.amendmentDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setAmendmentDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getAnesthesiaMedicalTranscriberIds().isEmpty() && entity.getAnesthesiaMedicalTranscriber().isEmpty()) {
			entityToUpdate.setAnesthesiaMedicalTranscriber(new HashSet<>());
		} else if (!entity.getAnesthesiaMedicalTranscriberIds().isEmpty() && entity.getAnesthesiaMedicalTranscriber().isEmpty()) {
			Iterable<PreoperativeRecordsEntity> anesthesiaMedicalTranscriberEntities =
					this.preoperativeRecordsRepository.findAllById(entity.getAnesthesiaMedicalTranscriberIds());
			entityToUpdate.setAnesthesiaMedicalTranscriber(Sets.newHashSet(anesthesiaMedicalTranscriberEntities));
		}
		if (persistRelations && !entity.getAnesthesiaMedicalTranscriber().isEmpty()) {
			Set<PreoperativeRecordsEntity> updatedEntities = new HashSet<>();
			entity.getAnesthesiaMedicalTranscriber().forEach(model -> {
				if (model.getId() != null) {
					model = this.preoperativeRecordsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setAnesthesiaMedicalTranscriber(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getAnesthesiologistIds().isEmpty() && entity.getAnesthesiologist().isEmpty()) {
			entityToUpdate.setAnesthesiologist(new HashSet<>());
		} else if (!entity.getAnesthesiologistIds().isEmpty() && entity.getAnesthesiologist().isEmpty()) {
			Iterable<PreoperativeRecordsEntity> anesthesiologistEntities =
					this.preoperativeRecordsRepository.findAllById(entity.getAnesthesiologistIds());
			entityToUpdate.setAnesthesiologist(Sets.newHashSet(anesthesiologistEntities));
		}
		if (persistRelations && !entity.getAnesthesiologist().isEmpty()) {
			Set<PreoperativeRecordsEntity> updatedEntities = new HashSet<>();
			entity.getAnesthesiologist().forEach(model -> {
				if (model.getId() != null) {
					model = this.preoperativeRecordsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setAnesthesiologist(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getAnesthesiologyNurseIds().isEmpty() && entity.getAnesthesiologyNurse().isEmpty()) {
			entityToUpdate.setAnesthesiologyNurse(new HashSet<>());
		} else if (!entity.getAnesthesiologyNurseIds().isEmpty() && entity.getAnesthesiologyNurse().isEmpty()) {
			Iterable<PreoperativeRecordsEntity> anesthesiologyNurseEntities =
					this.preoperativeRecordsRepository.findAllById(entity.getAnesthesiologyNurseIds());
			entityToUpdate.setAnesthesiologyNurse(Sets.newHashSet(anesthesiologyNurseEntities));
		}
		if (persistRelations && !entity.getAnesthesiologyNurse().isEmpty()) {
			Set<PreoperativeRecordsEntity> updatedEntities = new HashSet<>();
			entity.getAnesthesiologyNurse().forEach(model -> {
				if (model.getId() != null) {
					model = this.preoperativeRecordsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setAnesthesiologyNurse(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getCashierStaffIds().isEmpty() && entity.getCashierStaff().isEmpty()) {
			entityToUpdate.setCashierStaff(new HashSet<>());
		} else if (!entity.getCashierStaffIds().isEmpty() && entity.getCashierStaff().isEmpty()) {
			Iterable<CashReceiptEntity> cashierStaffEntities =
					this.cashReceiptRepository.findAllById(entity.getCashierStaffIds());
			entityToUpdate.setCashierStaff(Sets.newHashSet(cashierStaffEntities));
		}
		if (persistRelations && !entity.getCashierStaff().isEmpty()) {
			Set<CashReceiptEntity> updatedEntities = new HashSet<>();
			entity.getCashierStaff().forEach(model -> {
				if (model.getId() != null) {
					model = this.cashReceiptRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCashierStaff(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getCoTreatingDoctorsIds().isEmpty() && entity.getCoTreatingDoctors().isEmpty()) {
			entityToUpdate.setCoTreatingDoctors(new HashSet<>());
		} else if (!entity.getCoTreatingDoctorsIds().isEmpty() && entity.getCoTreatingDoctors().isEmpty()) {
			Iterable<CoTreatingDoctorEntity> coTreatingDoctorsEntities =
					this.coTreatingDoctorRepository.findAllById(entity.getCoTreatingDoctorsIds());
			entityToUpdate.setCoTreatingDoctors(Sets.newHashSet(coTreatingDoctorsEntities));
		}
		if (persistRelations && !entity.getCoTreatingDoctors().isEmpty()) {
			Set<CoTreatingDoctorEntity> updatedEntities = new HashSet<>();
			entity.getCoTreatingDoctors().forEach(model -> {
				if (model.getId() != null) {
					model = this.coTreatingDoctorRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCoTreatingDoctors(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDailyCareCPPTsCreatedByStaffIds().isEmpty() && entity.getDailyCareCPPTsCreatedByStaff().isEmpty()) {
			entityToUpdate.setDailyCareCPPTsCreatedByStaff(new HashSet<>());
		} else if (!entity.getDailyCareCPPTsCreatedByStaffIds().isEmpty() && entity.getDailyCareCPPTsCreatedByStaff().isEmpty()) {
			Iterable<DailyCareCPPTEntity> dailyCareCPPTsCreatedByStaffEntities =
					this.dailyCareCPPTRepository.findAllById(entity.getDailyCareCPPTsCreatedByStaffIds());
			entityToUpdate.setDailyCareCPPTsCreatedByStaff(Sets.newHashSet(dailyCareCPPTsCreatedByStaffEntities));
		}
		if (persistRelations && !entity.getDailyCareCPPTsCreatedByStaff().isEmpty()) {
			Set<DailyCareCPPTEntity> updatedEntities = new HashSet<>();
			entity.getDailyCareCPPTsCreatedByStaff().forEach(model -> {
				if (model.getId() != null) {
					model = this.dailyCareCPPTRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDailyCareCPPTsCreatedByStaff(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDailyCareCPPTsDoctorInChargeIds().isEmpty() && entity.getDailyCareCPPTsDoctorInCharge().isEmpty()) {
			entityToUpdate.setDailyCareCPPTsDoctorInCharge(new HashSet<>());
		} else if (!entity.getDailyCareCPPTsDoctorInChargeIds().isEmpty() && entity.getDailyCareCPPTsDoctorInCharge().isEmpty()) {
			Iterable<DailyCareCPPTEntity> dailyCareCPPTsDoctorInChargeEntities =
					this.dailyCareCPPTRepository.findAllById(entity.getDailyCareCPPTsDoctorInChargeIds());
			entityToUpdate.setDailyCareCPPTsDoctorInCharge(Sets.newHashSet(dailyCareCPPTsDoctorInChargeEntities));
		}
		if (persistRelations && !entity.getDailyCareCPPTsDoctorInCharge().isEmpty()) {
			Set<DailyCareCPPTEntity> updatedEntities = new HashSet<>();
			entity.getDailyCareCPPTsDoctorInCharge().forEach(model -> {
				if (model.getId() != null) {
					model = this.dailyCareCPPTRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDailyCareCPPTsDoctorInCharge(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDailyCareCPPTsMedicalTranscriberIds().isEmpty() && entity.getDailyCareCPPTsMedicalTranscriber().isEmpty()) {
			entityToUpdate.setDailyCareCPPTsMedicalTranscriber(new HashSet<>());
		} else if (!entity.getDailyCareCPPTsMedicalTranscriberIds().isEmpty() && entity.getDailyCareCPPTsMedicalTranscriber().isEmpty()) {
			Iterable<DailyCareCPPTEntity> dailyCareCPPTsMedicalTranscriberEntities =
					this.dailyCareCPPTRepository.findAllById(entity.getDailyCareCPPTsMedicalTranscriberIds());
			entityToUpdate.setDailyCareCPPTsMedicalTranscriber(Sets.newHashSet(dailyCareCPPTsMedicalTranscriberEntities));
		}
		if (persistRelations && !entity.getDailyCareCPPTsMedicalTranscriber().isEmpty()) {
			Set<DailyCareCPPTEntity> updatedEntities = new HashSet<>();
			entity.getDailyCareCPPTsMedicalTranscriber().forEach(model -> {
				if (model.getId() != null) {
					model = this.dailyCareCPPTRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDailyCareCPPTsMedicalTranscriber(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDeliveryProgressesIds().isEmpty() && entity.getDeliveryProgresses().isEmpty()) {
			entityToUpdate.setDeliveryProgresses(new HashSet<>());
		} else if (!entity.getDeliveryProgressesIds().isEmpty() && entity.getDeliveryProgresses().isEmpty()) {
			Iterable<DeliveryProgressEntity> deliveryProgressesEntities =
					this.deliveryProgressRepository.findAllById(entity.getDeliveryProgressesIds());
			entityToUpdate.setDeliveryProgresses(Sets.newHashSet(deliveryProgressesEntities));
		}
		if (persistRelations && !entity.getDeliveryProgresses().isEmpty()) {
			Set<DeliveryProgressEntity> updatedEntities = new HashSet<>();
			entity.getDeliveryProgresses().forEach(model -> {
				if (model.getId() != null) {
					model = this.deliveryProgressRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDeliveryProgresses(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDiagnosticStaffExaminationSummariesIds().isEmpty() && entity.getDiagnosticStaffExaminationSummaries().isEmpty()) {
			entityToUpdate.setDiagnosticStaffExaminationSummaries(new HashSet<>());
		} else if (!entity.getDiagnosticStaffExaminationSummariesIds().isEmpty() && entity.getDiagnosticStaffExaminationSummaries().isEmpty()) {
			Iterable<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummariesEntities =
					this.diagnosticStaffExaminationSummaryRepository.findAllById(entity.getDiagnosticStaffExaminationSummariesIds());
			entityToUpdate.setDiagnosticStaffExaminationSummaries(Sets.newHashSet(diagnosticStaffExaminationSummariesEntities));
		}
		if (persistRelations && !entity.getDiagnosticStaffExaminationSummaries().isEmpty()) {
			Set<DiagnosticStaffExaminationSummaryEntity> updatedEntities = new HashSet<>();
			entity.getDiagnosticStaffExaminationSummaries().forEach(model -> {
				if (model.getId() != null) {
					model = this.diagnosticStaffExaminationSummaryRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDiagnosticStaffExaminationSummaries(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDismissalReferringStaffIds().isEmpty() && entity.getDismissalReferringStaff().isEmpty()) {
			entityToUpdate.setDismissalReferringStaff(new HashSet<>());
		} else if (!entity.getDismissalReferringStaffIds().isEmpty() && entity.getDismissalReferringStaff().isEmpty()) {
			Iterable<RegistrationEntity> dismissalReferringStaffEntities =
					this.registrationRepository.findAllById(entity.getDismissalReferringStaffIds());
			entityToUpdate.setDismissalReferringStaff(Sets.newHashSet(dismissalReferringStaffEntities));
		}
		if (persistRelations && !entity.getDismissalReferringStaff().isEmpty()) {
			Set<RegistrationEntity> updatedEntities = new HashSet<>();
			entity.getDismissalReferringStaff().forEach(model -> {
				if (model.getId() != null) {
					model = this.registrationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDismissalReferringStaff(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDoctorSchedulesIds().isEmpty() && entity.getDoctorSchedules().isEmpty()) {
			entityToUpdate.setDoctorSchedules(new HashSet<>());
		} else if (!entity.getDoctorSchedulesIds().isEmpty() && entity.getDoctorSchedules().isEmpty()) {
			Iterable<DoctorScheduleEntity> doctorSchedulesEntities =
					this.doctorScheduleRepository.findAllById(entity.getDoctorSchedulesIds());
			entityToUpdate.setDoctorSchedules(Sets.newHashSet(doctorSchedulesEntities));
		}
		if (persistRelations && !entity.getDoctorSchedules().isEmpty()) {
			Set<DoctorScheduleEntity> updatedEntities = new HashSet<>();
			entity.getDoctorSchedules().forEach(model -> {
				if (model.getId() != null) {
					model = this.doctorScheduleRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDoctorSchedules(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDoctorOnExaminationIds().isEmpty() && entity.getDoctorOnExamination().isEmpty()) {
			entityToUpdate.setDoctorOnExamination(new HashSet<>());
		} else if (!entity.getDoctorOnExaminationIds().isEmpty() && entity.getDoctorOnExamination().isEmpty()) {
			Iterable<MedicalExaminationRecordEntity> doctorOnExaminationEntities =
					this.medicalExaminationRecordRepository.findAllById(entity.getDoctorOnExaminationIds());
			entityToUpdate.setDoctorOnExamination(Sets.newHashSet(doctorOnExaminationEntities));
		}
		if (persistRelations && !entity.getDoctorOnExamination().isEmpty()) {
			Set<MedicalExaminationRecordEntity> updatedEntities = new HashSet<>();
			entity.getDoctorOnExamination().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalExaminationRecordRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDoctorOnExamination(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getFluidBalanceDetailsIds().isEmpty() && entity.getFluidBalanceDetails().isEmpty()) {
			entityToUpdate.setFluidBalanceDetails(new HashSet<>());
		} else if (!entity.getFluidBalanceDetailsIds().isEmpty() && entity.getFluidBalanceDetails().isEmpty()) {
			Iterable<FluidBalanceDetailEntity> fluidBalanceDetailsEntities =
					this.fluidBalanceDetailRepository.findAllById(entity.getFluidBalanceDetailsIds());
			entityToUpdate.setFluidBalanceDetails(Sets.newHashSet(fluidBalanceDetailsEntities));
		}
		if (persistRelations && !entity.getFluidBalanceDetails().isEmpty()) {
			Set<FluidBalanceDetailEntity> updatedEntities = new HashSet<>();
			entity.getFluidBalanceDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.fluidBalanceDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setFluidBalanceDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getHemodialysisMonitoringsIds().isEmpty() && entity.getHemodialysisMonitorings().isEmpty()) {
			entityToUpdate.setHemodialysisMonitorings(new HashSet<>());
		} else if (!entity.getHemodialysisMonitoringsIds().isEmpty() && entity.getHemodialysisMonitorings().isEmpty()) {
			Iterable<HemodialysisMonitoringEntity> hemodialysisMonitoringsEntities =
					this.hemodialysisMonitoringRepository.findAllById(entity.getHemodialysisMonitoringsIds());
			entityToUpdate.setHemodialysisMonitorings(Sets.newHashSet(hemodialysisMonitoringsEntities));
		}
		if (persistRelations && !entity.getHemodialysisMonitorings().isEmpty()) {
			Set<HemodialysisMonitoringEntity> updatedEntities = new HashSet<>();
			entity.getHemodialysisMonitorings().forEach(model -> {
				if (model.getId() != null) {
					model = this.hemodialysisMonitoringRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setHemodialysisMonitorings(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getHospitalBranchInformationsIds().isEmpty() && entity.getHospitalBranchInformations().isEmpty()) {
			entityToUpdate.setHospitalBranchInformations(new HashSet<>());
		} else if (!entity.getHospitalBranchInformationsIds().isEmpty() && entity.getHospitalBranchInformations().isEmpty()) {
			Iterable<HospitalBranchInformationEntity> hospitalBranchInformationsEntities =
					this.hospitalBranchInformationRepository.findAllById(entity.getHospitalBranchInformationsIds());
			entityToUpdate.setHospitalBranchInformations(Sets.newHashSet(hospitalBranchInformationsEntities));
		}
		if (persistRelations && !entity.getHospitalBranchInformations().isEmpty()) {
			Set<HospitalBranchInformationEntity> updatedEntities = new HashSet<>();
			entity.getHospitalBranchInformations().forEach(model -> {
				if (model.getId() != null) {
					model = this.hospitalBranchInformationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setHospitalBranchInformations(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInformingConsentsIds().isEmpty() && entity.getInformingConsents().isEmpty()) {
			entityToUpdate.setInformingConsents(new HashSet<>());
		} else if (!entity.getInformingConsentsIds().isEmpty() && entity.getInformingConsents().isEmpty()) {
			Iterable<InformedConsentEntity> informingConsentsEntities =
					this.informedConsentRepository.findAllById(entity.getInformingConsentsIds());
			entityToUpdate.setInformingConsents(Sets.newHashSet(informingConsentsEntities));
		}
		if (persistRelations && !entity.getInformingConsents().isEmpty()) {
			Set<InformedConsentEntity> updatedEntities = new HashSet<>();
			entity.getInformingConsents().forEach(model -> {
				if (model.getId() != null) {
					model = this.informedConsentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInformingConsents(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInvoicesIds().isEmpty() && entity.getInvoices().isEmpty()) {
			entityToUpdate.setInvoices(new HashSet<>());
		} else if (!entity.getInvoicesIds().isEmpty() && entity.getInvoices().isEmpty()) {
			Iterable<InvoiceEntity> invoicesEntities =
					this.invoiceRepository.findAllById(entity.getInvoicesIds());
			entityToUpdate.setInvoices(Sets.newHashSet(invoicesEntities));
		}
		if (persistRelations && !entity.getInvoices().isEmpty()) {
			Set<InvoiceEntity> updatedEntities = new HashSet<>();
			entity.getInvoices().forEach(model -> {
				if (model.getId() != null) {
					model = this.invoiceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoices(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMcuPackageItemsIds().isEmpty() && entity.getMcuPackageItems().isEmpty()) {
			entityToUpdate.setMcuPackageItems(new HashSet<>());
		} else if (!entity.getMcuPackageItemsIds().isEmpty() && entity.getMcuPackageItems().isEmpty()) {
			Iterable<McuPackageItemEntity> mcuPackageItemsEntities =
					this.mcuPackageItemRepository.findAllById(entity.getMcuPackageItemsIds());
			entityToUpdate.setMcuPackageItems(Sets.newHashSet(mcuPackageItemsEntities));
		}
		if (persistRelations && !entity.getMcuPackageItems().isEmpty()) {
			Set<McuPackageItemEntity> updatedEntities = new HashSet<>();
			entity.getMcuPackageItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.mcuPackageItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMcuPackageItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalCertificateDischargeResumesIds().isEmpty() && entity.getMedicalCertificateDischargeResumes().isEmpty()) {
			entityToUpdate.setMedicalCertificateDischargeResumes(new HashSet<>());
		} else if (!entity.getMedicalCertificateDischargeResumesIds().isEmpty() && entity.getMedicalCertificateDischargeResumes().isEmpty()) {
			Iterable<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumesEntities =
					this.medicalCertificateDischargeResumeRepository.findAllById(entity.getMedicalCertificateDischargeResumesIds());
			entityToUpdate.setMedicalCertificateDischargeResumes(Sets.newHashSet(medicalCertificateDischargeResumesEntities));
		}
		if (persistRelations && !entity.getMedicalCertificateDischargeResumes().isEmpty()) {
			Set<MedicalCertificateDischargeResumeEntity> updatedEntities = new HashSet<>();
			entity.getMedicalCertificateDischargeResumes().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalCertificateDischargeResumeRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalCertificateDischargeResumes(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalCertificateBirthsIds().isEmpty() && entity.getMedicalCertificateBirths().isEmpty()) {
			entityToUpdate.setMedicalCertificateBirths(new HashSet<>());
		} else if (!entity.getMedicalCertificateBirthsIds().isEmpty() && entity.getMedicalCertificateBirths().isEmpty()) {
			Iterable<MedicalCertificateBirthEntity> medicalCertificateBirthsEntities =
					this.medicalCertificateBirthRepository.findAllById(entity.getMedicalCertificateBirthsIds());
			entityToUpdate.setMedicalCertificateBirths(Sets.newHashSet(medicalCertificateBirthsEntities));
		}
		if (persistRelations && !entity.getMedicalCertificateBirths().isEmpty()) {
			Set<MedicalCertificateBirthEntity> updatedEntities = new HashSet<>();
			entity.getMedicalCertificateBirths().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalCertificateBirthRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalCertificateBirths(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalCertificateHospitalizationsIds().isEmpty() && entity.getMedicalCertificateHospitalizations().isEmpty()) {
			entityToUpdate.setMedicalCertificateHospitalizations(new HashSet<>());
		} else if (!entity.getMedicalCertificateHospitalizationsIds().isEmpty() && entity.getMedicalCertificateHospitalizations().isEmpty()) {
			Iterable<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizationsEntities =
					this.medicalCertificateHospitalizationRepository.findAllById(entity.getMedicalCertificateHospitalizationsIds());
			entityToUpdate.setMedicalCertificateHospitalizations(Sets.newHashSet(medicalCertificateHospitalizationsEntities));
		}
		if (persistRelations && !entity.getMedicalCertificateHospitalizations().isEmpty()) {
			Set<MedicalCertificateHospitalizationEntity> updatedEntities = new HashSet<>();
			entity.getMedicalCertificateHospitalizations().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalCertificateHospitalizationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalCertificateHospitalizations(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalExaminationRecordDischargeSummarysIds().isEmpty() && entity.getMedicalExaminationRecordDischargeSummarys().isEmpty()) {
			entityToUpdate.setMedicalExaminationRecordDischargeSummarys(new HashSet<>());
		} else if (!entity.getMedicalExaminationRecordDischargeSummarysIds().isEmpty() && entity.getMedicalExaminationRecordDischargeSummarys().isEmpty()) {
			Iterable<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummarysEntities =
					this.medicalExaminationRecordDischargeSummaryRepository.findAllById(entity.getMedicalExaminationRecordDischargeSummarysIds());
			entityToUpdate.setMedicalExaminationRecordDischargeSummarys(Sets.newHashSet(medicalExaminationRecordDischargeSummarysEntities));
		}
		if (persistRelations && !entity.getMedicalExaminationRecordDischargeSummarys().isEmpty()) {
			Set<MedicalExaminationRecordDischargeSummaryEntity> updatedEntities = new HashSet<>();
			entity.getMedicalExaminationRecordDischargeSummarys().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalExaminationRecordDischargeSummaryRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalExaminationRecordDischargeSummarys(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalRecordTranscriberIds().isEmpty() && entity.getMedicalRecordTranscriber().isEmpty()) {
			entityToUpdate.setMedicalRecordTranscriber(new HashSet<>());
		} else if (!entity.getMedicalRecordTranscriberIds().isEmpty() && entity.getMedicalRecordTranscriber().isEmpty()) {
			Iterable<MedicalExaminationRecordEntity> medicalRecordTranscriberEntities =
					this.medicalExaminationRecordRepository.findAllById(entity.getMedicalRecordTranscriberIds());
			entityToUpdate.setMedicalRecordTranscriber(Sets.newHashSet(medicalRecordTranscriberEntities));
		}
		if (persistRelations && !entity.getMedicalRecordTranscriber().isEmpty()) {
			Set<MedicalExaminationRecordEntity> updatedEntities = new HashSet<>();
			entity.getMedicalRecordTranscriber().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalExaminationRecordRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalRecordTranscriber(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalStaffOfMedicalAttendancesCertificateIds().isEmpty() && entity.getMedicalStaffOfMedicalAttendancesCertificate().isEmpty()) {
			entityToUpdate.setMedicalStaffOfMedicalAttendancesCertificate(new HashSet<>());
		} else if (!entity.getMedicalStaffOfMedicalAttendancesCertificateIds().isEmpty() && entity.getMedicalStaffOfMedicalAttendancesCertificate().isEmpty()) {
			Iterable<MedicalCertificateMedicalAttendanceEntity> medicalStaffOfMedicalAttendancesCertificateEntities =
					this.medicalCertificateMedicalAttendanceRepository.findAllById(entity.getMedicalStaffOfMedicalAttendancesCertificateIds());
			entityToUpdate.setMedicalStaffOfMedicalAttendancesCertificate(Sets.newHashSet(medicalStaffOfMedicalAttendancesCertificateEntities));
		}
		if (persistRelations && !entity.getMedicalStaffOfMedicalAttendancesCertificate().isEmpty()) {
			Set<MedicalCertificateMedicalAttendanceEntity> updatedEntities = new HashSet<>();
			entity.getMedicalStaffOfMedicalAttendancesCertificate().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalCertificateMedicalAttendanceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalStaffOfMedicalAttendancesCertificate(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalStaffOfMentalHealthsIds().isEmpty() && entity.getMedicalStaffOfMentalHealths().isEmpty()) {
			entityToUpdate.setMedicalStaffOfMentalHealths(new HashSet<>());
		} else if (!entity.getMedicalStaffOfMentalHealthsIds().isEmpty() && entity.getMedicalStaffOfMentalHealths().isEmpty()) {
			Iterable<MedicalCertificateMentalHealthEntity> medicalStaffOfMentalHealthsEntities =
					this.medicalCertificateMentalHealthRepository.findAllById(entity.getMedicalStaffOfMentalHealthsIds());
			entityToUpdate.setMedicalStaffOfMentalHealths(Sets.newHashSet(medicalStaffOfMentalHealthsEntities));
		}
		if (persistRelations && !entity.getMedicalStaffOfMentalHealths().isEmpty()) {
			Set<MedicalCertificateMentalHealthEntity> updatedEntities = new HashSet<>();
			entity.getMedicalStaffOfMentalHealths().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalCertificateMentalHealthRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalStaffOfMentalHealths(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalStaffOfPhysicalHealthsIds().isEmpty() && entity.getMedicalStaffOfPhysicalHealths().isEmpty()) {
			entityToUpdate.setMedicalStaffOfPhysicalHealths(new HashSet<>());
		} else if (!entity.getMedicalStaffOfPhysicalHealthsIds().isEmpty() && entity.getMedicalStaffOfPhysicalHealths().isEmpty()) {
			Iterable<MedicalCertificatePhysicalHealthEntity> medicalStaffOfPhysicalHealthsEntities =
					this.medicalCertificatePhysicalHealthRepository.findAllById(entity.getMedicalStaffOfPhysicalHealthsIds());
			entityToUpdate.setMedicalStaffOfPhysicalHealths(Sets.newHashSet(medicalStaffOfPhysicalHealthsEntities));
		}
		if (persistRelations && !entity.getMedicalStaffOfPhysicalHealths().isEmpty()) {
			Set<MedicalCertificatePhysicalHealthEntity> updatedEntities = new HashSet<>();
			entity.getMedicalStaffOfPhysicalHealths().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalCertificatePhysicalHealthRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalStaffOfPhysicalHealths(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalStaffOfRestrictedWorksCertificateIds().isEmpty() && entity.getMedicalStaffOfRestrictedWorksCertificate().isEmpty()) {
			entityToUpdate.setMedicalStaffOfRestrictedWorksCertificate(new HashSet<>());
		} else if (!entity.getMedicalStaffOfRestrictedWorksCertificateIds().isEmpty() && entity.getMedicalStaffOfRestrictedWorksCertificate().isEmpty()) {
			Iterable<MedicalCertificateRestrictedWorkEntity> medicalStaffOfRestrictedWorksCertificateEntities =
					this.medicalCertificateRestrictedWorkRepository.findAllById(entity.getMedicalStaffOfRestrictedWorksCertificateIds());
			entityToUpdate.setMedicalStaffOfRestrictedWorksCertificate(Sets.newHashSet(medicalStaffOfRestrictedWorksCertificateEntities));
		}
		if (persistRelations && !entity.getMedicalStaffOfRestrictedWorksCertificate().isEmpty()) {
			Set<MedicalCertificateRestrictedWorkEntity> updatedEntities = new HashSet<>();
			entity.getMedicalStaffOfRestrictedWorksCertificate().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalCertificateRestrictedWorkRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalStaffOfRestrictedWorksCertificate(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalStaffOfSickLeavesCertificateIds().isEmpty() && entity.getMedicalStaffOfSickLeavesCertificate().isEmpty()) {
			entityToUpdate.setMedicalStaffOfSickLeavesCertificate(new HashSet<>());
		} else if (!entity.getMedicalStaffOfSickLeavesCertificateIds().isEmpty() && entity.getMedicalStaffOfSickLeavesCertificate().isEmpty()) {
			Iterable<MedicalCertificateSickLeaveEntity> medicalStaffOfSickLeavesCertificateEntities =
					this.medicalCertificateSickLeaveRepository.findAllById(entity.getMedicalStaffOfSickLeavesCertificateIds());
			entityToUpdate.setMedicalStaffOfSickLeavesCertificate(Sets.newHashSet(medicalStaffOfSickLeavesCertificateEntities));
		}
		if (persistRelations && !entity.getMedicalStaffOfSickLeavesCertificate().isEmpty()) {
			Set<MedicalCertificateSickLeaveEntity> updatedEntities = new HashSet<>();
			entity.getMedicalStaffOfSickLeavesCertificate().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalCertificateSickLeaveRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalStaffOfSickLeavesCertificate(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicationAdministeredHisotriesIds().isEmpty() && entity.getMedicationAdministeredHisotries().isEmpty()) {
			entityToUpdate.setMedicationAdministeredHisotries(new HashSet<>());
		} else if (!entity.getMedicationAdministeredHisotriesIds().isEmpty() && entity.getMedicationAdministeredHisotries().isEmpty()) {
			Iterable<MedicationAdministeredHistoryEntity> medicationAdministeredHisotriesEntities =
					this.medicationAdministeredHistoryRepository.findAllById(entity.getMedicationAdministeredHisotriesIds());
			entityToUpdate.setMedicationAdministeredHisotries(Sets.newHashSet(medicationAdministeredHisotriesEntities));
		}
		if (persistRelations && !entity.getMedicationAdministeredHisotries().isEmpty()) {
			Set<MedicationAdministeredHistoryEntity> updatedEntities = new HashSet<>();
			entity.getMedicationAdministeredHisotries().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicationAdministeredHistoryRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicationAdministeredHisotries(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicationHeadersIds().isEmpty() && entity.getMedicationHeaders().isEmpty()) {
			entityToUpdate.setMedicationHeaders(new HashSet<>());
		} else if (!entity.getMedicationHeadersIds().isEmpty() && entity.getMedicationHeaders().isEmpty()) {
			Iterable<MedicationHeaderEntity> medicationHeadersEntities =
					this.medicationHeaderRepository.findAllById(entity.getMedicationHeadersIds());
			entityToUpdate.setMedicationHeaders(Sets.newHashSet(medicationHeadersEntities));
		}
		if (persistRelations && !entity.getMedicationHeaders().isEmpty()) {
			Set<MedicationHeaderEntity> updatedEntities = new HashSet<>();
			entity.getMedicationHeaders().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicationHeaderRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicationHeaders(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMidwivesIds().isEmpty() && entity.getMidwives().isEmpty()) {
			entityToUpdate.setMidwives(new HashSet<>());
		} else if (!entity.getMidwivesIds().isEmpty() && entity.getMidwives().isEmpty()) {
			Iterable<DeliveryMedicalExaminationRecordEntity> midwivesEntities =
					this.deliveryMedicalExaminationRecordRepository.findAllById(entity.getMidwivesIds());
			entityToUpdate.setMidwives(Sets.newHashSet(midwivesEntities));
		}
		if (persistRelations && !entity.getMidwives().isEmpty()) {
			Set<DeliveryMedicalExaminationRecordEntity> updatedEntities = new HashSet<>();
			entity.getMidwives().forEach(model -> {
				if (model.getId() != null) {
					model = this.deliveryMedicalExaminationRecordRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMidwives(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getNurseIds().isEmpty() && entity.getNurse().isEmpty()) {
			entityToUpdate.setNurse(new HashSet<>());
		} else if (!entity.getNurseIds().isEmpty() && entity.getNurse().isEmpty()) {
			Iterable<MedicalExaminationRecordEntity> nurseEntities =
					this.medicalExaminationRecordRepository.findAllById(entity.getNurseIds());
			entityToUpdate.setNurse(Sets.newHashSet(nurseEntities));
		}
		if (persistRelations && !entity.getNurse().isEmpty()) {
			Set<MedicalExaminationRecordEntity> updatedEntities = new HashSet<>();
			entity.getNurse().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalExaminationRecordRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setNurse(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getNursingDetailSurgicalNursingIds().isEmpty() && entity.getNursingDetailSurgicalNursing().isEmpty()) {
			entityToUpdate.setNursingDetailSurgicalNursing(new HashSet<>());
		} else if (!entity.getNursingDetailSurgicalNursingIds().isEmpty() && entity.getNursingDetailSurgicalNursing().isEmpty()) {
			Iterable<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailSurgicalNursingEntities =
					this.operatingTheaterMedicalExaminationRecordRepository.findAllById(entity.getNursingDetailSurgicalNursingIds());
			entityToUpdate.setNursingDetailSurgicalNursing(Sets.newHashSet(nursingDetailSurgicalNursingEntities));
		}
		if (persistRelations && !entity.getNursingDetailSurgicalNursing().isEmpty()) {
			Set<OperatingTheaterMedicalExaminationRecordEntity> updatedEntities = new HashSet<>();
			entity.getNursingDetailSurgicalNursing().forEach(model -> {
				if (model.getId() != null) {
					model = this.operatingTheaterMedicalExaminationRecordRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setNursingDetailSurgicalNursing(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getNursingDetailsAnesthesiaNursingIds().isEmpty() && entity.getNursingDetailsAnesthesiaNursing().isEmpty()) {
			entityToUpdate.setNursingDetailsAnesthesiaNursing(new HashSet<>());
		} else if (!entity.getNursingDetailsAnesthesiaNursingIds().isEmpty() && entity.getNursingDetailsAnesthesiaNursing().isEmpty()) {
			Iterable<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailsAnesthesiaNursingEntities =
					this.operatingTheaterMedicalExaminationRecordRepository.findAllById(entity.getNursingDetailsAnesthesiaNursingIds());
			entityToUpdate.setNursingDetailsAnesthesiaNursing(Sets.newHashSet(nursingDetailsAnesthesiaNursingEntities));
		}
		if (persistRelations && !entity.getNursingDetailsAnesthesiaNursing().isEmpty()) {
			Set<OperatingTheaterMedicalExaminationRecordEntity> updatedEntities = new HashSet<>();
			entity.getNursingDetailsAnesthesiaNursing().forEach(model -> {
				if (model.getId() != null) {
					model = this.operatingTheaterMedicalExaminationRecordRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setNursingDetailsAnesthesiaNursing(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPatientConsentsIds().isEmpty() && entity.getPatientConsents().isEmpty()) {
			entityToUpdate.setPatientConsents(new HashSet<>());
		} else if (!entity.getPatientConsentsIds().isEmpty() && entity.getPatientConsents().isEmpty()) {
			Iterable<PatientConsentEntity> patientConsentsEntities =
					this.patientConsentRepository.findAllById(entity.getPatientConsentsIds());
			entityToUpdate.setPatientConsents(Sets.newHashSet(patientConsentsEntities));
		}
		if (persistRelations && !entity.getPatientConsents().isEmpty()) {
			Set<PatientConsentEntity> updatedEntities = new HashSet<>();
			entity.getPatientConsents().forEach(model -> {
				if (model.getId() != null) {
					model = this.patientConsentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPatientConsents(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPatientVitalInformationsIds().isEmpty() && entity.getPatientVitalInformations().isEmpty()) {
			entityToUpdate.setPatientVitalInformations(new HashSet<>());
		} else if (!entity.getPatientVitalInformationsIds().isEmpty() && entity.getPatientVitalInformations().isEmpty()) {
			Iterable<PatientVitalInformationEntity> patientVitalInformationsEntities =
					this.patientVitalInformationRepository.findAllById(entity.getPatientVitalInformationsIds());
			entityToUpdate.setPatientVitalInformations(Sets.newHashSet(patientVitalInformationsEntities));
		}
		if (persistRelations && !entity.getPatientVitalInformations().isEmpty()) {
			Set<PatientVitalInformationEntity> updatedEntities = new HashSet<>();
			entity.getPatientVitalInformations().forEach(model -> {
				if (model.getId() != null) {
					model = this.patientVitalInformationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPatientVitalInformations(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPediatricianInChargeIds().isEmpty() && entity.getPediatricianInCharge().isEmpty()) {
			entityToUpdate.setPediatricianInCharge(new HashSet<>());
		} else if (!entity.getPediatricianInChargeIds().isEmpty() && entity.getPediatricianInCharge().isEmpty()) {
			Iterable<NewbornDetailEntity> pediatricianInChargeEntities =
					this.newbornDetailRepository.findAllById(entity.getPediatricianInChargeIds());
			entityToUpdate.setPediatricianInCharge(Sets.newHashSet(pediatricianInChargeEntities));
		}
		if (persistRelations && !entity.getPediatricianInCharge().isEmpty()) {
			Set<NewbornDetailEntity> updatedEntities = new HashSet<>();
			entity.getPediatricianInCharge().forEach(model -> {
				if (model.getId() != null) {
					model = this.newbornDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPediatricianInCharge(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPrescriptionHeadersIds().isEmpty() && entity.getPrescriptionHeaders().isEmpty()) {
			entityToUpdate.setPrescriptionHeaders(new HashSet<>());
		} else if (!entity.getPrescriptionHeadersIds().isEmpty() && entity.getPrescriptionHeaders().isEmpty()) {
			Iterable<PrescriptionHeaderEntity> prescriptionHeadersEntities =
					this.prescriptionHeaderRepository.findAllById(entity.getPrescriptionHeadersIds());
			entityToUpdate.setPrescriptionHeaders(Sets.newHashSet(prescriptionHeadersEntities));
		}
		if (persistRelations && !entity.getPrescriptionHeaders().isEmpty()) {
			Set<PrescriptionHeaderEntity> updatedEntities = new HashSet<>();
			entity.getPrescriptionHeaders().forEach(model -> {
				if (model.getId() != null) {
					model = this.prescriptionHeaderRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPrescriptionHeaders(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getProcessWorkflowLogsIds().isEmpty() && entity.getProcessWorkflowLogs().isEmpty()) {
			entityToUpdate.setProcessWorkflowLogs(new HashSet<>());
		} else if (!entity.getProcessWorkflowLogsIds().isEmpty() && entity.getProcessWorkflowLogs().isEmpty()) {
			Iterable<ProcessWorkflowEntity> processWorkflowLogsEntities =
					this.processWorkflowRepository.findAllById(entity.getProcessWorkflowLogsIds());
			entityToUpdate.setProcessWorkflowLogs(Sets.newHashSet(processWorkflowLogsEntities));
		}
		if (persistRelations && !entity.getProcessWorkflowLogs().isEmpty()) {
			Set<ProcessWorkflowEntity> updatedEntities = new HashSet<>();
			entity.getProcessWorkflowLogs().forEach(model -> {
				if (model.getId() != null) {
					model = this.processWorkflowRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setProcessWorkflowLogs(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getRegistrationsIds().isEmpty() && entity.getRegistrations().isEmpty()) {
			entityToUpdate.setRegistrations(new HashSet<>());
		} else if (!entity.getRegistrationsIds().isEmpty() && entity.getRegistrations().isEmpty()) {
			Iterable<RegistrationEntity> registrationsEntities =
					this.registrationRepository.findAllById(entity.getRegistrationsIds());
			entityToUpdate.setRegistrations(Sets.newHashSet(registrationsEntities));
		}
		if (persistRelations && !entity.getRegistrations().isEmpty()) {
			Set<RegistrationEntity> updatedEntities = new HashSet<>();
			entity.getRegistrations().forEach(model -> {
				if (model.getId() != null) {
					model = this.registrationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRegistrations(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getRequestedByIds().isEmpty() && entity.getRequestedBy().isEmpty()) {
			entityToUpdate.setRequestedBy(new HashSet<>());
		} else if (!entity.getRequestedByIds().isEmpty() && entity.getRequestedBy().isEmpty()) {
			Iterable<RegistrationEntity> requestedByEntities =
					this.registrationRepository.findAllById(entity.getRequestedByIds());
			entityToUpdate.setRequestedBy(Sets.newHashSet(requestedByEntities));
		}
		if (persistRelations && !entity.getRequestedBy().isEmpty()) {
			Set<RegistrationEntity> updatedEntities = new HashSet<>();
			entity.getRequestedBy().forEach(model -> {
				if (model.getId() != null) {
					model = this.registrationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRequestedBy(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getRoomTransfersIds().isEmpty() && entity.getRoomTransfers().isEmpty()) {
			entityToUpdate.setRoomTransfers(new HashSet<>());
		} else if (!entity.getRoomTransfersIds().isEmpty() && entity.getRoomTransfers().isEmpty()) {
			Iterable<RoomTransferEntity> roomTransfersEntities =
					this.roomTransferRepository.findAllById(entity.getRoomTransfersIds());
			entityToUpdate.setRoomTransfers(Sets.newHashSet(roomTransfersEntities));
		}
		if (persistRelations && !entity.getRoomTransfers().isEmpty()) {
			Set<RoomTransferEntity> updatedEntities = new HashSet<>();
			entity.getRoomTransfers().forEach(model -> {
				if (model.getId() != null) {
					model = this.roomTransferRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRoomTransfers(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getSampleCollectionStaffsIds().isEmpty() && entity.getSampleCollectionStaffs().isEmpty()) {
			entityToUpdate.setSampleCollectionStaffs(new HashSet<>());
		} else if (!entity.getSampleCollectionStaffsIds().isEmpty() && entity.getSampleCollectionStaffs().isEmpty()) {
			Iterable<SampleCollectionItemsEntity> sampleCollectionStaffsEntities =
					this.sampleCollectionItemsRepository.findAllById(entity.getSampleCollectionStaffsIds());
			entityToUpdate.setSampleCollectionStaffs(Sets.newHashSet(sampleCollectionStaffsEntities));
		}
		if (persistRelations && !entity.getSampleCollectionStaffs().isEmpty()) {
			Set<SampleCollectionItemsEntity> updatedEntities = new HashSet<>();
			entity.getSampleCollectionStaffs().forEach(model -> {
				if (model.getId() != null) {
					model = this.sampleCollectionItemsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSampleCollectionStaffs(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getSampleDeliveryStaffsIds().isEmpty() && entity.getSampleDeliveryStaffs().isEmpty()) {
			entityToUpdate.setSampleDeliveryStaffs(new HashSet<>());
		} else if (!entity.getSampleDeliveryStaffsIds().isEmpty() && entity.getSampleDeliveryStaffs().isEmpty()) {
			Iterable<SampleCollectionItemsEntity> sampleDeliveryStaffsEntities =
					this.sampleCollectionItemsRepository.findAllById(entity.getSampleDeliveryStaffsIds());
			entityToUpdate.setSampleDeliveryStaffs(Sets.newHashSet(sampleDeliveryStaffsEntities));
		}
		if (persistRelations && !entity.getSampleDeliveryStaffs().isEmpty()) {
			Set<SampleCollectionItemsEntity> updatedEntities = new HashSet<>();
			entity.getSampleDeliveryStaffs().forEach(model -> {
				if (model.getId() != null) {
					model = this.sampleCollectionItemsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSampleDeliveryStaffs(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getSampleProcessingStaffsIds().isEmpty() && entity.getSampleProcessingStaffs().isEmpty()) {
			entityToUpdate.setSampleProcessingStaffs(new HashSet<>());
		} else if (!entity.getSampleProcessingStaffsIds().isEmpty() && entity.getSampleProcessingStaffs().isEmpty()) {
			Iterable<SampleCollectionItemsEntity> sampleProcessingStaffsEntities =
					this.sampleCollectionItemsRepository.findAllById(entity.getSampleProcessingStaffsIds());
			entityToUpdate.setSampleProcessingStaffs(Sets.newHashSet(sampleProcessingStaffsEntities));
		}
		if (persistRelations && !entity.getSampleProcessingStaffs().isEmpty()) {
			Set<SampleCollectionItemsEntity> updatedEntities = new HashSet<>();
			entity.getSampleProcessingStaffs().forEach(model -> {
				if (model.getId() != null) {
					model = this.sampleCollectionItemsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSampleProcessingStaffs(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getSurgeonIds().isEmpty() && entity.getSurgeon().isEmpty()) {
			entityToUpdate.setSurgeon(new HashSet<>());
		} else if (!entity.getSurgeonIds().isEmpty() && entity.getSurgeon().isEmpty()) {
			Iterable<PreoperativeRecordsEntity> surgeonEntities =
					this.preoperativeRecordsRepository.findAllById(entity.getSurgeonIds());
			entityToUpdate.setSurgeon(Sets.newHashSet(surgeonEntities));
		}
		if (persistRelations && !entity.getSurgeon().isEmpty()) {
			Set<PreoperativeRecordsEntity> updatedEntities = new HashSet<>();
			entity.getSurgeon().forEach(model -> {
				if (model.getId() != null) {
					model = this.preoperativeRecordsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSurgeon(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getSurgicalMedicalTranscriberIds().isEmpty() && entity.getSurgicalMedicalTranscriber().isEmpty()) {
			entityToUpdate.setSurgicalMedicalTranscriber(new HashSet<>());
		} else if (!entity.getSurgicalMedicalTranscriberIds().isEmpty() && entity.getSurgicalMedicalTranscriber().isEmpty()) {
			Iterable<PreoperativeRecordsEntity> surgicalMedicalTranscriberEntities =
					this.preoperativeRecordsRepository.findAllById(entity.getSurgicalMedicalTranscriberIds());
			entityToUpdate.setSurgicalMedicalTranscriber(Sets.newHashSet(surgicalMedicalTranscriberEntities));
		}
		if (persistRelations && !entity.getSurgicalMedicalTranscriber().isEmpty()) {
			Set<PreoperativeRecordsEntity> updatedEntities = new HashSet<>();
			entity.getSurgicalMedicalTranscriber().forEach(model -> {
				if (model.getId() != null) {
					model = this.preoperativeRecordsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSurgicalMedicalTranscriber(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getSurgicalNurseIds().isEmpty() && entity.getSurgicalNurse().isEmpty()) {
			entityToUpdate.setSurgicalNurse(new HashSet<>());
		} else if (!entity.getSurgicalNurseIds().isEmpty() && entity.getSurgicalNurse().isEmpty()) {
			Iterable<PreoperativeRecordsEntity> surgicalNurseEntities =
					this.preoperativeRecordsRepository.findAllById(entity.getSurgicalNurseIds());
			entityToUpdate.setSurgicalNurse(Sets.newHashSet(surgicalNurseEntities));
		}
		if (persistRelations && !entity.getSurgicalNurse().isEmpty()) {
			Set<PreoperativeRecordsEntity> updatedEntities = new HashSet<>();
			entity.getSurgicalNurse().forEach(model -> {
				if (model.getId() != null) {
					model = this.preoperativeRecordsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSurgicalNurse(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getTransferOrderStockDetailsIds().isEmpty() && entity.getTransferOrderStockDetails().isEmpty()) {
			entityToUpdate.setTransferOrderStockDetails(new HashSet<>());
		} else if (!entity.getTransferOrderStockDetailsIds().isEmpty() && entity.getTransferOrderStockDetails().isEmpty()) {
			Iterable<TransferOrderStockDetailEntity> transferOrderStockDetailsEntities =
					this.transferOrderStockDetailRepository.findAllById(entity.getTransferOrderStockDetailsIds());
			entityToUpdate.setTransferOrderStockDetails(Sets.newHashSet(transferOrderStockDetailsEntities));
		}
		if (persistRelations && !entity.getTransferOrderStockDetails().isEmpty()) {
			Set<TransferOrderStockDetailEntity> updatedEntities = new HashSet<>();
			entity.getTransferOrderStockDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.transferOrderStockDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setTransferOrderStockDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getVaccinationOrdersIds().isEmpty() && entity.getVaccinationOrders().isEmpty()) {
			entityToUpdate.setVaccinationOrders(new HashSet<>());
		} else if (!entity.getVaccinationOrdersIds().isEmpty() && entity.getVaccinationOrders().isEmpty()) {
			Iterable<VaccinationOrderEntity> vaccinationOrdersEntities =
					this.vaccinationOrderRepository.findAllById(entity.getVaccinationOrdersIds());
			entityToUpdate.setVaccinationOrders(Sets.newHashSet(vaccinationOrdersEntities));
		}
		if (persistRelations && !entity.getVaccinationOrders().isEmpty()) {
			Set<VaccinationOrderEntity> updatedEntities = new HashSet<>();
			entity.getVaccinationOrders().forEach(model -> {
				if (model.getId() != null) {
					model = this.vaccinationOrderRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setVaccinationOrders(updatedEntities);
		}

		// Outgoing many to many reference
		if (entity.getServicesIds().isEmpty() && entity.getServices().isEmpty()) {
			entityToUpdate.setServices(new HashSet<>());
		} else if (!entity.getServicesIds().isEmpty() && entity.getServices().isEmpty()) {
			Iterable<ServiceEntity> servicesEntities =
					this.serviceRepository.findAllById(entity.getServicesIds());
			entityToUpdate.setServices(Sets.newHashSet(servicesEntities));
		}
		if (persistRelations && !entity.getServices().isEmpty()) {
			Set<ServiceEntity> updatedEntities = new HashSet<>();
			entity.getServices().forEach(model -> {
				if (model.getId() != null) {
					model = this.serviceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setServices(updatedEntities);
		}

		// % protected region % [Add any additional logic for update references after the main logic here] off begin
		// % protected region % [Add any additional logic for update references after the main logic here] end

		return entityToUpdate;
	}

	/**
	 * Validate the entity using database constraint checks as well as input constraint checks.
	 * Has the side effect of round trip requests to the database for constraints such as uniqueness.
	 * @param entity The entity to validate
	 * @throws ConstraintViolationException Throw ConstraintViolationException when entity is invalid
	 */
	public void validateEntity(StaffEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<StaffEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByStaffNumberOpt = this.findByStaffNumber(entity.getStaffNumber());
			if (entityByStaffNumberOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<StaffEntity>(
						"Staff Number",
						entity.getStaffNumber(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"StaffNumber"
				);
				errors.add(uniquenessViolation);
			}
		}
		// % protected region % [Add custom validation errors here] off begin
		// % protected region % [Add custom validation errors here] end

		if (!errors.isEmpty()) {
			throw new ConstraintViolationException(errors);
		}

		// % protected region % [Add any additional logic for validate entity after the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity after the main logic here] end
	}


	/**
	 * Get the sort as given by the sort by for the StaffEntity.
	 * This allows fore more advanced sorting algorithms and methods to be compiled and returned.
	 *
	 * In the case that a custom sort is provided, only a single sort is returned.
	 *
	 * @param sortBy Submitted sort by
	 * @return sortBy if simple, for custom sort return a QSort.by(QSort Method).
	 */
	private Sort getSort (Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for getSort here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getSort here] end
	{
		Iterator it = sortBy.iterator();

		while (it.hasNext()) {
			Sort.Order currentOrder = (Sort.Order)it.next();

			// % protected region % [Customise your sort method here by returning early] off begin
			// % protected region % [Customise your sort method here by returning early] end
		}
		return sortBy;
	}

	public Set<String> validateEntityRelations(StaffEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getAdministrationUserId() != null && this.administrationUserRepository.findById(entity.getAdministrationUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getAdministrationUserId() + " is not associated with a Administration User Entity");
		}

		if (entity.getCashierUserId() != null && this.cashierUserRepository.findById(entity.getCashierUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getCashierUserId() + " is not associated with a Cashier User Entity");
		}

		if (entity.getClaimUserId() != null && this.claimUserRepository.findById(entity.getClaimUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getClaimUserId() + " is not associated with a Claim User Entity");
		}

		if (entity.getDiagnosticSupportUserId() != null && this.diagnosticSupportUserRepository.findById(entity.getDiagnosticSupportUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getDiagnosticSupportUserId() + " is not associated with a Diagnostic Support User Entity");
		}

		if (entity.getDoctorUserId() != null && this.doctorUserRepository.findById(entity.getDoctorUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getDoctorUserId() + " is not associated with a Doctor User Entity");
		}

		if (entity.getFacilityUserId() != null && this.facilityUserRepository.findById(entity.getFacilityUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getFacilityUserId() + " is not associated with a Facility User Entity");
		}

		if (entity.getManagementUserId() != null && this.managementUserRepository.findById(entity.getManagementUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getManagementUserId() + " is not associated with a Management User Entity");
		}

		if (entity.getMedicalRecordUserId() != null && this.medicalRecordUserRepository.findById(entity.getMedicalRecordUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalRecordUserId() + " is not associated with a Medical Record user Entity");
		}

		if (entity.getMedicalTranscriberUserId() != null && this.medicalTranscriberUserRepository.findById(entity.getMedicalTranscriberUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalTranscriberUserId() + " is not associated with a Medical Transcriber User Entity");
		}

		if (entity.getNurseUserId() != null && this.nurseUserRepository.findById(entity.getNurseUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getNurseUserId() + " is not associated with a Nurse User Entity");
		}

		if (entity.getPharmacyUserId() != null && this.pharmacyUserRepository.findById(entity.getPharmacyUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getPharmacyUserId() + " is not associated with a Pharmacy User Entity");
		}

		if (entity.getPurchasingUserId() != null && this.purchasingUserRepository.findById(entity.getPurchasingUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getPurchasingUserId() + " is not associated with a Purchasing User Entity");
		}

		if (entity.getRegistrationUserId() != null && this.registrationUserRepository.findById(entity.getRegistrationUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getRegistrationUserId() + " is not associated with a Registration User Entity");
		}

		if (entity.getSystemAdminUserId() != null && this.systemAdminUserRepository.findById(entity.getSystemAdminUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getSystemAdminUserId() + " is not associated with a System Admin User Entity");
		}

		if (entity.getWarehouseUserId() != null && this.warehouseUserRepository.findById(entity.getWarehouseUserId()).isEmpty()) {
			errors.add("The UUID " + entity.getWarehouseUserId() + " is not associated with a Warehouse User Entity");
		}

		for (UUID id : entity.getAccompanyingConsentsIds()) {
			if (this.informedConsentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Informed Consent Entity");
			}
		}

		if (entity.getAdministratorId() != null && this.administratorRepository.findById(entity.getAdministratorId()).isEmpty()) {
			errors.add("The UUID " + entity.getAdministratorId() + " is not associated with a Administrator Entity");
		}

		for (UUID id : entity.getAmendmentDetailsIds()) {
			if (this.amendmentDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Amendment Detail Entity");
			}
		}

		for (UUID id : entity.getAnesthesiaMedicalTranscriberIds()) {
			if (this.preoperativeRecordsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Preoperative Records Entity");
			}
		}

		for (UUID id : entity.getAnesthesiologistIds()) {
			if (this.preoperativeRecordsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Preoperative Records Entity");
			}
		}

		for (UUID id : entity.getAnesthesiologyNurseIds()) {
			if (this.preoperativeRecordsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Preoperative Records Entity");
			}
		}

		if (entity.getBpjsDoctorMappingId() != null && this.bpjsDoctorMappingRepository.findById(entity.getBpjsDoctorMappingId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsDoctorMappingId() + " is not associated with a BPJS Doctor Mapping Entity");
		}

		for (UUID id : entity.getCashierStaffIds()) {
			if (this.cashReceiptRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Cash Receipt Entity");
			}
		}

		for (UUID id : entity.getCoTreatingDoctorsIds()) {
			if (this.coTreatingDoctorRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Co Treating Doctor Entity");
			}
		}

		for (UUID id : entity.getDailyCareCPPTsCreatedByStaffIds()) {
			if (this.dailyCareCPPTRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Daily Care CPPT Entity");
			}
		}

		for (UUID id : entity.getDailyCareCPPTsDoctorInChargeIds()) {
			if (this.dailyCareCPPTRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Daily Care CPPT Entity");
			}
		}

		for (UUID id : entity.getDailyCareCPPTsMedicalTranscriberIds()) {
			if (this.dailyCareCPPTRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Daily Care CPPT Entity");
			}
		}

		for (UUID id : entity.getDeliveryProgressesIds()) {
			if (this.deliveryProgressRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Delivery Progress Entity");
			}
		}

		for (UUID id : entity.getDiagnosticStaffExaminationSummariesIds()) {
			if (this.diagnosticStaffExaminationSummaryRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Diagnostic Staff Examination Summary Entity");
			}
		}

		for (UUID id : entity.getDismissalReferringStaffIds()) {
			if (this.registrationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Registration Entity");
			}
		}

		for (UUID id : entity.getDoctorSchedulesIds()) {
			if (this.doctorScheduleRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Doctor Schedule Entity");
			}
		}

		for (UUID id : entity.getDoctorOnExaminationIds()) {
			if (this.medicalExaminationRecordRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Examination Record Entity");
			}
		}

		for (UUID id : entity.getFluidBalanceDetailsIds()) {
			if (this.fluidBalanceDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Fluid Balance Detail Entity");
			}
		}

		for (UUID id : entity.getHemodialysisMonitoringsIds()) {
			if (this.hemodialysisMonitoringRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Hemodialysis Monitoring Entity");
			}
		}

		for (UUID id : entity.getHospitalBranchInformationsIds()) {
			if (this.hospitalBranchInformationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Hospital Branch Information Entity");
			}
		}

		for (UUID id : entity.getInformingConsentsIds()) {
			if (this.informedConsentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Informed Consent Entity");
			}
		}

		for (UUID id : entity.getInvoicesIds()) {
			if (this.invoiceRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Entity");
			}
		}

		for (UUID id : entity.getMcuPackageItemsIds()) {
			if (this.mcuPackageItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a MCU Package Item Entity");
			}
		}

		for (UUID id : entity.getMedicalCertificateDischargeResumesIds()) {
			if (this.medicalCertificateDischargeResumeRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Certificate  Discharge Resume Entity");
			}
		}

		for (UUID id : entity.getMedicalCertificateBirthsIds()) {
			if (this.medicalCertificateBirthRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Certificate Birth Entity");
			}
		}

		for (UUID id : entity.getMedicalCertificateHospitalizationsIds()) {
			if (this.medicalCertificateHospitalizationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Certificate Hospitalization Entity");
			}
		}

		for (UUID id : entity.getMedicalExaminationRecordDischargeSummarysIds()) {
			if (this.medicalExaminationRecordDischargeSummaryRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Examination Record Discharge Summary Entity");
			}
		}

		for (UUID id : entity.getMedicalRecordTranscriberIds()) {
			if (this.medicalExaminationRecordRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Examination Record Entity");
			}
		}

		for (UUID id : entity.getMedicalStaffOfMedicalAttendancesCertificateIds()) {
			if (this.medicalCertificateMedicalAttendanceRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Certificate Medical Attendance Entity");
			}
		}

		for (UUID id : entity.getMedicalStaffOfMentalHealthsIds()) {
			if (this.medicalCertificateMentalHealthRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Certificate Mental Health Entity");
			}
		}

		for (UUID id : entity.getMedicalStaffOfPhysicalHealthsIds()) {
			if (this.medicalCertificatePhysicalHealthRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Certificate Physical Health Entity");
			}
		}

		for (UUID id : entity.getMedicalStaffOfRestrictedWorksCertificateIds()) {
			if (this.medicalCertificateRestrictedWorkRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Certificate Restricted Work Entity");
			}
		}

		for (UUID id : entity.getMedicalStaffOfSickLeavesCertificateIds()) {
			if (this.medicalCertificateSickLeaveRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Certificate Sick Leave Entity");
			}
		}

		for (UUID id : entity.getMedicationAdministeredHisotriesIds()) {
			if (this.medicationAdministeredHistoryRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medication Administered History Entity");
			}
		}

		for (UUID id : entity.getMedicationHeadersIds()) {
			if (this.medicationHeaderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medication Header Entity");
			}
		}

		for (UUID id : entity.getMidwivesIds()) {
			if (this.deliveryMedicalExaminationRecordRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Delivery Medical Examination Record Entity");
			}
		}

		for (UUID id : entity.getNurseIds()) {
			if (this.medicalExaminationRecordRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Examination Record Entity");
			}
		}

		for (UUID id : entity.getNursingDetailSurgicalNursingIds()) {
			if (this.operatingTheaterMedicalExaminationRecordRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Operating Theater Medical Examination Record Entity");
			}
		}

		for (UUID id : entity.getNursingDetailsAnesthesiaNursingIds()) {
			if (this.operatingTheaterMedicalExaminationRecordRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Operating Theater Medical Examination Record Entity");
			}
		}

		if (entity.getPcareDokterId() != null && this.pcareDokterRepository.findById(entity.getPcareDokterId()).isEmpty()) {
			errors.add("The UUID " + entity.getPcareDokterId() + " is not associated with a PCare Dokter Entity");
		}

		for (UUID id : entity.getPatientConsentsIds()) {
			if (this.patientConsentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Patient Consent Entity");
			}
		}

		for (UUID id : entity.getPatientVitalInformationsIds()) {
			if (this.patientVitalInformationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Patient Vital Information Entity");
			}
		}

		for (UUID id : entity.getPediatricianInChargeIds()) {
			if (this.newbornDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Newborn Detail Entity");
			}
		}

		for (UUID id : entity.getPrescriptionHeadersIds()) {
			if (this.prescriptionHeaderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Prescription Header Entity");
			}
		}

		for (UUID id : entity.getProcessWorkflowLogsIds()) {
			if (this.processWorkflowRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Process Workflow Entity");
			}
		}

		for (UUID id : entity.getRegistrationsIds()) {
			if (this.registrationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Registration Entity");
			}
		}

		for (UUID id : entity.getRequestedByIds()) {
			if (this.registrationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Registration Entity");
			}
		}

		for (UUID id : entity.getRoomTransfersIds()) {
			if (this.roomTransferRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Room Transfer Entity");
			}
		}

		for (UUID id : entity.getSampleCollectionStaffsIds()) {
			if (this.sampleCollectionItemsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Sample Collection Items Entity");
			}
		}

		for (UUID id : entity.getSampleDeliveryStaffsIds()) {
			if (this.sampleCollectionItemsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Sample Collection Items Entity");
			}
		}

		for (UUID id : entity.getSampleProcessingStaffsIds()) {
			if (this.sampleCollectionItemsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Sample Collection Items Entity");
			}
		}

		if (entity.getServiceId() != null && this.serviceRepository.findById(entity.getServiceId()).isEmpty()) {
			errors.add("The UUID " + entity.getServiceId() + " is not associated with a Service Entity");
		}

		for (UUID id : entity.getServicesIds()) {
			if (this.serviceRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Service Entity");
			}
		}

		for (UUID id : entity.getSurgeonIds()) {
			if (this.preoperativeRecordsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Preoperative Records Entity");
			}
		}

		for (UUID id : entity.getSurgicalMedicalTranscriberIds()) {
			if (this.preoperativeRecordsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Preoperative Records Entity");
			}
		}

		for (UUID id : entity.getSurgicalNurseIds()) {
			if (this.preoperativeRecordsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Preoperative Records Entity");
			}
		}

		for (UUID id : entity.getTransferOrderStockDetailsIds()) {
			if (this.transferOrderStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Transfer Order Stock Detail Entity");
			}
		}

		for (UUID id : entity.getVaccinationOrdersIds()) {
			if (this.vaccinationOrderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Vaccination Order Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
