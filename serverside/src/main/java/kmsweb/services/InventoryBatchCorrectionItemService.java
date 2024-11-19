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
import kmsweb.repositories.InventoryBatchCorrectionItemRepository;
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
import kmsweb.entities.InventoryBatchCorrectionEntity;
import kmsweb.repositories.InventoryBatchCorrectionRepository;
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
public class InventoryBatchCorrectionItemService extends AbstractService<InventoryBatchCorrectionItemEntity, InventoryBatchCorrectionItemRepository, InventoryBatchCorrectionItemEntityAudit> {

	private final String[] referenceNamesInInventoryBatchCorrectionItemEntity = {
		"inventoryBatchCorrection",
		"stockCatalogue",
	};

	private final InventoryBatchCorrectionRepository inventoryBatchCorrectionRepository;

	private final StockCatalogueRepository stockCatalogueRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InventoryBatchCorrectionItemService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		InventoryBatchCorrectionRepository inventoryBatchCorrectionRepository,
		StockCatalogueRepository stockCatalogueRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		InventoryBatchCorrectionItemRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.inventoryBatchCorrectionRepository = inventoryBatchCorrectionRepository;

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
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
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
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
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
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findByItemLineNumber(Integer itemLineNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemLineNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemLineNumber here] end
	{
		// % protected region % [Add any additional logic for findByItemLineNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemLineNumber before the main body here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findByItemLineNumber(itemLineNumber));

		// % protected region % [Add any additional logic for findByItemLineNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemLineNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Batch Number.
	 *
	 * @param batchNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Batch Number
	 */
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findByBatchNumber(String batchNumber)
	// % protected region % [Add any throwables, implementations, or extensions for findByBatchNumber here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBatchNumber here] end
	{
		// % protected region % [Add any additional logic for findByBatchNumber before the main body here] off begin
		// % protected region % [Add any additional logic for findByBatchNumber before the main body here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findByBatchNumber(batchNumber));

		// % protected region % [Add any additional logic for findByBatchNumber before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBatchNumber before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Expiration Date.
	 *
	 * @param expirationDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Expiration Date
	 */
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findByExpirationDate(OffsetDateTime expirationDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByExpirationDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExpirationDate here] end
	{
		// % protected region % [Add any additional logic for findByExpirationDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByExpirationDate before the main body here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findByExpirationDate(expirationDate));

		// % protected region % [Add any additional logic for findByExpirationDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExpirationDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute UOM.
	 *
	 * @param uom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOM
	 */
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findByUom(String uom)
	// % protected region % [Add any throwables, implementations, or extensions for findByUom here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUom here] end
	{
		// % protected region % [Add any additional logic for findByUom before the main body here] off begin
		// % protected region % [Add any additional logic for findByUom before the main body here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findByUom(uom));

		// % protected region % [Add any additional logic for findByUom before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUom before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Available Qty Batch.
	 *
	 * @param availableQtyBatch the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Available Qty Batch
	 */
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findByAvailableQtyBatch(Double availableQtyBatch)
	// % protected region % [Add any throwables, implementations, or extensions for findByAvailableQtyBatch here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAvailableQtyBatch here] end
	{
		// % protected region % [Add any additional logic for findByAvailableQtyBatch before the main body here] off begin
		// % protected region % [Add any additional logic for findByAvailableQtyBatch before the main body here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findByAvailableQtyBatch(availableQtyBatch));

		// % protected region % [Add any additional logic for findByAvailableQtyBatch before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAvailableQtyBatch before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Actual Qty Batch.
	 *
	 * @param actualQtyBatch the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Actual Qty Batch
	 */
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findByActualQtyBatch(Double actualQtyBatch)
	// % protected region % [Add any throwables, implementations, or extensions for findByActualQtyBatch here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByActualQtyBatch here] end
	{
		// % protected region % [Add any additional logic for findByActualQtyBatch before the main body here] off begin
		// % protected region % [Add any additional logic for findByActualQtyBatch before the main body here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findByActualQtyBatch(actualQtyBatch));

		// % protected region % [Add any additional logic for findByActualQtyBatch before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByActualQtyBatch before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Qty Adjusted.
	 *
	 * @param qtyAdjusted the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty Adjusted
	 */
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findByQtyAdjusted(Double qtyAdjusted)
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyAdjusted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyAdjusted here] end
	{
		// % protected region % [Add any additional logic for findByQtyAdjusted before the main body here] off begin
		// % protected region % [Add any additional logic for findByQtyAdjusted before the main body here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findByQtyAdjusted(qtyAdjusted));

		// % protected region % [Add any additional logic for findByQtyAdjusted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQtyAdjusted before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Item Notes.
	 *
	 * @param itemNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Notes
	 */
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findByItemNotes(String itemNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemNotes here] end
	{
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemNotes before the main body here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findByItemNotes(itemNotes));

		// % protected region % [Add any additional logic for findByItemNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByItemNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute UOI.
	 *
	 * @param uoi the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute UOI
	 */
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findByUoi(String uoi)
	// % protected region % [Add any throwables, implementations, or extensions for findByUoi here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUoi here] end
	{
		// % protected region % [Add any additional logic for findByUoi before the main body here] off begin
		// % protected region % [Add any additional logic for findByUoi before the main body here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findByUoi(uoi));

		// % protected region % [Add any additional logic for findByUoi before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUoi before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Qty UOI.
	 *
	 * @param qtyUOI the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Qty UOI
	 */
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findByQtyUOI(Double qtyUOI)
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyUOI here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByQtyUOI here] end
	{
		// % protected region % [Add any additional logic for findByQtyUOI before the main body here] off begin
		// % protected region % [Add any additional logic for findByQtyUOI before the main body here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findByQtyUOI(qtyUOI));

		// % protected region % [Add any additional logic for findByQtyUOI before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByQtyUOI before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<InventoryBatchCorrectionItemEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<InventoryBatchCorrectionItemEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<InventoryBatchCorrectionItemEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'create')")
	public InventoryBatchCorrectionItemEntity create(InventoryBatchCorrectionItemEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		InventoryBatchCorrectionItemEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'create')")
	public InventoryBatchCorrectionItemEntity create(InventoryBatchCorrectionItemEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		InventoryBatchCorrectionItemEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		InventoryBatchCorrectionItemEntity newEntity;

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
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'create')")
	public List<InventoryBatchCorrectionItemEntity> createAll(Iterable<InventoryBatchCorrectionItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<InventoryBatchCorrectionItemEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<InventoryBatchCorrectionItemEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'update')")
	public InventoryBatchCorrectionItemEntity update(InventoryBatchCorrectionItemEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		InventoryBatchCorrectionItemEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'update')")
	public InventoryBatchCorrectionItemEntity update(InventoryBatchCorrectionItemEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		InventoryBatchCorrectionItemEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		InventoryBatchCorrectionItemEntity newEntity;

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
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'update')")
	public List<InventoryBatchCorrectionItemEntity> updateAll(Iterable<InventoryBatchCorrectionItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<InventoryBatchCorrectionItemEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<InventoryBatchCorrectionItemEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'create') or hasPermission('InventoryBatchCorrectionItemEntity', 'update')")
	public InventoryBatchCorrectionItemEntity save(InventoryBatchCorrectionItemEntity entity) throws ConstraintViolationException
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

		InventoryBatchCorrectionItemEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'create') or hasPermission('InventoryBatchCorrectionItemEntity', 'update')")
	public List<InventoryBatchCorrectionItemEntity> saveAll(Iterable<InventoryBatchCorrectionItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<InventoryBatchCorrectionItemEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	public List<InventoryBatchCorrectionItemEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	public List<InventoryBatchCorrectionItemEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(InventoryBatchCorrectionItemEntity.class);

		// % protected region % [Add any additional processing before converting to a list of InventoryBatchCorrectionItemEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of InventoryBatchCorrectionItemEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('InventoryBatchCorrectionItemEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InventoryBatchCorrectionItemEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of InventoryBatchCorrectionItemEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of InventoryBatchCorrectionItemEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(InventoryBatchCorrectionItemEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of InventoryBatchCorrectionItemEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of InventoryBatchCorrectionItemEntityAudits
	 */
	private List<InventoryBatchCorrectionItemEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<InventoryBatchCorrectionItemEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param inventoryBatchCorrectionItem inventoryBatchCorrectionItem to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private InventoryBatchCorrectionItemEntity updateAuditData(InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItem)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return inventoryBatchCorrectionItem;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private InventoryBatchCorrectionItemEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		InventoryBatchCorrectionItemEntity entityAtRevision = updateAuditData((InventoryBatchCorrectionItemEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new InventoryBatchCorrectionItemEntityAudit(
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

		QInventoryBatchCorrectionItemEntity entity = QInventoryBatchCorrectionItemEntity.inventoryBatchCorrectionItemEntity;

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
			case "inventoryBatchCorrectionId":
				// % protected region % [Add any additional logic before the query parameters of relation from Inventory Batch Correction to Inventory Batch Correction Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Inventory Batch Correction to Inventory Batch Correction Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inventoryBatchCorrection.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Inventory Batch Correction to Inventory Batch Correction Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Inventory Batch Correction to Inventory Batch Correction Items here] end

				break;
			case "stockCatalogueId":
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Inventory Batch Correction Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Stock Catalogue to Inventory Batch Correction Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockCatalogue.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Inventory Batch Correction Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Stock Catalogue to Inventory Batch Correction Items here] end

				break;
			case "batchNumber":
				// % protected region % [Add any additional logic before the query parameters of batchNumber here] off begin
				// % protected region % [Add any additional logic before the query parameters of batchNumber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.batchNumber, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of batchNumber here] off begin
				// % protected region % [Add any additional logic after the query parameters of batchNumber here] end

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
	public InventoryBatchCorrectionItemEntity updateOldData(InventoryBatchCorrectionItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public InventoryBatchCorrectionItemEntity updateOldData(InventoryBatchCorrectionItemEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		InventoryBatchCorrectionItemEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInInventoryBatchCorrectionItemEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getInventoryBatchCorrection() == null && entity.getInventoryBatchCorrectionId() == null) {
			entityToUpdate.unsetInventoryBatchCorrection();
		} else if (entity.getInventoryBatchCorrectionId() != null && entity.getInventoryBatchCorrection() == null) {
			Optional<InventoryBatchCorrectionEntity> inventoryBatchCorrectionEntity = this.inventoryBatchCorrectionRepository.findById(entity.getInventoryBatchCorrectionId());
			entityToUpdate.setInventoryBatchCorrection(inventoryBatchCorrectionEntity.orElseThrow());
		}
		if (persistRelations && entity.getInventoryBatchCorrection() != null) {
			entityToUpdate.setInventoryBatchCorrection(entity.getInventoryBatchCorrection(), false);
			if (entityToUpdate.getInventoryBatchCorrectionId() != null) {
				this.inventoryBatchCorrectionRepository.save(entityToUpdate.getInventoryBatchCorrection());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getInventoryBatchCorrection().unsetInventoryBatchCorrectionItems();
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
				entityToUpdate.getStockCatalogue().unsetInventoryBatchCorrectionItems();
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
	public void validateEntity(InventoryBatchCorrectionItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<InventoryBatchCorrectionItemEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the InventoryBatchCorrectionItemEntity.
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

	public Set<String> validateEntityRelations(InventoryBatchCorrectionItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getInventoryBatchCorrectionId() != null && this.inventoryBatchCorrectionRepository.findById(entity.getInventoryBatchCorrectionId()).isEmpty()) {
			errors.add("The UUID " + entity.getInventoryBatchCorrectionId() + " is not associated with a Inventory Batch Correction Entity");
		}

		if (entity.getStockCatalogueId() != null && this.stockCatalogueRepository.findById(entity.getStockCatalogueId()).isEmpty()) {
			errors.add("The UUID " + entity.getStockCatalogueId() + " is not associated with a Stock Catalogue Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
