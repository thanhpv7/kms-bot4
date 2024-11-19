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
import kmsweb.repositories.TransactionDetailTypeRepository;
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
import kmsweb.entities.InventoryAdjustmentEntity;
import kmsweb.repositories.InventoryAdjustmentRepository;
import kmsweb.entities.StockTransactionDetailEntity;
import kmsweb.repositories.StockTransactionDetailRepository;
import kmsweb.entities.StockTransactionPerDateTypeEntity;
import kmsweb.repositories.StockTransactionPerDateTypeRepository;
import kmsweb.entities.TransactionDetailTypeMappingEntity;
import kmsweb.repositories.TransactionDetailTypeMappingRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class TransactionDetailTypeService extends AbstractService<TransactionDetailTypeEntity, TransactionDetailTypeRepository, TransactionDetailTypeEntityAudit> {

	private final String[] referenceNamesInTransactionDetailTypeEntity = {
		"inventoryAdjustments",
		"stockTransactionDetails",
		"stockTransactionPerDateTypes",
		"transactionDetailTypeMappings",
	};

	private final InventoryAdjustmentRepository inventoryAdjustmentRepository;

	private final StockTransactionDetailRepository stockTransactionDetailRepository;

	private final StockTransactionPerDateTypeRepository stockTransactionPerDateTypeRepository;

	private final TransactionDetailTypeMappingRepository transactionDetailTypeMappingRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public TransactionDetailTypeService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		InventoryAdjustmentRepository inventoryAdjustmentRepository,
		StockTransactionDetailRepository stockTransactionDetailRepository,
		StockTransactionPerDateTypeRepository stockTransactionPerDateTypeRepository,
		TransactionDetailTypeMappingRepository transactionDetailTypeMappingRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		TransactionDetailTypeRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.inventoryAdjustmentRepository = inventoryAdjustmentRepository;

		this.stockTransactionDetailRepository = stockTransactionDetailRepository;

		this.stockTransactionPerDateTypeRepository = stockTransactionPerDateTypeRepository;

		this.transactionDetailTypeMappingRepository = transactionDetailTypeMappingRepository;

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
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
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
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Transaction Detail.
	 *
	 * @param transactionDetail the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Transaction Detail
	 */
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransactionDetailTypeEntity> findByTransactionDetail(String transactionDetail)
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDetail here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTransactionDetail here] end
	{
		// % protected region % [Add any additional logic for findByTransactionDetail before the main body here] off begin
		// % protected region % [Add any additional logic for findByTransactionDetail before the main body here] end

		List<TransactionDetailTypeEntity> entities = Lists.newArrayList(repository.findByTransactionDetail(transactionDetail));

		// % protected region % [Add any additional logic for findByTransactionDetail before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTransactionDetail before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransactionDetailTypeEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<TransactionDetailTypeEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute COA COGS.
	 *
	 * @param coaCOGS the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA COGS
	 */
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransactionDetailTypeEntity> findByCoaCOGS(String coaCOGS)
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaCOGS here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaCOGS here] end
	{
		// % protected region % [Add any additional logic for findByCoaCOGS before the main body here] off begin
		// % protected region % [Add any additional logic for findByCoaCOGS before the main body here] end

		List<TransactionDetailTypeEntity> entities = Lists.newArrayList(repository.findByCoaCOGS(coaCOGS));

		// % protected region % [Add any additional logic for findByCoaCOGS before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCoaCOGS before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute COA Sell.
	 *
	 * @param coaSell the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA Sell
	 */
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransactionDetailTypeEntity> findByCoaSell(String coaSell)
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaSell here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaSell here] end
	{
		// % protected region % [Add any additional logic for findByCoaSell before the main body here] off begin
		// % protected region % [Add any additional logic for findByCoaSell before the main body here] end

		List<TransactionDetailTypeEntity> entities = Lists.newArrayList(repository.findByCoaSell(coaSell));

		// % protected region % [Add any additional logic for findByCoaSell before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCoaSell before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute COA Inventory.
	 *
	 * @param coaInventory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA Inventory
	 */
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransactionDetailTypeEntity> findByCoaInventory(String coaInventory)
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaInventory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaInventory here] end
	{
		// % protected region % [Add any additional logic for findByCoaInventory before the main body here] off begin
		// % protected region % [Add any additional logic for findByCoaInventory before the main body here] end

		List<TransactionDetailTypeEntity> entities = Lists.newArrayList(repository.findByCoaInventory(coaInventory));

		// % protected region % [Add any additional logic for findByCoaInventory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCoaInventory before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<TransactionDetailTypeEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<TransactionDetailTypeEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransactionDetailTypeEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<TransactionDetailTypeEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransactionDetailTypeEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<TransactionDetailTypeEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TransactionDetailTypeEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<TransactionDetailTypeEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'create')")
	public TransactionDetailTypeEntity create(TransactionDetailTypeEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		TransactionDetailTypeEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'create')")
	public TransactionDetailTypeEntity create(TransactionDetailTypeEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		TransactionDetailTypeEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		TransactionDetailTypeEntity newEntity;

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
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'create')")
	public List<TransactionDetailTypeEntity> createAll(Iterable<TransactionDetailTypeEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<TransactionDetailTypeEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<TransactionDetailTypeEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'update')")
	public TransactionDetailTypeEntity update(TransactionDetailTypeEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		TransactionDetailTypeEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'update')")
	public TransactionDetailTypeEntity update(TransactionDetailTypeEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		TransactionDetailTypeEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		TransactionDetailTypeEntity newEntity;

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
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'update')")
	public List<TransactionDetailTypeEntity> updateAll(Iterable<TransactionDetailTypeEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<TransactionDetailTypeEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<TransactionDetailTypeEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'create') or hasPermission('TransactionDetailTypeEntity', 'update')")
	public TransactionDetailTypeEntity save(TransactionDetailTypeEntity entity) throws ConstraintViolationException
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

		TransactionDetailTypeEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'create') or hasPermission('TransactionDetailTypeEntity', 'update')")
	public List<TransactionDetailTypeEntity> saveAll(Iterable<TransactionDetailTypeEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<TransactionDetailTypeEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	public List<TransactionDetailTypeEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	public List<TransactionDetailTypeEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TransactionDetailTypeEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(TransactionDetailTypeEntity.class);

		// % protected region % [Add any additional processing before converting to a list of TransactionDetailTypeEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of TransactionDetailTypeEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('TransactionDetailTypeEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TransactionDetailTypeEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of TransactionDetailTypeEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of TransactionDetailTypeEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(TransactionDetailTypeEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of TransactionDetailTypeEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of TransactionDetailTypeEntityAudits
	 */
	private List<TransactionDetailTypeEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<TransactionDetailTypeEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param transactionDetailType transactionDetailType to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private TransactionDetailTypeEntity updateAuditData(TransactionDetailTypeEntity transactionDetailType)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return transactionDetailType;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private TransactionDetailTypeEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		TransactionDetailTypeEntity entityAtRevision = updateAuditData((TransactionDetailTypeEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new TransactionDetailTypeEntityAudit(
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

		QTransactionDetailTypeEntity entity = QTransactionDetailTypeEntity.transactionDetailTypeEntity;

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
			case "inventoryAdjustmentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Transaction Detail Type to Inventory Adjustments here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Transaction Detail Type to Inventory Adjustments here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inventoryAdjustments.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Transaction Detail Type to Inventory Adjustments here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Transaction Detail Type to Inventory Adjustments here] end

				break;
			case "stockTransactionDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Transaction Detail Type to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Transaction Detail Type to Stock Transaction Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockTransactionDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Transaction Detail Type to Stock Transaction Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Transaction Detail Type to Stock Transaction Details here] end

				break;
			case "stockTransactionPerDateTypesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Transaction Detail Type to Stock Transaction Per Date Types here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Transaction Detail Type to Stock Transaction Per Date Types here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.stockTransactionPerDateTypes.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Transaction Detail Type to Stock Transaction Per Date Types here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Transaction Detail Type to Stock Transaction Per Date Types here] end

				break;
			case "transactionDetailTypeMappingsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Transaction Detail Type to Transaction Detail Type Mappings here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Transaction Detail Type to Transaction Detail Type Mappings here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionDetailTypeMappings.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Transaction Detail Type to Transaction Detail Type Mappings here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Transaction Detail Type to Transaction Detail Type Mappings here] end

				break;
			case "transactionDetail":
				// % protected region % [Add any additional logic before the query parameters of transactionDetail here] off begin
				// % protected region % [Add any additional logic before the query parameters of transactionDetail here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.transactionDetail, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of transactionDetail here] off begin
				// % protected region % [Add any additional logic after the query parameters of transactionDetail here] end

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
	public TransactionDetailTypeEntity updateOldData(TransactionDetailTypeEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public TransactionDetailTypeEntity updateOldData(TransactionDetailTypeEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		TransactionDetailTypeEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInTransactionDetailTypeEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Outgoing one to many reference
		if (entity.getInventoryAdjustmentsIds().isEmpty() && entity.getInventoryAdjustments().isEmpty()) {
			entityToUpdate.setInventoryAdjustments(new HashSet<>());
		} else if (!entity.getInventoryAdjustmentsIds().isEmpty() && entity.getInventoryAdjustments().isEmpty()) {
			Iterable<InventoryAdjustmentEntity> inventoryAdjustmentsEntities =
					this.inventoryAdjustmentRepository.findAllById(entity.getInventoryAdjustmentsIds());
			entityToUpdate.setInventoryAdjustments(Sets.newHashSet(inventoryAdjustmentsEntities));
		}
		if (persistRelations && !entity.getInventoryAdjustments().isEmpty()) {
			Set<InventoryAdjustmentEntity> updatedEntities = new HashSet<>();
			entity.getInventoryAdjustments().forEach(model -> {
				if (model.getId() != null) {
					model = this.inventoryAdjustmentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInventoryAdjustments(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getStockTransactionDetailsIds().isEmpty() && entity.getStockTransactionDetails().isEmpty()) {
			entityToUpdate.setStockTransactionDetails(new HashSet<>());
		} else if (!entity.getStockTransactionDetailsIds().isEmpty() && entity.getStockTransactionDetails().isEmpty()) {
			Iterable<StockTransactionDetailEntity> stockTransactionDetailsEntities =
					this.stockTransactionDetailRepository.findAllById(entity.getStockTransactionDetailsIds());
			entityToUpdate.setStockTransactionDetails(Sets.newHashSet(stockTransactionDetailsEntities));
		}
		if (persistRelations && !entity.getStockTransactionDetails().isEmpty()) {
			Set<StockTransactionDetailEntity> updatedEntities = new HashSet<>();
			entity.getStockTransactionDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.stockTransactionDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setStockTransactionDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getStockTransactionPerDateTypesIds().isEmpty() && entity.getStockTransactionPerDateTypes().isEmpty()) {
			entityToUpdate.setStockTransactionPerDateTypes(new HashSet<>());
		} else if (!entity.getStockTransactionPerDateTypesIds().isEmpty() && entity.getStockTransactionPerDateTypes().isEmpty()) {
			Iterable<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypesEntities =
					this.stockTransactionPerDateTypeRepository.findAllById(entity.getStockTransactionPerDateTypesIds());
			entityToUpdate.setStockTransactionPerDateTypes(Sets.newHashSet(stockTransactionPerDateTypesEntities));
		}
		if (persistRelations && !entity.getStockTransactionPerDateTypes().isEmpty()) {
			Set<StockTransactionPerDateTypeEntity> updatedEntities = new HashSet<>();
			entity.getStockTransactionPerDateTypes().forEach(model -> {
				if (model.getId() != null) {
					model = this.stockTransactionPerDateTypeRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setStockTransactionPerDateTypes(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getTransactionDetailTypeMappingsIds().isEmpty() && entity.getTransactionDetailTypeMappings().isEmpty()) {
			entityToUpdate.setTransactionDetailTypeMappings(new HashSet<>());
		} else if (!entity.getTransactionDetailTypeMappingsIds().isEmpty() && entity.getTransactionDetailTypeMappings().isEmpty()) {
			Iterable<TransactionDetailTypeMappingEntity> transactionDetailTypeMappingsEntities =
					this.transactionDetailTypeMappingRepository.findAllById(entity.getTransactionDetailTypeMappingsIds());
			entityToUpdate.setTransactionDetailTypeMappings(Sets.newHashSet(transactionDetailTypeMappingsEntities));
		}
		if (persistRelations && !entity.getTransactionDetailTypeMappings().isEmpty()) {
			Set<TransactionDetailTypeMappingEntity> updatedEntities = new HashSet<>();
			entity.getTransactionDetailTypeMappings().forEach(model -> {
				if (model.getId() != null) {
					model = this.transactionDetailTypeMappingRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setTransactionDetailTypeMappings(updatedEntities);
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
	public void validateEntity(TransactionDetailTypeEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<TransactionDetailTypeEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the TransactionDetailTypeEntity.
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

	public Set<String> validateEntityRelations(TransactionDetailTypeEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		for (UUID id : entity.getInventoryAdjustmentsIds()) {
			if (this.inventoryAdjustmentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Inventory Adjustment Entity");
			}
		}

		for (UUID id : entity.getStockTransactionDetailsIds()) {
			if (this.stockTransactionDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Stock Transaction Detail Entity");
			}
		}

		for (UUID id : entity.getStockTransactionPerDateTypesIds()) {
			if (this.stockTransactionPerDateTypeRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Stock Transaction Per Date Type Entity");
			}
		}

		for (UUID id : entity.getTransactionDetailTypeMappingsIds()) {
			if (this.transactionDetailTypeMappingRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Transaction Detail Type Mapping Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
