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
import kmsweb.repositories.HemodialysisExaminationRepository;
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
import kmsweb.entities.HemodialysisMonitoringEntity;
import kmsweb.repositories.HemodialysisMonitoringRepository;
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
public class HemodialysisExaminationService extends AbstractService<HemodialysisExaminationEntity, HemodialysisExaminationRepository, HemodialysisExaminationEntityAudit> {

	private final String[] referenceNamesInHemodialysisExaminationEntity = {
		"hemodialysisMonitorings",
		"medicalExaminationRecord",
	};

	private final HemodialysisMonitoringRepository hemodialysisMonitoringRepository;

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public HemodialysisExaminationService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		HemodialysisMonitoringRepository hemodialysisMonitoringRepository,
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		HemodialysisExaminationRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.hemodialysisMonitoringRepository = hemodialysisMonitoringRepository;

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
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
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
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute First Dialysis.
	 *
	 * @param firstDialysis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute First Dialysis
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByFirstDialysis(OffsetDateTime firstDialysis)
	// % protected region % [Add any throwables, implementations, or extensions for findByFirstDialysis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFirstDialysis here] end
	{
		// % protected region % [Add any additional logic for findByFirstDialysis before the main body here] off begin
		// % protected region % [Add any additional logic for findByFirstDialysis before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByFirstDialysis(firstDialysis));

		// % protected region % [Add any additional logic for findByFirstDialysis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFirstDialysis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dialysis Frequency.
	 *
	 * @param dialysisFrequency the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dialysis Frequency
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByDialysisFrequency(String dialysisFrequency)
	// % protected region % [Add any throwables, implementations, or extensions for findByDialysisFrequency here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDialysisFrequency here] end
	{
		// % protected region % [Add any additional logic for findByDialysisFrequency before the main body here] off begin
		// % protected region % [Add any additional logic for findByDialysisFrequency before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByDialysisFrequency(dialysisFrequency));

		// % protected region % [Add any additional logic for findByDialysisFrequency before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDialysisFrequency before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dialysis No.
	 *
	 * @param dialysisNo the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dialysis No
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByDialysisNo(String dialysisNo)
	// % protected region % [Add any throwables, implementations, or extensions for findByDialysisNo here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDialysisNo here] end
	{
		// % protected region % [Add any additional logic for findByDialysisNo before the main body here] off begin
		// % protected region % [Add any additional logic for findByDialysisNo before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByDialysisNo(dialysisNo));

		// % protected region % [Add any additional logic for findByDialysisNo before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDialysisNo before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hemodialysis Type.
	 *
	 * @param hemodialysisType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hemodialysis Type
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByHemodialysisType(String hemodialysisType)
	// % protected region % [Add any throwables, implementations, or extensions for findByHemodialysisType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHemodialysisType here] end
	{
		// % protected region % [Add any additional logic for findByHemodialysisType before the main body here] off begin
		// % protected region % [Add any additional logic for findByHemodialysisType before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByHemodialysisType(hemodialysisType));

		// % protected region % [Add any additional logic for findByHemodialysisType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHemodialysisType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Condition.
	 *
	 * @param condition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Condition
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByCondition(String condition)
	// % protected region % [Add any throwables, implementations, or extensions for findByCondition here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByCondition here] end
	{
		// % protected region % [Add any additional logic for findByCondition before the main body here] off begin
		// % protected region % [Add any additional logic for findByCondition before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByCondition(condition));

		// % protected region % [Add any additional logic for findByCondition before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByCondition before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Vascular Access.
	 *
	 * @param vascularAccess the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Vascular Access
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByVascularAccess(String vascularAccess)
	// % protected region % [Add any throwables, implementations, or extensions for findByVascularAccess here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVascularAccess here] end
	{
		// % protected region % [Add any additional logic for findByVascularAccess before the main body here] off begin
		// % protected region % [Add any additional logic for findByVascularAccess before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByVascularAccess(vascularAccess));

		// % protected region % [Add any additional logic for findByVascularAccess before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVascularAccess before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Heparinization.
	 *
	 * @param heparinization the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Heparinization
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByHeparinization(String heparinization)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeparinization here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeparinization here] end
	{
		// % protected region % [Add any additional logic for findByHeparinization before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeparinization before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByHeparinization(heparinization));

		// % protected region % [Add any additional logic for findByHeparinization before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeparinization before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Heparinization Initial Dose.
	 *
	 * @param heparinizationInitialDose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Heparinization Initial Dose
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByHeparinizationInitialDose(String heparinizationInitialDose)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeparinizationInitialDose here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeparinizationInitialDose here] end
	{
		// % protected region % [Add any additional logic for findByHeparinizationInitialDose before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeparinizationInitialDose before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByHeparinizationInitialDose(heparinizationInitialDose));

		// % protected region % [Add any additional logic for findByHeparinizationInitialDose before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeparinizationInitialDose before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Heparinization Follow Up Dose.
	 *
	 * @param heparinizationFollowUpDose the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Heparinization Follow Up Dose
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByHeparinizationFollowUpDose(String heparinizationFollowUpDose)
	// % protected region % [Add any throwables, implementations, or extensions for findByHeparinizationFollowUpDose here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHeparinizationFollowUpDose here] end
	{
		// % protected region % [Add any additional logic for findByHeparinizationFollowUpDose before the main body here] off begin
		// % protected region % [Add any additional logic for findByHeparinizationFollowUpDose before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByHeparinizationFollowUpDose(heparinizationFollowUpDose));

		// % protected region % [Add any additional logic for findByHeparinizationFollowUpDose before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHeparinizationFollowUpDose before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dialyzer.
	 *
	 * @param dialyzer the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dialyzer
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByDialyzer(String dialyzer)
	// % protected region % [Add any throwables, implementations, or extensions for findByDialyzer here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDialyzer here] end
	{
		// % protected region % [Add any additional logic for findByDialyzer before the main body here] off begin
		// % protected region % [Add any additional logic for findByDialyzer before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByDialyzer(dialyzer));

		// % protected region % [Add any additional logic for findByDialyzer before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDialyzer before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dialyzer Type.
	 *
	 * @param dialyzerType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dialyzer Type
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByDialyzerType(String dialyzerType)
	// % protected region % [Add any throwables, implementations, or extensions for findByDialyzerType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDialyzerType here] end
	{
		// % protected region % [Add any additional logic for findByDialyzerType before the main body here] off begin
		// % protected region % [Add any additional logic for findByDialyzerType before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByDialyzerType(dialyzerType));

		// % protected region % [Add any additional logic for findByDialyzerType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDialyzerType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dialysis Fluid.
	 *
	 * @param dialysisFluid the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dialysis Fluid
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByDialysisFluid(String dialysisFluid)
	// % protected region % [Add any throwables, implementations, or extensions for findByDialysisFluid here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDialysisFluid here] end
	{
		// % protected region % [Add any additional logic for findByDialysisFluid before the main body here] off begin
		// % protected region % [Add any additional logic for findByDialysisFluid before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByDialysisFluid(dialysisFluid));

		// % protected region % [Add any additional logic for findByDialysisFluid before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDialysisFluid before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dry Weight.
	 *
	 * @param dryWeight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dry Weight
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByDryWeight(Double dryWeight)
	// % protected region % [Add any throwables, implementations, or extensions for findByDryWeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDryWeight here] end
	{
		// % protected region % [Add any additional logic for findByDryWeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByDryWeight before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByDryWeight(dryWeight));

		// % protected region % [Add any additional logic for findByDryWeight before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDryWeight before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Dry Weight Unit.
	 *
	 * @param dryWeightUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dry Weight Unit
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByDryWeightUnit(String dryWeightUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByDryWeightUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDryWeightUnit here] end
	{
		// % protected region % [Add any additional logic for findByDryWeightUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByDryWeightUnit before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByDryWeightUnit(dryWeightUnit));

		// % protected region % [Add any additional logic for findByDryWeightUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDryWeightUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight Upon Arrival.
	 *
	 * @param weightUponArrival the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Upon Arrival
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByWeightUponArrival(Double weightUponArrival)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUponArrival here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUponArrival here] end
	{
		// % protected region % [Add any additional logic for findByWeightUponArrival before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightUponArrival before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByWeightUponArrival(weightUponArrival));

		// % protected region % [Add any additional logic for findByWeightUponArrival before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightUponArrival before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight Upon Arrival Unit.
	 *
	 * @param weightUponArrivalUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Upon Arrival Unit
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByWeightUponArrivalUnit(String weightUponArrivalUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUponArrivalUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUponArrivalUnit here] end
	{
		// % protected region % [Add any additional logic for findByWeightUponArrivalUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightUponArrivalUnit before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByWeightUponArrivalUnit(weightUponArrivalUnit));

		// % protected region % [Add any additional logic for findByWeightUponArrivalUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightUponArrivalUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight During Previous Hemodialysis.
	 *
	 * @param weightDuringPreviousHemodialysis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight During Previous Hemodialysis
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByWeightDuringPreviousHemodialysis(Double weightDuringPreviousHemodialysis)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightDuringPreviousHemodialysis here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightDuringPreviousHemodialysis here] end
	{
		// % protected region % [Add any additional logic for findByWeightDuringPreviousHemodialysis before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightDuringPreviousHemodialysis before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByWeightDuringPreviousHemodialysis(weightDuringPreviousHemodialysis));

		// % protected region % [Add any additional logic for findByWeightDuringPreviousHemodialysis before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightDuringPreviousHemodialysis before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight During Previous Hemodialysis Unit.
	 *
	 * @param weightDuringPreviousHemodialysisUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight During Previous Hemodialysis Unit
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByWeightDuringPreviousHemodialysisUnit(String weightDuringPreviousHemodialysisUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightDuringPreviousHemodialysisUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightDuringPreviousHemodialysisUnit here] end
	{
		// % protected region % [Add any additional logic for findByWeightDuringPreviousHemodialysisUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightDuringPreviousHemodialysisUnit before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByWeightDuringPreviousHemodialysisUnit(weightDuringPreviousHemodialysisUnit));

		// % protected region % [Add any additional logic for findByWeightDuringPreviousHemodialysisUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightDuringPreviousHemodialysisUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anti HIV.
	 *
	 * @param antiHIV the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anti HIV
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByAntiHIV(Boolean antiHIV)
	// % protected region % [Add any throwables, implementations, or extensions for findByAntiHIV here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAntiHIV here] end
	{
		// % protected region % [Add any additional logic for findByAntiHIV before the main body here] off begin
		// % protected region % [Add any additional logic for findByAntiHIV before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByAntiHIV(antiHIV));

		// % protected region % [Add any additional logic for findByAntiHIV before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAntiHIV before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute HbsAg.
	 *
	 * @param hbsag the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute HbsAg
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByHbsag(Boolean hbsag)
	// % protected region % [Add any throwables, implementations, or extensions for findByHbsag here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHbsag here] end
	{
		// % protected region % [Add any additional logic for findByHbsag before the main body here] off begin
		// % protected region % [Add any additional logic for findByHbsag before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByHbsag(hbsag));

		// % protected region % [Add any additional logic for findByHbsag before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHbsag before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Anti HCV.
	 *
	 * @param antiHCV the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Anti HCV
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByAntiHCV(Boolean antiHCV)
	// % protected region % [Add any throwables, implementations, or extensions for findByAntiHCV here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAntiHCV here] end
	{
		// % protected region % [Add any additional logic for findByAntiHCV before the main body here] off begin
		// % protected region % [Add any additional logic for findByAntiHCV before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByAntiHCV(antiHCV));

		// % protected region % [Add any additional logic for findByAntiHCV before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAntiHCV before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hemodialysis Start Time.
	 *
	 * @param hemodialysisStartTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hemodialysis Start Time
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByHemodialysisStartTime(OffsetDateTime hemodialysisStartTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByHemodialysisStartTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHemodialysisStartTime here] end
	{
		// % protected region % [Add any additional logic for findByHemodialysisStartTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByHemodialysisStartTime before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByHemodialysisStartTime(hemodialysisStartTime));

		// % protected region % [Add any additional logic for findByHemodialysisStartTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHemodialysisStartTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hemodialysis End Time.
	 *
	 * @param hemodialysisEndTime the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hemodialysis End Time
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByHemodialysisEndTime(OffsetDateTime hemodialysisEndTime)
	// % protected region % [Add any throwables, implementations, or extensions for findByHemodialysisEndTime here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHemodialysisEndTime here] end
	{
		// % protected region % [Add any additional logic for findByHemodialysisEndTime before the main body here] off begin
		// % protected region % [Add any additional logic for findByHemodialysisEndTime before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByHemodialysisEndTime(hemodialysisEndTime));

		// % protected region % [Add any additional logic for findByHemodialysisEndTime before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHemodialysisEndTime before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Target.
	 *
	 * @param target the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Target
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByTarget(String target)
	// % protected region % [Add any throwables, implementations, or extensions for findByTarget here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTarget here] end
	{
		// % protected region % [Add any additional logic for findByTarget before the main body here] off begin
		// % protected region % [Add any additional logic for findByTarget before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByTarget(target));

		// % protected region % [Add any additional logic for findByTarget before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTarget before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Priming Volume.
	 *
	 * @param primingVolume the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Priming Volume
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByPrimingVolume(String primingVolume)
	// % protected region % [Add any throwables, implementations, or extensions for findByPrimingVolume here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPrimingVolume here] end
	{
		// % protected region % [Add any additional logic for findByPrimingVolume before the main body here] off begin
		// % protected region % [Add any additional logic for findByPrimingVolume before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByPrimingVolume(primingVolume));

		// % protected region % [Add any additional logic for findByPrimingVolume before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPrimingVolume before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Remaining Priming.
	 *
	 * @param remainingPriming the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Remaining Priming
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByRemainingPriming(String remainingPriming)
	// % protected region % [Add any throwables, implementations, or extensions for findByRemainingPriming here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRemainingPriming here] end
	{
		// % protected region % [Add any additional logic for findByRemainingPriming before the main body here] off begin
		// % protected region % [Add any additional logic for findByRemainingPriming before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByRemainingPriming(remainingPriming));

		// % protected region % [Add any additional logic for findByRemainingPriming before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRemainingPriming before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Complication.
	 *
	 * @param complication the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Complication
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByComplication(String complication)
	// % protected region % [Add any throwables, implementations, or extensions for findByComplication here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByComplication here] end
	{
		// % protected region % [Add any additional logic for findByComplication before the main body here] off begin
		// % protected region % [Add any additional logic for findByComplication before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByComplication(complication));

		// % protected region % [Add any additional logic for findByComplication before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByComplication before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Hemodialysis Details.
	 *
	 * @param hemodialysisDetails the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hemodialysis Details
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByHemodialysisDetails(String hemodialysisDetails)
	// % protected region % [Add any throwables, implementations, or extensions for findByHemodialysisDetails here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByHemodialysisDetails here] end
	{
		// % protected region % [Add any additional logic for findByHemodialysisDetails before the main body here] off begin
		// % protected region % [Add any additional logic for findByHemodialysisDetails before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByHemodialysisDetails(hemodialysisDetails));

		// % protected region % [Add any additional logic for findByHemodialysisDetails before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByHemodialysisDetails before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight Upon Dismissal.
	 *
	 * @param weightUponDismissal the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Upon Dismissal
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByWeightUponDismissal(Double weightUponDismissal)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUponDismissal here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUponDismissal here] end
	{
		// % protected region % [Add any additional logic for findByWeightUponDismissal before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightUponDismissal before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByWeightUponDismissal(weightUponDismissal));

		// % protected region % [Add any additional logic for findByWeightUponDismissal before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightUponDismissal before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Weight Upon Dismissal Unit.
	 *
	 * @param weightUponDismissalUnit the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Weight Upon Dismissal Unit
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByWeightUponDismissalUnit(String weightUponDismissalUnit)
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUponDismissalUnit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWeightUponDismissalUnit here] end
	{
		// % protected region % [Add any additional logic for findByWeightUponDismissalUnit before the main body here] off begin
		// % protected region % [Add any additional logic for findByWeightUponDismissalUnit before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByWeightUponDismissalUnit(weightUponDismissalUnit));

		// % protected region % [Add any additional logic for findByWeightUponDismissalUnit before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWeightUponDismissalUnit before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Priming.
	 *
	 * @param priming the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Priming
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByPriming(Double priming)
	// % protected region % [Add any throwables, implementations, or extensions for findByPriming here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPriming here] end
	{
		// % protected region % [Add any additional logic for findByPriming before the main body here] off begin
		// % protected region % [Add any additional logic for findByPriming before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByPriming(priming));

		// % protected region % [Add any additional logic for findByPriming before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPriming before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Blood.
	 *
	 * @param blood the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Blood
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByBlood(Double blood)
	// % protected region % [Add any throwables, implementations, or extensions for findByBlood here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBlood here] end
	{
		// % protected region % [Add any additional logic for findByBlood before the main body here] off begin
		// % protected region % [Add any additional logic for findByBlood before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByBlood(blood));

		// % protected region % [Add any additional logic for findByBlood before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBlood before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute IV Line.
	 *
	 * @param ivLine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute IV Line
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByIvLine(Double ivLine)
	// % protected region % [Add any throwables, implementations, or extensions for findByIvLine here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByIvLine here] end
	{
		// % protected region % [Add any additional logic for findByIvLine before the main body here] off begin
		// % protected region % [Add any additional logic for findByIvLine before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByIvLine(ivLine));

		// % protected region % [Add any additional logic for findByIvLine before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByIvLine before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Oral.
	 *
	 * @param oral the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Oral
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByOral(Double oral)
	// % protected region % [Add any throwables, implementations, or extensions for findByOral here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOral here] end
	{
		// % protected region % [Add any additional logic for findByOral before the main body here] off begin
		// % protected region % [Add any additional logic for findByOral before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByOral(oral));

		// % protected region % [Add any additional logic for findByOral before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOral before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Wash Out.
	 *
	 * @param washOut the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Wash Out
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByWashOut(Double washOut)
	// % protected region % [Add any throwables, implementations, or extensions for findByWashOut here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByWashOut here] end
	{
		// % protected region % [Add any additional logic for findByWashOut before the main body here] off begin
		// % protected region % [Add any additional logic for findByWashOut before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByWashOut(washOut));

		// % protected region % [Add any additional logic for findByWashOut before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByWashOut before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Fluid Intake.
	 *
	 * @param totalFluidIntake the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Fluid Intake
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByTotalFluidIntake(Double totalFluidIntake)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalFluidIntake here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalFluidIntake here] end
	{
		// % protected region % [Add any additional logic for findByTotalFluidIntake before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalFluidIntake before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByTotalFluidIntake(totalFluidIntake));

		// % protected region % [Add any additional logic for findByTotalFluidIntake before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalFluidIntake before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Urine.
	 *
	 * @param urine the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Urine
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByUrine(Double urine)
	// % protected region % [Add any throwables, implementations, or extensions for findByUrine here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUrine here] end
	{
		// % protected region % [Add any additional logic for findByUrine before the main body here] off begin
		// % protected region % [Add any additional logic for findByUrine before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByUrine(urine));

		// % protected region % [Add any additional logic for findByUrine before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUrine before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Others.
	 *
	 * @param others the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Others
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByOthers(Double others)
	// % protected region % [Add any throwables, implementations, or extensions for findByOthers here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOthers here] end
	{
		// % protected region % [Add any additional logic for findByOthers before the main body here] off begin
		// % protected region % [Add any additional logic for findByOthers before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByOthers(others));

		// % protected region % [Add any additional logic for findByOthers before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOthers before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Total Fluid Output.
	 *
	 * @param totalFluidOutput the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Total Fluid Output
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByTotalFluidOutput(Double totalFluidOutput)
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalFluidOutput here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTotalFluidOutput here] end
	{
		// % protected region % [Add any additional logic for findByTotalFluidOutput before the main body here] off begin
		// % protected region % [Add any additional logic for findByTotalFluidOutput before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByTotalFluidOutput(totalFluidOutput));

		// % protected region % [Add any additional logic for findByTotalFluidOutput before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTotalFluidOutput before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Fluid Balance.
	 *
	 * @param fluidBalance the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fluid Balance
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByFluidBalance(Double fluidBalance)
	// % protected region % [Add any throwables, implementations, or extensions for findByFluidBalance here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFluidBalance here] end
	{
		// % protected region % [Add any additional logic for findByFluidBalance before the main body here] off begin
		// % protected region % [Add any additional logic for findByFluidBalance before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByFluidBalance(fluidBalance));

		// % protected region % [Add any additional logic for findByFluidBalance before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFluidBalance before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Post Hemodialysis Evaluation.
	 *
	 * @param postHemodialysisEvaluation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Post Hemodialysis Evaluation
	 */
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findByPostHemodialysisEvaluation(String postHemodialysisEvaluation)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostHemodialysisEvaluation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostHemodialysisEvaluation here] end
	{
		// % protected region % [Add any additional logic for findByPostHemodialysisEvaluation before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostHemodialysisEvaluation before the main body here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findByPostHemodialysisEvaluation(postHemodialysisEvaluation));

		// % protected region % [Add any additional logic for findByPostHemodialysisEvaluation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostHemodialysisEvaluation before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<HemodialysisExaminationEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<HemodialysisExaminationEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<HemodialysisExaminationEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'create')")
	public HemodialysisExaminationEntity create(HemodialysisExaminationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		HemodialysisExaminationEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'create')")
	public HemodialysisExaminationEntity create(HemodialysisExaminationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		HemodialysisExaminationEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		HemodialysisExaminationEntity newEntity;

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
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'create')")
	public List<HemodialysisExaminationEntity> createAll(Iterable<HemodialysisExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<HemodialysisExaminationEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<HemodialysisExaminationEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'update')")
	public HemodialysisExaminationEntity update(HemodialysisExaminationEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		HemodialysisExaminationEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'update')")
	public HemodialysisExaminationEntity update(HemodialysisExaminationEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		HemodialysisExaminationEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		HemodialysisExaminationEntity newEntity;

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
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'update')")
	public List<HemodialysisExaminationEntity> updateAll(Iterable<HemodialysisExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<HemodialysisExaminationEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<HemodialysisExaminationEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'create') or hasPermission('HemodialysisExaminationEntity', 'update')")
	public HemodialysisExaminationEntity save(HemodialysisExaminationEntity entity) throws ConstraintViolationException
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

		HemodialysisExaminationEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'create') or hasPermission('HemodialysisExaminationEntity', 'update')")
	public List<HemodialysisExaminationEntity> saveAll(Iterable<HemodialysisExaminationEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<HemodialysisExaminationEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'delete')")
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
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	public List<HemodialysisExaminationEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	public List<HemodialysisExaminationEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(HemodialysisExaminationEntity.class);

		// % protected region % [Add any additional processing before converting to a list of HemodialysisExaminationEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of HemodialysisExaminationEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('HemodialysisExaminationEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<HemodialysisExaminationEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of HemodialysisExaminationEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of HemodialysisExaminationEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(HemodialysisExaminationEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of HemodialysisExaminationEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of HemodialysisExaminationEntityAudits
	 */
	private List<HemodialysisExaminationEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<HemodialysisExaminationEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param hemodialysisExamination hemodialysisExamination to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private HemodialysisExaminationEntity updateAuditData(HemodialysisExaminationEntity hemodialysisExamination)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return hemodialysisExamination;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private HemodialysisExaminationEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		HemodialysisExaminationEntity entityAtRevision = updateAuditData((HemodialysisExaminationEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new HemodialysisExaminationEntityAudit(
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

		QHemodialysisExaminationEntity entity = QHemodialysisExaminationEntity.hemodialysisExaminationEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Hemodialysis Examination here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Hemodialysis Examination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Hemodialysis Examination here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Hemodialysis Examination here] end

				break;
			case "hemodialysisMonitoringsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Hemodialysis Examination to Hemodialysis Monitorings here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Hemodialysis Examination to Hemodialysis Monitorings here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.hemodialysisMonitorings.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Hemodialysis Examination to Hemodialysis Monitorings here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Hemodialysis Examination to Hemodialysis Monitorings here] end

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
	public HemodialysisExaminationEntity updateOldData(HemodialysisExaminationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public HemodialysisExaminationEntity updateOldData(HemodialysisExaminationEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		HemodialysisExaminationEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInHemodialysisExaminationEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getAntiHIV() == null) {
			entityToUpdate.setAntiHIV(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getHbsag() == null) {
			entityToUpdate.setHbsag(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getAntiHCV() == null) {
			entityToUpdate.setAntiHCV(false);
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
				entityToUpdate.getMedicalExaminationRecord().unsetHemodialysisExamination();
			}
		}

		// Outgoing one to many reference
		if (entity.getHemodialysisMonitoringsIds().isEmpty() && entity.getHemodialysisMonitorings().isEmpty()) {
			entityToUpdate.setHemodialysisMonitorings(new HashSet<>());
		} else if (!entity.getHemodialysisMonitoringsIds().isEmpty() && entity.getHemodialysisMonitorings().isEmpty()) {
			Iterable<HemodialysisMonitoringEntity> hemodialysisMonitoringsEntities =
					this.hemodialysisMonitoringRepository.findAllById(entity.getHemodialysisMonitoringsIds());
			entityToUpdate.setHemodialysisMonitorings(Sets.newHashSet(hemodialysisMonitoringsEntities));
		}
		if (persistRelations && !entity.getHemodialysisMonitorings().isEmpty()) {
			Set<HemodialysisMonitoringEntity> updatedEntities = new HashSet<>();
			entity.getHemodialysisMonitorings().forEach(model -> {
				if (model.getId() != null) {
					model = this.hemodialysisMonitoringRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setHemodialysisMonitorings(updatedEntities);
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
	public void validateEntity(HemodialysisExaminationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<HemodialysisExaminationEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the HemodialysisExaminationEntity.
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

	public Set<String> validateEntityRelations(HemodialysisExaminationEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getMedicalExaminationRecordId() != null && this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalExaminationRecordId() + " is not associated with a Medical Examination Record Entity");
		}

		for (UUID id : entity.getHemodialysisMonitoringsIds()) {
			if (this.hemodialysisMonitoringRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Hemodialysis Monitoring Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
