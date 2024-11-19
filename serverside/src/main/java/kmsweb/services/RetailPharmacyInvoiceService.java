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
import kmsweb.repositories.RetailPharmacyInvoiceRepository;
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
import kmsweb.entities.CashReceiptEntity;
import kmsweb.repositories.CashReceiptRepository;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.entities.InvoiceSummaryEntity;
import kmsweb.repositories.InvoiceSummaryRepository;
import kmsweb.entities.RetailPharmacyEntity;
import kmsweb.repositories.RetailPharmacyRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class RetailPharmacyInvoiceService extends AbstractService<RetailPharmacyInvoiceEntity, RetailPharmacyInvoiceRepository, RetailPharmacyInvoiceEntityAudit> {

	private final String[] referenceNamesInRetailPharmacyInvoiceEntity = {
		"cashReceipts",
		"invoiceItems",
		"invoiceSummary",
		"retailPharmacy",
	};

	private final CashReceiptRepository cashReceiptRepository;

	private final InvoiceItemRepository invoiceItemRepository;

	private final InvoiceSummaryRepository invoiceSummaryRepository;

	private final RetailPharmacyRepository retailPharmacyRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public RetailPharmacyInvoiceService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		CashReceiptRepository cashReceiptRepository,
		InvoiceItemRepository invoiceItemRepository,
		InvoiceSummaryRepository invoiceSummaryRepository,
		RetailPharmacyRepository retailPharmacyRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		RetailPharmacyInvoiceRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.cashReceiptRepository = cashReceiptRepository;

		this.invoiceItemRepository = invoiceItemRepository;

		this.invoiceSummaryRepository = invoiceSummaryRepository;

		this.retailPharmacyRepository = retailPharmacyRepository;

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByInvoiceNumber(String invoiceNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceNumber here] end
	{
		// % protected region % [Add any additional logic for findByInvoiceNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByInvoiceNumber before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByInvoiceNumber(invoiceNumber));

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByRevisionNumber(Integer revisionNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByRevisionNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRevisionNumber here] end
	{
		// % protected region % [Add any additional logic for findByRevisionNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByRevisionNumber before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByRevisionNumber(revisionNumber));

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByInvoiceStatus(String invoiceStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceStatus here] end
	{
		// % protected region % [Add any additional logic for findByInvoiceStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByInvoiceStatus before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByInvoiceStatus(invoiceStatus));

		// % protected region % [Add any additional logic for findByInvoiceStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInvoiceStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Date.
	 *
	 * @param invoiceDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Date
	 */
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByInvoiceDate(OffsetDateTime invoiceDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceDate here] end
	{
		// % protected region % [Add any additional logic for findByInvoiceDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByInvoiceDate before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByInvoiceDate(invoiceDate));

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByCancelDate(OffsetDateTime cancelDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByCancelDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCancelDate here] end
	{
		// % protected region % [Add any additional logic for findByCancelDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByCancelDate before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByCancelDate(cancelDate));

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByBillingLocation(String billingLocation)
	// % protected region % [Add any throwables, implementations, or extensions for findByBillingLocation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBillingLocation here] end
	{
		// % protected region % [Add any additional logic for findByBillingLocation before the main body here] off begin
		// % protected region % [Add any additional logic for findByBillingLocation before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByBillingLocation(billingLocation));

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByPatientPaymentType(String patientPaymentType)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientPaymentType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientPaymentType here] end
	{
		// % protected region % [Add any additional logic for findByPatientPaymentType before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientPaymentType before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByPatientPaymentType(patientPaymentType));

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByVerificationDate(OffsetDateTime verificationDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByVerificationDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVerificationDate here] end
	{
		// % protected region % [Add any additional logic for findByVerificationDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByVerificationDate before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByVerificationDate(verificationDate));

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByDisplayDoctorOnPrint(Boolean displayDoctorOnPrint)
	// % protected region % [Add any throwables, implementations, or extensions for findByDisplayDoctorOnPrint here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDisplayDoctorOnPrint here] end
	{
		// % protected region % [Add any additional logic for findByDisplayDoctorOnPrint before the main body here] off begin
		// % protected region % [Add any additional logic for findByDisplayDoctorOnPrint before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByDisplayDoctorOnPrint(displayDoctorOnPrint));

		// % protected region % [Add any additional logic for findByDisplayDoctorOnPrint before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDisplayDoctorOnPrint before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Claim No.
	 *
	 * @param claimNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Claim No
	 */
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByClaimNo(String claimNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByClaimNo here] end
	{
		// % protected region % [Add any additional logic for findByClaimNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByClaimNo before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByClaimNo(claimNo));

		// % protected region % [Add any additional logic for findByClaimNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByClaimNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Payment Status.
	 *
	 * @param paymentStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Payment Status
	 */
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByPaymentStatus(String paymentStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPaymentStatus here] end
	{
		// % protected region % [Add any additional logic for findByPaymentStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByPaymentStatus before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByPaymentStatus(paymentStatus));

		// % protected region % [Add any additional logic for findByPaymentStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPaymentStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Invoice Amount.
	 *
	 * @param invoiceAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Invoice Amount
	 */
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByInvoiceAmount(Double invoiceAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInvoiceAmount here] end
	{
		// % protected region % [Add any additional logic for findByInvoiceAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByInvoiceAmount before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByInvoiceAmount(invoiceAmount));

		// % protected region % [Add any additional logic for findByInvoiceAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInvoiceAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Outstanding Amount.
	 *
	 * @param outstandingAmount the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Outstanding Amount
	 */
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByOutstandingAmount(Double outstandingAmount)
	// % protected region % [Add any throwables, implementations, or extensions for findByOutstandingAmount here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOutstandingAmount here] end
	{
		// % protected region % [Add any additional logic for findByOutstandingAmount before the main body here] off begin
		// % protected region % [Add any additional logic for findByOutstandingAmount before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByOutstandingAmount(outstandingAmount));

		// % protected region % [Add any additional logic for findByOutstandingAmount before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOutstandingAmount before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Customer Name.
	 *
	 * @param customerName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Customer Name
	 */
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findByCustomerName(String customerName)
	// % protected region % [Add any throwables, implementations, or extensions for findByCustomerName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCustomerName here] end
	{
		// % protected region % [Add any additional logic for findByCustomerName before the main body here] off begin
		// % protected region % [Add any additional logic for findByCustomerName before the main body here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findByCustomerName(customerName));

		// % protected region % [Add any additional logic for findByCustomerName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCustomerName before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<RetailPharmacyInvoiceEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<RetailPharmacyInvoiceEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<RetailPharmacyInvoiceEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'create')")
	public RetailPharmacyInvoiceEntity create(RetailPharmacyInvoiceEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		RetailPharmacyInvoiceEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'create')")
	public RetailPharmacyInvoiceEntity create(RetailPharmacyInvoiceEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		RetailPharmacyInvoiceEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		RetailPharmacyInvoiceEntity newEntity;

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'create')")
	public List<RetailPharmacyInvoiceEntity> createAll(Iterable<RetailPharmacyInvoiceEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<RetailPharmacyInvoiceEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<RetailPharmacyInvoiceEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'update')")
	public RetailPharmacyInvoiceEntity update(RetailPharmacyInvoiceEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		RetailPharmacyInvoiceEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'update')")
	public RetailPharmacyInvoiceEntity update(RetailPharmacyInvoiceEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		RetailPharmacyInvoiceEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		RetailPharmacyInvoiceEntity newEntity;

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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'update')")
	public List<RetailPharmacyInvoiceEntity> updateAll(Iterable<RetailPharmacyInvoiceEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<RetailPharmacyInvoiceEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<RetailPharmacyInvoiceEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'create') or hasPermission('RetailPharmacyInvoiceEntity', 'update')")
	public RetailPharmacyInvoiceEntity save(RetailPharmacyInvoiceEntity entity) throws ConstraintViolationException
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

		RetailPharmacyInvoiceEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'create') or hasPermission('RetailPharmacyInvoiceEntity', 'update')")
	public List<RetailPharmacyInvoiceEntity> saveAll(Iterable<RetailPharmacyInvoiceEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<RetailPharmacyInvoiceEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'delete')")
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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'delete')")
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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	public List<RetailPharmacyInvoiceEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	public List<RetailPharmacyInvoiceEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(RetailPharmacyInvoiceEntity.class);

		// % protected region % [Add any additional processing before converting to a list of RetailPharmacyInvoiceEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of RetailPharmacyInvoiceEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('RetailPharmacyInvoiceEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<RetailPharmacyInvoiceEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of RetailPharmacyInvoiceEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of RetailPharmacyInvoiceEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(RetailPharmacyInvoiceEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of RetailPharmacyInvoiceEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of RetailPharmacyInvoiceEntityAudits
	 */
	private List<RetailPharmacyInvoiceEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<RetailPharmacyInvoiceEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param retailPharmacyInvoice retailPharmacyInvoice to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private RetailPharmacyInvoiceEntity updateAuditData(RetailPharmacyInvoiceEntity retailPharmacyInvoice)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return retailPharmacyInvoice;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private RetailPharmacyInvoiceEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		RetailPharmacyInvoiceEntity entityAtRevision = updateAuditData((RetailPharmacyInvoiceEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new RetailPharmacyInvoiceEntityAudit(
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

		QRetailPharmacyInvoiceEntity entity = QRetailPharmacyInvoiceEntity.retailPharmacyInvoiceEntity;

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
			case "invoiceSummaryId":
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Invoice Summary here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Invoice Summary here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceSummary.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Invoice Summary here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Invoice Summary here] end

				break;
			case "retailPharmacyId":
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy to Retail Pharmacy Invoices here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy to Retail Pharmacy Invoices here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.retailPharmacy.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy to Retail Pharmacy Invoices here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy to Retail Pharmacy Invoices here] end

				break;
			case "cashReceiptsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Cash Receipts here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Cash Receipts here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.cashReceipts.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Cash Receipts here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Cash Receipts here] end

				break;
			case "invoiceItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Retail Pharmacy Invoice to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Retail Pharmacy Invoice to Invoice Items here] end

				break;
			case "revisionNumber":
				// % protected region % [Add any additional logic before the query parameters of revisionNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of revisionNumber here] end


				// % protected region % [Add any additional logic after the query parameters of revisionNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of revisionNumber here] end

				break;
			case "invoiceStatus":
				// % protected region % [Add any additional logic before the query parameters of invoiceStatus here] off begin
				// % protected region % [Add any additional logic before the query parameters of invoiceStatus here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceStatus, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of invoiceStatus here] off begin
				// % protected region % [Add any additional logic after the query parameters of invoiceStatus here] end

				break;
			case "invoiceDate":
				// % protected region % [Add any additional logic before the query parameters of invoiceDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of invoiceDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of invoiceDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of invoiceDate here] end

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
	public RetailPharmacyInvoiceEntity updateOldData(RetailPharmacyInvoiceEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public RetailPharmacyInvoiceEntity updateOldData(RetailPharmacyInvoiceEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		RetailPharmacyInvoiceEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInRetailPharmacyInvoiceEntity);

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
				entityToUpdate.getInvoiceSummary().unsetRetailPharmacyInvoice();
			}
		}

		// Incoming One to Many reference
		if (entity.getRetailPharmacy() == null && entity.getRetailPharmacyId() == null) {
			entityToUpdate.unsetRetailPharmacy();
		} else if (entity.getRetailPharmacyId() != null && entity.getRetailPharmacy() == null) {
			Optional<RetailPharmacyEntity> retailPharmacyEntity = this.retailPharmacyRepository.findById(entity.getRetailPharmacyId());
			entityToUpdate.setRetailPharmacy(retailPharmacyEntity.orElseThrow());
		}
		if (persistRelations && entity.getRetailPharmacy() != null) {
			entityToUpdate.setRetailPharmacy(entity.getRetailPharmacy(), false);
			if (entityToUpdate.getRetailPharmacyId() != null) {
				this.retailPharmacyRepository.save(entityToUpdate.getRetailPharmacy());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getRetailPharmacy().unsetRetailPharmacyInvoices();
			}
		}

		// Outgoing one to many reference
		if (entity.getCashReceiptsIds().isEmpty() && entity.getCashReceipts().isEmpty()) {
			entityToUpdate.setCashReceipts(new HashSet<>());
		} else if (!entity.getCashReceiptsIds().isEmpty() && entity.getCashReceipts().isEmpty()) {
			Iterable<CashReceiptEntity> cashReceiptsEntities =
					this.cashReceiptRepository.findAllById(entity.getCashReceiptsIds());
			entityToUpdate.setCashReceipts(Sets.newHashSet(cashReceiptsEntities));
		}
		if (persistRelations && !entity.getCashReceipts().isEmpty()) {
			Set<CashReceiptEntity> updatedEntities = new HashSet<>();
			entity.getCashReceipts().forEach(model -> {
				if (model.getId() != null) {
					model = this.cashReceiptRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCashReceipts(updatedEntities);
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
	public void validateEntity(RetailPharmacyInvoiceEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<RetailPharmacyInvoiceEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the RetailPharmacyInvoiceEntity.
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

	public Set<String> validateEntityRelations(RetailPharmacyInvoiceEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getRetailPharmacyId() != null && this.retailPharmacyRepository.findById(entity.getRetailPharmacyId()).isEmpty()) {
			errors.add("The UUID " + entity.getRetailPharmacyId() + " is not associated with a Retail Pharmacy Entity");
		}

		for (UUID id : entity.getCashReceiptsIds()) {
			if (this.cashReceiptRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Cash Receipt Entity");
			}
		}

		for (UUID id : entity.getInvoiceItemsIds()) {
			if (this.invoiceItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Item Entity");
			}
		}

		if (entity.getInvoiceSummaryId() != null && this.invoiceSummaryRepository.findById(entity.getInvoiceSummaryId()).isEmpty()) {
			errors.add("The UUID " + entity.getInvoiceSummaryId() + " is not associated with a Invoice Summary Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
