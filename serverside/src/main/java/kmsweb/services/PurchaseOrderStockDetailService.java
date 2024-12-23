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
import kmsweb.repositories.PurchaseOrderStockDetailRepository;
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
import kmsweb.entities.GoodsReceiveNoteItemEntity;
import kmsweb.repositories.GoodsReceiveNoteItemRepository;
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.entities.PurchaseRequisitionStockDetailEntity;
import kmsweb.repositories.PurchaseRequisitionStockDetailRepository;
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
public class PurchaseOrderStockDetailService extends AbstractService<PurchaseOrderStockDetailEntity, PurchaseOrderStockDetailRepository, PurchaseOrderStockDetailEntityAudit> {

	private final String[] referenceNamesInPurchaseOrderStockDetailEntity = {
		"goodsReceiveNoteItems",
		"purchaseOrder",
		"purchaseRequisitionStockDetail",
		"stockCatalogue",
	};

	private final GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository;

	private final PurchaseOrderRepository purchaseOrderRepository;

	private final PurchaseRequisitionStockDetailRepository purchaseRequisitionStockDetailRepository;

	private final StockCatalogueRepository stockCatalogueRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PurchaseOrderStockDetailService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository,
		PurchaseOrderRepository purchaseOrderRepository,
		PurchaseRequisitionStockDetailRepository purchaseRequisitionStockDetailRepository,
		StockCatalogueRepository stockCatalogueRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PurchaseOrderStockDetailRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.goodsReceiveNoteItemRepository = goodsReceiveNoteItemRepository;

		this.purchaseOrderRepository = purchaseOrderRepository;

		this.purchaseRequisitionStockDetailRepository = purchaseRequisitionStockDetailRepository;

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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Unit Price.
	 *
	 * @param unitPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit Price
	 */
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByUnitPrice(Double unitPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByUnitPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUnitPrice here] end
	{
		// % protected region % [Add any additional logic for findByUnitPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByUnitPrice before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByUnitPrice(unitPrice));

		// % protected region % [Add any additional logic for findByUnitPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUnitPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Ordered.
	 *
	 * @param quantityOrdered the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Ordered
	 */
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByQuantityOrdered(Double quantityOrdered)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityOrdered here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityOrdered here] end
	{
		// % protected region % [Add any additional logic for findByQuantityOrdered before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityOrdered before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityOrdered(quantityOrdered));

		// % protected region % [Add any additional logic for findByQuantityOrdered before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantityOrdered before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute UOP.
	 *
	 * @param uop the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOP
	 */
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByUop(String uop)
	// % protected region % [Add any throwables, implementations, or extensions for findByUop here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUop here] end
	{
		// % protected region % [Add any additional logic for findByUop before the main body here] off begin
		// % protected region % [Add any additional logic for findByUop before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByUop(uop));

		// % protected region % [Add any additional logic for findByUop before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUop before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Discount In Percent.
	 *
	 * @param discountInPercent the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discount In Percent
	 */
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByDiscountInPercent(Boolean discountInPercent)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiscountInPercent here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiscountInPercent here] end
	{
		// % protected region % [Add any additional logic for findByDiscountInPercent before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiscountInPercent before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByDiscountInPercent(discountInPercent));

		// % protected region % [Add any additional logic for findByDiscountInPercent before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiscountInPercent before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Discount Value.
	 *
	 * @param discountValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discount Value
	 */
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByDiscountValue(Double discountValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiscountValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiscountValue here] end
	{
		// % protected region % [Add any additional logic for findByDiscountValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiscountValue before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByDiscountValue(discountValue));

		// % protected region % [Add any additional logic for findByDiscountValue before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiscountValue before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Taxable.
	 *
	 * @param taxable the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Taxable
	 */
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByTaxable(Boolean taxable)
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxable here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTaxable here] end
	{
		// % protected region % [Add any additional logic for findByTaxable before the main body here] off begin
		// % protected region % [Add any additional logic for findByTaxable before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByTaxable(taxable));

		// % protected region % [Add any additional logic for findByTaxable before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTaxable before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Item Price.
	 *
	 * @param itemPrice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Price
	 */
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByItemPrice(Double itemPrice)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemPrice here] end
	{
		// % protected region % [Add any additional logic for findByItemPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemPrice before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByItemPrice(itemPrice));

		// % protected region % [Add any additional logic for findByItemPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Item Status.
	 *
	 * @param itemStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Status
	 */
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByItemStatus(String itemStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemStatus here] end
	{
		// % protected region % [Add any additional logic for findByItemStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemStatus before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByItemStatus(itemStatus));

		// % protected region % [Add any additional logic for findByItemStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute SOH.
	 *
	 * @param soh the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute SOH
	 */
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findBySoh(Double soh)
	// % protected region % [Add any throwables, implementations, or extensions for findBySoh here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySoh here] end
	{
		// % protected region % [Add any additional logic for findBySoh before the main body here] off begin
		// % protected region % [Add any additional logic for findBySoh before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findBySoh(soh));

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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByMaxLevel(Double maxLevel)
	// % protected region % [Add any throwables, implementations, or extensions for findByMaxLevel here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMaxLevel here] end
	{
		// % protected region % [Add any additional logic for findByMaxLevel before the main body here] off begin
		// % protected region % [Add any additional logic for findByMaxLevel before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByMaxLevel(maxLevel));

		// % protected region % [Add any additional logic for findByMaxLevel before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMaxLevel before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Received.
	 *
	 * @param quantityReceived the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Received
	 */
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByQuantityReceived(Double quantityReceived)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityReceived here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityReceived here] end
	{
		// % protected region % [Add any additional logic for findByQuantityReceived before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityReceived before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityReceived(quantityReceived));

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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByQuantityReturned(Double quantityReturned)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityReturned here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityReturned here] end
	{
		// % protected region % [Add any additional logic for findByQuantityReturned before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityReturned before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityReturned(quantityReturned));

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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByItemNotes(String itemNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] end
	{
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByItemNotes(itemNotes));

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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findByRemainingQuantity(Double remainingQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByRemainingQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRemainingQuantity here] end
	{
		// % protected region % [Add any additional logic for findByRemainingQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByRemainingQuantity before the main body here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByRemainingQuantity(remainingQuantity));

		// % protected region % [Add any additional logic for findByRemainingQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRemainingQuantity before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PurchaseOrderStockDetailEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PurchaseOrderStockDetailEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PurchaseOrderStockDetailEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'create')")
	public PurchaseOrderStockDetailEntity create(PurchaseOrderStockDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PurchaseOrderStockDetailEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'create')")
	public PurchaseOrderStockDetailEntity create(PurchaseOrderStockDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PurchaseOrderStockDetailEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PurchaseOrderStockDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'create')")
	public List<PurchaseOrderStockDetailEntity> createAll(Iterable<PurchaseOrderStockDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PurchaseOrderStockDetailEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PurchaseOrderStockDetailEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'update')")
	public PurchaseOrderStockDetailEntity update(PurchaseOrderStockDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PurchaseOrderStockDetailEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'update')")
	public PurchaseOrderStockDetailEntity update(PurchaseOrderStockDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PurchaseOrderStockDetailEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PurchaseOrderStockDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'update')")
	public List<PurchaseOrderStockDetailEntity> updateAll(Iterable<PurchaseOrderStockDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PurchaseOrderStockDetailEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PurchaseOrderStockDetailEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'create') or hasPermission('PurchaseOrderStockDetailEntity', 'update')")
	public PurchaseOrderStockDetailEntity save(PurchaseOrderStockDetailEntity entity) throws ConstraintViolationException
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

		PurchaseOrderStockDetailEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'create') or hasPermission('PurchaseOrderStockDetailEntity', 'update')")
	public List<PurchaseOrderStockDetailEntity> saveAll(Iterable<PurchaseOrderStockDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PurchaseOrderStockDetailEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	public List<PurchaseOrderStockDetailEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	public List<PurchaseOrderStockDetailEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PurchaseOrderStockDetailEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PurchaseOrderStockDetailEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PurchaseOrderStockDetailEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PurchaseOrderStockDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PurchaseOrderStockDetailEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PurchaseOrderStockDetailEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PurchaseOrderStockDetailEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PurchaseOrderStockDetailEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PurchaseOrderStockDetailEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PurchaseOrderStockDetailEntityAudits
	 */
	private List<PurchaseOrderStockDetailEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PurchaseOrderStockDetailEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param purchaseOrderStockDetail purchaseOrderStockDetail to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PurchaseOrderStockDetailEntity updateAuditData(PurchaseOrderStockDetailEntity purchaseOrderStockDetail)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return purchaseOrderStockDetail;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PurchaseOrderStockDetailEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PurchaseOrderStockDetailEntity entityAtRevision = updateAuditData((PurchaseOrderStockDetailEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PurchaseOrderStockDetailEntityAudit(
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

		QPurchaseOrderStockDetailEntity entity = QPurchaseOrderStockDetailEntity.purchaseOrderStockDetailEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order to Purchase Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseOrder.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order to Purchase Order Stock Details here] end

				break;
			case "purchaseRequisitionStockDetailId":
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Requisition Stock Detail to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Requisition Stock Detail to Purchase Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.purchaseRequisitionStockDetail.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Requisition Stock Detail to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Requisition Stock Detail to Purchase Order Stock Details here] end

				break;
			case "stockCatalogueId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Purchase Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCatalogue.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Purchase Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Purchase Order Stock Details here] end

				break;
			case "goodsReceiveNoteItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order Stock Detail to Goods Receive Note Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Purchase Order Stock Detail to Goods Receive Note Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.goodsReceiveNoteItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order Stock Detail to Goods Receive Note Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Purchase Order Stock Detail to Goods Receive Note Items here] end

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
	public PurchaseOrderStockDetailEntity updateOldData(PurchaseOrderStockDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PurchaseOrderStockDetailEntity updateOldData(PurchaseOrderStockDetailEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PurchaseOrderStockDetailEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPurchaseOrderStockDetailEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getDiscountInPercent() == null) {
			entityToUpdate.setDiscountInPercent(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getTaxable() == null) {
			entityToUpdate.setTaxable(false);
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
				entityToUpdate.getPurchaseOrder().unsetPurchaseOrderStockDetails();
			}
		}

		// Incoming One to Many reference
		if (entity.getPurchaseRequisitionStockDetail() == null && entity.getPurchaseRequisitionStockDetailId() == null) {
			entityToUpdate.unsetPurchaseRequisitionStockDetail();
		} else if (entity.getPurchaseRequisitionStockDetailId() != null && entity.getPurchaseRequisitionStockDetail() == null) {
			Optional<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetailEntity = this.purchaseRequisitionStockDetailRepository.findById(entity.getPurchaseRequisitionStockDetailId());
			entityToUpdate.setPurchaseRequisitionStockDetail(purchaseRequisitionStockDetailEntity.orElseThrow());
		}
		if (persistRelations && entity.getPurchaseRequisitionStockDetail() != null) {
			entityToUpdate.setPurchaseRequisitionStockDetail(entity.getPurchaseRequisitionStockDetail(), false);
			if (entityToUpdate.getPurchaseRequisitionStockDetailId() != null) {
				this.purchaseRequisitionStockDetailRepository.save(entityToUpdate.getPurchaseRequisitionStockDetail());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPurchaseRequisitionStockDetail().unsetPurchaseOrderStockDetails();
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
				entityToUpdate.getStockCatalogue().unsetPurchaseOrderStockDetails();
			}
		}

		// Outgoing one to many reference
		if (entity.getGoodsReceiveNoteItemsIds().isEmpty() && entity.getGoodsReceiveNoteItems().isEmpty()) {
			entityToUpdate.setGoodsReceiveNoteItems(new HashSet<>());
		} else if (!entity.getGoodsReceiveNoteItemsIds().isEmpty() && entity.getGoodsReceiveNoteItems().isEmpty()) {
			Iterable<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemsEntities =
					this.goodsReceiveNoteItemRepository.findAllById(entity.getGoodsReceiveNoteItemsIds());
			entityToUpdate.setGoodsReceiveNoteItems(Sets.newHashSet(goodsReceiveNoteItemsEntities));
		}
		if (persistRelations && !entity.getGoodsReceiveNoteItems().isEmpty()) {
			Set<GoodsReceiveNoteItemEntity> updatedEntities = new HashSet<>();
			entity.getGoodsReceiveNoteItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.goodsReceiveNoteItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setGoodsReceiveNoteItems(updatedEntities);
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
	public void validateEntity(PurchaseOrderStockDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PurchaseOrderStockDetailEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PurchaseOrderStockDetailEntity.
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

	public Set<String> validateEntityRelations(PurchaseOrderStockDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getPurchaseOrderId() != null && this.purchaseOrderRepository.findById(entity.getPurchaseOrderId()).isEmpty()) {
			errors.add("The UUID " + entity.getPurchaseOrderId() + " is not associated with a Purchase Order Entity");
		}

		if (entity.getPurchaseRequisitionStockDetailId() != null && this.purchaseRequisitionStockDetailRepository.findById(entity.getPurchaseRequisitionStockDetailId()).isEmpty()) {
			errors.add("The UUID " + entity.getPurchaseRequisitionStockDetailId() + " is not associated with a Purchase Requisition Stock Detail Entity");
		}

		if (entity.getStockCatalogueId() != null && this.stockCatalogueRepository.findById(entity.getStockCatalogueId()).isEmpty()) {
			errors.add("The UUID " + entity.getStockCatalogueId() + " is not associated with a Stock Catalogue Entity");
		}

		for (UUID id : entity.getGoodsReceiveNoteItemsIds()) {
			if (this.goodsReceiveNoteItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Goods Receive Note Item Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
