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
import kmsweb.repositories.DeliveryMedicalExaminationRecordRepository;
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
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.repositories.CoTreatingDoctorRepository;
import kmsweb.entities.DeliveryProgressEntity;
import kmsweb.repositories.DeliveryProgressRepository;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.entities.NewbornDetailEntity;
import kmsweb.repositories.NewbornDetailRepository;
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
public class DeliveryMedicalExaminationRecordService extends AbstractService<DeliveryMedicalExaminationRecordEntity, DeliveryMedicalExaminationRecordRepository, DeliveryMedicalExaminationRecordEntityAudit> {

	private final String[] referenceNamesInDeliveryMedicalExaminationRecordEntity = {
		"additionalMidwives",
		"deliveryProgresses",
		"newbornDetails",
		"medicalExaminationRecord",
		"midwife",
	};

	private final CoTreatingDoctorRepository coTreatingDoctorRepository;

	private final DeliveryProgressRepository deliveryProgressRepository;

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private final NewbornDetailRepository newbornDetailRepository;

	private final StaffRepository staffRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public DeliveryMedicalExaminationRecordService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		CoTreatingDoctorRepository coTreatingDoctorRepository,
		DeliveryProgressRepository deliveryProgressRepository,
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		NewbornDetailRepository newbornDetailRepository,
		StaffRepository staffRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		DeliveryMedicalExaminationRecordRepository repository
	) {
		super(
				// % protected region % [Add any additional superclass constructor arguments here] off begin
				// % protected region % [Add any additional superclass constructor arguments here] end
				repository
		);

		this.coTreatingDoctorRepository = coTreatingDoctorRepository;

		this.deliveryProgressRepository = deliveryProgressRepository;

		this.medicalExaminationRecordRepository = medicalExaminationRecordRepository;

		this.newbornDetailRepository = newbornDetailRepository;

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
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
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
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
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
	 * Return an entity or a list of entities that have the given attribute Pregnancy History Gravida.
	 *
	 * @param pregnancyHistoryGravida the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pregnancy History Gravida
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByPregnancyHistoryGravida(String pregnancyHistoryGravida)
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryGravida here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryGravida here] end
	{
		// % protected region % [Add any additional logic for findByPregnancyHistoryGravida before the main body here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryGravida before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPregnancyHistoryGravida(pregnancyHistoryGravida));

		// % protected region % [Add any additional logic for findByPregnancyHistoryGravida before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryGravida before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pregnancy History Partum .
	 *
	 * @param pregnancyHistoryPartum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pregnancy History Partum 
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByPregnancyHistoryPartum(String pregnancyHistoryPartum)
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryPartum here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryPartum here] end
	{
		// % protected region % [Add any additional logic for findByPregnancyHistoryPartum before the main body here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryPartum before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPregnancyHistoryPartum(pregnancyHistoryPartum));

		// % protected region % [Add any additional logic for findByPregnancyHistoryPartum before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryPartum before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pregnancy History Abortum .
	 *
	 * @param pregnancyHistoryAbortum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pregnancy History Abortum 
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByPregnancyHistoryAbortum(String pregnancyHistoryAbortum)
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryAbortum here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryAbortum here] end
	{
		// % protected region % [Add any additional logic for findByPregnancyHistoryAbortum before the main body here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryAbortum before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPregnancyHistoryAbortum(pregnancyHistoryAbortum));

		// % protected region % [Add any additional logic for findByPregnancyHistoryAbortum before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryAbortum before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pregnancy History Notes.
	 *
	 * @param pregnancyHistoryNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pregnancy History Notes
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByPregnancyHistoryNotes(String pregnancyHistoryNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryNotes here] end
	{
		// % protected region % [Add any additional logic for findByPregnancyHistoryNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryNotes before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPregnancyHistoryNotes(pregnancyHistoryNotes));

		// % protected region % [Add any additional logic for findByPregnancyHistoryNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute LNMP Start Date.
	 *
	 * @param lnmpStartDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute LNMP Start Date
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByLnmpStartDate(OffsetDateTime lnmpStartDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByLnmpStartDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLnmpStartDate here] end
	{
		// % protected region % [Add any additional logic for findByLnmpStartDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByLnmpStartDate before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByLnmpStartDate(lnmpStartDate));

		// % protected region % [Add any additional logic for findByLnmpStartDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLnmpStartDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute LNMP End Date.
	 *
	 * @param lnmpEndDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute LNMP End Date
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByLnmpEndDate(OffsetDateTime lnmpEndDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByLnmpEndDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLnmpEndDate here] end
	{
		// % protected region % [Add any additional logic for findByLnmpEndDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByLnmpEndDate before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByLnmpEndDate(lnmpEndDate));

		// % protected region % [Add any additional logic for findByLnmpEndDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLnmpEndDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approximate Birth Date.
	 *
	 * @param approximateBirthDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approximate Birth Date
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByApproximateBirthDate(OffsetDateTime approximateBirthDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByApproximateBirthDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApproximateBirthDate here] end
	{
		// % protected region % [Add any additional logic for findByApproximateBirthDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByApproximateBirthDate before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByApproximateBirthDate(approximateBirthDate));

		// % protected region % [Add any additional logic for findByApproximateBirthDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByApproximateBirthDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gestation Age Weeks.
	 *
	 * @param gestationAgeWeeks the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gestation Age Weeks
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByGestationAgeWeeks(Integer gestationAgeWeeks)
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationAgeWeeks here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationAgeWeeks here] end
	{
		// % protected region % [Add any additional logic for findByGestationAgeWeeks before the main body here] off begin
		// % protected region % [Add any additional logic for findByGestationAgeWeeks before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByGestationAgeWeeks(gestationAgeWeeks));

		// % protected region % [Add any additional logic for findByGestationAgeWeeks before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGestationAgeWeeks before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gestation Age Days.
	 *
	 * @param gestationAgeDays the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gestation Age Days
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByGestationAgeDays(Integer gestationAgeDays)
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationAgeDays here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationAgeDays here] end
	{
		// % protected region % [Add any additional logic for findByGestationAgeDays before the main body here] off begin
		// % protected region % [Add any additional logic for findByGestationAgeDays before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByGestationAgeDays(gestationAgeDays));

		// % protected region % [Add any additional logic for findByGestationAgeDays before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGestationAgeDays before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tetanus Vaccine 1.
	 *
	 * @param tetanusVaccine1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tetanus Vaccine 1
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByTetanusVaccine1(Boolean tetanusVaccine1)
	// % protected region % [Add any throwables, implementations, or extensions for findByTetanusVaccine1 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTetanusVaccine1 here] end
	{
		// % protected region % [Add any additional logic for findByTetanusVaccine1 before the main body here] off begin
		// % protected region % [Add any additional logic for findByTetanusVaccine1 before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTetanusVaccine1(tetanusVaccine1));

		// % protected region % [Add any additional logic for findByTetanusVaccine1 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTetanusVaccine1 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Tetanus Vaccine 2.
	 *
	 * @param tetanusVaccine2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tetanus Vaccine 2
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByTetanusVaccine2(Boolean tetanusVaccine2)
	// % protected region % [Add any throwables, implementations, or extensions for findByTetanusVaccine2 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByTetanusVaccine2 here] end
	{
		// % protected region % [Add any additional logic for findByTetanusVaccine2 before the main body here] off begin
		// % protected region % [Add any additional logic for findByTetanusVaccine2 before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByTetanusVaccine2(tetanusVaccine2));

		// % protected region % [Add any additional logic for findByTetanusVaccine2 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByTetanusVaccine2 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Type.
	 *
	 * @param deliveryType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Type
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByDeliveryType(String deliveryType)
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryType here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryType here] end
	{
		// % protected region % [Add any additional logic for findByDeliveryType before the main body here] off begin
		// % protected region % [Add any additional logic for findByDeliveryType before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByDeliveryType(deliveryType));

		// % protected region % [Add any additional logic for findByDeliveryType before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDeliveryType before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Complications In Pregnancy.
	 *
	 * @param complicationsInPregnancy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Complications In Pregnancy
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByComplicationsInPregnancy(String complicationsInPregnancy)
	// % protected region % [Add any throwables, implementations, or extensions for findByComplicationsInPregnancy here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByComplicationsInPregnancy here] end
	{
		// % protected region % [Add any additional logic for findByComplicationsInPregnancy before the main body here] off begin
		// % protected region % [Add any additional logic for findByComplicationsInPregnancy before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByComplicationsInPregnancy(complicationsInPregnancy));

		// % protected region % [Add any additional logic for findByComplicationsInPregnancy before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByComplicationsInPregnancy before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Risk Factor.
	 *
	 * @param riskFactor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Risk Factor
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByRiskFactor(String riskFactor)
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFactor here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRiskFactor here] end
	{
		// % protected region % [Add any additional logic for findByRiskFactor before the main body here] off begin
		// % protected region % [Add any additional logic for findByRiskFactor before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByRiskFactor(riskFactor));

		// % protected region % [Add any additional logic for findByRiskFactor before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRiskFactor before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Fetal Presentation.
	 *
	 * @param fetalPresentation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fetal Presentation
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByFetalPresentation(String fetalPresentation)
	// % protected region % [Add any throwables, implementations, or extensions for findByFetalPresentation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFetalPresentation here] end
	{
		// % protected region % [Add any additional logic for findByFetalPresentation before the main body here] off begin
		// % protected region % [Add any additional logic for findByFetalPresentation before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByFetalPresentation(fetalPresentation));

		// % protected region % [Add any additional logic for findByFetalPresentation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFetalPresentation before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Abdomen Examination.
	 *
	 * @param abdomenExamination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Abdomen Examination
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByAbdomenExamination(String abdomenExamination)
	// % protected region % [Add any throwables, implementations, or extensions for findByAbdomenExamination here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAbdomenExamination here] end
	{
		// % protected region % [Add any additional logic for findByAbdomenExamination before the main body here] off begin
		// % protected region % [Add any additional logic for findByAbdomenExamination before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByAbdomenExamination(abdomenExamination));

		// % protected region % [Add any additional logic for findByAbdomenExamination before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAbdomenExamination before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Fundal Height.
	 *
	 * @param fundalHeight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fundal Height
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByFundalHeight(String fundalHeight)
	// % protected region % [Add any throwables, implementations, or extensions for findByFundalHeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFundalHeight here] end
	{
		// % protected region % [Add any additional logic for findByFundalHeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByFundalHeight before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByFundalHeight(fundalHeight));

		// % protected region % [Add any additional logic for findByFundalHeight before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFundalHeight before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute FHR Per Minute.
	 *
	 * @param fhrPerMinute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute FHR Per Minute
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByFhrPerMinute(String fhrPerMinute)
	// % protected region % [Add any throwables, implementations, or extensions for findByFhrPerMinute here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFhrPerMinute here] end
	{
		// % protected region % [Add any additional logic for findByFhrPerMinute before the main body here] off begin
		// % protected region % [Add any additional logic for findByFhrPerMinute before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByFhrPerMinute(fhrPerMinute));

		// % protected region % [Add any additional logic for findByFhrPerMinute before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFhrPerMinute before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Estimated Fetal Weight.
	 *
	 * @param estimatedFetalWeight the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Estimated Fetal Weight
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByEstimatedFetalWeight(String estimatedFetalWeight)
	// % protected region % [Add any throwables, implementations, or extensions for findByEstimatedFetalWeight here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEstimatedFetalWeight here] end
	{
		// % protected region % [Add any additional logic for findByEstimatedFetalWeight before the main body here] off begin
		// % protected region % [Add any additional logic for findByEstimatedFetalWeight before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByEstimatedFetalWeight(estimatedFetalWeight));

		// % protected region % [Add any additional logic for findByEstimatedFetalWeight before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEstimatedFetalWeight before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Leopold 1.
	 *
	 * @param leopold1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Leopold 1
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByLeopold1(String leopold1)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeopold1 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeopold1 here] end
	{
		// % protected region % [Add any additional logic for findByLeopold1 before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeopold1 before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByLeopold1(leopold1));

		// % protected region % [Add any additional logic for findByLeopold1 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeopold1 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Leopold 2.
	 *
	 * @param leopold2 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Leopold 2
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByLeopold2(String leopold2)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeopold2 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeopold2 here] end
	{
		// % protected region % [Add any additional logic for findByLeopold2 before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeopold2 before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByLeopold2(leopold2));

		// % protected region % [Add any additional logic for findByLeopold2 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeopold2 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Leopold 3.
	 *
	 * @param leopold3 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Leopold 3
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByLeopold3(String leopold3)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeopold3 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeopold3 here] end
	{
		// % protected region % [Add any additional logic for findByLeopold3 before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeopold3 before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByLeopold3(leopold3));

		// % protected region % [Add any additional logic for findByLeopold3 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeopold3 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Leopold 4.
	 *
	 * @param leopold4 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Leopold 4
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByLeopold4(String leopold4)
	// % protected region % [Add any throwables, implementations, or extensions for findByLeopold4 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByLeopold4 here] end
	{
		// % protected region % [Add any additional logic for findByLeopold4 before the main body here] off begin
		// % protected region % [Add any additional logic for findByLeopold4 before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByLeopold4(leopold4));

		// % protected region % [Add any additional logic for findByLeopold4 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByLeopold4 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Genitelia Externa.
	 *
	 * @param geniteliaExterna the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Genitelia Externa
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByGeniteliaExterna(String geniteliaExterna)
	// % protected region % [Add any throwables, implementations, or extensions for findByGeniteliaExterna here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGeniteliaExterna here] end
	{
		// % protected region % [Add any additional logic for findByGeniteliaExterna before the main body here] off begin
		// % protected region % [Add any additional logic for findByGeniteliaExterna before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByGeniteliaExterna(geniteliaExterna));

		// % protected region % [Add any additional logic for findByGeniteliaExterna before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGeniteliaExterna before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Genitelia Interna.
	 *
	 * @param geniteliaInterna the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Genitelia Interna
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByGeniteliaInterna(String geniteliaInterna)
	// % protected region % [Add any throwables, implementations, or extensions for findByGeniteliaInterna here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGeniteliaInterna here] end
	{
		// % protected region % [Add any additional logic for findByGeniteliaInterna before the main body here] off begin
		// % protected region % [Add any additional logic for findByGeniteliaInterna before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByGeniteliaInterna(geniteliaInterna));

		// % protected region % [Add any additional logic for findByGeniteliaInterna before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGeniteliaInterna before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Vaginal Examination.
	 *
	 * @param vaginalExamination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Vaginal Examination
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByVaginalExamination(String vaginalExamination)
	// % protected region % [Add any throwables, implementations, or extensions for findByVaginalExamination here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByVaginalExamination here] end
	{
		// % protected region % [Add any additional logic for findByVaginalExamination before the main body here] off begin
		// % protected region % [Add any additional logic for findByVaginalExamination before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByVaginalExamination(vaginalExamination));

		// % protected region % [Add any additional logic for findByVaginalExamination before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByVaginalExamination before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Complication.
	 *
	 * @param deliveryComplication the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Complication
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByDeliveryComplication(String deliveryComplication)
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryComplication here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryComplication here] end
	{
		// % protected region % [Add any additional logic for findByDeliveryComplication before the main body here] off begin
		// % protected region % [Add any additional logic for findByDeliveryComplication before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByDeliveryComplication(deliveryComplication));

		// % protected region % [Add any additional logic for findByDeliveryComplication before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDeliveryComplication before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Delivery Note.
	 *
	 * @param deliveryNote the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Delivery Note
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByDeliveryNote(String deliveryNote)
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryNote here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByDeliveryNote here] end
	{
		// % protected region % [Add any additional logic for findByDeliveryNote before the main body here] off begin
		// % protected region % [Add any additional logic for findByDeliveryNote before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByDeliveryNote(deliveryNote));

		// % protected region % [Add any additional logic for findByDeliveryNote before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByDeliveryNote before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Normal Delivery Case.
	 *
	 * @param normalDeliveryCase the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Normal Delivery Case
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByNormalDeliveryCase(Boolean normalDeliveryCase)
	// % protected region % [Add any throwables, implementations, or extensions for findByNormalDeliveryCase here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNormalDeliveryCase here] end
	{
		// % protected region % [Add any additional logic for findByNormalDeliveryCase before the main body here] off begin
		// % protected region % [Add any additional logic for findByNormalDeliveryCase before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByNormalDeliveryCase(normalDeliveryCase));

		// % protected region % [Add any additional logic for findByNormalDeliveryCase before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNormalDeliveryCase before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stage 1 Hour.
	 *
	 * @param stage1Hour the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 1 Hour
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByStage1Hour(Integer stage1Hour)
	// % protected region % [Add any throwables, implementations, or extensions for findByStage1Hour here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStage1Hour here] end
	{
		// % protected region % [Add any additional logic for findByStage1Hour before the main body here] off begin
		// % protected region % [Add any additional logic for findByStage1Hour before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByStage1Hour(stage1Hour));

		// % protected region % [Add any additional logic for findByStage1Hour before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStage1Hour before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Unnamed Integer 1.
	 *
	 * @param unnamedInteger1 the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Unnamed Integer 1
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByUnnamedInteger1(Integer unnamedInteger1)
	// % protected region % [Add any throwables, implementations, or extensions for findByUnnamedInteger1 here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByUnnamedInteger1 here] end
	{
		// % protected region % [Add any additional logic for findByUnnamedInteger1 before the main body here] off begin
		// % protected region % [Add any additional logic for findByUnnamedInteger1 before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByUnnamedInteger1(unnamedInteger1));

		// % protected region % [Add any additional logic for findByUnnamedInteger1 before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByUnnamedInteger1 before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stage 3 Hour.
	 *
	 * @param stage3Hour the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 3 Hour
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByStage3Hour(Integer stage3Hour)
	// % protected region % [Add any throwables, implementations, or extensions for findByStage3Hour here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStage3Hour here] end
	{
		// % protected region % [Add any additional logic for findByStage3Hour before the main body here] off begin
		// % protected region % [Add any additional logic for findByStage3Hour before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByStage3Hour(stage3Hour));

		// % protected region % [Add any additional logic for findByStage3Hour before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStage3Hour before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stage 4 Hour.
	 *
	 * @param stage4Hour the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 4 Hour
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByStage4Hour(Integer stage4Hour)
	// % protected region % [Add any throwables, implementations, or extensions for findByStage4Hour here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStage4Hour here] end
	{
		// % protected region % [Add any additional logic for findByStage4Hour before the main body here] off begin
		// % protected region % [Add any additional logic for findByStage4Hour before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByStage4Hour(stage4Hour));

		// % protected region % [Add any additional logic for findByStage4Hour before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStage4Hour before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stage 1 Minute.
	 *
	 * @param stage1Minute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 1 Minute
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByStage1Minute(Integer stage1Minute)
	// % protected region % [Add any throwables, implementations, or extensions for findByStage1Minute here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStage1Minute here] end
	{
		// % protected region % [Add any additional logic for findByStage1Minute before the main body here] off begin
		// % protected region % [Add any additional logic for findByStage1Minute before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByStage1Minute(stage1Minute));

		// % protected region % [Add any additional logic for findByStage1Minute before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStage1Minute before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stage 2 Minute.
	 *
	 * @param stage2Minute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 2 Minute
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByStage2Minute(Integer stage2Minute)
	// % protected region % [Add any throwables, implementations, or extensions for findByStage2Minute here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStage2Minute here] end
	{
		// % protected region % [Add any additional logic for findByStage2Minute before the main body here] off begin
		// % protected region % [Add any additional logic for findByStage2Minute before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByStage2Minute(stage2Minute));

		// % protected region % [Add any additional logic for findByStage2Minute before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStage2Minute before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stage 3 Minute.
	 *
	 * @param stage3Minute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 3 Minute
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByStage3Minute(Integer stage3Minute)
	// % protected region % [Add any throwables, implementations, or extensions for findByStage3Minute here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStage3Minute here] end
	{
		// % protected region % [Add any additional logic for findByStage3Minute before the main body here] off begin
		// % protected region % [Add any additional logic for findByStage3Minute before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByStage3Minute(stage3Minute));

		// % protected region % [Add any additional logic for findByStage3Minute before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStage3Minute before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Stage 4 Minute.
	 *
	 * @param stage4Minute the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Stage 4 Minute
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByStage4Minute(Integer stage4Minute)
	// % protected region % [Add any throwables, implementations, or extensions for findByStage4Minute here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStage4Minute here] end
	{
		// % protected region % [Add any additional logic for findByStage4Minute before the main body here] off begin
		// % protected region % [Add any additional logic for findByStage4Minute before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByStage4Minute(stage4Minute));

		// % protected region % [Add any additional logic for findByStage4Minute before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStage4Minute before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Placenta.
	 *
	 * @param placenta the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Placenta
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByPlacenta(String placenta)
	// % protected region % [Add any throwables, implementations, or extensions for findByPlacenta here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPlacenta here] end
	{
		// % protected region % [Add any additional logic for findByPlacenta before the main body here] off begin
		// % protected region % [Add any additional logic for findByPlacenta before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPlacenta(placenta));

		// % protected region % [Add any additional logic for findByPlacenta before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPlacenta before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Perineum.
	 *
	 * @param perineum the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Perineum
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByPerineum(String perineum)
	// % protected region % [Add any throwables, implementations, or extensions for findByPerineum here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPerineum here] end
	{
		// % protected region % [Add any additional logic for findByPerineum before the main body here] off begin
		// % protected region % [Add any additional logic for findByPerineum before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPerineum(perineum));

		// % protected region % [Add any additional logic for findByPerineum before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPerineum before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Bleeding.
	 *
	 * @param bleeding the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bleeding
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByBleeding(String bleeding)
	// % protected region % [Add any throwables, implementations, or extensions for findByBleeding here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByBleeding here] end
	{
		// % protected region % [Add any additional logic for findByBleeding before the main body here] off begin
		// % protected region % [Add any additional logic for findByBleeding before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByBleeding(bleeding));

		// % protected region % [Add any additional logic for findByBleeding before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByBleeding before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Postpartum Complication.
	 *
	 * @param postpartumComplication the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postpartum Complication
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByPostpartumComplication(String postpartumComplication)
	// % protected region % [Add any throwables, implementations, or extensions for findByPostpartumComplication here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPostpartumComplication here] end
	{
		// % protected region % [Add any additional logic for findByPostpartumComplication before the main body here] off begin
		// % protected region % [Add any additional logic for findByPostpartumComplication before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPostpartumComplication(postpartumComplication));

		// % protected region % [Add any additional logic for findByPostpartumComplication before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPostpartumComplication before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Newborn Delivered.
	 *
	 * @param newbornDelivered the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Newborn Delivered
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByNewbornDelivered(Integer newbornDelivered)
	// % protected region % [Add any throwables, implementations, or extensions for findByNewbornDelivered here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByNewbornDelivered here] end
	{
		// % protected region % [Add any additional logic for findByNewbornDelivered before the main body here] off begin
		// % protected region % [Add any additional logic for findByNewbornDelivered before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByNewbornDelivered(newbornDelivered));

		// % protected region % [Add any additional logic for findByNewbornDelivered before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByNewbornDelivered before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Perineum Infection.
	 *
	 * @param perineumInfection the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Perineum Infection
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByPerineumInfection(Boolean perineumInfection)
	// % protected region % [Add any throwables, implementations, or extensions for findByPerineumInfection here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPerineumInfection here] end
	{
		// % protected region % [Add any additional logic for findByPerineumInfection before the main body here] off begin
		// % protected region % [Add any additional logic for findByPerineumInfection before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByPerineumInfection(perineumInfection));

		// % protected region % [Add any additional logic for findByPerineumInfection before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPerineumInfection before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Early Breastfeeding Intiation.
	 *
	 * @param earlyBreastfeedingIntiation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Early Breastfeeding Intiation
	 */
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findByEarlyBreastfeedingIntiation(Boolean earlyBreastfeedingIntiation)
	// % protected region % [Add any throwables, implementations, or extensions for findByEarlyBreastfeedingIntiation here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEarlyBreastfeedingIntiation here] end
	{
		// % protected region % [Add any additional logic for findByEarlyBreastfeedingIntiation before the main body here] off begin
		// % protected region % [Add any additional logic for findByEarlyBreastfeedingIntiation before the main body here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findByEarlyBreastfeedingIntiation(earlyBreastfeedingIntiation));

		// % protected region % [Add any additional logic for findByEarlyBreastfeedingIntiation before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEarlyBreastfeedingIntiation before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<DeliveryMedicalExaminationRecordEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<DeliveryMedicalExaminationRecordEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<DeliveryMedicalExaminationRecordEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'create')")
	public DeliveryMedicalExaminationRecordEntity create(DeliveryMedicalExaminationRecordEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		DeliveryMedicalExaminationRecordEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'create')")
	public DeliveryMedicalExaminationRecordEntity create(DeliveryMedicalExaminationRecordEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		DeliveryMedicalExaminationRecordEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		DeliveryMedicalExaminationRecordEntity newEntity;

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
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'create')")
	public List<DeliveryMedicalExaminationRecordEntity> createAll(Iterable<DeliveryMedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<DeliveryMedicalExaminationRecordEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<DeliveryMedicalExaminationRecordEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'update')")
	public DeliveryMedicalExaminationRecordEntity update(DeliveryMedicalExaminationRecordEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		DeliveryMedicalExaminationRecordEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'update')")
	public DeliveryMedicalExaminationRecordEntity update(DeliveryMedicalExaminationRecordEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		DeliveryMedicalExaminationRecordEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		DeliveryMedicalExaminationRecordEntity newEntity;

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
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'update')")
	public List<DeliveryMedicalExaminationRecordEntity> updateAll(Iterable<DeliveryMedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<DeliveryMedicalExaminationRecordEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<DeliveryMedicalExaminationRecordEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'create') or hasPermission('DeliveryMedicalExaminationRecordEntity', 'update')")
	public DeliveryMedicalExaminationRecordEntity save(DeliveryMedicalExaminationRecordEntity entity) throws ConstraintViolationException
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

		DeliveryMedicalExaminationRecordEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'create') or hasPermission('DeliveryMedicalExaminationRecordEntity', 'update')")
	public List<DeliveryMedicalExaminationRecordEntity> saveAll(Iterable<DeliveryMedicalExaminationRecordEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<DeliveryMedicalExaminationRecordEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'delete')")
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
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'delete')")
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
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	public List<DeliveryMedicalExaminationRecordEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	public List<DeliveryMedicalExaminationRecordEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(DeliveryMedicalExaminationRecordEntity.class);

		// % protected region % [Add any additional processing before converting to a list of DeliveryMedicalExaminationRecordEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of DeliveryMedicalExaminationRecordEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('DeliveryMedicalExaminationRecordEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<DeliveryMedicalExaminationRecordEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of DeliveryMedicalExaminationRecordEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of DeliveryMedicalExaminationRecordEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(DeliveryMedicalExaminationRecordEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of DeliveryMedicalExaminationRecordEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of DeliveryMedicalExaminationRecordEntityAudits
	 */
	private List<DeliveryMedicalExaminationRecordEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<DeliveryMedicalExaminationRecordEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param deliveryMedicalExaminationRecord deliveryMedicalExaminationRecord to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private DeliveryMedicalExaminationRecordEntity updateAuditData(DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecord)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return deliveryMedicalExaminationRecord;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private DeliveryMedicalExaminationRecordEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		DeliveryMedicalExaminationRecordEntity entityAtRevision = updateAuditData((DeliveryMedicalExaminationRecordEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new DeliveryMedicalExaminationRecordEntityAudit(
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

		QDeliveryMedicalExaminationRecordEntity entity = QDeliveryMedicalExaminationRecordEntity.deliveryMedicalExaminationRecordEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Delivery Medical Examination Record here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Delivery Medical Examination Record here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Delivery Medical Examination Record here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Delivery Medical Examination Record here] end

				break;
			case "midwifeId":
				// % protected region % [Add any additional logic before the query parameters of relation from Midwife to Midwives here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Midwife to Midwives here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.midwife.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Midwife to Midwives here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Midwife to Midwives here] end

				break;
			case "additionalMidwivesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Midwife to Additional Midwives here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Additional Midwife to Additional Midwives here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.additionalMidwives.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Additional Midwife to Additional Midwives here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Additional Midwife to Additional Midwives here] end

				break;
			case "deliveryProgressesId":
				// % protected region % [Add any additional logic before the query parameters of relation from Delivery Medical Examination Record to Delivery Progresses here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Delivery Medical Examination Record to Delivery Progresses here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.deliveryProgresses.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Delivery Medical Examination Record to Delivery Progresses here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Delivery Medical Examination Record to Delivery Progresses here] end

				break;
			case "newbornDetailsId":
				// % protected region % [Add any additional logic before the query parameters of relation from Delivery Medical Examination Record to Newborn Details here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Delivery Medical Examination Record to Newborn Details here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.newbornDetails.any().id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Delivery Medical Examination Record to Newborn Details here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Delivery Medical Examination Record to Newborn Details here] end

				break;
			case "pregnancyHistoryGravida":
				// % protected region % [Add any additional logic before the query parameters of pregnancyHistoryGravida here] off begin
				// % protected region % [Add any additional logic before the query parameters of pregnancyHistoryGravida here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pregnancyHistoryGravida, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of pregnancyHistoryGravida here] off begin
				// % protected region % [Add any additional logic after the query parameters of pregnancyHistoryGravida here] end

				break;
			case "pregnancyHistoryPartum":
				// % protected region % [Add any additional logic before the query parameters of pregnancyHistoryPartum here] off begin
				// % protected region % [Add any additional logic before the query parameters of pregnancyHistoryPartum here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pregnancyHistoryPartum, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of pregnancyHistoryPartum here] off begin
				// % protected region % [Add any additional logic after the query parameters of pregnancyHistoryPartum here] end

				break;
			case "pregnancyHistoryNotes":
				// % protected region % [Add any additional logic before the query parameters of pregnancyHistoryNotes here] off begin
				// % protected region % [Add any additional logic before the query parameters of pregnancyHistoryNotes here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.pregnancyHistoryNotes, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of pregnancyHistoryNotes here] off begin
				// % protected region % [Add any additional logic after the query parameters of pregnancyHistoryNotes here] end

				break;
			case "lnmpStartDate":
				// % protected region % [Add any additional logic before the query parameters of lnmpStartDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of lnmpStartDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.lnmpStartDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of lnmpStartDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of lnmpStartDate here] end

				break;
			case "lnmpEndDate":
				// % protected region % [Add any additional logic before the query parameters of lnmpEndDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of lnmpEndDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.lnmpEndDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of lnmpEndDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of lnmpEndDate here] end

				break;
			case "approximateBirthDate":
				// % protected region % [Add any additional logic before the query parameters of approximateBirthDate here] off begin
				// % protected region % [Add any additional logic before the query parameters of approximateBirthDate here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.approximateBirthDate, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of approximateBirthDate here] off begin
				// % protected region % [Add any additional logic after the query parameters of approximateBirthDate here] end

				break;
			case "gestationAgeWeeks":
				// % protected region % [Add any additional logic before the query parameters of gestationAgeWeeks here] off begin
				// % protected region % [Add any additional logic before the query parameters of gestationAgeWeeks here] end


				// % protected region % [Add any additional logic after the query parameters of gestationAgeWeeks here] off begin
				// % protected region % [Add any additional logic after the query parameters of gestationAgeWeeks here] end

				break;
			case "gestationAgeDays":
				// % protected region % [Add any additional logic before the query parameters of gestationAgeDays here] off begin
				// % protected region % [Add any additional logic before the query parameters of gestationAgeDays here] end


				// % protected region % [Add any additional logic after the query parameters of gestationAgeDays here] off begin
				// % protected region % [Add any additional logic after the query parameters of gestationAgeDays here] end

				break;
			case "tetanusVaccine1":
				// % protected region % [Add any additional logic before the query parameters of tetanusVaccine1 here] off begin
				// % protected region % [Add any additional logic before the query parameters of tetanusVaccine1 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tetanusVaccine1, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tetanusVaccine1 here] off begin
				// % protected region % [Add any additional logic after the query parameters of tetanusVaccine1 here] end

				break;
			case "tetanusVaccine2":
				// % protected region % [Add any additional logic before the query parameters of tetanusVaccine2 here] off begin
				// % protected region % [Add any additional logic before the query parameters of tetanusVaccine2 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.tetanusVaccine2, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of tetanusVaccine2 here] off begin
				// % protected region % [Add any additional logic after the query parameters of tetanusVaccine2 here] end

				break;
			case "deliveryType":
				// % protected region % [Add any additional logic before the query parameters of deliveryType here] off begin
				// % protected region % [Add any additional logic before the query parameters of deliveryType here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.deliveryType, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of deliveryType here] off begin
				// % protected region % [Add any additional logic after the query parameters of deliveryType here] end

				break;
			case "complicationsInPregnancy":
				// % protected region % [Add any additional logic before the query parameters of complicationsInPregnancy here] off begin
				// % protected region % [Add any additional logic before the query parameters of complicationsInPregnancy here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.complicationsInPregnancy, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of complicationsInPregnancy here] off begin
				// % protected region % [Add any additional logic after the query parameters of complicationsInPregnancy here] end

				break;
			case "riskFactor":
				// % protected region % [Add any additional logic before the query parameters of riskFactor here] off begin
				// % protected region % [Add any additional logic before the query parameters of riskFactor here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.riskFactor, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of riskFactor here] off begin
				// % protected region % [Add any additional logic after the query parameters of riskFactor here] end

				break;
			case "fetalPresentation":
				// % protected region % [Add any additional logic before the query parameters of fetalPresentation here] off begin
				// % protected region % [Add any additional logic before the query parameters of fetalPresentation here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.fetalPresentation, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of fetalPresentation here] off begin
				// % protected region % [Add any additional logic after the query parameters of fetalPresentation here] end

				break;
			case "abdomenExamination":
				// % protected region % [Add any additional logic before the query parameters of abdomenExamination here] off begin
				// % protected region % [Add any additional logic before the query parameters of abdomenExamination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.abdomenExamination, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of abdomenExamination here] off begin
				// % protected region % [Add any additional logic after the query parameters of abdomenExamination here] end

				break;
			case "fundalHeight":
				// % protected region % [Add any additional logic before the query parameters of fundalHeight here] off begin
				// % protected region % [Add any additional logic before the query parameters of fundalHeight here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.fundalHeight, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of fundalHeight here] off begin
				// % protected region % [Add any additional logic after the query parameters of fundalHeight here] end

				break;
			case "fhrPerMinute":
				// % protected region % [Add any additional logic before the query parameters of fhrPerMinute here] off begin
				// % protected region % [Add any additional logic before the query parameters of fhrPerMinute here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.fhrPerMinute, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of fhrPerMinute here] off begin
				// % protected region % [Add any additional logic after the query parameters of fhrPerMinute here] end

				break;
			case "estimatedFetalWeight":
				// % protected region % [Add any additional logic before the query parameters of estimatedFetalWeight here] off begin
				// % protected region % [Add any additional logic before the query parameters of estimatedFetalWeight here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.estimatedFetalWeight, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of estimatedFetalWeight here] off begin
				// % protected region % [Add any additional logic after the query parameters of estimatedFetalWeight here] end

				break;
			case "leopold1":
				// % protected region % [Add any additional logic before the query parameters of leopold1 here] off begin
				// % protected region % [Add any additional logic before the query parameters of leopold1 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.leopold1, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of leopold1 here] off begin
				// % protected region % [Add any additional logic after the query parameters of leopold1 here] end

				break;
			case "leopold2":
				// % protected region % [Add any additional logic before the query parameters of leopold2 here] off begin
				// % protected region % [Add any additional logic before the query parameters of leopold2 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.leopold2, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of leopold2 here] off begin
				// % protected region % [Add any additional logic after the query parameters of leopold2 here] end

				break;
			case "leopold3":
				// % protected region % [Add any additional logic before the query parameters of leopold3 here] off begin
				// % protected region % [Add any additional logic before the query parameters of leopold3 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.leopold3, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of leopold3 here] off begin
				// % protected region % [Add any additional logic after the query parameters of leopold3 here] end

				break;
			case "leopold4":
				// % protected region % [Add any additional logic before the query parameters of leopold4 here] off begin
				// % protected region % [Add any additional logic before the query parameters of leopold4 here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.leopold4, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of leopold4 here] off begin
				// % protected region % [Add any additional logic after the query parameters of leopold4 here] end

				break;
			case "geniteliaExterna":
				// % protected region % [Add any additional logic before the query parameters of geniteliaExterna here] off begin
				// % protected region % [Add any additional logic before the query parameters of geniteliaExterna here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.geniteliaExterna, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of geniteliaExterna here] off begin
				// % protected region % [Add any additional logic after the query parameters of geniteliaExterna here] end

				break;
			case "geniteliaInterna":
				// % protected region % [Add any additional logic before the query parameters of geniteliaInterna here] off begin
				// % protected region % [Add any additional logic before the query parameters of geniteliaInterna here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.geniteliaInterna, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of geniteliaInterna here] off begin
				// % protected region % [Add any additional logic after the query parameters of geniteliaInterna here] end

				break;
			case "vaginalExamination":
				// % protected region % [Add any additional logic before the query parameters of vaginalExamination here] off begin
				// % protected region % [Add any additional logic before the query parameters of vaginalExamination here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.vaginalExamination, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of vaginalExamination here] off begin
				// % protected region % [Add any additional logic after the query parameters of vaginalExamination here] end

				break;
			case "deliveryComplication":
				// % protected region % [Add any additional logic before the query parameters of deliveryComplication here] off begin
				// % protected region % [Add any additional logic before the query parameters of deliveryComplication here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.deliveryComplication, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of deliveryComplication here] off begin
				// % protected region % [Add any additional logic after the query parameters of deliveryComplication here] end

				break;
			case "deliveryNote":
				// % protected region % [Add any additional logic before the query parameters of deliveryNote here] off begin
				// % protected region % [Add any additional logic before the query parameters of deliveryNote here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.deliveryNote, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of deliveryNote here] off begin
				// % protected region % [Add any additional logic after the query parameters of deliveryNote here] end

				break;
			case "normalDeliveryCase":
				// % protected region % [Add any additional logic before the query parameters of normalDeliveryCase here] off begin
				// % protected region % [Add any additional logic before the query parameters of normalDeliveryCase here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.normalDeliveryCase, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of normalDeliveryCase here] off begin
				// % protected region % [Add any additional logic after the query parameters of normalDeliveryCase here] end

				break;
			case "stage1Hour":
				// % protected region % [Add any additional logic before the query parameters of stage1Hour here] off begin
				// % protected region % [Add any additional logic before the query parameters of stage1Hour here] end


				// % protected region % [Add any additional logic after the query parameters of stage1Hour here] off begin
				// % protected region % [Add any additional logic after the query parameters of stage1Hour here] end

				break;
			case "stage3Hour":
				// % protected region % [Add any additional logic before the query parameters of stage3Hour here] off begin
				// % protected region % [Add any additional logic before the query parameters of stage3Hour here] end


				// % protected region % [Add any additional logic after the query parameters of stage3Hour here] off begin
				// % protected region % [Add any additional logic after the query parameters of stage3Hour here] end

				break;
			case "stage4Hour":
				// % protected region % [Add any additional logic before the query parameters of stage4Hour here] off begin
				// % protected region % [Add any additional logic before the query parameters of stage4Hour here] end


				// % protected region % [Add any additional logic after the query parameters of stage4Hour here] off begin
				// % protected region % [Add any additional logic after the query parameters of stage4Hour here] end

				break;
			case "stage1Minute":
				// % protected region % [Add any additional logic before the query parameters of stage1Minute here] off begin
				// % protected region % [Add any additional logic before the query parameters of stage1Minute here] end


				// % protected region % [Add any additional logic after the query parameters of stage1Minute here] off begin
				// % protected region % [Add any additional logic after the query parameters of stage1Minute here] end

				break;
			case "stage2Minute":
				// % protected region % [Add any additional logic before the query parameters of stage2Minute here] off begin
				// % protected region % [Add any additional logic before the query parameters of stage2Minute here] end


				// % protected region % [Add any additional logic after the query parameters of stage2Minute here] off begin
				// % protected region % [Add any additional logic after the query parameters of stage2Minute here] end

				break;
			case "stage3Minute":
				// % protected region % [Add any additional logic before the query parameters of stage3Minute here] off begin
				// % protected region % [Add any additional logic before the query parameters of stage3Minute here] end


				// % protected region % [Add any additional logic after the query parameters of stage3Minute here] off begin
				// % protected region % [Add any additional logic after the query parameters of stage3Minute here] end

				break;
			case "stage4Minute":
				// % protected region % [Add any additional logic before the query parameters of stage4Minute here] off begin
				// % protected region % [Add any additional logic before the query parameters of stage4Minute here] end


				// % protected region % [Add any additional logic after the query parameters of stage4Minute here] off begin
				// % protected region % [Add any additional logic after the query parameters of stage4Minute here] end

				break;
			case "placenta":
				// % protected region % [Add any additional logic before the query parameters of placenta here] off begin
				// % protected region % [Add any additional logic before the query parameters of placenta here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.placenta, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of placenta here] off begin
				// % protected region % [Add any additional logic after the query parameters of placenta here] end

				break;
			case "perineum":
				// % protected region % [Add any additional logic before the query parameters of perineum here] off begin
				// % protected region % [Add any additional logic before the query parameters of perineum here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.perineum, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of perineum here] off begin
				// % protected region % [Add any additional logic after the query parameters of perineum here] end

				break;
			case "bleeding":
				// % protected region % [Add any additional logic before the query parameters of bleeding here] off begin
				// % protected region % [Add any additional logic before the query parameters of bleeding here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.bleeding, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of bleeding here] off begin
				// % protected region % [Add any additional logic after the query parameters of bleeding here] end

				break;
			case "postpartumComplication":
				// % protected region % [Add any additional logic before the query parameters of postpartumComplication here] off begin
				// % protected region % [Add any additional logic before the query parameters of postpartumComplication here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.postpartumComplication, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of postpartumComplication here] off begin
				// % protected region % [Add any additional logic after the query parameters of postpartumComplication here] end

				break;
			case "newbornDelivered":
				// % protected region % [Add any additional logic before the query parameters of newbornDelivered here] off begin
				// % protected region % [Add any additional logic before the query parameters of newbornDelivered here] end


				// % protected region % [Add any additional logic after the query parameters of newbornDelivered here] off begin
				// % protected region % [Add any additional logic after the query parameters of newbornDelivered here] end

				break;
			case "perineumInfection":
				// % protected region % [Add any additional logic before the query parameters of perineumInfection here] off begin
				// % protected region % [Add any additional logic before the query parameters of perineumInfection here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.perineumInfection, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of perineumInfection here] off begin
				// % protected region % [Add any additional logic after the query parameters of perineumInfection here] end

				break;
			case "earlyBreastfeedingIntiation":
				// % protected region % [Add any additional logic before the query parameters of earlyBreastfeedingIntiation here] off begin
				// % protected region % [Add any additional logic before the query parameters of earlyBreastfeedingIntiation here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.earlyBreastfeedingIntiation, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of earlyBreastfeedingIntiation here] off begin
				// % protected region % [Add any additional logic after the query parameters of earlyBreastfeedingIntiation here] end

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
	public DeliveryMedicalExaminationRecordEntity updateOldData(DeliveryMedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public DeliveryMedicalExaminationRecordEntity updateOldData(DeliveryMedicalExaminationRecordEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		DeliveryMedicalExaminationRecordEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInDeliveryMedicalExaminationRecordEntity);

		} else {
			entityToUpdate = entity;

			// % protected region % [Add any additional logic before processing the new entity's data here] off begin
			// % protected region % [Add any additional logic before processing the new entity's data here] end

			// % protected region % [Add any additional logic after processing the new entity's data here] off begin
			// % protected region % [Add any additional logic after processing the new entity's data here] end
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getTetanusVaccine1() == null) {
			entityToUpdate.setTetanusVaccine1(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getTetanusVaccine2() == null) {
			entityToUpdate.setTetanusVaccine2(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getNormalDeliveryCase() == null) {
			entityToUpdate.setNormalDeliveryCase(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getPerineumInfection() == null) {
			entityToUpdate.setPerineumInfection(false);
		}

		// Null booleans should default to false when adding them to the database
		if (entityToUpdate.getEarlyBreastfeedingIntiation() == null) {
			entityToUpdate.setEarlyBreastfeedingIntiation(false);
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
				entityToUpdate.getMedicalExaminationRecord().unsetDeliveryMedicalExaminationRecord();
			}
		}

		// Incoming One to Many reference
		if (entity.getMidwife() == null && entity.getMidwifeId() == null) {
			entityToUpdate.unsetMidwife();
		} else if (entity.getMidwifeId() != null && entity.getMidwife() == null) {
			Optional<StaffEntity> midwifeEntity = this.staffRepository.findById(entity.getMidwifeId());
			entityToUpdate.setMidwife(midwifeEntity.orElseThrow());
		}
		if (persistRelations && entity.getMidwife() != null) {
			entityToUpdate.setMidwife(entity.getMidwife(), false);
			if (entityToUpdate.getMidwifeId() != null) {
				this.staffRepository.save(entityToUpdate.getMidwife());
			} else if (entityToUpdate.getId() != null) {
				// Prevent recursive persistence
				entityToUpdate.getMidwife().unsetMidwives();
			}
		}

		// Outgoing one to many reference
		if (entity.getAdditionalMidwivesIds().isEmpty() && entity.getAdditionalMidwives().isEmpty()) {
			entityToUpdate.setAdditionalMidwives(new HashSet<>());
		} else if (!entity.getAdditionalMidwivesIds().isEmpty() && entity.getAdditionalMidwives().isEmpty()) {
			Iterable<CoTreatingDoctorEntity> additionalMidwivesEntities =
					this.coTreatingDoctorRepository.findAllById(entity.getAdditionalMidwivesIds());
			entityToUpdate.setAdditionalMidwives(Sets.newHashSet(additionalMidwivesEntities));
		}
		if (persistRelations && !entity.getAdditionalMidwives().isEmpty()) {
			Set<CoTreatingDoctorEntity> updatedEntities = new HashSet<>();
			entity.getAdditionalMidwives().forEach(model -> {
				if (model.getId() != null) {
					model = this.coTreatingDoctorRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setAdditionalMidwives(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getDeliveryProgressesIds().isEmpty() && entity.getDeliveryProgresses().isEmpty()) {
			entityToUpdate.setDeliveryProgresses(new HashSet<>());
		} else if (!entity.getDeliveryProgressesIds().isEmpty() && entity.getDeliveryProgresses().isEmpty()) {
			Iterable<DeliveryProgressEntity> deliveryProgressesEntities =
					this.deliveryProgressRepository.findAllById(entity.getDeliveryProgressesIds());
			entityToUpdate.setDeliveryProgresses(Sets.newHashSet(deliveryProgressesEntities));
		}
		if (persistRelations && !entity.getDeliveryProgresses().isEmpty()) {
			Set<DeliveryProgressEntity> updatedEntities = new HashSet<>();
			entity.getDeliveryProgresses().forEach(model -> {
				if (model.getId() != null) {
					model = this.deliveryProgressRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setDeliveryProgresses(updatedEntities);
		}

		// Outgoing one to many reference
		if (entity.getNewbornDetailsIds().isEmpty() && entity.getNewbornDetails().isEmpty()) {
			entityToUpdate.setNewbornDetails(new HashSet<>());
		} else if (!entity.getNewbornDetailsIds().isEmpty() && entity.getNewbornDetails().isEmpty()) {
			Iterable<NewbornDetailEntity> newbornDetailsEntities =
					this.newbornDetailRepository.findAllById(entity.getNewbornDetailsIds());
			entityToUpdate.setNewbornDetails(Sets.newHashSet(newbornDetailsEntities));
		}
		if (persistRelations && !entity.getNewbornDetails().isEmpty()) {
			Set<NewbornDetailEntity> updatedEntities = new HashSet<>();
			entity.getNewbornDetails().forEach(model -> {
				if (model.getId() != null) {
					model = this.newbornDetailRepository.save(model);
				}
				updatedEntities.add(model);
			});
			entityToUpdate.setNewbornDetails(updatedEntities);
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
	public void validateEntity(DeliveryMedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<DeliveryMedicalExaminationRecordEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the DeliveryMedicalExaminationRecordEntity.
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

	public Set<String> validateEntityRelations(DeliveryMedicalExaminationRecordEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntityRelations here] end
	{
		Set<String> errors = new HashSet<>();

		if (entity.getMedicalExaminationRecordId() != null && this.medicalExaminationRecordRepository.findById(entity.getMedicalExaminationRecordId()).isEmpty()) {
			errors.add("The UUID " + entity.getMedicalExaminationRecordId() + " is not associated with a Medical Examination Record Entity");
		}

		if (entity.getMidwifeId() != null && this.staffRepository.findById(entity.getMidwifeId()).isEmpty()) {
			errors.add("The UUID " + entity.getMidwifeId() + " is not associated with a Staff Entity");
		}

		for (UUID id : entity.getAdditionalMidwivesIds()) {
			if (this.coTreatingDoctorRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Co Treating Doctor Entity");
			}
		}

		for (UUID id : entity.getDeliveryProgressesIds()) {
			if (this.deliveryProgressRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Delivery Progress Entity");
			}
		}

		for (UUID id : entity.getNewbornDetailsIds()) {
			if (this.newbornDetailRepository.findById(id).isEmpty()) {
				errors.add("The UUID " + id + " is not associated with a Newborn Detail Entity");
			}
		}

		return errors;
	}



	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
