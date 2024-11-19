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
import kmsweb.repositories.RegistrationRepository;
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
import java.time.*;
import kmsweb.entities.BpjsPRBDetailEntity;
import kmsweb.repositories.BpjsPRBDetailRepository;
import kmsweb.entities.BpjsPcareRegistrationsEntity;
import kmsweb.repositories.BpjsPcareRegistrationsRepository;
import kmsweb.entities.BpjsSEPEntity;
import kmsweb.repositories.BpjsSEPRepository;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.entities.BedReserveEntity;
import kmsweb.repositories.BedReserveRepository;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.entities.DiagnosticExaminationResultsEntity;
import kmsweb.repositories.DiagnosticExaminationResultsRepository;
import kmsweb.entities.DiagnosticStaffExaminationSummaryEntity;
import kmsweb.repositories.DiagnosticStaffExaminationSummaryRepository;
import kmsweb.entities.ExaminationItemEntity;
import kmsweb.repositories.ExaminationItemRepository;
import kmsweb.entities.FluidBalanceDetailEntity;
import kmsweb.repositories.FluidBalanceDetailRepository;
import kmsweb.entities.HealthFacilityEntity;
import kmsweb.repositories.HealthFacilityRepository;
import kmsweb.entities.InformedConsentEntity;
import kmsweb.repositories.InformedConsentRepository;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
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
import kmsweb.entities.MedicalFeeEntity;
import kmsweb.repositories.MedicalFeeRepository;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.entities.PcareExaminationEntity;
import kmsweb.repositories.PcareExaminationRepository;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;
import kmsweb.entities.PatientVitalInformationEntity;
import kmsweb.repositories.PatientVitalInformationRepository;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.entities.SepEntity;
import kmsweb.repositories.SepRepository;
import kmsweb.entities.SampleCollectionInformationEntity;
import kmsweb.repositories.SampleCollectionInformationRepository;
import kmsweb.entities.ServiceEntity;
import kmsweb.repositories.ServiceRepository;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.entities.VaccinationOrderEntity;
import kmsweb.repositories.VaccinationOrderRepository;
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
public class RegistrationService extends AbstractService<RegistrationEntity, RegistrationRepository, RegistrationEntityAudit> {

	private final String[] referenceNamesInRegistrationEntity = {
		"bpjsPRBDetail",
		"bpjsPcareRegistrations",
		"bpjsSEP",
		"bedReserves",
		"diagnosticExaminationResults",
		"fluidBalanceDetails",
		"informedConsents",
		"invoiceItems",
		"medicalCertificateDischargeResume",
		"medicalCertificateBirth",
		"medicalCertificateHospitalization",
		"medicalCertificateMedicalAttendance",
		"medicalCertificateMentalHealth",
		"medicalCertificatePhysicalHealth",
		"medicalCertificateRestrictedWork",
		"medicalCertificateSickLeave",
		"medicalExaminationRecord",
		"medicalFees",
		"medicationHeaders",
		"pcareExamination",
		"patientVitalInformations",
		"prescriptionHeaders",
		"sep",
		"sampleCollectionInformations",
		"vaccinationOrders",
		"admissionICD10",
		"admissionICD9CM",
		"dismissalReferringFacility",
		"dismissalReferringStaff",
		"referringUnit",
		"referringFacility",
		"diagnosticStaffExaminationSummary",
		"bedFacility",
		"examinationItems",
		"patientVisit",
		"service",
		"staff",
		"requestedBy",
	};

	private AbstractFileService<FileEntity> fileService;

	private final BpjsPRBDetailRepository bpjsPRBDetailRepository;

	private final BpjsPcareRegistrationsRepository bpjsPcareRegistrationsRepository;

	private final BpjsSEPRepository bpjsSEPRepository;

	private final BedFacilityRepository bedFacilityRepository;

	private final BedReserveRepository bedReserveRepository;

	private final DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	private final DiagnosticExaminationResultsRepository diagnosticExaminationResultsRepository;

	private final DiagnosticStaffExaminationSummaryRepository diagnosticStaffExaminationSummaryRepository;

	private final ExaminationItemRepository examinationItemRepository;

	private final FluidBalanceDetailRepository fluidBalanceDetailRepository;

	private final HealthFacilityRepository healthFacilityRepository;

	private final InformedConsentRepository informedConsentRepository;

	private final InvoiceItemRepository invoiceItemRepository;

	private final MedicalCertificateDischargeResumeRepository medicalCertificateDischargeResumeRepository;

	private final MedicalCertificateBirthRepository medicalCertificateBirthRepository;

	private final MedicalCertificateHospitalizationRepository medicalCertificateHospitalizationRepository;

	private final MedicalCertificateMedicalAttendanceRepository medicalCertificateMedicalAttendanceRepository;

	private final MedicalCertificateMentalHealthRepository medicalCertificateMentalHealthRepository;

	private final MedicalCertificatePhysicalHealthRepository medicalCertificatePhysicalHealthRepository;

	private final MedicalCertificateRestrictedWorkRepository medicalCertificateRestrictedWorkRepository;

	private final MedicalCertificateSickLeaveRepository medicalCertificateSickLeaveRepository;

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private final MedicalFeeRepository medicalFeeRepository;

	private final MedicationHeaderRepository medicationHeaderRepository;

	private final PcareExaminationRepository pcareExaminationRepository;

	private final PatientVisitRepository patientVisitRepository;

	private final PatientVitalInformationRepository patientVitalInformationRepository;

	private final PrescriptionHeaderRepository prescriptionHeaderRepository;

	private final SepRepository sepRepository;

	private final SampleCollectionInformationRepository sampleCollectionInformationRepository;

	private final ServiceRepository serviceRepository;

	private final StaffRepository staffRepository;

	private final VaccinationOrderRepository vaccinationOrderRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public RegistrationService(
		// % protected region % [Add any additional constructor parameters here] off begin
		S3FileService s3FileService,
		// % protected region % [Add any additional constructor parameters here] end
		BpjsPRBDetailRepository bpjsPRBDetailRepository,
		BpjsPcareRegistrationsRepository bpjsPcareRegistrationsRepository,
		BpjsSEPRepository bpjsSEPRepository,
		BedFacilityRepository bedFacilityRepository,
		BedReserveRepository bedReserveRepository,
		DiagnosesAndProceduresRepository diagnosesAndProceduresRepository,
		DiagnosticExaminationResultsRepository diagnosticExaminationResultsRepository,
		DiagnosticStaffExaminationSummaryRepository diagnosticStaffExaminationSummaryRepository,
		ExaminationItemRepository examinationItemRepository,
		FluidBalanceDetailRepository fluidBalanceDetailRepository,
		HealthFacilityRepository healthFacilityRepository,
		InformedConsentRepository informedConsentRepository,
		InvoiceItemRepository invoiceItemRepository,
		MedicalCertificateDischargeResumeRepository medicalCertificateDischargeResumeRepository,
		MedicalCertificateBirthRepository medicalCertificateBirthRepository,
		MedicalCertificateHospitalizationRepository medicalCertificateHospitalizationRepository,
		MedicalCertificateMedicalAttendanceRepository medicalCertificateMedicalAttendanceRepository,
		MedicalCertificateMentalHealthRepository medicalCertificateMentalHealthRepository,
		MedicalCertificatePhysicalHealthRepository medicalCertificatePhysicalHealthRepository,
		MedicalCertificateRestrictedWorkRepository medicalCertificateRestrictedWorkRepository,
		MedicalCertificateSickLeaveRepository medicalCertificateSickLeaveRepository,
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		MedicalFeeRepository medicalFeeRepository,
		MedicationHeaderRepository medicationHeaderRepository,
		PcareExaminationRepository pcareExaminationRepository,
		PatientVisitRepository patientVisitRepository,
		PatientVitalInformationRepository patientVitalInformationRepository,
		PrescriptionHeaderRepository prescriptionHeaderRepository,
		SepRepository sepRepository,
		SampleCollectionInformationRepository sampleCollectionInformationRepository,
		ServiceRepository serviceRepository,
		StaffRepository staffRepository,
		VaccinationOrderRepository vaccinationOrderRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		RegistrationRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bpjsPRBDetailRepository = bpjsPRBDetailRepository;

		this.bpjsPcareRegistrationsRepository = bpjsPcareRegistrationsRepository;

		this.bpjsSEPRepository = bpjsSEPRepository;

		this.bedFacilityRepository = bedFacilityRepository;

		this.bedReserveRepository = bedReserveRepository;

		this.diagnosesAndProceduresRepository = diagnosesAndProceduresRepository;

		this.diagnosticExaminationResultsRepository = diagnosticExaminationResultsRepository;

		this.diagnosticStaffExaminationSummaryRepository = diagnosticStaffExaminationSummaryRepository;

		this.examinationItemRepository = examinationItemRepository;

		this.fluidBalanceDetailRepository = fluidBalanceDetailRepository;

		this.healthFacilityRepository = healthFacilityRepository;

		this.informedConsentRepository = informedConsentRepository;

		this.invoiceItemRepository = invoiceItemRepository;

		this.medicalCertificateDischargeResumeRepository = medicalCertificateDischargeResumeRepository;

		this.medicalCertificateBirthRepository = medicalCertificateBirthRepository;

		this.medicalCertificateHospitalizationRepository = medicalCertificateHospitalizationRepository;

		this.medicalCertificateMedicalAttendanceRepository = medicalCertificateMedicalAttendanceRepository;

		this.medicalCertificateMentalHealthRepository = medicalCertificateMentalHealthRepository;

		this.medicalCertificatePhysicalHealthRepository = medicalCertificatePhysicalHealthRepository;

		this.medicalCertificateRestrictedWorkRepository = medicalCertificateRestrictedWorkRepository;

		this.medicalCertificateSickLeaveRepository = medicalCertificateSickLeaveRepository;

		this.medicalExaminationRecordRepository = medicalExaminationRecordRepository;

		this.medicalFeeRepository = medicalFeeRepository;

		this.medicationHeaderRepository = medicationHeaderRepository;

		this.pcareExaminationRepository = pcareExaminationRepository;

		this.patientVisitRepository = patientVisitRepository;

		this.patientVitalInformationRepository = patientVitalInformationRepository;

		this.prescriptionHeaderRepository = prescriptionHeaderRepository;

		this.sepRepository = sepRepository;

		this.sampleCollectionInformationRepository = sampleCollectionInformationRepository;

		this.serviceRepository = serviceRepository;

		this.staffRepository = staffRepository;

		this.vaccinationOrderRepository = vaccinationOrderRepository;

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
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
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
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Registration Number.
	 *
	 * @param registrationNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Registration Number
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByRegistrationNumber(String registrationNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationNumber here] end
	{
		// % protected region % [Add any additional logic for findByRegistrationNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByRegistrationNumber before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByRegistrationNumber(registrationNumber));

		// % protected region % [Add any additional logic for findByRegistrationNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRegistrationNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Scheduled Date.
	 *
	 * @param scheduledDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Scheduled Date
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByScheduledDate(OffsetDateTime scheduledDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByScheduledDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByScheduledDate here] end
	{
		// % protected region % [Add any additional logic for findByScheduledDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByScheduledDate before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByScheduledDate(scheduledDate));

		// % protected region % [Add any additional logic for findByScheduledDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByScheduledDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Actual In Date.
	 *
	 * @param actualInDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Actual In Date
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByActualInDate(OffsetDateTime actualInDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByActualInDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByActualInDate here] end
	{
		// % protected region % [Add any additional logic for findByActualInDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByActualInDate before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByActualInDate(actualInDate));

		// % protected region % [Add any additional logic for findByActualInDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByActualInDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Date.
	 *
	 * @param dismissalDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Date
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByDismissalDate(OffsetDateTime dismissalDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalDate here] end
	{
		// % protected region % [Add any additional logic for findByDismissalDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByDismissalDate before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByDismissalDate(dismissalDate));

		// % protected region % [Add any additional logic for findByDismissalDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDismissalDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Type.
	 *
	 * @param dismissalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Type
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByDismissalType(String dismissalType)
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalType here] end
	{
		// % protected region % [Add any additional logic for findByDismissalType before the main body here] off begin
		// % protected region % [Add any additional logic for findByDismissalType before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByDismissalType(dismissalType));

		// % protected region % [Add any additional logic for findByDismissalType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDismissalType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Queue No.
	 *
	 * @param queueNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Queue No
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByQueueNo(Integer queueNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByQueueNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQueueNo here] end
	{
		// % protected region % [Add any additional logic for findByQueueNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByQueueNo before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByQueueNo(queueNo));

		// % protected region % [Add any additional logic for findByQueueNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQueueNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Duration.
	 *
	 * @param duration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Duration
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByDuration(Integer duration)
	// % protected region % [Add any throwables, implementations, or extensions for findByDuration here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDuration here] end
	{
		// % protected region % [Add any additional logic for findByDuration before the main body here] off begin
		// % protected region % [Add any additional logic for findByDuration before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByDuration(duration));

		// % protected region % [Add any additional logic for findByDuration before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDuration before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByTreatmentClass(String treatmentClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByTreatmentClass(treatmentClass));

		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Booked Treatment Class.
	 *
	 * @param bookedTreatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Booked Treatment Class
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByBookedTreatmentClass(String bookedTreatmentClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByBookedTreatmentClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBookedTreatmentClass here] end
	{
		// % protected region % [Add any additional logic for findByBookedTreatmentClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByBookedTreatmentClass before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByBookedTreatmentClass(bookedTreatmentClass));

		// % protected region % [Add any additional logic for findByBookedTreatmentClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBookedTreatmentClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Shift.
	 *
	 * @param shift the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Shift
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByShift(String shift)
	// % protected region % [Add any throwables, implementations, or extensions for findByShift here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByShift here] end
	{
		// % protected region % [Add any additional logic for findByShift before the main body here] off begin
		// % protected region % [Add any additional logic for findByShift before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByShift(shift));

		// % protected region % [Add any additional logic for findByShift before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByShift before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute CITO.
	 *
	 * @param cito the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute CITO
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByCito(Boolean cito)
	// % protected region % [Add any throwables, implementations, or extensions for findByCito here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCito here] end
	{
		// % protected region % [Add any additional logic for findByCito before the main body here] off begin
		// % protected region % [Add any additional logic for findByCito before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByCito(cito));

		// % protected region % [Add any additional logic for findByCito before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCito before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute One Day Care.
	 *
	 * @param oneDayCare the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute One Day Care
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByOneDayCare(Boolean oneDayCare)
	// % protected region % [Add any throwables, implementations, or extensions for findByOneDayCare here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOneDayCare here] end
	{
		// % protected region % [Add any additional logic for findByOneDayCare before the main body here] off begin
		// % protected region % [Add any additional logic for findByOneDayCare before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByOneDayCare(oneDayCare));

		// % protected region % [Add any additional logic for findByOneDayCare before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOneDayCare before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral.
	 *
	 * @param referral the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByReferral(Boolean referral)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferral here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferral here] end
	{
		// % protected region % [Add any additional logic for findByReferral before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferral before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByReferral(referral));

		// % protected region % [Add any additional logic for findByReferral before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferral before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Registration Status.
	 *
	 * @param registrationStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Registration Status
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByRegistrationStatus(String registrationStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationStatus here] end
	{
		// % protected region % [Add any additional logic for findByRegistrationStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByRegistrationStatus before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByRegistrationStatus(registrationStatus));

		// % protected region % [Add any additional logic for findByRegistrationStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRegistrationStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral Type.
	 *
	 * @param referralType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Type
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByReferralType(String referralType)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralType here] end
	{
		// % protected region % [Add any additional logic for findByReferralType before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralType before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByReferralType(referralType));

		// % protected region % [Add any additional logic for findByReferralType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Purpose.
	 *
	 * @param purpose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purpose
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByPurpose(String purpose)
	// % protected region % [Add any throwables, implementations, or extensions for findByPurpose here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPurpose here] end
	{
		// % protected region % [Add any additional logic for findByPurpose before the main body here] off begin
		// % protected region % [Add any additional logic for findByPurpose before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByPurpose(purpose));

		// % protected region % [Add any additional logic for findByPurpose before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPurpose before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral Notes.
	 *
	 * @param referralNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Notes
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByReferralNotes(String referralNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralNotes here] end
	{
		// % protected region % [Add any additional logic for findByReferralNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralNotes before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByReferralNotes(referralNotes));

		// % protected region % [Add any additional logic for findByReferralNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Admission Diagnosis.
	 *
	 * @param admissionDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Admission Diagnosis
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByAdmissionDiagnosis(String admissionDiagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdmissionDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdmissionDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByAdmissionDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdmissionDiagnosis before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByAdmissionDiagnosis(admissionDiagnosis));

		// % protected region % [Add any additional logic for findByAdmissionDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdmissionDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Uploaded Date Time.
	 *
	 * @param uploadedDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uploaded Date Time
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByUploadedDateTime(OffsetDateTime uploadedDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByUploadedDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUploadedDateTime here] end
	{
		// % protected region % [Add any additional logic for findByUploadedDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByUploadedDateTime before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByUploadedDateTime(uploadedDateTime));

		// % protected region % [Add any additional logic for findByUploadedDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUploadedDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Visit Status.
	 *
	 * @param visitStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Visit Status
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByVisitStatus(String visitStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVisitStatus here] end
	{
		// % protected region % [Add any additional logic for findByVisitStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByVisitStatus before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByVisitStatus(visitStatus));

		// % protected region % [Add any additional logic for findByVisitStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVisitStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Instruction.
	 *
	 * @param instruction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruction
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByInstruction(String instruction)
	// % protected region % [Add any throwables, implementations, or extensions for findByInstruction here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInstruction here] end
	{
		// % protected region % [Add any additional logic for findByInstruction before the main body here] off begin
		// % protected region % [Add any additional logic for findByInstruction before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByInstruction(instruction));

		// % protected region % [Add any additional logic for findByInstruction before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInstruction before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute is An Appointment.
	 *
	 * @param isAnAppointment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute is An Appointment
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByIsAnAppointment(Boolean isAnAppointment)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsAnAppointment here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsAnAppointment here] end
	{
		// % protected region % [Add any additional logic for findByIsAnAppointment before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsAnAppointment before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByIsAnAppointment(isAnAppointment));

		// % protected region % [Add any additional logic for findByIsAnAppointment before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsAnAppointment before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Referral Number.
	 *
	 * @param referralNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Referral Number
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByReferralNumber(String referralNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferralNumber here] end
	{
		// % protected region % [Add any additional logic for findByReferralNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferralNumber before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByReferralNumber(referralNumber));

		// % protected region % [Add any additional logic for findByReferralNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferralNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute kodepoli.
	 *
	 * @param kodepoli the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute kodepoli
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByKodepoli(String kodepoli)
	// % protected region % [Add any throwables, implementations, or extensions for findByKodepoli here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByKodepoli here] end
	{
		// % protected region % [Add any additional logic for findByKodepoli before the main body here] off begin
		// % protected region % [Add any additional logic for findByKodepoli before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByKodepoli(kodepoli));

		// % protected region % [Add any additional logic for findByKodepoli before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByKodepoli before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Death Certificate No.
	 *
	 * @param deathCertificateNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Death Certificate No
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByDeathCertificateNo(String deathCertificateNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByDeathCertificateNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDeathCertificateNo here] end
	{
		// % protected region % [Add any additional logic for findByDeathCertificateNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByDeathCertificateNo before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByDeathCertificateNo(deathCertificateNo));

		// % protected region % [Add any additional logic for findByDeathCertificateNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDeathCertificateNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Time Of Death.
	 *
	 * @param timeOfDeath the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Time Of Death
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByTimeOfDeath(OffsetDateTime timeOfDeath)
	// % protected region % [Add any throwables, implementations, or extensions for findByTimeOfDeath here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTimeOfDeath here] end
	{
		// % protected region % [Add any additional logic for findByTimeOfDeath before the main body here] off begin
		// % protected region % [Add any additional logic for findByTimeOfDeath before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByTimeOfDeath(timeOfDeath));

		// % protected region % [Add any additional logic for findByTimeOfDeath before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTimeOfDeath before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Referral.
	 *
	 * @param dismissalReferral the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Referral
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByDismissalReferral(Boolean dismissalReferral)
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalReferral here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalReferral here] end
	{
		// % protected region % [Add any additional logic for findByDismissalReferral before the main body here] off begin
		// % protected region % [Add any additional logic for findByDismissalReferral before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByDismissalReferral(dismissalReferral));

		// % protected region % [Add any additional logic for findByDismissalReferral before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDismissalReferral before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Referral Detail.
	 *
	 * @param dismissalReferralDetail the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Referral Detail
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByDismissalReferralDetail(String dismissalReferralDetail)
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalReferralDetail here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalReferralDetail here] end
	{
		// % protected region % [Add any additional logic for findByDismissalReferralDetail before the main body here] off begin
		// % protected region % [Add any additional logic for findByDismissalReferralDetail before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByDismissalReferralDetail(dismissalReferralDetail));

		// % protected region % [Add any additional logic for findByDismissalReferralDetail before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDismissalReferralDetail before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Referral Type.
	 *
	 * @param dismissalReferralType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Referral Type
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByDismissalReferralType(String dismissalReferralType)
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalReferralType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalReferralType here] end
	{
		// % protected region % [Add any additional logic for findByDismissalReferralType before the main body here] off begin
		// % protected region % [Add any additional logic for findByDismissalReferralType before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByDismissalReferralType(dismissalReferralType));

		// % protected region % [Add any additional logic for findByDismissalReferralType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDismissalReferralType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dismissal Referring Notes.
	 *
	 * @param dismissalReferringNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dismissal Referring Notes
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByDismissalReferringNotes(String dismissalReferringNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalReferringNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDismissalReferringNotes here] end
	{
		// % protected region % [Add any additional logic for findByDismissalReferringNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByDismissalReferringNotes before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByDismissalReferringNotes(dismissalReferringNotes));

		// % protected region % [Add any additional logic for findByDismissalReferringNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDismissalReferringNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Patient Is Referred Back.
	 *
	 * @param patientIsReferredBack the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Is Referred Back
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByPatientIsReferredBack(Boolean patientIsReferredBack)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientIsReferredBack here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientIsReferredBack here] end
	{
		// % protected region % [Add any additional logic for findByPatientIsReferredBack before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientIsReferredBack before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByPatientIsReferredBack(patientIsReferredBack));

		// % protected region % [Add any additional logic for findByPatientIsReferredBack before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientIsReferredBack before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute MCU Package.
	 *
	 * @param mcuPackage the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute MCU Package
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByMcuPackage(String mcuPackage)
	// % protected region % [Add any throwables, implementations, or extensions for findByMcuPackage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMcuPackage here] end
	{
		// % protected region % [Add any additional logic for findByMcuPackage before the main body here] off begin
		// % protected region % [Add any additional logic for findByMcuPackage before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByMcuPackage(mcuPackage));

		// % protected region % [Add any additional logic for findByMcuPackage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMcuPackage before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Parent Registration Number.
	 *
	 * @param parentRegistrationNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Parent Registration Number
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByParentRegistrationNumber(String parentRegistrationNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByParentRegistrationNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByParentRegistrationNumber here] end
	{
		// % protected region % [Add any additional logic for findByParentRegistrationNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByParentRegistrationNumber before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByParentRegistrationNumber(parentRegistrationNumber));

		// % protected region % [Add any additional logic for findByParentRegistrationNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByParentRegistrationNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is Unknown Patient.
	 *
	 * @param isUnknownPatient the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is Unknown Patient
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByIsUnknownPatient(Boolean isUnknownPatient)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsUnknownPatient here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsUnknownPatient here] end
	{
		// % protected region % [Add any additional logic for findByIsUnknownPatient before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsUnknownPatient before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByIsUnknownPatient(isUnknownPatient));

		// % protected region % [Add any additional logic for findByIsUnknownPatient before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsUnknownPatient before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Referred Facility.
	 *
	 * @param otherReferredFacility the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Referred Facility
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByOtherReferredFacility(String otherReferredFacility)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherReferredFacility here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherReferredFacility here] end
	{
		// % protected region % [Add any additional logic for findByOtherReferredFacility before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherReferredFacility before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByOtherReferredFacility(otherReferredFacility));

		// % protected region % [Add any additional logic for findByOtherReferredFacility before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherReferredFacility before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Referred Staff.
	 *
	 * @param otherReferredStaff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Referred Staff
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findByOtherReferredStaff(String otherReferredStaff)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherReferredStaff here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherReferredStaff here] end
	{
		// % protected region % [Add any additional logic for findByOtherReferredStaff before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherReferredStaff before the main body here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findByOtherReferredStaff(otherReferredStaff));

		// % protected region % [Add any additional logic for findByOtherReferredStaff before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherReferredStaff before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<RegistrationEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<RegistrationEntity> entity = repository.findById(id);

		entity.ifPresent(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<RegistrationEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RegistrationEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<RegistrationEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('RegistrationEntity', 'create')")
	public RegistrationEntity create(RegistrationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		RegistrationEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('RegistrationEntity', 'create')")
	public RegistrationEntity create(RegistrationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		RegistrationEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		RegistrationEntity newEntity;

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
	@PreAuthorize("hasPermission('RegistrationEntity', 'create')")
	public List<RegistrationEntity> createAll(Iterable<RegistrationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<RegistrationEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<RegistrationEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('RegistrationEntity', 'update')")
	public RegistrationEntity update(RegistrationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		RegistrationEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('RegistrationEntity', 'update')")
	public RegistrationEntity update(RegistrationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		RegistrationEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		RegistrationEntity newEntity;

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
	@PreAuthorize("hasPermission('RegistrationEntity', 'update')")
	public List<RegistrationEntity> updateAll(Iterable<RegistrationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<RegistrationEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<RegistrationEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('RegistrationEntity', 'create') or hasPermission('RegistrationEntity', 'update')")
	public RegistrationEntity save(RegistrationEntity entity) throws ConstraintViolationException
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

		RegistrationEntity newEntity = repository.save(entity);

		generateSignedFileUrls(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('RegistrationEntity', 'create') or hasPermission('RegistrationEntity', 'update')")
	public List<RegistrationEntity> saveAll(Iterable<RegistrationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<RegistrationEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('RegistrationEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('RegistrationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('RegistrationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	public List<RegistrationEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	public List<RegistrationEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<RegistrationEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(RegistrationEntity.class);

		// % protected region % [Add any additional processing before converting to a list of RegistrationEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of RegistrationEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<RegistrationEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of RegistrationEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of RegistrationEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(RegistrationEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of RegistrationEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of RegistrationEntityAudits
	 */
	private List<RegistrationEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<RegistrationEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param registration registration to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private RegistrationEntity updateAuditData(RegistrationEntity registration)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{

		registration.setSupportingDocument(new HashSet<>(registration.getSupportingDocument()));
		registration.setPrintWristband(new HashSet<>(registration.getPrintWristband()));
		registration.setPrintLabel(new HashSet<>(registration.getPrintLabel()));

		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return registration;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private RegistrationEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		RegistrationEntity entityAtRevision = updateAuditData((RegistrationEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new RegistrationEntityAudit(
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
	private void generateSignedFileUrls(RegistrationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for generateSignedFileUrls here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for generateSignedFileUrls here] end
	{
		Set<FileEntity> supportingDocument = entity.getSupportingDocument();

		for (FileEntity individualSupportingDocument : supportingDocument) {
			String url = fileService.generateUrl(individualSupportingDocument.getId());
			individualSupportingDocument.setUrl(url);
		}
		Set<FileEntity> printWristband = entity.getPrintWristband();

		for (FileEntity individualPrintWristband : printWristband) {
			String url = fileService.generateUrl(individualPrintWristband.getId());
			individualPrintWristband.setUrl(url);
		}
		Set<FileEntity> printLabel = entity.getPrintLabel();

		for (FileEntity individualPrintLabel : printLabel) {
			String url = fileService.generateUrl(individualPrintLabel.getId());
			individualPrintLabel.setUrl(url);
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

		QRegistrationEntity entity = QRegistrationEntity.registrationEntity;

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
			case "bpjsPRBDetailId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to BPJS PRB Detail here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to BPJS PRB Detail here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsPRBDetail.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to BPJS PRB Detail here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to BPJS PRB Detail here] end

				break;
			case "bpjsPcareRegistrationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to BPJS Pcare Registrations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to BPJS Pcare Registrations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsPcareRegistrations.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to BPJS Pcare Registrations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to BPJS Pcare Registrations here] end

				break;
			case "bpjsSEPId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to BPJS SEP here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to BPJS SEP here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsSEP.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to BPJS SEP here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to BPJS SEP here] end

				break;
			case "medicalCertificateDischargeResumeId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate  Discharge Resume here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate  Discharge Resume here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalCertificateDischargeResume.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate  Discharge Resume here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate  Discharge Resume here] end

				break;
			case "medicalCertificateBirthId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Birth here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Birth here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalCertificateBirth.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Birth here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Birth here] end

				break;
			case "medicalCertificateHospitalizationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Hospitalization here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Hospitalization here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalCertificateHospitalization.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Hospitalization here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Hospitalization here] end

				break;
			case "medicalCertificateMedicalAttendanceId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Medical Attendance here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Medical Attendance here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalCertificateMedicalAttendance.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Medical Attendance here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Medical Attendance here] end

				break;
			case "medicalCertificateMentalHealthId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Mental Health here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Mental Health here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalCertificateMentalHealth.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Mental Health here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Mental Health here] end

				break;
			case "medicalCertificatePhysicalHealthId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Physical Health here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Physical Health here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalCertificatePhysicalHealth.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Physical Health here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Physical Health here] end

				break;
			case "medicalCertificateRestrictedWorkId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Restricted Work here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Restricted Work here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalCertificateRestrictedWork.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Restricted Work here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Restricted Work here] end

				break;
			case "medicalCertificateSickLeaveId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Sick Leave here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate Sick Leave here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalCertificateSickLeave.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Sick Leave here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate Sick Leave here] end

				break;
			case "medicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Examination Record here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Examination Record here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Examination Record here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Examination Record here] end

				break;
			case "pcareExaminationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to PCare Examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to PCare Examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pcareExamination.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to PCare Examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to PCare Examination here] end

				break;
			case "sepId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to SEP here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to SEP here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sep.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to SEP here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to SEP here] end

				break;
			case "diagnosticStaffExaminationSummaryId":
				// % protected region % [Add any additional logic before the query parameters of relation from Diagnostic Staff Examination Summary to Registration here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Diagnostic Staff Examination Summary to Registration here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnosticStaffExaminationSummary.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Diagnostic Staff Examination Summary to Registration here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Diagnostic Staff Examination Summary to Registration here] end

				break;
			case "admissionICD10Id":
				// % protected region % [Add any additional logic before the query parameters of relation from Admission ICD 10 to Admission ICD 10 here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Admission ICD 10 to Admission ICD 10 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.admissionICD10.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Admission ICD 10 to Admission ICD 10 here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Admission ICD 10 to Admission ICD 10 here] end

				break;
			case "admissionICD9CMId":
				// % protected region % [Add any additional logic before the query parameters of relation from Admission ICD 9 CM to Admission ICD 9 CM here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Admission ICD 9 CM to Admission ICD 9 CM here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.admissionICD9CM.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Admission ICD 9 CM to Admission ICD 9 CM here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Admission ICD 9 CM to Admission ICD 9 CM here] end

				break;
			case "dismissalReferringFacilityId":
				// % protected region % [Add any additional logic before the query parameters of relation from Dismissal Referring Facility to Dismissal Referring Facility here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Dismissal Referring Facility to Dismissal Referring Facility here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dismissalReferringFacility.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Dismissal Referring Facility to Dismissal Referring Facility here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Dismissal Referring Facility to Dismissal Referring Facility here] end

				break;
			case "dismissalReferringStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Dismissal Referring Staff to Dismissal Referring Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Dismissal Referring Staff to Dismissal Referring Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dismissalReferringStaff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Dismissal Referring Staff to Dismissal Referring Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Dismissal Referring Staff to Dismissal Referring Staff here] end

				break;
			case "referringUnitId":
				// % protected region % [Add any additional logic before the query parameters of relation from Referring Unit to Referring Unit here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Referring Unit to Referring Unit here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referringUnit.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Referring Unit to Referring Unit here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Referring Unit to Referring Unit here] end

				break;
			case "referringFacilityId":
				// % protected region % [Add any additional logic before the query parameters of relation from Referring facility to Referring facility here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Referring facility to Referring facility here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referringFacility.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Referring facility to Referring facility here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Referring facility to Referring facility here] end

				break;
			case "bedFacilityId":
				// % protected region % [Add any additional logic before the query parameters of relation from Bed Facility to Registrations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Bed Facility to Registrations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bedFacility.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Bed Facility to Registrations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Bed Facility to Registrations here] end

				break;
			case "patientVisitId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Registrations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Registrations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientVisit.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Registrations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Registrations here] end

				break;
			case "serviceId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Registrations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service to Registrations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.service.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service to Registrations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service to Registrations here] end

				break;
			case "staffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Registrations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Registrations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Registrations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Registrations here] end

				break;
			case "requestedById":
				// % protected region % [Add any additional logic before the query parameters of relation from Requested By to Requested By here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Requested By to Requested By here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.requestedBy.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Requested By to Requested By here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Requested By to Requested By here] end

				break;
			case "bedReservesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Bed Reserves here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Bed Reserves here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bedReserves.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Bed Reserves here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Bed Reserves here] end

				break;
			case "diagnosticExaminationResultsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Diagnostic Examination Results here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Diagnostic Examination Results here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnosticExaminationResults.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Diagnostic Examination Results here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Diagnostic Examination Results here] end

				break;
			case "fluidBalanceDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Fluid Balance Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Fluid Balance Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.fluidBalanceDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Fluid Balance Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Fluid Balance Details here] end

				break;
			case "informedConsentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Informed Consents here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Informed Consents here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.informedConsents.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Informed Consents here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Informed Consents here] end

				break;
			case "invoiceItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service Number to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service Number to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service Number to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service Number to Invoice Items here] end

				break;
			case "medicalFeesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Fees here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Fees here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalFees.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Fees here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Fees here] end

				break;
			case "medicationHeadersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medication Headers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medication Headers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationHeaders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medication Headers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medication Headers here] end

				break;
			case "patientVitalInformationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Patient Vital Informations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Patient Vital Informations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientVitalInformations.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Patient Vital Informations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Patient Vital Informations here] end

				break;
			case "prescriptionHeadersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Prescription Headers here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Prescription Headers here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescriptionHeaders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Prescription Headers here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Prescription Headers here] end

				break;
			case "sampleCollectionInformationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Sample Collection Informations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Sample Collection Informations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sampleCollectionInformations.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Sample Collection Informations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Sample Collection Informations here] end

				break;
			case "vaccinationOrdersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Vaccination Orders here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Vaccination Orders here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.vaccinationOrders.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Vaccination Orders here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Vaccination Orders here] end

				break;
			case "examinationItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Items to Registrations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Items to Registrations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.examinationItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Examination Items to Registrations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Examination Items to Registrations here] end

				break;
			case "registrationNumber":
				// % protected region % [Add any additional logic before the query parameters of registrationNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of registrationNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registrationNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of registrationNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of registrationNumber here] end

				break;
			case "scheduledDate":
				// % protected region % [Add any additional logic before the query parameters of scheduledDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of scheduledDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.scheduledDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of scheduledDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of scheduledDate here] end

				break;
			case "queueNo":
				// % protected region % [Add any additional logic before the query parameters of queueNo here] off begin
				// % protected region % [Add any additional logic before the query parameters of queueNo here] end


				// % protected region % [Add any additional logic after the query parameters of queueNo here] off begin
				// % protected region % [Add any additional logic after the query parameters of queueNo here] end

				break;
			case "registrationStatus":
				// % protected region % [Add any additional logic before the query parameters of registrationStatus here] off begin
				// % protected region % [Add any additional logic before the query parameters of registrationStatus here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registrationStatus, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of registrationStatus here] off begin
				// % protected region % [Add any additional logic after the query parameters of registrationStatus here] end

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
	public RegistrationEntity updateOldData(RegistrationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public RegistrationEntity updateOldData(RegistrationEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		RegistrationEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInRegistrationEntity);


			// % protected region % [Add any additional logic for update before uploading files here] off begin
			// % protected region % [Add any additional logic for update before uploading files here] end

			Set<FileEntity> supportingDocumentFiles = entity.getSupportingDocument();

			// Delete any file that requires deletion.
			Set<FileEntity> supportingDocumentfilesToDelete = supportingDocumentFiles.stream()
					.filter(fileToDelete -> fileToDelete.getId() != null && fileToDelete.getDoDelete()) // Only delete valid existing files
					.filter(entityToUpdate::containsSupportingDocument) // Make sure that the files exist in the old entity before deleting them
					.collect(Collectors.toSet());

			supportingDocumentfilesToDelete.stream()
					.peek(entity::removeSupportingDocument) // Remove the deleted files from the entity itself.
					.map(FileEntity::getId)
					.forEach(fileService::delete);

			// Upload and merge the rest of the files together with the current files
			Set<FileEntity> supportingDocumentFilesToUpload = supportingDocumentFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null) // Only upload those files that we have not uploaded yet
					.collect(Collectors.toSet());

			fileService.uploadMultiple(supportingDocumentFilesToUpload).forEach(entity::addSupportingDocument);

			Set<FileEntity> printWristbandFiles = entity.getPrintWristband();

			// Delete any file that requires deletion.
			Set<FileEntity> printWristbandfilesToDelete = printWristbandFiles.stream()
					.filter(fileToDelete -> fileToDelete.getId() != null && fileToDelete.getDoDelete()) // Only delete valid existing files
					.filter(entityToUpdate::containsPrintWristband) // Make sure that the files exist in the old entity before deleting them
					.collect(Collectors.toSet());

			printWristbandfilesToDelete.stream()
					.peek(entity::removePrintWristband) // Remove the deleted files from the entity itself.
					.map(FileEntity::getId)
					.forEach(fileService::delete);

			// Upload and merge the rest of the files together with the current files
			Set<FileEntity> printWristbandFilesToUpload = printWristbandFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null) // Only upload those files that we have not uploaded yet
					.collect(Collectors.toSet());

			fileService.uploadMultiple(printWristbandFilesToUpload).forEach(entity::addPrintWristband);

			Set<FileEntity> printLabelFiles = entity.getPrintLabel();

			// Delete any file that requires deletion.
			Set<FileEntity> printLabelfilesToDelete = printLabelFiles.stream()
					.filter(fileToDelete -> fileToDelete.getId() != null && fileToDelete.getDoDelete()) // Only delete valid existing files
					.filter(entityToUpdate::containsPrintLabel) // Make sure that the files exist in the old entity before deleting them
					.collect(Collectors.toSet());

			printLabelfilesToDelete.stream()
					.peek(entity::removePrintLabel) // Remove the deleted files from the entity itself.
					.map(FileEntity::getId)
					.forEach(fileService::delete);

			// Upload and merge the rest of the files together with the current files
			Set<FileEntity> printLabelFilesToUpload = printLabelFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null) // Only upload those files that we have not uploaded yet
					.collect(Collectors.toSet());

			fileService.uploadMultiple(printLabelFilesToUpload).forEach(entity::addPrintLabel);
		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			Set<FileEntity> supportingDocumentFiles = entityToUpdate.getSupportingDocument();
			// Merge the rest of the files together
			Set<FileEntity> supportingDocumentFilesToUpload = supportingDocumentFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null)
					.collect(Collectors.toSet());

			entityToUpdate.clearAllSupportingDocument();
			fileService.uploadMultiple(supportingDocumentFilesToUpload).forEach(entity::addSupportingDocument);

			Set<FileEntity> printWristbandFiles = entityToUpdate.getPrintWristband();
			// Merge the rest of the files together
			Set<FileEntity> printWristbandFilesToUpload = printWristbandFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null)
					.collect(Collectors.toSet());

			entityToUpdate.clearAllPrintWristband();
			fileService.uploadMultiple(printWristbandFilesToUpload).forEach(entity::addPrintWristband);

			Set<FileEntity> printLabelFiles = entityToUpdate.getPrintLabel();
			// Merge the rest of the files together
			Set<FileEntity> printLabelFilesToUpload = printLabelFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null)
					.collect(Collectors.toSet());

			entityToUpdate.clearAllPrintLabel();
			fileService.uploadMultiple(printLabelFilesToUpload).forEach(entity::addPrintLabel);

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getCito() == null) {
			entityToUpdate.setCito(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getOneDayCare() == null) {
			entityToUpdate.setOneDayCare(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getReferral() == null) {
			entityToUpdate.setReferral(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsAnAppointment() == null) {
			entityToUpdate.setIsAnAppointment(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDismissalReferral() == null) {
			entityToUpdate.setDismissalReferral(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getPatientIsReferredBack() == null) {
			entityToUpdate.setPatientIsReferredBack(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsUnknownPatient() == null) {
			entityToUpdate.setIsUnknownPatient(false);
		}

		// Incoming One to One reference
		if (entity.getDiagnosticStaffExaminationSummary() == null && entity.getDiagnosticStaffExaminationSummaryId() == null) {
			entityToUpdate.unsetDiagnosticStaffExaminationSummary();
		} else if (entity.getDiagnosticStaffExaminationSummaryId() != null && entity.getDiagnosticStaffExaminationSummary() == null) {
			Optional<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummaryEntity = this.diagnosticStaffExaminationSummaryRepository.findById(entity.getDiagnosticStaffExaminationSummaryId());
			entityToUpdate.setDiagnosticStaffExaminationSummary(diagnosticStaffExaminationSummaryEntity.orElseThrow());
		}
		if (persistRelations && entity.getDiagnosticStaffExaminationSummary() != null) {
			entityToUpdate.setDiagnosticStaffExaminationSummary(entity.getDiagnosticStaffExaminationSummary(), false);
			if (entityToUpdate.getDiagnosticStaffExaminationSummaryId() != null) {
				this.diagnosticStaffExaminationSummaryRepository.save(entityToUpdate.getDiagnosticStaffExaminationSummary());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDiagnosticStaffExaminationSummary().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getBpjsPRBDetail() == null && entity.getBpjsPRBDetailId() == null) {
			entityToUpdate.unsetBpjsPRBDetail();
		} else if (entity.getBpjsPRBDetailId() != null && entity.getBpjsPRBDetail() == null) {
			Optional<BpjsPRBDetailEntity> bpjsPRBDetailEntity = this.bpjsPRBDetailRepository.findById(entity.getBpjsPRBDetailId());
			entityToUpdate.setBpjsPRBDetail(bpjsPRBDetailEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsPRBDetail() != null) {
			entityToUpdate.setBpjsPRBDetail(entity.getBpjsPRBDetail(), false);
			if (entityToUpdate.getBpjsPRBDetailId() != null) {
				this.bpjsPRBDetailRepository.save(entityToUpdate.getBpjsPRBDetail());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsPRBDetail().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getBpjsPcareRegistrations() == null && entity.getBpjsPcareRegistrationsId() == null) {
			entityToUpdate.unsetBpjsPcareRegistrations();
		} else if (entity.getBpjsPcareRegistrationsId() != null && entity.getBpjsPcareRegistrations() == null) {
			Optional<BpjsPcareRegistrationsEntity> bpjsPcareRegistrationsEntity = this.bpjsPcareRegistrationsRepository.findById(entity.getBpjsPcareRegistrationsId());
			entityToUpdate.setBpjsPcareRegistrations(bpjsPcareRegistrationsEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsPcareRegistrations() != null) {
			entityToUpdate.setBpjsPcareRegistrations(entity.getBpjsPcareRegistrations(), false);
			if (entityToUpdate.getBpjsPcareRegistrationsId() != null) {
				this.bpjsPcareRegistrationsRepository.save(entityToUpdate.getBpjsPcareRegistrations());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsPcareRegistrations().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getBpjsSEP() == null && entity.getBpjsSEPId() == null) {
			entityToUpdate.unsetBpjsSEP();
		} else if (entity.getBpjsSEPId() != null && entity.getBpjsSEP() == null) {
			Optional<BpjsSEPEntity> bpjsSEPEntity = this.bpjsSEPRepository.findById(entity.getBpjsSEPId());
			entityToUpdate.setBpjsSEP(bpjsSEPEntity.orElseThrow());
		}
		if (persistRelations && entity.getBpjsSEP() != null) {
			entityToUpdate.setBpjsSEP(entity.getBpjsSEP(), false);
			if (entityToUpdate.getBpjsSEPId() != null) {
				this.bpjsSEPRepository.save(entityToUpdate.getBpjsSEP());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBpjsSEP().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalCertificateDischargeResume() == null && entity.getMedicalCertificateDischargeResumeId() == null) {
			entityToUpdate.unsetMedicalCertificateDischargeResume();
		} else if (entity.getMedicalCertificateDischargeResumeId() != null && entity.getMedicalCertificateDischargeResume() == null) {
			Optional<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumeEntity = this.medicalCertificateDischargeResumeRepository.findById(entity.getMedicalCertificateDischargeResumeId());
			entityToUpdate.setMedicalCertificateDischargeResume(medicalCertificateDischargeResumeEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalCertificateDischargeResume() != null) {
			entityToUpdate.setMedicalCertificateDischargeResume(entity.getMedicalCertificateDischargeResume(), false);
			if (entityToUpdate.getMedicalCertificateDischargeResumeId() != null) {
				this.medicalCertificateDischargeResumeRepository.save(entityToUpdate.getMedicalCertificateDischargeResume());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalCertificateDischargeResume().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalCertificateBirth() == null && entity.getMedicalCertificateBirthId() == null) {
			entityToUpdate.unsetMedicalCertificateBirth();
		} else if (entity.getMedicalCertificateBirthId() != null && entity.getMedicalCertificateBirth() == null) {
			Optional<MedicalCertificateBirthEntity> medicalCertificateBirthEntity = this.medicalCertificateBirthRepository.findById(entity.getMedicalCertificateBirthId());
			entityToUpdate.setMedicalCertificateBirth(medicalCertificateBirthEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalCertificateBirth() != null) {
			entityToUpdate.setMedicalCertificateBirth(entity.getMedicalCertificateBirth(), false);
			if (entityToUpdate.getMedicalCertificateBirthId() != null) {
				this.medicalCertificateBirthRepository.save(entityToUpdate.getMedicalCertificateBirth());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalCertificateBirth().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalCertificateHospitalization() == null && entity.getMedicalCertificateHospitalizationId() == null) {
			entityToUpdate.unsetMedicalCertificateHospitalization();
		} else if (entity.getMedicalCertificateHospitalizationId() != null && entity.getMedicalCertificateHospitalization() == null) {
			Optional<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizationEntity = this.medicalCertificateHospitalizationRepository.findById(entity.getMedicalCertificateHospitalizationId());
			entityToUpdate.setMedicalCertificateHospitalization(medicalCertificateHospitalizationEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalCertificateHospitalization() != null) {
			entityToUpdate.setMedicalCertificateHospitalization(entity.getMedicalCertificateHospitalization(), false);
			if (entityToUpdate.getMedicalCertificateHospitalizationId() != null) {
				this.medicalCertificateHospitalizationRepository.save(entityToUpdate.getMedicalCertificateHospitalization());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalCertificateHospitalization().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalCertificateMedicalAttendance() == null && entity.getMedicalCertificateMedicalAttendanceId() == null) {
			entityToUpdate.unsetMedicalCertificateMedicalAttendance();
		} else if (entity.getMedicalCertificateMedicalAttendanceId() != null && entity.getMedicalCertificateMedicalAttendance() == null) {
			Optional<MedicalCertificateMedicalAttendanceEntity> medicalCertificateMedicalAttendanceEntity = this.medicalCertificateMedicalAttendanceRepository.findById(entity.getMedicalCertificateMedicalAttendanceId());
			entityToUpdate.setMedicalCertificateMedicalAttendance(medicalCertificateMedicalAttendanceEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalCertificateMedicalAttendance() != null) {
			entityToUpdate.setMedicalCertificateMedicalAttendance(entity.getMedicalCertificateMedicalAttendance(), false);
			if (entityToUpdate.getMedicalCertificateMedicalAttendanceId() != null) {
				this.medicalCertificateMedicalAttendanceRepository.save(entityToUpdate.getMedicalCertificateMedicalAttendance());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalCertificateMedicalAttendance().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalCertificateMentalHealth() == null && entity.getMedicalCertificateMentalHealthId() == null) {
			entityToUpdate.unsetMedicalCertificateMentalHealth();
		} else if (entity.getMedicalCertificateMentalHealthId() != null && entity.getMedicalCertificateMentalHealth() == null) {
			Optional<MedicalCertificateMentalHealthEntity> medicalCertificateMentalHealthEntity = this.medicalCertificateMentalHealthRepository.findById(entity.getMedicalCertificateMentalHealthId());
			entityToUpdate.setMedicalCertificateMentalHealth(medicalCertificateMentalHealthEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalCertificateMentalHealth() != null) {
			entityToUpdate.setMedicalCertificateMentalHealth(entity.getMedicalCertificateMentalHealth(), false);
			if (entityToUpdate.getMedicalCertificateMentalHealthId() != null) {
				this.medicalCertificateMentalHealthRepository.save(entityToUpdate.getMedicalCertificateMentalHealth());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalCertificateMentalHealth().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalCertificatePhysicalHealth() == null && entity.getMedicalCertificatePhysicalHealthId() == null) {
			entityToUpdate.unsetMedicalCertificatePhysicalHealth();
		} else if (entity.getMedicalCertificatePhysicalHealthId() != null && entity.getMedicalCertificatePhysicalHealth() == null) {
			Optional<MedicalCertificatePhysicalHealthEntity> medicalCertificatePhysicalHealthEntity = this.medicalCertificatePhysicalHealthRepository.findById(entity.getMedicalCertificatePhysicalHealthId());
			entityToUpdate.setMedicalCertificatePhysicalHealth(medicalCertificatePhysicalHealthEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalCertificatePhysicalHealth() != null) {
			entityToUpdate.setMedicalCertificatePhysicalHealth(entity.getMedicalCertificatePhysicalHealth(), false);
			if (entityToUpdate.getMedicalCertificatePhysicalHealthId() != null) {
				this.medicalCertificatePhysicalHealthRepository.save(entityToUpdate.getMedicalCertificatePhysicalHealth());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalCertificatePhysicalHealth().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalCertificateRestrictedWork() == null && entity.getMedicalCertificateRestrictedWorkId() == null) {
			entityToUpdate.unsetMedicalCertificateRestrictedWork();
		} else if (entity.getMedicalCertificateRestrictedWorkId() != null && entity.getMedicalCertificateRestrictedWork() == null) {
			Optional<MedicalCertificateRestrictedWorkEntity> medicalCertificateRestrictedWorkEntity = this.medicalCertificateRestrictedWorkRepository.findById(entity.getMedicalCertificateRestrictedWorkId());
			entityToUpdate.setMedicalCertificateRestrictedWork(medicalCertificateRestrictedWorkEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalCertificateRestrictedWork() != null) {
			entityToUpdate.setMedicalCertificateRestrictedWork(entity.getMedicalCertificateRestrictedWork(), false);
			if (entityToUpdate.getMedicalCertificateRestrictedWorkId() != null) {
				this.medicalCertificateRestrictedWorkRepository.save(entityToUpdate.getMedicalCertificateRestrictedWork());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalCertificateRestrictedWork().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalCertificateSickLeave() == null && entity.getMedicalCertificateSickLeaveId() == null) {
			entityToUpdate.unsetMedicalCertificateSickLeave();
		} else if (entity.getMedicalCertificateSickLeaveId() != null && entity.getMedicalCertificateSickLeave() == null) {
			Optional<MedicalCertificateSickLeaveEntity> medicalCertificateSickLeaveEntity = this.medicalCertificateSickLeaveRepository.findById(entity.getMedicalCertificateSickLeaveId());
			entityToUpdate.setMedicalCertificateSickLeave(medicalCertificateSickLeaveEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalCertificateSickLeave() != null) {
			entityToUpdate.setMedicalCertificateSickLeave(entity.getMedicalCertificateSickLeave(), false);
			if (entityToUpdate.getMedicalCertificateSickLeaveId() != null) {
				this.medicalCertificateSickLeaveRepository.save(entityToUpdate.getMedicalCertificateSickLeave());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalCertificateSickLeave().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getMedicalExaminationRecord() == null && entity.getMedicalExaminationRecordId() == null) {
			entityToUpdate.unsetMedicalExaminationRecord();
		} else if (entity.getMedicalExaminationRecordId() != null && entity.getMedicalExaminationRecord() == null) {
			Optional<MedicalExaminationRecordEntity> medicalExaminationRecordEntity = this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId());
			entityToUpdate.setMedicalExaminationRecord(medicalExaminationRecordEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalExaminationRecord() != null) {
			entityToUpdate.setMedicalExaminationRecord(entity.getMedicalExaminationRecord(), false);
			if (entityToUpdate.getMedicalExaminationRecordId() != null) {
				this.medicalExaminationRecordRepository.save(entityToUpdate.getMedicalExaminationRecord());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalExaminationRecord().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getPcareExamination() == null && entity.getPcareExaminationId() == null) {
			entityToUpdate.unsetPcareExamination();
		} else if (entity.getPcareExaminationId() != null && entity.getPcareExamination() == null) {
			Optional<PcareExaminationEntity> pcareExaminationEntity = this.pcareExaminationRepository.findById(entity.getPcareExaminationId());
			entityToUpdate.setPcareExamination(pcareExaminationEntity.orElseThrow());
		}
		if (persistRelations && entity.getPcareExamination() != null) {
			entityToUpdate.setPcareExamination(entity.getPcareExamination(), false);
			if (entityToUpdate.getPcareExaminationId() != null) {
				this.pcareExaminationRepository.save(entityToUpdate.getPcareExamination());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPcareExamination().unsetRegistration();
			}
		}

		// Outgoing one to one reference
		if (entity.getSep() == null && entity.getSepId() == null) {
			entityToUpdate.unsetSep();
		} else if (entity.getSepId() != null && entity.getSep() == null) {
			Optional<SepEntity> sepEntity = this.sepRepository.findById(entity.getSepId());
			entityToUpdate.setSep(sepEntity.orElseThrow());
		}
		if (persistRelations && entity.getSep() != null) {
			entityToUpdate.setSep(entity.getSep(), false);
			if (entityToUpdate.getSepId() != null) {
				this.sepRepository.save(entityToUpdate.getSep());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSep().unsetRegistration();
			}
		}

		// Incoming One to Many reference
		if (entity.getAdmissionICD10() == null && entity.getAdmissionICD10Id() == null) {
			entityToUpdate.unsetAdmissionICD10();
		} else if (entity.getAdmissionICD10Id() != null && entity.getAdmissionICD10() == null) {
			Optional<DiagnosesAndProceduresEntity> admissionICD10Entity = this.diagnosesAndProceduresRepository.findById(entity.getAdmissionICD10Id());
			entityToUpdate.setAdmissionICD10(admissionICD10Entity.orElseThrow());
		}
		if (persistRelations && entity.getAdmissionICD10() != null) {
			entityToUpdate.setAdmissionICD10(entity.getAdmissionICD10(), false);
			if (entityToUpdate.getAdmissionICD10Id() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getAdmissionICD10());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAdmissionICD10().unsetAdmissionICD10();
			}
		}

		// Incoming One to Many reference
		if (entity.getAdmissionICD9CM() == null && entity.getAdmissionICD9CMId() == null) {
			entityToUpdate.unsetAdmissionICD9CM();
		} else if (entity.getAdmissionICD9CMId() != null && entity.getAdmissionICD9CM() == null) {
			Optional<DiagnosesAndProceduresEntity> admissionICD9CMEntity = this.diagnosesAndProceduresRepository.findById(entity.getAdmissionICD9CMId());
			entityToUpdate.setAdmissionICD9CM(admissionICD9CMEntity.orElseThrow());
		}
		if (persistRelations && entity.getAdmissionICD9CM() != null) {
			entityToUpdate.setAdmissionICD9CM(entity.getAdmissionICD9CM(), false);
			if (entityToUpdate.getAdmissionICD9CMId() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getAdmissionICD9CM());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getAdmissionICD9CM().unsetAdmissionICD9CM();
			}
		}

		// Incoming One to Many reference
		if (entity.getDismissalReferringFacility() == null && entity.getDismissalReferringFacilityId() == null) {
			entityToUpdate.unsetDismissalReferringFacility();
		} else if (entity.getDismissalReferringFacilityId() != null && entity.getDismissalReferringFacility() == null) {
			Optional<HealthFacilityEntity> dismissalReferringFacilityEntity = this.healthFacilityRepository.findById(entity.getDismissalReferringFacilityId());
			entityToUpdate.setDismissalReferringFacility(dismissalReferringFacilityEntity.orElseThrow());
		}
		if (persistRelations && entity.getDismissalReferringFacility() != null) {
			entityToUpdate.setDismissalReferringFacility(entity.getDismissalReferringFacility(), false);
			if (entityToUpdate.getDismissalReferringFacilityId() != null) {
				this.healthFacilityRepository.save(entityToUpdate.getDismissalReferringFacility());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDismissalReferringFacility().unsetDismissalReferringFacility();
			}
		}

		// Incoming One to Many reference
		if (entity.getDismissalReferringStaff() == null && entity.getDismissalReferringStaffId() == null) {
			entityToUpdate.unsetDismissalReferringStaff();
		} else if (entity.getDismissalReferringStaffId() != null && entity.getDismissalReferringStaff() == null) {
			Optional<StaffEntity> dismissalReferringStaffEntity = this.staffRepository.findById(entity.getDismissalReferringStaffId());
			entityToUpdate.setDismissalReferringStaff(dismissalReferringStaffEntity.orElseThrow());
		}
		if (persistRelations && entity.getDismissalReferringStaff() != null) {
			entityToUpdate.setDismissalReferringStaff(entity.getDismissalReferringStaff(), false);
			if (entityToUpdate.getDismissalReferringStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getDismissalReferringStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDismissalReferringStaff().unsetDismissalReferringStaff();
			}
		}

		// Incoming One to Many reference
		if (entity.getReferringUnit() == null && entity.getReferringUnitId() == null) {
			entityToUpdate.unsetReferringUnit();
		} else if (entity.getReferringUnitId() != null && entity.getReferringUnit() == null) {
			Optional<ServiceEntity> referringUnitEntity = this.serviceRepository.findById(entity.getReferringUnitId());
			entityToUpdate.setReferringUnit(referringUnitEntity.orElseThrow());
		}
		if (persistRelations && entity.getReferringUnit() != null) {
			entityToUpdate.setReferringUnit(entity.getReferringUnit(), false);
			if (entityToUpdate.getReferringUnitId() != null) {
				this.serviceRepository.save(entityToUpdate.getReferringUnit());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getReferringUnit().unsetReferringUnit();
			}
		}

		// Incoming One to Many reference
		if (entity.getReferringFacility() == null && entity.getReferringFacilityId() == null) {
			entityToUpdate.unsetReferringFacility();
		} else if (entity.getReferringFacilityId() != null && entity.getReferringFacility() == null) {
			Optional<HealthFacilityEntity> referringFacilityEntity = this.healthFacilityRepository.findById(entity.getReferringFacilityId());
			entityToUpdate.setReferringFacility(referringFacilityEntity.orElseThrow());
		}
		if (persistRelations && entity.getReferringFacility() != null) {
			entityToUpdate.setReferringFacility(entity.getReferringFacility(), false);
			if (entityToUpdate.getReferringFacilityId() != null) {
				this.healthFacilityRepository.save(entityToUpdate.getReferringFacility());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getReferringFacility().unsetReferringFacility();
			}
		}

		// Incoming One to Many reference
		if (entity.getBedFacility() == null && entity.getBedFacilityId() == null) {
			entityToUpdate.unsetBedFacility();
		} else if (entity.getBedFacilityId() != null && entity.getBedFacility() == null) {
			Optional<BedFacilityEntity> bedFacilityEntity = this.bedFacilityRepository.findById(entity.getBedFacilityId());
			entityToUpdate.setBedFacility(bedFacilityEntity.orElseThrow());
		}
		if (persistRelations && entity.getBedFacility() != null) {
			entityToUpdate.setBedFacility(entity.getBedFacility(), false);
			if (entityToUpdate.getBedFacilityId() != null) {
				this.bedFacilityRepository.save(entityToUpdate.getBedFacility());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBedFacility().unsetRegistrations();
			}
		}

		// Incoming One to Many reference
		if (entity.getPatientVisit() == null && entity.getPatientVisitId() == null) {
			entityToUpdate.unsetPatientVisit();
		} else if (entity.getPatientVisitId() != null && entity.getPatientVisit() == null) {
			Optional<PatientVisitEntity> patientVisitEntity = this.patientVisitRepository.findById(entity.getPatientVisitId());
			entityToUpdate.setPatientVisit(patientVisitEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientVisit() != null) {
			entityToUpdate.setPatientVisit(entity.getPatientVisit(), false);
			if (entityToUpdate.getPatientVisitId() != null) {
				this.patientVisitRepository.save(entityToUpdate.getPatientVisit());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientVisit().unsetRegistrations();
			}
		}

		// Incoming One to Many reference
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
				entityToUpdate.getService().unsetRegistrations();
			}
		}

		// Incoming One to Many reference
		if (entity.getStaff() == null && entity.getStaffId() == null) {
			entityToUpdate.unsetStaff();
		} else if (entity.getStaffId() != null && entity.getStaff() == null) {
			Optional<StaffEntity> staffEntity = this.staffRepository.findById(entity.getStaffId());
			entityToUpdate.setStaff(staffEntity.orElseThrow());
		}
		if (persistRelations && entity.getStaff() != null) {
			entityToUpdate.setStaff(entity.getStaff(), false);
			if (entityToUpdate.getStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getStaff().unsetRegistrations();
			}
		}

		// Incoming One to Many reference
		if (entity.getRequestedBy() == null && entity.getRequestedById() == null) {
			entityToUpdate.unsetRequestedBy();
		} else if (entity.getRequestedById() != null && entity.getRequestedBy() == null) {
			Optional<StaffEntity> requestedByEntity = this.staffRepository.findById(entity.getRequestedById());
			entityToUpdate.setRequestedBy(requestedByEntity.orElseThrow());
		}
		if (persistRelations && entity.getRequestedBy() != null) {
			entityToUpdate.setRequestedBy(entity.getRequestedBy(), false);
			if (entityToUpdate.getRequestedById() != null) {
				this.staffRepository.save(entityToUpdate.getRequestedBy());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getRequestedBy().unsetRequestedBy();
			}
		}

		// Outgoing one to many reference
		if (entity.getBedReservesIds().isEmpty() && entity.getBedReserves().isEmpty()) {
			entityToUpdate.setBedReserves(new HashSet<>());
		} else if (!entity.getBedReservesIds().isEmpty() && entity.getBedReserves().isEmpty()) {
			Iterable<BedReserveEntity> bedReservesEntities =
					this.bedReserveRepository.findAllById(entity.getBedReservesIds());
			entityToUpdate.setBedReserves(Sets.newHashSet(bedReservesEntities));
		}
		if (persistRelations && !entity.getBedReserves().isEmpty()) {
			Set<BedReserveEntity> updatedEntities = new HashSet<>();
			entity.getBedReserves().forEach(model -> {
				if (model.getId() != null) {
					model = this.bedReserveRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBedReserves(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDiagnosticExaminationResultsIds().isEmpty() && entity.getDiagnosticExaminationResults().isEmpty()) {
			entityToUpdate.setDiagnosticExaminationResults(new HashSet<>());
		} else if (!entity.getDiagnosticExaminationResultsIds().isEmpty() && entity.getDiagnosticExaminationResults().isEmpty()) {
			Iterable<DiagnosticExaminationResultsEntity> diagnosticExaminationResultsEntities =
					this.diagnosticExaminationResultsRepository.findAllById(entity.getDiagnosticExaminationResultsIds());
			entityToUpdate.setDiagnosticExaminationResults(Sets.newHashSet(diagnosticExaminationResultsEntities));
		}
		if (persistRelations && !entity.getDiagnosticExaminationResults().isEmpty()) {
			Set<DiagnosticExaminationResultsEntity> updatedEntities = new HashSet<>();
			entity.getDiagnosticExaminationResults().forEach(model -> {
				if (model.getId() != null) {
					model = this.diagnosticExaminationResultsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDiagnosticExaminationResults(updatedEntities);
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
		if (entity.getInformedConsentsIds().isEmpty() && entity.getInformedConsents().isEmpty()) {
			entityToUpdate.setInformedConsents(new HashSet<>());
		} else if (!entity.getInformedConsentsIds().isEmpty() && entity.getInformedConsents().isEmpty()) {
			Iterable<InformedConsentEntity> informedConsentsEntities =
					this.informedConsentRepository.findAllById(entity.getInformedConsentsIds());
			entityToUpdate.setInformedConsents(Sets.newHashSet(informedConsentsEntities));
		}
		if (persistRelations && !entity.getInformedConsents().isEmpty()) {
			Set<InformedConsentEntity> updatedEntities = new HashSet<>();
			entity.getInformedConsents().forEach(model -> {
				if (model.getId() != null) {
					model = this.informedConsentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInformedConsents(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInvoiceItemsIds().isEmpty() && entity.getInvoiceItems().isEmpty()) {
			entityToUpdate.setInvoiceItems(new HashSet<>());
		} else if (!entity.getInvoiceItemsIds().isEmpty() && entity.getInvoiceItems().isEmpty()) {
			Iterable<InvoiceItemEntity> invoiceItemsEntities =
					this.invoiceItemRepository.findAllById(entity.getInvoiceItemsIds());
			entityToUpdate.setInvoiceItems(Sets.newHashSet(invoiceItemsEntities));
		}
		if (persistRelations && !entity.getInvoiceItems().isEmpty()) {
			Set<InvoiceItemEntity> updatedEntities = new HashSet<>();
			entity.getInvoiceItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.invoiceItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoiceItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicalFeesIds().isEmpty() && entity.getMedicalFees().isEmpty()) {
			entityToUpdate.setMedicalFees(new HashSet<>());
		} else if (!entity.getMedicalFeesIds().isEmpty() && entity.getMedicalFees().isEmpty()) {
			Iterable<MedicalFeeEntity> medicalFeesEntities =
					this.medicalFeeRepository.findAllById(entity.getMedicalFeesIds());
			entityToUpdate.setMedicalFees(Sets.newHashSet(medicalFeesEntities));
		}
		if (persistRelations && !entity.getMedicalFees().isEmpty()) {
			Set<MedicalFeeEntity> updatedEntities = new HashSet<>();
			entity.getMedicalFees().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicalFeeRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicalFees(updatedEntities);
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
		if (entity.getSampleCollectionInformationsIds().isEmpty() && entity.getSampleCollectionInformations().isEmpty()) {
			entityToUpdate.setSampleCollectionInformations(new HashSet<>());
		} else if (!entity.getSampleCollectionInformationsIds().isEmpty() && entity.getSampleCollectionInformations().isEmpty()) {
			Iterable<SampleCollectionInformationEntity> sampleCollectionInformationsEntities =
					this.sampleCollectionInformationRepository.findAllById(entity.getSampleCollectionInformationsIds());
			entityToUpdate.setSampleCollectionInformations(Sets.newHashSet(sampleCollectionInformationsEntities));
		}
		if (persistRelations && !entity.getSampleCollectionInformations().isEmpty()) {
			Set<SampleCollectionInformationEntity> updatedEntities = new HashSet<>();
			entity.getSampleCollectionInformations().forEach(model -> {
				if (model.getId() != null) {
					model = this.sampleCollectionInformationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setSampleCollectionInformations(updatedEntities);
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

		// Incoming many to many reference
		if (entity.getExaminationItemsIds().isEmpty() && entity.getExaminationItems().isEmpty()) {
			entityToUpdate.setExaminationItems(new HashSet<>());
		} else if (!entity.getExaminationItemsIds().isEmpty() && entity.getExaminationItems().isEmpty()) {
			Iterable<ExaminationItemEntity> examinationItemsEntities =
					this.examinationItemRepository.findAllById(entity.getExaminationItemsIds());
			entityToUpdate.setExaminationItems(Sets.newHashSet(examinationItemsEntities));
		}
		if (persistRelations && !entity.getExaminationItems().isEmpty()) {
			Set<ExaminationItemEntity> updatedEntities = new HashSet<>();
			entity.getExaminationItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.examinationItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setExaminationItems(updatedEntities);
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
	public void validateEntity(RegistrationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<RegistrationEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
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
	 * Get the sort as given by the sort by for the RegistrationEntity.
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

	public Set<String> validateEntityRelations(RegistrationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getAdmissionICD10Id() != null && this.diagnosesAndProceduresRepository.findById(entity.getAdmissionICD10Id()).isEmpty()) {
			errors.add("The UUID " + entity.getAdmissionICD10Id() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getAdmissionICD9CMId() != null && this.diagnosesAndProceduresRepository.findById(entity.getAdmissionICD9CMId()).isEmpty()) {
			errors.add("The UUID " + entity.getAdmissionICD9CMId() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getDismissalReferringFacilityId() != null && this.healthFacilityRepository.findById(entity.getDismissalReferringFacilityId()).isEmpty()) {
			errors.add("The UUID " + entity.getDismissalReferringFacilityId() + " is not associated with a Health Facility Entity");
		}

		if (entity.getDismissalReferringStaffId() != null && this.staffRepository.findById(entity.getDismissalReferringStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getDismissalReferringStaffId() + " is not associated with a Staff Entity");
		}

		if (entity.getReferringUnitId() != null && this.serviceRepository.findById(entity.getReferringUnitId()).isEmpty()) {
			errors.add("The UUID " + entity.getReferringUnitId() + " is not associated with a Service Entity");
		}

		if (entity.getReferringFacilityId() != null && this.healthFacilityRepository.findById(entity.getReferringFacilityId()).isEmpty()) {
			errors.add("The UUID " + entity.getReferringFacilityId() + " is not associated with a Health Facility Entity");
		}

		if (entity.getDiagnosticStaffExaminationSummaryId() != null && this.diagnosticStaffExaminationSummaryRepository.findById(entity.getDiagnosticStaffExaminationSummaryId()).isEmpty()) {
			errors.add("The UUID " + entity.getDiagnosticStaffExaminationSummaryId() + " is not associated with a Diagnostic Staff Examination Summary Entity");
		}

		if (entity.getBedFacilityId() != null && this.bedFacilityRepository.findById(entity.getBedFacilityId()).isEmpty()) {
			errors.add("The UUID " + entity.getBedFacilityId() + " is not associated with a Bed Facility Entity");
		}

		for (UUID id : entity.getExaminationItemsIds()) {
			if (this.examinationItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Examination Item Entity");
			}
		}

		if (entity.getPatientVisitId() != null && this.patientVisitRepository.findById(entity.getPatientVisitId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientVisitId() + " is not associated with a Patient Visit Entity");
		}

		if (entity.getServiceId() != null && this.serviceRepository.findById(entity.getServiceId()).isEmpty()) {
			errors.add("The UUID " + entity.getServiceId() + " is not associated with a Service Entity");
		}

		if (entity.getStaffId() != null && this.staffRepository.findById(entity.getStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getStaffId() + " is not associated with a Staff Entity");
		}

		if (entity.getRequestedById() != null && this.staffRepository.findById(entity.getRequestedById()).isEmpty()) {
			errors.add("The UUID " + entity.getRequestedById() + " is not associated with a Staff Entity");
		}

		if (entity.getBpjsPRBDetailId() != null && this.bpjsPRBDetailRepository.findById(entity.getBpjsPRBDetailId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsPRBDetailId() + " is not associated with a BPJS PRB Detail Entity");
		}

		if (entity.getBpjsPcareRegistrationsId() != null && this.bpjsPcareRegistrationsRepository.findById(entity.getBpjsPcareRegistrationsId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsPcareRegistrationsId() + " is not associated with a BPJS Pcare Registrations Entity");
		}

		if (entity.getBpjsSEPId() != null && this.bpjsSEPRepository.findById(entity.getBpjsSEPId()).isEmpty()) {
			errors.add("The UUID " + entity.getBpjsSEPId() + " is not associated with a BPJS SEP Entity");
		}

		for (UUID id : entity.getBedReservesIds()) {
			if (this.bedReserveRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Bed Reserve Entity");
			}
		}

		for (UUID id : entity.getDiagnosticExaminationResultsIds()) {
			if (this.diagnosticExaminationResultsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Diagnostic Examination Results Entity");
			}
		}

		for (UUID id : entity.getFluidBalanceDetailsIds()) {
			if (this.fluidBalanceDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Fluid Balance Detail Entity");
			}
		}

		for (UUID id : entity.getInformedConsentsIds()) {
			if (this.informedConsentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Informed Consent Entity");
			}
		}

		for (UUID id : entity.getInvoiceItemsIds()) {
			if (this.invoiceItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Item Entity");
			}
		}

		if (entity.getMedicalCertificateDischargeResumeId() != null && this.medicalCertificateDischargeResumeRepository.findById(entity.getMedicalCertificateDischargeResumeId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalCertificateDischargeResumeId() + " is not associated with a Medical Certificate  Discharge Resume Entity");
		}

		if (entity.getMedicalCertificateBirthId() != null && this.medicalCertificateBirthRepository.findById(entity.getMedicalCertificateBirthId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalCertificateBirthId() + " is not associated with a Medical Certificate Birth Entity");
		}

		if (entity.getMedicalCertificateHospitalizationId() != null && this.medicalCertificateHospitalizationRepository.findById(entity.getMedicalCertificateHospitalizationId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalCertificateHospitalizationId() + " is not associated with a Medical Certificate Hospitalization Entity");
		}

		if (entity.getMedicalCertificateMedicalAttendanceId() != null && this.medicalCertificateMedicalAttendanceRepository.findById(entity.getMedicalCertificateMedicalAttendanceId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalCertificateMedicalAttendanceId() + " is not associated with a Medical Certificate Medical Attendance Entity");
		}

		if (entity.getMedicalCertificateMentalHealthId() != null && this.medicalCertificateMentalHealthRepository.findById(entity.getMedicalCertificateMentalHealthId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalCertificateMentalHealthId() + " is not associated with a Medical Certificate Mental Health Entity");
		}

		if (entity.getMedicalCertificatePhysicalHealthId() != null && this.medicalCertificatePhysicalHealthRepository.findById(entity.getMedicalCertificatePhysicalHealthId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalCertificatePhysicalHealthId() + " is not associated with a Medical Certificate Physical Health Entity");
		}

		if (entity.getMedicalCertificateRestrictedWorkId() != null && this.medicalCertificateRestrictedWorkRepository.findById(entity.getMedicalCertificateRestrictedWorkId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalCertificateRestrictedWorkId() + " is not associated with a Medical Certificate Restricted Work Entity");
		}

		if (entity.getMedicalCertificateSickLeaveId() != null && this.medicalCertificateSickLeaveRepository.findById(entity.getMedicalCertificateSickLeaveId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalCertificateSickLeaveId() + " is not associated with a Medical Certificate Sick Leave Entity");
		}

		if (entity.getMedicalExaminationRecordId() != null && this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalExaminationRecordId() + " is not associated with a Medical Examination Record Entity");
		}

		for (UUID id : entity.getMedicalFeesIds()) {
			if (this.medicalFeeRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medical Fee Entity");
			}
		}

		for (UUID id : entity.getMedicationHeadersIds()) {
			if (this.medicationHeaderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medication Header Entity");
			}
		}

		if (entity.getPcareExaminationId() != null && this.pcareExaminationRepository.findById(entity.getPcareExaminationId()).isEmpty()) {
			errors.add("The UUID " + entity.getPcareExaminationId() + " is not associated with a PCare Examination Entity");
		}

		for (UUID id : entity.getPatientVitalInformationsIds()) {
			if (this.patientVitalInformationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Patient Vital Information Entity");
			}
		}

		for (UUID id : entity.getPrescriptionHeadersIds()) {
			if (this.prescriptionHeaderRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Prescription Header Entity");
			}
		}

		if (entity.getSepId() != null && this.sepRepository.findById(entity.getSepId()).isEmpty()) {
			errors.add("The UUID " + entity.getSepId() + " is not associated with a SEP Entity");
		}

		for (UUID id : entity.getSampleCollectionInformationsIds()) {
			if (this.sampleCollectionInformationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Sample Collection Information Entity");
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
