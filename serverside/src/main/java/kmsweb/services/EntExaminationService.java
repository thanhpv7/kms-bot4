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
import kmsweb.repositories.EntExaminationRepository;
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
public class EntExaminationService extends AbstractService<EntExaminationEntity, EntExaminationRepository, EntExaminationEntityAudit> {

	private final String[] referenceNamesInEntExaminationEntity = {
		"medicalExaminationRecord",
	};

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public EntExaminationService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		EntExaminationRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

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
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
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
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Right External Ear Subjective.
	 *
	 * @param rightExternalEarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right External Ear Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightExternalEarSubjective(String rightExternalEarSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightExternalEarSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightExternalEarSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightExternalEarSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightExternalEarSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightExternalEarSubjective(rightExternalEarSubjective));

		// % protected region % [Add any additional logic for findByRightExternalEarSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightExternalEarSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right External Ear Objective.
	 *
	 * @param rightExternalEarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right External Ear Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightExternalEarObjective(String rightExternalEarObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightExternalEarObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightExternalEarObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightExternalEarObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightExternalEarObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightExternalEarObjective(rightExternalEarObjective));

		// % protected region % [Add any additional logic for findByRightExternalEarObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightExternalEarObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Concha Subjective.
	 *
	 * @param rightConchaSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Concha Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightConchaSubjective(String rightConchaSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightConchaSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightConchaSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightConchaSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightConchaSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightConchaSubjective(rightConchaSubjective));

		// % protected region % [Add any additional logic for findByRightConchaSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightConchaSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Concha Objective.
	 *
	 * @param rightConchaObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Concha Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightConchaObjective(String rightConchaObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightConchaObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightConchaObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightConchaObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightConchaObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightConchaObjective(rightConchaObjective));

		// % protected region % [Add any additional logic for findByRightConchaObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightConchaObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Earlobe Subjective.
	 *
	 * @param rightEarlobeSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Earlobe Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightEarlobeSubjective(String rightEarlobeSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEarlobeSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEarlobeSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightEarlobeSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightEarlobeSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightEarlobeSubjective(rightEarlobeSubjective));

		// % protected region % [Add any additional logic for findByRightEarlobeSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightEarlobeSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Earlobe Objective.
	 *
	 * @param rightEarlobeObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Earlobe Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightEarlobeObjective(String rightEarlobeObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEarlobeObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEarlobeObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightEarlobeObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightEarlobeObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightEarlobeObjective(rightEarlobeObjective));

		// % protected region % [Add any additional logic for findByRightEarlobeObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightEarlobeObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Ear Canal Subjective.
	 *
	 * @param rightEarCanalSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ear Canal Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightEarCanalSubjective(String rightEarCanalSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEarCanalSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEarCanalSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightEarCanalSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightEarCanalSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightEarCanalSubjective(rightEarCanalSubjective));

		// % protected region % [Add any additional logic for findByRightEarCanalSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightEarCanalSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Ear Canal Objective.
	 *
	 * @param rightEarCanalObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ear Canal Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightEarCanalObjective(String rightEarCanalObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEarCanalObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEarCanalObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightEarCanalObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightEarCanalObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightEarCanalObjective(rightEarCanalObjective));

		// % protected region % [Add any additional logic for findByRightEarCanalObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightEarCanalObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Eardrum Subjective.
	 *
	 * @param rightEardrumSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Eardrum Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightEardrumSubjective(String rightEardrumSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEardrumSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEardrumSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightEardrumSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightEardrumSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightEardrumSubjective(rightEardrumSubjective));

		// % protected region % [Add any additional logic for findByRightEardrumSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightEardrumSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Eardrum Objective.
	 *
	 * @param rightEardrumObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Eardrum Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightEardrumObjective(String rightEardrumObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEardrumObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEardrumObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightEardrumObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightEardrumObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightEardrumObjective(rightEardrumObjective));

		// % protected region % [Add any additional logic for findByRightEardrumObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightEardrumObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left External Ear Subjective.
	 *
	 * @param leftExternalEarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left External Ear Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftExternalEarSubjective(String leftExternalEarSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftExternalEarSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftExternalEarSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftExternalEarSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftExternalEarSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftExternalEarSubjective(leftExternalEarSubjective));

		// % protected region % [Add any additional logic for findByLeftExternalEarSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftExternalEarSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left External Ear Objective.
	 *
	 * @param leftExternalEarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left External Ear Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftExternalEarObjective(String leftExternalEarObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftExternalEarObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftExternalEarObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftExternalEarObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftExternalEarObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftExternalEarObjective(leftExternalEarObjective));

		// % protected region % [Add any additional logic for findByLeftExternalEarObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftExternalEarObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Concha Subjective.
	 *
	 * @param leftConchaSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Concha Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftConchaSubjective(String leftConchaSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftConchaSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftConchaSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftConchaSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftConchaSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftConchaSubjective(leftConchaSubjective));

		// % protected region % [Add any additional logic for findByLeftConchaSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftConchaSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Concha Objective.
	 *
	 * @param leftConchaObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Concha Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftConchaObjective(String leftConchaObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftConchaObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftConchaObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftConchaObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftConchaObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftConchaObjective(leftConchaObjective));

		// % protected region % [Add any additional logic for findByLeftConchaObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftConchaObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Earlobe Subjective.
	 *
	 * @param leftEarlobeSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Earlobe Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftEarlobeSubjective(String leftEarlobeSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEarlobeSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEarlobeSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftEarlobeSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftEarlobeSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftEarlobeSubjective(leftEarlobeSubjective));

		// % protected region % [Add any additional logic for findByLeftEarlobeSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftEarlobeSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Earlobe Objective.
	 *
	 * @param leftEarlobeObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Earlobe Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftEarlobeObjective(String leftEarlobeObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEarlobeObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEarlobeObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftEarlobeObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftEarlobeObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftEarlobeObjective(leftEarlobeObjective));

		// % protected region % [Add any additional logic for findByLeftEarlobeObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftEarlobeObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Ear Canal Subjective.
	 *
	 * @param leftEarCanalSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ear Canal Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftEarCanalSubjective(String leftEarCanalSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEarCanalSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEarCanalSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftEarCanalSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftEarCanalSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftEarCanalSubjective(leftEarCanalSubjective));

		// % protected region % [Add any additional logic for findByLeftEarCanalSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftEarCanalSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Ear Canal Objective.
	 *
	 * @param leftEarCanalObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ear Canal Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftEarCanalObjective(String leftEarCanalObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEarCanalObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEarCanalObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftEarCanalObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftEarCanalObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftEarCanalObjective(leftEarCanalObjective));

		// % protected region % [Add any additional logic for findByLeftEarCanalObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftEarCanalObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Eardrum Subjective.
	 *
	 * @param leftEardrumSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Eardrum Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftEardrumSubjective(String leftEardrumSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEardrumSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEardrumSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftEardrumSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftEardrumSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftEardrumSubjective(leftEardrumSubjective));

		// % protected region % [Add any additional logic for findByLeftEardrumSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftEardrumSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Eardrum Objective.
	 *
	 * @param leftEardrumObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Eardrum Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftEardrumObjective(String leftEardrumObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEardrumObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEardrumObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftEardrumObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftEardrumObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftEardrumObjective(leftEardrumObjective));

		// % protected region % [Add any additional logic for findByLeftEardrumObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftEardrumObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Nasal Bone Subjective.
	 *
	 * @param nasalBoneSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nasal Bone Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByNasalBoneSubjective(String nasalBoneSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByNasalBoneSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNasalBoneSubjective here] end
	{
		// % protected region % [Add any additional logic for findByNasalBoneSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByNasalBoneSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByNasalBoneSubjective(nasalBoneSubjective));

		// % protected region % [Add any additional logic for findByNasalBoneSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNasalBoneSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Nasal Bone Objective.
	 *
	 * @param nasalBoneObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nasal Bone Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByNasalBoneObjective(String nasalBoneObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByNasalBoneObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNasalBoneObjective here] end
	{
		// % protected region % [Add any additional logic for findByNasalBoneObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByNasalBoneObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByNasalBoneObjective(nasalBoneObjective));

		// % protected region % [Add any additional logic for findByNasalBoneObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNasalBoneObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Frontal Sinus Subjective.
	 *
	 * @param rightFrontalSinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Frontal Sinus Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightFrontalSinusSubjective(String rightFrontalSinusSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightFrontalSinusSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightFrontalSinusSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightFrontalSinusSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightFrontalSinusSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightFrontalSinusSubjective(rightFrontalSinusSubjective));

		// % protected region % [Add any additional logic for findByRightFrontalSinusSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightFrontalSinusSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Frontal Sinus Objective.
	 *
	 * @param rightFrontalSinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Frontal Sinus Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightFrontalSinusObjective(String rightFrontalSinusObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightFrontalSinusObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightFrontalSinusObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightFrontalSinusObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightFrontalSinusObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightFrontalSinusObjective(rightFrontalSinusObjective));

		// % protected region % [Add any additional logic for findByRightFrontalSinusObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightFrontalSinusObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Ethmoid Sinus Subjective.
	 *
	 * @param rightEthmoidSinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ethmoid Sinus Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightEthmoidSinusSubjective(String rightEthmoidSinusSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEthmoidSinusSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEthmoidSinusSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightEthmoidSinusSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightEthmoidSinusSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightEthmoidSinusSubjective(rightEthmoidSinusSubjective));

		// % protected region % [Add any additional logic for findByRightEthmoidSinusSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightEthmoidSinusSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Ethmoid Sinus Objective.
	 *
	 * @param rightEthmoidSinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ethmoid Sinus Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightEthmoidSinusObjective(String rightEthmoidSinusObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEthmoidSinusObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightEthmoidSinusObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightEthmoidSinusObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightEthmoidSinusObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightEthmoidSinusObjective(rightEthmoidSinusObjective));

		// % protected region % [Add any additional logic for findByRightEthmoidSinusObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightEthmoidSinusObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Superior Turbinate Subjective.
	 *
	 * @param rightSuperiorTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Superior Turbinate Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightSuperiorTurbinateSubjective(String rightSuperiorTurbinateSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightSuperiorTurbinateSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightSuperiorTurbinateSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightSuperiorTurbinateSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightSuperiorTurbinateSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightSuperiorTurbinateSubjective(rightSuperiorTurbinateSubjective));

		// % protected region % [Add any additional logic for findByRightSuperiorTurbinateSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightSuperiorTurbinateSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Superior Turbinate Objective.
	 *
	 * @param rightSuperiorTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Superior Turbinate Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightSuperiorTurbinateObjective(String rightSuperiorTurbinateObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightSuperiorTurbinateObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightSuperiorTurbinateObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightSuperiorTurbinateObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightSuperiorTurbinateObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightSuperiorTurbinateObjective(rightSuperiorTurbinateObjective));

		// % protected region % [Add any additional logic for findByRightSuperiorTurbinateObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightSuperiorTurbinateObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Middle Turbinate Subjective.
	 *
	 * @param rightMiddleTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Middle Turbinate Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightMiddleTurbinateSubjective(String rightMiddleTurbinateSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightMiddleTurbinateSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightMiddleTurbinateSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightMiddleTurbinateSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightMiddleTurbinateSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightMiddleTurbinateSubjective(rightMiddleTurbinateSubjective));

		// % protected region % [Add any additional logic for findByRightMiddleTurbinateSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightMiddleTurbinateSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Middle Turbinate Objective.
	 *
	 * @param rightMiddleTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Middle Turbinate Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightMiddleTurbinateObjective(String rightMiddleTurbinateObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightMiddleTurbinateObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightMiddleTurbinateObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightMiddleTurbinateObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightMiddleTurbinateObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightMiddleTurbinateObjective(rightMiddleTurbinateObjective));

		// % protected region % [Add any additional logic for findByRightMiddleTurbinateObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightMiddleTurbinateObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Maxillary Sinus Subjective.
	 *
	 * @param rightMaxillarySinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Maxillary Sinus Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightMaxillarySinusSubjective(String rightMaxillarySinusSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightMaxillarySinusSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightMaxillarySinusSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightMaxillarySinusSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightMaxillarySinusSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightMaxillarySinusSubjective(rightMaxillarySinusSubjective));

		// % protected region % [Add any additional logic for findByRightMaxillarySinusSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightMaxillarySinusSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Maxillary Sinus Objective.
	 *
	 * @param rightMaxillarySinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Maxillary Sinus Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightMaxillarySinusObjective(String rightMaxillarySinusObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightMaxillarySinusObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightMaxillarySinusObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightMaxillarySinusObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightMaxillarySinusObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightMaxillarySinusObjective(rightMaxillarySinusObjective));

		// % protected region % [Add any additional logic for findByRightMaxillarySinusObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightMaxillarySinusObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Nasal Cavity Subjective.
	 *
	 * @param rightNasalCavitySubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Nasal Cavity Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightNasalCavitySubjective(String rightNasalCavitySubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightNasalCavitySubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightNasalCavitySubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightNasalCavitySubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightNasalCavitySubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightNasalCavitySubjective(rightNasalCavitySubjective));

		// % protected region % [Add any additional logic for findByRightNasalCavitySubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightNasalCavitySubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Nasal Cavity Objective.
	 *
	 * @param rightNasalCavityObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Nasal Cavity Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightNasalCavityObjective(String rightNasalCavityObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightNasalCavityObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightNasalCavityObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightNasalCavityObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightNasalCavityObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightNasalCavityObjective(rightNasalCavityObjective));

		// % protected region % [Add any additional logic for findByRightNasalCavityObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightNasalCavityObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Inferior Turbinate Subjective.
	 *
	 * @param rightInferiorTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Inferior Turbinate Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightInferiorTurbinateSubjective(String rightInferiorTurbinateSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightInferiorTurbinateSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightInferiorTurbinateSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightInferiorTurbinateSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightInferiorTurbinateSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightInferiorTurbinateSubjective(rightInferiorTurbinateSubjective));

		// % protected region % [Add any additional logic for findByRightInferiorTurbinateSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightInferiorTurbinateSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Inferior Turbinate Objective.
	 *
	 * @param rightInferiorTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Inferior Turbinate Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightInferiorTurbinateObjective(String rightInferiorTurbinateObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightInferiorTurbinateObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightInferiorTurbinateObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightInferiorTurbinateObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightInferiorTurbinateObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightInferiorTurbinateObjective(rightInferiorTurbinateObjective));

		// % protected region % [Add any additional logic for findByRightInferiorTurbinateObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightInferiorTurbinateObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Frontal Sinus Subjective.
	 *
	 * @param leftFrontalSinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Frontal Sinus Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftFrontalSinusSubjective(String leftFrontalSinusSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftFrontalSinusSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftFrontalSinusSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftFrontalSinusSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftFrontalSinusSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftFrontalSinusSubjective(leftFrontalSinusSubjective));

		// % protected region % [Add any additional logic for findByLeftFrontalSinusSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftFrontalSinusSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Frontal Sinus Objective.
	 *
	 * @param leftFrontalSinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Frontal Sinus Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftFrontalSinusObjective(String leftFrontalSinusObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftFrontalSinusObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftFrontalSinusObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftFrontalSinusObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftFrontalSinusObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftFrontalSinusObjective(leftFrontalSinusObjective));

		// % protected region % [Add any additional logic for findByLeftFrontalSinusObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftFrontalSinusObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Ethmoid Sinus Subjective.
	 *
	 * @param leftEthmoidSinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ethmoid Sinus Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftEthmoidSinusSubjective(String leftEthmoidSinusSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEthmoidSinusSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEthmoidSinusSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftEthmoidSinusSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftEthmoidSinusSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftEthmoidSinusSubjective(leftEthmoidSinusSubjective));

		// % protected region % [Add any additional logic for findByLeftEthmoidSinusSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftEthmoidSinusSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Ethmoid Sinus Objective.
	 *
	 * @param leftEthmoidSinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ethmoid Sinus Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftEthmoidSinusObjective(String leftEthmoidSinusObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEthmoidSinusObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftEthmoidSinusObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftEthmoidSinusObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftEthmoidSinusObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftEthmoidSinusObjective(leftEthmoidSinusObjective));

		// % protected region % [Add any additional logic for findByLeftEthmoidSinusObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftEthmoidSinusObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Superior Turbinate Subjective.
	 *
	 * @param leftSuperiorTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Superior Turbinate Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftSuperiorTurbinateSubjective(String leftSuperiorTurbinateSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftSuperiorTurbinateSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftSuperiorTurbinateSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftSuperiorTurbinateSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftSuperiorTurbinateSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftSuperiorTurbinateSubjective(leftSuperiorTurbinateSubjective));

		// % protected region % [Add any additional logic for findByLeftSuperiorTurbinateSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftSuperiorTurbinateSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Superior Turbinate Objective.
	 *
	 * @param leftSuperiorTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Superior Turbinate Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftSuperiorTurbinateObjective(String leftSuperiorTurbinateObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftSuperiorTurbinateObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftSuperiorTurbinateObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftSuperiorTurbinateObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftSuperiorTurbinateObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftSuperiorTurbinateObjective(leftSuperiorTurbinateObjective));

		// % protected region % [Add any additional logic for findByLeftSuperiorTurbinateObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftSuperiorTurbinateObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Middle Turbinate Subjective.
	 *
	 * @param leftMiddleTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Middle Turbinate Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftMiddleTurbinateSubjective(String leftMiddleTurbinateSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftMiddleTurbinateSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftMiddleTurbinateSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftMiddleTurbinateSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftMiddleTurbinateSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftMiddleTurbinateSubjective(leftMiddleTurbinateSubjective));

		// % protected region % [Add any additional logic for findByLeftMiddleTurbinateSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftMiddleTurbinateSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Middle Turbinate Objective.
	 *
	 * @param leftMiddleTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Middle Turbinate Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftMiddleTurbinateObjective(String leftMiddleTurbinateObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftMiddleTurbinateObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftMiddleTurbinateObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftMiddleTurbinateObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftMiddleTurbinateObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftMiddleTurbinateObjective(leftMiddleTurbinateObjective));

		// % protected region % [Add any additional logic for findByLeftMiddleTurbinateObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftMiddleTurbinateObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Maxillary Sinus Subjective.
	 *
	 * @param leftMaxillarySinusSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Maxillary Sinus Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftMaxillarySinusSubjective(String leftMaxillarySinusSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftMaxillarySinusSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftMaxillarySinusSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftMaxillarySinusSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftMaxillarySinusSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftMaxillarySinusSubjective(leftMaxillarySinusSubjective));

		// % protected region % [Add any additional logic for findByLeftMaxillarySinusSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftMaxillarySinusSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Maxillary Sinus Objective.
	 *
	 * @param leftMaxillarySinusObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Maxillary Sinus Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftMaxillarySinusObjective(String leftMaxillarySinusObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftMaxillarySinusObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftMaxillarySinusObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftMaxillarySinusObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftMaxillarySinusObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftMaxillarySinusObjective(leftMaxillarySinusObjective));

		// % protected region % [Add any additional logic for findByLeftMaxillarySinusObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftMaxillarySinusObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Nasal Cavity Subjective.
	 *
	 * @param leftNasalCavitySubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Nasal Cavity Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftNasalCavitySubjective(String leftNasalCavitySubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftNasalCavitySubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftNasalCavitySubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftNasalCavitySubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftNasalCavitySubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftNasalCavitySubjective(leftNasalCavitySubjective));

		// % protected region % [Add any additional logic for findByLeftNasalCavitySubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftNasalCavitySubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Nasal Cavity Objective.
	 *
	 * @param leftNasalCavityObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Nasal Cavity Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftNasalCavityObjective(String leftNasalCavityObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftNasalCavityObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftNasalCavityObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftNasalCavityObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftNasalCavityObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftNasalCavityObjective(leftNasalCavityObjective));

		// % protected region % [Add any additional logic for findByLeftNasalCavityObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftNasalCavityObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Inferior Turbinate Subjective.
	 *
	 * @param leftInferiorTurbinateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Inferior Turbinate Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftInferiorTurbinateSubjective(String leftInferiorTurbinateSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftInferiorTurbinateSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftInferiorTurbinateSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftInferiorTurbinateSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftInferiorTurbinateSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftInferiorTurbinateSubjective(leftInferiorTurbinateSubjective));

		// % protected region % [Add any additional logic for findByLeftInferiorTurbinateSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftInferiorTurbinateSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Inferior Turbinate Objective.
	 *
	 * @param leftInferiorTurbinateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Inferior Turbinate Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftInferiorTurbinateObjective(String leftInferiorTurbinateObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftInferiorTurbinateObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftInferiorTurbinateObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftInferiorTurbinateObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftInferiorTurbinateObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftInferiorTurbinateObjective(leftInferiorTurbinateObjective));

		// % protected region % [Add any additional logic for findByLeftInferiorTurbinateObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftInferiorTurbinateObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lingual Tonsil Subjective.
	 *
	 * @param lingualTonsilSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lingual Tonsil Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLingualTonsilSubjective(String lingualTonsilSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLingualTonsilSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLingualTonsilSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLingualTonsilSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLingualTonsilSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLingualTonsilSubjective(lingualTonsilSubjective));

		// % protected region % [Add any additional logic for findByLingualTonsilSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLingualTonsilSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Lingual Tonsil Objective.
	 *
	 * @param lingualTonsilObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Lingual Tonsil Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLingualTonsilObjective(String lingualTonsilObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLingualTonsilObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLingualTonsilObjective here] end
	{
		// % protected region % [Add any additional logic for findByLingualTonsilObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLingualTonsilObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLingualTonsilObjective(lingualTonsilObjective));

		// % protected region % [Add any additional logic for findByLingualTonsilObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLingualTonsilObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Epiglottis Subjective.
	 *
	 * @param epiglottisSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Epiglottis Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByEpiglottisSubjective(String epiglottisSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByEpiglottisSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEpiglottisSubjective here] end
	{
		// % protected region % [Add any additional logic for findByEpiglottisSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByEpiglottisSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByEpiglottisSubjective(epiglottisSubjective));

		// % protected region % [Add any additional logic for findByEpiglottisSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEpiglottisSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Epiglottis Objective.
	 *
	 * @param epiglottisObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Epiglottis Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByEpiglottisObjective(String epiglottisObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByEpiglottisObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEpiglottisObjective here] end
	{
		// % protected region % [Add any additional logic for findByEpiglottisObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByEpiglottisObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByEpiglottisObjective(epiglottisObjective));

		// % protected region % [Add any additional logic for findByEpiglottisObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEpiglottisObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Vocal Fold Subjective.
	 *
	 * @param rightVocalFoldSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Vocal Fold Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightVocalFoldSubjective(String rightVocalFoldSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightVocalFoldSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightVocalFoldSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightVocalFoldSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightVocalFoldSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightVocalFoldSubjective(rightVocalFoldSubjective));

		// % protected region % [Add any additional logic for findByRightVocalFoldSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightVocalFoldSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Vocal Fold Objective.
	 *
	 * @param rightVocalFoldObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Vocal Fold Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightVocalFoldObjective(String rightVocalFoldObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightVocalFoldObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightVocalFoldObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightVocalFoldObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightVocalFoldObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightVocalFoldObjective(rightVocalFoldObjective));

		// % protected region % [Add any additional logic for findByRightVocalFoldObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightVocalFoldObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Ventricular Fold Subjective.
	 *
	 * @param rightVentricularFoldSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ventricular Fold Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightVentricularFoldSubjective(String rightVentricularFoldSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightVentricularFoldSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightVentricularFoldSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightVentricularFoldSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightVentricularFoldSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightVentricularFoldSubjective(rightVentricularFoldSubjective));

		// % protected region % [Add any additional logic for findByRightVentricularFoldSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightVentricularFoldSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Ventricular Fold Objective.
	 *
	 * @param rightVentricularFoldObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Ventricular Fold Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightVentricularFoldObjective(String rightVentricularFoldObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightVentricularFoldObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightVentricularFoldObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightVentricularFoldObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightVentricularFoldObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightVentricularFoldObjective(rightVentricularFoldObjective));

		// % protected region % [Add any additional logic for findByRightVentricularFoldObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightVentricularFoldObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Glottis Subjective.
	 *
	 * @param glottisSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Glottis Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByGlottisSubjective(String glottisSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByGlottisSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGlottisSubjective here] end
	{
		// % protected region % [Add any additional logic for findByGlottisSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByGlottisSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByGlottisSubjective(glottisSubjective));

		// % protected region % [Add any additional logic for findByGlottisSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGlottisSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Glottis Objective.
	 *
	 * @param glottisObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Glottis Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByGlottisObjective(String glottisObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByGlottisObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGlottisObjective here] end
	{
		// % protected region % [Add any additional logic for findByGlottisObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByGlottisObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByGlottisObjective(glottisObjective));

		// % protected region % [Add any additional logic for findByGlottisObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGlottisObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Cuneiform Cartilage Subjective.
	 *
	 * @param rightCuneiformCartilageSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Cuneiform Cartilage Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightCuneiformCartilageSubjective(String rightCuneiformCartilageSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightCuneiformCartilageSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightCuneiformCartilageSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightCuneiformCartilageSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightCuneiformCartilageSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightCuneiformCartilageSubjective(rightCuneiformCartilageSubjective));

		// % protected region % [Add any additional logic for findByRightCuneiformCartilageSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightCuneiformCartilageSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Cuneiform Cartilage Objective.
	 *
	 * @param rightCuneiformCartilageObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Cuneiform Cartilage Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightCuneiformCartilageObjective(String rightCuneiformCartilageObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightCuneiformCartilageObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightCuneiformCartilageObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightCuneiformCartilageObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightCuneiformCartilageObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightCuneiformCartilageObjective(rightCuneiformCartilageObjective));

		// % protected region % [Add any additional logic for findByRightCuneiformCartilageObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightCuneiformCartilageObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Corniculate Cartilage Subjective.
	 *
	 * @param rightCorniculateCartilageSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Corniculate Cartilage Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightCorniculateCartilageSubjective(String rightCorniculateCartilageSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightCorniculateCartilageSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightCorniculateCartilageSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightCorniculateCartilageSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightCorniculateCartilageSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightCorniculateCartilageSubjective(rightCorniculateCartilageSubjective));

		// % protected region % [Add any additional logic for findByRightCorniculateCartilageSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightCorniculateCartilageSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Corniculate Cartilage Objective.
	 *
	 * @param rightCorniculateCartilageObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Corniculate Cartilage Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightCorniculateCartilageObjective(String rightCorniculateCartilageObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightCorniculateCartilageObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightCorniculateCartilageObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightCorniculateCartilageObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightCorniculateCartilageObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightCorniculateCartilageObjective(rightCorniculateCartilageObjective));

		// % protected region % [Add any additional logic for findByRightCorniculateCartilageObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightCorniculateCartilageObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Trachea Subjective.
	 *
	 * @param tracheaSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Trachea Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByTracheaSubjective(String tracheaSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByTracheaSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTracheaSubjective here] end
	{
		// % protected region % [Add any additional logic for findByTracheaSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByTracheaSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByTracheaSubjective(tracheaSubjective));

		// % protected region % [Add any additional logic for findByTracheaSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTracheaSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Trachea Objective.
	 *
	 * @param tracheaObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Trachea Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByTracheaObjective(String tracheaObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByTracheaObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTracheaObjective here] end
	{
		// % protected region % [Add any additional logic for findByTracheaObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByTracheaObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByTracheaObjective(tracheaObjective));

		// % protected region % [Add any additional logic for findByTracheaObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTracheaObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Vocal Fold Subjective.
	 *
	 * @param leftVocalFoldSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Vocal Fold Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftVocalFoldSubjective(String leftVocalFoldSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftVocalFoldSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftVocalFoldSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftVocalFoldSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftVocalFoldSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftVocalFoldSubjective(leftVocalFoldSubjective));

		// % protected region % [Add any additional logic for findByLeftVocalFoldSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftVocalFoldSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Vocal Fold Objective.
	 *
	 * @param leftVocalFoldObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Vocal Fold Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftVocalFoldObjective(String leftVocalFoldObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftVocalFoldObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftVocalFoldObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftVocalFoldObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftVocalFoldObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftVocalFoldObjective(leftVocalFoldObjective));

		// % protected region % [Add any additional logic for findByLeftVocalFoldObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftVocalFoldObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Ventricular Fold Subjective.
	 *
	 * @param leftVentricularFoldSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ventricular Fold Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftVentricularFoldSubjective(String leftVentricularFoldSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftVentricularFoldSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftVentricularFoldSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftVentricularFoldSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftVentricularFoldSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftVentricularFoldSubjective(leftVentricularFoldSubjective));

		// % protected region % [Add any additional logic for findByLeftVentricularFoldSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftVentricularFoldSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Ventricular Fold Objective.
	 *
	 * @param leftVentricularFoldObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Ventricular Fold Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftVentricularFoldObjective(String leftVentricularFoldObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftVentricularFoldObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftVentricularFoldObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftVentricularFoldObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftVentricularFoldObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftVentricularFoldObjective(leftVentricularFoldObjective));

		// % protected region % [Add any additional logic for findByLeftVentricularFoldObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftVentricularFoldObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Cuneiform Cartilage Subjective.
	 *
	 * @param leftCuneiformCartilageSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Cuneiform Cartilage Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftCuneiformCartilageSubjective(String leftCuneiformCartilageSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftCuneiformCartilageSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftCuneiformCartilageSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftCuneiformCartilageSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftCuneiformCartilageSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftCuneiformCartilageSubjective(leftCuneiformCartilageSubjective));

		// % protected region % [Add any additional logic for findByLeftCuneiformCartilageSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftCuneiformCartilageSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Cuneiform Cartilage Objective.
	 *
	 * @param leftCuneiformCartilageObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Cuneiform Cartilage Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftCuneiformCartilageObjective(String leftCuneiformCartilageObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftCuneiformCartilageObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftCuneiformCartilageObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftCuneiformCartilageObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftCuneiformCartilageObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftCuneiformCartilageObjective(leftCuneiformCartilageObjective));

		// % protected region % [Add any additional logic for findByLeftCuneiformCartilageObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftCuneiformCartilageObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Corniculate Cartilage Subjective.
	 *
	 * @param leftCorniculateCartilageSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Corniculate Cartilage Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftCorniculateCartilageSubjective(String leftCorniculateCartilageSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftCorniculateCartilageSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftCorniculateCartilageSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftCorniculateCartilageSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftCorniculateCartilageSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftCorniculateCartilageSubjective(leftCorniculateCartilageSubjective));

		// % protected region % [Add any additional logic for findByLeftCorniculateCartilageSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftCorniculateCartilageSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Corniculate Cartilage Objective.
	 *
	 * @param leftCorniculateCartilageObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Corniculate Cartilage Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftCorniculateCartilageObjective(String leftCorniculateCartilageObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftCorniculateCartilageObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftCorniculateCartilageObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftCorniculateCartilageObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftCorniculateCartilageObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftCorniculateCartilageObjective(leftCorniculateCartilageObjective));

		// % protected region % [Add any additional logic for findByLeftCorniculateCartilageObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftCorniculateCartilageObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Soft Palate Subjective.
	 *
	 * @param softPalateSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Soft Palate Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findBySoftPalateSubjective(String softPalateSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findBySoftPalateSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySoftPalateSubjective here] end
	{
		// % protected region % [Add any additional logic for findBySoftPalateSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findBySoftPalateSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findBySoftPalateSubjective(softPalateSubjective));

		// % protected region % [Add any additional logic for findBySoftPalateSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySoftPalateSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Soft Palate Objective.
	 *
	 * @param softPalateObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Soft Palate Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findBySoftPalateObjective(String softPalateObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findBySoftPalateObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findBySoftPalateObjective here] end
	{
		// % protected region % [Add any additional logic for findBySoftPalateObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findBySoftPalateObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findBySoftPalateObjective(softPalateObjective));

		// % protected region % [Add any additional logic for findBySoftPalateObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findBySoftPalateObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Anterior Pillar Subjective.
	 *
	 * @param rightAnteriorPillarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Anterior Pillar Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightAnteriorPillarSubjective(String rightAnteriorPillarSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightAnteriorPillarSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightAnteriorPillarSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightAnteriorPillarSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightAnteriorPillarSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightAnteriorPillarSubjective(rightAnteriorPillarSubjective));

		// % protected region % [Add any additional logic for findByRightAnteriorPillarSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightAnteriorPillarSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Anterior Pillar Objective.
	 *
	 * @param rightAnteriorPillarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Anterior Pillar Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightAnteriorPillarObjective(String rightAnteriorPillarObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightAnteriorPillarObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightAnteriorPillarObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightAnteriorPillarObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightAnteriorPillarObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightAnteriorPillarObjective(rightAnteriorPillarObjective));

		// % protected region % [Add any additional logic for findByRightAnteriorPillarObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightAnteriorPillarObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Uvula Subjective.
	 *
	 * @param uvulaSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uvula Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByUvulaSubjective(String uvulaSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByUvulaSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUvulaSubjective here] end
	{
		// % protected region % [Add any additional logic for findByUvulaSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByUvulaSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByUvulaSubjective(uvulaSubjective));

		// % protected region % [Add any additional logic for findByUvulaSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUvulaSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Uvula Objective.
	 *
	 * @param uvulaObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Uvula Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByUvulaObjective(String uvulaObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByUvulaObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUvulaObjective here] end
	{
		// % protected region % [Add any additional logic for findByUvulaObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByUvulaObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByUvulaObjective(uvulaObjective));

		// % protected region % [Add any additional logic for findByUvulaObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUvulaObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Posterior Pillar Subjective.
	 *
	 * @param rightPosteriorPillarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Posterior Pillar Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightPosteriorPillarSubjective(String rightPosteriorPillarSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightPosteriorPillarSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightPosteriorPillarSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightPosteriorPillarSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightPosteriorPillarSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightPosteriorPillarSubjective(rightPosteriorPillarSubjective));

		// % protected region % [Add any additional logic for findByRightPosteriorPillarSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightPosteriorPillarSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Posterior Pillar Objective.
	 *
	 * @param rightPosteriorPillarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Posterior Pillar Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightPosteriorPillarObjective(String rightPosteriorPillarObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightPosteriorPillarObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightPosteriorPillarObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightPosteriorPillarObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightPosteriorPillarObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightPosteriorPillarObjective(rightPosteriorPillarObjective));

		// % protected region % [Add any additional logic for findByRightPosteriorPillarObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightPosteriorPillarObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Tonsil Subjective.
	 *
	 * @param rightTonsilSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Tonsil Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightTonsilSubjective(String rightTonsilSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightTonsilSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightTonsilSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightTonsilSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightTonsilSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightTonsilSubjective(rightTonsilSubjective));

		// % protected region % [Add any additional logic for findByRightTonsilSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightTonsilSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Tonsil Objective.
	 *
	 * @param rightTonsilObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Tonsil Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightTonsilObjective(String rightTonsilObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightTonsilObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightTonsilObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightTonsilObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightTonsilObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightTonsilObjective(rightTonsilObjective));

		// % protected region % [Add any additional logic for findByRightTonsilObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightTonsilObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Posterior Subjective.
	 *
	 * @param rightPosteriorSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Posterior Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightPosteriorSubjective(String rightPosteriorSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightPosteriorSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightPosteriorSubjective here] end
	{
		// % protected region % [Add any additional logic for findByRightPosteriorSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightPosteriorSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightPosteriorSubjective(rightPosteriorSubjective));

		// % protected region % [Add any additional logic for findByRightPosteriorSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightPosteriorSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Right Posterior Objective.
	 *
	 * @param rightPosteriorObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Right Posterior Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByRightPosteriorObjective(String rightPosteriorObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByRightPosteriorObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRightPosteriorObjective here] end
	{
		// % protected region % [Add any additional logic for findByRightPosteriorObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByRightPosteriorObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByRightPosteriorObjective(rightPosteriorObjective));

		// % protected region % [Add any additional logic for findByRightPosteriorObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRightPosteriorObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Upper Tongue Subjective.
	 *
	 * @param upperTongueSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Upper Tongue Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByUpperTongueSubjective(String upperTongueSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByUpperTongueSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUpperTongueSubjective here] end
	{
		// % protected region % [Add any additional logic for findByUpperTongueSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByUpperTongueSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByUpperTongueSubjective(upperTongueSubjective));

		// % protected region % [Add any additional logic for findByUpperTongueSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUpperTongueSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Upper Tongue Objective.
	 *
	 * @param upperTongueObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Upper Tongue Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByUpperTongueObjective(String upperTongueObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByUpperTongueObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUpperTongueObjective here] end
	{
		// % protected region % [Add any additional logic for findByUpperTongueObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByUpperTongueObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByUpperTongueObjective(upperTongueObjective));

		// % protected region % [Add any additional logic for findByUpperTongueObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUpperTongueObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Anterior Pillar Subjective.
	 *
	 * @param leftAnteriorPillarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Anterior Pillar Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftAnteriorPillarSubjective(String leftAnteriorPillarSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftAnteriorPillarSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftAnteriorPillarSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftAnteriorPillarSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftAnteriorPillarSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftAnteriorPillarSubjective(leftAnteriorPillarSubjective));

		// % protected region % [Add any additional logic for findByLeftAnteriorPillarSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftAnteriorPillarSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Anterior Pillar Objective.
	 *
	 * @param leftAnteriorPillarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Anterior Pillar Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftAnteriorPillarObjective(String leftAnteriorPillarObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftAnteriorPillarObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftAnteriorPillarObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftAnteriorPillarObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftAnteriorPillarObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftAnteriorPillarObjective(leftAnteriorPillarObjective));

		// % protected region % [Add any additional logic for findByLeftAnteriorPillarObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftAnteriorPillarObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Posterior Pillar Subjective.
	 *
	 * @param leftPosteriorPillarSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Posterior Pillar Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftPosteriorPillarSubjective(String leftPosteriorPillarSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftPosteriorPillarSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftPosteriorPillarSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftPosteriorPillarSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftPosteriorPillarSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftPosteriorPillarSubjective(leftPosteriorPillarSubjective));

		// % protected region % [Add any additional logic for findByLeftPosteriorPillarSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftPosteriorPillarSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Posterior Pillar Objective.
	 *
	 * @param leftPosteriorPillarObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Posterior Pillar Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftPosteriorPillarObjective(String leftPosteriorPillarObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftPosteriorPillarObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftPosteriorPillarObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftPosteriorPillarObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftPosteriorPillarObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftPosteriorPillarObjective(leftPosteriorPillarObjective));

		// % protected region % [Add any additional logic for findByLeftPosteriorPillarObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftPosteriorPillarObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Tonsil Subjective.
	 *
	 * @param leftTonsilSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Tonsil Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftTonsilSubjective(String leftTonsilSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftTonsilSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftTonsilSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftTonsilSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftTonsilSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftTonsilSubjective(leftTonsilSubjective));

		// % protected region % [Add any additional logic for findByLeftTonsilSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftTonsilSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Tonsil Objective.
	 *
	 * @param leftTonsilObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Tonsil Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftTonsilObjective(String leftTonsilObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftTonsilObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftTonsilObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftTonsilObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftTonsilObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftTonsilObjective(leftTonsilObjective));

		// % protected region % [Add any additional logic for findByLeftTonsilObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftTonsilObjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Posterior Wall Subjective.
	 *
	 * @param leftPosteriorWallSubjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Posterior Wall Subjective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftPosteriorWallSubjective(String leftPosteriorWallSubjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftPosteriorWallSubjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftPosteriorWallSubjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftPosteriorWallSubjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftPosteriorWallSubjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftPosteriorWallSubjective(leftPosteriorWallSubjective));

		// % protected region % [Add any additional logic for findByLeftPosteriorWallSubjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftPosteriorWallSubjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Left Posterior Wall Objective.
	 *
	 * @param leftPosteriorWallObjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Left Posterior Wall Objective
	 */
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findByLeftPosteriorWallObjective(String leftPosteriorWallObjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftPosteriorWallObjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeftPosteriorWallObjective here] end
	{
		// % protected region % [Add any additional logic for findByLeftPosteriorWallObjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeftPosteriorWallObjective before the main body here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findByLeftPosteriorWallObjective(leftPosteriorWallObjective));

		// % protected region % [Add any additional logic for findByLeftPosteriorWallObjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeftPosteriorWallObjective before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<EntExaminationEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<EntExaminationEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<EntExaminationEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<EntExaminationEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<EntExaminationEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('EntExaminationEntity', 'create')")
	public EntExaminationEntity create(EntExaminationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		EntExaminationEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('EntExaminationEntity', 'create')")
	public EntExaminationEntity create(EntExaminationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		EntExaminationEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		EntExaminationEntity newEntity;

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
	@PreAuthorize("hasPermission('EntExaminationEntity', 'create')")
	public List<EntExaminationEntity> createAll(Iterable<EntExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<EntExaminationEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<EntExaminationEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('EntExaminationEntity', 'update')")
	public EntExaminationEntity update(EntExaminationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		EntExaminationEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('EntExaminationEntity', 'update')")
	public EntExaminationEntity update(EntExaminationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		EntExaminationEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		EntExaminationEntity newEntity;

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
	@PreAuthorize("hasPermission('EntExaminationEntity', 'update')")
	public List<EntExaminationEntity> updateAll(Iterable<EntExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<EntExaminationEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<EntExaminationEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('EntExaminationEntity', 'create') or hasPermission('EntExaminationEntity', 'update')")
	public EntExaminationEntity save(EntExaminationEntity entity) throws ConstraintViolationException
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

		EntExaminationEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('EntExaminationEntity', 'create') or hasPermission('EntExaminationEntity', 'update')")
	public List<EntExaminationEntity> saveAll(Iterable<EntExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<EntExaminationEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('EntExaminationEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('EntExaminationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('EntExaminationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	public List<EntExaminationEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	public List<EntExaminationEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<EntExaminationEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(EntExaminationEntity.class);

		// % protected region % [Add any additional processing before converting to a list of EntExaminationEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of EntExaminationEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('EntExaminationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<EntExaminationEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of EntExaminationEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of EntExaminationEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(EntExaminationEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of EntExaminationEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of EntExaminationEntityAudits
	 */
	private List<EntExaminationEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<EntExaminationEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param entExamination entExamination to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private EntExaminationEntity updateAuditData(EntExaminationEntity entExamination)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return entExamination;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private EntExaminationEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		EntExaminationEntity entityAtRevision = updateAuditData((EntExaminationEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new EntExaminationEntityAudit(
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

		QEntExaminationEntity entity = QEntExaminationEntity.entExaminationEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to ENT Examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to ENT Examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to ENT Examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to ENT Examination here] end

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
	public EntExaminationEntity updateOldData(EntExaminationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public EntExaminationEntity updateOldData(EntExaminationEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		EntExaminationEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInEntExaminationEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Incoming One to One reference
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
				entityToUpdate.getMedicalExaminationRecord().unsetEntExamination();
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
	public void validateEntity(EntExaminationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<EntExaminationEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the EntExaminationEntity.
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

	public Set<String> validateEntityRelations(EntExaminationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getMedicalExaminationRecordId() != null && this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalExaminationRecordId() + " is not associated with a Medical Examination Record Entity");
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
