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
import kmsweb.repositories.MedicalCertificateDischargeResumeRepository;
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
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
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
public class MedicalCertificateDischargeResumeService extends AbstractService<MedicalCertificateDischargeResumeEntity, MedicalCertificateDischargeResumeRepository, MedicalCertificateDischargeResumeEntityAudit> {

	private final String[] referenceNamesInMedicalCertificateDischargeResumeEntity = {
		"dischargeICD10",
		"dischargeICD9CM",
		"registration",
		"medicalStaff",
	};

	private final DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	private final RegistrationRepository registrationRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public MedicalCertificateDischargeResumeService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		DiagnosesAndProceduresRepository diagnosesAndProceduresRepository,
		RegistrationRepository registrationRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		MedicalCertificateDischargeResumeRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.diagnosesAndProceduresRepository = diagnosesAndProceduresRepository;

		this.registrationRepository = registrationRepository;

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
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
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
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Admission Date Time.
	 *
	 * @param admissionDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Admission Date Time
	 */
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalCertificateDischargeResumeEntity> findByAdmissionDateTime(OffsetDateTime admissionDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByAdmissionDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAdmissionDateTime here] end
	{
		// % protected region % [Add any additional logic for findByAdmissionDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByAdmissionDateTime before the main body here] end

		List<MedicalCertificateDischargeResumeEntity> entities = Lists.newArrayList(repository.findByAdmissionDateTime(admissionDateTime));

		// % protected region % [Add any additional logic for findByAdmissionDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAdmissionDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Discharge Date Time.
	 *
	 * @param dischargeDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Discharge Date Time
	 */
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalCertificateDischargeResumeEntity> findByDischargeDateTime(OffsetDateTime dischargeDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByDischargeDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDischargeDateTime here] end
	{
		// % protected region % [Add any additional logic for findByDischargeDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByDischargeDateTime before the main body here] end

		List<MedicalCertificateDischargeResumeEntity> entities = Lists.newArrayList(repository.findByDischargeDateTime(dischargeDateTime));

		// % protected region % [Add any additional logic for findByDischargeDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDischargeDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Condition.
	 *
	 * @param condition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Condition
	 */
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalCertificateDischargeResumeEntity> findByCondition(String condition)
	// % protected region % [Add any throwables, implementations, or extensions for findByCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCondition here] end
	{
		// % protected region % [Add any additional logic for findByCondition before the main body here] off begin
		// % protected region % [Add any additional logic for findByCondition before the main body here] end

		List<MedicalCertificateDischargeResumeEntity> entities = Lists.newArrayList(repository.findByCondition(condition));

		// % protected region % [Add any additional logic for findByCondition before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCondition before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Main Diagnosis.
	 *
	 * @param mainDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Main Diagnosis
	 */
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalCertificateDischargeResumeEntity> findByMainDiagnosis(String mainDiagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByMainDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMainDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByMainDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByMainDiagnosis before the main body here] end

		List<MedicalCertificateDischargeResumeEntity> entities = Lists.newArrayList(repository.findByMainDiagnosis(mainDiagnosis));

		// % protected region % [Add any additional logic for findByMainDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMainDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Action.
	 *
	 * @param action the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Action
	 */
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalCertificateDischargeResumeEntity> findByAction(String action)
	// % protected region % [Add any throwables, implementations, or extensions for findByAction here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAction here] end
	{
		// % protected region % [Add any additional logic for findByAction before the main body here] off begin
		// % protected region % [Add any additional logic for findByAction before the main body here] end

		List<MedicalCertificateDischargeResumeEntity> entities = Lists.newArrayList(repository.findByAction(action));

		// % protected region % [Add any additional logic for findByAction before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAction before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalCertificateDischargeResumeEntity> findByNotes(String notes)
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNotes here] end
	{
		// % protected region % [Add any additional logic for findByNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByNotes before the main body here] end

		List<MedicalCertificateDischargeResumeEntity> entities = Lists.newArrayList(repository.findByNotes(notes));

		// % protected region % [Add any additional logic for findByNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNotes before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<MedicalCertificateDischargeResumeEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<MedicalCertificateDischargeResumeEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalCertificateDischargeResumeEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<MedicalCertificateDischargeResumeEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalCertificateDischargeResumeEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<MedicalCertificateDischargeResumeEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@Transactional(readOnly = true)
	public List<MedicalCertificateDischargeResumeEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<MedicalCertificateDischargeResumeEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'create')")
	public MedicalCertificateDischargeResumeEntity create(MedicalCertificateDischargeResumeEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		MedicalCertificateDischargeResumeEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'create')")
	public MedicalCertificateDischargeResumeEntity create(MedicalCertificateDischargeResumeEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		MedicalCertificateDischargeResumeEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		MedicalCertificateDischargeResumeEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'create')")
	public List<MedicalCertificateDischargeResumeEntity> createAll(Iterable<MedicalCertificateDischargeResumeEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<MedicalCertificateDischargeResumeEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<MedicalCertificateDischargeResumeEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'update')")
	public MedicalCertificateDischargeResumeEntity update(MedicalCertificateDischargeResumeEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		MedicalCertificateDischargeResumeEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'update')")
	public MedicalCertificateDischargeResumeEntity update(MedicalCertificateDischargeResumeEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		MedicalCertificateDischargeResumeEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		MedicalCertificateDischargeResumeEntity newEntity;

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
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'update')")
	public List<MedicalCertificateDischargeResumeEntity> updateAll(Iterable<MedicalCertificateDischargeResumeEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<MedicalCertificateDischargeResumeEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<MedicalCertificateDischargeResumeEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'create') or hasPermission('MedicalCertificateDischargeResumeEntity', 'update')")
	public MedicalCertificateDischargeResumeEntity save(MedicalCertificateDischargeResumeEntity entity) throws ConstraintViolationException
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

		MedicalCertificateDischargeResumeEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'create') or hasPermission('MedicalCertificateDischargeResumeEntity', 'update')")
	public List<MedicalCertificateDischargeResumeEntity> saveAll(Iterable<MedicalCertificateDischargeResumeEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<MedicalCertificateDischargeResumeEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'delete')")
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
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	public List<MedicalCertificateDischargeResumeEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	public List<MedicalCertificateDischargeResumeEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicalCertificateDischargeResumeEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(MedicalCertificateDischargeResumeEntity.class);

		// % protected region % [Add any additional processing before converting to a list of MedicalCertificateDischargeResumeEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicalCertificateDischargeResumeEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<MedicalCertificateDischargeResumeEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of MedicalCertificateDischargeResumeEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of MedicalCertificateDischargeResumeEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(MedicalCertificateDischargeResumeEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of MedicalCertificateDischargeResumeEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of MedicalCertificateDischargeResumeEntityAudits
	 */
	private List<MedicalCertificateDischargeResumeEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<MedicalCertificateDischargeResumeEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param medicalCertificateDischargeResume medicalCertificateDischargeResume to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private MedicalCertificateDischargeResumeEntity updateAuditData(MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResume)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return medicalCertificateDischargeResume;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private MedicalCertificateDischargeResumeEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		MedicalCertificateDischargeResumeEntity entityAtRevision = updateAuditData((MedicalCertificateDischargeResumeEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new MedicalCertificateDischargeResumeEntityAudit(
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

		QMedicalCertificateDischargeResumeEntity entity = QMedicalCertificateDischargeResumeEntity.medicalCertificateDischargeResumeEntity;

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
			case "registrationId":
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate  Discharge Resume here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Registration to Medical Certificate  Discharge Resume here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.registration.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate  Discharge Resume here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Registration to Medical Certificate  Discharge Resume here] end

				break;
			case "dischargeICD10Id":
				// % protected region % [Add any additional logic before the query parameters of relation from Discharge ICD 10 to Discharge ICD 10 here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Discharge ICD 10 to Discharge ICD 10 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dischargeICD10.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Discharge ICD 10 to Discharge ICD 10 here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Discharge ICD 10 to Discharge ICD 10 here] end

				break;
			case "dischargeICD9CMId":
				// % protected region % [Add any additional logic before the query parameters of relation from Discharge ICD 9 CM to Discharge ICD 9 CM here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Discharge ICD 9 CM to Discharge ICD 9 CM here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.dischargeICD9CM.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Discharge ICD 9 CM to Discharge ICD 9 CM here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Discharge ICD 9 CM to Discharge ICD 9 CM here] end

				break;
			case "medicalStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Certificate  Discharge Resumes here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Staff to Medical Certificate  Discharge Resumes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalStaff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Certificate  Discharge Resumes here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Staff to Medical Certificate  Discharge Resumes here] end

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
	public MedicalCertificateDischargeResumeEntity updateOldData(MedicalCertificateDischargeResumeEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public MedicalCertificateDischargeResumeEntity updateOldData(MedicalCertificateDischargeResumeEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		MedicalCertificateDischargeResumeEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInMedicalCertificateDischargeResumeEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to One reference
		if (entity.getRegistration() == null && entity.getRegistrationId() == null) {
			entityToUpdate.unsetRegistration();
		} else if (entity.getRegistrationId() != null && entity.getRegistration() == null) {
			Optional<RegistrationEntity> registrationEntity = this.registrationRepository.findById(entity.getRegistrationId());
			entityToUpdate.setRegistration(registrationEntity.orElseThrow());
		}
		if (persistRelations && entity.getRegistration() != null) {
			entityToUpdate.setRegistration(entity.getRegistration(), false);
			if (entityToUpdate.getRegistrationId() != null) {
				this.registrationRepository.save(entityToUpdate.getRegistration());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getRegistration().unsetMedicalCertificateDischargeResume();
			}
		}

		// Incoming One to Many reference
		if (entity.getDischargeICD10() == null && entity.getDischargeICD10Id() == null) {
			entityToUpdate.unsetDischargeICD10();
		} else if (entity.getDischargeICD10Id() != null && entity.getDischargeICD10() == null) {
			Optional<DiagnosesAndProceduresEntity> dischargeICD10Entity = this.diagnosesAndProceduresRepository.findById(entity.getDischargeICD10Id());
			entityToUpdate.setDischargeICD10(dischargeICD10Entity.orElseThrow());
		}
		if (persistRelations && entity.getDischargeICD10() != null) {
			entityToUpdate.setDischargeICD10(entity.getDischargeICD10(), false);
			if (entityToUpdate.getDischargeICD10Id() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getDischargeICD10());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDischargeICD10().unsetDischargeICD10();
			}
		}

		// Incoming One to Many reference
		if (entity.getDischargeICD9CM() == null && entity.getDischargeICD9CMId() == null) {
			entityToUpdate.unsetDischargeICD9CM();
		} else if (entity.getDischargeICD9CMId() != null && entity.getDischargeICD9CM() == null) {
			Optional<DiagnosesAndProceduresEntity> dischargeICD9CMEntity = this.diagnosesAndProceduresRepository.findById(entity.getDischargeICD9CMId());
			entityToUpdate.setDischargeICD9CM(dischargeICD9CMEntity.orElseThrow());
		}
		if (persistRelations && entity.getDischargeICD9CM() != null) {
			entityToUpdate.setDischargeICD9CM(entity.getDischargeICD9CM(), false);
			if (entityToUpdate.getDischargeICD9CMId() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getDischargeICD9CM());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDischargeICD9CM().unsetDischargeICD9CM();
			}
		}

		// Incoming One to Many reference
		if (entity.getMedicalStaff() == null && entity.getMedicalStaffId() == null) {
			entityToUpdate.unsetMedicalStaff();
		} else if (entity.getMedicalStaffId() != null && entity.getMedicalStaff() == null) {
			Optional<StaffEntity> medicalStaffEntity = this.staffRepository.findById(entity.getMedicalStaffId());
			entityToUpdate.setMedicalStaff(medicalStaffEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalStaff() != null) {
			entityToUpdate.setMedicalStaff(entity.getMedicalStaff(), false);
			if (entityToUpdate.getMedicalStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getMedicalStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalStaff().unsetMedicalCertificateDischargeResumes();
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
	public void validateEntity(MedicalCertificateDischargeResumeEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<MedicalCertificateDischargeResumeEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the MedicalCertificateDischargeResumeEntity.
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

	public Set<String> validateEntityRelations(MedicalCertificateDischargeResumeEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getDischargeICD10Id() != null && this.diagnosesAndProceduresRepository.findById(entity.getDischargeICD10Id()).isEmpty()) {
			errors.add("The UUID " + entity.getDischargeICD10Id() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getDischargeICD9CMId() != null && this.diagnosesAndProceduresRepository.findById(entity.getDischargeICD9CMId()).isEmpty()) {
			errors.add("The UUID " + entity.getDischargeICD9CMId() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getRegistrationId() != null && this.registrationRepository.findById(entity.getRegistrationId()).isEmpty()) {
			errors.add("The UUID " + entity.getRegistrationId() + " is not associated with a Registration Entity");
		}

		if (entity.getMedicalStaffId() != null && this.staffRepository.findById(entity.getMedicalStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalStaffId() + " is not associated with a Staff Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
