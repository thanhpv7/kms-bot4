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
import kmsweb.repositories.PatientGeneralInfoRepository;
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
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.repositories.BpjsClaimSubmissionRepository;
import kmsweb.entities.CashReceiptEntity;
import kmsweb.repositories.CashReceiptRepository;
import kmsweb.entities.CashRefundEntity;
import kmsweb.repositories.CashRefundRepository;
import kmsweb.entities.InformedConsentEntity;
import kmsweb.repositories.InformedConsentRepository;
import kmsweb.entities.PatientCaseHistoryEntity;
import kmsweb.repositories.PatientCaseHistoryRepository;
import kmsweb.entities.PatientConsentEntity;
import kmsweb.repositories.PatientConsentRepository;
import kmsweb.entities.PatientContactInfoEntity;
import kmsweb.repositories.PatientContactInfoRepository;
import kmsweb.entities.PatientDetailEntity;
import kmsweb.repositories.PatientDetailRepository;
import kmsweb.entities.PatientDetailAddressEntity;
import kmsweb.repositories.PatientDetailAddressRepository;
import kmsweb.entities.PatientEmergencyContactDetailEntity;
import kmsweb.repositories.PatientEmergencyContactDetailRepository;
import kmsweb.entities.PatientEmploymentDetailEntity;
import kmsweb.repositories.PatientEmploymentDetailRepository;
import kmsweb.entities.PatientPaymentSelfPayingEntity;
import kmsweb.repositories.PatientPaymentSelfPayingRepository;
import kmsweb.entities.PatientPaymentBPJSEntity;
import kmsweb.repositories.PatientPaymentBPJSRepository;
import kmsweb.entities.PatientPaymentInsuranceEntity;
import kmsweb.repositories.PatientPaymentInsuranceRepository;
import kmsweb.entities.PatientPaymentOthersEntity;
import kmsweb.repositories.PatientPaymentOthersRepository;
import kmsweb.entities.PatientPersonalInfoEntity;
import kmsweb.repositories.PatientPersonalInfoRepository;
import kmsweb.entities.PatientSupportingDocumentEntity;
import kmsweb.repositories.PatientSupportingDocumentRepository;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;
import kmsweb.entities.RetailPharmacyEntity;
import kmsweb.repositories.RetailPharmacyRepository;
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
public class PatientGeneralInfoService extends AbstractService<PatientGeneralInfoEntity, PatientGeneralInfoRepository, PatientGeneralInfoEntityAudit> {

	private final String[] referenceNamesInPatientGeneralInfoEntity = {
		"bpjsClaimSubmissions",
		"cashRefunds",
		"informedConsents",
		"invoiceReceipts",
		"patientCaseHistories",
		"patientConsents",
		"patientContactInformation",
		"patientDetailAddress",
		"patientDetail",
		"patientEmergencyContactDetail",
		"patientEmploymentDetail",
		"patientFinalizeProfiles",
		"patientPaymentBPJS",
		"patientPaymentTypeInsurance",
		"patientPaymentTypeOthers",
		"patientPersonalInformation",
		"patientSelfPaying",
		"retailPharmacies",
		"visits",
	};

	private AbstractFileService<FileEntity> fileService;

	private final BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository;

	private final CashReceiptRepository cashReceiptRepository;

	private final CashRefundRepository cashRefundRepository;

	private final InformedConsentRepository informedConsentRepository;

	private final PatientCaseHistoryRepository patientCaseHistoryRepository;

	private final PatientConsentRepository patientConsentRepository;

	private final PatientContactInfoRepository patientContactInfoRepository;

	private final PatientDetailRepository patientDetailRepository;

	private final PatientDetailAddressRepository patientDetailAddressRepository;

	private final PatientEmergencyContactDetailRepository patientEmergencyContactDetailRepository;

	private final PatientEmploymentDetailRepository patientEmploymentDetailRepository;

	private final PatientPaymentSelfPayingRepository patientPaymentSelfPayingRepository;

	private final PatientPaymentBPJSRepository patientPaymentBPJSRepository;

	private final PatientPaymentInsuranceRepository patientPaymentInsuranceRepository;

	private final PatientPaymentOthersRepository patientPaymentOthersRepository;

	private final PatientPersonalInfoRepository patientPersonalInfoRepository;

	private final PatientSupportingDocumentRepository patientSupportingDocumentRepository;

	private final PatientVisitRepository patientVisitRepository;

	private final RetailPharmacyRepository retailPharmacyRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PatientGeneralInfoService(
		// % protected region % [Add any additional constructor parameters here] off begin
		S3FileService s3FileService,
		// % protected region % [Add any additional constructor parameters here] end
		BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository,
		CashReceiptRepository cashReceiptRepository,
		CashRefundRepository cashRefundRepository,
		InformedConsentRepository informedConsentRepository,
		PatientCaseHistoryRepository patientCaseHistoryRepository,
		PatientConsentRepository patientConsentRepository,
		PatientContactInfoRepository patientContactInfoRepository,
		PatientDetailRepository patientDetailRepository,
		PatientDetailAddressRepository patientDetailAddressRepository,
		PatientEmergencyContactDetailRepository patientEmergencyContactDetailRepository,
		PatientEmploymentDetailRepository patientEmploymentDetailRepository,
		PatientPaymentSelfPayingRepository patientPaymentSelfPayingRepository,
		PatientPaymentBPJSRepository patientPaymentBPJSRepository,
		PatientPaymentInsuranceRepository patientPaymentInsuranceRepository,
		PatientPaymentOthersRepository patientPaymentOthersRepository,
		PatientPersonalInfoRepository patientPersonalInfoRepository,
		PatientSupportingDocumentRepository patientSupportingDocumentRepository,
		PatientVisitRepository patientVisitRepository,
		RetailPharmacyRepository retailPharmacyRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PatientGeneralInfoRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bpjsClaimSubmissionRepository = bpjsClaimSubmissionRepository;

		this.cashReceiptRepository = cashReceiptRepository;

		this.cashRefundRepository = cashRefundRepository;

		this.informedConsentRepository = informedConsentRepository;

		this.patientCaseHistoryRepository = patientCaseHistoryRepository;

		this.patientConsentRepository = patientConsentRepository;

		this.patientContactInfoRepository = patientContactInfoRepository;

		this.patientDetailRepository = patientDetailRepository;

		this.patientDetailAddressRepository = patientDetailAddressRepository;

		this.patientEmergencyContactDetailRepository = patientEmergencyContactDetailRepository;

		this.patientEmploymentDetailRepository = patientEmploymentDetailRepository;

		this.patientPaymentSelfPayingRepository = patientPaymentSelfPayingRepository;

		this.patientPaymentBPJSRepository = patientPaymentBPJSRepository;

		this.patientPaymentInsuranceRepository = patientPaymentInsuranceRepository;

		this.patientPaymentOthersRepository = patientPaymentOthersRepository;

		this.patientPersonalInfoRepository = patientPersonalInfoRepository;

		this.patientSupportingDocumentRepository = patientSupportingDocumentRepository;

		this.patientVisitRepository = patientVisitRepository;

		this.retailPharmacyRepository = retailPharmacyRepository;

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
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
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
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Patient ID.
	 *
	 * @param patientID the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient ID
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PatientGeneralInfoEntity> findByPatientID(String patientID)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientID here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientID here] end
	{
		// % protected region % [Add any additional logic for findByPatientID before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientID before the main body here] end

		Optional<PatientGeneralInfoEntity> entity = repository.findByPatientID(patientID);

		// % protected region % [Add any additional logic for findByPatientID before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByPatientID before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Title.
	 *
	 * @param title the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Title
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findByTitle(String title)
	// % protected region % [Add any throwables, implementations, or extensions for findByTitle here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTitle here] end
	{
		// % protected region % [Add any additional logic for findByTitle before the main body here] off begin
		// % protected region % [Add any additional logic for findByTitle before the main body here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findByTitle(title));

		// % protected region % [Add any additional logic for findByTitle before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTitle before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Given Name.
	 *
	 * @param givenName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Given Name
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findByGivenName(String givenName)
	// % protected region % [Add any throwables, implementations, or extensions for findByGivenName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGivenName here] end
	{
		// % protected region % [Add any additional logic for findByGivenName before the main body here] off begin
		// % protected region % [Add any additional logic for findByGivenName before the main body here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findByGivenName(givenName));

		// % protected region % [Add any additional logic for findByGivenName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGivenName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Last Name.
	 *
	 * @param lastName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Last Name
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findByLastName(String lastName)
	// % protected region % [Add any throwables, implementations, or extensions for findByLastName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLastName here] end
	{
		// % protected region % [Add any additional logic for findByLastName before the main body here] off begin
		// % protected region % [Add any additional logic for findByLastName before the main body here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findByLastName(lastName));

		// % protected region % [Add any additional logic for findByLastName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLastName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Place of Birth.
	 *
	 * @param placeOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Place of Birth
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findByPlaceOfBirth(String placeOfBirth)
	// % protected region % [Add any throwables, implementations, or extensions for findByPlaceOfBirth here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPlaceOfBirth here] end
	{
		// % protected region % [Add any additional logic for findByPlaceOfBirth before the main body here] off begin
		// % protected region % [Add any additional logic for findByPlaceOfBirth before the main body here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findByPlaceOfBirth(placeOfBirth));

		// % protected region % [Add any additional logic for findByPlaceOfBirth before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPlaceOfBirth before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Date of Birth.
	 *
	 * @param dateOfBirth the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date of Birth
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findByDateOfBirth(OffsetDateTime dateOfBirth)
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfBirth here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDateOfBirth here] end
	{
		// % protected region % [Add any additional logic for findByDateOfBirth before the main body here] off begin
		// % protected region % [Add any additional logic for findByDateOfBirth before the main body here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findByDateOfBirth(dateOfBirth));

		// % protected region % [Add any additional logic for findByDateOfBirth before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDateOfBirth before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gender.
	 *
	 * @param gender the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gender
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findByGender(String gender)
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGender here] end
	{
		// % protected region % [Add any additional logic for findByGender before the main body here] off begin
		// % protected region % [Add any additional logic for findByGender before the main body here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findByGender(gender));

		// % protected region % [Add any additional logic for findByGender before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGender before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findByAddress(String address)
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAddress here] end
	{
		// % protected region % [Add any additional logic for findByAddress before the main body here] off begin
		// % protected region % [Add any additional logic for findByAddress before the main body here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findByAddress(address));

		// % protected region % [Add any additional logic for findByAddress before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAddress before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Patient Payment Type.
	 *
	 * @param patientPaymentType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient Payment Type
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findByPatientPaymentType(String patientPaymentType)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientPaymentType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientPaymentType here] end
	{
		// % protected region % [Add any additional logic for findByPatientPaymentType before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientPaymentType before the main body here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findByPatientPaymentType(patientPaymentType));

		// % protected region % [Add any additional logic for findByPatientPaymentType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientPaymentType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Important Notes.
	 *
	 * @param importantNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Important Notes
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findByImportantNotes(String importantNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByImportantNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByImportantNotes here] end
	{
		// % protected region % [Add any additional logic for findByImportantNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByImportantNotes before the main body here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findByImportantNotes(importantNotes));

		// % protected region % [Add any additional logic for findByImportantNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByImportantNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Has Outstanding Payment.
	 *
	 * @param hasOutstandingPayment the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Has Outstanding Payment
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findByHasOutstandingPayment(Boolean hasOutstandingPayment)
	// % protected region % [Add any throwables, implementations, or extensions for findByHasOutstandingPayment here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHasOutstandingPayment here] end
	{
		// % protected region % [Add any additional logic for findByHasOutstandingPayment before the main body here] off begin
		// % protected region % [Add any additional logic for findByHasOutstandingPayment before the main body here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findByHasOutstandingPayment(hasOutstandingPayment));

		// % protected region % [Add any additional logic for findByHasOutstandingPayment before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHasOutstandingPayment before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PatientGeneralInfoEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PatientGeneralInfoEntity> entity = repository.findById(id);

		entity.ifPresent(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PatientGeneralInfoEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		entities.forEach(this::generateSignedFileUrls);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'create')")
	public PatientGeneralInfoEntity create(PatientGeneralInfoEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PatientGeneralInfoEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'create')")
	public PatientGeneralInfoEntity create(PatientGeneralInfoEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PatientGeneralInfoEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PatientGeneralInfoEntity newEntity;

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
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'create')")
	public List<PatientGeneralInfoEntity> createAll(Iterable<PatientGeneralInfoEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PatientGeneralInfoEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PatientGeneralInfoEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'update')")
	public PatientGeneralInfoEntity update(PatientGeneralInfoEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PatientGeneralInfoEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'update')")
	public PatientGeneralInfoEntity update(PatientGeneralInfoEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PatientGeneralInfoEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PatientGeneralInfoEntity newEntity;

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
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'update')")
	public List<PatientGeneralInfoEntity> updateAll(Iterable<PatientGeneralInfoEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PatientGeneralInfoEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PatientGeneralInfoEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'create') or hasPermission('PatientGeneralInfoEntity', 'update')")
	public PatientGeneralInfoEntity save(PatientGeneralInfoEntity entity) throws ConstraintViolationException
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

		PatientGeneralInfoEntity newEntity = repository.save(entity);

		generateSignedFileUrls(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'create') or hasPermission('PatientGeneralInfoEntity', 'update')")
	public List<PatientGeneralInfoEntity> saveAll(Iterable<PatientGeneralInfoEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PatientGeneralInfoEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	public List<PatientGeneralInfoEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	public List<PatientGeneralInfoEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PatientGeneralInfoEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PatientGeneralInfoEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PatientGeneralInfoEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PatientGeneralInfoEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PatientGeneralInfoEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PatientGeneralInfoEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PatientGeneralInfoEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PatientGeneralInfoEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PatientGeneralInfoEntityAudits
	 */
	private List<PatientGeneralInfoEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PatientGeneralInfoEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param patientGeneralInfo patientGeneralInfo to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PatientGeneralInfoEntity updateAuditData(PatientGeneralInfoEntity patientGeneralInfo)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{

		patientGeneralInfo.setPatientPicture(new HashSet<>(patientGeneralInfo.getPatientPicture()));

		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return patientGeneralInfo;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PatientGeneralInfoEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PatientGeneralInfoEntity entityAtRevision = updateAuditData((PatientGeneralInfoEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PatientGeneralInfoEntityAudit(
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
	private void generateSignedFileUrls(PatientGeneralInfoEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for generateSignedFileUrls here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for generateSignedFileUrls here] end
	{
		Set<FileEntity> patientPicture = entity.getPatientPicture();

		for (FileEntity individualPatientPicture : patientPicture) {
			String url = fileService.generateUrl(individualPatientPicture.getId());
			individualPatientPicture.setUrl(url);
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

		QPatientGeneralInfoEntity entity = QPatientGeneralInfoEntity.patientGeneralInfoEntity;

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
			case "patientContactInformationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Contact Information here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Contact Information here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientContactInformation.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Contact Information here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Contact Information here] end

				break;
			case "patientDetailAddressId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Detail Address here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Detail Address here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientDetailAddress.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Detail Address here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Detail Address here] end

				break;
			case "patientDetailId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Detail here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Detail here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientDetail.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Detail here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Detail here] end

				break;
			case "patientEmergencyContactDetailId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Emergency Contact Detail here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Emergency Contact Detail here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientEmergencyContactDetail.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Emergency Contact Detail here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Emergency Contact Detail here] end

				break;
			case "patientEmploymentDetailId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Patient Employment Detail  here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Patient Employment Detail  here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientEmploymentDetail.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Patient Employment Detail  here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Patient Employment Detail  here] end

				break;
			case "patientPaymentBPJSId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Patient Payment BPJS here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Patient Payment BPJS here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientPaymentBPJS.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Patient Payment BPJS here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Patient Payment BPJS here] end

				break;
			case "patientPaymentTypeInsuranceId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Payment Type Insurance here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Payment Type Insurance here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientPaymentTypeInsurance.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Payment Type Insurance here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Payment Type Insurance here] end

				break;
			case "patientPaymentTypeOthersId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Payment Type Others here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Payment Type Others here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientPaymentTypeOthers.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Payment Type Others here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Payment Type Others here] end

				break;
			case "patientPersonalInformationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Personal Information here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Personal Information here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientPersonalInformation.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Personal Information here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Personal Information here] end

				break;
			case "patientSelfPayingId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Self Paying here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Self Paying here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientSelfPaying.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Self Paying here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Self Paying here] end

				break;
			case "bpjsClaimSubmissionsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to BPJS Claim Submissions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bpjsClaimSubmissions.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to BPJS Claim Submissions here] end

				break;
			case "cashRefundsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Cash Refunds here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Cash Refunds here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.cashRefunds.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Cash Refunds here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Cash Refunds here] end

				break;
			case "informedConsentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Informed Consents here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Informed Consents here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.informedConsents.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Informed Consents here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Informed Consents here] end

				break;
			case "invoiceReceiptsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient to Invoice Receipts here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient to Invoice Receipts here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceReceipts.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient to Invoice Receipts here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient to Invoice Receipts here] end

				break;
			case "patientCaseHistoriesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Case Histories here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Case Histories here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientCaseHistories.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Case Histories here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Case Histories here] end

				break;
			case "patientConsentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Patient Consents here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Patient Consents here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientConsents.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Patient Consents here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Patient Consents here] end

				break;
			case "patientFinalizeProfilesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Finalize Profiles here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Information to Patient Finalize Profiles here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientFinalizeProfiles.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Finalize Profiles here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Information to Patient Finalize Profiles here] end

				break;
			case "retailPharmaciesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Retail Pharmacies here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient General Info to Retail Pharmacies here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.retailPharmacies.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Retail Pharmacies here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient General Info to Retail Pharmacies here] end

				break;
			case "visitsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Patient to Visits here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Patient to Visits here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.visits.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Patient to Visits here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Patient to Visits here] end

				break;
			case "patientID":
				// % protected region % [Add any additional logic before the query parameters of patientID here] off begin
				// % protected region % [Add any additional logic before the query parameters of patientID here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.patientID, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of patientID here] off begin
				// % protected region % [Add any additional logic after the query parameters of patientID here] end

				break;
			case "givenName":
				// % protected region % [Add any additional logic before the query parameters of givenName here] off begin
				// % protected region % [Add any additional logic before the query parameters of givenName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.givenName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of givenName here] off begin
				// % protected region % [Add any additional logic after the query parameters of givenName here] end

				break;
			case "lastName":
				// % protected region % [Add any additional logic before the query parameters of lastName here] off begin
				// % protected region % [Add any additional logic before the query parameters of lastName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.lastName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of lastName here] off begin
				// % protected region % [Add any additional logic after the query parameters of lastName here] end

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
	public PatientGeneralInfoEntity updateOldData(PatientGeneralInfoEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PatientGeneralInfoEntity updateOldData(PatientGeneralInfoEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PatientGeneralInfoEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPatientGeneralInfoEntity);


			// % protected region % [Add any additional logic for update before uploading files here] off begin
			// % protected region % [Add any additional logic for update before uploading files here] end

			Set<FileEntity> patientPictureFiles = entity.getPatientPicture();

			// Delete any file that requires deletion.
			Set<FileEntity> patientPicturefilesToDelete = patientPictureFiles.stream()
					.filter(fileToDelete -> fileToDelete.getId() != null && fileToDelete.getDoDelete()) // Only delete valid existing files
					.filter(entityToUpdate::containsPatientPicture) // Make sure that the files exist in the old entity before deleting them
					.collect(Collectors.toSet());

			patientPicturefilesToDelete.stream()
					.peek(entity::removePatientPicture) // Remove the deleted files from the entity itself.
					.map(FileEntity::getId)
					.forEach(fileService::delete);

			// Upload and merge the rest of the files together with the current files
			Set<FileEntity> patientPictureFilesToUpload = patientPictureFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null) // Only upload those files that we have not uploaded yet
					.collect(Collectors.toSet());

			fileService.uploadMultiple(patientPictureFilesToUpload).forEach(entity::addPatientPicture);
		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			Set<FileEntity> patientPictureFiles = entityToUpdate.getPatientPicture();
			// Merge the rest of the files together
			Set<FileEntity> patientPictureFilesToUpload = patientPictureFiles.stream()
					.filter(fileToUpload -> fileToUpload.getId() == null)
					.collect(Collectors.toSet());

			entityToUpdate.clearAllPatientPicture();
			fileService.uploadMultiple(patientPictureFilesToUpload).forEach(entity::addPatientPicture);

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getHasOutstandingPayment() == null) {
			entityToUpdate.setHasOutstandingPayment(false);
		}

		// Outgoing one to one reference
		if (entity.getPatientContactInformation() == null && entity.getPatientContactInformationId() == null) {
			entityToUpdate.unsetPatientContactInformation();
		} else if (entity.getPatientContactInformationId() != null && entity.getPatientContactInformation() == null) {
			Optional<PatientContactInfoEntity> patientContactInformationEntity = this.patientContactInfoRepository.findById(entity.getPatientContactInformationId());
			entityToUpdate.setPatientContactInformation(patientContactInformationEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientContactInformation() != null) {
			entityToUpdate.setPatientContactInformation(entity.getPatientContactInformation(), false);
			if (entityToUpdate.getPatientContactInformationId() != null) {
				this.patientContactInfoRepository.save(entityToUpdate.getPatientContactInformation());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientContactInformation().unsetPatientGeneralInformation();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientDetailAddress() == null && entity.getPatientDetailAddressId() == null) {
			entityToUpdate.unsetPatientDetailAddress();
		} else if (entity.getPatientDetailAddressId() != null && entity.getPatientDetailAddress() == null) {
			Optional<PatientDetailAddressEntity> patientDetailAddressEntity = this.patientDetailAddressRepository.findById(entity.getPatientDetailAddressId());
			entityToUpdate.setPatientDetailAddress(patientDetailAddressEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientDetailAddress() != null) {
			entityToUpdate.setPatientDetailAddress(entity.getPatientDetailAddress(), false);
			if (entityToUpdate.getPatientDetailAddressId() != null) {
				this.patientDetailAddressRepository.save(entityToUpdate.getPatientDetailAddress());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientDetailAddress().unsetPatientGeneralInformation();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientDetail() == null && entity.getPatientDetailId() == null) {
			entityToUpdate.unsetPatientDetail();
		} else if (entity.getPatientDetailId() != null && entity.getPatientDetail() == null) {
			Optional<PatientDetailEntity> patientDetailEntity = this.patientDetailRepository.findById(entity.getPatientDetailId());
			entityToUpdate.setPatientDetail(patientDetailEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientDetail() != null) {
			entityToUpdate.setPatientDetail(entity.getPatientDetail(), false);
			if (entityToUpdate.getPatientDetailId() != null) {
				this.patientDetailRepository.save(entityToUpdate.getPatientDetail());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientDetail().unsetPatientGeneralInformation();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientEmergencyContactDetail() == null && entity.getPatientEmergencyContactDetailId() == null) {
			entityToUpdate.unsetPatientEmergencyContactDetail();
		} else if (entity.getPatientEmergencyContactDetailId() != null && entity.getPatientEmergencyContactDetail() == null) {
			Optional<PatientEmergencyContactDetailEntity> patientEmergencyContactDetailEntity = this.patientEmergencyContactDetailRepository.findById(entity.getPatientEmergencyContactDetailId());
			entityToUpdate.setPatientEmergencyContactDetail(patientEmergencyContactDetailEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientEmergencyContactDetail() != null) {
			entityToUpdate.setPatientEmergencyContactDetail(entity.getPatientEmergencyContactDetail(), false);
			if (entityToUpdate.getPatientEmergencyContactDetailId() != null) {
				this.patientEmergencyContactDetailRepository.save(entityToUpdate.getPatientEmergencyContactDetail());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientEmergencyContactDetail().unsetPatientGeneralInformation();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientEmploymentDetail() == null && entity.getPatientEmploymentDetailId() == null) {
			entityToUpdate.unsetPatientEmploymentDetail();
		} else if (entity.getPatientEmploymentDetailId() != null && entity.getPatientEmploymentDetail() == null) {
			Optional<PatientEmploymentDetailEntity> patientEmploymentDetailEntity = this.patientEmploymentDetailRepository.findById(entity.getPatientEmploymentDetailId());
			entityToUpdate.setPatientEmploymentDetail(patientEmploymentDetailEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientEmploymentDetail() != null) {
			entityToUpdate.setPatientEmploymentDetail(entity.getPatientEmploymentDetail(), false);
			if (entityToUpdate.getPatientEmploymentDetailId() != null) {
				this.patientEmploymentDetailRepository.save(entityToUpdate.getPatientEmploymentDetail());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientEmploymentDetail().unsetPatientGeneralInfo();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientPaymentBPJS() == null && entity.getPatientPaymentBPJSId() == null) {
			entityToUpdate.unsetPatientPaymentBPJS();
		} else if (entity.getPatientPaymentBPJSId() != null && entity.getPatientPaymentBPJS() == null) {
			Optional<PatientPaymentBPJSEntity> patientPaymentBPJSEntity = this.patientPaymentBPJSRepository.findById(entity.getPatientPaymentBPJSId());
			entityToUpdate.setPatientPaymentBPJS(patientPaymentBPJSEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientPaymentBPJS() != null) {
			entityToUpdate.setPatientPaymentBPJS(entity.getPatientPaymentBPJS(), false);
			if (entityToUpdate.getPatientPaymentBPJSId() != null) {
				this.patientPaymentBPJSRepository.save(entityToUpdate.getPatientPaymentBPJS());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientPaymentBPJS().unsetPatientGeneralInfo();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientPaymentTypeInsurance() == null && entity.getPatientPaymentTypeInsuranceId() == null) {
			entityToUpdate.unsetPatientPaymentTypeInsurance();
		} else if (entity.getPatientPaymentTypeInsuranceId() != null && entity.getPatientPaymentTypeInsurance() == null) {
			Optional<PatientPaymentInsuranceEntity> patientPaymentTypeInsuranceEntity = this.patientPaymentInsuranceRepository.findById(entity.getPatientPaymentTypeInsuranceId());
			entityToUpdate.setPatientPaymentTypeInsurance(patientPaymentTypeInsuranceEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientPaymentTypeInsurance() != null) {
			entityToUpdate.setPatientPaymentTypeInsurance(entity.getPatientPaymentTypeInsurance(), false);
			if (entityToUpdate.getPatientPaymentTypeInsuranceId() != null) {
				this.patientPaymentInsuranceRepository.save(entityToUpdate.getPatientPaymentTypeInsurance());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientPaymentTypeInsurance().unsetPatientGeneralInformation();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientPaymentTypeOthers() == null && entity.getPatientPaymentTypeOthersId() == null) {
			entityToUpdate.unsetPatientPaymentTypeOthers();
		} else if (entity.getPatientPaymentTypeOthersId() != null && entity.getPatientPaymentTypeOthers() == null) {
			Optional<PatientPaymentOthersEntity> patientPaymentTypeOthersEntity = this.patientPaymentOthersRepository.findById(entity.getPatientPaymentTypeOthersId());
			entityToUpdate.setPatientPaymentTypeOthers(patientPaymentTypeOthersEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientPaymentTypeOthers() != null) {
			entityToUpdate.setPatientPaymentTypeOthers(entity.getPatientPaymentTypeOthers(), false);
			if (entityToUpdate.getPatientPaymentTypeOthersId() != null) {
				this.patientPaymentOthersRepository.save(entityToUpdate.getPatientPaymentTypeOthers());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientPaymentTypeOthers().unsetPatientGeneralInformation();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientPersonalInformation() == null && entity.getPatientPersonalInformationId() == null) {
			entityToUpdate.unsetPatientPersonalInformation();
		} else if (entity.getPatientPersonalInformationId() != null && entity.getPatientPersonalInformation() == null) {
			Optional<PatientPersonalInfoEntity> patientPersonalInformationEntity = this.patientPersonalInfoRepository.findById(entity.getPatientPersonalInformationId());
			entityToUpdate.setPatientPersonalInformation(patientPersonalInformationEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientPersonalInformation() != null) {
			entityToUpdate.setPatientPersonalInformation(entity.getPatientPersonalInformation(), false);
			if (entityToUpdate.getPatientPersonalInformationId() != null) {
				this.patientPersonalInfoRepository.save(entityToUpdate.getPatientPersonalInformation());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientPersonalInformation().unsetPatientGeneralInformation();
			}
		}

		// Outgoing one to one reference
		if (entity.getPatientSelfPaying() == null && entity.getPatientSelfPayingId() == null) {
			entityToUpdate.unsetPatientSelfPaying();
		} else if (entity.getPatientSelfPayingId() != null && entity.getPatientSelfPaying() == null) {
			Optional<PatientPaymentSelfPayingEntity> patientSelfPayingEntity = this.patientPaymentSelfPayingRepository.findById(entity.getPatientSelfPayingId());
			entityToUpdate.setPatientSelfPaying(patientSelfPayingEntity.orElseThrow());
		}
		if (persistRelations && entity.getPatientSelfPaying() != null) {
			entityToUpdate.setPatientSelfPaying(entity.getPatientSelfPaying(), false);
			if (entityToUpdate.getPatientSelfPayingId() != null) {
				this.patientPaymentSelfPayingRepository.save(entityToUpdate.getPatientSelfPaying());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPatientSelfPaying().unsetPatientGeneralInformation();
			}
		}

		// Outgoing one to many reference
		if (entity.getBpjsClaimSubmissionsIds().isEmpty() && entity.getBpjsClaimSubmissions().isEmpty()) {
			entityToUpdate.setBpjsClaimSubmissions(new HashSet<>());
		} else if (!entity.getBpjsClaimSubmissionsIds().isEmpty() && entity.getBpjsClaimSubmissions().isEmpty()) {
			Iterable<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities =
					this.bpjsClaimSubmissionRepository.findAllById(entity.getBpjsClaimSubmissionsIds());
			entityToUpdate.setBpjsClaimSubmissions(Sets.newHashSet(bpjsClaimSubmissionsEntities));
		}
		if (persistRelations && !entity.getBpjsClaimSubmissions().isEmpty()) {
			Set<BpjsClaimSubmissionEntity> updatedEntities = new HashSet<>();
			entity.getBpjsClaimSubmissions().forEach(model -> {
				if (model.getId() != null) {
					model = this.bpjsClaimSubmissionRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBpjsClaimSubmissions(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getCashRefundsIds().isEmpty() && entity.getCashRefunds().isEmpty()) {
			entityToUpdate.setCashRefunds(new HashSet<>());
		} else if (!entity.getCashRefundsIds().isEmpty() && entity.getCashRefunds().isEmpty()) {
			Iterable<CashRefundEntity> cashRefundsEntities =
					this.cashRefundRepository.findAllById(entity.getCashRefundsIds());
			entityToUpdate.setCashRefunds(Sets.newHashSet(cashRefundsEntities));
		}
		if (persistRelations && !entity.getCashRefunds().isEmpty()) {
			Set<CashRefundEntity> updatedEntities = new HashSet<>();
			entity.getCashRefunds().forEach(model -> {
				if (model.getId() != null) {
					model = this.cashRefundRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCashRefunds(updatedEntities);
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
		if (entity.getInvoiceReceiptsIds().isEmpty() && entity.getInvoiceReceipts().isEmpty()) {
			entityToUpdate.setInvoiceReceipts(new HashSet<>());
		} else if (!entity.getInvoiceReceiptsIds().isEmpty() && entity.getInvoiceReceipts().isEmpty()) {
			Iterable<CashReceiptEntity> invoiceReceiptsEntities =
					this.cashReceiptRepository.findAllById(entity.getInvoiceReceiptsIds());
			entityToUpdate.setInvoiceReceipts(Sets.newHashSet(invoiceReceiptsEntities));
		}
		if (persistRelations && !entity.getInvoiceReceipts().isEmpty()) {
			Set<CashReceiptEntity> updatedEntities = new HashSet<>();
			entity.getInvoiceReceipts().forEach(model -> {
				if (model.getId() != null) {
					model = this.cashReceiptRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoiceReceipts(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPatientCaseHistoriesIds().isEmpty() && entity.getPatientCaseHistories().isEmpty()) {
			entityToUpdate.setPatientCaseHistories(new HashSet<>());
		} else if (!entity.getPatientCaseHistoriesIds().isEmpty() && entity.getPatientCaseHistories().isEmpty()) {
			Iterable<PatientCaseHistoryEntity> patientCaseHistoriesEntities =
					this.patientCaseHistoryRepository.findAllById(entity.getPatientCaseHistoriesIds());
			entityToUpdate.setPatientCaseHistories(Sets.newHashSet(patientCaseHistoriesEntities));
		}
		if (persistRelations && !entity.getPatientCaseHistories().isEmpty()) {
			Set<PatientCaseHistoryEntity> updatedEntities = new HashSet<>();
			entity.getPatientCaseHistories().forEach(model -> {
				if (model.getId() != null) {
					model = this.patientCaseHistoryRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPatientCaseHistories(updatedEntities);
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
		if (entity.getPatientFinalizeProfilesIds().isEmpty() && entity.getPatientFinalizeProfiles().isEmpty()) {
			entityToUpdate.setPatientFinalizeProfiles(new HashSet<>());
		} else if (!entity.getPatientFinalizeProfilesIds().isEmpty() && entity.getPatientFinalizeProfiles().isEmpty()) {
			Iterable<PatientSupportingDocumentEntity> patientFinalizeProfilesEntities =
					this.patientSupportingDocumentRepository.findAllById(entity.getPatientFinalizeProfilesIds());
			entityToUpdate.setPatientFinalizeProfiles(Sets.newHashSet(patientFinalizeProfilesEntities));
		}
		if (persistRelations && !entity.getPatientFinalizeProfiles().isEmpty()) {
			Set<PatientSupportingDocumentEntity> updatedEntities = new HashSet<>();
			entity.getPatientFinalizeProfiles().forEach(model -> {
				if (model.getId() != null) {
					model = this.patientSupportingDocumentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPatientFinalizeProfiles(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getRetailPharmaciesIds().isEmpty() && entity.getRetailPharmacies().isEmpty()) {
			entityToUpdate.setRetailPharmacies(new HashSet<>());
		} else if (!entity.getRetailPharmaciesIds().isEmpty() && entity.getRetailPharmacies().isEmpty()) {
			Iterable<RetailPharmacyEntity> retailPharmaciesEntities =
					this.retailPharmacyRepository.findAllById(entity.getRetailPharmaciesIds());
			entityToUpdate.setRetailPharmacies(Sets.newHashSet(retailPharmaciesEntities));
		}
		if (persistRelations && !entity.getRetailPharmacies().isEmpty()) {
			Set<RetailPharmacyEntity> updatedEntities = new HashSet<>();
			entity.getRetailPharmacies().forEach(model -> {
				if (model.getId() != null) {
					model = this.retailPharmacyRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRetailPharmacies(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getVisitsIds().isEmpty() && entity.getVisits().isEmpty()) {
			entityToUpdate.setVisits(new HashSet<>());
		} else if (!entity.getVisitsIds().isEmpty() && entity.getVisits().isEmpty()) {
			Iterable<PatientVisitEntity> visitsEntities =
					this.patientVisitRepository.findAllById(entity.getVisitsIds());
			entityToUpdate.setVisits(Sets.newHashSet(visitsEntities));
		}
		if (persistRelations && !entity.getVisits().isEmpty()) {
			Set<PatientVisitEntity> updatedEntities = new HashSet<>();
			entity.getVisits().forEach(model -> {
				if (model.getId() != null) {
					model = this.patientVisitRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setVisits(updatedEntities);
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
	public void validateEntity(PatientGeneralInfoEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PatientGeneralInfoEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByPatientIDOpt = this.findByPatientID(entity.getPatientID());
			if (entityByPatientIDOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<PatientGeneralInfoEntity>(
						"Patient ID",
						entity.getPatientID(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"PatientID"
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
	 * Get the sort as given by the sort by for the PatientGeneralInfoEntity.
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

	public Set<String> validateEntityRelations(PatientGeneralInfoEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		for (UUID id : entity.getBpjsClaimSubmissionsIds()) {
			if (this.bpjsClaimSubmissionRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a BPJS Claim Submission Entity");
			}
		}

		for (UUID id : entity.getCashRefundsIds()) {
			if (this.cashRefundRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Cash Refund Entity");
			}
		}

		for (UUID id : entity.getInformedConsentsIds()) {
			if (this.informedConsentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Informed Consent Entity");
			}
		}

		for (UUID id : entity.getInvoiceReceiptsIds()) {
			if (this.cashReceiptRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Cash Receipt Entity");
			}
		}

		for (UUID id : entity.getPatientCaseHistoriesIds()) {
			if (this.patientCaseHistoryRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Patient Case History Entity");
			}
		}

		for (UUID id : entity.getPatientConsentsIds()) {
			if (this.patientConsentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Patient Consent Entity");
			}
		}

		if (entity.getPatientContactInformationId() != null && this.patientContactInfoRepository.findById(entity.getPatientContactInformationId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientContactInformationId() + " is not associated with a Patient Contact Info Entity");
		}

		if (entity.getPatientDetailAddressId() != null && this.patientDetailAddressRepository.findById(entity.getPatientDetailAddressId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientDetailAddressId() + " is not associated with a Patient Detail Address Entity");
		}

		if (entity.getPatientDetailId() != null && this.patientDetailRepository.findById(entity.getPatientDetailId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientDetailId() + " is not associated with a Patient Detail Entity");
		}

		if (entity.getPatientEmergencyContactDetailId() != null && this.patientEmergencyContactDetailRepository.findById(entity.getPatientEmergencyContactDetailId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientEmergencyContactDetailId() + " is not associated with a Patient Emergency Contact Detail Entity");
		}

		if (entity.getPatientEmploymentDetailId() != null && this.patientEmploymentDetailRepository.findById(entity.getPatientEmploymentDetailId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientEmploymentDetailId() + " is not associated with a Patient Employment Detail  Entity");
		}

		for (UUID id : entity.getPatientFinalizeProfilesIds()) {
			if (this.patientSupportingDocumentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Patient Supporting Document Entity");
			}
		}

		if (entity.getPatientPaymentBPJSId() != null && this.patientPaymentBPJSRepository.findById(entity.getPatientPaymentBPJSId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientPaymentBPJSId() + " is not associated with a Patient Payment BPJS Entity");
		}

		if (entity.getPatientPaymentTypeInsuranceId() != null && this.patientPaymentInsuranceRepository.findById(entity.getPatientPaymentTypeInsuranceId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientPaymentTypeInsuranceId() + " is not associated with a Patient Payment Insurance Entity");
		}

		if (entity.getPatientPaymentTypeOthersId() != null && this.patientPaymentOthersRepository.findById(entity.getPatientPaymentTypeOthersId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientPaymentTypeOthersId() + " is not associated with a Patient Payment Others Entity");
		}

		if (entity.getPatientPersonalInformationId() != null && this.patientPersonalInfoRepository.findById(entity.getPatientPersonalInformationId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientPersonalInformationId() + " is not associated with a Patient Personal Info Entity");
		}

		if (entity.getPatientSelfPayingId() != null && this.patientPaymentSelfPayingRepository.findById(entity.getPatientSelfPayingId()).isEmpty()) {
			errors.add("The UUID " + entity.getPatientSelfPayingId() + " is not associated with a Patient Payment  Self Paying Entity");
		}

		for (UUID id : entity.getRetailPharmaciesIds()) {
			if (this.retailPharmacyRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Retail Pharmacy Entity");
			}
		}

		for (UUID id : entity.getVisitsIds()) {
			if (this.patientVisitRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Patient Visit Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
