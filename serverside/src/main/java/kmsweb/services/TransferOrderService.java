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
import kmsweb.repositories.TransferOrderRepository;
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
import kmsweb.entities.TransferOrderStockDetailEntity;
import kmsweb.repositories.TransferOrderStockDetailRepository;
import kmsweb.entities.WarehouseEntity;
import kmsweb.repositories.WarehouseRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class TransferOrderService extends AbstractService<TransferOrderEntity, TransferOrderRepository, TransferOrderEntityAudit> {

	private final String[] referenceNamesInTransferOrderEntity = {
		"transferOrderStockDetails",
		"destinationWarehouse",
		"sourceWarehouse",
	};

	private final TransferOrderStockDetailRepository transferOrderStockDetailRepository;

	private final WarehouseRepository warehouseRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public TransferOrderService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		TransferOrderStockDetailRepository transferOrderStockDetailRepository,
		WarehouseRepository warehouseRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		TransferOrderRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.transferOrderStockDetailRepository = transferOrderStockDetailRepository;

		this.warehouseRepository = warehouseRepository;

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
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
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
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Transfer Order Number.
	 *
	 * @param transferOrderNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transfer Order Number
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByTransferOrderNumber(String transferOrderNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransferOrderNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransferOrderNumber here] end
	{
		// % protected region % [Add any additional logic for findByTransferOrderNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransferOrderNumber before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByTransferOrderNumber(transferOrderNumber));

		// % protected region % [Add any additional logic for findByTransferOrderNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransferOrderNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Status.
	 *
	 * @param transactionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Status
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByTransactionStatus(String transactionStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionStatus here] end
	{
		// % protected region % [Add any additional logic for findByTransactionStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionStatus before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByTransactionStatus(transactionStatus));

		// % protected region % [Add any additional logic for findByTransactionStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approval Status.
	 *
	 * @param approvalStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Status
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByApprovalStatus(String approvalStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalStatus here] end
	{
		// % protected region % [Add any additional logic for findByApprovalStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByApprovalStatus before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByApprovalStatus(approvalStatus));

		// % protected region % [Add any additional logic for findByApprovalStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApprovalStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Order Date.
	 *
	 * @param orderDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Order Date
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByOrderDate(OffsetDateTime orderDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByOrderDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOrderDate here] end
	{
		// % protected region % [Add any additional logic for findByOrderDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByOrderDate before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByOrderDate(orderDate));

		// % protected region % [Add any additional logic for findByOrderDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOrderDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Expected Date.
	 *
	 * @param expectedDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expected Date
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByExpectedDate(OffsetDateTime expectedDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByExpectedDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExpectedDate here] end
	{
		// % protected region % [Add any additional logic for findByExpectedDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByExpectedDate before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByExpectedDate(expectedDate));

		// % protected region % [Add any additional logic for findByExpectedDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExpectedDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Reference Number.
	 *
	 * @param referenceNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Number
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByReferenceNumber(String referenceNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceNumber here] end
	{
		// % protected region % [Add any additional logic for findByReferenceNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferenceNumber before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByReferenceNumber(referenceNumber));

		// % protected region % [Add any additional logic for findByReferenceNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferenceNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Void Date.
	 *
	 * @param voidDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Void Date
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByVoidDate(OffsetDateTime voidDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidDate here] end
	{
		// % protected region % [Add any additional logic for findByVoidDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByVoidDate before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByVoidDate(voidDate));

		// % protected region % [Add any additional logic for findByVoidDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVoidDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Reference Document.
	 *
	 * @param referenceDocument the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Document
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByReferenceDocument(String referenceDocument)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceDocument here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceDocument here] end
	{
		// % protected region % [Add any additional logic for findByReferenceDocument before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferenceDocument before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByReferenceDocument(referenceDocument));

		// % protected region % [Add any additional logic for findByReferenceDocument before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferenceDocument before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Required Date.
	 *
	 * @param requiredDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Required Date
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByRequiredDate(OffsetDateTime requiredDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByRequiredDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRequiredDate here] end
	{
		// % protected region % [Add any additional logic for findByRequiredDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByRequiredDate before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByRequiredDate(requiredDate));

		// % protected region % [Add any additional logic for findByRequiredDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRequiredDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Issued Date Time.
	 *
	 * @param issuedDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Issued Date Time
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByIssuedDateTime(OffsetDateTime issuedDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByIssuedDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIssuedDateTime here] end
	{
		// % protected region % [Add any additional logic for findByIssuedDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByIssuedDateTime before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByIssuedDateTime(issuedDateTime));

		// % protected region % [Add any additional logic for findByIssuedDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIssuedDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Received Date Time.
	 *
	 * @param receivedDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Received Date Time
	 */
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findByReceivedDateTime(OffsetDateTime receivedDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByReceivedDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReceivedDateTime here] end
	{
		// % protected region % [Add any additional logic for findByReceivedDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByReceivedDateTime before the main body here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findByReceivedDateTime(receivedDateTime));

		// % protected region % [Add any additional logic for findByReceivedDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReceivedDateTime before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<TransferOrderEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<TransferOrderEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<TransferOrderEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<TransferOrderEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TransferOrderEntity', 'create')")
	public TransferOrderEntity create(TransferOrderEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		TransferOrderEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TransferOrderEntity', 'create')")
	public TransferOrderEntity create(TransferOrderEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		TransferOrderEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		TransferOrderEntity newEntity;

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
	@PreAuthorize("hasPermission('TransferOrderEntity', 'create')")
	public List<TransferOrderEntity> createAll(Iterable<TransferOrderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<TransferOrderEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<TransferOrderEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TransferOrderEntity', 'update')")
	public TransferOrderEntity update(TransferOrderEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		TransferOrderEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TransferOrderEntity', 'update')")
	public TransferOrderEntity update(TransferOrderEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		TransferOrderEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		TransferOrderEntity newEntity;

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
	@PreAuthorize("hasPermission('TransferOrderEntity', 'update')")
	public List<TransferOrderEntity> updateAll(Iterable<TransferOrderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<TransferOrderEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<TransferOrderEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderEntity', 'create') or hasPermission('TransferOrderEntity', 'update')")
	public TransferOrderEntity save(TransferOrderEntity entity) throws ConstraintViolationException
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

		TransferOrderEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderEntity', 'create') or hasPermission('TransferOrderEntity', 'update')")
	public List<TransferOrderEntity> saveAll(Iterable<TransferOrderEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<TransferOrderEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TransferOrderEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	public List<TransferOrderEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	public List<TransferOrderEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TransferOrderEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(TransferOrderEntity.class);

		// % protected region % [Add any additional processing before converting to a list of TransferOrderEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of TransferOrderEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TransferOrderEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of TransferOrderEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of TransferOrderEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(TransferOrderEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of TransferOrderEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of TransferOrderEntityAudits
	 */
	private List<TransferOrderEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<TransferOrderEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param transferOrder transferOrder to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private TransferOrderEntity updateAuditData(TransferOrderEntity transferOrder)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return transferOrder;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private TransferOrderEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		TransferOrderEntity entityAtRevision = updateAuditData((TransferOrderEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new TransferOrderEntityAudit(
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

		QTransferOrderEntity entity = QTransferOrderEntity.transferOrderEntity;

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
			case "destinationWarehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Destination Warehouse to Destination Warehouses here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Destination Warehouse to Destination Warehouses here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.destinationWarehouse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Destination Warehouse to Destination Warehouses here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Destination Warehouse to Destination Warehouses here] end

				break;
			case "sourceWarehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Source Warehouse to Source Warehouses here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Source Warehouse to Source Warehouses here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.sourceWarehouse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Source Warehouse to Source Warehouses here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Source Warehouse to Source Warehouses here] end

				break;
			case "transferOrderStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Transfer Order to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Transfer Order to Transfer Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transferOrderStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Transfer Order to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Transfer Order to Transfer Order Stock Details here] end

				break;
			case "transferOrderNumber":
				// % protected region % [Add any additional logic before the query parameters of transferOrderNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of transferOrderNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transferOrderNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of transferOrderNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of transferOrderNumber here] end

				break;
			case "transactionStatus":
				// % protected region % [Add any additional logic before the query parameters of transactionStatus here] off begin
				// % protected region % [Add any additional logic before the query parameters of transactionStatus here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionStatus, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of transactionStatus here] off begin
				// % protected region % [Add any additional logic after the query parameters of transactionStatus here] end

				break;
			case "approvalStatus":
				// % protected region % [Add any additional logic before the query parameters of approvalStatus here] off begin
				// % protected region % [Add any additional logic before the query parameters of approvalStatus here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.approvalStatus, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of approvalStatus here] off begin
				// % protected region % [Add any additional logic after the query parameters of approvalStatus here] end

				break;
			case "orderDate":
				// % protected region % [Add any additional logic before the query parameters of orderDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of orderDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.orderDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of orderDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of orderDate here] end

				break;
			case "expectedDate":
				// % protected region % [Add any additional logic before the query parameters of expectedDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of expectedDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.expectedDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of expectedDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of expectedDate here] end

				break;
			case "referenceNumber":
				// % protected region % [Add any additional logic before the query parameters of referenceNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of referenceNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referenceNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referenceNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of referenceNumber here] end

				break;
			case "notes":
				// % protected region % [Add any additional logic before the query parameters of notes here] off begin
				// % protected region % [Add any additional logic before the query parameters of notes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.notes, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of notes here] off begin
				// % protected region % [Add any additional logic after the query parameters of notes here] end

				break;
			case "voidDate":
				// % protected region % [Add any additional logic before the query parameters of voidDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of voidDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.voidDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of voidDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of voidDate here] end

				break;
			case "referenceDocument":
				// % protected region % [Add any additional logic before the query parameters of referenceDocument here] off begin
				// % protected region % [Add any additional logic before the query parameters of referenceDocument here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.referenceDocument, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of referenceDocument here] off begin
				// % protected region % [Add any additional logic after the query parameters of referenceDocument here] end

				break;
			case "requiredDate":
				// % protected region % [Add any additional logic before the query parameters of requiredDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of requiredDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.requiredDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of requiredDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of requiredDate here] end

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
	public TransferOrderEntity updateOldData(TransferOrderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public TransferOrderEntity updateOldData(TransferOrderEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		TransferOrderEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInTransferOrderEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getDestinationWarehouse() == null && entity.getDestinationWarehouseId() == null) {
			entityToUpdate.unsetDestinationWarehouse();
		} else if (entity.getDestinationWarehouseId() != null && entity.getDestinationWarehouse() == null) {
			Optional<WarehouseEntity> destinationWarehouseEntity = this.warehouseRepository.findById(entity.getDestinationWarehouseId());
			entityToUpdate.setDestinationWarehouse(destinationWarehouseEntity.orElseThrow());
		}
		if (persistRelations && entity.getDestinationWarehouse() != null) {
			entityToUpdate.setDestinationWarehouse(entity.getDestinationWarehouse(), false);
			if (entityToUpdate.getDestinationWarehouseId() != null) {
				this.warehouseRepository.save(entityToUpdate.getDestinationWarehouse());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDestinationWarehouse().unsetDestinationWarehouses();
			}
		}

		// Incoming One to Many reference
		if (entity.getSourceWarehouse() == null && entity.getSourceWarehouseId() == null) {
			entityToUpdate.unsetSourceWarehouse();
		} else if (entity.getSourceWarehouseId() != null && entity.getSourceWarehouse() == null) {
			Optional<WarehouseEntity> sourceWarehouseEntity = this.warehouseRepository.findById(entity.getSourceWarehouseId());
			entityToUpdate.setSourceWarehouse(sourceWarehouseEntity.orElseThrow());
		}
		if (persistRelations && entity.getSourceWarehouse() != null) {
			entityToUpdate.setSourceWarehouse(entity.getSourceWarehouse(), false);
			if (entityToUpdate.getSourceWarehouseId() != null) {
				this.warehouseRepository.save(entityToUpdate.getSourceWarehouse());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSourceWarehouse().unsetSourceWarehouses();
			}
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
	public void validateEntity(TransferOrderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<TransferOrderEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the TransferOrderEntity.
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

	public Set<String> validateEntityRelations(TransferOrderEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getDestinationWarehouseId() != null && this.warehouseRepository.findById(entity.getDestinationWarehouseId()).isEmpty()) {
			errors.add("The UUID " + entity.getDestinationWarehouseId() + " is not associated with a Warehouse Entity");
		}

		if (entity.getSourceWarehouseId() != null && this.warehouseRepository.findById(entity.getSourceWarehouseId()).isEmpty()) {
			errors.add("The UUID " + entity.getSourceWarehouseId() + " is not associated with a Warehouse Entity");
		}

		for (UUID id : entity.getTransferOrderStockDetailsIds()) {
			if (this.transferOrderStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Transfer Order Stock Detail Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}