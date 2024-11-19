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
import kmsweb.repositories.PurchaseRequisitionRepository;
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
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.entities.PurchaseRequisitionStockDetailEntity;
import kmsweb.repositories.PurchaseRequisitionStockDetailRepository;
import kmsweb.entities.SupplierEntity;
import kmsweb.repositories.SupplierRepository;
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
public class PurchaseRequisitionService extends AbstractService<PurchaseRequisitionEntity, PurchaseRequisitionRepository, PurchaseRequisitionEntityAudit> {

	private final String[] referenceNamesInPurchaseRequisitionEntity = {
		"purchaseRequisitionStockDetails",
		"purchaseOrder",
		"supplier",
		"warehouse",
	};

	private final PurchaseOrderRepository purchaseOrderRepository;

	private final PurchaseRequisitionStockDetailRepository purchaseRequisitionStockDetailRepository;

	private final SupplierRepository supplierRepository;

	private final WarehouseRepository warehouseRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PurchaseRequisitionService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		PurchaseOrderRepository purchaseOrderRepository,
		PurchaseRequisitionStockDetailRepository purchaseRequisitionStockDetailRepository,
		SupplierRepository supplierRepository,
		WarehouseRepository warehouseRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PurchaseRequisitionRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.purchaseOrderRepository = purchaseOrderRepository;

		this.purchaseRequisitionStockDetailRepository = purchaseRequisitionStockDetailRepository;

		this.supplierRepository = supplierRepository;

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
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
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
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Purchase Requisition Number.
	 *
	 * @param purchaseRequisitionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Purchase Requisition Number
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findByPurchaseRequisitionNumber(String purchaseRequisitionNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseRequisitionNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPurchaseRequisitionNumber here] end
	{
		// % protected region % [Add any additional logic for findByPurchaseRequisitionNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByPurchaseRequisitionNumber before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findByPurchaseRequisitionNumber(purchaseRequisitionNumber));

		// % protected region % [Add any additional logic for findByPurchaseRequisitionNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPurchaseRequisitionNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Status.
	 *
	 * @param transactionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Status
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findByTransactionStatus(String transactionStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionStatus here] end
	{
		// % protected region % [Add any additional logic for findByTransactionStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionStatus before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findByTransactionStatus(transactionStatus));

		// % protected region % [Add any additional logic for findByTransactionStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Reference Document.
	 *
	 * @param referenceDocument the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Reference Document
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findByReferenceDocument(String referenceDocument)
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceDocument here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReferenceDocument here] end
	{
		// % protected region % [Add any additional logic for findByReferenceDocument before the main body here] off begin
		// % protected region % [Add any additional logic for findByReferenceDocument before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findByReferenceDocument(referenceDocument));

		// % protected region % [Add any additional logic for findByReferenceDocument before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReferenceDocument before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Order Date.
	 *
	 * @param orderDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Order Date
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findByOrderDate(OffsetDateTime orderDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByOrderDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOrderDate here] end
	{
		// % protected region % [Add any additional logic for findByOrderDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByOrderDate before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findByOrderDate(orderDate));

		// % protected region % [Add any additional logic for findByOrderDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOrderDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Required Date.
	 *
	 * @param requiredDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Required Date
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findByRequiredDate(OffsetDateTime requiredDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByRequiredDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRequiredDate here] end
	{
		// % protected region % [Add any additional logic for findByRequiredDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByRequiredDate before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findByRequiredDate(requiredDate));

		// % protected region % [Add any additional logic for findByRequiredDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRequiredDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Estimation Order.
	 *
	 * @param totalEstimationOrder the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Estimation Order
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findByTotalEstimationOrder(Double totalEstimationOrder)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalEstimationOrder here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalEstimationOrder here] end
	{
		// % protected region % [Add any additional logic for findByTotalEstimationOrder before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalEstimationOrder before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findByTotalEstimationOrder(totalEstimationOrder));

		// % protected region % [Add any additional logic for findByTotalEstimationOrder before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalEstimationOrder before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Redrafting Date Time.
	 *
	 * @param redraftingDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Redrafting Date Time
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findByRedraftingDateTime(OffsetDateTime redraftingDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByRedraftingDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRedraftingDateTime here] end
	{
		// % protected region % [Add any additional logic for findByRedraftingDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByRedraftingDateTime before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findByRedraftingDateTime(redraftingDateTime));

		// % protected region % [Add any additional logic for findByRedraftingDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRedraftingDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Submission Date Time.
	 *
	 * @param submissionDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Submission Date Time
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findBySubmissionDateTime(OffsetDateTime submissionDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubmissionDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubmissionDateTime here] end
	{
		// % protected region % [Add any additional logic for findBySubmissionDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubmissionDateTime before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findBySubmissionDateTime(submissionDateTime));

		// % protected region % [Add any additional logic for findBySubmissionDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubmissionDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approval Date Time.
	 *
	 * @param approvalDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approval Date Time
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findByApprovalDateTime(OffsetDateTime approvalDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApprovalDateTime here] end
	{
		// % protected region % [Add any additional logic for findByApprovalDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByApprovalDateTime before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findByApprovalDateTime(approvalDateTime));

		// % protected region % [Add any additional logic for findByApprovalDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApprovalDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Rejection Date Time.
	 *
	 * @param rejectionDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rejection Date Time
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findByRejectionDateTime(OffsetDateTime rejectionDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByRejectionDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRejectionDateTime here] end
	{
		// % protected region % [Add any additional logic for findByRejectionDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByRejectionDateTime before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findByRejectionDateTime(rejectionDateTime));

		// % protected region % [Add any additional logic for findByRejectionDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRejectionDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Voiding Date Time.
	 *
	 * @param voidingDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Voiding Date Time
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findByVoidingDateTime(OffsetDateTime voidingDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidingDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVoidingDateTime here] end
	{
		// % protected region % [Add any additional logic for findByVoidingDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByVoidingDateTime before the main body here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findByVoidingDateTime(voidingDateTime));

		// % protected region % [Add any additional logic for findByVoidingDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVoidingDateTime before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PurchaseRequisitionEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PurchaseRequisitionEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PurchaseRequisitionEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'create')")
	public PurchaseRequisitionEntity create(PurchaseRequisitionEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PurchaseRequisitionEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'create')")
	public PurchaseRequisitionEntity create(PurchaseRequisitionEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PurchaseRequisitionEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PurchaseRequisitionEntity newEntity;

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
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'create')")
	public List<PurchaseRequisitionEntity> createAll(Iterable<PurchaseRequisitionEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PurchaseRequisitionEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PurchaseRequisitionEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'update')")
	public PurchaseRequisitionEntity update(PurchaseRequisitionEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PurchaseRequisitionEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'update')")
	public PurchaseRequisitionEntity update(PurchaseRequisitionEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PurchaseRequisitionEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PurchaseRequisitionEntity newEntity;

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
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'update')")
	public List<PurchaseRequisitionEntity> updateAll(Iterable<PurchaseRequisitionEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PurchaseRequisitionEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PurchaseRequisitionEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'create') or hasPermission('PurchaseRequisitionEntity', 'update')")
	public PurchaseRequisitionEntity save(PurchaseRequisitionEntity entity) throws ConstraintViolationException
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

		PurchaseRequisitionEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'create') or hasPermission('PurchaseRequisitionEntity', 'update')")
	public List<PurchaseRequisitionEntity> saveAll(Iterable<PurchaseRequisitionEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PurchaseRequisitionEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	public List<PurchaseRequisitionEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	public List<PurchaseRequisitionEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PurchaseRequisitionEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PurchaseRequisitionEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PurchaseRequisitionEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PurchaseRequisitionEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PurchaseRequisitionEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PurchaseRequisitionEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PurchaseRequisitionEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PurchaseRequisitionEntityAudits
	 */
	private List<PurchaseRequisitionEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PurchaseRequisitionEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param purchaseRequisition purchaseRequisition to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PurchaseRequisitionEntity updateAuditData(PurchaseRequisitionEntity purchaseRequisition)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return purchaseRequisition;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PurchaseRequisitionEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PurchaseRequisitionEntity entityAtRevision = updateAuditData((PurchaseRequisitionEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PurchaseRequisitionEntityAudit(
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

		QPurchaseRequisitionEntity entity = QPurchaseRequisitionEntity.purchaseRequisitionEntity;

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
			case "purchaseOrderId":
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Purchase Requisitions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseOrder.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Purchase Requisitions here] end

				break;
			case "supplierId":
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Supplier to Purchase Requisitions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.supplier.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Supplier to Purchase Requisitions here] end

				break;
			case "warehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Purchase Requisitions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Purchase Requisitions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Purchase Requisitions here] end

				break;
			case "purchaseRequisitionStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Requisition to Purchase Requisition Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Requisition to Purchase Requisition Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseRequisitionStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Requisition to Purchase Requisition Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Requisition to Purchase Requisition Stock Details here] end

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
	public PurchaseRequisitionEntity updateOldData(PurchaseRequisitionEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PurchaseRequisitionEntity updateOldData(PurchaseRequisitionEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PurchaseRequisitionEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPurchaseRequisitionEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getPurchaseOrder() == null && entity.getPurchaseOrderId() == null) {
			entityToUpdate.unsetPurchaseOrder();
		} else if (entity.getPurchaseOrderId() != null && entity.getPurchaseOrder() == null) {
			Optional<PurchaseOrderEntity> purchaseOrderEntity = this.purchaseOrderRepository.findById(entity.getPurchaseOrderId());
			entityToUpdate.setPurchaseOrder(purchaseOrderEntity.orElseThrow());
		}
		if (persistRelations && entity.getPurchaseOrder() != null) {
			entityToUpdate.setPurchaseOrder(entity.getPurchaseOrder(), false);
			if (entityToUpdate.getPurchaseOrderId() != null) {
				this.purchaseOrderRepository.save(entityToUpdate.getPurchaseOrder());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPurchaseOrder().unsetPurchaseRequisitions();
			}
		}

		// Incoming One to Many reference
		if (entity.getSupplier() == null && entity.getSupplierId() == null) {
			entityToUpdate.unsetSupplier();
		} else if (entity.getSupplierId() != null && entity.getSupplier() == null) {
			Optional<SupplierEntity> supplierEntity = this.supplierRepository.findById(entity.getSupplierId());
			entityToUpdate.setSupplier(supplierEntity.orElseThrow());
		}
		if (persistRelations && entity.getSupplier() != null) {
			entityToUpdate.setSupplier(entity.getSupplier(), false);
			if (entityToUpdate.getSupplierId() != null) {
				this.supplierRepository.save(entityToUpdate.getSupplier());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getSupplier().unsetPurchaseRequisitions();
			}
		}

		// Incoming One to Many reference
		if (entity.getWarehouse() == null && entity.getWarehouseId() == null) {
			entityToUpdate.unsetWarehouse();
		} else if (entity.getWarehouseId() != null && entity.getWarehouse() == null) {
			Optional<WarehouseEntity> warehouseEntity = this.warehouseRepository.findById(entity.getWarehouseId());
			entityToUpdate.setWarehouse(warehouseEntity.orElseThrow());
		}
		if (persistRelations && entity.getWarehouse() != null) {
			entityToUpdate.setWarehouse(entity.getWarehouse(), false);
			if (entityToUpdate.getWarehouseId() != null) {
				this.warehouseRepository.save(entityToUpdate.getWarehouse());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getWarehouse().unsetPurchaseRequisitions();
			}
		}

		// Outgoing one to many reference
		if (entity.getPurchaseRequisitionStockDetailsIds().isEmpty() && entity.getPurchaseRequisitionStockDetails().isEmpty()) {
			entityToUpdate.setPurchaseRequisitionStockDetails(new HashSet<>());
		} else if (!entity.getPurchaseRequisitionStockDetailsIds().isEmpty() && entity.getPurchaseRequisitionStockDetails().isEmpty()) {
			Iterable<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetailsEntities =
					this.purchaseRequisitionStockDetailRepository.findAllById(entity.getPurchaseRequisitionStockDetailsIds());
			entityToUpdate.setPurchaseRequisitionStockDetails(Sets.newHashSet(purchaseRequisitionStockDetailsEntities));
		}
		if (persistRelations && !entity.getPurchaseRequisitionStockDetails().isEmpty()) {
			Set<PurchaseRequisitionStockDetailEntity> updatedEntities = new HashSet<>();
			entity.getPurchaseRequisitionStockDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.purchaseRequisitionStockDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPurchaseRequisitionStockDetails(updatedEntities);
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
	public void validateEntity(PurchaseRequisitionEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PurchaseRequisitionEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PurchaseRequisitionEntity.
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

	public Set<String> validateEntityRelations(PurchaseRequisitionEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPurchaseOrderId() != null && this.purchaseOrderRepository.findById(entity.getPurchaseOrderId()).isEmpty()) {
			errors.add("The UUID " + entity.getPurchaseOrderId() + " is not associated with a Purchase Order Entity");
		}

		if (entity.getSupplierId() != null && this.supplierRepository.findById(entity.getSupplierId()).isEmpty()) {
			errors.add("The UUID " + entity.getSupplierId() + " is not associated with a Supplier Entity");
		}

		if (entity.getWarehouseId() != null && this.warehouseRepository.findById(entity.getWarehouseId()).isEmpty()) {
			errors.add("The UUID " + entity.getWarehouseId() + " is not associated with a Warehouse Entity");
		}

		for (UUID id : entity.getPurchaseRequisitionStockDetailsIds()) {
			if (this.purchaseRequisitionStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Purchase Requisition Stock Detail Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
