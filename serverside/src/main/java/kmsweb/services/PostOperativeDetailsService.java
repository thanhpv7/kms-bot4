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
import kmsweb.repositories.PostOperativeDetailsRepository;
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
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.entities.RoomFacilityEntity;
import kmsweb.repositories.RoomFacilityRepository;

import lombok.NonNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.time.OffsetDateTime;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Service
public class PostOperativeDetailsService extends AbstractService<PostOperativeDetailsEntity, PostOperativeDetailsRepository, PostOperativeDetailsEntityAudit> {

	private final String[] referenceNamesInPostOperativeDetailsEntity = {
		"bedFacilities",
		"operatingTheaterMedicalExaminationRecord",
		"postOperativeICD10",
		"postOperativeICD9CM",
		"recoveryRooms",
	};

	private final BedFacilityRepository bedFacilityRepository;

	private final DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	private final OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;

	private final RoomFacilityRepository roomFacilityRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PostOperativeDetailsService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		BedFacilityRepository bedFacilityRepository,
		DiagnosesAndProceduresRepository diagnosesAndProceduresRepository,
		OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository,
		RoomFacilityRepository roomFacilityRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		PostOperativeDetailsRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.bedFacilityRepository = bedFacilityRepository;

		this.diagnosesAndProceduresRepository = diagnosesAndProceduresRepository;

		this.operatingTheaterMedicalExaminationRecordRepository = operatingTheaterMedicalExaminationRecordRepository;

		this.roomFacilityRepository = roomFacilityRepository;

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
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
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
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Recovery Start Date Time.
	 *
	 * @param recoveryStartDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Recovery Start Date Time
	 */
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntity> findByRecoveryStartDateTime(OffsetDateTime recoveryStartDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByRecoveryStartDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRecoveryStartDateTime here] end
	{
		// % protected region % [Add any additional logic for findByRecoveryStartDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByRecoveryStartDateTime before the main body here] end

		List<PostOperativeDetailsEntity> entities = Lists.newArrayList(repository.findByRecoveryStartDateTime(recoveryStartDateTime));

		// % protected region % [Add any additional logic for findByRecoveryStartDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRecoveryStartDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Recovery End Date Time.
	 *
	 * @param recoveryEndDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Recovery End Date Time
	 */
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntity> findByRecoveryEndDateTime(OffsetDateTime recoveryEndDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByRecoveryEndDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRecoveryEndDateTime here] end
	{
		// % protected region % [Add any additional logic for findByRecoveryEndDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByRecoveryEndDateTime before the main body here] end

		List<PostOperativeDetailsEntity> entities = Lists.newArrayList(repository.findByRecoveryEndDateTime(recoveryEndDateTime));

		// % protected region % [Add any additional logic for findByRecoveryEndDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRecoveryEndDateTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Postoperative Main Diagnosis.
	 *
	 * @param postoperativeMainDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postoperative Main Diagnosis
	 */
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntity> findByPostoperativeMainDiagnosis(String postoperativeMainDiagnosis)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostoperativeMainDiagnosis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostoperativeMainDiagnosis here] end
	{
		// % protected region % [Add any additional logic for findByPostoperativeMainDiagnosis before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostoperativeMainDiagnosis before the main body here] end

		List<PostOperativeDetailsEntity> entities = Lists.newArrayList(repository.findByPostoperativeMainDiagnosis(postoperativeMainDiagnosis));

		// % protected region % [Add any additional logic for findByPostoperativeMainDiagnosis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostoperativeMainDiagnosis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Postoperative Action.
	 *
	 * @param postoperativeAction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postoperative Action
	 */
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntity> findByPostoperativeAction(String postoperativeAction)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostoperativeAction here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostoperativeAction here] end
	{
		// % protected region % [Add any additional logic for findByPostoperativeAction before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostoperativeAction before the main body here] end

		List<PostOperativeDetailsEntity> entities = Lists.newArrayList(repository.findByPostoperativeAction(postoperativeAction));

		// % protected region % [Add any additional logic for findByPostoperativeAction before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostoperativeAction before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute New Case.
	 *
	 * @param newCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute New Case
	 */
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntity> findByNewCase(Boolean newCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByNewCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNewCase here] end
	{
		// % protected region % [Add any additional logic for findByNewCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByNewCase before the main body here] end

		List<PostOperativeDetailsEntity> entities = Lists.newArrayList(repository.findByNewCase(newCase));

		// % protected region % [Add any additional logic for findByNewCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNewCase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Postoperative Diagnosis Support Order.
	 *
	 * @param postoperativeDiagnosisSupportOrder the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postoperative Diagnosis Support Order
	 */
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntity> findByPostoperativeDiagnosisSupportOrder(String postoperativeDiagnosisSupportOrder)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostoperativeDiagnosisSupportOrder here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostoperativeDiagnosisSupportOrder here] end
	{
		// % protected region % [Add any additional logic for findByPostoperativeDiagnosisSupportOrder before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostoperativeDiagnosisSupportOrder before the main body here] end

		List<PostOperativeDetailsEntity> entities = Lists.newArrayList(repository.findByPostoperativeDiagnosisSupportOrder(postoperativeDiagnosisSupportOrder));

		// % protected region % [Add any additional logic for findByPostoperativeDiagnosisSupportOrder before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostoperativeDiagnosisSupportOrder before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Postoperative Monitoring.
	 *
	 * @param anesthesiaPostoperativeMonitoring the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Postoperative Monitoring
	 */
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntity> findByAnesthesiaPostoperativeMonitoring(String anesthesiaPostoperativeMonitoring)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaPostoperativeMonitoring here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaPostoperativeMonitoring here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaPostoperativeMonitoring before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaPostoperativeMonitoring before the main body here] end

		List<PostOperativeDetailsEntity> entities = Lists.newArrayList(repository.findByAnesthesiaPostoperativeMonitoring(anesthesiaPostoperativeMonitoring));

		// % protected region % [Add any additional logic for findByAnesthesiaPostoperativeMonitoring before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaPostoperativeMonitoring before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anesthesia Postoperative Action.
	 *
	 * @param anesthesiaPostoperativeAction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anesthesia Postoperative Action
	 */
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntity> findByAnesthesiaPostoperativeAction(String anesthesiaPostoperativeAction)
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaPostoperativeAction here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAnesthesiaPostoperativeAction here] end
	{
		// % protected region % [Add any additional logic for findByAnesthesiaPostoperativeAction before the main body here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaPostoperativeAction before the main body here] end

		List<PostOperativeDetailsEntity> entities = Lists.newArrayList(repository.findByAnesthesiaPostoperativeAction(anesthesiaPostoperativeAction));

		// % protected region % [Add any additional logic for findByAnesthesiaPostoperativeAction before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAnesthesiaPostoperativeAction before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<PostOperativeDetailsEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<PostOperativeDetailsEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<PostOperativeDetailsEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<PostOperativeDetailsEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<PostOperativeDetailsEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'create')")
	public PostOperativeDetailsEntity create(PostOperativeDetailsEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		PostOperativeDetailsEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'create')")
	public PostOperativeDetailsEntity create(PostOperativeDetailsEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		PostOperativeDetailsEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		PostOperativeDetailsEntity newEntity;

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
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'create')")
	public List<PostOperativeDetailsEntity> createAll(Iterable<PostOperativeDetailsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<PostOperativeDetailsEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<PostOperativeDetailsEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'update')")
	public PostOperativeDetailsEntity update(PostOperativeDetailsEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		PostOperativeDetailsEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'update')")
	public PostOperativeDetailsEntity update(PostOperativeDetailsEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		PostOperativeDetailsEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		PostOperativeDetailsEntity newEntity;

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
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'update')")
	public List<PostOperativeDetailsEntity> updateAll(Iterable<PostOperativeDetailsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<PostOperativeDetailsEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<PostOperativeDetailsEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'create') or hasPermission('PostOperativeDetailsEntity', 'update')")
	public PostOperativeDetailsEntity save(PostOperativeDetailsEntity entity) throws ConstraintViolationException
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

		PostOperativeDetailsEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'create') or hasPermission('PostOperativeDetailsEntity', 'update')")
	public List<PostOperativeDetailsEntity> saveAll(Iterable<PostOperativeDetailsEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<PostOperativeDetailsEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'delete')")
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
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	public List<PostOperativeDetailsEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	public List<PostOperativeDetailsEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(PostOperativeDetailsEntity.class);

		// % protected region % [Add any additional processing before converting to a list of PostOperativeDetailsEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of PostOperativeDetailsEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<PostOperativeDetailsEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of PostOperativeDetailsEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of PostOperativeDetailsEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(PostOperativeDetailsEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of PostOperativeDetailsEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of PostOperativeDetailsEntityAudits
	 */
	private List<PostOperativeDetailsEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<PostOperativeDetailsEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param postOperativeDetails postOperativeDetails to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private PostOperativeDetailsEntity updateAuditData(PostOperativeDetailsEntity postOperativeDetails)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return postOperativeDetails;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private PostOperativeDetailsEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		PostOperativeDetailsEntity entityAtRevision = updateAuditData((PostOperativeDetailsEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new PostOperativeDetailsEntityAudit(
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

		QPostOperativeDetailsEntity entity = QPostOperativeDetailsEntity.postOperativeDetailsEntity;

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
			case "operatingTheaterMedicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Post Operative Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Operating Theater Medical Examination Record to Post Operative Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.operatingTheaterMedicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Post Operative Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Operating Theater Medical Examination Record to Post Operative Details here] end

				break;
			case "postOperativeICD10Id":
				// % protected region % [Add any additional logic before the query parameters of relation from Post Operative ICD 10 to Post Operative ICD 10 here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Post Operative ICD 10 to Post Operative ICD 10 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.postOperativeICD10.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Post Operative ICD 10 to Post Operative ICD 10 here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Post Operative ICD 10 to Post Operative ICD 10 here] end

				break;
			case "postOperativeICD9CMId":
				// % protected region % [Add any additional logic before the query parameters of relation from Post Operative ICD 9 CM to Post Operative ICD 9 CM here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Post Operative ICD 9 CM to Post Operative ICD 9 CM here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.postOperativeICD9CM.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Post Operative ICD 9 CM to Post Operative ICD 9 CM here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Post Operative ICD 9 CM to Post Operative ICD 9 CM here] end

				break;
			case "recoveryRoomsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Recovery Rooms to Recovery Rooms here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Recovery Rooms to Recovery Rooms here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.recoveryRooms.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Recovery Rooms to Recovery Rooms here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Recovery Rooms to Recovery Rooms here] end

				break;
			case "bedFacilitiesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Post Operative Details to Bed Facilities here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Post Operative Details to Bed Facilities here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bedFacilities.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Post Operative Details to Bed Facilities here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Post Operative Details to Bed Facilities here] end

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
	public PostOperativeDetailsEntity updateOldData(PostOperativeDetailsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public PostOperativeDetailsEntity updateOldData(PostOperativeDetailsEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		PostOperativeDetailsEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInPostOperativeDetailsEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getNewCase() == null) {
			entityToUpdate.setNewCase(false);
		}

		// Incoming One to One reference
		if (entity.getOperatingTheaterMedicalExaminationRecord() == null && entity.getOperatingTheaterMedicalExaminationRecordId() == null) {
			entityToUpdate.unsetOperatingTheaterMedicalExaminationRecord();
		} else if (entity.getOperatingTheaterMedicalExaminationRecordId() != null && entity.getOperatingTheaterMedicalExaminationRecord() == null) {
			Optional<OperatingTheaterMedicalExaminationRecordEntity> operatingTheaterMedicalExaminationRecordEntity = this.operatingTheaterMedicalExaminationRecordRepository.findById(entity.getOperatingTheaterMedicalExaminationRecordId());
			entityToUpdate.setOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecordEntity.orElseThrow());
		}
		if (persistRelations && entity.getOperatingTheaterMedicalExaminationRecord() != null) {
			entityToUpdate.setOperatingTheaterMedicalExaminationRecord(entity.getOperatingTheaterMedicalExaminationRecord(), false);
			if (entityToUpdate.getOperatingTheaterMedicalExaminationRecordId() != null) {
				this.operatingTheaterMedicalExaminationRecordRepository.save(entityToUpdate.getOperatingTheaterMedicalExaminationRecord());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getOperatingTheaterMedicalExaminationRecord().unsetPostOperativeDetails();
			}
		}

		// Incoming One to Many reference
		if (entity.getPostOperativeICD10() == null && entity.getPostOperativeICD10Id() == null) {
			entityToUpdate.unsetPostOperativeICD10();
		} else if (entity.getPostOperativeICD10Id() != null && entity.getPostOperativeICD10() == null) {
			Optional<DiagnosesAndProceduresEntity> postOperativeICD10Entity = this.diagnosesAndProceduresRepository.findById(entity.getPostOperativeICD10Id());
			entityToUpdate.setPostOperativeICD10(postOperativeICD10Entity.orElseThrow());
		}
		if (persistRelations && entity.getPostOperativeICD10() != null) {
			entityToUpdate.setPostOperativeICD10(entity.getPostOperativeICD10(), false);
			if (entityToUpdate.getPostOperativeICD10Id() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getPostOperativeICD10());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPostOperativeICD10().unsetPostOperativeICD10();
			}
		}

		// Incoming One to Many reference
		if (entity.getPostOperativeICD9CM() == null && entity.getPostOperativeICD9CMId() == null) {
			entityToUpdate.unsetPostOperativeICD9CM();
		} else if (entity.getPostOperativeICD9CMId() != null && entity.getPostOperativeICD9CM() == null) {
			Optional<DiagnosesAndProceduresEntity> postOperativeICD9CMEntity = this.diagnosesAndProceduresRepository.findById(entity.getPostOperativeICD9CMId());
			entityToUpdate.setPostOperativeICD9CM(postOperativeICD9CMEntity.orElseThrow());
		}
		if (persistRelations && entity.getPostOperativeICD9CM() != null) {
			entityToUpdate.setPostOperativeICD9CM(entity.getPostOperativeICD9CM(), false);
			if (entityToUpdate.getPostOperativeICD9CMId() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getPostOperativeICD9CM());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getPostOperativeICD9CM().unsetPostOperativeICD9CM();
			}
		}

		// Incoming One to Many reference
		if (entity.getRecoveryRooms() == null && entity.getRecoveryRoomsId() == null) {
			entityToUpdate.unsetRecoveryRooms();
		} else if (entity.getRecoveryRoomsId() != null && entity.getRecoveryRooms() == null) {
			Optional<RoomFacilityEntity> recoveryRoomsEntity = this.roomFacilityRepository.findById(entity.getRecoveryRoomsId());
			entityToUpdate.setRecoveryRooms(recoveryRoomsEntity.orElseThrow());
		}
		if (persistRelations && entity.getRecoveryRooms() != null) {
			entityToUpdate.setRecoveryRooms(entity.getRecoveryRooms(), false);
			if (entityToUpdate.getRecoveryRoomsId() != null) {
				this.roomFacilityRepository.save(entityToUpdate.getRecoveryRooms());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getRecoveryRooms().unsetRecoveryRooms();
			}
		}

		// Outgoing one to many reference
		if (entity.getBedFacilitiesIds().isEmpty() && entity.getBedFacilities().isEmpty()) {
			entityToUpdate.setBedFacilities(new HashSet<>());
		} else if (!entity.getBedFacilitiesIds().isEmpty() && entity.getBedFacilities().isEmpty()) {
			Iterable<BedFacilityEntity> bedFacilitiesEntities =
					this.bedFacilityRepository.findAllById(entity.getBedFacilitiesIds());
			entityToUpdate.setBedFacilities(Sets.newHashSet(bedFacilitiesEntities));
		}
		if (persistRelations && !entity.getBedFacilities().isEmpty()) {
			Set<BedFacilityEntity> updatedEntities = new HashSet<>();
			entity.getBedFacilities().forEach(model -> {
				if (model.getId() != null) {
					model = this.bedFacilityRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setBedFacilities(updatedEntities);
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
	public void validateEntity(PostOperativeDetailsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<PostOperativeDetailsEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the PostOperativeDetailsEntity.
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

	public Set<String> validateEntityRelations(PostOperativeDetailsEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getOperatingTheaterMedicalExaminationRecordId() != null && this.operatingTheaterMedicalExaminationRecordRepository.findById(entity.getOperatingTheaterMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getOperatingTheaterMedicalExaminationRecordId() + " is not associated with a Operating Theater Medical Examination Record Entity");
		}

		if (entity.getPostOperativeICD10Id() != null && this.diagnosesAndProceduresRepository.findById(entity.getPostOperativeICD10Id()).isEmpty()) {
			errors.add("The UUID " + entity.getPostOperativeICD10Id() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getPostOperativeICD9CMId() != null && this.diagnosesAndProceduresRepository.findById(entity.getPostOperativeICD9CMId()).isEmpty()) {
			errors.add("The UUID " + entity.getPostOperativeICD9CMId() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getRecoveryRoomsId() != null && this.roomFacilityRepository.findById(entity.getRecoveryRoomsId()).isEmpty()) {
			errors.add("The UUID " + entity.getRecoveryRoomsId() + " is not associated with a Room Facility Entity");
		}

		for (UUID id : entity.getBedFacilitiesIds()) {
			if (this.bedFacilityRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Bed Facility Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
