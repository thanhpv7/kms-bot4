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
import kmsweb.repositories.InvoiceRepository;
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
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.entities.InvoicePaymentInsuranceEntity;
import kmsweb.repositories.InvoicePaymentInsuranceRepository;
import kmsweb.entities.InvoicePaymentOtherEntity;
import kmsweb.repositories.InvoicePaymentOtherRepository;
import kmsweb.entities.InvoicePaymentSelfPayingEntity;
import kmsweb.repositories.InvoicePaymentSelfPayingRepository;
import kmsweb.entities.InvoiceSummaryEntity;
import kmsweb.repositories.InvoiceSummaryRepository;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.entities.TariffSchemaEntity;
import kmsweb.repositories.TariffSchemaRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class InvoiceService extends AbstractService<InvoiceEntity, InvoiceRepository, InvoiceEntityAudit> {

	private final String[] referenceNamesInInvoiceEntity = {
		"invoiceItems",
		"invoicePaymentInsurances",
		"invoicePaymentOther",
		"invoicePaymentSelfPaying",
		"invoiceSummary",
		"prescriptionHeader",
		"medicationHeader",
		"icd10",
		"icd9CM",
		"bedFacility",
		"patientVisit",
		"tariffSchema",
		"verifiedBy",
	};

	private final BedFacilityRepository bedFacilityRepository;

	private final DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	private final InvoiceItemRepository invoiceItemRepository;

	private final InvoicePaymentInsuranceRepository invoicePaymentInsuranceRepository;

	private final InvoicePaymentOtherRepository invoicePaymentOtherRepository;

	private final InvoicePaymentSelfPayingRepository invoicePaymentSelfPayingRepository;

	private final InvoiceSummaryRepository invoiceSummaryRepository;

	private final MedicationHeaderRepository medicationHeaderRepository;

	private final PatientVisitRepository patientVisitRepository;

	private final PrescriptionHeaderRepository prescriptionHeaderRepository;

	private final StaffRepository staffRepository;

	private final TariffSchemaRepository tariffSchemaRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InvoiceService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BedFacilityRepository bedFacilityRepository,
		DiagnosesAndProceduresRepository diagnosesAndProceduresRepository,
		InvoiceItemRepository invoiceItemRepository,
		InvoicePaymentInsuranceRepository invoicePaymentInsuranceRepository,
		InvoicePaymentOtherRepository invoicePaymentOtherRepository,
		InvoicePaymentSelfPayingRepository invoicePaymentSelfPayingRepository,
		InvoiceSummaryRepository invoiceSummaryRepository,
		MedicationHeaderRepository medicationHeaderRepository,
		PatientVisitRepository patientVisitRepository,
		PrescriptionHeaderRepository prescriptionHeaderRepository,
		StaffRepository staffRepository,
		TariffSchemaRepository tariffSchemaRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		InvoiceRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bedFacilityRepository = bedFacilityRepository;

		this.diagnosesAndProceduresRepository = diagnosesAndProceduresRepository;

		this.invoiceItemRepository = invoiceItemRepository;

		this.invoicePaymentInsuranceRepository = invoicePaymentInsuranceRepository;

		this.invoicePaymentOtherRepository = invoicePaymentOtherRepository;

		this.invoicePaymentSelfPayingRepository = invoicePaymentSelfPayingRepository;

		this.invoiceSummaryRepository = invoiceSummaryRepository;

		this.medicationHeaderRepository = medicationHeaderRepository;

		this.patientVisitRepository = patientVisitRepository;

		this.prescriptionHeaderRepository = prescriptionHeaderRepository;

		this.staffRepository = staffRepository;

		this.tariffSchemaRepository = tariffSchemaRepository;

		this.validator = validator;

		this.auditingRepository = auditingRepository;

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * Return the number of records available in the database.
	 *
	 * @return the number of records available in the database.
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
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
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Invoice Number.
	 *
	 * @param invoiceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Number
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByInvoiceNumber(String invoiceNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceNumber here] end
	{
		// % protected region % [Add any additional logic for findByInvoiceNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByInvoiceNumber before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByInvoiceNumber(invoiceNumber));

		// % protected region % [Add any additional logic for findByInvoiceNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInvoiceNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Revision Number.
	 *
	 * @param revisionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revision Number
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByRevisionNumber(Integer revisionNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByRevisionNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRevisionNumber here] end
	{
		// % protected region % [Add any additional logic for findByRevisionNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByRevisionNumber before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByRevisionNumber(revisionNumber));

		// % protected region % [Add any additional logic for findByRevisionNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRevisionNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Status.
	 *
	 * @param invoiceStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Status
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByInvoiceStatus(String invoiceStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceStatus here] end
	{
		// % protected region % [Add any additional logic for findByInvoiceStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByInvoiceStatus before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByInvoiceStatus(invoiceStatus));

		// % protected region % [Add any additional logic for findByInvoiceStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInvoiceStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Type.
	 *
	 * @param invoiceType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Type
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByInvoiceType(InvoiceTypeEnum invoiceType)
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceType here] end
	{
		// % protected region % [Add any additional logic for findByInvoiceType before the main body here] off begin
		// % protected region % [Add any additional logic for findByInvoiceType before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByInvoiceType(invoiceType));

		// % protected region % [Add any additional logic for findByInvoiceType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInvoiceType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Date.
	 *
	 * @param invoiceDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Date
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByInvoiceDate(OffsetDateTime invoiceDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceDate here] end
	{
		// % protected region % [Add any additional logic for findByInvoiceDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByInvoiceDate before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByInvoiceDate(invoiceDate));

		// % protected region % [Add any additional logic for findByInvoiceDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInvoiceDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Cancel Date.
	 *
	 * @param cancelDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Cancel Date
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByCancelDate(OffsetDateTime cancelDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByCancelDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCancelDate here] end
	{
		// % protected region % [Add any additional logic for findByCancelDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByCancelDate before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByCancelDate(cancelDate));

		// % protected region % [Add any additional logic for findByCancelDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCancelDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Billing Location.
	 *
	 * @param billingLocation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Billing Location
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByBillingLocation(String billingLocation)
	// % protected region % [Add any throwables, implementations, or extensions for findByBillingLocation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBillingLocation here] end
	{
		// % protected region % [Add any additional logic for findByBillingLocation before the main body here] off begin
		// % protected region % [Add any additional logic for findByBillingLocation before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByBillingLocation(billingLocation));

		// % protected region % [Add any additional logic for findByBillingLocation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBillingLocation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Patient Payment Type.
	 *
	 * @param patientPaymentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Payment Type
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByPatientPaymentType(String patientPaymentType)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientPaymentType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientPaymentType here] end
	{
		// % protected region % [Add any additional logic for findByPatientPaymentType before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientPaymentType before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByPatientPaymentType(patientPaymentType));

		// % protected region % [Add any additional logic for findByPatientPaymentType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientPaymentType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Verification Date.
	 *
	 * @param verificationDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Verification Date
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByVerificationDate(OffsetDateTime verificationDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByVerificationDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVerificationDate here] end
	{
		// % protected region % [Add any additional logic for findByVerificationDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByVerificationDate before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByVerificationDate(verificationDate));

		// % protected region % [Add any additional logic for findByVerificationDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVerificationDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Display Doctor on Print.
	 *
	 * @param displayDoctorOnPrint the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Display Doctor on Print
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByDisplayDoctorOnPrint(Boolean displayDoctorOnPrint)
	// % protected region % [Add any throwables, implementations, or extensions for findByDisplayDoctorOnPrint here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDisplayDoctorOnPrint here] end
	{
		// % protected region % [Add any additional logic for findByDisplayDoctorOnPrint before the main body here] off begin
		// % protected region % [Add any additional logic for findByDisplayDoctorOnPrint before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByDisplayDoctorOnPrint(displayDoctorOnPrint));

		// % protected region % [Add any additional logic for findByDisplayDoctorOnPrint before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDisplayDoctorOnPrint before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Display ICD 10 on Print.
	 *
	 * @param displayICD10OnPrint the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Display ICD 10 on Print
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByDisplayICD10OnPrint(Boolean displayICD10OnPrint)
	// % protected region % [Add any throwables, implementations, or extensions for findByDisplayICD10OnPrint here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDisplayICD10OnPrint here] end
	{
		// % protected region % [Add any additional logic for findByDisplayICD10OnPrint before the main body here] off begin
		// % protected region % [Add any additional logic for findByDisplayICD10OnPrint before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByDisplayICD10OnPrint(displayICD10OnPrint));

		// % protected region % [Add any additional logic for findByDisplayICD10OnPrint before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDisplayICD10OnPrint before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Display ICD 9 CM on Print.
	 *
	 * @param displayICD9CMOnPrint the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Display ICD 9 CM on Print
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByDisplayICD9CMOnPrint(Boolean displayICD9CMOnPrint)
	// % protected region % [Add any throwables, implementations, or extensions for findByDisplayICD9CMOnPrint here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDisplayICD9CMOnPrint here] end
	{
		// % protected region % [Add any additional logic for findByDisplayICD9CMOnPrint before the main body here] off begin
		// % protected region % [Add any additional logic for findByDisplayICD9CMOnPrint before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByDisplayICD9CMOnPrint(displayICD9CMOnPrint));

		// % protected region % [Add any additional logic for findByDisplayICD9CMOnPrint before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDisplayICD9CMOnPrint before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Doctor Code.
	 *
	 * @param doctorCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor Code
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByDoctorCode(String doctorCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDoctorCode here] end
	{
		// % protected region % [Add any additional logic for findByDoctorCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByDoctorCode before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByDoctorCode(doctorCode));

		// % protected region % [Add any additional logic for findByDoctorCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDoctorCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByTreatmentClass(String treatmentClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByTreatmentClass(treatmentClass));

		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Admission Date.
	 *
	 * @param admissionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Admission Date
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByAdmissionDate(OffsetDateTime admissionDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdmissionDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdmissionDate here] end
	{
		// % protected region % [Add any additional logic for findByAdmissionDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdmissionDate before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByAdmissionDate(admissionDate));

		// % protected region % [Add any additional logic for findByAdmissionDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdmissionDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Discharged Date.
	 *
	 * @param dischargedDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discharged Date
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByDischargedDate(OffsetDateTime dischargedDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByDischargedDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDischargedDate here] end
	{
		// % protected region % [Add any additional logic for findByDischargedDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByDischargedDate before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByDischargedDate(dischargedDate));

		// % protected region % [Add any additional logic for findByDischargedDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDischargedDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Claim No.
	 *
	 * @param claimNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim No
	 */
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findByClaimNo(String claimNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimNo here] end
	{
		// % protected region % [Add any additional logic for findByClaimNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByClaimNo before the main body here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findByClaimNo(claimNo));

		// % protected region % [Add any additional logic for findByClaimNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByClaimNo before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<InvoiceEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<InvoiceEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<InvoiceEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InvoiceEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<InvoiceEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InvoiceEntity', 'create')")
	public InvoiceEntity create(InvoiceEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		InvoiceEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InvoiceEntity', 'create')")
	public InvoiceEntity create(InvoiceEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		InvoiceEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		InvoiceEntity newEntity;

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
	@PreAuthorize("hasPermission('InvoiceEntity', 'create')")
	public List<InvoiceEntity> createAll(Iterable<InvoiceEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<InvoiceEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<InvoiceEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InvoiceEntity', 'update')")
	public InvoiceEntity update(InvoiceEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		InvoiceEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InvoiceEntity', 'update')")
	public InvoiceEntity update(InvoiceEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		InvoiceEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		InvoiceEntity newEntity;

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
	@PreAuthorize("hasPermission('InvoiceEntity', 'update')")
	public List<InvoiceEntity> updateAll(Iterable<InvoiceEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<InvoiceEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<InvoiceEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceEntity', 'create') or hasPermission('InvoiceEntity', 'update')")
	public InvoiceEntity save(InvoiceEntity entity) throws ConstraintViolationException
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

		InvoiceEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceEntity', 'create') or hasPermission('InvoiceEntity', 'update')")
	public List<InvoiceEntity> saveAll(Iterable<InvoiceEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<InvoiceEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InvoiceEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	public List<InvoiceEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	public List<InvoiceEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InvoiceEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(InvoiceEntity.class);

		// % protected region % [Add any additional processing before converting to a list of InvoiceEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of InvoiceEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InvoiceEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of InvoiceEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of InvoiceEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(InvoiceEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of InvoiceEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of InvoiceEntityAudits
	 */
	private List<InvoiceEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<InvoiceEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param invoice invoice to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private InvoiceEntity updateAuditData(InvoiceEntity invoice)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return invoice;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private InvoiceEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		InvoiceEntity entityAtRevision = updateAuditData((InvoiceEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new InvoiceEntityAudit(
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

		QInvoiceEntity entity = QInvoiceEntity.invoiceEntity;

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
			case "invoicePaymentOtherId":
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Payment Other here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Payment Other here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoicePaymentOther.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Payment Other here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Payment Other here] end

				break;
			case "invoicePaymentSelfPayingId":
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Payment Self Paying here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Payment Self Paying here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoicePaymentSelfPaying.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Payment Self Paying here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Payment Self Paying here] end

				break;
			case "invoiceSummaryId":
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Summary here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Summary here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceSummary.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Summary here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Summary here] end

				break;
			case "prescriptionHeaderId":
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Prescription Header here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Prescription Header here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescriptionHeader.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Prescription Header here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Prescription Header here] end

				break;
			case "medicationHeaderId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Header to Invoice here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Header to Invoice here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationHeader.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medication Header to Invoice here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medication Header to Invoice here] end

				break;
			case "icd10Id":
				// % protected region % [Add any additional logic before the query parameters of relation from ICD 10 to Invoices ICD 10 here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from ICD 10 to Invoices ICD 10 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.icd10.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from ICD 10 to Invoices ICD 10 here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from ICD 10 to Invoices ICD 10 here] end

				break;
			case "icd9CMId":
				// % protected region % [Add any additional logic before the query parameters of relation from ICD 9 CM to Invoices ICD 9 CM here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from ICD 9 CM to Invoices ICD 9 CM here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.icd9CM.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from ICD 9 CM to Invoices ICD 9 CM here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from ICD 9 CM to Invoices ICD 9 CM here] end

				break;
			case "bedFacilityId":
				// % protected region % [Add any additional logic before the query parameters of relation from Bed Facility to Invoices here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Bed Facility to Invoices here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bedFacility.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Bed Facility to Invoices here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Bed Facility to Invoices here] end

				break;
			case "patientVisitId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Invoices here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient Visit to Invoices here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientVisit.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Invoices here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient Visit to Invoices here] end

				break;
			case "tariffSchemaId":
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Schema to Invoices here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Schema to Invoices here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tariffSchema.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Schema to Invoices here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Schema to Invoices here] end

				break;
			case "verifiedById":
				// % protected region % [Add any additional logic before the query parameters of relation from Verified By to Invoices here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Verified By to Invoices here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.verifiedBy.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Verified By to Invoices here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Verified By to Invoices here] end

				break;
			case "invoiceItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Items here] end

				break;
			case "invoicePaymentInsurancesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Payment Insurances here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Invoice to Invoice Payment Insurances here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoicePaymentInsurances.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Payment Insurances here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Invoice to Invoice Payment Insurances here] end

				break;
			case "invoiceNumber":
				// % protected region % [Add any additional logic before the query parameters of invoiceNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of invoiceNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of invoiceNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of invoiceNumber here] end

				break;
			case "invoiceType":
				// % protected region % [Add any additional logic before the query parameters of invoiceType here] off begin
				// % protected region % [Add any additional logic before the query parameters of invoiceType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceType, InvoiceTypeEnum.class, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of invoiceType here] off begin
				// % protected region % [Add any additional logic after the query parameters of invoiceType here] end

				break;
			case "invoiceDate":
				// % protected region % [Add any additional logic before the query parameters of invoiceDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of invoiceDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of invoiceDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of invoiceDate here] end

				break;
			case "billingLocation":
				// % protected region % [Add any additional logic before the query parameters of billingLocation here] off begin
				// % protected region % [Add any additional logic before the query parameters of billingLocation here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.billingLocation, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of billingLocation here] off begin
				// % protected region % [Add any additional logic after the query parameters of billingLocation here] end

				break;
			case "patientPaymentType":
				// % protected region % [Add any additional logic before the query parameters of patientPaymentType here] off begin
				// % protected region % [Add any additional logic before the query parameters of patientPaymentType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientPaymentType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of patientPaymentType here] off begin
				// % protected region % [Add any additional logic after the query parameters of patientPaymentType here] end

				break;
			case "verificationDate":
				// % protected region % [Add any additional logic before the query parameters of verificationDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of verificationDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.verificationDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of verificationDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of verificationDate here] end

				break;
			case "doctorCode":
				// % protected region % [Add any additional logic before the query parameters of doctorCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of doctorCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.doctorCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of doctorCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of doctorCode here] end

				break;
			case "treatmentClass":
				// % protected region % [Add any additional logic before the query parameters of treatmentClass here] off begin
				// % protected region % [Add any additional logic before the query parameters of treatmentClass here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.treatmentClass, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of treatmentClass here] off begin
				// % protected region % [Add any additional logic after the query parameters of treatmentClass here] end

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
	public InvoiceEntity updateOldData(InvoiceEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public InvoiceEntity updateOldData(InvoiceEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		InvoiceEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInInvoiceEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDisplayDoctorOnPrint() == null) {
			entityToUpdate.setDisplayDoctorOnPrint(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDisplayICD10OnPrint() == null) {
			entityToUpdate.setDisplayICD10OnPrint(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDisplayICD9CMOnPrint() == null) {
			entityToUpdate.setDisplayICD9CMOnPrint(false);
		}

		// Incoming One to One reference
		if (entity.getMedicationHeader() == null && entity.getMedicationHeaderId() == null) {
			entityToUpdate.unsetMedicationHeader();
		} else if (entity.getMedicationHeaderId() != null && entity.getMedicationHeader() == null) {
			Optional<MedicationHeaderEntity> medicationHeaderEntity = this.medicationHeaderRepository.findById(entity.getMedicationHeaderId());
			entityToUpdate.setMedicationHeader(medicationHeaderEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicationHeader() != null) {
			entityToUpdate.setMedicationHeader(entity.getMedicationHeader(), false);
			if (entityToUpdate.getMedicationHeaderId() != null) {
				this.medicationHeaderRepository.save(entityToUpdate.getMedicationHeader());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicationHeader().unsetInvoice();
			}
		}

		// Outgoing one to one reference
		if (entity.getInvoicePaymentOther() == null && entity.getInvoicePaymentOtherId() == null) {
			entityToUpdate.unsetInvoicePaymentOther();
		} else if (entity.getInvoicePaymentOtherId() != null && entity.getInvoicePaymentOther() == null) {
			Optional<InvoicePaymentOtherEntity> invoicePaymentOtherEntity = this.invoicePaymentOtherRepository.findById(entity.getInvoicePaymentOtherId());
			entityToUpdate.setInvoicePaymentOther(invoicePaymentOtherEntity.orElseThrow());
		}
		if (persistRelations && entity.getInvoicePaymentOther() != null) {
			entityToUpdate.setInvoicePaymentOther(entity.getInvoicePaymentOther(), false);
			if (entityToUpdate.getInvoicePaymentOtherId() != null) {
				this.invoicePaymentOtherRepository.save(entityToUpdate.getInvoicePaymentOther());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getInvoicePaymentOther().unsetInvoice();
			}
		}

		// Outgoing one to one reference
		if (entity.getInvoicePaymentSelfPaying() == null && entity.getInvoicePaymentSelfPayingId() == null) {
			entityToUpdate.unsetInvoicePaymentSelfPaying();
		} else if (entity.getInvoicePaymentSelfPayingId() != null && entity.getInvoicePaymentSelfPaying() == null) {
			Optional<InvoicePaymentSelfPayingEntity> invoicePaymentSelfPayingEntity = this.invoicePaymentSelfPayingRepository.findById(entity.getInvoicePaymentSelfPayingId());
			entityToUpdate.setInvoicePaymentSelfPaying(invoicePaymentSelfPayingEntity.orElseThrow());
		}
		if (persistRelations && entity.getInvoicePaymentSelfPaying() != null) {
			entityToUpdate.setInvoicePaymentSelfPaying(entity.getInvoicePaymentSelfPaying(), false);
			if (entityToUpdate.getInvoicePaymentSelfPayingId() != null) {
				this.invoicePaymentSelfPayingRepository.save(entityToUpdate.getInvoicePaymentSelfPaying());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getInvoicePaymentSelfPaying().unsetInvoice();
			}
		}

		// Outgoing one to one reference
		if (entity.getInvoiceSummary() == null && entity.getInvoiceSummaryId() == null) {
			entityToUpdate.unsetInvoiceSummary();
		} else if (entity.getInvoiceSummaryId() != null && entity.getInvoiceSummary() == null) {
			Optional<InvoiceSummaryEntity> invoiceSummaryEntity = this.invoiceSummaryRepository.findById(entity.getInvoiceSummaryId());
			entityToUpdate.setInvoiceSummary(invoiceSummaryEntity.orElseThrow());
		}
		if (persistRelations && entity.getInvoiceSummary() != null) {
			entityToUpdate.setInvoiceSummary(entity.getInvoiceSummary(), false);
			if (entityToUpdate.getInvoiceSummaryId() != null) {
				this.invoiceSummaryRepository.save(entityToUpdate.getInvoiceSummary());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getInvoiceSummary().unsetInvoice();
			}
		}

		// Outgoing one to one reference
		if (entity.getPrescriptionHeader() == null && entity.getPrescriptionHeaderId() == null) {
			entityToUpdate.unsetPrescriptionHeader();
		} else if (entity.getPrescriptionHeaderId() != null && entity.getPrescriptionHeader() == null) {
			Optional<PrescriptionHeaderEntity> prescriptionHeaderEntity = this.prescriptionHeaderRepository.findById(entity.getPrescriptionHeaderId());
			entityToUpdate.setPrescriptionHeader(prescriptionHeaderEntity.orElseThrow());
		}
		if (persistRelations && entity.getPrescriptionHeader() != null) {
			entityToUpdate.setPrescriptionHeader(entity.getPrescriptionHeader(), false);
			if (entityToUpdate.getPrescriptionHeaderId() != null) {
				this.prescriptionHeaderRepository.save(entityToUpdate.getPrescriptionHeader());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPrescriptionHeader().unsetInvoice();
			}
		}

		// Incoming One to Many reference
		if (entity.getIcd10() == null && entity.getIcd10Id() == null) {
			entityToUpdate.unsetIcd10();
		} else if (entity.getIcd10Id() != null && entity.getIcd10() == null) {
			Optional<DiagnosesAndProceduresEntity> icd10Entity = this.diagnosesAndProceduresRepository.findById(entity.getIcd10Id());
			entityToUpdate.setIcd10(icd10Entity.orElseThrow());
		}
		if (persistRelations && entity.getIcd10() != null) {
			entityToUpdate.setIcd10(entity.getIcd10(), false);
			if (entityToUpdate.getIcd10Id() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getIcd10());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getIcd10().unsetInvoicesICD10();
			}
		}

		// Incoming One to Many reference
		if (entity.getIcd9CM() == null && entity.getIcd9CMId() == null) {
			entityToUpdate.unsetIcd9CM();
		} else if (entity.getIcd9CMId() != null && entity.getIcd9CM() == null) {
			Optional<DiagnosesAndProceduresEntity> icd9CMEntity = this.diagnosesAndProceduresRepository.findById(entity.getIcd9CMId());
			entityToUpdate.setIcd9CM(icd9CMEntity.orElseThrow());
		}
		if (persistRelations && entity.getIcd9CM() != null) {
			entityToUpdate.setIcd9CM(entity.getIcd9CM(), false);
			if (entityToUpdate.getIcd9CMId() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getIcd9CM());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getIcd9CM().unsetInvoicesICD9CM();
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
				entityToUpdate.getBedFacility().unsetInvoices();
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
				entityToUpdate.getPatientVisit().unsetInvoices();
			}
		}

		// Incoming One to Many reference
		if (entity.getTariffSchema() == null && entity.getTariffSchemaId() == null) {
			entityToUpdate.unsetTariffSchema();
		} else if (entity.getTariffSchemaId() != null && entity.getTariffSchema() == null) {
			Optional<TariffSchemaEntity> tariffSchemaEntity = this.tariffSchemaRepository.findById(entity.getTariffSchemaId());
			entityToUpdate.setTariffSchema(tariffSchemaEntity.orElseThrow());
		}
		if (persistRelations && entity.getTariffSchema() != null) {
			entityToUpdate.setTariffSchema(entity.getTariffSchema(), false);
			if (entityToUpdate.getTariffSchemaId() != null) {
				this.tariffSchemaRepository.save(entityToUpdate.getTariffSchema());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getTariffSchema().unsetInvoices();
			}
		}

		// Incoming One to Many reference
		if (entity.getVerifiedBy() == null && entity.getVerifiedById() == null) {
			entityToUpdate.unsetVerifiedBy();
		} else if (entity.getVerifiedById() != null && entity.getVerifiedBy() == null) {
			Optional<StaffEntity> verifiedByEntity = this.staffRepository.findById(entity.getVerifiedById());
			entityToUpdate.setVerifiedBy(verifiedByEntity.orElseThrow());
		}
		if (persistRelations && entity.getVerifiedBy() != null) {
			entityToUpdate.setVerifiedBy(entity.getVerifiedBy(), false);
			if (entityToUpdate.getVerifiedById() != null) {
				this.staffRepository.save(entityToUpdate.getVerifiedBy());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getVerifiedBy().unsetInvoices();
			}
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
		if (entity.getInvoicePaymentInsurancesIds().isEmpty() && entity.getInvoicePaymentInsurances().isEmpty()) {
			entityToUpdate.setInvoicePaymentInsurances(new HashSet<>());
		} else if (!entity.getInvoicePaymentInsurancesIds().isEmpty() && entity.getInvoicePaymentInsurances().isEmpty()) {
			Iterable<InvoicePaymentInsuranceEntity> invoicePaymentInsurancesEntities =
					this.invoicePaymentInsuranceRepository.findAllById(entity.getInvoicePaymentInsurancesIds());
			entityToUpdate.setInvoicePaymentInsurances(Sets.newHashSet(invoicePaymentInsurancesEntities));
		}
		if (persistRelations && !entity.getInvoicePaymentInsurances().isEmpty()) {
			Set<InvoicePaymentInsuranceEntity> updatedEntities = new HashSet<>();
			entity.getInvoicePaymentInsurances().forEach(model -> {
				if (model.getId() != null) {
					model = this.invoicePaymentInsuranceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoicePaymentInsurances(updatedEntities);
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
	public void validateEntity(InvoiceEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<InvoiceEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the InvoiceEntity.
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

	public Set<String> validateEntityRelations(InvoiceEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getMedicationHeaderId() != null && this.medicationHeaderRepository.findById(entity.getMedicationHeaderId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicationHeaderId() + " is not associated with a Medication Header Entity");
		}

		if (entity.getIcd10Id() != null && this.diagnosesAndProceduresRepository.findById(entity.getIcd10Id()).isEmpty()) {
			errors.add("The UUID " + entity.getIcd10Id() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getIcd9CMId() != null && this.diagnosesAndProceduresRepository.findById(entity.getIcd9CMId()).isEmpty()) {
			errors.add("The UUID " + entity.getIcd9CMId() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getBedFacilityId() != null && this.bedFacilityRepository.findById(entity.getBedFacilityId()).isEmpty()) {
			errors.add("The UUID " + entity.getBedFacilityId() + " is not associated with a Bed Facility Entity");
		}

		if (entity.getPatientVisitId() != null && this.patientVisitRepository.findById(entity.getPatientVisitId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientVisitId() + " is not associated with a Patient Visit Entity");
		}

		if (entity.getTariffSchemaId() != null && this.tariffSchemaRepository.findById(entity.getTariffSchemaId()).isEmpty()) {
			errors.add("The UUID " + entity.getTariffSchemaId() + " is not associated with a Tariff Schema Entity");
		}

		if (entity.getVerifiedById() != null && this.staffRepository.findById(entity.getVerifiedById()).isEmpty()) {
			errors.add("The UUID " + entity.getVerifiedById() + " is not associated with a Staff Entity");
		}

		for (UUID id : entity.getInvoiceItemsIds()) {
			if (this.invoiceItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Item Entity");
			}
		}

		for (UUID id : entity.getInvoicePaymentInsurancesIds()) {
			if (this.invoicePaymentInsuranceRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Payment Insurance Entity");
			}
		}

		if (entity.getInvoicePaymentOtherId() != null && this.invoicePaymentOtherRepository.findById(entity.getInvoicePaymentOtherId()).isEmpty()) {
			errors.add("The UUID " + entity.getInvoicePaymentOtherId() + " is not associated with a Invoice Payment Other Entity");
		}

		if (entity.getInvoicePaymentSelfPayingId() != null && this.invoicePaymentSelfPayingRepository.findById(entity.getInvoicePaymentSelfPayingId()).isEmpty()) {
			errors.add("The UUID " + entity.getInvoicePaymentSelfPayingId() + " is not associated with a Invoice Payment Self Paying Entity");
		}

		if (entity.getInvoiceSummaryId() != null && this.invoiceSummaryRepository.findById(entity.getInvoiceSummaryId()).isEmpty()) {
			errors.add("The UUID " + entity.getInvoiceSummaryId() + " is not associated with a Invoice Summary Entity");
		}

		if (entity.getPrescriptionHeaderId() != null && this.prescriptionHeaderRepository.findById(entity.getPrescriptionHeaderId()).isEmpty()) {
			errors.add("The UUID " + entity.getPrescriptionHeaderId() + " is not associated with a Prescription Header Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
