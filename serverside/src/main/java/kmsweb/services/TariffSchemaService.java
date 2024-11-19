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
import kmsweb.repositories.TariffSchemaRepository;
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
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.entities.TariffDefinitionEntity;
import kmsweb.repositories.TariffDefinitionRepository;
import kmsweb.entities.TariffFormulaEntity;
import kmsweb.repositories.TariffFormulaRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class TariffSchemaService extends AbstractService<TariffSchemaEntity, TariffSchemaRepository, TariffSchemaEntityAudit> {

	private final String[] referenceNamesInTariffSchemaEntity = {
		"baseScheme",
		"invoiceItems",
		"invoices",
		"tariffDefinitions",
		"tariffScheme",
	};

	private final InvoiceRepository invoiceRepository;

	private final InvoiceItemRepository invoiceItemRepository;

	private final TariffDefinitionRepository tariffDefinitionRepository;

	private final TariffFormulaRepository tariffFormulaRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public TariffSchemaService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		InvoiceRepository invoiceRepository,
		InvoiceItemRepository invoiceItemRepository,
		TariffDefinitionRepository tariffDefinitionRepository,
		TariffFormulaRepository tariffFormulaRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		TariffSchemaRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.invoiceRepository = invoiceRepository;

		this.invoiceItemRepository = invoiceItemRepository;

		this.tariffDefinitionRepository = tariffDefinitionRepository;

		this.tariffFormulaRepository = tariffFormulaRepository;

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
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
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
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Schema Code.
	 *
	 * @param schemaCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Schema Code
	 */
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffSchemaEntity> findBySchemaCode(String schemaCode)
	// % protected region % [Add any throwables, implementations, or extensions for findBySchemaCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySchemaCode here] end
	{
		// % protected region % [Add any additional logic for findBySchemaCode before the main body here] off begin
		// % protected region % [Add any additional logic for findBySchemaCode before the main body here] end

		List<TariffSchemaEntity> entities = Lists.newArrayList(repository.findBySchemaCode(schemaCode));

		// % protected region % [Add any additional logic for findBySchemaCode before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySchemaCode before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Scheme Name.
	 *
	 * @param schemeName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Scheme Name
	 */
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffSchemaEntity> findBySchemeName(String schemeName)
	// % protected region % [Add any throwables, implementations, or extensions for findBySchemeName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySchemeName here] end
	{
		// % protected region % [Add any additional logic for findBySchemeName before the main body here] off begin
		// % protected region % [Add any additional logic for findBySchemeName before the main body here] end

		List<TariffSchemaEntity> entities = Lists.newArrayList(repository.findBySchemeName(schemeName));

		// % protected region % [Add any additional logic for findBySchemeName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySchemeName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Start Date.
	 *
	 * @param startDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Start Date
	 */
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffSchemaEntity> findByStartDate(OffsetDateTime startDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDate here] end
	{
		// % protected region % [Add any additional logic for findByStartDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByStartDate before the main body here] end

		List<TariffSchemaEntity> entities = Lists.newArrayList(repository.findByStartDate(startDate));

		// % protected region % [Add any additional logic for findByStartDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStartDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute End Date.
	 *
	 * @param endDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute End Date
	 */
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffSchemaEntity> findByEndDate(OffsetDateTime endDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDate here] end
	{
		// % protected region % [Add any additional logic for findByEndDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByEndDate before the main body here] end

		List<TariffSchemaEntity> entities = Lists.newArrayList(repository.findByEndDate(endDate));

		// % protected region % [Add any additional logic for findByEndDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEndDate before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<TariffSchemaEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<TariffSchemaEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffSchemaEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<TariffSchemaEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffSchemaEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<TariffSchemaEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffSchemaEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<TariffSchemaEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'create')")
	public TariffSchemaEntity create(TariffSchemaEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		TariffSchemaEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'create')")
	public TariffSchemaEntity create(TariffSchemaEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		TariffSchemaEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		TariffSchemaEntity newEntity;

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
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'create')")
	public List<TariffSchemaEntity> createAll(Iterable<TariffSchemaEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<TariffSchemaEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<TariffSchemaEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'update')")
	public TariffSchemaEntity update(TariffSchemaEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		TariffSchemaEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'update')")
	public TariffSchemaEntity update(TariffSchemaEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		TariffSchemaEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		TariffSchemaEntity newEntity;

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
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'update')")
	public List<TariffSchemaEntity> updateAll(Iterable<TariffSchemaEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<TariffSchemaEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<TariffSchemaEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'create') or hasPermission('TariffSchemaEntity', 'update')")
	public TariffSchemaEntity save(TariffSchemaEntity entity) throws ConstraintViolationException
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

		TariffSchemaEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'create') or hasPermission('TariffSchemaEntity', 'update')")
	public List<TariffSchemaEntity> saveAll(Iterable<TariffSchemaEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<TariffSchemaEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	public List<TariffSchemaEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	public List<TariffSchemaEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TariffSchemaEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(TariffSchemaEntity.class);

		// % protected region % [Add any additional processing before converting to a list of TariffSchemaEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of TariffSchemaEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('TariffSchemaEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TariffSchemaEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of TariffSchemaEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of TariffSchemaEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(TariffSchemaEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of TariffSchemaEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of TariffSchemaEntityAudits
	 */
	private List<TariffSchemaEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<TariffSchemaEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param tariffSchema tariffSchema to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private TariffSchemaEntity updateAuditData(TariffSchemaEntity tariffSchema)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return tariffSchema;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private TariffSchemaEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		TariffSchemaEntity entityAtRevision = updateAuditData((TariffSchemaEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new TariffSchemaEntityAudit(
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

		QTariffSchemaEntity entity = QTariffSchemaEntity.tariffSchemaEntity;

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
			case "baseSchemeId":
				// % protected region % [Add any additional logic before the query parameters of relation from Base Schema to Base Scheme here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Base Schema to Base Scheme here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.baseScheme.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Base Schema to Base Scheme here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Base Schema to Base Scheme here] end

				break;
			case "invoiceItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Schema to Invoice Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Schema to Invoice Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoiceItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Schema to Invoice Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Schema to Invoice Items here] end

				break;
			case "invoicesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Schema to Invoices here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Schema to Invoices here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.invoices.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Schema to Invoices here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Schema to Invoices here] end

				break;
			case "tariffDefinitionsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Price Schema to Tariff Definitions here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Price Schema to Tariff Definitions here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tariffDefinitions.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Price Schema to Tariff Definitions here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Price Schema to Tariff Definitions here] end

				break;
			case "tariffSchemeId":
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Schema to Tariff Scheme here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Schema to Tariff Scheme here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tariffScheme.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Schema to Tariff Scheme here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Schema to Tariff Scheme here] end

				break;
			case "schemaCode":
				// % protected region % [Add any additional logic before the query parameters of schemaCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of schemaCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.schemaCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of schemaCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of schemaCode here] end

				break;
			case "schemeName":
				// % protected region % [Add any additional logic before the query parameters of schemeName here] off begin
				// % protected region % [Add any additional logic before the query parameters of schemeName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.schemeName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of schemeName here] off begin
				// % protected region % [Add any additional logic after the query parameters of schemeName here] end

				break;
			case "startDate":
				// % protected region % [Add any additional logic before the query parameters of startDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of startDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.startDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of startDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of startDate here] end

				break;
			case "endDate":
				// % protected region % [Add any additional logic before the query parameters of endDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of endDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.endDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of endDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of endDate here] end

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
	public TariffSchemaEntity updateOldData(TariffSchemaEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public TariffSchemaEntity updateOldData(TariffSchemaEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		TariffSchemaEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInTariffSchemaEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Outgoing one to many reference
		if (entity.getBaseSchemeIds().isEmpty() && entity.getBaseScheme().isEmpty()) {
			entityToUpdate.setBaseScheme(new HashSet<>());
		} else if (!entity.getBaseSchemeIds().isEmpty() && entity.getBaseScheme().isEmpty()) {
			Iterable<TariffFormulaEntity> baseSchemeEntities =
					this.tariffFormulaRepository.findAllById(entity.getBaseSchemeIds());
			entityToUpdate.setBaseScheme(Sets.newHashSet(baseSchemeEntities));
		}
		if (persistRelations && !entity.getBaseScheme().isEmpty()) {
			Set<TariffFormulaEntity> updatedEntities = new HashSet<>();
			entity.getBaseScheme().forEach(model -> {
				if (model.getId() != null) {
					model = this.tariffFormulaRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBaseScheme(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInvoiceItemsIds().isEmpty() && entity.getInvoiceItems().isEmpty()) {
			entityToUpdate.setInvoiceItems(new HashSet<>());
		} else if (!entity.getInvoiceItemsIds().isEmpty() && entity.getInvoiceItems().isEmpty()) {
			Iterable<InvoiceItemEntity> invoiceItemsEntities =
					this.invoiceItemRepository.findAllById(entity.getInvoiceItemsIds());
			entityToUpdate.setInvoiceItems(Sets.newHashSet(invoiceItemsEntities));
		}
		if (persistRelations && !entity.getInvoiceItems().isEmpty()) {
			Set<InvoiceItemEntity> updatedEntities = new HashSet<>();
			entity.getInvoiceItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.invoiceItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoiceItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getInvoicesIds().isEmpty() && entity.getInvoices().isEmpty()) {
			entityToUpdate.setInvoices(new HashSet<>());
		} else if (!entity.getInvoicesIds().isEmpty() && entity.getInvoices().isEmpty()) {
			Iterable<InvoiceEntity> invoicesEntities =
					this.invoiceRepository.findAllById(entity.getInvoicesIds());
			entityToUpdate.setInvoices(Sets.newHashSet(invoicesEntities));
		}
		if (persistRelations && !entity.getInvoices().isEmpty()) {
			Set<InvoiceEntity> updatedEntities = new HashSet<>();
			entity.getInvoices().forEach(model -> {
				if (model.getId() != null) {
					model = this.invoiceRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setInvoices(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getTariffDefinitionsIds().isEmpty() && entity.getTariffDefinitions().isEmpty()) {
			entityToUpdate.setTariffDefinitions(new HashSet<>());
		} else if (!entity.getTariffDefinitionsIds().isEmpty() && entity.getTariffDefinitions().isEmpty()) {
			Iterable<TariffDefinitionEntity> tariffDefinitionsEntities =
					this.tariffDefinitionRepository.findAllById(entity.getTariffDefinitionsIds());
			entityToUpdate.setTariffDefinitions(Sets.newHashSet(tariffDefinitionsEntities));
		}
		if (persistRelations && !entity.getTariffDefinitions().isEmpty()) {
			Set<TariffDefinitionEntity> updatedEntities = new HashSet<>();
			entity.getTariffDefinitions().forEach(model -> {
				if (model.getId() != null) {
					model = this.tariffDefinitionRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setTariffDefinitions(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getTariffSchemeIds().isEmpty() && entity.getTariffScheme().isEmpty()) {
			entityToUpdate.setTariffScheme(new HashSet<>());
		} else if (!entity.getTariffSchemeIds().isEmpty() && entity.getTariffScheme().isEmpty()) {
			Iterable<TariffFormulaEntity> tariffSchemeEntities =
					this.tariffFormulaRepository.findAllById(entity.getTariffSchemeIds());
			entityToUpdate.setTariffScheme(Sets.newHashSet(tariffSchemeEntities));
		}
		if (persistRelations && !entity.getTariffScheme().isEmpty()) {
			Set<TariffFormulaEntity> updatedEntities = new HashSet<>();
			entity.getTariffScheme().forEach(model -> {
				if (model.getId() != null) {
					model = this.tariffFormulaRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setTariffScheme(updatedEntities);
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
	public void validateEntity(TariffSchemaEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<TariffSchemaEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the TariffSchemaEntity.
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

	public Set<String> validateEntityRelations(TariffSchemaEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		for (UUID id : entity.getBaseSchemeIds()) {
			if (this.tariffFormulaRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Tariff Formula Entity");
			}
		}

		for (UUID id : entity.getInvoiceItemsIds()) {
			if (this.invoiceItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Item Entity");
			}
		}

		for (UUID id : entity.getInvoicesIds()) {
			if (this.invoiceRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Invoice Entity");
			}
		}

		for (UUID id : entity.getTariffDefinitionsIds()) {
			if (this.tariffDefinitionRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Tariff Definition Entity");
			}
		}

		for (UUID id : entity.getTariffSchemeIds()) {
			if (this.tariffFormulaRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Tariff Formula Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
