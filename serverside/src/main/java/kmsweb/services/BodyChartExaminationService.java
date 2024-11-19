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
import kmsweb.repositories.BodyChartExaminationRepository;
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
public class BodyChartExaminationService extends AbstractService<BodyChartExaminationEntity, BodyChartExaminationRepository, BodyChartExaminationEntityAudit> {

	private final String[] referenceNamesInBodyChartExaminationEntity = {
		"medicalExaminationRecord",
	};

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public BodyChartExaminationService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		BodyChartExaminationRepository repository
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
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
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
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute BC01 Subjective.
	 *
	 * @param bc01Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC01 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc01Subjective(String bc01Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc01Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc01Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc01Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc01Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc01Subjective(bc01Subjective));

		// % protected region % [Add any additional logic for findByBc01Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc01Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC01 Objective.
	 *
	 * @param bc01Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC01 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc01Objective(String bc01Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc01Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc01Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc01Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc01Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc01Objective(bc01Objective));

		// % protected region % [Add any additional logic for findByBc01Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc01Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC02 Subjective.
	 *
	 * @param bc02Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC02 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc02Subjective(String bc02Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc02Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc02Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc02Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc02Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc02Subjective(bc02Subjective));

		// % protected region % [Add any additional logic for findByBc02Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc02Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC02 Objective.
	 *
	 * @param bc02Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC02 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc02Objective(String bc02Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc02Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc02Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc02Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc02Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc02Objective(bc02Objective));

		// % protected region % [Add any additional logic for findByBc02Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc02Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC03 Subjective.
	 *
	 * @param bc03Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC03 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc03Subjective(String bc03Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc03Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc03Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc03Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc03Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc03Subjective(bc03Subjective));

		// % protected region % [Add any additional logic for findByBc03Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc03Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC03 Objective.
	 *
	 * @param bc03Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC03 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc03Objective(String bc03Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc03Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc03Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc03Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc03Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc03Objective(bc03Objective));

		// % protected region % [Add any additional logic for findByBc03Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc03Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC04 Subjective.
	 *
	 * @param bc04Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC04 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc04Subjective(String bc04Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc04Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc04Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc04Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc04Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc04Subjective(bc04Subjective));

		// % protected region % [Add any additional logic for findByBc04Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc04Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC04 Objective.
	 *
	 * @param bc04Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC04 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc04Objective(String bc04Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc04Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc04Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc04Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc04Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc04Objective(bc04Objective));

		// % protected region % [Add any additional logic for findByBc04Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc04Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC05 Subjective.
	 *
	 * @param bc05Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC05 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc05Subjective(String bc05Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc05Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc05Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc05Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc05Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc05Subjective(bc05Subjective));

		// % protected region % [Add any additional logic for findByBc05Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc05Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC05 Objective.
	 *
	 * @param bc05Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC05 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc05Objective(String bc05Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc05Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc05Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc05Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc05Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc05Objective(bc05Objective));

		// % protected region % [Add any additional logic for findByBc05Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc05Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC06 Subjective.
	 *
	 * @param bc06Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC06 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc06Subjective(String bc06Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc06Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc06Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc06Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc06Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc06Subjective(bc06Subjective));

		// % protected region % [Add any additional logic for findByBc06Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc06Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC06 Objective.
	 *
	 * @param bc06Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC06 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc06Objective(String bc06Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc06Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc06Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc06Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc06Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc06Objective(bc06Objective));

		// % protected region % [Add any additional logic for findByBc06Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc06Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC07 Subjective.
	 *
	 * @param bc07Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC07 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc07Subjective(String bc07Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc07Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc07Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc07Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc07Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc07Subjective(bc07Subjective));

		// % protected region % [Add any additional logic for findByBc07Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc07Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC07 Objective.
	 *
	 * @param bc07Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC07 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc07Objective(String bc07Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc07Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc07Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc07Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc07Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc07Objective(bc07Objective));

		// % protected region % [Add any additional logic for findByBc07Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc07Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC08 Subjective.
	 *
	 * @param bc08Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC08 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc08Subjective(String bc08Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc08Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc08Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc08Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc08Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc08Subjective(bc08Subjective));

		// % protected region % [Add any additional logic for findByBc08Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc08Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC08 Objective.
	 *
	 * @param bc08Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC08 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc08Objective(String bc08Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc08Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc08Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc08Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc08Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc08Objective(bc08Objective));

		// % protected region % [Add any additional logic for findByBc08Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc08Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC09 Subjective.
	 *
	 * @param bc09Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC09 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc09Subjective(String bc09Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc09Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc09Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc09Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc09Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc09Subjective(bc09Subjective));

		// % protected region % [Add any additional logic for findByBc09Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc09Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC09 Objective.
	 *
	 * @param bc09Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC09 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc09Objective(String bc09Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc09Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc09Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc09Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc09Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc09Objective(bc09Objective));

		// % protected region % [Add any additional logic for findByBc09Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc09Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC10 Subjective.
	 *
	 * @param bc10Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC10 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc10Subjective(String bc10Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc10Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc10Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc10Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc10Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc10Subjective(bc10Subjective));

		// % protected region % [Add any additional logic for findByBc10Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc10Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC10 Objective.
	 *
	 * @param bc10Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC10 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc10Objective(String bc10Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc10Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc10Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc10Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc10Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc10Objective(bc10Objective));

		// % protected region % [Add any additional logic for findByBc10Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc10Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC11 Subjective.
	 *
	 * @param bc11Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC11 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc11Subjective(String bc11Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc11Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc11Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc11Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc11Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc11Subjective(bc11Subjective));

		// % protected region % [Add any additional logic for findByBc11Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc11Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC11 Objective.
	 *
	 * @param bc11Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC11 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc11Objective(String bc11Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc11Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc11Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc11Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc11Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc11Objective(bc11Objective));

		// % protected region % [Add any additional logic for findByBc11Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc11Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC12 Subjective.
	 *
	 * @param bc12Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC12 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc12Subjective(String bc12Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc12Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc12Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc12Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc12Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc12Subjective(bc12Subjective));

		// % protected region % [Add any additional logic for findByBc12Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc12Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC12 Objective.
	 *
	 * @param bc12Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC12 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc12Objective(String bc12Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc12Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc12Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc12Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc12Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc12Objective(bc12Objective));

		// % protected region % [Add any additional logic for findByBc12Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc12Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC13 Subjective.
	 *
	 * @param bc13Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC13 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc13Subjective(String bc13Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc13Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc13Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc13Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc13Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc13Subjective(bc13Subjective));

		// % protected region % [Add any additional logic for findByBc13Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc13Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC13 Objective.
	 *
	 * @param bc13Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC13 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc13Objective(String bc13Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc13Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc13Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc13Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc13Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc13Objective(bc13Objective));

		// % protected region % [Add any additional logic for findByBc13Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc13Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC14 Subjective.
	 *
	 * @param bc14Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC14 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc14Subjective(String bc14Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc14Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc14Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc14Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc14Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc14Subjective(bc14Subjective));

		// % protected region % [Add any additional logic for findByBc14Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc14Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC14 Objective.
	 *
	 * @param bc14Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC14 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc14Objective(String bc14Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc14Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc14Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc14Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc14Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc14Objective(bc14Objective));

		// % protected region % [Add any additional logic for findByBc14Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc14Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC15 Subjective.
	 *
	 * @param bc15Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC15 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc15Subjective(String bc15Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc15Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc15Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc15Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc15Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc15Subjective(bc15Subjective));

		// % protected region % [Add any additional logic for findByBc15Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc15Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC15 Objective.
	 *
	 * @param bc15Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC15 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc15Objective(String bc15Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc15Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc15Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc15Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc15Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc15Objective(bc15Objective));

		// % protected region % [Add any additional logic for findByBc15Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc15Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC16 Subjective.
	 *
	 * @param bc16Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC16 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc16Subjective(String bc16Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc16Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc16Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc16Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc16Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc16Subjective(bc16Subjective));

		// % protected region % [Add any additional logic for findByBc16Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc16Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC16 Objective.
	 *
	 * @param bc16Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC16 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc16Objective(String bc16Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc16Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc16Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc16Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc16Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc16Objective(bc16Objective));

		// % protected region % [Add any additional logic for findByBc16Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc16Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC17 Subjective.
	 *
	 * @param bc17Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC17 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc17Subjective(String bc17Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc17Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc17Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc17Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc17Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc17Subjective(bc17Subjective));

		// % protected region % [Add any additional logic for findByBc17Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc17Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC17 Objective.
	 *
	 * @param bc17Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC17 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc17Objective(String bc17Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc17Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc17Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc17Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc17Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc17Objective(bc17Objective));

		// % protected region % [Add any additional logic for findByBc17Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc17Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC18 Subjective.
	 *
	 * @param bc18Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC18 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc18Subjective(String bc18Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc18Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc18Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc18Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc18Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc18Subjective(bc18Subjective));

		// % protected region % [Add any additional logic for findByBc18Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc18Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC18 Objective.
	 *
	 * @param bc18Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC18 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc18Objective(String bc18Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc18Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc18Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc18Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc18Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc18Objective(bc18Objective));

		// % protected region % [Add any additional logic for findByBc18Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc18Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC19 Subjective.
	 *
	 * @param bc19Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC19 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc19Subjective(String bc19Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc19Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc19Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc19Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc19Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc19Subjective(bc19Subjective));

		// % protected region % [Add any additional logic for findByBc19Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc19Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC19 Objective.
	 *
	 * @param bc19Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC19 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc19Objective(String bc19Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc19Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc19Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc19Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc19Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc19Objective(bc19Objective));

		// % protected region % [Add any additional logic for findByBc19Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc19Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC20 Subjective.
	 *
	 * @param bc20Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC20 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc20Subjective(String bc20Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc20Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc20Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc20Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc20Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc20Subjective(bc20Subjective));

		// % protected region % [Add any additional logic for findByBc20Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc20Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC20 Objective.
	 *
	 * @param bc20Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC20 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc20Objective(String bc20Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc20Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc20Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc20Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc20Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc20Objective(bc20Objective));

		// % protected region % [Add any additional logic for findByBc20Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc20Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC21 Subjective.
	 *
	 * @param bc21Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC21 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc21Subjective(String bc21Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc21Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc21Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc21Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc21Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc21Subjective(bc21Subjective));

		// % protected region % [Add any additional logic for findByBc21Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc21Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC21 Objective.
	 *
	 * @param bc21Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC21 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc21Objective(String bc21Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc21Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc21Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc21Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc21Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc21Objective(bc21Objective));

		// % protected region % [Add any additional logic for findByBc21Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc21Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC22 Subjective.
	 *
	 * @param bc22Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC22 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc22Subjective(String bc22Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc22Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc22Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc22Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc22Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc22Subjective(bc22Subjective));

		// % protected region % [Add any additional logic for findByBc22Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc22Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC22 Objective.
	 *
	 * @param bc22Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC22 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc22Objective(String bc22Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc22Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc22Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc22Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc22Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc22Objective(bc22Objective));

		// % protected region % [Add any additional logic for findByBc22Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc22Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC23 Subjective.
	 *
	 * @param bc23Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC23 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc23Subjective(String bc23Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc23Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc23Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc23Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc23Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc23Subjective(bc23Subjective));

		// % protected region % [Add any additional logic for findByBc23Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc23Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC23 Objective.
	 *
	 * @param bc23Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC23 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc23Objective(String bc23Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc23Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc23Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc23Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc23Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc23Objective(bc23Objective));

		// % protected region % [Add any additional logic for findByBc23Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc23Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC24 Subjective.
	 *
	 * @param bc24Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC24 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc24Subjective(String bc24Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc24Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc24Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc24Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc24Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc24Subjective(bc24Subjective));

		// % protected region % [Add any additional logic for findByBc24Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc24Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC24 Objective.
	 *
	 * @param bc24Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC24 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc24Objective(String bc24Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc24Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc24Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc24Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc24Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc24Objective(bc24Objective));

		// % protected region % [Add any additional logic for findByBc24Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc24Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC25 Subjective.
	 *
	 * @param bc25Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC25 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc25Subjective(String bc25Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc25Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc25Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc25Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc25Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc25Subjective(bc25Subjective));

		// % protected region % [Add any additional logic for findByBc25Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc25Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC25 Objective.
	 *
	 * @param bc25Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC25 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc25Objective(String bc25Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc25Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc25Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc25Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc25Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc25Objective(bc25Objective));

		// % protected region % [Add any additional logic for findByBc25Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc25Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC26 Subjective.
	 *
	 * @param bc26Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC26 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc26Subjective(String bc26Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc26Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc26Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc26Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc26Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc26Subjective(bc26Subjective));

		// % protected region % [Add any additional logic for findByBc26Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc26Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC26 Objective.
	 *
	 * @param bc26Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC26 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc26Objective(String bc26Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc26Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc26Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc26Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc26Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc26Objective(bc26Objective));

		// % protected region % [Add any additional logic for findByBc26Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc26Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC27 Subjective.
	 *
	 * @param bc27Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC27 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc27Subjective(String bc27Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc27Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc27Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc27Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc27Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc27Subjective(bc27Subjective));

		// % protected region % [Add any additional logic for findByBc27Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc27Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC27 Objective.
	 *
	 * @param bc27Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC27 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc27Objective(String bc27Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc27Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc27Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc27Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc27Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc27Objective(bc27Objective));

		// % protected region % [Add any additional logic for findByBc27Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc27Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC28 Subjective.
	 *
	 * @param bc28Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC28 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc28Subjective(String bc28Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc28Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc28Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc28Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc28Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc28Subjective(bc28Subjective));

		// % protected region % [Add any additional logic for findByBc28Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc28Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC28 Objective.
	 *
	 * @param bc28Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC28 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc28Objective(String bc28Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc28Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc28Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc28Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc28Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc28Objective(bc28Objective));

		// % protected region % [Add any additional logic for findByBc28Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc28Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC29 Subjective.
	 *
	 * @param bc29Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC29 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc29Subjective(String bc29Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc29Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc29Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc29Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc29Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc29Subjective(bc29Subjective));

		// % protected region % [Add any additional logic for findByBc29Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc29Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC29 Objective.
	 *
	 * @param bc29Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC29 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc29Objective(String bc29Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc29Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc29Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc29Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc29Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc29Objective(bc29Objective));

		// % protected region % [Add any additional logic for findByBc29Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc29Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC30 Subjective.
	 *
	 * @param bc30Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC30 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc30Subjective(String bc30Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc30Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc30Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc30Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc30Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc30Subjective(bc30Subjective));

		// % protected region % [Add any additional logic for findByBc30Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc30Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC30 Objective.
	 *
	 * @param bc30Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC30 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc30Objective(String bc30Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc30Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc30Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc30Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc30Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc30Objective(bc30Objective));

		// % protected region % [Add any additional logic for findByBc30Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc30Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC31 Subjective.
	 *
	 * @param bc31Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC31 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc31Subjective(String bc31Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc31Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc31Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc31Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc31Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc31Subjective(bc31Subjective));

		// % protected region % [Add any additional logic for findByBc31Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc31Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC31 Objective.
	 *
	 * @param bc31Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC31 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc31Objective(String bc31Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc31Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc31Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc31Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc31Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc31Objective(bc31Objective));

		// % protected region % [Add any additional logic for findByBc31Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc31Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC32 Subjective.
	 *
	 * @param bc32Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC32 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc32Subjective(String bc32Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc32Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc32Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc32Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc32Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc32Subjective(bc32Subjective));

		// % protected region % [Add any additional logic for findByBc32Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc32Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC32 Objective.
	 *
	 * @param bc32Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC32 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc32Objective(String bc32Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc32Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc32Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc32Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc32Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc32Objective(bc32Objective));

		// % protected region % [Add any additional logic for findByBc32Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc32Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC33 Subjective.
	 *
	 * @param bc33Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC33 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc33Subjective(String bc33Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc33Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc33Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc33Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc33Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc33Subjective(bc33Subjective));

		// % protected region % [Add any additional logic for findByBc33Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc33Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC33 Objective.
	 *
	 * @param bc33Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC33 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc33Objective(String bc33Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc33Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc33Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc33Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc33Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc33Objective(bc33Objective));

		// % protected region % [Add any additional logic for findByBc33Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc33Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC34 Subjective.
	 *
	 * @param bc34Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC34 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc34Subjective(String bc34Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc34Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc34Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc34Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc34Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc34Subjective(bc34Subjective));

		// % protected region % [Add any additional logic for findByBc34Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc34Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC34 Objective.
	 *
	 * @param bc34Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC34 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc34Objective(String bc34Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc34Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc34Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc34Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc34Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc34Objective(bc34Objective));

		// % protected region % [Add any additional logic for findByBc34Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc34Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC35 Subjective.
	 *
	 * @param bc35Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC35 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc35Subjective(String bc35Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc35Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc35Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc35Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc35Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc35Subjective(bc35Subjective));

		// % protected region % [Add any additional logic for findByBc35Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc35Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC35 Objective.
	 *
	 * @param bc35Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC35 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc35Objective(String bc35Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc35Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc35Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc35Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc35Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc35Objective(bc35Objective));

		// % protected region % [Add any additional logic for findByBc35Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc35Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC36 Subjective.
	 *
	 * @param bc36Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC36 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc36Subjective(String bc36Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc36Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc36Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc36Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc36Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc36Subjective(bc36Subjective));

		// % protected region % [Add any additional logic for findByBc36Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc36Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC36 Objective.
	 *
	 * @param bc36Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC36 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc36Objective(String bc36Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc36Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc36Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc36Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc36Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc36Objective(bc36Objective));

		// % protected region % [Add any additional logic for findByBc36Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc36Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC37 Subjective.
	 *
	 * @param bc37Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC37 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc37Subjective(String bc37Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc37Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc37Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc37Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc37Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc37Subjective(bc37Subjective));

		// % protected region % [Add any additional logic for findByBc37Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc37Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC37 Objective.
	 *
	 * @param bc37Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC37 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc37Objective(String bc37Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc37Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc37Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc37Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc37Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc37Objective(bc37Objective));

		// % protected region % [Add any additional logic for findByBc37Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc37Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC38 Subjective.
	 *
	 * @param bc38Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC38 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc38Subjective(String bc38Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc38Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc38Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc38Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc38Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc38Subjective(bc38Subjective));

		// % protected region % [Add any additional logic for findByBc38Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc38Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC38 Objective.
	 *
	 * @param bc38Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC38 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc38Objective(String bc38Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc38Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc38Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc38Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc38Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc38Objective(bc38Objective));

		// % protected region % [Add any additional logic for findByBc38Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc38Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC39 Subjective.
	 *
	 * @param bc39Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC39 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc39Subjective(String bc39Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc39Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc39Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc39Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc39Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc39Subjective(bc39Subjective));

		// % protected region % [Add any additional logic for findByBc39Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc39Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC39 Objective.
	 *
	 * @param bc39Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC39 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc39Objective(String bc39Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc39Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc39Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc39Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc39Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc39Objective(bc39Objective));

		// % protected region % [Add any additional logic for findByBc39Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc39Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC40 Subjective.
	 *
	 * @param bc40Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC40 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc40Subjective(String bc40Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc40Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc40Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc40Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc40Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc40Subjective(bc40Subjective));

		// % protected region % [Add any additional logic for findByBc40Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc40Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC40 Objective.
	 *
	 * @param bc40Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC40 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc40Objective(String bc40Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc40Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc40Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc40Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc40Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc40Objective(bc40Objective));

		// % protected region % [Add any additional logic for findByBc40Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc40Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC41 Subjective.
	 *
	 * @param bc41Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC41 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc41Subjective(String bc41Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc41Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc41Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc41Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc41Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc41Subjective(bc41Subjective));

		// % protected region % [Add any additional logic for findByBc41Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc41Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC41 Objective.
	 *
	 * @param bc41Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC41 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc41Objective(String bc41Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc41Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc41Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc41Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc41Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc41Objective(bc41Objective));

		// % protected region % [Add any additional logic for findByBc41Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc41Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC42 Subjective.
	 *
	 * @param bc42Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC42 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc42Subjective(String bc42Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc42Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc42Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc42Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc42Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc42Subjective(bc42Subjective));

		// % protected region % [Add any additional logic for findByBc42Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc42Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC42 Objective.
	 *
	 * @param bc42Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC42 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc42Objective(String bc42Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc42Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc42Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc42Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc42Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc42Objective(bc42Objective));

		// % protected region % [Add any additional logic for findByBc42Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc42Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC43 Subjective.
	 *
	 * @param bc43Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC43 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc43Subjective(String bc43Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc43Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc43Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc43Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc43Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc43Subjective(bc43Subjective));

		// % protected region % [Add any additional logic for findByBc43Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc43Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC43 Objective.
	 *
	 * @param bc43Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC43 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc43Objective(String bc43Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc43Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc43Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc43Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc43Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc43Objective(bc43Objective));

		// % protected region % [Add any additional logic for findByBc43Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc43Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC44 Subjective.
	 *
	 * @param bc44Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC44 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc44Subjective(String bc44Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc44Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc44Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc44Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc44Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc44Subjective(bc44Subjective));

		// % protected region % [Add any additional logic for findByBc44Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc44Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC44 Objective.
	 *
	 * @param bc44Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC44 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc44Objective(String bc44Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc44Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc44Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc44Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc44Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc44Objective(bc44Objective));

		// % protected region % [Add any additional logic for findByBc44Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc44Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC45 Subjective.
	 *
	 * @param bc45Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC45 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc45Subjective(String bc45Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc45Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc45Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc45Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc45Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc45Subjective(bc45Subjective));

		// % protected region % [Add any additional logic for findByBc45Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc45Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC45 Objective.
	 *
	 * @param bc45Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC45 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc45Objective(String bc45Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc45Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc45Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc45Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc45Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc45Objective(bc45Objective));

		// % protected region % [Add any additional logic for findByBc45Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc45Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC46 Subjective.
	 *
	 * @param bc46Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC46 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc46Subjective(String bc46Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc46Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc46Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc46Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc46Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc46Subjective(bc46Subjective));

		// % protected region % [Add any additional logic for findByBc46Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc46Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC46 Objective.
	 *
	 * @param bc46Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC46 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc46Objective(String bc46Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc46Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc46Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc46Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc46Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc46Objective(bc46Objective));

		// % protected region % [Add any additional logic for findByBc46Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc46Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC47 Subjective.
	 *
	 * @param bc47Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC47 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc47Subjective(String bc47Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc47Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc47Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc47Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc47Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc47Subjective(bc47Subjective));

		// % protected region % [Add any additional logic for findByBc47Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc47Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC47 Objective.
	 *
	 * @param bc47Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC47 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc47Objective(String bc47Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc47Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc47Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc47Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc47Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc47Objective(bc47Objective));

		// % protected region % [Add any additional logic for findByBc47Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc47Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC48 Subjective.
	 *
	 * @param bc48Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC48 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc48Subjective(String bc48Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc48Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc48Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc48Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc48Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc48Subjective(bc48Subjective));

		// % protected region % [Add any additional logic for findByBc48Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc48Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC48 Objective.
	 *
	 * @param bc48Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC48 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc48Objective(String bc48Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc48Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc48Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc48Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc48Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc48Objective(bc48Objective));

		// % protected region % [Add any additional logic for findByBc48Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc48Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC49 Subjective.
	 *
	 * @param bc49Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC49 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc49Subjective(String bc49Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc49Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc49Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc49Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc49Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc49Subjective(bc49Subjective));

		// % protected region % [Add any additional logic for findByBc49Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc49Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC49 Objective.
	 *
	 * @param bc49Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC49 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc49Objective(String bc49Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc49Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc49Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc49Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc49Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc49Objective(bc49Objective));

		// % protected region % [Add any additional logic for findByBc49Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc49Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC50 Subjective.
	 *
	 * @param bc50Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC50 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc50Subjective(String bc50Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc50Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc50Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc50Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc50Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc50Subjective(bc50Subjective));

		// % protected region % [Add any additional logic for findByBc50Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc50Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC50 Objective.
	 *
	 * @param bc50Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC50 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc50Objective(String bc50Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc50Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc50Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc50Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc50Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc50Objective(bc50Objective));

		// % protected region % [Add any additional logic for findByBc50Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc50Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC51 Subjective.
	 *
	 * @param bc51Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC51 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc51Subjective(String bc51Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc51Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc51Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc51Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc51Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc51Subjective(bc51Subjective));

		// % protected region % [Add any additional logic for findByBc51Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc51Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC51 Objective.
	 *
	 * @param bc51Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC51 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc51Objective(String bc51Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc51Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc51Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc51Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc51Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc51Objective(bc51Objective));

		// % protected region % [Add any additional logic for findByBc51Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc51Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC52 Subjective.
	 *
	 * @param bc52Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC52 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc52Subjective(String bc52Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc52Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc52Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc52Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc52Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc52Subjective(bc52Subjective));

		// % protected region % [Add any additional logic for findByBc52Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc52Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC52 Objective.
	 *
	 * @param bc52Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC52 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc52Objective(String bc52Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc52Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc52Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc52Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc52Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc52Objective(bc52Objective));

		// % protected region % [Add any additional logic for findByBc52Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc52Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC53 Subjective.
	 *
	 * @param bc53Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC53 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc53Subjective(String bc53Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc53Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc53Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc53Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc53Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc53Subjective(bc53Subjective));

		// % protected region % [Add any additional logic for findByBc53Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc53Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC53 Objective.
	 *
	 * @param bc53Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC53 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc53Objective(String bc53Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc53Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc53Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc53Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc53Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc53Objective(bc53Objective));

		// % protected region % [Add any additional logic for findByBc53Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc53Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC54 Subjective.
	 *
	 * @param bc54Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC54 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc54Subjective(String bc54Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc54Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc54Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc54Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc54Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc54Subjective(bc54Subjective));

		// % protected region % [Add any additional logic for findByBc54Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc54Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC54 Objective.
	 *
	 * @param bc54Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC54 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc54Objective(String bc54Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc54Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc54Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc54Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc54Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc54Objective(bc54Objective));

		// % protected region % [Add any additional logic for findByBc54Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc54Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC55 Subjective.
	 *
	 * @param bc55Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC55 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc55Subjective(String bc55Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc55Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc55Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc55Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc55Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc55Subjective(bc55Subjective));

		// % protected region % [Add any additional logic for findByBc55Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc55Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC55 Objective.
	 *
	 * @param bc55Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC55 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc55Objective(String bc55Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc55Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc55Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc55Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc55Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc55Objective(bc55Objective));

		// % protected region % [Add any additional logic for findByBc55Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc55Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC56 Subjective.
	 *
	 * @param bc56Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC56 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc56Subjective(String bc56Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc56Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc56Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc56Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc56Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc56Subjective(bc56Subjective));

		// % protected region % [Add any additional logic for findByBc56Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc56Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC56 Objective.
	 *
	 * @param bc56Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC56 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc56Objective(String bc56Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc56Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc56Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc56Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc56Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc56Objective(bc56Objective));

		// % protected region % [Add any additional logic for findByBc56Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc56Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC57 Subjective.
	 *
	 * @param bc57Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC57 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc57Subjective(String bc57Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc57Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc57Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc57Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc57Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc57Subjective(bc57Subjective));

		// % protected region % [Add any additional logic for findByBc57Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc57Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC57 Objective.
	 *
	 * @param bc57Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC57 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc57Objective(String bc57Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc57Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc57Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc57Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc57Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc57Objective(bc57Objective));

		// % protected region % [Add any additional logic for findByBc57Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc57Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC58 Subjective.
	 *
	 * @param bc58Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC58 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc58Subjective(String bc58Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc58Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc58Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc58Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc58Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc58Subjective(bc58Subjective));

		// % protected region % [Add any additional logic for findByBc58Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc58Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC58 Objective.
	 *
	 * @param bc58Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC58 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc58Objective(String bc58Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc58Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc58Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc58Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc58Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc58Objective(bc58Objective));

		// % protected region % [Add any additional logic for findByBc58Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc58Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC59 Subjective.
	 *
	 * @param bc59Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC59 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc59Subjective(String bc59Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc59Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc59Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc59Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc59Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc59Subjective(bc59Subjective));

		// % protected region % [Add any additional logic for findByBc59Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc59Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC59 Objective.
	 *
	 * @param bc59Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC59 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc59Objective(String bc59Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc59Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc59Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc59Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc59Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc59Objective(bc59Objective));

		// % protected region % [Add any additional logic for findByBc59Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc59Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC60 Subjective.
	 *
	 * @param bc60Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC60 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc60Subjective(String bc60Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc60Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc60Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc60Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc60Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc60Subjective(bc60Subjective));

		// % protected region % [Add any additional logic for findByBc60Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc60Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC60 Objective.
	 *
	 * @param bc60Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC60 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc60Objective(String bc60Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc60Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc60Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc60Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc60Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc60Objective(bc60Objective));

		// % protected region % [Add any additional logic for findByBc60Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc60Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC61 Subjective.
	 *
	 * @param bc61Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC61 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc61Subjective(String bc61Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc61Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc61Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc61Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc61Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc61Subjective(bc61Subjective));

		// % protected region % [Add any additional logic for findByBc61Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc61Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC61 Objective.
	 *
	 * @param bc61Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC61 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc61Objective(String bc61Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc61Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc61Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc61Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc61Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc61Objective(bc61Objective));

		// % protected region % [Add any additional logic for findByBc61Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc61Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC62 Subjective.
	 *
	 * @param bc62Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC62 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc62Subjective(String bc62Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc62Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc62Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc62Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc62Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc62Subjective(bc62Subjective));

		// % protected region % [Add any additional logic for findByBc62Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc62Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC62 Objective.
	 *
	 * @param bc62Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC62 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc62Objective(String bc62Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc62Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc62Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc62Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc62Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc62Objective(bc62Objective));

		// % protected region % [Add any additional logic for findByBc62Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc62Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC63 Subjective.
	 *
	 * @param bc63Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC63 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc63Subjective(String bc63Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc63Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc63Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc63Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc63Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc63Subjective(bc63Subjective));

		// % protected region % [Add any additional logic for findByBc63Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc63Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC63 Objective.
	 *
	 * @param bc63Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC63 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc63Objective(String bc63Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc63Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc63Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc63Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc63Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc63Objective(bc63Objective));

		// % protected region % [Add any additional logic for findByBc63Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc63Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC64 Subjective.
	 *
	 * @param bc64Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC64 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc64Subjective(String bc64Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc64Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc64Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc64Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc64Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc64Subjective(bc64Subjective));

		// % protected region % [Add any additional logic for findByBc64Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc64Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC64 Objective.
	 *
	 * @param bc64Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC64 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc64Objective(String bc64Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc64Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc64Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc64Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc64Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc64Objective(bc64Objective));

		// % protected region % [Add any additional logic for findByBc64Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc64Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC65 Subjective.
	 *
	 * @param bc65Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC65 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc65Subjective(String bc65Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc65Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc65Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc65Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc65Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc65Subjective(bc65Subjective));

		// % protected region % [Add any additional logic for findByBc65Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc65Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC65 Objective.
	 *
	 * @param bc65Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC65 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc65Objective(String bc65Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc65Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc65Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc65Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc65Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc65Objective(bc65Objective));

		// % protected region % [Add any additional logic for findByBc65Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc65Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC66 Subjective.
	 *
	 * @param bc66Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC66 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc66Subjective(String bc66Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc66Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc66Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc66Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc66Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc66Subjective(bc66Subjective));

		// % protected region % [Add any additional logic for findByBc66Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc66Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC66 Objective.
	 *
	 * @param bc66Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC66 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc66Objective(String bc66Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc66Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc66Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc66Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc66Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc66Objective(bc66Objective));

		// % protected region % [Add any additional logic for findByBc66Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc66Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC67 Subjective.
	 *
	 * @param bc67Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC67 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc67Subjective(String bc67Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc67Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc67Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc67Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc67Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc67Subjective(bc67Subjective));

		// % protected region % [Add any additional logic for findByBc67Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc67Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC67 Objective.
	 *
	 * @param bc67Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC67 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc67Objective(String bc67Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc67Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc67Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc67Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc67Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc67Objective(bc67Objective));

		// % protected region % [Add any additional logic for findByBc67Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc67Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC68 Subjective.
	 *
	 * @param bc68Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC68 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc68Subjective(String bc68Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc68Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc68Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc68Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc68Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc68Subjective(bc68Subjective));

		// % protected region % [Add any additional logic for findByBc68Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc68Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC68 Objective.
	 *
	 * @param bc68Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC68 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc68Objective(String bc68Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc68Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc68Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc68Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc68Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc68Objective(bc68Objective));

		// % protected region % [Add any additional logic for findByBc68Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc68Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC69 Subjective.
	 *
	 * @param bc69Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC69 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc69Subjective(String bc69Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc69Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc69Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc69Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc69Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc69Subjective(bc69Subjective));

		// % protected region % [Add any additional logic for findByBc69Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc69Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC69 Objective.
	 *
	 * @param bc69Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC69 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc69Objective(String bc69Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc69Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc69Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc69Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc69Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc69Objective(bc69Objective));

		// % protected region % [Add any additional logic for findByBc69Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc69Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC70 Subjective.
	 *
	 * @param bc70Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC70 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc70Subjective(String bc70Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc70Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc70Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc70Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc70Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc70Subjective(bc70Subjective));

		// % protected region % [Add any additional logic for findByBc70Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc70Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC70 Objective.
	 *
	 * @param bc70Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC70 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc70Objective(String bc70Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc70Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc70Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc70Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc70Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc70Objective(bc70Objective));

		// % protected region % [Add any additional logic for findByBc70Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc70Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC71 Subjective.
	 *
	 * @param bc71Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC71 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc71Subjective(String bc71Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc71Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc71Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc71Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc71Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc71Subjective(bc71Subjective));

		// % protected region % [Add any additional logic for findByBc71Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc71Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC71 Objective.
	 *
	 * @param bc71Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC71 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc71Objective(String bc71Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc71Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc71Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc71Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc71Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc71Objective(bc71Objective));

		// % protected region % [Add any additional logic for findByBc71Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc71Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC72 Subjective.
	 *
	 * @param bc72Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC72 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc72Subjective(String bc72Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc72Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc72Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc72Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc72Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc72Subjective(bc72Subjective));

		// % protected region % [Add any additional logic for findByBc72Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc72Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC72 Objective.
	 *
	 * @param bc72Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC72 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc72Objective(String bc72Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc72Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc72Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc72Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc72Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc72Objective(bc72Objective));

		// % protected region % [Add any additional logic for findByBc72Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc72Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC73 Subjective.
	 *
	 * @param bc73Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC73 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc73Subjective(String bc73Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc73Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc73Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc73Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc73Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc73Subjective(bc73Subjective));

		// % protected region % [Add any additional logic for findByBc73Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc73Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC73 Objective.
	 *
	 * @param bc73Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC73 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc73Objective(String bc73Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc73Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc73Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc73Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc73Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc73Objective(bc73Objective));

		// % protected region % [Add any additional logic for findByBc73Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc73Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC74 Subjective.
	 *
	 * @param bc74Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC74 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc74Subjective(String bc74Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc74Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc74Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc74Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc74Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc74Subjective(bc74Subjective));

		// % protected region % [Add any additional logic for findByBc74Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc74Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC74 Objective.
	 *
	 * @param bc74Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC74 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc74Objective(String bc74Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc74Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc74Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc74Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc74Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc74Objective(bc74Objective));

		// % protected region % [Add any additional logic for findByBc74Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc74Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC75 Subjective.
	 *
	 * @param bc75Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC75 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc75Subjective(String bc75Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc75Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc75Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc75Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc75Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc75Subjective(bc75Subjective));

		// % protected region % [Add any additional logic for findByBc75Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc75Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC75 Objective.
	 *
	 * @param bc75Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC75 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc75Objective(String bc75Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc75Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc75Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc75Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc75Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc75Objective(bc75Objective));

		// % protected region % [Add any additional logic for findByBc75Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc75Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC76 Subjective.
	 *
	 * @param bc76Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC76 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc76Subjective(String bc76Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc76Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc76Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc76Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc76Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc76Subjective(bc76Subjective));

		// % protected region % [Add any additional logic for findByBc76Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc76Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC76 Objective.
	 *
	 * @param bc76Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC76 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc76Objective(String bc76Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc76Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc76Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc76Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc76Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc76Objective(bc76Objective));

		// % protected region % [Add any additional logic for findByBc76Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc76Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC77 Subjective.
	 *
	 * @param bc77Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC77 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc77Subjective(String bc77Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc77Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc77Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc77Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc77Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc77Subjective(bc77Subjective));

		// % protected region % [Add any additional logic for findByBc77Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc77Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC77 Objective.
	 *
	 * @param bc77Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC77 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc77Objective(String bc77Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc77Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc77Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc77Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc77Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc77Objective(bc77Objective));

		// % protected region % [Add any additional logic for findByBc77Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc77Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC78 Subjective.
	 *
	 * @param bc78Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC78 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc78Subjective(String bc78Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc78Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc78Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc78Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc78Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc78Subjective(bc78Subjective));

		// % protected region % [Add any additional logic for findByBc78Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc78Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC78 Objective.
	 *
	 * @param bc78Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC78 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc78Objective(String bc78Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc78Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc78Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc78Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc78Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc78Objective(bc78Objective));

		// % protected region % [Add any additional logic for findByBc78Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc78Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC79 Subjective.
	 *
	 * @param bc79Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC79 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc79Subjective(String bc79Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc79Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc79Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc79Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc79Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc79Subjective(bc79Subjective));

		// % protected region % [Add any additional logic for findByBc79Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc79Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC79 Objective.
	 *
	 * @param bc79Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC79 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc79Objective(String bc79Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc79Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc79Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc79Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc79Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc79Objective(bc79Objective));

		// % protected region % [Add any additional logic for findByBc79Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc79Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC80 Subjective.
	 *
	 * @param bc80Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC80 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc80Subjective(String bc80Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc80Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc80Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc80Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc80Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc80Subjective(bc80Subjective));

		// % protected region % [Add any additional logic for findByBc80Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc80Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC80 Objective.
	 *
	 * @param bc80Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC80 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc80Objective(String bc80Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc80Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc80Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc80Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc80Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc80Objective(bc80Objective));

		// % protected region % [Add any additional logic for findByBc80Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc80Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC81 Subjective.
	 *
	 * @param bc81Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC81 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc81Subjective(String bc81Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc81Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc81Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc81Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc81Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc81Subjective(bc81Subjective));

		// % protected region % [Add any additional logic for findByBc81Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc81Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC81 Objective.
	 *
	 * @param bc81Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC81 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc81Objective(String bc81Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc81Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc81Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc81Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc81Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc81Objective(bc81Objective));

		// % protected region % [Add any additional logic for findByBc81Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc81Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC82 Subjective.
	 *
	 * @param bc82Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC82 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc82Subjective(String bc82Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc82Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc82Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc82Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc82Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc82Subjective(bc82Subjective));

		// % protected region % [Add any additional logic for findByBc82Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc82Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC82 Objective.
	 *
	 * @param bc82Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC82 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc82Objective(String bc82Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc82Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc82Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc82Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc82Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc82Objective(bc82Objective));

		// % protected region % [Add any additional logic for findByBc82Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc82Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC83 Subjective.
	 *
	 * @param bc83Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC83 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc83Subjective(String bc83Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc83Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc83Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc83Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc83Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc83Subjective(bc83Subjective));

		// % protected region % [Add any additional logic for findByBc83Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc83Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC83 Objective.
	 *
	 * @param bc83Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC83 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc83Objective(String bc83Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc83Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc83Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc83Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc83Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc83Objective(bc83Objective));

		// % protected region % [Add any additional logic for findByBc83Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc83Objective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC84 Subjective.
	 *
	 * @param bc84Subjective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC84 Subjective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc84Subjective(String bc84Subjective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc84Subjective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc84Subjective here] end
	{
		// % protected region % [Add any additional logic for findByBc84Subjective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc84Subjective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc84Subjective(bc84Subjective));

		// % protected region % [Add any additional logic for findByBc84Subjective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc84Subjective before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute BC84 Objective.
	 *
	 * @param bc84Objective the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute BC84 Objective
	 */
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findByBc84Objective(String bc84Objective)
	// % protected region % [Add any throwables, implementations, or extensions for findByBc84Objective here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBc84Objective here] end
	{
		// % protected region % [Add any additional logic for findByBc84Objective before the main body here] off begin
		// % protected region % [Add any additional logic for findByBc84Objective before the main body here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findByBc84Objective(bc84Objective));

		// % protected region % [Add any additional logic for findByBc84Objective before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBc84Objective before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<BodyChartExaminationEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<BodyChartExaminationEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<BodyChartExaminationEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'create')")
	public BodyChartExaminationEntity create(BodyChartExaminationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		BodyChartExaminationEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'create')")
	public BodyChartExaminationEntity create(BodyChartExaminationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		BodyChartExaminationEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		BodyChartExaminationEntity newEntity;

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
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'create')")
	public List<BodyChartExaminationEntity> createAll(Iterable<BodyChartExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<BodyChartExaminationEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<BodyChartExaminationEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'update')")
	public BodyChartExaminationEntity update(BodyChartExaminationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		BodyChartExaminationEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'update')")
	public BodyChartExaminationEntity update(BodyChartExaminationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		BodyChartExaminationEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		BodyChartExaminationEntity newEntity;

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
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'update')")
	public List<BodyChartExaminationEntity> updateAll(Iterable<BodyChartExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<BodyChartExaminationEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<BodyChartExaminationEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'create') or hasPermission('BodyChartExaminationEntity', 'update')")
	public BodyChartExaminationEntity save(BodyChartExaminationEntity entity) throws ConstraintViolationException
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

		BodyChartExaminationEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'create') or hasPermission('BodyChartExaminationEntity', 'update')")
	public List<BodyChartExaminationEntity> saveAll(Iterable<BodyChartExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<BodyChartExaminationEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	public List<BodyChartExaminationEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	public List<BodyChartExaminationEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(BodyChartExaminationEntity.class);

		// % protected region % [Add any additional processing before converting to a list of BodyChartExaminationEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of BodyChartExaminationEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('BodyChartExaminationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BodyChartExaminationEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of BodyChartExaminationEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of BodyChartExaminationEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(BodyChartExaminationEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of BodyChartExaminationEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of BodyChartExaminationEntityAudits
	 */
	private List<BodyChartExaminationEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<BodyChartExaminationEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param bodyChartExamination bodyChartExamination to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private BodyChartExaminationEntity updateAuditData(BodyChartExaminationEntity bodyChartExamination)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return bodyChartExamination;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private BodyChartExaminationEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		BodyChartExaminationEntity entityAtRevision = updateAuditData((BodyChartExaminationEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new BodyChartExaminationEntityAudit(
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

		QBodyChartExaminationEntity entity = QBodyChartExaminationEntity.bodyChartExaminationEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Body Chart Examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Body Chart Examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Body Chart Examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Body Chart Examination here] end

				break;
			case "bc77Objective":
				// % protected region % [Add any additional logic before the query parameters of bc77Objective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc77Objective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc77Objective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc77Objective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc77Objective here] end

				break;
			case "bc78Subjective":
				// % protected region % [Add any additional logic before the query parameters of bc78Subjective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc78Subjective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc78Subjective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc78Subjective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc78Subjective here] end

				break;
			case "bc78Objective":
				// % protected region % [Add any additional logic before the query parameters of bc78Objective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc78Objective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc78Objective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc78Objective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc78Objective here] end

				break;
			case "bc79Subjective":
				// % protected region % [Add any additional logic before the query parameters of bc79Subjective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc79Subjective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc79Subjective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc79Subjective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc79Subjective here] end

				break;
			case "bc79Objective":
				// % protected region % [Add any additional logic before the query parameters of bc79Objective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc79Objective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc79Objective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc79Objective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc79Objective here] end

				break;
			case "bc80Subjective":
				// % protected region % [Add any additional logic before the query parameters of bc80Subjective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc80Subjective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc80Subjective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc80Subjective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc80Subjective here] end

				break;
			case "bc80Objective":
				// % protected region % [Add any additional logic before the query parameters of bc80Objective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc80Objective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc80Objective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc80Objective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc80Objective here] end

				break;
			case "bc81Subjective":
				// % protected region % [Add any additional logic before the query parameters of bc81Subjective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc81Subjective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc81Subjective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc81Subjective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc81Subjective here] end

				break;
			case "bc81Objective":
				// % protected region % [Add any additional logic before the query parameters of bc81Objective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc81Objective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc81Objective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc81Objective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc81Objective here] end

				break;
			case "bc82Subjective":
				// % protected region % [Add any additional logic before the query parameters of bc82Subjective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc82Subjective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc82Subjective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc82Subjective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc82Subjective here] end

				break;
			case "bc82Objective":
				// % protected region % [Add any additional logic before the query parameters of bc82Objective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc82Objective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc82Objective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc82Objective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc82Objective here] end

				break;
			case "bc83Subjective":
				// % protected region % [Add any additional logic before the query parameters of bc83Subjective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc83Subjective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc83Subjective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc83Subjective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc83Subjective here] end

				break;
			case "bc83Objective":
				// % protected region % [Add any additional logic before the query parameters of bc83Objective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc83Objective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc83Objective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc83Objective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc83Objective here] end

				break;
			case "bc84Subjective":
				// % protected region % [Add any additional logic before the query parameters of bc84Subjective here] off begin
				// % protected region % [Add any additional logic before the query parameters of bc84Subjective here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bc84Subjective, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bc84Subjective here] off begin
				// % protected region % [Add any additional logic after the query parameters of bc84Subjective here] end

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
	public BodyChartExaminationEntity updateOldData(BodyChartExaminationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public BodyChartExaminationEntity updateOldData(BodyChartExaminationEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		BodyChartExaminationEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInBodyChartExaminationEntity);

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
				entityToUpdate.getMedicalExaminationRecord().unsetBodyChartExamination();
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
	public void validateEntity(BodyChartExaminationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<BodyChartExaminationEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the BodyChartExaminationEntity.
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

	public Set<String> validateEntityRelations(BodyChartExaminationEntity entity)
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
