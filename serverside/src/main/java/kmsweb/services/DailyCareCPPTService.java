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
import kmsweb.repositories.DailyCareCPPTRepository;
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
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
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
public class DailyCareCPPTService extends AbstractService<DailyCareCPPTEntity, DailyCareCPPTRepository, DailyCareCPPTEntityAudit> {

	private final String[] referenceNamesInDailyCareCPPTEntity = {
		"icd10",
		"icd9CM",
		"createdByStaff",
		"doctorInCharge",
		"medicalTranscriber",
		"medicalExaminationRecord",
	};

	private final DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public DailyCareCPPTService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		DiagnosesAndProceduresRepository diagnosesAndProceduresRepository,
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		DailyCareCPPTRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.diagnosesAndProceduresRepository = diagnosesAndProceduresRepository;

		this.medicalExaminationRecordRepository = medicalExaminationRecordRepository;

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
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
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
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Subjective.
	 *
	 * @param subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Subjective
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findBySubjective(String subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findBySubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySubjective here] end
	{
		// % protected region % [Add any additional logic for findBySubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findBySubjective before the main body here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findBySubjective(subjective));

		// % protected region % [Add any additional logic for findBySubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Objective.
	 *
	 * @param objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Objective
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findByObjective(String objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByObjective here] end
	{
		// % protected region % [Add any additional logic for findByObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByObjective before the main body here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findByObjective(objective));

		// % protected region % [Add any additional logic for findByObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Diagnose.
	 *
	 * @param diagnose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Diagnose
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findByDiagnose(String diagnose)
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnose here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDiagnose here] end
	{
		// % protected region % [Add any additional logic for findByDiagnose before the main body here] off begin
		// % protected region % [Add any additional logic for findByDiagnose before the main body here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findByDiagnose(diagnose));

		// % protected region % [Add any additional logic for findByDiagnose before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDiagnose before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Plan.
	 *
	 * @param plan the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Plan
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findByPlan(String plan)
	// % protected region % [Add any throwables, implementations, or extensions for findByPlan here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPlan here] end
	{
		// % protected region % [Add any additional logic for findByPlan before the main body here] off begin
		// % protected region % [Add any additional logic for findByPlan before the main body here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findByPlan(plan));

		// % protected region % [Add any additional logic for findByPlan before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPlan before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Instruction.
	 *
	 * @param instruction the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Instruction
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findByInstruction(String instruction)
	// % protected region % [Add any throwables, implementations, or extensions for findByInstruction here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByInstruction here] end
	{
		// % protected region % [Add any additional logic for findByInstruction before the main body here] off begin
		// % protected region % [Add any additional logic for findByInstruction before the main body here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findByInstruction(instruction));

		// % protected region % [Add any additional logic for findByInstruction before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByInstruction before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Verified Date.
	 *
	 * @param verifiedDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Verified Date
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findByVerifiedDate(OffsetDateTime verifiedDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByVerifiedDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVerifiedDate here] end
	{
		// % protected region % [Add any additional logic for findByVerifiedDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByVerifiedDate before the main body here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findByVerifiedDate(verifiedDate));

		// % protected region % [Add any additional logic for findByVerifiedDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVerifiedDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Verified By.
	 *
	 * @param verifiedBy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Verified By
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findByVerifiedBy(String verifiedBy)
	// % protected region % [Add any throwables, implementations, or extensions for findByVerifiedBy here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVerifiedBy here] end
	{
		// % protected region % [Add any additional logic for findByVerifiedBy before the main body here] off begin
		// % protected region % [Add any additional logic for findByVerifiedBy before the main body here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findByVerifiedBy(verifiedBy));

		// % protected region % [Add any additional logic for findByVerifiedBy before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVerifiedBy before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Canceled Date.
	 *
	 * @param canceledDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Canceled Date
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findByCanceledDate(OffsetDateTime canceledDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByCanceledDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCanceledDate here] end
	{
		// % protected region % [Add any additional logic for findByCanceledDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByCanceledDate before the main body here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findByCanceledDate(canceledDate));

		// % protected region % [Add any additional logic for findByCanceledDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCanceledDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Canceled By.
	 *
	 * @param canceledBy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Canceled By
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findByCanceledBy(String canceledBy)
	// % protected region % [Add any throwables, implementations, or extensions for findByCanceledBy here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCanceledBy here] end
	{
		// % protected region % [Add any additional logic for findByCanceledBy before the main body here] off begin
		// % protected region % [Add any additional logic for findByCanceledBy before the main body here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findByCanceledBy(canceledBy));

		// % protected region % [Add any additional logic for findByCanceledBy before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCanceledBy before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Status.
	 *
	 * @param status the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Status
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findByStatus(String status)
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStatus here] end
	{
		// % protected region % [Add any additional logic for findByStatus before the main body here] off begin
		// % protected region % [Add any additional logic for findByStatus before the main body here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findByStatus(status));

		// % protected region % [Add any additional logic for findByStatus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStatus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute CPPT Date Time.
	 *
	 * @param cpptDateTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute CPPT Date Time
	 */
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findByCpptDateTime(OffsetDateTime cpptDateTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByCpptDateTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCpptDateTime here] end
	{
		// % protected region % [Add any additional logic for findByCpptDateTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByCpptDateTime before the main body here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findByCpptDateTime(cpptDateTime));

		// % protected region % [Add any additional logic for findByCpptDateTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCpptDateTime before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<DailyCareCPPTEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<DailyCareCPPTEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<DailyCareCPPTEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'create')")
	public DailyCareCPPTEntity create(DailyCareCPPTEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		DailyCareCPPTEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'create')")
	public DailyCareCPPTEntity create(DailyCareCPPTEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		DailyCareCPPTEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		DailyCareCPPTEntity newEntity;

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
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'create')")
	public List<DailyCareCPPTEntity> createAll(Iterable<DailyCareCPPTEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<DailyCareCPPTEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<DailyCareCPPTEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'update')")
	public DailyCareCPPTEntity update(DailyCareCPPTEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		DailyCareCPPTEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'update')")
	public DailyCareCPPTEntity update(DailyCareCPPTEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		DailyCareCPPTEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		DailyCareCPPTEntity newEntity;

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
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'update')")
	public List<DailyCareCPPTEntity> updateAll(Iterable<DailyCareCPPTEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<DailyCareCPPTEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<DailyCareCPPTEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'create') or hasPermission('DailyCareCPPTEntity', 'update')")
	public DailyCareCPPTEntity save(DailyCareCPPTEntity entity) throws ConstraintViolationException
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

		DailyCareCPPTEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'create') or hasPermission('DailyCareCPPTEntity', 'update')")
	public List<DailyCareCPPTEntity> saveAll(Iterable<DailyCareCPPTEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<DailyCareCPPTEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'delete')")
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
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'delete')")
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
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	public List<DailyCareCPPTEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	public List<DailyCareCPPTEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(DailyCareCPPTEntity.class);

		// % protected region % [Add any additional processing before converting to a list of DailyCareCPPTEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of DailyCareCPPTEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<DailyCareCPPTEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of DailyCareCPPTEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of DailyCareCPPTEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(DailyCareCPPTEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of DailyCareCPPTEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of DailyCareCPPTEntityAudits
	 */
	private List<DailyCareCPPTEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<DailyCareCPPTEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param dailyCareCPPT dailyCareCPPT to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private DailyCareCPPTEntity updateAuditData(DailyCareCPPTEntity dailyCareCPPT)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return dailyCareCPPT;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private DailyCareCPPTEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		DailyCareCPPTEntity entityAtRevision = updateAuditData((DailyCareCPPTEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new DailyCareCPPTEntityAudit(
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

		QDailyCareCPPTEntity entity = QDailyCareCPPTEntity.dailyCareCPPTEntity;

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
			case "icd10Id":
				// % protected region % [Add any additional logic before the query parameters of relation from ICD 10 to CPPT ICD 10 here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from ICD 10 to CPPT ICD 10 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.icd10.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from ICD 10 to CPPT ICD 10 here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from ICD 10 to CPPT ICD 10 here] end

				break;
			case "icd9CMId":
				// % protected region % [Add any additional logic before the query parameters of relation from ICD 9 CM to CPPT ICD 9 CM here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from ICD 9 CM to CPPT ICD 9 CM here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.icd9CM.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from ICD 9 CM to CPPT ICD 9 CM here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from ICD 9 CM to CPPT ICD 9 CM here] end

				break;
			case "createdByStaffId":
				// % protected region % [Add any additional logic before the query parameters of relation from Created By Staff to Daily Care CPPTs Created By Staff here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Created By Staff to Daily Care CPPTs Created By Staff here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.createdByStaff.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Created By Staff to Daily Care CPPTs Created By Staff here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Created By Staff to Daily Care CPPTs Created By Staff here] end

				break;
			case "doctorInChargeId":
				// % protected region % [Add any additional logic before the query parameters of relation from Doctor in Charge to Daily Care CPPTs Doctor in Charge here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Doctor in Charge to Daily Care CPPTs Doctor in Charge here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.doctorInCharge.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Doctor in Charge to Daily Care CPPTs Doctor in Charge here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Doctor in Charge to Daily Care CPPTs Doctor in Charge here] end

				break;
			case "medicalTranscriberId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Transcriber to Daily Care CPPTs Medical Transcriber here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Transcriber to Daily Care CPPTs Medical Transcriber here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalTranscriber.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Transcriber to Daily Care CPPTs Medical Transcriber here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Transcriber to Daily Care CPPTs Medical Transcriber here] end

				break;
			case "medicalExaminationRecordId":
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Daily Care CPPTs here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Daily Care CPPTs here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Daily Care CPPTs here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Daily Care CPPTs here] end

				break;
			case "subjective":
				// % protected region % [Add any additional logic before the query parameters of subjective here] off begin
				// % protected region % [Add any additional logic before the query parameters of subjective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.subjective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of subjective here] off begin
				// % protected region % [Add any additional logic after the query parameters of subjective here] end

				break;
			case "objective":
				// % protected region % [Add any additional logic before the query parameters of objective here] off begin
				// % protected region % [Add any additional logic before the query parameters of objective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.objective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of objective here] off begin
				// % protected region % [Add any additional logic after the query parameters of objective here] end

				break;
			case "diagnose":
				// % protected region % [Add any additional logic before the query parameters of diagnose here] off begin
				// % protected region % [Add any additional logic before the query parameters of diagnose here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.diagnose, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of diagnose here] off begin
				// % protected region % [Add any additional logic after the query parameters of diagnose here] end

				break;
			case "plan":
				// % protected region % [Add any additional logic before the query parameters of plan here] off begin
				// % protected region % [Add any additional logic before the query parameters of plan here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.plan, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of plan here] off begin
				// % protected region % [Add any additional logic after the query parameters of plan here] end

				break;
			case "instruction":
				// % protected region % [Add any additional logic before the query parameters of instruction here] off begin
				// % protected region % [Add any additional logic before the query parameters of instruction here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.instruction, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of instruction here] off begin
				// % protected region % [Add any additional logic after the query parameters of instruction here] end

				break;
			case "verifiedBy":
				// % protected region % [Add any additional logic before the query parameters of verifiedBy here] off begin
				// % protected region % [Add any additional logic before the query parameters of verifiedBy here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.verifiedBy, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of verifiedBy here] off begin
				// % protected region % [Add any additional logic after the query parameters of verifiedBy here] end

				break;
			case "canceledBy":
				// % protected region % [Add any additional logic before the query parameters of canceledBy here] off begin
				// % protected region % [Add any additional logic before the query parameters of canceledBy here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.canceledBy, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of canceledBy here] off begin
				// % protected region % [Add any additional logic after the query parameters of canceledBy here] end

				break;
			case "status":
				// % protected region % [Add any additional logic before the query parameters of status here] off begin
				// % protected region % [Add any additional logic before the query parameters of status here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.status, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of status here] off begin
				// % protected region % [Add any additional logic after the query parameters of status here] end

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
	public DailyCareCPPTEntity updateOldData(DailyCareCPPTEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public DailyCareCPPTEntity updateOldData(DailyCareCPPTEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		DailyCareCPPTEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInDailyCareCPPTEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to Many reference
		if (entity.getIcd10() == null && entity.getIcd10Id() == null) {
			entityToUpdate.unsetIcd10();
		} else if (entity.getIcd10Id() != null && entity.getIcd10() == null) {
			Optional<DiagnosesAndProceduresEntity> icd10Entity = this.diagnosesAndProceduresRepository.findById(entity.getIcd10Id());
			entityToUpdate.setIcd10(icd10Entity.orElseThrow());
		}
		if (persistRelations && entity.getIcd10() != null) {
			entityToUpdate.setIcd10(entity.getIcd10(), false);
			if (entityToUpdate.getIcd10Id() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getIcd10());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getIcd10().unsetCpptICD10();
			}
		}

		// Incoming One to Many reference
		if (entity.getIcd9CM() == null && entity.getIcd9CMId() == null) {
			entityToUpdate.unsetIcd9CM();
		} else if (entity.getIcd9CMId() != null && entity.getIcd9CM() == null) {
			Optional<DiagnosesAndProceduresEntity> icd9CMEntity = this.diagnosesAndProceduresRepository.findById(entity.getIcd9CMId());
			entityToUpdate.setIcd9CM(icd9CMEntity.orElseThrow());
		}
		if (persistRelations && entity.getIcd9CM() != null) {
			entityToUpdate.setIcd9CM(entity.getIcd9CM(), false);
			if (entityToUpdate.getIcd9CMId() != null) {
				this.diagnosesAndProceduresRepository.save(entityToUpdate.getIcd9CM());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getIcd9CM().unsetCpptICD9CM();
			}
		}

		// Incoming One to Many reference
		if (entity.getCreatedByStaff() == null && entity.getCreatedByStaffId() == null) {
			entityToUpdate.unsetCreatedByStaff();
		} else if (entity.getCreatedByStaffId() != null && entity.getCreatedByStaff() == null) {
			Optional<StaffEntity> createdByStaffEntity = this.staffRepository.findById(entity.getCreatedByStaffId());
			entityToUpdate.setCreatedByStaff(createdByStaffEntity.orElseThrow());
		}
		if (persistRelations && entity.getCreatedByStaff() != null) {
			entityToUpdate.setCreatedByStaff(entity.getCreatedByStaff(), false);
			if (entityToUpdate.getCreatedByStaffId() != null) {
				this.staffRepository.save(entityToUpdate.getCreatedByStaff());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getCreatedByStaff().unsetDailyCareCPPTsCreatedByStaff();
			}
		}

		// Incoming One to Many reference
		if (entity.getDoctorInCharge() == null && entity.getDoctorInChargeId() == null) {
			entityToUpdate.unsetDoctorInCharge();
		} else if (entity.getDoctorInChargeId() != null && entity.getDoctorInCharge() == null) {
			Optional<StaffEntity> doctorInChargeEntity = this.staffRepository.findById(entity.getDoctorInChargeId());
			entityToUpdate.setDoctorInCharge(doctorInChargeEntity.orElseThrow());
		}
		if (persistRelations && entity.getDoctorInCharge() != null) {
			entityToUpdate.setDoctorInCharge(entity.getDoctorInCharge(), false);
			if (entityToUpdate.getDoctorInChargeId() != null) {
				this.staffRepository.save(entityToUpdate.getDoctorInCharge());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getDoctorInCharge().unsetDailyCareCPPTsDoctorInCharge();
			}
		}

		// Incoming One to Many reference
		if (entity.getMedicalTranscriber() == null && entity.getMedicalTranscriberId() == null) {
			entityToUpdate.unsetMedicalTranscriber();
		} else if (entity.getMedicalTranscriberId() != null && entity.getMedicalTranscriber() == null) {
			Optional<StaffEntity> medicalTranscriberEntity = this.staffRepository.findById(entity.getMedicalTranscriberId());
			entityToUpdate.setMedicalTranscriber(medicalTranscriberEntity.orElseThrow());
		}
		if (persistRelations && entity.getMedicalTranscriber() != null) {
			entityToUpdate.setMedicalTranscriber(entity.getMedicalTranscriber(), false);
			if (entityToUpdate.getMedicalTranscriberId() != null) {
				this.staffRepository.save(entityToUpdate.getMedicalTranscriber());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMedicalTranscriber().unsetDailyCareCPPTsMedicalTranscriber();
			}
		}

		// Incoming One to Many reference
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
				entityToUpdate.getMedicalExaminationRecord().unsetDailyCareCPPTs();
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
	public void validateEntity(DailyCareCPPTEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<DailyCareCPPTEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the DailyCareCPPTEntity.
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

	public Set<String> validateEntityRelations(DailyCareCPPTEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getIcd10Id() != null && this.diagnosesAndProceduresRepository.findById(entity.getIcd10Id()).isEmpty()) {
			errors.add("The UUID " + entity.getIcd10Id() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getIcd9CMId() != null && this.diagnosesAndProceduresRepository.findById(entity.getIcd9CMId()).isEmpty()) {
			errors.add("The UUID " + entity.getIcd9CMId() + " is not associated with a Diagnoses and Procedures Entity");
		}

		if (entity.getCreatedByStaffId() != null && this.staffRepository.findById(entity.getCreatedByStaffId()).isEmpty()) {
			errors.add("The UUID " + entity.getCreatedByStaffId() + " is not associated with a Staff Entity");
		}

		if (entity.getDoctorInChargeId() != null && this.staffRepository.findById(entity.getDoctorInChargeId()).isEmpty()) {
			errors.add("The UUID " + entity.getDoctorInChargeId() + " is not associated with a Staff Entity");
		}

		if (entity.getMedicalTranscriberId() != null && this.staffRepository.findById(entity.getMedicalTranscriberId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalTranscriberId() + " is not associated with a Staff Entity");
		}

		if (entity.getMedicalExaminationRecordId() != null && this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalExaminationRecordId() + " is not associated with a Medical Examination Record Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
