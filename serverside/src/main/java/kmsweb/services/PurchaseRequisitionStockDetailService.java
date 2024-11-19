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
import kmsweb.repositories.PurchaseRequisitionStockDetailRepository;
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
import kmsweb.entities.PurchaseOrderStockDetailEntity;
import kmsweb.repositories.PurchaseOrderStockDetailRepository;
import kmsweb.entities.PurchaseRequisitionEntity;
import kmsweb.repositories.PurchaseRequisitionRepository;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class PurchaseRequisitionStockDetailService extends AbstractService<PurchaseRequisitionStockDetailEntity, PurchaseRequisitionStockDetailRepository, PurchaseRequisitionStockDetailEntityAudit> {

	private final String[] referenceNamesInPurchaseRequisitionStockDetailEntity = {
		"purchaseOrderStockDetails",
		"purchaseRequisition",
		"stockCatalogue",
	};

	private final PurchaseOrderStockDetailRepository purchaseOrderStockDetailRepository;

	private final PurchaseRequisitionRepository purchaseRequisitionRepository;

	private final StockCatalogueRepository stockCatalogueRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PurchaseRequisitionStockDetailService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		PurchaseOrderStockDetailRepository purchaseOrderStockDetailRepository,
		PurchaseRequisitionRepository purchaseRequisitionRepository,
		StockCatalogueRepository stockCatalogueRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PurchaseRequisitionStockDetailRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.purchaseOrderStockDetailRepository = purchaseOrderStockDetailRepository;

		this.purchaseRequisitionRepository = purchaseRequisitionRepository;

		this.stockCatalogueRepository = stockCatalogueRepository;

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
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
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
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute SOH.
	 *
	 * @param soh the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SOH
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findBySoh(Double soh)
	// % protected region % [Add any throwables, implementations, or extensions for findBySoh here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySoh here] end
	{
		// % protected region % [Add any additional logic for findBySoh before the main body here] off begin
		// % protected region % [Add any additional logic for findBySoh before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findBySoh(soh));

		// % protected region % [Add any additional logic for findBySoh before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySoh before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Max Level.
	 *
	 * @param maxLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Max Level
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findByMaxLevel(Double maxLevel)
	// % protected region % [Add any throwables, implementations, or extensions for findByMaxLevel here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMaxLevel here] end
	{
		// % protected region % [Add any additional logic for findByMaxLevel before the main body here] off begin
		// % protected region % [Add any additional logic for findByMaxLevel before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findByMaxLevel(maxLevel));

		// % protected region % [Add any additional logic for findByMaxLevel before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMaxLevel before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Requested.
	 *
	 * @param quantityRequested the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Requested
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findByQuantityRequested(Double quantityRequested)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityRequested here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityRequested here] end
	{
		// % protected region % [Add any additional logic for findByQuantityRequested before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityRequested before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityRequested(quantityRequested));

		// % protected region % [Add any additional logic for findByQuantityRequested before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantityRequested before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute UOP.
	 *
	 * @param uop the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOP
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findByUop(String uop)
	// % protected region % [Add any throwables, implementations, or extensions for findByUop here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUop here] end
	{
		// % protected region % [Add any additional logic for findByUop before the main body here] off begin
		// % protected region % [Add any additional logic for findByUop before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findByUop(uop));

		// % protected region % [Add any additional logic for findByUop before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUop before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Unit Price.
	 *
	 * @param unitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit Price
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findByUnitPrice(Double unitPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByUnitPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUnitPrice here] end
	{
		// % protected region % [Add any additional logic for findByUnitPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByUnitPrice before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findByUnitPrice(unitPrice));

		// % protected region % [Add any additional logic for findByUnitPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUnitPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Price.
	 *
	 * @param totalPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Price
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findByTotalPrice(Double totalPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalPrice here] end
	{
		// % protected region % [Add any additional logic for findByTotalPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalPrice before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findByTotalPrice(totalPrice));

		// % protected region % [Add any additional logic for findByTotalPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Item Status.
	 *
	 * @param itemStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Status
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findByItemStatus(String itemStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemStatus here] end
	{
		// % protected region % [Add any additional logic for findByItemStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemStatus before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findByItemStatus(itemStatus));

		// % protected region % [Add any additional logic for findByItemStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Ordered.
	 *
	 * @param quantityOrdered the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Ordered
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findByQuantityOrdered(Double quantityOrdered)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityOrdered here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityOrdered here] end
	{
		// % protected region % [Add any additional logic for findByQuantityOrdered before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityOrdered before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityOrdered(quantityOrdered));

		// % protected region % [Add any additional logic for findByQuantityOrdered before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantityOrdered before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Received.
	 *
	 * @param quantityReceived the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Received
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findByQuantityReceived(Double quantityReceived)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityReceived here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityReceived here] end
	{
		// % protected region % [Add any additional logic for findByQuantityReceived before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityReceived before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityReceived(quantityReceived));

		// % protected region % [Add any additional logic for findByQuantityReceived before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantityReceived before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Returned.
	 *
	 * @param quantityReturned the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Returned
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findByQuantityReturned(Double quantityReturned)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityReturned here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityReturned here] end
	{
		// % protected region % [Add any additional logic for findByQuantityReturned before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityReturned before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityReturned(quantityReturned));

		// % protected region % [Add any additional logic for findByQuantityReturned before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantityReturned before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findByItemNotes(String itemNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] end
	{
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findByItemNotes(itemNotes));

		// % protected region % [Add any additional logic for findByItemNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Remaining Quantity.
	 *
	 * @param remainingQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Remaining Quantity
	 */
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findByRemainingQuantity(Double remainingQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByRemainingQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRemainingQuantity here] end
	{
		// % protected region % [Add any additional logic for findByRemainingQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByRemainingQuantity before the main body here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findByRemainingQuantity(remainingQuantity));

		// % protected region % [Add any additional logic for findByRemainingQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRemainingQuantity before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PurchaseRequisitionStockDetailEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PurchaseRequisitionStockDetailEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PurchaseRequisitionStockDetailEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'create')")
	public PurchaseRequisitionStockDetailEntity create(PurchaseRequisitionStockDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PurchaseRequisitionStockDetailEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'create')")
	public PurchaseRequisitionStockDetailEntity create(PurchaseRequisitionStockDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PurchaseRequisitionStockDetailEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PurchaseRequisitionStockDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'create')")
	public List<PurchaseRequisitionStockDetailEntity> createAll(Iterable<PurchaseRequisitionStockDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PurchaseRequisitionStockDetailEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PurchaseRequisitionStockDetailEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'update')")
	public PurchaseRequisitionStockDetailEntity update(PurchaseRequisitionStockDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PurchaseRequisitionStockDetailEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'update')")
	public PurchaseRequisitionStockDetailEntity update(PurchaseRequisitionStockDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PurchaseRequisitionStockDetailEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PurchaseRequisitionStockDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'update')")
	public List<PurchaseRequisitionStockDetailEntity> updateAll(Iterable<PurchaseRequisitionStockDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PurchaseRequisitionStockDetailEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PurchaseRequisitionStockDetailEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'create') or hasPermission('PurchaseRequisitionStockDetailEntity', 'update')")
	public PurchaseRequisitionStockDetailEntity save(PurchaseRequisitionStockDetailEntity entity) throws ConstraintViolationException
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

		PurchaseRequisitionStockDetailEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'create') or hasPermission('PurchaseRequisitionStockDetailEntity', 'update')")
	public List<PurchaseRequisitionStockDetailEntity> saveAll(Iterable<PurchaseRequisitionStockDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PurchaseRequisitionStockDetailEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	public List<PurchaseRequisitionStockDetailEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	public List<PurchaseRequisitionStockDetailEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PurchaseRequisitionStockDetailEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PurchaseRequisitionStockDetailEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PurchaseRequisitionStockDetailEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseRequisitionStockDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PurchaseRequisitionStockDetailEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PurchaseRequisitionStockDetailEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PurchaseRequisitionStockDetailEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PurchaseRequisitionStockDetailEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PurchaseRequisitionStockDetailEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PurchaseRequisitionStockDetailEntityAudits
	 */
	private List<PurchaseRequisitionStockDetailEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PurchaseRequisitionStockDetailEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param purchaseRequisitionStockDetail purchaseRequisitionStockDetail to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PurchaseRequisitionStockDetailEntity updateAuditData(PurchaseRequisitionStockDetailEntity purchaseRequisitionStockDetail)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return purchaseRequisitionStockDetail;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PurchaseRequisitionStockDetailEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PurchaseRequisitionStockDetailEntity entityAtRevision = updateAuditData((PurchaseRequisitionStockDetailEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PurchaseRequisitionStockDetailEntityAudit(
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

		QPurchaseRequisitionStockDetailEntity entity = QPurchaseRequisitionStockDetailEntity.purchaseRequisitionStockDetailEntity;

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
			case "purchaseRequisitionId":
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Requisition to Purchase Requisition Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Requisition to Purchase Requisition Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseRequisition.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Requisition to Purchase Requisition Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Requisition to Purchase Requisition Stock Details here] end

				break;
			case "stockCatalogueId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Purchase Requisition Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Purchase Requisition Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCatalogue.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Purchase Requisition Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Purchase Requisition Stock Details here] end

				break;
			case "purchaseOrderStockDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Requisition Stock Detail to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Requisition Stock Detail to Purchase Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseOrderStockDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Requisition Stock Detail to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Requisition Stock Detail to Purchase Order Stock Details here] end

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
	public PurchaseRequisitionStockDetailEntity updateOldData(PurchaseRequisitionStockDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PurchaseRequisitionStockDetailEntity updateOldData(PurchaseRequisitionStockDetailEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PurchaseRequisitionStockDetailEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPurchaseRequisitionStockDetailEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getPurchaseRequisition() == null && entity.getPurchaseRequisitionId() == null) {
			entityToUpdate.unsetPurchaseRequisition();
		} else if (entity.getPurchaseRequisitionId() != null && entity.getPurchaseRequisition() == null) {
			Optional<PurchaseRequisitionEntity> purchaseRequisitionEntity = this.purchaseRequisitionRepository.findById(entity.getPurchaseRequisitionId());
			entityToUpdate.setPurchaseRequisition(purchaseRequisitionEntity.orElseThrow());
		}
		if (persistRelations && entity.getPurchaseRequisition() != null) {
			entityToUpdate.setPurchaseRequisition(entity.getPurchaseRequisition(), false);
			if (entityToUpdate.getPurchaseRequisitionId() != null) {
				this.purchaseRequisitionRepository.save(entityToUpdate.getPurchaseRequisition());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPurchaseRequisition().unsetPurchaseRequisitionStockDetails();
			}
		}

		// Incoming One to Many reference
		if (entity.getStockCatalogue() == null && entity.getStockCatalogueId() == null) {
			entityToUpdate.unsetStockCatalogue();
		} else if (entity.getStockCatalogueId() != null && entity.getStockCatalogue() == null) {
			Optional<StockCatalogueEntity> stockCatalogueEntity = this.stockCatalogueRepository.findById(entity.getStockCatalogueId());
			entityToUpdate.setStockCatalogue(stockCatalogueEntity.orElseThrow());
		}
		if (persistRelations && entity.getStockCatalogue() != null) {
			entityToUpdate.setStockCatalogue(entity.getStockCatalogue(), false);
			if (entityToUpdate.getStockCatalogueId() != null) {
				this.stockCatalogueRepository.save(entityToUpdate.getStockCatalogue());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getStockCatalogue().unsetPurchaseRequisitionStockDetails();
			}
		}

		// Outgoing one to many reference
		if (entity.getPurchaseOrderStockDetailsIds().isEmpty() && entity.getPurchaseOrderStockDetails().isEmpty()) {
			entityToUpdate.setPurchaseOrderStockDetails(new HashSet<>());
		} else if (!entity.getPurchaseOrderStockDetailsIds().isEmpty() && entity.getPurchaseOrderStockDetails().isEmpty()) {
			Iterable<PurchaseOrderStockDetailEntity> purchaseOrderStockDetailsEntities =
					this.purchaseOrderStockDetailRepository.findAllById(entity.getPurchaseOrderStockDetailsIds());
			entityToUpdate.setPurchaseOrderStockDetails(Sets.newHashSet(purchaseOrderStockDetailsEntities));
		}
		if (persistRelations && !entity.getPurchaseOrderStockDetails().isEmpty()) {
			Set<PurchaseOrderStockDetailEntity> updatedEntities = new HashSet<>();
			entity.getPurchaseOrderStockDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.purchaseOrderStockDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPurchaseOrderStockDetails(updatedEntities);
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
	public void validateEntity(PurchaseRequisitionStockDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PurchaseRequisitionStockDetailEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PurchaseRequisitionStockDetailEntity.
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

	public Set<String> validateEntityRelations(PurchaseRequisitionStockDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPurchaseRequisitionId() != null && this.purchaseRequisitionRepository.findById(entity.getPurchaseRequisitionId()).isEmpty()) {
			errors.add("The UUID " + entity.getPurchaseRequisitionId() + " is not associated with a Purchase Requisition Entity");
		}

		if (entity.getStockCatalogueId() != null && this.stockCatalogueRepository.findById(entity.getStockCatalogueId()).isEmpty()) {
			errors.add("The UUID " + entity.getStockCatalogueId() + " is not associated with a Stock Catalogue Entity");
		}

		for (UUID id : entity.getPurchaseOrderStockDetailsIds()) {
			if (this.purchaseOrderStockDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Purchase Order Stock Detail Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
