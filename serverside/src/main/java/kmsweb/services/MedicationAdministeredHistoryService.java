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
import kmsweb.repositories.MedicationAdministeredHistoryRepository;
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
import kmsweb.entities.MedicationCompoundEntity;
import kmsweb.repositories.MedicationCompoundRepository;
import kmsweb.entities.MedicationItemEntity;
import kmsweb.repositories.MedicationItemRepository;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class MedicationAdministeredHistoryService extends AbstractService<MedicationAdministeredHistoryEntity, MedicationAdministeredHistoryRepository, MedicationAdministeredHistoryEntityAudit> {

	private final String[] referenceNamesInMedicationAdministeredHistoryEntity = {
		"medicationItem",
		"staff",
		"medicationCompound",
	};

	private final MedicationCompoundRepository medicationCompoundRepository;

	private final MedicationItemRepository medicationItemRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public MedicationAdministeredHistoryService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		MedicationCompoundRepository medicationCompoundRepository,
		MedicationItemRepository medicationItemRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		MedicationAdministeredHistoryRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.medicationCompoundRepository = medicationCompoundRepository;

		this.medicationItemRepository = medicationItemRepository;

		this.staffRepository = staffRepository;

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
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
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
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute DateTime.
	 *
	 * @param datetime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DateTime
	 */
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationAdministeredHistoryEntity> findByDatetime(OffsetDateTime datetime)
	// % protected region % [Add any throwables, implementations, or extensions for findByDatetime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDatetime here] end
	{
		// % protected region % [Add any additional logic for findByDatetime before the main body here] off begin
		// % protected region % [Add any additional logic for findByDatetime before the main body here] end

		List<MedicationAdministeredHistoryEntity> entities = Lists.newArrayList(repository.findByDatetime(datetime));

		// % protected region % [Add any additional logic for findByDatetime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDatetime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Administration Notes.
	 *
	 * @param administrationNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Administration Notes
	 */
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationAdministeredHistoryEntity> findByAdministrationNotes(String administrationNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdministrationNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdministrationNotes here] end
	{
		// % protected region % [Add any additional logic for findByAdministrationNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdministrationNotes before the main body here] end

		List<MedicationAdministeredHistoryEntity> entities = Lists.newArrayList(repository.findByAdministrationNotes(administrationNotes));

		// % protected region % [Add any additional logic for findByAdministrationNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdministrationNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Administered Quantity.
	 *
	 * @param administeredQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Administered Quantity
	 */
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationAdministeredHistoryEntity> findByAdministeredQuantity(Integer administeredQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdministeredQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdministeredQuantity here] end
	{
		// % protected region % [Add any additional logic for findByAdministeredQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdministeredQuantity before the main body here] end

		List<MedicationAdministeredHistoryEntity> entities = Lists.newArrayList(repository.findByAdministeredQuantity(administeredQuantity));

		// % protected region % [Add any additional logic for findByAdministeredQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdministeredQuantity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Taken Home Quantity.
	 *
	 * @param takenHomeQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Taken Home Quantity
	 */
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationAdministeredHistoryEntity> findByTakenHomeQuantity(Integer takenHomeQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByTakenHomeQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTakenHomeQuantity here] end
	{
		// % protected region % [Add any additional logic for findByTakenHomeQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByTakenHomeQuantity before the main body here] end

		List<MedicationAdministeredHistoryEntity> entities = Lists.newArrayList(repository.findByTakenHomeQuantity(takenHomeQuantity));

		// % protected region % [Add any additional logic for findByTakenHomeQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTakenHomeQuantity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Returned Quantity.
	 *
	 * @param returnedQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Returned Quantity
	 */
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationAdministeredHistoryEntity> findByReturnedQuantity(Integer returnedQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByReturnedQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByReturnedQuantity here] end
	{
		// % protected region % [Add any additional logic for findByReturnedQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByReturnedQuantity before the main body here] end

		List<MedicationAdministeredHistoryEntity> entities = Lists.newArrayList(repository.findByReturnedQuantity(returnedQuantity));

		// % protected region % [Add any additional logic for findByReturnedQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByReturnedQuantity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Administered Quantity.
	 *
	 * @param totalAdministeredQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Administered Quantity
	 */
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationAdministeredHistoryEntity> findByTotalAdministeredQuantity(Integer totalAdministeredQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalAdministeredQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalAdministeredQuantity here] end
	{
		// % protected region % [Add any additional logic for findByTotalAdministeredQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalAdministeredQuantity before the main body here] end

		List<MedicationAdministeredHistoryEntity> entities = Lists.newArrayList(repository.findByTotalAdministeredQuantity(totalAdministeredQuantity));

		// % protected region % [Add any additional logic for findByTotalAdministeredQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalAdministeredQuantity before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<MedicationAdministeredHistoryEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<MedicationAdministeredHistoryEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationAdministeredHistoryEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<MedicationAdministeredHistoryEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationAdministeredHistoryEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<MedicationAdministeredHistoryEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicationAdministeredHistoryEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<MedicationAdministeredHistoryEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'create')")
	public MedicationAdministeredHistoryEntity create(MedicationAdministeredHistoryEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		MedicationAdministeredHistoryEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'create')")
	public MedicationAdministeredHistoryEntity create(MedicationAdministeredHistoryEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		MedicationAdministeredHistoryEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		MedicationAdministeredHistoryEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'create')")
	public List<MedicationAdministeredHistoryEntity> createAll(Iterable<MedicationAdministeredHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<MedicationAdministeredHistoryEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<MedicationAdministeredHistoryEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'update')")
	public MedicationAdministeredHistoryEntity update(MedicationAdministeredHistoryEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		MedicationAdministeredHistoryEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'update')")
	public MedicationAdministeredHistoryEntity update(MedicationAdministeredHistoryEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		MedicationAdministeredHistoryEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		MedicationAdministeredHistoryEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'update')")
	public List<MedicationAdministeredHistoryEntity> updateAll(Iterable<MedicationAdministeredHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<MedicationAdministeredHistoryEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<MedicationAdministeredHistoryEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'create') or hasPermission('MedicationAdministeredHistoryEntity', 'update')")
	public MedicationAdministeredHistoryEntity save(MedicationAdministeredHistoryEntity entity) throws ConstraintViolationException
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

		MedicationAdministeredHistoryEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'create') or hasPermission('MedicationAdministeredHistoryEntity', 'update')")
	public List<MedicationAdministeredHistoryEntity> saveAll(Iterable<MedicationAdministeredHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<MedicationAdministeredHistoryEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	public List<MedicationAdministeredHistoryEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	public List<MedicationAdministeredHistoryEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicationAdministeredHistoryEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(MedicationAdministeredHistoryEntity.class);

		// % protected region % [Add any additional processing before converting to a list of MedicationAdministeredHistoryEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicationAdministeredHistoryEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('MedicationAdministeredHistoryEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicationAdministeredHistoryEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of MedicationAdministeredHistoryEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicationAdministeredHistoryEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(MedicationAdministeredHistoryEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of MedicationAdministeredHistoryEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of MedicationAdministeredHistoryEntityAudits
	 */
	private List<MedicationAdministeredHistoryEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<MedicationAdministeredHistoryEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param medicationAdministeredHistory medicationAdministeredHistory to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private MedicationAdministeredHistoryEntity updateAuditData(MedicationAdministeredHistoryEntity medicationAdministeredHistory)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return medicationAdministeredHistory;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private MedicationAdministeredHistoryEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		MedicationAdministeredHistoryEntity entityAtRevision = updateAuditData((MedicationAdministeredHistoryEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new MedicationAdministeredHistoryEntityAudit(
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

		QMedicationAdministeredHistoryEntity entity = QMedicationAdministeredHistoryEntity.medicationAdministeredHistoryEntity;

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
			case "medicationItemId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Item to Medication Administered Hisotries here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Item to Medication Administered Hisotries here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationItem.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medication Item to Medication Administered Hisotries here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medication Item to Medication Administered Hisotries here] end

				break;
			case "staffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Medication Administered Hisotries here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Staff to Medication Administered Hisotries here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.staff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Medication Administered Hisotries here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Staff to Medication Administered Hisotries here] end

				break;
			case "medicationCompoundId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Compound to Medication Administered Histories here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medication Compound to Medication Administered Histories here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationCompound.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medication Compound to Medication Administered Histories here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medication Compound to Medication Administered Histories here] end

				break;
			case "administrationNotes":
				// % protected region % [Add any additional logic before the query parameters of administrationNotes here] off begin
				// % protected region % [Add any additional logic before the query parameters of administrationNotes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.administrationNotes, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of administrationNotes here] off begin
				// % protected region % [Add any additional logic after the query parameters of administrationNotes here] end

				break;
			case "administeredQuantity":
				// % protected region % [Add any additional logic before the query parameters of administeredQuantity here] off begin
				// % protected region % [Add any additional logic before the query parameters of administeredQuantity here] end


				// % protected region % [Add any additional logic after the query parameters of administeredQuantity here] off begin
				// % protected region % [Add any additional logic after the query parameters of administeredQuantity here] end

				break;
			case "takenHomeQuantity":
				// % protected region % [Add any additional logic before the query parameters of takenHomeQuantity here] off begin
				// % protected region % [Add any additional logic before the query parameters of takenHomeQuantity here] end


				// % protected region % [Add any additional logic after the query parameters of takenHomeQuantity here] off begin
				// % protected region % [Add any additional logic after the query parameters of takenHomeQuantity here] end

				break;
			case "returnedQuantity":
				// % protected region % [Add any additional logic before the query parameters of returnedQuantity here] off begin
				// % protected region % [Add any additional logic before the query parameters of returnedQuantity here] end


				// % protected region % [Add any additional logic after the query parameters of returnedQuantity here] off begin
				// % protected region % [Add any additional logic after the query parameters of returnedQuantity here] end

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
	public MedicationAdministeredHistoryEntity updateOldData(MedicationAdministeredHistoryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public MedicationAdministeredHistoryEntity updateOldData(MedicationAdministeredHistoryEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		MedicationAdministeredHistoryEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInMedicationAdministeredHistoryEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getMedicationItem() == null && entity.getMedicationItemId() == null) {
			entityToUpdate.unsetMedicationItem();
		} else if (entity.getMedicationItemId() != null && entity.getMedicationItem() == null) {
			Optional<MedicationItemEntity> medicationItemEntity = this.medicationItemRepository.findById(entity.getMedicationItemId());
			entityToUpdate.setMedicationItem(medicationItemEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicationItem() != null) {
			entityToUpdate.setMedicationItem(entity.getMedicationItem(), false);
			if (entityToUpdate.getMedicationItemId() != null) {
				this.medicationItemRepository.save(entityToUpdate.getMedicationItem());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicationItem().unsetMedicationAdministeredHisotries();
			}
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
				entityToUpdate.getStaff().unsetMedicationAdministeredHisotries();
			}
		}

		// Incoming One to Many reference
		if (entity.getMedicationCompound() == null && entity.getMedicationCompoundId() == null) {
			entityToUpdate.unsetMedicationCompound();
		} else if (entity.getMedicationCompoundId() != null && entity.getMedicationCompound() == null) {
			Optional<MedicationCompoundEntity> medicationCompoundEntity = this.medicationCompoundRepository.findById(entity.getMedicationCompoundId());
			entityToUpdate.setMedicationCompound(medicationCompoundEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicationCompound() != null) {
			entityToUpdate.setMedicationCompound(entity.getMedicationCompound(), false);
			if (entityToUpdate.getMedicationCompoundId() != null) {
				this.medicationCompoundRepository.save(entityToUpdate.getMedicationCompound());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicationCompound().unsetMedicationAdministeredHistories();
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
	public void validateEntity(MedicationAdministeredHistoryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<MedicationAdministeredHistoryEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the MedicationAdministeredHistoryEntity.
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

	public Set<String> validateEntityRelations(MedicationAdministeredHistoryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getMedicationItemId() != null && this.medicationItemRepository.findById(entity.getMedicationItemId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicationItemId() + " is not associated with a Medication Item Entity");
		}

		if (entity.getStaffId() != null && this.staffRepository.findById(entity.getStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getStaffId() + " is not associated with a Staff Entity");
		}

		if (entity.getMedicationCompoundId() != null && this.medicationCompoundRepository.findById(entity.getMedicationCompoundId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicationCompoundId() + " is not associated with a Medication Compound Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}