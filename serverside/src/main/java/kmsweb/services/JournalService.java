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
import kmsweb.repositories.JournalRepository;
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

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class JournalService extends AbstractService<JournalEntity, JournalRepository, JournalEntityAudit> {

	private final String[] referenceNamesInJournalEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public JournalService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		JournalRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

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
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
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
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Journal Number.
	 *
	 * @param journalNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Journal Number
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByJournalNumber(String journalNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByJournalNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByJournalNumber here] end
	{
		// % protected region % [Add any additional logic for findByJournalNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByJournalNumber before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByJournalNumber(journalNumber));

		// % protected region % [Add any additional logic for findByJournalNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByJournalNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Date.
	 *
	 * @param transactionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Date
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByTransactionDate(OffsetDateTime transactionDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDate here] end
	{
		// % protected region % [Add any additional logic for findByTransactionDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionDate before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByTransactionDate(transactionDate));

		// % protected region % [Add any additional logic for findByTransactionDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Reference Number.
	 *
	 * @param referenceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Number
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByReferenceNumber(String referenceNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceNumber here] end
	{
		// % protected region % [Add any additional logic for findByReferenceNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferenceNumber before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByReferenceNumber(referenceNumber));

		// % protected region % [Add any additional logic for findByReferenceNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferenceNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Type.
	 *
	 * @param transactionType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Type
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByTransactionType(String transactionType)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionType here] end
	{
		// % protected region % [Add any additional logic for findByTransactionType before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionType before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByTransactionType(transactionType));

		// % protected region % [Add any additional logic for findByTransactionType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Detail Type.
	 *
	 * @param transactionDetailType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Detail Type
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByTransactionDetailType(String transactionDetailType)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDetailType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDetailType here] end
	{
		// % protected region % [Add any additional logic for findByTransactionDetailType before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionDetailType before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByTransactionDetailType(transactionDetailType));

		// % protected region % [Add any additional logic for findByTransactionDetailType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionDetailType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Account Number.
	 *
	 * @param accountNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Account Number
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByAccountNumber(String accountNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByAccountNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAccountNumber here] end
	{
		// % protected region % [Add any additional logic for findByAccountNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByAccountNumber before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByAccountNumber(accountNumber));

		// % protected region % [Add any additional logic for findByAccountNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAccountNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Debit.
	 *
	 * @param debit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Debit
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByDebit(Double debit)
	// % protected region % [Add any throwables, implementations, or extensions for findByDebit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDebit here] end
	{
		// % protected region % [Add any additional logic for findByDebit before the main body here] off begin
		// % protected region % [Add any additional logic for findByDebit before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByDebit(debit));

		// % protected region % [Add any additional logic for findByDebit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDebit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Credit.
	 *
	 * @param credit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Credit
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByCredit(Double credit)
	// % protected region % [Add any throwables, implementations, or extensions for findByCredit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCredit here] end
	{
		// % protected region % [Add any additional logic for findByCredit before the main body here] off begin
		// % protected region % [Add any additional logic for findByCredit before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByCredit(credit));

		// % protected region % [Add any additional logic for findByCredit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCredit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Posting Status.
	 *
	 * @param postingStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Posting Status
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByPostingStatus(String postingStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostingStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostingStatus here] end
	{
		// % protected region % [Add any additional logic for findByPostingStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostingStatus before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByPostingStatus(postingStatus));

		// % protected region % [Add any additional logic for findByPostingStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostingStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Posting Date Time.
	 *
	 * @param postingDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Posting Date Time
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByPostingDateTime(OffsetDateTime postingDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostingDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostingDateTime here] end
	{
		// % protected region % [Add any additional logic for findByPostingDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostingDateTime before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByPostingDateTime(postingDateTime));

		// % protected region % [Add any additional logic for findByPostingDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostingDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Supplier Number.
	 *
	 * @param supplierNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Number
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findBySupplierNumber(String supplierNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierNumber here] end
	{
		// % protected region % [Add any additional logic for findBySupplierNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findBySupplierNumber before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findBySupplierNumber(supplierNumber));

		// % protected region % [Add any additional logic for findBySupplierNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySupplierNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Supplier Name.
	 *
	 * @param supplierName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Supplier Name
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findBySupplierName(String supplierName)
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySupplierName here] end
	{
		// % protected region % [Add any additional logic for findBySupplierName before the main body here] off begin
		// % protected region % [Add any additional logic for findBySupplierName before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findBySupplierName(supplierName));

		// % protected region % [Add any additional logic for findBySupplierName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySupplierName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Customer Number.
	 *
	 * @param customerNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Customer Number
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByCustomerNumber(String customerNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByCustomerNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCustomerNumber here] end
	{
		// % protected region % [Add any additional logic for findByCustomerNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByCustomerNumber before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByCustomerNumber(customerNumber));

		// % protected region % [Add any additional logic for findByCustomerNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCustomerNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Customer Name.
	 *
	 * @param customerName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Customer Name
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByCustomerName(String customerName)
	// % protected region % [Add any throwables, implementations, or extensions for findByCustomerName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCustomerName here] end
	{
		// % protected region % [Add any additional logic for findByCustomerName before the main body here] off begin
		// % protected region % [Add any additional logic for findByCustomerName before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByCustomerName(customerName));

		// % protected region % [Add any additional logic for findByCustomerName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCustomerName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Revenue Center.
	 *
	 * @param revenueCenter the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Revenue Center
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByRevenueCenter(String revenueCenter)
	// % protected region % [Add any throwables, implementations, or extensions for findByRevenueCenter here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRevenueCenter here] end
	{
		// % protected region % [Add any additional logic for findByRevenueCenter before the main body here] off begin
		// % protected region % [Add any additional logic for findByRevenueCenter before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByRevenueCenter(revenueCenter));

		// % protected region % [Add any additional logic for findByRevenueCenter before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRevenueCenter before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findByDescription(String description)
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] end
	{
		// % protected region % [Add any additional logic for findByDescription before the main body here] off begin
		// % protected region % [Add any additional logic for findByDescription before the main body here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findByDescription(description));

		// % protected region % [Add any additional logic for findByDescription before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDescription before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<JournalEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<JournalEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<JournalEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@Transactional(readOnly = true)
	public List<JournalEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<JournalEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('JournalEntity', 'create')")
	public JournalEntity create(JournalEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		JournalEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('JournalEntity', 'create')")
	public JournalEntity create(JournalEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		JournalEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		JournalEntity newEntity;

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
	@PreAuthorize("hasPermission('JournalEntity', 'create')")
	public List<JournalEntity> createAll(Iterable<JournalEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<JournalEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<JournalEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('JournalEntity', 'update')")
	public JournalEntity update(JournalEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		JournalEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('JournalEntity', 'update')")
	public JournalEntity update(JournalEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		JournalEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		JournalEntity newEntity;

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
	@PreAuthorize("hasPermission('JournalEntity', 'update')")
	public List<JournalEntity> updateAll(Iterable<JournalEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<JournalEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<JournalEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('JournalEntity', 'create') or hasPermission('JournalEntity', 'update')")
	public JournalEntity save(JournalEntity entity) throws ConstraintViolationException
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

		JournalEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('JournalEntity', 'create') or hasPermission('JournalEntity', 'update')")
	public List<JournalEntity> saveAll(Iterable<JournalEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<JournalEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('JournalEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('JournalEntity', 'delete')")
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
	@PreAuthorize("hasPermission('JournalEntity', 'delete')")
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
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	public List<JournalEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	public List<JournalEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<JournalEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(JournalEntity.class);

		// % protected region % [Add any additional processing before converting to a list of JournalEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of JournalEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('JournalEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<JournalEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of JournalEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of JournalEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(JournalEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of JournalEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of JournalEntityAudits
	 */
	private List<JournalEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<JournalEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param journal journal to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private JournalEntity updateAuditData(JournalEntity journal)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return journal;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private JournalEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		JournalEntity entityAtRevision = updateAuditData((JournalEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new JournalEntityAudit(
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

		QJournalEntity entity = QJournalEntity.journalEntity;

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
			case "journalNumber":
				// % protected region % [Add any additional logic before the query parameters of journalNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of journalNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.journalNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of journalNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of journalNumber here] end

				break;
			case "transactionDate":
				// % protected region % [Add any additional logic before the query parameters of transactionDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of transactionDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of transactionDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of transactionDate here] end

				break;
			case "referenceNumber":
				// % protected region % [Add any additional logic before the query parameters of referenceNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of referenceNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referenceNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referenceNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of referenceNumber here] end

				break;
			case "transactionType":
				// % protected region % [Add any additional logic before the query parameters of transactionType here] off begin
				// % protected region % [Add any additional logic before the query parameters of transactionType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of transactionType here] off begin
				// % protected region % [Add any additional logic after the query parameters of transactionType here] end

				break;
			case "transactionDetailType":
				// % protected region % [Add any additional logic before the query parameters of transactionDetailType here] off begin
				// % protected region % [Add any additional logic before the query parameters of transactionDetailType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionDetailType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of transactionDetailType here] off begin
				// % protected region % [Add any additional logic after the query parameters of transactionDetailType here] end

				break;
			case "accountNumber":
				// % protected region % [Add any additional logic before the query parameters of accountNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of accountNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.accountNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of accountNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of accountNumber here] end

				break;
			case "debit":
				// % protected region % [Add any additional logic before the query parameters of debit here] off begin
				// % protected region % [Add any additional logic before the query parameters of debit here] end


				// % protected region % [Add any additional logic after the query parameters of debit here] off begin
				// % protected region % [Add any additional logic after the query parameters of debit here] end

				break;
			case "credit":
				// % protected region % [Add any additional logic before the query parameters of credit here] off begin
				// % protected region % [Add any additional logic before the query parameters of credit here] end


				// % protected region % [Add any additional logic after the query parameters of credit here] off begin
				// % protected region % [Add any additional logic after the query parameters of credit here] end

				break;
			case "postingStatus":
				// % protected region % [Add any additional logic before the query parameters of postingStatus here] off begin
				// % protected region % [Add any additional logic before the query parameters of postingStatus here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.postingStatus, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of postingStatus here] off begin
				// % protected region % [Add any additional logic after the query parameters of postingStatus here] end

				break;
			case "postingDateTime":
				// % protected region % [Add any additional logic before the query parameters of postingDateTime here] off begin
				// % protected region % [Add any additional logic before the query parameters of postingDateTime here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.postingDateTime, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of postingDateTime here] off begin
				// % protected region % [Add any additional logic after the query parameters of postingDateTime here] end

				break;
			case "supplierNumber":
				// % protected region % [Add any additional logic before the query parameters of supplierNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of supplierNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.supplierNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of supplierNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of supplierNumber here] end

				break;
			case "supplierName":
				// % protected region % [Add any additional logic before the query parameters of supplierName here] off begin
				// % protected region % [Add any additional logic before the query parameters of supplierName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.supplierName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of supplierName here] off begin
				// % protected region % [Add any additional logic after the query parameters of supplierName here] end

				break;
			case "customerNumber":
				// % protected region % [Add any additional logic before the query parameters of customerNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of customerNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.customerNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of customerNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of customerNumber here] end

				break;
			case "customerName":
				// % protected region % [Add any additional logic before the query parameters of customerName here] off begin
				// % protected region % [Add any additional logic before the query parameters of customerName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.customerName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of customerName here] off begin
				// % protected region % [Add any additional logic after the query parameters of customerName here] end

				break;
			case "revenueCenter":
				// % protected region % [Add any additional logic before the query parameters of revenueCenter here] off begin
				// % protected region % [Add any additional logic before the query parameters of revenueCenter here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.revenueCenter, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of revenueCenter here] off begin
				// % protected region % [Add any additional logic after the query parameters of revenueCenter here] end

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
	public JournalEntity updateOldData(JournalEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public JournalEntity updateOldData(JournalEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		JournalEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInJournalEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
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
	public void validateEntity(JournalEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<JournalEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the JournalEntity.
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

	public Set<String> validateEntityRelations(JournalEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
