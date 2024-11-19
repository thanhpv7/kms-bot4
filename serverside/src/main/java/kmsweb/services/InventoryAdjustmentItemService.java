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
import kmsweb.repositories.InventoryAdjustmentItemRepository;
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
import kmsweb.entities.InventoryAdjusmentBatchEntity;
import kmsweb.repositories.InventoryAdjusmentBatchRepository;
import kmsweb.entities.InventoryAdjustmentEntity;
import kmsweb.repositories.InventoryAdjustmentRepository;
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
public class InventoryAdjustmentItemService extends AbstractService<InventoryAdjustmentItemEntity, InventoryAdjustmentItemRepository, InventoryAdjustmentItemEntityAudit> {

	private final String[] referenceNamesInInventoryAdjustmentItemEntity = {
		"inventoryAdjusmentBatchs",
		"inventoryAdjustment",
		"stockCatalogue",
	};

	private final InventoryAdjusmentBatchRepository inventoryAdjusmentBatchRepository;

	private final InventoryAdjustmentRepository inventoryAdjustmentRepository;

	private final StockCatalogueRepository stockCatalogueRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InventoryAdjustmentItemService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		InventoryAdjusmentBatchRepository inventoryAdjusmentBatchRepository,
		InventoryAdjustmentRepository inventoryAdjustmentRepository,
		StockCatalogueRepository stockCatalogueRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		InventoryAdjustmentItemRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.inventoryAdjusmentBatchRepository = inventoryAdjusmentBatchRepository;

		this.inventoryAdjustmentRepository = inventoryAdjustmentRepository;

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
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
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
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Item Line Number.
	 *
	 * @param itemLineNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Line Number
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByItemLineNumber(Integer itemLineNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemLineNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemLineNumber here] end
	{
		// % protected region % [Add any additional logic for findByItemLineNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemLineNumber before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByItemLineNumber(itemLineNumber));

		// % protected region % [Add any additional logic for findByItemLineNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemLineNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Original SOH.
	 *
	 * @param originalSOH the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Original SOH
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByOriginalSOH(Double originalSOH)
	// % protected region % [Add any throwables, implementations, or extensions for findByOriginalSOH here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOriginalSOH here] end
	{
		// % protected region % [Add any additional logic for findByOriginalSOH before the main body here] off begin
		// % protected region % [Add any additional logic for findByOriginalSOH before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByOriginalSOH(originalSOH));

		// % protected region % [Add any additional logic for findByOriginalSOH before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOriginalSOH before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Original Inventory Value.
	 *
	 * @param originalInventoryValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Original Inventory Value
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByOriginalInventoryValue(Double originalInventoryValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByOriginalInventoryValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOriginalInventoryValue here] end
	{
		// % protected region % [Add any additional logic for findByOriginalInventoryValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByOriginalInventoryValue before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByOriginalInventoryValue(originalInventoryValue));

		// % protected region % [Add any additional logic for findByOriginalInventoryValue before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOriginalInventoryValue before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Qty.
	 *
	 * @param qty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByQty(Double qty)
	// % protected region % [Add any throwables, implementations, or extensions for findByQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQty here] end
	{
		// % protected region % [Add any additional logic for findByQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByQty before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByQty(qty));

		// % protected region % [Add any additional logic for findByQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Uom.
	 *
	 * @param uom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uom
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByUom(String uom)
	// % protected region % [Add any throwables, implementations, or extensions for findByUom here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUom here] end
	{
		// % protected region % [Add any additional logic for findByUom before the main body here] off begin
		// % protected region % [Add any additional logic for findByUom before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByUom(uom));

		// % protected region % [Add any additional logic for findByUom before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUom before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Price.
	 *
	 * @param price the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByPrice(Double price)
	// % protected region % [Add any throwables, implementations, or extensions for findByPrice here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPrice here] end
	{
		// % protected region % [Add any additional logic for findByPrice before the main body here] off begin
		// % protected region % [Add any additional logic for findByPrice before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByPrice(price));

		// % protected region % [Add any additional logic for findByPrice before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPrice before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Cost.
	 *
	 * @param totalCost the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Cost
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByTotalCost(Double totalCost)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalCost here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalCost here] end
	{
		// % protected region % [Add any additional logic for findByTotalCost before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalCost before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByTotalCost(totalCost));

		// % protected region % [Add any additional logic for findByTotalCost before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalCost before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Adjusted Soh.
	 *
	 * @param adjustedSoh the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Adjusted Soh
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByAdjustedSoh(Double adjustedSoh)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdjustedSoh here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdjustedSoh here] end
	{
		// % protected region % [Add any additional logic for findByAdjustedSoh before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdjustedSoh before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByAdjustedSoh(adjustedSoh));

		// % protected region % [Add any additional logic for findByAdjustedSoh before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdjustedSoh before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Adjusted Inventory Value.
	 *
	 * @param adjustedInventoryValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Adjusted Inventory Value
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByAdjustedInventoryValue(Double adjustedInventoryValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdjustedInventoryValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdjustedInventoryValue here] end
	{
		// % protected region % [Add any additional logic for findByAdjustedInventoryValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdjustedInventoryValue before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByAdjustedInventoryValue(adjustedInventoryValue));

		// % protected region % [Add any additional logic for findByAdjustedInventoryValue before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdjustedInventoryValue before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Minimal Level.
	 *
	 * @param minimalLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Minimal Level
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByMinimalLevel(Double minimalLevel)
	// % protected region % [Add any throwables, implementations, or extensions for findByMinimalLevel here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMinimalLevel here] end
	{
		// % protected region % [Add any additional logic for findByMinimalLevel before the main body here] off begin
		// % protected region % [Add any additional logic for findByMinimalLevel before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByMinimalLevel(minimalLevel));

		// % protected region % [Add any additional logic for findByMinimalLevel before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMinimalLevel before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Maximal Level.
	 *
	 * @param maximalLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Maximal Level
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByMaximalLevel(Double maximalLevel)
	// % protected region % [Add any throwables, implementations, or extensions for findByMaximalLevel here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMaximalLevel here] end
	{
		// % protected region % [Add any additional logic for findByMaximalLevel before the main body here] off begin
		// % protected region % [Add any additional logic for findByMaximalLevel before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByMaximalLevel(maximalLevel));

		// % protected region % [Add any additional logic for findByMaximalLevel before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMaximalLevel before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByItemNotes(String itemNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] end
	{
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByItemNotes(itemNotes));

		// % protected region % [Add any additional logic for findByItemNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Uoi.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uoi
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByUoi(String uoi)
	// % protected region % [Add any throwables, implementations, or extensions for findByUoi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUoi here] end
	{
		// % protected region % [Add any additional logic for findByUoi before the main body here] off begin
		// % protected region % [Add any additional logic for findByUoi before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByUoi(uoi));

		// % protected region % [Add any additional logic for findByUoi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUoi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Qty Uoi.
	 *
	 * @param qtyUoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Uoi
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByQtyUoi(Double qtyUoi)
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyUoi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyUoi here] end
	{
		// % protected region % [Add any additional logic for findByQtyUoi before the main body here] off begin
		// % protected region % [Add any additional logic for findByQtyUoi before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByQtyUoi(qtyUoi));

		// % protected region % [Add any additional logic for findByQtyUoi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQtyUoi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Price Uoi.
	 *
	 * @param priceUoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Price Uoi
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByPriceUoi(Double priceUoi)
	// % protected region % [Add any throwables, implementations, or extensions for findByPriceUoi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPriceUoi here] end
	{
		// % protected region % [Add any additional logic for findByPriceUoi before the main body here] off begin
		// % protected region % [Add any additional logic for findByPriceUoi before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByPriceUoi(priceUoi));

		// % protected region % [Add any additional logic for findByPriceUoi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPriceUoi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inventory Rounding Value.
	 *
	 * @param inventoryRoundingValue the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inventory Rounding Value
	 */
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findByInventoryRoundingValue(Double inventoryRoundingValue)
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRoundingValue here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInventoryRoundingValue here] end
	{
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before the main body here] off begin
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before the main body here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findByInventoryRoundingValue(inventoryRoundingValue));

		// % protected region % [Add any additional logic for findByInventoryRoundingValue before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInventoryRoundingValue before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<InventoryAdjustmentItemEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<InventoryAdjustmentItemEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<InventoryAdjustmentItemEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'create')")
	public InventoryAdjustmentItemEntity create(InventoryAdjustmentItemEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		InventoryAdjustmentItemEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'create')")
	public InventoryAdjustmentItemEntity create(InventoryAdjustmentItemEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		InventoryAdjustmentItemEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		InventoryAdjustmentItemEntity newEntity;

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
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'create')")
	public List<InventoryAdjustmentItemEntity> createAll(Iterable<InventoryAdjustmentItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<InventoryAdjustmentItemEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<InventoryAdjustmentItemEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'update')")
	public InventoryAdjustmentItemEntity update(InventoryAdjustmentItemEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		InventoryAdjustmentItemEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'update')")
	public InventoryAdjustmentItemEntity update(InventoryAdjustmentItemEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		InventoryAdjustmentItemEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		InventoryAdjustmentItemEntity newEntity;

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
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'update')")
	public List<InventoryAdjustmentItemEntity> updateAll(Iterable<InventoryAdjustmentItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<InventoryAdjustmentItemEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<InventoryAdjustmentItemEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'create') or hasPermission('InventoryAdjustmentItemEntity', 'update')")
	public InventoryAdjustmentItemEntity save(InventoryAdjustmentItemEntity entity) throws ConstraintViolationException
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

		InventoryAdjustmentItemEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'create') or hasPermission('InventoryAdjustmentItemEntity', 'update')")
	public List<InventoryAdjustmentItemEntity> saveAll(Iterable<InventoryAdjustmentItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<InventoryAdjustmentItemEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	public List<InventoryAdjustmentItemEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	public List<InventoryAdjustmentItemEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(InventoryAdjustmentItemEntity.class);

		// % protected region % [Add any additional processing before converting to a list of InventoryAdjustmentItemEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of InventoryAdjustmentItemEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('InventoryAdjustmentItemEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InventoryAdjustmentItemEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of InventoryAdjustmentItemEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of InventoryAdjustmentItemEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(InventoryAdjustmentItemEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of InventoryAdjustmentItemEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of InventoryAdjustmentItemEntityAudits
	 */
	private List<InventoryAdjustmentItemEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<InventoryAdjustmentItemEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param inventoryAdjustmentItem inventoryAdjustmentItem to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private InventoryAdjustmentItemEntity updateAuditData(InventoryAdjustmentItemEntity inventoryAdjustmentItem)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return inventoryAdjustmentItem;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private InventoryAdjustmentItemEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		InventoryAdjustmentItemEntity entityAtRevision = updateAuditData((InventoryAdjustmentItemEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new InventoryAdjustmentItemEntityAudit(
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

		QInventoryAdjustmentItemEntity entity = QInventoryAdjustmentItemEntity.inventoryAdjustmentItemEntity;

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
			case "inventoryAdjustmentId":
				// % protected region % [Add any additional logic before the query parameters of relation from Inventory Adjustment to Inventory Adjustment Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Inventory Adjustment to Inventory Adjustment Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inventoryAdjustment.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Inventory Adjustment to Inventory Adjustment Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Inventory Adjustment to Inventory Adjustment Items here] end

				break;
			case "stockCatalogueId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Inventory Adjustment Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Inventory Adjustment Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCatalogue.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Inventory Adjustment Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Inventory Adjustment Items here] end

				break;
			case "inventoryAdjusmentBatchsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Inventory Adjustment Item to Inventory Adjusment Batchs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Inventory Adjustment Item to Inventory Adjusment Batchs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inventoryAdjusmentBatchs.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Inventory Adjustment Item to Inventory Adjusment Batchs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Inventory Adjustment Item to Inventory Adjusment Batchs here] end

				break;
			case "originalInventoryValue":
				// % protected region % [Add any additional logic before the query parameters of originalInventoryValue here] off begin
				// % protected region % [Add any additional logic before the query parameters of originalInventoryValue here] end


				// % protected region % [Add any additional logic after the query parameters of originalInventoryValue here] off begin
				// % protected region % [Add any additional logic after the query parameters of originalInventoryValue here] end

				break;
			case "qty":
				// % protected region % [Add any additional logic before the query parameters of qty here] off begin
				// % protected region % [Add any additional logic before the query parameters of qty here] end


				// % protected region % [Add any additional logic after the query parameters of qty here] off begin
				// % protected region % [Add any additional logic after the query parameters of qty here] end

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
	public InventoryAdjustmentItemEntity updateOldData(InventoryAdjustmentItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public InventoryAdjustmentItemEntity updateOldData(InventoryAdjustmentItemEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		InventoryAdjustmentItemEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInInventoryAdjustmentItemEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getInventoryAdjustment() == null && entity.getInventoryAdjustmentId() == null) {
			entityToUpdate.unsetInventoryAdjustment();
		} else if (entity.getInventoryAdjustmentId() != null && entity.getInventoryAdjustment() == null) {
			Optional<InventoryAdjustmentEntity> inventoryAdjustmentEntity = this.inventoryAdjustmentRepository.findById(entity.getInventoryAdjustmentId());
			entityToUpdate.setInventoryAdjustment(inventoryAdjustmentEntity.orElseThrow());
		}
		if (persistRelations && entity.getInventoryAdjustment() != null) {
			entityToUpdate.setInventoryAdjustment(entity.getInventoryAdjustment(), false);
			if (entityToUpdate.getInventoryAdjustmentId() != null) {
				this.inventoryAdjustmentRepository.save(entityToUpdate.getInventoryAdjustment());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getInventoryAdjustment().unsetInventoryAdjustmentItems();
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
				entityToUpdate.getStockCatalogue().unsetInventoryAdjustmentItems();
			}
		}

		// Outgoing one to many reference
		if (entity.getInventoryAdjusmentBatchsIds().isEmpty() && entity.getInventoryAdjusmentBatchs().isEmpty()) {
			entityToUpdate.setInventoryAdjusmentBatchs(new HashSet<>());
		} else if (!entity.getInventoryAdjusmentBatchsIds().isEmpty() && entity.getInventoryAdjusmentBatchs().isEmpty()) {
			Iterable<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchsEntities =
					this.inventoryAdjusmentBatchRepository.findAllById(entity.getInventoryAdjusmentBatchsIds());
			entityToUpdate.setInventoryAdjusmentBatchs(Sets.newHashSet(inventoryAdjusmentBatchsEntities));
		}
		if (persistRelations && !entity.getInventoryAdjusmentBatchs().isEmpty()) {
			Set<InventoryAdjusmentBatchEntity> updatedEntities = new HashSet<>();
			entity.getInventoryAdjusmentBatchs().forEach(model -> {
				if (model.getId() != null) {
					model = this.inventoryAdjusmentBatchRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInventoryAdjusmentBatchs(updatedEntities);
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
	public void validateEntity(InventoryAdjustmentItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<InventoryAdjustmentItemEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the InventoryAdjustmentItemEntity.
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

	public Set<String> validateEntityRelations(InventoryAdjustmentItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getInventoryAdjustmentId() != null && this.inventoryAdjustmentRepository.findById(entity.getInventoryAdjustmentId()).isEmpty()) {
			errors.add("The UUID " + entity.getInventoryAdjustmentId() + " is not associated with a Inventory Adjustment Entity");
		}

		if (entity.getStockCatalogueId() != null && this.stockCatalogueRepository.findById(entity.getStockCatalogueId()).isEmpty()) {
			errors.add("The UUID " + entity.getStockCatalogueId() + " is not associated with a Stock Catalogue Entity");
		}

		for (UUID id : entity.getInventoryAdjusmentBatchsIds()) {
			if (this.inventoryAdjusmentBatchRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Inventory Adjusment Batch Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
