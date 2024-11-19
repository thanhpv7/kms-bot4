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
import kmsweb.repositories.FacilityHistoryRepository;
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

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class FacilityHistoryService extends AbstractService<FacilityHistoryEntity, FacilityHistoryRepository, FacilityHistoryEntityAudit> {

	private final String[] referenceNamesInFacilityHistoryEntity = {
	};

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public FacilityHistoryService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		Validator validator,
		AuditingRepository auditingRepository,
		FacilityHistoryRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

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
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
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
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Change Date.
	 *
	 * @param changeDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Change Date
	 */
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findByChangeDate(OffsetDateTime changeDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByChangeDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByChangeDate here] end
	{
		// % protected region % [Add any additional logic for findByChangeDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByChangeDate before the main body here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findByChangeDate(changeDate));

		// % protected region % [Add any additional logic for findByChangeDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByChangeDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Facility No.
	 *
	 * @param facilityNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility No
	 */
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findByFacilityNo(String facilityNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityNo here] end
	{
		// % protected region % [Add any additional logic for findByFacilityNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByFacilityNo before the main body here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findByFacilityNo(facilityNo));

		// % protected region % [Add any additional logic for findByFacilityNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFacilityNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Current Qty.
	 *
	 * @param currentQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Current Qty
	 */
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findByCurrentQty(Integer currentQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByCurrentQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCurrentQty here] end
	{
		// % protected region % [Add any additional logic for findByCurrentQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByCurrentQty before the main body here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findByCurrentQty(currentQty));

		// % protected region % [Add any additional logic for findByCurrentQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCurrentQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Changed Qty.
	 *
	 * @param changedQty the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Changed Qty
	 */
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findByChangedQty(Integer changedQty)
	// % protected region % [Add any throwables, implementations, or extensions for findByChangedQty here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByChangedQty here] end
	{
		// % protected region % [Add any additional logic for findByChangedQty before the main body here] off begin
		// % protected region % [Add any additional logic for findByChangedQty before the main body here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findByChangedQty(changedQty));

		// % protected region % [Add any additional logic for findByChangedQty before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByChangedQty before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Facility Status.
	 *
	 * @param facilityStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility Status
	 */
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findByFacilityStatus(String facilityStatus)
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityStatus here] end
	{
		// % protected region % [Add any additional logic for findByFacilityStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByFacilityStatus before the main body here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findByFacilityStatus(facilityStatus));

		// % protected region % [Add any additional logic for findByFacilityStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFacilityStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Facility Class.
	 *
	 * @param facilityClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility Class
	 */
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findByFacilityClass(String facilityClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityClass here] end
	{
		// % protected region % [Add any additional logic for findByFacilityClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByFacilityClass before the main body here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findByFacilityClass(facilityClass));

		// % protected region % [Add any additional logic for findByFacilityClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFacilityClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Facility Type.
	 *
	 * @param facilityType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility Type
	 */
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findByFacilityType(String facilityType)
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityType here] end
	{
		// % protected region % [Add any additional logic for findByFacilityType before the main body here] off begin
		// % protected region % [Add any additional logic for findByFacilityType before the main body here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findByFacilityType(facilityType));

		// % protected region % [Add any additional logic for findByFacilityType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFacilityType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Facility Service.
	 *
	 * @param facilityService the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Facility Service
	 */
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findByFacilityService(String facilityService)
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityService here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFacilityService here] end
	{
		// % protected region % [Add any additional logic for findByFacilityService before the main body here] off begin
		// % protected region % [Add any additional logic for findByFacilityService before the main body here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findByFacilityService(facilityService));

		// % protected region % [Add any additional logic for findByFacilityService before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFacilityService before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Bed Facility Id.
	 *
	 * @param bedFacilityId the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bed Facility Id
	 */
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findByBedFacilityId(String bedFacilityId)
	// % protected region % [Add any throwables, implementations, or extensions for findByBedFacilityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBedFacilityId here] end
	{
		// % protected region % [Add any additional logic for findByBedFacilityId before the main body here] off begin
		// % protected region % [Add any additional logic for findByBedFacilityId before the main body here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findByBedFacilityId(bedFacilityId));

		// % protected region % [Add any additional logic for findByBedFacilityId before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBedFacilityId before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Registration Id.
	 *
	 * @param registrationId the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Registration Id
	 */
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findByRegistrationId(String registrationId)
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRegistrationId here] end
	{
		// % protected region % [Add any additional logic for findByRegistrationId before the main body here] off begin
		// % protected region % [Add any additional logic for findByRegistrationId before the main body here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findByRegistrationId(registrationId));

		// % protected region % [Add any additional logic for findByRegistrationId before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRegistrationId before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<FacilityHistoryEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<FacilityHistoryEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<FacilityHistoryEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<FacilityHistoryEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'create')")
	public FacilityHistoryEntity create(FacilityHistoryEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		FacilityHistoryEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'create')")
	public FacilityHistoryEntity create(FacilityHistoryEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		FacilityHistoryEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		FacilityHistoryEntity newEntity;

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
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'create')")
	public List<FacilityHistoryEntity> createAll(Iterable<FacilityHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<FacilityHistoryEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<FacilityHistoryEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'update')")
	public FacilityHistoryEntity update(FacilityHistoryEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		FacilityHistoryEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'update')")
	public FacilityHistoryEntity update(FacilityHistoryEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		FacilityHistoryEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		FacilityHistoryEntity newEntity;

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
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'update')")
	public List<FacilityHistoryEntity> updateAll(Iterable<FacilityHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<FacilityHistoryEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<FacilityHistoryEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'create') or hasPermission('FacilityHistoryEntity', 'update')")
	public FacilityHistoryEntity save(FacilityHistoryEntity entity) throws ConstraintViolationException
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

		FacilityHistoryEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'create') or hasPermission('FacilityHistoryEntity', 'update')")
	public List<FacilityHistoryEntity> saveAll(Iterable<FacilityHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<FacilityHistoryEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'delete')")
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
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'delete')")
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
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	public List<FacilityHistoryEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	public List<FacilityHistoryEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(FacilityHistoryEntity.class);

		// % protected region % [Add any additional processing before converting to a list of FacilityHistoryEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of FacilityHistoryEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('FacilityHistoryEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<FacilityHistoryEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of FacilityHistoryEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of FacilityHistoryEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(FacilityHistoryEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of FacilityHistoryEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of FacilityHistoryEntityAudits
	 */
	private List<FacilityHistoryEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<FacilityHistoryEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param facilityHistory facilityHistory to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private FacilityHistoryEntity updateAuditData(FacilityHistoryEntity facilityHistory)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return facilityHistory;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private FacilityHistoryEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		FacilityHistoryEntity entityAtRevision = updateAuditData((FacilityHistoryEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new FacilityHistoryEntityAudit(
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

		QFacilityHistoryEntity entity = QFacilityHistoryEntity.facilityHistoryEntity;

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
			case "changeDate":
				// % protected region % [Add any additional logic before the query parameters of changeDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of changeDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.changeDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of changeDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of changeDate here] end

				break;
			case "bedFacilityId":
				// % protected region % [Add any additional logic before the query parameters of bedFacilityId here] off begin
				// % protected region % [Add any additional logic before the query parameters of bedFacilityId here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bedFacilityId, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bedFacilityId here] off begin
				// % protected region % [Add any additional logic after the query parameters of bedFacilityId here] end

				break;
			case "registrationId":
				// % protected region % [Add any additional logic before the query parameters of registrationId here] off begin
				// % protected region % [Add any additional logic before the query parameters of registrationId here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registrationId, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of registrationId here] off begin
				// % protected region % [Add any additional logic after the query parameters of registrationId here] end

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
	public FacilityHistoryEntity updateOldData(FacilityHistoryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public FacilityHistoryEntity updateOldData(FacilityHistoryEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		FacilityHistoryEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInFacilityHistoryEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
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
	public void validateEntity(FacilityHistoryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<FacilityHistoryEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the FacilityHistoryEntity.
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

	public Set<String> validateEntityRelations(FacilityHistoryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
