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
import kmsweb.repositories.CompoundPrescriptionDetailRepository;
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
import kmsweb.entities.CompoundPrescriptionItemEntity;
import kmsweb.repositories.CompoundPrescriptionItemRepository;
import kmsweb.entities.UnitOfMeasurementEntity;
import kmsweb.repositories.UnitOfMeasurementRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class CompoundPrescriptionDetailService extends AbstractService<CompoundPrescriptionDetailEntity, CompoundPrescriptionDetailRepository, CompoundPrescriptionDetailEntityAudit> {

	private final String[] referenceNamesInCompoundPrescriptionDetailEntity = {
		"compoundPrescriptionItems",
		"consumptionUnit",
	};

	private final CompoundPrescriptionItemRepository compoundPrescriptionItemRepository;

	private final UnitOfMeasurementRepository unitOfMeasurementRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public CompoundPrescriptionDetailService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		CompoundPrescriptionItemRepository compoundPrescriptionItemRepository,
		UnitOfMeasurementRepository unitOfMeasurementRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		CompoundPrescriptionDetailRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.compoundPrescriptionItemRepository = compoundPrescriptionItemRepository;

		this.unitOfMeasurementRepository = unitOfMeasurementRepository;

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
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
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
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Compound Code.
	 *
	 * @param compoundCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Code
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<CompoundPrescriptionDetailEntity> findByCompoundCode(String compoundCode)
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundCode here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundCode here] end
	{
		// % protected region % [Add any additional logic for findByCompoundCode before the main body here] off begin
		// % protected region % [Add any additional logic for findByCompoundCode before the main body here] end

		Optional<CompoundPrescriptionDetailEntity> entity = repository.findByCompoundCode(compoundCode);

		// % protected region % [Add any additional logic for findByCompoundCode before returning the entity here] off begin
		// % protected region % [Add any additional logic for findByCompoundCode before returning the entity here] end

		return entity;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Compound Name.
	 *
	 * @param compoundName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Compound Name
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findByCompoundName(String compoundName)
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundName here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCompoundName here] end
	{
		// % protected region % [Add any additional logic for findByCompoundName before the main body here] off begin
		// % protected region % [Add any additional logic for findByCompoundName before the main body here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findByCompoundName(compoundName));

		// % protected region % [Add any additional logic for findByCompoundName before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCompoundName before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Request Quantity.
	 *
	 * @param requestQuantity the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Request Quantity
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findByRequestQuantity(Double requestQuantity)
	// % protected region % [Add any throwables, implementations, or extensions for findByRequestQuantity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRequestQuantity here] end
	{
		// % protected region % [Add any additional logic for findByRequestQuantity before the main body here] off begin
		// % protected region % [Add any additional logic for findByRequestQuantity before the main body here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findByRequestQuantity(requestQuantity));

		// % protected region % [Add any additional logic for findByRequestQuantity before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRequestQuantity before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dosage Times.
	 *
	 * @param dosageTimes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dosage Times
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findByDosageTimes(Integer dosageTimes)
	// % protected region % [Add any throwables, implementations, or extensions for findByDosageTimes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDosageTimes here] end
	{
		// % protected region % [Add any additional logic for findByDosageTimes before the main body here] off begin
		// % protected region % [Add any additional logic for findByDosageTimes before the main body here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findByDosageTimes(dosageTimes));

		// % protected region % [Add any additional logic for findByDosageTimes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDosageTimes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dosage Days.
	 *
	 * @param dosageDays the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dosage Days
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findByDosageDays(Double dosageDays)
	// % protected region % [Add any throwables, implementations, or extensions for findByDosageDays here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDosageDays here] end
	{
		// % protected region % [Add any additional logic for findByDosageDays before the main body here] off begin
		// % protected region % [Add any additional logic for findByDosageDays before the main body here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findByDosageDays(dosageDays));

		// % protected region % [Add any additional logic for findByDosageDays before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDosageDays before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Frequency.
	 *
	 * @param frequency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Frequency
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findByFrequency(String frequency)
	// % protected region % [Add any throwables, implementations, or extensions for findByFrequency here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFrequency here] end
	{
		// % protected region % [Add any additional logic for findByFrequency before the main body here] off begin
		// % protected region % [Add any additional logic for findByFrequency before the main body here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findByFrequency(frequency));

		// % protected region % [Add any additional logic for findByFrequency before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFrequency before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Consumption Method.
	 *
	 * @param consumptionMethod the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Consumption Method
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findByConsumptionMethod(String consumptionMethod)
	// % protected region % [Add any throwables, implementations, or extensions for findByConsumptionMethod here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByConsumptionMethod here] end
	{
		// % protected region % [Add any additional logic for findByConsumptionMethod before the main body here] off begin
		// % protected region % [Add any additional logic for findByConsumptionMethod before the main body here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findByConsumptionMethod(consumptionMethod));

		// % protected region % [Add any additional logic for findByConsumptionMethod before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByConsumptionMethod before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Iteration Start.
	 *
	 * @param iterationStart the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Iteration Start
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findByIterationStart(Integer iterationStart)
	// % protected region % [Add any throwables, implementations, or extensions for findByIterationStart here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIterationStart here] end
	{
		// % protected region % [Add any additional logic for findByIterationStart before the main body here] off begin
		// % protected region % [Add any additional logic for findByIterationStart before the main body here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findByIterationStart(iterationStart));

		// % protected region % [Add any additional logic for findByIterationStart before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIterationStart before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Iteration End.
	 *
	 * @param iterationEnd the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Iteration End
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findByIterationEnd(Integer iterationEnd)
	// % protected region % [Add any throwables, implementations, or extensions for findByIterationEnd here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIterationEnd here] end
	{
		// % protected region % [Add any additional logic for findByIterationEnd before the main body here] off begin
		// % protected region % [Add any additional logic for findByIterationEnd before the main body here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findByIterationEnd(iterationEnd));

		// % protected region % [Add any additional logic for findByIterationEnd before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIterationEnd before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Is dtd.
	 *
	 * @param isDtd the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is dtd
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findByIsDtd(Boolean isDtd)
	// % protected region % [Add any throwables, implementations, or extensions for findByIsDtd here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIsDtd here] end
	{
		// % protected region % [Add any additional logic for findByIsDtd before the main body here] off begin
		// % protected region % [Add any additional logic for findByIsDtd before the main body here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findByIsDtd(isDtd));

		// % protected region % [Add any additional logic for findByIsDtd before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIsDtd before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Instruction.
	 *
	 * @param instruction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruction
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findByInstruction(String instruction)
	// % protected region % [Add any throwables, implementations, or extensions for findByInstruction here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInstruction here] end
	{
		// % protected region % [Add any additional logic for findByInstruction before the main body here] off begin
		// % protected region % [Add any additional logic for findByInstruction before the main body here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findByInstruction(instruction));

		// % protected region % [Add any additional logic for findByInstruction before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInstruction before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<CompoundPrescriptionDetailEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<CompoundPrescriptionDetailEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<CompoundPrescriptionDetailEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'create')")
	public CompoundPrescriptionDetailEntity create(CompoundPrescriptionDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		CompoundPrescriptionDetailEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'create')")
	public CompoundPrescriptionDetailEntity create(CompoundPrescriptionDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		CompoundPrescriptionDetailEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		CompoundPrescriptionDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'create')")
	public List<CompoundPrescriptionDetailEntity> createAll(Iterable<CompoundPrescriptionDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<CompoundPrescriptionDetailEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<CompoundPrescriptionDetailEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'update')")
	public CompoundPrescriptionDetailEntity update(CompoundPrescriptionDetailEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		CompoundPrescriptionDetailEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'update')")
	public CompoundPrescriptionDetailEntity update(CompoundPrescriptionDetailEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		CompoundPrescriptionDetailEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		CompoundPrescriptionDetailEntity newEntity;

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
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'update')")
	public List<CompoundPrescriptionDetailEntity> updateAll(Iterable<CompoundPrescriptionDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<CompoundPrescriptionDetailEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<CompoundPrescriptionDetailEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'create') or hasPermission('CompoundPrescriptionDetailEntity', 'update')")
	public CompoundPrescriptionDetailEntity save(CompoundPrescriptionDetailEntity entity) throws ConstraintViolationException
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

		CompoundPrescriptionDetailEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'create') or hasPermission('CompoundPrescriptionDetailEntity', 'update')")
	public List<CompoundPrescriptionDetailEntity> saveAll(Iterable<CompoundPrescriptionDetailEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<CompoundPrescriptionDetailEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'delete')")
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
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	public List<CompoundPrescriptionDetailEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	public List<CompoundPrescriptionDetailEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(CompoundPrescriptionDetailEntity.class);

		// % protected region % [Add any additional processing before converting to a list of CompoundPrescriptionDetailEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of CompoundPrescriptionDetailEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('CompoundPrescriptionDetailEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<CompoundPrescriptionDetailEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of CompoundPrescriptionDetailEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of CompoundPrescriptionDetailEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(CompoundPrescriptionDetailEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of CompoundPrescriptionDetailEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of CompoundPrescriptionDetailEntityAudits
	 */
	private List<CompoundPrescriptionDetailEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<CompoundPrescriptionDetailEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param compoundPrescriptionDetail compoundPrescriptionDetail to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private CompoundPrescriptionDetailEntity updateAuditData(CompoundPrescriptionDetailEntity compoundPrescriptionDetail)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return compoundPrescriptionDetail;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private CompoundPrescriptionDetailEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		CompoundPrescriptionDetailEntity entityAtRevision = updateAuditData((CompoundPrescriptionDetailEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new CompoundPrescriptionDetailEntityAudit(
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

		QCompoundPrescriptionDetailEntity entity = QCompoundPrescriptionDetailEntity.compoundPrescriptionDetailEntity;

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
			case "consumptionUnitId":
				// % protected region % [Add any additional logic before the query parameters of relation from Consumption Unit to Compound Prescription Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Consumption Unit to Compound Prescription Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.consumptionUnit.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Consumption Unit to Compound Prescription Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Consumption Unit to Compound Prescription Details here] end

				break;
			case "compoundPrescriptionItemsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Compound Prescription Detail to Compound Prescription Items here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Compound Prescription Detail to Compound Prescription Items here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.compoundPrescriptionItems.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Compound Prescription Detail to Compound Prescription Items here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Compound Prescription Detail to Compound Prescription Items here] end

				break;
			case "compoundCode":
				// % protected region % [Add any additional logic before the query parameters of compoundCode here] off begin
				// % protected region % [Add any additional logic before the query parameters of compoundCode here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.compoundCode, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of compoundCode here] off begin
				// % protected region % [Add any additional logic after the query parameters of compoundCode here] end

				break;
			case "compoundName":
				// % protected region % [Add any additional logic before the query parameters of compoundName here] off begin
				// % protected region % [Add any additional logic before the query parameters of compoundName here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.compoundName, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of compoundName here] off begin
				// % protected region % [Add any additional logic after the query parameters of compoundName here] end

				break;
			case "frequency":
				// % protected region % [Add any additional logic before the query parameters of frequency here] off begin
				// % protected region % [Add any additional logic before the query parameters of frequency here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.frequency, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of frequency here] off begin
				// % protected region % [Add any additional logic after the query parameters of frequency here] end

				break;
			case "consumptionMethod":
				// % protected region % [Add any additional logic before the query parameters of consumptionMethod here] off begin
				// % protected region % [Add any additional logic before the query parameters of consumptionMethod here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.consumptionMethod, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of consumptionMethod here] off begin
				// % protected region % [Add any additional logic after the query parameters of consumptionMethod here] end

				break;
			case "isDtd":
				// % protected region % [Add any additional logic before the query parameters of isDtd here] off begin
				// % protected region % [Add any additional logic before the query parameters of isDtd here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.isDtd, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of isDtd here] off begin
				// % protected region % [Add any additional logic after the query parameters of isDtd here] end

				break;
			case "instruction":
				// % protected region % [Add any additional logic before the query parameters of instruction here] off begin
				// % protected region % [Add any additional logic before the query parameters of instruction here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.instruction, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of instruction here] off begin
				// % protected region % [Add any additional logic after the query parameters of instruction here] end

				break;
			case "notes":
				// % protected region % [Add any additional logic before the query parameters of notes here] off begin
				// % protected region % [Add any additional logic before the query parameters of notes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.notes, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of notes here] off begin
				// % protected region % [Add any additional logic after the query parameters of notes here] end

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
	public CompoundPrescriptionDetailEntity updateOldData(CompoundPrescriptionDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public CompoundPrescriptionDetailEntity updateOldData(CompoundPrescriptionDetailEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		CompoundPrescriptionDetailEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInCompoundPrescriptionDetailEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getIsDtd() == null) {
			entityToUpdate.setIsDtd(false);
		}

		// Incoming One to Many reference
		if (entity.getConsumptionUnit() == null && entity.getConsumptionUnitId() == null) {
			entityToUpdate.unsetConsumptionUnit();
		} else if (entity.getConsumptionUnitId() != null && entity.getConsumptionUnit() == null) {
			Optional<UnitOfMeasurementEntity> consumptionUnitEntity = this.unitOfMeasurementRepository.findById(entity.getConsumptionUnitId());
			entityToUpdate.setConsumptionUnit(consumptionUnitEntity.orElseThrow());
		}
		if (persistRelations && entity.getConsumptionUnit() != null) {
			entityToUpdate.setConsumptionUnit(entity.getConsumptionUnit(), false);
			if (entityToUpdate.getConsumptionUnitId() != null) {
				this.unitOfMeasurementRepository.save(entityToUpdate.getConsumptionUnit());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getConsumptionUnit().unsetCompoundPrescriptionDetails();
			}
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
	public void validateEntity(CompoundPrescriptionDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<CompoundPrescriptionDetailEntity>> errors = this.validator.validate(entity);

		// We need to ensure our set can be expanded.
		if (errors.isEmpty()) {
			errors = new HashSet<>();
		}

		// We have a uniqueness constraint on this class, let's check if create could be successful if we are creating
		final String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		if (entity.getId() == null) {
			var entityByCompoundCodeOpt = this.findByCompoundCode(entity.getCompoundCode());
			if (entityByCompoundCodeOpt.isPresent()) {
				var uniquenessViolation = new SimpleConstraintViolationImpl<CompoundPrescriptionDetailEntity>(
						"Compound Code",
						entity.getCompoundCode(),
						UNIQUENESS_VIOLATION_MESSAGE,
						"CompoundCode"
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
	 * Get the sort as given by the sort by for the CompoundPrescriptionDetailEntity.
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

	public Set<String> validateEntityRelations(CompoundPrescriptionDetailEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getConsumptionUnitId() != null && this.unitOfMeasurementRepository.findById(entity.getConsumptionUnitId()).isEmpty()) {
			errors.add("The UUID " + entity.getConsumptionUnitId() + " is not associated with a Unit Of Measurement Entity");
		}

		for (UUID id : entity.getCompoundPrescriptionItemsIds()) {
			if (this.compoundPrescriptionItemRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Compound Prescription Item Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
