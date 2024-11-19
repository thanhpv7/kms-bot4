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
import kmsweb.repositories.TransferOrderStockDetailRepository;
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
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.entities.TransferOrderEntity;
import kmsweb.repositories.TransferOrderRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class TransferOrderStockDetailService extends AbstractService<TransferOrderStockDetailEntity, TransferOrderStockDetailRepository, TransferOrderStockDetailEntityAudit> {

	private final String[] referenceNamesInTransferOrderStockDetailEntity = {
		"staff",
		"stockCatalogue",
		"transferOrder",
	};

	private final StaffRepository staffRepository;

	private final StockCatalogueRepository stockCatalogueRepository;

	private final TransferOrderRepository transferOrderRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public TransferOrderStockDetailService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		StaffRepository staffRepository,
		StockCatalogueRepository stockCatalogueRepository,
		TransferOrderRepository transferOrderRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		TransferOrderStockDetailRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.staffRepository = staffRepository;

		this.stockCatalogueRepository = stockCatalogueRepository;

		this.transferOrderRepository = transferOrderRepository;

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
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
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
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Item Number.
	 *
	 * @param itemNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Number
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByItemNumber(Integer itemNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNumber here] end
	{
		// % protected region % [Add any additional logic for findByItemNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemNumber before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByItemNumber(itemNumber));

		// % protected region % [Add any additional logic for findByItemNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Source Available Quantity.
	 *
	 * @param sourceAvailableQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Available Quantity
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findBySourceAvailableQuantity(Double sourceAvailableQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findBySourceAvailableQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySourceAvailableQuantity here] end
	{
		// % protected region % [Add any additional logic for findBySourceAvailableQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findBySourceAvailableQuantity before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findBySourceAvailableQuantity(sourceAvailableQuantity));

		// % protected region % [Add any additional logic for findBySourceAvailableQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySourceAvailableQuantity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Destination SOH.
	 *
	 * @param destinationSOH the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Destination SOH
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByDestinationSOH(Double destinationSOH)
	// % protected region % [Add any throwables, implementations, or extensions for findByDestinationSOH here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDestinationSOH here] end
	{
		// % protected region % [Add any additional logic for findByDestinationSOH before the main body here] off begin
		// % protected region % [Add any additional logic for findByDestinationSOH before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByDestinationSOH(destinationSOH));

		// % protected region % [Add any additional logic for findByDestinationSOH before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDestinationSOH before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Ordered.
	 *
	 * @param quantityOrdered the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Ordered
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByQuantityOrdered(Double quantityOrdered)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityOrdered here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityOrdered here] end
	{
		// % protected region % [Add any additional logic for findByQuantityOrdered before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityOrdered before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityOrdered(quantityOrdered));

		// % protected region % [Add any additional logic for findByQuantityOrdered before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantityOrdered before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute uom.
	 *
	 * @param uom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute uom
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByUom(String uom)
	// % protected region % [Add any throwables, implementations, or extensions for findByUom here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUom here] end
	{
		// % protected region % [Add any additional logic for findByUom before the main body here] off begin
		// % protected region % [Add any additional logic for findByUom before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByUom(uom));

		// % protected region % [Add any additional logic for findByUom before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUom before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Transaction Status.
	 *
	 * @param transactionStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Status
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByTransactionStatus(String transactionStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionStatus here] end
	{
		// % protected region % [Add any additional logic for findByTransactionStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionStatus before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByTransactionStatus(transactionStatus));

		// % protected region % [Add any additional logic for findByTransactionStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Issued.
	 *
	 * @param quantityIssued the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Issued
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByQuantityIssued(Double quantityIssued)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityIssued here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityIssued here] end
	{
		// % protected region % [Add any additional logic for findByQuantityIssued before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityIssued before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityIssued(quantityIssued));

		// % protected region % [Add any additional logic for findByQuantityIssued before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantityIssued before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Received.
	 *
	 * @param quantityReceived the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Received
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByQuantityReceived(Double quantityReceived)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityReceived here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityReceived here] end
	{
		// % protected region % [Add any additional logic for findByQuantityReceived before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityReceived before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityReceived(quantityReceived));

		// % protected region % [Add any additional logic for findByQuantityReceived before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantityReceived before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Source Min Level.
	 *
	 * @param sourceMinLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Source Min Level
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findBySourceMinLevel(Double sourceMinLevel)
	// % protected region % [Add any throwables, implementations, or extensions for findBySourceMinLevel here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySourceMinLevel here] end
	{
		// % protected region % [Add any additional logic for findBySourceMinLevel before the main body here] off begin
		// % protected region % [Add any additional logic for findBySourceMinLevel before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findBySourceMinLevel(sourceMinLevel));

		// % protected region % [Add any additional logic for findBySourceMinLevel before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySourceMinLevel before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Destination Max Level.
	 *
	 * @param destinationMaxLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Destination Max Level
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByDestinationMaxLevel(Double destinationMaxLevel)
	// % protected region % [Add any throwables, implementations, or extensions for findByDestinationMaxLevel here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDestinationMaxLevel here] end
	{
		// % protected region % [Add any additional logic for findByDestinationMaxLevel before the main body here] off begin
		// % protected region % [Add any additional logic for findByDestinationMaxLevel before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByDestinationMaxLevel(destinationMaxLevel));

		// % protected region % [Add any additional logic for findByDestinationMaxLevel before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDestinationMaxLevel before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Transferred.
	 *
	 * @param quantityTransferred the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Transferred
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByQuantityTransferred(Double quantityTransferred)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityTransferred here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityTransferred here] end
	{
		// % protected region % [Add any additional logic for findByQuantityTransferred before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityTransferred before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityTransferred(quantityTransferred));

		// % protected region % [Add any additional logic for findByQuantityTransferred before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantityTransferred before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Quantity Fulfilled.
	 *
	 * @param quantityFulfilled the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Quantity Fulfilled
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByQuantityFulfilled(Double quantityFulfilled)
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityFulfilled here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQuantityFulfilled here] end
	{
		// % protected region % [Add any additional logic for findByQuantityFulfilled before the main body here] off begin
		// % protected region % [Add any additional logic for findByQuantityFulfilled before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByQuantityFulfilled(quantityFulfilled));

		// % protected region % [Add any additional logic for findByQuantityFulfilled before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQuantityFulfilled before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Order Date Time.
	 *
	 * @param orderDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Order Date Time
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByOrderDateTime(OffsetDateTime orderDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByOrderDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOrderDateTime here] end
	{
		// % protected region % [Add any additional logic for findByOrderDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByOrderDateTime before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByOrderDateTime(orderDateTime));

		// % protected region % [Add any additional logic for findByOrderDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOrderDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByItemNotes(String itemNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] end
	{
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByItemNotes(itemNotes));

		// % protected region % [Add any additional logic for findByItemNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findByInventoryRoundingValue(Double inventoryRoundingValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRoundingValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRoundingValue here] end
	{
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before the main body here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findByInventoryRoundingValue(inventoryRoundingValue));

		// % protected region % [Add any additional logic for findByInventoryRoundingValue before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<TransferOrderStockDetailEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<TransferOrderStockDetailEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<TransferOrderStockDetailEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'create')")
	public TransferOrderStockDetailEntity create(TransferOrderStockDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		TransferOrderStockDetailEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'create')")
	public TransferOrderStockDetailEntity create(TransferOrderStockDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		TransferOrderStockDetailEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		TransferOrderStockDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'create')")
	public List<TransferOrderStockDetailEntity> createAll(Iterable<TransferOrderStockDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<TransferOrderStockDetailEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<TransferOrderStockDetailEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'update')")
	public TransferOrderStockDetailEntity update(TransferOrderStockDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		TransferOrderStockDetailEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'update')")
	public TransferOrderStockDetailEntity update(TransferOrderStockDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		TransferOrderStockDetailEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		TransferOrderStockDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'update')")
	public List<TransferOrderStockDetailEntity> updateAll(Iterable<TransferOrderStockDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<TransferOrderStockDetailEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<TransferOrderStockDetailEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'create') or hasPermission('TransferOrderStockDetailEntity', 'update')")
	public TransferOrderStockDetailEntity save(TransferOrderStockDetailEntity entity) throws ConstraintViolationException
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

		TransferOrderStockDetailEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'create') or hasPermission('TransferOrderStockDetailEntity', 'update')")
	public List<TransferOrderStockDetailEntity> saveAll(Iterable<TransferOrderStockDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<TransferOrderStockDetailEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	public List<TransferOrderStockDetailEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	public List<TransferOrderStockDetailEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(TransferOrderStockDetailEntity.class);

		// % protected region % [Add any additional processing before converting to a list of TransferOrderStockDetailEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of TransferOrderStockDetailEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('TransferOrderStockDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TransferOrderStockDetailEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of TransferOrderStockDetailEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of TransferOrderStockDetailEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(TransferOrderStockDetailEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of TransferOrderStockDetailEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of TransferOrderStockDetailEntityAudits
	 */
	private List<TransferOrderStockDetailEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<TransferOrderStockDetailEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param transferOrderStockDetail transferOrderStockDetail to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private TransferOrderStockDetailEntity updateAuditData(TransferOrderStockDetailEntity transferOrderStockDetail)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return transferOrderStockDetail;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private TransferOrderStockDetailEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		TransferOrderStockDetailEntity entityAtRevision = updateAuditData((TransferOrderStockDetailEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new TransferOrderStockDetailEntityAudit(
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

		QTransferOrderStockDetailEntity entity = QTransferOrderStockDetailEntity.transferOrderStockDetailEntity;

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
			case "staffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Transfer Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Transfer Order Stock Details here] end

				break;
			case "stockCatalogueId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Transfer Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCatalogue.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Transfer Order Stock Details here] end

				break;
			case "transferOrderId":
				// % protected region % [Add any additional logic before the query parameters of relation from Transfer Order to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Transfer Order to Transfer Order Stock Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transferOrder.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Transfer Order to Transfer Order Stock Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Transfer Order to Transfer Order Stock Details here] end

				break;
			case "itemNumber":
				// % protected region % [Add any additional logic before the query parameters of itemNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of itemNumber here] end


				// % protected region % [Add any additional logic after the query parameters of itemNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of itemNumber here] end

				break;
			case "sourceAvailableQuantity":
				// % protected region % [Add any additional logic before the query parameters of sourceAvailableQuantity here] off begin
				// % protected region % [Add any additional logic before the query parameters of sourceAvailableQuantity here] end


				// % protected region % [Add any additional logic after the query parameters of sourceAvailableQuantity here] off begin
				// % protected region % [Add any additional logic after the query parameters of sourceAvailableQuantity here] end

				break;
			case "destinationSOH":
				// % protected region % [Add any additional logic before the query parameters of destinationSOH here] off begin
				// % protected region % [Add any additional logic before the query parameters of destinationSOH here] end


				// % protected region % [Add any additional logic after the query parameters of destinationSOH here] off begin
				// % protected region % [Add any additional logic after the query parameters of destinationSOH here] end

				break;
			case "quantityOrdered":
				// % protected region % [Add any additional logic before the query parameters of quantityOrdered here] off begin
				// % protected region % [Add any additional logic before the query parameters of quantityOrdered here] end


				// % protected region % [Add any additional logic after the query parameters of quantityOrdered here] off begin
				// % protected region % [Add any additional logic after the query parameters of quantityOrdered here] end

				break;
			case "uom":
				// % protected region % [Add any additional logic before the query parameters of uom here] off begin
				// % protected region % [Add any additional logic before the query parameters of uom here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.uom, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of uom here] off begin
				// % protected region % [Add any additional logic after the query parameters of uom here] end

				break;
			case "transactionStatus":
				// % protected region % [Add any additional logic before the query parameters of transactionStatus here] off begin
				// % protected region % [Add any additional logic before the query parameters of transactionStatus here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionStatus, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of transactionStatus here] off begin
				// % protected region % [Add any additional logic after the query parameters of transactionStatus here] end

				break;
			case "quantityIssued":
				// % protected region % [Add any additional logic before the query parameters of quantityIssued here] off begin
				// % protected region % [Add any additional logic before the query parameters of quantityIssued here] end


				// % protected region % [Add any additional logic after the query parameters of quantityIssued here] off begin
				// % protected region % [Add any additional logic after the query parameters of quantityIssued here] end

				break;
			case "quantityReceived":
				// % protected region % [Add any additional logic before the query parameters of quantityReceived here] off begin
				// % protected region % [Add any additional logic before the query parameters of quantityReceived here] end


				// % protected region % [Add any additional logic after the query parameters of quantityReceived here] off begin
				// % protected region % [Add any additional logic after the query parameters of quantityReceived here] end

				break;
			case "sourceMinLevel":
				// % protected region % [Add any additional logic before the query parameters of sourceMinLevel here] off begin
				// % protected region % [Add any additional logic before the query parameters of sourceMinLevel here] end


				// % protected region % [Add any additional logic after the query parameters of sourceMinLevel here] off begin
				// % protected region % [Add any additional logic after the query parameters of sourceMinLevel here] end

				break;
			case "destinationMaxLevel":
				// % protected region % [Add any additional logic before the query parameters of destinationMaxLevel here] off begin
				// % protected region % [Add any additional logic before the query parameters of destinationMaxLevel here] end


				// % protected region % [Add any additional logic after the query parameters of destinationMaxLevel here] off begin
				// % protected region % [Add any additional logic after the query parameters of destinationMaxLevel here] end

				break;
			case "quantityTransferred":
				// % protected region % [Add any additional logic before the query parameters of quantityTransferred here] off begin
				// % protected region % [Add any additional logic before the query parameters of quantityTransferred here] end


				// % protected region % [Add any additional logic after the query parameters of quantityTransferred here] off begin
				// % protected region % [Add any additional logic after the query parameters of quantityTransferred here] end

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
	public TransferOrderStockDetailEntity updateOldData(TransferOrderStockDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public TransferOrderStockDetailEntity updateOldData(TransferOrderStockDetailEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		TransferOrderStockDetailEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInTransferOrderStockDetailEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
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
				entityToUpdate.getStaff().unsetTransferOrderStockDetails();
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
				entityToUpdate.getStockCatalogue().unsetTransferOrderStockDetails();
			}
		}

		// Incoming One to Many reference
		if (entity.getTransferOrder() == null && entity.getTransferOrderId() == null) {
			entityToUpdate.unsetTransferOrder();
		} else if (entity.getTransferOrderId() != null && entity.getTransferOrder() == null) {
			Optional<TransferOrderEntity> transferOrderEntity = this.transferOrderRepository.findById(entity.getTransferOrderId());
			entityToUpdate.setTransferOrder(transferOrderEntity.orElseThrow());
		}
		if (persistRelations && entity.getTransferOrder() != null) {
			entityToUpdate.setTransferOrder(entity.getTransferOrder(), false);
			if (entityToUpdate.getTransferOrderId() != null) {
				this.transferOrderRepository.save(entityToUpdate.getTransferOrder());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getTransferOrder().unsetTransferOrderStockDetails();
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
	public void validateEntity(TransferOrderStockDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<TransferOrderStockDetailEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the TransferOrderStockDetailEntity.
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

	public Set<String> validateEntityRelations(TransferOrderStockDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getStaffId() != null && this.staffRepository.findById(entity.getStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getStaffId() + " is not associated with a Staff Entity");
		}

		if (entity.getStockCatalogueId() != null && this.stockCatalogueRepository.findById(entity.getStockCatalogueId()).isEmpty()) {
			errors.add("The UUID " + entity.getStockCatalogueId() + " is not associated with a Stock Catalogue Entity");
		}

		if (entity.getTransferOrderId() != null && this.transferOrderRepository.findById(entity.getTransferOrderId()).isEmpty()) {
			errors.add("The UUID " + entity.getTransferOrderId() + " is not associated with a Transfer Order Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
