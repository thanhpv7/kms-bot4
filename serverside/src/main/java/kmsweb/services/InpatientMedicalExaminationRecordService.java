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
import kmsweb.repositories.InpatientMedicalExaminationRecordRepository;
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
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class InpatientMedicalExaminationRecordService extends AbstractService<InpatientMedicalExaminationRecordEntity, InpatientMedicalExaminationRecordRepository, InpatientMedicalExaminationRecordEntityAudit> {

	private final String[] referenceNamesInInpatientMedicalExaminationRecordEntity = {
		"medicalExaminationRecord",
		"bedFacility",
	};

	private final BedFacilityRepository bedFacilityRepository;

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public InpatientMedicalExaminationRecordService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BedFacilityRepository bedFacilityRepository,
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		InpatientMedicalExaminationRecordRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bedFacilityRepository = bedFacilityRepository;

		this.medicalExaminationRecordRepository = medicalExaminationRecordRepository;

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
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
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
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Start Date Time.
	 *
	 * @param startDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Start Date Time
	 */
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findByStartDateTime(OffsetDateTime startDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDateTime here] end
	{
		// % protected region % [Add any additional logic for findByStartDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByStartDateTime before the main body here] end

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByStartDateTime(startDateTime));

		// % protected region % [Add any additional logic for findByStartDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStartDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute End Date Time.
	 *
	 * @param endDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute End Date Time
	 */
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findByEndDateTime(OffsetDateTime endDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDateTime here] end
	{
		// % protected region % [Add any additional logic for findByEndDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByEndDateTime before the main body here] end

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByEndDateTime(endDateTime));

		// % protected region % [Add any additional logic for findByEndDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEndDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Treatment Class.
	 *
	 * @param treatmentClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Treatment Class
	 */
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findByTreatmentClass(String treatmentClass)
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTreatmentClass here] end
	{
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before the main body here] end

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTreatmentClass(treatmentClass));

		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTreatmentClass before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Inpatient Case.
	 *
	 * @param inpatientCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inpatient Case
	 */
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findByInpatientCase(String inpatientCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByInpatientCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInpatientCase here] end
	{
		// % protected region % [Add any additional logic for findByInpatientCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByInpatientCase before the main body here] end

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByInpatientCase(inpatientCase));

		// % protected region % [Add any additional logic for findByInpatientCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInpatientCase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Service Case.
	 *
	 * @param serviceCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Service Case
	 */
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findByServiceCase(String serviceCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByServiceCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByServiceCase here] end
	{
		// % protected region % [Add any additional logic for findByServiceCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByServiceCase before the main body here] end

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByServiceCase(serviceCase));

		// % protected region % [Add any additional logic for findByServiceCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByServiceCase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dependency Level.
	 *
	 * @param dependencyLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dependency Level
	 */
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findByDependencyLevel(String dependencyLevel)
	// % protected region % [Add any throwables, implementations, or extensions for findByDependencyLevel here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDependencyLevel here] end
	{
		// % protected region % [Add any additional logic for findByDependencyLevel before the main body here] off begin
		// % protected region % [Add any additional logic for findByDependencyLevel before the main body here] end

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByDependencyLevel(dependencyLevel));

		// % protected region % [Add any additional logic for findByDependencyLevel before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDependencyLevel before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Current Dependency.
	 *
	 * @param currentDependency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Current Dependency
	 */
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findByCurrentDependency(String currentDependency)
	// % protected region % [Add any throwables, implementations, or extensions for findByCurrentDependency here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCurrentDependency here] end
	{
		// % protected region % [Add any additional logic for findByCurrentDependency before the main body here] off begin
		// % protected region % [Add any additional logic for findByCurrentDependency before the main body here] end

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByCurrentDependency(currentDependency));

		// % protected region % [Add any additional logic for findByCurrentDependency before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCurrentDependency before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Infant Condition.
	 *
	 * @param infantCondition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Infant Condition
	 */
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findByInfantCondition(String infantCondition)
	// % protected region % [Add any throwables, implementations, or extensions for findByInfantCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInfantCondition here] end
	{
		// % protected region % [Add any additional logic for findByInfantCondition before the main body here] off begin
		// % protected region % [Add any additional logic for findByInfantCondition before the main body here] end

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByInfantCondition(infantCondition));

		// % protected region % [Add any additional logic for findByInfantCondition before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInfantCondition before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Neonatal Case.
	 *
	 * @param neonatalCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Neonatal Case
	 */
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findByNeonatalCase(String neonatalCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByNeonatalCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNeonatalCase here] end
	{
		// % protected region % [Add any additional logic for findByNeonatalCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByNeonatalCase before the main body here] end

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByNeonatalCase(neonatalCase));

		// % protected region % [Add any additional logic for findByNeonatalCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNeonatalCase before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<InpatientMedicalExaminationRecordEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<InpatientMedicalExaminationRecordEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<InpatientMedicalExaminationRecordEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'create')")
	public InpatientMedicalExaminationRecordEntity create(InpatientMedicalExaminationRecordEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		InpatientMedicalExaminationRecordEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'create')")
	public InpatientMedicalExaminationRecordEntity create(InpatientMedicalExaminationRecordEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		InpatientMedicalExaminationRecordEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		InpatientMedicalExaminationRecordEntity newEntity;

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
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'create')")
	public List<InpatientMedicalExaminationRecordEntity> createAll(Iterable<InpatientMedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<InpatientMedicalExaminationRecordEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<InpatientMedicalExaminationRecordEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'update')")
	public InpatientMedicalExaminationRecordEntity update(InpatientMedicalExaminationRecordEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		InpatientMedicalExaminationRecordEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'update')")
	public InpatientMedicalExaminationRecordEntity update(InpatientMedicalExaminationRecordEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		InpatientMedicalExaminationRecordEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		InpatientMedicalExaminationRecordEntity newEntity;

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
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'update')")
	public List<InpatientMedicalExaminationRecordEntity> updateAll(Iterable<InpatientMedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<InpatientMedicalExaminationRecordEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<InpatientMedicalExaminationRecordEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'create') or hasPermission('InpatientMedicalExaminationRecordEntity', 'update')")
	public InpatientMedicalExaminationRecordEntity save(InpatientMedicalExaminationRecordEntity entity) throws ConstraintViolationException
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

		InpatientMedicalExaminationRecordEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'create') or hasPermission('InpatientMedicalExaminationRecordEntity', 'update')")
	public List<InpatientMedicalExaminationRecordEntity> saveAll(Iterable<InpatientMedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<InpatientMedicalExaminationRecordEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'delete')")
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
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	public List<InpatientMedicalExaminationRecordEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	public List<InpatientMedicalExaminationRecordEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(InpatientMedicalExaminationRecordEntity.class);

		// % protected region % [Add any additional processing before converting to a list of InpatientMedicalExaminationRecordEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of InpatientMedicalExaminationRecordEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('InpatientMedicalExaminationRecordEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<InpatientMedicalExaminationRecordEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of InpatientMedicalExaminationRecordEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of InpatientMedicalExaminationRecordEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(InpatientMedicalExaminationRecordEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of InpatientMedicalExaminationRecordEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of InpatientMedicalExaminationRecordEntityAudits
	 */
	private List<InpatientMedicalExaminationRecordEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<InpatientMedicalExaminationRecordEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param inpatientMedicalExaminationRecord inpatientMedicalExaminationRecord to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private InpatientMedicalExaminationRecordEntity updateAuditData(InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecord)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return inpatientMedicalExaminationRecord;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private InpatientMedicalExaminationRecordEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		InpatientMedicalExaminationRecordEntity entityAtRevision = updateAuditData((InpatientMedicalExaminationRecordEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new InpatientMedicalExaminationRecordEntityAudit(
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

		QInpatientMedicalExaminationRecordEntity entity = QInpatientMedicalExaminationRecordEntity.inpatientMedicalExaminationRecordEntity;

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
			case "medicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Inpatient Medical Examination Record to Medical Examination Record here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Inpatient Medical Examination Record to Medical Examination Record here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Inpatient Medical Examination Record to Medical Examination Record here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Inpatient Medical Examination Record to Medical Examination Record here] end

				break;
			case "bedFacilityId":
				// % protected region % [Add any additional logic before the query parameters of relation from Bed Facility to Inpatient Medical Examination Records here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Bed Facility to Inpatient Medical Examination Records here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bedFacility.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Bed Facility to Inpatient Medical Examination Records here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Bed Facility to Inpatient Medical Examination Records here] end

				break;
			case "startDateTime":
				// % protected region % [Add any additional logic before the query parameters of startDateTime here] off begin
				// % protected region % [Add any additional logic before the query parameters of startDateTime here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.startDateTime, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of startDateTime here] off begin
				// % protected region % [Add any additional logic after the query parameters of startDateTime here] end

				break;
			case "endDateTime":
				// % protected region % [Add any additional logic before the query parameters of endDateTime here] off begin
				// % protected region % [Add any additional logic before the query parameters of endDateTime here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.endDateTime, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of endDateTime here] off begin
				// % protected region % [Add any additional logic after the query parameters of endDateTime here] end

				break;
			case "treatmentClass":
				// % protected region % [Add any additional logic before the query parameters of treatmentClass here] off begin
				// % protected region % [Add any additional logic before the query parameters of treatmentClass here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.treatmentClass, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of treatmentClass here] off begin
				// % protected region % [Add any additional logic after the query parameters of treatmentClass here] end

				break;
			case "inpatientCase":
				// % protected region % [Add any additional logic before the query parameters of inpatientCase here] off begin
				// % protected region % [Add any additional logic before the query parameters of inpatientCase here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.inpatientCase, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of inpatientCase here] off begin
				// % protected region % [Add any additional logic after the query parameters of inpatientCase here] end

				break;
			case "serviceCase":
				// % protected region % [Add any additional logic before the query parameters of serviceCase here] off begin
				// % protected region % [Add any additional logic before the query parameters of serviceCase here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.serviceCase, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of serviceCase here] off begin
				// % protected region % [Add any additional logic after the query parameters of serviceCase here] end

				break;
			case "dependencyLevel":
				// % protected region % [Add any additional logic before the query parameters of dependencyLevel here] off begin
				// % protected region % [Add any additional logic before the query parameters of dependencyLevel here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dependencyLevel, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of dependencyLevel here] off begin
				// % protected region % [Add any additional logic after the query parameters of dependencyLevel here] end

				break;
			case "currentDependency":
				// % protected region % [Add any additional logic before the query parameters of currentDependency here] off begin
				// % protected region % [Add any additional logic before the query parameters of currentDependency here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.currentDependency, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of currentDependency here] off begin
				// % protected region % [Add any additional logic after the query parameters of currentDependency here] end

				break;
			case "infantCondition":
				// % protected region % [Add any additional logic before the query parameters of infantCondition here] off begin
				// % protected region % [Add any additional logic before the query parameters of infantCondition here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.infantCondition, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of infantCondition here] off begin
				// % protected region % [Add any additional logic after the query parameters of infantCondition here] end

				break;
			case "neonatalCase":
				// % protected region % [Add any additional logic before the query parameters of neonatalCase here] off begin
				// % protected region % [Add any additional logic before the query parameters of neonatalCase here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.neonatalCase, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of neonatalCase here] off begin
				// % protected region % [Add any additional logic after the query parameters of neonatalCase here] end

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
	public InpatientMedicalExaminationRecordEntity updateOldData(InpatientMedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public InpatientMedicalExaminationRecordEntity updateOldData(InpatientMedicalExaminationRecordEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		InpatientMedicalExaminationRecordEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInInpatientMedicalExaminationRecordEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Outgoing one to one reference
		if (entity.getMedicalExaminationRecord() == null && entity.getMedicalExaminationRecordId() == null) {
			entityToUpdate.unsetMedicalExaminationRecord();
		} else if (entity.getMedicalExaminationRecordId() != null && entity.getMedicalExaminationRecord() == null) {
			Optional<MedicalExaminationRecordEntity> medicalExaminationRecordEntity = this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId());
			entityToUpdate.setMedicalExaminationRecord(medicalExaminationRecordEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalExaminationRecord() != null) {
			entityToUpdate.setMedicalExaminationRecord(entity.getMedicalExaminationRecord(), false);
			if (entityToUpdate.getMedicalExaminationRecordId() != null) {
				this.medicalExaminationRecordRepository.save(entityToUpdate.getMedicalExaminationRecord());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalExaminationRecord().unsetInpatientMedicalExaminationRecord();
			}
		}

		// Incoming One to Many reference
		if (entity.getBedFacility() == null && entity.getBedFacilityId() == null) {
			entityToUpdate.unsetBedFacility();
		} else if (entity.getBedFacilityId() != null && entity.getBedFacility() == null) {
			Optional<BedFacilityEntity> bedFacilityEntity = this.bedFacilityRepository.findById(entity.getBedFacilityId());
			entityToUpdate.setBedFacility(bedFacilityEntity.orElseThrow());
		}
		if (persistRelations && entity.getBedFacility() != null) {
			entityToUpdate.setBedFacility(entity.getBedFacility(), false);
			if (entityToUpdate.getBedFacilityId() != null) {
				this.bedFacilityRepository.save(entityToUpdate.getBedFacility());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getBedFacility().unsetInpatientMedicalExaminationRecords();
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
	public void validateEntity(InpatientMedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<InpatientMedicalExaminationRecordEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the InpatientMedicalExaminationRecordEntity.
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

	public Set<String> validateEntityRelations(InpatientMedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getBedFacilityId() != null && this.bedFacilityRepository.findById(entity.getBedFacilityId()).isEmpty()) {
			errors.add("The UUID " + entity.getBedFacilityId() + " is not associated with a Bed Facility Entity");
		}

		if (entity.getMedicalExaminationRecordId() != null && this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalExaminationRecordId() + " is not associated with a Medical Examination Record Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
