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
import kmsweb.repositories.UnitOfMeasurementRepository;
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
import kmsweb.entities.CatalogueUOMEntity;
import kmsweb.repositories.CatalogueUOMRepository;
import kmsweb.entities.CompoundPrescriptionDetailEntity;
import kmsweb.repositories.CompoundPrescriptionDetailRepository;
import kmsweb.entities.CompoundPrescriptionItemEntity;
import kmsweb.repositories.CompoundPrescriptionItemRepository;
import kmsweb.entities.MedicationCompoundEntity;
import kmsweb.repositories.MedicationCompoundRepository;
import kmsweb.entities.MedicationItemEntity;
import kmsweb.repositories.MedicationItemRepository;
import kmsweb.entities.PrescriptionCompoundEntity;
import kmsweb.repositories.PrescriptionCompoundRepository;
import kmsweb.entities.PrescriptionItemEntity;
import kmsweb.repositories.PrescriptionItemRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class UnitOfMeasurementService extends AbstractService<UnitOfMeasurementEntity, UnitOfMeasurementRepository, UnitOfMeasurementEntityAudit> {

	private final String[] referenceNamesInUnitOfMeasurementEntity = {
		"compoundPrescriptionDetails",
		"compoundPrescriptionItems",
		"compoundsUnit",
		"medicationCompounds",
		"medicationItems",
		"prescriptionItems",
		"catalogueUOM",
	};

	private final CatalogueUOMRepository catalogueUOMRepository;

	private final CompoundPrescriptionDetailRepository compoundPrescriptionDetailRepository;

	private final CompoundPrescriptionItemRepository compoundPrescriptionItemRepository;

	private final MedicationCompoundRepository medicationCompoundRepository;

	private final MedicationItemRepository medicationItemRepository;

	private final PrescriptionCompoundRepository prescriptionCompoundRepository;

	private final PrescriptionItemRepository prescriptionItemRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public UnitOfMeasurementService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		CatalogueUOMRepository catalogueUOMRepository,
		CompoundPrescriptionDetailRepository compoundPrescriptionDetailRepository,
		CompoundPrescriptionItemRepository compoundPrescriptionItemRepository,
		MedicationCompoundRepository medicationCompoundRepository,
		MedicationItemRepository medicationItemRepository,
		PrescriptionCompoundRepository prescriptionCompoundRepository,
		PrescriptionItemRepository prescriptionItemRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		UnitOfMeasurementRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.catalogueUOMRepository = catalogueUOMRepository;

		this.compoundPrescriptionDetailRepository = compoundPrescriptionDetailRepository;

		this.compoundPrescriptionItemRepository = compoundPrescriptionItemRepository;

		this.medicationCompoundRepository = medicationCompoundRepository;

		this.medicationItemRepository = medicationItemRepository;

		this.prescriptionCompoundRepository = prescriptionCompoundRepository;

		this.prescriptionItemRepository = prescriptionItemRepository;

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
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
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
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Unit Name.
	 *
	 * @param unitName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit Name
	 */
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<UnitOfMeasurementEntity> findByUnitName(String unitName)
	// % protected region % [Add any throwables, implementations, or extensions for findByUnitName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUnitName here] end
	{
		// % protected region % [Add any additional logic for findByUnitName before the main body here] off begin
		// % protected region % [Add any additional logic for findByUnitName before the main body here] end

		List<UnitOfMeasurementEntity> entities = Lists.newArrayList(repository.findByUnitName(unitName));

		// % protected region % [Add any additional logic for findByUnitName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUnitName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Symbol.
	 *
	 * @param symbol the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Symbol
	 */
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<UnitOfMeasurementEntity> findBySymbol(String symbol)
	// % protected region % [Add any throwables, implementations, or extensions for findBySymbol here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySymbol here] end
	{
		// % protected region % [Add any additional logic for findBySymbol before the main body here] off begin
		// % protected region % [Add any additional logic for findBySymbol before the main body here] end

		List<UnitOfMeasurementEntity> entities = Lists.newArrayList(repository.findBySymbol(symbol));

		// % protected region % [Add any additional logic for findBySymbol before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySymbol before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Description.
	 *
	 * @param description the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Description
	 */
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<UnitOfMeasurementEntity> findByDescription(String description)
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDescription here] end
	{
		// % protected region % [Add any additional logic for findByDescription before the main body here] off begin
		// % protected region % [Add any additional logic for findByDescription before the main body here] end

		List<UnitOfMeasurementEntity> entities = Lists.newArrayList(repository.findByDescription(description));

		// % protected region % [Add any additional logic for findByDescription before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDescription before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Unit Category.
	 *
	 * @param unitCategory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unit Category
	 */
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<UnitOfMeasurementEntity> findByUnitCategory(String unitCategory)
	// % protected region % [Add any throwables, implementations, or extensions for findByUnitCategory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUnitCategory here] end
	{
		// % protected region % [Add any additional logic for findByUnitCategory before the main body here] off begin
		// % protected region % [Add any additional logic for findByUnitCategory before the main body here] end

		List<UnitOfMeasurementEntity> entities = Lists.newArrayList(repository.findByUnitCategory(unitCategory));

		// % protected region % [Add any additional logic for findByUnitCategory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUnitCategory before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Consumption Unit.
	 *
	 * @param consumptionUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consumption Unit
	 */
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<UnitOfMeasurementEntity> findByConsumptionUnit(Boolean consumptionUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByConsumptionUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConsumptionUnit here] end
	{
		// % protected region % [Add any additional logic for findByConsumptionUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByConsumptionUnit before the main body here] end

		List<UnitOfMeasurementEntity> entities = Lists.newArrayList(repository.findByConsumptionUnit(consumptionUnit));

		// % protected region % [Add any additional logic for findByConsumptionUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByConsumptionUnit before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<UnitOfMeasurementEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<UnitOfMeasurementEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<UnitOfMeasurementEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<UnitOfMeasurementEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<UnitOfMeasurementEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<UnitOfMeasurementEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	@Transactional(readOnly = true)
	public List<UnitOfMeasurementEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<UnitOfMeasurementEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'create')")
	public UnitOfMeasurementEntity create(UnitOfMeasurementEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		UnitOfMeasurementEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'create')")
	public UnitOfMeasurementEntity create(UnitOfMeasurementEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		UnitOfMeasurementEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		UnitOfMeasurementEntity newEntity;

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
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'create')")
	public List<UnitOfMeasurementEntity> createAll(Iterable<UnitOfMeasurementEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<UnitOfMeasurementEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<UnitOfMeasurementEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'update')")
	public UnitOfMeasurementEntity update(UnitOfMeasurementEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		UnitOfMeasurementEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'update')")
	public UnitOfMeasurementEntity update(UnitOfMeasurementEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		UnitOfMeasurementEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		UnitOfMeasurementEntity newEntity;

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
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'update')")
	public List<UnitOfMeasurementEntity> updateAll(Iterable<UnitOfMeasurementEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<UnitOfMeasurementEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<UnitOfMeasurementEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'create') or hasPermission('UnitOfMeasurementEntity', 'update')")
	public UnitOfMeasurementEntity save(UnitOfMeasurementEntity entity) throws ConstraintViolationException
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

		UnitOfMeasurementEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'create') or hasPermission('UnitOfMeasurementEntity', 'update')")
	public List<UnitOfMeasurementEntity> saveAll(Iterable<UnitOfMeasurementEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<UnitOfMeasurementEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'delete')")
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
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'delete')")
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
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	public List<UnitOfMeasurementEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	public List<UnitOfMeasurementEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<UnitOfMeasurementEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(UnitOfMeasurementEntity.class);

		// % protected region % [Add any additional processing before converting to a list of UnitOfMeasurementEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of UnitOfMeasurementEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('UnitOfMeasurementEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<UnitOfMeasurementEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of UnitOfMeasurementEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of UnitOfMeasurementEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(UnitOfMeasurementEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of UnitOfMeasurementEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of UnitOfMeasurementEntityAudits
	 */
	private List<UnitOfMeasurementEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<UnitOfMeasurementEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param unitOfMeasurement unitOfMeasurement to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private UnitOfMeasurementEntity updateAuditData(UnitOfMeasurementEntity unitOfMeasurement)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return unitOfMeasurement;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private UnitOfMeasurementEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		UnitOfMeasurementEntity entityAtRevision = updateAuditData((UnitOfMeasurementEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new UnitOfMeasurementEntityAudit(
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

		QUnitOfMeasurementEntity entity = QUnitOfMeasurementEntity.unitOfMeasurementEntity;

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
			case "catalogueUOMId":
				// % protected region % [Add any additional logic before the query parameters of relation from Catalogue UOM to Unit Of Measurement here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Catalogue UOM to Unit Of Measurement here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.catalogueUOM.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Catalogue UOM to Unit Of Measurement here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Catalogue UOM to Unit Of Measurement here] end

				break;
			case "compoundPrescriptionDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Consumption Unit to Compound Prescription Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Consumption Unit to Compound Prescription Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.compoundPrescriptionDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Consumption Unit to Compound Prescription Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Consumption Unit to Compound Prescription Details here] end

				break;
			case "compoundPrescriptionItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Unit to Compound Prescription Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Unit to Compound Prescription Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.compoundPrescriptionItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Unit to Compound Prescription Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Unit to Compound Prescription Items here] end

				break;
			case "compoundsUnitId":
				// % protected region % [Add any additional logic before the query parameters of relation from Unit to Compounds Unit here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Unit to Compounds Unit here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.compoundsUnit.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Unit to Compounds Unit here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Unit to Compounds Unit here] end

				break;
			case "medicationCompoundsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Unit Of Measurement to Medication Compounds here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Unit Of Measurement to Medication Compounds here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationCompounds.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Unit Of Measurement to Medication Compounds here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Unit Of Measurement to Medication Compounds here] end

				break;
			case "medicationItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Unit Of Measurement to Medication Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Unit Of Measurement to Medication Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicationItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Unit Of Measurement to Medication Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Unit Of Measurement to Medication Items here] end

				break;
			case "prescriptionItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Unit to Prescription Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Unit to Prescription Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.prescriptionItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Unit to Prescription Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Unit to Prescription Items here] end

				break;
			case "unitName":
				// % protected region % [Add any additional logic before the query parameters of unitName here] off begin
				// % protected region % [Add any additional logic before the query parameters of unitName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.unitName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of unitName here] off begin
				// % protected region % [Add any additional logic after the query parameters of unitName here] end

				break;
			case "symbol":
				// % protected region % [Add any additional logic before the query parameters of symbol here] off begin
				// % protected region % [Add any additional logic before the query parameters of symbol here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.symbol, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of symbol here] off begin
				// % protected region % [Add any additional logic after the query parameters of symbol here] end

				break;
			case "description":
				// % protected region % [Add any additional logic before the query parameters of description here] off begin
				// % protected region % [Add any additional logic before the query parameters of description here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.description, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of description here] off begin
				// % protected region % [Add any additional logic after the query parameters of description here] end

				break;
			case "unitCategory":
				// % protected region % [Add any additional logic before the query parameters of unitCategory here] off begin
				// % protected region % [Add any additional logic before the query parameters of unitCategory here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.unitCategory, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of unitCategory here] off begin
				// % protected region % [Add any additional logic after the query parameters of unitCategory here] end

				break;
			case "consumptionUnit":
				// % protected region % [Add any additional logic before the query parameters of consumptionUnit here] off begin
				// % protected region % [Add any additional logic before the query parameters of consumptionUnit here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.consumptionUnit, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of consumptionUnit here] off begin
				// % protected region % [Add any additional logic after the query parameters of consumptionUnit here] end

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
	public UnitOfMeasurementEntity updateOldData(UnitOfMeasurementEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public UnitOfMeasurementEntity updateOldData(UnitOfMeasurementEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		UnitOfMeasurementEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInUnitOfMeasurementEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getConsumptionUnit() == null) {
			entityToUpdate.setConsumptionUnit(false);
		}

		// Incoming One to One reference
		if (entity.getCatalogueUOM() == null && entity.getCatalogueUOMId() == null) {
			entityToUpdate.unsetCatalogueUOM();
		} else if (entity.getCatalogueUOMId() != null && entity.getCatalogueUOM() == null) {
			Optional<CatalogueUOMEntity> catalogueUOMEntity = this.catalogueUOMRepository.findById(entity.getCatalogueUOMId());
			entityToUpdate.setCatalogueUOM(catalogueUOMEntity.orElseThrow());
		}
		if (persistRelations && entity.getCatalogueUOM() != null) {
			entityToUpdate.setCatalogueUOM(entity.getCatalogueUOM(), false);
			if (entityToUpdate.getCatalogueUOMId() != null) {
				this.catalogueUOMRepository.save(entityToUpdate.getCatalogueUOM());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getCatalogueUOM().unsetUnitOfMeasurement();
			}
		}

		// Outgoing one to many reference
		if (entity.getCompoundPrescriptionDetailsIds().isEmpty() && entity.getCompoundPrescriptionDetails().isEmpty()) {
			entityToUpdate.setCompoundPrescriptionDetails(new HashSet<>());
		} else if (!entity.getCompoundPrescriptionDetailsIds().isEmpty() && entity.getCompoundPrescriptionDetails().isEmpty()) {
			Iterable<CompoundPrescriptionDetailEntity> compoundPrescriptionDetailsEntities =
					this.compoundPrescriptionDetailRepository.findAllById(entity.getCompoundPrescriptionDetailsIds());
			entityToUpdate.setCompoundPrescriptionDetails(Sets.newHashSet(compoundPrescriptionDetailsEntities));
		}
		if (persistRelations && !entity.getCompoundPrescriptionDetails().isEmpty()) {
			Set<CompoundPrescriptionDetailEntity> updatedEntities = new HashSet<>();
			entity.getCompoundPrescriptionDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.compoundPrescriptionDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCompoundPrescriptionDetails(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getCompoundPrescriptionItemsIds().isEmpty() && entity.getCompoundPrescriptionItems().isEmpty()) {
			entityToUpdate.setCompoundPrescriptionItems(new HashSet<>());
		} else if (!entity.getCompoundPrescriptionItemsIds().isEmpty() && entity.getCompoundPrescriptionItems().isEmpty()) {
			Iterable<CompoundPrescriptionItemEntity> compoundPrescriptionItemsEntities =
					this.compoundPrescriptionItemRepository.findAllById(entity.getCompoundPrescriptionItemsIds());
			entityToUpdate.setCompoundPrescriptionItems(Sets.newHashSet(compoundPrescriptionItemsEntities));
		}
		if (persistRelations && !entity.getCompoundPrescriptionItems().isEmpty()) {
			Set<CompoundPrescriptionItemEntity> updatedEntities = new HashSet<>();
			entity.getCompoundPrescriptionItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.compoundPrescriptionItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCompoundPrescriptionItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getCompoundsUnitIds().isEmpty() && entity.getCompoundsUnit().isEmpty()) {
			entityToUpdate.setCompoundsUnit(new HashSet<>());
		} else if (!entity.getCompoundsUnitIds().isEmpty() && entity.getCompoundsUnit().isEmpty()) {
			Iterable<PrescriptionCompoundEntity> compoundsUnitEntities =
					this.prescriptionCompoundRepository.findAllById(entity.getCompoundsUnitIds());
			entityToUpdate.setCompoundsUnit(Sets.newHashSet(compoundsUnitEntities));
		}
		if (persistRelations && !entity.getCompoundsUnit().isEmpty()) {
			Set<PrescriptionCompoundEntity> updatedEntities = new HashSet<>();
			entity.getCompoundsUnit().forEach(model -> {
				if (model.getId() != null) {
					model = this.prescriptionCompoundRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setCompoundsUnit(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicationCompoundsIds().isEmpty() && entity.getMedicationCompounds().isEmpty()) {
			entityToUpdate.setMedicationCompounds(new HashSet<>());
		} else if (!entity.getMedicationCompoundsIds().isEmpty() && entity.getMedicationCompounds().isEmpty()) {
			Iterable<MedicationCompoundEntity> medicationCompoundsEntities =
					this.medicationCompoundRepository.findAllById(entity.getMedicationCompoundsIds());
			entityToUpdate.setMedicationCompounds(Sets.newHashSet(medicationCompoundsEntities));
		}
		if (persistRelations && !entity.getMedicationCompounds().isEmpty()) {
			Set<MedicationCompoundEntity> updatedEntities = new HashSet<>();
			entity.getMedicationCompounds().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicationCompoundRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicationCompounds(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getMedicationItemsIds().isEmpty() && entity.getMedicationItems().isEmpty()) {
			entityToUpdate.setMedicationItems(new HashSet<>());
		} else if (!entity.getMedicationItemsIds().isEmpty() && entity.getMedicationItems().isEmpty()) {
			Iterable<MedicationItemEntity> medicationItemsEntities =
					this.medicationItemRepository.findAllById(entity.getMedicationItemsIds());
			entityToUpdate.setMedicationItems(Sets.newHashSet(medicationItemsEntities));
		}
		if (persistRelations && !entity.getMedicationItems().isEmpty()) {
			Set<MedicationItemEntity> updatedEntities = new HashSet<>();
			entity.getMedicationItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.medicationItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setMedicationItems(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getPrescriptionItemsIds().isEmpty() && entity.getPrescriptionItems().isEmpty()) {
			entityToUpdate.setPrescriptionItems(new HashSet<>());
		} else if (!entity.getPrescriptionItemsIds().isEmpty() && entity.getPrescriptionItems().isEmpty()) {
			Iterable<PrescriptionItemEntity> prescriptionItemsEntities =
					this.prescriptionItemRepository.findAllById(entity.getPrescriptionItemsIds());
			entityToUpdate.setPrescriptionItems(Sets.newHashSet(prescriptionItemsEntities));
		}
		if (persistRelations && !entity.getPrescriptionItems().isEmpty()) {
			Set<PrescriptionItemEntity> updatedEntities = new HashSet<>();
			entity.getPrescriptionItems().forEach(model -> {
				if (model.getId() != null) {
					model = this.prescriptionItemRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setPrescriptionItems(updatedEntities);
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
	public void validateEntity(UnitOfMeasurementEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<UnitOfMeasurementEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the UnitOfMeasurementEntity.
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

	public Set<String> validateEntityRelations(UnitOfMeasurementEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getCatalogueUOMId() != null && this.catalogueUOMRepository.findById(entity.getCatalogueUOMId()).isEmpty()) {
			errors.add("The UUID " + entity.getCatalogueUOMId() + " is not associated with a Catalogue UOM Entity");
		}

		for (UUID id : entity.getCompoundPrescriptionDetailsIds()) {
			if (this.compoundPrescriptionDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Compound Prescription Detail Entity");
			}
		}

		for (UUID id : entity.getCompoundPrescriptionItemsIds()) {
			if (this.compoundPrescriptionItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Compound Prescription Item Entity");
			}
		}

		for (UUID id : entity.getCompoundsUnitIds()) {
			if (this.prescriptionCompoundRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Prescription Compound Entity");
			}
		}

		for (UUID id : entity.getMedicationCompoundsIds()) {
			if (this.medicationCompoundRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medication Compound Entity");
			}
		}

		for (UUID id : entity.getMedicationItemsIds()) {
			if (this.medicationItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Medication Item Entity");
			}
		}

		for (UUID id : entity.getPrescriptionItemsIds()) {
			if (this.prescriptionItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Prescription Item Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
