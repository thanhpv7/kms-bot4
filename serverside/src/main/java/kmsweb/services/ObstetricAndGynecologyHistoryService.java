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
import kmsweb.repositories.ObstetricAndGynecologyHistoryRepository;
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
public class ObstetricAndGynecologyHistoryService extends AbstractService<ObstetricAndGynecologyHistoryEntity, ObstetricAndGynecologyHistoryRepository, ObstetricAndGynecologyHistoryEntityAudit> {

	private final String[] referenceNamesInObstetricAndGynecologyHistoryEntity = {
		"medicalExaminationRecord",
	};

	private final MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	private Validator validator;

	private AuditingRepository auditingRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public ObstetricAndGynecologyHistoryService(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		MedicalExaminationRecordRepository medicalExaminationRecordRepository,
		Validator validator,
		AuditingRepository auditingRepository,
		ObstetricAndGynecologyHistoryRepository repository
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
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
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
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
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
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByPregnancyHistoryGravida(String pregnancyHistoryGravida)
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryGravida here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryGravida here] end
	{
		// % protected region % [Add any additional logic for findByPregnancyHistoryGravida before the main body here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryGravida before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByPregnancyHistoryGravida(pregnancyHistoryGravida));

		// % protected region % [Add any additional logic for findByPregnancyHistoryGravida before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryGravida before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Patient History Para.
	 *
	 * @param patientHistoryPara the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient History Para
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByPatientHistoryPara(String patientHistoryPara)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientHistoryPara here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientHistoryPara here] end
	{
		// % protected region % [Add any additional logic for findByPatientHistoryPara before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientHistoryPara before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByPatientHistoryPara(patientHistoryPara));

		// % protected region % [Add any additional logic for findByPatientHistoryPara before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientHistoryPara before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Patient History Abortus.
	 *
	 * @param patientHistoryAbortus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Patient History Abortus
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByPatientHistoryAbortus(String patientHistoryAbortus)
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientHistoryAbortus here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPatientHistoryAbortus here] end
	{
		// % protected region % [Add any additional logic for findByPatientHistoryAbortus before the main body here] off begin
		// % protected region % [Add any additional logic for findByPatientHistoryAbortus before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByPatientHistoryAbortus(patientHistoryAbortus));

		// % protected region % [Add any additional logic for findByPatientHistoryAbortus before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPatientHistoryAbortus before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Pregnancy History Notes.
	 *
	 * @param pregnancyHistoryNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pregnancy History Notes
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByPregnancyHistoryNotes(String pregnancyHistoryNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByPregnancyHistoryNotes here] end
	{
		// % protected region % [Add any additional logic for findByPregnancyHistoryNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryNotes before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByPregnancyHistoryNotes(pregnancyHistoryNotes));

		// % protected region % [Add any additional logic for findByPregnancyHistoryNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByPregnancyHistoryNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Age of Menarche.
	 *
	 * @param ageOfMenarche the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Age of Menarche
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByAgeOfMenarche(String ageOfMenarche)
	// % protected region % [Add any throwables, implementations, or extensions for findByAgeOfMenarche here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAgeOfMenarche here] end
	{
		// % protected region % [Add any additional logic for findByAgeOfMenarche before the main body here] off begin
		// % protected region % [Add any additional logic for findByAgeOfMenarche before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByAgeOfMenarche(ageOfMenarche));

		// % protected region % [Add any additional logic for findByAgeOfMenarche before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAgeOfMenarche before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Age of First Sexual Contact.
	 *
	 * @param ageOfFirstSexualContact the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Age of First Sexual Contact
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByAgeOfFirstSexualContact(String ageOfFirstSexualContact)
	// % protected region % [Add any throwables, implementations, or extensions for findByAgeOfFirstSexualContact here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByAgeOfFirstSexualContact here] end
	{
		// % protected region % [Add any additional logic for findByAgeOfFirstSexualContact before the main body here] off begin
		// % protected region % [Add any additional logic for findByAgeOfFirstSexualContact before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByAgeOfFirstSexualContact(ageOfFirstSexualContact));

		// % protected region % [Add any additional logic for findByAgeOfFirstSexualContact before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByAgeOfFirstSexualContact before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Start Date.
	 *
	 * @param startDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Start Date
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByStartDate(OffsetDateTime startDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByStartDate here] end
	{
		// % protected region % [Add any additional logic for findByStartDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByStartDate before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByStartDate(startDate));

		// % protected region % [Add any additional logic for findByStartDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByStartDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute End Date.
	 *
	 * @param endDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute End Date
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByEndDate(OffsetDateTime endDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEndDate here] end
	{
		// % protected region % [Add any additional logic for findByEndDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByEndDate before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByEndDate(endDate));

		// % protected region % [Add any additional logic for findByEndDate before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEndDate before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Approximate Birth Date.
	 *
	 * @param approximateBirthDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Approximate Birth Date
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByApproximateBirthDate(OffsetDateTime approximateBirthDate)
	// % protected region % [Add any throwables, implementations, or extensions for findByApproximateBirthDate here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByApproximateBirthDate here] end
	{
		// % protected region % [Add any additional logic for findByApproximateBirthDate before the main body here] off begin
		// % protected region % [Add any additional logic for findByApproximateBirthDate before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByApproximateBirthDate(approximateBirthDate));

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
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByGestationAgeWeeks(String gestationAgeWeeks)
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationAgeWeeks here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationAgeWeeks here] end
	{
		// % protected region % [Add any additional logic for findByGestationAgeWeeks before the main body here] off begin
		// % protected region % [Add any additional logic for findByGestationAgeWeeks before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByGestationAgeWeeks(gestationAgeWeeks));

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
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByGestationAgeDays(String gestationAgeDays)
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationAgeDays here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGestationAgeDays here] end
	{
		// % protected region % [Add any additional logic for findByGestationAgeDays before the main body here] off begin
		// % protected region % [Add any additional logic for findByGestationAgeDays before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByGestationAgeDays(gestationAgeDays));

		// % protected region % [Add any additional logic for findByGestationAgeDays before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGestationAgeDays before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Maternity History.
	 *
	 * @param maternityHistory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Maternity History
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByMaternityHistory(String maternityHistory)
	// % protected region % [Add any throwables, implementations, or extensions for findByMaternityHistory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByMaternityHistory here] end
	{
		// % protected region % [Add any additional logic for findByMaternityHistory before the main body here] off begin
		// % protected region % [Add any additional logic for findByMaternityHistory before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByMaternityHistory(maternityHistory));

		// % protected region % [Add any additional logic for findByMaternityHistory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByMaternityHistory before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Gynecology History.
	 *
	 * @param gynecologyHistory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Gynecology History
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByGynecologyHistory(String gynecologyHistory)
	// % protected region % [Add any throwables, implementations, or extensions for findByGynecologyHistory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByGynecologyHistory here] end
	{
		// % protected region % [Add any additional logic for findByGynecologyHistory before the main body here] off begin
		// % protected region % [Add any additional logic for findByGynecologyHistory before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByGynecologyHistory(gynecologyHistory));

		// % protected region % [Add any additional logic for findByGynecologyHistory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByGynecologyHistory before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Family Plan History.
	 *
	 * @param familyPlanHistory the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Family Plan History
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByFamilyPlanHistory(String familyPlanHistory)
	// % protected region % [Add any throwables, implementations, or extensions for findByFamilyPlanHistory here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByFamilyPlanHistory here] end
	{
		// % protected region % [Add any additional logic for findByFamilyPlanHistory before the main body here] off begin
		// % protected region % [Add any additional logic for findByFamilyPlanHistory before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByFamilyPlanHistory(familyPlanHistory));

		// % protected region % [Add any additional logic for findByFamilyPlanHistory before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByFamilyPlanHistory before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Other Notes.
	 *
	 * @param otherNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Notes
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByOtherNotes(String otherNotes)
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherNotes here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByOtherNotes here] end
	{
		// % protected region % [Add any additional logic for findByOtherNotes before the main body here] off begin
		// % protected region % [Add any additional logic for findByOtherNotes before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByOtherNotes(otherNotes));

		// % protected region % [Add any additional logic for findByOtherNotes before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByOtherNotes before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Education Level of Patient.
	 *
	 * @param educationLevelOfPatient the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Education Level of Patient
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByEducationLevelOfPatient(String educationLevelOfPatient)
	// % protected region % [Add any throwables, implementations, or extensions for findByEducationLevelOfPatient here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByEducationLevelOfPatient here] end
	{
		// % protected region % [Add any additional logic for findByEducationLevelOfPatient before the main body here] off begin
		// % protected region % [Add any additional logic for findByEducationLevelOfPatient before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByEducationLevelOfPatient(educationLevelOfPatient));

		// % protected region % [Add any additional logic for findByEducationLevelOfPatient before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByEducationLevelOfPatient before returning the entities here] end

		return entities;
	}

	/**
	 * Return an entity or a list of entities that have the given attribute Rupture Of Membrane.
	 *
	 * @param ruptureOfMembrane the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Rupture Of Membrane
	 */
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findByRuptureOfMembrane(OffsetDateTime ruptureOfMembrane)
	// % protected region % [Add any throwables, implementations, or extensions for findByRuptureOfMembrane here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findByRuptureOfMembrane here] end
	{
		// % protected region % [Add any additional logic for findByRuptureOfMembrane before the main body here] off begin
		// % protected region % [Add any additional logic for findByRuptureOfMembrane before the main body here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findByRuptureOfMembrane(ruptureOfMembrane));

		// % protected region % [Add any additional logic for findByRuptureOfMembrane before returning the entities here] off begin
		// % protected region % [Add any additional logic for findByRuptureOfMembrane before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public Optional<ObstetricAndGynecologyHistoryEntity> findById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for findById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findById here] end
	{
		// % protected region % [Add any additional logic for findById before the main logic here] off begin
		// % protected region % [Add any additional logic for findById before the main logic here] end

		Optional<ObstetricAndGynecologyHistoryEntity> entity = repository.findById(id);

		// % protected region % [Add any additional logic for findById before returning the entity here] off begin
		// % protected region % [Add any additional logic for findById before returning the entity here] end

		return entity;
	}

	@Override
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findAllWithPage(int pageIndex, int pageSize)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPage here] end
	{
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before the main logic here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findAll(PageRequest.of(pageIndex, pageSize)));

		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPage before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findAllWithPageSorted(int pageIndex, int pageSize, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllWithPageSorted here] end
	{
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before the main logic here] end

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(repository.findAll(
			PageRequest.of(pageIndex, pageSize, getSort(sortBy)))
		);

		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] off begin
		// % protected region % [Add any additional logic for findAllWithPageSorted before returning the entities here] end

		return entities;
	}

	@Override
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntity> findSortedPageWithQuery(int pageIndex, int pageSize, List<List<Where>> conditions, Sort sortBy)
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findSortedPageWithQuery here] end
	{
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before the main logic here] end

		var predicate = this.getQueryConditions(conditions);
		var pageRequest = PageRequest.of(pageIndex, pageSize, getSort(sortBy));

		List<ObstetricAndGynecologyHistoryEntity> entities = Lists.newArrayList(
			predicate != null ? repository.findAll(predicate, pageRequest) : repository.findAll(pageRequest)
		);

		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] off begin
		// % protected region % [Add any additional logic for findSortedPageWithQuery before returning the entities here] end

		return entities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'create')")
	public ObstetricAndGynecologyHistoryEntity create(ObstetricAndGynecologyHistoryEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default create here] end
	{
		ObstetricAndGynecologyHistoryEntity createdEntity;

		try {
			createdEntity = this.create(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return createdEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'create')")
	public ObstetricAndGynecologyHistoryEntity create(ObstetricAndGynecologyHistoryEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for create here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for create here] end
	{
		// % protected region % [Add any additional logic for create before the main logic here] off begin
		// % protected region % [Add any additional logic for create before the main logic here] end

		ObstetricAndGynecologyHistoryEntity entityToCreate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for create before saving the entity here] off begin
		// % protected region % [Add any additional logic for create before saving the entity here] end

		ObstetricAndGynecologyHistoryEntity newEntity;

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
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'create')")
	public List<ObstetricAndGynecologyHistoryEntity> createAll(Iterable<ObstetricAndGynecologyHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for createAll here] end
	{
		// % protected region % [Add any additional logic for createAll before the main logic here] off begin
		// % protected region % [Add any additional logic for createAll before the main logic here] end

		Iterable<ObstetricAndGynecologyHistoryEntity> entitiesToCreate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before creating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before creating the entities here] end

		List<ObstetricAndGynecologyHistoryEntity> newEntities = this.saveAll(entitiesToCreate);

		// % protected region % [Add any additional logic for createAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for createAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'update')")
	public ObstetricAndGynecologyHistoryEntity update(ObstetricAndGynecologyHistoryEntity entity) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default update here] end
	{
		ObstetricAndGynecologyHistoryEntity updatedEntity;

		try {
			updatedEntity = this.update(entity, false);
		} catch (ConstraintViolationException e) {
			throw e;
		}

		return updatedEntity;
	}

	@Transactional
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'update')")
	public ObstetricAndGynecologyHistoryEntity update(ObstetricAndGynecologyHistoryEntity entity, Boolean persistRelations) throws ConstraintViolationException
	// % protected region % [Add any throwables, implementations, or extensions for update here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for update here] end
	{
		// % protected region % [Add any additional logic for update before the main logic here] off begin
		// % protected region % [Add any additional logic for update before the main logic here] end

		ObstetricAndGynecologyHistoryEntity entityToUpdate = updateOldData(entity, persistRelations);

		// % protected region % [Add any additional logic for update before updating the entity here] off begin
		// % protected region % [Add any additional logic for update before updating the entity here] end

		ObstetricAndGynecologyHistoryEntity newEntity;

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
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'update')")
	public List<ObstetricAndGynecologyHistoryEntity> updateAll(Iterable<ObstetricAndGynecologyHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAll here] end
	{
		// % protected region % [Add any additional logic for updateAll before the main logic here] off begin
		// % protected region % [Add any additional logic for updateAll before the main logic here] end

		Iterable<ObstetricAndGynecologyHistoryEntity> entitiesToUpdate = StreamSupport.stream(entities.spliterator(), false).map(this::updateOldData).collect(Collectors.toList());

		// % protected region % [Add any additional logic for createAll before updating the entities here] off begin
		// % protected region % [Add any additional logic for createAll before updating the entities here] end

		List<ObstetricAndGynecologyHistoryEntity> newEntities = this.saveAll(entitiesToUpdate);

		// % protected region % [Add any additional logic for updateAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for updateAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'create') or hasPermission('ObstetricAndGynecologyHistoryEntity', 'update')")
	public ObstetricAndGynecologyHistoryEntity save(ObstetricAndGynecologyHistoryEntity entity) throws ConstraintViolationException
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

		ObstetricAndGynecologyHistoryEntity newEntity = repository.save(entity);

		// % protected region % [Add any additional logic before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic before returning the newly created entity here] end

		return newEntity;
	}

	@Override
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'create') or hasPermission('ObstetricAndGynecologyHistoryEntity', 'update')")
	public List<ObstetricAndGynecologyHistoryEntity> saveAll(Iterable<ObstetricAndGynecologyHistoryEntity> entities)
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for saveAll here] end
	{
		// % protected region % [Add any additional logic for saveAll before the main logic here] off begin
		// % protected region % [Add any additional logic for saveAll before the main logic here] end

		List<ObstetricAndGynecologyHistoryEntity> newEntities = Lists.newArrayList(repository.saveAll(entities));

		// % protected region % [Add any additional logic for saveAll before returning the entities here] off begin
		// % protected region % [Add any additional logic for saveAll before returning the entities here] end

		return newEntities;
	}

	@Override
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'delete')")
	public void deleteById(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for deleteById here] end
	{
		// % protected region % [Add any additional logic for deleteById before the main logic here] off begin
		// % protected region % [Add any additional logic for deleteById before the main logic here] end
		repository.deleteById(id);
	}

	@Override
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'delete')")
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
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'delete')")
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
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	public List<ObstetricAndGynecologyHistoryEntity> findAllByIds(Iterable<UUID> ids)
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for findAllByIds here] end
	{
		return Lists.newArrayList(repository.findAllByIdIn(ids));
	}

	@Override
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	public List<ObstetricAndGynecologyHistoryEntity> findAllExcludingIds(Iterable<UUID> ids)
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
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntityAudit> getAudits()
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAudits here] end
	{
		// % protected region % [Add any additional logic for getAudits before the main logic here] off begin
		// % protected region % [Add any additional logic for getAudits before the main logic here] end

		List<Object[]> rawAudits = auditingRepository.getAudits(ObstetricAndGynecologyHistoryEntity.class);

		// % protected region % [Add any additional processing before converting to a list of ObstetricAndGynecologyHistoryEntityAudit here] off begin
		// % protected region % [Add any additional processing before converting to a list of ObstetricAndGynecologyHistoryEntityAudit here] end

		return mapRawAudits(rawAudits);
	}

	@Override
	@PreAuthorize("hasPermission('ObstetricAndGynecologyHistoryEntity', 'read')")
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<ObstetricAndGynecologyHistoryEntityAudit> getAuditsByEntityId(UUID id)
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for getAuditsByEntityId here] end
	{

		// % protected region % [Add any additional processing before converting to a list of ObstetricAndGynecologyHistoryEntityAudit as filtered by id here] off begin
		// % protected region % [Add any additional processing before converting to a list of ObstetricAndGynecologyHistoryEntityAudit as filtered by id here] end

		List<Object[]> rawAudits = auditingRepository.getAuditsByEntityId(ObstetricAndGynecologyHistoryEntity.class, id);

		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] off begin
		// % protected region % [Add any additional logic before returning the list of entity audits filtered by id here] end

		return mapRawAudits(rawAudits);
	}


	/**
	 * Map the list of raw audits to a list of ObstetricAndGynecologyHistoryEntityAudit entities
	 *
	 * @param rawAudits The list of raw audits to map
	 * @returns The mapped list of raw audits as a list of ObstetricAndGynecologyHistoryEntityAudits
	 */
	private List<ObstetricAndGynecologyHistoryEntityAudit> mapRawAudits(List<Object[]> rawAudits)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudits here] end
	{
		List<ObstetricAndGynecologyHistoryEntityAudit> audits = rawAudits.stream().map(this::mapRawAudit)
				.sorted(Collections.reverseOrder(Comparator.comparing(AbstractEntityAudit::getTimestamp)))
				.collect(Collectors.toList());

		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] off begin
		// % protected region % [Add any additional logic before returning the list of mapped entity audits here] end

		return audits;
	}

	/**
	 * Update the data in audit
	 * Change the ProxySet to Hashset to avoid lazy load issue in graphql
	 * @param obstetricAndGynecologyHistory obstetricAndGynecologyHistory to be updated
	 * @return Entity in audit with HashSet as relationship
	 */
	private ObstetricAndGynecologyHistoryEntity updateAuditData(ObstetricAndGynecologyHistoryEntity obstetricAndGynecologyHistory)
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateAuditData here] end
	{


		// % protected region % [Customise your update audit data here] off begin
		// % protected region % [Customise your update audit data here] end

		return obstetricAndGynecologyHistory;
	}

	/**
	 * Map a raw audit object to the RegisteredServiceProviderEntityAudit object.
	 *
	 * Handles system changes in the audit log.
	 *
	 * @param rawAudit The raw audit data
	 * @return mapped audit object
	 */
	private ObstetricAndGynecologyHistoryEntityAudit mapRawAudit(Object[] rawAudit)
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for mapRawAudit here] end
	{
		ObstetricAndGynecologyHistoryEntity entityAtRevision = updateAuditData((ObstetricAndGynecologyHistoryEntity) rawAudit[0]);
		CustomRevisionEntity revision = (CustomRevisionEntity) rawAudit[1];
		AuditQueryType auditType = AuditQueryType.getType((RevisionType) rawAudit[2]);

		// Anything performed internally may not have a user associated with it,
		// therefore they can be called system.
		boolean isSystem = (revision.getAuthor() == null);

		return new ObstetricAndGynecologyHistoryEntityAudit(
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

		QObstetricAndGynecologyHistoryEntity entity = QObstetricAndGynecologyHistoryEntity.obstetricAndGynecologyHistoryEntity;

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
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Obstetric And Gynecology History here] off begin
				// % protected region % [Add any additional logic before the query parameters of relation from Medical Examination Record to Obstetric And Gynecology History here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.medicalExaminationRecord.id, condition.getOperation(), UUID.fromString(condition.getValue()));

				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Obstetric And Gynecology History here] off begin
				// % protected region % [Add any additional logic after the query parameters of relation from Medical Examination Record to Obstetric And Gynecology History here] end

				break;
			case "educationLevelOfHusbandOrWife":
				// % protected region % [Add any additional logic before the query parameters of educationLevelOfHusbandOrWife here] off begin
				// % protected region % [Add any additional logic before the query parameters of educationLevelOfHusbandOrWife here] end

				predicate = QuerydslUtils.getDefaultPredicate(entity.educationLevelOfHusbandOrWife, condition.getOperation(), condition.getValue());

				// % protected region % [Add any additional logic after the query parameters of educationLevelOfHusbandOrWife here] off begin
				// % protected region % [Add any additional logic after the query parameters of educationLevelOfHusbandOrWife here] end

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
	public ObstetricAndGynecologyHistoryEntity updateOldData(ObstetricAndGynecologyHistoryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for the default updateOldData here] end
	{
		return this.updateOldData(entity, false);
	}

	public ObstetricAndGynecologyHistoryEntity updateOldData(ObstetricAndGynecologyHistoryEntity entity, Boolean persistRelations)
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for updateOldData here] end
	{
		// % protected region % [Add any additional logic for update references before the main logic here] off begin
		// % protected region % [Add any additional logic for update references before the main logic here] end
		ObstetricAndGynecologyHistoryEntity entityToUpdate;
		// Check if this is an update operation or a create operation.
		if (entity.getId() != null) {
			// Copy the updated entity data to the entity find from database
			entityToUpdate = repository.findById(entity.getId())
					.orElseThrow(() -> new ResponseStatusException(
							HttpStatus.NOT_FOUND, "Failed to find entity with ID" + entity.getId()
					));

			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] off begin
			// % protected region % [Add any additional logic before copying the properties of entityToUpdate here] end

			BeanUtils.copyProperties(entity, entityToUpdate, this.referenceNamesInObstetricAndGynecologyHistoryEntity);

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
				entityToUpdate.getMedicalExaminationRecord().unsetObstetricAndGynecologyHistory();
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
	public void validateEntity(ObstetricAndGynecologyHistoryEntity entity)
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] off begin
	// % protected region % [Add any throwables, implementations, or extensions for validateEntity here] end
	{
		// % protected region % [Add any additional logic for validate entity before the main logic here] off begin
		// % protected region % [Add any additional logic for validate entity before the main logic here] end

		Set<ConstraintViolation<ObstetricAndGynecologyHistoryEntity>> errors = this.validator.validate(entity);

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
	 * Get the sort as given by the sort by for the ObstetricAndGynecologyHistoryEntity.
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

	public Set<String> validateEntityRelations(ObstetricAndGynecologyHistoryEntity entity)
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
