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
import kmsweb.repositories.ExaminationItemRepository;
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
import kmsweb.entities.DiagnosticExaminationResultsEntity;
import kmsweb.repositories.DiagnosticExaminationResultsRepository;
import kmsweb.entities.ExaminationGroupEntity;
import kmsweb.repositories.ExaminationGroupRepository;
import kmsweb.entities.ExaminationItemDetailEntity;
import kmsweb.repositories.ExaminationItemDetailRepository;
import kmsweb.entities.McuPackageItemEntity;
import kmsweb.repositories.McuPackageItemRepository;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.entities.ServiceItemEntity;
import kmsweb.repositories.ServiceItemRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class ExaminationItemService extends AbstractService<ExaminationItemEntity, ExaminationItemRepository, ExaminationItemEntityAudit> {

	private final String[] referenceNamesInExaminationItemEntity = {
		"diagnosticExaminationResults",
		"examinationItemDetails",
		"examinationItemOfMCUItem",
		"registrations",
		"examinationGroup",
		"serviceItem",
	};

	private final DiagnosticExaminationResultsRepository diagnosticExaminationResultsRepository;

	private final ExaminationGroupRepository examinationGroupRepository;

	private final ExaminationItemDetailRepository examinationItemDetailRepository;

	private final McuPackageItemRepository mcuPackageItemRepository;

	private final RegistrationRepository registrationRepository;

	private final ServiceItemRepository serviceItemRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public ExaminationItemService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		DiagnosticExaminationResultsRepository diagnosticExaminationResultsRepository,
		ExaminationGroupRepository examinationGroupRepository,
		ExaminationItemDetailRepository examinationItemDetailRepository,
		McuPackageItemRepository mcuPackageItemRepository,
		RegistrationRepository registrationRepository,
		ServiceItemRepository serviceItemRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		ExaminationItemRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.diagnosticExaminationResultsRepository = diagnosticExaminationResultsRepository;

		this.examinationGroupRepository = examinationGroupRepository;

		this.examinationItemDetailRepository = examinationItemDetailRepository;

		this.mcuPackageItemRepository = mcuPackageItemRepository;

		this.registrationRepository = registrationRepository;

		this.serviceItemRepository = serviceItemRepository;

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
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
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
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Item Code.
	 *
	 * @param itemCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Item Code
	 */
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<ExaminationItemEntity> findByItemCode(String itemCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByItemCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByItemCode here] end
	{
		// % protected region % [Add any additional logic for findByItemCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByItemCode before the main body here] end

		Optional<ExaminationItemEntity> entity = repository.findByItemCode(itemCode);

		// % protected region % [Add any additional logic for findByItemCode before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByItemCode before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ExaminationItemEntity> findByDescription(String description)
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] end
	{
		// % protected region % [Add any additional logic for findByDescription before the main body here] off begin
		// % protected region % [Add any additional logic for findByDescription before the main body here] end

		List<ExaminationItemEntity> entities = Lists.newArrayList(repository.findByDescription(description));

		// % protected region % [Add any additional logic for findByDescription before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDescription before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Sample.
	 *
	 * @param sample the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sample
	 */
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ExaminationItemEntity> findBySample(String sample)
	// % protected region % [Add any throwables, implementations, or extensions for findBySample here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySample here] end
	{
		// % protected region % [Add any additional logic for findBySample before the main body here] off begin
		// % protected region % [Add any additional logic for findBySample before the main body here] end

		List<ExaminationItemEntity> entities = Lists.newArrayList(repository.findBySample(sample));

		// % protected region % [Add any additional logic for findBySample before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySample before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Examination Level.
	 *
	 * @param examinationLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Examination Level
	 */
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ExaminationItemEntity> findByExaminationLevel(String examinationLevel)
	// % protected region % [Add any throwables, implementations, or extensions for findByExaminationLevel here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExaminationLevel here] end
	{
		// % protected region % [Add any additional logic for findByExaminationLevel before the main body here] off begin
		// % protected region % [Add any additional logic for findByExaminationLevel before the main body here] end

		List<ExaminationItemEntity> entities = Lists.newArrayList(repository.findByExaminationLevel(examinationLevel));

		// % protected region % [Add any additional logic for findByExaminationLevel before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExaminationLevel before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Examination Type.
	 *
	 * @param examinationType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Examination Type
	 */
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ExaminationItemEntity> findByExaminationType(String examinationType)
	// % protected region % [Add any throwables, implementations, or extensions for findByExaminationType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByExaminationType here] end
	{
		// % protected region % [Add any additional logic for findByExaminationType before the main body here] off begin
		// % protected region % [Add any additional logic for findByExaminationType before the main body here] end

		List<ExaminationItemEntity> entities = Lists.newArrayList(repository.findByExaminationType(examinationType));

		// % protected region % [Add any additional logic for findByExaminationType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByExaminationType before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<ExaminationItemEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<ExaminationItemEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ExaminationItemEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<ExaminationItemEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ExaminationItemEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<ExaminationItemEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ExaminationItemEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<ExaminationItemEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'create')")
	public ExaminationItemEntity create(ExaminationItemEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		ExaminationItemEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'create')")
	public ExaminationItemEntity create(ExaminationItemEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		ExaminationItemEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		ExaminationItemEntity newEntity;

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
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'create')")
	public List<ExaminationItemEntity> createAll(Iterable<ExaminationItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<ExaminationItemEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<ExaminationItemEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'update')")
	public ExaminationItemEntity update(ExaminationItemEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		ExaminationItemEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'update')")
	public ExaminationItemEntity update(ExaminationItemEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		ExaminationItemEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		ExaminationItemEntity newEntity;

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
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'update')")
	public List<ExaminationItemEntity> updateAll(Iterable<ExaminationItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<ExaminationItemEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<ExaminationItemEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'create') or hasPermission('ExaminationItemEntity', 'update')")
	public ExaminationItemEntity save(ExaminationItemEntity entity) throws ConstraintViolationException
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

		ExaminationItemEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'create') or hasPermission('ExaminationItemEntity', 'update')")
	public List<ExaminationItemEntity> saveAll(Iterable<ExaminationItemEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<ExaminationItemEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'delete')")
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
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'delete')")
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
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	public List<ExaminationItemEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	public List<ExaminationItemEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<ExaminationItemEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(ExaminationItemEntity.class);

		// % protected region % [Add any additional processing before converting to a list of ExaminationItemEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of ExaminationItemEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<ExaminationItemEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of ExaminationItemEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of ExaminationItemEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(ExaminationItemEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of ExaminationItemEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of ExaminationItemEntityAudits
	 */
	private List<ExaminationItemEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<ExaminationItemEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param examinationItem examinationItem to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private ExaminationItemEntity updateAuditData(ExaminationItemEntity examinationItem)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return examinationItem;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private ExaminationItemEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		ExaminationItemEntity entityAtRevision = updateAuditData((ExaminationItemEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new ExaminationItemEntityAudit(
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

		QExaminationItemEntity entity = QExaminationItemEntity.examinationItemEntity;

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
			case "examinationGroupId":
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Group to Examination Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Group to Examination Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.examinationGroup.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Examination Group to Examination Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Examination Group to Examination Items here] end

				break;
			case "serviceItemId":
				// % protected region % [Add any additional logic before the query parameters of relation from Service Item to Examination Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Service Item to Examination Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.serviceItem.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Service Item to Examination Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Service Item to Examination Items here] end

				break;
			case "diagnosticExaminationResultsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Item to Diagnostic Examination Results here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Item to Diagnostic Examination Results here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnosticExaminationResults.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Examination Item to Diagnostic Examination Results here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Examination Item to Diagnostic Examination Results here] end

				break;
			case "examinationItemDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Item to Examination Item Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Item to Examination Item Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.examinationItemDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Examination Item to Examination Item Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Examination Item to Examination Item Details here] end

				break;
			case "examinationItemOfMCUItemId":
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Items to Examination Item of MCU Item here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Items to Examination Item of MCU Item here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.examinationItemOfMCUItem.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Examination Items to Examination Item of MCU Item here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Examination Items to Examination Item of MCU Item here] end

				break;
			case "registrationsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Items to Registrations here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Examination Items to Registrations here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registrations.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Examination Items to Registrations here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Examination Items to Registrations here] end

				break;
			case "itemCode":
				// % protected region % [Add any additional logic before the query parameters of itemCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of itemCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.itemCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of itemCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of itemCode here] end

				break;
			case "description":
				// % protected region % [Add any additional logic before the query parameters of description here] off begin
				// % protected region % [Add any additional logic before the query parameters of description here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.description, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of description here] off begin
				// % protected region % [Add any additional logic after the query parameters of description here] end

				break;
			case "examinationLevel":
				// % protected region % [Add any additional logic before the query parameters of examinationLevel here] off begin
				// % protected region % [Add any additional logic before the query parameters of examinationLevel here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.examinationLevel, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of examinationLevel here] off begin
				// % protected region % [Add any additional logic after the query parameters of examinationLevel here] end

				break;
			case "examinationType":
				// % protected region % [Add any additional logic before the query parameters of examinationType here] off begin
				// % protected region % [Add any additional logic before the query parameters of examinationType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.examinationType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of examinationType here] off begin
				// % protected region % [Add any additional logic after the query parameters of examinationType here] end

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
	public ExaminationItemEntity updateOldData(ExaminationItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public ExaminationItemEntity updateOldData(ExaminationItemEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		ExaminationItemEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInExaminationItemEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getExaminationGroup() == null && entity.getExaminationGroupId() == null) {
			entityToUpdate.unsetExaminationGroup();
		} else if (entity.getExaminationGroupId() != null && entity.getExaminationGroup() == null) {
			Optional<ExaminationGroupEntity> examinationGroupEntity = this.examinationGroupRepository.findById(entity.getExaminationGroupId());
			entityToUpdate.setExaminationGroup(examinationGroupEntity.orElseThrow());
		}
		if (persistRelations && entity.getExaminationGroup() != null) {
			entityToUpdate.setExaminationGroup(entity.getExaminationGroup(), false);
			if (entityToUpdate.getExaminationGroupId() != null) {
				this.examinationGroupRepository.save(entityToUpdate.getExaminationGroup());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getExaminationGroup().unsetExaminationItems();
			}
		}

		// Incoming One to Many reference
		if (entity.getServiceItem() == null && entity.getServiceItemId() == null) {
			entityToUpdate.unsetServiceItem();
		} else if (entity.getServiceItemId() != null && entity.getServiceItem() == null) {
			Optional<ServiceItemEntity> serviceItemEntity = this.serviceItemRepository.findById(entity.getServiceItemId());
			entityToUpdate.setServiceItem(serviceItemEntity.orElseThrow());
		}
		if (persistRelations && entity.getServiceItem() != null) {
			entityToUpdate.setServiceItem(entity.getServiceItem(), false);
			if (entityToUpdate.getServiceItemId() != null) {
				this.serviceItemRepository.save(entityToUpdate.getServiceItem());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getServiceItem().unsetExaminationItems();
			}
		}

		// Outgoing one to many reference
		if (entity.getDiagnosticExaminationResultsIds().isEmpty() && entity.getDiagnosticExaminationResults().isEmpty()) {
			entityToUpdate.setDiagnosticExaminationResults(new HashSet<>());
		} else if (!entity.getDiagnosticExaminationResultsIds().isEmpty() && entity.getDiagnosticExaminationResults().isEmpty()) {
			Iterable<DiagnosticExaminationResultsEntity> diagnosticExaminationResultsEntities =
					this.diagnosticExaminationResultsRepository.findAllById(entity.getDiagnosticExaminationResultsIds());
			entityToUpdate.setDiagnosticExaminationResults(Sets.newHashSet(diagnosticExaminationResultsEntities));
		}
		if (persistRelations && !entity.getDiagnosticExaminationResults().isEmpty()) {
			Set<DiagnosticExaminationResultsEntity> updatedEntities = new HashSet<>();
			entity.getDiagnosticExaminationResults().forEach(model -> {
				if (model.getId() != null) {
					model = this.diagnosticExaminationResultsRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDiagnosticExaminationResults(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getExaminationItemDetailsIds().isEmpty() && entity.getExaminationItemDetails().isEmpty()) {
			entityToUpdate.setExaminationItemDetails(new HashSet<>());
		} else if (!entity.getExaminationItemDetailsIds().isEmpty() && entity.getExaminationItemDetails().isEmpty()) {
			Iterable<ExaminationItemDetailEntity> examinationItemDetailsEntities =
					this.examinationItemDetailRepository.findAllById(entity.getExaminationItemDetailsIds());
			entityToUpdate.setExaminationItemDetails(Sets.newHashSet(examinationItemDetailsEntities));
		}
		if (persistRelations && !entity.getExaminationItemDetails().isEmpty()) {
			Set<ExaminationItemDetailEntity> updatedEntities = new HashSet<>();
			entity.getExaminationItemDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.examinationItemDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setExaminationItemDetails(updatedEntities);
		}

		// Outgoing many to many reference
		if (entity.getExaminationItemOfMCUItemIds().isEmpty() && entity.getExaminationItemOfMCUItem().isEmpty()) {
			entityToUpdate.setExaminationItemOfMCUItem(new HashSet<>());
		} else if (!entity.getExaminationItemOfMCUItemIds().isEmpty() && entity.getExaminationItemOfMCUItem().isEmpty()) {
			Iterable<McuPackageItemEntity> examinationItemOfMCUItemEntities =
					this.mcuPackageItemRepository.findAllById(entity.getExaminationItemOfMCUItemIds());
			entityToUpdate.setExaminationItemOfMCUItem(Sets.newHashSet(examinationItemOfMCUItemEntities));
		}
		if (persistRelations && !entity.getExaminationItemOfMCUItem().isEmpty()) {
			Set<McuPackageItemEntity> updatedEntities = new HashSet<>();
			entity.getExaminationItemOfMCUItem().forEach(model -> {
				if (model.getId() != null) {
					model = this.mcuPackageItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setExaminationItemOfMCUItem(updatedEntities);
		}

		// Outgoing many to many reference
		if (entity.getRegistrationsIds().isEmpty() && entity.getRegistrations().isEmpty()) {
			entityToUpdate.setRegistrations(new HashSet<>());
		} else if (!entity.getRegistrationsIds().isEmpty() && entity.getRegistrations().isEmpty()) {
			Iterable<RegistrationEntity> registrationsEntities =
					this.registrationRepository.findAllById(entity.getRegistrationsIds());
			entityToUpdate.setRegistrations(Sets.newHashSet(registrationsEntities));
		}
		if (persistRelations && !entity.getRegistrations().isEmpty()) {
			Set<RegistrationEntity> updatedEntities = new HashSet<>();
			entity.getRegistrations().forEach(model -> {
				if (model.getId() != null) {
					model = this.registrationRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setRegistrations(updatedEntities);
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
	public void validateEntity(ExaminationItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<ExaminationItemEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByItemCodeOpt = this.findByItemCode(entity.getItemCode());
			if (entityByItemCodeOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<ExaminationItemEntity>(
						"Item Code",
						entity.getItemCode(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"ItemCode"
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
	 * Get the sort as given by the sort by for the ExaminationItemEntity.
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

	public Set<String> validateEntityRelations(ExaminationItemEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getExaminationGroupId() != null && this.examinationGroupRepository.findById(entity.getExaminationGroupId()).isEmpty()) {
			errors.add("The UUID " + entity.getExaminationGroupId() + " is not associated with a Examination Group Entity");
		}

		if (entity.getServiceItemId() != null && this.serviceItemRepository.findById(entity.getServiceItemId()).isEmpty()) {
			errors.add("The UUID " + entity.getServiceItemId() + " is not associated with a Service Item Entity");
		}

		for (UUID id : entity.getDiagnosticExaminationResultsIds()) {
			if (this.diagnosticExaminationResultsRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Diagnostic Examination Results Entity");
			}
		}

		for (UUID id : entity.getExaminationItemDetailsIds()) {
			if (this.examinationItemDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Examination Item Detail Entity");
			}
		}

		for (UUID id : entity.getExaminationItemOfMCUItemIds()) {
			if (this.mcuPackageItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a MCU Package Item Entity");
			}
		}

		for (UUID id : entity.getRegistrationsIds()) {
			if (this.registrationRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Registration Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}