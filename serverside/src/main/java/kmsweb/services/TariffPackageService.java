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
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.TariffPackageRepository;
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
import kmsweb.entities.ServiceItemAssignmentEntity;
import kmsweb.repositories.ServiceItemAssignmentRepository;
import kmsweb.entities.TariffPackageItemEntity;
import kmsweb.repositories.TariffPackageItemRepository;
import kmsweb.entities.TariffPackageServiceAssignmentEntity;
import kmsweb.repositories.TariffPackageServiceAssignmentRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class TariffPackageService extends AbstractService<TariffPackageEntity, TariffPackageRepository, TariffPackageEntityAudit> {

	private final String[] referenceNamesInTariffPackageEntity = {
		"serviceItemAssignments",
		"tariffPackageItems",
		"tariffPackageServiceAssignments",
	};

	private final ServiceItemAssignmentRepository serviceItemAssignmentRepository;

	private final TariffPackageItemRepository tariffPackageItemRepository;

	private final TariffPackageServiceAssignmentRepository tariffPackageServiceAssignmentRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public TariffPackageService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		ServiceItemAssignmentRepository serviceItemAssignmentRepository,
		TariffPackageItemRepository tariffPackageItemRepository,
		TariffPackageServiceAssignmentRepository tariffPackageServiceAssignmentRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		TariffPackageRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.serviceItemAssignmentRepository = serviceItemAssignmentRepository;

		this.tariffPackageItemRepository = tariffPackageItemRepository;

		this.tariffPackageServiceAssignmentRepository = tariffPackageServiceAssignmentRepository;

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
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
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
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Tariff Package Code.
	 *
	 * @param tariffPackageCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Package Code
	 */
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<TariffPackageEntity> findByTariffPackageCode(String tariffPackageCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffPackageCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffPackageCode here] end
	{
		// % protected region % [Add any additional logic for findByTariffPackageCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByTariffPackageCode before the main body here] end

		Optional<TariffPackageEntity> entity = repository.findByTariffPackageCode(tariffPackageCode);

		// % protected region % [Add any additional logic for findByTariffPackageCode before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByTariffPackageCode before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Package Name.
	 *
	 * @param tariffPackageName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Package Name
	 */
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffPackageEntity> findByTariffPackageName(String tariffPackageName)
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffPackageName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffPackageName here] end
	{
		// % protected region % [Add any additional logic for findByTariffPackageName before the main body here] off begin
		// % protected region % [Add any additional logic for findByTariffPackageName before the main body here] end

		List<TariffPackageEntity> entities = Lists.newArrayList(repository.findByTariffPackageName(tariffPackageName));

		// % protected region % [Add any additional logic for findByTariffPackageName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTariffPackageName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Package Classification.
	 *
	 * @param tariffPackageClassification the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Package Classification
	 */
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffPackageEntity> findByTariffPackageClassification(String tariffPackageClassification)
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffPackageClassification here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffPackageClassification here] end
	{
		// % protected region % [Add any additional logic for findByTariffPackageClassification before the main body here] off begin
		// % protected region % [Add any additional logic for findByTariffPackageClassification before the main body here] end

		List<TariffPackageEntity> entities = Lists.newArrayList(repository.findByTariffPackageClassification(tariffPackageClassification));

		// % protected region % [Add any additional logic for findByTariffPackageClassification before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTariffPackageClassification before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute COA Sell.
	 *
	 * @param coaSell the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute COA Sell
	 */
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffPackageEntity> findByCoaSell(String coaSell)
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaSell here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCoaSell here] end
	{
		// % protected region % [Add any additional logic for findByCoaSell before the main body here] off begin
		// % protected region % [Add any additional logic for findByCoaSell before the main body here] end

		List<TariffPackageEntity> entities = Lists.newArrayList(repository.findByCoaSell(coaSell));

		// % protected region % [Add any additional logic for findByCoaSell before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCoaSell before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tariff Package Description.
	 *
	 * @param tariffPackageDescription the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tariff Package Description
	 */
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffPackageEntity> findByTariffPackageDescription(String tariffPackageDescription)
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffPackageDescription here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTariffPackageDescription here] end
	{
		// % protected region % [Add any additional logic for findByTariffPackageDescription before the main body here] off begin
		// % protected region % [Add any additional logic for findByTariffPackageDescription before the main body here] end

		List<TariffPackageEntity> entities = Lists.newArrayList(repository.findByTariffPackageDescription(tariffPackageDescription));

		// % protected region % [Add any additional logic for findByTariffPackageDescription before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTariffPackageDescription before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Apply To All Services.
	 *
	 * @param applyToAllServices the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Apply To All Services
	 */
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffPackageEntity> findByApplyToAllServices(Boolean applyToAllServices)
	// % protected region % [Add any throwables, implementations, or extensions for findByApplyToAllServices here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApplyToAllServices here] end
	{
		// % protected region % [Add any additional logic for findByApplyToAllServices before the main body here] off begin
		// % protected region % [Add any additional logic for findByApplyToAllServices before the main body here] end

		List<TariffPackageEntity> entities = Lists.newArrayList(repository.findByApplyToAllServices(applyToAllServices));

		// % protected region % [Add any additional logic for findByApplyToAllServices before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApplyToAllServices before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<TariffPackageEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<TariffPackageEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffPackageEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<TariffPackageEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffPackageEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<TariffPackageEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@Transactional(readOnly = true)
	public List<TariffPackageEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<TariffPackageEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TariffPackageEntity', 'create')")
	public TariffPackageEntity create(TariffPackageEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		TariffPackageEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TariffPackageEntity', 'create')")
	public TariffPackageEntity create(TariffPackageEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		TariffPackageEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		TariffPackageEntity newEntity;

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
	@PreAuthorize("hasPermission('TariffPackageEntity', 'create')")
	public List<TariffPackageEntity> createAll(Iterable<TariffPackageEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<TariffPackageEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<TariffPackageEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('TariffPackageEntity', 'update')")
	public TariffPackageEntity update(TariffPackageEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		TariffPackageEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('TariffPackageEntity', 'update')")
	public TariffPackageEntity update(TariffPackageEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		TariffPackageEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		TariffPackageEntity newEntity;

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
	@PreAuthorize("hasPermission('TariffPackageEntity', 'update')")
	public List<TariffPackageEntity> updateAll(Iterable<TariffPackageEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<TariffPackageEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<TariffPackageEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TariffPackageEntity', 'create') or hasPermission('TariffPackageEntity', 'update')")
	public TariffPackageEntity save(TariffPackageEntity entity) throws ConstraintViolationException
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

		TariffPackageEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('TariffPackageEntity', 'create') or hasPermission('TariffPackageEntity', 'update')")
	public List<TariffPackageEntity> saveAll(Iterable<TariffPackageEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<TariffPackageEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('TariffPackageEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('TariffPackageEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TariffPackageEntity', 'delete')")
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
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	public List<TariffPackageEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	public List<TariffPackageEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TariffPackageEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(TariffPackageEntity.class);

		// % protected region % [Add any additional processing before converting to a list of TariffPackageEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of TariffPackageEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('TariffPackageEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TariffPackageEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of TariffPackageEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of TariffPackageEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(TariffPackageEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of TariffPackageEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of TariffPackageEntityAudits
	 */
	private List<TariffPackageEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<TariffPackageEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param tariffPackage tariffPackage to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private TariffPackageEntity updateAuditData(TariffPackageEntity tariffPackage)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return tariffPackage;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private TariffPackageEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		TariffPackageEntity entityAtRevision = updateAuditData((TariffPackageEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new TariffPackageEntityAudit(
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

		QTariffPackageEntity entity = QTariffPackageEntity.tariffPackageEntity;

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
			case "serviceItemAssignmentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Package to Service Item Assignments here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Package to Service Item Assignments here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.serviceItemAssignments.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Package to Service Item Assignments here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Package to Service Item Assignments here] end

				break;
			case "tariffPackageItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Package to Tariff Package Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Package to Tariff Package Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tariffPackageItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Package to Tariff Package Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Package to Tariff Package Items here] end

				break;
			case "tariffPackageServiceAssignmentsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Package to Tariff Package Service Assignments here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Tariff Package to Tariff Package Service Assignments here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tariffPackageServiceAssignments.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Package to Tariff Package Service Assignments here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Tariff Package to Tariff Package Service Assignments here] end

				break;
			case "tariffPackageName":
				// % protected region % [Add any additional logic before the query parameters of tariffPackageName here] off begin
				// % protected region % [Add any additional logic before the query parameters of tariffPackageName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tariffPackageName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tariffPackageName here] off begin
				// % protected region % [Add any additional logic after the query parameters of tariffPackageName here] end

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
	public TariffPackageEntity updateOldData(TariffPackageEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public TariffPackageEntity updateOldData(TariffPackageEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		TariffPackageEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInTariffPackageEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getApplyToAllServices() == null) {
			entityToUpdate.setApplyToAllServices(false);
		}

		// Outgoing one to many reference
		if (entity.getServiceItemAssignmentsIds().isEmpty() && entity.getServiceItemAssignments().isEmpty()) {
			entityToUpdate.setServiceItemAssignments(new HashSet<>());
		} else if (!entity.getServiceItemAssignmentsIds().isEmpty() && entity.getServiceItemAssignments().isEmpty()) {
			Iterable<ServiceItemAssignmentEntity> serviceItemAssignmentsEntities =
					this.serviceItemAssignmentRepository.findAllById(entity.getServiceItemAssignmentsIds());
			entityToUpdate.setServiceItemAssignments(Sets.newHashSet(serviceItemAssignmentsEntities));
		}
		if (persistRelations && !entity.getServiceItemAssignments().isEmpty()) {
			Set<ServiceItemAssignmentEntity> updatedEntities = new HashSet<>();
			entity.getServiceItemAssignments().forEach(model -> {
				if (model.getId() != null) {
					model = this.serviceItemAssignmentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setServiceItemAssignments(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getTariffPackageItemsIds().isEmpty() && entity.getTariffPackageItems().isEmpty()) {
			entityToUpdate.setTariffPackageItems(new HashSet<>());
		} else if (!entity.getTariffPackageItemsIds().isEmpty() && entity.getTariffPackageItems().isEmpty()) {
			Iterable<TariffPackageItemEntity> tariffPackageItemsEntities =
					this.tariffPackageItemRepository.findAllById(entity.getTariffPackageItemsIds());
			entityToUpdate.setTariffPackageItems(Sets.newHashSet(tariffPackageItemsEntities));
		}
		if (persistRelations && !entity.getTariffPackageItems().isEmpty()) {
			Set<TariffPackageItemEntity> updatedEntities = new HashSet<>();
			entity.getTariffPackageItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.tariffPackageItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setTariffPackageItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getTariffPackageServiceAssignmentsIds().isEmpty() && entity.getTariffPackageServiceAssignments().isEmpty()) {
			entityToUpdate.setTariffPackageServiceAssignments(new HashSet<>());
		} else if (!entity.getTariffPackageServiceAssignmentsIds().isEmpty() && entity.getTariffPackageServiceAssignments().isEmpty()) {
			Iterable<TariffPackageServiceAssignmentEntity> tariffPackageServiceAssignmentsEntities =
					this.tariffPackageServiceAssignmentRepository.findAllById(entity.getTariffPackageServiceAssignmentsIds());
			entityToUpdate.setTariffPackageServiceAssignments(Sets.newHashSet(tariffPackageServiceAssignmentsEntities));
		}
		if (persistRelations && !entity.getTariffPackageServiceAssignments().isEmpty()) {
			Set<TariffPackageServiceAssignmentEntity> updatedEntities = new HashSet<>();
			entity.getTariffPackageServiceAssignments().forEach(model -> {
				if (model.getId() != null) {
					model = this.tariffPackageServiceAssignmentRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setTariffPackageServiceAssignments(updatedEntities);
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
	public void validateEntity(TariffPackageEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<TariffPackageEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByTariffPackageCodeOpt = this.findByTariffPackageCode(entity.getTariffPackageCode());
			if (entityByTariffPackageCodeOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<TariffPackageEntity>(
						"Tariff Package Code",
						entity.getTariffPackageCode(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"TariffPackageCode"
				);
				errors.add(uniquenessViolation);
			}
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
	 * Get the sort as given by the sort by for the TariffPackageEntity.
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

	public Set<String> validateEntityRelations(TariffPackageEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		for (UUID id : entity.getServiceItemAssignmentsIds()) {
			if (this.serviceItemAssignmentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Service Item Assignment Entity");
			}
		}

		for (UUID id : entity.getTariffPackageItemsIds()) {
			if (this.tariffPackageItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Tariff Package Item Entity");
			}
		}

		for (UUID id : entity.getTariffPackageServiceAssignmentsIds()) {
			if (this.tariffPackageServiceAssignmentRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Tariff Package Service Assignment Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
