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
import kmsweb.repositories.StockTransactionDetailRepository;
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
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.entities.TransactionDetailTypeEntity;
import kmsweb.repositories.TransactionDetailTypeRepository;
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
public class StockTransactionDetailService extends AbstractService<StockTransactionDetailEntity, StockTransactionDetailRepository, StockTransactionDetailEntityAudit> {

	private final String[] referenceNamesInStockTransactionDetailEntity = {
		"stockCatalogue",
		"transactionDetailType",
		"warehouse",
	};

	private final StockCatalogueRepository stockCatalogueRepository;

	private final TransactionDetailTypeRepository transactionDetailTypeRepository;

	private final WarehouseRepository warehouseRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public StockTransactionDetailService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		StockCatalogueRepository stockCatalogueRepository,
		TransactionDetailTypeRepository transactionDetailTypeRepository,
		WarehouseRepository warehouseRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		StockTransactionDetailRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.stockCatalogueRepository = stockCatalogueRepository;

		this.transactionDetailTypeRepository = transactionDetailTypeRepository;

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
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
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
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Transaction Number.
	 *
	 * @param transactionNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Number
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByTransactionNumber(String transactionNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionNumber here] end
	{
		// % protected region % [Add any additional logic for findByTransactionNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionNumber before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByTransactionNumber(transactionNumber));

		// % protected region % [Add any additional logic for findByTransactionNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Date.
	 *
	 * @param transactionDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Date
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByTransactionDate(OffsetDateTime transactionDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDate here] end
	{
		// % protected region % [Add any additional logic for findByTransactionDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionDate before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByTransactionDate(transactionDate));

		// % protected region % [Add any additional logic for findByTransactionDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Type.
	 *
	 * @param transactionType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Type
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByTransactionType(String transactionType)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionType here] end
	{
		// % protected region % [Add any additional logic for findByTransactionType before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionType before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByTransactionType(transactionType));

		// % protected region % [Add any additional logic for findByTransactionType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Notes.
	 *
	 * @param transactionNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Notes
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByTransactionNotes(String transactionNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionNotes here] end
	{
		// % protected region % [Add any additional logic for findByTransactionNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionNotes before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByTransactionNotes(transactionNotes));

		// % protected region % [Add any additional logic for findByTransactionNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Item Line Number.
	 *
	 * @param itemLineNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Line Number
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByItemLineNumber(Integer itemLineNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemLineNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemLineNumber here] end
	{
		// % protected region % [Add any additional logic for findByItemLineNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemLineNumber before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByItemLineNumber(itemLineNumber));

		// % protected region % [Add any additional logic for findByItemLineNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemLineNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByItemNotes(String itemNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] end
	{
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByItemNotes(itemNotes));

		// % protected region % [Add any additional logic for findByItemNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Qty Uoi.
	 *
	 * @param qtyUoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Uoi
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByQtyUoi(Double qtyUoi)
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyUoi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyUoi here] end
	{
		// % protected region % [Add any additional logic for findByQtyUoi before the main body here] off begin
		// % protected region % [Add any additional logic for findByQtyUoi before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByQtyUoi(qtyUoi));

		// % protected region % [Add any additional logic for findByQtyUoi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQtyUoi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Qty Uom Transaction.
	 *
	 * @param qtyUomTransaction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Uom Transaction
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByQtyUomTransaction(Double qtyUomTransaction)
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyUomTransaction here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyUomTransaction here] end
	{
		// % protected region % [Add any additional logic for findByQtyUomTransaction before the main body here] off begin
		// % protected region % [Add any additional logic for findByQtyUomTransaction before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByQtyUomTransaction(qtyUomTransaction));

		// % protected region % [Add any additional logic for findByQtyUomTransaction before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQtyUomTransaction before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Cost.
	 *
	 * @param totalCost the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Cost
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByTotalCost(Double totalCost)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalCost here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalCost here] end
	{
		// % protected region % [Add any additional logic for findByTotalCost before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalCost before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByTotalCost(totalCost));

		// % protected region % [Add any additional logic for findByTotalCost before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalCost before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Uoi.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uoi
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByUoi(String uoi)
	// % protected region % [Add any throwables, implementations, or extensions for findByUoi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUoi here] end
	{
		// % protected region % [Add any additional logic for findByUoi before the main body here] off begin
		// % protected region % [Add any additional logic for findByUoi before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByUoi(uoi));

		// % protected region % [Add any additional logic for findByUoi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUoi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Uom Transaction.
	 *
	 * @param uomTransaction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uom Transaction
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByUomTransaction(String uomTransaction)
	// % protected region % [Add any throwables, implementations, or extensions for findByUomTransaction here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUomTransaction here] end
	{
		// % protected region % [Add any additional logic for findByUomTransaction before the main body here] off begin
		// % protected region % [Add any additional logic for findByUomTransaction before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByUomTransaction(uomTransaction));

		// % protected region % [Add any additional logic for findByUomTransaction before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUomTransaction before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Source Order Number.
	 *
	 * @param sourceOrderNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Order Number
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findBySourceOrderNumber(String sourceOrderNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findBySourceOrderNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySourceOrderNumber here] end
	{
		// % protected region % [Add any additional logic for findBySourceOrderNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findBySourceOrderNumber before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findBySourceOrderNumber(sourceOrderNumber));

		// % protected region % [Add any additional logic for findBySourceOrderNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySourceOrderNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Qty Transit Uoi.
	 *
	 * @param qtyTransitUoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Transit Uoi
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByQtyTransitUoi(Double qtyTransitUoi)
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyTransitUoi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyTransitUoi here] end
	{
		// % protected region % [Add any additional logic for findByQtyTransitUoi before the main body here] off begin
		// % protected region % [Add any additional logic for findByQtyTransitUoi before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByQtyTransitUoi(qtyTransitUoi));

		// % protected region % [Add any additional logic for findByQtyTransitUoi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQtyTransitUoi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Qty Transit Uom Transaction.
	 *
	 * @param qtyTransitUomTransaction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Transit Uom Transaction
	 */
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findByQtyTransitUomTransaction(Double qtyTransitUomTransaction)
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyTransitUomTransaction here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyTransitUomTransaction here] end
	{
		// % protected region % [Add any additional logic for findByQtyTransitUomTransaction before the main body here] off begin
		// % protected region % [Add any additional logic for findByQtyTransitUomTransaction before the main body here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findByQtyTransitUomTransaction(qtyTransitUomTransaction));

		// % protected region % [Add any additional logic for findByQtyTransitUomTransaction before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQtyTransitUomTransaction before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<StockTransactionDetailEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<StockTransactionDetailEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<StockTransactionDetailEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'create')")
	public StockTransactionDetailEntity create(StockTransactionDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		StockTransactionDetailEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'create')")
	public StockTransactionDetailEntity create(StockTransactionDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		StockTransactionDetailEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		StockTransactionDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'create')")
	public List<StockTransactionDetailEntity> createAll(Iterable<StockTransactionDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<StockTransactionDetailEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<StockTransactionDetailEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'update')")
	public StockTransactionDetailEntity update(StockTransactionDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		StockTransactionDetailEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'update')")
	public StockTransactionDetailEntity update(StockTransactionDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		StockTransactionDetailEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		StockTransactionDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'update')")
	public List<StockTransactionDetailEntity> updateAll(Iterable<StockTransactionDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<StockTransactionDetailEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<StockTransactionDetailEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'create') or hasPermission('StockTransactionDetailEntity', 'update')")
	public StockTransactionDetailEntity save(StockTransactionDetailEntity entity) throws ConstraintViolationException
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

		StockTransactionDetailEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'create') or hasPermission('StockTransactionDetailEntity', 'update')")
	public List<StockTransactionDetailEntity> saveAll(Iterable<StockTransactionDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<StockTransactionDetailEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	public List<StockTransactionDetailEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	public List<StockTransactionDetailEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(StockTransactionDetailEntity.class);

		// % protected region % [Add any additional processing before converting to a list of StockTransactionDetailEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of StockTransactionDetailEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('StockTransactionDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<StockTransactionDetailEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of StockTransactionDetailEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of StockTransactionDetailEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(StockTransactionDetailEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of StockTransactionDetailEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of StockTransactionDetailEntityAudits
	 */
	private List<StockTransactionDetailEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<StockTransactionDetailEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param stockTransactionDetail stockTransactionDetail to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private StockTransactionDetailEntity updateAuditData(StockTransactionDetailEntity stockTransactionDetail)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return stockTransactionDetail;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private StockTransactionDetailEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		StockTransactionDetailEntity entityAtRevision = updateAuditData((StockTransactionDetailEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new StockTransactionDetailEntityAudit(
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

		QStockTransactionDetailEntity entity = QStockTransactionDetailEntity.stockTransactionDetailEntity;

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
			case "stockCatalogueId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Stock Transaction Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCatalogue.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Stock Transaction Details here] end

				break;
			case "transactionDetailTypeId":
				// % protected region % [Add any additional logic before the query parameters of relation from Transaction Detail Type to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Transaction Detail Type to Stock Transaction Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionDetailType.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Transaction Detail Type to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Transaction Detail Type to Stock Transaction Details here] end

				break;
			case "warehouseId":
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Warehouse to Stock Transaction Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.warehouse.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Warehouse to Stock Transaction Details here] end

				break;
			case "transactionNumber":
				// % protected region % [Add any additional logic before the query parameters of transactionNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of transactionNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of transactionNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of transactionNumber here] end

				break;
			case "transactionDate":
				// % protected region % [Add any additional logic before the query parameters of transactionDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of transactionDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of transactionDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of transactionDate here] end

				break;
			case "transactionType":
				// % protected region % [Add any additional logic before the query parameters of transactionType here] off begin
				// % protected region % [Add any additional logic before the query parameters of transactionType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of transactionType here] off begin
				// % protected region % [Add any additional logic after the query parameters of transactionType here] end

				break;
			case "transactionNotes":
				// % protected region % [Add any additional logic before the query parameters of transactionNotes here] off begin
				// % protected region % [Add any additional logic before the query parameters of transactionNotes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionNotes, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of transactionNotes here] off begin
				// % protected region % [Add any additional logic after the query parameters of transactionNotes here] end

				break;
			case "itemNotes":
				// % protected region % [Add any additional logic before the query parameters of itemNotes here] off begin
				// % protected region % [Add any additional logic before the query parameters of itemNotes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.itemNotes, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of itemNotes here] off begin
				// % protected region % [Add any additional logic after the query parameters of itemNotes here] end

				break;
			case "qtyUoi":
				// % protected region % [Add any additional logic before the query parameters of qtyUoi here] off begin
				// % protected region % [Add any additional logic before the query parameters of qtyUoi here] end


				// % protected region % [Add any additional logic after the query parameters of qtyUoi here] off begin
				// % protected region % [Add any additional logic after the query parameters of qtyUoi here] end

				break;
			case "qtyUomTransaction":
				// % protected region % [Add any additional logic before the query parameters of qtyUomTransaction here] off begin
				// % protected region % [Add any additional logic before the query parameters of qtyUomTransaction here] end


				// % protected region % [Add any additional logic after the query parameters of qtyUomTransaction here] off begin
				// % protected region % [Add any additional logic after the query parameters of qtyUomTransaction here] end

				break;
			case "totalCost":
				// % protected region % [Add any additional logic before the query parameters of totalCost here] off begin
				// % protected region % [Add any additional logic before the query parameters of totalCost here] end


				// % protected region % [Add any additional logic after the query parameters of totalCost here] off begin
				// % protected region % [Add any additional logic after the query parameters of totalCost here] end

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
	public StockTransactionDetailEntity updateOldData(StockTransactionDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public StockTransactionDetailEntity updateOldData(StockTransactionDetailEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		StockTransactionDetailEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInStockTransactionDetailEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
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
				entityToUpdate.getStockCatalogue().unsetStockTransactionDetails();
			}
		}

		// Incoming One to Many reference
		if (entity.getTransactionDetailType() == null && entity.getTransactionDetailTypeId() == null) {
			entityToUpdate.unsetTransactionDetailType();
		} else if (entity.getTransactionDetailTypeId() != null && entity.getTransactionDetailType() == null) {
			Optional<TransactionDetailTypeEntity> transactionDetailTypeEntity = this.transactionDetailTypeRepository.findById(entity.getTransactionDetailTypeId());
			entityToUpdate.setTransactionDetailType(transactionDetailTypeEntity.orElseThrow());
		}
		if (persistRelations && entity.getTransactionDetailType() != null) {
			entityToUpdate.setTransactionDetailType(entity.getTransactionDetailType(), false);
			if (entityToUpdate.getTransactionDetailTypeId() != null) {
				this.transactionDetailTypeRepository.save(entityToUpdate.getTransactionDetailType());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getTransactionDetailType().unsetStockTransactionDetails();
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
				entityToUpdate.getWarehouse().unsetStockTransactionDetails();
			}
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
	public void validateEntity(StockTransactionDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<StockTransactionDetailEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the StockTransactionDetailEntity.
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

	public Set<String> validateEntityRelations(StockTransactionDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getStockCatalogueId() != null && this.stockCatalogueRepository.findById(entity.getStockCatalogueId()).isEmpty()) {
			errors.add("The UUID " + entity.getStockCatalogueId() + " is not associated with a Stock Catalogue Entity");
		}

		if (entity.getTransactionDetailTypeId() != null && this.transactionDetailTypeRepository.findById(entity.getTransactionDetailTypeId()).isEmpty()) {
			errors.add("The UUID " + entity.getTransactionDetailTypeId() + " is not associated with a Transaction Detail Type Entity");
		}

		if (entity.getWarehouseId() != null && this.warehouseRepository.findById(entity.getWarehouseId()).isEmpty()) {
			errors.add("The UUID " + entity.getWarehouseId() + " is not associated with a Warehouse Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
